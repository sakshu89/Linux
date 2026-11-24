package com.ibm.icu.impl;

import defpackage.cq;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class Assert {
    public static void assrt(String str, boolean z) {
        if (z) {
            return;
        }
        og.n(cq.v("assert '", str, "' failed"));
    }

    public static void fail(String str) {
        throw new IllegalStateException(cq.v("failure '", str, "'"));
    }

    public static void fail(Exception exc) {
        fail(exc.toString());
    }

    public static void assrt(boolean z) {
        if (z) {
            return;
        }
        og.n("assert failed");
    }
}
