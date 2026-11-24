package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class w8 implements wq0 {
    public final /* synthetic */ int a;

    public /* synthetic */ w8(int i) {
        this.a = i;
    }

    @Override // defpackage.wq0
    public final Object c(Object obj, Object obj2, Object obj3) {
        int i = this.a;
        bk1 bk1Var = bk1.a;
        q43 q43Var = q43.a;
        boolean z = false;
        switch (i) {
            case 0:
                ek1 ek1Var = (ek1) obj;
                x20 x20Var = (x20) obj2;
                ((Integer) obj3).getClass();
                x20Var.W(-2126899193);
                long j = ((sz2) x20Var.j(tz2.a)).a;
                boolean zE = x20Var.e(j);
                Object objL = x20Var.L();
                if (zE || objL == r20.a) {
                    objL = new x8(z ? 1 : 0, j);
                    x20Var.g0(objL);
                }
                ek1 ek1VarC = ek1Var.c(az3.b(bk1Var, (hq0) objL));
                x20Var.p(false);
                return ek1VarC;
            case 1:
                q50 q50Var = (q50) obj;
                x20 x20Var2 = (x20) obj2;
                int iIntValue = ((Integer) obj3).intValue();
                if ((iIntValue & 6) == 0) {
                    iIntValue |= x20Var2.f(q50Var) ? 4 : 2;
                }
                if (x20Var2.O(iIntValue & 1, (iIntValue & 19) != 18)) {
                    gm.a(kg1.a(w44.c(w44.b(c34.e(bk1Var, 0.0f, s50.g, 1), 1.0f), s50.f), q50Var.c, y34.a), x20Var2, 0);
                } else {
                    x20Var2.R();
                }
                return q43Var;
            case 2:
                x20 x20Var3 = (x20) obj2;
                int iIntValue2 = ((Integer) obj3).intValue();
                ((f92) obj).getClass();
                if (x20Var3.O(iIntValue2 & 1, (iIntValue2 & 17) != 16)) {
                    dz2.b("Yes", null, 0L, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var3.j(w33.a)).m, x20Var3, 6, 0, 131070);
                } else {
                    x20Var3.R();
                }
                return q43Var;
            default:
                x20 x20Var4 = (x20) obj2;
                int iIntValue3 = ((Integer) obj3).intValue();
                ((f92) obj).getClass();
                if (x20Var4.O(iIntValue3 & 1, (iIntValue3 & 17) != 16)) {
                    dz2.b("No", null, 0L, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var4.j(w33.a)).m, x20Var4, 6, 0, 131070);
                } else {
                    x20Var4.R();
                }
                return q43Var;
        }
    }
}
