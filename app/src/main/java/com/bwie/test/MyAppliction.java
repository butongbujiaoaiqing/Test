package com.bwie.test;

import android.app.Application;

/**
 * 作者：王兵洋  2017/8/3 11:27
 * 类的用途：
 */
public class MyAppliction extends Application {

    public static MyAppliction instance;

    public MyAppliction() {

    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
