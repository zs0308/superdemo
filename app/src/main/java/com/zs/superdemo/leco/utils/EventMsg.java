package com.zs.superdemo.leco.utils;


/**
 * Created by zs on 2018/1/2.
 * event bus message
 */

public class EventMsg {
    private int flag;

    public EventMsg(int flag) {
        this.flag = flag;
    }

    /**
     * 登录成功
     */
    public final static int USER_LOGIN = 1001;
//    private MobileUserVo mobileUserVo;
    /**
     * 收藏管理更新
     */
    public final static int COLLECT_MANAGER = 1002;
    private boolean isManager;
//    private TUser tUser;


    /**
     * 用户信息页更新
     */
    public final static int UPDATE_USER_INFO = 10031;

    /**
     * 更新收货地址列表
     *
     * @return
     */
    public final static int UPDATEADDRESS = 1004;

    /**
     * 退出登录
     *
     * @return
     */
    public final static int USER_EXIT_LOGIN = 1005;

    /**
     * 待付款页面刷新
     */
    public final static int REFRESH_ORDER_LIST_1 = 1006;
    /**
     * 所有订单
     */
    public final static int REFRESH_ORDER_LIST_ALL = 1007;
    /**
     * 动态发布完刷新
     */
    public final static int REFRESH_DYNAMIC = 1008;
    /**
     * 待发货页面刷新
     */
    public final static int REFRESH_ORDER_LIST_2 = 1009;
    /**
     * 待收货页面刷新
     */
    public final static int REFRESH_ORDER_LIST_3 = 1010;
    /**
     * 待安装页面刷新
     */
    public final static int REFRESH_ORDER_LIST_4 = 1011;
    /**
     * 待评价页面刷新
     */
    public final static int REFRESH_ORDER_LIST_5 = 1012;
    /**
     * 获取到推送client id
     */
    public final static int GET_CLIENTID = 1013;
    private String clientId = "";

    /**
     * 获取到推送client id
     */
    public final static int REFRESH_TC = 1014;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String mClientId) {
        clientId = mClientId;
    }
    public int getFlag() {
        return flag;
    }
    public void setFlag(int flag) {
        this.flag = flag;
    }
    public boolean isManager() {
        return isManager;
    }
    public void setManager(boolean manager) {
        isManager = manager;
    }

}
