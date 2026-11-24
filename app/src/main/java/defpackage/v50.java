package defpackage;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class v50 {
    public static final q50 a;

    static {
        m30 m30Var = fb.a;
        long j = sz.c;
        long j2 = sz.b;
        a = new q50(j, j2, j2, sz.b(0.38f, j2), sz.b(0.38f, j2));
    }

    public static final void a(q50 q50Var, ek1 ek1Var, w10 w10Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(-527864079);
        if ((i & 6) == 0) {
            i2 = (x20Var.f(q50Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.f(ek1Var) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var.h(w10Var) ? 256 : 128;
        }
        if (x20Var.O(i2 & 1, (i2 & 147) != 146)) {
            kl klVar = s50.a;
            t82 t82VarA = u82.a(4.0f);
            boolean z = de0.a(3.0f, 0.0f) > 0;
            long j = zu0.a;
            ek1 ek1VarF = i44.f(c34.e(kg1.a((de0.a(3.0f, 0.0f) > 0 || z) ? ek1Var.c(new wj2(t82VarA, z, j, j)) : ek1Var, q50Var.a, y34.a).c(new c31()), 0.0f, s50.d, 1), i44.d(x20Var));
            int i3 = (i2 << 3) & 7168;
            j00 j00VarA = h00.a(jg1.d, xy.w, x20Var, 0);
            int iHashCode = Long.hashCode(x20Var.T);
            gw1 gw1VarL = x20Var.l();
            ek1 ek1VarC = gj4.c(x20Var, ek1VarF);
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
            ie4.c(x20Var, n20.d, ek1VarC);
            w10Var.c(k00.a, x20Var, Integer.valueOf(((i3 >> 6) & 112) | 6));
            x20Var.p(true);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new mb(q50Var, ek1Var, w10Var, i, 4);
        }
    }

    public static final void b(ek1 ek1Var, q50 q50Var, hq0 hq0Var, x20 x20Var, int i, int i2) {
        int i3;
        int i4;
        x20Var.X(-625529233);
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
        } else {
            i3 = (x20Var.f(ek1Var) ? 4 : 2) | i;
        }
        int i6 = i2 & 2;
        if (i6 != 0) {
            i4 = i3 | 48;
        } else {
            i4 = i3 | (x20Var.f(q50Var) ? 32 : 16);
        }
        int i7 = i4 | (x20Var.h(hq0Var) ? 256 : 128);
        int i8 = 0;
        if (x20Var.O(i7 & 1, (i7 & 147) != 146)) {
            if (i5 != 0) {
                ek1Var = bk1.a;
            }
            if (i6 != 0) {
                q50Var = a;
            }
            a(q50Var, ek1Var, yi4.b(-250345048, new t50(i8, hq0Var, q50Var), x20Var), x20Var, ((i7 << 3) & 112) | ((i7 >> 3) & 14) | CollationFastLatin.LATIN_LIMIT);
        } else {
            x20Var.R();
        }
        ek1 ek1Var2 = ek1Var;
        q50 q50Var2 = q50Var;
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new mb(ek1Var2, q50Var2, hq0Var, i, i2);
        }
    }

    public static final void c(final String str, final boolean z, final q50 q50Var, final ek1 ek1Var, final wq0 wq0Var, final fq0 fq0Var, x20 x20Var, final int i) {
        int i2;
        x20 x20Var2 = x20Var;
        x20Var2.X(-2001167027);
        if ((i & 6) == 0) {
            i2 = (x20Var2.f(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var2.g(z) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var2.f(q50Var) ? 256 : 128;
        }
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i2 |= x20Var2.f(ek1Var) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= x20Var2.h(wq0Var) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= x20Var2.h(fq0Var) ? 131072 : 65536;
        }
        int i3 = i2;
        if (x20Var2.O(i3 & 1, (74899 & i3) != 74898)) {
            kl klVar = s50.a;
            float f = s50.c;
            eg egVar = new eg(f, new ag(0));
            boolean z2 = ((i3 & 112) == 32) | ((458752 & i3) == 131072);
            Object objL = x20Var2.L();
            if (z2 || objL == r20.a) {
                objL = new hk(z, fq0Var, 1);
                x20Var2.g0(objL);
            }
            ek1 ek1VarE = c34.e(w44.b(pd3.c(ek1Var, z, str, null, (fq0) objL, 12), 1.0f).c(new yk2(112.0f, 48.0f, 280.0f, 48.0f, true)), f, 0.0f, 2);
            e92 e92VarA = d92.a(egVar, klVar, x20Var2, 54);
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
            if (wq0Var == null) {
                x20Var2.W(-1597947094);
                x20Var2.p(false);
            } else {
                x20Var2.W(-1597947093);
                float f2 = s50.e;
                ek1 ek1VarF = w44.f(bk1.a, f2, 0.0f, f2, f2, 2);
                oh1 oh1VarD = gm.d(xy.b, false);
                int iHashCode2 = Long.hashCode(x20Var2.T);
                gw1 gw1VarL2 = x20Var2.l();
                ek1 ek1VarC2 = gj4.c(x20Var2, ek1VarF);
                x20Var2.Z();
                if (x20Var2.S) {
                    x20Var2.k(k30Var);
                } else {
                    x20Var2.j0();
                }
                ie4.c(x20Var2, jdVar, oh1VarD);
                ie4.c(x20Var2, jdVar2, gw1VarL2);
                cq.s(iHashCode2, x20Var2, jdVar3, x20Var2, j7Var);
                ie4.c(x20Var2, jdVar4, ek1VarC2);
                wq0Var.c(new sz(z ? q50Var.c : q50Var.e), x20Var2, 0);
                x20Var2.p(true);
                x20Var2.p(false);
            }
            long j = z ? q50Var.b : q50Var.d;
            ef4.a(str, new d81(1.0f, true), new yz2(j, s50.h, s50.i, null, s50.k, s50.b, s50.j, 16613240), 0, false, 1, 0, x20Var2, (i3 & 14) | 1572864, 952);
            x20Var2 = x20Var2;
            x20Var2.p(true);
        } else {
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new vq0() { // from class: u50
                @Override // defpackage.vq0
                public final Object e(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    v50.c(str, z, q50Var, ek1Var, wq0Var, fq0Var, (x20) obj, ny3.c(i | 1));
                    return q43.a;
                }
            };
        }
    }
}
