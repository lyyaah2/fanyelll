package com.chalenge.fanyelll.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.chalenge.fanyelll.DuanBofangActivity;
import com.chalenge.fanyelll.Mypath.Mypathconfig;
import com.chalenge.fanyelll.R;
import com.chalenge.fanyelll.adapter.ShangYingPullToAdapter;
import com.chalenge.fanyelll.entity.ShangYingBean;
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

/**
 * Created by Administrator on 2016/7/27.
 */
public class ShangyingFragment extends Fragment {
    private static final String TAG = "ShangyingFragment";
    private PullToRefreshListView pullToRefreshListView;
    private List<ShangYingBean.DataBean.ListBean> data = new ArrayList<>();
    private ShangYingPullToAdapter adapter_shangying;
    private int page = 1;
    int index1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.shangying_fragment, container, false);
        // initview(view);

        index1 = getArguments().getInt("index1", -1);

        initdata(1);

        adapter_shangying = new ShangYingPullToAdapter(data, getActivity());
        pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pullToRefreshListView);
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                data.clear();
                page = 1;
                initdata(1);

            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

                // page++;

                initdata(page);


            }
        });
        pullToRefreshListView.setAdapter(adapter_shangying);
        //监听点击事件
        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), DuanBofangActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Url_shangying", data.get(position).getMoviedata().getTrailerurl());
                bundle.putInt("flag", 1);
                intent.putExtra("bundle", bundle);
                startActivity(intent);


            }
        });
        return view;
    }

    //初始化数据,下载数据
    private void initdata(int index) {
        switch (index1) {
            case 0:
                String path_shangying = Mypathconfig.path_shangying + index;
                OkHttpClient okHttpClient = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(path_shangying)
                        .build();
                Call call = okHttpClient.newCall(request);

                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {


                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        page++;

                        if (response != null) {
                            Gson gson = new Gson();
                            ShangYingBean shangyingBean = gson.fromJson(response.body().string(), ShangYingBean.class);
                            final List<ShangYingBean.DataBean.ListBean> list = shangyingBean.getData().getList();

                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (list != null && list.size() > 0) {
                                        data.addAll(list);
                                        adapter_shangying.notifyDataSetChanged();
                                    } else {
                                        Toast.makeText(getActivity(), "没有更多数据了", Toast.LENGTH_SHORT).show();
                                    }
                                    if (pullToRefreshListView.isRefreshing()) {
                                        pullToRefreshListView.onRefreshComplete();
                                    }
                                }
                            });


                        }

                    }
                });
                break;
            case 1:

                String path_shangying2 = Mypathconfig.path_shangying2 + index;
                okHttpClient = new OkHttpClient();
                request = new Request.Builder()
                        .url(path_shangying2)
                        .build();
                call = okHttpClient.newCall(request);

                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {


                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        page++;
                        if (response != null) {
                            Gson gson = new Gson();
                            ShangYingBean shangyingBean = gson.fromJson(response.body().string(), ShangYingBean.class);
                            final List<ShangYingBean.DataBean.ListBean> list = shangyingBean.getData().getList();
                            getActivity().runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    if (list != null && list.size() > 0) {
                                        data.addAll(list);
                                        adapter_shangying.notifyDataSetChanged();
                                    } else {
                                        Toast.makeText(getActivity(), "没有更多数据了", Toast.LENGTH_SHORT).show();
                                    }
                                    if (pullToRefreshListView.isRefreshing()) {
                                        pullToRefreshListView.onRefreshComplete();
                                    }
                                }
                            });


                        }

                    }
                });
                break;
        }

    }


}
