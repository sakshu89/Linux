package defpackage;

import android.os.Build;
import android.os.Trace;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ge4 {
    public static final void a(long j, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            Trace.setCounter(str, j);
        }
    }

    public static final double b(long j) {
        return ((j >>> 11) * 2048.0d) + (j & 2047);
    }
}
