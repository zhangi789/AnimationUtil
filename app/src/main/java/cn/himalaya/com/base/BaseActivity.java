package cn.himalaya.com.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

/**
 * 项目名称:   动画练习
 * 创建者      张海洋
 * 创建时间    on 2019/8/6
 * 描述
 */
public abstract class BaseActivity extends AppCompatActivity {

    protected abstract int initLayout();

    protected abstract void initView();

    protected abstract void initData();

    //OnResume
    //处理一些界面再次进入展示逻辑
    protected abstract void onResumes();

    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(initLayout());
        context = this;
        //解决从图标进入app  app进入登陆界面
        if (!this.isTaskRoot()) {
            Intent intent = getIntent();
            if (intent != null) {
                String action = intent.getAction();
                if (intent.hasCategory(Intent.CATEGORY_LAUNCHER) && Intent.ACTION_MAIN.equals(action)) {
                    finish();
                    return;
                }
            }
        }
        ButterKnife.bind(this);
        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        onResumes();
    }










}
