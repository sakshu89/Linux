package defpackage;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jo extends FilterOutputStream {
    public final /* synthetic */ int a = 0;
    public final OutputStream b;
    public ByteOrder c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public jo(OutputStream outputStream) {
        super(outputStream);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        this.b = outputStream;
        this.c = byteOrder;
    }

    public void c(int i) throws IOException {
        this.b.write(i);
    }

    public final void e(int i) throws IOException {
        int i2 = this.a;
        OutputStream outputStream = this.b;
        switch (i2) {
            case 0:
                ByteOrder byteOrder = this.c;
                if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                    outputStream.write(i & 255);
                    outputStream.write((i >>> 8) & 255);
                    outputStream.write((i >>> 16) & 255);
                    outputStream.write((i >>> 24) & 255);
                } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                    outputStream.write((i >>> 24) & 255);
                    outputStream.write((i >>> 16) & 255);
                    outputStream.write((i >>> 8) & 255);
                    outputStream.write(i & 255);
                }
                break;
            default:
                ByteOrder byteOrder2 = this.c;
                if (byteOrder2 == ByteOrder.LITTLE_ENDIAN) {
                    outputStream.write(i & 255);
                    outputStream.write((i >>> 8) & 255);
                    outputStream.write((i >>> 16) & 255);
                    outputStream.write((i >>> 24) & 255);
                } else if (byteOrder2 == ByteOrder.BIG_ENDIAN) {
                    outputStream.write((i >>> 24) & 255);
                    outputStream.write((i >>> 16) & 255);
                    outputStream.write((i >>> 8) & 255);
                    outputStream.write(i & 255);
                }
                break;
        }
    }

    public final void j(short s) throws IOException {
        int i = this.a;
        OutputStream outputStream = this.b;
        switch (i) {
            case 0:
                ByteOrder byteOrder = this.c;
                if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
                    outputStream.write(s & 255);
                    outputStream.write((s >>> 8) & 255);
                } else if (byteOrder == ByteOrder.BIG_ENDIAN) {
                    outputStream.write((s >>> 8) & 255);
                    outputStream.write(s & 255);
                }
                break;
            default:
                ByteOrder byteOrder2 = this.c;
                if (byteOrder2 == ByteOrder.LITTLE_ENDIAN) {
                    outputStream.write(s & 255);
                    outputStream.write((s >>> 8) & 255);
                } else if (byteOrder2 == ByteOrder.BIG_ENDIAN) {
                    outputStream.write((s >>> 8) & 255);
                    outputStream.write(s & 255);
                }
                break;
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        switch (this.a) {
            case 0:
                this.b.write(bArr);
                break;
            default:
                this.b.write(bArr);
                break;
        }
    }

    public jo(OutputStream outputStream, ByteOrder byteOrder) {
        super(outputStream);
        this.b = outputStream;
        this.c = byteOrder;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        switch (this.a) {
            case 0:
                this.b.write(bArr, i, i2);
                break;
            default:
                this.b.write(bArr, i, i2);
                break;
        }
    }
}
