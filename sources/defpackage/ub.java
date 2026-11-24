package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ub implements wq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ boolean b;
    public final /* synthetic */ Object c;

    public /* synthetic */ ub(Object obj, boolean z, int i) {
        this.a = i;
        this.c = obj;
        this.b = z;
    }

    @Override // defpackage.wq0
    public final Object c(Object obj, Object obj2, Object obj3) {
        int i = this.a;
        xy xyVar = r20.a;
        final boolean z = this.b;
        Object obj4 = this.c;
        switch (i) {
            case 0:
                final fq0 fq0Var = (fq0) obj4;
                ek1 ek1Var = (ek1) obj;
                x20 x20Var = (x20) obj2;
                ((Integer) obj3).getClass();
                x20Var.W(-196777734);
                final long j = ((sz2) x20Var.j(tz2.a)).a;
                boolean zE = x20Var.e(j) | x20Var.f(fq0Var) | x20Var.g(z);
                Object objL = x20Var.L();
                if (zE || objL == xyVar) {
                    objL = new hq0() { // from class: vb
                        @Override // defpackage.hq0
                        public final Object j(Object obj5) {
                            so soVar = (so) obj5;
                            final p9 p9VarD = vd4.d(soVar, Float.intBitsToFloat((int) (soVar.a.c() >> 32)) / 2.0f);
                            final nl nlVar = new nl(5, j);
                            final fq0 fq0Var2 = fq0Var;
                            final boolean z2 = z;
                            return soVar.a(new hq0() { // from class: nb
                                @Override // defpackage.hq0
                                public final Object j(Object obj6) {
                                    p71 p71Var = (p71) obj6;
                                    p71Var.a();
                                    ew ewVar = p71Var.a;
                                    boolean zBooleanValue = ((Boolean) fq0Var2.a()).booleanValue();
                                    q43 q43Var = q43.a;
                                    if (!zBooleanValue) {
                                        return q43Var;
                                    }
                                    boolean z3 = z2;
                                    p9 p9Var = p9VarD;
                                    nl nlVar2 = nlVar;
                                    if (!z3) {
                                        ewVar.e(p9Var, nlVar2);
                                        return q43Var;
                                    }
                                    long jX = ewVar.X();
                                    kf kfVar = ewVar.b;
                                    long jR = kfVar.r();
                                    kfVar.m().m();
                                    try {
                                        ((q82) kfVar.b).H(-1.0f, 1.0f, jX);
                                        ewVar.e(p9Var, nlVar2);
                                        return q43Var;
                                    } finally {
                                        cq.t(kfVar, jR);
                                    }
                                }
                            });
                        }
                    };
                    x20Var.g0(objL);
                }
                ek1 ek1VarB = az3.b(ek1Var, (hq0) objL);
                x20Var.p(false);
                return ek1VarB;
            default:
                fy2 fy2Var = (fy2) obj4;
                ku1 ku1Var = fy2Var.f;
                x20 x20Var2 = (x20) obj2;
                ((Integer) obj3).getClass();
                x20Var2.W(-2137546592);
                boolean z2 = ((js1) ku1Var.getValue()) == js1.a || !(x20Var2.j(l30.n) == z61.b);
                boolean zF = x20Var2.f(fy2Var);
                Object objL2 = x20Var2.L();
                if (zF || objL2 == xyVar) {
                    objL2 = new rm2(7, fy2Var);
                    x20Var2.g0(objL2);
                }
                mm1 mm1VarH = o44.h((hq0) objL2, x20Var2);
                Object objL3 = x20Var2.L();
                if (objL3 == xyVar) {
                    bb0 bb0Var = new bb0(new jc(mm1VarH, 3));
                    x20Var2.g0(bb0Var);
                    objL3 = bb0Var;
                }
                be2 be2Var = (be2) objL3;
                boolean zF2 = x20Var2.f(be2Var) | x20Var2.f(fy2Var);
                Object objL4 = x20Var2.L();
                if (zF2 || objL4 == xyVar) {
                    objL4 = new ey2(be2Var, fy2Var);
                    x20Var2.g0(objL4);
                }
                ek1 ek1VarB2 = ud2.b((ey2) objL4, (js1) ku1Var.getValue(), z && fy2Var.b.g() != 0.0f, z2);
                x20Var2.p(false);
                return ek1VarB2;
        }
    }
}
