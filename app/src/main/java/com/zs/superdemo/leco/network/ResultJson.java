package com.zs.superdemo.leco.network;

import java.io.Serializable;

/**
 * Created by Administrator on 2016/7/20.
 * 请求结果
 */
public class ResultJson implements Serializable {

    /**
     * 成功
     */
    public static final int SUCCESS_CODE = 200;
    public static final int SESSION_FAILED = -201;
    public static final int USER_NO_BIND = -202;//三方登录未绑定用户
    /**
     * 失败
     */
    public static final int FAILED_CODE = -200;

    private int code;//状态
    private String msg;//原因
    private Object data;//数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "code : " + code + ", msg : " + msg + ", data : " + data;
    }

}
