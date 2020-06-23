package com.yrn.drawableemple.util;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

/**
 * DrawableEmple
 * <p>
 * Created by Xinhoo on 2020/6/10
 * Describe:
 */

public class DrawableUtil {
    /**
     * 代码实现 drawable中selector的xml功能
     * @param mContext 上下文
     * @param idNormal  正常状态 资源id
     * @param idPressed 点击状态 资源id
     * @return
     */
    public static StateListDrawable addStateListBgDrawable(Context mContext, int idNormal, int idPressed) {
        StateListDrawable stateListDrawable = new StateListDrawable();
//        stateListDrawable.addState(new int[]{android.R.attr.state_selected},mContext.getResources().getDrawable(idPressed));
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed},mContext.getResources().getDrawable(idPressed));
//        stateListDrawable.addState(new int[]{android.R.attr.state_enabled},mContext.getResources().getDrawable(idPressed));
        stateListDrawable.addState(new int[]{},mContext.getResources().getDrawable(idNormal));
        return stateListDrawable;
    }

    /**
     * 代码实现，背景渐变
     * @param orientation 渐变方向
     * @param colors 渐变颜色集合
     * @return
     */
    public static GradientDrawable addGradientBgDrawable(GradientDrawable.Orientation orientation, int[] colors) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(orientation);//定义渐变方向
        gradientDrawable.setColors(colors);//渐变颜色数组

        return gradientDrawable;
    }
}
