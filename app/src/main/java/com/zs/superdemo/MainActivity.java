package com.zs.superdemo;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ClipboardManager;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.PhoneUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.leon.lfilepickerlibrary.LFilePicker;
import com.leon.lfilepickerlibrary.utils.Constant;
import com.maning.mndialoglibrary.MToast;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.RequestMethod;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zs.superdemo.leco.activity.base.BaseActivity;
import com.zs.superdemo.leco.activity.commonui.PicWaterMark;
import com.zs.superdemo.leco.network.ResultJson;
import com.zs.superdemo.leco.network.UrlConstant;
import com.zs.superdemo.leco.network.nohttp.HttpListener;
import com.zs.superdemo.leco.network.nohttp.NoHttpUtil;
import com.zs.superdemo.leco.utils.GsonUtil;
import com.zs.superdemo.leco.utils.LecoUtils;
import com.zs.superdemo.leco.utils.MLog;
import com.zs.superdemo.leco.utils.OpenFiles;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnNeverAskAgain;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.OnShowRationale;
import permissions.dispatcher.PermissionRequest;
import permissions.dispatcher.RuntimePermissions;

/**
 * code no bug a
 */
@RuntimePermissions
public class MainActivity extends BaseActivity {
    private final int SELECT_FILE = 1000;//选择文件
    private final int SELECT_FILE_LFile = 1001;//选择文件
//    @Bind(R.id.tv_hello)
//    TextView tvHello;
//    @Bind(R.id.recycler)
//    RecyclerView recycler;

    private TextView tvHello;
    private RecyclerView recycler;

    private List<String> list = new ArrayList<>();

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
        tvHello = findViewById(R.id.tv_hello);
        recycler = findViewById(R.id.recycler);

        Log.e("zs", "hiyou  SHA1=" + AppUtils.getAppSignatureSHA1("com.leco.haiyoufurniture"));
        list.add("1 跳至发送短信界面");
        list.add("2 截屏");
        list.add("3 打开网络设置界面");
        list.add("4 select file test");
        list.add("5 文件选择 Ifilepickerlibrary");
        list.add("6 test nohttp");
        list.add("7 图片水印");
        list.add("8 打开微信");
        list.add("9 点击复制这段文字");
        list.add("10 权限测试");
        list.add("11 8.0通知栏适配");
        list.add("11    发送聊天信息");
        list.add("11    发送订阅信息");
        MLog.e("list.size=" + list.size());
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(getBaseContext());
        recycler.setLayoutManager(mLinearLayoutManager);
        recycler.setAdapter(new CommonAdapter<String>(this, R.layout.item_list, list) {
            @Override
            protected void convert(ViewHolder holder, String mS, final int position) {
                holder.setText(R.id.tv_content, mS);
                MLog.e("ms=" + mS);
                MLog.e("position=" + position);
                holder.setOnClickListener(R.id.tv_content, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = null;
                        MLog.e("click click click");
                        switch (position) {
                            case 0://跳至发送短信界面
                                PhoneUtils.sendSms("10000", "108");
                                break;
                            case 1://截屏
                                ScreenUtils.screenShot(MainActivity.this);
                                break;
                            case 2://打开网络设置界面
                                NetworkUtils.openWirelessSettings();
                                break;
                            case 3://打开文件测试
                                intent = new Intent(Intent.ACTION_GET_CONTENT);
                                //intent.setType(“image/*”);//选择图片
                                //intent.setType(“audio/*”); //选择音频
                                //intent.setType(“video/*”); //选择视频 （mp4 3gp 是android支持的视频格式）
                                //intent.setType(“video/*;image/*”);//同时选择视频和图片
                                intent.setType("*/*");//无类型限制
                                intent.addCategory(Intent.CATEGORY_OPENABLE);
                                startActivityForResult(intent, SELECT_FILE);
                                break;
                            case 4://lfilepickerlibrary
                                new LFilePicker()
                                        .withActivity(MainActivity.this)
                                        .withRequestCode(SELECT_FILE_LFile)
//                                        .withStartPath("/storage/emulated/0/Download")//指定初始显示路径
//                                        .withIsGreater(false)//过滤文件大小 小于指定大小的文件
//                                        .withFileSize(5000 * 1024)//指定文件大小为500K
                                        .withIconStyle(Constant.ICON_STYLE_BLUE)//文件图标跑
                                        .withTitle("选择文件")//标题
                                        .withMutilyMode(false)//单选、多选
                                        .withFileFilter(new String[]{".txt", ".png", ".doc"})//过滤文件类型
                                        .withBackIcon(Constant.BACKICON_STYLETHREE)//返回图标三种类型
                                        .withBackgroundColor("#FF9966")
                                        .start();

                                break;
                            case 5:
                                login("18392184426", "000000");
                                break;
                            case 6:
                                //水印图片
                                intent = new Intent(getBaseContext(), PicWaterMark.class);
                                startActivity(intent);
                                break;
                            case 7:
                                //打开微信
                                startApp("com.tencent.mm");
                                break;
                            case 8:
                                //复制这段文字
                                ClipboardManager cm = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                                cm.setText(list.get(8));
                                Toast.makeText(getBaseContext(), "复制成功", Toast.LENGTH_SHORT).show();
                                break;
                            case 9:
                                MLog.e("打电话了");
                                MainActivityPermissionsDispatcher.callWithCheck(MainActivity.this, "10086");
                                break;
                            case 10:
                                //
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                    String channelId = "chat";
                                    String channelName = "聊天信息";
                                    int importance = NotificationManager.IMPORTANCE_HIGH;
                                    createNoticationChannel(channelId, channelName, importance);
                                    channelId = "subscribe";
                                    channelName = "订阅消息";
                                    importance = NotificationManager.IMPORTANCE_DEFAULT;
                                    createNoticationChannel(channelId, channelName, importance);
                                }
                                break;
                            case 11:
                                sendChatMsg();
                                break;
                            case 12:
                                sendSubscribeMsg();
                                break;
                        }
                    }
                });
            }

        });

        boolean is4G = NetworkUtils.is4G();
        MLog.e("is4G=" + is4G);

//        PhoneUtils.getIMEI();
    }

    @TargetApi(Build.VERSION_CODES.O)
    private void createNoticationChannel(String channelId, String channelName, int importance) {
        NotificationChannel channel = new NotificationChannel(channelId, channelName, importance);
        channel.setShowBadge(true);//表示允许这个渠道下的通知显示角标
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotificationManager.createNotificationChannel(channel);
    }

    private void sendChatMsg(){
        NotificationManager mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification mNotification = new NotificationCompat.Builder(this,"chat")
                .setContentTitle("收到一条聊天消息")
                .setContentText("今天中午吃什么？")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.test_pic_3)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.test_pic_1))
                .setAutoCancel(true)
                .setNumber(2)//传入未读消息的数量
                .build();
        mManager.notify(1,mNotification);

    }

    private void sendSubscribeMsg(){
        NotificationManager mManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification mNotification = new NotificationCompat.Builder(this,"subscribe")
                .setContentTitle("收到一条订阅消息")
                .setContentText("地铁沿线30万商铺抢购中")
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.drawable.btn_bg)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.test_pic_2))
                .setAutoCancel(true)
                .build();
        mManager.notify(2,mNotification);

    }
    @NeedsPermission(Manifest.permission.CALL_PHONE)
        //在需要获取的地方注释
    void call(String string) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        Uri data = Uri.parse("tel:" + string);
        intent.setData(data);
        MLog.e("11111");
        try {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return;
            }
            startActivity(intent);
        } catch (Exception e) {
            MLog.e("打电话异常 e=" + e);
        }
    }

    @OnShowRationale(Manifest.permission.CALL_PHONE)
        //提示用户为何要开此权限
    void showWhy(final PermissionRequest mRequest) {
        new AlertDialog.Builder(this)
                .setMessage("提示用户为何要开启权限，因为你要打电话")
                .setPositiveButton("知道了", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mRequest.proceed();//再次执行权限请求
                    }
                })
                .show();

    }

    @OnPermissionDenied(Manifest.permission.CALL_PHONE)
        //用户选择拒绝的提式
    void showDenied() {
        Toast.makeText(this, "哦你拒绝了", Toast.LENGTH_SHORT).show();
    }

    @OnNeverAskAgain(Manifest.permission.CALL_PHONE)
    void showNotAsk() {
        new AlertDialog.Builder(this)
                .setMessage("该功能要访问权限，拒绝你会后悔的")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(MainActivity.this, requestCode, grantResults);
    }

    private void startApp(String packageName) {
        PackageManager packageManager = getPackageManager();
        Intent intent = new Intent();
        intent = packageManager.getLaunchIntentForPackage(packageName);
        if (intent == null) {
            Toast.makeText(this, "未安装", Toast.LENGTH_LONG).show();
        } else {
            startActivity(intent);
        }
    }

    String path;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case SELECT_FILE://选择文件
                    Uri uri = data.getData();
                    MLog.e("select_file uri=" + uri);
                    if ("file".equalsIgnoreCase(uri.getScheme())) {//使用第三方应用打开
                        path = uri.getPath();
                        MLog.e("path=" + path);
                        return;
                    }

                    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {//4.4以后
                        path = getPath(this, uri);
                        MLog.e("4.4 以上 path=" + path);
                    }

                    break;
                case SELECT_FILE_LFile:
                    //LFilePicker
                    //如果是文件选择模式，需要获取选择的所有文件的路径集合
                    //List<String> list = data.getStringArrayListExtra(Constant.RESULT_INFO);//Constant.RESULT_INFO == "paths"
                    List<String> list = data.getStringArrayListExtra("paths");
                    Toast.makeText(getApplicationContext(), "选中了" + list.size() + "个文件", Toast.LENGTH_SHORT).show();
                    MLog.e("选中了" + list.size() + "个文件");
                    //如果是文件夹选择模式，需要获取选择的文件夹路径
                    String path = data.getStringExtra("path");
                    Toast.makeText(getApplicationContext(), "选中的路径为" + path, Toast.LENGTH_SHORT).show();
                    MLog.e("选中的路径为" + path);
                    File mFile = new File(path);
                    startActivity(OpenFiles.getWordFileIntent(mFile));
                    MLog.e("打开word");
                    break;
            }
        }
    }

    /**
     * 专为Android4.4设计的从Uri获取文件绝对路径，以前的方法已不好使
     */

    @SuppressLint("NewApi")
    public String getPath(final Context context, final Uri uri) {
        final boolean isKitKat = Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT;
        // DocumentProvider
        if (isKitKat && DocumentsContract.isDocumentUri(context, uri)) {
            // ExternalStorageProvider
            if (isExternalStorageDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];

                if ("primary".equalsIgnoreCase(type)) {
                    return Environment.getExternalStorageDirectory() + "/" + split[1];
                }
            }
            // DownloadsProvider
            else if (isDownloadsDocument(uri)) {
                final String id = DocumentsContract.getDocumentId(uri);
                final Uri contentUri = ContentUris.withAppendedId(
                        Uri.parse("content://downloads/public_downloads"), Long.valueOf(id));
                return getDataColumn(context, contentUri, null, null);
            }
            // MediaProvider
            else if (isMediaDocument(uri)) {
                final String docId = DocumentsContract.getDocumentId(uri);
                final String[] split = docId.split(":");
                final String type = split[0];
                Uri contentUri = null;
                if ("image".equals(type)) {
                    contentUri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

                } else if ("video".equals(type)) {
                    contentUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

                } else if ("audio".equals(type)) {
                    contentUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                }
                final String selection = "_id=?";
                final String[] selectionArgs = new String[]{split[1]};
                return getDataColumn(context, contentUri, selection, selectionArgs);
            }
        }
        // MediaStore (and general)
        else if ("content".equalsIgnoreCase(uri.getScheme())) {
            return getDataColumn(context, uri, null, null);
        }
        // File
        else if ("file".equalsIgnoreCase(uri.getScheme())) {
            return uri.getPath();
        }
        return null;
    }

    /**
     * Get the value of the data column for this Uri. This is useful for
     * MediaStore Uris, and other file-based ContentProviders.
     *
     * @param context       The context.
     * @param uri           The Uri to query.
     * @param selection     (Optional) Filter used in the query.
     * @param selectionArgs (Optional) Selection arguments used in the query.
     * @return The value of the _data column, which is typically a file path.
     */
    public String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) {
        Cursor cursor = null;
        final String column = "_data";
        final String[] projection = {column};
        try {
            cursor = context.getContentResolver().query(uri, projection, selection, selectionArgs, null);
            if (cursor != null && cursor.moveToFirst()) {
                final int column_index = cursor.getColumnIndexOrThrow(column);
                return cursor.getString(column_index);
            }
        } finally {
            if (cursor != null)
                cursor.close();
        }
        return null;
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is ExternalStorageProvider.
     */
    public boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is DownloadsProvider.
     */
    public boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /**
     * @param uri The Uri to check.
     * @return Whether the Uri authority is MediaProvider.
     */
    public boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /**
     * 登录
     *
     * @param userPhone
     * @param loginPwd
     */
    private void login(String userPhone, String loginPwd) {
        LecoUtils.Log("自动登录 接口开始传参 userRegist userPhone = " + userPhone + ",loginPwd=" + loginPwd);
        Request<String> request = NoHttp.createStringRequest(UrlConstant.SERVER_BASE_URL + UrlConstant.login, RequestMethod.POST);
        request.add("userPhone", userPhone);
        request.add("loginPwd", loginPwd);
//        request.add("client_type", LecoConstant.CLIENT_TYPE);

        NoHttpUtil.getInstance(this).sendRequest(0, request, new HttpListener<String>() {
            @Override
            public void onSucceed(int what, Response<String> response) {
                LecoUtils.Log("登录 userRegist onSucceed=========== " + response.responseCode() + "  === " + response.get());
                if (response.responseCode() == 200) {
                    ResultJson resultJson = GsonUtil.getGson().fromJson(response.get(), ResultJson.class);
                    switch (resultJson.getCode()) {
                        case ResultJson.SUCCESS_CODE:
//                            LecoUtils.showToast(getBaseContext(), "登录成功");
                            LecoUtils.Log("登录 SUCCESS_CODE SUCCESS_CODE");
                            break;
                        case ResultJson.SESSION_FAILED:
                            LecoUtils.showToast(getBaseContext(), LecoUtils.SessionFailNotice);
//                            Intent intent = new Intent(getBaseContext(), LoginActivity.class);
//                            startActivity(intent);
                            break;
                        case ResultJson.FAILED_CODE:
                            MToast.makeTextShort(getBaseContext(), resultJson.getMsg());
                            break;
                    }
                }
            }

            @Override
            public void onFailed(int what, Response<String> response) {
                MLog.e("登录 onFailed=========== " + response.responseCode() + "  === " + response.get());

            }
        }, true, true, "请稍后...");
    }

}
