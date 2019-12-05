package com.instawhat.model.services.network;

import com.instawhat.model.Contacto;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonAdapterContacto {

    public static List<Contacto> getContactos(JSONArray jsonArray) throws JSONException{
        List<Contacto> res = new ArrayList<>();
        for(int i=0; i<jsonArray.length() ; i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Contacto contacto = new Contacto();
            contacto.setCorreo(jsonObject.getString("agregado"));
            contacto.setRelacion(jsonObject.getString("relacion"));
            res.add(contacto);
        }
        return res;
    }


}
