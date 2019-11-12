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
import com.instawhat.model.services.network.JsonAdapterActivacionResponse;
import com.instawhat.model.services.network.JsonAdapterLogin;
import com.instawhat.model.services.network.VolleyS;
import com.instawhat.model.services.persitance.Default;
import com.instawhat.model.services.persitance.User;
import com.instawhat.pojo.ActivacionPOJO;
import com.instawhat.pojo.LoginPojo;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class NipValidacion extends AppCompatActivity {

    private Button btnActivar;
    private EditText etNip;
    public static String TAG = "Activación";
    private VolleyS volley;
    protected RequestQueue fRequestQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nip_validacion);

        this.btnActivar = findViewById(R.id.btnConfirmarNip);
        this.etNip = findViewById(R.id.etNip);
        this.volley = VolleyS.getInstance(NipValidacion.this);
        this.fRequestQueue = volley.getRequestQueue();

        this.btnActivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registroRequest();
            }
        });
    }

    private void registroRequest(){

        Map<String, String> param = new HashMap<>();
        param.put("correo", User.getEmail());
        param.put("nip", this.etNip.getText().toString());
        param.put("password", User.getPassword());

        JSONObject jsonObject = new JSONObject(param);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT,
                ApiEndPoint.usuarioActivacion,jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            ActivacionPOJO result = JsonAdapterActivacionResponse.activacionAdapter(response);


                            if (result.getnModified() == 1) {
                                Intent intent = new Intent(NipValidacion.this, MainActivity.class);
                                NipValidacion.this.startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(NipValidacion.this, "Nip incorrecto", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            Toast.makeText(NipValidacion.this, "Cannot parse response", Toast.LENGTH_SHORT).show();
                        }

                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();

                        Toast.makeText(NipValidacion.this, "usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();

                        Log.e(TAG, "Testing network");
                    }
                }
        );

        volley.addToQueue(jsonObjectRequest);

    }

}
