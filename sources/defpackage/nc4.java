package defpackage;

import android.R;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class nc4 {
    public static final void a(h3 h3Var, gg2 gg2Var) {
        cg2 cg2Var = gg2Var.d;
        gm1 gm1Var = cg2Var.a;
        Object objG = cg2Var.a.g(kg2.x);
        if (objG == null) {
            objG = null;
        }
        if (pc4.a(gg2Var)) {
            Object objG2 = gm1Var.g(bg2.y);
            if (objG2 == null) {
                objG2 = null;
            }
            b2 b2Var = (b2) objG2;
            if (b2Var != null) {
                h3Var.a(new d3(null, R.id.accessibilityActionPageUp, b2Var.a, null));
            }
            Object objG3 = gm1Var.g(bg2.A);
            if (objG3 == null) {
                objG3 = null;
            }
            b2 b2Var2 = (b2) objG3;
            if (b2Var2 != null) {
                h3Var.a(new d3(null, R.id.accessibilityActionPageDown, b2Var2.a, null));
            }
            Object objG4 = gm1Var.g(bg2.z);
            if (objG4 == null) {
                objG4 = null;
            }
            b2 b2Var3 = (b2) objG4;
            if (b2Var3 != null) {
                h3Var.a(new d3(null, R.id.accessibilityActionPageLeft, b2Var3.a, null));
            }
            Object objG5 = gm1Var.g(bg2.B);
            if (objG5 == null) {
                objG5 = null;
            }
            b2 b2Var4 = (b2) objG5;
            if (b2Var4 != null) {
                h3Var.a(new d3(null, R.id.accessibilityActionPageRight, b2Var4.a, null));
            }
        }
    }

    public static final long b(double d) {
        return d((float) d, 4294967296L);
    }

    public static final long c(int i) {
        return d(i, 4294967296L);
    }

    public static final long d(float f, long j) {
        long jFloatToRawIntBits = j | (((long) Float.floatToRawIntBits(f)) & 4294967295L);
        c03[] c03VarArr = b03.b;
        return jFloatToRawIntBits;
    }
}
