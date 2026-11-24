package com.ibm.icu.util;

import java.io.IOException;
import java.io.UncheckedIOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class ICUUncheckedIOException extends UncheckedIOException {
    private static final long serialVersionUID = 1210263498513384449L;
    private int serialVersion;

    @Deprecated
    public ICUUncheckedIOException(Throwable th) {
        super(th instanceof IOException ? (IOException) th : new IOException(th));
        this.serialVersion = 1;
    }

    private Object readResolve() {
        if (this.serialVersion == 0) {
            IOException cause = null;
            boolean z = false;
            try {
                cause = getCause();
            } catch (ClassCastException unused) {
                z = true;
            } catch (NullPointerException unused2) {
            }
            if (cause == null) {
                IOException iOException = new IOException(getMessage());
                iOException.setStackTrace(getStackTrace());
                if (z) {
                    ICUUncheckedIOException iCUUncheckedIOException = new ICUUncheckedIOException(getMessage(), iOException);
                    iCUUncheckedIOException.setStackTrace(getStackTrace());
                    return iCUUncheckedIOException;
                }
                initCause(iOException);
            }
            this.serialVersion = 1;
        }
        return this;
    }

    @Deprecated
    public ICUUncheckedIOException(String str) {
        super(str, new IOException(str));
        this.serialVersion = 1;
    }

    @Deprecated
    public ICUUncheckedIOException() {
        super(new IOException());
        this.serialVersion = 1;
    }

    @Deprecated
    public ICUUncheckedIOException(String str, Throwable th) {
        super(str, th instanceof IOException ? (IOException) th : new IOException(th));
        this.serialVersion = 1;
    }
}
