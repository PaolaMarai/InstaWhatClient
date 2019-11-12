package com.instawhat.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.instawhat.R;
import com.instawhat.model.services.network.ApiEndPoint;
import com.instawhat.model.services.network.JsonAdapterLogin;
import com.instawhat.model.services.network.VolleyS;
import com.instawhat.model.services.persitance.Default;
import com.instawhat.model.services.persitance.User;
import com.instawhat.pojo.LoginPojo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail;
    private EditText etPassword;
    private Button btnSingIn;
    private  Button btnRegistrar;
    private final String usuarioSinActivar = "nuevo";
    public static String TAG = "MainActivity";
    private VolleyS volley;
    protected RequestQueue fRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.etEmail = findViewById(R.id.etEmail);
        this.etPassword = findViewById(R.id.etPassword);
        this.btnSingIn = findViewById(R.id.bttnLogIn);
        this.btnRegistrar = findViewById(R.id.btnRegistro);

        this.volley = VolleyS.getInstance(MainActivity.this);
        this.fRequestQueue = volley.getRequestQueue();

        this.btnSingIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginRequest();
            }
        });

        this.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Registro.class);
                MainActivity.this.startActivity(intent);
                finish();
            }
        });
    }


    private void loginRequest(){

        Map<String, String> param = new HashMap<>();
        param.put("correo", this.etEmail.getText().toString());
        param.put("password", this.etPassword.getText().toString());

        JSONObject jsonObject = new JSONObject(param);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                ApiEndPoint.usuarioLogin,jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            LoginPojo result = JsonAdapterLogin.loginAdapter(response);

                            if (result.getToken().equals(usuarioSinActivar))  {
                                User.setEmail(etEmail.getText().toString());
                                User.setPassword(etPassword.getText().toString());
                                Toast.makeText(MainActivity.this, "Active su cuenta", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(MainActivity.this, NipValidacion.class);
                                MainActivity.this.startActivity(intent);
                                finish();

                            } else {
                                Default d = Default.getInstance(MainActivity.this);
                                d.setToken(result.getToken());

                                Toast.makeText(MainActivity.this, "TK:" + d.getToken(), Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(MainActivity.this, MainMenu.class);
                                MainActivity.this.startActivity(intent);
                                finish();
                            }


                        } catch (JSONException e) {
                            Toast.makeText(MainActivity.this, "Cannot parse response", Toast.LENGTH_SHORT).show();
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();

                        Toast.makeText(MainActivity.this, "usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();

                        Log.e(TAG, "Testing network");
                    }
                }
        );

        volley.addToQueue(jsonObjectRequest);

    }

}
