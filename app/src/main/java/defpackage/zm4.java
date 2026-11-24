package defpackage;

import android.os.Build;
import android.widget.EdgeEffect;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class zm4 {
    public static float a(EdgeEffect edgeEffect, float f, float f2, jc0 jc0Var) {
        float f3 = wg0.a;
        double dB = jc0Var.b() * 386.0878f * 160.0f * 0.84f;
        double dAbs = Math.abs(f) * 0.35f;
        double d = ((double) wg0.a) * dB;
        float fExp = (float) (Math.exp((wg0.b / wg0.c) * Math.log(dAbs / d)) * d);
        int i = Build.VERSION.SDK_INT;
        if (fExp > (i >= 31 ? le.c(edgeEffect) : 0.0f) * f2) {
            return 0.0f;
        }
        int iF = hh1.f(f);
        if (i >= 31) {
            edgeEffect.onAbsorb(iF);
            return f;
        }
        if (edgeEffect.isFinished()) {
            edgeEffect.onAbsorb(iF);
        }
        return f;
    }
}
