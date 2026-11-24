package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ho implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ w10 b;
    public final /* synthetic */ Object c;

    public /* synthetic */ ho(int i, w10 w10Var, Object obj) {
        this.a = i;
        this.c = obj;
        this.b = w10Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        w10 w10Var = this.b;
        Object obj3 = this.c;
        switch (i) {
            case 0:
                x20 x20Var = (x20) obj;
                int iIntValue = ((Number) obj2).intValue();
                if (!x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                    x20Var.R();
                } else {
                    ek1 ek1VarC = w44.a(bk1.a, bo.b, bo.c).c(new pt1((qt1) obj3));
                    e92 e92VarA = d92.a(jg1.e, xy.u, x20Var, 54);
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
                    ie4.c(x20Var, n20.f, e92VarA);
                    ie4.c(x20Var, n20.e, gw1VarL);
                    jd jdVar = n20.g;
                    if (x20Var.S || !g31.a(x20Var.L(), Integer.valueOf(iHashCode))) {
                        x20Var.g0(Integer.valueOf(iHashCode));
                        x20Var.b(jdVar, Integer.valueOf(iHashCode));
                    }
                    ie4.c(x20Var, n20.d, ek1VarC2);
                    w10Var.c(g92.a, x20Var, 6);
                    x20Var.p(true);
                }
                break;
            default:
                x20 x20Var2 = (x20) obj;
                int iIntValue2 = ((Number) obj2).intValue();
                if (!x20Var2.O(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    x20Var2.R();
                } else {
                    dz2.a(((v33) obj3).j, w10Var, x20Var2, 0);
                }
                break;
        }
        return q43Var;
    }
}
