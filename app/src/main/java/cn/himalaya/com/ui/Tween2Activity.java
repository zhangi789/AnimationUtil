package cn.himalaya.com.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.himalaya.com.R;
import cn.himalaya.com.base.BaseActivity;
import cn.himalaya.com.util.BaseKit;

/**
 * @author 张海洋
 * @Date on 2019/08/06.
 * @org 上海..科技有限公司
 * @describe 补间动画实现   代码实现
 */
public class Tween2Activity extends BaseActivity {
    @BindView(R.id.mAlpha)
    Button mAlpha;
    @BindView(R.id.mScale)
    Button mScale;
    @BindView(R.id.mRotate)
    Button mRotate;
    @BindView(R.id.mTranslate)
    Button mTranslate;
    @BindView(R.id.mIv)
    ImageView mIv;

    @Override
    protected int initLayout() {
        return R.layout.activity_tween;
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

    @OnClick({R.id.mAlpha, R.id.mScale, R.id.mRotate, R.id.mTranslate})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mAlpha:
                BaseKit.alphaAnimation(mIv,false,0,Animation.RESTART);

                break;
            case R.id.mScale:
                BaseKit.scaleAnimation(mIv,false,0,Animation.RESTART);

                break;
            case R.id.mRotate:
                BaseKit.rotateAnimation(mIv,false,0,Animation.RESTART);

                break;
            case R.id.mTranslate:
                BaseKit.translateAnimation(mIv,false,0,Animation.RESTART);
                break;
        }
    }
}
