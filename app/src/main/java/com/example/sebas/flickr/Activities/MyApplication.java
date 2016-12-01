package com.example.sebas.flickr.Activities;

import android.app.Application;
import android.graphics.Bitmap;

import com.example.sebas.flickr.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * Created by Sebas on 17/11/2016.
 */

public class MyApplication extends Application {

    public static  DisplayImageOptions options,optionsRounded;

    @Override
    public void onCreate() {
        super.onCreate();
        options = new DisplayImageOptions.Builder()
//                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .imageScaleType(ImageScaleType.IN_SAMPLE_INT)
                .showImageOnFail(R.drawable.loading_image)
                .showImageForEmptyUri(R.drawable.loading_image)
                .showImageOnLoading(R.drawable.loading_image)
                .displayer(new FadeInBitmapDisplayer(500))
                .resetViewBeforeLoading(true)
                .build();

        optionsRounded = new DisplayImageOptions.Builder()
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .showImageOnFail(R.drawable.loading_image)
                .showImageForEmptyUri(R.drawable.loading_image)
                .showImageOnLoading(R.drawable.loading_image)
                .imageScaleType(ImageScaleType.EXACTLY_STRETCHED)
                .displayer(new RoundedBitmapDisplayer(1000))
                .resetViewBeforeLoading(true)
                .build();

        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                .threadPoolSize(2)
                .build();

        ImageLoader.getInstance().init(config);

    }
}
