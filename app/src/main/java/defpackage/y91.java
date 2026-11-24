package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class y91 {
    public final int a;
    public final List b;
    public final jl c;
    public final z61 d;
    public final int e;
    public final long f;
    public final Object g;
    public final Object h;
    public final t81 i;
    public int j;
    public final int k;
    public final int l;
    public final int m;
    public boolean n;
    public int o = Integer.MIN_VALUE;
    public final int[] p;

    public y91(int i, List list, jl jlVar, z61 z61Var, int i2, int i3, int i4, long j, Object obj, Object obj2, t81 t81Var, long j2) {
        this.a = i;
        this.b = list;
        this.c = jlVar;
        this.d = z61Var;
        this.e = i4;
        this.f = j;
        this.g = obj;
        this.h = obj2;
        this.i = t81Var;
        int size = list.size();
        int i5 = 0;
        int iMax = 0;
        for (int i6 = 0; i6 < size; i6++) {
            zw1 zw1Var = (zw1) list.get(i6);
            i5 += zw1Var.b;
            iMax = Math.max(iMax, zw1Var.a);
        }
        this.k = i5;
        int i7 = i5 + this.e;
        this.l = i7 >= 0 ? i7 : 0;
        this.m = iMax;
        this.p = new int[this.b.size() * 2];
    }

    public final long a(int i) {
        if (i == 0 && this.b.size() == 0) {
            return ((long) this.j) & 4294967295L;
        }
        int i2 = i * 2;
        int[] iArr = this.p;
        int i3 = iArr[i2];
        return (((long) iArr[i2 + 1]) & 4294967295L) | (((long) i3) << 32);
    }

    public final void b(yw1 yw1Var) {
        kt1 kt1Var = kt1.n;
        if (this.o == Integer.MIN_VALUE) {
            c11.a("position() should be called first");
        }
        List list = this.b;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            zw1 zw1Var = (zw1) list.get(i);
            int i2 = zw1Var.b;
            long jA = a(i);
            ky0.x(this.i.a.g(this.g));
            long jC = e21.c(jA, this.f);
            int i3 = ax1.b;
            yw1Var.getClass();
            yw1.a(yw1Var, zw1Var);
            zw1Var.n0(e21.c(jC, zw1Var.f), 0.0f, kt1Var);
        }
    }

    public final void c(int i, int i2, int i3) {
        this.j = i;
        this.o = i3;
        List list = this.b;
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            zw1 zw1Var = (zw1) list.get(i4);
            int i5 = i4 * 2;
            jl jlVar = this.c;
            if (jlVar == null) {
                c11.b("null horizontalAlignment when isVertical == true");
                og.k();
                return;
            }
            int iA = jlVar.a(zw1Var.a, i2, this.d);
            int[] iArr = this.p;
            iArr[i5] = iA;
            iArr[i5 + 1] = i;
            i += zw1Var.b;
        }
    }
}
