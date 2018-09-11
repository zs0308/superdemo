package com.zs.superdemo.leco.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by highnes on 2017/3/23.
 */

public class ShareUtils {
    public static String key = "zs";
    public static void clearDate(Context context){//清除所有数据
        SharedPreferences clearDateSp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        clearDateSp.edit().clear().commit();
    }
    //当前设备
    public static String getCurrentDevice(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getString("current_sn","");
    }

    public static void setCurrentSn(Context context, String data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
        edit.putString("current_sn", data);
        edit.commit();
    }
    //屏幕宽度
    public static float getAppWidth(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getFloat("width",0);
    }

    public static void setAppWidth(Context context, float data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
        edit.putFloat("width", data);
        edit.commit();
    }
    //屏幕高度
    public static float getAppHeight(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getFloat("height",0);
    }
    public static void setAppHeight(Context context, float data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
        edit.putFloat("height", data);
        edit.commit();
    }

    //账号
    public static void setAccount(Context context, String data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
        edit.putString("account", data);
        edit.commit();
    }

    public static String getAccount(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getString("account","");
    }

    //token，请求时需放在header中
    public static void setAuthorization(Context context, String data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
        edit.putString("Authorization", data);
        edit.commit();
    }

    public static String getAuthorization(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getString("Authorization","");
    }

    //邮箱
    public static void setEmail(Context context, String data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
        edit.putString("email", data);
        edit.commit();
    }

    public static String getEmail(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getString("email","");
    }
    //主键ID
    public static void setId(Context context, String data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
        edit.putString("id", data);
        edit.commit();
    }

    public static String getId(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getString("id","");
    }

    //身份证号
    public static void setIdentity(Context context, String data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
        edit.putString("identity", data);
        edit.commit();
    }

    public static String getIdentity(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getString("identity","");
    }

    //手机号码
    public static void setMobile(Context context, String data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
        edit.putString("mobile", data);
        edit.commit();
    }

    public static String getMobile(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getString("mobile","");
    }


    //真实姓名
    public static void setRealName(Context context, String data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
        edit.putString("realName", data);
        edit.commit();
    }

    public static String getRealName(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getString("realName","");
    }

    //联系电话
    public static void setTel(Context context, String data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
        edit.putString("tel", data);
        edit.commit();
    }

    public static String getTel(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getString("tel","");
    }

    //最近一次登陆时间
    public static void setLatestTime(Context context, String data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
        edit.putString("latestTime", data);
        edit.commit();
    }

    public static String getLatestTime(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getString("latestTime","");
    }


    //当前年月日
    public static void setNowData(Context context, String data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
        edit.putString("NowData", data);
        edit.commit();
    }

    public static String getNowData(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getString("NowData","");
    }


    //当前月的一号
    public static void setFirstData(Context context, String data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
        edit.putString("FirstData", data);
        edit.commit();
    }

    public static String getFirstData(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getString("FirstData","");
    }

    //经度
    public static void setLongitude(Context context, String data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
//        edit.putString("longitude", "0");
        edit.putString("longitude", data);
        edit.commit();
    }


    public static String getLongitude(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getString("longitude","0");
    }

    //纬度
    public static void setLatitude(Context context, String data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
//        edit.putString("latitude", "0");
        edit.putString("latitude", data);
        edit.commit();
    }

    public static String getLatitude(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getString("latitude","0");
    }

    //城区
    public static void setChengqu(Context context, String data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
        edit.putString("chengqu", data);
        edit.commit();
    }

    public static String getChengqu(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getString("chengqu","--");
    }

    public static void setJiedao(Context context, String data){
        SharedPreferences acountsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = acountsp.edit();
        edit.putString("jiedao", data);
        edit.commit();
    }

    public static String getJiedao(Context context){
        SharedPreferences portraitsp = context.getSharedPreferences(key, Context.MODE_PRIVATE);
        return portraitsp.getString("jiedao","--");
    }

}
