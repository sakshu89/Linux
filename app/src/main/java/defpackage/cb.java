package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cb extends k61 implements vq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ yy1 c;
    public final /* synthetic */ mm1 e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ cb(yy1 yy1Var, mm1 mm1Var, int i) {
        super(2);
        this.b = i;
        this.c = yy1Var;
        this.e = mm1Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.b;
        q43 q43Var = q43.a;
        mm1 mm1Var = this.e;
        yy1 yy1Var = this.c;
        int i2 = 0;
        switch (i) {
            case 0:
                x20 x20Var = (x20) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (!x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                    x20Var.R();
                } else {
                    Object objL = x20Var.L();
                    xy xyVar = r20.a;
                    if (objL == xyVar) {
                        objL = j7.n;
                        x20Var.g0(objL);
                    }
                    ek1 ek1VarA = dg2.a(bk1.a, (hq0) objL);
                    boolean zH = x20Var.h(yy1Var);
                    Object objL2 = x20Var.L();
                    if (zH || objL2 == xyVar) {
                        objL2 = new za(yy1Var, 1);
                        x20Var.g0(objL2);
                    }
                    ek1 ek1VarC = ek1VarA.c(new iq1((hq0) objL2));
                    float f = yy1Var.getCanCalculatePosition() ? 1.0f : 0.0f;
                    if (f != 1.0f) {
                        ek1VarC = pz3.c(ek1VarC, f, null, 520187);
                    }
                    m30 m30Var = fb.a;
                    vq0 vq0Var = (vq0) mm1Var.getValue();
                    Object objL3 = x20Var.L();
                    if (objL3 == xyVar) {
                        objL3 = eb.b;
                        x20Var.g0(objL3);
                    }
                    oh1 oh1Var = (oh1) objL3;
                    int iHashCode = Long.hashCode(x20Var.T);
                    gw1 gw1VarL = x20Var.l();
                    ek1 ek1VarC2 = gj4.c(x20Var, ek1VarC);
                    o20.p.getClass();
                    k30 k30Var = n20.b;
                    x20Var.Z();
                    if (x20Var.S) {
                        x20Var.k(k30Var);
                    } else {
                        x20Var.j0();
                    }
                    ie4.c(x20Var, n20.f, oh1Var);
                    ie4.c(x20Var, n20.e, gw1VarL);
                    ie4.a(x20Var, Integer.valueOf(iHashCode), n20.g);
                    ie4.b(x20Var, n20.h);
                    ie4.c(x20Var, n20.d, ek1VarC2);
                    vq0Var.e(x20Var, 0);
                    x20Var.p(true);
                }
                break;
            default:
                x20 x20Var2 = (x20) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                if (!x20Var2.O(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    x20Var2.R();
                } else {
                    kj4.a(fb.b.a(Boolean.TRUE), yi4.b(1022273628, new cb(yy1Var, mm1Var, i2), x20Var2), x20Var2, 56);
                }
                break;
        }
        return q43Var;
    }
}
