package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class id0 extends hb2 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater j = AtomicIntegerFieldUpdater.newUpdater(id0.class, "_decision$volatile");
    private volatile /* synthetic */ int _decision$volatile;

    @Override // defpackage.hb2, defpackage.p41
    public final void t(Object obj) {
        z(obj);
    }

    @Override // defpackage.hb2, defpackage.p41
    public final void z(Object obj) {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        do {
            atomicIntegerFieldUpdater = j;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i != 0) {
                if (i == 1) {
                    ry3.b(fp4.b(this.i), wi4.a(obj));
                    return;
                } else {
                    og.n("Already resumed");
                    return;
                }
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, 0, 2));
    }
}
