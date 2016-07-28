package com.chalenge.fanyelll.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/7/27.
 */
public class ShangyingPagerAdapter  extends FragmentPagerAdapter {

    private List<Fragment> fragments;
    private List<String> mTitles;

    public ShangyingPagerAdapter(FragmentManager fm,List<Fragment> fragments,List<String> mTitles) {
        super(fm);
        this.fragments=fragments;
        this.mTitles=mTitles;
    }

    @Override
    public int getCount() {
        return fragments==null?0:fragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }
}
