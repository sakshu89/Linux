package defpackage;

import com.ibm.icu.text.ArabicShaping;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jn1 extends dk1 implements t23 {
    public final p6 H;
    public jn1 X;
    public final String Y = "androidx.compose.ui.input.nestedscroll.NestedScrollNode";
    public final jb x;

    public jn1(jb jbVar, p6 p6Var) {
        this.x = jbVar;
        this.H = p6Var;
    }

    @Override // defpackage.dk1
    public final void A0() {
        p6 p6Var = this.H;
        p6Var.a = this;
        p6Var.b = null;
        this.X = null;
        p6Var.c = new ta(12, this);
        p6Var.e = w0();
    }

    @Override // defpackage.dk1
    public final void B0() {
        t42 t42Var = new t42();
        jd4.c(this, new i7(2, t42Var));
        jn1 jn1Var = (jn1) ((t23) t42Var.a);
        this.X = jn1Var;
        p6 p6Var = this.H;
        p6Var.b = jn1Var;
        if (((jn1) p6Var.a) == this) {
            p6Var.a = null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12, types: [dk1] */
    /* JADX WARN: Type inference failed for: r4v14 */
    /* JADX WARN: Type inference failed for: r4v15, types: [dk1] */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v17 */
    /* JADX WARN: Type inference failed for: r4v18 */
    /* JADX WARN: Type inference failed for: r4v19 */
    /* JADX WARN: Type inference failed for: r4v20 */
    /* JADX WARN: Type inference failed for: r4v21 */
    /* JADX WARN: Type inference failed for: r4v22 */
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
    public final s70 I0() {
        jn1 jn1Var;
        t23 t23Var;
        zn1 zn1Var;
        if (this.w) {
            if (!this.a.w) {
                z01.b("visitAncestors called on an unattached node");
            }
            dk1 dk1Var = this.a.f;
            n71 n71VarG = cm4.g(this);
            loop0: while (true) {
                if (n71VarG == null) {
                    t23Var = null;
                    break;
                }
                if ((n71VarG.o0.f.e & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                    while (dk1Var != null) {
                        if ((dk1Var.c & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                            var B = dk1Var;
                            var pm1Var = 0;
                            while (B != 0) {
                                if (B instanceof t23) {
                                    t23Var = (t23) B;
                                    if (g31.a(p(), t23Var.p()) && jn1.class == t23Var.getClass()) {
                                        break loop0;
                                    }
                                } else if ((B.c & ArabicShaping.TASHKEEL_BEGIN) != 0 && (B instanceof zb0)) {
                                    dk1 dk1Var2 = ((zb0) B).H;
                                    int i = 0;
                                    B = B;
                                    pm1Var = pm1Var;
                                    while (dk1Var2 != null) {
                                        if ((dk1Var2.c & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                                            i++;
                                            pm1Var = pm1Var;
                                            if (i == 1) {
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
                                    if (i == 1) {
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
        } else {
            jn1Var = null;
        }
        s70 s70VarI0 = jn1Var != null ? jn1Var.I0() : null;
        if (s70VarI0 != null && tl4.d(s70VarI0)) {
            return s70VarI0;
        }
        s70 s70Var = (s70) this.H.e;
        if (s70Var != null) {
            return s70Var;
        }
        og.n("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7, types: [pm1] */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14, types: [dk1] */
    /* JADX WARN: Type inference failed for: r14v16 */
    /* JADX WARN: Type inference failed for: r14v17 */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [dk1] */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r16v0 */
    /* JADX WARN: Type inference failed for: r16v1 */
    /* JADX WARN: Type inference failed for: r16v10 */
    /* JADX WARN: Type inference failed for: r16v11 */
    /* JADX WARN: Type inference failed for: r16v2 */
    /* JADX WARN: Type inference failed for: r16v3 */
    /* JADX WARN: Type inference failed for: r16v4 */
    /* JADX WARN: Type inference failed for: r16v5 */
    /* JADX WARN: Type inference failed for: r16v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r16v7 */
    /* JADX WARN: Type inference failed for: r16v8 */
    /* JADX WARN: Type inference failed for: r16v9 */
    /* JADX WARN: Type inference failed for: r9v17 */
    public final Object J0(long j, long j2, y50 y50Var) {
        hn1 hn1Var;
        long j3;
        long j4;
        long j5;
        jn1 jn1Var;
        long j6;
        long j7;
        t23 t23Var;
        zn1 zn1Var;
        int i;
        Object r16;
        Object B;
        int i2;
        if (y50Var instanceof hn1) {
            hn1Var = (hn1) y50Var;
            int i3 = hn1Var.k;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                hn1Var.k = i3 - Integer.MIN_VALUE;
            } else {
                hn1Var = new hn1(this, y50Var);
            }
        } else {
            hn1Var = new hn1(this, y50Var);
        }
        hn1 hn1Var2 = hn1Var;
        Object objH = hn1Var2.i;
        int i4 = hn1Var2.k;
        Object obj = null;
        int i5 = 1;
        t70 t70Var = t70.a;
        if (i4 == 0) {
            bz3.g(objH);
            hn1Var2.e = j;
            hn1Var2.f = j2;
            hn1Var2.k = 1;
            objH = this.x.h(j, j2, hn1Var2);
            if (objH != t70Var) {
                j3 = j;
                j4 = j2;
            }
            return t70Var;
        }
        if (i4 == 1) {
            j4 = hn1Var2.f;
            j3 = hn1Var2.e;
            bz3.g(objH);
        } else {
            if (i4 != 2) {
                og.n("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            j7 = hn1Var2.e;
            bz3.g(objH);
        }
        j6 = ((x63) objH).a;
        j5 = j7;
        return new x63(x63.e(j5, j6));
        j5 = ((x63) objH).a;
        boolean z = this.w;
        if (!z) {
            jn1Var = this.X;
        } else if (z && z) {
            if (!this.a.w) {
                z01.b("visitAncestors called on an unattached node");
            }
            dk1 dk1Var = this.a.f;
            n71 n71VarG = cm4.g(this);
            loop0: while (true) {
                if (n71VarG == null) {
                    t23Var = null;
                    break;
                }
                int i6 = n71VarG.o0.f.e;
                int i7 = ArabicShaping.TASHKEEL_BEGIN;
                if ((i6 & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                    while (dk1Var != null) {
                        if ((dk1Var.c & i7) != 0) {
                            var r14 = dk1Var;
                            var r17 = obj;
                            while (r14 != 0) {
                                if (r14 instanceof t23) {
                                    t23 t23Var2 = (t23) r14;
                                    i = i7;
                                    if (g31.a(p(), t23Var2.p()) && jn1.class == t23Var2.getClass()) {
                                        t23Var = t23Var2;
                                        break loop0;
                                    }
                                } else {
                                    i = i7;
                                    if ((r14.c & i) != 0 && (r14 instanceof zb0)) {
                                        dk1 dk1Var2 = ((zb0) r14).H;
                                        int i8 = 0;
                                        B = r14;
                                        r16 = r17;
                                        while (dk1Var2 != null) {
                                            if ((dk1Var2.c & i) != 0) {
                                                i8++;
                                                if (i8 == i5) {
                                                    B = dk1Var2;
                                                } else {
                                                    var pm1Var = r16 == 0 ? new pm1(new dk1[16]) : r16;
                                                    if (B != 0) {
                                                        pm1Var.b(B);
                                                        B = 0;
                                                    }
                                                    pm1Var.b(dk1Var2);
                                                    r16 = pm1Var;
                                                }
                                            }
                                            dk1Var2 = dk1Var2.i;
                                            i5 = 1;
                                            B = B;
                                            r16 = r16;
                                        }
                                        i2 = i5;
                                        r16 = r16;
                                        if (i8 == i2) {
                                        }
                                        i7 = i;
                                        i5 = i2;
                                        r14 = B;
                                        r17 = r16;
                                    }
                                    B = cm4.b(r16);
                                    i7 = i;
                                    i5 = i2;
                                    r14 = B;
                                    r17 = r16;
                                }
                                i2 = i5;
                                r16 = r17;
                                B = cm4.b(r16);
                                i7 = i;
                                i5 = i2;
                                r14 = B;
                                r17 = r16;
                            }
                        }
                        dk1Var = dk1Var.f;
                        i7 = i7;
                        i5 = i5;
                        obj = null;
                    }
                }
                int i9 = i5;
                n71VarG = n71VarG.u();
                dk1Var = (n71VarG == null || (zn1Var = n71VarG.o0) == null) ? null : zn1Var.e;
                i5 = i9;
                obj = null;
            }
            jn1Var = (jn1) t23Var;
        } else {
            jn1Var = null;
        }
        if (jn1Var != null) {
            long jE = x63.e(j3, j5);
            long jD = x63.d(j4, j5);
            hn1Var2.e = j5;
            hn1Var2.k = 2;
            objH = jn1Var.J0(jE, jD, hn1Var2);
            if (objH != t70Var) {
                j7 = j5;
                j6 = ((x63) objH).a;
                j5 = j7;
            }
            return t70Var;
        }
        j6 = 0;
        return new x63(x63.e(j5, j6));
    }

    /* JADX WARN: Code duplicated, block: B:8:0x002e  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11, types: [dk1] */
    /* JADX WARN: Type inference failed for: r10v12, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v17 */
    /* JADX WARN: Type inference failed for: r10v18 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8, types: [dk1] */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [pm1] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r12v8 */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r9v0, types: [jn1] */
    public final long K0(int i, long j, long j2) {
        long jH;
        zn1 zn1Var;
        jb jbVar = this.x;
        if (jbVar.a) {
            he2 he2Var = (he2) jbVar.b;
            if (he2Var.a.b()) {
                jH = 0;
            } else {
                jH = he2Var.h(he2Var.d(he2Var.a.e(he2Var.d(he2Var.g(j2)))));
            }
        } else {
            jH = 0;
        }
        boolean z = this.w;
        t23 t23Var = null;
        if (z && z) {
            if (!this.a.w) {
                z01.b("visitAncestors called on an unattached node");
            }
            dk1 dk1Var = this.a.f;
            n71 n71VarG = cm4.g(this);
            loop0: while (n71VarG != null) {
                if ((n71VarG.o0.f.e & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                    while (dk1Var != null) {
                        if ((dk1Var.c & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                            var B = dk1Var;
                            var pm1Var = 0;
                            while (B != 0) {
                                if (B instanceof t23) {
                                    t23 t23Var2 = (t23) B;
                                    if (g31.a(p(), t23Var2.p()) && jn1.class == t23Var2.getClass()) {
                                        t23Var = t23Var2;
                                        break loop0;
                                    }
                                } else if ((B.c & ArabicShaping.TASHKEEL_BEGIN) != 0 && (B instanceof zb0)) {
                                    dk1 dk1Var2 = ((zb0) B).H;
                                    int i2 = 0;
                                    B = B;
                                    pm1Var = pm1Var;
                                    while (dk1Var2 != null) {
                                        if ((dk1Var2.c & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                                            i2++;
                                            pm1Var = pm1Var;
                                            if (i2 == 1) {
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
                                    if (i2 == 1) {
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
            t23Var = (jn1) t23Var;
        }
        var r9 = t23Var;
        return jp1.e(jH, r9 != 0 ? r9.K0(i, jp1.e(j, jH), jp1.d(j2, jH)) : 0L);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Code duplicated, block: B:81:0x0122  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v12 */
    /* JADX WARN: Type inference failed for: r12v13 */
    /* JADX WARN: Type inference failed for: r12v14, types: [dk1] */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v6 */
    /* JADX WARN: Type inference failed for: r12v7, types: [dk1] */
    /* JADX WARN: Type inference failed for: r12v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v9 */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v3 */
    /* JADX WARN: Type inference failed for: r14v4, types: [pm1] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [pm1] */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r6v13 */
    public final Object L0(long j, x50 x50Var) {
        in1 in1Var;
        jn1 jn1Var;
        long j2;
        long j3;
        t23 t23Var;
        zn1 zn1Var;
        Object pm1Var;
        Object B;
        int i;
        x63 x63Var;
        long j4;
        if (x50Var instanceof in1) {
            in1Var = (in1) x50Var;
            int i2 = in1Var.j;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                in1Var.j = i2 - Integer.MIN_VALUE;
            } else {
                in1Var = new in1(this, (y50) x50Var);
            }
        } else {
            in1Var = new in1(this, (y50) x50Var);
        }
        Object objL0 = in1Var.f;
        int i3 = in1Var.j;
        Object obj = null;
        t70 t70Var = t70.a;
        if (i3 != 0) {
            if (i3 == 1) {
                j2 = in1Var.e;
                bz3.g(objL0);
            } else {
                if (i3 != 2) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                j4 = in1Var.e;
                bz3.g(objL0);
            }
            return new x63(x63.e(j4, ((x63) objL0).a));
        }
        bz3.g(objL0);
        boolean z = this.w;
        if (z && z) {
            if (!this.a.w) {
                z01.b("visitAncestors called on an unattached node");
            }
            dk1 dk1Var = this.a.f;
            n71 n71VarG = cm4.g(this);
            loop0: while (true) {
                if (n71VarG == null) {
                    t23Var = null;
                    break;
                }
                int i4 = n71VarG.o0.f.e;
                int i5 = ArabicShaping.TASHKEEL_BEGIN;
                if ((i4 & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                    while (dk1Var != null) {
                        if ((dk1Var.c & i5) != 0) {
                            var r12 = dk1Var;
                            var r14 = obj;
                            while (r12 != 0) {
                                if (r12 instanceof t23) {
                                    t23 t23Var2 = (t23) r12;
                                    if (g31.a(p(), t23Var2.p()) && jn1.class == t23Var2.getClass()) {
                                        t23Var = t23Var2;
                                        break loop0;
                                    }
                                } else {
                                    if ((r12.c & i5) != 0 && (r12 instanceof zb0)) {
                                        dk1 dk1Var2 = ((zb0) r12).H;
                                        int i6 = 0;
                                        B = r12;
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
                                        i = i5;
                                        pm1Var = pm1Var;
                                        if (i6 == 1) {
                                        }
                                        i5 = i;
                                        r12 = B;
                                        r14 = pm1Var;
                                    }
                                    B = cm4.b(pm1Var);
                                    i5 = i;
                                    r12 = B;
                                    r14 = pm1Var;
                                }
                                i = i5;
                                pm1Var = r14;
                                B = cm4.b(pm1Var);
                                i5 = i;
                                r12 = B;
                                r14 = pm1Var;
                            }
                        }
                        dk1Var = dk1Var.f;
                        i5 = i5;
                        obj = null;
                    }
                }
                n71VarG = n71VarG.u();
                dk1Var = (n71VarG == null || (zn1Var = n71VarG.o0) == null) ? null : zn1Var.e;
                obj = null;
            }
            jn1Var = (jn1) t23Var;
        } else {
            jn1Var = null;
        }
        if (jn1Var != null) {
            in1Var.e = j;
            in1Var.j = 1;
            objL0 = jn1Var.L0(j, in1Var);
            if (objL0 != t70Var) {
                j2 = j;
            }
        } else {
            j2 = j;
            j3 = 0;
            x63.d(j2, j3);
            in1Var.e = j3;
            in1Var.j = 2;
            x63Var = new x63(0L);
            if (x63Var != t70Var) {
                objL0 = x63Var;
                j4 = j3;
                return new x63(x63.e(j4, ((x63) objL0).a));
            }
        }
        return t70Var;
        j3 = ((x63) objL0).a;
        x63.d(j2, j3);
        in1Var.e = j3;
        in1Var.j = 2;
        x63Var = new x63(0L);
        if (x63Var != t70Var) {
            objL0 = x63Var;
            j4 = j3;
            return new x63(x63.e(j4, ((x63) objL0).a));
        }
        return t70Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [dk1] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [dk1] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [pm1] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r5v8 */
    /* JADX WARN: Type inference failed for: r5v9 */
    /* JADX WARN: Type inference failed for: r6v7 */
    public final long M0(int i, long j) {
        zn1 zn1Var;
        boolean z = this.w;
        jn1 jn1Var = null;
        t23 t23Var = null;
        jn1Var = null;
        if (z && z) {
            if (!this.a.w) {
                z01.b("visitAncestors called on an unattached node");
            }
            dk1 dk1Var = this.a.f;
            n71 n71VarG = cm4.g(this);
            loop0: while (n71VarG != null) {
                if ((n71VarG.o0.f.e & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                    while (dk1Var != null) {
                        if ((dk1Var.c & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                            var B = dk1Var;
                            var pm1Var = 0;
                            while (B != 0) {
                                if (B instanceof t23) {
                                    t23 t23Var2 = (t23) B;
                                    if (g31.a(p(), t23Var2.p()) && jn1.class == t23Var2.getClass()) {
                                        t23Var = t23Var2;
                                        break loop0;
                                    }
                                } else if ((B.c & ArabicShaping.TASHKEEL_BEGIN) != 0 && (B instanceof zb0)) {
                                    dk1 dk1Var2 = ((zb0) B).H;
                                    int i2 = 0;
                                    B = B;
                                    pm1Var = pm1Var;
                                    while (dk1Var2 != null) {
                                        if ((dk1Var2.c & ArabicShaping.TASHKEEL_BEGIN) != 0) {
                                            i2++;
                                            pm1Var = pm1Var;
                                            if (i2 == 1) {
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
                                    if (i2 == 1) {
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
        long jM0 = jn1Var != null ? jn1Var.M0(i, j) : 0L;
        jp1.d(j, jM0);
        return jp1.e(jM0, 0L);
    }

    @Override // defpackage.t23
    public final Object p() {
        return this.Y;
    }
}
