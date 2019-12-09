package com.instawhat.viewModels;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.instawhat.R;
import com.instawhat.model.Foto;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class FotoRVAdapter {
    private List<Foto> mDataSet;
    private View.OnClickListener Listener;

    public void onClick(View view){
        if(Listener != null){
            Listener.onClick(view);
        }
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private TextView lbUsuario;
        private TextView lbDescripcion;
        private ImageView ivFoto;

        public ViewHolder(View v){
            super(v);
            lbUsuario = v.findViewById(R.id.twUsernameFotoRow);
            lbDescripcion = v.findViewById(R.id.tvDescripcionFotoRow);
            ivFoto = v.findViewById(R.id.ivFotoFotoRow);

        }

    }

    public FotoRVAdapter(List<Foto> mDataSet, View.OnClickListener Listener){
        this.Listener=Listener;
        this.mDataSet=mDataSet;
    }

    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_foto_row, parent, false);
        v.setOnClickListener((View.OnClickListener) this);
        ViewHolder vh= new ViewHolder(v);
        return vh;
    }


    public void onBindViewHolder(FotoRVAdapter.ViewHolder holder, int position) {
        holder.lbDescripcion.setText((mDataSet.get(position).getDescripcion()));
        holder.lbUsuario.setText(mDataSet.get(position).getCorreo());
        //holder.ivFoto.draw();
    }

    public int getItemCount() {
        return mDataSet.size();
    }
}
