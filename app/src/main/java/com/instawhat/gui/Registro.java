package com.instawhat.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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
import com.instawhat.ExpresionesRegulares;
import com.instawhat.R;
import com.instawhat.model.services.network.ApiEndPoint;
import com.instawhat.model.services.network.VolleyS;
import com.instawhat.model.services.persitance.User;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Registro extends AppCompatActivity {

    private Button btnRegistrar;
    private EditText etEmail;
    private EditText etUsername;
    private EditText etPassword;
    private EditText etPasswordConfirm;
    public static String TAG = "Registro";
    private VolleyS volley;
    protected RequestQueue fRequestQueue;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        this.btnRegistrar = findViewById(R.id.btnRegistrarUser);
        this.etEmail = findViewById(R.id.etEmailRegistro);
        this.etUsername = findViewById(R.id.etUsernameRegistro);
        this.etPassword = findViewById(R.id.etPasswordRegistroRegistro);
        this.etPasswordConfirm = findViewById(R.id.etConfirmacionRegistro);
        this.volley = VolleyS.getInstance(Registro.this);
        this.fRequestQueue = volley.getRequestQueue();

        this.btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registroRequest();
            }
        });
        this.etEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!validarEmail()) {
                    Toast.makeText(Registro.this, "Email no válido", Toast.LENGTH_SHORT).show();
                }
            }
        });
        this.etUsername.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!validarUsername()) {
                    Toast.makeText(Registro.this, "Username no válido", Toast.LENGTH_SHORT).show();
                }
            }
        });





    }

    private boolean validarEmail() {
        return ExpresionesRegulares.validarEmail(
                this.etEmail.getText().toString());
    }

    private boolean validarPassword() {
        return  ExpresionesRegulares.validarPassword(
                this.etPassword.getText().toString());

    }

    private boolean validarUsername() {
        return ExpresionesRegulares.validarUsername(
                this.etUsername.getText().toString());
    }


    private void registroRequest(){

        if (validarEmail() && validarUsername()) {

            if (validarPassword()) {

                if (this.etPasswordConfirm.getText().toString().equals(
                        this.etPassword.getText().toString())) {

                    Map<String, String> param = new HashMap<>();
                    param.put("correo", this.etEmail.getText().toString());
                    param.put("username", this.etUsername.getText().toString());
                    param.put("password", this.etPassword.getText().toString());

                    JSONObject jsonObject = new JSONObject(param);

                    JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                            ApiEndPoint.usuarioRegistro,jsonObject,
                            new Response.Listener<JSONObject>() {
                                @Override
                                public void onResponse(JSONObject response) {

                                    User.setEmail(etEmail.getText().toString());
                                    User.setPassword(etPassword.getText().toString());
                                    Intent intent = new Intent(Registro.this, NipValidacion.class);
                                    Registro.this.startActivity(intent);
                                    finish();
                                }

                            },
                            new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    error.printStackTrace();

                                    Toast.makeText(Registro.this, "Error de registro", Toast.LENGTH_SHORT).show();

                                    Log.e(TAG, "Testing network");
                                }
                            }
                    );

                    volley.addToQueue(jsonObjectRequest);

                } else {
                    Toast.makeText(Registro.this, "Password no coincide", Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(Registro.this, "Password no válido", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(Registro.this, "Username o Email no válido", Toast.LENGTH_SHORT).show();
        }



    }

}
