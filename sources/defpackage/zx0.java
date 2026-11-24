package defpackage;

import java.net.SocketTimeoutException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zx0 extends gh {
    public final /* synthetic */ ay0 m;

    public zx0(ay0 ay0Var) {
        this.m = ay0Var;
    }

    @Override // defpackage.gh
    public final void k() {
        this.m.e(9);
        tx0 tx0Var = this.m.b;
        synchronized (tx0Var) {
            long j = tx0Var.x;
            long j2 = tx0Var.w;
            if (j < j2) {
                return;
            }
            tx0Var.w = j2 + 1;
            tx0Var.H = System.nanoTime() + 1000000000;
            tx0Var.k.c(new qx0(cq.n(new StringBuilder(), tx0Var.c, " ping"), tx0Var, 0), 0L);
        }
    }

    public final void l() {
        if (j()) {
            throw new SocketTimeoutException("timeout");
        }
    }
}
