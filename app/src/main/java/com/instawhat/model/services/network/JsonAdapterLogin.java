package com.instawhat.model.services.network;

import com.instawhat.pojo.LoginPojo;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonAdapterLogin {

    public static LoginPojo loginAdapter(JSONObject jsonObject) throws JSONException {
        LoginPojo res = new LoginPojo();
        res.setToken(jsonObject.getString("token"));
        return res;
    }

}
