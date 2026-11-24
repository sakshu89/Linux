package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kr2 extends a2 {
    public final AtomicReference a = new AtomicReference(null);

    @Override // defpackage.a2
    public final boolean a(z1 z1Var) {
        AtomicReference atomicReference = this.a;
        if (atomicReference.get() != null) {
            return false;
        }
        atomicReference.set(o54.a);
        return true;
    }

    @Override // defpackage.a2
    public final x50[] b(z1 z1Var) {
        this.a.set(null);
        return n80.a;
    }
}
