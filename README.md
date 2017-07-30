# TourLink

* 1.01 实现：底部导航栏 + 顶部导航栏
```java
    1、底部导航栏（RadioGroup + RadioButton + Fragment）
        首先，就是去掉它的默认样式，因此，我们来自定义一个style
        然后，直接给RadioButton 设置style
        <RadioButton
                    android:id="@+id/radio_button_home"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:text="首页"
                    android:drawableTop="@drawable/tab_home_selector"
                    style="@style/RadioGroupButtonStyle"
                    />
        最后，在Activity中初始化，绑定相应的fragment
        来自：Android 底部导航栏(底部Tab)最佳实践（http://www.jianshu.com/p/0b9d5777abba ）

    2、顶部导航栏
        第一步，在Theme中隐藏现有的ActionBar，有以下两种方式:
        <style name="AppTheme" parent="Theme.AppCompat.Light.NoActionBar">
        第二步，自定义toolbar
        第三步，在styles.xml中添加toolbar的theme
        第四步，在主布局添加Toolbar控件
        <android.support.v7.widget.Toolbar
                android:id="@+id/toolbar"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:background="@color/color_0176da"
                android:theme="@style/Theme.ToolBar.ZhiHu">
        </android.support.v7.widget.Toolbar>
        来自：Android开发：最详细的 Toolbar 开发实践总结（http://www.jianshu.com/p/79604c3ddcae）
              Android Toolbar，你想知道的都在这里了（http://yifeng.studio/2016/10/12/android-toolbar/）

```

* 1.02_1~2 添加list、使用md风格的图标
```java
     1、listitemview
     compile 'com.lucasurbas:listitemview:1.0.5'
     来自：https://github.com/lurbas/ListItemView

     2、md图标
     来自：https://materialdesignicons.com/
           https://github.com/yeungeek/android-platform-tools-base

```

* 1.03_1 添加View注入butterknife、完成跳转反射弧且添加跳转动画
```java
    1、添加View注入butterknife
    compile 'com.jakewharton:butterknife:7.0.1'

    2、完成代码目录重构，接下来尽量做一些方法的重构

    3、完成跳转反射弧且添加跳转动画（overridePendingTransition（））
    //在fragment里做跳转
    Intent intent = new Intent(getActivity(), ChatActivity.class);
    startActivity(intent);
    getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

    //返回
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
```

* 1.03_2 完成chatUI的功能