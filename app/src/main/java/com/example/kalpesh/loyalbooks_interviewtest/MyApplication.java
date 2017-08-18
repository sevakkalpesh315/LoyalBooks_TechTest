package com.example.kalpesh.loyalbooks_interviewtest;

import android.app.Application;
import android.content.Context;

import com.example.kalpesh.loyalbooks_interviewtest.injection.DaggerIPresenterComponent;
import com.example.kalpesh.loyalbooks_interviewtest.injection.IPresenterComponent;


/**
 * Created by kalpesh on 18/08/2017.
 */

public class MyApplication extends Application {
    private IPresenterComponent iPresenterComponent;

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
        iPresenterComponent= DaggerIPresenterComponent.create();

    }
    public IPresenterComponent getiPresenterComponent() {
        return iPresenterComponent;
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }


}