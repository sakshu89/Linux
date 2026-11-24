package defpackage;

import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public interface yn extends fp2, ReadableByteChannel {
    int B(fs1 fs1Var);

    void F(long j);

    long I();

    String J(Charset charset);

    void i(long j, ln lnVar);

    oo l(long j);

    String p();

    byte readByte();

    void readFully(byte[] bArr);

    int readInt();

    long readLong();

    short readShort();

    void skip(long j);

    String z(long j);
}
