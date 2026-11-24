package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ra2 implements vq0 {
    public final /* synthetic */ int a;

    public /* synthetic */ ra2(int i) {
        this.a = i;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        de deVar;
        Object objA;
        switch (this.a) {
            case 0:
                jp1 jp1Var = (jp1) obj2;
                return jp1Var != null ? jp1.b(jp1Var.a, 9205357640488583168L) : false ? Boolean.FALSE : nz.a(Float.valueOf(Float.intBitsToFloat((int) (jp1Var.a >> 32))), Float.valueOf(Float.intBitsToFloat((int) (jp1Var.a & 4294967295L))));
            case 1:
                x92 x92Var = (x92) obj;
                ae aeVar = (ae) obj2;
                Object obj3 = aeVar.a;
                if (obj3 instanceof eu1) {
                    deVar = de.a;
                } else if (obj3 instanceof hp2) {
                    deVar = de.b;
                } else if (obj3 instanceof a73) {
                    deVar = de.c;
                } else if (obj3 instanceof m53) {
                    deVar = de.e;
                } else if (obj3 instanceof jc1) {
                    deVar = de.f;
                } else if (obj3 instanceof ic1) {
                    deVar = de.i;
                } else {
                    if (!(obj3 instanceof bs2)) {
                        dk0.p();
                        return null;
                    }
                    deVar = de.j;
                }
                switch (deVar.ordinal()) {
                    case 0:
                        obj3.getClass();
                        objA = wa2.a((eu1) obj3, wa2.g, x92Var);
                        break;
                    case 1:
                        obj3.getClass();
                        objA = wa2.a((hp2) obj3, wa2.h, x92Var);
                        break;
                    case 2:
                        obj3.getClass();
                        objA = wa2.a((a73) obj3, wa2.c, x92Var);
                        break;
                    case 3:
                        obj3.getClass();
                        objA = wa2.a((m53) obj3, wa2.d, x92Var);
                        break;
                    case 4:
                        obj3.getClass();
                        objA = wa2.a((jc1) obj3, wa2.e, x92Var);
                        break;
                    case 5:
                        obj3.getClass();
                        objA = wa2.a((ic1) obj3, wa2.f, x92Var);
                        break;
                    case 6:
                        obj3.getClass();
                        objA = ((bs2) obj3).a;
                        break;
                    default:
                        dk0.l();
                        return null;
                }
                return nz.a(deVar, objA, Integer.valueOf(aeVar.b), Integer.valueOf(aeVar.c), aeVar.d);
            case 2:
                x92 x92Var2 = (x92) obj;
                List list = ((ne1) obj2).a;
                ArrayList arrayList = new ArrayList(list.size());
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    arrayList.add(wa2.a((me1) list.get(i), wa2.z, x92Var2));
                }
                return arrayList;
            case 3:
                return ((me1) obj2).a.toLanguageTag();
            case 4:
                x92 x92Var3 = (x92) obj;
                bc1 bc1Var = (bc1) obj2;
                return nz.a(wa2.a(new yb1(bc1Var.a), wa2.B, x92Var3), wa2.a(new ac1(bc1Var.b), wa2.C, x92Var3), wa2.a(new zb1(bc1Var.c), wa2.D, x92Var3));
            case 5:
                return Float.valueOf(((yb1) obj2).a);
            case 6:
                return Integer.valueOf(((ac1) obj2).a);
            case 7:
                return Integer.valueOf(((zb1) obj2).a);
            case 8:
                return ((a73) obj2).a;
            case 9:
                x92 x92Var4 = (x92) obj;
                eu1 eu1Var = (eu1) obj2;
                Object objA2 = wa2.a(new vw2(eu1Var.a), wa2.q, x92Var4);
                Object objA3 = wa2.a(new vx2(eu1Var.b), wa2.r, x92Var4);
                Object objA4 = wa2.a(new b03(eu1Var.c), wa2.v, x92Var4);
                wy2 wy2Var = eu1Var.d;
                wy2 wy2Var2 = wy2.c;
                Object objA5 = wa2.a(wy2Var, wa2.l, x92Var4);
                Object objA6 = wa2.a(eu1Var.e, g44.a, x92Var4);
                bc1 bc1Var2 = eu1Var.f;
                bc1 bc1Var3 = bc1.d;
                return nz.a(objA2, objA3, objA4, objA5, objA6, wa2.a(bc1Var2, wa2.A, x92Var4), wa2.a(new wb1(eu1Var.g), g44.c, x92Var4), wa2.a(new iy0(eu1Var.h), wa2.s, x92Var4), wa2.a(eu1Var.i, g44.d, x92Var4));
            case 10:
                return ((m53) obj2).a;
            case 11:
                x92 x92Var5 = (x92) obj;
                hp2 hp2Var = (hp2) obj2;
                sz szVar = new sz(hp2Var.a.c());
                va2 va2Var = wa2.p;
                Object objA7 = wa2.a(szVar, va2Var, x92Var5);
                b03 b03Var = new b03(hp2Var.b);
                va2 va2Var2 = wa2.v;
                Object objA8 = wa2.a(b03Var, va2Var2, x92Var5);
                np0 np0Var = hp2Var.c;
                np0 np0Var2 = np0.b;
                Object objA9 = wa2.a(np0Var, wa2.m, x92Var5);
                Object objA10 = wa2.a(hp2Var.d, wa2.t, x92Var5);
                Object objA11 = wa2.a(hp2Var.e, wa2.u, x92Var5);
                String str = hp2Var.g;
                Object objA12 = wa2.a(new b03(hp2Var.h), va2Var2, x92Var5);
                Object objA13 = wa2.a(hp2Var.i, wa2.n, x92Var5);
                Object objA14 = wa2.a(hp2Var.j, wa2.k, x92Var5);
                ne1 ne1Var = hp2Var.k;
                ne1 ne1Var2 = ne1.c;
                Object objA15 = wa2.a(ne1Var, wa2.y, x92Var5);
                Object objA16 = wa2.a(new sz(hp2Var.l), va2Var, x92Var5);
                Object objA17 = wa2.a(hp2Var.m, wa2.j, x92Var5);
                vj2 vj2Var = hp2Var.n;
                vj2 vj2Var2 = vj2.d;
                return nz.a(objA7, objA8, objA9, objA10, objA11, -1, str, objA12, objA13, objA14, objA15, objA16, objA17, wa2.a(vj2Var, wa2.o, x92Var5));
            case 12:
                x92 x92Var6 = (x92) obj;
                jz2 jz2Var = (jz2) obj2;
                hp2 hp2Var2 = jz2Var.a;
                q91 q91Var = wa2.h;
                return nz.a(wa2.a(hp2Var2, q91Var, x92Var6), wa2.a(jz2Var.b, q91Var, x92Var6), wa2.a(jz2Var.c, q91Var, x92Var6), wa2.a(jz2Var.d, q91Var, x92Var6));
            case 13:
                nx1 nx1Var = (nx1) obj2;
                Boolean boolValueOf = Boolean.valueOf(nx1Var.a);
                q91 q91Var2 = wa2.a;
                return nz.a(boolValueOf, wa2.a(new ai0(nx1Var.b), g44.b, (x92) obj));
            case 14:
                return Integer.valueOf(((ai0) obj2).a);
            case 15:
                return Integer.valueOf(((wb1) obj2).a);
            case 16:
                lz2 lz2Var = (lz2) obj2;
                return nz.a(wa2.a(new kz2(lz2Var.a), g44.e, (x92) obj), Boolean.valueOf(lz2Var.b));
            case 17:
                return Integer.valueOf(((kz2) obj2).a);
            case 18:
                return Integer.valueOf(((md2) obj2).a.g());
            case 19:
                fy2 fy2Var = (fy2) obj2;
                return nz.i(Float.valueOf(fy2Var.a.g()), Boolean.valueOf(((js1) fy2Var.f.getValue()) == js1.a));
            case 20:
                return obj;
            case 21:
                if (obj == null) {
                } else {
                    dk0.t();
                }
                return null;
            default:
                return (l03) obj;
        }
    }
}
