package com.ibm.icu.util;

import defpackage.dk0;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class UResourceBundleIterator {
    private UResourceBundle bundle;
    private int index = 0;
    private int size;

    public UResourceBundleIterator(UResourceBundle uResourceBundle) {
        this.size = 0;
        this.bundle = uResourceBundle;
        this.size = uResourceBundle.getSize();
    }

    public boolean hasNext() {
        return this.index < this.size;
    }

    public UResourceBundle next() {
        int i = this.index;
        if (i >= this.size) {
            dk0.d();
            return null;
        }
        UResourceBundle uResourceBundle = this.bundle;
        this.index = i + 1;
        return uResourceBundle.get(i);
    }

    public String nextString() {
        int i = this.index;
        if (i >= this.size) {
            dk0.d();
            return null;
        }
        UResourceBundle uResourceBundle = this.bundle;
        this.index = i + 1;
        return uResourceBundle.getString(i);
    }

    public void reset() {
        this.index = 0;
    }
}
