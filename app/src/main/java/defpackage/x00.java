package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x00 extends p41 implements qb0 {
    public final Object s0(x50 x50Var) throws Throwable {
        Object objU;
        do {
            objU = U();
            if (!(objU instanceof rz0)) {
                if (objU instanceof a10) {
                    throw ((a10) objU).a;
                }
                return tz3.e(objU);
            }
        } while (m0(objU) < 0);
        j41 j41Var = new j41(fp4.b(x50Var), this);
        j41Var.x();
        j41Var.A(new rv(1, hp4.d(this, true, new l72(j41Var))));
        return j41Var.v();
    }

    public final boolean t0(Throwable th) {
        return b0(new a10(th, false));
    }
}
