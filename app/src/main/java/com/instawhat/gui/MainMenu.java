package com.instawhat.gui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.instawhat.R;
import com.instawhat.model.services.network.VolleyS;

public class MainMenu extends AppCompatActivity {



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



        return super.onOptionsItemSelected(item);
    }




}
