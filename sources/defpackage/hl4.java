package defpackage;

import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class hl4 {
    /* JADX WARN: Multi-variable type inference failed */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r7v25 ??
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.ModVisitor.anonymousCallArgMod(ModVisitor.java:535)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.ModVisitor.processAnonymousConstructor(ModVisitor.java:528)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:111)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    public static final void a(final defpackage.ty2 r69, final defpackage.hq0 r70, final defpackage.ek1 r71, final defpackage.yz2 r72, final defpackage.q83 r73, final defpackage.hq0 r74, final defpackage.cn2 r75, final boolean r76, final int r77, final int r78, final defpackage.kz0 r79, final defpackage.t51 r80, final boolean r81, final defpackage.w10 r82, defpackage.x20 r83, final int r84, final int r85) {
        /*
            Method dump skipped, instruction units count: 2705
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hl4.a(ty2, hq0, ek1, yz2, q83, hq0, cn2, boolean, int, int, kz0, t51, boolean, w10, x20, int, int):void");
    }

    public static final void b(ek1 ek1Var, ny2 ny2Var, w10 w10Var, x20 x20Var, int i) {
        x20Var.X(2036174316);
        int i2 = (x20Var.f(ek1Var) ? 4 : 2) | i | (x20Var.h(ny2Var) ? 32 : 16);
        if (x20Var.O(i2 & 1, (i2 & 147) != 146)) {
            oh1 oh1VarD = gm.d(xy.b, true);
            int iHashCode = Long.hashCode(x20Var.T);
            gw1 gw1VarL = x20Var.l();
            ek1 ek1VarC = gj4.c(x20Var, ek1Var);
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
            cl4.a(ny2Var, w10Var, x20Var, (i2 >> 3) & 126);
            x20Var.p(true);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new ic(ek1Var, ny2Var, w10Var, i, 2);
        }
    }

    public static final void c(ny2 ny2Var, boolean z, x20 x20Var, int i) {
        hz2 hz2VarD;
        x20Var.X(626339208);
        int i2 = (x20Var.h(ny2Var) ? 4 : 2) | i | (x20Var.g(z) ? 32 : 16);
        if (!x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            x20Var.R();
        } else if (z) {
            x20Var.W(1530097388);
            ua1 ua1Var = ny2Var.d;
            gz2 gz2Var = null;
            if (ua1Var != null && (hz2VarD = ua1Var.d()) != null) {
                gz2 gz2Var2 = hz2VarD.a;
                ua1 ua1Var2 = ny2Var.d;
                if (!(ua1Var2 != null ? ua1Var2.p : true)) {
                    gz2Var = gz2Var2;
                }
            }
            if (gz2Var == null) {
                x20Var.W(1530097387);
            } else {
                x20Var.W(1530097388);
                if (oz2.c(ny2Var.n().b)) {
                    x20Var.W(2062097806);
                } else {
                    x20Var.W(2109807302);
                    int iL = ny2Var.b.l((int) (ny2Var.n().b >> 32));
                    int iL2 = ny2Var.b.l((int) (ny2Var.n().b & 4294967295L));
                    p62 p62VarA = gz2Var.a(iL);
                    p62 p62VarA2 = gz2Var.a(Math.max(iL2 - 1, 0));
                    ua1 ua1Var3 = ny2Var.d;
                    if (ua1Var3 == null || !((Boolean) ua1Var3.m.getValue()).booleanValue()) {
                        x20Var.W(2062097806);
                    } else {
                        x20Var.W(2110225306);
                        wb4.a(true, p62VarA, ny2Var, x20Var, ((i2 << 6) & 896) | 6);
                    }
                    x20Var.p(false);
                    ua1 ua1Var4 = ny2Var.d;
                    if (ua1Var4 == null || !((Boolean) ua1Var4.n.getValue()).booleanValue()) {
                        x20Var.W(2062097806);
                    } else {
                        x20Var.W(2110574459);
                        wb4.a(false, p62VarA2, ny2Var, x20Var, ((i2 << 6) & 896) | 6);
                    }
                    x20Var.p(false);
                }
                x20Var.p(false);
                ua1 ua1Var5 = ny2Var.d;
                if (ua1Var5 != null) {
                    ku1 ku1Var = ua1Var5.l;
                    if (!g31.a(ny2Var.u.a.b, ny2Var.n().a.b)) {
                        ku1Var.setValue(Boolean.FALSE);
                    }
                    if (ua1Var5.b()) {
                        if (((Boolean) ku1Var.getValue()).booleanValue()) {
                            ny2Var.r();
                        } else {
                            ny2Var.o();
                        }
                    }
                }
            }
            x20Var.p(false);
            x20Var.p(false);
        } else {
            x20Var.W(1989076778);
            x20Var.p(false);
            ny2Var.o();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new ik(ny2Var, z, i);
        }
    }

    public static final void d(ny2 ny2Var, x20 x20Var, int i) {
        be beVarM;
        x20Var.X(-1436003720);
        int i2 = 2;
        int i3 = (x20Var.h(ny2Var) ? 4 : 2) | i;
        if (x20Var.O(i3 & 1, (i3 & 3) != 2)) {
            ua1 ua1Var = ny2Var.d;
            if (ua1Var == null || !((Boolean) ua1Var.o.getValue()).booleanValue() || (beVarM = ny2Var.m()) == null || beVarM.b.length() <= 0) {
                x20Var.W(2132946858);
            } else {
                x20Var.W(-2112351432);
                boolean zF = x20Var.f(ny2Var);
                Object objL = x20Var.L();
                Object obj = r20.a;
                if (zF || objL == obj) {
                    objL = new jy2(ny2Var);
                    x20Var.g0(objL);
                }
                wx2 wx2Var = (wx2) objL;
                jc0 jc0Var = (jc0) x20Var.j(l30.h);
                mp1 mp1Var = ny2Var.b;
                long j = ny2Var.n().b;
                int i4 = oz2.c;
                int iL = mp1Var.l((int) (j >> 32));
                ua1 ua1Var2 = ny2Var.d;
                hz2 hz2VarD = ua1Var2 != null ? ua1Var2.d() : null;
                hz2VarD.getClass();
                gz2 gz2Var = hz2VarD.a;
                l42 l42VarC = gz2Var.c(ky3.c(iL, 0, gz2Var.a.a.b.length()));
                long jFloatToRawIntBits = (((long) Float.floatToRawIntBits((jc0Var.x(2.0f) / 2.0f) + l42VarC.a)) << 32) | (((long) Float.floatToRawIntBits(l42VarC.d)) & 4294967295L);
                boolean zE = x20Var.e(jFloatToRawIntBits);
                Object objL2 = x20Var.L();
                if (zE || objL2 == obj) {
                    objL2 = new x60(jFloatToRawIntBits);
                    x20Var.g0(objL2);
                }
                op1 op1Var = (op1) objL2;
                boolean zH = x20Var.h(wx2Var) | x20Var.h(ny2Var);
                Object objL3 = x20Var.L();
                if (zH || objL3 == obj) {
                    objL3 = new a70(wx2Var, ny2Var);
                    x20Var.g0(objL3);
                }
                ek1 ek1VarA = pu2.a(bk1.a, wx2Var, (PointerInputEventHandler) objL3);
                boolean zE2 = x20Var.e(jFloatToRawIntBits);
                Object objL4 = x20Var.L();
                if (zE2 || objL4 == obj) {
                    objL4 = new x8(i2, jFloatToRawIntBits);
                    x20Var.g0(objL4);
                }
                z8.a(op1Var, dg2.a(ek1VarA, (hq0) objL4), 0L, x20Var, 0);
            }
            x20Var.p(false);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new ha(ny2Var, i, i2);
        }
    }

    public static final void e(ua1 ua1Var) {
        bz2 bz2Var = ua1Var.e;
        if (bz2Var != null) {
            ua1Var.v.j(ty2.a((ty2) ua1Var.d.b, null, 0L, 3));
            xy2 xy2Var = bz2Var.a;
            AtomicReference atomicReference = xy2Var.b;
            while (!atomicReference.compareAndSet(bz2Var, null)) {
                if (atomicReference.get() != bz2Var) {
                }
            }
            xy2Var.a.f();
        }
        ua1Var.e = null;
    }

    public static final void f(ua1 ua1Var, ty2 ty2Var, mp1 mp1Var) {
        bm2 bm2VarA = i44.a();
        hq0 hq0VarE = bm2VarA != null ? bm2VarA.e() : null;
        bm2 bm2VarB = i44.b(bm2VarA);
        try {
            hz2 hz2VarD = ua1Var.d();
            if (hz2VarD == null) {
                return;
            }
            bz2 bz2Var = ua1Var.e;
            if (bz2Var == null) {
                return;
            }
            y61 y61VarC = ua1Var.c();
            if (y61VarC == null) {
                return;
            }
            qb4.a(ty2Var, ua1Var.a, hz2VarD.a, y61VarC, bz2Var, ua1Var.b(), mp1Var);
        } finally {
            i44.e(bm2VarA, bm2VarB, hq0VarE);
        }
    }

    public static final void g(xy2 xy2Var, ua1 ua1Var, ty2 ty2Var, kz0 kz0Var, mp1 mp1Var) {
        l11 l11Var = ua1Var.d;
        q60 q60Var = ua1Var.v;
        q60 q60Var2 = ua1Var.w;
        t42 t42Var = new t42();
        e2 e2Var = new e2(l11Var, q60Var, t42Var, 12);
        by1 by1Var = xy2Var.a;
        by1Var.h(ty2Var, kz0Var, e2Var, q60Var2);
        bz2 bz2Var = new bz2(xy2Var, by1Var);
        xy2Var.b.set(bz2Var);
        t42Var.a = bz2Var;
        ua1Var.e = bz2Var;
        f(ua1Var, ty2Var, mp1Var);
    }
}
