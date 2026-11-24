package defpackage;

import com.ibm.icu.impl.coll.CollationFastLatin;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class di2 implements vq0 {
    public final /* synthetic */ int a = 0;
    public final /* synthetic */ gj2 b;
    public final /* synthetic */ hq0 c;
    public final /* synthetic */ fq0 e;
    public final /* synthetic */ fq0 f;

    public /* synthetic */ di2(gj2 gj2Var, fq0 fq0Var, fq0 fq0Var2, hq0 hq0Var) {
        this.b = gj2Var;
        this.e = fq0Var;
        this.f = fq0Var2;
        this.c = hq0Var;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i;
        int i2 = this.a;
        q43 q43Var = q43.a;
        switch (i2) {
            case 0:
                x20 x20Var = (x20) obj;
                int iIntValue = ((Integer) obj2).intValue();
                kl klVar = xy.u;
                if (x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                    bk1 bk1Var = bk1.a;
                    ek1 ek1VarE = c34.e(w44.b(bk1Var, 1.0f), 0.0f, 6.0f, 1);
                    bg bgVar = jg1.b;
                    e92 e92VarA = d92.a(bgVar, klVar, x20Var, 48);
                    int iHashCode = Long.hashCode(x20Var.T);
                    gw1 gw1VarL = x20Var.l();
                    ek1 ek1VarC = gj4.c(x20Var, ek1VarE);
                    o20.p.getClass();
                    k30 k30Var = n20.b;
                    x20Var.Z();
                    if (x20Var.S) {
                        x20Var.k(k30Var);
                    } else {
                        x20Var.j0();
                    }
                    jd jdVar = n20.f;
                    ie4.c(x20Var, jdVar, e92VarA);
                    jd jdVar2 = n20.e;
                    ie4.c(x20Var, jdVar2, gw1VarL);
                    Integer numValueOf = Integer.valueOf(iHashCode);
                    jd jdVar3 = n20.g;
                    ie4.a(x20Var, numValueOf, jdVar3);
                    j7 j7Var = n20.h;
                    ie4.b(x20Var, j7Var);
                    jd jdVar4 = n20.d;
                    ie4.c(x20Var, jdVar4, ek1VarC);
                    sr2 sr2Var = w33.a;
                    yz2 yz2Var = ((v33) x20Var.j(sr2Var)).k;
                    long j = uz.e;
                    dz2.b("Default digital assistant", f92.a(), j, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, yz2Var, x20Var, 390, 0, 131064);
                    k54.h(x20Var, w44.g(bk1Var, 8.0f));
                    gj2 gj2Var = this.b;
                    boolean z = gj2Var.t;
                    k34.g(z ? "DEFAULT" : "SET ASSISTANT", z, this.e, x20Var, 0);
                    x20Var.p(true);
                    k54.h(x20Var, w44.c(bk1Var, 12.0f));
                    ek1 ek1VarB = w44.b(bk1Var, 1.0f);
                    e92 e92VarA2 = d92.a(bgVar, klVar, x20Var, 48);
                    int iHashCode2 = Long.hashCode(x20Var.T);
                    gw1 gw1VarL2 = x20Var.l();
                    ek1 ek1VarC2 = gj4.c(x20Var, ek1VarB);
                    x20Var.Z();
                    if (x20Var.S) {
                        x20Var.k(k30Var);
                    } else {
                        x20Var.j0();
                    }
                    ie4.c(x20Var, jdVar, e92VarA2);
                    ie4.c(x20Var, jdVar2, gw1VarL2);
                    cq.s(iHashCode2, x20Var, jdVar3, x20Var, j7Var);
                    ie4.c(x20Var, jdVar4, ek1VarC2);
                    dz2.b("Power-button shortcut", f92.a(), j, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var.j(sr2Var)).k, x20Var, 390, 0, 131064);
                    x20 x20Var2 = x20Var;
                    k54.h(x20Var2, w44.g(bk1Var, 8.0f));
                    k34.g("SET UP", false, this.f, x20Var2, 54);
                    x20Var2.p(true);
                    k54.h(x20Var2, w44.c(bk1Var, 12.0f));
                    x20Var2.W(1815729116);
                    for (i92 i92Var : gj2Var.r) {
                        String str = i92Var.b;
                        boolean z2 = i92Var.d;
                        k34.c(str, z2 ? "Allowed" : "Not allowed", z2, x20Var2, 0);
                    }
                    x20Var2.p(false);
                    for (op2 op2Var : gj2Var.s) {
                        ek1 ek1VarE2 = c34.e(w44.b(bk1Var, 1.0f), 0.0f, 6.0f, 1);
                        e92 e92VarA3 = d92.a(bgVar, klVar, x20Var2, 48);
                        int iHashCode3 = Long.hashCode(x20Var2.T);
                        gw1 gw1VarL3 = x20Var2.l();
                        ek1 ek1VarC3 = gj4.c(x20Var2, ek1VarE2);
                        o20.p.getClass();
                        k30 k30Var2 = n20.b;
                        x20Var2.Z();
                        if (x20Var2.S) {
                            x20Var2.k(k30Var2);
                        } else {
                            x20Var2.j0();
                        }
                        ie4.c(x20Var2, n20.f, e92VarA3);
                        ie4.c(x20Var2, n20.e, gw1VarL3);
                        ie4.a(x20Var2, Integer.valueOf(iHashCode3), n20.g);
                        ie4.b(x20Var2, n20.h);
                        ie4.c(x20Var2, n20.d, ek1VarC3);
                        x20 x20Var3 = x20Var2;
                        dz2.b(op2Var.b, new d81(1.0f, true), uz.e, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(w33.a)).k, x20Var3, CollationFastLatin.LATIN_LIMIT, 0, 131064);
                        x20Var2 = x20Var3;
                        k54.h(x20Var2, w44.g(bk1Var, 8.0f));
                        boolean z3 = op2Var.d;
                        String str2 = z3 ? "ENABLED" : "MANAGE";
                        hq0 hq0Var = this.c;
                        boolean zF = x20Var2.f(hq0Var) | x20Var2.f(op2Var);
                        Object objL = x20Var2.L();
                        if (zF || objL == r20.a) {
                            i = 0;
                            objL = new gi2(hq0Var, op2Var, 0);
                            x20Var2.g0(objL);
                        } else {
                            i = 0;
                        }
                        k34.g(str2, z3, (fq0) objL, x20Var2, i);
                        x20Var2.p(true);
                    }
                } else {
                    x20Var.R();
                }
                break;
            default:
                ((Integer) obj2).getClass();
                k34.e(this.b, this.c, this.e, this.f, (x20) obj, ny3.c(1));
                break;
        }
        return q43Var;
    }

    public /* synthetic */ di2(gj2 gj2Var, hq0 hq0Var, fq0 fq0Var, fq0 fq0Var2, int i) {
        this.b = gj2Var;
        this.c = hq0Var;
        this.e = fq0Var;
        this.f = fq0Var2;
    }
}
