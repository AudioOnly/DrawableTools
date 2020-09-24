package com.yrn.drawableemple.animation;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yrn.drawableemple.R;

/**
 * DrawableEmple
 * <属性动画-ObjectAnimator 实现了，四大效果（透明，缩放，平移，旋转）:
 * 步骤：
 * 实现过程基本可以归纳为
 * 创建 AnimatorSet 对象
 * 设置，变化发生的轴心（部分需要）
 * 设置所需要发生改变的动画（通常在 playTogether() 方法中）
 * 开启动画>
 * Created by Xinhoo on 2020/8/21
 * Describe:
 */
public class ObjectAnimatorActivity extends AppCompatActivity {

    //透明
    private TextView tvAlpha;
    //缩放
    private TextView tvScale;
    //平移
    private TextView tvTranslation;
    //旋转
    private TextView tvRotate;

    //xml 实现动画
    private ImageView ivXmlAnimator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator);
        tvAlpha = findViewById(R.id.tv_1);
        tvScale = findViewById(R.id.tv_2);
        tvTranslation = findViewById(R.id.tv_3);
        tvRotate = findViewById(R.id.tv_4);

        ivXmlAnimator = findViewById(R.id.iv_xml_animator);

        initAnimator();

        Animator xmlAnimator = AnimatorInflater.loadAnimator(this, R.animator.objcet_animator_group);
        xmlAnimator.setTarget(ivXmlAnimator);
        xmlAnimator.start();
    }

    private void initAnimator(){
        //透明
        AnimatorSet alphaAnimatorSet = new AnimatorSet();
        ObjectAnimator alphaObjectAnimator = ObjectAnimator.ofFloat(tvAlpha, "alpha", 1f, 0f,1f);
        alphaObjectAnimator.setDuration(5000);
        alphaAnimatorSet.playTogether(alphaObjectAnimator);
        alphaAnimatorSet.start();
        //缩放
        AnimatorSet scaleAnimator = new AnimatorSet();
        //设置 缩放的 中心点位置，
//        tvScale.setPivotX(tvScale.getWidth() + 250);
//        tvScale.setPivotX(tvScale.getHeight() + 250);
        scaleAnimator.playTogether(
                ObjectAnimator.ofFloat(tvScale, "scaleX", 1, 0, 1).setDuration(2000),
                ObjectAnimator.ofFloat(tvScale, "scaleY", 1, 0, 1).setDuration(2000)
        );
        scaleAnimator.start();
        //平移
        AnimatorSet translationAnimatorSet = new AnimatorSet();
        Log.e("TAG", "tvTranslation---width:" + tvTranslation.getWidth() + "--tvTranslation---height:" + tvTranslation.getHeight());
        translationAnimatorSet.playTogether(
                ObjectAnimator.ofFloat(tvTranslation, "translationX", 0,200,0)
                        .setDuration(2000),
                ObjectAnimator.ofFloat(tvTranslation, "translationY", 0,200,0)
                        .setDuration(2000)
        );
        translationAnimatorSet.start();

        //旋转
        AnimatorSet rotateAnimationSet = new AnimatorSet();
        rotateAnimationSet.playTogether(
                ObjectAnimator.ofFloat(tvRotate, "rotation",0, 360)
                        .setDuration(2000)
        );
        rotateAnimationSet.start();
    }

}
