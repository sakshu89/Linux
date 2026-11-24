package defpackage;

import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kx3 extends OutputStream {
    public final /* synthetic */ int a;
    public long b;

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) {
        int length;
        int i3;
        int length2;
        int i4;
        switch (this.a) {
            case 0:
                if (i < 0 || i > (length = bArr.length) || i2 < 0 || (i3 = i + i2) > length || i3 < 0) {
                    throw new IndexOutOfBoundsException();
                }
                this.b += (long) i2;
                return;
            default:
                if (i < 0 || i > (length2 = bArr.length) || i2 < 0 || (i4 = i + i2) > length2 || i4 < 0) {
                    throw new IndexOutOfBoundsException();
                }
                this.b += (long) i2;
                return;
        }
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr) {
        switch (this.a) {
            case 0:
                this.b += (long) bArr.length;
                break;
            default:
                this.b += (long) bArr.length;
                break;
        }
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        switch (this.a) {
            case 0:
                this.b++;
                break;
            default:
                this.b++;
                break;
        }
    }
}
