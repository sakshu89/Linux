package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class bm2 {
    public gm2 a;
    public long b;
    public boolean c;
    public int d;

    public bm2(long j, gm2 gm2Var) {
        int iA;
        int iNumberOfTrailingZeros;
        this.a = gm2Var;
        this.b = j;
        sa2 sa2Var = im2.a;
        if (j != 0) {
            gm2 gm2VarD = d();
            long j2 = gm2VarD.c;
            long[] jArr = gm2VarD.e;
            if (jArr != null) {
                j = jArr[0];
            } else {
                long j3 = gm2VarD.b;
                if (j3 != 0) {
                    iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j3);
                } else {
                    long j4 = gm2VarD.a;
                    if (j4 != 0) {
                        j2 += 64;
                        iNumberOfTrailingZeros = Long.numberOfTrailingZeros(j4);
                    }
                }
                j = ((long) iNumberOfTrailingZeros) + j2;
            }
            synchronized (im2.c) {
                iA = im2.f.a(j);
            }
        } else {
            iA = -1;
        }
        this.d = iA;
    }

    public static void q(bm2 bm2Var) {
        im2.b.C(bm2Var);
    }

    public final void a() {
        synchronized (im2.c) {
            b();
            p();
        }
    }

    public void b() {
        im2.d = im2.d.b(g());
    }

    public abstract void c();

    public gm2 d() {
        return this.a;
    }

    public abstract hq0 e();

    public abstract boolean f();

    public long g() {
        return this.b;
    }

    public int h() {
        return 0;
    }

    public abstract hq0 i();

    public final bm2 j() {
        kf kfVar = im2.b;
        bm2 bm2Var = (bm2) kfVar.l();
        kfVar.C(this);
        return bm2Var;
    }

    public abstract void k();

    public abstract void l();

    public abstract void m();

    public abstract void n(nr2 nr2Var);

    public final void o() {
        int i = this.d;
        if (i >= 0) {
            im2.u(i);
            this.d = -1;
        }
    }

    public void p() {
        o();
    }

    public void r(gm2 gm2Var) {
        this.a = gm2Var;
    }

    public void s(long j) {
        this.b = j;
    }

    public void t(int i) {
        throw new IllegalStateException("Updating write count is not supported for this snapshot");
    }

    public abstract bm2 u(hq0 hq0Var);
}
