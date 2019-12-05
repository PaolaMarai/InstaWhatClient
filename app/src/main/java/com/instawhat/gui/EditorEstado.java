package com.instawhat.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.instawhat.R;
import com.instawhat.model.services.network.ApiEndPoint;
import com.instawhat.model.services.network.JsonAdapterActivacionResponse;
import com.instawhat.model.services.network.VolleyS;
import com.instawhat.model.services.persitance.User;
import com.instawhat.pojo.ActivacionPOJO;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class EditorEstado extends AppCompatActivity {

    private EditText etEstado;
    private Button btnCambiarEstado;
    public static String TAG = "MainActivity";
    private VolleyS volley;
    protected RequestQueue fRequestQueue;
    private MenuItem inicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor_estado);
        this.etEstado = findViewById(R.id.etEditarEstadoEstado);
        this.btnCambiarEstado = findViewById(R.id.btnCambiarEstado);
        this.etEstado.setText(User.getEstado(), TextView.BufferType.EDITABLE);

        this.volley = VolleyS.getInstance(EditorEstado.this);
        this.fRequestQueue = volley.getRequestQueue();

        this.btnCambiarEstado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cambiarEstado();
            }
        });


        this.inicio = findViewById(R.id.InicioMenu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    private void cambiarEstado() {


        Map<String, String> param = new HashMap<>();
        param.put("correo", User.getEmail());
        param.put("estado", this.etEstado.getText().toString());

        System.out.println(User.getEmail());
        JSONObject jsonObject = new JSONObject(param);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT,
                ApiEndPoint.usuarioEditarEstado,jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                       User.setEstado(etEstado.getText().toString());
                        Intent intent = new Intent(EditorEstado.this, MainMenu.class);
                        EditorEstado.this.startActivity(intent);
                        finish();
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();

                        Toast.makeText(EditorEstado.this, "Error", Toast.LENGTH_SHORT).show();

                        Log.e(TAG, "Testing network");
                    }
                }
        );

        volley.addToQueue(jsonObjectRequest);

    }
}
