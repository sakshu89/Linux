package dagger.hilt.internal;

import defpackage.dk0;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class Preconditions {
    private Preconditions() {
    }

    public static void checkArgument(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(String.format(str, objArr));
        }
    }

    public static <T> T checkNotNull(T t, String str) {
        if (t != null) {
            return t;
        }
        dk0.n(str);
        return null;
    }

    public static void checkState(boolean z, String str, Object... objArr) {
        if (!z) {
            throw new IllegalStateException(String.format(str, objArr));
        }
    }

    public static <T> T checkNotNull(T t) {
        t.getClass();
        return t;
    }
}
