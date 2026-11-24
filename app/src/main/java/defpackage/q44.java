package defpackage;

import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.Normalizer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class q44 {
    public static final void a(boolean z, fq0 fq0Var, x20 x20Var, int i) {
        fq0 fq0Var2;
        int i2;
        boolean z2;
        x20 x20Var2 = x20Var;
        x20Var2.X(933534452);
        int i3 = i | (x20Var2.g(z) ? 4 : 2) | (x20Var2.h(fq0Var) ? 32 : 16);
        if (x20Var2.O(i3 & 1, (i3 & 19) != 18)) {
            bk1 bk1Var = bk1.a;
            ek1 ek1VarE = c34.e(w44.b(bk1Var, 1.0f), 0.0f, 6.0f, 1);
            e92 e92VarA = d92.a(jg1.b, xy.u, x20Var2, 48);
            int iHashCode = Long.hashCode(x20Var2.T);
            gw1 gw1VarL = x20Var2.l();
            ek1 ek1VarC = gj4.c(x20Var2, ek1VarE);
            o20.p.getClass();
            k30 k30Var = n20.b;
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            jd jdVar = n20.f;
            ie4.c(x20Var2, jdVar, e92VarA);
            jd jdVar2 = n20.e;
            ie4.c(x20Var2, jdVar2, gw1VarL);
            Integer numValueOf = Integer.valueOf(iHashCode);
            jd jdVar3 = n20.g;
            ie4.a(x20Var2, numValueOf, jdVar3);
            j7 j7Var = n20.h;
            ie4.b(x20Var2, j7Var);
            jd jdVar4 = n20.d;
            ie4.c(x20Var2, jdVar4, ek1VarC);
            i(z, x20Var2, i3 & 14);
            k54.h(x20Var2, w44.g(bk1Var, 8.0f));
            d81 d81Var = new d81(1.0f, true);
            j00 j00VarA = h00.a(jg1.d, xy.w, x20Var2, 0);
            int iHashCode2 = Long.hashCode(x20Var2.T);
            gw1 gw1VarL2 = x20Var2.l();
            ek1 ek1VarC2 = gj4.c(x20Var2, d81Var);
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            ie4.c(x20Var2, jdVar, j00VarA);
            ie4.c(x20Var2, jdVar2, gw1VarL2);
            cq.s(iHashCode2, x20Var2, jdVar3, x20Var2, j7Var);
            ie4.c(x20Var2, jdVar4, ek1VarC2);
            sr2 sr2Var = w33.a;
            i2 = 1;
            dz2.b("Default Assistant Shortcut", null, z ? uz.e : uz.f, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(sr2Var)).k, x20Var, 6, 0, 131066);
            dz2.b("Choose SONIC for your phone's supported assistant shortcuts.", null, uz.g, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var.j(sr2Var)).o, x20Var, 390, 0, 131066);
            x20Var2 = x20Var;
            x20Var2.p(true);
            if (z) {
                fq0Var2 = fq0Var;
                z2 = false;
                x20Var2.W(1289805682);
            } else {
                x20Var2.W(1296950965);
                k54.h(x20Var2, w44.g(bk1Var, 8.0f));
                fq0Var2 = fq0Var;
                g("SET ASSISTANT", fq0Var2, x20Var2, (i3 & 112) | 6);
                z2 = false;
            }
            x20Var2.p(z2);
            x20Var2.p(true);
        } else {
            fq0Var2 = fq0Var;
            i2 = 1;
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new ik(z, fq0Var2, i, i2);
        }
    }

    public static final void b(w10 w10Var, x20 x20Var, int i) {
        x20Var.X(1136890687);
        if (x20Var.O(i & 1, (i & 3) != 2)) {
            ek1 ek1VarC = c34.c(of4.a(kg1.a(vh4.a(w44.b(bk1.a, 1.0f), u82.a(16.0f)), uz.c, y34.a), uz.d, u82.a(16.0f)), 16.0f);
            j00 j00VarA = h00.a(jg1.d, xy.w, x20Var, 0);
            int iHashCode = Long.hashCode(x20Var.T);
            gw1 gw1VarL = x20Var.l();
            ek1 ek1VarC2 = gj4.c(x20Var, ek1VarC);
            o20.p.getClass();
            k30 k30Var = n20.b;
            x20Var.Z();
            if (x20Var.S) {
                x20Var.k(k30Var);
            } else {
                x20Var.j0();
            }
            ie4.c(x20Var, n20.f, j00VarA);
            ie4.c(x20Var, n20.e, gw1VarL);
            ie4.a(x20Var, Integer.valueOf(iHashCode), n20.g);
            ie4.b(x20Var, n20.h);
            ie4.c(x20Var, n20.d, ek1VarC2);
            w10Var.e(x20Var, 6);
            x20Var.p(true);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new gn0(w10Var, i, 2);
        }
    }

    public static final void c(String str, String str2, boolean z, x20 x20Var, int i) {
        x20 x20Var2 = x20Var;
        x20Var2.X(-241927734);
        int i2 = i | (x20Var2.f(str) ? 4 : 2) | (x20Var2.f(str2) ? 32 : 16) | (x20Var2.g(z) ? 256 : 128);
        if (x20Var2.O(i2 & 1, (i2 & 147) != 146)) {
            bk1 bk1Var = bk1.a;
            ek1 ek1VarE = c34.e(w44.b(bk1Var, 1.0f), 0.0f, 6.0f, 1);
            e92 e92VarA = d92.a(jg1.b, xy.u, x20Var2, 48);
            int iHashCode = Long.hashCode(x20Var2.T);
            gw1 gw1VarL = x20Var2.l();
            ek1 ek1VarC = gj4.c(x20Var2, ek1VarE);
            o20.p.getClass();
            k30 k30Var = n20.b;
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            jd jdVar = n20.f;
            ie4.c(x20Var2, jdVar, e92VarA);
            jd jdVar2 = n20.e;
            ie4.c(x20Var2, jdVar2, gw1VarL);
            Integer numValueOf = Integer.valueOf(iHashCode);
            jd jdVar3 = n20.g;
            ie4.a(x20Var2, numValueOf, jdVar3);
            j7 j7Var = n20.h;
            ie4.b(x20Var2, j7Var);
            jd jdVar4 = n20.d;
            ie4.c(x20Var2, jdVar4, ek1VarC);
            i(z, x20Var2, (i2 >> 6) & 14);
            k54.h(x20Var2, w44.g(bk1Var, 8.0f));
            d81 d81Var = new d81(1.0f, true);
            j00 j00VarA = h00.a(jg1.d, xy.w, x20Var2, 0);
            int iHashCode2 = Long.hashCode(x20Var2.T);
            gw1 gw1VarL2 = x20Var2.l();
            ek1 ek1VarC2 = gj4.c(x20Var2, d81Var);
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            ie4.c(x20Var2, jdVar, j00VarA);
            ie4.c(x20Var2, jdVar2, gw1VarL2);
            cq.s(iHashCode2, x20Var2, jdVar3, x20Var2, j7Var);
            ie4.c(x20Var2, jdVar4, ek1VarC2);
            sr2 sr2Var = w33.a;
            dz2.b(str, null, z ? uz.e : uz.f, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(sr2Var)).k, x20Var2, i2 & 14, 0, 131066);
            dz2.b(str2, null, uz.g, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(sr2Var)).o, x20Var2, ((i2 >> 3) & 14) | CollationFastLatin.LATIN_LIMIT, 0, 131066);
            x20Var2 = x20Var2;
            x20Var2.p(true);
            x20Var2.p(true);
        } else {
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new ki2(str, str2, z, i, 1);
        }
    }

    public static final void d(String str, x20 x20Var, int i) {
        x20Var.X(841491729);
        if (x20Var.O(i & 1, (i & 3) != 2)) {
            dz2.b(str, null, uz.h, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var.j(w33.a)).o, x20Var, 390, 0, 131066);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new ei2(str, i, 1);
        }
    }

    public static final void e(String str, fq0 fq0Var, x20 x20Var, int i) {
        int i2;
        x20 x20Var2 = x20Var;
        x20Var2.X(-685117955);
        if ((i & 6) == 0) {
            i2 = i | (x20Var2.f(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var2.h(fq0Var) ? 32 : 16;
        }
        int i3 = i2;
        if (x20Var2.O(i3 & 1, (i3 & 19) != 18)) {
            ek1 ek1VarA = vh4.a(w44.b(bk1.a, 1.0f), u82.a(12.0f));
            long j = uz.h;
            ek1 ek1VarE = c34.e(pd3.c(of4.a(kg1.a(ek1VarA, sz.b(0.16f, j), y34.a), sz.b(0.6f, j), u82.a(12.0f)), false, null, null, fq0Var, 15), 0.0f, 14.0f, 1);
            oh1 oh1VarD = gm.d(xy.i, false);
            int iHashCode = Long.hashCode(x20Var2.T);
            gw1 gw1VarL = x20Var2.l();
            ek1 ek1VarC = gj4.c(x20Var2, ek1VarE);
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
            dz2.b(str, null, j, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(w33.a)).o, x20Var, (i3 & 14) | CollationFastLatin.LATIN_LIMIT, 0, 131066);
            x20Var2 = x20Var;
            x20Var2.p(true);
        } else {
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new gw(i, 4, str, fq0Var);
        }
    }

    public static final void f(final qj2 qj2Var, final fq0 fq0Var, final hq0 hq0Var, final fq0 fq0Var2, final hq0 hq0Var2, final fq0 fq0Var3, final fq0 fq0Var4, final fq0 fq0Var5, final ek1 ek1Var, x20 x20Var, final int i) {
        x20 x20Var2;
        qj2Var.getClass();
        fq0Var.getClass();
        hq0Var.getClass();
        fq0Var2.getClass();
        hq0Var2.getClass();
        fq0Var3.getClass();
        fq0Var4.getClass();
        x20Var.X(1447068794);
        int i2 = i | (x20Var.h(qj2Var) ? 4 : 2) | (x20Var.h(fq0Var) ? 32 : 16) | (x20Var.h(hq0Var) ? 256 : 128) | (x20Var.h(fq0Var2) ? 2048 : 1024) | (x20Var.h(fq0Var3) ? Normalizer.INPUT_IS_FCD : 65536) | (x20Var.h(fq0Var4) ? 1048576 : ArabicShaping.TASHKEEL_RESIZE) | (x20Var.h(fq0Var5) ? 8388608 : 4194304) | (x20Var.f(ek1Var) ? 67108864 : 33554432);
        if (x20Var.O(i2 & 1, (i2 & 38339731) != 38339730)) {
            ek1 ek1VarE = c34.e(i44.f(ek1Var.c(w44.b), i44.d(x20Var)), 20.0f, 0.0f, 2);
            j00 j00VarA = h00.a(jg1.d, xy.w, x20Var, 0);
            int iHashCode = Long.hashCode(x20Var.T);
            gw1 gw1VarL = x20Var.l();
            ek1 ek1VarC = gj4.c(x20Var, ek1VarE);
            o20.p.getClass();
            k30 k30Var = n20.b;
            x20Var.Z();
            if (x20Var.S) {
                x20Var.k(k30Var);
            } else {
                x20Var.j0();
            }
            jd jdVar = n20.f;
            ie4.c(x20Var, jdVar, j00VarA);
            jd jdVar2 = n20.e;
            ie4.c(x20Var, jdVar2, gw1VarL);
            Integer numValueOf = Integer.valueOf(iHashCode);
            jd jdVar3 = n20.g;
            ie4.a(x20Var, numValueOf, jdVar3);
            j7 j7Var = n20.h;
            ie4.b(x20Var, j7Var);
            jd jdVar4 = n20.d;
            ie4.c(x20Var, jdVar4, ek1VarC);
            bk1 bk1Var = bk1.a;
            k54.h(x20Var, w44.c(bk1Var, 36.0f));
            sr2 sr2Var = w33.a;
            dz2.b("SONIC", null, uz.h, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var.j(sr2Var)).e, x20Var, 390, 0, 131066);
            k54.h(x20Var, w44.c(bk1Var, 6.0f));
            dz2.b("Your sovereign AI assistant.", null, uz.e, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var.j(sr2Var)).j, x20Var, 390, 0, 131066);
            k54.h(x20Var, w44.c(bk1Var, 12.0f));
            dz2.b("Review and grant permissions below to enable hands-free voice actions, calling, messaging, and screen control.", null, uz.f, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var.j(sr2Var)).k, x20Var, 390, 0, 131066);
            k54.h(x20Var, w44.c(bk1Var, 18.0f));
            b(yi4.b(-410130035, new km(10, qj2Var, fq0Var), x20Var), x20Var, 6);
            k54.h(x20Var, w44.c(bk1Var, 18.0f));
            b(yi4.b(200936516, new xk(qj2Var, fq0Var2, fq0Var5, hq0Var, 2), x20Var), x20Var, 6);
            k54.h(x20Var, w44.c(bk1Var, 18.0f));
            e(qj2Var.d ? "START TALKING" : "CARRY ON ANYWAY", fq0Var3, x20Var, (i2 >> 12) & 112);
            k54.h(x20Var, w44.c(bk1Var, 8.0f));
            ek1 ek1VarE2 = c34.e(pd3.c(w44.b(bk1Var, 1.0f), false, null, null, fq0Var4, 15), 0.0f, 10.0f, 1);
            oh1 oh1VarD = gm.d(xy.i, false);
            int iHashCode2 = Long.hashCode(x20Var.T);
            gw1 gw1VarL2 = x20Var.l();
            ek1 ek1VarC2 = gj4.c(x20Var, ek1VarE2);
            x20Var.Z();
            if (x20Var.S) {
                x20Var.k(k30Var);
            } else {
                x20Var.j0();
            }
            ie4.c(x20Var, jdVar, oh1VarD);
            ie4.c(x20Var, jdVar2, gw1VarL2);
            cq.s(iHashCode2, x20Var, jdVar3, x20Var, j7Var);
            ie4.c(x20Var, jdVar4, ek1VarC2);
            dz2.b("Skip for now", null, uz.g, 0L, null, null, 0L, new vw2(3), 0L, 0, false, 0, 0, ((v33) x20Var.j(sr2Var)).o, x20Var, 390, 0, 130042);
            x20Var2 = x20Var;
            x20Var2.p(true);
            k54.h(x20Var2, w44.c(bk1Var, 36.0f));
            x20Var2.p(true);
        } else {
            x20Var2 = x20Var;
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new vq0(fq0Var, hq0Var, fq0Var2, hq0Var2, fq0Var3, fq0Var4, fq0Var5, ek1Var, i) { // from class: pj2
                public final /* synthetic */ fq0 b;
                public final /* synthetic */ hq0 c;
                public final /* synthetic */ fq0 e;
                public final /* synthetic */ hq0 f;
                public final /* synthetic */ fq0 i;
                public final /* synthetic */ fq0 j;
                public final /* synthetic */ fq0 k;
                public final /* synthetic */ ek1 n;

                @Override // defpackage.vq0
                public final Object e(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iC = ny3.c(1);
                    q44.f(this.a, this.b, this.c, this.e, this.f, this.i, this.j, this.k, this.n, (x20) obj, iC);
                    return q43.a;
                }
            };
        }
    }

    public static final void g(String str, fq0 fq0Var, x20 x20Var, int i) {
        x20Var.X(-1998687592);
        int i2 = i | (x20Var.h(fq0Var) ? 32 : 16);
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            dz2.b(str, c34.d(pd3.c(of4.a(vh4.a(bk1.a, u82.a(12.0f)), uz.d, u82.a(12.0f)), false, null, null, fq0Var, 15), 10.0f, 6.0f), uz.f, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var.j(w33.a)).o, x20Var, 390, 0, 131064);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new km(i, 11, str, fq0Var);
        }
    }

    public static final void h(op2 op2Var, fq0 fq0Var, x20 x20Var, int i) {
        fq0 fq0Var2;
        boolean z;
        x20 x20Var2 = x20Var;
        x20Var2.X(1001428806);
        int i2 = i | (x20Var2.f(op2Var) ? 4 : 2) | (x20Var2.h(fq0Var) ? 32 : 16);
        if (x20Var2.O(i2 & 1, (i2 & 19) != 18)) {
            bk1 bk1Var = bk1.a;
            ek1 ek1VarE = c34.e(w44.b(bk1Var, 1.0f), 0.0f, 6.0f, 1);
            e92 e92VarA = d92.a(jg1.b, xy.u, x20Var2, 48);
            int iHashCode = Long.hashCode(x20Var2.T);
            gw1 gw1VarL = x20Var2.l();
            ek1 ek1VarC = gj4.c(x20Var2, ek1VarE);
            o20.p.getClass();
            k30 k30Var = n20.b;
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            jd jdVar = n20.f;
            ie4.c(x20Var2, jdVar, e92VarA);
            jd jdVar2 = n20.e;
            ie4.c(x20Var2, jdVar2, gw1VarL);
            Integer numValueOf = Integer.valueOf(iHashCode);
            jd jdVar3 = n20.g;
            ie4.a(x20Var2, numValueOf, jdVar3);
            j7 j7Var = n20.h;
            ie4.b(x20Var2, j7Var);
            jd jdVar4 = n20.d;
            ie4.c(x20Var2, jdVar4, ek1VarC);
            boolean z2 = op2Var.d;
            i(z2, x20Var2, 0);
            k54.h(x20Var2, w44.g(bk1Var, 8.0f));
            d81 d81Var = new d81(1.0f, true);
            j00 j00VarA = h00.a(jg1.d, xy.w, x20Var2, 0);
            int iHashCode2 = Long.hashCode(x20Var2.T);
            gw1 gw1VarL2 = x20Var2.l();
            ek1 ek1VarC2 = gj4.c(x20Var2, d81Var);
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            ie4.c(x20Var2, jdVar, j00VarA);
            ie4.c(x20Var2, jdVar2, gw1VarL2);
            cq.s(iHashCode2, x20Var2, jdVar3, x20Var2, j7Var);
            ie4.c(x20Var2, jdVar4, ek1VarC2);
            String str = op2Var.b;
            sr2 sr2Var = w33.a;
            dz2.b(str, null, z2 ? uz.e : uz.f, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(sr2Var)).k, x20Var, 0, 0, 131066);
            dz2.b(op2Var.c, null, uz.g, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var.j(sr2Var)).o, x20Var, CollationFastLatin.LATIN_LIMIT, 0, 131066);
            x20Var2 = x20Var;
            x20Var2.p(true);
            if (z2) {
                fq0Var2 = fq0Var;
                z = false;
                x20Var2.W(-2064597928);
            } else {
                x20Var2.W(-2056586009);
                k54.h(x20Var2, w44.g(bk1Var, 8.0f));
                fq0Var2 = fq0Var;
                g("OPEN", fq0Var2, x20Var2, (i2 & 112) | 6);
                z = false;
            }
            x20Var2.p(z);
            x20Var2.p(true);
        } else {
            fq0Var2 = fq0Var;
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new km(i, 12, op2Var, fq0Var2);
        }
    }

    public static final void i(boolean z, x20 x20Var, int i) {
        int i2;
        x20Var.X(927308201);
        if ((i & 6) == 0) {
            i2 = (x20Var.g(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (x20Var.O(i2 & 1, (i2 & 3) != 2)) {
            ek1 ek1VarG = w44.g(bk1.a, 12.0f);
            t82 t82Var = u82.a;
            gm.a(of4.a(kg1.a(vh4.a(ek1VarG, t82Var), z ? uz.m : sz.f, y34.a), z ? uz.m : uz.d, t82Var), x20Var, 0);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new ii2(i, 1, z);
        }
    }

    public static final void j() {
        throw new UnsupportedOperationException();
    }
}
