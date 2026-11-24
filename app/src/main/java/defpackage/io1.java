package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class io1 extends c1 implements f41 {
    public static final io1 b = new io1(nr4.k);

    @Override // defpackage.f41
    public final rd0 C(hq0 hq0Var) {
        return jo1.a;
    }

    @Override // defpackage.f41
    public final Object H(y50 y50Var) {
        throw new UnsupportedOperationException("This job is always active");
    }

    @Override // defpackage.f41
    public final rd0 K(boolean z, boolean z2, q0 q0Var) {
        return jo1.a;
    }

    @Override // defpackage.f41
    public final boolean c() {
        return true;
    }

    @Override // defpackage.f41
    public final sx q(p41 p41Var) {
        return jo1.a;
    }

    @Override // defpackage.f41
    public final boolean start() {
        return false;
    }

    public final String toString() {
        return "NonCancellable";
    }

    @Override // defpackage.f41
    public final CancellationException x() {
        throw new IllegalStateException("This job is always active");
    }

    @Override // defpackage.f41
    public final void e(CancellationException cancellationException) {
    }
}
