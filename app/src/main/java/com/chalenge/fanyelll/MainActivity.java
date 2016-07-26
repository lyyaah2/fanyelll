package com.chalenge.fanyelll;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chalenge.fanyelll.adapter.adapter_pageradapter_tablayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout mTablayout;
    private ViewPager mViewPager;
    private String[] titles;
    private int[] images;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
//        for (int i = 0; i < 5; i++) {
//            TabLayout.Tab tab = mTablayout.getTabAt(i);
//            if (tab != null) {
//                tab.setCustomView(getTabView(i));
//            }
//        }


        mViewPager.setAdapter(new adapter_pageradapter_tablayout(getSupportFragmentManager(),titles));
        mTablayout.setupWithViewPager(mViewPager);

    }

    private void initview() {
        mTablayout = (TabLayout) findViewById(R.id.Tablayout_zhujiemian);
        mViewPager = (ViewPager) findViewById(R.id.ViewPager_zhujiemian);
        inittitledata();


    }

    private void inittitledata() {
        titles=new String[]{"设置","我的","推荐","发现","搜索"};
        images=new int[]{R.mipmap.noavatar_small,0,0,0,R.mipmap.red_search};


    }
    public View getTabView(int position){
        //首先为子tab布置一个布局
        View v = LayoutInflater.from(MainActivity.this).inflate(R.layout.tab_title,null);
        ImageView image = (ImageView) v.findViewById(R.id.image_tabtitle);
        TextView text = (TextView) v.findViewById(R.id.textview_tabtitle);
        if (!titles[position].equals("")) {
            text.setText(titles[position]);
        }
        if (images[position]!=0) {
           image.setImageResource(images[position]);
        }


        return v;
    }
}
