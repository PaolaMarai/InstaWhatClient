package com.instawhat.model.services.network;

import com.instawhat.pojo.LoginPojo;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonAdapterEditResponse {

    public static boolean editResponseAdapter(JSONObject jsonObject) throws JSONException {
        int res = jsonObject.getInt("nModified");

        if (res == 1) {
            return true;
        } else {
            return false;
        }
    }

}

