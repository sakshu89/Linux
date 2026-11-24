package defpackage;

import android.R;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ba0 {
    public static final int[] a = {R.attr.name, R.attr.tint, R.attr.height, R.attr.width, R.attr.alpha, R.attr.autoMirrored, R.attr.tintMode, R.attr.viewportWidth, R.attr.viewportHeight};
    public static final int[] b = {R.attr.name, R.attr.pivotX, R.attr.pivotY, R.attr.scaleX, R.attr.scaleY, R.attr.rotation, R.attr.translateX, R.attr.translateY};
    public static final int[] c = {R.attr.name, R.attr.fillColor, R.attr.pathData, R.attr.strokeColor, R.attr.strokeWidth, R.attr.trimPathStart, R.attr.trimPathEnd, R.attr.trimPathOffset, R.attr.strokeLineCap, R.attr.strokeLineJoin, R.attr.strokeMiterLimit, R.attr.strokeAlpha, R.attr.fillAlpha, R.attr.fillType};
    public static final int[] d = {R.attr.name, R.attr.pathData};

    public static final void a(ek1 ek1Var, w10 w10Var, x20 x20Var, int i) {
        int i2;
        ek1 ek1Var2;
        w10 w10Var2;
        x20Var.X(790527681);
        int i3 = 4;
        if ((i & 6) == 0) {
            i2 = (x20Var.f(ek1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.h(w10Var) ? 32 : 16;
        }
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            Object objL = x20Var.L();
            xy xyVar = r20.a;
            if (objL == xyVar) {
                ku1 ku1Var = new ku1(null, el1.f);
                x20Var.g0(ku1Var);
                objL = ku1Var;
            }
            mm1 mm1Var = (mm1) objL;
            Object objL2 = x20Var.L();
            if (objL2 == xyVar) {
                objL2 = new hc(mm1Var, 5);
                x20Var.g0(objL2);
            }
            fq0 fq0Var = (fq0) objL2;
            bz1 bz1Var = jb0.a;
            wk wkVarB = cf4.b(fy3.b, x20Var, 6);
            ek1Var2 = ek1Var;
            w10Var2 = w10Var;
            kj4.b(new a22[]{mx2.b.a(ce4.f(fq0Var, x20Var, 2)), mx2.a.a(wkVarB)}, yi4.b(1070596993, new bg1(ek1Var2, mm1Var, w10Var2, wkVarB, fq0Var, 1), x20Var), x20Var, 56);
        } else {
            ek1Var2 = ek1Var;
            w10Var2 = w10Var;
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new gc(ek1Var2, w10Var2, i, i3);
        }
    }

    public static final void b(ek1 ek1Var, w10 w10Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(155925518);
        if ((i & 6) == 0) {
            i2 = (x20Var.f(ek1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.h(w10Var) ? 32 : 16;
        }
        int i3 = 3;
        if (x20Var.O(i2 & 1, (i2 & 19) != 18)) {
            boolean z = x20Var.j(mx2.a) != null;
            boolean z2 = x20Var.j(mx2.b) != null;
            if (z && z2) {
                x20Var.W(-1977187922);
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
                w10Var.e(x20Var, Integer.valueOf((i2 >> 3) & 14));
                x20Var.p(true);
                x20Var.p(false);
            } else if (z) {
                x20Var.W(-1976997706);
                ce4.a(ek1Var, w10Var, x20Var, i2 & 126);
                x20Var.p(false);
            } else if (z2) {
                x20Var.W(-1976846922);
                jb0.d(ek1Var, w10Var, x20Var, i2 & 126);
                x20Var.p(false);
            } else {
                x20Var.W(-1976716505);
                a(ek1Var, w10Var, x20Var, i2 & 126);
                x20Var.p(false);
            }
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new gc(ek1Var, w10Var, i, i3);
        }
    }

    public static final String c(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final String d(x50 x50Var) {
        Object h72Var;
        if (x50Var instanceof hd0) {
            return ((hd0) x50Var).toString();
        }
        try {
            h72Var = x50Var + '@' + c(x50Var);
        } catch (Throwable th) {
            h72Var = new h72(th);
        }
        if (i72.a(h72Var) != null) {
            h72Var = x50Var.getClass().getName() + '@' + c(x50Var);
        }
        return (String) h72Var;
    }
}
