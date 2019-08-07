package cn.himalaya.com.util;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.AnimRes;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import java.security.SecureRandom;

import cn.himalaya.com.R;

/**
 * @author 张海洋
 * @Date on 2019/08/06.
 * @org 上海..科技有限公司
 * @describe
 */
public class BaseKit {


    /**
     * 帧动画初始化
     * <p>
     * 开启 和关闭 XML 实现方式
     */

    /**
     * @param mContext
     * @param mIv
     * @param id
     * @param oneShot  控制是否单次播放
     * @return
     */
    public static AnimationDrawable initFrame(Context mContext, ImageView mIv, int id, boolean oneShot) {
        AnimationDrawable mAnimationDrawable = (AnimationDrawable) mContext.getResources().getDrawable(id);
        mIv.setImageDrawable(mAnimationDrawable);
        mAnimationDrawable.setOneShot(oneShot);
        return mAnimationDrawable;
    }

    public static void openFrame(AnimationDrawable mAnimationDrawable) {
        if (mAnimationDrawable != null && !mAnimationDrawable.isRunning()) {
            mAnimationDrawable.start();
        }
    }

    public static void stopFrame(AnimationDrawable mAnimationDrawable) {
        if (mAnimationDrawable != null && mAnimationDrawable.isRunning()) {

            mAnimationDrawable.stop();
        }
    }


    /**
     * 初始化补间动画
     *
     * @param context
     * @param mIv
     * @param id          资源id 通常R.anim.alpha_anim
     * @param fillAfter   控制动画后是否显示原图
     * @param repeatCount 设置重复执行的次数
     * @param repeatMode  设置重复执行的模式
     * @return
     */
    public static Animation initTween(Context context, ImageView mIv, @AnimRes int id, boolean fillAfter, int repeatCount, int repeatMode) {
        Animation animator = AnimationUtils.loadAnimation(context, id);
        animator.setFillAfter(fillAfter);
        animator.setRepeatCount(repeatCount);
        animator.setRepeatMode(repeatMode);
        mIv.startAnimation(animator);
        return animator;
    }


    /**
     * 代码实现
     * Java代码对应动画了
     * AlphaAnimation  渐变透明度动画效果
     * ScaleAnimation  渐变尺寸伸缩动画效果
     * TranslateAnimation  画面转换位置移动动画效果
     * RotateAnimation 画面转移旋转动画效果
     */


    public static void alphaAnimation(ImageView mIv, boolean fillAfter, int repeatCount, int repeatMode) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(3000);
        alphaAnimation.setRepeatCount(repeatCount);
        alphaAnimation.setRepeatMode(repeatMode);
        alphaAnimation.setFillAfter(fillAfter);
        alphaAnimation.setInterpolator(new LinearInterpolator());
        alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mIv.startAnimation(alphaAnimation);
    }


    /**
     * 相对自身
     * @param mIv
     * @param fillAfter
     * @param repeatCount
     * @param repeatMode
     */
    public static void scaleAnimation(ImageView mIv, boolean fillAfter, int repeatCount, int repeatMode) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0f, 1f, 0f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(2000); //动画持续时间
        scaleAnimation.setInterpolator(new AccelerateInterpolator()); //设置为加速
        scaleAnimation.setFillAfter(fillAfter); //结束动画之后，是否停留在最后
        scaleAnimation.setRepeatCount(repeatCount); //重复的次数
        mIv.startAnimation(scaleAnimation);
    }






    public  static void rotateAnimation(ImageView mIv, boolean fillAfter, int repeatCount, int repeatMode) {
        RotateAnimation rotateAnimation = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.2F);
        rotateAnimation.setFillAfter(fillAfter);
        rotateAnimation.setDuration(2000);
        rotateAnimation.setRepeatMode(repeatMode);
        rotateAnimation.setRepeatCount(repeatCount);
        rotateAnimation.setDetachWallpaper(true);
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mIv.startAnimation(rotateAnimation);

    }






  public  static   void translateAnimation(final ImageView mIv, boolean fillAfter, int repeatCount, int repeatMode) {
        /**
         * 此方法默认的都是使用绝对布局Animation.ABSOLUTE的
         */
        TranslateAnimation translateAnimation = new TranslateAnimation(0, 300, 0, 300);

        /**
         * 下面构造方法是可以指定开始位置和结束位置依赖于哪一个布局参数来测量移动的
         * 一下是各个参数的解释：
         *Animation.ABSOLUTE：绝对位置，即距离屏幕远点（左上角）的位置
         *Animation.RELATIVE_TO_SELF：相对于自身的距离
         *Animation.RELATIVE_TO_PARENT：现对于控件父布局的距离
         */
        TranslateAnimation translateAnimation1 = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_PARENT, 300,
                Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_PARENT, 300);

        translateAnimation.setDuration(3000); //动画持续时间
        translateAnimation.setFillAfter(fillAfter); //动画之后，停留在最后面
        translateAnimation.setRepeatMode(repeatMode);
        translateAnimation.setRepeatCount(repeatCount);

        //设置动画的监听
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                scaleAnimation(mIv,false,0,Animation.RESTART);//动画完成之后，再调用另外一个方法，继续透明度的动画
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mIv.startAnimation(translateAnimation);
    }


    /**
     *   属性动画   ObjectAnimator
     */

    public static  void property1(){


    }




}
