package com.instawhat.gui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.instawhat.R;
import com.instawhat.model.Foto;
import com.instawhat.model.services.network.ApiEndPoint;
import com.instawhat.model.services.network.JsonAdapterEditResponse;
import com.instawhat.model.services.network.JsonAdapterFoto;
import com.instawhat.model.services.network.MyJsonArrayRequest;
import com.instawhat.model.services.network.VolleyS;
import com.instawhat.model.services.persitance.Default;
import com.instawhat.model.services.persitance.User;
import com.instawhat.viewModels.FotoRVAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainMenu extends AppCompatActivity {

    private static final int PICK_IMAGE = 100;
    private MenuItem editarPerfil;
    public static String TAG = "MainActivity";
    private VolleyS volley;
    protected RequestQueue fRequestQueue;
    protected RequestQueue requestQueue;
    private RecyclerView rv;
    private FotoRVAdapter rvAdapter;
    private int fotosConsultadas = 0;
    private int fotosPedidas = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        volley = VolleyS.getInstance(MainMenu.this);
        requestQueue = volley.getRequestQueue();

        rv = findViewById(R.id.rvFotoInicio);

        rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(MainMenu.this);
        rv.setLayoutManager(llm);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(), llm.getOrientation());
        rv.addItemDecoration(dividerItemDecoration);
        feed();
    }

    private void feed(){
        Map<String, Integer> param = new HashMap<>();
        param.put("skip",this.fotosConsultadas);
        this.fotosConsultadas += this.fotosPedidas;
        param.put("limit",this.fotosPedidas);

        JSONObject jsonObject = new JSONObject(param);
        MyJsonArrayRequest jsonArrayRequest = new MyJsonArrayRequest(Request.Method.POST, ApiEndPoint.obternerFotos, jsonObject, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    final List<Foto> fotos = JsonAdapterFoto.getFotos(response);
                    System.out.println(response);
                    setupRV(fotos);
                } catch (JSONException e) {
                    Toast.makeText(MainMenu.this, "Cannot parse response", Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "Testing network");
                    }
                })
        {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                Default defaults = Default.getInstance(MainMenu.this);
                headers.put("authorization", defaults.getToken());
                return headers;
            }
        };

        volley.addToQueue(jsonArrayRequest);
    }

    private void setupRV(List<Foto> fotos){
        final List<Foto> fotosList = fotos;
        rvAdapter = new FotoRVAdapter(fotos);
        rv.setAdapter(rvAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent;

        switch (id) {

            case R.id.EditarPerfilMenu:
                intent = new Intent(MainMenu.this, EditarPerfil.class);
                MainMenu.this.startActivity(intent);
                return true;

            case R.id.ContactosMenu:
                intent = new Intent(MainMenu.this, ContactosActivity.class);
                MainMenu.this.startActivity(intent);
                return true;

            case R.id.NuevoContactoMenu:
                intent = new Intent(MainMenu.this, AgregarContactoActivity.class);
                MainMenu.this.startActivity(intent);
                return true;

            case R.id.SubirFotoMenu:
                intent = new Intent(MainMenu.this, PublicarFoto.class);
                MainMenu.this.startActivity(intent);
                return true;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}
