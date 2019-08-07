package cn.himalaya.com.ui;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.himalaya.com.R;
import cn.himalaya.com.base.BaseActivity;

/**
 * @author 张海洋
 * @Date on 2019/08/06.
 * @org 上海..科技有限公司
 * @describe
 */
public class PropertyActivity extends BaseActivity {
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
        return R.layout.activity_protry;
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

                ObjectAnimator anim = ObjectAnimator.ofFloat(mIv, "alpha", 1.0f, 0.8f, 0.6f, 0.4f, 0.2f, 0.0f);
                anim.setRepeatCount(0);
                anim.setRepeatMode(ObjectAnimator.REVERSE);
                anim.setDuration(1000);
                anim.start();


                break;
            case R.id.mScale:

                ObjectAnimator anim2 = ObjectAnimator.ofFloat(mIv, "alpha", 0.0f, 1.0f);
                ObjectAnimator scaleXAnim = ObjectAnimator.ofFloat(mIv, "scaleX", 0.0f, 1.0f);
                ObjectAnimator scaleYAnim = ObjectAnimator.ofFloat(mIv, "scaleY", 0.0f, 1.0f);
                AnimatorSet set = new AnimatorSet();
                set.playTogether( anim2,scaleXAnim, scaleYAnim);
//                set.playSequentially(alphaAnim, scaleXAnim, scaleYAnim, rotateAnim, transXAnim, transYAnim);
                set.setDuration(3000);
                set.start();

                break;
            case R.id.mRotate:

                ObjectAnimator rotateAnim = ObjectAnimator.ofFloat(mIv, "rotation", 0, 360);
            //    ObjectAnimator rotateAnim = ObjectAnimator.ofFloat(mIv, "rotation", 0, 360, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.2F);
                rotateAnim.setRepeatCount(0);
                rotateAnim.setRepeatMode(ObjectAnimator.RESTART);
                rotateAnim.setDuration(3000);
                rotateAnim.start();

                break;
            case R.id.mTranslate:

                ObjectAnimator transXAnim = ObjectAnimator.ofFloat(mIv, "translationX", 100, 400);
                @SuppressLint("ObjectAnimatorBinding") ObjectAnimator transYAnim = ObjectAnimator.ofFloat(mIv, "tranlsationY", 100, 750);
              /*  ObjectAnimator anim = ObjectAnimator.ofFloat(mIv, "rotation", 0f, 360f);
                anim.setDuration(1000);
                anim.start();*/


                AnimatorSet set2 = new AnimatorSet();
                set2.playTogether(  transXAnim/*, transYAnim*/);
//                set.playSequentially(alphaAnim, scaleXAnim, scaleYAnim, rotateAnim, transXAnim, transYAnim);
                set2.setDuration(3000);
                set2.start();
                break;
        }
    }
}
