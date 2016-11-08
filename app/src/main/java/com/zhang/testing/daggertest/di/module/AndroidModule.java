package com.zhang.testing.daggertest.di.module;

import android.content.Context;
import android.location.LocationManager;

import com.zhang.testing.daggertest.DemoApplication;
import com.zhang.testing.daggertest.ForBoy;
import com.zhang.testing.daggertest.ForGirl;
import com.zhang.testing.daggertest.PerActivity;
import com.zhang.testing.daggertest.bean.Test5;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static android.content.Context.LOCATION_SERVICE;

/**
 * Created by zyg on 2016/11/5.
 */
@Module
public class AndroidModule {
    private final DemoApplication application;

    public AndroidModule(DemoApplication application) {
        this.application = application;
    }

    @Provides
    @PerActivity
    public LocationManager provideLoctionManager() {
        return (LocationManager) application.getSystemService(LOCATION_SERVICE);
    }

    @PerActivity
    @Provides
    public Context provideContext() {
        return application.getApplicationContext();
    }

    @PerActivity
    @Provides
    @Named("boy")
    public Test5 provideBoy() {
        return new Test5(0);
    }

    @PerActivity
    @Provides
    @Named("girl")
    public Test5 provideGirle() {
        return new Test5(1);
    }
    @PerActivity
    @Provides
    @ForBoy
    public Test5 provideMan(){
        return new Test5(2);
    }
    @PerActivity
    @Provides
    @ForGirl
    public Test5 provideWoman(){
        return new Test5(3);
    }
}
