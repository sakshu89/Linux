package defpackage;

import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vu0 {
    public final xu0 a;
    public Outline f;
    public float j;
    public es4 k;
    public na l;
    public na m;
    public boolean n;
    public ew o;
    public fa p;
    public int q;
    public boolean s;
    public long t;
    public long u;
    public long v;
    public boolean w;
    public RectF x;
    public jc0 b = yy3.c;
    public z61 c = z61.a;
    public hq0 d = j7.h0;
    public final h6 e = new h6(13, this);
    public boolean g = true;
    public long h = 0;
    public long i = 9205357640488583168L;
    public final ux r = new ux();

    static {
        String lowerCase = Build.FINGERPRINT.toLowerCase(Locale.ROOT);
        lowerCase.getClass();
        lowerCase.equals("robolectric");
    }

    public vu0(xu0 xu0Var) {
        this.a = xu0Var;
        xu0Var.t(false);
        this.t = 0L;
        this.u = 0L;
        this.v = 9205357640488583168L;
    }

    public final void a() {
        Outline outline;
        if (this.g) {
            boolean z = this.w;
            Outline outline2 = null;
            xu0 xu0Var = this.a;
            if (z || xu0Var.G() > 0.0f) {
                na naVar = this.l;
                if (naVar != null) {
                    RectF rectF = this.x;
                    if (rectF == null) {
                        rectF = new RectF();
                        this.x = rectF;
                    }
                    boolean z2 = naVar instanceof na;
                    if (!z2) {
                        dk0.r("Unable to obtain android.graphics.Path");
                        return;
                    }
                    Path path = naVar.a;
                    path.computeBounds(rectF, false);
                    int i = Build.VERSION.SDK_INT;
                    if (i > 28 || path.isConvex()) {
                        outline = this.f;
                        if (outline == null) {
                            outline = new Outline();
                            this.f = outline;
                        }
                        if (i >= 30) {
                            if (!z2) {
                                dk0.r("Unable to obtain android.graphics.Path");
                                return;
                            }
                            outline.setPath(path);
                        } else {
                            if (!z2) {
                                dk0.r("Unable to obtain android.graphics.Path");
                                return;
                            }
                            outline.setConvexPath(path);
                        }
                        this.n = !outline.canClip();
                    } else {
                        Outline outline3 = this.f;
                        if (outline3 != null) {
                            outline3.setEmpty();
                        }
                        this.n = true;
                        outline = null;
                    }
                    this.l = naVar;
                    if (outline != null) {
                        outline.setAlpha(xu0Var.a());
                        outline2 = outline;
                    }
                    xu0Var.k(outline2, (4294967295L & ((long) Math.round(rectF.height()))) | (((long) Math.round(rectF.width())) << 32));
                    if (this.n && this.w) {
                        xu0Var.t(false);
                        xu0Var.p();
                    } else {
                        xu0Var.t(this.w);
                    }
                } else {
                    xu0Var.t(this.w);
                    Outline outline4 = this.f;
                    if (outline4 == null) {
                        outline4 = new Outline();
                        this.f = outline4;
                    }
                    Outline outline5 = outline4;
                    long jA = cp4.a(this.u);
                    long j = this.h;
                    long j2 = this.i;
                    if (j2 != 9205357640488583168L) {
                        jA = j2;
                    }
                    int i2 = (int) (j >> 32);
                    int i3 = (int) (j & 4294967295L);
                    int i4 = (int) (jA >> 32);
                    int i5 = (int) (jA & 4294967295L);
                    outline5.setRoundRect(Math.round(Float.intBitsToFloat(i2)), Math.round(Float.intBitsToFloat(i3)), Math.round(Float.intBitsToFloat(i4) + Float.intBitsToFloat(i2)), Math.round(Float.intBitsToFloat(i5) + Float.intBitsToFloat(i3)), this.j);
                    outline5.setAlpha(xu0Var.a());
                    xu0Var.k(outline5, (4294967295L & ((long) Math.round(Float.intBitsToFloat(i5)))) | (((long) Math.round(Float.intBitsToFloat(i4))) << 32));
                }
            } else {
                xu0Var.t(false);
                xu0Var.k(null, 0L);
            }
        }
        this.g = false;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x005c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x005e A[LOOP:0: B:14:0x0027->B:24:0x005e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:29:0x0061 A[EDGE_INSN: B:29:0x0061->B:25:0x0061 BREAK  A[LOOP:0: B:14:0x0027->B:24:0x005e], SYNTHETIC] */
    public final void b() {
        if (this.s && this.q == 0) {
            ux uxVar = this.r;
            vu0 vu0Var = (vu0) uxVar.b;
            if (vu0Var != null) {
                vu0Var.e();
                uxVar.b = null;
            }
            hm1 hm1Var = (hm1) uxVar.d;
            if (hm1Var != null) {
                Object[] objArr = hm1Var.b;
                long[] jArr = hm1Var.a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                            if (i != length) {
                                break;
                                break;
                            }
                            i++;
                        } else {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128) {
                                    ((vu0) objArr[(i << 3) + i3]).e();
                                }
                                j >>= 8;
                            }
                            if (i2 != 8) {
                                break;
                            } else if (i != length) {
                                break;
                            } else {
                                i++;
                            }
                        }
                    }
                }
                hm1Var.b();
            }
            this.a.p();
        }
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0088 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:30:0x008a A[LOOP:0: B:20:0x0053->B:30:0x008a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:34:0x008d A[EDGE_INSN: B:34:0x008d->B:31:0x008d BREAK  A[LOOP:0: B:20:0x0053->B:30:0x008a], SYNTHETIC] */
    public final void c(rf0 rf0Var) {
        ux uxVar = this.r;
        uxVar.c = (vu0) uxVar.b;
        hm1 hm1Var = (hm1) uxVar.d;
        if (hm1Var != null && hm1Var.h()) {
            hm1 hm1Var2 = (hm1) uxVar.e;
            if (hm1Var2 == null) {
                hm1 hm1Var3 = za2.a;
                hm1Var2 = new hm1();
                uxVar.e = hm1Var2;
            }
            hm1Var2.j(hm1Var);
            hm1Var.b();
        }
        uxVar.a = true;
        this.d.j(rf0Var);
        uxVar.a = false;
        vu0 vu0Var = (vu0) uxVar.c;
        if (vu0Var != null) {
            vu0Var.e();
        }
        hm1 hm1Var4 = (hm1) uxVar.e;
        if (hm1Var4 == null || !hm1Var4.h()) {
            return;
        }
        Object[] objArr = hm1Var4.b;
        long[] jArr = hm1Var4.a;
        int length = jArr.length - 2;
        if (length >= 0) {
            int i = 0;
            while (true) {
                long j = jArr[i];
                if ((((~j) << 7) & j & (-9187201950435737472L)) == -9187201950435737472L) {
                    if (i != length) {
                        break;
                        break;
                    }
                    i++;
                } else {
                    int i2 = 8 - ((~(i - length)) >>> 31);
                    for (int i3 = 0; i3 < i2; i3++) {
                        if ((255 & j) < 128) {
                            ((vu0) objArr[(i << 3) + i3]).e();
                        }
                        j >>= 8;
                    }
                    if (i2 != 8) {
                        break;
                    } else if (i != length) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
        }
        hm1Var4.b();
    }

    public final es4 d() {
        es4 us1Var;
        es4 es4Var = this.k;
        na naVar = this.l;
        if (es4Var != null) {
            return es4Var;
        }
        if (naVar != null) {
            ts1 ts1Var = new ts1(naVar);
            this.k = ts1Var;
            return ts1Var;
        }
        long jA = cp4.a(this.u);
        long j = this.h;
        long j2 = this.i;
        if (j2 != 9205357640488583168L) {
            jA = j2;
        }
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jA >> 32)) + fIntBitsToFloat;
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jA & 4294967295L)) + fIntBitsToFloat2;
        float f = this.j;
        if (f > 0.0f) {
            us1Var = new vs1(ez3.a(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4, (((long) Float.floatToRawIntBits(f)) << 32) | (4294967295L & ((long) Float.floatToRawIntBits(f)))));
        } else {
            us1Var = new us1(new l42(fIntBitsToFloat, fIntBitsToFloat2, fIntBitsToFloat3, fIntBitsToFloat4));
        }
        this.k = us1Var;
        return us1Var;
    }

    public final void e() {
        this.q--;
        b();
    }

    public final void f(long j, long j2, float f) {
        if (jp1.b(this.h, j) && xk2.a(this.i, j2) && this.j == f && this.l == null) {
            return;
        }
        this.k = null;
        this.l = null;
        this.g = true;
        this.n = false;
        this.h = j;
        this.i = j2;
        this.j = f;
        a();
    }
}
