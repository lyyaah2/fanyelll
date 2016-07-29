package com.chalenge.fanyelll;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import io.vov.vitamio.Vitamio;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;

public class DuanBofangActivity extends AppCompatActivity {

    protected VideoView mVideoView;
    private MediaController mediaController;
    private String videoUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置成全屏模式
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);//强制为横屏
        setContentView(R.layout.activity_duan_bofang);

        mVideoView = (VideoView) findViewById(R.id.videoView);
        //给VItamio进行初始化
        Vitamio.isInitialized(this);
        Intent intent = getIntent();

        Bundle bundle = intent.getBundleExtra("bundle");
        int flag = bundle.getInt("flag", -1);
        if (flag == 0) {
            videoUrl =bundle.getString("Url_duanpian");
        }else if(flag==1){
            videoUrl=bundle.getString("Url_shangying");
        }
        //设置播放地址
        mVideoView.setVideoPath(videoUrl);
        mediaController = new MediaController(DuanBofangActivity.this);
        mVideoView.setMediaController(mediaController);
        mVideoView.start();

    }
}
