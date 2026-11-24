package defpackage;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface pz2 extends Closeable, nb1, cs1 {
    @Override // java.io.Closeable, java.lang.AutoCloseable
    @hq1(db1.ON_DESTROY)
    void close();
}
