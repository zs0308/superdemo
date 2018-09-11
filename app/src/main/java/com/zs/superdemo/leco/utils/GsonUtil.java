package com.zs.superdemo.leco.utils;


import com.google.gson.Gson;

/**
 * GsonUtil
 * implementation 'com.squareup.retrofit2:converter-gson:2.1.0'
 */
public class GsonUtil {

    private static Gson gson = new Gson();

    public static Gson getGson() {
        return gson;
    }
}
