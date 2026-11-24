package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kd1 implements dp1 {
    public final AtomicBoolean a = new AtomicBoolean(true);
    public final k02 b;
    public final Executor c;

    public kd1(Executor executor, k02 k02Var) {
        this.c = executor;
        this.b = k02Var;
    }

    @Override // defpackage.dp1
    public final void u(Object obj) {
        this.c.execute(new o8(21, this, (ld1) obj));
    }
}
