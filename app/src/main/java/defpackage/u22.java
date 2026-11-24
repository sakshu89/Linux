package defpackage;

import android.os.SystemClock;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.a;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class u22 implements cq1 {
    public final int a;
    public final long b;
    public final long c;
    public final Object e;
    public final Object f;

    public u22(int i, int i2, long j) {
        long j2 = (i2 & 4) != 0 ? 0L : 700L;
        t22 t22Var = t22.k;
        this.a = i;
        this.b = j;
        this.c = j2;
        this.e = t22Var;
        if (i <= 0) {
            og.i("maxCalls must be positive");
            throw null;
        }
        if (j > 0) {
            this.f = new hg();
        } else {
            og.i("windowMillis must be positive");
            throw null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0031 A[RETURN] */
    public static c40 c(wd3 wd3Var, a aVar, int i) {
        xf4 xf4Var = aVar.u;
        c40 c40Var = xf4Var == null ? null : xf4Var.e;
        if (c40Var != null && c40Var.b) {
            int[] iArr = c40Var.e;
            int i2 = 0;
            if (iArr == null) {
                int[] iArr2 = c40Var.i;
                if (iArr2 != null) {
                    while (i2 < iArr2.length) {
                        if (iArr2[i2] != i) {
                            i2++;
                        }
                    }
                    if (wd3Var.l < c40Var.f) {
                        return c40Var;
                    }
                } else if (wd3Var.l < c40Var.f) {
                    return c40Var;
                }
            } else {
                while (i2 < iArr.length) {
                    if (iArr[i2] != i) {
                        i2++;
                    } else if (wd3Var.l < c40Var.f) {
                        return c40Var;
                    }
                }
            }
        }
        return null;
    }

    public void a(long j) {
        hg hgVar = (hg) this.f;
        while (!hgVar.isEmpty() && j - ((Number) hgVar.first()).longValue() >= this.b) {
            hgVar.removeFirst();
        }
    }

    public boolean b() {
        synchronized (((hg) this.f)) {
            long jLongValue = ((Number) ((fq0) this.e).a()).longValue();
            a(jLongValue);
            if (this.c > 0 && !((hg) this.f).isEmpty() && jLongValue - ((Number) ((hg) this.f).last()).longValue() < this.c) {
                return false;
            }
            hg hgVar = (hg) this.f;
            if (hgVar.c >= this.a) {
                return false;
            }
            hgVar.addLast(Long.valueOf(jLongValue));
            return true;
        }
    }

    @Override // defpackage.cq1
    public void r(et4 et4Var) {
        int i;
        int i2;
        int i3;
        Exception exc;
        int i4;
        int i5;
        long j;
        long j2;
        if (((qu0) this.e).a()) {
            r82 r82Var = (r82) q82.D().a;
            if (r82Var == null || r82Var.b) {
                wd3 wd3Var = (wd3) ((qu0) this.e).j.get((se) this.f);
                if (wd3Var != null) {
                    je jeVar = wd3Var.b;
                    if (jeVar instanceof a) {
                        a aVar = (a) jeVar;
                        int i6 = 0;
                        boolean z = this.b > 0;
                        int i7 = aVar.p;
                        if (r82Var != null) {
                            z &= r82Var.c;
                            int i8 = r82Var.e;
                            int i9 = r82Var.f;
                            i = r82Var.a;
                            if (aVar.u != null && !aVar.d()) {
                                c40 c40VarC = c(wd3Var, aVar, this.a);
                                if (c40VarC == null) {
                                    return;
                                }
                                boolean z2 = c40VarC.c && this.b > 0;
                                i9 = c40VarC.f;
                                z = z2;
                            }
                            i3 = i8;
                            i2 = i9;
                        } else {
                            i = 0;
                            i2 = 100;
                            i3 = 5000;
                        }
                        qu0 qu0Var = (qu0) this.e;
                        int iElapsedRealtime = -1;
                        if (et4Var.c()) {
                            i5 = 0;
                        } else {
                            if (et4Var.d) {
                                i5 = 100;
                            } else {
                                synchronized (et4Var.a) {
                                    exc = et4Var.f;
                                }
                                if (exc instanceof qe) {
                                    Status status = ((qe) exc).a;
                                    i4 = status.a;
                                    x30 x30Var = status.e;
                                    if (x30Var != null) {
                                        i5 = i4;
                                        i6 = x30Var.b;
                                    }
                                } else {
                                    i4 = 101;
                                }
                                i5 = i4;
                            }
                            i6 = -1;
                        }
                        if (z) {
                            long j3 = this.b;
                            long j4 = this.c;
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            iElapsedRealtime = (int) (SystemClock.elapsedRealtime() - j4);
                            j2 = jCurrentTimeMillis;
                            j = j3;
                        } else {
                            j = 0;
                            j2 = 0;
                        }
                        de3 de3Var = new de3(new mj1(this.a, i5, i6, j, j2, null, null, i7, iElapsedRealtime), i, i3, i2);
                        we3 we3Var = qu0Var.m;
                        we3Var.sendMessage(we3Var.obtainMessage(18, de3Var));
                    }
                }
            }
        }
    }

    public u22(qu0 qu0Var, int i, se seVar, long j, long j2) {
        this.e = qu0Var;
        this.a = i;
        this.f = seVar;
        this.b = j;
        this.c = j2;
    }
}
