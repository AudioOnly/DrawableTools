package com.yrn.drawableemple.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;

import com.yrn.drawableemple.R;
import com.yrn.drawableemple.bean.CommentModel;

/**
 * Cod
 * <p>
 * Created by Xinhoo on 2020/5/18
 * Describe: 评论自定义View
 */
public class CommentTextView extends AppCompatTextView {

    private TextView instance;
    private Context mContext;
    //    private StyleSpan boldSpan;
    //回复者 点击事件
    private ClickableSpan reviewSpan;
    //被回复者 点击事件
    private ClickableSpan replySpan;
    //亮蓝色
    private ForegroundColorSpan blueSpan;
    //显示评论者名称
    private boolean isShowCommentName = true;

    //评论状态
    private boolean isDel = false;

    public CommentTextView(Context context) {
        super(context);
        mContext = context;
        initView();
    }

    public CommentTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initView();
    }

    public CommentTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initView();
    }




    private void initView() {
        instance = this;
        setHighlightColor(getResources().getColor(R.color.transparent));
        setMovementMethod(LinkMovementMethod.getInstance());
        reviewSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                CommentModel model1 = (CommentModel) widget.getTag();
                model1.setClickReplay(false);
                widget.setTag(model1);

            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
//                ds.setTypeface(Typeface.DEFAULT_BOLD);
                ds.setTypeface(Typeface.DEFAULT);
                ds.setUnderlineText(false);
                ds.setColor(getResources().getColor(R.color.like_user_color));
            }
        };
        replySpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                CommentModel model1 = (CommentModel) widget.getTag();
                model1.setClickReplay(true);
                widget.setTag(model1);

            }

            @Override
            public void updateDrawState(@NonNull TextPaint ds) {
                super.updateDrawState(ds);
//                ds.setTypeface(Typeface.DEFAULT_BOLD);
                ds.setTypeface(Typeface.DEFAULT);
                ds.setUnderlineText(false);
                ds.setColor(getResources().getColor(R.color.like_user_color));
            }
        };
        //默认蓝色
        blueSpan = new ForegroundColorSpan(getResources().getColor(R.color.like_user_color));
    }

    /**
     * 点击事件
     * @param commentTextClickListener
     */
    public void setCommentTextClickListener(CommentTextClickListener commentTextClickListener) {
        this.commentTextClickListener = commentTextClickListener;
    }

    private CommentTextClickListener commentTextClickListener;
    private boolean isMove = false;
    private float lastX;
    private float lastY;
    //标记点击的ClickableSpan的起始位置
    private int mStart = -1;
    private int mEnd = -1;
    //计数（长按操作）
    private int leftTime;
    private android.os.Handler handler = new android.os.Handler();
    private Runnable countDownRunnable = new Runnable() {
        public void run() {
            leftTime--;
            if (leftTime == -1) {
                // 触发长按事件
                if (commentTextClickListener != null && !isMove) {
                    CommentModel model1 = (CommentModel) getTag();
                    commentTextClickListener.onLongClick(instance, model1);
                }
            } else {
                //100毫秒执行一次 超过500毫秒就说明触发长按
                handler.postDelayed(this, 100);
            }
        }
    };

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        boolean result = super.onTouchEvent(event);

        int downBgColor = getResources().getColor(R.color.friend_space_click_color);
        int upBgColor = Color.TRANSPARENT;
        int action = event.getAction();
        Log.e("yrn", "Action===" + action);

        int x = (int) event.getX();
        int y = (int) event.getY();
        if (action == MotionEvent.ACTION_DOWN) {
            lastX = event.getX();
            lastY = event.getY();
            isMove = false;
        }
        if (action == MotionEvent.ACTION_CANCEL || action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_MOVE) {
            float distanceX = Math.abs(lastX - event.getX());
            float distanceY = Math.abs(lastY - event.getY());
            if (distanceX > 1.5f || distanceY > 1.5f) {
                isMove = true;
            }
        }
        x -= getTotalPaddingLeft();
        y -= getTotalPaddingTop();

        x += getScrollX();
        y += getScrollY();

        Layout layout = getLayout();
        int line = layout.getLineForVertical(y);
        int off = layout.getOffsetForHorizontal(line, x);
        CharSequence text = getText();
        if (TextUtils.isEmpty(text) || !(text instanceof Spannable)) {
            return result;
        }
        Spannable buffer = (Spannable) text;
        ClickableSpan[] link = buffer.getSpans(off, off, ClickableSpan.class);
        if (link.length != 0) {
            if (action == MotionEvent.ACTION_DOWN) {
                mStart = buffer.getSpanStart(link[0]);
                mEnd = buffer.getSpanEnd(link[0]);
                if (mStart >= 0 && mEnd >= mStart) {
                    buffer.setSpan(new BackgroundColorSpan(downBgColor), mStart, mEnd,
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            } else if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
                if (mStart >= 0 && mEnd >= mStart) {
                    buffer.setSpan(new BackgroundColorSpan(isDel ? downBgColor : upBgColor), mStart, mEnd,
                            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    mStart = -1;
                    mEnd = -1;
                }
            }
            return true;
        } else {
            if (mStart >= 0 && mEnd >= mStart) {
                buffer.setSpan(new BackgroundColorSpan(isDel ? downBgColor : upBgColor), mStart, mEnd,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                mStart = -1;
                mEnd = -1;
            }
            if (action == MotionEvent.ACTION_DOWN) {
                setBackgroundColor(downBgColor);
                //开始计数
                leftTime = 5;
                handler.post(countDownRunnable);
                return true;
            } else if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
                setBackgroundColor(isDel ? downBgColor : upBgColor);
                //如果没有调用长按 调用点击整个的监听
                if (leftTime > -1) {
                    leftTime = 10;
                    handler.removeCallbacks(countDownRunnable);//移除统计
                    if (commentTextClickListener != null && !isMove) {
                        CommentModel model = (CommentModel) getTag();
                        commentTextClickListener.onBlankClick(this, model);
                    }
                } else {
                    return true;
                }
            } else if (action == MotionEvent.ACTION_MOVE) {
                if (isMove) {
                    setBackgroundColor(isDel ? downBgColor : upBgColor);
                }
            }
            Selection.removeSelection(buffer);
            return true;
        }
    }

    public void setShowCommentName(boolean showCommentName) {
        isShowCommentName = showCommentName;
    }

    /**
     * 设置回复的可点击文本
     *
     * @param model
     * @return
     */
    public void setReply(CommentModel model) {
        isDel = model.getCommentStatus() == 2;
        if (isDel) {
            setText("");
            setTag(model);
            append(getResources().getString(R.string.moment_comment_deleted));
            setBackgroundColor(Color.argb(99, 204, 204, 204));
            return;
        }
        setBackgroundColor(getResources().getColor(R.color.transparent));
        if (isShowCommentName) {
            setText("");
            setTag(model);
            String reviewName = model.getReviewUName();
            SpannableStringBuilder stylesBuilder;
            String str;
            if (!TextUtils.isEmpty(model.getReplyUName())) {
                String replyName = model.getReplyUName();
                str = reviewName + getResources().getString(R.string.moment_comment_reply) + replyName + "：" + model.getReviewContent();
                int reviewStart = str.indexOf(reviewName);
                int replyStart = str.indexOf(replyName);
                stylesBuilder = new SpannableStringBuilder(str);
                stylesBuilder.setSpan(reviewSpan, reviewStart, reviewStart + reviewName.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

                if (TextUtils.isEmpty(model.getReplyUid())) {
                    stylesBuilder.setSpan(blueSpan, replyStart, replyStart + replyName.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                } else {
                    stylesBuilder.setSpan(replySpan, replyStart, replyStart + replyName.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            } else {
                str = reviewName + "：" + model.getReviewContent();
                int reviewStart = str.indexOf(reviewName);
                stylesBuilder = new SpannableStringBuilder(str);
                stylesBuilder.setSpan(reviewSpan, reviewStart, reviewStart + reviewName.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            }
            append(stylesBuilder);
        } else {
            setText("");
            setTag(model);
            SpannableStringBuilder stylesBuilder;
            String str;
            if (!TextUtils.isEmpty(model.getReplyUName())) {//回复评论
                String replyName = model.getReplyUName();
                str = getResources().getString(R.string.moment_comment_reply) + replyName + "：" + model.getReviewContent();
                int replyStart = str.indexOf(replyName);
                stylesBuilder = new SpannableStringBuilder(str);
                if (TextUtils.isEmpty(model.getReplyUid())) {
                    stylesBuilder.setSpan(blueSpan, replyStart, replyStart + replyName.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                } else {
                    stylesBuilder.setSpan(replySpan, replyStart, replyStart + replyName.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                }
            } else {//评论
                str = model.getReviewContent();
                stylesBuilder = new SpannableStringBuilder(str);
            }
            append(stylesBuilder);
        }
    }
}
