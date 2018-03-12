package com.hr.tvprojectdemo.net.http;


import com.hr.tvprojectdemo.net.Service.YouDaoService;
import com.hr.tvprojectdemo.net.base.BaseService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;

/**
 * Created by 吕 on 2017/10/26.
 */
@Module
public class HttpModule {
    protected static final String APP_CODE = "AppCode";
    protected static final String APP_CODE_VALUE = "ANDROID";

    @Provides
    @Singleton
    public YouDaoService youDaoService(){
        HttpServiceSetting httpServiceSetting = new HttpServiceSetting("http://fanyi.youdao.com/");
        httpServiceSetting.builderCallback = new OkHttpRequestBuilderCallback() {
            @Override
            public void builder(Request.Builder builder) {
                builder.addHeader(APP_CODE, APP_CODE_VALUE);    //设置请求头
            }
        };
        httpServiceSetting.logLevel = HttpLoggingInterceptor.Level.BODY;
        Retrofit retrofit = OkHttpClientUtils.buildRetrofit(httpServiceSetting);
        return  retrofit.create(YouDaoService.class);
    }

    //
    @Provides
    @Singleton
    public BaseService baseService(){
        return new BaseService();
    }
}
