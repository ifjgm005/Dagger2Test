package com.zhang.testing.daggertest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;



/**
 * Created by zyg on 2016/11/5.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface OnlyInstance {

}
