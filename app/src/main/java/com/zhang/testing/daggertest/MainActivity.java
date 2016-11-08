package com.zhang.testing.daggertest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.zhang.testing.daggertest.bean.Test2;
import com.zhang.testing.daggertest.bean.Test3;
import com.zhang.testing.daggertest.bean.Test4;
import com.zhang.testing.daggertest.bean.Test5;
import com.zhang.testing.daggertest.di.component.DaggerMainActivityComponent;
import com.zhang.testing.daggertest.di.module.CModule;
import com.zhang.testing.daggertest.di.module.MyModule2;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedDeque;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.Lazy;

public class MainActivity extends AppCompatActivity {
    @Inject
    Test3 test3;
    @Inject
    Test3 test2;
    @Inject
    Test2 test21;//注入这个需要提供Set<String>为参数
    @Inject
    Set<String> S;//注入的为Set<String>
    @Inject
    Map<String, Long> mapTest;//Key为String，值为Long的就会注入到这个里面
    @Inject
    Map<Long, Long> mapLongkey;//key 为Long，值为Long的就会注入到这个里面
    @Inject
    Map<MyModule2.MyEnum, String> myEnumStringMap;
    @Inject
    Map<Class<? extends Number>, String> classStringMap;//自定义Key
    @Inject
    Map<Class<?>, String> test3StringMap;//key为Test3.class，用的是Dagger2的标注，所以key为Class<?>
    @Inject
    Set<Integer> integerSet;//注入的为 Set<Integer>
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
    @Inject
    @ForGirl
    Lazy<Test5> beautifulGirl;//漂亮的女孩都比较懒


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* S = DaggerMainActivityComponent
                .builder()
                .applicationComponent(((DemoApplication) getApplication()).component())
               *//* .cModule(new CModule())*//*
                .build()
                .getStrings();*/
        DaggerMainActivityComponent.builder()
                .applicationComponent(((DemoApplication) getApplication()).component())
                .build()
                .inject(this);
        Toast.makeText(this, test2.sayName(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, beautifulGirl.get().signature(), Toast.LENGTH_SHORT).show();
        //注入完成后只是提供一个可以生成Test5的对象，通过get(),才能获得我们需要的真正实例
    }
}
