package defpackage;

import com.ibm.icu.text.ArabicShaping;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r72 implements jc0 {
    public es4 H;
    public int a;
    public float b = 1.0f;
    public float c = 1.0f;
    public float e = 1.0f;
    public float f;
    public long i;
    public long j;
    public float k;
    public long n;
    public yj2 s;
    public boolean t;
    public long u;
    public jc0 v;
    public z61 w;
    public int x;

    public r72() {
        long j = zu0.a;
        this.i = j;
        this.j = j;
        this.k = 8.0f;
        this.n = y13.a;
        this.s = y34.a;
        this.u = 9205357640488583168L;
        this.v = em4.a();
        this.w = z61.a;
        this.x = 3;
    }

    public final void a() {
        h(1.0f);
        i(1.0f);
        d(1.0f);
        k(0.0f);
        long j = zu0.a;
        e(j);
        n(j);
        if (this.k != 8.0f) {
            this.a |= 2048;
            this.k = 8.0f;
        }
        o(y13.a);
        m(y34.a);
        f(false);
        if (this.x != 3) {
            this.a |= ArabicShaping.TASHKEEL_RESIZE;
            this.x = 3;
        }
        this.u = 9205357640488583168L;
        this.H = null;
        this.a = 0;
    }

    @Override // defpackage.jc0
    public final float b() {
        return this.v.b();
    }

    public final void d(float f) {
        if (this.e == f) {
            return;
        }
        this.a |= 4;
        this.e = f;
    }

    public final void e(long j) {
        if (sz.c(this.i, j)) {
            return;
        }
        this.a |= 64;
        this.i = j;
    }

    public final void f(boolean z) {
        if (this.t != z) {
            this.a |= 16384;
            this.t = z;
        }
    }

    public final void h(float f) {
        if (this.b == f) {
            return;
        }
        this.a |= 1;
        this.b = f;
    }

    public final void i(float f) {
        if (this.c == f) {
            return;
        }
        this.a |= 2;
        this.c = f;
    }

    public final void k(float f) {
        if (this.f == f) {
            return;
        }
        this.a |= 32;
        this.f = f;
    }

    @Override // defpackage.jc0
    public final float l() {
        return this.v.l();
    }

    public final void m(yj2 yj2Var) {
        if (g31.a(this.s, yj2Var)) {
            return;
        }
        this.a |= 8192;
        this.s = yj2Var;
    }

    public final void n(long j) {
        if (sz.c(this.j, j)) {
            return;
        }
        this.a |= 128;
        this.j = j;
    }

    public final void o(long j) {
        long j2 = this.n;
        int i = y13.b;
        if (j2 == j) {
            return;
        }
        this.a |= 4096;
        this.n = j;
    }
}
