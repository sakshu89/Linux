package defpackage;

import android.content.ClipDescription;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ny2 {
    public final s9 A;
    public boolean B;
    public final m43 a;
    public ua1 d;
    public fq0 g;
    public sy h;
    public s70 i;
    public sx1 j;
    public bw0 k;
    public fo0 l;
    public final ku1 m;
    public final ku1 n;
    public long o;
    public oz2 p;
    public long q;
    public final ku1 r;
    public final ku1 s;
    public int t;
    public ty2 u;
    public s9 v;
    public oz2 w;
    public final ku1 x;
    public final cu2 y;
    public final ly2 z;
    public mp1 b = e63.a;
    public hq0 c = new j(29);
    public final ku1 e = o44.g(new ty2(7, 0, (String) null));
    public q83 f = qs4.k;

    public ny2(m43 m43Var) {
        this.a = m43Var;
        Boolean bool = Boolean.TRUE;
        this.m = o44.g(bool);
        this.n = o44.g(bool);
        this.o = 0L;
        this.q = 0L;
        this.r = o44.g(null);
        this.s = o44.g(null);
        this.t = -1;
        this.u = new ty2(7, 0L, (String) null);
        this.x = o44.g(Boolean.FALSE);
        cu2 cu2Var = new cu2(3, false);
        cu2Var.c = e13.a;
        this.y = cu2Var;
        this.z = new ly2(this);
        this.A = new s9(this);
    }

    public static final wt1 a(ny2 ny2Var) {
        String str;
        oz2 oz2Var;
        be beVarM = ny2Var.m();
        if (beVarM == null || (str = beVarM.b) == null || (oz2Var = ny2Var.w) == null) {
            return null;
        }
        long j = oz2Var.a;
        return new wt1(str, new oz2(hc4.a(ny2Var.b.l((int) (j >> 32)), ny2Var.b.l((int) (j & 4294967295L)))));
    }

    public static final void b(ny2 ny2Var, oz2 oz2Var) {
        be beVarM;
        String str;
        s70 s70Var;
        if (oz2Var == null) {
            return;
        }
        long j = oz2Var.a;
        sx1 sx1Var = ny2Var.j;
        if (sx1Var == null || (beVarM = ny2Var.m()) == null || (str = beVarM.b) == null) {
            return;
        }
        mp1 mp1Var = ny2Var.b;
        long jA = hc4.a(mp1Var.l((int) (j >> 32)), mp1Var.l((int) (j & 4294967295L)));
        if (str.length() <= 0 || oz2.c(jA) || (s70Var = ny2Var.i) == null) {
            return;
        }
        uf4.b(s70Var, null, new i50(sx1Var, str, jA, oz2Var, ny2Var, mp1Var, null), 3);
    }

    public static final long c(ny2 ny2Var, ty2 ty2Var, long j, boolean z, boolean z2, lf2 lf2Var, boolean z3) {
        hz2 hz2VarD;
        long j2;
        jf2 jf2Var;
        boolean z4;
        boolean z5;
        bw0 bw0Var;
        ua1 ua1Var = ny2Var.d;
        if (ua1Var == null || (hz2VarD = ua1Var.d()) == null) {
            return oz2.b;
        }
        mp1 mp1Var = ny2Var.b;
        long j3 = ty2Var.b;
        be beVar = ty2Var.a;
        int i = oz2.c;
        long jA = hc4.a(mp1Var.l((int) (j3 >> 32)), ny2Var.b.l((int) (j3 & 4294967295L)));
        int iB = hz2VarD.b(j, false);
        int i2 = (z2 || z) ? iB : (int) (jA >> 32);
        int i3 = (!z2 || z) ? iB : (int) (jA & 4294967295L);
        s9 s9Var = ny2Var.v;
        int i4 = -1;
        if (z || s9Var == null) {
            j2 = 4294967295L;
        } else {
            j2 = 4294967295L;
            int i5 = ny2Var.t;
            if (i5 != -1) {
                i4 = i5;
            }
        }
        gz2 gz2Var = hz2VarD.a;
        if (z) {
            jf2Var = null;
        } else {
            int i6 = (int) (jA >> 32);
            int i7 = (int) (jA & j2);
            jf2Var = new jf2(new if2(u24.a(gz2Var, i6), i6, 1L), new if2(u24.a(gz2Var, i7), i7, 1L), oz2.g(jA));
        }
        s9 s9Var2 = new s9(z2, jf2Var, new iz(i2, i3, i4, gz2Var));
        if (jf2Var != null && s9Var != null && z2 == s9Var.b) {
            iz izVar = (iz) s9Var.e;
            if (i2 == izVar.b && i3 == izVar.c) {
                return j3;
            }
        }
        ny2Var.v = s9Var2;
        ny2Var.t = iB;
        jf2 jf2VarB = lf2Var.b(s9Var2);
        long jA2 = hc4.a(ny2Var.b.k(jf2VarB.a.b), ny2Var.b.k(jf2VarB.b.b));
        if (oz2.b(jA2, j3)) {
            return j3;
        }
        boolean z6 = oz2.g(jA2) != oz2.g(j3) && oz2.b(hc4.a((int) (jA2 & j2), (int) (jA2 >> 32)), j3);
        boolean z7 = oz2.c(jA2) && oz2.c(j3);
        if (z3 && beVar.b.length() > 0 && !z6 && !z7 && (bw0Var = ny2Var.k) != null) {
            bw0Var.a();
        }
        ny2Var.c.j(e(beVar, jA2));
        ny2Var.w = new oz2(jA2);
        if (!z3) {
            ny2Var.t(!oz2.c(jA2));
        }
        ua1 ua1Var2 = ny2Var.d;
        if (ua1Var2 != null) {
            ua1Var2.q.setValue(Boolean.valueOf(z3));
        }
        ua1 ua1Var3 = ny2Var.d;
        if (ua1Var3 != null) {
            ua1Var3.m.setValue(Boolean.valueOf(!oz2.c(jA2) && yb4.b(ny2Var, true)));
        }
        ua1 ua1Var4 = ny2Var.d;
        if (ua1Var4 != null) {
            if (oz2.c(jA2)) {
                z4 = false;
            } else {
                z4 = false;
                if (yb4.b(ny2Var, false)) {
                    z5 = true;
                }
                ua1Var4.n.setValue(Boolean.valueOf(z5));
            }
            z5 = z4;
            ua1Var4.n.setValue(Boolean.valueOf(z5));
        } else {
            z4 = false;
        }
        ua1 ua1Var5 = ny2Var.d;
        if (ua1Var5 != null) {
            if (oz2.c(jA2) && yb4.b(ny2Var, true)) {
                z4 = true;
            }
            ua1Var5.o.setValue(Boolean.valueOf(z4));
        }
        return jA2;
    }

    public static ty2 e(be beVar, long j) {
        return new ty2(beVar, j, (oz2) null);
    }

    public final yq2 d(boolean z) {
        s70 s70Var = this.i;
        x50 x50Var = null;
        if (s70Var != null) {
            return uf4.b(s70Var, null, new iy2(this, z, x50Var, 0), 1);
        }
        return null;
    }

    public final void f() {
        s70 s70Var = this.i;
        if (s70Var != null) {
            uf4.b(s70Var, null, new gy2(this, null, 1), 1);
        }
    }

    public final void g(jp1 jp1Var) {
        if (!oz2.c(n().b)) {
            ua1 ua1Var = this.d;
            hz2 hz2VarD = ua1Var != null ? ua1Var.d() : null;
            int iE = (jp1Var == null || hz2VarD == null) ? oz2.e(n().b) : this.b.k(hz2VarD.b(jp1Var.a, true));
            ty2 ty2VarA = ty2.a(n(), null, hc4.a(iE, iE), 5);
            this.c.j(ty2VarA);
            this.w = new oz2(ty2VarA.b);
        }
        q((jp1Var == null || n().a.b.length() <= 0) ? rv0.a : rv0.c);
        t(false);
    }

    public final void h(boolean z) {
        fo0 fo0Var;
        ua1 ua1Var = this.d;
        if (ua1Var != null && !ua1Var.b() && (fo0Var = this.l) != null) {
            fo0.a(fo0Var);
        }
        this.u = n();
        t(z);
        q(rv0.b);
    }

    public final jp1 i() {
        return (jp1) this.s.getValue();
    }

    public final boolean j() {
        return ((Boolean) this.m.getValue()).booleanValue();
    }

    public final boolean k() {
        return ((Boolean) this.n.getValue()).booleanValue();
    }

    public final long l(boolean z) {
        hz2 hz2VarD;
        long j;
        ua1 ua1Var = this.d;
        if (ua1Var == null || (hz2VarD = ua1Var.d()) == null) {
            return 9205357640488583168L;
        }
        gz2 gz2Var = hz2VarD.a;
        fl1 fl1Var = gz2Var.b;
        be beVarM = m();
        if (beVarM == null) {
            return 9205357640488583168L;
        }
        if (!g31.a(beVarM.b, gz2Var.a.a.b)) {
            return 9205357640488583168L;
        }
        ty2 ty2VarN = n();
        if (z) {
            long j2 = ty2VarN.b;
            int i = oz2.c;
            j = j2 >> 32;
        } else {
            long j3 = ty2VarN.b;
            int i2 = oz2.c;
            j = j3 & 4294967295L;
        }
        int iL = this.b.l((int) j);
        boolean zG = oz2.g(n().b);
        long j4 = gz2Var.c;
        int iD = fl1Var.d(iL);
        if (iD >= fl1Var.f) {
            return 9205357640488583168L;
        }
        boolean z2 = gz2Var.a(((!z || zG) && (z || !zG)) ? Math.max(iL + (-1), 0) : iL) == gz2Var.g(iL);
        fl1Var.k(iL);
        int length = ((be) fl1Var.a.b).b.length();
        ArrayList arrayList = fl1Var.h;
        au1 au1Var = (au1) arrayList.get(iL == length ? nz.g(arrayList) : qr4.a(iL, arrayList));
        ia iaVar = au1Var.a;
        int iD2 = au1Var.d(iL);
        ez2 ez2Var = iaVar.d;
        return (((long) Float.floatToRawIntBits(ky3.b(fl1Var.b(iD), 0.0f, (int) (j4 & 4294967295L)))) & 4294967295L) | (((long) Float.floatToRawIntBits(ky3.b(z2 ? ez2Var.h(iD2, false) : ez2Var.i(iD2, false), 0.0f, (int) (j4 >> 32)))) << 32);
    }

    public final be m() {
        ua1 ua1Var = this.d;
        if (ua1Var != null) {
            return ua1Var.a.a;
        }
        return null;
    }

    public final ty2 n() {
        return (ty2) this.e.getValue();
    }

    public final void o() throws IllegalAccessException, InvocationTargetException {
        yq2 yq2Var;
        rx2 rx2Var = (rx2) this.y.b;
        if (rx2Var == null || (yq2Var = rx2Var.d0) == null) {
            return;
        }
        yq2Var.e(null);
        rx2Var.d0 = null;
    }

    public final void p() {
        s70 s70Var = this.i;
        if (s70Var != null) {
            uf4.b(s70Var, null, new gy2(this, null, 2), 1);
        }
    }

    public final void q(rv0 rv0Var) {
        ua1 ua1Var = this.d;
        if (ua1Var != null) {
            if (ua1Var.a() == rv0Var) {
                ua1Var = null;
            }
            if (ua1Var != null) {
                ua1Var.k.setValue(rv0Var);
            }
        }
    }

    public final void r() {
        ua1 ua1Var;
        lx2 lx2Var;
        bm2 bm2VarA = i44.a();
        x50 x50Var = null;
        hq0 hq0VarE = bm2VarA != null ? bm2VarA.e() : null;
        bm2 bm2VarB = i44.b(bm2VarA);
        try {
            if (!k() || ((ua1Var = this.d) != null && !((Boolean) ua1Var.q.getValue()).booleanValue())) {
                i44.e(bm2VarA, bm2VarB, hq0VarE);
                return;
            }
            i44.e(bm2VarA, bm2VarB, hq0VarE);
            cu2 cu2Var = this.y;
            if (((e13) cu2Var.c) == e13.a) {
                c11.c("ToolbarRequester is not initialized.");
            }
            rx2 rx2Var = (rx2) cu2Var.b;
            if (rx2Var == null || !rx2Var.w) {
                return;
            }
            yq2 yq2Var = rx2Var.d0;
            if ((yq2Var == null || !yq2Var.c()) && (lx2Var = (lx2) ij4.a(rx2Var, mx2.b)) != null) {
                rx2Var.d0 = uf4.b(rx2Var.w0(), null, new r0(rx2Var, lx2Var, x50Var, 20), 1);
            }
        } catch (Throwable th) {
            i44.e(bm2VarA, bm2VarB, hq0VarE);
            throw th;
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    public final Object s(y50 y50Var) {
        my2 my2Var;
        if (y50Var instanceof my2) {
            my2Var = (my2) y50Var;
            int i = my2Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                my2Var.j = i - Integer.MIN_VALUE;
            } else {
                my2Var = new my2(this, y50Var);
            }
        } else {
            my2Var = new my2(this, y50Var);
        }
        Object objValueOf = my2Var.f;
        int i2 = my2Var.j;
        if (i2 == 0) {
            bz3.g(objValueOf);
            sy syVar = this.h;
            if (syVar != null) {
                my2Var.e = this;
                my2Var.j = 1;
                ClipDescription primaryClipDescription = ((y6) syVar).a.a.getPrimaryClipDescription();
                objValueOf = Boolean.valueOf(primaryClipDescription != null && primaryClipDescription.hasMimeType("text/*"));
                Object obj = t70.a;
                if (objValueOf == obj) {
                    return obj;
                }
            }
            return q43.a;
        }
        if (i2 != 1) {
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        this = my2Var.e;
        bz3.g(objValueOf);
        Boolean bool = (Boolean) objValueOf;
        bool.getClass();
        this.x.setValue(bool);
        return q43.a;
    }

    public final void t(boolean z) {
        ua1 ua1Var = this.d;
        if (ua1Var != null) {
            ua1Var.l.setValue(Boolean.valueOf(z));
        }
        if (z) {
            r();
        } else {
            o();
        }
    }
}
