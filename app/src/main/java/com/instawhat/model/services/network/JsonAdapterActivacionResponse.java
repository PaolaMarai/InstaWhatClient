package com.instawhat.model.services.network;

import com.instawhat.pojo.ActivacionPOJO;
import com.instawhat.pojo.LoginPojo;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonAdapterActivacionResponse {


    /**
     * Muestra la cantidad de elementos modificados
     * @param jsonObject objeto Json
     * @return regresa un objeto ActivacionPOJO
     * @throws JSONException
     */
    public static ActivacionPOJO activacionAdapter(JSONObject jsonObject) throws JSONException {
        ActivacionPOJO res = new ActivacionPOJO();
        res.setnModified(jsonObject.getInt("nModified"));
        return res;
    }

}
