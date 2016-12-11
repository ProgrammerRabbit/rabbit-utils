package com.github.programmerrabbit.cache;

import com.github.programmerrabbit.concurrent.Executor;
import com.github.programmerrabbit.utils.MapUtils;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by yangwen on 2016/12/3.
 */
public class ConcurrentCache<K, V> implements Cache<K, V> {
    private ExpireTypeEnum expireType;
    private long expireNanos;

    private ConcurrentHashMap<K, CacheEntry<V>> cache = MapUtils.newConcurrentHashMap();

    public ConcurrentCache(ExpireTypeEnum expireType, long duration, TimeUnit timeUnit) {
        this.expireType = expireType;
        this.expireNanos = timeUnit.toNanos(duration);
    }

    public V get(K key, Callable<? extends V> callable) {
        clean(key);

        V value = getIfPresent(key);
        if (value != null) {
            return value;
        } else {
            try {
                V newValue = Executor.getExecutorService().submit(callable).get();
                put(key, newValue);
                return newValue;
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public V getIfPresent(K key) {
        CacheEntry<V> cacheEntry = cache.get(key);
        if (cacheEntry != null && !isExpired(cacheEntry.lastNanos)) {
            if (ExpireTypeEnum.EXPIRE_AFTER_ACCESS == expireType) {
                cacheEntry.lastNanos = nowNanos();
            }
            return cacheEntry.value;
        }
        return null;
    }

    public void put(K key, V value) {
        CacheEntry<V> newCacheEntry = new CacheEntry<V>();
        newCacheEntry.lastNanos = nowNanos();
        newCacheEntry.value = value;
        cache.put(key, newCacheEntry);
    }

    public void asyncPut(final K key, final V value) {
        Executor.getExecutorService().submit(new Callable<Object>() {
            public Object call() throws Exception {
                put(key, value);
                return null;
            }
        });
    }

    public void remove(K key) {
        cache.remove(key);
    }

    public void removeAll() {
        for (K key : cache.keySet()) {
            remove(key);
        }
    }

    public void cleanUp() {
        for (K key : cache.keySet()) {
            clean(key);
        }
    }

    private void clean(K key) {
        CacheEntry<V> cacheEntry = cache.get(key);
        if (cacheEntry != null && isExpired(cacheEntry.lastNanos)) {
            cache.remove(key);
        }
    }

    private long nowNanos() {
        return TimeUnit.MILLISECONDS.toNanos(new Date().getTime());
    }

    private boolean isExpired(long lastNanos) {
        return nowNanos() - lastNanos > expireNanos;
    }

    private class CacheEntry<C> {
        long lastNanos;
        C value;
    }
}
