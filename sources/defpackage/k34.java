package defpackage;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.Normalizer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class k34 {
    public static final StackTraceElement[] a = new StackTraceElement[0];

    public static final void a(String str, long j, x20 x20Var, int i) {
        x20Var.X(-1748749590);
        int i2 = i | (x20Var.f(str) ? 4 : 2);
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            dz2.b(str, c34.c(of4.a(kg1.a(vh4.a(w44.b(bk1.a, 1.0f), u82.a(16.0f)), uz.c, y34.a), j, u82.a(16.0f)), 16.0f), j, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var.j(w33.a)).o, x20Var, (i2 & 14) | CollationFastLatin.LATIN_LIMIT, 0, 131064);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new ls1(i, j, str);
        }
    }

    public static final void b(String str, x20 x20Var, int i) {
        int i2;
        x20Var.X(1313211189);
        if ((i & 6) == 0) {
            i2 = i | (x20Var.f(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (x20Var.O(i2 & 1, (i2 & 3) != 2)) {
            dz2.b(str, null, uz.f, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var.j(w33.a)).o, x20Var, (i2 & 14) | CollationFastLatin.LATIN_LIMIT, 0, 131066);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new s91(str, i, 1);
        }
    }

    public static final void c(String str, String str2, boolean z, x20 x20Var, int i) {
        x20 x20Var2 = x20Var;
        x20Var2.X(-2045907897);
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
            ie4.c(x20Var2, n20.f, e92VarA);
            ie4.c(x20Var2, n20.e, gw1VarL);
            ie4.a(x20Var2, Integer.valueOf(iHashCode), n20.g);
            ie4.b(x20Var2, n20.h);
            ie4.c(x20Var2, n20.d, ek1VarC);
            gm.a(kg1.a(vh4.a(w44.g(bk1Var, 8.0f), u82.a), z ? uz.m : uz.p, y34.a), x20Var2, 0);
            k54.h(x20Var2, w44.g(bk1Var, 8.0f));
            sr2 sr2Var = w33.a;
            dz2.b(str, new d81(1.0f, true), uz.e, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(sr2Var)).k, x20Var2, (i2 & 14) | CollationFastLatin.LATIN_LIMIT, 0, 131064);
            dz2.b(str2, null, z ? uz.m : uz.f, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(sr2Var)).o, x20Var2, (i2 >> 3) & 14, 0, 131066);
            x20Var2 = x20Var2;
            x20Var2.p(true);
        } else {
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new ki2(str, str2, z, i, 0);
        }
    }

    public static final void d(fq0 fq0Var, x20 x20Var, int i) {
        x20Var.X(208582902);
        int i2 = i | (x20Var.h(fq0Var) ? 32 : 16);
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            yz2 yz2Var = ((v33) x20Var.j(w33.a)).o;
            long j = uz.p;
            dz2.b("ERASE STORED SECRETS", c34.e(pd3.c(of4.a(kg1.a(vh4.a(w44.b(bk1.a, 1.0f), u82.a(16.0f)), uz.c, y34.a), j, u82.a(16.0f)), false, null, null, fq0Var, 15), 0.0f, 8.0f, 1), j, 0L, null, null, 0L, new vw2(3), 0L, 0, false, 0, 0, yz2Var, x20Var, 390, 0, 130040);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new ji2(fq0Var, i);
        }
    }

    public static final void e(final gj2 gj2Var, final hq0 hq0Var, final fq0 fq0Var, final fq0 fq0Var2, x20 x20Var, int i) {
        k30 k30Var;
        mm1 mm1Var;
        boolean z;
        boolean z2;
        bk1 bk1Var;
        float f;
        x20 x20Var2 = x20Var;
        x20Var2.X(-1349198969);
        int i2 = i | (x20Var2.h(gj2Var) ? 4 : 2) | (x20Var2.h(hq0Var) ? 32 : 16) | (x20Var2.h(fq0Var) ? 256 : 128) | (x20Var2.h(fq0Var2) ? 2048 : 1024);
        if (x20Var2.O(i2 & 1, (i2 & 1171) != 1170)) {
            Object objL = x20Var2.L();
            xy xyVar = r20.a;
            if (objL == xyVar) {
                objL = o44.g("");
                x20Var2.g0(objL);
            }
            mm1 mm1Var2 = (mm1) objL;
            final zm2 zm2Var = (zm2) x20Var2.j(l30.p);
            jl jlVar = xy.w;
            cg cgVar = jg1.d;
            j00 j00VarA = h00.a(cgVar, jlVar, x20Var2, 0);
            int iHashCode = Long.hashCode(x20Var2.T);
            gw1 gw1VarL = x20Var2.l();
            bk1 bk1Var2 = bk1.a;
            ek1 ek1VarC = gj4.c(x20Var2, bk1Var2);
            o20.p.getClass();
            k30 k30Var2 = n20.b;
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var2);
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
            kl klVar = xy.u;
            bg bgVar = jg1.b;
            e92 e92VarA = d92.a(bgVar, klVar, x20Var2, 48);
            int iHashCode2 = Long.hashCode(x20Var2.T);
            gw1 gw1VarL2 = x20Var2.l();
            ek1 ek1VarC2 = gj4.c(x20Var2, bk1Var2);
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var2);
            } else {
                x20Var2.j0();
            }
            ie4.c(x20Var2, jdVar, e92VarA);
            ie4.c(x20Var2, jdVar2, gw1VarL2);
            cq.s(iHashCode2, x20Var2, jdVar3, x20Var2, j7Var);
            ie4.c(x20Var2, jdVar4, ek1VarC2);
            ek1 ek1VarG = w44.g(bk1Var2, 8.0f);
            boolean z3 = gj2Var.d;
            String str = gj2Var.v;
            s51 s51Var = gj2Var.f;
            gm.a(kg1.a(ek1VarG, z3 ? uz.m : uz.g, u82.a), x20Var2, 0);
            k54.h(x20Var2, w44.g(bk1Var2, 8.0f));
            String str2 = z3 ? "Key saved" : "No key saved";
            sr2 sr2Var = w33.a;
            dz2.b(str2, null, z3 ? uz.e : uz.f, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(sr2Var)).o, x20Var, 0, 0, 131066);
            x20Var.p(true);
            k54.h(x20Var, w44.c(bk1Var2, 12.0f));
            ek1 ek1VarA = vh4.a(w44.b(bk1Var2, 1.0f), u82.a(8.0f));
            long j = uz.c;
            vw0 vw0Var = y34.a;
            ek1 ek1VarD = c34.d(of4.a(kg1.a(ek1VarA, j, vw0Var), uz.d, u82.a(8.0f)), 12.0f, 10.0f);
            ll llVar = xy.b;
            oh1 oh1VarD = gm.d(llVar, false);
            int iHashCode3 = Long.hashCode(x20Var.T);
            gw1 gw1VarL3 = x20Var.l();
            ek1 ek1VarC3 = gj4.c(x20Var, ek1VarD);
            x20Var.Z();
            if (x20Var.S) {
                k30Var = k30Var2;
                x20Var.k(k30Var);
            } else {
                k30Var = k30Var2;
                x20Var.j0();
            }
            ie4.c(x20Var, jdVar, oh1VarD);
            ie4.c(x20Var, jdVar2, gw1VarL3);
            cq.s(iHashCode3, x20Var, jdVar3, x20Var, j7Var);
            ie4.c(x20Var, jdVar4, ek1VarC3);
            String str3 = (String) mm1Var2.getValue();
            nu1 nu1Var = new nu1();
            yz2 yz2Var = ((v33) x20Var.j(sr2Var)).k;
            long j2 = uz.e;
            yz2 yz2VarA = yz2.a(yz2Var, j2, 0L, null, null, 0L, null, 0L, null, 16777214);
            long j3 = uz.h;
            cn2 cn2Var = new cn2(j3);
            u51 u51Var = new u51(113);
            ek1 ek1VarB = w44.b(bk1Var2, 1.0f);
            Object objL2 = x20Var.L();
            if (objL2 == xyVar) {
                mm1Var = mm1Var2;
                objL2 = new jc(mm1Var, 4);
                x20Var.g0(objL2);
            } else {
                mm1Var = mm1Var2;
            }
            k30 k30Var3 = k30Var;
            final mm1 mm1Var3 = mm1Var;
            zk.a(str3, (hq0) objL2, ek1VarB, false, yz2VarA, u51Var, null, true, 0, 0, nu1Var, null, cn2Var, yi4.b(1379625070, new xv(6, mm1Var), x20Var), x20Var, 100663728);
            x20Var2 = x20Var;
            x20Var2.p(true);
            k54.h(x20Var2, w44.c(bk1Var2, 12.0f));
            vn4.a(null, new eg(8.0f, new ag(0)), new eg(8.0f, new ag(0)), null, 0, 0, yi4.b(1332075148, new wq0() { // from class: hi2
                @Override // defpackage.wq0
                public final Object c(Object obj, Object obj2, Object obj3) {
                    x20 x20Var3 = (x20) obj2;
                    int iIntValue = ((Integer) obj3).intValue();
                    ((nn0) obj).getClass();
                    if (x20Var3.O(iIntValue & 1, (iIntValue & 17) != 16)) {
                        mm1 mm1Var4 = mm1Var3;
                        boolean z4 = !cs2.A((String) mm1Var4.getValue());
                        gj2 gj2Var2 = gj2Var;
                        boolean zH = x20Var3.h(gj2Var2);
                        zm2 zm2Var2 = zm2Var;
                        boolean zF = zH | x20Var3.f(zm2Var2);
                        hq0 hq0Var2 = hq0Var;
                        boolean zF2 = zF | x20Var3.f(hq0Var2);
                        Object objL3 = x20Var3.L();
                        xy xyVar2 = r20.a;
                        if (zF2 || objL3 == xyVar2) {
                            objL3 = new t01(gj2Var2, zm2Var2, hq0Var2, mm1Var4);
                            x20Var3.g0(objL3);
                        }
                        int i3 = 6;
                        k34.g("SAVE & CONNECT", z4, (fq0) objL3, x20Var3, 6);
                        String str4 = gj2Var2.f instanceof q51 ? "TESTING…" : "TEST";
                        boolean zH2 = x20Var3.h(gj2Var2) | x20Var3.f(zm2Var2);
                        fq0 fq0Var3 = fq0Var2;
                        boolean zF3 = zH2 | x20Var3.f(fq0Var3);
                        Object objL4 = x20Var3.L();
                        if (zF3 || objL4 == xyVar2) {
                            objL4 = new ek(gj2Var2, zm2Var2, fq0Var3, i3);
                            x20Var3.g0(objL4);
                        }
                        k34.g(str4, false, (fq0) objL4, x20Var3, 48);
                        if (gj2Var2.d) {
                            x20Var3.W(-1646276272);
                            boolean zH3 = x20Var3.h(gj2Var2);
                            fq0 fq0Var4 = fq0Var;
                            boolean zF4 = zH3 | x20Var3.f(fq0Var4);
                            Object objL5 = x20Var3.L();
                            if (zF4 || objL5 == xyVar2) {
                                objL5 = new zb(15, gj2Var2, fq0Var4);
                                x20Var3.g0(objL5);
                            }
                            k34.g("REMOVE", false, (fq0) objL5, x20Var3, 54);
                        } else {
                            x20Var3.W(-1658678442);
                        }
                        x20Var3.p(false);
                    } else {
                        x20Var3.R();
                    }
                    return q43.a;
                }
            }, x20Var2), x20Var2, 1573296);
            if (s51Var instanceof q51) {
                x20Var2.W(1675586358);
                k54.h(x20Var2, w44.c(bk1Var2, 12.0f));
                ek1 ek1VarC4 = c34.c(of4.a(kg1.a(vh4.a(w44.b(bk1Var2, 1.0f), u82.a(12.0f)), j, vw0Var), j3, u82.a(12.0f)), 16.0f);
                oh1 oh1VarD2 = gm.d(llVar, false);
                int iHashCode4 = Long.hashCode(x20Var2.T);
                gw1 gw1VarL4 = x20Var2.l();
                ek1 ek1VarC5 = gj4.c(x20Var2, ek1VarC4);
                x20Var2.Z();
                if (x20Var2.S) {
                    x20Var2.k(k30Var3);
                } else {
                    x20Var2.j0();
                }
                ie4.c(x20Var2, jdVar, oh1VarD2);
                ie4.c(x20Var2, jdVar2, gw1VarL4);
                cq.s(iHashCode4, x20Var2, jdVar3, x20Var2, j7Var);
                ie4.c(x20Var2, jdVar4, ek1VarC5);
                e92 e92VarA2 = d92.a(bgVar, klVar, x20Var2, 48);
                int iHashCode5 = Long.hashCode(x20Var2.T);
                gw1 gw1VarL5 = x20Var2.l();
                ek1 ek1VarC6 = gj4.c(x20Var2, bk1Var2);
                x20Var2.Z();
                if (x20Var2.S) {
                    x20Var2.k(k30Var3);
                } else {
                    x20Var2.j0();
                }
                ie4.c(x20Var2, jdVar, e92VarA2);
                ie4.c(x20Var2, jdVar2, gw1VarL5);
                cq.s(iHashCode5, x20Var2, jdVar3, x20Var2, j7Var);
                ie4.c(x20Var2, jdVar4, ek1VarC6);
                t12.a(w44.g(bk1Var2, 24.0f), j3, 2.5f, 0L, 0, 0.0f, x20Var, 438);
                k54.h(x20Var, w44.g(bk1Var2, 12.0f));
                j00 j00VarA2 = h00.a(cgVar, jlVar, x20Var, 0);
                int iHashCode6 = Long.hashCode(x20Var.T);
                gw1 gw1VarL6 = x20Var.l();
                ek1 ek1VarC7 = gj4.c(x20Var, bk1Var2);
                x20Var.Z();
                if (x20Var.S) {
                    x20Var.k(k30Var3);
                } else {
                    x20Var.j0();
                }
                ie4.c(x20Var, jdVar, j00VarA2);
                ie4.c(x20Var, jdVar2, gw1VarL6);
                cq.s(iHashCode6, x20Var, jdVar3, x20Var, j7Var);
                ie4.c(x20Var, jdVar4, ek1VarC7);
                dz2.b("Connecting to Gemini…", null, j2, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var.j(sr2Var)).k, x20Var, 390, 0, 131066);
                String str4 = str;
                if (str4 == null) {
                    str4 = "Checking connection… Please wait.";
                }
                dz2.b(str4, null, j3, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var.j(sr2Var)).o, x20Var, CollationFastLatin.LATIN_LIMIT, 0, 131066);
                x20Var2 = x20Var;
                z2 = true;
                x20Var2.p(true);
                x20Var2.p(true);
                x20Var2.p(true);
                z = false;
                x20Var2.p(false);
                bk1Var = bk1Var2;
                f = 12.0f;
            } else {
                z = false;
                z2 = true;
                x20Var2.W(1676730227);
                if (str == null) {
                    x20Var2.W(1676766434);
                    x20Var2.p(false);
                    bk1Var = bk1Var2;
                    f = 12.0f;
                } else {
                    x20Var2.W(1676766435);
                    bk1Var = bk1Var2;
                    f = 12.0f;
                    k54.h(x20Var2, w44.c(bk1Var, 12.0f));
                    b(str, x20Var2, 0);
                    x20Var2.p(false);
                }
                x20Var2.p(false);
            }
            if (g31.a(s51Var, r51.a)) {
                x20Var2.W(-777188587);
                x20Var2.p(z);
            } else if (g31.a(s51Var, q51.a)) {
                x20Var2.W(-777187435);
                x20Var2.p(z);
            } else if (s51Var instanceof p51) {
                x20Var2.W(1677034244);
                k54.h(x20Var2, w44.c(bk1Var, f));
                a("Connected to Gemini.", uz.m, x20Var2, 48);
                x20Var2.p(z);
            } else if (!(s51Var instanceof o51)) {
                x20Var2.W(-777190301);
                x20Var2.p(z);
                dk0.l();
                return;
            } else {
                x20Var2.W(1677176100);
                k54.h(x20Var2, w44.c(bk1Var, f));
                a(((o51) s51Var).a, uz.p, x20Var2, 48);
                x20Var2.p(z);
            }
            x20Var2.p(z2);
        } else {
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new di2(gj2Var, hq0Var, fq0Var, fq0Var2, i);
        }
    }

    public static final void f(String str, x20 x20Var, int i) {
        x20Var.X(-605138713);
        int i2 = i | (x20Var.f(str) ? 4 : 2);
        if (x20Var.O(i2 & 1, (i2 & 3) != 2)) {
            yz2 yz2Var = ((v33) x20Var.j(w33.a)).k;
            long j = uz.r;
            dz2.b(str, c34.c(of4.a(kg1.a(vh4.a(w44.b(bk1.a, 1.0f), u82.a(12.0f)), uz.c, y34.a), j, u82.a(12.0f)), 16.0f), j, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, yz2Var, x20Var, (i2 & 14) | CollationFastLatin.LATIN_LIMIT, 0, 131064);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new ei2(str, i, 0);
        }
    }

    public static final void g(String str, boolean z, fq0 fq0Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(-809916722);
        if ((i & 6) == 0) {
            i2 = i | (x20Var.f(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.g(z) ? 32 : 16;
        }
        int i3 = i2 | (x20Var.h(fq0Var) ? 256 : 128);
        if (x20Var.O(i3 & 1, (i3 & 147) != 146)) {
            gr2 gr2VarA = vk2.a(z ? uz.h : uz.f, ie4.e(200, null, 6), "pillTint", x20Var);
            dz2.b(str, c34.d(pd3.c(of4.a(kg1.a(vh4.a(bk1.a, u82.a(16.0f)), uz.c, y34.a), ((sz) gr2VarA.getValue()).a, u82.a(16.0f)), false, null, null, fq0Var, 15), 12.0f, 8.0f), ((sz) gr2VarA.getValue()).a, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var.j(w33.a)).o, x20Var, i3 & 14, 0, 131064);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new tb(str, z, fq0Var, i);
        }
    }

    public static final void h(String str, w10 w10Var, x20 x20Var, int i) {
        vq0 vq0Var;
        x20 x20Var2 = x20Var;
        x20Var2.X(627374421);
        if (x20Var2.O(i & 1, (i & 19) != 18)) {
            jl jlVar = xy.w;
            cg cgVar = jg1.d;
            j00 j00VarA = h00.a(cgVar, jlVar, x20Var2, 0);
            int iHashCode = Long.hashCode(x20Var2.T);
            gw1 gw1VarL = x20Var2.l();
            bk1 bk1Var = bk1.a;
            ek1 ek1VarC = gj4.c(x20Var2, bk1Var);
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
            dz2.b(str, c34.f(bk1Var, 0.0f, 0.0f, 12.0f, 7), uz.h, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(w33.a)).o, x20Var2, 438, 0, 131064);
            x20Var2 = x20Var2;
            ek1 ek1VarC2 = c34.c(of4.a(kg1.a(vh4.a(w44.b(bk1Var, 1.0f), u82.a(12.0f)), uz.c, y34.a), uz.d, u82.a(12.0f)), 16.0f);
            j00 j00VarA2 = h00.a(cgVar, jlVar, x20Var2, 0);
            int iHashCode2 = Long.hashCode(x20Var2.T);
            gw1 gw1VarL2 = x20Var2.l();
            ek1 ek1VarC3 = gj4.c(x20Var2, ek1VarC2);
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            ie4.c(x20Var2, jdVar, j00VarA2);
            ie4.c(x20Var2, jdVar2, gw1VarL2);
            cq.s(iHashCode2, x20Var2, jdVar3, x20Var2, j7Var);
            ie4.c(x20Var2, jdVar4, ek1VarC3);
            vq0Var = w10Var;
            vq0Var.e(x20Var2, 6);
            x20Var2.p(true);
            x20Var2.p(true);
        } else {
            vq0Var = w10Var;
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new km(i, 9, str, vq0Var);
        }
    }

    public static final void i(gj2 gj2Var, final hq0 hq0Var, final hq0 hq0Var2, final fq0 fq0Var, final fq0 fq0Var2, final hq0 hq0Var3, final hq0 hq0Var4, final hq0 hq0Var5, final hq0 hq0Var6, final hq0 hq0Var7, final hq0 hq0Var8, final fq0 fq0Var3, final fq0 fq0Var4, final hq0 hq0Var9, final fq0 fq0Var5, final fq0 fq0Var6, final fq0 fq0Var7, ek1 ek1Var, x20 x20Var, final int i, final int i2) {
        int i3;
        final ek1 ek1Var2;
        boolean z;
        final gj2 gj2Var2 = gj2Var;
        gj2Var2.getClass();
        hq0Var.getClass();
        hq0Var2.getClass();
        fq0Var.getClass();
        fq0Var2.getClass();
        hq0Var5.getClass();
        hq0Var6.getClass();
        hq0Var7.getClass();
        fq0Var7.getClass();
        x20Var.X(198433187);
        int i4 = i | (x20Var.h(gj2Var2) ? 4 : 2) | (x20Var.h(hq0Var) ? 32 : 16) | (x20Var.h(hq0Var2) ? 256 : 128) | (x20Var.h(fq0Var) ? 2048 : 1024) | (x20Var.h(fq0Var2) ? 16384 : 8192) | (x20Var.h(hq0Var3) ? Normalizer.INPUT_IS_FCD : 65536) | (x20Var.h(hq0Var5) ? 8388608 : 4194304) | (x20Var.h(hq0Var6) ? 67108864 : 33554432) | (x20Var.h(hq0Var7) ? 536870912 : 268435456);
        if ((i2 & 6) == 0) {
            i3 = i2 | (x20Var.h(hq0Var8) ? 4 : 2);
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= x20Var.h(fq0Var3) ? 32 : 16;
        }
        if ((i2 & CollationFastLatin.LATIN_LIMIT) == 0) {
            i3 |= x20Var.h(fq0Var4) ? 256 : 128;
        }
        if ((i2 & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i3 |= x20Var.h(hq0Var9) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= x20Var.h(fq0Var5) ? 16384 : 8192;
        }
        if ((1572864 & i2) == 0) {
            i3 |= x20Var.h(fq0Var7) ? 1048576 : ArabicShaping.TASHKEEL_RESIZE;
        }
        if (x20Var.O(i4 & 1, ((i4 & 306259091) == 306259090 && ((i3 | 12582912) & 4727955) == 4727954) ? false : true)) {
            bk1 bk1Var = bk1.a;
            ek1 ek1VarF = i44.f(w44.b(bk1Var, 1.0f), i44.d(x20Var));
            j00 j00VarA = h00.a(new eg(20.0f, new ag(0)), xy.w, x20Var, 6);
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
            String str = gj2Var2.u;
            if (str == null) {
                x20Var.W(-1372630410);
                z = false;
            } else {
                z = false;
                x20Var.W(-1372630409);
                f(str, x20Var, 0);
            }
            x20Var.p(z);
            h("1. CONVERSATION", yi4.b(354000434, new vq0() { // from class: mi2
                @Override // defpackage.vq0
                public final Object e(Object obj, Object obj2) {
                    x20 x20Var2 = (x20) obj;
                    int iIntValue = ((Integer) obj2).intValue();
                    if (x20Var2.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                        k34.b("Conversation mode", x20Var2, 6);
                        bk1 bk1Var2 = bk1.a;
                        k54.h(x20Var2, w44.c(bk1Var2, 8.0f));
                        eg egVar = new eg(8.0f, new ag(0));
                        eg egVar2 = new eg(8.0f, new ag(0));
                        gj2 gj2Var3 = gj2Var2;
                        vn4.a(null, egVar, egVar2, null, 0, 0, yi4.b(287329773, new t50(gj2Var3, hq0Var3, 3), x20Var2), x20Var2, 1573296);
                        k54.h(x20Var2, w44.c(bk1Var2, 12.0f));
                        k34.k("Continuous listening", gj2Var3.i, hq0Var5, x20Var2, 6);
                        k54.h(x20Var2, w44.c(bk1Var2, 12.0f));
                        k34.k("Call me Boss", gj2Var3.q, hq0Var7, x20Var2, 6);
                        k54.h(x20Var2, w44.c(bk1Var2, 12.0f));
                        k34.k("Read the screen", gj2Var3.n, hq0Var6, x20Var2, 6);
                        k54.h(x20Var2, w44.c(bk1Var2, 12.0f));
                        k34.k("Direct message", gj2Var3.o, hq0Var8, x20Var2, 6);
                    } else {
                        x20Var2.R();
                    }
                    return q43.a;
                }
            }, x20Var), x20Var, 54);
            gj2Var2 = gj2Var;
            h("2. AI CONNECTION", yi4.b(176507049, new bg1(gj2Var2, hq0Var, hq0Var2, fq0Var, fq0Var2, 2), x20Var), x20Var, 54);
            h("3. PERMISSIONS & SHORTCUTS", yi4.b(278984042, new di2(gj2Var2, fq0Var3, fq0Var4, hq0Var9), x20Var), x20Var, 54);
            byte b = 0;
            h("4. HISTORY & DIAGNOSTICS", yi4.b(381461035, new ji2(fq0Var5, b, b), x20Var), x20Var, 54);
            h("5. PRIVACY", yi4.b(483938028, new ji2(fq0Var7, 1, b), x20Var), x20Var, 54);
            k54.h(x20Var, w44.c(bk1Var, 20.0f));
            x20Var.p(true);
            ek1Var2 = bk1Var;
        } else {
            x20Var.R();
            ek1Var2 = ek1Var;
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new vq0(hq0Var, hq0Var2, fq0Var, fq0Var2, hq0Var3, hq0Var4, hq0Var5, hq0Var6, hq0Var7, hq0Var8, fq0Var3, fq0Var4, hq0Var9, fq0Var5, fq0Var6, fq0Var7, ek1Var2, i, i2) { // from class: li2
                public final /* synthetic */ fq0 H;
                public final /* synthetic */ fq0 X;
                public final /* synthetic */ ek1 Y;
                public final /* synthetic */ int Z;
                public final /* synthetic */ hq0 b;
                public final /* synthetic */ hq0 c;
                public final /* synthetic */ fq0 e;
                public final /* synthetic */ fq0 f;
                public final /* synthetic */ hq0 i;
                public final /* synthetic */ hq0 j;
                public final /* synthetic */ hq0 k;
                public final /* synthetic */ hq0 n;
                public final /* synthetic */ hq0 s;
                public final /* synthetic */ hq0 t;
                public final /* synthetic */ fq0 u;
                public final /* synthetic */ fq0 v;
                public final /* synthetic */ hq0 w;
                public final /* synthetic */ fq0 x;

                {
                    this.Z = i2;
                }

                @Override // defpackage.vq0
                public final Object e(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iC = ny3.c(1);
                    int iC2 = ny3.c(this.Z);
                    k34.i(this.a, this.b, this.c, this.e, this.f, this.i, this.j, this.k, this.n, this.s, this.t, this.u, this.v, this.w, this.x, this.H, this.X, this.Y, (x20) obj, iC, iC2);
                    return q43.a;
                }
            };
        }
    }

    public static final void j(boolean z, x20 x20Var, int i) {
        int i2;
        x20Var.X(56883222);
        if ((i & 6) == 0) {
            i2 = (x20Var.g(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i3 = 0;
        if (x20Var.O(i2 & 1, (i2 & 3) != 2)) {
            gr2 gr2VarA = vk2.a(z ? uz.h : uz.d, ie4.e(200, null, 6), "switchTrack", x20Var);
            bk1 bk1Var = bk1.a;
            ek1 ek1VarH = w44.h(bk1Var, 44.0f, 24.0f);
            t82 t82Var = u82.a;
            ek1 ek1VarA = vh4.a(ek1VarH, t82Var);
            long j = ((sz) gr2VarA.getValue()).a;
            vw0 vw0Var = y34.a;
            ek1 ek1VarA2 = kg1.a(ek1VarA, j, vw0Var);
            oh1 oh1VarD = gm.d(z ? xy.j : xy.f, false);
            int iHashCode = Long.hashCode(x20Var.T);
            gw1 gw1VarL = x20Var.l();
            ek1 ek1VarC = gj4.c(x20Var, ek1VarA2);
            o20.p.getClass();
            k30 k30Var = n20.b;
            x20Var.Z();
            if (x20Var.S) {
                x20Var.k(k30Var);
            } else {
                x20Var.j0();
            }
            ie4.c(x20Var, n20.f, oh1VarD);
            ie4.c(x20Var, n20.e, gw1VarL);
            ie4.a(x20Var, Integer.valueOf(iHashCode), n20.g);
            ie4.b(x20Var, n20.h);
            ie4.c(x20Var, n20.d, ek1VarC);
            gm.a(kg1.a(vh4.a(w44.g(c34.e(bk1Var, 3.0f, 0.0f, 2), 18.0f), t82Var), uz.e, vw0Var), x20Var, 0);
            x20Var.p(true);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new ii2(i, i3, z);
        }
    }

    public static final void k(String str, boolean z, hq0 hq0Var, x20 x20Var, int i) {
        x20 x20Var2;
        x20Var.X(1978548702);
        int i2 = i | (x20Var.g(z) ? 32 : 16) | (x20Var.h(hq0Var) ? 256 : 128);
        if (x20Var.O(i2 & 1, (i2 & 147) != 146)) {
            bk1 bk1Var = bk1.a;
            ek1 ek1VarB = w44.b(bk1Var, 1.0f);
            boolean z2 = ((i2 & 896) == 256) | ((i2 & 112) == 32);
            Object objL = x20Var.L();
            int i3 = 3;
            if (z2 || objL == r20.a) {
                objL = new hk(hq0Var, z, i3);
                x20Var.g0(objL);
            }
            ek1 ek1VarE = c34.e(pd3.c(ek1VarB, false, null, null, (fq0) objL, 15), 0.0f, 4.0f, 1);
            e92 e92VarA = d92.a(jg1.b, xy.u, x20Var, 48);
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
            ie4.c(x20Var, n20.f, e92VarA);
            ie4.c(x20Var, n20.e, gw1VarL);
            ie4.a(x20Var, Integer.valueOf(iHashCode), n20.g);
            ie4.b(x20Var, n20.h);
            ie4.c(x20Var, n20.d, ek1VarC);
            dz2.b(str, new d81(1.0f, true), uz.e, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var.j(w33.a)).k, x20Var, 390, 0, 131064);
            x20Var2 = x20Var;
            k54.h(x20Var2, w44.g(bk1Var, 8.0f));
            j(z, x20Var2, (i2 >> 3) & 14);
            x20Var2.p(true);
        } else {
            x20Var2 = x20Var;
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new fi2(str, z, hq0Var, i, 0);
        }
    }
}
