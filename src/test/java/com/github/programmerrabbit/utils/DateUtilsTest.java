package com.github.programmerrabbit.utils;

import com.github.programmerrabbit.test.Test;
import com.github.programmerrabbit.test.Tests;

import java.util.Date;

/**
 * Created by yangwen on 2016/12/3.
 */
public class DateUtilsTest {
    @Test
    public void testDateUtils() {
        System.out.println(DateUtils.format(new Date(), DateUtils.SIMPLE_DATE_PATTERN));
        System.out.println(DateUtils.format(new Date(), DateUtils.STANDARD_DATE_PATTERN));
        System.out.println(DateUtils.format(new Date().getTime(), DateUtils.SIMPLE_DATE_PATTERN));
        System.out.println(DateUtils.format(new Date().getTime(), DateUtils.STANDARD_DATE_PATTERN));
    }

    public static void main(String[] args) {
        Tests.run(DateUtilsTest.class);
    }
}
