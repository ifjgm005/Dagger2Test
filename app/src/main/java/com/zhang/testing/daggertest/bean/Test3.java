package com.zhang.testing.daggertest.bean;

import android.location.LocationManager;

/**
 * Created by zyg on 2016/11/5.
 */

public class Test3 {
    private LocationManager locationManager;

    public Test3(LocationManager manager) {
        this.locationManager = manager;
    }
    public String sayName(){
        return "我是Test3";
    }


}
