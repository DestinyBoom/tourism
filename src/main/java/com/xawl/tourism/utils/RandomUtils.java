package com.xawl.tourism.utils;

/**
 * Created by zb on 2017/11/18.
 */
public class RandomUtils {
    public static Integer getRandom(){
        Integer random = (int) (Math.random() * 1000000);
        return random;
    }
}
