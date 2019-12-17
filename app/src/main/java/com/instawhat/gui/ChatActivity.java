package com.instawhat.gui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.instawhat.ChatAdminGrpc;
import com.instawhat.ChatOuterClass;
import com.instawhat.R;
import com.instawhat.model.services.persitance.User;
import com.instawhat.viewModels.MensajeRVAdapter;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ChatActivity extends AppCompatActivity {

    private Button butttonEnviar;
    private RecyclerView rv;
    private EditText mensajeEdit;
    private MensajeRVAdapter mensajeRVAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        this.rv= findViewById(R.id.rvMensajes);
        this.butttonEnviar= findViewById(R.id.boton_enviar);
        this.mensajeEdit= findViewById(R.id.mensage);

        this.butttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mensajeEdit.getText().toString().isEmpty()){
                    enviarMensaje();
                    mensajeEdit.getText().clear();
                } else {
                    Toast.makeText(ChatActivity.this, "No puede enviar un mensaje sin contenido",
                            Toast.LENGTH_LONG).show();
                }

            }

        });

       rv.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(ChatActivity.this);
        rv.setLayoutManager(llm);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv.getContext(), llm.getOrientation());
        rv.addItemDecoration(dividerItemDecoration);

       /* Thread hilo = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    obtenerMensajes();
                }
            }
        });

        hilo.start();
*/

    }

    public void obtenerMensajes(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("192.168.1.121", 50051)
                .usePlaintext().build();
        ChatAdminGrpc.ChatAdminBlockingStub stub = ChatAdminGrpc.newBlockingStub(channel);

        ChatOuterClass.GetMessagesRequest request = ChatOuterClass.GetMessagesRequest.newBuilder()
                .setFecha("2019-12-15")
                .setHora("02:38:03")
                .setIdchat(0)
                .build();

        ChatOuterClass.MessagesResponse response;

    }

    public void enviarMensaje(){
        ManagedChannel channel = ManagedChannelBuilder.forAddress("192.168.43.42", 50051)
                .usePlaintext().build();
        ChatAdminGrpc.ChatAdminBlockingStub stub = ChatAdminGrpc.newBlockingStub(channel);

        ChatOuterClass.Mensaje mensaje = ChatOuterClass.Mensaje.newBuilder()
                .setIdmensaje(0)
                .setMensaje(mensajeEdit.getText().toString())
                .setEstado("Recibido")
                .setFecha("2019-12-15")
                .setCorreoremitente(User.getEmail())
                .setIdchat(0)
                .setHora("02:36:42")
                .build();


        ChatOuterClass.MessageRequest request = ChatOuterClass.MessageRequest.newBuilder()
                .setMensaje(mensaje)
                .build();

        try {
            ChatOuterClass.SendMesageResponse sererResponse = stub.sendMessage(request);
            System.out.println("El servidor respondiooooooooooooooo");
        } catch (Exception e) {
            System.out.println("Excepcion: " + e.getMessage());
        }

    }
}
