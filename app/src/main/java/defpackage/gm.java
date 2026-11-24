package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class gm {
    public static final gm1 a = c(true);
    public static final gm1 b = c(false);
    public static final eb c = eb.c;

    public static final void a(ek1 ek1Var, x20 x20Var, int i) {
        int i2;
        x20Var.X(-211209833);
        if ((i & 6) == 0) {
            i2 = (x20Var.f(ek1Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        byte b2 = 0;
        int i3 = 1;
        if (x20Var.O(i2 & 1, (i2 & 3) != 2)) {
            int iHashCode = Long.hashCode(x20Var.T);
            ek1 ek1VarC = gj4.c(x20Var, ek1Var);
            gw1 gw1VarL = x20Var.l();
            o20.p.getClass();
            k30 k30Var = n20.b;
            x20Var.Z();
            if (x20Var.S) {
                x20Var.k(k30Var);
            } else {
                x20Var.j0();
            }
            ie4.c(x20Var, n20.f, c);
            ie4.c(x20Var, n20.e, gw1VarL);
            ie4.b(x20Var, n20.h);
            ie4.c(x20Var, n20.d, ek1VarC);
            ie4.a(x20Var, Integer.valueOf(iHashCode), n20.g);
            x20Var.p(true);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new v8(ek1Var, i, i3, b2);
        }
    }

    public static final void b(yw1 yw1Var, zw1 zw1Var, jh1 jh1Var, z61 z61Var, int i, int i2, ll llVar) {
        ll llVar2;
        Object objK = jh1Var.k();
        fm fmVar = objK instanceof fm ? (fm) objK : null;
        yw1.i(yw1Var, zw1Var, ((fmVar == null || (llVar2 = fmVar.x) == null) ? llVar : llVar2).a((((long) zw1Var.a) << 32) | (((long) zw1Var.b) & 4294967295L), (((long) i) << 32) | (((long) i2) & 4294967295L), z61Var));
    }

    public static final gm1 c(boolean z) {
        gm1 gm1Var = new gm1(9);
        ll llVar = xy.b;
        gm1Var.m(llVar, new jm(llVar, z));
        ll llVar2 = xy.c;
        gm1Var.m(llVar2, new jm(llVar2, z));
        ll llVar3 = xy.e;
        gm1Var.m(llVar3, new jm(llVar3, z));
        ll llVar4 = xy.f;
        gm1Var.m(llVar4, new jm(llVar4, z));
        ll llVar5 = xy.i;
        gm1Var.m(llVar5, new jm(llVar5, z));
        ll llVar6 = xy.j;
        gm1Var.m(llVar6, new jm(llVar6, z));
        ll llVar7 = xy.k;
        gm1Var.m(llVar7, new jm(llVar7, z));
        ll llVar8 = xy.n;
        gm1Var.m(llVar8, new jm(llVar8, z));
        ll llVar9 = xy.s;
        gm1Var.m(llVar9, new jm(llVar9, z));
        return gm1Var;
    }

    public static final oh1 d(ll llVar, boolean z) {
        oh1 oh1Var = (oh1) (z ? a : b).g(llVar);
        return oh1Var == null ? new jm(llVar, z) : oh1Var;
    }
}
