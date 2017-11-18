package com.xawl.tourism.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * Created by zb on 2017/11/18.
 */
public class MD5Utils {

    public static String addMD5(String pass) throws Exception {
        //确定计算方法
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        //加密后的字符串
        String newPass = base64en.encode(md5.digest(pass.getBytes("utf-8")));
        return newPass;
    }
}
