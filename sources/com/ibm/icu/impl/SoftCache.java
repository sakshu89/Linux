package com.ibm.icu.impl;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class SoftCache<K, V, D> extends CacheBase<K, V, D> {
    private ConcurrentHashMap<K, Object> map = new ConcurrentHashMap<>();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.ibm.icu.impl.CacheBase
    public final V getInstance(K k, D d) {
        V v = (V) this.map.get(k);
        if (v == 0) {
            V vCreateInstance = createInstance(k, d);
            V v2 = (V) this.map.putIfAbsent(k, (vCreateInstance == null || !CacheValue.futureInstancesWillBeStrong()) ? CacheValue.getInstance(vCreateInstance) : vCreateInstance);
            if (v2 == 0) {
                return vCreateInstance;
            }
            return !(v2 instanceof CacheValue) ? v2 : (V) ((CacheValue) v2).resetIfCleared(vCreateInstance);
        }
        if (!(v instanceof CacheValue)) {
            return v;
        }
        CacheValue cacheValue = (CacheValue) v;
        if (cacheValue.isNull()) {
            return null;
        }
        V v3 = (V) cacheValue.get();
        return v3 != null ? v3 : (V) cacheValue.resetIfCleared(createInstance(k, d));
    }

    public ConcurrentHashMap<K, Object> getMap() {
        return this.map;
    }
}
