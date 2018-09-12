package com.zs.superdemo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.blankj.utilcode.util.AppUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.PhoneUtils;
import com.blankj.utilcode.util.ScreenUtils;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zs.superdemo.leco.utils.MLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * code no bug a
 */
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv_hello)
    TextView tvHello;
    @Bind(R.id.recycler)
    RecyclerView recycler;

    private List<String> list = new ArrayList<>();

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Log.e("zs", "hiyou SHA1=" + AppUtils.getAppSignatureSHA1("com.leco.haiyoufurniture"));
        list.add("跳至发送短信界面");
        list.add("截屏");
        list.add("打开网络设置界面");
        list.add("hello item 4");
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
                        MLog.e("click click click");
                        switch (position) {
                            case 0://跳至发送短信界面
                                PhoneUtils.sendSms("10000","108");
                                break;
                            case 1://截屏
                                ScreenUtils.screenShot(MainActivity.this);
                                break;
                            case 2://打开网络设置界面
                                NetworkUtils.openWirelessSettings();
                                break;
                            case 3:
                                break;
                        }
                    }
                });
            }

        });

        boolean is4G = NetworkUtils.is4G();
        MLog.e("is4G=" + is4G);

        PhoneUtils.getIMEI();
    }
}
