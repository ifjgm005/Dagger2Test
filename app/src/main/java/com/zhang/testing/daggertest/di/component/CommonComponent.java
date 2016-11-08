package com.zhang.testing.daggertest.di.component;

import android.content.Context;

import com.zhang.testing.daggertest.PerActivity;
import com.zhang.testing.daggertest.bean.Test4;
import com.zhang.testing.daggertest.di.module.AndroidModule;
import com.zhang.testing.daggertest.di.module.ComonModule;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Subcomponent;

/**
 * Created by zyg on 2016/11/6.
 */

@Subcomponent(modules = ComonModule.class)
public interface CommonComponent {
    Test4 getText4();
}
