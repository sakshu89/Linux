package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w60 implements oh1 {
    public final /* synthetic */ ua1 a;
    public final /* synthetic */ hq0 b;
    public final /* synthetic */ ty2 c;
    public final /* synthetic */ mp1 d;
    public final /* synthetic */ jc0 e;
    public final /* synthetic */ int f;

    public w60(ua1 ua1Var, hq0 hq0Var, ty2 ty2Var, mp1 mp1Var, jc0 jc0Var, int i) {
        this.a = ua1Var;
        this.b = hq0Var;
        this.c = ty2Var;
        this.d = mp1Var;
        this.e = jc0Var;
        this.f = i;
    }

    @Override // defpackage.oh1
    public final int c(z21 z21Var, List list, int i) {
        ua1 ua1Var = this.a;
        ua1Var.a.a(z21Var.getLayoutDirection());
        cj cjVar = ua1Var.a.j;
        if (cjVar != null) {
            return mb4.a(cjVar.c());
        }
        og.n("layoutIntrinsics must be called first");
        return 0;
    }

    /* JADX WARN: Code duplicated, block: B:75:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:77:0x01c9  */
    /* JADX WARN: Code duplicated, block: B:78:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:83:0x01f0  */
    /* JADX WARN: Code duplicated, block: B:84:0x01fb  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v2, types: [y61] */
    /* JADX WARN: Type inference failed for: r14v6 */
    @Override // defpackage.oh1
    public final ph1 f(qh1 qh1Var, List list, long j) {
        gz2 gz2Var;
        z61 z61Var;
        ph1 ph1Var;
        gz2 gz2Var2;
        int i;
        w60 w60Var;
        int iA;
        Object r14;
        ua1 ua1Var = this.a;
        bm2 bm2VarA = i44.a();
        hq0 hq0VarE = bm2VarA != null ? bm2VarA.e() : null;
        bm2 bm2VarB = i44.b(bm2VarA);
        try {
            hz2 hz2VarD = ua1Var.d();
            i44.e(bm2VarA, bm2VarB, hq0VarE);
            gz2 gz2Var3 = hz2VarD != null ? hz2VarD.a : null;
            ux2 ux2Var = ua1Var.a;
            z61 layoutDirection = qh1Var.getLayoutDirection();
            int i2 = ux2Var.f;
            boolean z = ux2Var.e;
            int i3 = ux2Var.c;
            if (gz2Var3 != null) {
                fl1 fl1Var = gz2Var3.b;
                fz2 fz2Var = gz2Var3.a;
                be beVar = ux2Var.a;
                yz2 yz2Var = ux2Var.b;
                List list2 = ux2Var.i;
                ph1Var = null;
                jc0 jc0Var = ux2Var.g;
                qo0 qo0Var = ux2Var.h;
                gz2 gz2Var4 = gz2Var3;
                if (!fl1Var.a.b()) {
                    be beVar2 = fz2Var.a;
                    long j2 = fz2Var.j;
                    if (g31.a(beVar2, beVar) && fz2Var.b.c(yz2Var) && g31.a(fz2Var.c, list2) && fz2Var.d == i3 && fz2Var.e == z && fz2Var.f == i2 && g31.a(fz2Var.g, jc0Var)) {
                        z61Var = layoutDirection;
                        if (fz2Var.h == z61Var && g31.a(fz2Var.i, qo0Var) && q40.j(j) == q40.j(j2) && ((!z && i2 != 2) || (q40.h(j) == q40.h(j2) && q40.g(j) == q40.g(j2)))) {
                            gz2Var = gz2Var4;
                            gz2Var2 = new gz2(new fz2(fz2Var.a, ux2Var.b, fz2Var.c, fz2Var.d, fz2Var.e, fz2Var.f, fz2Var.g, fz2Var.h, fz2Var.i, j), fl1Var, r40.d(j, (((long) mb4.a(fl1Var.e)) & 4294967295L) | (((long) mb4.a(fl1Var.d)) << 32)));
                        }
                    } else {
                        j = j;
                        gz2Var = gz2Var4;
                        z61Var = layoutDirection;
                    }
                    long j3 = gz2Var2.c;
                    Integer numValueOf = Integer.valueOf((int) (j3 >> 32));
                    Integer numValueOf2 = Integer.valueOf((int) (j3 & 4294967295L));
                    int iIntValue = numValueOf.intValue();
                    int iIntValue2 = numValueOf2.intValue();
                    if (g31.a(gz2Var, gz2Var2)) {
                        i = 0;
                        w60Var = this;
                    } else {
                        if (hz2VarD != null) {
                            r14 = hz2VarD.c;
                        } else {
                            r14 = ph1Var;
                        }
                        ua1Var.i.setValue(new hz2(gz2Var2, r14));
                        i = 0;
                        ua1Var.p = false;
                        w60Var = this;
                        w60Var.b.j(gz2Var2);
                        hl4.f(ua1Var, w60Var.c, w60Var.d);
                    }
                    if (w60Var.f == 1) {
                        iA = mb4.a(gz2Var2.b.b(i));
                    } else {
                        iA = i;
                    }
                    ua1Var.g.setValue(new de0(w60Var.e.r0(iA)));
                    return qh1Var.j0(iIntValue, iIntValue2, bh1.c(new wt1(g6.a, Integer.valueOf(Math.round(gz2Var2.d))), new wt1(g6.b, Integer.valueOf(Math.round(gz2Var2.e)))), new j(7));
                }
                z61Var = layoutDirection;
                gz2Var = gz2Var4;
            } else {
                j = j;
                gz2Var = gz2Var3;
                z61Var = layoutDirection;
                ph1Var = null;
            }
            ux2Var.a(z61Var);
            int iJ = q40.j(j);
            int iH = ((z || i2 == 2) && q40.d(j)) ? q40.h(j) : Integer.MAX_VALUE;
            int i4 = (z || i2 != 2) ? i3 : 1;
            if (iJ != iH) {
                cj cjVar = ux2Var.j;
                if (cjVar == null) {
                    og.n("layoutIntrinsics must be called first");
                    return ph1Var;
                }
                iH = ky3.c(mb4.a(cjVar.c()), iJ, iH);
            }
            cj cjVar2 = ux2Var.j;
            if (cjVar2 == null) {
                og.n("layoutIntrinsics must be called first");
                return ph1Var;
            }
            fl1 fl1Var2 = new fl1(cjVar2, wk4.b(0, iH, 0, q40.g(j)), i4, ux2Var.f);
            gz2Var2 = new gz2(new fz2(ux2Var.a, ux2Var.b, ux2Var.i, ux2Var.c, ux2Var.e, ux2Var.f, ux2Var.g, z61Var, ux2Var.h, j), fl1Var2, r40.d(j, (((long) mb4.a(fl1Var2.d)) << 32) | (((long) mb4.a(fl1Var2.e)) & 4294967295L)));
            long j4 = gz2Var2.c;
            Integer numValueOf3 = Integer.valueOf((int) (j4 >> 32));
            Integer numValueOf4 = Integer.valueOf((int) (j4 & 4294967295L));
            int iIntValue3 = numValueOf3.intValue();
            int iIntValue4 = numValueOf4.intValue();
            if (g31.a(gz2Var, gz2Var2)) {
                if (hz2VarD != null) {
                    r14 = hz2VarD.c;
                } else {
                    r14 = ph1Var;
                }
                ua1Var.i.setValue(new hz2(gz2Var2, r14));
                i = 0;
                ua1Var.p = false;
                w60Var = this;
                w60Var.b.j(gz2Var2);
                hl4.f(ua1Var, w60Var.c, w60Var.d);
            } else {
                i = 0;
                w60Var = this;
            }
            if (w60Var.f == 1) {
                iA = mb4.a(gz2Var2.b.b(i));
            } else {
                iA = i;
            }
            ua1Var.g.setValue(new de0(w60Var.e.r0(iA)));
            return qh1Var.j0(iIntValue3, iIntValue4, bh1.c(new wt1(g6.a, Integer.valueOf(Math.round(gz2Var2.d))), new wt1(g6.b, Integer.valueOf(Math.round(gz2Var2.e)))), new j(7));
        } catch (Throwable th) {
            i44.e(bm2VarA, bm2VarB, hq0VarE);
            throw th;
        }
    }
}
