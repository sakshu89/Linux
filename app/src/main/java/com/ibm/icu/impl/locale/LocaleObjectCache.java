package com.ibm.icu.impl.locale;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class LocaleObjectCache<K, V> {
    private ConcurrentHashMap<K, CacheEntry<K, V>> _map;
    private ReferenceQueue<V> _queue;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CacheEntry<K, V> extends SoftReference<V> {
        private K _key;

        public CacheEntry(K k, V v, ReferenceQueue<V> referenceQueue) {
            super(v, referenceQueue);
            this._key = k;
        }

        public K getKey() {
            return this._key;
        }
    }

    public LocaleObjectCache(int i, float f, int i2) {
        this._queue = new ReferenceQueue<>();
        this._map = new ConcurrentHashMap<>(i, f, i2);
    }

    private void cleanStaleEntries() {
        while (true) {
            CacheEntry cacheEntry = (CacheEntry) this._queue.poll();
            if (cacheEntry == null) {
                return;
            } else {
                this._map.remove(cacheEntry.getKey());
            }
        }
    }

    public abstract V createObject(K k);

    public V get(K k) {
        cleanStaleEntries();
        CacheEntry<K, V> cacheEntry = this._map.get(k);
        V vCreateObject = cacheEntry != null ? cacheEntry.get() : null;
        if (vCreateObject == null) {
            K kNormalizeKey = normalizeKey(k);
            if (kNormalizeKey == null) {
                return null;
            }
            CacheEntry<K, V> cacheEntry2 = this._map.get(kNormalizeKey);
            if (cacheEntry2 != null) {
                vCreateObject = cacheEntry2.get();
            }
            if (vCreateObject != null) {
                return vCreateObject;
            }
            vCreateObject = createObject(kNormalizeKey);
            if (vCreateObject == null) {
                return null;
            }
            CacheEntry<K, V> cacheEntry3 = new CacheEntry<>(kNormalizeKey, vCreateObject, this._queue);
            CacheEntry<K, V> cacheEntryPutIfAbsent = this._map.putIfAbsent(kNormalizeKey, cacheEntry3);
            if (cacheEntryPutIfAbsent != null) {
                V v = cacheEntryPutIfAbsent.get();
                if (v != null) {
                    return v;
                }
                this._map.put(kNormalizeKey, cacheEntry3);
            }
            cleanStaleEntries();
        }
        return vCreateObject;
    }

    public LocaleObjectCache() {
        this(16, 0.75f, 16);
    }

    public K normalizeKey(K k) {
        return k;
    }
}
