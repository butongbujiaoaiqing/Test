package com.bwie.test.home.presenter;

/**
 * 作者：王兵洋  2017/8/3 16:55
 * 类的用途：
 */
public interface IHomePresenter {

    void loadStart();

    void detachView();

    //配置启动项
    void loadConfig(String sid);

    //加载详情
    void loadDetail();

}
