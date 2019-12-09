package com.instawhat.model.services.network;

import com.instawhat.model.Foto;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class JsonAdapterFoto {
    public static List<Foto> getFotos(JSONArray jsonArray) throws JSONException{
        List<Foto> res = new ArrayList<>();
        for(int i=0; i<jsonArray.length() ; i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Foto foto = new Foto();
            foto.setIdFoto(jsonObject.getString("_id"));
            foto.setCorreo(jsonObject.getString("correo"));
            foto.setDescripcion(jsonObject.getString("descripcion"));
            foto.setFoto(jsonObject.getString("foto"));
            res.add(foto);
        }
        return res;
    }
}
