package com.instawhat.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.instawhat.R;

public class ChatActivity extends AppCompatActivity {

    private Button butttonEnviar;
    private RecyclerView rv;
    private EditText mensajeEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        this.butttonEnviar= findViewById(R.id.boton_enviar);
        this.mensajeEdit= findViewById(R.id.mensage);

        this.rv= findViewById(R.id.rvMensajes);

    }
}
