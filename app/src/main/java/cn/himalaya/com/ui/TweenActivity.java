package cn.himalaya.com.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
 * @describe    补间动画实现   Xml 方式实现
 */
public class TweenActivity extends BaseActivity {
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
    Animation mAlphaAnimation;
    Animation mTranslateAnimation;

    /*  Animation mAlphaAnimation;
      Animation mAlphaAnimation;*/
    @Override
    protected int initLayout() {
        return R.layout.activity_tween;
    }

    @Override
    protected void initView() {
       // mAlphaAnimation = BaseKit.initTween(TweenActivity.this,mIv,R.anim.alpha_anim,false,0,1);
    }

    @Override
    protected void initData() {



       /* mTranslateAnimation = BaseKit.initTween(TweenActivity.this, mIv, R.anim.translate_anim);
        mAlphaAnimation = BaseKit.initTween(TweenActivity.this, mIv, R.anim.alpha_anim);
        mAlphaAnimation = BaseKit.initTween(TweenActivity.this, mIv, R.anim.alpha_anim);*/
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
                Log.i("GGG","点击");
             //   mAlphaAnimation = BaseKit.initTween(TweenActivity.this,R.anim.alpha_anim,false,2,1);
                BaseKit.initTween(TweenActivity.this,mIv,R.anim.alpha_anim,false,2,Animation.RESTART);

                break;
            case R.id.mScale:
                BaseKit.initTween(TweenActivity.this,mIv,R.anim.scale_anim1,false,0,Animation.RESTART);
                break;
            case R.id.mRotate:
                BaseKit.initTween(TweenActivity.this,mIv,R.anim.translate_anim,true,0,Animation.RESTART);
                break;
            case R.id.mTranslate:
                BaseKit.initTween(TweenActivity.this,mIv,R.anim.rotate_anim,false,0,Animation.RESTART);
                break;
        }
    }
}
