package com.bwie.test.home.presenter;

import com.bwie.test.core.NetCallBack;
import com.bwie.test.home.model.ConfigResponse;
import com.bwie.test.home.model.HomeService;
import com.bwie.test.home.view.IHomeView;

/**
 * 作者：王兵洋  2017/8/3 16:53
 * 类的用途：
 */
public class HomePresenter implements IHomePresenter {

    private IHomeView mIHomeView;

    public HomePresenter(IHomeView IHomeView) {
        mIHomeView = IHomeView;
    }

    public HomePresenter() {
    }

    @Override
    public void loadStart() {
        loadConfig("xy");
    }

    @Override
    public void detachView() {
        if (mIHomeView != null) {
            mIHomeView = null;
        }
    }

    @Override
    public void loadConfig(String sid) {

        HomeService.getInstance().getConfig(sid, new NetCallBack<ConfigResponse>() {
            @Override
            public void onNetStart() {
                if (mIHomeView != null) {
                    mIHomeView.showOrHideloading(true);
                    mIHomeView.showOrHideErrorView(false);
                }
            }

            @Override
            public void onNetSuccess(ConfigResponse configResponse) {
                if (mIHomeView != null) {
                    mIHomeView.showOrHideloading(false);
                    mIHomeView.showOrHideErrorView(false);
                }
                if (mIHomeView != null) {
                    mIHomeView.refreshView(configResponse);
                }
            }

            @Override
            public void onNetFail(ConfigResponse configResponse) {
                if (mIHomeView != null) {
                    mIHomeView.showOrHideloading(false);
                    mIHomeView.showOrHideErrorView(true);
                }
            }
        });
    }

    @Override
    public void loadDetail() {

    }
}
