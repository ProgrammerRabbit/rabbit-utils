package com.github.programmerrabbit.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yangwen on 2016/12/3.
 */
public class MapUtils {
    public static <K, V> HashMap<K, V> newHashMap() {
        return new HashMap<K, V>();
    }

    public static <K, V> LinkedHashMap<K, V> newLinkedHashMap() {
        return new LinkedHashMap<K, V>();
    }

    public static <K, V> ConcurrentHashMap<K, V> newConcurrentHashMap() {
        return new ConcurrentHashMap<K, V>();
    }

    public static <K, V> TreeMap<K, V> newTreeMap() {
        return new TreeMap<K, V>();
    }
}
