package com.ibm.icu.impl;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class SimpleCache<K, V> implements ICUCache<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private volatile Reference<Map<K, V>> cacheRef;
    private final int capacity;
    private final Object lock;
    private final int type;

    public SimpleCache(int i, int i2) {
        this.cacheRef = null;
        this.lock = new Object();
        if (i == 1) {
            this.type = i;
        } else {
            this.type = 0;
        }
        if (i2 > 0) {
            this.capacity = i2;
        } else {
            this.capacity = 16;
        }
    }

    @Override // com.ibm.icu.impl.ICUCache
    public void clear() {
        this.cacheRef = null;
    }

    @Override // com.ibm.icu.impl.ICUCache
    public V get(Object obj) {
        Map<K, V> map;
        Reference<Map<K, V>> reference = this.cacheRef;
        if (reference == null || (map = reference.get()) == null) {
            return null;
        }
        return map.get(obj);
    }

    @Override // com.ibm.icu.impl.ICUCache
    public void put(K k, V v) {
        Reference<Map<K, V>> reference = this.cacheRef;
        Map<K, V> concurrentHashMap = reference != null ? reference.get() : null;
        if (concurrentHashMap == null) {
            synchronized (this.lock) {
                try {
                    Reference<Map<K, V>> reference2 = this.cacheRef;
                    if (reference2 != null) {
                        concurrentHashMap = reference2.get();
                    }
                    if (concurrentHashMap == null) {
                        concurrentHashMap = new ConcurrentHashMap<>(this.capacity);
                        this.cacheRef = this.type == 1 ? new WeakReference<>(concurrentHashMap) : new SoftReference<>(concurrentHashMap);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        concurrentHashMap.put(k, v);
    }

    public SimpleCache(int i) {
        this(i, 16);
    }

    public SimpleCache() {
        this(0, 16);
    }
}
