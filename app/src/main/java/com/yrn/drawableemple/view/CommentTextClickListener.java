package com.yrn.drawableemple.view;

import android.view.View;

/**
 * Cod
 * <p>
 * Created by Xinhoo on 2020/5/18
 * Describe: 评论 点击、长按事件
 */
public interface CommentTextClickListener<T> {
    void onBlankClick(View view, T t);

    void onLongClick(View view, T t);
}
