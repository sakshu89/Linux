package defpackage;

import android.media.MediaDataSource;
import java.io.DataInputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ek0 extends MediaDataSource {
    public long a;
    public final /* synthetic */ fk0 b;

    public ek0(fk0 fk0Var) {
        this.b = fk0Var;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j, byte[] bArr, int i, int i2) {
        fk0 fk0Var = this.b;
        DataInputStream dataInputStream = fk0Var.a;
        if (i2 == 0) {
            return 0;
        }
        if (j >= 0) {
            try {
                long j2 = this.a;
                if (j2 != j) {
                    if (j2 < 0 || j < j2 + ((long) dataInputStream.available())) {
                        fk0Var.c(j);
                        this.a = j;
                    }
                }
                if (i2 > dataInputStream.available()) {
                    i2 = dataInputStream.available();
                }
                int i3 = fk0Var.read(bArr, i, i2);
                if (i3 >= 0) {
                    this.a += (long) i3;
                    return i3;
                }
            } catch (IOException unused) {
            }
            this.a = -1L;
            return -1;
        }
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
