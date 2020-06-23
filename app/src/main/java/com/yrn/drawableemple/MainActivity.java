package com.yrn.drawableemple;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.yrn.drawableemple.util.DrawableUtil;

public class MainActivity extends AppCompatActivity {

    private TextView tvCodeSelector;
    private TextView tvCodeGradient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //动态设置点击效果
        tvCodeSelector = findViewById(R.id.tv_code_selector);
        tvCodeSelector.setBackground(DrawableUtil.addStateListBgDrawable(this, R.drawable.shape_base, R.drawable.shape_base_pressed));
        //动态实现渐变效果
        tvCodeGradient = findViewById(R.id.tv_code_gradient);
        tvCodeGradient.setBackground(DrawableUtil.addGradientBgDrawable(GradientDrawable.Orientation.LEFT_RIGHT, new int[]{getResources().getColor(R.color.colorAccent), getResources().getColor(R.color.colorRed)}));
    }


    public void tvOnClicker(View v) {
        Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
    }
}
