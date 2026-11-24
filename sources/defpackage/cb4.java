package defpackage;

import com.ibm.icu.impl.coll.CollationFastLatin;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class cb4 {
    public static final void a(l5 l5Var, x20 x20Var, int i) {
        String str;
        boolean z;
        String string;
        boolean z2;
        l5 l5Var2;
        x20 x20Var2 = x20Var;
        x20Var2.X(792058658);
        int i2 = i | (x20Var2.h(l5Var) ? 4 : 2);
        if (x20Var2.O(i2 & 1, (i2 & 3) != 2)) {
            e33 e33Var = l5Var.b;
            String str2 = l5Var.a;
            rn2.a.getClass();
            long j = uz.a(el1.q(e33Var)).c;
            bk1 bk1Var = bk1.a;
            ek1 ek1VarC = c34.c(of4.a(kg1.a(w44.b(bk1Var, 1.0f), uz.c, u82.a(12.0f)), uz.d, u82.a(12.0f)), 12.0f);
            oh1 oh1VarD = gm.d(xy.b, false);
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
            j00 j00VarA = h00.a(new eg(6.0f, new ag(0)), xy.w, x20Var2, 6);
            int iHashCode2 = Long.hashCode(x20Var2.T);
            gw1 gw1VarL2 = x20Var2.l();
            ek1 ek1VarC3 = gj4.c(x20Var2, bk1Var);
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            ie4.c(x20Var2, jdVar, j00VarA);
            ie4.c(x20Var2, jdVar2, gw1VarL2);
            cq.s(iHashCode2, x20Var2, jdVar3, x20Var2, j7Var);
            ie4.c(x20Var2, jdVar4, ek1VarC3);
            e92 e92VarA = d92.a(jg1.b, xy.u, x20Var2, 48);
            int iHashCode3 = Long.hashCode(x20Var2.T);
            gw1 gw1VarL3 = x20Var2.l();
            ek1 ek1VarC4 = gj4.c(x20Var2, bk1Var);
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            ie4.c(x20Var2, jdVar, e92VarA);
            ie4.c(x20Var2, jdVar2, gw1VarL3);
            cq.s(iHashCode3, x20Var2, jdVar3, x20Var2, j7Var);
            ie4.c(x20Var2, jdVar4, ek1VarC4);
            gm.a(kg1.a(w44.g(bk1Var, 7.0f), j, u82.a), x20Var2, 0);
            k54.h(x20Var2, w44.g(bk1Var, 8.0f));
            f5 f5Var = l5Var.d;
            if (f5Var == null || (str = f5Var.a) == null) {
                str = "Action";
            }
            sr2 sr2Var = w33.a;
            yz2 yz2Var = ((v33) x20Var2.j(sr2Var)).o;
            long j2 = uz.h;
            bu0 bu0Var = ev2.c;
            long j3 = j;
            dz2.b(str, null, j2, 0L, null, bu0Var, 0L, null, 0L, 0, false, 0, 0, yz2Var, x20Var, CollationFastLatin.LATIN_LIMIT, 0, 130938);
            k54.h(x20Var, new d81(1.0f, true));
            dz2.b(l5Var.b.name(), null, j3, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var.j(sr2Var)).o, x20Var, 0, 0, 131066);
            x20Var2 = x20Var;
            x20Var2.p(true);
            if (cs2.A(str2)) {
                z = false;
                x20Var2.W(668539548);
            } else {
                x20Var2.W(674798789);
                dz2.b("Request: “" + str2 + "”", null, uz.e, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(sr2Var)).o, x20Var, CollationFastLatin.LATIN_LIMIT, 0, 131066);
                x20Var2 = x20Var;
                z = false;
            }
            x20Var2.p(z);
            e73 e73Var = l5Var.h;
            if (e73Var == null) {
                x20Var2.W(675046137);
                x20Var2.p(z);
                z2 = z;
                l5Var2 = l5Var;
            } else {
                x20Var2.W(675046138);
                boolean z3 = e73Var instanceof d73;
                if (z3) {
                    d73 d73Var = (d73) e73Var;
                    string = cq.l("✓ ", d73Var.a, " — saw ", d73Var.b);
                } else if (e73Var instanceof c73) {
                    string = "? couldn't check: ".concat(((c73) e73Var).a);
                } else {
                    if (!(e73Var instanceof b73)) {
                        dk0.l();
                        return;
                    }
                    b73 b73Var = (b73) e73Var;
                    String str3 = b73Var.a;
                    String str4 = b73Var.b;
                    String str5 = b73Var.c;
                    StringBuilder sbQ = cq.q("✕ ", str3, " — expected ", str4, ", saw ");
                    sbQ.append(str5);
                    string = sbQ.toString();
                }
                yz2 yz2Var2 = ((v33) x20Var2.j(r26)).o;
                if (!z3) {
                    if (e73Var instanceof c73) {
                        j3 = uz.g;
                    } else if (!(e73Var instanceof b73)) {
                        dk0.l();
                        return;
                    }
                }
                z2 = z;
                dz2.b(string, null, j3, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, yz2Var2, x20Var, 0, 0, 131066);
                x20Var2 = x20Var;
                x20Var2.p(z2);
                l5Var2 = l5Var;
            }
            String str6 = l5Var2.l;
            if (str6 == null || cs2.A(str6)) {
                str6 = null;
            }
            if (str6 == null) {
                x20Var2.W(675359826);
            } else {
                x20Var2.W(675359827);
                dz2.b(str6, null, uz.g, 0L, null, bu0Var, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(sr2Var)).o, x20Var, CollationFastLatin.LATIN_LIMIT, 0, 130938);
                x20Var2 = x20Var;
            }
            x20Var2.p(z2);
            x20Var2.p(true);
            x20Var2.p(true);
        } else {
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new u13(l5Var, i, 2);
        }
    }

    public static final void b(final t82 t82Var, long j, long j2, ek1 ek1Var, w10 w10Var, x20 x20Var, final int i) {
        final long j3;
        long j4;
        ek1 ek1Var2;
        final w10 w10Var2;
        x20Var.X(-1125906507);
        int i2 = i | (x20Var.f(t82Var) ? 4 : 2);
        if (x20Var.O(i2 & 1, (i2 & 9363) != 9362)) {
            j3 = j;
            ek1Var2 = ek1Var;
            j4 = j2;
            ek1 ek1VarD = c34.d(of4.a(kg1.a(ek1Var2, j3, t82Var), j4, t82Var), 14.0f, 10.0f);
            oh1 oh1VarD = gm.d(xy.b, false);
            int iHashCode = Long.hashCode(x20Var.T);
            gw1 gw1VarL = x20Var.l();
            ek1 ek1VarC = gj4.c(x20Var, ek1VarD);
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
            w10Var2 = w10Var;
            w10Var2.e(x20Var, 6);
            x20Var.p(true);
        } else {
            j3 = j;
            j4 = j2;
            ek1Var2 = ek1Var;
            w10Var2 = w10Var;
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            final ek1 ek1Var3 = ek1Var2;
            final long j5 = j4;
            a42VarR.d = new vq0(j3, j5, ek1Var3, w10Var2, i) { // from class: v13
                public final /* synthetic */ long b;
                public final /* synthetic */ long c;
                public final /* synthetic */ ek1 e;
                public final /* synthetic */ w10 f;

                @Override // defpackage.vq0
                public final Object e(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iC = ny3.c(28081);
                    cb4.b(this.a, this.b, this.c, this.e, this.f, (x20) obj, iC);
                    return q43.a;
                }
            };
        }
    }

    public static final void c(ek1 ek1Var, x20 x20Var, int i) {
        int i2;
        x20 x20Var2 = x20Var;
        x20Var2.X(-1568584552);
        if ((i & 6) == 0) {
            i2 = i | (x20Var2.f(ek1Var) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (x20Var2.O(i2 & 1, (i2 & 3) != 2)) {
            ek1 ek1VarC = ek1Var.c(w44.b);
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
            ie4.c(x20Var2, n20.f, oh1VarD);
            ie4.c(x20Var2, n20.e, gw1VarL);
            ie4.a(x20Var2, Integer.valueOf(iHashCode), n20.g);
            ie4.b(x20Var2, n20.h);
            ie4.c(x20Var2, n20.d, ek1VarC2);
            dz2.b("No items in history yet.\nStart a conversation or trigger an action.", null, uz.g, 0L, null, null, 0L, new vw2(3), 0L, 0, false, 0, 0, ((v33) x20Var2.j(w33.a)).k, x20Var, 390, 0, 130042);
            x20Var2 = x20Var;
            x20Var2.p(true);
        } else {
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new v8(ek1Var, i, 2, (byte) 0);
        }
    }

    public static final void d(l5 l5Var, x20 x20Var, int i) {
        l5 l5Var2;
        jd jdVar;
        jd jdVar2;
        jd jdVar3;
        boolean z;
        float f;
        j7 j7Var;
        kl klVar = xy.t;
        x20Var.X(1773282745);
        int i2 = i | (x20Var.h(l5Var) ? 4 : 2);
        int i3 = 1;
        if (x20Var.O(i2 & 1, (i2 & 3) != 2)) {
            e33 e33Var = l5Var.b;
            rn2.a.getClass();
            long j = uz.a(el1.q(e33Var)).c;
            bk1 bk1Var = bk1.a;
            ek1 ek1VarB = w44.b(bk1Var, 1.0f);
            j00 j00VarA = h00.a(new eg(6.0f, new ag(0)), xy.w, x20Var, 6);
            int iHashCode = Long.hashCode(x20Var.T);
            gw1 gw1VarL = x20Var.l();
            ek1 ek1VarC = gj4.c(x20Var, ek1VarB);
            o20.p.getClass();
            k30 k30Var = n20.b;
            x20Var.Z();
            if (x20Var.S) {
                x20Var.k(k30Var);
            } else {
                x20Var.j0();
            }
            jd jdVar4 = n20.f;
            ie4.c(x20Var, jdVar4, j00VarA);
            jd jdVar5 = n20.e;
            ie4.c(x20Var, jdVar5, gw1VarL);
            Integer numValueOf = Integer.valueOf(iHashCode);
            jd jdVar6 = n20.g;
            ie4.a(x20Var, numValueOf, jdVar6);
            j7 j7Var2 = n20.h;
            ie4.b(x20Var, j7Var2);
            jd jdVar7 = n20.d;
            ie4.c(x20Var, jdVar7, ek1VarC);
            if (cs2.A(l5Var.a)) {
                jdVar = jdVar5;
                jdVar2 = jdVar6;
                jdVar3 = jdVar7;
                z = false;
                f = 1.0f;
                j7Var = j7Var2;
                x20Var.W(955304511);
            } else {
                x20Var.W(958550707);
                ek1 ek1VarB2 = w44.b(bk1Var, 1.0f);
                e92 e92VarA = d92.a(jg1.c, klVar, x20Var, 6);
                int iHashCode2 = Long.hashCode(x20Var.T);
                gw1 gw1VarL2 = x20Var.l();
                ek1 ek1VarC2 = gj4.c(x20Var, ek1VarB2);
                x20Var.Z();
                if (x20Var.S) {
                    x20Var.k(k30Var);
                } else {
                    x20Var.j0();
                }
                ie4.c(x20Var, jdVar4, e92VarA);
                ie4.c(x20Var, jdVar5, gw1VarL2);
                cq.s(iHashCode2, x20Var, jdVar6, x20Var, j7Var2);
                ie4.c(x20Var, jdVar7, ek1VarC2);
                t82 t82Var = u82.a;
                t82 t82Var2 = new t82(new ee0(16.0f), new ee0(16.0f), new ee0(4.0f), new ee0(16.0f));
                long j2 = uz.h;
                jdVar3 = jdVar7;
                jdVar2 = jdVar6;
                jdVar = jdVar5;
                f = 1.0f;
                j7Var = j7Var2;
                b(t82Var2, sz.b(0.16f, j2), sz.b(0.34f, j2), w44.b(bk1Var, 0.88f), yi4.b(364733799, new u13(l5Var), x20Var), x20Var, 28080);
                x20Var.p(true);
                z = false;
            }
            x20Var.p(z);
            ek1 ek1VarB3 = w44.b(bk1Var, f);
            e92 e92VarA2 = d92.a(jg1.b, klVar, x20Var, 6);
            int iHashCode3 = Long.hashCode(x20Var.T);
            gw1 gw1VarL3 = x20Var.l();
            ek1 ek1VarC3 = gj4.c(x20Var, ek1VarB3);
            x20Var.Z();
            if (x20Var.S) {
                x20Var.k(k30Var);
            } else {
                x20Var.j0();
            }
            ie4.c(x20Var, jdVar4, e92VarA2);
            ie4.c(x20Var, jdVar, gw1VarL3);
            cq.s(iHashCode3, x20Var, jdVar2, x20Var, j7Var);
            ie4.c(x20Var, jdVar3, ek1VarC3);
            t82 t82Var3 = u82.a;
            i3 = 1;
            l5Var2 = l5Var;
            b(new t82(new ee0(16.0f), new ee0(16.0f), new ee0(16.0f), new ee0(4.0f)), uz.c, uz.d, w44.b(bk1Var, 0.88f), yi4.b(-1068439134, new t8(i3, j, l5Var2), x20Var), x20Var, 28080);
            x20Var.p(true);
            x20Var.p(true);
        } else {
            l5Var2 = l5Var;
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new u13(l5Var2, i, i3);
        }
    }

    public static final void e(final List list, final boolean z, final ek1 ek1Var, x20 x20Var, final int i) {
        a42 a42VarR;
        vq0 vq0Var;
        list.getClass();
        x20Var.X(-69365797);
        int i2 = i | (x20Var.h(list) ? 4 : 2) | (x20Var.g(z) ? 32 : 16) | (x20Var.f(ek1Var) ? 256 : 128);
        if (x20Var.O(i2 & 1, (i2 & 147) != 146)) {
            if (list.isEmpty()) {
                x20Var.W(-597027601);
                c(ek1Var, x20Var, (i2 >> 6) & 14);
                x20Var.p(false);
                a42VarR = x20Var.r();
                if (a42VarR == null) {
                    return;
                }
                final int i3 = 0;
                vq0Var = new vq0(list, z, ek1Var, i, i3) { // from class: t13
                    public final /* synthetic */ int a;
                    public final /* synthetic */ List b;
                    public final /* synthetic */ boolean c;
                    public final /* synthetic */ ek1 e;

                    {
                        this.a = i3;
                    }

                    @Override // defpackage.vq0
                    public final Object e(Object obj, Object obj2) {
                        int i4 = this.a;
                        q43 q43Var = q43.a;
                        ek1 ek1Var2 = this.e;
                        boolean z2 = this.c;
                        List list2 = this.b;
                        x20 x20Var2 = (x20) obj;
                        ((Integer) obj2).getClass();
                        switch (i4) {
                            case 0:
                                cb4.e(list2, z2, ek1Var2, x20Var2, ny3.c(1));
                                break;
                            default:
                                cb4.e(list2, z2, ek1Var2, x20Var2, ny3.c(1));
                                break;
                        }
                        return q43Var;
                    }
                };
            } else {
                x20Var.W(-598936953);
                x20Var.p(false);
                ea1 ea1VarA = ga1.a(x20Var);
                Integer numValueOf = Integer.valueOf(list.size());
                boolean zH = x20Var.h(list) | x20Var.f(ea1VarA);
                Object objL = x20Var.L();
                Object obj = r20.a;
                if (zH || objL == obj) {
                    objL = new sc2(list, ea1VarA, (x50) null, 13);
                    x20Var.g0(objL);
                }
                bz3.c(x20Var, (vq0) objL, numValueOf);
                ek1 ek1VarC = ek1Var.c(w44.b);
                eg egVar = new eg(12.0f, new ag(0));
                qt1 qt1VarA = c34.a(1);
                boolean zH2 = x20Var.h(list) | ((i2 & 112) == 32);
                Object objL2 = x20Var.L();
                if (zH2 || objL2 == obj) {
                    objL2 = new wn2(list, z);
                    x20Var.g0(objL2);
                }
                xp4.a(ek1VarC, ea1VarA, qt1VarA, egVar, null, null, false, null, (hq0) objL2, x20Var, 24960);
            }
            a42VarR.d = vq0Var;
        }
        x20Var.R();
        a42VarR = x20Var.r();
        if (a42VarR != null) {
            final int i4 = 1;
            vq0Var = new vq0(list, z, ek1Var, i, i4) { // from class: t13
                public final /* synthetic */ int a;
                public final /* synthetic */ List b;
                public final /* synthetic */ boolean c;
                public final /* synthetic */ ek1 e;

                {
                    this.a = i4;
                }

                @Override // defpackage.vq0
                public final Object e(Object obj2, Object obj3) {
                    int i5 = this.a;
                    q43 q43Var = q43.a;
                    ek1 ek1Var2 = this.e;
                    boolean z2 = this.c;
                    List list2 = this.b;
                    x20 x20Var2 = (x20) obj2;
                    ((Integer) obj3).getClass();
                    switch (i5) {
                        case 0:
                            cb4.e(list2, z2, ek1Var2, x20Var2, ny3.c(1));
                            break;
                        default:
                            cb4.e(list2, z2, ek1Var2, x20Var2, ny3.c(1));
                            break;
                    }
                    return q43Var;
                }
            };
            a42VarR.d = vq0Var;
        }
    }

    public static String f(int i) {
        ArrayList arrayList = new ArrayList();
        if ((i & 4) != 0) {
            arrayList.add("IMAGE_CAPTURE");
        }
        if ((i & 1) != 0) {
            arrayList.add("PREVIEW");
        }
        if ((i & 2) != 0) {
            arrayList.add("VIDEO_CAPTURE");
        }
        return String.join("|", arrayList);
    }
}
