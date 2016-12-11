package com.github.programmerrabbit.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by yangwen on 2016/12/3.
 */
public class Executor {
    private static final ExecutorService executorService = Executors.newFixedThreadPool(64);

    public static ExecutorService getExecutorService() {
        return executorService;
    }
}
