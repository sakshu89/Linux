package defpackage;

import com.ibm.icu.text.ArabicShaping;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bz1 {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final boolean d;
    public final boolean e;

    public bz1(boolean z, xe2 xe2Var, boolean z2) {
        m30 m30Var = fb.a;
        int i = !z ? 262152 : ArabicShaping.TASHKEEL_BEGIN;
        i = xe2Var == xe2.b ? i | 8192 : i;
        i = z2 ? i : i | 512;
        boolean z3 = xe2Var == xe2.a;
        this.a = i;
        this.b = z3;
        this.c = true;
        this.d = true;
        this.e = true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bz1)) {
            return false;
        }
        bz1 bz1Var = (bz1) obj;
        return this.a == bz1Var.a && this.b == bz1Var.b && this.c == bz1Var.c && this.d == bz1Var.d && this.e == bz1Var.e;
    }

    public final int hashCode() {
        return Boolean.hashCode(false) + ky0.e(ky0.e(ky0.e(ky0.e(this.a * 31, 31, this.b), 31, this.c), 31, this.d), 31, this.e);
    }
}
