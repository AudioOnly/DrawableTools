package com.yrn.drawableemple.util;

import android.content.Context;

import com.yrn.drawableemple.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * DrawableEmple
 * <p>
 * Created by Xinhoo on 2020/8/7
 * Describe:
 */
public class TimeUtils {
    private static final SimpleDateFormat DATE_FORMAT_DATE_HH_MM = new SimpleDateFormat("HH:mm");
    private static final SimpleDateFormat DEFAULT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    //朋友圈-消息通知列表 显示时间格式  Start
    private static final SimpleDateFormat DATE_FORMAT_DATE_HH_MM_EN = new SimpleDateFormat("M/dd, HH:mm");
    private static final SimpleDateFormat DEFAULT_DATE_FORMAT_YYYY_M_DD_HH_MM_EN = new SimpleDateFormat("M/dd/yyyy, HH:mm");

    /**
     * 朋友圈-新消息通知列表/朋友圈详情-评论 时间显示规则
     * @param mContext 上下文
     * @param longTime 发送时间
     * 点赞评论通知列表的时间显示规则：
     * 当天的显示“X时：X分”，
     * 属于昨天及以前的都显示“X月X日 X时：X分”，
     * 去年及以前的都显示“X年X月X日 X时：X分”
     * @return
     */
    public static String daysFormatForMomentsMsg(Context mContext, long longTime) {
        Calendar calCurr = Calendar.getInstance();
        Calendar calSend = Calendar.getInstance();
        calSend.setTimeInMillis(longTime);

        int dayOffset;
        int yearOffSet;
        int daySend = calSend.get(Calendar.DAY_OF_YEAR);
        int dayCurr = calCurr.get(Calendar.DAY_OF_YEAR);
        int yearSend = calSend.get(Calendar.YEAR);
        int yearCurr = calCurr.get(Calendar.YEAR);
        yearOffSet = yearCurr - yearSend;
        if (yearSend != yearCurr) {  //不同年
            int timeDistance = 0;
            for (int i = yearSend; i < yearCurr; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {  //闰年
                    timeDistance += 366;
                } else {  //不是闰年
                    timeDistance += 365;
                }
            }
            dayOffset = timeDistance + (dayCurr - daySend);
        } else { //同一年
            dayOffset = dayCurr - daySend;
        }


        int hour = (int) ((calCurr.getTimeInMillis() - calSend.getTimeInMillis()) / 3600000);
        if (hour <= 24) {
            if (hour == 0) {
                int timeOffset = (int) Math.max((calCurr.getTimeInMillis() - calSend.getTimeInMillis()) / 60000, 1);
                return mContext.getResources().getString(R.string.moment_time_before_min, timeOffset);
            } else {
                return mContext.getResources().getString(R.string.moment_time_before_hour, hour);
            }
        } else {
            if (dayOffset == 1) {
                return mContext.getResources().getString(R.string.moment_time_yesterday)+"，" + getTimeHHmm(longTime);
            } else {
                if (yearOffSet == 0) {
                    //同一年 （M/dd,HH:mm）
                    return getTime(longTime, DATE_FORMAT_DATE_HH_MM_EN);
                } else {
                    //不同年 （M/dd/yyyy, HH:mm）
                    return getTime(longTime, DEFAULT_DATE_FORMAT_YYYY_M_DD_HH_MM_EN);
                }
            }
        }
    }


    private static String getTimeHHmm(long time) {
        Date curDate = new Date(time);//
        String str = DATE_FORMAT_DATE_HH_MM.format(curDate);
        return str;
    }

    /**
     * long time to string, format is {@link #DEFAULT_DATE_FORMAT}
     *
     * @param timeInMillis
     * @return
     */
    private static String getTime(long timeInMillis) {
        return getTime(timeInMillis, DEFAULT_DATE_FORMAT);
    }
    /**
     * long time to string
     *
     * @param timeInMillis
     * @param dateFormat
     * @return
     */
    private static String getTime(long timeInMillis, SimpleDateFormat dateFormat) {
        return dateFormat.format(new Date(timeInMillis));
    }

}
