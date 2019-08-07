package cn.himalaya.com.ui;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
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
 * @describe
 *帧动画是最容易实现的一种动画，这种动画更多的依赖于完善的UI资源，他的原理就是将一张张单独的图片连贯的进行播放，
从而在视觉上产生一种动画的效果；有点类似于某些软件制作gif动画的方式。
 *
 *
 */
public class FrameActivity extends BaseActivity {
    @BindView(R.id.mIv)
    ImageView mIv;
    @BindView(R.id.mStart)
    Button mStart;
    @BindView(R.id.mStop)
    Button mStop;
    AnimationDrawable animationDrawable;
    @Override
    protected int initLayout() {
        return R.layout.activity_frame;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        animationDrawable = BaseKit.initFrame(FrameActivity.this, mIv,R.drawable.frame_anim,false);

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

    @OnClick({R.id.mStart, R.id.mStop})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.mStart:


                BaseKit.openFrame(animationDrawable);
                break;
            case R.id.mStop:
                BaseKit.stopFrame(animationDrawable);
                break;
        }
    }
}
