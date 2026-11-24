package defpackage;

import android.os.Bundle;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class pz3 {
    public static r72 a;

    public static final Bundle a(String str, Bundle bundle) {
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 != null) {
            return bundle2;
        }
        og.i(cq.v("No valid saved state was found for the key '", str, "'. It may be missing, null, or not of the expected type. This can occur if the value was saved with a different type or if the saved state was modified unexpectedly."));
        return null;
    }

    public static final ek1 b(ek1 ek1Var, float f, float f2, long j, yj2 yj2Var, boolean z, long j2, long j3) {
        return ek1Var.c(new wu0(f, f2, j, yj2Var, z, j2, j3));
    }

    public static ek1 c(ek1 ek1Var, float f, yj2 yj2Var, int i) {
        if ((i & 4) != 0) {
            f = 1.0f;
        }
        float f2 = f;
        long j = y13.a;
        if ((i & 2048) != 0) {
            yj2Var = y34.a;
        }
        long j2 = zu0.a;
        return b(ek1Var, f2, 0.0f, j, yj2Var, true, j2, j2);
    }
}
