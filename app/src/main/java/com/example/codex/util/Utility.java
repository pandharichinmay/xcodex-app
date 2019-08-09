package com.example.codex.util;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class Utility {

    public static final String HOST_URL = "http://192.168.0.103:8080/";


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

}
