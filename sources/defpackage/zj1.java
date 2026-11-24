package defpackage;

import java.io.Closeable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class zj1 implements Closeable, nb1 {
    public static final l11 f = new l11("MobileVisionBase", 24);
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final rz2 b;
    public final uf1 c;
    public final Executor e;

    public zj1(rz2 rz2Var, Executor executor) {
        this.b = rz2Var;
        uf1 uf1Var = new uf1(10);
        this.c = uf1Var;
        this.e = executor;
        rz2Var.b.incrementAndGet();
        et4 et4VarA = rz2Var.a(executor, uy3.a, (wj1) uf1Var.b);
        ak1 ak1Var = ak1.k;
        et4VarA.getClass();
        et4VarA.b.o(new xd4(jw2.a, ak1Var));
        et4VarA.i();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    @hq1(db1.ON_DESTROY)
    public synchronized void close() {
        if (this.a.getAndSet(true)) {
            return;
        }
        this.c.l();
        rz2 rz2Var = this.b;
        Executor executor = this.e;
        if (rz2Var.b.get() <= 0) {
            throw new IllegalStateException();
        }
        rz2Var.a.d(new or0(15, rz2Var, new iw2()), executor);
    }
}
