package com.ibm.icu.impl;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface ICUCache<K, V> {
    public static final Object NULL = new Object();
    public static final int SOFT = 0;
    public static final int WEAK = 1;

    void clear();

    V get(Object obj);

    void put(K k, V v);
}
