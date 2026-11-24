package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ag implements vq0 {
    public final /* synthetic */ int a;

    public /* synthetic */ ag(tt0 tt0Var) {
        this.a = 6;
    }

    /* JADX WARN: Code duplicated, block: B:163:0x026c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:71:0x0267 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x0269 A[LOOP:1: B:59:0x0222->B:72:0x0269, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:99:0x02f4 A[PHI: r5
      0x02f4: PHI (r5v14 int) = (r5v4 int), (r5v9 int), (r5v11 int) binds: [B:98:0x02f2, B:104:0x032c, B:107:0x033b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        p00 p00Var;
        switch (this.a) {
            case 0:
                return Integer.valueOf(Math.round((1.0f + (((z61) obj2) == z61.a ? -1.0f : 1.0f)) * (((Integer) obj).intValue() / 2.0f)));
            case 1:
                String str = (String) obj;
                h70 h70Var = (h70) obj2;
                str.getClass();
                h70Var.getClass();
                if (str.length() == 0) {
                    return h70Var.toString();
                }
                return str + ", " + h70Var;
            case 2:
                j70 j70Var = (j70) obj;
                h70 h70Var2 = (h70) obj2;
                j70Var.getClass();
                h70Var2.getClass();
                j70 j70VarD = j70Var.D(h70Var2.getKey());
                gi0 gi0Var = gi0.a;
                if (j70VarD == gi0Var) {
                    return h70Var2;
                }
                qs4 qs4Var = qs4.c;
                l70 l70Var = (l70) j70VarD.v(qs4Var);
                if (l70Var == null) {
                    p00Var = new p00(h70Var2, j70VarD);
                } else {
                    j70 j70VarD2 = j70VarD.D(qs4Var);
                    if (j70VarD2 == gi0Var) {
                        return new p00(l70Var, h70Var2);
                    }
                    p00Var = new p00(l70Var, new p00(h70Var2, j70VarD2));
                }
                return p00Var;
            case 3:
                return ((j70) obj).r((h70) obj2);
            case 4:
                return ((j70) obj).r((h70) obj2);
            case 5:
                Boolean bool = (Boolean) obj;
                bool.booleanValue();
                return bool;
            case 6:
                String str2 = (String) obj;
                String str3 = (String) obj2;
                str3.getClass();
                boolean z = tt0.g(str3) >= 3;
                str2.getClass();
                int iCompare = Boolean.compare(z, tt0.g(str2) >= 3);
                if (iCompare == 0) {
                    int iCompare2 = Boolean.compare(cs2.n(str3, "flash", true), cs2.n(str2, "flash", true));
                    if (iCompare2 != 0) {
                        iCompare = iCompare2;
                    } else {
                        wt1 wt1VarH = tt0.h(str2);
                        wt1 wt1VarH2 = tt0.h(str3);
                        int iB = g31.b(((Number) wt1VarH2.a).intValue(), ((Number) wt1VarH.a).intValue());
                        if (iB != 0) {
                            iCompare = iB;
                        } else {
                            iCompare2 = g31.b(((Number) wt1VarH2.b).intValue(), ((Number) wt1VarH.b).intValue());
                            if (iCompare2 == 0 && (iCompare2 = g31.b(tt0.g(str3), tt0.g(str2))) == 0) {
                                iCompare = g31.b(cs2.n(str3, "flash-lite", true) ? 2 : cs2.n(str3, "flash", true) ? 3 : 1, cs2.n(str2, "flash-lite", true) ? 2 : cs2.n(str2, "flash", true) ? 3 : 1);
                                if (iCompare == 0 && (iCompare = g31.b(str2.length(), str3.length())) == 0) {
                                    iCompare = str2.compareTo(str3);
                                }
                            } else {
                                iCompare = iCompare2;
                            }
                        }
                    }
                }
                return Integer.valueOf(iCompare);
            case 7:
                ea1 ea1Var = (ea1) obj2;
                return nz.i(Integer.valueOf(ea1Var.g()), Integer.valueOf(ea1Var.h()));
            case 8:
                Map mapD = ((ha1) obj2).d();
                if (mapD.isEmpty()) {
                    return null;
                }
                return mapD;
            case 9:
                return Integer.valueOf(((Integer) obj).intValue() + 1);
            case 10:
                aa2 aa2Var = (aa2) obj2;
                Map map = aa2Var.a;
                gm1 gm1Var = aa2Var.b;
                Object[] objArr = gm1Var.b;
                Object[] objArr2 = gm1Var.c;
                long[] jArr = gm1Var.a;
                int length = jArr.length - 2;
                if (length >= 0) {
                    int i = 0;
                    while (true) {
                        long j = jArr[i];
                        if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                            int i2 = 8 - ((~(i - length)) >>> 31);
                            for (int i3 = 0; i3 < i2; i3++) {
                                if ((255 & j) < 128) {
                                    int i4 = (i << 3) + i3;
                                    Object obj3 = objArr[i4];
                                    Map mapD2 = ((ba2) objArr2[i4]).d();
                                    if (mapD2.isEmpty()) {
                                        map.remove(obj3);
                                    } else {
                                        map.put(obj3, mapD2);
                                    }
                                }
                                j >>= 8;
                            }
                            if (i2 == 8) {
                                if (i != length) {
                                    i++;
                                }
                            }
                        } else if (i != length) {
                            i++;
                        }
                    }
                }
                if (map.isEmpty()) {
                    return null;
                }
                return map;
            case 11:
                return obj2;
            case 12:
                be beVar = (be) obj2;
                return nz.a(beVar.b, wa2.a(beVar.a, wa2.a, (x92) obj));
            case 13:
                return Integer.valueOf(((sx2) obj2).a);
            case 14:
                vy2 vy2Var = (vy2) obj2;
                return nz.a(Float.valueOf(vy2Var.a), Float.valueOf(vy2Var.b));
            case 15:
                x92 x92Var = (x92) obj;
                wy2 wy2Var = (wy2) obj2;
                b03 b03Var = new b03(wy2Var.a);
                va2 va2Var = wa2.v;
                return nz.a(wa2.a(b03Var, va2Var, x92Var), wa2.a(new b03(wy2Var.b), va2Var, x92Var));
            case 16:
                return Integer.valueOf(((np0) obj2).a);
            case 17:
                jc1 jc1Var = (jc1) obj2;
                return nz.a(jc1Var.a, wa2.a(jc1Var.b, wa2.i, (x92) obj));
            case 18:
                return Float.valueOf(((rk) obj2).a);
            case 19:
                x92 x92Var2 = (x92) obj;
                List list = (List) obj2;
                ArrayList arrayList = new ArrayList(list.size());
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    arrayList.add(wa2.a((ae) list.get(i5), wa2.b, x92Var2));
                }
                return arrayList;
            case 20:
                oz2 oz2Var = (oz2) obj2;
                return nz.a(Integer.valueOf((int) (oz2Var.a >> 32)), Integer.valueOf((int) (oz2Var.a & 4294967295L)));
            case 21:
                x92 x92Var3 = (x92) obj;
                vj2 vj2Var = (vj2) obj2;
                return nz.a(wa2.a(new sz(vj2Var.a), wa2.p, x92Var3), wa2.a(new jp1(vj2Var.b), wa2.x, x92Var3), Float.valueOf(vj2Var.c));
            case 22:
                return Integer.valueOf(((vw2) obj2).a);
            case 23:
                return Integer.valueOf(((vx2) obj2).a);
            case 24:
                return Integer.valueOf(((iy0) obj2).a);
            case 25:
                return Integer.valueOf(((lp0) obj2).a);
            case 26:
                return Integer.valueOf(((mp0) obj2).a);
            case 27:
                b03 b03Var2 = (b03) obj2;
                return b03Var2 != null ? b03.a(b03Var2.a, b03.c) : false ? Boolean.FALSE : nz.a(Float.valueOf(b03.c(b03Var2.a)), wa2.a(new c03(b03.b(b03Var2.a)), wa2.w, (x92) obj));
            case 28:
                ic1 ic1Var = (ic1) obj2;
                return nz.a(ic1Var.a, wa2.a(ic1Var.b, wa2.i, (x92) obj));
            default:
                long j2 = ((c03) obj2).a;
                if (c03.a(j2, 8589934592L)) {
                    return 0;
                }
                if (c03.a(j2, 4294967296L)) {
                    return 1;
                }
                return Boolean.FALSE;
        }
    }

    public /* synthetic */ ag(int i) {
        this.a = i;
    }
}
