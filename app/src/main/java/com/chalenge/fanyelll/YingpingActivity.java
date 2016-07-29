package com.chalenge.fanyelll;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class YingpingActivity extends AppCompatActivity {

    private WebView webview;
    private String path1="http://morguo.com/forum.php?mod=viewthread&tid=%s&mobile=2&webviewflag=1&webviewversion=2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yingping);
        Intent intent=getIntent();
        String Tid=intent.getStringExtra("Tid");
        webview = (WebView) findViewById(R.id.webview_yingping);
        String path=String.format(path1,Tid);
        webview.loadUrl(path);
    }
}
