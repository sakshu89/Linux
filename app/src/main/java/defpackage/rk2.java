package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rk2 extends wp0 {
    public final AtomicBoolean e;

    public rk2(zy0 zy0Var) {
        super(zy0Var);
        this.e = new AtomicBoolean(false);
    }

    @Override // defpackage.wp0, java.lang.AutoCloseable
    public final void close() throws Exception {
        if (this.e.getAndSet(true)) {
            return;
        }
        super.close();
    }
}
