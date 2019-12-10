package com.instawhat.model.services.network;

public abstract class ApiEndPoint {
   private static String host = "192.168.43.42:8080"; //local
    //private static String host = "10.0.2.2:8888"; //local
    //private static String host = "10.50.7.1:8888"; //local
    // para emulador
    //para server
    // para probar con cel
    //private static String host = "157.245.115.130:8888";
    private static String baseURL = "http://" + host + "/api";
    public static String ping = baseURL + "/ping";
    public static String usuario = baseURL + "/Usuario";
    public static String usuarioLogin = baseURL + "/login";
    public static String usuarioRegistro = baseURL + "/registro";
    public static String usuarioActivacion = usuarioRegistro + "/activar";
    public static String usuarioFotoPerfil = baseURL + "/fotoperfil";
    public static String usuarioCambiarFotoPerfil = usuarioFotoPerfil + "/editar";

    public static String contacto = baseURL + "/contacto";
    public static String contactos = contacto + "/" ;
    public static String agregarContacto = contacto + "/agregar";
    public static String buscarContacto = contacto + "/buscar";

    public static String usuarioEditarEstado = usuario + "/editarestado";
    public static String usuarioEditarUsername = usuario + "/editarusername";
    public static String usuerioEditarPassword = usuario + "/editarpassword";
    public static String foto = baseURL + "/foto";
    public static String publicarFoto = foto + "/publicar";

    public static String obternerFotos = foto + "/consultarpublicaciones";


}
