package com.example.administrator.toolbardrawerlayout;

import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //声明相关变量
    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView lvLeftMenu;
    private String[] lvs = {"I LOVE Y", "I Believe Y", "I Want Y", "......."};
    private ArrayAdapter arrayAdapter;
    private TextView ivRunningMan;
    private AnimationDrawable mAnimationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews(); //获取控件
        CustomProgressDialog dialog = new CustomProgressDialog(MainActivity.this, "正在加载中", R.anim.anim2);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable());
        dialog.show();
        toolbar.setTitle("Title");
        toolbar.setSubtitle("SubTitle");//设置Toolbar标题
        toolbar.setTitleTextColor(Color.parseColor("#ffffff")); //设置标题颜色
        toolbar.setSubtitleTextColor(Color.parseColor("#ffffff"));
        toolbar.setLogo(R.mipmap.ic_launcher);

        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true); //设置返回键可用
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//设置箭头
        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
        //创建返回键，并实现打开关/闭监听
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
//                mAnimationDrawable.start();
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        //设置菜单列表
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, lvs);
        lvLeftMenu.setAdapter(arrayAdapter);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.action_search:
                        Toast.makeText(MainActivity.this, "Search !", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_notifications:
                        Toast.makeText(MainActivity.this, "Notificationa !", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_settings:
                        Toast.makeText(MainActivity.this, "Settings !", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    private void findViews() {
        ivRunningMan = (TextView) findViewById(R.id.iv_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        lvLeftMenu = (ListView) findViewById(R.id.lv_left_menu);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
}
