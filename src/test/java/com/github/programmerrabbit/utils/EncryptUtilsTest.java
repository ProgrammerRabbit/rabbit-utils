package com.github.programmerrabbit.utils;

import com.github.programmerrabbit.test.Test;
import com.github.programmerrabbit.test.Tests;

/**
 * Created by yangwen on 2016/12/3.
 */
public class EncryptUtilsTest {
    @Test
    public void testEncryptUtils() {
        System.out.println("MD5 " + EncryptUtils.MD5("杨文"));
        System.out.println("SHA1 " + EncryptUtils.SHA1("杨文"));
    }

    public static void main(String[] args) {
        Tests.run(EncryptUtilsTest.class);
    }
}
