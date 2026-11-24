package com.ibm.icu.util;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ICUException extends RuntimeException {
    private static final long serialVersionUID = -3067399656455755650L;

    public ICUException() {
    }

    public ICUException(String str) {
        super(str);
    }

    public ICUException(Throwable th) {
        super(th);
    }

    public ICUException(String str, Throwable th) {
        super(str, th);
    }
}
