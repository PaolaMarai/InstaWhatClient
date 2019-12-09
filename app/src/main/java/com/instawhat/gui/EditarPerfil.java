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
import com.instawhat.ExpresionesRegulares;
import com.instawhat.R;
import com.instawhat.model.services.network.ApiEndPoint;
import com.instawhat.model.services.network.JsonAdapterEditResponse;
import com.instawhat.model.services.network.VolleyS;
import com.instawhat.model.services.persitance.Default;
import com.instawhat.model.services.persitance.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class EditarPerfil extends AppCompatActivity {

    private Button btnCambiarFoto;
    private EditText etUsername;
    public static String TAG = "Editar Perfil";
    private Button btnEditarEstado;
    private EditText etPasswordNuevo;
    private EditText etPasswordConfirm;
    private EditText etPassword;
    private Button btnEditarPassword;
    private Button btnEditarUsername;

    private VolleyS volley;
    protected RequestQueue fRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        this.btnCambiarFoto = findViewById(R.id.btnEditarFotoPerfilPage);
        this.etUsername = findViewById(R.id.etEditarUsername);
        this.etUsername.setText(User.getUsername());
        this.etPassword = findViewById(R.id.etPasswordActual);
        this.etPasswordNuevo = findViewById(R.id.etEditarPassword);
        this.etPasswordConfirm = findViewById(R.id.etEditarPasswordConfirm);
        this.btnEditarEstado = findViewById(R.id.btnEditarEstadoPage);
        this.btnEditarUsername = findViewById(R.id.btnEditarUsername);
        this.btnEditarPassword = findViewById(R.id.btnEditarPassword);

        this.volley = VolleyS.getInstance(EditarPerfil.this);
        this.fRequestQueue = volley.getRequestQueue();


        this.btnCambiarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditarPerfil.this, EditarFoto.class);
                EditarPerfil.this.startActivity(intent);
            }
        });

        this.btnEditarEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditarPerfil.this, EditorEstado.class);
                EditarPerfil.this.startActivity(intent);
            }
        });

        this.btnEditarUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarUsername();
            }
        });

        this.btnEditarPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editarPassword();
            }
        });



    }

    private void editarUsername() {

        if(validarUsername()) {
            Map<String, String> param = new HashMap<>();
            param.put("correo", User.getEmail());
            param.put("username", this.etUsername.getText().toString());
            JSONObject jsonObject = new JSONObject(param);


            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                    ApiEndPoint.usuarioEditarUsername,jsonObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                if (JsonAdapterEditResponse.editResponseAdapter(response)) {
                                    User.setEstado(etUsername.getText().toString());
                                    Toast.makeText(EditarPerfil.this, "Username actualizado", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(EditarPerfil.this, "Error", Toast.LENGTH_SHORT).show();
                                Log.e(TAG, "Testing network");
                            }

                        }

                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();

                            Toast.makeText(EditarPerfil.this, "Error", Toast.LENGTH_SHORT).show();

                            Log.e(TAG, "Testing network");
                        }
                    }
            )
            {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json");
                    Default defaults = Default.getInstance(EditarPerfil.this);
                    headers.put("authorization", defaults.getToken());
                    return headers;
                }
            };


            volley.addToQueue(jsonObjectRequest);
        } else {
            Toast.makeText(EditarPerfil.this, "Username inválido", Toast.LENGTH_SHORT).show();
        }


    }

    private void editarPassword() {

        if(validarPassword()) {
            Map<String, String> param = new HashMap<>();
            param.put("correo", User.getEmail());
            param.put("password", this.etPassword.getText().toString());
            param.put("passwordnueva", this.etPasswordNuevo.getText().toString());

            JSONObject jsonObject = new JSONObject(param);


            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST,
                    ApiEndPoint.usuerioEditarPassword,jsonObject,
                    new Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(JSONObject response) {
                            try {
                                if (JsonAdapterEditResponse.editResponseAdapter(response)) {
                                    User.setPassword(etPasswordNuevo.getText().toString());
                                    etPassword.setText("");
                                    etPasswordNuevo.setText("");
                                    etPasswordConfirm.setText("");
                                    Toast.makeText(EditarPerfil.this, "Password actualizado", Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                                Toast.makeText(EditarPerfil.this, "Error", Toast.LENGTH_SHORT).show();
                                Log.e(TAG, "Testing network");
                            }


                        }

                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            error.printStackTrace();
                            Toast.makeText(EditarPerfil.this, "Error", Toast.LENGTH_SHORT).show();
                            Log.e(TAG, "Testing network");
                        }
                    }
            )
            {
                @Override
                public Map<String, String> getHeaders() throws AuthFailureError {
                    HashMap<String, String> headers = new HashMap<String, String>();
                    headers.put("Content-Type", "application/json");
                    Default defaults = Default.getInstance(EditarPerfil.this);
                    headers.put("authorization", defaults.getToken());
                    return headers;
                }
            };


            volley.addToQueue(jsonObjectRequest);
        } else {
            Toast.makeText(EditarPerfil.this, "Username inválido", Toast.LENGTH_SHORT).show();
        }


    }

    private boolean validarPassword() {
        return
                ExpresionesRegulares.validarPassword(this.etPasswordNuevo.getText().toString()) &&
                this.etPasswordNuevo.getText().toString().equals(this.etPasswordConfirm.getText().toString());

    }

    private boolean validarUsername() {
        return ExpresionesRegulares.validarUsername(
                this.etUsername.getText().toString());
    }

}
