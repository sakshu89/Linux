package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class xk implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;
    public final /* synthetic */ Object f;

    public /* synthetic */ xk(fq0 fq0Var, ek1 ek1Var, f91 f91Var, w91 w91Var, int i) {
        this.a = 1;
        this.c = fq0Var;
        this.b = ek1Var;
        this.e = f91Var;
        this.f = w91Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        xy xyVar = r20.a;
        q43 q43Var = q43.a;
        Object obj3 = this.f;
        Object obj4 = this.e;
        Object obj5 = this.c;
        Object obj6 = this.b;
        switch (i) {
            case 0:
                ek1 ek1Var = (ek1) obj6;
                mm1 mm1Var = (mm1) obj5;
                w10 w10Var = (w10) obj4;
                wk wkVar = (wk) obj3;
                x20 x20Var = (x20) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                    Object objL = x20Var.L();
                    if (objL == xyVar) {
                        objL = new jc(mm1Var, 1);
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
                    Object objL2 = x20Var.L();
                    if (objL2 == xyVar) {
                        objL2 = new hc(mm1Var, 1);
                        x20Var.g0(objL2);
                    }
                    wkVar.b((fq0) objL2, x20Var, 6);
                    x20Var.p(true);
                } else {
                    x20Var.R();
                }
                break;
            case 1:
                ((Integer) obj2).getClass();
                bq4.a((fq0) obj5, (ek1) obj6, (f91) obj4, (w91) obj3, (x20) obj, ny3.c(1));
                break;
            default:
                qj2 qj2Var = (qj2) obj6;
                fq0 fq0Var = (fq0) obj5;
                fq0 fq0Var2 = (fq0) obj4;
                hq0 hq0Var = (hq0) obj3;
                x20 x20Var2 = (x20) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                if (x20Var2.O(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    q44.d("SYSTEM SHORTCUTS & SPECIAL ACCESS", x20Var2, 6);
                    bk1 bk1Var = bk1.a;
                    k54.h(x20Var2, w44.c(bk1Var, 8.0f));
                    dz2.b("Configure default assistant role and screen control access.", null, uz.g, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(w33.a)).o, x20Var2, 390, 0, 131066);
                    k54.h(x20Var2, w44.c(bk1Var, 12.0f));
                    q44.a(qj2Var.c, fq0Var, x20Var2, 0);
                    k54.h(x20Var2, w44.c(bk1Var, 8.0f));
                    q44.g("POWER-BUTTON SHORTCUT", fq0Var2, x20Var2, 6);
                    for (op2 op2Var : qj2Var.b) {
                        boolean zF = x20Var2.f(hq0Var) | x20Var2.f(op2Var);
                        Object objL3 = x20Var2.L();
                        if (zF || objL3 == xyVar) {
                            objL3 = new gi2(hq0Var, op2Var, 1);
                            x20Var2.g0(objL3);
                        }
                        q44.h(op2Var, (fq0) objL3, x20Var2, 0);
                    }
                } else {
                    x20Var2.R();
                }
                break;
        }
        return q43Var;
    }

    public /* synthetic */ xk(Object obj, Object obj2, rq0 rq0Var, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.e = rq0Var;
        this.f = obj3;
    }
}
