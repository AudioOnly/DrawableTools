## Drawable/color 一些基础使用方法汇总

#### selector
点击转台
例：
```
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:state_pressed="true">
        <shape>
            <corners android:radius="4dp" />
            <solid android:color="#888888" />
        </shape>
    </item>
    <item android:state_pressed="false">
        <shape>
            <corners android:radius="4dp" />
            <solid android:color="#50888888" />
        </shape>
    </item>
</selector>
```
#### space
solid:填充
stroke：描边
corners：圆角
size：尺寸
gradient：渐变

### 实现  
 1. View 背景点击效果 selector
 2. Space 画背景
 3. selector+color 实现内容颜色 点击效果

## 动态使用Drawable（StateListDrawable--（selector 点击状态）；GradientDrawable--（gradient 渐变））
使用java代码实现：渐变和点击效果
 com.yrn.drawableemple.util.DrawableUtil

## 获取手机屏幕尺寸

getWindowManager()和 getSystemService(name); 获取的WindowManager 是同一个
```
DisplayMetrics dm=new DisplayMetrics();
getWindowManager().getDefaultDisplay().getMetrics(dm)
int width=dm.widthPixels;
int height=dm.heightPixels;

Point point=new Point();
getWindowManager().getDefaultDisplay().getSize(point);
int width=point.x;
int height=point.y;
```
### dp dpi px density 关系
1. dp(dip);device independent pixels(设备独立像素).
2. density:密度（屏幕里像素值浓度）
3. dpi：（dot per inch）屏幕像素密度，每英寸多少像素（计算公式 √(width²+ high²)/screen(√是开平方)）
   * density=dpi/160
   * px=dp*density
   * dp=px/density
4. PPI：(每英寸所拥有的像素数目)pixels per inch
###  DisplayMetrics 中几个重要参数
1. widthPixels ，单位像素，display的absolute-width:绝对宽度
2. heightPixels，单位像素，display的absolute-height：绝对长度
3. densityDpi densityDpi就是dpi
4. density = dpi / 160
5. px和dp换算公式：px = dp * (dpi / 160)

### 两种Android适配方案
1. 两种适配方案
https://blog.csdn.net/wy391920778/article/details/81939233
2. UI设计方案
https://www.ui.cn/detail/281292.html

 


