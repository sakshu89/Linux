package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class sz3 {
    public static final gu1 a(x20 x20Var) {
        Object objL = x20Var.L();
        xy xyVar = r20.a;
        if (objL == xyVar) {
            objL = new gu1(0.0f);
            x20Var.g0(objL);
        }
        gu1 gu1Var = (gu1) objL;
        ob1 ob1Var = (ob1) x20Var.j(ie1.a);
        boolean zH = x20Var.h(ob1Var);
        Object objL2 = x20Var.L();
        if (zH || objL2 == xyVar) {
            objL2 = new p0(gu1Var, ob1Var, null, 28);
            x20Var.g0(objL2);
        }
        bz3.c(x20Var, (vq0) objL2, ob1Var);
        return gu1Var;
    }
}
