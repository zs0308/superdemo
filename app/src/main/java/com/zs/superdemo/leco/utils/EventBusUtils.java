package com.zs.superdemo.leco.utils;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;

/*
    引入：implementation 'org.greenrobot:eventbus:3.0.0'
    ThreadMode.MAIN          不管从哪个线程发出的事件，MAIN模式都会在UI（主线程）线程执行
    ThreadMode.POSTING       事件从哪个线程发布出来的就会在该线程中运行
    ThreadMode.BACKGROUND    如果发送事件的线程是UI线程，则重新创建新的子线程执行，因此不能执行更新UI的操作
    ThreadMode.ASYNC         不管从哪个线程发出的事件，ASYNC模式都会创建一个新的子线程来执行

    默认就是非粘性事件，如果是粘性事件，只需要在事件的注解上面加上 sticky = true

    粘性事件，在注解上加上 priority = 优先级数（int值）   priority = 1

-----------------------EventMsg--------------------------------
    //注册
    EventBusUtils.register(this);
  //处理event
    @Subscribe(threadMode = ThreadMode.MAIN,priority = 1)
    public void onEventMainThread(EventMsg event) {
        LecoUtils.Log("threadMode = ThreadMode.MAIN");
        switch (event.getFlag()){
            case EventMsg.EVENTTEST1:
                LecoUtils.Log("EVENTTEST1 EVENTTEST1");
                break;

        }
    }

    //处理event bus粘性事件
    @Subscribe(threadMode = ThreadMode.POSTING,sticky = true,priority = 2)
    public void onEventStickyThread(CarCalculatorDetail.MessageEvent event) {
        LecoUtils.Log("ThreadMode.POSTING");
        LecoUtils.showToast(getBaseContext(), event.getMsg()+"POSTING");
        chepaiEt.setText(event.getMsg());
    }

    //反注册
    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtils.unregister(this);
    }
    //---------------------------------------
    //第二个页面发送
    EventBusUtils.post(new EventMsg(EventMsg.UPDATE_XUBAO_LIST));
    */

/**
 * 作者： lcw on 2016/7/7.
 * 博客： http://blog.csdn.net/lsyz0021/
 */
public class EventBusUtils {

    private static final String TAG = "EventBusUtils";

    private EventBusUtils() {
    }

    /**
     * 注册EventBus
     *
     * @param subscriber 订阅者对象
     */
    public static void register(Object subscriber) {
        if (!EventBus.getDefault().isRegistered(subscriber)) {
            Log.e(TAG, "register: 注册成功");
            EventBus.getDefault().register(subscriber);
        } else {
            Log.e(TAG, "register: 注册失败");
        }
    }

    /**
     * 取消注册EventBus
     *
     * @param subscriber 订阅者对象
     */
    public static void unregister(Object subscriber) {
        EventBus.getDefault().unregister(subscriber);
    }

    /**
     * 发布订阅事件
     *
     * @param event 事件对象
     */
    public static void post(Object event) {
        EventBus.getDefault().post(event);
    }

    /**
     * 发布粘性订阅事件
     *
     * @param event 事件对象
     */
    public static void postSticky(Object event) {
        EventBus.getDefault().postSticky(event);
    }

    /**
     * 移除指定的粘性订阅事件
     *
     * @param eventType class的字节码，例如：String.class
     */
    public static <T> void removeStickyEvent(Class<T> eventType) {
        T stickyEvent = EventBus.getDefault().getStickyEvent(eventType);
        if (stickyEvent != null) {
            EventBus.getDefault().removeStickyEvent((T) stickyEvent);
        }
    }

    /**
     * 移除所有的粘性订阅事件
     */
    public static void removeAllStickyEvents() {
        EventBus.getDefault().removeAllStickyEvents();
    }

    /**
     * 取消事件传送
     *
     * @param event 事件对象
     */
    public static void cancelEventDelivery(Object event) {
        EventBus.getDefault().cancelEventDelivery(event);
    }
}
