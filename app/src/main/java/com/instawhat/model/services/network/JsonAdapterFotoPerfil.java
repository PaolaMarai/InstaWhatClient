package com.instawhat.model.services.network;

import com.instawhat.pojo.LoginPojo;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonAdapterFotoPerfil {

    public static boolean fotoPerfilResponseAdapter(JSONObject jsonObject) throws JSONException {
        int res = jsonObject.getInt("nModified");

        if (res == 1) {
            return true;
        } else {
            return false;
        }
    }

}

