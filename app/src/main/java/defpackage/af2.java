package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class af2 extends q30 implements mo1 {
    public static final /* synthetic */ AtomicIntegerFieldUpdater i = AtomicIntegerFieldUpdater.newUpdater(af2.class, "cleanedAndPointers$volatile");
    private volatile /* synthetic */ int cleanedAndPointers$volatile;
    public final long f;

    public af2(long j, af2 af2Var, int i2) {
        super(af2Var);
        this.f = j;
        this.cleanedAndPointers$volatile = i2 << 16;
    }

    @Override // defpackage.q30
    public final boolean g() {
        return i.get(this) == l() && d() != null;
    }

    public final boolean k() {
        return i.addAndGet(this, -65536) == l() && d() != null;
    }

    public abstract int l();

    public abstract void m(int i2, j70 j70Var);

    public final void n() {
        if (i.incrementAndGet(this) == l()) {
            i();
        }
    }

    public final boolean o() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i2;
        do {
            atomicIntegerFieldUpdater = i;
            i2 = atomicIntegerFieldUpdater.get(this);
            if (i2 == l() && d() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i2, 65536 + i2));
        return true;
    }
}
