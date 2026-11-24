package com.ibm.icu.util;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ICUCloneNotSupportedException extends ICUException {
    private static final long serialVersionUID = -4824446458488194964L;

    public ICUCloneNotSupportedException() {
    }

    public ICUCloneNotSupportedException(String str) {
        super(str);
    }

    public ICUCloneNotSupportedException(Throwable th) {
        super(th);
    }

    public ICUCloneNotSupportedException(String str, Throwable th) {
        super(str, th);
    }
}
