package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zq1 extends zr1 {
    public static final zq1 c = new zq1(0, 2, 1);

    @Override // defpackage.zr1
    public final void a(iz izVar, xf xfVar, rl2 rl2Var, i52 i52Var, as1 as1Var) {
        int i;
        j21 j21Var = (j21) izVar.e(0);
        int iC = rl2Var.c((j6) izVar.e(1));
        if (rl2Var.t >= iC) {
            y20.a("Check failed");
        }
        xr4.a(rl2Var, xfVar, iC);
        int i2 = rl2Var.t;
        int iE = rl2Var.v;
        while (iE >= 0 && !rl2Var.y(iE)) {
            iE = rl2Var.E(iE, rl2Var.b);
        }
        int iU = iE + 1;
        int iL = 0;
        while (iU < i2) {
            if (rl2Var.v(i2, iU)) {
                if (rl2Var.y(iU)) {
                    iL = 0;
                }
                iU++;
            } else {
                iL += rl2Var.y(iU) ? 1 : rl2Var.b[(rl2Var.r(iU) * 5) + 1] & 67108863;
                iU += rl2Var.u(iU);
            }
        }
        while (true) {
            i = rl2Var.t;
            if (i >= iC) {
                break;
            }
            if (rl2Var.v(iC, i)) {
                int i3 = rl2Var.t;
                if (i3 < rl2Var.u && (rl2Var.b[(rl2Var.r(i3) * 5) + 1] & 1073741824) != 0) {
                    xfVar.b(rl2Var.D(rl2Var.t));
                    iL = 0;
                }
                rl2Var.P();
            } else {
                iL += rl2Var.L();
            }
        }
        if (i != iC) {
            y20.a("Check failed");
        }
        j21Var.a = iL;
    }
}
