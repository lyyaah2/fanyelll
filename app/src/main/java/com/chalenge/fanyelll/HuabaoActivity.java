package com.chalenge.fanyelll;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class HuabaoActivity extends AppCompatActivity {

    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huabao);
        image = (ImageView) findViewById(R.id.image_huabaoactivity);
        Intent intent=getIntent();
        String path=intent.getStringExtra("path");
        Picasso.with(this).load(path).into(image);

    }
}
