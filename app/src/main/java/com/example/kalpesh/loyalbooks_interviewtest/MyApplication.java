package com.example.kalpesh.loyalbooks_interviewtest;

import android.app.Application;
import android.content.Context;

/**
 * Created by kalpesh on 18/08/2017.
 */

public class MyApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}