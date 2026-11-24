package defpackage;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w03 extends hb2 implements Runnable {
    public final long j;

    public w03(long j, y50 y50Var) {
        super(y50Var, y50Var.f());
        this.j = j;
    }

    @Override // defpackage.p41
    public final String d0() {
        return super.d0() + "(timeMillis=" + this.j + ')';
    }

    @Override // java.lang.Runnable
    public final void run() throws IllegalAccessException, InvocationTargetException {
        bm4.c(this.f);
        A(new v03("Timed out waiting for " + this.j + " ms", this));
    }
}
