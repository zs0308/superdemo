package com.zs.superdemo.leco.network.nohttp;

import android.app.Activity;

import com.yanzhenjie.nohttp.NoHttp;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.RequestQueue;

/**
 * NoHttp请求
 */
public class NoHttpUtil {

    private static NoHttpUtil instance;
    private static Activity mActivity;

    public static NoHttpUtil getInstance(Activity activity) {
        mActivity = activity;
        if (instance == null)
            synchronized (NoHttpUtil.class) {
                if (instance == null)
                    instance = new NoHttpUtil();
            }
        return instance;
    }

    /**
     * 请求队列。
     */
    private RequestQueue mQueue;
    /**
     * 用来标记取消。
     */
    private Object object = new Object();

    private NoHttpUtil() {
        mQueue = NoHttp.newRequestQueue(5);
    }

    /**
     * 完全退出 app 时，调用这个方法释放 CPU。
     */
    public void stop() {
        mQueue.stop();
    }

    /**
     * 发起请求。
     *
     * @param what      what.
     * @param request   请求对象。
     * @param callback  回调函数。
     * @param canCancel 是否能被用户取消。
     * @param isLoading 实现显示加载框。
     * @param msg       加载框文字提示。
     * @param <T>       想请求到的数据类型。
     */
    public <T> void sendRequest(int what, Request<T> request, HttpListener<T> callback, boolean canCancel, boolean isLoading, String msg) {
        request.setCancelSign(object);
        mQueue.add(what, request, new HttpResponseListener<>(mActivity, request, callback, canCancel, isLoading, msg));
    }

    /**
     * 发起请求。
     *
     * @param what      what.
     * @param request   请求对象。
     * @param callback  回调函数。
     * @param isLoading 实现显示加载框。
     * @param msg       加载框文字提示。
     * @param <T>       想请求到的数据类型。
     */
    public <T> void sendRequest(int what, Request<T> request, HttpListener<T> callback, boolean isLoading, String msg) {
        request.setCancelSign(object);
        mQueue.add(what, request, new HttpResponseListener<>(mActivity, request, callback, isLoading, msg));
    }

    /**
     * 发起请求。
     *
     * @param what      what.
     * @param request   请求对象。
     * @param callback  回调函数。
     * @param isLoading 实现显示加载框。
     * @param <T>       想请求到的数据类型。
     */
    public <T> void sendRequest(int what, Request<T> request, HttpListener<T> callback, boolean isLoading) {
        request.setCancelSign(object);
        mQueue.add(what, request, new HttpResponseListener<>(mActivity, request, callback, isLoading));
    }

    /**
     * 发起请求。
     *
     * @param what     what.
     * @param request  请求对象。
     * @param callback 回调函数。
     * @param <T>      想请求到的数据类型。
     */
    public <T> void sendRequest(int what, Request<T> request, HttpListener<T> callback) {
        request.setCancelSign(object);
        mQueue.add(what, request, new HttpResponseListener<>(mActivity, request, callback));
    }

}
