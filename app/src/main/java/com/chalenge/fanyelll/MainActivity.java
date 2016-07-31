package com.chalenge.fanyelll;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.chalenge.fanyelll.adapter.adapter_pageradapter_tablayout;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTablayout;
    private ViewPager mViewPager;
    private String[] titles;
    private SlidingMenu slidingMenu;
    private ImageView leftmunu;
    private ImageView rightmenu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();

        initLeftRightSlidingMenu();
        mViewPager.setAdapter(new adapter_pageradapter_tablayout(getSupportFragmentManager(),titles));
        mTablayout.setupWithViewPager(mViewPager);

    }
    public void GotoMore(){
        mViewPager.setCurrentItem(2);
    }
    //初始化SlidingMenu
    private void initLeftRightSlidingMenu() {

        //1,实例化SlidingMenu对象
        slidingMenu = new SlidingMenu(MainActivity.this);
        //2,设置侧滑菜单的样式  LEFT  ,LEFT_RIGHT ,RIGHT
        slidingMenu.setMode(SlidingMenu.LEFT_RIGHT);
        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_NONE);
        //3,引入菜单布局
        // 方式一  VIew
        // slidingMenu.setMenu(LayoutInflater.from(MainActivity.this).inflate());
        //方法二  R.layout.xxx
        slidingMenu.setMenu(R.layout.left);

        //设置右边菜单
        slidingMenu.setSecondaryMenu(R.layout.right);


        slidingMenu.attachToActivity(MainActivity.this, SlidingMenu.SLIDING_CONTENT);

        //获取右边布局
        View v2 =  slidingMenu.getMenu();
        ImageView right = (ImageView) v2.findViewById(R.id.btnMenu1);
       right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slidingMenu.toggle();
            }
        });

        //获取菜单的View
        View v = slidingMenu.getSecondaryMenu();
        Button right_close = (Button) v.findViewById(R.id.right_close);
        right_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("AAA","AAAAAAAAAAAAAA");
                //万能开关
                slidingMenu.toggle();
            }
        });
        leftmunu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(slidingMenu!=null){
                    slidingMenu.toggle();
                }
            }
        });
        rightmenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(slidingMenu!=null){
                    slidingMenu.showSecondaryMenu();
                }
            }
        });
    }


    private void initview() {
        mTablayout = (TabLayout) findViewById(R.id.Tablayout_zhujiemian);
        mViewPager = (ViewPager) findViewById(R.id.ViewPager_zhujiemian);
        leftmunu = (ImageView) findViewById(R.id.leftmenuButton);
        rightmenu = (ImageView) findViewById(R.id.rightmenuButton);
        slidingMenu=new SlidingMenu(MainActivity.this);
        inittitledata();


    }

    private void inittitledata() {
        titles=new String[]{"我的","推荐","发现"};
      }

}
