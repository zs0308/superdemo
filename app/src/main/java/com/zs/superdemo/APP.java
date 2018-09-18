package com.zs.superdemo;

import android.app.Activity;
import android.app.Service;
import android.support.multidex.MultiDexApplication;

import com.yanzhenjie.nohttp.InitializationConfig;
import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.OkHttpNetworkExecutor;
import com.yanzhenjie.nohttp.cache.DBCacheStore;
import com.yanzhenjie.nohttp.cookie.DBCookieStore;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/4.
 */
public class APP extends MultiDexApplication {

    //activity 列表
    private List<Activity> activityList = new ArrayList<Activity>();
    //分步的activity 列表
    private List<Activity> activityStep = new ArrayList<Activity>();
    //服务列表
    private final List<Service> serviceList = new LinkedList<Service>();
    public static APP app;

    //数据库
//    private DaoMaster.DevOpenHelper mHelper;
//    private SQLiteDatabase db;
//    private DaoMaster mDaoMaster;
//    private DaoSession mDaoSession;

    public static APP getInstance() {
        if (app == null) {
            app = new APP();
        }
        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        //---------------------------greendao-----------------------------
//        setDatabase();
        // -----------------------NoHttp自定义配置：-----------------------
        InitializationConfig config = InitializationConfig.newBuilder(this)
                // 全局连接服务器超时时间，单位毫秒，默认10s。
                .connectionTimeout(30 * 1000)
                // 全局等待服务器响应超时时间，单位毫秒，默认10s。
                .readTimeout(30 * 1000)
                // 配置缓存，默认保存数据库DBCacheStore，保存到SD卡使用DiskCacheStore。
                .cacheStore(new DBCacheStore(this).setEnable(true))// 如果不使用缓存，setEnable(false)禁用。
                // 配置Cookie，默认保存数据库DBCookieStore，开发者可以自己实现CookieStore接口。
                .cookieStore(new DBCookieStore(this).setEnable(true))// 如果不维护cookie，setEnable(false)禁用。
                // 配置网络层，默认URLConnectionNetworkExecutor，如果想用OkHttp：OkHttpNetworkExecutor。
                .networkExecutor(new OkHttpNetworkExecutor())
                // 全局通用Header，add是添加，多次调用add不会覆盖上次add。
                //.addHeader()
                // 全局通用Param，add是添加，多次调用add不会覆盖上次add。
                //.addParam()
                //.sslSocketFactory() // 全局SSLSocketFactory。
                //.hostnameVerifier() // 全局HostnameVerifier。
                .retry(1) // 全局重试次数，配置后每个请求失败都会重试x次。
                .build();
        NoHttp.initialize(config);
        Logger.setDebug(true);// 开启NoHttp的调试模式, 配置后可看到请求过程、日志和错误信息。
        Logger.setTag("NoHttp");// 打印Log的tag。
        /*ImagePipelineConfig imagePipelineConfig = ImagePipelineConfig.newBuilder(this)
                .setProgressiveJpegConfig(new SimpleProgressiveJpegConfig())
                .build();
        Fresco.initialize(this, imagePipelineConfig);*/
        //FontsUtil.setDefaultFont(this, "DEFAULT", "simyou.TTF");

        //----------------------------share sdk 初始化----------------------------------
//        MobSDK.init(this);
    }

    /**
     * 设置greenDao
     */
//    private void setDatabase() {
//        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
//        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
//        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
//        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
//        mHelper = new DaoMaster.DevOpenHelper(this, "notes-db", null);
//        db = mHelper.getWritableDatabase();
//        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
//        mDaoMaster = new DaoMaster(db);
//        mDaoSession = mDaoMaster.newSession();
//    }
//    public DaoSession getDaoSession() {
//        return mDaoSession;
//    }
//    public SQLiteDatabase getDb() {
//        return db;
//    }

    /**
     * 添加Service 到容器中
     *
     * @param service
     */
    public void addService(Service service) {
        serviceList.add(service);
    }

    /**
     * 遍历所有Activity、Service 并finish
     */
    public void exit() {
        for (Service service : serviceList) {
            service.stopSelf();
        }
        for (Activity activity : activityList) {
            activity.finish();
        }
        System.exit(0);
    }

    /**
     * 添加Activity 到容器中
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    /**
     * 分步的activity  完成时 全部finish
     *
     * @param activity
     */
    public void addActivityStep(Activity activity) {
        activityStep.add(activity);
    }

    public void finishStep() {
        for (Activity activity : activityStep) {
            activity.finish();
        }
    }

    /**
     * 创建应用所需文件夹
     */
    private void creatResPath() {
        /*File file = is_new File(LecoConstant.SDCARD_PATH);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        file = is_new File(LecoConstant.SDCARD_PATH_PHOTO);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        file = is_new File(LecoConstant.SDCARD_cache);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        file = is_new File(LecoConstant.SDCARD_apk);
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }*/
    }

}
