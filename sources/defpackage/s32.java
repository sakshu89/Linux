package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s32 {
    public final m32 a;
    public final ArrayList b;
    public final int c;
    public final ux d;
    public final lj1 e;
    public final int f;
    public final int g;
    public final int h;
    public int i;

    public s32(m32 m32Var, ArrayList arrayList, int i, ux uxVar, lj1 lj1Var, int i2, int i3, int i4) {
        this.a = m32Var;
        this.b = arrayList;
        this.c = i;
        this.d = uxVar;
        this.e = lj1Var;
        this.f = i2;
        this.g = i3;
        this.h = i4;
    }

    public static s32 a(s32 s32Var, int i, ux uxVar, lj1 lj1Var, int i2) {
        if ((i2 & 1) != 0) {
            i = s32Var.c;
        }
        int i3 = i;
        if ((i2 & 2) != 0) {
            uxVar = s32Var.d;
        }
        ux uxVar2 = uxVar;
        if ((i2 & 4) != 0) {
            lj1Var = s32Var.e;
        }
        lj1 lj1Var2 = lj1Var;
        int i4 = s32Var.f;
        int i5 = s32Var.g;
        int i6 = s32Var.h;
        lj1Var2.getClass();
        return new s32(s32Var.a, s32Var.b, i3, uxVar2, lj1Var2, i4, i5, i6);
    }

    public final z62 b(lj1 lj1Var) {
        lj1Var.getClass();
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i = this.c;
        if (i >= size) {
            og.n("Check failed.");
            return null;
        }
        this.i++;
        ux uxVar = this.d;
        if (uxVar != null) {
            sj0 sj0Var = (sj0) uxVar.c;
            ey0 ey0Var = (ey0) lj1Var.b;
            sj0Var.getClass();
            ey0Var.getClass();
            ey0 ey0Var2 = sj0Var.b.h;
            if (ey0Var.e != ey0Var2.e || !g31.a(ey0Var.d, ey0Var2.d)) {
                dk0.i("network interceptor ", arrayList.get(i - 1), " must retain the same host and port");
                return null;
            }
            if (this.i != 1) {
                dk0.i("network interceptor ", arrayList.get(i - 1), " must call proceed() exactly once");
                return null;
            }
        }
        int i2 = i + 1;
        s32 s32VarA = a(this, i2, null, lj1Var, 58);
        v21 v21Var = (v21) arrayList.get(i);
        z62 z62VarA = v21Var.a(s32VarA);
        if (z62VarA == null) {
            throw new NullPointerException("interceptor " + v21Var + " returned null");
        }
        if (uxVar != null && i2 < arrayList.size() && s32VarA.i != 1) {
            dk0.i("network interceptor ", v21Var, " must call proceed() exactly once");
            return null;
        }
        if (z62VarA.j != null) {
            return z62VarA;
        }
        dk0.i("interceptor ", v21Var, " returned a response with no body");
        return null;
    }
}
