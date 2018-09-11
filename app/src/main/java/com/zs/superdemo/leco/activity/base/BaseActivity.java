package com.zs.superdemo.leco.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.jaeger.library.StatusBarUtil;
import com.zs.superdemo.R;

import butterknife.ButterKnife;

/**
 * Created by leco on 2017/4/12.
 */

public class BaseActivity extends AppCompatActivity {

//    protected Subscription mSubscription;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //用图片  compile 'com.jaeger.statusbaruitl:library:1.3.6'
//        StatusBarUtil.setTranslucentForImageViewInFragment(this, 0, null);
        //纯颜色，默认alpha 111 v19 0dp
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            StatusBarUtil.setColor(this, getResources().getColor(R.color.white), 0);
//        }else {
//            StatusBarUtil.setColor(this, getResources().getColor(R.color.white), 50);
//        }
        StatusBarUtil.setColor(this, getResources().getColor(R.color.theme),0);
    }

    protected boolean useThemestatusBarColor = false;//是否使用特殊的标题栏背景颜色，android5.0以上可以设置状态栏背景色，如果不使用则使用透明色值
    protected boolean useStatusBarColor = true;//是否使用状态栏文字和图标为暗色，如果状态栏采用了白色系，则需要使状态栏和图标为暗色，android6.0以上可以设置

    protected void setStatusBar() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {//5.0及以上
//            View decorView = getWindow().getDecorView();
//            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
//            decorView.setSystemUiVisibility(option);
//            //根据上面设置是否对状态栏单独设置颜色
//            if (useThemestatusBarColor) {
//                getWindow().setStatusBarColor(getResources().getColor(R.color.colorTheme));
//            } else {
//                getWindow().setStatusBarColor(Color.TRANSPARENT);
//            }
//        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {//4.4到5.0
//            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
//            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
//        }
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && !withoutUseStatusBarColor) {//android6.0以后可以对状态栏文字颜色和图标进行修改

        //设置状态栏标题字体为黑色
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {//android6.0以后可以对状态栏文字颜色和图标进行修改
////            getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
//        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

}
