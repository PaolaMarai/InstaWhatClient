package com.instawhat.viewModels;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.instawhat.R;
import com.instawhat.model.Contacto;

import java.util.List;

public class ContactoRVAdapter extends RecyclerView.Adapter<ContactoRVAdapter.ViewHolder> implements View.OnClickListener {
    private List<Contacto> mDataSet;
    private View.OnClickListener Listener;

    public ContactoRVAdapter(List<Contacto> contactos) {
        this.mDataSet=contactos;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView lbcorreo;

        public ViewHolder(View itemView) {
            super(itemView);
            lbcorreo= itemView.findViewById(R.id.tvContactoCorreo);
        }
    }


    @NonNull
    @Override
    public ContactoRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacto_list_row, parent, false);
        v.setOnClickListener(this);
        ViewHolder vh= new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull ContactoRVAdapter.ViewHolder holder, int position) {
        holder.lbcorreo.setText(mDataSet.get(position).getCorreo());
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
}