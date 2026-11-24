package defpackage;

import android.os.SystemClock;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vq implements s63 {
    public final long a;
    public long b = 0;
    public final Object c;

    public vq(u63 u63Var) {
        this.c = u63Var;
        this.a = ((long) (u63Var.g() + u63Var.e())) * 1000000;
    }

    @Override // defpackage.s63
    public long a(vd vdVar, vd vdVar2, vd vdVar3) {
        return Long.MAX_VALUE;
    }

    public int b() {
        if (!((xq) this.c).c()) {
            return 700;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.b == -1) {
            this.b = jUptimeMillis;
        }
        long j = jUptimeMillis - this.b;
        if (j <= 120000) {
            return 1000;
        }
        return j <= 300000 ? 2000 : 4000;
    }

    public int c() {
        boolean zC = ((xq) this.c).c();
        long j = this.a;
        if (zC) {
            if (j > 0) {
                return Math.min((int) j, 1800000);
            }
            return 1800000;
        }
        if (j > 0) {
            return Math.min((int) j, 10000);
        }
        return 10000;
    }

    public long d(long j) {
        long j2 = j + this.b;
        if (j2 <= 0) {
            return 0L;
        }
        long j3 = this.a;
        return j2 - ((j2 / j3) * j3);
    }

    @Override // defpackage.s63
    public vd f(long j, vd vdVar, vd vdVar2, vd vdVar3) {
        return ((u63) this.c).f(d(j), vdVar, vdVar2, i(j, vdVar, vdVar3, vdVar2));
    }

    @Override // defpackage.s63
    public vd h(long j, vd vdVar, vd vdVar2, vd vdVar3) {
        return ((u63) this.c).h(d(j), vdVar, vdVar2, i(j, vdVar, vdVar3, vdVar2));
    }

    public vd i(long j, vd vdVar, vd vdVar2, vd vdVar3) {
        long j2 = this.b;
        long j3 = j + j2;
        long j4 = this.a;
        return j3 > j4 ? ((u63) this.c).f(j4 - j2, vdVar, vdVar3, vdVar2) : vdVar2;
    }

    @Override // defpackage.s63
    public boolean isInfinite() {
        return true;
    }

    public vq(xq xqVar, long j) {
        this.c = xqVar;
        this.a = j;
    }
}
