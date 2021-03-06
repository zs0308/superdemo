/*
 * Copyright 2015 Yan Zhenjie
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zs.superdemo.leco.network.nohttp;

import android.app.Activity;
import android.text.TextUtils;

import com.maning.mndialoglibrary.MProgressDialog;
import com.maning.mndialoglibrary.MToast;
import com.yanzhenjie.nohttp.Logger;
import com.yanzhenjie.nohttp.error.NetworkError;
import com.yanzhenjie.nohttp.error.NotFoundCacheError;
import com.yanzhenjie.nohttp.error.TimeoutError;
import com.yanzhenjie.nohttp.error.URLError;
import com.yanzhenjie.nohttp.error.UnKnownHostError;
import com.yanzhenjie.nohttp.rest.OnResponseListener;
import com.yanzhenjie.nohttp.rest.Request;
import com.yanzhenjie.nohttp.rest.Response;
import com.zs.superdemo.leco.utils.MLog;

/**
 * @author Yan Zhenjie.
 */
public class HttpResponseListener<T> implements OnResponseListener<T> {

    private Activity mActivity;
    /**
     * Dialog.
     */
    private MProgressDialog mWaitDialog;
    /**
     * 加载框 提示语
     */
    private String msg;
    /**
     * Request.
     */
    private Request<?> mRequest;
    /**
     * 结果回调.
     */
    private HttpListener<T> callback;

    /**
     * @param activity     context用来实例化dialog.
     * @param request      请求对象.
     * @param httpCallback 回调对象.
     * @param canCancel    是否允许用户取消请求.
     * @param isLoading    是否显示dialog.
     * @param msg          对话框的文字提示
     */
    public HttpResponseListener(Activity activity, Request<?> request, HttpListener<T> httpCallback, final boolean canCancel, boolean isLoading, String msg) {
        this.mActivity = activity;
        this.mRequest = request;
        this.msg = msg;
        MLog.e("mWaitDialog=" + mWaitDialog);
        if (activity != null && isLoading) {
            mWaitDialog = new MProgressDialog();
        }
        if (canCancel) {
            if (mWaitDialog != null && mWaitDialog.isShowing()) {
                mWaitDialog.dismissProgress();
                request.cancel();
            }

//            if (mWaitDialog!=null){
//                mWaitDialog.setCanceledOnTouchOutside(true);
//                mWaitDialog.setOnDialogDismissListener(new MProgressDialog.OnDialogDismissListener() {
//                    @Override
//                    public void dismiss() {
//
//                    }
//                });
//            }
        }
        this.callback = httpCallback;
    }

    /**
     * @param activity     context用来实例化dialog.
     * @param request      请求对象.
     * @param httpCallback 回调对象.
     * @param isLoading    是否显示dialog.
     * @param msg          对话框的文字提示
     */
    public HttpResponseListener(Activity activity, Request<?> request, HttpListener<T> httpCallback, boolean isLoading, String msg) {
        this.mActivity = activity;
        this.mRequest = request;
        this.msg = msg;
        if (activity != null && isLoading) {
            mWaitDialog = new MProgressDialog();
        }
        this.callback = httpCallback;
    }

    /**
     * @param activity     context用来实例化dialog.
     * @param request      请求对象.
     * @param httpCallback 回调对象.
     * @param isLoading    是否显示dialog.
     */
    public HttpResponseListener(Activity activity, Request<?> request, HttpListener<T> httpCallback, boolean isLoading) {
        this.mActivity = activity;
        this.mRequest = request;
        this.msg = "";
        if (activity != null && isLoading) {
            mWaitDialog = new MProgressDialog();
        }
        this.callback = httpCallback;
    }

    /**
     * @param activity     context用来实例化dialog.
     * @param request      请求对象.
     * @param httpCallback 回调对象.
     */
    public HttpResponseListener(Activity activity, Request<?> request, HttpListener<T> httpCallback) {
        this.mActivity = activity;
        this.mRequest = request;
        this.callback = httpCallback;
    }

    /**
     * 开始请求, 这里显示一个dialog.
     */
    @Override
    public void onStart(int what) {
        if (mWaitDialog != null && !mActivity.isFinishing()) {
            if (TextUtils.isEmpty(msg)) {
                mWaitDialog.showProgress(mActivity);
            } else {
                mWaitDialog.showProgress(mActivity,msg);
            }
        }
    }

    /**
     * 结束请求, 这里关闭dialog.
     */
    @Override
    public void onFinish(int what) {
        if (mWaitDialog != null) {
            mWaitDialog.dismissProgress();
        }
    }

    /**
     * 成功回调.
     */
    @Override
    public void onSucceed(int what, Response<T> response) {
        if (callback != null) {
            // 这里判断一下http响应码，这个响应码问下你们的服务端你们的状态有几种，一般是200成功。
            // w3c标准http响应码：http://www.w3school.com.cn/tags/html_ref_httpmessages.asp
            if (response.responseCode() == 200) {
                callback.onSucceed(what, response);
            } else {
                callback.onFailed(what, response);
            }
        }
    }

    /**
     * 失败回调.
     */
    @Override
    public void onFailed(int what, Response<T> response) {
        Exception exception = response.getException();
        if (exception instanceof NetworkError) {// 网络不好
            MToast.makeTextShort(mActivity, "请检查网络");
        } else if (exception instanceof TimeoutError) {// 请求超时
            MToast.makeTextShort(mActivity, "请求超时，网络不好或者服务器不稳定");
        } else if (exception instanceof UnKnownHostError) {// 找不到服务器
            MToast.makeTextShort(mActivity, "未发现指定服务器，请切换网络后重试");
        } else if (exception instanceof URLError) {// URL是错的
            MToast.makeTextShort(mActivity, "URL错误");
        } else if (exception instanceof NotFoundCacheError) {
            // 这个异常只会在仅仅查找缓存时没有找到缓存时返回
            MToast.makeTextShort(mActivity, "没有找到缓存");
        } else {
            MToast.makeTextShort(mActivity, "未知错误");
        }
        Logger.e("错误：" + exception.getMessage());
        if (callback != null) {
            callback.onFailed(what, response);
        }
    }

}
