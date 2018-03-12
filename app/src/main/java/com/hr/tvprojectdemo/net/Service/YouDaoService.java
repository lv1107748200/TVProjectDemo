package com.hr.tvprojectdemo.net.Service;



import com.hr.tvprojectdemo.net.base.BaseResponse;
import com.hr.tvprojectdemo.net.entry.AddPostData;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by 吕 on 2017/12/12.
 * http://fanyi.youdao.com/openapi.do?keyfrom=lvzuhao&key=560647729&type=data&doctype=json&version=1.1&q=你好
 */

public interface YouDaoService {
    @GET("http://fanyi.youdao.com/openapi.do?keyfrom=lvzuhao&key=560647729&type=data&doctype=json&version=1.1")
    Observable<Response<BaseResponse<AddPostData>>> getPostView(@Query("q") String q);

}
