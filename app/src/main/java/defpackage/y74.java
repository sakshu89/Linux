package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.hardware.camera2.CaptureResult;
import android.util.Base64;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class y74 implements zs2, j92, sb0, ls, ey1, ks4, pg0, b23 {
    public static final og b = new og(17);
    public static final y74 c = new y74(2);
    public static final /* synthetic */ y74 e = new y74(3);
    public static final y74 f = new y74(4);
    public static final y74 i = new y74(5);
    public static final kf2 j = new kf2(4);
    public static final kf2 k = new kf2(5);
    public static final y74 n = new y74(7);
    public final /* synthetic */ int a;

    public /* synthetic */ y74(int i2) {
        this.a = i2;
    }

    public static final ArrayList r(y74 y74Var, String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(new x42(str, y42.IGNORE_CASE));
        }
        return arrayList;
    }

    public static final void s(fl4 fl4Var) {
        jr2 jr2Var;
        pw1 pw1Var;
        pw1 pw1Var2;
        jr2 jr2Var2 = f42.z;
        do {
            jr2Var = f42.z;
            pw1Var = (pw1) jr2Var.getValue();
            hw1 hw1VarA = pw1Var.c;
            oc1 oc1Var = (oc1) hw1VarA.get(fl4Var);
            if (oc1Var == null) {
                pw1Var2 = pw1Var;
            } else {
                Object obj = oc1Var.a;
                Object obj2 = oc1Var.b;
                x23 x23Var = hw1VarA.a;
                x23 x23VarV = x23Var.v(fl4Var != null ? fl4Var.hashCode() : 0, 0, fl4Var);
                if (x23Var != x23VarV) {
                    hw1VarA = x23VarV == null ? hw1.c : new hw1(x23VarV, hw1VarA.b - 1);
                }
                xy xyVar = xy.H;
                if (obj != xyVar) {
                    Object obj3 = hw1VarA.get(obj);
                    obj3.getClass();
                    hw1VarA = hw1VarA.a(obj, new oc1(((oc1) obj3).a, obj2));
                }
                if (obj2 != xyVar) {
                    Object obj4 = hw1VarA.get(obj2);
                    obj4.getClass();
                    hw1VarA = hw1VarA.a(obj2, new oc1(obj, ((oc1) obj4).b));
                }
                Object obj5 = obj != xyVar ? pw1Var.a : obj2;
                if (obj2 != xyVar) {
                    obj = pw1Var.b;
                }
                pw1Var2 = new pw1(obj5, obj, hw1VarA);
            }
            if (pw1Var == pw1Var2) {
                return;
            }
        } while (!jr2Var.h(pw1Var, pw1Var2));
    }

    public static Typeface u(String str, np0 np0Var, int i2) {
        if (i2 == 0 && g31.a(np0Var, np0.c) && (str == null || str.length() == 0)) {
            return Typeface.DEFAULT;
        }
        int iA = xc4.a(np0Var, i2);
        return (str == null || str.length() == 0) ? Typeface.defaultFromStyle(iA) : Typeface.create(str, iA);
    }

    public static ec1 v(wt1[] wt1VarArr, long j2, long j3) {
        ArrayList arrayList = new ArrayList(wt1VarArr.length);
        for (wt1 wt1Var : wt1VarArr) {
            arrayList.add(new sz(((sz) wt1Var.b).a));
        }
        ArrayList arrayList2 = new ArrayList(wt1VarArr.length);
        for (wt1 wt1Var2 : wt1VarArr) {
            arrayList2.add(Float.valueOf(((Number) wt1Var2.a).floatValue()));
        }
        return new ec1(arrayList, arrayList2, j2, j3);
    }

    public static f5 w(b63 b63Var) {
        fh1 fh1VarD;
        fh1 fh1VarD2;
        fh1 fh1VarD3;
        fh1 fh1VarD4;
        Map mapSingletonMap;
        String strH = nk0.a.h(cs2.V(b63Var.a).toString());
        fh1 fh1VarD5 = nk0.c.d(strH);
        if (fh1VarD5 != null) {
            String str = (String) ((dh1) fh1VarD5.a()).get(2);
            Locale locale = Locale.ROOT;
            String strO = cq.o(locale, str, locale);
            Pattern patternCompile = Pattern.compile("(?:st|nd|rd|th)$");
            patternCompile.getClass();
            String strReplaceAll = patternCompile.matcher(strO).replaceAll("");
            strReplaceAll.getClass();
            Integer numL = js2.l(10, strReplaceAll);
            int iIntValue = numL != null ? numL.intValue() : nk0.b.indexOf(strO) + 1;
            Map mapC = bh1.c(new wt1("query", ((dh1) fh1VarD5.a()).get(1)), new wt1("video_position", String.valueOf(iIntValue)));
            if (iIntValue == 1) {
                mapSingletonMap = Collections.singletonMap("select_first_result", "true");
                mapSingletonMap.getClass();
            } else {
                mapSingletonMap = ji0.a;
            }
            return dp4.d(b63Var, "youtube.play", bh1.e(mapC, mapSingletonMap), 0.0f, 12);
        }
        ArrayList arrayList = nk0.d;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        do {
            if (i3 >= size) {
                fh1VarD = null;
                break;
            }
            Object obj = arrayList.get(i3);
            i3++;
            fh1VarD = ((x42) obj).d(strH);
        } while (fh1VarD == null);
        if (fh1VarD != null) {
            return dp4.d(b63Var, "youtube.play", bh1.c(new wt1("query", ((dh1) fh1VarD.a()).get(1)), new wt1("video_position", "1"), new wt1("select_first_result", "true")), 0.0f, 12);
        }
        x42 x42Var = yb2.a;
        if (xz3.b(b63Var) == null) {
            ArrayList arrayList2 = nk0.e;
            int size2 = arrayList2.size();
            int i4 = 0;
            do {
                if (i4 >= size2) {
                    fh1VarD2 = null;
                    break;
                }
                Object obj2 = arrayList2.get(i4);
                i4++;
                fh1VarD2 = ((x42) obj2).d(strH);
            } while (fh1VarD2 == null);
            if (fh1VarD2 != null) {
                Map mapSingletonMap2 = Collections.singletonMap("query", ((dh1) fh1VarD2.a()).get(1));
                mapSingletonMap2.getClass();
                return dp4.d(b63Var, "youtube.play", mapSingletonMap2, 0.0f, 12);
            }
            ArrayList arrayList3 = nk0.f;
            int size3 = arrayList3.size();
            int i5 = 0;
            do {
                if (i5 >= size3) {
                    fh1VarD3 = null;
                    break;
                }
                Object obj3 = arrayList3.get(i5);
                i5++;
                fh1VarD3 = ((x42) obj3).d(strH);
            } while (fh1VarD3 == null);
            if (fh1VarD3 != null) {
                Map mapSingletonMap3 = Collections.singletonMap("query", ((dh1) fh1VarD3.a()).get(1));
                mapSingletonMap3.getClass();
                return dp4.d(b63Var, "youtube.search", mapSingletonMap3, 0.0f, 12);
            }
            ArrayList arrayList4 = nk0.g;
            int size4 = arrayList4.size();
            do {
                if (i2 >= size4) {
                    fh1VarD4 = null;
                    break;
                }
                Object obj4 = arrayList4.get(i2);
                i2++;
                fh1VarD4 = ((x42) obj4).d(strH);
            } while (fh1VarD4 == null);
            if (fh1VarD4 != null) {
                Map mapSingletonMap4 = Collections.singletonMap("query", ((dh1) fh1VarD4.a()).get(1));
                mapSingletonMap4.getClass();
                return dp4.d(b63Var, "web.search", mapSingletonMap4, 0.0f, 12);
            }
        }
        return null;
    }

    public static o22 x(wt1[] wt1VarArr, long j2, float f2) {
        ArrayList arrayList = new ArrayList(wt1VarArr.length);
        for (wt1 wt1Var : wt1VarArr) {
            arrayList.add(new sz(((sz) wt1Var.b).a));
        }
        ArrayList arrayList2 = new ArrayList(wt1VarArr.length);
        for (wt1 wt1Var2 : wt1VarArr) {
            arrayList2.add(Float.valueOf(((Number) wt1Var2.a).floatValue()));
        }
        return new o22(arrayList, arrayList2, j2, f2);
    }

    public static ec1 y(wt1[] wt1VarArr, float f2, int i2) {
        if ((i2 & 4) != 0) {
            f2 = Float.POSITIVE_INFINITY;
        }
        return v((wt1[]) Arrays.copyOf(wt1VarArr, wt1VarArr.length), (((long) Float.floatToRawIntBits(0.0f)) << 32) | (((long) Float.floatToRawIntBits(0.0f)) & 4294967295L), (((long) Float.floatToRawIntBits(f2)) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32));
    }

    @Override // defpackage.j92
    public Object apply(Object obj) {
        switch (this.a) {
            case 5:
                Cursor cursor = (Cursor) obj;
                qi0 qi0Var = l92.f;
                ArrayList arrayList = new ArrayList();
                while (cursor.moveToNext()) {
                    String string = cursor.getString(1);
                    byte[] bArrDecode = null;
                    if (string == null) {
                        dk0.n("Null backendName");
                        return null;
                    }
                    v02 v02VarB = w02.b(cursor.getInt(2));
                    String string2 = cursor.getString(3);
                    if (string2 != null) {
                        bArrDecode = Base64.decode(string2, 0);
                    }
                    arrayList.add(new pj(string, bArrDecode, v02VarB));
                }
                return arrayList;
            default:
                return (byte[]) obj;
        }
    }

    @Override // defpackage.ls
    public iv2 b() {
        return iv2.b;
    }

    @Override // defpackage.sb0
    public boolean c(SSLSocket sSLSocket) {
        return js2.k(sSLSocket.getClass().getName(), "com.google.android.gms.org.conscrypt.", false);
    }

    @Override // defpackage.ls
    public long d() {
        return -1L;
    }

    @Override // defpackage.ey1
    public Typeface e(np0 np0Var, int i2) {
        return u(null, np0Var, i2);
    }

    @Override // defpackage.ks4
    public Object f(Object obj) {
        switch (this.a) {
            case 22:
                return new tw2((vs4) obj);
            default:
                zh4 zh4Var = (zh4) obj;
                v54 v54Var = zh4Var.b;
                String str = zh4Var.j;
                List listC = bh4.c(v54Var);
                String str2 = zh4Var.f;
                if (hi4.c(str2)) {
                    str2 = "";
                }
                String str3 = str2;
                Rect rectB = bh4.b(listC);
                if (hi4.c(str)) {
                    str = "und";
                }
                String str4 = str;
                jh4.b(Arrays.asList(zh4Var.a), new nr4(24));
                float f2 = zh4Var.b.f;
                return new rw2(str3, rectB, listC, str4, null);
        }
    }

    @Override // defpackage.sb0
    public xm2 g(SSLSocket sSLSocket) {
        Class<?> cls = sSLSocket.getClass();
        Class<?> superclass = cls;
        while (!superclass.getSimpleName().equals("OpenSSLSocketImpl")) {
            superclass = superclass.getSuperclass();
            if (superclass == null) {
                throw new AssertionError("No OpenSSLSocketImpl superclass of socket of type " + cls);
            }
        }
        return new wb(superclass);
    }

    @Override // defpackage.zs2
    public void h(ys2 ys2Var) {
        ys2Var.clear();
    }

    @Override // defpackage.ey1
    public Typeface i(bu0 bu0Var, np0 np0Var, int i2) {
        String strConcat = bu0Var.d;
        int i3 = np0Var.a / 100;
        if (i3 >= 0 && i3 < 2) {
            strConcat = strConcat.concat("-thin");
        } else if (2 <= i3 && i3 < 4) {
            strConcat = strConcat.concat("-light");
        } else if (i3 != 4) {
            if (i3 == 5) {
                strConcat = strConcat.concat("-medium");
            } else if ((6 > i3 || i3 >= 8) && 8 <= i3 && i3 < 11) {
                strConcat = strConcat.concat("-black");
            }
        }
        Typeface typeface = null;
        if (strConcat.length() != 0) {
            Typeface typefaceU = u(strConcat, np0Var, i2);
            if (!g31.a(typefaceU, Typeface.create(Typeface.DEFAULT, xc4.a(np0Var, i2))) && !g31.a(typefaceU, u(null, np0Var, i2))) {
                typeface = typefaceU;
            }
        }
        return typeface == null ? u(bu0Var.d, np0Var, i2) : typeface;
    }

    @Override // defpackage.ls
    public hs j() {
        return hs.a;
    }

    @Override // defpackage.ls
    public js k() {
        return js.a;
    }

    @Override // defpackage.pg0
    public int l(Context context, String str) {
        return sg0.a(context, str);
    }

    @Override // defpackage.ls
    public int m() {
        return 1;
    }

    @Override // defpackage.ls
    public CaptureResult n() {
        return null;
    }

    @Override // defpackage.ls
    public is o() {
        return is.a;
    }

    @Override // defpackage.zs2
    public boolean p(Object obj, Object obj2) {
        return false;
    }

    @Override // defpackage.pg0
    public int q(Context context, String str, boolean z) {
        return sg0.d(context, str, z);
    }

    public void t(pi0 pi0Var) {
        pi0Var.a(td4.class, b54.a);
        pi0Var.a(bi4.class, o94.a);
        pi0Var.a(vd4.class, c54.a);
        pi0Var.a(ee4.class, e54.a);
        pi0Var.a(ae4.class, d54.a);
        pi0Var.a(ce4.class, g54.a);
        pi0Var.a(wb4.class, g34.a);
        pi0Var.a(ub4.class, f34.a);
        pi0Var.a(zc4.class, n44.a);
        pi0Var.a(ph4.class, y84.a);
        pi0Var.a(sb4.class, d34.a);
        pi0Var.a(qb4.class, b34.a);
        pi0Var.a(ue4.class, e64.a);
        pi0Var.a(oj4.class, b44.a);
        pi0Var.a(tc4.class, h44.a);
        pi0Var.a(nc4.class, z34.a);
        pi0Var.a(we4.class, g64.a);
        pi0Var.a(jh4.class, s84.a);
        pi0Var.a(lh4.class, u84.a);
        pi0Var.a(hh4.class, q84.a);
        pi0Var.a(v53.class, r54.a);
        pi0Var.a(mj4.class, v14.a);
        pi0Var.a(rd3.class, t54.a);
        pi0Var.a(mf4.class, w64.a);
        pi0Var.a(sf4.class, c74.a);
        pi0Var.a(qf4.class, a74.a);
        pi0Var.a(of4.class, y64.a);
        pi0Var.a(ng4.class, u74.a);
        pi0Var.a(pg4.class, w74.a);
        pi0Var.a(tg4.class, c84.a);
        pi0Var.a(rg4.class, a84.a);
        pi0Var.a(ke4.class, p54.a);
        pi0Var.a(vg4.class, e84.a);
        pi0Var.a(xg4.class, g84.a);
        pi0Var.a(zg4.class, i84.a);
        pi0Var.a(bh4.class, k84.a);
        pi0Var.a(fh4.class, m84.a);
        pi0Var.a(dh4.class, o84.a);
        pi0Var.a(lg4.class, m74.a);
        pi0Var.a(ld4.class, x44.a);
        pi0Var.a(hg4.class, q74.a);
        pi0Var.a(fg4.class, o74.a);
        pi0Var.a(jg4.class, s74.a);
        pi0Var.a(nh4.class, w84.a);
        pi0Var.a(mi4.class, ca4.a);
        pi0Var.a(ds2.class, f24.a);
        pi0Var.a(ra4.class, d24.a);
        pi0Var.a(pa4.class, c24.a);
        pi0Var.a(ta4.class, e24.a);
        pi0Var.a(ya4.class, j24.a);
        pi0Var.a(wa4.class, h24.a);
        pi0Var.a(ab4.class, l24.a);
        pi0Var.a(cb4.class, n24.a);
        pi0Var.a(eb4.class, p24.a);
        pi0Var.a(gb4.class, r24.a);
        pi0Var.a(ib4.class, t24.a);
        pi0Var.a(wz3.class, o14.a);
        pi0Var.a(yz3.class, s14.a);
        pi0Var.a(xz3.class, q14.a);
        pi0Var.a(hd4.class, t44.a);
        pi0Var.a(yb4.class, h34.a);
        pi0Var.a(iy3.class, a04.a);
        pi0Var.a(fy3.class, b04.a);
        pi0Var.a(jc4.class, t34.a);
        pi0Var.a(ky3.class, d04.a);
        pi0Var.a(jy3.class, e04.a);
        pi0Var.a(ty3.class, n04.a);
        pi0Var.a(ry3.class, p04.a);
        pi0Var.a(ny3.class, f04.a);
        pi0Var.a(my3.class, g04.a);
        pi0Var.a(fz3.class, z04.a);
        pi0Var.a(ez3.class, b14.a);
        pi0Var.a(mz3.class, f14.a);
        pi0Var.a(kz3.class, g14.a);
        pi0Var.a(uz3.class, m14.a);
        pi0Var.a(tz3.class, n14.a);
        pi0Var.a(pz3.class, h14.a);
        pi0Var.a(oz3.class, i14.a);
        pi0Var.a(sz3.class, j14.a);
        pi0Var.a(qz3.class, k14.a);
        pi0Var.a(cj4.class, e94.a);
        pi0Var.a(oi4.class, j34.a);
        pi0Var.a(wi4.class, n54.a);
        pi0Var.a(ui4.class, l54.a);
        pi0Var.a(qi4.class, d44.a);
        pi0Var.a(aj4.class, c94.a);
        pi0Var.a(yi4.class, a94.a);
        pi0Var.a(ej4.class, g94.a);
        pi0Var.a(si4.class, p44.a);
        pi0Var.a(kj4.class, ga4.a);
        pi0Var.a(ij4.class, ia4.a);
        pi0Var.a(gj4.class, ea4.a);
        pi0Var.a(rh4.class, i94.a);
        pi0Var.a(fd4.class, r44.a);
        pi0Var.a(nd4.class, z44.a);
        pi0Var.a(na4.class, y14.a);
        pi0Var.a(vc4.class, j44.a);
        pi0Var.a(jd4.class, v44.a);
        pi0Var.a(lc4.class, v34.a);
        pi0Var.a(dc4.class, n34.a);
        pi0Var.a(fc4.class, p34.a);
        pi0Var.a(bc4.class, l34.a);
        pi0Var.a(hc4.class, r34.a);
        pi0Var.a(ie4.class, j54.a);
        pi0Var.a(ge4.class, h54.a);
        pi0Var.a(dy3.class, zz3.a);
        pi0Var.a(hi4.class, u94.a);
        pi0Var.a(ki4.class, y94.a);
        pi0Var.a(nz.class, w94.a);
        pi0Var.a(la4.class, u14.a);
        pi0Var.a(ob4.class, z24.a);
        pi0Var.a(mb4.class, x24.a);
        pi0Var.a(kb4.class, v24.a);
        pi0Var.a(oe4.class, y54.a);
        pi0Var.a(se4.class, c64.a);
        pi0Var.a(qe4.class, a64.a);
        pi0Var.a(py3.class, l04.a);
        pi0Var.a(oy3.class, m04.a);
        pi0Var.a(ye4.class, i64.a);
        pi0Var.a(ef4.class, o64.a);
        pi0Var.a(af4.class, k64.a);
        pi0Var.a(cf4.class, m64.a);
        pi0Var.a(bz3.class, r04.a);
        pi0Var.a(az3.class, t04.a);
        pi0Var.a(vh4.class, m94.a);
        pi0Var.a(th4.class, k94.a);
        pi0Var.a(di4.class, q94.a);
        pi0Var.a(fi4.class, s94.a);
        pi0Var.a(uf4.class, e74.a);
        pi0Var.a(dg4.class, k74.a);
        pi0Var.a(wf4.class, g74.a);
        pi0Var.a(bg4.class, i74.a);
        pi0Var.a(iz3.class, c14.a);
        pi0Var.a(hz3.class, d14.a);
        pi0Var.a(xc4.class, l44.a);
        pi0Var.a(pc4.class, f44.a);
        pi0Var.a(gf4.class, q64.a);
        pi0Var.a(kf4.class, u64.a);
        pi0Var.a(if4.class, s64.a);
        pi0Var.a(dz3.class, v04.a);
        pi0Var.a(cz3.class, x04.a);
    }

    public String toString() {
        switch (this.a) {
            case 18:
                return "SharingStarted.Eagerly";
            default:
                return super.toString();
        }
    }
}
