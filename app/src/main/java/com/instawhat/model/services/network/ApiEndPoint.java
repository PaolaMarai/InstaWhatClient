package com.instawhat.model.services.network;

public abstract class ApiEndPoint {
    private static String host = "10.0.2.2:8080"; //local
    //private static String host = "157.245.115.130:8080";
    private static String baseURL = "http://" + host + "/api";
    public static String ping = baseURL + "/ping";
    public static String usuario = baseURL + "/usuario";
    public static String usuarioLogin = usuario + "/login";
    public static String usuarioRegistro = usuario + "/registro";
    public static String usuarioActivacion = usuario + "/activar";
}
