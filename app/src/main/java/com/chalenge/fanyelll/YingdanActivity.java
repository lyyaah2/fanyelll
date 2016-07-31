package com.chalenge.fanyelll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.chalenge.fanyelll.adapter.Adapter_yingdan_list;
import com.chalenge.fanyelll.entity.Yingdan;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class YingdanActivity extends AppCompatActivity {


    private PullToRefreshListView listview;
    private String path1="http://morguo.com/forum.php?mod=collection&op=recommend&androidflag=1&page=%d";
    private int page=1;
    private List<Yingdan.DataBean.ListBean> list=new ArrayList<>();
    private  Adapter_yingdan_list lAdapter_yingdan_list;
    String path;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yingdan);
        listview = (PullToRefreshListView) findViewById(R.id.pullToRefreshListView_yingdanactivity);

        lAdapter_yingdan_list=new Adapter_yingdan_list(list,this);
        listview.setAdapter(lAdapter_yingdan_list);
        initOkhttp(1);
        listview.setMode(PullToRefreshBase.Mode.BOTH);
        listview.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                initOkhttp(1);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

                initOkhttp(page);
            }
        });
    }

    private void initOkhttp(int p) {
        path=String.format(path1,p);
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
                Gson lGson=new Gson();
                Yingdan lYingdan = lGson.fromJson(response.body().string(), Yingdan.class);
                Yingdan.DataBean lData = lYingdan.getData();
                List<Yingdan.DataBean.ListBean> lList = lData.getList();
                list.addAll(lList);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        lAdapter_yingdan_list.notifyDataSetChanged();
                    }
                });




            }
        });
    }


}
