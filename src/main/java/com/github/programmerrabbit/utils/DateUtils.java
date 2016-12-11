package com.github.programmerrabbit.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by yangwen on 2016/12/3.
 */
public class DateUtils {
    public static final String STANDARD_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static final String SIMPLE_DATE_PATTERN = "yyyy-MM-dd";

    public static String format(Date date, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(date);
    }

    public static String format(long millis, String pattern) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        return dateFormat.format(new Date(millis));
    }
}
