package com.instawhat.model.services.network;

import com.instawhat.model.Foto;

import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JsonAdapterFoto {
    public static List<Foto> getFotos(JSONArray jsonArray) throws JSONException, ParseException {
        List<Foto> res = new ArrayList<>();
        /*String fecha;
        Date fechaparsed;*/


        for(int i=0; i<jsonArray.length() ; i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Foto foto = new Foto();
            foto.setIdFoto(jsonObject.getString("idFoto"));
            foto.setCorreo(jsonObject.getString("correo"));
            foto.setDescripcion(jsonObject.getString("descripcion"));
            foto.setFoto(jsonObject.getString("foto"));
            /*fecha = jsonObject.getString("fecha");
            fechaparsed=new SimpleDateFormat("dd/MM/yyyy").parse(convertMongoDate(fecha));
            foto.setFecha(fechaparsed);*/
            res.add(foto);
        }
        return res;
    }

    private static String convertMongoDate(String val){
        SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat outputFormat= new SimpleDateFormat("yyyy/MM/dd");
        try {
            String finalStr = outputFormat.format(inputFormat.parse(val));
            System.out.println(finalStr);
            return finalStr;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}
