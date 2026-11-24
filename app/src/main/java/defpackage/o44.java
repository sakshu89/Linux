package defpackage;

import android.graphics.Rect;
import android.graphics.Region;
import android.os.Trace;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class o44 {
    public static final l42 a = new l42(0.0f, 0.0f, 10.0f, 10.0f);

    public static final pm1 a() {
        kf kfVar = pm2.b;
        pm1 pm1Var = (pm1) kfVar.l();
        if (pm1Var != null) {
            return pm1Var;
        }
        pm1 pm1Var2 = new pm1(new w20[0]);
        kfVar.C(pm1Var2);
        return pm1Var2;
    }

    public static final qc0 b(fq0 fq0Var) {
        kf kfVar = pm2.a;
        return new qc0(fq0Var, null);
    }

    public static final ml1 c(jg2 jg2Var, hq0 hq0Var) {
        Trace.beginSection("getAllUncoveredSemanticsNodesToIntObjectMap");
        try {
            gg2 gg2VarA = jg2Var.a();
            n71 n71Var = gg2VarA.c;
            if (n71Var.I() && n71Var.H()) {
                ml1 ml1Var = new ml1(48);
                wj1 wj1Var = new wj1(7);
                i21 i21VarA = bp4.a(gg2VarA.g());
                ((Region) wj1Var.b).set(i21VarA.a, i21VarA.b, i21VarA.c, i21VarA.d);
                d(wj1Var, gg2VarA, ml1Var, hq0Var, gg2VarA, new wj1(7));
                return ml1Var;
            }
            ml1 ml1Var2 = d21.a;
            ml1Var2.getClass();
            return ml1Var2;
        } finally {
            Trace.endSection();
        }
    }

    public static final void d(wj1 wj1Var, gg2 gg2Var, ml1 ml1Var, hq0 hq0Var, gg2 gg2Var2, wj1 wj1Var2) {
        l42 l42VarQ1;
        n71 n71Var;
        gg2 gg2Var3 = gg2Var;
        int i = gg2Var3.g;
        wj1 wj1Var3 = wj1Var2;
        Region region = (Region) wj1Var3.b;
        n71 n71Var2 = gg2Var2.c;
        int i2 = gg2Var2.g;
        boolean z = (n71Var2.I() && n71Var2.H()) ? false : true;
        wj1 wj1Var4 = wj1Var;
        Region region2 = (Region) wj1Var4.b;
        if (!region2.isEmpty() || i2 == i) {
            if (!z || gg2Var2.e) {
                xb0 xb0VarF = gg2Var2.f();
                if (xb0VarF == null) {
                    l42VarQ1 = n71Var2.o0.c.q1();
                } else {
                    dk1 dk1Var = ((dk1) xb0VarF).a;
                    Object objG = gg2Var2.d.a.g(bg2.b);
                    if (objG == null) {
                        objG = null;
                    }
                    boolean z2 = objG != null;
                    if (!dk1Var.a.w) {
                        l42VarQ1 = l42.e;
                    } else if (z2) {
                        l42VarQ1 = cm4.e(dk1Var, 8).q1();
                    } else {
                        co1 co1VarE = cm4.e(dk1Var, 8);
                        l42VarQ1 = pp4.c(co1VarE).N(co1VarE, true);
                    }
                }
                i21 i21VarA = bp4.a(l42VarQ1);
                region.set(i21VarA.a, i21VarA.b, i21VarA.c, i21VarA.d);
                if (i2 == i) {
                    i2 = -1;
                }
                if (!region.op(region2, Region.Op.INTERSECT)) {
                    if (gg2Var2.e) {
                        gg2 gg2VarL = gg2Var2.l();
                        ml1Var.h(i2, new ig2(gg2Var2, bp4.a((gg2VarL == null || (n71Var = gg2VarL.c) == null || !n71Var.I()) ? a : gg2VarL.g())));
                        return;
                    } else {
                        if (i2 == -1) {
                            Rect bounds = region.getBounds();
                            ml1Var.h(i2, new ig2(gg2Var2, new i21(bounds.left, bounds.top, bounds.right, bounds.bottom)));
                            return;
                        }
                        return;
                    }
                }
                Rect bounds2 = region.getBounds();
                ml1Var.h(i2, new ig2(gg2Var2, new i21(bounds2.left, bounds2.top, bounds2.right, bounds2.bottom)));
                List listI = gg2Var2.i((4 & 1) != 0 ? !gg2Var2.b : false, (4 & 2) == 0);
                int size = listI.size() - 1;
                while (-1 < size) {
                    if (!((Boolean) hq0Var.j(listI.get(size))).booleanValue()) {
                        d(wj1Var4, gg2Var3, ml1Var, hq0Var, (gg2) listI.get(size), wj1Var3);
                    }
                    size--;
                    wj1Var4 = wj1Var;
                    gg2Var3 = gg2Var;
                    wj1Var3 = wj1Var2;
                }
                if (f(gg2Var2)) {
                    region2.op(i21VarA.a, i21VarA.b, i21VarA.c, i21VarA.d, Region.Op.DIFFERENCE);
                }
            }
        }
    }

    public static final boolean e(gg2 gg2Var) {
        co1 co1VarD = gg2Var.d();
        gm1 gm1Var = gg2Var.d.a;
        return (co1VarD != null ? co1VarD.d1() : false) || gm1Var.c(kg2.p) || gm1Var.c(kg2.o);
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0054 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x0056 A[LOOP:0: B:9:0x001b->B:21:0x0056, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:27:0x005b A[SYNTHETIC] */
    public static final boolean f(gg2 gg2Var) {
        if (!e(gg2Var)) {
            cg2 cg2Var = gg2Var.d;
            if (cg2Var.c) {
                return true;
            }
            gm1 gm1Var = cg2Var.a;
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
                                Object obj = objArr[i4];
                                Object obj2 = objArr2[i4];
                                if (((ng2) obj).c) {
                                    return true;
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
        }
        return false;
    }

    public static ku1 g(Object obj) {
        return new ku1(obj, su0.k);
    }

    public static final mm1 h(Object obj, x20 x20Var) {
        Object objL = x20Var.L();
        if (objL == r20.a) {
            objL = g(obj);
            x20Var.g0(objL);
        }
        mm1 mm1Var = (mm1) objL;
        mm1Var.setValue(obj);
        return mm1Var;
    }
}
