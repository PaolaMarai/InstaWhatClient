package com.instawhat.viewModels;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.instawhat.R;
import com.instawhat.model.ChatView;


import java.util.List;

public class ChatListRVAdapter extends RecyclerView.Adapter<ChatListRVAdapter.ViewHolder> implements View.OnClickListener {
    private List<ChatView> mDataSet;
    private View.OnClickListener Listener;

    public ChatListRVAdapter(List<ChatView> chatViews) {
        this.mDataSet=chatViews;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView miembrosChat;

        public ViewHolder(View itemView) {
            super(itemView);
            miembrosChat= itemView.findViewById(R.id.miembrosChat);
        }
    }


    @NonNull
    @Override
    public ChatListRVAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.chat_list_row, parent, false);
        v.setOnClickListener(this);
        ChatListRVAdapter.ViewHolder vh= new ChatListRVAdapter.ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(@NonNull ChatListRVAdapter.ViewHolder holder, int position) {
        holder.miembrosChat.setText(mDataSet.get(position).getMiembrosChat());
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
