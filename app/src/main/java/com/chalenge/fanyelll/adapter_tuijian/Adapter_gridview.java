package com.chalenge.fanyelll.adapter_tuijian;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.chalenge.fanyelll.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/7/27.
 */
public class Adapter_gridview extends BaseAdapter {
    private List<String> pathlist;
    private Context context;

    public Adapter_gridview(List<String> pList, Context pContext) {
        pathlist = pList;
        context = pContext;
    }

    @Override
    public int getCount() {
        return pathlist.size();
    }

    @Override
    public Object getItem(int position) {
        return pathlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder=null;
        if (convertView == null) {
            convertView= LayoutInflater.from(context).inflate(R.layout.item_gridview,parent,false);
            holder=new ViewHolder();
            holder.image= (ImageView) convertView.findViewById(R.id.image_gridview_item);
            convertView.setTag(holder);
        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        Picasso.with(context).load(pathlist.get(position)).into(holder.image);
        return convertView;
    }



    static class ViewHolder {

        ImageView image;
    }
}
