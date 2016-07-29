package com.chalenge.fanyelll.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.chalenge.fanyelll.R;
import com.chalenge.fanyelll.ToRoundBitmap.ToRoundBitmap;
import com.chalenge.fanyelll.entity.DianyingyuanshengBean;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.io.IOException;
import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
public class DianyingyuanshengAdapter extends BaseAdapter {
    private static final String TAG = "yuanshengAdapter";
    private Context context;
    private List<DianyingyuanshengBean.DataBean.ListBean> data;
    private MediaPlayer mediaPlayer;
    private boolean flag = false;
    public DianyingyuanshengAdapter(Context context) {

        this.context = context;
        if (mediaPlayer== null) {
            mediaPlayer = new MediaPlayer();
        }

    }


    public void setData(List<DianyingyuanshengBean.DataBean.ListBean> data) {
        this.data = data;
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
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.dianyingyuansheng_item, parent, false);
            viewHolder.text_subject_yuansheng = (TextView) convertView.findViewById(R.id.text_subject_yuansheng);
            viewHolder.text_intro_yuansheng = (TextView) convertView.findViewById(R.id.text_intro_yuansheng);
            viewHolder.text_zanshu = (TextView) convertView.findViewById(R.id.text_zanshu);
            viewHolder.text_pinglunshu = (TextView) convertView.findViewById(R.id.text_pinglunshu);
            viewHolder.image_yuansheng = (ImageView) convertView.findViewById(R.id.image_yuansheng);
            viewHolder.iv_bofang= (ImageView) convertView.findViewById(R.id.iv_bofang);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        final DianyingyuanshengBean.DataBean.ListBean listBean = data.get(position);
        if (listBean != null) {
            if (listBean.getSubject() != null) {
                viewHolder.text_subject_yuansheng.setText(listBean.getSubject());
            }
            if (listBean.getIntro() != null) {
                viewHolder.text_intro_yuansheng.setText(listBean.getIntro());
            }
            if (listBean.getLiketimes() != null) {
                viewHolder.text_zanshu.setText(listBean.getLiketimes());
            }
            viewHolder.text_pinglunshu.setText(listBean.getIsliked() + "");
            if (listBean.getImage() != null) {
                String imageUrl = "http://morguo.com/" + listBean.getImage();
                Picasso.with(context)
                        .load(imageUrl)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .config(Bitmap.Config.RGB_565)
                        .transform(new Transformation() {
                            @Override
                            public Bitmap transform(Bitmap source) {
                                Bitmap bitmap = ToRoundBitmap.toRoundBitmap(source);
                                if (bitmap != source) {
                                    source.recycle();
                                }
                                return bitmap;
                            }

                            @Override
                            public String key() {
                                return "zh";
                            }
                        })
                        .into(viewHolder.image_yuansheng);
            }


            viewHolder.image_yuansheng.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View v) {
                    try {
                        Log.i(TAG, "=====onClick:");
                        if (mediaPlayer.isPlaying()) {
                            mediaPlayer.pause();
                            return;
                        }
                        if (listBean.getMusicurl() != null) {
                            mediaPlayer.reset();
                            Log.i(TAG, "onClick:null?");
                            Log.i(TAG, "onClick:getMusicurl " + listBean.getMusicurl());
                            mediaPlayer.setDataSource(listBean.getMusicurl());
                            mediaPlayer.prepareAsync();
                            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                                @Override
                                public void onPrepared(MediaPlayer mp) {
                                    mediaPlayer.start();

                                }
                            });

                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        return convertView;
    }

    static class ViewHolder {
        TextView text_subject_yuansheng, text_intro_yuansheng, text_zanshu, text_pinglunshu;
        ImageView image_yuansheng,iv_bofang;
    }

}
