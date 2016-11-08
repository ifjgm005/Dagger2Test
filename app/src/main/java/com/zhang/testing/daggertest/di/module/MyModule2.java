package com.zhang.testing.daggertest.di.module;

import java.math.BigDecimal;

import dagger.MapKey;
import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoMap;

/**
 * Created by zyg on 2016/11/6.
 */
@Module
public class MyModule2 {
    @Provides
    @IntoMap
    @MyEnumKey(MyEnum.ABC)
    public String provideABCValue() {
        return "Value for ABC";
    }

    @Provides
    @IntoMap
    @MyNumberClassKey(BigDecimal.class)
    public String provideNumberClassValue() {
        return "BigDecimal Value";
    }

    //自定义枚举
    public static enum MyEnum {
        ABC, DEF;
    }

    @MapKey
    @interface MyEnumKey {
        MyEnum value();
    }

    @MapKey
    @interface MyNumberClassKey {
        Class<? extends Number> value();
    }
}
