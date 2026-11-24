package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class xp4 {
    public static final void a(final ek1 ek1Var, final ea1 ea1Var, final qt1 qt1Var, final fg fgVar, jl jlVar, ka0 ka0Var, boolean z, f9 f9Var, final hq0 hq0Var, x20 x20Var, final int i) {
        final jl jlVar2;
        final ka0 ka0Var2;
        final boolean z2;
        final f9 f9Var2;
        f9 f9Var3;
        int i2;
        boolean z3;
        ka0 ka0Var3;
        x20Var.X(53695811);
        int i3 = i | (x20Var.f(ek1Var) ? 4 : 2) | (x20Var.f(ea1Var) ? 32 : 16) | 46861312 | (x20Var.h(hq0Var) ? 536870912 : 268435456);
        if (x20Var.O(i3 & 1, (306783379 & i3) != 306783378)) {
            x20Var.T();
            if ((i & 1) == 0 || x20Var.y()) {
                jl jlVar3 = xy.w;
                float f = pp2.a;
                jc0 jc0Var = (jc0) x20Var.j(l30.h);
                boolean zC = x20Var.c(jc0Var.b());
                Object objL = x20Var.L();
                Object obj = r20.a;
                if (zC || objL == obj) {
                    objL = new da0(new py0(jc0Var));
                    x20Var.g0(objL);
                }
                da0 da0Var = (da0) objL;
                boolean zF = x20Var.f(da0Var);
                Object objL2 = x20Var.L();
                if (zF || objL2 == obj) {
                    objL2 = new ka0(da0Var);
                    x20Var.g0(objL2);
                }
                ka0 ka0Var4 = (ka0) objL2;
                m30 m30Var = gt1.a;
                x20Var.W(282942128);
                g9 g9Var = (g9) x20Var.j(gt1.a);
                if (g9Var == null) {
                    x20Var.p(false);
                    f9Var3 = null;
                } else {
                    boolean zF2 = x20Var.f(g9Var);
                    Object objL3 = x20Var.L();
                    if (zF2 || objL3 == obj) {
                        Object f9Var4 = new f9(g9Var.a, g9Var.b, g9Var.c, g9Var.d);
                        x20Var.g0(f9Var4);
                        objL3 = f9Var4;
                    }
                    x20Var.p(false);
                    f9Var3 = (f9) objL3;
                }
                i2 = i3 & (-238551041);
                z3 = true;
                ka0Var3 = ka0Var4;
                jlVar2 = jlVar3;
            } else {
                x20Var.R();
                i2 = i3 & (-238551041);
                jlVar2 = jlVar;
                ka0Var3 = ka0Var;
                z3 = z;
                f9Var3 = f9Var;
            }
            x20Var.q();
            eq4.a(ek1Var, ea1Var, qt1Var, ka0Var3, z3, f9Var3, jlVar2, fgVar, hq0Var, x20Var, (i2 & 14) | 24576 | (i2 & 112) | 806882688, 6 | ((i2 >> 18) & 7168));
            ka0Var2 = ka0Var3;
            z2 = z3;
            f9Var2 = f9Var3;
        } else {
            x20Var.R();
            jlVar2 = jlVar;
            ka0Var2 = ka0Var;
            z2 = z;
            f9Var2 = f9Var;
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new vq0(ea1Var, qt1Var, fgVar, jlVar2, ka0Var2, z2, f9Var2, hq0Var, i) { // from class: j81
                public final /* synthetic */ ea1 b;
                public final /* synthetic */ qt1 c;
                public final /* synthetic */ fg e;
                public final /* synthetic */ jl f;
                public final /* synthetic */ ka0 i;
                public final /* synthetic */ boolean j;
                public final /* synthetic */ f9 k;
                public final /* synthetic */ hq0 n;

                @Override // defpackage.vq0
                public final Object e(Object obj2, Object obj3) {
                    ((Integer) obj3).getClass();
                    int iC = ny3.c(24961);
                    xp4.a(this.a, this.b, this.c, this.e, this.f, this.i, this.j, this.k, this.n, (x20) obj2, iC);
                    return q43.a;
                }
            };
        }
    }
}
