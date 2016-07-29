package com.chalenge.fanyelll.adapter_tuijian;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class adapter_viewpager_image extends PagerAdapter {

    private List<ImageView> images;
    private Context mContext;

    public adapter_viewpager_image(List<ImageView> pImages, Context pContext) {
        images = pImages;
        mContext = pContext;
    }

    @Override
    public int getCount() {
        return images.size();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        container.addView(images.get(position));




        return images.get(position) ;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        container.removeView(images.get(position));
    }
}
