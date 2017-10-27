package com.bwie.test.core;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * 作者：王兵洋  2017/8/3 11:23
 * 类的用途：
 */
public class ApiGenerator {
    //http://h5test.newaircloud.com/api/getConfig?sid=xy
    static Retrofit retrofit = new Retrofit.Builder()
            /**
             * retrofit必须要求有baseUrl接口地址
             * 参数后面必须加  /
             * 拼接路径
             * 安全（）
             */
            .baseUrl("http://h5test.newaircloud.com/api/")
            .addConverterFactory(ScalarsConverterFactory.create())
            .build();

    public static ApiService getApiServer() {
        return retrofit.create(ApiService.class);
    }
}
