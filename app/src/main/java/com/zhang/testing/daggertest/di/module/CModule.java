package com.zhang.testing.daggertest.di.module;

import android.location.LocationManager;

import com.zhang.testing.daggertest.OnlyInstance;
import com.zhang.testing.daggertest.bean.Test3;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zyg on 2016/11/5.
 */
@Module
public class CModule {
    @OnlyInstance
    @Provides
    Test3 provdeText3(LocationManager locationManager){
      return   new Test3(locationManager);
    }
    /**
     * 继承中单例的总结：
     * 单例有源头性，如果上游是单例接收必须单例。
     * 父类Component提供的是单例，子Component必须单例，
     * 但仅限于Component,子的Module不受影响
     * Component 和Module之间，Module 是单例，Component必须单例。
     *
     *
     * @Scope的一个注释，这个注释的意思就是作用域，
     * 在作用域内保持单例：同属于一个作用域，共用一个相同实例
     * 为什么要新增一个呢，主要是因为各个组件需要独立出来，
     * 因此如果是依赖关系，则需要各自在不同的注释作用域里面
     * （所以自定义一个@OnlyInstance）
     * 子Component 和 父Component 作用域不能相同，必须各自在不同的作用域里
     * 但是 Component和 Module之间必须用相同的作用域，当然如果Module没有，Component就随意了
     * 然后我们又定义了一个@PerActivity
     * 我们将之前的@Singleton用新建的（自定义的@PerActivity）替换掉，
     * 验证两次的生成代码，发现一模一样，一模一样，一模一样，
     * so。。。 就是这个样子啦
     *
     * @Singleton，只是@Scope中普通
     *
     * */
}
