package com.ibm.icu.impl;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class IllegalIcuArgumentException extends IllegalArgumentException {
    private static final long serialVersionUID = 3789261542830211225L;

    public IllegalIcuArgumentException(String str) {
        super(str);
    }

    @Override // java.lang.Throwable
    public synchronized IllegalIcuArgumentException initCause(Throwable th) {
        return (IllegalIcuArgumentException) super.initCause(th);
    }

    public IllegalIcuArgumentException(Throwable th) {
        super(th);
    }

    public IllegalIcuArgumentException(String str, Throwable th) {
        super(str, th);
    }
}
