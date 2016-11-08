package com.zhang.testing.daggertest.di.module;

import android.location.LocationManager;

import com.zhang.testing.daggertest.bean.Test2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import dagger.multibindings.IntoSet;

/**
 * Created by zyg on 2016/11/6.
 */
@Module
public class ModuleA {

    @Provides
    @IntoSet
    public String provideString(LocationManager locationManager) {
        return "ABC";
    }

    @Provides
    @IntoSet
    public String provideSecond(LocationManager locationManager) {
        return "abc";
    }

    @Provides
    @ElementsIntoSet
    public Set<String> provideStings(LocationManager manager) {
        return new HashSet<String>(Arrays.asList("DEF", "GHI"));
    }


    @Provides
    @IntoSet
    public Integer provideInterger(LocationManager locationManager) {
        return 1;
    }

    @Provides
    @ElementsIntoSet
    public Set<Integer> provideIntegers(LocationManager manager) {
        return new HashSet<Integer>(Arrays.asList(1, 2));
    }


    @Provides
    public Test2 provideTest2(Set<String> stringSet) {
        return new Test2(stringSet);
    }
    /**
     *
     * 这里需要注意的就是，在组件里面加入多个绑定的时候，
     * module的里面必须要有一个是@IntoSet 这个作为第一个标记，
     * 否则会出错，可以多个@IntoSet标记。
     如果是列表类型的，则使用@ElementsIntoSet就ok了。
     * */
}
