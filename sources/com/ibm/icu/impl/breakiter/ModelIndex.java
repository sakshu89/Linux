package com.ibm.icu.impl.breakiter;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
enum ModelIndex {
    kUWStart(0),
    kBWStart(6),
    kTWStart(9);

    private final int value;

    ModelIndex(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
