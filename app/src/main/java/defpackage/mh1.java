package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mh1 extends k61 implements fq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ nh1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ mh1(nh1 nh1Var, int i) {
        super(0);
        this.b = i;
        this.c = nh1Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        yw1 placementScope;
        int i = this.b;
        q43 q43Var = q43.a;
        nh1 nh1Var = this.c;
        switch (i) {
            case 0:
                r71 r71Var = nh1Var.i;
                r71Var.i = 0;
                pm1 pm1VarZ = r71Var.a.z();
                Object[] objArr = pm1VarZ.a;
                int i2 = pm1VarZ.c;
                for (int i3 = 0; i3 < i2; i3++) {
                    nh1 nh1Var2 = ((n71) objArr[i3]).p0.p;
                    nh1Var2.k = nh1Var2.n;
                    nh1Var2.n = Integer.MAX_VALUE;
                    nh1Var2.Z = false;
                    if (nh1Var2.u == l71.b) {
                        nh1Var2.u = l71.c;
                    }
                }
                n71 n71Var = r71Var.a;
                n71 n71Var2 = r71Var.a;
                pm1 pm1VarZ2 = n71Var.z();
                Object[] objArr2 = pm1VarZ2.a;
                int i4 = pm1VarZ2.c;
                for (int i5 = 0; i5 < i4; i5++) {
                    ((n71) objArr2[i5]).p0.p.f0.getClass();
                }
                if (nh1Var.p().t) {
                    wl1 wl1Var = (wl1) n71Var2.n();
                    int i6 = ((pm1) wl1Var.b).c;
                    for (int i7 = 0; i7 < i6; i7++) {
                        ((n71) wl1Var.get(i7)).o0.d.t = true;
                    }
                }
                nh1Var.p().D0().c();
                if (nh1Var.p().t) {
                    wl1 wl1Var2 = (wl1) n71Var2.n();
                    int i8 = ((pm1) wl1Var2.b).c;
                    for (int i9 = 0; i9 < i8; i9++) {
                        ((n71) wl1Var2.get(i9)).o0.d.t = false;
                    }
                }
                pm1 pm1VarZ3 = n71Var2.z();
                Object[] objArr3 = pm1VarZ3.a;
                int i10 = pm1VarZ3.c;
                for (int i11 = 0; i11 < i10; i11++) {
                    n71 n71Var3 = (n71) objArr3[i11];
                    r71 r71Var2 = n71Var3.p0;
                    if (r71Var2.p.k != n71Var3.v()) {
                        n71Var2.O();
                        n71Var2.C();
                        if (n71Var3.v() == Integer.MAX_VALUE) {
                            if (r71Var2.c || vp4.a(n71Var3)) {
                                sf1 sf1Var = r71Var2.q;
                                sf1Var.getClass();
                                sf1Var.t0(false);
                            }
                            r71Var2.p.w0();
                        }
                    }
                }
                pm1 pm1VarZ4 = n71Var2.z();
                Object[] objArr4 = pm1VarZ4.a;
                int i12 = pm1VarZ4.c;
                for (int i13 = 0; i13 < i12; i13++) {
                    o71 o71Var = ((n71) objArr4[i13]).p0.p.f0;
                    o71Var.getClass();
                    o71Var.c = false;
                }
                break;
            case 1:
                nh1Var.i.a().e(nh1Var.j0);
                break;
            default:
                r71 r71Var3 = nh1Var.i;
                co1 co1Var = r71Var3.a().X;
                if (co1Var == null || (placementScope = co1Var.u) == null) {
                    placementScope = ((r7) q71.a(r71Var3.a)).getPlacementScope();
                }
                hq0 hq0Var = nh1Var.o0;
                if (hq0Var == null) {
                    co1 co1VarA = r71Var3.a();
                    long j = nh1Var.p0;
                    float f = nh1Var.q0;
                    placementScope.getClass();
                    yw1.a(placementScope, co1VarA);
                    co1VarA.n0(e21.c(j, co1VarA.f), f, null);
                } else {
                    co1 co1VarA2 = r71Var3.a();
                    long j2 = nh1Var.p0;
                    float f2 = nh1Var.q0;
                    placementScope.getClass();
                    yw1.a(placementScope, co1VarA2);
                    co1VarA2.n0(e21.c(j2, co1VarA2.f), f2, hq0Var);
                }
                break;
        }
        return q43Var;
    }
}
