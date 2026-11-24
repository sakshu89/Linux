package com.ibm.icu.util;

import defpackage.cq;
import defpackage.ky0;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class IllformedLocaleException extends RuntimeException {
    private static final long serialVersionUID = 1;
    private int _errIdx;

    public IllformedLocaleException(String str, int i) {
        super(ky0.j(str, i < 0 ? "" : cq.h(" [at index ", i, "]")));
        this._errIdx = i;
    }

    public int getErrorIndex() {
        return this._errIdx;
    }

    public IllformedLocaleException(String str) {
        super(str);
        this._errIdx = -1;
    }

    public IllformedLocaleException() {
        this._errIdx = -1;
    }
}
