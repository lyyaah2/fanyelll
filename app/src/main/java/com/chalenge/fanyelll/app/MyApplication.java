package com.chalenge.fanyelll.app;

import android.app.Application;
import android.os.Environment;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.io.File;

/**
 * Created by Administrator on 2016/7/19.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        initUIL();
    }

    private void initUIL() {
        File file = new File(Environment.getExternalStorageDirectory(),"Okpay_imagecache_UIL");
        ImageLoaderConfiguration configuration = new ImageLoaderConfiguration.Builder(this)
                .threadPoolSize(3)//线程池大小  1-5
                .memoryCacheSize(10*1024*1024) //配置内存大小
                .diskCacheSize(100*1024*1024) //配置磁盘大小
                .diskCacheFileCount(100)  //配置磁盘缓存文件的数量
                .diskCacheFileNameGenerator(new HashCodeFileNameGenerator())//磁盘缓存文件的命名器
                .writeDebugLogs() //输出log日志
                .diskCache(new UnlimitedDiskCache(file))//定义磁盘缓存文件
                .build();

        //进行全局初始化
        ImageLoader.getInstance().init(configuration);

    }
}
