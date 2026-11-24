package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class zw1 {
    public int a;
    public int b;
    public long c = 0;
    public long e = ax1.a;
    public long f = 0;

    public int h0() {
        return (int) (this.c & 4294967295L);
    }

    public int i0() {
        return (int) (this.c >> 32);
    }

    public Object k() {
        return null;
    }

    public final void k0() {
        this.a = ky3.c((int) (this.c >> 32), q40.j(this.e), q40.h(this.e));
        int iC = ky3.c((int) (this.c & 4294967295L), q40.i(this.e), q40.g(this.e));
        this.b = iC;
        int i = this.a;
        long j = this.c;
        this.f = (((long) ((i - ((int) (j >> 32))) / 2)) << 32) | (4294967295L & ((long) ((iC - ((int) (j & 4294967295L))) / 2)));
    }

    public abstract void n0(long j, float f, hq0 hq0Var);

    public final void o0(long j) {
        if (l21.a(this.c, j)) {
            return;
        }
        this.c = j;
        k0();
    }

    public final void q0(long j) {
        if (q40.b(this.e, j)) {
            return;
        }
        this.e = j;
        k0();
    }
}
