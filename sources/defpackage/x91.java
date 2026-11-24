package defpackage;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x91 implements ph1 {
    public final y91 a;
    public final int b;
    public final boolean c;
    public final float d;
    public final ph1 e;
    public final float f;
    public final boolean g;
    public final s70 h;
    public final jc0 i;
    public final long j;
    public final List k;
    public final int l;
    public final int m;
    public final int n;
    public final js1 o;
    public final int p;
    public final int q;

    public x91(y91 y91Var, int i, boolean z, float f, ph1 ph1Var, float f2, boolean z2, s70 s70Var, jc0 jc0Var, long j, List list, int i2, int i3, int i4, js1 js1Var, int i5, int i6) {
        this.a = y91Var;
        this.b = i;
        this.c = z;
        this.d = f;
        this.e = ph1Var;
        this.f = f2;
        this.g = z2;
        this.h = s70Var;
        this.i = jc0Var;
        this.j = j;
        this.k = list;
        this.l = i2;
        this.m = i3;
        this.n = i4;
        this.o = js1Var;
        this.p = i5;
        this.q = i6;
    }

    @Override // defpackage.ph1
    public final int a() {
        return this.e.a();
    }

    @Override // defpackage.ph1
    public final int b() {
        return this.e.b();
    }

    @Override // defpackage.ph1
    public final void c() {
        this.e.c();
    }

    @Override // defpackage.ph1
    public final Map d() {
        return this.e.d();
    }

    @Override // defpackage.ph1
    public final hq0 e() {
        return this.e.e();
    }

    public final x91 f(int i, boolean z) {
        y91 y91Var;
        if (this.g) {
            return null;
        }
        List list = this.k;
        if (list.isEmpty() || (y91Var = this.a) == null) {
            return null;
        }
        int i2 = y91Var.l;
        int i3 = this.b - i;
        if (i3 < 0 || i3 >= i2) {
            return null;
        }
        y91 y91Var2 = (y91) mz.x(list);
        y91 y91Var3 = (y91) mz.D(list);
        if (y91Var2.n || y91Var3.n) {
            return null;
        }
        int i4 = y91Var2.j;
        int i5 = this.m;
        int i6 = this.l;
        if (i < 0) {
            if (Math.min((i4 + y91Var2.l) - i6, (y91Var3.j + y91Var3.l) - i5) <= (-i)) {
                return null;
            }
        } else if (Math.min(i6 - i4, i5 - y91Var3.j) <= i) {
            return null;
        }
        int size = list.size();
        for (int i7 = 0; i7 < size; i7++) {
            y91 y91Var4 = (y91) list.get(i7);
            y91Var4.getClass();
            int[] iArr = y91Var4.p;
            if (!y91Var4.n) {
                y91Var4.j += i;
                int length = iArr.length;
                for (int i8 = 0; i8 < length; i8++) {
                    if ((i8 & 1) != 0) {
                        iArr[i8] = iArr[i8] + i;
                    }
                }
                if (z) {
                    int size2 = y91Var4.b.size();
                    for (int i9 = 0; i9 < size2; i9++) {
                        ky0.x(y91Var4.i.a.g(y91Var4.g));
                    }
                }
            }
        }
        return new x91(this.a, i3, this.c || i > 0, i, this.e, this.f, this.g, this.h, this.i, this.j, list, this.l, this.m, this.n, this.o, this.p, this.q);
    }

    public final long g() {
        ph1 ph1Var = this.e;
        return (((long) ph1Var.b()) << 32) | (((long) ph1Var.a()) & 4294967295L);
    }
}
