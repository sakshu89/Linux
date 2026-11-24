package defpackage;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.Normalizer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ds4 {
    public static final void a(List list, final long j, final hq0 hq0Var, x20 x20Var, int i) {
        x20Var.X(-449717501);
        int i2 = i | (x20Var.h(list) ? 4 : 2) | (x20Var.e(j) ? 32 : 16) | (x20Var.h(hq0Var) ? 256 : 128);
        if (x20Var.O(i2 & 1, (i2 & 147) != 146)) {
            boolean zF = x20Var.f(list);
            Object objL = x20Var.L();
            if (zF || objL == r20.a) {
                objL = new hu1(0);
                x20Var.g0(objL);
            }
            final hu1 hu1Var = (hu1) objL;
            final int size = (list.size() + 3) / 4;
            final int iC = ky3.c(hu1Var.g(), 0, Math.max(0, size - 1));
            final List listL = mz.L(mz.u(iC * 4, list), 4);
            qf4.a(w44.b(bk1.a, 1.0f), null, yi4.b(18202349, new wq0() { // from class: ss1
                /* JADX WARN: Multi-variable type inference failed */
                @Override // defpackage.wq0
                public final Object c(Object obj, Object obj2, Object obj3) throws Throwable {
                    boolean z;
                    int i3;
                    int i4;
                    boolean z2;
                    boolean z3;
                    x20 x20Var2;
                    Object obj4;
                    boolean z4;
                    int i5;
                    x20 x20Var3;
                    x20 x20Var4;
                    Object obj5;
                    final int i6;
                    Object obj6;
                    boolean z5;
                    ArrayList arrayList;
                    lm lmVar = (lm) obj;
                    x20 x20Var5 = (x20) obj2;
                    int iIntValue = ((Integer) obj3).intValue();
                    lmVar.getClass();
                    int i7 = 2;
                    if ((iIntValue & 6) == 0) {
                        iIntValue |= x20Var5.f(lmVar) ? 4 : 2;
                    }
                    int i8 = 0;
                    if (x20Var5.O(iIntValue & 1, (iIntValue & 19) != 18)) {
                        jc0 jc0Var = lmVar.a;
                        long j2 = lmVar.b;
                        int iA = de0.a(q40.d(j2) ? jc0Var.r0(q40.h(j2)) : Float.POSITIVE_INFINITY, 360.0f);
                        List list2 = listL;
                        if (iA < 0) {
                            z = false;
                        } else {
                            if (!list2.isEmpty()) {
                                Iterator it = list2.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (((zx) it.next()).a.length() > 22) {
                                            z = false;
                                        }
                                    }
                                }
                            }
                            z = true;
                        }
                        bk1 bk1Var = bk1.a;
                        ek1 ek1VarB = w44.b(bk1Var, 1.0f);
                        j00 j00VarA = h00.a(new eg(8.0f, new ag(0)), xy.w, x20Var5, 6);
                        int iHashCode = Long.hashCode(x20Var5.T);
                        gw1 gw1VarL = x20Var5.l();
                        ek1 ek1VarC = gj4.c(x20Var5, ek1VarB);
                        o20.p.getClass();
                        fq0 fq0Var = n20.b;
                        x20Var5.Z();
                        if (x20Var5.S) {
                            x20Var5.k(fq0Var);
                        } else {
                            x20Var5.j0();
                        }
                        ie4.c(x20Var5, n20.f, j00VarA);
                        ie4.c(x20Var5, n20.e, gw1VarL);
                        ie4.a(x20Var5, Integer.valueOf(iHashCode), n20.g);
                        ie4.b(x20Var5, n20.h);
                        ie4.c(x20Var5, n20.d, ek1VarC);
                        Throwable th = null;
                        int i9 = iC;
                        final long j3 = j;
                        int i10 = i9;
                        hq0 hq0Var2 = hq0Var;
                        if (z) {
                            x20Var5.W(994113072);
                            c44.a(2, 2);
                            if (list2 instanceof RandomAccess) {
                                int size2 = list2.size();
                                z5 = true;
                                arrayList = new ArrayList((size2 / 2) + (size2 % 2 == 0 ? 0 : 1));
                                int i11 = 0;
                                while (i11 >= 0 && i11 < size2) {
                                    int i12 = size2 - i11;
                                    if (i7 <= i12) {
                                        i12 = i7;
                                    }
                                    ArrayList arrayList2 = new ArrayList(i12);
                                    while (i8 < i12) {
                                        arrayList2.add(list2.get(i8 + i11));
                                        i8++;
                                    }
                                    arrayList.add(arrayList2);
                                    i11 += 2;
                                    i7 = 2;
                                    i8 = 0;
                                }
                            } else {
                                z5 = true;
                                arrayList = new ArrayList();
                                Iterator it2 = list2.iterator();
                                it2.getClass();
                                Iterator itA = !it2.hasNext() ? hi0.a : ah2.a(new ml2(it2, null));
                                while (itA.hasNext()) {
                                    arrayList.add((List) itA.next());
                                }
                            }
                            int size3 = arrayList.size();
                            int i13 = 0;
                            int i14 = 0;
                            while (i13 < size3) {
                                Object obj7 = arrayList.get(i13);
                                int i15 = i13 + 1;
                                int i16 = i14 + 1;
                                if (i14 < 0) {
                                    Throwable th2 = th;
                                    nz.n();
                                    throw th2;
                                }
                                List list3 = (List) obj7;
                                ek1 ek1VarB2 = w44.b(bk1Var, 1.0f);
                                int i17 = size3;
                                e92 e92VarA = d92.a(new eg(8.0f, new ag(0)), xy.t, x20Var5, 6);
                                int iHashCode2 = Long.hashCode(x20Var5.T);
                                gw1 gw1VarL2 = x20Var5.l();
                                ek1 ek1VarC2 = gj4.c(x20Var5, ek1VarB2);
                                o20.p.getClass();
                                fq0 fq0Var2 = n20.b;
                                x20Var5.Z();
                                if (x20Var5.S) {
                                    x20Var5.k(fq0Var2);
                                } else {
                                    x20Var5.j0();
                                }
                                ie4.c(x20Var5, n20.f, e92VarA);
                                ie4.c(x20Var5, n20.e, gw1VarL2);
                                ie4.a(x20Var5, Integer.valueOf(iHashCode2), n20.g);
                                ie4.b(x20Var5, n20.h);
                                ie4.c(x20Var5, n20.d, ek1VarC2);
                                x20Var5.W(-1719103791);
                                int i18 = 0;
                                for (Object obj8 : list3) {
                                    int i19 = i18 + 1;
                                    if (i18 < 0) {
                                        nz.n();
                                        throw null;
                                    }
                                    ds4.c(String.valueOf((i14 * 2) + (i10 * 4) + i18 + 1), (zx) obj8, j3, hq0Var2, f92.a(), x20Var5, 0);
                                    i10 = i10;
                                    i18 = i19;
                                    i16 = i16;
                                }
                                int i20 = i16;
                                int i21 = i10;
                                x20Var5.p(false);
                                if (list3.size() < 2) {
                                    x20Var5.W(-1752081200);
                                    k54.h(x20Var5, f92.a());
                                } else {
                                    x20Var5.W(-1760627869);
                                }
                                x20Var5.p(false);
                                boolean z6 = z5;
                                x20Var5.p(z6);
                                i14 = i20;
                                z5 = z6;
                                i13 = i15;
                                i10 = i21;
                                th = null;
                                size3 = i17;
                            }
                            i3 = i10;
                            x20Var5.p(false);
                            i4 = 1;
                        } else {
                            i3 = i10;
                            x20Var5.W(995112202);
                            int i22 = 0;
                            for (Object obj9 : list2) {
                                int i23 = i22 + 1;
                                if (i22 < 0) {
                                    nz.n();
                                    throw null;
                                }
                                ds4.c(String.valueOf((i3 * 4) + i22 + 1), (zx) obj9, j3, hq0Var2, w44.b(bk1Var, 1.0f), x20Var5, 24576);
                                i22 = i23;
                            }
                            i4 = 1;
                            x20Var5.p(false);
                        }
                        int i24 = size;
                        if (i24 > i4) {
                            x20Var5.W(995615301);
                            ek1 ek1VarB3 = w44.b(bk1Var, 1.0f);
                            e92 e92VarA2 = d92.a(jg1.f, xy.u, x20Var5, 54);
                            int iHashCode3 = Long.hashCode(x20Var5.T);
                            gw1 gw1VarL3 = x20Var5.l();
                            ek1 ek1VarC3 = gj4.c(x20Var5, ek1VarB3);
                            o20.p.getClass();
                            fq0 fq0Var3 = n20.b;
                            x20Var5.Z();
                            if (x20Var5.S) {
                                x20Var5.k(fq0Var3);
                            } else {
                                x20Var5.j0();
                            }
                            ie4.c(x20Var5, n20.f, e92VarA2);
                            ie4.c(x20Var5, n20.e, gw1VarL3);
                            ie4.a(x20Var5, Integer.valueOf(iHashCode3), n20.g);
                            ie4.b(x20Var5, n20.h);
                            ie4.c(x20Var5, n20.d, ek1VarC3);
                            final hu1 hu1Var2 = hu1Var;
                            Object obj10 = r20.a;
                            if (i3 > 0) {
                                x20Var5.W(-1431940806);
                                boolean zF2 = x20Var5.f(hu1Var2);
                                Object objL2 = x20Var5.L();
                                if (zF2 || objL2 == obj10) {
                                    i6 = 1;
                                    Object obj11 = new fq0() { // from class: ns1
                                        @Override // defpackage.fq0
                                        public final Object a() {
                                            int i25 = i6;
                                            q43 q43Var = q43.a;
                                            hu1 hu1Var3 = hu1Var2;
                                            switch (i25) {
                                                case 0:
                                                    hu1Var3.h(hu1Var3.g() + 1);
                                                    break;
                                                default:
                                                    hu1Var3.h(hu1Var3.g() - 1);
                                                    break;
                                            }
                                            return q43Var;
                                        }
                                    };
                                    x20Var5.g0(obj11);
                                    obj6 = obj11;
                                } else {
                                    i6 = 1;
                                    obj6 = objL2;
                                }
                                final int i25 = 0;
                                i5 = i6;
                                obj4 = obj10;
                                dg4.b((fq0) obj6, null, false, null, null, null, null, yi4.b(-1990318188, new wq0() { // from class: ms1
                                    @Override // defpackage.wq0
                                    public final Object c(Object obj12, Object obj13, Object obj14) {
                                        int i26 = i25;
                                        q43 q43Var = q43.a;
                                        switch (i26) {
                                            case 0:
                                                x20 x20Var6 = (x20) obj13;
                                                int iIntValue2 = ((Integer) obj14).intValue();
                                                ((f92) obj12).getClass();
                                                if (!x20Var6.O(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                                    x20Var6.R();
                                                } else {
                                                    dz2.b("< Prev", null, j3, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var6.j(w33.a)).n, x20Var6, 6, 0, 131066);
                                                }
                                                break;
                                            default:
                                                x20 x20Var7 = (x20) obj13;
                                                int iIntValue3 = ((Integer) obj14).intValue();
                                                ((f92) obj12).getClass();
                                                if (!x20Var7.O(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                    x20Var7.R();
                                                } else {
                                                    dz2.b("Next >", null, j3, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var7.j(w33.a)).n, x20Var7, 6, 0, 131066);
                                                }
                                                break;
                                        }
                                        return q43Var;
                                    }
                                }, x20Var5), x20Var5, 805306368, 510);
                                x20 x20Var6 = x20Var5;
                                z4 = false;
                                x20Var6.p(false);
                                x20Var3 = x20Var6;
                            } else {
                                obj4 = obj10;
                                z4 = false;
                                i5 = 1;
                                x20Var5.W(-1431710507);
                                k54.h(x20Var5, w44.i());
                                x20Var5.p(false);
                                x20Var3 = x20Var5;
                            }
                            x20 x20Var7 = x20Var3;
                            int i26 = i3;
                            boolean z7 = i5;
                            dz2.b(ky0.i("Page ", i3 + 1, i24, " of "), null, uz.f, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var3.j(w33.a)).o, x20Var7, CollationFastLatin.LATIN_LIMIT, 0, 131066);
                            x20 x20Var8 = x20Var7;
                            if (i26 < i24 - 1) {
                                x20Var8.W(-1431346598);
                                boolean zF3 = x20Var8.f(hu1Var2);
                                Object objL3 = x20Var8.L();
                                if (zF3 || objL3 == obj4) {
                                    z3 = false;
                                    final boolean z8 = false ? 1 : 0;
                                    Object obj12 = new fq0() { // from class: ns1
                                        @Override // defpackage.fq0
                                        public final Object a() {
                                            int i27 = z8;
                                            q43 q43Var = q43.a;
                                            hu1 hu1Var3 = hu1Var2;
                                            switch (i27) {
                                                case 0:
                                                    hu1Var3.h(hu1Var3.g() + 1);
                                                    break;
                                                default:
                                                    hu1Var3.h(hu1Var3.g() - 1);
                                                    break;
                                            }
                                            return q43Var;
                                        }
                                    };
                                    x20Var8.g0(obj12);
                                    obj5 = obj12;
                                } else {
                                    z3 = false;
                                    obj5 = objL3;
                                }
                                final int i27 = z7 ? 1 : 0;
                                dg4.b((fq0) obj5, null, false, null, null, null, null, yi4.b(-944034563, new wq0() { // from class: ms1
                                    @Override // defpackage.wq0
                                    public final Object c(Object obj13, Object obj14, Object obj15) {
                                        int i28 = i27;
                                        q43 q43Var = q43.a;
                                        switch (i28) {
                                            case 0:
                                                x20 x20Var9 = (x20) obj14;
                                                int iIntValue2 = ((Integer) obj15).intValue();
                                                ((f92) obj13).getClass();
                                                if (!x20Var9.O(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                                                    x20Var9.R();
                                                } else {
                                                    dz2.b("< Prev", null, j3, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var9.j(w33.a)).n, x20Var9, 6, 0, 131066);
                                                }
                                                break;
                                            default:
                                                x20 x20Var10 = (x20) obj14;
                                                int iIntValue3 = ((Integer) obj15).intValue();
                                                ((f92) obj13).getClass();
                                                if (!x20Var10.O(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                                                    x20Var10.R();
                                                } else {
                                                    dz2.b("Next >", null, j3, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var10.j(w33.a)).n, x20Var10, 6, 0, 131066);
                                                }
                                                break;
                                        }
                                        return q43Var;
                                    }
                                }, x20Var8), x20Var8, 805306368, 510);
                                x20 x20Var9 = x20Var8;
                                x20Var9.p(z3);
                                x20Var4 = x20Var9;
                            } else {
                                z3 = false;
                                x20Var8.W(-1431116299);
                                k54.h(x20Var8, w44.i());
                                x20Var8.p(false);
                                x20Var4 = x20Var8;
                            }
                            x20Var4.p(z7);
                            z2 = z7;
                            x20Var2 = x20Var4;
                        } else {
                            z2 = i4;
                            z3 = false;
                            x20Var5.W(986412331);
                            x20Var2 = x20Var5;
                        }
                        x20Var2.p(z3);
                        x20Var2.p(z2);
                    } else {
                        x20Var5.R();
                    }
                    return q43.a;
                }
            }, x20Var), x20Var, 3078);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new u8(list, j, hq0Var, i, 2);
        }
    }

    public static final void b(long j, fq0 fq0Var, fq0 fq0Var2, x20 x20Var, int i) {
        x20 x20Var2 = x20Var;
        x20Var2.X(-437409467);
        int i2 = i | (x20Var2.e(j) ? 4 : 2) | (x20Var2.h(fq0Var) ? 32 : 16) | (x20Var2.h(fq0Var2) ? 256 : 128);
        if (x20Var2.O(i2 & 1, (i2 & 147) != 146)) {
            ek1 ek1VarB = w44.b(bk1.a, 1.0f);
            e92 e92VarA = d92.a(new eg(12.0f, new ag(0)), xy.t, x20Var2, 6);
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
            ie4.c(x20Var2, n20.f, e92VarA);
            ie4.c(x20Var2, n20.e, gw1VarL);
            ie4.a(x20Var2, Integer.valueOf(iHashCode), n20.g);
            ie4.b(x20Var2, n20.h);
            ie4.c(x20Var2, n20.d, ek1VarC);
            ek1 ek1VarA = f92.a();
            qt1 qt1Var = bo.a;
            dg4.a(fq0Var, ek1VarA, false, u82.a(14.0f), bo.a(j, uz.a, x20Var2), null, null, null, iy3.a, x20Var, ((i2 >> 3) & 14) | 805306368, 484);
            x20Var2 = x20Var;
            dg4.b(fq0Var2, f92.a(), false, u82.a(14.0f), bo.c(0L, uz.f, x20Var, 13), null, null, iy3.b, x20Var2, ((i2 >> 6) & 14) | 805306368, 484);
            x20Var2.p(true);
        } else {
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new u8(j, fq0Var, fq0Var2, i, 1);
        }
    }

    public static final void c(final String str, final zx zxVar, final long j, final hq0 hq0Var, final ek1 ek1Var, x20 x20Var, final int i) {
        x20Var.X(-918976681);
        int i2 = (x20Var.f(str) ? 4 : 2) | i | (x20Var.h(zxVar) ? 32 : 16) | (x20Var.e(j) ? 256 : 128) | (x20Var.h(hq0Var) ? 2048 : 1024);
        if ((i & 24576) == 0) {
            i2 |= x20Var.f(ek1Var) ? 16384 : 8192;
        }
        int i3 = i2;
        if (x20Var.O(i3 & 1, (i3 & 9363) != 9362)) {
            ek1 ek1VarA = w44.a(ek1Var, Float.NaN, 52.0f);
            qt1 qt1Var = bo.a;
            ao aoVarC = bo.c(uz.c, uz.e, x20Var, 12);
            yl ylVar = new yl(1.5f, new cn2(sz.b(0.6f, j)));
            t82 t82VarA = u82.a(12.0f);
            qt1 qt1Var2 = new qt1(12.0f, 10.0f, 12.0f, 10.0f);
            boolean zH = x20Var.h(zxVar) | ((i3 & 7168) == 2048);
            Object objL = x20Var.L();
            if (zH || objL == r20.a) {
                objL = new zb(11, hq0Var, zxVar);
                x20Var.g0(objL);
            }
            dg4.b((fq0) objL, ek1VarA, false, t82VarA, aoVarC, ylVar, qt1Var2, yi4.b(-652341467, new wq0() { // from class: os1
                @Override // defpackage.wq0
                public final Object c(Object obj, Object obj2, Object obj3) {
                    x20 x20Var2 = (x20) obj2;
                    int iIntValue = ((Integer) obj3).intValue();
                    ((f92) obj).getClass();
                    if (x20Var2.O(iIntValue & 1, (iIntValue & 17) != 16)) {
                        bk1 bk1Var = bk1.a;
                        ek1 ek1VarB = w44.b(bk1Var, 1.0f);
                        e92 e92VarA = d92.a(jg1.b, xy.u, x20Var2, 54);
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
                        t82 t82VarA2 = u82.a(6.0f);
                        long j2 = j;
                        long jB = sz.b(0.25f, j2);
                        ek1 ek1VarF = c34.f(bk1Var, 0.0f, 10.0f, 0.0f, 11);
                        w10 w10VarB = yi4.b(571111716, new ls1(j2, str), x20Var2);
                        m30 m30Var = wt2.a;
                        sr2 sr2Var = a00.a;
                        x20Var2.W(89374938);
                        yz yzVar = (yz) x20Var2.j(a00.a);
                        long j3 = yzVar.a;
                        long j4 = yzVar.U;
                        long j5 = yzVar.Q;
                        long j6 = yzVar.M;
                        long j7 = yzVar.q;
                        if (sz.c(jB, j3)) {
                            j7 = yzVar.b;
                        } else if (sz.c(jB, yzVar.f)) {
                            j7 = yzVar.g;
                        } else if (sz.c(jB, yzVar.j)) {
                            j7 = yzVar.k;
                        } else if (sz.c(jB, yzVar.n)) {
                            j7 = yzVar.o;
                        } else if (sz.c(jB, yzVar.w)) {
                            j7 = yzVar.x;
                        } else if (sz.c(jB, yzVar.c)) {
                            j7 = yzVar.d;
                        } else if (sz.c(jB, yzVar.h)) {
                            j7 = yzVar.i;
                        } else if (sz.c(jB, yzVar.l)) {
                            j7 = yzVar.m;
                        } else if (sz.c(jB, yzVar.y)) {
                            j7 = yzVar.z;
                        } else if (sz.c(jB, yzVar.u)) {
                            j7 = yzVar.v;
                        } else if (!sz.c(jB, yzVar.p)) {
                            if (sz.c(jB, yzVar.r)) {
                                j7 = yzVar.s;
                            } else if (!sz.c(jB, yzVar.D) && !sz.c(jB, yzVar.F) && !sz.c(jB, yzVar.G) && !sz.c(jB, yzVar.H) && !sz.c(jB, yzVar.I) && !sz.c(jB, yzVar.J) && !sz.c(jB, yzVar.E)) {
                                if (sz.c(jB, yzVar.K) || sz.c(jB, yzVar.L)) {
                                    j7 = j6;
                                } else if (sz.c(jB, yzVar.O) || sz.c(jB, yzVar.P)) {
                                    j7 = j5;
                                } else {
                                    j7 = (sz.c(jB, yzVar.S) || sz.c(jB, yzVar.T)) ? j4 : sz.g;
                                }
                            }
                        }
                        if (j7 == 16) {
                            j7 = ((sz) x20Var2.j(g50.a)).a;
                        }
                        x20Var2.p(false);
                        m30 m30Var2 = wt2.a;
                        float f = ((de0) x20Var2.j(m30Var2)).a + 0.0f;
                        kj4.b(new a22[]{g50.a.a(new sz(j7)), m30Var2.a(new de0(f))}, yi4.b(421772006, new ut2(ek1VarF, t82VarA2, jB, f, w10VarB), x20Var2), x20Var2, 56);
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
                        zx zxVar2 = zxVar;
                        String str2 = zxVar2.a;
                        sr2 sr2Var2 = w33.a;
                        dz2.b(str2, null, uz.e, 0L, null, null, 0L, null, 0L, 2, false, 2, 0, ((v33) x20Var2.j(sr2Var2)).k, x20Var2, CollationFastLatin.LATIN_LIMIT, 24960, 110586);
                        x20 x20Var3 = x20Var2;
                        String str3 = zxVar2.c;
                        if (str3 == null || cs2.A(str3)) {
                            str3 = null;
                        }
                        if (str3 == null) {
                            x20Var3.W(-1473297780);
                        } else {
                            x20Var3.W(-1473297779);
                            k54.h(x20Var3, w44.c(bk1Var, 2.0f));
                            dz2.b(str3, null, uz.f, 0L, null, null, 0L, null, 0L, 2, false, 1, 0, ((v33) x20Var3.j(sr2Var2)).o, x20Var3, CollationFastLatin.LATIN_LIMIT, 24960, 110586);
                            x20Var3 = x20Var3;
                        }
                        x20Var3.p(false);
                        x20Var3.p(true);
                        x20Var3.p(true);
                    } else {
                        x20Var2.R();
                    }
                    return q43.a;
                }
            }, x20Var), x20Var, 817889280, UCharacter.UnicodeBlock.EGYPTIAN_HIEROGLYPH_FORMAT_CONTROLS_ID);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new vq0() { // from class: ps1
                @Override // defpackage.vq0
                public final Object e(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    ds4.c(str, zxVar, j, hq0Var, ek1Var, (x20) obj, ny3.c(i | 1));
                    return q43.a;
                }
            };
        }
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:67:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:71:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:74:0x0100  */
    /* JADX WARN: Code duplicated, block: B:77:0x012e  */
    /* JADX WARN: Code duplicated, block: B:80:0x0151  */
    /* JADX WARN: Code duplicated, block: B:81:0x0154  */
    /* JADX WARN: Code duplicated, block: B:83:0x015a  */
    /* JADX WARN: Code duplicated, block: B:84:0x015d  */
    /* JADX WARN: Code duplicated, block: B:86:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:89:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:91:? A[RETURN, SYNTHETIC] */
    public static final void d(final eo2 eo2Var, final fq0 fq0Var, final fq0 fq0Var2, final hq0 hq0Var, final hq0 hq0Var2, ek1 ek1Var, x20 x20Var, final int i, final int i2) {
        fq0 fq0Var3;
        hq0 hq0Var3;
        hq0 hq0Var4;
        ek1 ek1Var2;
        int i3;
        boolean z;
        final ek1 ek1Var3;
        a42 a42VarR;
        boolean z2;
        kl klVar;
        kl klVar2;
        ll llVar;
        yl0 yl0VarE;
        ll llVar2;
        ll llVar3 = xy.i;
        ll llVar4 = xy.n;
        ll llVar5 = xy.c;
        eo2Var.getClass();
        fq0Var.getClass();
        fq0Var2.getClass();
        hq0Var.getClass();
        hq0Var2.getClass();
        x20Var.X(-1555867148);
        int i4 = (x20Var.h(eo2Var) ? 4 : 2) | i;
        if ((i & 48) == 0) {
            i4 |= x20Var.h(fq0Var) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            fq0Var3 = fq0Var2;
            i4 |= x20Var.h(fq0Var3) ? 256 : 128;
        } else {
            fq0Var3 = fq0Var2;
        }
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            hq0Var3 = hq0Var;
            i4 |= x20Var.h(hq0Var3) ? 2048 : 1024;
        } else {
            hq0Var3 = hq0Var;
        }
        if ((i & 24576) == 0) {
            hq0Var4 = hq0Var2;
            i4 |= x20Var.h(hq0Var4) ? 16384 : 8192;
        } else {
            hq0Var4 = hq0Var2;
        }
        int i5 = i2 & 32;
        if (i5 == 0) {
            if ((196608 & i) == 0) {
                ek1Var2 = ek1Var;
                i4 |= x20Var.f(ek1Var2) ? Normalizer.INPUT_IS_FCD : 65536;
            }
            i3 = i4;
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (x20Var.O(i3 & 1, z)) {
                if (i5 != 0) {
                    ek1Var2 = bk1.a;
                }
                if (eo2Var.c.length() > 0 && eo2Var.f.isEmpty() && eo2Var.g == null) {
                    z2 = false;
                } else {
                    z2 = true;
                }
                cj0 cj0VarA = yi0.a(ie4.e(UCharacter.UnicodeBlock.OLD_HUNGARIAN_ID, null, 6), 2);
                f33 f33VarE = ie4.e(UCharacter.UnicodeBlock.OLD_HUNGARIAN_ID, null, 6);
                klVar = xy.v;
                j7 j7Var = j7.Z;
                klVar2 = xy.t;
                if (g31.a(klVar, klVar2)) {
                    llVar4 = llVar5;
                    llVar = llVar4;
                } else if (g31.a(klVar, klVar)) {
                    llVar = llVar5;
                } else {
                    llVar = llVar5;
                    llVar4 = llVar3;
                }
                cj0 cj0VarA2 = cj0VarA.a(new cj0(new k23((al0) null, new zw(llVar4, new xi0(j7Var, 0), f33VarE), (LinkedHashMap) null, 123)));
                yl0VarE = ie4.e(160, null, 6);
                if ((2 & 1) != 0) {
                    yl0VarE = ie4.d(5, null);
                }
                mk0 mk0Var = new mk0(new k23(new al0(yl0VarE), (zw) null, (LinkedHashMap) null, 126));
                f33 f33VarE2 = ie4.e(160, null, 6);
                j7 j7Var2 = j7.c0;
                if (g31.a(klVar, klVar2)) {
                    llVar2 = llVar;
                } else if (g31.a(klVar, klVar)) {
                    llVar2 = llVar4;
                } else {
                    llVar2 = llVar3;
                }
                mk0 mk0VarA = mk0Var.a(new mk0(new k23((al0) null, new zw(llVar2, new xi0(j7Var2, 1), f33VarE2), (LinkedHashMap) null, 123)));
                final fq0 fq0Var4 = fq0Var3;
                final hq0 hq0Var5 = hq0Var3;
                final hq0 hq0Var6 = hq0Var4;
                ek1 ek1Var4 = ek1Var2;
                f31.b(z2, ek1Var4, cj0VarA2, mk0VarA, null, yi4.b(88483868, new wq0() { // from class: qs1
                    @Override // defpackage.wq0
                    public final Object c(Object obj, Object obj2, Object obj3) {
                        long j;
                        boolean z3;
                        qs1 qs1Var;
                        long j2;
                        x20 x20Var2 = (x20) obj2;
                        ((Integer) obj3).getClass();
                        ((ld) obj).getClass();
                        eo2 eo2Var2 = eo2Var;
                        rn2 rn2Var = eo2Var2.a;
                        String str = eo2Var2.c;
                        long j3 = uz.a(rn2Var).c;
                        ek1 ek1VarC = c34.c(of4.a(kg1.a(w44.b(bk1.a, 1.0f), uz.c, u82.a(20.0f)), sz.b(0.28f, j3), u82.a(20.0f)), 18.0f);
                        j00 j00VarA = h00.a(new eg(12.0f, new ag(0)), xy.w, x20Var2, 6);
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
                        ie4.c(x20Var2, n20.f, j00VarA);
                        ie4.c(x20Var2, n20.e, gw1VarL);
                        ie4.a(x20Var2, Integer.valueOf(iHashCode), n20.g);
                        ie4.b(x20Var2, n20.h);
                        ie4.c(x20Var2, n20.d, ek1VarC2);
                        if (str.length() > 0) {
                            x20Var2.W(1586922999);
                            j = j3;
                            z3 = false;
                            dz2.b(str, null, uz.e, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(w33.a)).j, x20Var2, CollationFastLatin.LATIN_LIMIT, 0, 131066);
                            x20Var2 = x20Var2;
                        } else {
                            j = j3;
                            z3 = false;
                            x20Var2.W(1582719740);
                        }
                        x20Var2.p(z3);
                        String str2 = eo2Var2.d;
                        if (str2 == null || cs2.A(str2)) {
                            str2 = null;
                        }
                        if (str2 == null) {
                            x20Var2.W(1587174191);
                        } else {
                            x20Var2.W(1587174192);
                            x20 x20Var3 = x20Var2;
                            dz2.b(str2, null, uz.f, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(w33.a)).k, x20Var3, CollationFastLatin.LATIN_LIMIT, 0, 131066);
                            x20Var2 = x20Var3;
                        }
                        x20Var2.p(z3);
                        if (eo2Var2.a == rn2.v) {
                            x20Var2.W(1587409203);
                            qs1Var = this;
                            long j4 = j;
                            ds4.b(j4, fq0Var, fq0Var4, x20Var2, 0);
                            j2 = j4;
                        } else {
                            qs1Var = this;
                            j2 = j;
                            x20Var2.W(1582719740);
                        }
                        x20Var2.p(z3);
                        if (eo2Var2.b()) {
                            x20Var2.W(1587550067);
                            ds4.a(eo2Var2.f, j2, hq0Var5, x20Var2, 0);
                        } else {
                            x20Var2.W(1582719740);
                        }
                        x20Var2.p(z3);
                        h52 h52Var = eo2Var2.g;
                        if (h52Var == null) {
                            x20Var2.W(1587682250);
                        } else {
                            x20Var2.W(1587682251);
                            ds4.e(h52Var, j2, hq0Var6, x20Var2, 0);
                        }
                        x20Var2.p(z3);
                        x20Var2.p(true);
                        return q43.a;
                    }
                }, x20Var), x20Var, ((i3 >> 12) & 112) | 200064);
                ek1Var3 = ek1Var4;
            } else {
                x20Var.R();
                ek1Var3 = ek1Var2;
            }
            a42VarR = x20Var.r();
            if (a42VarR != null) {
                a42VarR.d = new vq0() { // from class: rs1
                    @Override // defpackage.vq0
                    public final Object e(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        ds4.d(eo2Var, fq0Var, fq0Var2, hq0Var, hq0Var2, ek1Var3, (x20) obj, ny3.c(i | 1), i2);
                        return q43.a;
                    }
                };
            }
        }
        i4 |= 196608;
        ek1Var2 = ek1Var;
        i3 = i4;
        if ((74899 & i3) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (x20Var.O(i3 & 1, z)) {
            if (i5 != 0) {
                ek1Var2 = bk1.a;
            }
            if (eo2Var.c.length() > 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            cj0 cj0VarA3 = yi0.a(ie4.e(UCharacter.UnicodeBlock.OLD_HUNGARIAN_ID, null, 6), 2);
            f33 f33VarE3 = ie4.e(UCharacter.UnicodeBlock.OLD_HUNGARIAN_ID, null, 6);
            klVar = xy.v;
            j7 j7Var3 = j7.Z;
            klVar2 = xy.t;
            if (g31.a(klVar, klVar2)) {
                llVar4 = llVar5;
                llVar = llVar4;
            } else if (g31.a(klVar, klVar)) {
                llVar = llVar5;
            } else {
                llVar = llVar5;
                llVar4 = llVar3;
            }
            cj0 cj0VarA4 = cj0VarA3.a(new cj0(new k23((al0) null, new zw(llVar4, new xi0(j7Var3, 0), f33VarE3), (LinkedHashMap) null, 123)));
            yl0VarE = ie4.e(160, null, 6);
            if ((2 & 1) != 0) {
                yl0VarE = ie4.d(5, null);
            }
            mk0 mk0Var2 = new mk0(new k23(new al0(yl0VarE), (zw) null, (LinkedHashMap) null, 126));
            f33 f33VarE4 = ie4.e(160, null, 6);
            j7 j7Var4 = j7.c0;
            if (g31.a(klVar, klVar2)) {
                llVar2 = llVar;
            } else if (g31.a(klVar, klVar)) {
                llVar2 = llVar4;
            } else {
                llVar2 = llVar3;
            }
            mk0 mk0VarA2 = mk0Var2.a(new mk0(new k23((al0) null, new zw(llVar2, new xi0(j7Var4, 1), f33VarE4), (LinkedHashMap) null, 123)));
            final fq0 fq0Var5 = fq0Var3;
            final hq0 hq0Var7 = hq0Var3;
            final hq0 hq0Var8 = hq0Var4;
            ek1 ek1Var5 = ek1Var2;
            f31.b(z2, ek1Var5, cj0VarA4, mk0VarA2, null, yi4.b(88483868, new wq0() { // from class: qs1
                @Override // defpackage.wq0
                public final Object c(Object obj, Object obj2, Object obj3) {
                    long j;
                    boolean z3;
                    qs1 qs1Var;
                    long j2;
                    x20 x20Var2 = (x20) obj2;
                    ((Integer) obj3).getClass();
                    ((ld) obj).getClass();
                    eo2 eo2Var2 = eo2Var;
                    rn2 rn2Var = eo2Var2.a;
                    String str = eo2Var2.c;
                    long j3 = uz.a(rn2Var).c;
                    ek1 ek1VarC = c34.c(of4.a(kg1.a(w44.b(bk1.a, 1.0f), uz.c, u82.a(20.0f)), sz.b(0.28f, j3), u82.a(20.0f)), 18.0f);
                    j00 j00VarA = h00.a(new eg(12.0f, new ag(0)), xy.w, x20Var2, 6);
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
                    ie4.c(x20Var2, n20.f, j00VarA);
                    ie4.c(x20Var2, n20.e, gw1VarL);
                    ie4.a(x20Var2, Integer.valueOf(iHashCode), n20.g);
                    ie4.b(x20Var2, n20.h);
                    ie4.c(x20Var2, n20.d, ek1VarC2);
                    if (str.length() > 0) {
                        x20Var2.W(1586922999);
                        j = j3;
                        z3 = false;
                        dz2.b(str, null, uz.e, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(w33.a)).j, x20Var2, CollationFastLatin.LATIN_LIMIT, 0, 131066);
                        x20Var2 = x20Var2;
                    } else {
                        j = j3;
                        z3 = false;
                        x20Var2.W(1582719740);
                    }
                    x20Var2.p(z3);
                    String str2 = eo2Var2.d;
                    if (str2 == null || cs2.A(str2)) {
                        str2 = null;
                    }
                    if (str2 == null) {
                        x20Var2.W(1587174191);
                    } else {
                        x20Var2.W(1587174192);
                        x20 x20Var3 = x20Var2;
                        dz2.b(str2, null, uz.f, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(w33.a)).k, x20Var3, CollationFastLatin.LATIN_LIMIT, 0, 131066);
                        x20Var2 = x20Var3;
                    }
                    x20Var2.p(z3);
                    if (eo2Var2.a == rn2.v) {
                        x20Var2.W(1587409203);
                        qs1Var = this;
                        long j4 = j;
                        ds4.b(j4, fq0Var, fq0Var5, x20Var2, 0);
                        j2 = j4;
                    } else {
                        qs1Var = this;
                        j2 = j;
                        x20Var2.W(1582719740);
                    }
                    x20Var2.p(z3);
                    if (eo2Var2.b()) {
                        x20Var2.W(1587550067);
                        ds4.a(eo2Var2.f, j2, hq0Var7, x20Var2, 0);
                    } else {
                        x20Var2.W(1582719740);
                    }
                    x20Var2.p(z3);
                    h52 h52Var = eo2Var2.g;
                    if (h52Var == null) {
                        x20Var2.W(1587682250);
                    } else {
                        x20Var2.W(1587682251);
                        ds4.e(h52Var, j2, hq0Var8, x20Var2, 0);
                    }
                    x20Var2.p(z3);
                    x20Var2.p(true);
                    return q43.a;
                }
            }, x20Var), x20Var, ((i3 >> 12) & 112) | 200064);
            ek1Var3 = ek1Var5;
        } else {
            x20Var.R();
            ek1Var3 = ek1Var2;
        }
        a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new vq0() { // from class: rs1
                @Override // defpackage.vq0
                public final Object e(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    ds4.d(eo2Var, fq0Var, fq0Var2, hq0Var, hq0Var2, ek1Var3, (x20) obj, ny3.c(i | 1), i2);
                    return q43.a;
                }
            };
        }
    }

    public static final void e(h52 h52Var, long j, hq0 hq0Var, x20 x20Var, int i) {
        h52 h52Var2;
        String str;
        boolean z;
        bk1 bk1Var;
        x20 x20Var2 = x20Var;
        x20Var2.X(1728763924);
        int i2 = i | (x20Var2.f(h52Var) ? 4 : 2) | (x20Var2.e(j) ? 32 : 16) | (x20Var2.h(hq0Var) ? 256 : 128);
        if (x20Var2.O(i2 & 1, (i2 & 147) != 146)) {
            j00 j00VarA = h00.a(new eg(8.0f, new ag(0)), xy.w, x20Var2, 6);
            int iHashCode = Long.hashCode(x20Var2.T);
            gw1 gw1VarL = x20Var2.l();
            bk1 bk1Var2 = bk1.a;
            ek1 ek1VarC = gj4.c(x20Var2, bk1Var2);
            o20.p.getClass();
            k30 k30Var = n20.b;
            x20Var2.Z();
            if (x20Var2.S) {
                x20Var2.k(k30Var);
            } else {
                x20Var2.j0();
            }
            ie4.c(x20Var2, n20.f, j00VarA);
            ie4.c(x20Var2, n20.e, gw1VarL);
            ie4.a(x20Var2, Integer.valueOf(iHashCode), n20.g);
            ie4.b(x20Var2, n20.h);
            ie4.c(x20Var2, n20.d, ek1VarC);
            if (h52Var instanceof f52) {
                str = ((f52) h52Var).c;
            } else if (h52Var instanceof d52) {
                str = ((d52) h52Var).c;
            } else {
                if (!(h52Var instanceof e52) && !(h52Var instanceof g52)) {
                    dk0.l();
                    return;
                }
                str = null;
            }
            if (str == null) {
                x20Var2.W(572300581);
                x20Var2.p(false);
                z = false;
                bk1Var = bk1Var2;
            } else {
                x20Var2.W(572300582);
                z = false;
                bk1Var = bk1Var2;
                dz2.b(str, null, uz.g, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(w33.a)).k, x20Var, CollationFastLatin.LATIN_LIMIT, 0, 131066);
                x20Var2 = x20Var;
                x20Var2.p(false);
            }
            ek1 ek1VarB = w44.b(bk1Var, 1.0f);
            qt1 qt1Var = bo.a;
            ao aoVarA = bo.a(j, uz.a, x20Var2);
            t82 t82VarA = u82.a(14.0f);
            boolean z2 = (i2 & 896) == 256 ? true : z;
            if ((i2 & 14) == 4) {
                z = true;
            }
            boolean z3 = z2 | z;
            Object objL = x20Var2.L();
            if (z3 || objL == r20.a) {
                h52Var2 = h52Var;
                objL = new zb(12, hq0Var, h52Var2);
                x20Var2.g0(objL);
            } else {
                h52Var2 = h52Var;
            }
            dg4.a((fq0) objL, ek1VarB, false, t82VarA, aoVarA, null, null, null, yi4.b(-1332600082, new xv(4, h52Var2), x20Var2), x20Var2, 805306416, 484);
            x20Var2.p(true);
        } else {
            h52Var2 = h52Var;
            x20Var2.R();
        }
        a42 a42VarR = x20Var2.r();
        if (a42VarR != null) {
            a42VarR.d = new u8(h52Var2, j, hq0Var, i, 3);
        }
    }
}
