package com.ibm.icu.impl;

import defpackage.cq;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ImmutableEntry<K, V> implements Map.Entry<K, V> {
    final K k;
    final V v;

    public ImmutableEntry(K k, V v) {
        this.k = k;
        this.v = v;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        try {
            Map.Entry entry = (Map.Entry) obj;
            return UnicodeMap.areEqual(entry.getKey(), this.k) && UnicodeMap.areEqual(entry.getValue(), this.v);
        } catch (ClassCastException unused) {
        }
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return this.k;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return this.v;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        K k = this.k;
        int iHashCode = k == null ? 0 : k.hashCode();
        V v = this.v;
        return iHashCode ^ (v != null ? v.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return cq.k(String.valueOf(this.k), "=", String.valueOf(this.v));
    }
}
