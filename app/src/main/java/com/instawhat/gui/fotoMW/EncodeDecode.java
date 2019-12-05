package com.instawhat.gui.fotoMW;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.util.Base64;
import android.widget.ImageView;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class EncodeDecode {


    public static String encodeImage(ImageView imagen) {
        Bitmap bitmap = ((BitmapDrawable) imagen.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] imageInByte = baos.toByteArray();
        String encode = android.util.Base64.encodeToString(imageInByte, android.util.Base64.DEFAULT);
        return encode;
    }

    public static Bitmap toBitmap(String foto) {
        System.out.println();
        System.out.println(foto);
        System.out.println();
        byte[] bytes = android.util.Base64.decode(foto, Base64.DEFAULT);
        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(bytes);
        Bitmap bitmap = BitmapFactory.decodeStream(arrayInputStream);
        return bitmap;
    }

}
