package com.zhang.testing.daggertest.di.component;

import com.zhang.testing.daggertest.MainActivity;
import com.zhang.testing.daggertest.OnlyInstance;
import com.zhang.testing.daggertest.di.MyModule1;
import com.zhang.testing.daggertest.di.module.CModule;
import com.zhang.testing.daggertest.di.module.ModuleA;
import com.zhang.testing.daggertest.di.module.ModuleB;
import com.zhang.testing.daggertest.di.module.MyModule2;

import java.util.Map;
import java.util.Set;

import dagger.Component;

/**
 * Created by zyg on 2016/11/5.
 */
@OnlyInstance
@Component(dependencies = ApplicationComponent.class,modules = {ModuleA.class, ModuleB.class,MyModule1.class, MyModule2.class,CModule.class})
public interface MainActivityComponent {
    void inject(MainActivity activity);

    Set<String> getStrings();

    Map<String, Long> getMap();

}
