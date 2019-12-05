package com.instawhat.model.services.persitance;

public class User {

    private static String email;
    private static String password;
    private static String estado;
    private static String foto;
    private static String username;

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        User.email = email;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        User.password = password;
    }

    public static String getEstado() {
        return estado;
    }

    public static void setEstado(String estado) {
        User.estado = estado;
    }

    public static String getFoto() {
        return foto;
    }

    public static void setFoto(String foto) {
        User.foto = foto;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        User.username = username;
    }
}
