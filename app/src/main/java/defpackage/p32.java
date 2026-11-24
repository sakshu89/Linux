package defpackage;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p32 implements Closeable {
    public final yn a;
    public final xn b;
    public final /* synthetic */ ux c;

    public p32(yn ynVar, xn xnVar, ux uxVar) {
        this.c = uxVar;
        ynVar.getClass();
        xnVar.getClass();
        this.a = ynVar;
        this.b = xnVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.c.a(true, true, null);
    }
}
