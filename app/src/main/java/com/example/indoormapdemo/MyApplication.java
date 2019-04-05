package com.example.indoormapdemo;

import android.app.Application;

import com.github.piasy.biv.BigImageViewer;
import com.github.piasy.biv.loader.glide.GlideImageLoader;

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        BigImageViewer.initialize(GlideImageLoader.with(this));
    }
}
