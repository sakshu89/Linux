package defpackage;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bh {
    public final jr2 a = o54.a(ah.a);
    public final AtomicLong b = new AtomicLong(System.currentTimeMillis());

    public final void a() {
        ah ahVar = ah.a;
        synchronized (this) {
            jr2 jr2Var = this.a;
            jr2Var.getClass();
            jr2Var.j(null, ahVar);
            this.b.incrementAndGet();
        }
    }
}
