package com.github.programmerrabbit.utils;

import com.github.programmerrabbit.test.Assert;
import com.github.programmerrabbit.test.Test;
import com.github.programmerrabbit.test.Tests;

/**
 * Created by yangwen on 2016/12/3.
 */
public class CollectionUtilsTest {
    @Test
    public void testCollectionUtils() {
        Assert.isTrue(CollectionUtils.isEmpty(CollectionUtils.newArrayList()));
        Assert.isTrue(CollectionUtils.isEmpty(null));
    }

    public static void main(String[] args) {
        Tests.run(CollectionUtilsTest.class);
    }
}
