# Toolbar_Drawerlayout
![github](https://raw.githubusercontent.com/2017HHL/Toolbar_Drawerlayout/master/1512458467.jpg "github")
![github](https://raw.githubusercontent.com/2017HHL/Toolbar_Drawerlayout/master/1512458467(1).jpg "github")
![github](https://raw.githubusercontent.com/2017HHL/Toolbar_Drawerlayout/master/1512458467(2).jpg "github")

# Android动画之仿美团加载数据等待时，小人奔跑进度动画对话框
### anim.xml文件如下
- animation-list 是动画列表，中间放很多的item 也就是组成帧动画的图片，
- android:drawable[drawable]//加载Drawable对象
- android:duration[long]//每一帧动画的持续时间（单位ms）
- android:oneshot[boolean]//动画是否只运行一次，true运行一次，false重复运行
```
<?xml version="1.0" encoding="utf-8"?>  
<animation-list xmlns:android="http://schemas.android.com/apk/res/android"  
    android:oneshot="false" >  
  
    <item  
        android:drawable="@drawable/app_loading0"  
        android:duration="150"/>  
    <item  
        android:drawable="@drawable/app_loading1"  
        android:duration="150"/>  
  
</animation-list>  
```
### Toolbar
- setNavigationIcon
- 即设定 up button 的图标，因为 Material 的介面，在 Toolbar这里的 up button样式也就有別于过去的 ActionBar 哦。
- setLogo
- APP 的图标。- 
- setTitle
- 主标题。
- setSubtitle
- 副标题。
- setOnMenuItemClickListener
- 设定菜单各按鈕的动作。
### Toolbar+Drawerlayout快速实现侧滑界面
```
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                mAnimationDrawable.stop();
            }
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                mAnimationDrawable.start();
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        //设置菜单列表
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lvs);
        lvLeftMenu.setAdapter(arrayAdapter);
```


