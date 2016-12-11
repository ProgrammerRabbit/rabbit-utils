package com.github.programmerrabbit.utils;

import com.github.programmerrabbit.test.Assert;
import com.github.programmerrabbit.test.Test;
import com.github.programmerrabbit.test.Tests;

/**
 * Created by yangwen on 2016/12/3.
 */
public class StringUtilsTest {
    @Test
    public void testStringUtils() {
        Assert.isTrue(StringUtils.isNullOrEmpty(""));
        Assert.isTrue(StringUtils.isNullOrEmpty(null));
    }

    public static void main(String[] args) {
        Tests.run(StringUtilsTest.class);
    }
}
