package com.example.codex.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {

    public static final String HOST_URL = "http://192.168.1.25:8080/";
    private static final String PREF_NAME = "codexPrefs";
    public static final String DATE_FORMAT = "MMM dd hh:mm";

    public static <T> T fromJson(String response, Class<T> cls, Type token) {
        try {
            if(token != null) {
                return new Gson().fromJson(response, token);
            } else {
                return new Gson().fromJson(response, cls);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static Response.ErrorListener standardErrorListener(final Context ctx) {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //displaying the error in toast if occurrs
                System.out.println("In Error Listener" + error);
                Toast.makeText(ctx, "Error occurred on the server ..", Toast.LENGTH_SHORT).show();
            }
        };
    }

    public static void saveToSharedPref(Activity activity, String keyString, Object object) {
        try {
            SharedPreferences sharedPreferences = activity.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(keyString, new Gson().toJson(object));
            editor.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Object readFromSharedPref(Activity activity, String key, Class<?> cls) {
        try {
            if (activity == null || key == null) {
                return null;
            }
            SharedPreferences sharedPreferences = activity.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            return fromJson(sharedPreferences.getString(key, null), cls, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String convertDate(Date date, String dateFormat) {
        try {
            return new SimpleDateFormat(dateFormat).format(date);
        } catch (Exception e) {
        }
        return null;
    }

}
