package com.instawhat.model;

public class Mensaje {
    private int idmensaje;
    private String mensaje;
    private String estado;
    private String fecha;
    private String correoremitente;
    private int idmensajeprocedencia;
    private int idchat;
    private String hora;

    public int getIdmensaje() {
        return idmensaje;
    }

    public void setIdmensaje(int idmensaje) {
        this.idmensaje = idmensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCorreoremitente() {
        return correoremitente;
    }

    public void setCorreoremitente(String correoremitente) {
        this.correoremitente = correoremitente;
    }

    public int getIdmensajeprocedencia() {
        return idmensajeprocedencia;
    }

    public void setIdmensajeprocedencia(int idmensajeprocedencia) {
        this.idmensajeprocedencia = idmensajeprocedencia;
    }

    public int getIdchat() {
        return idchat;
    }

    public void setIdchat(int idchat) {
        this.idchat = idchat;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
}
