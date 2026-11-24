package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ic implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;

    public /* synthetic */ ic(eo2 eo2Var, g32 g32Var, ek1 ek1Var, int i) {
        this.a = 4;
        this.e = eo2Var;
        this.c = g32Var;
        this.b = ek1Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        Object obj3 = this.b;
        Object obj4 = this.c;
        Object obj5 = this.e;
        switch (i) {
            case 0:
                ek1 ek1Var = (ek1) obj3;
                mm1 mm1Var = (mm1) obj5;
                w10 w10Var = (w10) obj4;
                x20 x20Var = (x20) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (!x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                    x20Var.R();
                } else {
                    Object objL = x20Var.L();
                    if (objL == r20.a) {
                        objL = new jc(mm1Var, 0);
                        x20Var.g0(objL);
                    }
                    ek1 ek1VarA = w24.a(ek1Var, (hq0) objL);
                    oh1 oh1VarD = gm.d(xy.b, true);
                    int iHashCode = Long.hashCode(x20Var.T);
                    gw1 gw1VarL = x20Var.l();
                    ek1 ek1VarC = gj4.c(x20Var, ek1VarA);
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
                    w10Var.e(x20Var, 0);
                    x20Var.p(true);
                }
                break;
            case 1:
                ((Integer) obj2).getClass();
                qf4.a((ek1) obj3, (c6) obj5, (w10) obj4, (x20) obj, ny3.c(3079));
                break;
            case 2:
                ((Integer) obj2).getClass();
                hl4.b((ek1) obj3, (ny2) obj5, (w10) obj4, (x20) obj, ny3.c(385));
                break;
            case 3:
                q42 q42Var = (q42) obj3;
                he2 he2Var = (he2) obj5;
                float fFloatValue = ((Float) obj).floatValue();
                ((Float) obj2).getClass();
                long jH = he2Var.h(he2Var.d(fFloatValue - q42Var.a));
                he2 he2Var2 = ((fe2) obj4).a;
                q42Var.a += he2Var.d(he2Var.g(he2Var2.c(he2Var2.k, jH, 1)));
                break;
            default:
                ((Integer) obj2).getClass();
                k54.d((eo2) obj5, (g32) obj4, (ek1) obj3, (x20) obj, ny3.c(1));
                break;
        }
        return q43Var;
    }

    public /* synthetic */ ic(ek1 ek1Var, Object obj, w10 w10Var, int i, int i2) {
        this.a = i2;
        this.b = ek1Var;
        this.e = obj;
        this.c = w10Var;
    }

    public /* synthetic */ ic(Object obj, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.e = obj2;
        this.c = obj3;
    }
}
