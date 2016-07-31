package com.chalenge.fanyelll.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chalenge.fanyelll.R;
import com.chalenge.fanyelll.entity.Yingdan;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Administrator on 2016/7/30.
 */
public class Adapter_yingdan_list extends BaseAdapter {
    private static final String TAG ="info--yingdan_list";
    private List<Yingdan.DataBean.ListBean> list;
    private Context context;

    public Adapter_yingdan_list(List<Yingdan.DataBean.ListBean> pList, Context pContext) {

        list = pList;
        context = pContext;
        Log.i(TAG, "Adapter_yingdan_list: "+list.size());
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder=null;
        if (convertView == null) {

            convertView= LayoutInflater.from(context).inflate(R.layout.item_yingdanlist,parent,false);
            holder=new ViewHolder();
            holder.image= (ImageView) convertView.findViewById(R.id.image_yingdanlist_item);
            holder.text_name= (TextView) convertView.findViewById(R.id.text_yingdanlist_name);
            holder.text_desc= (TextView) convertView.findViewById(R.id.text_yingdanlist_desc);
            convertView.setTag(holder);

        }else {
            holder= (ViewHolder) convertView.getTag();
        }
        //赋值
        Log.i(TAG, "getView: "+list.get(position).getName());
        holder.text_name.setText(list.get(position).getName());
        holder.text_desc.setText(list.get(position).getDesc());
        Picasso.with(context)
                .load("http://morguo.com/"+list.get(position).getImage())
                .into(holder.image);



        return convertView;
    }
    public class ViewHolder{
        private ImageView image;
        private TextView text_name,text_desc;

    }
}
