package com.github.programmerrabbit.utils;

/**
 * Created by yangwen on 2016/12/3.
 */
public class StringUtils {
    public static boolean isNullOrEmpty(String string) {
        return string == null || string.length() == 0;
    }
}