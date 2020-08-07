package com.yrn.drawableemple;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.yrn.drawableemple.app.MyApp;
import com.yrn.drawableemple.autosize.AutoSizeActivity;
import com.yrn.drawableemple.util.DrawableUtil;

public class MainActivity extends AppCompatActivity {

    private TextView tvCodeSelector;
    private TextView tvCodeGradient;
    private TextView tvScreenDisplay;

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

        //屏幕分辨率
        tvScreenDisplay = findViewById(R.id.tv_get_screen_dispaly);
    }


    public void tvOnClicker(View v) {
        Toast.makeText(this, "点击", Toast.LENGTH_SHORT).show();
    }

    public void tvGetScreenDisplay(View v) {
        StringBuilder sb = new StringBuilder();

        //方法一：
        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        int width = wm.getDefaultDisplay().getWidth();
        int height = wm.getDefaultDisplay().getHeight();
        sb.append("方法一（废弃方法：getWidth）：\n ");
        String wStr = "Width:" + width + "\n";
        sb.append(wStr);
        String hStr = "height:" + height + "\n";
        sb.append(hStr);
        sb.append("------------------------------------------\n");
        //方法二：
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int dm_Width = displayMetrics.widthPixels;
        int dm_Height = displayMetrics.heightPixels;
        float dm_Density = displayMetrics.density;
        //获取当前手机的dpi
        int dm_dpi = displayMetrics.densityDpi;
        float dm_scaleDensity = displayMetrics.scaledDensity;
        sb.append("方法二：\n");
        String dmWidthStr = "Width:" + dm_Width + "\n";
        sb.append(dmWidthStr);
        String dmHeightStr = "Height:" + dm_Height + "\n";
        sb.append(dmHeightStr);
        String densityStr = "密度：" + dm_Density + "\n";
        sb.append(densityStr);
        String dmDpiStr = "DM_DPI:" + dm_dpi + "\n";
        sb.append(dmDpiStr);
        String dmScaleDensityStr = "DM_SCALEDENSITY:" + dm_scaleDensity + "\n";
        sb.append(dmScaleDensityStr);
        float dm_xDpi = displayMetrics.xdpi;
        String dm_xDpiStr = "DM_XDPI:" + dm_xDpi + "\n";
        sb.append(dm_xDpiStr);
        float dm_yDpi = displayMetrics.ydpi;
        String dm_yDpiStr = "DM_YDPI:" + dm_yDpi + "\n";
        sb.append(dm_yDpiStr);
        //计算可显示屏幕尺寸（英尺）
        double diagonal = Math.sqrt(Math.pow(width, 2) + Math.pow(height, 2));
        double screen = diagonal / dm_dpi;
        String screenStr = "手机对角线尺寸（英尺）：" + screen + "\n";
        sb.append(screenStr);
        sb.append("------------------------------------------\n");
        //方法三
        Point point = new Point();
        getWindowManager().getDefaultDisplay().getSize(point);
        dmWidthStr = "Width:" + (point.x) + "\n";
        dmHeightStr = "Height:" + (point.y) + "\n";
        sb.append("方法三：\n");
        sb.append(dmWidthStr);
        sb.append(dmHeightStr);
        sb.append("------------------------------------------\n");
        //计算dpi/density
        double dpi = diagonal / screen;
        double density = dpi / 160;
        sb.append("自己计算dpi/density \n");
        sb.append("计算dpi：" + dpi + "\n");
        sb.append("计算myDensity：" + density + "\n");
        sb.append("------------------------------------------\n");

        final DisplayMetrics systemDm = Resources.getSystem().getDisplayMetrics();
        final DisplayMetrics appDm = MyApp.getApplication().getResources().getDisplayMetrics();
        final DisplayMetrics activityDm = getResources().getDisplayMetrics();

        sb.append("使用 AutoSize 之后：\n");
        sb.append("systemDm.density：" + systemDm.density + "\n");
        sb.append("systemDm.densityDpi：" + systemDm.densityDpi + "\n");
        sb.append("------------------------------------------\n");
        sb.append("appDm.density：" + appDm.density + "\n");
        sb.append("appDm.densityDpi：" + appDm.densityDpi + "\n");
        sb.append("------------------------------------------\n");
        sb.append("activityDm.density：" + activityDm.density + "\n");
        sb.append("activityDm.densityDpi：" + activityDm.densityDpi + "\n");
        sb.append("------------------------------------------\n");

        //结果
        tvScreenDisplay.setText(sb.toString());


    }

    public void tv2AutoSize(View v){
        startActivity(new Intent(MainActivity.this, AutoSizeActivity.class));
    }


}
