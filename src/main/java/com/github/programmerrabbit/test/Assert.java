package com.github.programmerrabbit.test;

/**
 * Created by yangwen on 2016/12/3.
 */
public class Assert {
    public static void isNotNull(Object object) {
        isNotNull(object, "[Assert] object should be not null - rabbit");
    }

    public static void isNotNull(Object object, String message) {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    public static void isTrue(boolean expression) {
        isTrue(expression, "[Assert] expression should be true - rabbit");
    }

    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new IllegalArgumentException(message);
        }
    }
}
