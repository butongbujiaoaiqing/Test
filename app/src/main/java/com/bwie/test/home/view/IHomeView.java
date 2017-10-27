package com.bwie.test.home.view;

import com.bwie.test.home.model.ConfigResponse;

/**
 * 作者：王兵洋  2017/8/3 17:01
 * 类的用途：
 */
public interface IHomeView<T> {

    void showOrHideloading(boolean flag);

    void showOrHideErrorView(boolean flag);

    void refreshView(ConfigResponse configResponse);

}
