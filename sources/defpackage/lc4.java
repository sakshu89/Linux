package defpackage;

import com.ibm.icu.text.DateTimePatternGenerator;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class lc4 {
    public static boolean a() {
        try {
            if (r7.s1 == null) {
                r7.s1 = Class.forName("android.os.SystemProperties");
            }
            if (r7.t1 == null) {
                Class cls = r7.s1;
                r7.t1 = cls != null ? cls.getDeclaredMethod("getBoolean", String.class, Boolean.TYPE) : null;
            }
            Method method = r7.t1;
            Object objInvoke = method != null ? method.invoke(null, "debug.layout", Boolean.FALSE) : null;
            return g31.a(objInvoke instanceof Boolean ? (Boolean) objInvoke : null, Boolean.TRUE);
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Code duplicated, block: B:78:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:81:0x0100  */
    /* JADX WARN: Code duplicated, block: B:84:0x010a  */
    /* JADX WARN: Code duplicated, block: B:87:0x0110  */
    /* JADX WARN: Code duplicated, block: B:90:0x0115  */
    public static final yz2 b(yz2 yz2Var, z61 z61Var) {
        long j;
        wy2 wy2Var;
        int i;
        int i2;
        lz2 lz2Var;
        hp2 hp2Var = yz2Var.a;
        uy2 uy2Var = ip2.d;
        uy2 uy2Var2 = hp2Var.a;
        if (uy2Var2.equals(el1.j)) {
            uy2Var2 = ip2.d;
        }
        uy2 uy2Var3 = uy2Var2;
        long j2 = hp2Var.b;
        c03[] c03VarArr = b03.b;
        if ((j2 & 1095216660480L) == 0) {
            j2 = ip2.a;
        }
        long j3 = j2;
        np0 np0Var = hp2Var.c;
        if (np0Var == null) {
            np0Var = np0.c;
        }
        np0 np0Var2 = np0Var;
        lp0 lp0Var = hp2Var.d;
        lp0 lp0Var2 = new lp0(lp0Var != null ? lp0Var.a : 0);
        mp0 mp0Var = hp2Var.e;
        mp0 mp0Var2 = new mp0(mp0Var != null ? mp0Var.a : DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH);
        ev2 ev2Var = hp2Var.f;
        if (ev2Var == null) {
            ev2Var = ev2.a;
        }
        ev2 ev2Var2 = ev2Var;
        String str = hp2Var.g;
        if (str == null) {
            str = "";
        }
        String str2 = str;
        long j4 = hp2Var.h;
        if ((j4 & 1095216660480L) == 0) {
            j4 = ip2.b;
        }
        long j5 = j4;
        rk rkVar = hp2Var.i;
        float f = rkVar != null ? rkVar.a : 0.0f;
        rk rkVar2 = new rk(Float.isNaN(f) ? 0.0f : f);
        vy2 vy2Var = hp2Var.j;
        if (vy2Var == null) {
            vy2Var = vy2.c;
        }
        vy2 vy2Var2 = vy2Var;
        ne1 ne1VarN = hp2Var.k;
        if (ne1VarN == null) {
            ne1 ne1Var = ne1.c;
            ne1VarN = gx1.a.n();
        }
        ne1 ne1Var2 = ne1VarN;
        long j6 = hp2Var.l;
        if (j6 == 16) {
            j6 = ip2.c;
        }
        long j7 = j6;
        sx2 sx2Var = hp2Var.m;
        if (sx2Var == null) {
            sx2Var = sx2.b;
        }
        sx2 sx2Var2 = sx2Var;
        vj2 vj2Var = hp2Var.n;
        if (vj2Var == null) {
            vj2Var = vj2.d;
        }
        vj2 vj2Var2 = vj2Var;
        wm4 wm4Var = hp2Var.o;
        if (wm4Var == null) {
            wm4Var = ql0.a;
        }
        hp2 hp2Var2 = new hp2(uy2Var3, j3, np0Var2, lp0Var2, mp0Var2, ev2Var2, str2, j5, rkVar2, vy2Var2, ne1Var2, j7, sx2Var2, vj2Var2, wm4Var);
        eu1 eu1Var = yz2Var.b;
        int i3 = fu1.b;
        int i4 = eu1Var.a;
        int i5 = 5;
        if (i4 == 0) {
            i4 = 5;
        }
        int i6 = eu1Var.b;
        if (i6 != 3) {
            if (i6 == 0) {
                int iOrdinal = z61Var.ordinal();
                if (iOrdinal == 0) {
                    i6 = 1;
                } else {
                    if (iOrdinal != 1) {
                        dk0.l();
                        return null;
                    }
                    i5 = 2;
                }
            }
            j = eu1Var.c;
            if ((j & 1095216660480L) == 0) {
                j = fu1.a;
            }
            wy2Var = eu1Var.d;
            if (wy2Var == null) {
                wy2Var = wy2.c;
            }
            nx1 nx1Var = eu1Var.e;
            bc1 bc1Var = eu1Var.f;
            i = eu1Var.g;
            if (i == 0) {
                i = wb1.b;
            }
            i2 = eu1Var.h;
            if (i2 == 0) {
                i2 = 1;
            }
            lz2Var = eu1Var.i;
            if (lz2Var == null) {
                lz2Var = lz2.c;
            }
            return new yz2(hp2Var2, new eu1(i4, i6, j, wy2Var, nx1Var, bc1Var, i, i2, lz2Var), yz2Var.c);
        }
        int iOrdinal2 = z61Var.ordinal();
        if (iOrdinal2 == 0) {
            i5 = 4;
        } else if (iOrdinal2 != 1) {
            dk0.l();
            return null;
        }
        i6 = i5;
        j = eu1Var.c;
        if ((j & 1095216660480L) == 0) {
            j = fu1.a;
        }
        wy2Var = eu1Var.d;
        if (wy2Var == null) {
            wy2Var = wy2.c;
        }
        nx1 nx1Var2 = eu1Var.e;
        bc1 bc1Var2 = eu1Var.f;
        i = eu1Var.g;
        if (i == 0) {
            i = wb1.b;
        }
        i2 = eu1Var.h;
        if (i2 == 0) {
            i2 = 1;
        }
        lz2Var = eu1Var.i;
        if (lz2Var == null) {
            lz2Var = lz2.c;
        }
        return new yz2(hp2Var2, new eu1(i4, i6, j, wy2Var, nx1Var2, bc1Var2, i, i2, lz2Var), yz2Var.c);
    }
}
