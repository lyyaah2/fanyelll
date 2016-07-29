package com.chalenge.fanyelll;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.chalenge.fanyelll.Mypath.Mypathconfig;
import com.chalenge.fanyelll.adapter.DianyingyuanshengAdapter;
import com.chalenge.fanyelll.entity.DianyingyuanshengBean;
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

public class DianyingyuanshengActivity extends AppCompatActivity {

    protected PullToRefreshListView pullToRefreshListView1;
    private int page=1;
    private List<DianyingyuanshengBean.DataBean.ListBean> data = new ArrayList<>();
    private DianyingyuanshengAdapter adapter_dianyingyuansheng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dianyingyuansheng);

        pullToRefreshListView1 = (PullToRefreshListView) findViewById(R.id.pullToRefreshListView1);
        initdata(1);


        pullToRefreshListView1.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshListView1.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                data.clear();
                page = 1;
                initdata(1);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                initdata(page);
            }
        });


    }

    //下载数据
    private void initdata(int index) {
        String  urldianyingyuansheng=Mypathconfig.path_dianyingyuansheng+index;
        Log.e("pp","=="+urldianyingyuansheng);
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(urldianyingyuansheng)
                .build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            //下载成功响应
            @Override
            public void onResponse(Call call, Response response) throws IOException {
               // Log.e("tt","=="+response.body().string());
                page++;
                if (response != null) {
                    Gson gson = new Gson();
                    DianyingyuanshengBean dianyingyuanshengBean = gson.fromJson(response.body().string(), DianyingyuanshengBean.class);
                    final List<DianyingyuanshengBean.DataBean.ListBean> list = dianyingyuanshengBean.getData().getList();
                    Log.e("oo","=="+list.toString());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            if (list != null&&list.size()>0) {
                                data.addAll(list);
                                adapter_dianyingyuansheng = new DianyingyuanshengAdapter(DianyingyuanshengActivity.this);
                                adapter_dianyingyuansheng.setData(data);
                                pullToRefreshListView1.setAdapter(adapter_dianyingyuansheng);
                                adapter_dianyingyuansheng.notifyDataSetChanged();
                            } else {
                                Toast.makeText(DianyingyuanshengActivity.this, "没有更多数据了", Toast.LENGTH_SHORT).show();
                            }
                            if (pullToRefreshListView1.isRefreshing()) {
                                pullToRefreshListView1.onRefreshComplete();
                            }
                        }
                    });
                }
            }
        });

    }
}
