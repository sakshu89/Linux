package com.ibm.icu.impl;

import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    public static <F, S> Pair<F, S> of(F f, S s) {
        if (f != null && s != null) {
            return new Pair<>(f, s);
        }
        og.i("Pair.of requires non null values.");
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return this.first.equals(pair.first) && this.second.equals(pair.second);
    }

    public int hashCode() {
        return this.second.hashCode() + (this.first.hashCode() * 37);
    }
}
