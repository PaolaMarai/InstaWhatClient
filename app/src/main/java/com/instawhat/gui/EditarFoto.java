package com.instawhat.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;


import android.content.Intent;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.instawhat.R;
import com.instawhat.gui.fotoMW.EncodeDecode;
import com.instawhat.model.services.network.ApiEndPoint;
import com.instawhat.model.services.network.JsonAdapterFotoPerfil;
import com.instawhat.model.services.network.VolleyS;
import com.instawhat.model.services.persitance.Default;
import com.instawhat.model.services.persitance.User;

import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class EditarFoto extends AppCompatActivity {

    private static final int PICK_IMAGE = 100;
    private Button btnCambiarFoto;
    private Uri imageUri;
    private ImageView foto_gallery;
    private String fotoString;
    public static String TAG = "Editar foto";
    private VolleyS volley;
    protected RequestQueue fRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_foto);
        this.btnCambiarFoto = findViewById(R.id.btnChangeFotoPerfil);
        this.foto_gallery = findViewById(R.id.ivFotoPerfil);

        this.foto_gallery.setImageBitmap(EncodeDecode.toBitmap(User.getFoto()));

        this.btnCambiarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });
        this.volley = VolleyS.getInstance(EditarFoto.this);
        this.fRequestQueue = volley.getRequestQueue();

    }


    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

     @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            foto_gallery.setImageURI(imageUri);
            foto_gallery.setImageURI(imageUri);
            int ancho = 600;
            int alto = 600;
            LinearLayoutCompat.LayoutParams params = new LinearLayoutCompat.LayoutParams(ancho, alto);
            foto_gallery.setLayoutParams(params);
            this.fotoString = EncodeDecode.encodeImage(foto_gallery);
            cambiarFoto();
        }
    }


    private void cambiarFoto(){

        Map<String, String> param = new HashMap<>();
        param.put("correo", User.getEmail());
        param.put("foto", this.fotoString);

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
                                Toast.makeText(EditarFoto.this, "Foto cambiada", Toast.LENGTH_SHORT).show();
                                User.setFoto(fotoString);
                            }

                        } catch (JSONException e) {
                            Toast.makeText(EditarFoto.this, "Cannot parse response", Toast.LENGTH_SHORT).show();
                        }
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();

                        Toast.makeText(EditarFoto.this, "Permiso denegado", Toast.LENGTH_SHORT).show();

                        Log.e(TAG, "Testing network");
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                Default defaults = Default.getInstance(EditarFoto.this);
                headers.put("authorization", defaults.getToken());
                return headers;
            }
        };

        volley.addToQueue(jsonObjectRequest);

    }


}
