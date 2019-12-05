package com.instawhat.model.services.network;

public abstract class ApiEndPoint {
    private static String host = "192.168.1.254:8081"; //local
    //private static String host = "157.245.115.130:8888";
    private static String baseURL = "http://" + host + "/api";
    public static String ping = baseURL + "/ping";
    public static String usuario = baseURL + "/usuario";
    public static String usuarioLogin = baseURL + "/login";
    public static String usuarioRegistro = baseURL + "/registro";
    public static String usuarioActivacion = usuarioRegistro + "/activar";
    public static String usuarioFotoPerfil = baseURL + "/fotoperfil";
    public static String usuarioCambiarFotoPerfil = usuarioFotoPerfil + "/editar";
    public static String usuarioEditarEstado = usuario + "//cambiarestado";
    public static String contacto = baseURL + "/contacto";
    public static String contactos = contacto + "/" ;
    public static String agregarContacto = contacto + "/agregar";
    public static String buscarContacto = contacto + "/buscar";
}
