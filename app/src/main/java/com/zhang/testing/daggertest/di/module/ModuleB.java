package com.zhang.testing.daggertest.di.module;

import android.location.LocationManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;

/**
 * Created by zyg on 2016/11/6.
 */
@Module
public class ModuleB {
    @Provides
    @ElementsIntoSet
    public Set<String> provideStings(LocationManager manager){
        return new HashSet<String>(Arrays.asList("def", "ghi"));
    }
}
