package defpackage;

import java.nio.channels.WritableByteChannel;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface xn extends wk2, WritableByteChannel {
    xn G(String str);

    @Override // defpackage.wk2, java.io.Flushable
    void flush();

    xn h(oo ooVar);

    xn k(long j);

    xn n();

    ln s();

    xn write(byte[] bArr);

    xn writeByte(int i);

    xn writeInt(int i);

    xn writeShort(int i);
}
