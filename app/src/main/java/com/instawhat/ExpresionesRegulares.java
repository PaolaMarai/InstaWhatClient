package com.instawhat;

public abstract class ExpresionesRegulares {

    private static final String EMAIL = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    private static final String PASSWORD = "^[a-zA-Z]\\w{3,14}$";

    private static final String USERNAME = "^([a-zA-Z0-9]{1,15})$";

    public static boolean validarEmail(String email) {

        if (email.matches(EMAIL)) {
            return true;
        }

        return false;
    }

    public static boolean validarPassword(String password) {

        if (password.matches(PASSWORD)) {
            return true;
        }

        return false;
    }

    public static boolean validarUsername(String username) {

        if (username.matches(USERNAME)) {
            return true;
        }

        return false;
    }

}
