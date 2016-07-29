package com.chalenge.fanyelll.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chalenge.fanyelll.DuanPianActivity;
import com.chalenge.fanyelll.R;
import com.chalenge.fanyelll.ShangyingActivity;
import com.chalenge.fanyelll.YingpingActivity;
import com.chalenge.fanyelll.adapter_tuijian.Adapter_recyclerview;
import com.chalenge.fanyelll.adapter_tuijian.adapter_viewpager_image;
import com.chalenge.fanyelll.customview.FullyLinearLayoutManager;
import com.chalenge.fanyelll.customview.MyRecyclerview;
import com.chalenge.fanyelll.model_tuijian.First_tuijian_bean;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/7/25.
 */
public class fragment_tuijian  extends Fragment {

    private static final String TAG ="info--fragment_tuijian" ;
    private View lView;
    private ViewPager mViewPager;
    private List<String> imagePaths_viewpager;
    private String pathhead="http://morguo.com/";
    private List<ImageView> mImageViewList=new ArrayList<>();
    private adapter_viewpager_image lAdapter_viewpager_image;
    private List<First_tuijian_bean.DataBean.ListBean> mList_item;
    private List<First_tuijian_bean.DataBean.ExplorerbannerlistBean> mExplorerbannerlist;
    private MyRecyclerview recyclerview;
    private Adapter_recyclerview adapter_recyclerview;
    private List<First_tuijian_bean.DataBean.ListBean> list=new ArrayList<>();
    private String path1="http://morguo.com/forum.php?mod=movieexplorer&v=3&androidflag=1&page=%d&pdateline=1469668475";
    private int page=1;
    private String pathOk;
    private boolean isBottom = false;
    private ImageView shangying_to;
    private ImageView duanpian_to;
    private ImageView yingdan_to;
    private ImageView gengduo_to;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        lView=inflater.inflate(R.layout.item_fragment_tuijian,container,false);
        imagePaths_viewpager=new ArrayList<>();
        initview();
        pathOk=String.format(path1,page);
        initOkhttp(pathOk);
        lAdapter_viewpager_image=new adapter_viewpager_image(mImageViewList,getContext());
        mViewPager.setAdapter(lAdapter_viewpager_image);
        final FullyLinearLayoutManager layoutManager = new FullyLinearLayoutManager(getContext());
        recyclerview.setLayoutManager(layoutManager);
        adapter_recyclerview=new Adapter_recyclerview(list,getContext());
        recyclerview.setAdapter(adapter_recyclerview);
//        recyclerview.addOnScrollListener(new RecyclerView.OnScrollListener() {
//
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                Log.i(TAG, "onScrolled: ");
//                int visible  = layoutManager.getChildCount();
//                int total = layoutManager.getItemCount();
//                int past=layoutManager.findFirstCompletelyVisibleItemPosition();
//                final Handler mHandler = new Handler() {
//                    @Override
//                    public void handleMessage(Message msg) {
//                        super.handleMessage(msg);
//                        Toast.makeText(getContext(),"加载跟多------",Toast.LENGTH_LONG).show();
//                        initOkhttp(String.format(path1,page));
//
//                    }
//                };
//
//
//                if ((visible + past) >= total){
//                    Runnable mRunnable = new Runnable() {
//                        @Override
//                        public void run() {
//                            mHandler.sendEmptyMessage(1);
//                        }
//                    };
//
//                    mHandler .postDelayed(mRunnable, 10000); // 在Handler中执行子线程并延迟3s。
//
//                }
//            }
//        });
        initclick();

        return lView;
    }

    private void initclick() {
        shangying_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), ShangyingActivity.class);
                startActivity(intent);
            }
        });
        duanpian_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), DuanPianActivity.class);
                startActivity(intent);
            }
        });
        yingdan_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getContext(), YingpingActivity.class);
                startActivity(intent);
            }
        });
    }


    private void initview() {
        mViewPager = (ViewPager) lView.findViewById(R.id.viewpager_tuijian);
        recyclerview = (MyRecyclerview) lView.findViewById(R.id.recyclerview);
        shangying_to = (ImageView)lView.findViewById(R.id.imageview_screen_select);
        duanpian_to = (ImageView)lView.findViewById(R.id.imageview_short_select);
        yingdan_to = (ImageView)lView.findViewById(R.id.imageview_movielist_select);
        gengduo_to = (ImageView)lView.findViewById(R.id.imageview_more_select);

}


    private void initOkhttp(String path) {

        OkHttpClient lOkHttpClient=new OkHttpClient();
        Request lRequest=new Request.Builder()
                .url(path)
                .build();
        Call lCall=lOkHttpClient.newCall(lRequest);
        lCall.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {


            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

                page++;
                String str = response.body().string();

                Gson lGson=new Gson();
                First_tuijian_bean lFirst_tuijian_bean = lGson.fromJson(str, First_tuijian_bean.class);
                mList_item = lFirst_tuijian_bean.getData().getList();
                list.addAll(mList_item);


                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adapter_recyclerview.notifyDataSetChanged();
                    }
                });

                mExplorerbannerlist = lFirst_tuijian_bean.getData().getExplorerbannerlist();
                for (int lI = 0; lI < mExplorerbannerlist.size(); lI++) {
                    String path=pathhead+mExplorerbannerlist.get(lI).getImage();
                    imagePaths_viewpager.add(path);
                    Log.i(TAG, "onResponse: "+path);





                }
                //用picasso下载图片放在集合里
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initPicasso();

                        lAdapter_viewpager_image.notifyDataSetChanged();


                    }
                });




            }
        });
    }

    private void initPicasso() {


        for (int i = 0; i < imagePaths_viewpager.size(); i++) {

            ImageView image=new ImageView(getContext());
            Picasso.with(getContext())
                    .load(imagePaths_viewpager.get(i))
                    .into(image);
            mImageViewList.add(image);

        }

    }



    public static fragment_tuijian newInstance() {

        fragment_tuijian f = new fragment_tuijian();

        return f;
    }
}
