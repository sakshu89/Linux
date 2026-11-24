package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class dd {
    public static final vq2 a = ie4.d(7, null);

    static {
        Map map = p83.a;
        Float.floatToRawIntBits(1.0f);
        Float.floatToRawIntBits(1.0f);
        Float.floatToRawIntBits(1.0f);
        Float.floatToRawIntBits(1.0f);
    }

    public static final gr2 a(float f, f33 f33Var, String str, x20 x20Var) {
        pd pdVar;
        Float fValueOf = Float.valueOf(0.01f);
        if (f33Var == a) {
            x20Var.W(1144089983);
            boolean zC = x20Var.c(0.01f);
            Object objL = x20Var.L();
            if (zC || objL == r20.a) {
                objL = ie4.d(3, fValueOf);
                x20Var.g0(objL);
            }
            x20Var.p(false);
            pdVar = (vq2) objL;
        } else {
            x20Var.W(1144199909);
            x20Var.p(false);
            pdVar = f33Var;
        }
        return b(Float.valueOf(f), eb4.a, pdVar, fValueOf, str, x20Var, 24576, 0);
    }

    public static final gr2 b(Object obj, g33 g33Var, pd pdVar, Float f, String str, x20 x20Var, int i, int i2) {
        if ((i2 & 8) != 0) {
            f = null;
        }
        Object objL = x20Var.L();
        Object obj2 = r20.a;
        if (objL == obj2) {
            objL = o44.g(null);
            x20Var.g0(objL);
        }
        mm1 mm1Var = (mm1) objL;
        Object objL2 = x20Var.L();
        if (objL2 == obj2) {
            objL2 = new bd(obj, g33Var, f);
            x20Var.g0(objL2);
        }
        bd bdVar = (bd) objL2;
        Object objH = o44.h(null, x20Var);
        if (f != null && (pdVar instanceof vq2)) {
            vq2 vq2Var = (vq2) pdVar;
            if (!g31.a(vq2Var.c, f)) {
                pdVar = new vq2(vq2Var.a, vq2Var.b, f);
            }
        }
        Object objH2 = o44.h(pdVar, x20Var);
        Object objL3 = x20Var.L();
        if (objL3 == obj2) {
            objL3 = nh4.a(-1, 6, null);
            x20Var.g0(objL3);
        }
        Object obj3 = (bx) objL3;
        boolean zH = x20Var.h(obj3) | x20Var.h(obj);
        Object objL4 = x20Var.L();
        if (zH || objL4 == obj2) {
            objL4 = new zb(1, obj3, obj);
            x20Var.g0(objL4);
        }
        bz3.d((fq0) objL4, x20Var);
        boolean zH2 = x20Var.h(obj3) | x20Var.h(bdVar) | x20Var.f(objH2) | x20Var.f(objH);
        Object objL5 = x20Var.L();
        if (zH2 || objL5 == obj2) {
            Object cdVar = new cd(obj3, bdVar, objH2, objH, (x50) null, 0);
            x20Var.g0(cdVar);
            objL5 = cdVar;
        }
        bz3.c(x20Var, (vq0) objL5, obj3);
        gr2 gr2Var = (gr2) mm1Var.getValue();
        return gr2Var == null ? bdVar.c : gr2Var;
    }
}
