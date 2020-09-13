package com.yrn.drawableemple.animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.yrn.drawableemple.R;

/**
 * DrawableEmple
 * <属性动画-Rotate--图片中心旋转>
 * Created by Xinhoo on 2020/8/21
 * Describe:
 */
public class AnimRotateActivity extends AppCompatActivity {

    private ImageView ivSending;
    private Animation rotateAnimation ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_rotate);
        ivSending = findViewById(R.id.img);
        rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);

    }
    //启动旋转
    public void  startRotate(View view){
        //代码实现
//        codeImp(ivSending);
        //使用anim_xxxx.xml配置文件实现
        if (view.getId() == R.id.tv_start) {
            if (rotateAnimation != null) {
                ivSending.startAnimation(rotateAnimation);
            }else{
                rotateAnimation= AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
                ivSending.setAnimation(rotateAnimation);
                ivSending.setAnimation(rotateAnimation);
            }
        }
    }
    //停止旋转
    public void stopRotate(View view) {
        ivSending.clearAnimation();
    }


    /**
     * 代码实现 中心旋转动画
     * @param view
     */
    private void codeImp(View view){
        RotateAnimation rotate  = new RotateAnimation(0f, 360f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        LinearInterpolator lin = new LinearInterpolator();
        rotate.setInterpolator(lin);
        rotate.setDuration(500);//设置动画持续周期
        rotate.setRepeatCount(-1);//设置重复次数
        rotate.setFillAfter(true);//动画执行完后是否停留在执行完的状态
        rotate.setStartOffset(10);//执行前的等待时间
        view.clearAnimation();
        view.setAnimation(rotate);
        view.startAnimation(rotate);
    }
}
