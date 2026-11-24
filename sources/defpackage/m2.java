package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class m2 implements hq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ AtomicBoolean b;

    public /* synthetic */ m2(AtomicBoolean atomicBoolean, int i) {
        this.a = i;
        this.b = atomicBoolean;
    }

    @Override // defpackage.hq0
    public final Object j(Object obj) {
        int i = this.a;
        q43 q43Var = q43.a;
        AtomicBoolean atomicBoolean = this.b;
        switch (i) {
            case 0:
                atomicBoolean.compareAndSet(false, true);
                break;
            default:
                atomicBoolean.compareAndSet(false, true);
                break;
        }
        return q43Var;
    }
}
