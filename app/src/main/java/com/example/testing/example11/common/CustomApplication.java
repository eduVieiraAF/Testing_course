package com.example.testing.example11.common;

import android.app.Application;

import com.example.testing.example11.common.di.CompositionRoot;

public class CustomApplication  extends Application {

    private CompositionRoot mCompositionRoot;

    @Override
    public void onCreate(){
        super.onCreate();

        mCompositionRoot = new CompositionRoot();
    }

    public CompositionRoot getCompositionRoot() {
        return mCompositionRoot;
    }
}
