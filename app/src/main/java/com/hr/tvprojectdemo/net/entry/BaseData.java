package com.hr.tvprojectdemo.net.entry;

/**
 * Created by 吕 on 2018/1/15.
 */

public class BaseData {
    private String userId;

    public BaseData(String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
