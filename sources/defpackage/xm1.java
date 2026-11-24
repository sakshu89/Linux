package defpackage;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xm1 {
    public final AtomicReference a = new AtomicReference(null);
    public final an1 b = new an1();

    public static final void a(xm1 xm1Var, um1 um1Var) {
        AtomicReference atomicReference = xm1Var.a;
        while (true) {
            um1 um1Var2 = (um1) atomicReference.get();
            if (um1Var2 != null && um1Var.a.compareTo(um1Var2.a) < 0) {
                throw new CancellationException("Current mutation had a higher priority");
            }
            do {
                if (atomicReference.compareAndSet(um1Var2, um1Var)) {
                    if (um1Var2 != null) {
                        um1Var2.b.e(new gm0("Mutation interrupted", 0));
                        return;
                    }
                    return;
                }
            } while (atomicReference.get() == um1Var2);
        }
    }
}
