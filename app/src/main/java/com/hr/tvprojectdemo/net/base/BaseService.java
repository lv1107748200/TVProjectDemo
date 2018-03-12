package com.hr.tvprojectdemo.net.base;





import com.hr.tvprojectdemo.base.BaseApplation;
import com.hr.tvprojectdemo.net.Service.YouDaoService;
import com.hr.tvprojectdemo.net.entry.AddPostData;
import com.hr.tvprojectdemo.net.http.HttpCallback;
import com.hr.tvprojectdemo.net.http.HttpUtils;
import com.hr.tvprojectdemo.net.subscriber.HttpSubscriber;

import java.io.File;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;

/**
 * Created by 吕 on 2017/10/27.
 */

public class BaseService {

    public BaseService() {
        BaseApplation.getBaseApp().getAppComponent().inject(this);
    }
    @Inject
    public YouDaoService youDaoService;


    @SuppressWarnings("unchecked")
    public void getP(String p, HttpCallback<BaseResponse<AddPostData>> httpCallback){
            HttpUtils.toSubscribe(youDaoService.getPostView(p),
                    new HttpSubscriber<AddPostData>(httpCallback));
    }

}
