package com.bwie.test.home.model;

import com.bwie.test.AppConstants;
import com.bwie.test.core.ApiService;
import com.bwie.test.core.ApiGenerator;

import retrofit2.Call;

/**
 * 作者：王兵洋  2017/8/3 11:30
 * 类的用途：
 */
public class ApiHome {
    public static volatile ApiHome instance = null;
    private ApiService mApiService;

    public ApiHome() {
        mApiService = ApiGenerator.getApiServer();
    }

    public static ApiHome getInstance() {
        if (instance == null) {
            synchronized (ApiHome.class) {
                if (instance == null) {
                    instance = new ApiHome();
                }
            }
        }
        return instance;
    }

    public Call<String> getConfigFromServer(String sid) {
        if (mApiService == null) {
            mApiService = ApiGenerator.getApiServer();
        }
        return mApiService.baseGetRequest(getConfigUrl(sid));
    }

    //http://h5test.newaircloud.com/api/getConfig?sid=xy
    private String getConfigUrl(String sid) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(AppConstants.Base.BASE_URL)
                .append(AppConstants.Home.NET_API_CONFIG)
                .append("sid=")
                .append(sid);
        return stringBuffer.toString();
    }
}
