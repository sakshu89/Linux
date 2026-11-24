package defpackage;

import android.view.ViewTreeObserver;
import com.ibm.icu.text.ArabicShaping;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class he2 {
    public be2 a;
    public f9 b;
    public ka0 c;
    public js1 d;
    public boolean e;
    public p6 f;
    public final ae2 g;
    public final wd2 h;
    public boolean i;
    public int j = 1;
    public kd2 k = ud2.b;
    public final fe2 l = new fe2(this);
    public final x0 m = new x0(26, this);

    public he2(be2 be2Var, f9 f9Var, ka0 ka0Var, js1 js1Var, boolean z, p6 p6Var, ae2 ae2Var, wd2 wd2Var) {
        this.a = be2Var;
        this.b = f9Var;
        this.c = ka0Var;
        this.d = js1Var;
        this.e = z;
        this.f = p6Var;
        this.g = ae2Var;
        this.h = wd2Var;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object a(long j, y50 y50Var) {
        de2 de2Var;
        he2 he2Var;
        Throwable th;
        s42 s42Var;
        if (y50Var instanceof de2) {
            de2Var = (de2) y50Var;
            int i = de2Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                de2Var.j = i - Integer.MIN_VALUE;
            } else {
                de2Var = new de2(this, y50Var);
            }
        } else {
            de2Var = new de2(this, y50Var);
        }
        Object obj = de2Var.f;
        int i2 = de2Var.j;
        if (i2 != 0) {
            if (i2 != 1) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            s42Var = de2Var.e;
            try {
                bz3.g(obj);
                he2Var = this;
                he2Var.i = false;
                return new x63(s42Var.a);
            } catch (Throwable th2) {
                th = th2;
                he2Var = this;
                he2Var.i = false;
                throw th;
            }
        }
        bz3.g(obj);
        s42 s42Var2 = new s42();
        s42Var2.a = j;
        this.i = true;
        try {
            rm1 rm1Var = rm1.a;
            he2Var = this;
            try {
                ee2 ee2Var = new ee2(he2Var, s42Var2, j, null);
                de2Var.e = s42Var2;
                de2Var.j = 1;
                Object objF = he2Var.f(rm1Var, ee2Var, de2Var);
                t70 t70Var = t70.a;
                if (objF == t70Var) {
                    return t70Var;
                }
                s42Var = s42Var2;
                he2Var.i = false;
                return new x63(s42Var.a);
            } catch (Throwable th3) {
                th = th3;
                th = th;
                he2Var.i = false;
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            he2Var = this;
        }
    }

    /* JADX WARN: Code duplicated, block: B:11:0x001a  */
    /* JADX WARN: Code duplicated, block: B:21:0x003f  */
    /* JADX WARN: Code duplicated, block: B:23:0x004c A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x000d  */
    /* JADX WARN: Code duplicated, block: B:9:0x0014  */
    public final Object b(long j, boolean z, nu2 nu2Var) {
        int i;
        long jA;
        f9 f9Var;
        t70 t70Var;
        Object objS;
        q43 q43Var = q43.a;
        if (z) {
            ka0 ka0Var = this.c;
            sa2 sa2Var = ud2.a;
            if (!(ka0Var instanceof ka0)) {
                if (this.d == js1.b) {
                    i = 1;
                } else {
                    i = 2;
                }
                jA = x63.a(j, 0.0f, 0.0f, i);
                ge2 ge2Var = new ge2(this, null);
                f9Var = this.b;
                t70Var = t70.a;
                if (f9Var == null && (this.a.c() || this.a.a())) {
                    Object objB = f9Var.b(jA, ge2Var, nu2Var);
                    if (objB == t70Var) {
                        return objB;
                    }
                } else {
                    ge2 ge2Var2 = new ge2(this, nu2Var);
                    ge2Var2.j = jA;
                    objS = ge2Var2.s(q43Var);
                    if (objS == t70Var) {
                        return objS;
                    }
                }
            }
        } else {
            if (this.d == js1.b) {
                i = 1;
            } else {
                i = 2;
            }
            jA = x63.a(j, 0.0f, 0.0f, i);
            ge2 ge2Var3 = new ge2(this, null);
            f9Var = this.b;
            t70Var = t70.a;
            if (f9Var == null) {
                ge2 ge2Var4 = new ge2(this, nu2Var);
                ge2Var4.j = jA;
                objS = ge2Var4.s(q43Var);
                if (objS == t70Var) {
                    return objS;
                }
            } else {
                ge2 ge2Var5 = new ge2(this, nu2Var);
                ge2Var5.j = jA;
                objS = ge2Var5.s(q43Var);
                if (objS == t70Var) {
                    return objS;
                }
            }
        }
        return q43Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v21 */
    /* JADX WARN: Type inference failed for: r13v22, types: [dk1] */
    /* JADX WARN: Type inference failed for: r13v23, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27 */
    /* JADX WARN: Type inference failed for: r13v28 */
    /* JADX WARN: Type inference failed for: r13v29, types: [dk1] */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9, types: [pm1] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v15, types: [dk1] */
    /* JADX WARN: Type inference failed for: r6v17 */
    /* JADX WARN: Type inference failed for: r6v18 */
    /* JADX WARN: Type inference failed for: r6v19 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8, types: [dk1] */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v11 */
    /* JADX WARN: Type inference failed for: r7v12, types: [pm1] */
    /* JADX WARN: Type inference failed for: r7v28 */
    /* JADX WARN: Type inference failed for: r7v37 */
    /* JADX WARN: Type inference failed for: r7v38 */
    /* JADX WARN: Type inference failed for: r7v39 */
    /* JADX WARN: Type inference failed for: r7v40 */
    /* JADX WARN: Type inference failed for: r7v41 */
    /* JADX WARN: Type inference failed for: r7v5 */
    /* JADX WARN: Type inference failed for: r7v6 */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9, types: [pm1] */
    /* JADX WARN: Type inference failed for: r8v4 */
    public final long c(kd2 kd2Var, long j, int i) {
        int i2;
        jn1 jn1Var;
        jn1 jn1Var2;
        long j2;
        long jK0;
        t23 t23Var;
        zn1 zn1Var;
        ?? B;
        t23 t23Var2;
        zn1 zn1Var2;
        ?? B2;
        jn1 jn1Var3 = (jn1) this.f.a;
        int i3 = ArabicShaping.TASHKEEL_BEGIN;
        Object obj = null;
        if (jn1Var3 == null || !jn1Var3.w) {
            i2 = 262144;
            jn1Var = null;
        } else {
            if (!jn1Var3.a.w) {
                z01.b("visitAncestors called on an unattached node");
            }
            dk1 dk1Var = jn1Var3.a.f;
            n71 n71VarG = cm4.g(jn1Var3);
            loop0: while (true) {
                if (n71VarG == null) {
                    i2 = i3;
                    t23Var2 = null;
                    break;
                }
                if ((n71VarG.o0.f.e & i3) != 0) {
                    while (dk1Var != null) {
                        if ((dk1Var.c & i3) != 0) {
                            ?? pm1Var = 0;
                            ?? r13 = dk1Var;
                            while (r13 != 0) {
                                if (r13 instanceof t23) {
                                    t23Var2 = (t23) r13;
                                    i2 = i3;
                                    if (g31.a(jn1Var3.p(), t23Var2.p()) && jn1.class == t23Var2.getClass()) {
                                        break loop0;
                                    }
                                } else {
                                    i2 = i3;
                                    if ((r13.c & i2) != 0 && (r13 instanceof zb0)) {
                                        dk1 dk1Var2 = ((zb0) r13).H;
                                        int i4 = 0;
                                        B2 = r13;
                                        pm1Var = pm1Var;
                                        while (dk1Var2 != null) {
                                            if ((dk1Var2.c & i2) != 0) {
                                                i4++;
                                                pm1Var = pm1Var;
                                                if (i4 == 1) {
                                                    B2 = dk1Var2;
                                                } else {
                                                    if (pm1Var == 0) {
                                                        pm1Var = new pm1(new dk1[16]);
                                                    }
                                                    if (B2 != 0) {
                                                        pm1Var.b(B2);
                                                        B2 = 0;
                                                    }
                                                    pm1Var.b(dk1Var2);
                                                }
                                            }
                                            dk1Var2 = dk1Var2.i;
                                            B2 = B2;
                                            pm1Var = pm1Var;
                                        }
                                        if (i4 == 1) {
                                        }
                                    }
                                    i3 = i2;
                                    r13 = B2;
                                    pm1Var = pm1Var;
                                }
                                B2 = cm4.b(pm1Var);
                                i3 = i2;
                                r13 = B2;
                                pm1Var = pm1Var;
                            }
                        }
                        dk1Var = dk1Var.f;
                        i3 = i3;
                    }
                }
                int i5 = i3;
                n71VarG = n71VarG.u();
                dk1Var = (n71VarG == null || (zn1Var2 = n71VarG.o0) == null) ? null : zn1Var2.e;
                i3 = i5;
            }
            jn1Var = (jn1) t23Var2;
        }
        long jM0 = jn1Var != null ? jn1Var.M0(i, j) : 0L;
        long jD = jp1.d(j, jM0);
        long jE = e(h(kd2Var.a(g(e(this.d == js1.b ? jp1.a(jD, 0.0f, 1) : jp1.a(jD, 0.0f, 2))))));
        ae2 ae2Var = this.g;
        if (ae2Var.w) {
            ViewTreeObserver viewTreeObserver = ((r7) cm4.h(ae2Var)).getViewTreeObserver();
            try {
                if (r7.x1 == null) {
                    Method declaredMethod = viewTreeObserver.getClass().getDeclaredMethod("dispatchOnScrollChanged", null);
                    declaredMethod.setAccessible(true);
                    r7.x1 = declaredMethod;
                }
                Method method = r7.x1;
                if (method != null) {
                    method.invoke(viewTreeObserver, null);
                }
            } catch (Exception unused) {
            }
        }
        long jD2 = jp1.d(jD, jE);
        jn1 jn1Var4 = (jn1) this.f.a;
        if (jn1Var4 == null || !jn1Var4.w) {
            jn1Var2 = null;
        } else {
            if (!jn1Var4.a.w) {
                z01.b("visitAncestors called on an unattached node");
            }
            dk1 dk1Var3 = jn1Var4.a.f;
            n71 n71VarG2 = cm4.g(jn1Var4);
            loop3: while (true) {
                if (n71VarG2 == null) {
                    t23Var = null;
                    break;
                }
                if ((n71VarG2.o0.f.e & i2) != 0) {
                    while (dk1Var3 != null) {
                        if ((dk1Var3.c & i2) != 0) {
                            ?? r6 = dk1Var3;
                            ?? pm1Var2 = obj;
                            while (r6 != 0) {
                                if (r6 instanceof t23) {
                                    t23 t23Var3 = (t23) r6;
                                    if (g31.a(jn1Var4.p(), t23Var3.p()) && jn1.class == t23Var3.getClass()) {
                                        t23Var = t23Var3;
                                        break loop3;
                                    }
                                } else {
                                    if ((r6.c & i2) != 0 && (r6 instanceof zb0)) {
                                        dk1 dk1Var4 = ((zb0) r6).H;
                                        int i6 = 0;
                                        B = r6;
                                        pm1Var2 = pm1Var2;
                                        while (dk1Var4 != null) {
                                            if ((dk1Var4.c & i2) != 0) {
                                                i6++;
                                                pm1Var2 = pm1Var2;
                                                if (i6 == 1) {
                                                    B = dk1Var4;
                                                } else {
                                                    if (pm1Var2 == 0) {
                                                        pm1Var2 = new pm1(new dk1[16]);
                                                    }
                                                    if (B != 0) {
                                                        pm1Var2.b(B);
                                                        B = 0;
                                                    }
                                                    pm1Var2.b(dk1Var4);
                                                }
                                            }
                                            dk1Var4 = dk1Var4.i;
                                            B = B;
                                            pm1Var2 = pm1Var2;
                                        }
                                        if (i6 == 1) {
                                        }
                                    }
                                    r6 = B;
                                    pm1Var2 = pm1Var2;
                                }
                                B = cm4.b(pm1Var2);
                                r6 = B;
                                pm1Var2 = pm1Var2;
                            }
                        }
                        dk1Var3 = dk1Var3.f;
                        obj = null;
                    }
                }
                n71VarG2 = n71VarG2.u();
                dk1Var3 = (n71VarG2 == null || (zn1Var = n71VarG2.o0) == null) ? null : zn1Var.e;
                obj = null;
            }
            jn1Var2 = (jn1) t23Var;
        }
        if (jn1Var2 != null) {
            jK0 = jn1Var2.K0(i, jE, jD2);
            j2 = jE;
        } else {
            j2 = jE;
            jK0 = 0;
        }
        return jp1.e(jp1.e(jM0, j2), jK0);
    }

    public final float d(float f) {
        return this.e ? f * (-1.0f) : f;
    }

    public final long e(long j) {
        return this.e ? jp1.f(-1.0f, j) : j;
    }

    public final Object f(rm1 rm1Var, vq0 vq0Var, y50 y50Var) {
        Object objD = this.a.d(rm1Var, new r0(this, vq0Var, null, 16), y50Var);
        return objD == t70.a ? objD : q43.a;
    }

    public final float g(long j) {
        return Float.intBitsToFloat((int) (this.d == js1.b ? j >> 32 : j & 4294967295L));
    }

    public final long h(float f) {
        if (f == 0.0f) {
            return 0L;
        }
        if (this.d == js1.b) {
            return (((long) Float.floatToRawIntBits(f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L);
        }
        return (((long) Float.floatToRawIntBits(f)) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32);
    }

    public final float i(long j) {
        int i = (int) (4294967295L & j);
        int i2 = (int) (j >> 32);
        double dAtan2 = (float) Math.atan2(Math.abs(Float.intBitsToFloat(i)), Math.abs(Float.intBitsToFloat(i2)));
        js1 js1Var = this.d;
        if (dAtan2 >= 0.7853981633974483d) {
            if (js1Var == js1.a) {
                return Float.intBitsToFloat(i);
            }
            return 0.0f;
        }
        if (js1Var == js1.b) {
            return Float.intBitsToFloat(i2);
        }
        return 0.0f;
    }
}
