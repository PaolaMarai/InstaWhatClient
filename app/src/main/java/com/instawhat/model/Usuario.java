package com.instawhat.model;

public class Usuario extends UsuarioGeneral {

    private String  status;
    private String nip;
    public Usuario() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
}
