package com.hr.tvprojectdemo.net.subscriber;


import android.content.Intent;


import com.hr.tvprojectdemo.base.BaseApplation;
import com.hr.tvprojectdemo.net.base.BaseResponse;
import com.hr.tvprojectdemo.net.http.HttpCallback;
import com.hr.tvprojectdemo.net.http.HttpException;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import retrofit2.Response;


/**
 public static final Integer LOGIN = 1000;//正常登录
 public static final Integer TOLOGIN = 1001;//未登录，需要跳转到登录界面
 public static final Integer NOPERMISSION = 1002;//无权限访问，跳转到无权限提示页面
 public static final Integer LOGINSUCCESS = 1003;//登录成功
 public static final Integer LOGINERROR = 1004;//登录异常，跳转到登录界面重新登录
 public static final Integer LOGININVALID = 1005;//无效的用户名或者密码，弹出提示信息
 public static final Integer LOGINOUTSUCCESS = 1006;//登出成功
 public static final Integer LOGINOUTERROR = 1007;//登出异常
 public static final Integer REPEATEDDATA = 2001;//添加或编辑数据重复
 */
public class HttpSubscriber<T> implements Observer<Response<BaseResponse<T>>> {
    HttpCallback callback;

    public HttpSubscriber(HttpCallback callback) {
        super();
        this.callback = callback;
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(Throwable e) {
      //  NToast.shortToastBaseApp("访问失败!");
        if (callback != null) {
            callback.onError(new HttpException(-100,e.getMessage()));
        }
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public void onNext(Response<BaseResponse<T>> httpResultResponse) {
        if(httpResultResponse.code()==200){
            BaseResponse<T> result = httpResultResponse.body();
            if(result.getSysCode()==1000 || result.getSysCode() == 1003 || result.getSysCode() == 1006){
                if (callback != null) {
                    callback.onSuccess(result);
                }
            } else {
                if(result.getSysCode() == 1001){//登陆超时



                }else {
                  //  NToast.shortToastBaseApp("访问失败!");
//                    if(result.getSysCode() == 400){
//                        NToast.shortToastBaseApp("访问失败!");
//                    }
                    if (callback != null) {
                        callback.onError(new HttpException(result.getSysCode(),result.getMsg()));
                    }
                }
            }
        } else {
            if (callback != null) {
                callback.onError(new HttpException(httpResultResponse.code(),httpResultResponse.message()));
            }
        }
    }



}
