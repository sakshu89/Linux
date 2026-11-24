package defpackage;

import android.graphics.Typeface;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import com.ibm.icu.text.ArabicShaping;
import java.io.InterruptedIOException;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p6 implements qj, v63 {
    public Object a;
    public Object b;
    public Object c;
    public Object e;

    public p6(Typeface typeface, hj1 hj1Var) {
        int i;
        int i2;
        int i3;
        int i4;
        this.e = typeface;
        this.a = hj1Var;
        this.c = new ij1(1024);
        int iA = hj1Var.a(6);
        if (iA != 0) {
            int i5 = iA + hj1Var.a;
            i = ((ByteBuffer) hj1Var.e).getInt(((ByteBuffer) hj1Var.e).getInt(i5) + i5);
        } else {
            i = 0;
        }
        this.b = new char[i * 2];
        int iA2 = hj1Var.a(6);
        if (iA2 != 0) {
            int i6 = iA2 + hj1Var.a;
            i2 = ((ByteBuffer) hj1Var.e).getInt(((ByteBuffer) hj1Var.e).getInt(i6) + i6);
        } else {
            i2 = 0;
        }
        for (int i7 = 0; i7 < i2; i7++) {
            q33 q33Var = new q33(this, i7);
            gj1 gj1VarB = q33Var.b();
            int iA3 = gj1VarB.a(4);
            Character.toChars(iA3 != 0 ? ((ByteBuffer) gj1VarB.e).getInt(iA3 + gj1VarB.a) : 0, (char[]) this.b, i7 * 2);
            gj1 gj1VarB2 = q33Var.b();
            int iA4 = gj1VarB2.a(16);
            if (iA4 != 0) {
                int i8 = iA4 + gj1VarB2.a;
                i3 = ((ByteBuffer) gj1VarB2.e).getInt(((ByteBuffer) gj1VarB2.e).getInt(i8) + i8);
            } else {
                i3 = 0;
            }
            hh1.a("invalid metadata codepoint length", i3 > 0);
            ij1 ij1Var = (ij1) this.c;
            gj1 gj1VarB3 = q33Var.b();
            int iA5 = gj1VarB3.a(16);
            if (iA5 != 0) {
                int i9 = iA5 + gj1VarB3.a;
                i4 = ((ByteBuffer) gj1VarB3.e).getInt(((ByteBuffer) gj1VarB3.e).getInt(i9) + i9);
            } else {
                i4 = 0;
            }
            ij1Var.a(q33Var, 0, i4 - 1);
        }
    }

    @Override // defpackage.s63
    public long a(vd vdVar, vd vdVar2, vd vdVar3) {
        int iB = vdVar.b();
        long jMax = 0;
        for (int i = 0; i < iB; i++) {
            jMax = Math.max(jMax, ((wd) this.a).get(i).d(vdVar.a(i), vdVar2.a(i), vdVar3.a(i)));
        }
        return jMax;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v19 */
    /* JADX WARN: Type inference failed for: r13v2 */
    /* JADX WARN: Type inference failed for: r13v20, types: [dk1] */
    /* JADX WARN: Type inference failed for: r13v21, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r13v22 */
    /* JADX WARN: Type inference failed for: r13v23 */
    /* JADX WARN: Type inference failed for: r13v24 */
    /* JADX WARN: Type inference failed for: r13v25 */
    /* JADX WARN: Type inference failed for: r13v26 */
    /* JADX WARN: Type inference failed for: r13v27, types: [dk1] */
    /* JADX WARN: Type inference failed for: r13v29 */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v30 */
    /* JADX WARN: Type inference failed for: r13v31 */
    /* JADX WARN: Type inference failed for: r13v32 */
    /* JADX WARN: Type inference failed for: r13v33 */
    /* JADX WARN: Type inference failed for: r13v34 */
    /* JADX WARN: Type inference failed for: r13v35 */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5, types: [pm1] */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8, types: [pm1] */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v16, types: [pm1] */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v19, types: [pm1] */
    /* JADX WARN: Type inference failed for: r14v20 */
    /* JADX WARN: Type inference failed for: r14v21 */
    /* JADX WARN: Type inference failed for: r14v22 */
    /* JADX WARN: Type inference failed for: r14v23 */
    /* JADX WARN: Type inference failed for: r14v24 */
    /* JADX WARN: Type inference failed for: r14v25 */
    /* JADX WARN: Type inference failed for: r14v26 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r3v30 */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v11, types: [dk1] */
    /* JADX WARN: Type inference failed for: r9v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v13 */
    /* JADX WARN: Type inference failed for: r9v14 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16 */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8, types: [dk1] */
    public Object b(long j, long j2, y50 y50Var) {
        fn1 fn1Var;
        int i;
        jn1 jn1Var;
        long j3;
        jn1 jn1Var2;
        t23 t23Var;
        zn1 zn1Var;
        t23 t23Var2;
        zn1 zn1Var2;
        Object pm1Var;
        Object B;
        int i2;
        if (y50Var instanceof fn1) {
            fn1Var = (fn1) y50Var;
            int i3 = fn1Var.i;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                fn1Var.i = i3 - Integer.MIN_VALUE;
            } else {
                fn1Var = new fn1(this, y50Var);
            }
        } else {
            fn1Var = new fn1(this, y50Var);
        }
        fn1 fn1Var2 = fn1Var;
        Object obj = fn1Var2.e;
        int i4 = fn1Var2.i;
        Object obj2 = null;
        if (i4 == 0) {
            bz3.g(obj);
            jn1 jn1Var3 = (jn1) this.a;
            int i5 = ArabicShaping.TASHKEEL_BEGIN;
            if (jn1Var3 == null || !jn1Var3.w) {
                i = 262144;
                jn1Var = null;
            } else {
                if (!jn1Var3.a.w) {
                    z01.b("visitAncestors called on an unattached node");
                }
                dk1 dk1Var = jn1Var3.a.f;
                n71 n71VarG = cm4.g(jn1Var3);
                loop0: while (true) {
                    if (n71VarG == null) {
                        t23Var2 = null;
                        break;
                    }
                    if ((n71VarG.o0.f.e & i5) != 0) {
                        while (dk1Var != null) {
                            if ((dk1Var.c & i5) != 0) {
                                var r14 = obj2;
                                var r13 = dk1Var;
                                while (r13 != 0) {
                                    if (r13 instanceof t23) {
                                        t23Var2 = (t23) r13;
                                        if (g31.a(jn1Var3.p(), t23Var2.p()) && jn1.class == t23Var2.getClass()) {
                                            break loop0;
                                        }
                                    } else {
                                        if ((r13.c & i5) != 0 && (r13 instanceof zb0)) {
                                            dk1 dk1Var2 = ((zb0) r13).H;
                                            int i6 = 0;
                                            B = r13;
                                            pm1Var = r14;
                                            while (dk1Var2 != null) {
                                                int i7 = i5;
                                                if ((dk1Var2.c & i7) != 0) {
                                                    i6++;
                                                    pm1Var = pm1Var;
                                                    if (i6 == 1) {
                                                        B = dk1Var2;
                                                    } else {
                                                        if (pm1Var == 0) {
                                                            pm1Var = new pm1(new dk1[16]);
                                                        }
                                                        if (B != 0) {
                                                            pm1Var.b(B);
                                                            B = 0;
                                                        }
                                                        pm1Var.b(dk1Var2);
                                                    }
                                                }
                                                dk1Var2 = dk1Var2.i;
                                                i5 = i7;
                                                B = B;
                                                pm1Var = pm1Var;
                                            }
                                            i2 = i5;
                                            pm1Var = pm1Var;
                                            if (i6 == 1) {
                                            }
                                            i5 = i2;
                                            r13 = B;
                                            r14 = pm1Var;
                                        }
                                        B = cm4.b(pm1Var);
                                        i5 = i2;
                                        r13 = B;
                                        r14 = pm1Var;
                                    }
                                    i2 = i5;
                                    pm1Var = r14;
                                    B = cm4.b(pm1Var);
                                    i5 = i2;
                                    r13 = B;
                                    r14 = pm1Var;
                                }
                            }
                            dk1Var = dk1Var.f;
                            i5 = i5;
                            obj2 = null;
                        }
                    }
                    int i8 = i5;
                    n71VarG = n71VarG.u();
                    dk1Var = (n71VarG == null || (zn1Var2 = n71VarG.o0) == null) ? null : zn1Var2.e;
                    i5 = i8;
                    obj2 = null;
                }
                i = i5;
                jn1Var = (jn1) t23Var2;
            }
            j3 = 0;
            t70 t70Var = t70.a;
            if (jn1Var == null) {
                jn1 jn1Var4 = (jn1) this.b;
                if (jn1Var4 != null) {
                    fn1Var2.i = 1;
                    Object objJ0 = jn1Var4.J0(j, j2, fn1Var2);
                    if (objJ0 != t70Var) {
                        obj = objJ0;
                        j3 = ((x63) obj).a;
                    }
                    return t70Var;
                }
            } else {
                jn1 jn1Var5 = (jn1) this.a;
                if (jn1Var5 == null || !jn1Var5.w) {
                    jn1Var2 = null;
                } else {
                    if (!jn1Var5.a.w) {
                        z01.b("visitAncestors called on an unattached node");
                    }
                    dk1 dk1Var3 = jn1Var5.a.f;
                    n71 n71VarG2 = cm4.g(jn1Var5);
                    loop3: while (true) {
                        if (n71VarG2 == null) {
                            t23Var = null;
                            break;
                        }
                        if ((n71VarG2.o0.f.e & i) != 0) {
                            while (dk1Var3 != null) {
                                if ((dk1Var3.c & i) != 0) {
                                    var B2 = dk1Var3;
                                    var pm1Var2 = 0;
                                    while (B2 != 0) {
                                        if (B2 instanceof t23) {
                                            t23 t23Var3 = (t23) B2;
                                            if (g31.a(jn1Var5.p(), t23Var3.p()) && jn1.class == t23Var3.getClass()) {
                                                t23Var = t23Var3;
                                                break loop3;
                                            }
                                        } else if ((B2.c & i) != 0 && (B2 instanceof zb0)) {
                                            dk1 dk1Var4 = ((zb0) B2).H;
                                            int i9 = 0;
                                            B2 = B2;
                                            pm1Var2 = pm1Var2;
                                            while (dk1Var4 != null) {
                                                if ((dk1Var4.c & i) != 0) {
                                                    i9++;
                                                    pm1Var2 = pm1Var2;
                                                    if (i9 == 1) {
                                                        B2 = dk1Var4;
                                                    } else {
                                                        if (pm1Var2 == 0) {
                                                            pm1Var2 = new pm1(new dk1[16]);
                                                        }
                                                        if (B2 != 0) {
                                                            pm1Var2.b(B2);
                                                            B2 = 0;
                                                        }
                                                        pm1Var2.b(dk1Var4);
                                                    }
                                                }
                                                dk1Var4 = dk1Var4.i;
                                                B2 = B2;
                                                pm1Var2 = pm1Var2;
                                            }
                                            if (i9 == 1) {
                                            }
                                        }
                                        B2 = cm4.b(pm1Var2);
                                    }
                                }
                                dk1Var3 = dk1Var3.f;
                            }
                        }
                        n71VarG2 = n71VarG2.u();
                        dk1Var3 = (n71VarG2 == null || (zn1Var = n71VarG2.o0) == null) ? null : zn1Var.e;
                    }
                    jn1Var2 = (jn1) t23Var;
                }
                if (jn1Var2 != null) {
                    fn1Var2.i = 2;
                    Object objJ1 = jn1Var2.J0(j, j2, fn1Var2);
                    if (objJ1 != t70Var) {
                        obj = objJ1;
                        j3 = ((x63) obj).a;
                    }
                    return t70Var;
                }
            }
        } else if (i4 == 1) {
            bz3.g(obj);
            j3 = ((x63) obj).a;
        } else {
            if (i4 != 2) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            bz3.g(obj);
            j3 = ((x63) obj).a;
        }
        return new x63(j3);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [dk1] */
    /* JADX WARN: Type inference failed for: r4v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v13 */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15 */
    /* JADX WARN: Type inference failed for: r4v16 */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [dk1] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3, types: [pm1] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference failed for: r7v7 */
    public Object c(long j, y50 y50Var) {
        gn1 gn1Var;
        long j2;
        zn1 zn1Var;
        if (y50Var instanceof gn1) {
            gn1Var = (gn1) y50Var;
            int i = gn1Var.i;
            if ((i & Integer.MIN_VALUE) != 0) {
                gn1Var.i = i - Integer.MIN_VALUE;
            } else {
                gn1Var = new gn1(this, y50Var);
            }
        } else {
            gn1Var = new gn1(this, y50Var);
        }
        Object objL0 = gn1Var.e;
        int i2 = gn1Var.i;
        jn1 jn1Var = null;
        t23 t23Var = null;
        jn1Var = null;
        if (i2 == 0) {
            bz3.g(objL0);
            jn1 jn1Var2 = (jn1) this.a;
            if (jn1Var2 != null && jn1Var2.w) {
                if (!jn1Var2.a.w) {
                    z01.b("visitAncestors called on an unattached node");
                }
                dk1 dk1Var = jn1Var2.a.f;
                n71 n71VarG = cm4.g(jn1Var2);
                loop0: while (n71VarG != null) {
                    if ((n71VarG.o0.f.e & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                        while (dk1Var != null) {
                            if ((dk1Var.c & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                                var B = dk1Var;
                                var pm1Var = 0;
                                while (B != 0) {
                                    if (B instanceof t23) {
                                        t23 t23Var2 = (t23) B;
                                        if (g31.a(jn1Var2.p(), t23Var2.p()) && jn1.class == t23Var2.getClass()) {
                                            t23Var = t23Var2;
                                            break loop0;
                                        }
                                    } else if ((B.c & ArabicShaping.TASHKEEL_BEGIN) != 0 && (B instanceof zb0)) {
                                        dk1 dk1Var2 = ((zb0) B).H;
                                        int i3 = 0;
                                        B = B;
                                        pm1Var = pm1Var;
                                        while (dk1Var2 != null) {
                                            if ((dk1Var2.c & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                                                i3++;
                                                pm1Var = pm1Var;
                                                if (i3 == 1) {
                                                    B = dk1Var2;
                                                } else {
                                                    if (pm1Var == 0) {
                                                        pm1Var = new pm1(new dk1[16]);
                                                    }
                                                    if (B != 0) {
                                                        pm1Var.b(B);
                                                        B = 0;
                                                    }
                                                    pm1Var.b(dk1Var2);
                                                }
                                            }
                                            dk1Var2 = dk1Var2.i;
                                            B = B;
                                            pm1Var = pm1Var;
                                        }
                                        if (i3 == 1) {
                                        }
                                    }
                                    B = cm4.b(pm1Var);
                                }
                            }
                            dk1Var = dk1Var.f;
                        }
                    }
                    n71VarG = n71VarG.u();
                    dk1Var = (n71VarG == null || (zn1Var = n71VarG.o0) == null) ? null : zn1Var.e;
                }
                jn1Var = (jn1) t23Var;
            }
            if (jn1Var != null) {
                gn1Var.i = 1;
                objL0 = jn1Var.L0(j, gn1Var);
                t70 t70Var = t70.a;
                if (objL0 == t70Var) {
                    return t70Var;
                }
            } else {
                j2 = 0;
            }
            return new x63(j2);
        }
        if (i2 != 1) {
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        bz3.g(objL0);
        j2 = ((x63) objL0).a;
        return new x63(j2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x005e, code lost:
    
        if (r7 == r2) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006d, code lost:
    
        if (r7 == r2) goto L27;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(defpackage.y50 r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.e
            w90 r0 = (defpackage.w90) r0
            boolean r1 = r7 instanceof defpackage.d90
            if (r1 == 0) goto L17
            r1 = r7
            d90 r1 = (defpackage.d90) r1
            int r2 = r1.j
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L17
            int r2 = r2 - r3
            r1.j = r2
            goto L1c
        L17:
            d90 r1 = new d90
            r1.<init>(r6, r7)
        L1c:
            java.lang.Object r7 = r1.f
            int r2 = r1.j
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L3b
            if (r2 == r5) goto L35
            if (r2 != r4) goto L2f
            p6 r6 = r1.e
            defpackage.bz3.g(r7)
            goto L61
        L2f:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r6)
            return r3
        L35:
            p6 r6 = r1.e
            defpackage.bz3.g(r7)
            goto L70
        L3b:
            defpackage.bz3.g(r7)
            java.lang.Object r7 = r6.c
            java.util.List r7 = (java.util.List) r7
            t70 r2 = defpackage.t70.a
            if (r7 == 0) goto L64
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L4d
            goto L64
        L4d:
            uk2 r7 = r0.h()
            g90 r5 = new g90
            r5.<init>(r0, r6, r3)
            r1.e = r6
            r1.j = r4
            java.lang.Object r7 = r7.b(r5, r1)
            if (r7 != r2) goto L61
            goto L6f
        L61:
            y80 r7 = (defpackage.y80) r7
            goto L72
        L64:
            r1.e = r6
            r1.j = r5
            r7 = 0
            java.lang.Object r7 = defpackage.w90.g(r0, r7, r1)
            if (r7 != r2) goto L70
        L6f:
            return r2
        L70:
            y80 r7 = (defpackage.y80) r7
        L72:
            java.lang.Object r6 = r6.e
            w90 r6 = (defpackage.w90) r6
            q82 r6 = r6.k
            r6.K(r7)
            q43 r6 = defpackage.q43.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p6.d(y50):java.lang.Object");
    }

    @Override // defpackage.s63
    public vd f(long j, vd vdVar, vd vdVar2, vd vdVar3) {
        if (((vd) this.c) == null) {
            this.c = vdVar3.c();
        }
        vd vdVar4 = (vd) this.c;
        if (vdVar4 == null) {
            g31.f("velocityVector");
            throw null;
        }
        int iB = vdVar4.b();
        int i = 0;
        while (true) {
            vd vdVar5 = (vd) this.c;
            if (i >= iB) {
                if (vdVar5 != null) {
                    return vdVar5;
                }
                g31.f("velocityVector");
                throw null;
            }
            if (vdVar5 == null) {
                g31.f("velocityVector");
                throw null;
            }
            vdVar5.e(((wd) this.a).get(i).c(j, vdVar.a(i), vdVar2.a(i), vdVar3.a(i)), i);
            i++;
        }
    }

    @Override // defpackage.s63
    public vd h(long j, vd vdVar, vd vdVar2, vd vdVar3) {
        if (((vd) this.b) == null) {
            this.b = vdVar.c();
        }
        vd vdVar4 = (vd) this.b;
        if (vdVar4 == null) {
            g31.f("valueVector");
            throw null;
        }
        int iB = vdVar4.b();
        int i = 0;
        while (true) {
            vd vdVar5 = (vd) this.b;
            if (i >= iB) {
                if (vdVar5 != null) {
                    return vdVar5;
                }
                g31.f("valueVector");
                throw null;
            }
            if (vdVar5 == null) {
                g31.f("valueVector");
                throw null;
            }
            vdVar5.e(((wd) this.a).get(i).b(j, vdVar.a(i), vdVar2.a(i), vdVar3.a(i)), i);
            i++;
        }
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0130  */
    /* JADX WARN: Code duplicated, block: B:68:0x0144 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:70:? A[LOOP:0: B:47:0x012a->B:70:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x00af, code lost:
    
        if (r15 == r1) goto L51;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [f41] */
    /* JADX WARN: Type inference failed for: r14v0, types: [nc, vq0] */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v9, types: [vq0] */
    /* JADX WARN: Type inference failed for: r15v5, types: [qb0[]] */
    /* JADX WARN: Type inference failed for: r2v10, types: [vq0] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object i(defpackage.nc r14, defpackage.y50 r15) {
        /*
            Method dump skipped, instruction units count: 356
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p6.i(nc, y50):java.lang.Object");
    }

    public void j(j32 j32Var) {
        j32Var.b.decrementAndGet();
        ArrayDeque arrayDeque = (ArrayDeque) this.c;
        synchronized (this) {
            if (!arrayDeque.remove(j32Var)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
        }
        o();
    }

    @Override // defpackage.s63
    public vd k(vd vdVar, vd vdVar2, vd vdVar3) {
        if (((vd) this.e) == null) {
            this.e = vdVar3.c();
        }
        vd vdVar4 = (vd) this.e;
        if (vdVar4 == null) {
            g31.f("endVelocityVector");
            throw null;
        }
        int iB = vdVar4.b();
        int i = 0;
        while (true) {
            vd vdVar5 = (vd) this.e;
            if (i >= iB) {
                if (vdVar5 != null) {
                    return vdVar5;
                }
                g31.f("endVelocityVector");
                throw null;
            }
            if (vdVar5 == null) {
                g31.f("endVelocityVector");
                throw null;
            }
            vdVar5.e(((wd) this.a).get(i).e(vdVar.a(i), vdVar2.a(i), vdVar3.a(i)), i);
            i++;
        }
    }

    public Size[] l(int i) {
        HashMap map = (HashMap) this.c;
        if (map.containsKey(Integer.valueOf(i))) {
            if (((Size[]) map.get(Integer.valueOf(i))) == null) {
                return null;
            }
            return (Size[]) ((Size[]) map.get(Integer.valueOf(i))).clone();
        }
        Size[] outputSizes = ((StreamConfigurationMap) ((wj1) this.a).b).getOutputSizes(i);
        if (outputSizes != null && outputSizes.length != 0) {
            Size[] sizeArrV = ((q91) this.b).v(outputSizes, i);
            map.put(Integer.valueOf(i), sizeArrV);
            return (Size[]) sizeArrV.clone();
        }
        xq4.d("StreamConfigurationMapCompat", "Retrieved output sizes array is null or empty for format " + i);
        return outputSizes;
    }

    public vd m(long j, vd vdVar, vd vdVar2) {
        if (((vd) this.c) == null) {
            this.c = vdVar.c();
        }
        vd vdVar3 = (vd) this.c;
        if (vdVar3 == null) {
            g31.f("velocityVector");
            throw null;
        }
        int iB = vdVar3.b();
        int i = 0;
        while (true) {
            vd vdVar4 = (vd) this.c;
            if (i >= iB) {
                if (vdVar4 != null) {
                    return vdVar4;
                }
                g31.f("velocityVector");
                throw null;
            }
            if (vdVar4 == null) {
                g31.f("velocityVector");
                throw null;
            }
            py0 py0Var = (py0) this.a;
            vdVar.getClass();
            long j2 = j / 1000000;
            dm0 dm0VarA = ((em0) py0Var.b).a(vdVar2.a(i));
            long j3 = dm0VarA.c;
            vdVar4.e((((Math.signum(dm0VarA.a) * k9.a(j3 > 0 ? j2 / j3 : 1.0f).b) * dm0VarA.b) / j3) * 1000.0f, i);
            i++;
        }
    }

    public b83 n(dy dyVar, String str) {
        b83 b83Var;
        boolean zIsInstance;
        b83 b83VarA;
        synchronized (((su0) this.e)) {
            try {
                g83 g83Var = (g83) this.a;
                g83Var.getClass();
                b83Var = (b83) g83Var.a.get(str);
                Class clsB = dyVar.a;
                Map map = dy.b;
                map.getClass();
                Integer num = (Integer) map.get(clsB);
                if (num != null) {
                    zIsInstance = h33.d(num.intValue(), b83Var);
                } else {
                    if (clsB.isPrimitive()) {
                        clsB = jp4.b(u42.a(clsB));
                    }
                    zIsInstance = clsB.isInstance(b83Var);
                }
                if (zIsInstance) {
                    e83 e83Var = (e83) this.b;
                    if (e83Var instanceof oa2) {
                        oa2 oa2Var = (oa2) e83Var;
                        b83Var.getClass();
                        qb1 qb1Var = oa2Var.d;
                        if (qb1Var != null) {
                            q91 q91Var = oa2Var.e;
                            q91Var.getClass();
                            iq4.a(b83Var, q91Var, qb1Var);
                        }
                    }
                    b83Var.getClass();
                } else {
                    jl1 jl1Var = new jl1((b80) this.c);
                    jl1Var.a.put(uf1.f, str);
                    e83 e83Var2 = (e83) this.b;
                    e83Var2.getClass();
                    try {
                        try {
                            b83VarA = e83Var2.c(dyVar, jl1Var);
                        } catch (AbstractMethodError unused) {
                            b83VarA = e83Var2.b(jp4.a(dyVar), jl1Var);
                        }
                    } catch (AbstractMethodError unused2) {
                        b83VarA = e83Var2.a(jp4.a(dyVar));
                    }
                    b83Var = b83VarA;
                    g83 g83Var2 = (g83) this.a;
                    g83Var2.getClass();
                    b83Var.getClass();
                    b83 b83Var2 = (b83) g83Var2.a.put(str, b83Var);
                    if (b83Var2 != null) {
                        b83Var2.b();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b83Var;
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0063  */
    /* JADX WARN: Code duplicated, block: B:24:0x0071 A[Catch: all -> 0x009e, TryCatch #3 {all -> 0x009e, blocks: (B:22:0x006b, B:24:0x0071, B:27:0x00a0), top: B:51:0x006b }] */
    /* JADX WARN: Code duplicated, block: B:51:0x006b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:24:0x0071, please report this as an issue */
    public void o() {
        int size;
        int i;
        j32 j32Var;
        byte[] bArr = z53.a;
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            try {
                Iterator it = ((ArrayDeque) this.b).iterator();
                it.getClass();
                while (it.hasNext()) {
                    j32 j32Var2 = (j32) it.next();
                    if (((ArrayDeque) this.c).size() >= 64) {
                        break;
                    }
                    if (j32Var2.b.get() < 5) {
                        it.remove();
                        j32Var2.b.incrementAndGet();
                        arrayList.add(j32Var2);
                        ((ArrayDeque) this.c).add(j32Var2);
                    }
                }
                synchronized (this) {
                    ((ArrayDeque) this.c).size();
                    ((ArrayDeque) this.e).size();
                }
                size = arrayList.size();
                for (i = 0; i < size; i++) {
                    j32Var = (j32) arrayList.get(i);
                    synchronized (this) {
                        try {
                            if (((ThreadPoolExecutor) this.a) == null) {
                                this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new y53(z53.g + " Dispatcher", false));
                            }
                            ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.a;
                            threadPoolExecutor.getClass();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    j32Var.getClass();
                    m32 m32Var = j32Var.c;
                    byte[] bArr2 = z53.a;
                    try {
                        try {
                            threadPoolExecutor.execute(j32Var);
                        } catch (Throwable th2) {
                            m32Var.a.a.j(j32Var);
                            throw th2;
                        }
                    } catch (RejectedExecutionException e) {
                        InterruptedIOException interruptedIOException = new InterruptedIOException("executor rejected");
                        interruptedIOException.initCause(e);
                        m32Var.i(interruptedIOException);
                        j32Var.a.m(m32Var, interruptedIOException);
                        m32Var.a.a.j(j32Var);
                    }
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        size = arrayList.size();
        while (i < size) {
            j32Var = (j32) arrayList.get(i);
            synchronized (this) {
                if (((ThreadPoolExecutor) this.a) == null) {
                    this.a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new y53(z53.g + " Dispatcher", false));
                }
                ThreadPoolExecutor threadPoolExecutor2 = (ThreadPoolExecutor) this.a;
                threadPoolExecutor2.getClass();
                j32Var.getClass();
                m32 m32Var2 = j32Var.c;
                byte[] bArr3 = z53.a;
                threadPoolExecutor2.execute(j32Var);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public Object p(y50 y50Var) throws Throwable {
        h92 h92Var;
        an1 an1Var;
        Throwable th;
        an1 an1Var2;
        p6 p6Var;
        if (y50Var instanceof h92) {
            h92Var = (h92) y50Var;
            int i = h92Var.k;
            if ((i & Integer.MIN_VALUE) != 0) {
                h92Var.k = i - Integer.MIN_VALUE;
            } else {
                h92Var = new h92(this, y50Var);
            }
        } else {
            h92Var = new h92(this, y50Var);
        }
        Object obj = h92Var.i;
        int i2 = h92Var.k;
        q43 q43Var = q43.a;
        t70 t70Var = t70.a;
        try {
            if (i2 == 0) {
                bz3.g(obj);
                if (((x00) this.b).Z()) {
                    return q43Var;
                }
                an1Var = (an1) this.a;
                h92Var.e = this;
                h92Var.f = an1Var;
                h92Var.k = 1;
                if (an1Var.e(h92Var) != t70Var) {
                }
                return t70Var;
            }
            if (i2 != 1) {
                if (i2 != 2) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                an1Var2 = h92Var.f;
                p6Var = h92Var.e;
                try {
                    bz3.g(obj);
                    ((x00) p6Var.b).b0(q43Var);
                    an1Var2.h(null);
                    return q43Var;
                } catch (Throwable th2) {
                    th = th2;
                    an1Var2.h(null);
                    throw th;
                }
            }
            an1 an1Var3 = h92Var.f;
            p6 p6Var2 = h92Var.e;
            bz3.g(obj);
            an1Var = an1Var3;
            this = p6Var2;
            if (((x00) this.b).Z()) {
                an1Var.h(null);
                return q43Var;
            }
            h92Var.e = this;
            h92Var.f = an1Var;
            h92Var.k = 2;
            if (this.d(h92Var) != t70Var) {
                p6Var = this;
                an1Var2 = an1Var;
                ((x00) p6Var.b).b0(q43Var);
                an1Var2.h(null);
                return q43Var;
            }
            return t70Var;
        } catch (Throwable th3) {
            an1 an1Var4 = an1Var;
            th = th3;
            an1Var2 = an1Var4;
            an1Var2.h(null);
            throw th;
        }
    }

    public /* synthetic */ p6(Object obj, Object obj2, Object obj3, Object obj4) {
        this.a = obj;
        this.b = obj2;
        this.c = obj3;
        this.e = obj4;
    }

    public p6(g83 g83Var, e83 e83Var, b80 b80Var) {
        g83Var.getClass();
        e83Var.getClass();
        b80Var.getClass();
        this.a = g83Var;
        this.b = e83Var;
        this.c = b80Var;
        this.e = new su0(19);
    }

    public p6(int i) {
        switch (i) {
            case 6:
                this.c = new ta(11, this);
                break;
            default:
                this.b = new ArrayDeque();
                this.c = new ArrayDeque();
                this.e = new ArrayDeque();
                break;
        }
    }

    public /* synthetic */ p6(Object obj) {
        this.a = obj;
    }

    public p6(im0 im0Var) {
        this(new py0(21, im0Var));
    }
}
