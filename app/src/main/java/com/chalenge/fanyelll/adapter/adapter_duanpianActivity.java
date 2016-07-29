package com.chalenge.fanyelll.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chalenge.fanyelll.R;
import com.chalenge.fanyelll.entity.DuanpianBean;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class adapter_duanpianActivity extends BaseAdapter {

    private Context context;
    private List<DuanpianBean.DataBean.ListBean> data;

    public adapter_duanpianActivity(Context context, List<DuanpianBean.DataBean.ListBean> data) {
        this.context = context;
        if (data != null) {
            this.data = data;
        }else{
           this.data=new ArrayList<>();
        }
        Log.e("rr","=="+data.size());
    }

//    public void setData(List<DuanpianBean.DataBean.ListBean> data) {
//        this.data = data;
//        notifyDataSetChanged();
//
//    }

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
            convertView = LayoutInflater.from(context).inflate(R.layout.duanpian_listviewitem, parent, false);
            viewHolder.iv_datu = (ImageView) convertView.findViewById(R.id.iv_datu);
            viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.tv_info = (TextView) convertView.findViewById(R.id.tv_info);
            viewHolder.tv_zanshu = (TextView) convertView.findViewById(R.id.tv_zanshu);
            viewHolder.tv_pinglunshu = (TextView) convertView.findViewById(R.id.tv_pinglunshu);
            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();
        }

        DuanpianBean.DataBean.ListBean listBean = data.get(position);
        if (listBean != null) {
            viewHolder.tv_title.setText(listBean.getSubject());
            viewHolder.tv_info.setText(listBean.getIntro());
            viewHolder.tv_zanshu.setText(listBean.getLiketimes());
            viewHolder.tv_pinglunshu.setText(listBean.getReplies());
            String imageUrl = "http://morguo.com/" + listBean.getImage();
            Picasso.with(context)
                    .load(imageUrl)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .config(Bitmap.Config.RGB_565)
                    .into(viewHolder.iv_datu);


        }


        return convertView;
    }


    static class ViewHolder {
        ImageView iv_datu;
        TextView tv_title, tv_info, tv_zanshu, tv_pinglunshu;

    }
}
