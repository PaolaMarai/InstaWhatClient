package com.instawhat.viewModels;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.instawhat.R;
import com.instawhat.model.Mensaje;
import com.instawhat.model.services.persitance.User;

import java.util.List;

public class MensajeRVAdapter extends RecyclerView.Adapter implements View.OnClickListener{
    private List<Mensaje> mDataSet;
    private View.OnLongClickListener LongListener;
    private View.OnClickListener Listener;
    private static final int VIEW_TYPE_MESSAGE_SENT = 1;
    private static final int VIEW_TYPE_MESSAGE_RECEIVED = 2;

    public MensajeRVAdapter(List<Mensaje> mensajes) {
        this.mDataSet=mensajes;
    }

    public class ViewHolderRecived extends RecyclerView.ViewHolder {
        private TextView user;
        private TextView mensaje;
        private TextView hora;

        public ViewHolderRecived(View itemView) {
            super(itemView);
            user = itemView.findViewById(R.id.text_message_name);
            mensaje = itemView.findViewById(R.id.text_message_body_send);
            hora= itemView.findViewById(R.id.text_message_time_send);
        }

        void bind(Mensaje message) {
            mensaje.setText(message.getMensaje());

            // Format the stored timestamp into a readable String using method.
            hora.setText(message.getHora());
            user.setText(message.getCorreoremitente());


        }
    }

    public class ViewHolderSend extends RecyclerView.ViewHolder {

        private TextView mensajeSend;
        private TextView horaSend;

        public ViewHolderSend(View itemView) {
            super(itemView);
            mensajeSend = itemView.findViewById(R.id.text_message_body_send);
            horaSend= itemView.findViewById(R.id.text_message_time_send);
        }

        void bind(Mensaje message) {
            mensajeSend.setText(message.getMensaje());
            horaSend.setText(message.getHora());
        }
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (viewType == VIEW_TYPE_MESSAGE_SENT) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.mensaje_enviado_row, parent, false);
            return new ViewHolderSend(view);
        } else if (viewType == VIEW_TYPE_MESSAGE_RECEIVED) {
            view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.mensaje_recibido_row, parent, false);
            return new ViewHolderRecived(view);
        }

        return null;


    }

    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Mensaje message = (Mensaje) mDataSet.get(position);

        switch (holder.getItemViewType()) {
            case VIEW_TYPE_MESSAGE_SENT:
                ((ViewHolderSend) holder).bind(message);
                break;
            case VIEW_TYPE_MESSAGE_RECEIVED:
                ((ViewHolderRecived) holder).bind(message);
        }
    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.Listener=listener;
    }


    public void onClick(View view){
        if(Listener != null){
            Listener.onClick(view);
        }
    }



    public int getItemViewType(int position) {
        Mensaje message = (Mensaje) mDataSet.get(position);

        if (message.getCorreoremitente()== User.getEmail()) {
            // If the current user is the sender of the message
            return VIEW_TYPE_MESSAGE_SENT;
        } else {
            // If some other user sent the message
            return VIEW_TYPE_MESSAGE_RECEIVED;
        }
    }
}
