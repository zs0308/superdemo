package com.zs.superdemo.leco.utils;

import android.util.Log;

public class MLog {

    private static boolean DEBUG = true;
    private static String TAG = "hua";

    public static void i(String s) {
        if (!DEBUG)
            return;
        Log.i(TAG, s);
    }

    public static void d(String s) {
        if (!DEBUG)
            return;
        Log.d(TAG, s);
    }

    public static void e(String s) {
        if (!DEBUG)
            return;
        e(TAG, s);
    }

    //打印超长log
    public static void e(String tag, String msg) {  //信息太长,分段打印
        //因为String的length是字符数量不是字节数量所以为了防止中文字符过多，
        //  把4*1024的MAX字节打印长度改为2001字符数
        int max_str_length = 2001 - tag.length();
        //大于4000时
        while (msg.length() > max_str_length) {
            Log.e(tag, msg.substring(0, max_str_length));
            msg = msg.substring(max_str_length);
        }
        //剩余部分
        Log.e(tag, msg);
    }
}
