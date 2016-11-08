package com.zhang.testing.daggertest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by zyg on 2016/11/7.
 */
@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface ForBoy {
}
