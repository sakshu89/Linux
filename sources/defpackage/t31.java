package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class t31 extends i41 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater n = AtomicIntegerFieldUpdater.newUpdater(t31.class, "_invoked$volatile");
    private volatile /* synthetic */ int _invoked$volatile;
    public final q0 k;

    public t31(q0 q0Var) {
        this.k = q0Var;
    }

    @Override // defpackage.i41
    public final boolean q() {
        return true;
    }

    @Override // defpackage.i41
    public final void r(Throwable th) throws IllegalAccessException, InvocationTargetException {
        if (n.compareAndSet(this, 0, 1)) {
            this.k.j(th);
        }
    }
}
