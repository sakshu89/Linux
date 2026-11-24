package defpackage;

import com.ibm.icu.impl.coll.CollationFastLatin;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class t8 implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;
    public final /* synthetic */ Object c;

    public /* synthetic */ t8(int i, long j, Object obj) {
        this.a = i;
        this.b = j;
        this.c = obj;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.a;
        q43 q43Var = q43.a;
        Object obj3 = this.c;
        long j = this.b;
        switch (i) {
            case 0:
                ek1 ek1Var = (ek1) obj3;
                x20 x20Var = (x20) obj;
                int iIntValue = ((Integer) obj2).intValue();
                if (!x20Var.O(iIntValue & 1, (iIntValue & 3) != 2)) {
                    x20Var.R();
                } else if (j == 9205357640488583168L) {
                    x20Var.W(-1243644858);
                    z8.b(ek1Var, x20Var, 0, 0);
                    x20Var.p(false);
                } else {
                    x20Var.W(-1244013944);
                    ek1 ek1VarF = w44.f(ek1Var, Float.intBitsToFloat((int) (j >> 32)), Float.intBitsToFloat((int) (4294967295L & j)), 0.0f, 0.0f, 12);
                    oh1 oh1VarD = gm.d(xy.c, false);
                    int iHashCode = Long.hashCode(x20Var.T);
                    gw1 gw1VarL = x20Var.l();
                    ek1 ek1VarC = gj4.c(x20Var, ek1VarF);
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
                    z8.b(null, x20Var, 0, 1);
                    x20Var.p(true);
                    x20Var.p(false);
                }
                break;
            default:
                l5 l5Var = (l5) obj3;
                x20 x20Var2 = (x20) obj;
                int iIntValue2 = ((Integer) obj2).intValue();
                if (!x20Var2.O(iIntValue2 & 1, (iIntValue2 & 3) != 2)) {
                    x20Var2.R();
                } else {
                    j00 j00VarA = h00.a(new eg(6.0f, new ag(0)), xy.w, x20Var2, 6);
                    int iHashCode2 = Long.hashCode(x20Var2.T);
                    gw1 gw1VarL2 = x20Var2.l();
                    bk1 bk1Var = bk1.a;
                    ek1 ek1VarC2 = gj4.c(x20Var2, bk1Var);
                    o20.p.getClass();
                    k30 k30Var2 = n20.b;
                    x20Var2.Z();
                    if (x20Var2.S) {
                        x20Var2.k(k30Var2);
                    } else {
                        x20Var2.j0();
                    }
                    jd jdVar = n20.f;
                    ie4.c(x20Var2, jdVar, j00VarA);
                    jd jdVar2 = n20.e;
                    ie4.c(x20Var2, jdVar2, gw1VarL2);
                    Integer numValueOf = Integer.valueOf(iHashCode2);
                    jd jdVar3 = n20.g;
                    ie4.a(x20Var2, numValueOf, jdVar3);
                    j7 j7Var = n20.h;
                    ie4.b(x20Var2, j7Var);
                    jd jdVar4 = n20.d;
                    ie4.c(x20Var2, jdVar4, ek1VarC2);
                    ek1 ek1VarB = w44.b(bk1Var, 1.0f);
                    e92 e92VarA = d92.a(new eg(8.0f, new ag(0)), xy.t, x20Var2, 6);
                    int iHashCode3 = Long.hashCode(x20Var2.T);
                    gw1 gw1VarL3 = x20Var2.l();
                    ek1 ek1VarC3 = gj4.c(x20Var2, ek1VarB);
                    x20Var2.Z();
                    if (x20Var2.S) {
                        x20Var2.k(k30Var2);
                    } else {
                        x20Var2.j0();
                    }
                    ie4.c(x20Var2, jdVar, e92VarA);
                    ie4.c(x20Var2, jdVar2, gw1VarL3);
                    cq.s(iHashCode3, x20Var2, jdVar3, x20Var2, j7Var);
                    ie4.c(x20Var2, jdVar4, ek1VarC3);
                    gm.a(kg1.a(w44.g(c34.f(bk1Var, 4.0f, 0.0f, 0.0f, 13), 7.0f), j, u82.a), x20Var2, 0);
                    dz2.b(l5Var.c, new d81(1.0f, true), uz.e, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var2.j(w33.a)).k, x20Var2, CollationFastLatin.LATIN_LIMIT, 0, 131064);
                    x20Var2.p(true);
                    x20Var2.p(true);
                }
                break;
        }
        return q43Var;
    }
}
