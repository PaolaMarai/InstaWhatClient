package com.instawhat.model.services.network;

import com.instawhat.model.Usuario;
import com.instawhat.pojo.LoginPojo;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonAdapterUsuario {

    public static Usuario userAdapter(JSONObject jsonObject) throws JSONException {
        Usuario res = new Usuario();
        res.setUsername(jsonObject.getString("username"));
        res.setEmail(jsonObject.getString("correo"));
        res.setEstado(jsonObject.getString("estado"));
        return res;
    }

    public static String fotoPerflAdapter(JSONObject jsonObject) throws JSONException {
        String fotoString = jsonObject.getString("foto");
        return fotoString;
    }

    public static String estadoAdapter(JSONObject jsonObject) throws JSONException {
        String estado = jsonObject.getString("descripcion");
        return estado;
    }

}
