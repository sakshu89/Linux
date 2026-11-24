package defpackage;

import android.os.Trace;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class r13 {
    public static boolean a() {
        return Trace.isEnabled();
    }

    public static void b(int i, String str) {
        Trace.setCounter(str, i);
    }
}
