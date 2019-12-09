package com.instawhat.gui;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.instawhat.R;
import com.instawhat.model.services.network.ApiEndPoint;
import com.instawhat.model.services.network.JsonAdapterFotoPerfil;
import com.instawhat.model.services.network.VolleyS;
import com.instawhat.model.services.persitance.Default;
import com.instawhat.model.services.persitance.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainMenu extends AppCompatActivity {

    private static final int PICK_IMAGE = 100;
    private MenuItem editarPerfil;
    public static String TAG = "MainActivity";
    private VolleyS volley;
    protected RequestQueue fRequestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.EditarPerfilMenu) {
            Intent intent = new Intent(MainMenu.this, EditarPerfil.class);
            MainMenu.this.startActivity(intent);
            return true;
        }
        if (id == R.id.ContactosMenu){
            Intent intent = new Intent(MainMenu.this, ContactosActivity.class);

            MainMenu.this.startActivity(intent);
            return true;
        }
        if (id == R.id.NuevoContactoMenu){
            Intent intent = new Intent(MainMenu.this, AgregarContactoActivity.class);
            MainMenu.this.startActivity(intent);
            return true;
        }

        if (id == R.id.SubirFotoMenu) {
            Intent intent = new Intent(MainMenu.this, PublicarFoto.class);
            MainMenu.this.startActivity(intent);
            return true;
        }




        return super.onOptionsItemSelected(item);
    }



    private void publidarFoto(String foto){

        Map<String, String> param = new HashMap<>();
        param.put("correo", User.getEmail());
        param.put("foto", foto);

        JSONObject jsonObject = new JSONObject(param);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT,
                ApiEndPoint.usuarioCambiarFotoPerfil,jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            Boolean result = JsonAdapterFotoPerfil.fotoPerfilResponseAdapter(response);

                            System.out.println(response);
                            if (result)  {
                                Toast.makeText(MainMenu.this, "Foto publicada", Toast.LENGTH_SHORT).show();
                            }

                        } catch (JSONException e) {
                            Toast.makeText(MainMenu.this, "Cannot parse response", Toast.LENGTH_SHORT).show();
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();

                        Toast.makeText(MainMenu.this, "Permiso denegado", Toast.LENGTH_SHORT).show();

                        Log.e(TAG, "Testing network");
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                Default defaults = Default.getInstance(MainMenu.this);
                headers.put("authorization", defaults.getToken());
                return headers;
            }
        };

        volley.addToQueue(jsonObjectRequest);

    }



}
