package com.hr.tvprojectdemo.base;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.hr.tvprojectdemo.R;
import com.hr.tvprojectdemo.net.base.BaseService;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * Created by 吕 on 2018/3/7.
 */

public class BaseActivity extends FragmentActivity {
    @Inject
    public BaseService baseService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BaseApplation.getBaseApp().getAppComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        ButterKnife.bind(this);

        init();
    }

    public int getLayout(){
        return 0;
    }
    public void init(){

    }

}
