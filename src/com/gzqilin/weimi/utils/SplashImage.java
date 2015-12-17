package com.gzqilin.weimi.utils;

import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

/**
 * 启动画面
 *
 * @author lsh
 */
public class SplashImage extends ImageView implements Animation.AnimationListener {
    //动画播放回调函数
    private Callback callback;

    public SplashImage(Context context) {
        this(context, android.R.drawable.ic_menu_report_image);
    }

    public SplashImage(Context context, int imageResource) {
        super(context);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        setLayoutParams(layoutParams);
        setBackgroundResource(imageResource);
        initAnimation(3000L);
    }

    protected void initAnimation(long delay) {
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(delay);
        animation.setFillAfter(true);
        animation.setAnimationListener(this);
        startAnimation(animation);
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public void onAnimationStart(Animation animation) {
        if (callback != null) {
            callback.onAnimationStart();
        }
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (callback != null) {
            callback.onAnimationEnd();
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }

    public interface Callback {

        void onAnimationStart();

        void onAnimationEnd();

    }

}

