package defpackage;

import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fk0 extends InputStream implements DataInput {
    public static final ByteOrder f = ByteOrder.LITTLE_ENDIAN;
    public static final ByteOrder i = ByteOrder.BIG_ENDIAN;
    public final DataInputStream a;
    public ByteOrder b;
    public final int c;
    public int e;

    public fk0(InputStream inputStream, ByteOrder byteOrder) throws IOException {
        this.b = ByteOrder.BIG_ENDIAN;
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.a = dataInputStream;
        int iAvailable = dataInputStream.available();
        this.c = iAvailable;
        this.e = 0;
        dataInputStream.mark(iAvailable);
        this.b = byteOrder;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.a.available();
    }

    public final void c(long j) throws IOException {
        int i2 = this.e;
        if (i2 > j) {
            this.e = 0;
            DataInputStream dataInputStream = this.a;
            dataInputStream.reset();
            dataInputStream.mark(this.c);
        } else {
            j -= (long) i2;
        }
        int i3 = (int) j;
        if (skipBytes(i3) == i3) {
            return;
        }
        dk0.h("Couldn't seek up to the byteCount");
    }

    @Override // java.io.InputStream
    public final synchronized void mark(int i2) {
        this.a.mark(i2);
    }

    @Override // java.io.InputStream
    public final int read() {
        this.e++;
        return this.a.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        this.e++;
        return this.a.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        int i2 = this.e + 1;
        this.e = i2;
        if (i2 > this.c) {
            throw new EOFException();
        }
        int i3 = this.a.read();
        if (i3 >= 0) {
            return (byte) i3;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        this.e += 2;
        return this.a.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        int length = this.e + bArr.length;
        this.e = length;
        if (length > this.c) {
            throw new EOFException();
        }
        if (this.a.read(bArr, 0, bArr.length) == bArr.length) {
            return;
        }
        dk0.h("Couldn't read up to the length of buffer");
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        int i2 = this.e + 4;
        this.e = i2;
        if (i2 > this.c) {
            throw new EOFException();
        }
        DataInputStream dataInputStream = this.a;
        int i3 = dataInputStream.read();
        int i4 = dataInputStream.read();
        int i5 = dataInputStream.read();
        int i6 = dataInputStream.read();
        if ((i3 | i4 | i5 | i6) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.b;
        if (byteOrder == f) {
            return (i6 << 24) + (i5 << 16) + (i4 << 8) + i3;
        }
        if (byteOrder == i) {
            return (i3 << 24) + (i4 << 16) + (i5 << 8) + i6;
        }
        dk0.g(this.b, "Invalid byte order: ");
        return 0;
    }

    @Override // java.io.DataInput
    public final String readLine() {
        return null;
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        int i2 = this.e + 8;
        this.e = i2;
        if (i2 > this.c) {
            throw new EOFException();
        }
        DataInputStream dataInputStream = this.a;
        int i3 = dataInputStream.read();
        int i4 = dataInputStream.read();
        int i5 = dataInputStream.read();
        int i6 = dataInputStream.read();
        int i7 = dataInputStream.read();
        int i8 = dataInputStream.read();
        int i9 = dataInputStream.read();
        int i10 = dataInputStream.read();
        if ((i3 | i4 | i5 | i6 | i7 | i8 | i9 | i10) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.b;
        if (byteOrder == f) {
            return (((long) i10) << 56) + (((long) i9) << 48) + (((long) i8) << 40) + (((long) i7) << 32) + (((long) i6) << 24) + (((long) i5) << 16) + (((long) i4) << 8) + ((long) i3);
        }
        if (byteOrder == i) {
            return (((long) i3) << 56) + (((long) i4) << 48) + (((long) i5) << 40) + (((long) i6) << 32) + (((long) i7) << 24) + (((long) i8) << 16) + (((long) i9) << 8) + ((long) i10);
        }
        dk0.g(this.b, "Invalid byte order: ");
        return 0L;
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        int i2 = this.e + 2;
        this.e = i2;
        if (i2 > this.c) {
            throw new EOFException();
        }
        DataInputStream dataInputStream = this.a;
        int i3 = dataInputStream.read();
        int i4 = dataInputStream.read();
        if ((i3 | i4) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.b;
        if (byteOrder == f) {
            return (short) ((i4 << 8) + i3);
        }
        if (byteOrder == i) {
            return (short) ((i3 << 8) + i4);
        }
        dk0.g(this.b, "Invalid byte order: ");
        return (short) 0;
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        this.e += 2;
        return this.a.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        this.e++;
        return this.a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        int i2 = this.e + 2;
        this.e = i2;
        if (i2 > this.c) {
            throw new EOFException();
        }
        DataInputStream dataInputStream = this.a;
        int i3 = dataInputStream.read();
        int i4 = dataInputStream.read();
        if ((i3 | i4) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.b;
        if (byteOrder == f) {
            return (i4 << 8) + i3;
        }
        if (byteOrder == i) {
            return (i3 << 8) + i4;
        }
        dk0.g(this.b, "Invalid byte order: ");
        return 0;
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i2) {
        int iMin = Math.min(i2, this.c - this.e);
        int iSkipBytes = 0;
        while (iSkipBytes < iMin) {
            iSkipBytes += this.a.skipBytes(iMin - iSkipBytes);
        }
        this.e += iSkipBytes;
        return iSkipBytes;
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.a.read(bArr, i2, i3);
        this.e += i4;
        return i4;
    }

    public fk0(InputStream inputStream) {
        this(inputStream, ByteOrder.BIG_ENDIAN);
    }

    public fk0(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.e + i3;
        this.e = i4;
        if (i4 <= this.c) {
            if (this.a.read(bArr, i2, i3) == i3) {
                return;
            }
            dk0.h("Couldn't read up to the length of buffer");
            return;
        }
        throw new EOFException();
    }
}
