package com.chalenge.fanyelll.adapter_tuijian;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.chalenge.fanyelll.DuanBofangActivity;
import com.chalenge.fanyelll.HuabaoActivity;
import com.chalenge.fanyelll.R;
import com.chalenge.fanyelll.YingpingActivity;
import com.chalenge.fanyelll.customview.ToroundBitmap;
import com.chalenge.fanyelll.model_tuijian.First_tuijian_bean;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/26.
 */
public class Adapter_recyclerview extends RecyclerView.Adapter<Adapter_recyclerview.ViewHolder> {
    private static final String TAG ="info--Adapterrr" ;
    private List<First_tuijian_bean.DataBean.ListBean> mList_item;
    private Context context;
    private LayoutInflater inflater;
    private String pathhead="http://morguo.com/";
    private List<String> thumpaths=new ArrayList<>();
    private List<Map<String,Bitmap>> maps=new ArrayList<>();
    public Adapter_recyclerview(List<First_tuijian_bean.DataBean.ListBean> mList_item, Context context) {
        this.context = context;
        inflater=LayoutInflater.from(context);

        this.mList_item=mList_item;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {



        Log.i(TAG, "onCreateViewHolder: ");
        View viewItem=null;
        ViewHolder viewHolder=null;

        switch (viewType) {

            case 1:
                //短片
                viewItem=inflater.inflate(R.layout.item_recyclerview_duanpian,parent,false);
                viewHolder=new ViewHolder(viewItem);
                viewHolder.mTextView_subject= (TextView) viewItem.findViewById(R.id.text_subject_duanpian);
                viewHolder.mTextView_intro= (TextView) viewItem.findViewById(R.id.text_intro_duanpian);
                viewHolder.image= (ImageView) viewItem.findViewById(R.id.image_duanpian);
                viewHolder.image_video= (ImageView) viewItem.findViewById(R.id.start_muvie_duanpian);
                viewHolder.tag=1;

                break;
            case 2:
                //台词
                viewItem=inflater.inflate(R.layout.item_recyclerview_taici,parent,false);
                viewHolder=new ViewHolder(viewItem);

                 viewHolder.mTextView_intro= (TextView) viewItem.findViewById(R.id.text_subject_taici);
                viewHolder.mTextView_subject= (TextView) viewItem.findViewById(R.id.text_intro_taici);
                viewHolder.image= (ImageView) viewItem.findViewById(R.id.image_taici);
                viewHolder.tag=2;


                break;
            case 3:
                //音乐
                viewItem=inflater.inflate(R.layout.item_recyclerview_dianyingyuansheng,parent,false);
                viewHolder=new ViewHolder(viewItem);

                viewHolder.mTextView_subject= (TextView) viewItem.findViewById(R.id.text_subject_yuansheng);
                viewHolder.mTextView_intro= (TextView) viewItem.findViewById(R.id.text_intro_yuansheng);
                viewHolder.image= (ImageView) viewItem.findViewById(R.id.image_yuansheng);

                viewHolder.tag=3;


                break;
            case 4:
                //影评 杂粮
                viewItem=inflater.inflate(R.layout.item_recyclerview_zaliang_yingping,parent,false);
                viewHolder=new ViewHolder(viewItem);

                viewHolder.mTextView_subject= (TextView) viewItem.findViewById(R.id.textview_subject_yingping);
                viewHolder.mTextView_intro= (TextView) viewItem.findViewById(R.id.textview_intro_yingping);
                viewHolder.image= (ImageView) viewItem.findViewById(R.id.image_yingping);
                viewHolder.tag=4;


                break;
            case 5:
                //画报
                viewItem=inflater.inflate(R.layout.item_recyclerview_huabao,parent,false);
                viewHolder=new ViewHolder(viewItem);

                viewHolder.mTextView_subject= (TextView) viewItem.findViewById(R.id.text_subject_huabao);
                viewHolder.mTextView_intro= (TextView) viewItem.findViewById(R.id.text_intro_huabao);
                viewHolder.mGridView= (GridView) viewItem.findViewById(R.id.gridview_huabao);
                viewHolder.tag=5;


                break;
            case 6:
                //影单 沙龙
                viewItem=inflater.inflate(R.layout.item_recyclerview_shalong_yingdan,parent,false);
                viewHolder=new ViewHolder(viewItem);

                viewHolder.mTextView_subject= (TextView) viewItem.findViewById(R.id.text_subject_shalong);
                viewHolder.mTextView_intro= (TextView) viewItem.findViewById(R.id.text_intro_shalong);
                viewHolder.image= (ImageView) viewItem.findViewById(R.id.image_shalong);
                viewHolder.tag=6;


                break;


        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {


        switch (holder.tag) {
            case 1:
                //短片
                getdatavideo(holder,position);

                break;
            case 2:
                //台词
                getdatataici(holder,position);
                break;
            case 3:
                //音乐
                getdataMusic(holder,position);

                break;
            case 4:
                //影评杂粮
                getdatayingping(holder,position);
                break;
            case 5:
                //画报
              getdatahuabao(holder,position);
                break;
            case 6:
                //影单沙龙
                getdatayingdan(holder,position);
                break;
        }

    }
    String image_path=null;
    String lSubject=null;
    String lIntro=null;
    String lTid=null;
    public void getdata(ViewHolder holder, int position){


         First_tuijian_bean.DataBean.ListBean.ItemdataBean lItemdata = mList_item.get(position).getItemdata();
         lSubject = lItemdata.getSubject();
         lIntro = lItemdata.getIntro();
         String lImage = lItemdata.getImage();

        image_path=pathhead+lImage;
         holder.mTextView_subject.setText(lSubject);
         holder.mTextView_intro.setText(lIntro);
         //下载图片
         Picasso.with(context)
                 .load(image_path)
                 .into(holder.image);

     }
    String lVideourl=null;
    public void getdatavideo(ViewHolder holder, int position){


        First_tuijian_bean.DataBean.ListBean.ItemdataBean lItemdata = mList_item.get(position).getItemdata();
        lSubject = lItemdata.getSubject();
        lIntro = lItemdata.getIntro();
        String lImage = lItemdata.getImage();
         lVideourl = lItemdata.getVideourl();

        image_path=pathhead+lImage;
        holder.mTextView_subject.setText(lSubject);
        holder.mTextView_intro.setText(lIntro);
        //下载图片
        Picasso.with(context)
                .load(image_path)
                .into(holder.image);

        holder.image_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"播放视频",Toast.LENGTH_SHORT).show();

                Intent  intent=new Intent(context,DuanBofangActivity.class);
                Bundle bundle=new Bundle();
                bundle.putString("Videourl",lVideourl);
                intent.putExtra("bundle",bundle);

                context.startActivity(intent);

            }
        });


    }

    //影评
    public void getdatayingping(ViewHolder holder, int position){

        Log.i(TAG, "getdata: ");
        First_tuijian_bean.DataBean.ListBean.ItemdataBean lItemdata = mList_item.get(position).getItemdata();
        String lSubject = lItemdata.getSubject();
        String lIntro = lItemdata.getIntro();
        String lImage = lItemdata.getImage();
        lTid = lItemdata.getTid();

        String image_path=pathhead+lImage;
        holder.mTextView_subject.setText(lSubject);
        holder.mTextView_intro.setText(lIntro);
        //下载图片
        Picasso.with(context)
                .load(image_path)
                .into(holder.image);

        holder.image.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {

                Intent intent =new Intent(context, YingpingActivity.class);
                intent.putExtra("Tid",lTid);
                context.startActivity(intent);
            }
        });
    }

    public void getdatataici(final ViewHolder holder, int position){

        Log.i(TAG, "getdata: ");
        First_tuijian_bean.DataBean.ListBean.ItemdataBean lItemdata = mList_item.get(position).getItemdata();
        lSubject = lItemdata.getSubject();
        lIntro = lItemdata.getIntro();
        String lImage = lItemdata.getImage();

        image_path=pathhead+lImage;
        holder.mTextView_subject.setText(lSubject);
        holder.mTextView_intro.setText(lIntro);
        //下载图片
        Picasso.with(context)
                .load(image_path)
                .into(holder.image);
        holder.image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View popWindowview=inflater.inflate(R.layout.item_recyclerview_taici,null,false);
                ImageView lImageView= (ImageView) popWindowview.findViewById(R.id.image_taici);
                Picasso.with(context)
                        .load(image_path)
                        .into(lImageView);
                TextView lViewById_s = (TextView) popWindowview.findViewById(R.id.text_subject_taici);
                TextView lViewById_i = (TextView) popWindowview.findViewById(R.id.text_subject_taici);
                lViewById_s.setText(lSubject);
                lViewById_i.setText(lIntro);
                PopupWindow lPopupWindow=new PopupWindow(popWindowview, RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT, true);

                lPopupWindow.showAtLocation(holder.image, Gravity.CENTER,0,0);
            }
        });
    }


    public void getdatayingdan(ViewHolder holder, int position){


        First_tuijian_bean.DataBean.ListBean.ItemdataBean lItemdata = mList_item.get(position).getItemdata();
        String name = lItemdata.getName();
        String lDesc = lItemdata.getDesc();
        String lImage = lItemdata.getImage();

        String image_path=pathhead+lImage;
        holder.mTextView_subject.setText(name);
        holder.mTextView_intro.setText(lDesc);
        //下载图片
        Picasso.with(context)
                .load(image_path)

                .into(holder.image);
    }
    public void getdataMusic(ViewHolder holder, int position){


        First_tuijian_bean.DataBean.ListBean.ItemdataBean lItemdata = mList_item.get(position).getItemdata();
        String lSubject = lItemdata.getSubject();
        String lIntro = lItemdata.getIntro();
        String lImage = lItemdata.getImage();

        String image_path=pathhead+lImage;
        holder.mTextView_subject.setText(lSubject);
        holder.mTextView_intro.setText(lIntro);
        //下载图片
        Picasso.with(context)
                .load(image_path)
                .resize(230,230)
                .transform(new Transformation() {
                    @Override
                    public Bitmap transform(Bitmap source) {

                        //Transformation zh mutated input Bitmap but failed to recycle the original.
                        Bitmap bitmap = ToroundBitmap.toRoundBitmap(source);

                        if (bitmap != source) {
                            //将原本的图片回收
                            source.recycle();
                        }

                        return bitmap;
                    }

                    @Override
                    public String key() {
                        //当前转换的唯一标识
                        return "zh";
                    }
                })
                .into(holder.image);
    }
    public void getdatahuabao(ViewHolder holder, int position){


        First_tuijian_bean.DataBean.ListBean.ItemdataBean lItemdata = mList_item.get(position).getItemdata();
        String lSubject = lItemdata.getSubject();
        String lIntro = lItemdata.getIntro();
        for (int i = 0; i < 9; i++) {

                String lThumb =pathhead+lItemdata.getImageListBean().get(i).getThumb();

                thumpaths.add(lThumb);


        }
        holder.mTextView_subject.setText(lSubject);
        holder.mTextView_intro.setText(lIntro);
        Adapter_gridview adaptergrid=new Adapter_gridview(thumpaths,context);
        holder.mGridView.setAdapter(adaptergrid);
        holder.mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(context, HuabaoActivity.class);
                intent.putExtra("path",thumpaths.get(position));
                context.startActivity(intent);

            }
        });



        //获得图片地址

        //得到imageview集合
      //  getimageviews(holder);
        //gridview的适配器



    }
    private void getimageviews(ViewHolder holder) {


        for (int i = 0; i < thumpaths.size(); i++) {

            ImageLoader.getInstance().loadImage(thumpaths.get(i), new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {

                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {

                }

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {

                    Map<String,Bitmap> map=new HashMap<String, Bitmap>();
                    map.put("map",loadedImage);
                    maps.add(map);
                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {

                }
            });


        }
        SimpleAdapter lSimpleAdapter=new SimpleAdapter(context,maps,R.layout.item_gridview,new String[]{"map"},new int[]{R.id.image_gridview_item});
        holder.mGridView.setAdapter(lSimpleAdapter);


    }




    @Override
    public int getItemCount() {
        return mList_item.size();
    }

    @Override
    public int getItemViewType(int position) {
        String lType = mList_item.get(position).getType();
        if (lType.equals("threadvideo")) {
            //短片
            return 1;
        }
        if (lType.equals("movielines")) {
            //台词
            return 2;
        }
        if (lType.equals("threadmusic")) {
            //音乐
            return 3;
        }
        if (lType.equals("acinecism")||lType.equals("threadarticle")) {
            //影评 杂粮
            return 4;
        }
        if (lType.equals("threadgallery")) {
            //画报
            return 5;
        }
        if (lType.equals("collection")||lType.equals("channel")) {
            //影单 沙龙
            return 6;
        }
        return 0;



    }
    public class ViewHolder extends RecyclerView.ViewHolder{


        private int tag=0;
        private ImageView image, image_video;
        private TextView mTextView_subject,mTextView_intro;
        private GridView mGridView;
        public ViewHolder(View itemView) {
            super(itemView);



        }
    }

}
