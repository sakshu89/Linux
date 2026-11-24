package com.ibm.icu.number;

import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class IntegerWidth {
    static final IntegerWidth DEFAULT = new IntegerWidth(1, -1);
    final int maxInt;
    final int minInt;

    private IntegerWidth(int i, int i2) {
        this.minInt = i;
        this.maxInt = i2;
    }

    public static IntegerWidth zeroFillTo(int i) {
        if (i == 1) {
            return DEFAULT;
        }
        if (i >= 0 && i <= 999) {
            return new IntegerWidth(i, -1);
        }
        og.i("Integer digits must be between 0 and 999 (inclusive)");
        return null;
    }

    public IntegerWidth truncateAt(int i) {
        int i2;
        if (i == this.maxInt) {
            return this;
        }
        if (i >= 0 && i <= 999 && i >= (i2 = this.minInt)) {
            return new IntegerWidth(i2, i);
        }
        int i3 = this.minInt;
        if (i3 == 1 && i == -1) {
            return DEFAULT;
        }
        if (i == -1) {
            return new IntegerWidth(i3, -1);
        }
        og.i("Integer digits must be between -1 and 999 (inclusive)");
        return null;
    }
}
