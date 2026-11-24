package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class kb4 {
    public static final cx2 a(xb0 xb0Var) {
        nx2 nx2Var;
        ax2 ax2Var = new ax2();
        jd4.b(xb0Var, ex2.a, new rm2(new rm2(5, ax2Var), new q0(1, ax2Var, ax2.class, "addFilter", "addFilter$foundation(Lkotlin/jvm/functions/Function1;)V", 0, 0, 20)));
        yl1 yl1Var = new yl1();
        yl1 yl1Var2 = ax2Var.a;
        Object[] objArr = yl1Var2.a;
        int i = yl1Var2.b;
        int i2 = 0;
        boolean z = true;
        bx2 bx2Var = null;
        while (true) {
            nx2Var = nx2.b;
            if (i2 >= i) {
                break;
            }
            bx2 bx2Var2 = (bx2) objArr[i2];
            if (!z || bx2Var2 != nx2Var) {
                if (bx2Var2 == nx2Var && bx2Var == nx2Var) {
                    z = false;
                } else {
                    if (bx2Var2 != nx2Var) {
                        yl1 yl1Var3 = ax2Var.b;
                        Object[] objArr2 = yl1Var3.a;
                        int i3 = yl1Var3.b;
                        int i4 = 0;
                        while (true) {
                            if (i4 < i3) {
                                if (((Boolean) ((hq0) objArr2[i4]).j(bx2Var2)).booleanValue()) {
                                    i4++;
                                } else {
                                    z = false;
                                }
                            }
                        }
                    }
                    yl1Var.a(bx2Var2);
                    z = false;
                    bx2Var = bx2Var2;
                }
            }
            i2++;
        }
        if (((bx2) (yl1Var.h() ? null : yl1Var.a[yl1Var.b - 1])) == nx2Var) {
            yl1Var.k(yl1Var.b - 1);
        }
        wl1 wl1Var = yl1Var.c;
        if (wl1Var == null) {
            wl1Var = new wl1(0, yl1Var);
            yl1Var.c = wl1Var;
        }
        return new cx2(wl1Var);
    }

    public static final ek1 b(ek1 ek1Var, hq0 hq0Var) {
        return ek1Var.c(new fv2(hq0Var));
    }
}
