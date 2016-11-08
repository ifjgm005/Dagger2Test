package com.zhang.testing.daggertest.di.component;

import android.location.LocationManager;

import com.zhang.testing.daggertest.DemoApplication;
import com.zhang.testing.daggertest.ForBoy;
import com.zhang.testing.daggertest.ForGirl;
import com.zhang.testing.daggertest.OnlyInstance;
import com.zhang.testing.daggertest.PerActivity;
import com.zhang.testing.daggertest.bean.Test5;
import com.zhang.testing.daggertest.di.module.AndroidModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zyg on 2016/11/5.
 */
@PerActivity
@Component(modules = AndroidModule.class)
public interface ApplicationComponent {
    void inject(DemoApplication application);

    LocationManager getLocationManager();

    CommonComponent getCommonComponent();

    @Named("boy")
    Test5 provideBoy();

    @Named("girl")
    Test5 provideGirl();

    @ForBoy
    Test5 provideMan();

    @ForGirl
    Test5 provideWoman();

}
