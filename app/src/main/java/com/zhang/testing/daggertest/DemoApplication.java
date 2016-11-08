package com.zhang.testing.daggertest;

import android.app.Application;
import android.location.LocationManager;
import android.widget.Toast;

import com.zhang.testing.daggertest.bean.Test4;
import com.zhang.testing.daggertest.bean.Test5;
import com.zhang.testing.daggertest.di.component.ApplicationComponent;
import com.zhang.testing.daggertest.di.component.DaggerApplicationComponent;
import com.zhang.testing.daggertest.di.module.AndroidModule;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * Created by zyg on 2016/11/5.
 */

public class DemoApplication extends Application {
    @Inject
    LocationManager locationManager;
    @Inject
    @Named("boy")
    Test5 boy;
    @Inject
    @Named("girl")
    Test5 girl;
    @Inject
    @ForBoy
    Test5 man;
    @Inject
    @ForGirl
    Test5 woman;

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerApplicationComponent.builder()
                .androidModule(new AndroidModule(this))
                .build();
        Test4 test4 = component().getCommonComponent().getText4();
        component().inject(this);
        Toast.makeText(this, locationManager.getClass().getSimpleName(), Toast.LENGTH_SHORT).show();

    }

    public ApplicationComponent component() {
        return component;
    }
}
