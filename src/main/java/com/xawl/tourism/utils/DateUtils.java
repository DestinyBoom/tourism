package com.xawl.tourism.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by DT on 2017/11/18.
 */
public class DateUtils {
    public static String getDateString() {
        String str = new SimpleDateFormat("yyyy-MM-dd HH:MM:ss").format(new Date());
        return str;
    }

    public static String dateToString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd ").format(date);
    }
}
