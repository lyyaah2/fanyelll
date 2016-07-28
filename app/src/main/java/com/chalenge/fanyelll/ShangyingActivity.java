package com.chalenge.fanyelll;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.chalenge.fanyelll.adapter.ShangyingPagerAdapter;
import com.chalenge.fanyelll.fragment.ShangyingFragment;

import java.util.ArrayList;
import java.util.List;

public class ShangyingActivity extends AppCompatActivity {

    protected TabLayout tabLayout_shangying;
    protected ViewPager viewPager_shangying;
    private List<Fragment> mFragments;
    private List<String> mTitles;
    private ShangyingPagerAdapter shangying_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shangying);
        initView();
        initData();
    }

    //初始化数据
    private void initData() {
        mFragments = new ArrayList<>();
        mTitles = new ArrayList<>();

        ShangyingFragment f1 = new ShangyingFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("index1", 0);
        f1.setArguments(bundle);
        mFragments.add(f1);

        ShangyingFragment f2 = new ShangyingFragment();
        bundle = new Bundle();
        bundle.putInt("index1", 1);
        f2.setArguments(bundle);
        mFragments.add(f2);

        mTitles.add("正在上映");
        mTitles.add("即将上映");
        shangying_adapter = new ShangyingPagerAdapter
                (getSupportFragmentManager(), mFragments, mTitles);
        viewPager_shangying.setAdapter(shangying_adapter);
        //viewpager和tablayout相关联
        tabLayout_shangying.setupWithViewPager(viewPager_shangying);
    }


    //初始化控件
    private void initView() {
        tabLayout_shangying = (TabLayout) findViewById(R.id.TableLayout_shangying);
        viewPager_shangying = (ViewPager) findViewById(R.id.viewPager_shangying);
    }
}
