package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface f71 extends xb0 {
    default int B(mf1 mf1Var, jh1 jh1Var, int i) {
        return d(new m31(mf1Var, mf1Var.getLayoutDirection()), new pa0(jh1Var, fo1.a, go1.b, 2), r40.b(i, 0, 13)).a();
    }

    default int S(mf1 mf1Var, jh1 jh1Var, int i) {
        return d(new m31(mf1Var, mf1Var.getLayoutDirection()), new pa0(jh1Var, fo1.a, go1.a, 2), r40.b(0, i, 7)).b();
    }

    ph1 d(qh1 qh1Var, jh1 jh1Var, long j);

    default int e(mf1 mf1Var, jh1 jh1Var, int i) {
        return d(new m31(mf1Var, mf1Var.getLayoutDirection()), new pa0(jh1Var, fo1.b, go1.a, 2), r40.b(0, i, 7)).b();
    }

    default int n(mf1 mf1Var, jh1 jh1Var, int i) {
        return d(new m31(mf1Var, mf1Var.getLayoutDirection()), new pa0(jh1Var, fo1.b, go1.b, 2), r40.b(i, 0, 13)).a();
    }
}
