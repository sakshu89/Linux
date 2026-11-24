package defpackage;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class x80 implements Closeable {
    public c22 a;
    public z70 b;
    public c22 c;
    public c22 e;
    public c22 f;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ((l92) this.e.get()).close();
    }
}
