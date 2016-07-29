package com.chalenge.fanyelll.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.chalenge.fanyelll.fragment.fragment_faxian;
import com.chalenge.fanyelll.fragment.fragment_shezhi;
import com.chalenge.fanyelll.fragment.fragment_tuijian;
import com.chalenge.fanyelll.fragment.fragment_wode;

/**
 * Created by Administrator on 2016/7/25.
 */
public class adapter_pageradapter_tablayout extends FragmentPagerAdapter {

   private String[] titles;

    public adapter_pageradapter_tablayout(FragmentManager fm, String[] titles) {
        super(fm);
        this.titles=titles;

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {

            case 0:return fragment_wode.newInstance();
            case 1:return fragment_tuijian.newInstance();
            case 2:return fragment_faxian.newInstance();

            default:return fragment_shezhi.newInstance();


        }

    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        return titles[position];
    }
}
