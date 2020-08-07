package com.yrn.drawableemple.app;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * DrawableEmple
 * <p>
 * Created by Xinhoo on 2020/8/7
 * Describe:
 */
public class MyApp extends Application {
    private static MyApp myApp;
    private static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        myApp=this;
        mContext = getApplicationContext();
    }

    public static MyApp getApplication(){
        if (myApp == null) {
            myApp = new MyApp();
        }
        return myApp;
    }
    public  static Context getContext() {
        if (mContext == null) {
            mContext = getApplication().getApplicationContext();
        }
        return mContext;
    }


    //    private static void adaptScreen(final Activity activity,
//                                    final int sizeInPx,
//                                    final boolean isVerticalSlide) {
//        final DisplayMetrics systemDm = Resources.getSystem().getDisplayMetrics();
//        final DisplayMetrics appDm = App.getAppContext().getResources().getDisplayMetrics();
//        final DisplayMetrics activityDm = activity.getResources().getDisplayMetrics();
//        if (isVerticalSlide) {
//            activityDm.density = activityDm.widthPixels / (float) sizeInPx;
//        } else {
//            activityDm.density = activityDm.heightPixels / (float) sizeInPx;
//        }
//        activityDm.scaledDensity = activityDm.density * (systemDm.scaledDensity / systemDm.density);
//        activityDm.densityDpi = (int) (160 * activityDm.density);
//        appDm.density = activityDm.density;
//        appDm.scaledDensity = activityDm.scaledDensity;
//        appDm.densityDpi = activityDm.densityDpi;
//    }
}
