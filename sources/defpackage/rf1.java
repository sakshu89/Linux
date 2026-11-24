package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rf1 extends k61 implements fq0 {
    public final /* synthetic */ int b;
    public final /* synthetic */ sf1 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ rf1(sf1 sf1Var, int i) {
        super(0);
        this.b = i;
        this.c = sf1Var;
    }

    @Override // defpackage.fq0
    public final Object a() {
        of1 of1VarT0;
        int i = this.b;
        q43 q43Var = q43.a;
        sf1 sf1Var = this.c;
        switch (i) {
            case 0:
                r71 r71Var = sf1Var.i;
                r71Var.h = 0;
                pm1 pm1VarZ = r71Var.a.z();
                Object[] objArr = pm1VarZ.a;
                int i2 = pm1VarZ.c;
                for (int i3 = 0; i3 < i2; i3++) {
                    sf1 sf1Var2 = ((n71) objArr[i3]).p0.q;
                    sf1Var2.getClass();
                    sf1Var2.k = sf1Var2.n;
                    sf1Var2.n = Integer.MAX_VALUE;
                    if (sf1Var2.s == l71.b) {
                        sf1Var2.s = l71.c;
                    }
                }
                n71 n71Var = r71Var.a;
                n71 n71Var2 = r71Var.a;
                pm1 pm1VarZ2 = n71Var.z();
                Object[] objArr2 = pm1VarZ2.a;
                int i4 = pm1VarZ2.c;
                for (int i5 = 0; i5 < i4; i5++) {
                    sf1 sf1Var3 = ((n71) objArr2[i5]).p0.q;
                    sf1Var3.getClass();
                    sf1Var3.X.getClass();
                }
                e11 e11Var = sf1Var.p().B0;
                if (e11Var != null) {
                    boolean z = e11Var.t;
                    wl1 wl1Var = (wl1) n71Var2.n();
                    int i6 = ((pm1) wl1Var.b).c;
                    for (int i7 = 0; i7 < i6; i7++) {
                        of1 of1VarT1 = ((n71) wl1Var.get(i7)).o0.d.T0();
                        if (of1VarT1 != null) {
                            of1VarT1.t = z;
                        }
                    }
                }
                e11 e11Var2 = sf1Var.p().B0;
                e11Var2.getClass();
                e11Var2.D0().c();
                if (sf1Var.p().B0 != null) {
                    wl1 wl1Var2 = (wl1) n71Var2.n();
                    int i8 = ((pm1) wl1Var2.b).c;
                    for (int i9 = 0; i9 < i8; i9++) {
                        of1 of1VarT2 = ((n71) wl1Var2.get(i9)).o0.d.T0();
                        if (of1VarT2 != null) {
                            of1VarT2.t = false;
                        }
                    }
                }
                pm1 pm1VarZ3 = n71Var2.z();
                Object[] objArr3 = pm1VarZ3.a;
                int i10 = pm1VarZ3.c;
                for (int i11 = 0; i11 < i10; i11++) {
                    sf1 sf1Var4 = ((n71) objArr3[i11]).p0.q;
                    sf1Var4.getClass();
                    int i12 = sf1Var4.k;
                    int i13 = sf1Var4.n;
                    if (i12 != i13 && i13 == Integer.MAX_VALUE) {
                        sf1Var4.t0(true);
                    }
                }
                pm1 pm1VarZ4 = n71Var2.z();
                Object[] objArr4 = pm1VarZ4.a;
                int i14 = pm1VarZ4.c;
                for (int i15 = 0; i15 < i14; i15++) {
                    sf1 sf1Var5 = ((n71) objArr4[i15]).p0.q;
                    sf1Var5.getClass();
                    o71 o71Var = sf1Var5.X;
                    o71Var.getClass();
                    o71Var.c = false;
                }
                break;
            case 1:
                r71 r71Var2 = sf1Var.i;
                yw1 placementScope = null;
                if (vp4.a(r71Var2.a) || r71Var2.c) {
                    co1 co1Var = r71Var2.a().X;
                    if (co1Var != null) {
                        placementScope = co1Var.u;
                    }
                } else {
                    co1 co1Var2 = r71Var2.a().X;
                    if (co1Var2 != null && (of1VarT0 = co1Var2.T0()) != null) {
                        placementScope = of1VarT0.u;
                    }
                }
                if (placementScope == null) {
                    placementScope = ((r7) q71.a(r71Var2.a)).getPlacementScope();
                }
                of1 of1VarT3 = r71Var2.a().T0();
                of1VarT3.getClass();
                yw1.i(placementScope, of1VarT3, sf1Var.w);
                break;
            default:
                of1 of1VarT4 = sf1Var.i.a().T0();
                of1VarT4.getClass();
                of1VarT4.e(sf1Var.g0);
                break;
        }
        return q43Var;
    }
}
