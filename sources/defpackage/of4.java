package defpackage;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class of4 {
    public static final ek1 a(ek1 ek1Var, long j, yj2 yj2Var) {
        return ek1Var.c(new xl(1.0f, new cn2(j), yj2Var));
    }

    public static void b(Window window) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 35) {
            e3.g(window);
        } else if (i >= 30) {
            e3.f(window);
        } else {
            View decorView = window.getDecorView();
            decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 1792);
        }
    }

    public static final long c(float f, long j) {
        float fMax = Math.max(0.0f, Float.intBitsToFloat((int) (j >> 32)) - f);
        float fMax2 = Math.max(0.0f, Float.intBitsToFloat((int) (j & 4294967295L)) - f);
        return (((long) Float.floatToRawIntBits(fMax)) << 32) | (((long) Float.floatToRawIntBits(fMax2)) & 4294967295L);
    }
}
