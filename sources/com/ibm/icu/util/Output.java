package com.ibm.icu.util;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class Output<T> {
    public T value;

    public Output(T t) {
        this.value = t;
    }

    public String toString() {
        T t = this.value;
        return t == null ? "null" : t.toString();
    }

    public Output() {
    }
}
