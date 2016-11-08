package com.zhang.testing.daggertest.di.module;

import com.zhang.testing.daggertest.bean.Test4;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zyg on 2016/11/6.
 */
@Module
public class ComonModule {
    @Provides
    public Test4 provideTest4() {
        return new Test4();
    }

}
