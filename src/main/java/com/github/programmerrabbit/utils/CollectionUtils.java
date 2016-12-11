package com.github.programmerrabbit.utils;

import java.util.*;

/**
 * Created by yangwen on 2016/12/3.
 */
public class CollectionUtils {
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() == 0;
    }

    public static boolean isNotEmpty(Collection collection) {
        return !isEmpty(collection);
    }

    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList<T>();
    }

    public static <T> LinkedList<T> newLinkedList() {
        return new LinkedList<T>();
    }

    public static <T> HashSet<T> newHashSet() {
        return new HashSet<T>();
    }

    public static <T> LinkedHashSet<T> newLinkedHashSet() {
        return new LinkedHashSet<T>();
    }

    public static <T> TreeSet<T> newTreeSet() {
        return new TreeSet<T>();
    }
}
