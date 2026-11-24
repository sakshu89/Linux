package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p81 extends dk1 implements f71 {
    public static final n81 Y = new n81();
    public tm H;
    public js1 X;
    public p91 x;

    public final boolean I0(l81 l81Var, int i) {
        if (i != 5 && i != 6) {
            if (i == 3 || i == 4) {
                if (this.X != js1.a) {
                }
            } else if (i != 1 && i != 2) {
                og.n("Lazy list does not support beyond bounds layout for the specified direction");
                return false;
            }
            if (J0(i) ? l81Var.a > 0 : l81Var.b < this.x.a.i().n - 1) {
                return true;
            }
        } else if (this.X != js1.b) {
            if (J0(i)) {
            }
        }
        return false;
    }

    public final boolean J0(int i) {
        if (i == 1) {
            return false;
        }
        if (i == 2) {
            return true;
        }
        if (i == 5) {
            return false;
        }
        if (i == 6) {
            return true;
        }
        if (i == 3) {
            int iOrdinal = cm4.g(this).i0.ordinal();
            if (iOrdinal == 0) {
                return false;
            }
            if (iOrdinal == 1) {
                return true;
            }
            dk0.l();
            return false;
        }
        if (i != 4) {
            og.n("Lazy list does not support beyond bounds layout for the specified direction");
            return false;
        }
        int iOrdinal2 = cm4.g(this).i0.ordinal();
        if (iOrdinal2 == 0) {
            return true;
        }
        if (iOrdinal2 == 1) {
            return false;
        }
        dk0.l();
        return false;
    }

    @Override // defpackage.f71
    public final ph1 d(qh1 qh1Var, jh1 jh1Var, long j) {
        zw1 zw1VarE = jh1Var.e(j);
        return qh1Var.j0(zw1VarE.a, zw1VarE.b, ji0.a, new sl0(zw1VarE, 2));
    }
}
