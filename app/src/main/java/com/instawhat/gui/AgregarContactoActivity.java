package com.instawhat.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.instawhat.R;
import com.instawhat.model.services.network.ApiEndPoint;
import com.instawhat.model.services.network.VolleyS;
import com.instawhat.model.services.persitance.Default;
import com.instawhat.model.services.persitance.User;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class AgregarContactoActivity extends AppCompatActivity {

    private Button btAgregar;
    private EditText etBuscarCorreo;

    private VolleyS volley;
    protected RequestQueue fRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_contacto);
        this.btAgregar = findViewById(R.id.btAgregar);
        this.etBuscarCorreo = findViewById(R.id.etBuscarCorreo);

        this.volley = VolleyS.getInstance(AgregarContactoActivity.this);
        this.fRequestQueue = volley.getRequestQueue();

        this.btAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                agregarUsuario();

            }
        });



    }

    private void agregarUsuario(){
        String contacto =this.etBuscarCorreo.getText().toString();
        if(contacto.isEmpty()){
            Toast.makeText(AgregarContactoActivity.this, "Ingrese un correo", Toast.LENGTH_SHORT).show();
        } else {
            Map<String, String> param = new HashMap<>();
            param.put("correoContacto", contacto);
            param.put("correo", User.getEmail());
            System.out.println("Si pasa");
            JSONObject jsonObject = new JSONObject(param);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                    ApiEndPoint.agregarContacto,jsonObject,
                    new Response.Listener<JSONObject>() {

                        @Override
                        public void onResponse(JSONObject response) {
                            System.out.println(response);
                            Toast.makeText(AgregarContactoActivity.this, "Agregado", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(AgregarContactoActivity.this, MainMenu.class);
                            AgregarContactoActivity.this.startActivity(intent);
                            finish();
                        }

                    },new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(AgregarContactoActivity.this, "Usuario inexistente o ya agregado", Toast.LENGTH_SHORT).show();
                    }
                }
            ){
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json");
                    Default defaults = Default.getInstance(AgregarContactoActivity.this);
                    headers.put("authorization", defaults.getToken());
                    return headers;
                }
            };

            volley.addToQueue(jsonObjectRequest);
        }

    }


}
