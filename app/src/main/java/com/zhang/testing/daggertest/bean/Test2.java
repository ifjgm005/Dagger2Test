package com.zhang.testing.daggertest.bean;

import junit.framework.Test;

import java.util.Set;

import javax.inject.Inject;

/**
 * Created by zyg on 2016/11/6.
 */

public class Test2 {
    private Set<String> strings;

    public Test2(Set<String> stringSet){
        this.strings = stringSet;
    }
}
