package com.zs.superdemo.leco.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * Created by shuang.zeng on 2017/7/5.
 * android 6.0、compileSdkVersion 23 以上的动态权限申请
 */

/*
    Android6.0以上系统把权限分为两个级别：
    一个是Normal Permissions，即普通权限，这类权限不会潜藏有侵害用户隐私和安全的问题，比如，访问网络的权限，访问WIFI的权限等；
    使用普通权限是可以直接的在manifest里面直接的使用，而且在安装后也会直接的生效了。
    另一类是Dangerous Permissions，即危险权限，这类权限会直接的威胁到用户的安全和隐私问题，比如说访问短信，相册等权限。
    危险权限需要动态申请
 */
public class UtilPermission {

    /**
     * @param activity
     * @param permission     要判断的权限 Manifest.permission.CALL_PHONE
     * @param isApply        如果没有权限是否要申请（回调的时候如果用户拒绝就传false，否则会一直循环）
     * @param permissionFlag 申请权限回调标记
     * @return 是否有这个权限
     */
    /*
    注意：手机厂商可能会对原生系统做了修改，例如：vivo、oppo手机只要在manifest文件中写了相关权限，它都会返回true，不管手机本身对此权限是开启或是关闭，
    且用户拒绝后就不会再提示申请。三星手机测试就正常，每次拒绝后用户再点击，照样会继续申请权限。
     */
    public static boolean isHavePermission(Activity activity, String permission, boolean isApply, int permissionFlag) {
        boolean has_permission = (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(activity, permission));
        LecoUtils.Log("permission=" + permission + ",has_permission=" + has_permission);
        if (!has_permission && isApply) {
//            Toast.makeText(activity, "对不起，没有***权限！", Toast.LENGTH_SHORT).show();
            //没有权限就去申请
            ActivityCompat.requestPermissions(activity, new String[]{permission}, permissionFlag);
        }
        return has_permission;
    }

    /*
    申请完权限后的回调
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE:
                boolean has_permission = UtilPermission.isHavePermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE, false, MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);
                if (has_permission) {
                    AppVersionChecker appVersionChecker = new AppVersionChecker(this, false);
                    appVersionChecker.getNewVersion(1);
                }
                break;
        }
    }
    */

    /** Dangerous Permissions （危险权限）*/
    /*
    SMS（短信）
        Manifest.permission.SEND_SMS
        Manifest.permission.RECEIVE_SMS
        Manifest.permission.READ_SMS
        Manifest.permission.RECEIVE_WAP_PUSH
        Manifest.permission.RECEIVE_MMS
    STORAGE（存储卡）
        Manifest.permission.READ_EXTERNAL_STORAGE
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    CONTACTS（联系人）
        Manifest.permission.READ_CONTACTS
        Manifest.permission.WRITE_CONTACTS
        Manifest.permission.GET_ACCOUNTS
    PHONE（手机）
        Manifest.permission.READ_PHONE_STATE
        Manifest.permission.CALL_PHONE
        Manifest.permission.READ_CALL_LOG
        Manifest.permission.WRITE_CALL_LOG
        Manifest.permission.ADD_VOICEMAIL
        Manifest.permission.USE_SIP
        Manifest.permission.PROCESS_OUTGOING_CALLS
    CALENDAR（日历）
        Manifest.permission.READ_CALENDAR
        Manifest.permission.WRITE_CALENDAR
    CAMERA（相机）
        Manifest.permission.CAMERA
    LOCATION（位置）
        Manifest.permission.ACCESS_FINE_LOCATION
        Manifest.permission.ACCESS_COARSE_LOCATION
    SENSORS（传感器）
        Manifest.permission.BODY_SENSORS
    MICROPHONE（麦克风）
        Manifest.permission.RECORD_AUDIO
     */

    /*
    危险权限和普通权限也有区别，普通权限是单条的权限，而危险权限是以组展示的，也就是说，当你接受一个危险权限时，
    不但但接受的是界面上展示的这一个权限，而是它所在这个组里面的其他所有访问权限也将会被自动获取权限，
    比如，一旦WRITE_CONTACTS被授权了，App也有READ_CONTACTS和GET_ACCOUNTS的权限了。
    值得注意的是，这类权限也是需要在manifest中注册的。
     */
}
