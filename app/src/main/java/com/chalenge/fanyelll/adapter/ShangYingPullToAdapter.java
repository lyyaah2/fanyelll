package com.chalenge.fanyelll.adapter;

import android.content.Context;
import android.graphics.Bitmap;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chalenge.fanyelll.R;
import com.chalenge.fanyelll.entity.ShangYingBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/27.
 */
public class ShangYingPullToAdapter extends BaseAdapter {
    private List<ShangYingBean.DataBean.ListBean> data;
    private Context context;

    public ShangYingPullToAdapter(List<ShangYingBean.DataBean.ListBean> data, Context context) {
        if (data != null) {
            this.data = data;
        } else {
            data = new ArrayList<>();
        }

        this.context = context;
    }

    @Override
    public int getCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.shangying_item, parent, false);
            viewHolder.tv_dianyingming = (TextView) convertView.findViewById(R.id.tv_dianyingming);
            viewHolder.tv_shangyingshangjian = (TextView) convertView.findViewById(R.id.tv_shangyingshangjian);
            viewHolder.tv_daoyanming = (TextView) convertView.findViewById(R.id.tv_daoyanming);
            viewHolder.tv_zhuyanming = (TextView) convertView.findViewById(R.id.tv_zhuyanming);
            viewHolder.tv_dianyingInfo = (TextView) convertView.findViewById(R.id.tv_dianyingInfo);
            viewHolder.iv_dianyingtu = (ImageView) convertView.findViewById(R.id.iv_dianyingtu);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ShangYingBean.DataBean.ListBean listBean = data.get(position);
        if (listBean != null) {
            viewHolder.tv_dianyingInfo.setText(listBean.getMessage());
            ShangYingBean.DataBean.ListBean.MoviedataBean moviedataBean = listBean.getMoviedata();
            if (moviedataBean != null) {
                if (moviedataBean.getTitle() != null) {
                    viewHolder.tv_dianyingming.setText(moviedataBean.getTitle());
                }
                if(moviedataBean.getPubdate()!=null){
                    viewHolder.tv_shangyingshangjian.setText(moviedataBean.getPubdate());
                }
                if (moviedataBean.getDirectors()!=null){
                    viewHolder.tv_daoyanming.setText(moviedataBean.getDirectors());
                }
                if (moviedataBean.getCasts()!=null){
                    viewHolder.tv_zhuyanming.setText(moviedataBean.getCasts());
                }
                if (moviedataBean.getImage()!=null){
                    String  imgpath="http://morguo.com/"+moviedataBean.getImage();
                    Picasso.with(context)
                            .load(imgpath)
                            .placeholder(R.mipmap.ic_launcher)
                            .error(R.mipmap.ic_launcher)
                            .config(Bitmap.Config.RGB_565)
                            .into(viewHolder.iv_dianyingtu);
                }
            }
        }


        return convertView;
    }

    static class ViewHolder {
        TextView tv_dianyingming, tv_shangyingshangjian, tv_daoyanming, tv_zhuyanming, tv_dianyingInfo;
        ImageView iv_dianyingtu;
    }
}
