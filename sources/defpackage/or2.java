package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class or2 implements nr2 {
    public final hh a = new hh(0);

    public final boolean e(int i) {
        return (this.a.get() & i) != 0;
    }

    public final void f(int i) {
        hh hhVar;
        int i2;
        do {
            hhVar = this.a;
            i2 = hhVar.get();
            if ((i2 & i) != 0) {
                return;
            }
        } while (!hhVar.compareAndSet(i2, i2 | i));
    }
}
