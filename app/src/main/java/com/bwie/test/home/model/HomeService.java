package com.bwie.test.home.model;

import com.bwie.test.AppConstants;
import com.bwie.test.MyAppliction;
import com.bwie.test.core.NetCallBack;
import com.bwie.test.utils.ACache;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * 作者：王兵洋  2017/8/3 11:29
 * 类的用途：
 */
public class HomeService {
    public static volatile HomeService instance;

    public HomeService() {
    }

    public static HomeService getInstance() {
        if (instance == null) {
            synchronized (ApiHome.class) {
                if (instance == null) {
                    instance = new HomeService();
                }
            }
        }
        return instance;
    }

    /**
     * 缓存的流程：
     * 第一次网络请求就来之后先去缓存拿数据，如果没有数据发起网络请求，如果返回成功将结果成功回调给页面， 存储返回结果，
     * 第二次进入添加一个开关（boolean的值）没有网络，读取缓存，发现缓存有数据，有值，回调变成失败，如果缓存 里面有数据，开关的值变成true
     * 第三次进入有网络 走第一次的流程，返回有值 继续回调并且开关变成true， 发起网络请求，成功，先不回调，
     * 第四次进来之后 再走前面的 一直保持缓存是最新的数据。。。。。。
     */
    public void getConfig(String sid, final NetCallBack<ConfigResponse> netCallBack) {
        netCallBack.onNetStart();
        //添加一个缓存开关
        boolean islocalCallBack = false;
        String result = ACache.get(MyAppliction.instance).getAsString(AppConstants.Home.CACHE_CONFIG_KEY);
        //判断非空
        if (result != null && !result.equalsIgnoreCase("null") && result.length() > 0) {
            netCallBack.onNetSuccess(ConfigResponse.objectFromData(result));
            //开启开关
            islocalCallBack = true;
        }
        Call<String> call = ApiHome.getInstance().getConfigFromServer(sid);
        final boolean finalIslocalCallBack = islocalCallBack;
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response != null && response.isSuccessful()) {
                    String result = response.body().toString();
                    if (!finalIslocalCallBack) {
                        netCallBack.onNetSuccess(ConfigResponse.objectFromData(result));
                    }
                    //缓存数据  放在回调之后
                    ACache.get(MyAppliction.instance).put(AppConstants.Home.CACHE_CONFIG_KEY, result);

                } else {
                    if (!finalIslocalCallBack) {
                        netCallBack.onNetFail(null);
                    }
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                if (!finalIslocalCallBack) {
                    netCallBack.onNetFail(null);
                }
            }
        });
    }
}