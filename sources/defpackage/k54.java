package defpackage;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.Normalizer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class k54 {
    public static final void a(String str, boolean z, fq0 fq0Var, x20 x20Var, int i) {
        x20Var.X(-683037981);
        int i2 = i | (x20Var.g(z) ? 32 : 16) | (x20Var.h(fq0Var) ? 256 : 128);
        if (x20Var.O(i2 & 1, (i2 & 147) != 146)) {
            gr2 gr2VarA = vk2.a(z ? uz.h : uz.f, ie4.e(UCharacter.UnicodeBlock.TAKRI_ID, null, 6), "chipTint", x20Var);
            dz2.b(str, c34.d(pd3.c(of4.a(kg1.a(vh4.a(bk1.a, u82.a(10.0f)), z ? sz.b(0.14f, uz.h) : uz.c, y34.a), z ? sz.b(0.5f, ((sz) gr2VarA.getValue()).a) : uz.d, u82.a(10.0f)), false, null, null, fq0Var, 15), 10.0f, 6.0f), ((sz) gr2VarA.getValue()).a, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var.j(w33.a)).o, x20Var, 6, 0, 131064);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new fi2(str, z, fq0Var, i, 1);
        }
    }

    public static final void b(final eo2 eo2Var, final g32 g32Var, final fq0 fq0Var, final fq0 fq0Var2, final fq0 fq0Var3, final hq0 hq0Var, final hq0 hq0Var2, x20 x20Var, int i) {
        x20Var.X(-1633133039);
        int i2 = (x20Var.h(eo2Var) ? 4 : 2) | i | (x20Var.h(g32Var) ? 32 : 16) | (x20Var.h(fq0Var) ? 256 : 128);
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i2 |= x20Var.h(fq0Var2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= x20Var.h(fq0Var3) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= x20Var.h(hq0Var) ? Normalizer.INPUT_IS_FCD : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= x20Var.h(hq0Var2) ? 1048576 : ArabicShaping.TASHKEEL_RESIZE;
        }
        if (x20Var.O(i2 & 1, (599187 & i2) != 599186)) {
            qf4.a(w44.b, null, yi4.b(-413579545, new wq0() { // from class: tn2
                /* JADX WARN: Code duplicated, block: B:49:0x0162  */
                @Override // defpackage.wq0
                public final Object c(Object obj, Object obj2, Object obj3) {
                    String str;
                    lm lmVar = (lm) obj;
                    x20 x20Var2 = (x20) obj2;
                    int iIntValue = ((Integer) obj3).intValue();
                    lmVar.getClass();
                    el1 el1Var = el1.b;
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= x20Var2.f(lmVar) ? 4 : 2;
                    }
                    if (x20Var2.O(iIntValue & 1, (iIntValue & 19) != 18)) {
                        jc0 jc0Var = lmVar.a;
                        long j = lmVar.b;
                        de0 de0Var = new de0((q40.d(j) ? jc0Var.r0(q40.h(j)) : Float.POSITIVE_INFINITY) * 0.56f);
                        de0 de0Var2 = new de0(lmVar.a() * 0.34f);
                        if (de0Var.compareTo(de0Var2) > 0) {
                            de0Var = de0Var2;
                        }
                        float fA = lmVar.a() * 0.335f;
                        float f = de0Var.a;
                        float f2 = fA - (f / 2.0f);
                        de0 de0Var3 = new de0(66.0f);
                        de0 de0Var4 = new de0(lmVar.a() * 0.105f);
                        de0 de0Var5 = de0Var3.compareTo(de0Var4) <= 0 ? de0Var3 : de0Var4;
                        eo2 eo2Var2 = eo2Var;
                        rn2 rn2Var = eo2Var2.a;
                        rn2 rn2Var2 = rn2.v;
                        boolean z = rn2Var == rn2Var2 || eo2Var2.b() || eo2Var2.g != null;
                        dp2.a(w44.b, x20Var2, 54);
                        rn2 rn2Var3 = eo2Var2.a;
                        boolean z2 = eo2Var2.l;
                        ll llVar = xy.c;
                        ek1 ek1VarG = w44.g(u24.b(el1Var.k(llVar), f2), f);
                        Object objL = x20Var2.L();
                        if (objL == r20.a) {
                            objL = new xn2(0);
                            x20Var2.g0(objL);
                        }
                        ek1 ek1VarK = k54.k(dg2.a(ek1VarG, (hq0) objL), fq0Var, x20Var2);
                        g32 g32Var2 = g32Var;
                        k54.c(rn2Var3, g32Var2, z2, ek1VarK, x20Var2, 0);
                        ek1 ek1VarB = w44.b(u24.b(el1Var.k(llVar), lmVar.a() * 0.785f), 1.0f);
                        j00 j00VarA = h00.a(jg1.d, xy.x, x20Var2, 48);
                        int iHashCode = Long.hashCode(x20Var2.T);
                        gw1 gw1VarL = x20Var2.l();
                        ek1 ek1VarC = gj4.c(x20Var2, ek1VarB);
                        o20.p.getClass();
                        k30 k30Var = n20.b;
                        x20Var2.Z();
                        if (x20Var2.S) {
                            x20Var2.k(k30Var);
                        } else {
                            x20Var2.j0();
                        }
                        jd jdVar = n20.f;
                        ie4.c(x20Var2, jdVar, j00VarA);
                        jd jdVar2 = n20.e;
                        ie4.c(x20Var2, jdVar2, gw1VarL);
                        Integer numValueOf = Integer.valueOf(iHashCode);
                        jd jdVar3 = n20.g;
                        ie4.a(x20Var2, numValueOf, jdVar3);
                        j7 j7Var = n20.h;
                        ie4.b(x20Var2, j7Var);
                        jd jdVar4 = n20.d;
                        ie4.c(x20Var2, jdVar4, ek1VarC);
                        rn2 rn2Var4 = eo2Var2.a;
                        if (eo2Var2.l) {
                            str = "SONIC IS SPEAKING";
                        } else if (rn2Var4 == rn2.e) {
                            str = "PROCESSING";
                        } else if (rn2Var4 == rn2.f) {
                            str = "THINKING";
                        } else if (rn2Var4 == rn2.i) {
                            str = "EXECUTING";
                        } else if (rn2Var4 == rn2.j) {
                            str = "CHECKING RESULT";
                        } else if (rn2Var4 == rn2Var2) {
                            str = "AWAITING CONFIRMATION";
                        } else if (eo2Var2.b()) {
                            str = "CHOOSE AN OPTION";
                        } else if (eo2Var2.i) {
                            str = "LISTENING";
                        } else if (rn2Var4.a()) {
                            str = "PROCESSING";
                        } else {
                            str = "TAP ORB TO START";
                        }
                        long jC = ki4.c(4288601327L);
                        np0 np0Var = np0.e;
                        long jC2 = nc4.c(10);
                        long jC3 = nc4.c(2);
                        bk1 bk1Var = bk1.a;
                        dz2.b(str, c34.e(bk1Var, 16.0f, 0.0f, 2), jC, jC2, np0Var, ev2.c, jC3, new vw2(3), 0L, 0, false, 0, 0, null, x20Var2, 102261168, 0, 260648);
                        x20 x20Var3 = x20Var2;
                        k54.h(x20Var3, w44.c(bk1Var, 14.0f));
                        k54.d(eo2Var2, g32Var2, w44.c(w44.b(bk1Var, 0.73f), de0Var5.a), x20Var3, 0);
                        x20Var3.p(true);
                        if (z) {
                            x20Var3.W(1314410424);
                            ek1 ek1VarF = i44.f(c34.c(w44.e(w44.b(el1Var.k(xy.n), 1.0f), 0.0f, lmVar.a() * 0.41f, 1), 16.0f), i44.d(x20Var3));
                            oh1 oh1VarD = gm.d(xy.b, false);
                            int iHashCode2 = Long.hashCode(x20Var3.T);
                            gw1 gw1VarL2 = x20Var3.l();
                            ek1 ek1VarC2 = gj4.c(x20Var3, ek1VarF);
                            x20Var3.Z();
                            if (x20Var3.S) {
                                x20Var3.k(k30Var);
                            } else {
                                x20Var3.j0();
                            }
                            ie4.c(x20Var3, jdVar, oh1VarD);
                            ie4.c(x20Var3, jdVar2, gw1VarL2);
                            cq.s(iHashCode2, x20Var3, jdVar3, x20Var3, j7Var);
                            ie4.c(x20Var3, jdVar4, ek1VarC2);
                            ds4.d(eo2Var2, fq0Var2, fq0Var3, hq0Var, hq0Var2, null, x20Var3, 0, 32);
                            x20Var3 = x20Var3;
                            x20Var3.p(true);
                        } else {
                            x20Var3.W(1305200603);
                        }
                        x20Var3.p(false);
                    } else {
                        x20Var2.R();
                    }
                    return q43.a;
                }
            }, x20Var), x20Var, 3078);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new sn2(eo2Var, g32Var, fq0Var, fq0Var2, fq0Var3, hq0Var, hq0Var2, i, 1);
        }
    }

    public static final void c(final rn2 rn2Var, final g32 g32Var, final boolean z, final ek1 ek1Var, x20 x20Var, final int i) {
        x20 x20Var2 = x20Var;
        x20Var2.X(951657117);
        int i2 = i | (x20Var2.d(rn2Var.ordinal()) ? 4 : 2) | (x20Var2.h(g32Var) ? 32 : 16) | (x20Var2.g(z) ? 256 : 128) | (x20Var2.f(ek1Var) ? 2048 : 1024);
        if (x20Var2.O(i2 & 1, (i2 & 1171) != 1170)) {
            mm1 mm1VarA = qn4.a(g32Var, x20Var2, (i2 >> 3) & 14);
            oh1 oh1VarD = gm.d(xy.b, false);
            int iHashCode = Long.hashCode(x20Var2.T);
            gw1 gw1VarL = x20Var2.l();
            ek1 ek1VarC = gj4.c(x20Var2, ek1Var);
            o20.p.getClass();
            k30 k30Var = n20.b;
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            ie4.c(x20Var2, n20.f, oh1VarD);
            ie4.c(x20Var2, n20.e, gw1VarL);
            ie4.a(x20Var2, Integer.valueOf(iHashCode), n20.g);
            ie4.b(x20Var2, n20.h);
            ie4.c(x20Var2, n20.d, ek1VarC);
            float fFloatValue = ((Number) mm1VarA.getValue()).floatValue();
            int i3 = (i2 & 14) | UCharacterProperty.SCRIPT_X_WITH_OTHER | (i2 & 896);
            rl0 rl0Var = w44.b;
            bs4.a(rn2Var, fFloatValue, z, rl0Var, x20Var2, i3);
            x20Var2 = x20Var;
            s44.b(rn2Var, ((Number) mm1VarA.getValue()).floatValue(), z, rl0Var, x20Var2, i3);
            x20Var2.p(true);
        } else {
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new vq0(g32Var, z, ek1Var, i) { // from class: yn2
                public final /* synthetic */ g32 b;
                public final /* synthetic */ boolean c;
                public final /* synthetic */ ek1 e;

                @Override // defpackage.vq0
                public final Object e(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iC = ny3.c(1);
                    k54.c(this.a, this.b, this.c, this.e, (x20) obj, iC);
                    return q43.a;
                }
            };
        }
    }

    public static final void d(eo2 eo2Var, g32 g32Var, ek1 ek1Var, x20 x20Var, int i) {
        ek1 ek1Var2;
        x20 x20Var2;
        x20Var.X(-42301193);
        int i2 = (x20Var.h(eo2Var) ? 4 : 2) | i | (x20Var.h(g32Var) ? 32 : 16) | (x20Var.f(ek1Var) ? 256 : 128);
        if (x20Var.O(i2 & 1, (i2 & 147) != 146)) {
            ek1Var2 = ek1Var;
            x20Var2 = x20Var;
            gf4.a(eo2Var.a, ((Number) qn4.a(g32Var, x20Var, (i2 >> 3) & 14).getValue()).floatValue(), eo2Var.l, ek1Var2, x20Var2, (i2 << 3) & 7168);
        } else {
            ek1Var2 = ek1Var;
            x20Var2 = x20Var;
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new ic(eo2Var, g32Var, ek1Var2, i);
        }
    }

    public static final void e(eo2 eo2Var, g32 g32Var, fq0 fq0Var, fq0 fq0Var2, fq0 fq0Var3, hq0 hq0Var, hq0 hq0Var2, x20 x20Var, int i) {
        boolean z;
        x20 x20Var2 = x20Var;
        x20Var2.X(1804501016);
        int i2 = (x20Var2.h(eo2Var) ? 4 : 2) | i | (x20Var2.h(g32Var) ? 32 : 16) | (x20Var2.h(fq0Var) ? 256 : 128);
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i2 |= x20Var2.h(fq0Var2) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= x20Var2.h(fq0Var3) ? 16384 : 8192;
        }
        if ((i & 196608) == 0) {
            i2 |= x20Var2.h(hq0Var) ? Normalizer.INPUT_IS_FCD : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= x20Var2.h(hq0Var2) ? 1048576 : ArabicShaping.TASHKEEL_RESIZE;
        }
        int i3 = i2;
        if (x20Var2.O(i3 & 1, (i3 & 599187) != 599186)) {
            Object[] objArr = new Object[0];
            Object objL = x20Var2.L();
            xy xyVar = r20.a;
            if (objL == xyVar) {
                objL = new tv1(11);
                x20Var2.g0(objL);
            }
            mm1 mm1Var = (mm1) yy3.b(objArr, (fq0) objL, x20Var2);
            jl jlVar = xy.w;
            cg cgVar = jg1.d;
            j00 j00VarA = h00.a(cgVar, jlVar, x20Var2, 0);
            int iHashCode = Long.hashCode(x20Var2.T);
            gw1 gw1VarL = x20Var2.l();
            ek1 ek1VarC = gj4.c(x20Var2, w44.b);
            o20.p.getClass();
            k30 k30Var = n20.b;
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            jd jdVar = n20.f;
            ie4.c(x20Var2, jdVar, j00VarA);
            jd jdVar2 = n20.e;
            ie4.c(x20Var2, jdVar2, gw1VarL);
            Integer numValueOf = Integer.valueOf(iHashCode);
            jd jdVar3 = n20.g;
            ie4.a(x20Var2, numValueOf, jdVar3);
            j7 j7Var = n20.h;
            ie4.b(x20Var2, j7Var);
            jd jdVar4 = n20.d;
            ie4.c(x20Var2, jdVar4, ek1VarC);
            bk1 bk1Var = bk1.a;
            ek1 ek1VarF = c34.f(w44.b(bk1Var, 1.0f), 0.0f, 0.0f, 12.0f, 7);
            e92 e92VarA = d92.a(new eg(10.0f, new ag(0)), xy.u, x20Var2, 54);
            int iHashCode2 = Long.hashCode(x20Var2.T);
            gw1 gw1VarL2 = x20Var2.l();
            ek1 ek1VarC2 = gj4.c(x20Var2, ek1VarF);
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            ie4.c(x20Var2, jdVar, e92VarA);
            ie4.c(x20Var2, jdVar2, gw1VarL2);
            cq.s(iHashCode2, x20Var2, jdVar3, x20Var2, j7Var);
            ie4.c(x20Var2, jdVar4, ek1VarC2);
            rn2 rn2Var = eo2Var.a;
            boolean z2 = eo2Var.l;
            ek1 ek1VarA = vh4.a(w44.g(bk1Var, 64.0f), u82.a);
            Object objL2 = x20Var2.L();
            if (objL2 == xyVar) {
                z = true;
                objL2 = new xn2(1 == true ? 1 : 0);
                x20Var2.g0(objL2);
            } else {
                z = true;
            }
            c(rn2Var, g32Var, z2, k(dg2.a(ek1VarA, (hq0) objL2), fq0Var, x20Var2), x20Var2, i3 & 112);
            d81 d81Var = new d81(1.0f, z);
            j00 j00VarA2 = h00.a(cgVar, jlVar, x20Var2, 0);
            int iHashCode3 = Long.hashCode(x20Var2.T);
            gw1 gw1VarL3 = x20Var2.l();
            ek1 ek1VarC3 = gj4.c(x20Var2, d81Var);
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            ie4.c(x20Var2, jdVar, j00VarA2);
            ie4.c(x20Var2, jdVar2, gw1VarL3);
            cq.s(iHashCode3, x20Var2, jdVar3, x20Var2, j7Var);
            ie4.c(x20Var2, jdVar4, ek1VarC3);
            boolean z3 = z;
            dz2.b("HISTORY & DIAGNOSTICS", null, uz.e, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(w33.a)).h, x20Var2, 390, 0, 131066);
            x20Var2.p(z3);
            x20Var2.p(z3);
            ek1 ek1VarF2 = c34.f(w44.b(bk1Var, 1.0f), 0.0f, 0.0f, 12.0f, 7);
            e92 e92VarA2 = d92.a(new eg(10.0f, new ag(0)), xy.t, x20Var2, 6);
            int iHashCode4 = Long.hashCode(x20Var2.T);
            gw1 gw1VarL4 = x20Var2.l();
            ek1 ek1VarC4 = gj4.c(x20Var2, ek1VarF2);
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            ie4.c(x20Var2, jdVar, e92VarA2);
            ie4.c(x20Var2, jdVar2, gw1VarL4);
            cq.s(iHashCode4, x20Var2, jdVar3, x20Var2, j7Var);
            ie4.c(x20Var2, jdVar4, ek1VarC4);
            boolean zBooleanValue = ((Boolean) mm1Var.getValue()).booleanValue() ^ z3;
            boolean zF = x20Var2.f(mm1Var);
            Object objL3 = x20Var2.L();
            if (zF || objL3 == xyVar) {
                objL3 = new hc(mm1Var, 6);
                x20Var2.g0(objL3);
            }
            a("CONVERSATION", zBooleanValue, (fq0) objL3, x20Var2, 6);
            boolean zBooleanValue2 = ((Boolean) mm1Var.getValue()).booleanValue();
            boolean zF2 = x20Var2.f(mm1Var);
            Object objL4 = x20Var2.L();
            if (zF2 || objL4 == xyVar) {
                objL4 = new hc(mm1Var, 7);
                x20Var2.g0(objL4);
            }
            a("ACTION LOGS", zBooleanValue2, (fq0) objL4, x20Var2, 6);
            x20Var2.p(z3);
            cb4.e(eo2Var.h, ((Boolean) mm1Var.getValue()).booleanValue(), new d81(1.0f, z3), x20Var2, 0);
            if (eo2Var.a == rn2.v || eo2Var.b() || eo2Var.g != null) {
                x20Var2.W(-1736487840);
                int i4 = i3 >> 6;
                ds4.d(eo2Var, fq0Var2, fq0Var3, hq0Var, hq0Var2, c34.f(bk1Var, 10.0f, 0.0f, 8.0f, 5), x20Var2, (i3 & 14) | 196608 | (i4 & 112) | (i4 & 896) | (i4 & 7168) | (i4 & 57344), 0);
                x20Var2 = x20Var2;
                x20Var2.p(false);
            } else {
                x20Var2.W(-1751609888);
                x20Var2.p(false);
                x20Var2 = x20Var2;
            }
            x20Var2.p(z3);
        } else {
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new sn2(eo2Var, g32Var, fq0Var, fq0Var2, fq0Var3, hq0Var, hq0Var2, i, 0);
        }
    }

    public static final void f(boolean z, fq0 fq0Var, x20 x20Var, int i) {
        float f;
        long jB;
        x20Var.X(-411098885);
        int i2 = (x20Var.g(z) ? 4 : 2) | i | (x20Var.h(fq0Var) ? 32 : 16);
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            gr2 gr2VarA = vk2.a(z ? uz.p : uz.f, ie4.e(UCharacter.UnicodeBlock.TAKRI_ID, null, 6), "muteTint", x20Var);
            bk1 bk1Var = bk1.a;
            ek1 ek1VarA = vh4.a(w44.g(bk1Var, 48.0f), u82.a(10.0f));
            if (z) {
                f = 10.0f;
                jB = sz.b(0.14f, uz.p);
            } else {
                f = 10.0f;
                jB = uz.c;
            }
            ek1 ek1VarA2 = of4.a(kg1.a(ek1VarA, jB, y34.a), z ? sz.b(0.5f, ((sz) gr2VarA.getValue()).a) : uz.d, u82.a(f));
            int i3 = i2 & 14;
            boolean z2 = i3 == 4;
            Object objL = x20Var.L();
            Object obj = r20.a;
            if (z2 || objL == obj) {
                objL = new un2(z, 1);
                x20Var.g0(objL);
            }
            ek1 ek1VarC = pd3.c(dg2.a(ek1VarA2, (hq0) objL), false, null, new m82(), fq0Var, 11);
            oh1 oh1VarD = gm.d(xy.i, false);
            int iHashCode = Long.hashCode(x20Var.T);
            gw1 gw1VarL = x20Var.l();
            ek1 ek1VarC2 = gj4.c(x20Var, ek1VarC);
            o20.p.getClass();
            fq0 fq0Var2 = n20.b;
            x20Var.Z();
            if (x20Var.S) {
                x20Var.k(fq0Var2);
            } else {
                x20Var.j0();
            }
            ie4.c(x20Var, n20.f, oh1VarD);
            ie4.c(x20Var, n20.e, gw1VarL);
            ie4.a(x20Var, Integer.valueOf(iHashCode), n20.g);
            ie4.b(x20Var, n20.h);
            ie4.c(x20Var, n20.d, ek1VarC2);
            ek1 ek1VarG = w44.g(bk1Var, 15.0f);
            boolean zF = x20Var.f(gr2VarA) | (i3 == 4);
            Object objL2 = x20Var.L();
            if (zF || objL2 == obj) {
                objL2 = new wn2(z, gr2VarA);
                x20Var.g0(objL2);
            }
            dh4.a(ek1VarG, (hq0) objL2, x20Var, 6);
            x20Var.p(true);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new ik(z, fq0Var, i, 2);
        }
    }

    public static final void g(final eo2 eo2Var, final g32 g32Var, final fq0 fq0Var, final hq0 hq0Var, final hq0 hq0Var2, final hq0 hq0Var3, final fq0 fq0Var2, final fq0 fq0Var3, final hq0 hq0Var4, final hq0 hq0Var5, final w10 w10Var, ek1 ek1Var, x20 x20Var, final int i) {
        final ek1 ek1Var2;
        float f;
        rl0 rl0Var;
        int i2;
        boolean z;
        eo2 eo2Var2;
        x20 x20Var2 = x20Var;
        eo2Var.getClass();
        fq0Var.getClass();
        hq0Var.getClass();
        hq0Var2.getClass();
        hq0Var3.getClass();
        fq0Var2.getClass();
        fq0Var3.getClass();
        hq0Var4.getClass();
        hq0Var5.getClass();
        x20Var2.X(-598287656);
        int i3 = (x20Var2.h(hq0Var5) ? 536870912 : 268435456) | i | (x20Var2.h(eo2Var) ? 4 : 2) | (x20Var2.h(g32Var) ? 32 : 16) | (x20Var2.h(fq0Var) ? 256 : 128) | (x20Var2.h(hq0Var2) ? 16384 : 8192) | (x20Var2.h(fq0Var2) ? 1048576 : ArabicShaping.TASHKEEL_RESIZE) | (x20Var2.h(fq0Var3) ? 8388608 : 4194304) | (x20Var2.h(hq0Var4) ? 67108864 : 33554432);
        if (x20Var2.O(i3 & 1, (306716819 & i3) != 306716818)) {
            Object[] objArr = new Object[0];
            Object objL = x20Var2.L();
            Object obj = r20.a;
            if (objL == obj) {
                objL = new tv1(10);
                x20Var2.g0(objL);
            }
            mm1 mm1Var = (mm1) yy3.b(objArr, (fq0) objL, x20Var2);
            Long lValueOf = Long.valueOf(eo2Var.o);
            boolean zH = x20Var2.h(eo2Var) | x20Var2.f(mm1Var);
            Object objL2 = x20Var2.L();
            x50 x50Var = null;
            if (zH || objL2 == obj) {
                objL2 = new y(eo2Var, mm1Var, x50Var, 13);
                x20Var2.g0(objL2);
            }
            bz3.c(x20Var2, (vq0) objL2, lValueOf);
            zt1 zt1Var = (zt1) mm1Var.getValue();
            zt1 zt1Var2 = zt1.a;
            boolean z2 = zt1Var != zt1Var2;
            boolean zF = x20Var2.f(mm1Var);
            Object objL3 = x20Var2.L();
            if (zF || objL3 == obj) {
                objL3 = new hc(mm1Var, 8);
                x20Var2.g0(objL3);
            }
            ye4.a(z2, (fq0) objL3, x20Var2, 0);
            long jC = ki4.c(4278256909L);
            vw0 vw0Var = y34.a;
            rl0 rl0Var2 = w44.b;
            ek1 ek1VarA = kg1.a(rl0Var2, jC, vw0Var);
            ll llVar = xy.b;
            oh1 oh1VarD = gm.d(llVar, false);
            int iHashCode = Long.hashCode(x20Var2.T);
            gw1 gw1VarL = x20Var2.l();
            ek1 ek1VarC = gj4.c(x20Var2, ek1VarA);
            o20.p.getClass();
            k30 k30Var = n20.b;
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            jd jdVar = n20.f;
            ie4.c(x20Var2, jdVar, oh1VarD);
            jd jdVar2 = n20.e;
            ie4.c(x20Var2, jdVar2, gw1VarL);
            Integer numValueOf = Integer.valueOf(iHashCode);
            jd jdVar3 = n20.g;
            ie4.a(x20Var2, numValueOf, jdVar3);
            j7 j7Var = n20.h;
            ie4.b(x20Var2, j7Var);
            jd jdVar4 = n20.d;
            ie4.c(x20Var2, jdVar4, ek1VarC);
            el1 el1Var = el1.b;
            ek1 ek1VarB = kb4.b(kb4.b(rl0Var2, new l63(10)), new l63(9));
            oh1 oh1VarD2 = gm.d(llVar, false);
            int iHashCode2 = Long.hashCode(x20Var2.T);
            gw1 gw1VarL2 = x20Var2.l();
            ek1 ek1VarC2 = gj4.c(x20Var2, ek1VarB);
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            ie4.c(x20Var2, jdVar, oh1VarD2);
            ie4.c(x20Var2, jdVar2, gw1VarL2);
            cq.s(iHashCode2, x20Var2, jdVar3, x20Var2, j7Var);
            ie4.c(x20Var2, jdVar4, ek1VarC2);
            if (((zt1) mm1Var.getValue()) == zt1Var2) {
                x20Var2.W(-1636329008);
                int i4 = i3 >> 9;
                f = 0.0f;
                b(eo2Var, g32Var, fq0Var, fq0Var2, fq0Var3, hq0Var4, hq0Var5, x20Var2, (i3 & 1022) | (i4 & 7168) | (i4 & 57344) | (i4 & 458752) | (i4 & 3670016));
                i2 = 0;
                x20Var2.p(false);
                rl0Var = rl0Var2;
            } else {
                f = 0.0f;
                x20Var2.W(-1636209162);
                sz szVar = new sz(ki4.c(4278391078L));
                long j = uz.a;
                rl0Var = rl0Var2;
                gm.a(rl0Var.c(new mk(0L, new ec1(nz.i(szVar, new sz(j), new sz(j)), null, (((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L), (((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(Float.POSITIVE_INFINITY)) & 4294967295L)), y34.a, 1)), x20Var2, 6);
                i2 = 0;
                x20Var2.p(false);
            }
            ek1 ek1VarB2 = kb4.b(rl0Var, new l63(11));
            j00 j00VarA = h00.a(jg1.d, xy.w, x20Var2, i2);
            int iHashCode3 = Long.hashCode(x20Var2.T);
            gw1 gw1VarL3 = x20Var2.l();
            ek1 ek1VarC3 = gj4.c(x20Var2, ek1VarB2);
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            ie4.c(x20Var2, jdVar, j00VarA);
            ie4.c(x20Var2, jdVar2, gw1VarL3);
            cq.s(iHashCode3, x20Var2, jdVar3, x20Var2, j7Var);
            ie4.c(x20Var2, jdVar4, ek1VarC3);
            zt1 zt1Var3 = (zt1) mm1Var.getValue();
            boolean zF2 = x20Var2.f(mm1Var);
            Object objL4 = x20Var2.L();
            if (zF2 || objL4 == obj) {
                objL4 = new jc(mm1Var, 5);
                x20Var2.g0(objL4);
            }
            j(eo2Var, zt1Var3, (hq0) objL4, hq0Var2, x20Var2, (i3 & 14) | ((i3 >> 3) & 7168));
            int iOrdinal = ((zt1) mm1Var.getValue()).ordinal();
            if (iOrdinal == 0) {
                z = true;
                eo2Var2 = eo2Var;
                x20Var2.W(-857235906);
                x20Var2.p(false);
            } else if (iOrdinal == 1) {
                x20Var2.W(-857234407);
                ek1 ek1VarE = c34.e(k00.a(), 20.0f, f, 2);
                oh1 oh1VarD3 = gm.d(llVar, false);
                int iHashCode4 = Long.hashCode(x20Var2.T);
                gw1 gw1VarL4 = x20Var2.l();
                ek1 ek1VarC4 = gj4.c(x20Var2, ek1VarE);
                x20Var2.Z();
                if (x20Var2.S) {
                    x20Var2.k(k30Var);
                } else {
                    x20Var2.j0();
                }
                ie4.c(x20Var2, jdVar, oh1VarD3);
                ie4.c(x20Var2, jdVar2, gw1VarL4);
                cq.s(iHashCode4, x20Var2, jdVar3, x20Var2, j7Var);
                ie4.c(x20Var2, jdVar4, ek1VarC4);
                int i5 = i3 >> 9;
                int i6 = (i3 & 1022) | (i5 & 7168) | (i5 & 57344) | (i5 & 458752) | (i5 & 3670016);
                eo2Var2 = eo2Var;
                e(eo2Var2, g32Var, fq0Var, fq0Var2, fq0Var3, hq0Var4, hq0Var5, x20Var2, i6);
                z = true;
                x20Var2.p(true);
                x20Var2.p(false);
            } else {
                if (iOrdinal != 2) {
                    x20Var2.W(-857236933);
                    x20Var2.p(false);
                    dk0.l();
                    return;
                }
                x20Var2.W(-857227124);
                ek1 ek1VarE2 = c34.e(k00.a(), 20.0f, f, 2);
                oh1 oh1VarD4 = gm.d(llVar, false);
                int iHashCode5 = Long.hashCode(x20Var2.T);
                gw1 gw1VarL5 = x20Var2.l();
                ek1 ek1VarC5 = gj4.c(x20Var2, ek1VarE2);
                x20Var2.Z();
                if (x20Var2.S) {
                    x20Var2.k(k30Var);
                } else {
                    x20Var2.j0();
                }
                ie4.c(x20Var2, jdVar, oh1VarD4);
                ie4.c(x20Var2, jdVar2, gw1VarL5);
                cq.s(iHashCode5, x20Var2, jdVar3, x20Var2, j7Var);
                ie4.c(x20Var2, jdVar4, ek1VarC5);
                boolean zF3 = x20Var2.f(mm1Var);
                Object objL5 = x20Var2.L();
                if (zF3 || objL5 == obj) {
                    objL5 = new hc(mm1Var, 9);
                    x20Var2.g0(objL5);
                }
                w10Var.c((fq0) objL5, x20Var2, 48);
                x20Var2.p(true);
                x20Var2.p(false);
                z = true;
                eo2Var2 = eo2Var;
            }
            x20Var2.p(z);
            String str = eo2Var2.n;
            String str2 = (str == null || cs2.A(str)) ? null : str;
            if (str2 == null) {
                x20Var2.W(-1635250891);
                x20Var2.p(false);
            } else {
                x20Var2.W(-1635250890);
                dz2.b(str2, c34.d(kg1.a(el1Var.k(xy.n), sz.b(0.92f, uz.a), u82.a(12.0f)), 18.0f, 8.0f), uz.i, 0L, null, null, 0L, new vw2(3), 0L, 0, false, 0, 0, ((v33) x20Var2.j(w33.a)).o, x20Var, CollationFastLatin.LATIN_LIMIT, 0, 130040);
                x20Var2 = x20Var;
                x20Var2.p(false);
                z = true;
            }
            x20Var2.p(z);
            x20Var2.p(z);
            ek1Var2 = bk1.a;
        } else {
            x20Var2.R();
            ek1Var2 = ek1Var;
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new vq0(g32Var, fq0Var, hq0Var, hq0Var2, hq0Var3, fq0Var2, fq0Var3, hq0Var4, hq0Var5, w10Var, ek1Var2, i) { // from class: zn2
                public final /* synthetic */ g32 b;
                public final /* synthetic */ fq0 c;
                public final /* synthetic */ hq0 e;
                public final /* synthetic */ hq0 f;
                public final /* synthetic */ hq0 i;
                public final /* synthetic */ fq0 j;
                public final /* synthetic */ fq0 k;
                public final /* synthetic */ hq0 n;
                public final /* synthetic */ hq0 s;
                public final /* synthetic */ w10 t;
                public final /* synthetic */ ek1 u;

                @Override // defpackage.vq0
                public final Object e(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    int iC = ny3.c(1);
                    k54.g(this.a, this.b, this.c, this.e, this.f, this.i, this.j, this.k, this.n, this.s, this.t, this.u, (x20) obj2, iC);
                    return q43.a;
                }
            };
        }
    }

    public static final void h(x20 x20Var, ek1 ek1Var) {
        eb ebVar = eb.g;
        int iHashCode = Long.hashCode(x20Var.T);
        ek1 ek1VarC = gj4.c(x20Var, ek1Var);
        gw1 gw1VarL = x20Var.l();
        o20.p.getClass();
        k30 k30Var = n20.b;
        x20Var.Z();
        if (x20Var.S) {
            x20Var.k(k30Var);
        } else {
            x20Var.j0();
        }
        ie4.c(x20Var, n20.f, ebVar);
        ie4.c(x20Var, n20.e, gw1VarL);
        ie4.b(x20Var, n20.h);
        ie4.c(x20Var, n20.d, ek1VarC);
        ie4.a(x20Var, Integer.valueOf(iHashCode), n20.g);
        x20Var.p(true);
    }

    public static final void i(boolean z, boolean z2, final fq0 fq0Var, x20 x20Var, final int i) {
        final boolean z3;
        final boolean z4;
        String str;
        x20 x20Var2 = x20Var;
        x20Var2.X(-1535311843);
        int i2 = i | (x20Var2.g(z) ? 4 : 2) | (x20Var2.g(z2) ? 32 : 16) | (x20Var2.h(fq0Var) ? 256 : 128);
        if (x20Var2.O(i2 & 1, (i2 & 147) != 146)) {
            gu1 gu1VarA = sz3.a(x20Var2);
            bk1 bk1Var = bk1.a;
            ek1 ek1VarE = w44.e(bk1Var, 48.0f, 0.0f, 2);
            int i3 = i2 & 112;
            boolean z5 = i3 == 32;
            Object objL = x20Var2.L();
            xy xyVar = r20.a;
            if (z5 || objL == xyVar) {
                objL = new un2(z2, 0);
                x20Var2.g0(objL);
            }
            ek1 ek1VarC = pd3.c(dg2.a(ek1VarE, (hq0) objL), false, null, new m82(), fq0Var, 11);
            oh1 oh1VarD = gm.d(xy.i, false);
            int iHashCode = Long.hashCode(x20Var2.T);
            gw1 gw1VarL = x20Var2.l();
            ek1 ek1VarC2 = gj4.c(x20Var2, ek1VarC);
            o20.p.getClass();
            k30 k30Var = n20.b;
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            jd jdVar = n20.f;
            ie4.c(x20Var2, jdVar, oh1VarD);
            jd jdVar2 = n20.e;
            ie4.c(x20Var2, jdVar2, gw1VarL);
            Integer numValueOf = Integer.valueOf(iHashCode);
            jd jdVar3 = n20.g;
            ie4.a(x20Var2, numValueOf, jdVar3);
            j7 j7Var = n20.h;
            ie4.b(x20Var2, j7Var);
            jd jdVar4 = n20.d;
            ie4.c(x20Var2, jdVar4, ek1VarC2);
            long jB = sz.b(0.7f, ki4.c(4280445850L));
            t82 t82Var = u82.a;
            ek1 ek1VarD = c34.d(kg1.a(of4.a(bk1Var, jB, t82Var), sz.b(0.7f, ki4.c(4278457642L)), t82Var), 10.0f, 5.0f);
            e92 e92VarA = d92.a(new eg(6.0f, new ag(0)), xy.u, x20Var2, 54);
            int iHashCode2 = Long.hashCode(x20Var2.T);
            gw1 gw1VarL2 = x20Var2.l();
            ek1 ek1VarC3 = gj4.c(x20Var2, ek1VarD);
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            ie4.c(x20Var2, jdVar, e92VarA);
            ie4.c(x20Var2, jdVar2, gw1VarL2);
            cq.s(iHashCode2, x20Var2, jdVar3, x20Var2, j7Var);
            ie4.c(x20Var2, jdVar4, ek1VarC3);
            if (z2) {
                str = z ? "ONLINE" : "OFFLINE";
            } else {
                str = "BACK";
            }
            boolean z6 = false;
            dz2.b(str, null, ki4.c(4288932606L), nc4.c(9), np0.f, ev2.c, nc4.c(1), null, 0L, 0, false, 0, 0, null, x20Var, 102261120, 0, 261674);
            x20Var2 = x20Var;
            ek1 ek1VarG = w44.g(bk1Var, 7.0f);
            boolean z7 = i3 == 32;
            if ((i2 & 14) == 4) {
                z6 = true;
            }
            boolean zF = z7 | z6 | x20Var2.f(gu1VarA);
            Object objL2 = x20Var2.L();
            if (zF || objL2 == xyVar) {
                z3 = z;
                z4 = z2;
                objL2 = new ob(z4, z3, gu1VarA);
                x20Var2.g0(objL2);
            } else {
                z3 = z;
                z4 = z2;
            }
            dh4.a(ek1VarG, (hq0) objL2, x20Var2, 6);
            x20Var2.p(true);
            x20Var2.p(true);
        } else {
            z3 = z;
            z4 = z2;
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new vq0(z3, z4, fq0Var, i) { // from class: vn2
                public final /* synthetic */ boolean a;
                public final /* synthetic */ boolean b;
                public final /* synthetic */ fq0 c;

                @Override // defpackage.vq0
                public final Object e(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iC = ny3.c(1);
                    k54.i(this.a, this.b, this.c, (x20) obj, iC);
                    return q43.a;
                }
            };
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7 */
    /* JADX WARN: Type inference failed for: r5v12, types: [x20] */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2, types: [x20] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public static final void j(eo2 eo2Var, zt1 zt1Var, hq0 hq0Var, hq0 hq0Var2, x20 x20Var, int i) {
        ?? r5;
        int i2;
        ?? r14;
        x20Var.X(990231241);
        int i3 = (x20Var.h(eo2Var) ? 4 : 2) | i | (x20Var.d(zt1Var.ordinal()) ? 32 : 16) | (x20Var.h(hq0Var) ? 256 : 128);
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i3 |= x20Var.h(hq0Var2) ? 2048 : 1024;
        }
        if (x20Var.O(i3 & 1, (i3 & 1171) != 1170)) {
            bk1 bk1Var = bk1.a;
            ek1 ek1VarD = c34.d(w44.b(bk1Var, 1.0f), 26.0f, 12.0f);
            e92 e92VarA = d92.a(jg1.f, xy.t, x20Var, 54);
            int iHashCode = Long.hashCode(x20Var.T);
            gw1 gw1VarL = x20Var.l();
            ek1 ek1VarC = gj4.c(x20Var, ek1VarD);
            o20.p.getClass();
            int i4 = i3;
            k30 k30Var = n20.b;
            x20Var.Z();
            if (x20Var.S) {
                x20Var.k(k30Var);
            } else {
                x20Var.j0();
            }
            jd jdVar = n20.f;
            ie4.c(x20Var, jdVar, e92VarA);
            jd jdVar2 = n20.e;
            ie4.c(x20Var, jdVar2, gw1VarL);
            Integer numValueOf = Integer.valueOf(iHashCode);
            jd jdVar3 = n20.g;
            ie4.a(x20Var, numValueOf, jdVar3);
            j7 j7Var = n20.h;
            ie4.b(x20Var, j7Var);
            jd jdVar4 = n20.d;
            ie4.c(x20Var, jdVar4, ek1VarC);
            ek1 ek1VarF = c34.f(new d81(1.0f, true), 3.0f, 0.0f, 0.0f, 13);
            j00 j00VarA = h00.a(jg1.d, xy.w, x20Var, 0);
            int iHashCode2 = Long.hashCode(x20Var.T);
            gw1 gw1VarL2 = x20Var.l();
            ek1 ek1VarC2 = gj4.c(x20Var, ek1VarF);
            x20Var.Z();
            if (x20Var.S) {
                x20Var.k(k30Var);
            } else {
                x20Var.j0();
            }
            ie4.c(x20Var, jdVar, j00VarA);
            ie4.c(x20Var, jdVar2, gw1VarL2);
            cq.s(iHashCode2, x20Var, jdVar3, x20Var, j7Var);
            ie4.c(x20Var, jdVar4, ek1VarC2);
            dz2.b("SONIC", null, ki4.c(4293063935L), nc4.c(19), np0.e, ev2.b, nc4.c(6), null, 0L, 0, false, 0, 0, yz2.a(((v33) x20Var.j(w33.a)).h, 0L, 0L, null, null, 0L, new vj2(2, sz.b(0.5f, ki4.c(4284006399L))), 0L, null, 16769023), x20Var, 102261126, 0, 130602);
            h(x20Var, w44.c(bk1Var, 6.0f));
            dz2.b("AI ASSISTANT", null, ki4.c(4286042858L), nc4.c(9), null, ev2.c, nc4.b(1.8d), null, 0L, 0, false, 0, 0, null, x20Var, 100688262, 0, 261738);
            ?? r6 = x20Var;
            r6.p(true);
            Object obj = r20.a;
            zt1 zt1Var2 = zt1.a;
            if (zt1Var != zt1Var2) {
                r6.W(-1212061705);
                ek1 ek1VarF2 = c34.f(bk1Var, 7.0f, 8.0f, 0.0f, 9);
                r14 = 0;
                oh1 oh1VarD = gm.d(xy.b, false);
                int iHashCode3 = Long.hashCode(r6.T);
                gw1 gw1VarL3 = r6.l();
                ek1 ek1VarC3 = gj4.c(r6, ek1VarF2);
                r6.Z();
                if (r6.S) {
                    r6.k(k30Var);
                } else {
                    r6.j0();
                }
                ie4.c(r6, jdVar, oh1VarD);
                ie4.c(r6, jdVar2, gw1VarL3);
                cq.s(iHashCode3, r6, jdVar3, r6, j7Var);
                ie4.c(r6, jdVar4, ek1VarC3);
                boolean z = eo2Var.m;
                i2 = i4;
                boolean zH = r6.h(eo2Var) | ((i2 & 7168) == 2048);
                Object objL = r6.L();
                if (zH || objL == obj) {
                    objL = new zb(17, hq0Var2, eo2Var);
                    r6.g0(objL);
                }
                f(z, (fq0) objL, r6, 0);
                r6.p(true);
            } else {
                i2 = i4;
                r14 = 0;
                r6.W(-1217727947);
            }
            r6.p(r14);
            boolean z2 = eo2Var.k;
            ?? r13 = zt1Var == zt1Var2 ? 1 : r14;
            int i5 = ((i2 & 112) == 32 ? 1 : r14) | ((i2 & 896) == 256 ? 1 : r14);
            Object objL2 = r6.L();
            if (i5 != 0 || objL2 == obj) {
                objL2 = new zb(18, hq0Var, zt1Var);
                r6.g0(objL2);
            }
            i(z2, r13, (fq0) objL2, r6, r14);
            r6.p(true);
            r5 = r6;
        } else {
            x20 x20Var2 = x20Var;
            x20Var2.R();
            r5 = x20Var2;
        }
        a42 a42VarR = r5.r();
        if (a42VarR != null) {
            a42VarR.d = new t10(eo2Var, zt1Var, hq0Var, hq0Var2, i, 2);
        }
    }

    public static final ek1 k(ek1 ek1Var, fq0 fq0Var, x20 x20Var) {
        Object objL = x20Var.L();
        if (objL == r20.a) {
            objL = new ol1();
            x20Var.g0(objL);
        }
        return pd3.b(ek1Var, (ol1) objL, null, false, new m82(), fq0Var, 12);
    }
}
