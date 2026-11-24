package com.ibm.icu.impl;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class CalendarCache {
    private int arraySize;
    private long[] keys;
    private int pIndex = 0;
    private int size = 0;
    private int threshold;
    private long[] values;
    private static final int[] primes = {61, 127, 509, 1021, 2039, 4093, 8191, 16381, 32749, 65521, 131071, 262139};
    public static long EMPTY = Long.MIN_VALUE;

    public CalendarCache() {
        int i = primes[0];
        this.arraySize = i;
        this.threshold = (i * 3) / 4;
        this.keys = new long[i];
        this.values = new long[i];
        makeArrays(i);
    }

    private final int findIndex(long j) {
        int iHash = hash(j);
        int iHash2 = 0;
        while (this.values[iHash] != EMPTY && this.keys[iHash] != j) {
            if (iHash2 == 0) {
                iHash2 = hash2(j);
            }
            iHash = (iHash + iHash2) % this.arraySize;
        }
        return iHash;
    }

    private final int hash(long j) {
        int i = this.arraySize;
        int i2 = (int) (((j * 15821) + 1) % ((long) i));
        return i2 < 0 ? i2 + i : i2;
    }

    private final int hash2(long j) {
        int i = this.arraySize;
        return (i - 2) - ((int) (j % ((long) (i - 2))));
    }

    private void makeArrays(int i) {
        this.keys = new long[i];
        this.values = new long[i];
        for (int i2 = 0; i2 < i; i2++) {
            this.values[i2] = EMPTY;
        }
        this.arraySize = i;
        this.threshold = (int) (((double) i) * 0.75d);
        this.size = 0;
    }

    private void rehash() {
        int i = this.arraySize;
        long[] jArr = this.keys;
        long[] jArr2 = this.values;
        int i2 = this.pIndex;
        int[] iArr = primes;
        if (i2 < iArr.length - 1) {
            int i3 = i2 + 1;
            this.pIndex = i3;
            this.arraySize = iArr[i3];
        } else {
            this.arraySize = (i * 2) + 1;
        }
        this.size = 0;
        makeArrays(this.arraySize);
        for (int i4 = 0; i4 < i; i4++) {
            long j = jArr2[i4];
            if (j != EMPTY) {
                put(jArr[i4], j);
            }
        }
    }

    public synchronized long get(long j) {
        return this.values[findIndex(j)];
    }

    public synchronized void put(long j, long j2) {
        try {
            if (this.size >= this.threshold) {
                rehash();
            }
            int iFindIndex = findIndex(j);
            this.keys[iFindIndex] = j;
            this.values[iFindIndex] = j2;
            this.size++;
        } catch (Throwable th) {
            throw th;
        }
    }
}
