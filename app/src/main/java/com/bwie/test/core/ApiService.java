package com.bwie.test.core;

import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.PartMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

/**
 * 作者：王兵洋  2017/8/3 10:41
 * 类的用途：
 */
public interface ApiService {

    //http://h5test.newaircloud.com/api/getConfig?sid=xy

    @GET
    Call<String> baseGetRequest(@Url String url);

    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET
    Call<String> baseGetRequestHeaders(@Url String url, @Header("token") String token);

    @FormUrlEncoded
    @POST
    Call<String> basePostRequesst(@Url String url, @FieldMap Map<String, String> params);

    @FormUrlEncoded
    @POST
    Call<String> basePostRequesstHerders(@Url String url, @FieldMap Map<String, String> params, @Header("token") String token);


    @Multipart
    @PUT("user/photo")
    Call<String> baseUpLoadFile(@Url String url,
                                @PartMap Map<String, RequestBody> params);

    @Streaming
    @GET
    Call<String> baseDownLoadFile(@Url String url);
}
