package com.github.programmerrabbit.cache;

import java.util.concurrent.Callable;

/**
 * Created by yangwen on 2016/12/3.
 */
public interface Cache<K, V> {
    V get(K key, Callable<? extends V> callable);

    V getIfPresent(K key);

    void put(K key, V value);

    void asyncPut(K key, V value);

    void remove(K key);

    void removeAll();

    void cleanUp();
}
