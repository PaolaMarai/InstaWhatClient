package com.instawhat.model.services.network;

import com.instawhat.model.Usuario;
import com.instawhat.pojo.LoginPojo;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonAdapterUsuario {

    public static Usuario userAdapter(JSONObject jsonObject) throws JSONException {
        Usuario res = new Usuario();
        res.setUsername(jsonObject.getString("user.username"));
        res.setEmail(jsonObject.getString("user.correo"));
        res.setPassword(jsonObject.getString("user.password"));
        return res;
    }


}
