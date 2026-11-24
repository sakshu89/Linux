package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vj1 implements hq0 {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ nl4 c;

    public vj1(AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, nl4 nl4Var) {
        this.a = atomicBoolean;
        this.b = atomicBoolean2;
        this.c = nl4Var;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        this.a.compareAndSet(false, true);
        if (this.b.compareAndSet(false, true)) {
            this.c.close();
        }
        return q43.a;
    }
}
