package com.bwie.test.core;

/**
 * 作者：王兵洋  2017/8/3 16:22
 * 类的用途：
 */
public interface NetCallBack<T> {

    //开始 准备工作
    public void onNetStart();

    //成功  刷新 view
    public void onNetSuccess(T t);

    //失败
    public void onNetFail(T t);

}
