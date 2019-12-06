package com.instawhat.model.services.network;

public abstract class ApiEndPoint {
    private static String host = "10.0.2.2:8080"; //local
    //private static String host = "157.245.115.130:8888";
    private static String baseURL = "http://" + host + "/api";
    public static String ping = baseURL + "/ping";
    public static String usuario = baseURL + "/usuario";
    public static String usuarioLogin = baseURL + "/login";
    public static String usuarioRegistro = baseURL + "/registro";
    public static String usuarioActivacion = usuarioRegistro + "/activar";
    public static String usuarioFotoPerfil = baseURL + "/fotoperfil";
    public static String usuarioCambiarFotoPerfil = usuarioFotoPerfil + "/editar";
    public static String usuarioEditarEstado = usuario + "//editarestado";
    public static String foto = baseURL + "/foto";
    public static String publicarFoto = foto + "/publicar";

}
