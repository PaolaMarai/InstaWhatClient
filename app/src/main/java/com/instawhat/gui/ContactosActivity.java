package com.instawhat.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.Notification;
import android.content.DialogInterface;
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
import com.android.volley.toolbox.JsonArrayRequest;
import com.instawhat.ExpresionesRegulares;
import com.instawhat.R;
import com.instawhat.model.Contacto;
import com.instawhat.model.services.network.ApiEndPoint;
import com.instawhat.model.services.network.JsonAdapterContacto;
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
        getContactos();


        this.etBuscarCorreo.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                if (!validarEmail()) {
                    Toast.makeText(ContactosActivity.this, "Email no válido", Toast.LENGTH_SHORT).show();
                }
            }
        });
        String correo = this.etBuscarCorreo.getText().toString();
        this.btBuscarContacto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                btBuscarContactoContactos();
            }
        });
    }

    private boolean validarEmail() {
        return ExpresionesRegulares.validarEmail(
                this.etBuscarCorreo.getText().toString());
    }

    private void getContactos(){
        Map<String, String> param = new HashMap<>();
        param.put("correo", User.getEmail());

        JSONObject jsonObject  = new JSONObject(param);


        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, ApiEndPoint.contactos,null,
                new Response.Listener<JSONArray>(){
            @Override
            public void onResponse(JSONArray response) {
                try {
                    final List<Contacto> contactoList = JsonAdapterContacto.getContactos(response);
                    setupRV(contactoList);
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
        rvAdapter = new ContactoRVAdapter(contactos, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contacto contacto = contactoList.get(rv.getChildAdapterPosition(v));
            }
        });
        rv.setAdapter(rvAdapter);
    }

    private void btBuscarContactoContactos (){

    }
}

