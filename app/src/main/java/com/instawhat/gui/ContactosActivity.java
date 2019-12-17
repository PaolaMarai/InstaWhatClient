package com.instawhat.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Notification;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
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

import com.instawhat.ExpresionesRegulares;
import com.instawhat.R;
import com.instawhat.model.Contacto;
import com.instawhat.model.services.network.ApiEndPoint;
import com.instawhat.model.services.network.JsonAdapterContacto;
import com.instawhat.model.services.network.MyJsonArrayRequest;
import com.instawhat.model.services.network.VolleyS;
import com.instawhat.model.services.persitance.Default;
import com.instawhat.model.services.persitance.User;
import com.instawhat.viewModels.ContactoRVAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContactosActivity extends AppCompatActivity {

    private VolleyS volley;
    protected RequestQueue requestQueue;
    private RecyclerView rv;
    private ContactoRVAdapter rvAdapter;
    private Button btBuscarContacto;
    private EditText etBuscarCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);

        volley = VolleyS.getInstance(ContactosActivity.this);
        requestQueue = volley.getRequestQueue();

        rv = findViewById(R.id.rvContactos);

        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(ContactosActivity.this);
        rv.setLayoutManager(llm);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(), llm.getOrientation());
        rv.addItemDecoration(dividerItemDecoration);

        Map<String, String> paramContactos = new HashMap<>();
        paramContactos.put("correo", User.getEmail());

        getContactos(paramContactos);


    }

    private void getContactos(Map<String, String> param){


        JSONObject jsonObject = new JSONObject(param);

        MyJsonArrayRequest jsonArrayRequest = new MyJsonArrayRequest(Request.Method.POST, ApiEndPoint.contactos,jsonObject,
                new Response.Listener<JSONArray>(){
            @Override
            public void onResponse(JSONArray response) {
                try {
                    final List<Contacto> contactoList = JsonAdapterContacto.getContactos(response);
                    if(!contactoList.isEmpty()){
                        setupRV(contactoList);
                    }else {
                        Toast.makeText(ContactosActivity.this, "Aún no tienes contactos registrados", Toast.LENGTH_SHORT).show();
                    }

                } catch (JSONException e) {
                    Toast.makeText(ContactosActivity.this, "Cannot parse response", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
               @Override
               public void onErrorResponse(VolleyError error) {
               Log.e("ContactosActivity", "Testing network");
               }
        })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                Default defaults = Default.getInstance(ContactosActivity.this);
                headers.put("authorization", defaults.getToken());
                return headers;
            }
        };

        volley.addToQueue(jsonArrayRequest);
    }

    private void setupRV(List<Contacto> contactos){
        final List<Contacto> contactoList = contactos;
        rvAdapter = new ContactoRVAdapter(contactoList);

        rvAdapter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ContactosActivity.this, ChatActivity.class);
                ContactosActivity.this.startActivity(intent);
                finish();
            }
        });
        rv.setAdapter(rvAdapter);
    }

    private void btBuscarContactoContactos (){
        this.etBuscarCorreo = findViewById(R.id.etBuscarCorreo);
        Map<String, String> paramBusqueda = new HashMap<>();
        paramBusqueda.put("correoContacto", etBuscarCorreo.getText().toString());
        paramBusqueda.put("correo", User.getEmail());
        getContactos(paramBusqueda);
    }
}

