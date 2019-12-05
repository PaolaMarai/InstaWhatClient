package com.instawhat.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.instawhat.R;
import com.instawhat.model.services.persitance.User;

import java.util.PriorityQueue;

public class EditarPerfil extends AppCompatActivity {

    private Button btnCambiarFoto;
    private EditText etUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        this.btnCambiarFoto = findViewById(R.id.btnEditarFotoPerfilPage);
        this.etUsername = findViewById(R.id.etEditarUsername);
        this.etUsername.setText(User.getUsername());

        this.btnCambiarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditarPerfil.this, EditarFoto.class);
                EditarPerfil.this.startActivity(intent);
            }
        });
    }
}
