package com.xawl.tourism.utils;

import java.util.UUID;

/**
 * Created by DT on 2017/11/17.
 */
public class UUIDUtils {
    /**
     * 生成UUID
     *
     * @return
     */
    public static String createUUID() {
        String str = UUID.randomUUID().toString().replaceAll("-", "");
        return str;
    }
}
