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
 


