package com.github.programmerrabbit.cache;

import com.github.programmerrabbit.test.Test;
import com.github.programmerrabbit.test.Tests;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * Created by yangwen on 2016/12/3.
 */
public class CacheTest {
    @Test
    public void testCache() {
        Cache<String, String> cache = new ConcurrentCache<String, String>(ExpireTypeEnum.EXPIRE_AFTER_WRITE, 1, TimeUnit.MINUTES);
        for (int i = 0; i < 5; ++ i) {
            System.out.println(cache.get("hello", new Callable<String>() {
                public String call() throws Exception {
                    return "world";
                }
            }));
        }
    }

    public static void main(String[] args) {
        Tests.run(CacheTest.class);
    }
}
