package com.instawhat.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

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

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class PublicarFoto extends AppCompatActivity {

    private static final int PICK_IMAGE = 100;
    private Button btnPublicar;
    private Uri imageUri;
    private ImageView foto_gallery;
    private EditText etDescripcion;
    private String fotoString;
    public static String TAG = "Editar foto";
    private VolleyS volley;
    protected RequestQueue fRequestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_publicar_foto);
        this.foto_gallery = findViewById(R.id.ivPublicacion);
        this.etDescripcion = findViewById(R.id.etDescripcion);
        this.btnPublicar = findViewById(R.id.btnPublicar);

        this.btnPublicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                publicarFoto();
            }
        });

        this.volley = VolleyS.getInstance(PublicarFoto.this);
        this.fRequestQueue = volley.getRequestQueue();
        openGallery();

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

        }
    }


    private void publicarFoto(){

        Map<String, String> param = new HashMap<>();
        param.put("correo", User.getEmail());
        param.put("foto", this.fotoString);
        param.put("descripcion", this.etDescripcion.getText().toString());

        JSONObject jsonObject = new JSONObject(param);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT,
                ApiEndPoint.publicarFoto,jsonObject,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //TODO
                        /*
                        try {
                            Boolean result = JsonAdapterFotoPerfil.fotoPerfilResponseAdapter(response);

                            System.out.println(response);
                            if (result)  {
                                Toast.makeText(PublicarFoto.this, "Foto cambiada", Toast.LENGTH_SHORT).show();
                                User.setFoto(fotoString);
                            }

                        } catch (JSONException e) {
                            Toast.makeText(PublicarFoto.this, "Cannot parse response", Toast.LENGTH_SHORT).show();
                        }

 */
                        Toast.makeText(PublicarFoto.this, "publicada", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(PublicarFoto.this, MainMenu.class);
                        PublicarFoto.this.startActivity(intent);
                        finish();
                    }

                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();

                        Toast.makeText(PublicarFoto.this, "Permiso denegado", Toast.LENGTH_SHORT).show();

                        Log.e(TAG, "Testing network");
                    }
                }
        ){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                HashMap<String, String> headers = new HashMap<String, String>();
                headers.put("Content-Type", "application/json");
                Default defaults = Default.getInstance(PublicarFoto.this);
                headers.put("authorization", defaults.getToken());
                return headers;
            }
        };

        volley.addToQueue(jsonObjectRequest);

    }

}
