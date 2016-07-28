package com.chalenge.fanyelll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.chalenge.fanyelll.Mypath.Mypathconfig;
import com.chalenge.fanyelll.adapter.Adapter_duanpianActivity;
import com.chalenge.fanyelll.entity.DuanpianBean;
import com.google.gson.Gson;
import com.google.gson.LongSerializationPolicy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class DuanPianActivity extends AppCompatActivity {

    private static final String TAG ="info--DuanPianActivity" ;
    protected ListView lv_duanpian;
    private List<DuanpianBean.DataBean.ListBean> data = new ArrayList<>();
    private Adapter_duanpianActivity adapter_duanpain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_duan_pian);
        lv_duanpian = (ListView) findViewById(R.id.lv_duanpian);
        Log.e("tag", "====" + Mypathconfig.path_duanpian);
        initdata();
        lv_duanpian.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent  intent=new Intent(DuanPianActivity.this,DuanBofangActivity.class);
                Bundle  bundle=new Bundle();
                bundle.putString("Videourl",data.get(position).getVideourl());
                intent.putExtra("bundle",bundle);
                Log.e("bb","=="+data.get(position).getVideourl());
                startActivity(intent);

            }
        });


    }

    private void initdata() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(Mypathconfig.path_duanpian)
                .build();


        Call call = okHttpClient.newCall(request);
        Log.i(TAG, "initdata:call ");
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.i(TAG, "initdata:onFailure "+e);

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                Log.i(TAG, "initdata:onResponse ");
//                if (response != null) {
//                    Log.e("aa", "====" + response.body().string());
//                }

                if (response != null) {
                    Gson gson = new Gson();
                    DuanpianBean ListBean = gson.fromJson(response.body().string(), DuanpianBean.class);

                    data = ListBean.getData().getList();
                    Log.e("ad", "====" + data);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter_duanpain = new Adapter_duanpianActivity(DuanPianActivity.this, data);
                            lv_duanpian.setAdapter(adapter_duanpain);
                            adapter_duanpain.notifyDataSetChanged();


                        }
                    });



                }

            }
        });
    }


}
