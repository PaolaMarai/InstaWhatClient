package com.instawhat.model;

public class ChatView {
    private String idChat;
    private String miembrosChat;

    public String getIdChat() {
        return idChat;
    }

    public void setIdChat(String idChat) {
        this.idChat = idChat;
    }

    public String getMiembrosChat() {
        return miembrosChat;
    }

    public void setMiembrosChat(String miembrosChat) {
        if(this.miembrosChat.isEmpty()){
            this.miembrosChat = miembrosChat;
        } else {
            this.miembrosChat = this.miembrosChat + ", "+ miembrosChat;
        }

    }
}
