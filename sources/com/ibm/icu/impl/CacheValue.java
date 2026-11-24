package com.ibm.icu.impl;

import defpackage.og;
import java.lang.ref.Reference;
import java.lang.ref.SoftReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class CacheValue<V> {
    private static volatile Strength strength = Strength.SOFT;
    private static final CacheValue NULL_VALUE = new NullValue(0);

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class SoftValue<V> extends CacheValue<V> {
        private volatile Reference<V> ref;

        public SoftValue(V v) {
            this.ref = new SoftReference(v);
        }

        @Override // com.ibm.icu.impl.CacheValue
        public V get() {
            return this.ref.get();
        }

        @Override // com.ibm.icu.impl.CacheValue
        public synchronized V resetIfCleared(V v) {
            V v2 = this.ref.get();
            if (v2 != null) {
                return v2;
            }
            this.ref = new SoftReference(v);
            return v;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Strength {
        STRONG,
        SOFT
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class StrongValue<V> extends CacheValue<V> {
        private V value;

        public StrongValue(V v) {
            this.value = v;
        }

        @Override // com.ibm.icu.impl.CacheValue
        public V get() {
            return this.value;
        }

        @Override // com.ibm.icu.impl.CacheValue
        public V resetIfCleared(V v) {
            return this.value;
        }
    }

    public static boolean futureInstancesWillBeStrong() {
        return strength == Strength.STRONG;
    }

    public static <V> CacheValue<V> getInstance(V v) {
        if (v == null) {
            return NULL_VALUE;
        }
        return strength == Strength.STRONG ? new StrongValue(v) : new SoftValue(v);
    }

    public static void setStrength(Strength strength2) {
        strength = strength2;
    }

    public abstract V get();

    public boolean isNull() {
        return false;
    }

    public abstract V resetIfCleared(V v);

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NullValue<V> extends CacheValue<V> {
        public /* synthetic */ NullValue(int i) {
            this();
        }

        @Override // com.ibm.icu.impl.CacheValue
        public V get() {
            return null;
        }

        @Override // com.ibm.icu.impl.CacheValue
        public boolean isNull() {
            return true;
        }

        @Override // com.ibm.icu.impl.CacheValue
        public V resetIfCleared(V v) {
            if (v == null) {
                return null;
            }
            og.q("resetting a null value to a non-null value");
            return null;
        }

        private NullValue() {
        }
    }
}
