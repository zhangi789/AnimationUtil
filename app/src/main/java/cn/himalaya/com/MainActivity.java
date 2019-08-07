package cn.himalaya.com;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.himalaya.com.base.BaseActivity;
import cn.himalaya.com.ui.FrameActivity;
import cn.himalaya.com.ui.PropertyActivity;
import cn.himalaya.com.ui.Tween2Activity;
import cn.himalaya.com.ui.TweenActivity;


/**
 * 动画集合
 * Android 动画分类
 * 传统动画 和属性动画
 * 传统动画：帧动画和补间动画
 * 帧动画:类似.gif   特别依赖UI完整性
 * 补间动画：补间动画又可以分为四种形式，分别是 alpha（淡入淡出），translate（位移），scale（缩放大小），rotate（旋转）。
 */
public class MainActivity extends BaseActivity {
    @BindView(R.id.mFrame)
    Button mFrame;
    @BindView(R.id.mTween)
    Button mTween;
    @BindView(R.id.mProperty)
    Button mProperty;

    @BindView(R.id.mCodeTween)
    Button mCodeTween;

    @Override
    protected int initLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void onResumes() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.mFrame, R.id.mTween, R.id.mProperty,R.id.mCodeTween})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            //帧动画
            case R.id.mFrame:
                startJump(MainActivity.this, FrameActivity.class);
                break;
            //补间动画 XML
            case R.id.mTween:

                startJump(MainActivity.this, TweenActivity.class);
                break;
                //属性动画
            case R.id.mProperty:
                startJump(MainActivity.this, PropertyActivity.class);
                break;

            //补间动画 代码实现
            case R.id.mCodeTween:
                startJump(MainActivity.this, Tween2Activity.class);
                break;
        }
    }


    public void startJump(Context packageContext, Class<?> cls) {
        Intent intent = new Intent(packageContext, cls);
        startActivity(intent);
        overridePendingTransition(R.anim.fade_center_in, R.anim.fade_center_out);
    }


}
