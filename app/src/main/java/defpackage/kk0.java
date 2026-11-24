package defpackage;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kk0 extends FilterOutputStream {
    public static final byte[] j = "Exif\u0000\u0000".getBytes(yj0.d);
    public final ck0 a;
    public final byte[] b;
    public final ByteBuffer c;
    public int e;
    public int f;
    public int i;

    public kk0(ByteArrayOutputStream byteArrayOutputStream, ck0 ck0Var) {
        super(new BufferedOutputStream(byteArrayOutputStream, 65536));
        this.b = new byte[1];
        this.c = ByteBuffer.allocate(4);
        this.e = 0;
        this.a = ck0Var;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr, int i, int i2) throws IOException {
        ck0 ck0Var;
        int i3 = i;
        int i4 = i2;
        while (true) {
            int i5 = this.f;
            if ((i5 <= 0 && this.i <= 0 && this.e == 2) || i4 <= 0) {
                break;
            }
            if (i5 > 0) {
                int iMin = Math.min(i4, i5);
                i4 -= iMin;
                this.f -= iMin;
                i3 += iMin;
            }
            int i6 = this.i;
            if (i6 > 0) {
                int iMin2 = Math.min(i4, i6);
                ((FilterOutputStream) this).out.write(bArr, i3, iMin2);
                i4 -= iMin2;
                this.i -= iMin2;
                i3 += iMin2;
            }
            if (i4 == 0) {
                return;
            }
            int i7 = this.e;
            int i8 = 4;
            ByteBuffer byteBuffer = this.c;
            if (i7 == 0) {
                int iMin3 = Math.min(i4, 2 - byteBuffer.position());
                byteBuffer.put(bArr, i3, iMin3);
                i3 += iMin3;
                i4 -= iMin3;
                if (byteBuffer.position() < 2) {
                    return;
                }
                byteBuffer.rewind();
                if (byteBuffer.getShort() != -40) {
                    dk0.h("Not a valid jpeg image, cannot write exif");
                    return;
                }
                ((FilterOutputStream) this).out.write(byteBuffer.array(), 0, 2);
                this.e = 1;
                byteBuffer.rewind();
                OutputStream outputStream = ((FilterOutputStream) this).out;
                ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                jo joVar = new jo(outputStream);
                joVar.j((short) -31);
                int[] iArr = new int[4];
                int[] iArr2 = new int[4];
                lk0[] lk0VarArr = ck0.c;
                int i9 = 0;
                while (true) {
                    ck0Var = this.a;
                    if (i9 >= i8) {
                        break;
                    }
                    lk0 lk0Var = lk0VarArr[i9];
                    int i10 = 0;
                    while (true) {
                        lk0[] lk0VarArr2 = ck0.c;
                        if (i10 < i8) {
                            ck0Var.a(i10).remove(lk0Var.b);
                            i10++;
                            i8 = 4;
                        }
                    }
                    i9++;
                    i8 = 4;
                }
                Map mapA = ck0Var.a(1);
                ByteOrder byteOrder2 = ck0Var.b;
                if (!mapA.isEmpty()) {
                    ck0Var.a(0).put(ck0.c[1].b, yj0.a(0L, byteOrder2));
                }
                if (!ck0Var.a(2).isEmpty()) {
                    ck0Var.a(0).put(ck0.c[2].b, yj0.a(0L, byteOrder2));
                }
                if (!ck0Var.a(3).isEmpty()) {
                    ck0Var.a(1).put(ck0.c[3].b, yj0.a(0L, byteOrder2));
                }
                int i11 = 0;
                while (true) {
                    lk0[] lk0VarArr3 = ck0.c;
                    if (i11 >= 4) {
                        break;
                    }
                    Iterator it = ck0Var.a(i11).entrySet().iterator();
                    int i12 = 0;
                    while (it.hasNext()) {
                        yj0 yj0Var = (yj0) ((Map.Entry) it.next()).getValue();
                        int i13 = yj0.f[yj0Var.a] * yj0Var.b;
                        if (i13 > 4) {
                            i12 += i13;
                        }
                    }
                    iArr2[i11] = iArr2[i11] + i12;
                    i11++;
                }
                int i14 = 0;
                int size = 8;
                while (true) {
                    lk0[] lk0VarArr4 = ck0.c;
                    if (i14 >= 4) {
                        break;
                    }
                    if (!ck0Var.a(i14).isEmpty()) {
                        iArr[i14] = size;
                        size += (ck0Var.a(i14).size() * 12) + 6 + iArr2[i14];
                    }
                    i14++;
                }
                int i15 = size + 8;
                if (!ck0Var.a(1).isEmpty()) {
                    ck0Var.a(0).put(ck0.c[1].b, yj0.a(iArr[1], byteOrder2));
                }
                if (!ck0Var.a(2).isEmpty()) {
                    ck0Var.a(0).put(ck0.c[2].b, yj0.a(iArr[2], byteOrder2));
                }
                if (!ck0Var.a(3).isEmpty()) {
                    ck0Var.a(1).put(ck0.c[3].b, yj0.a(iArr[3], byteOrder2));
                }
                joVar.j((short) i15);
                joVar.write(j);
                joVar.j(byteOrder2 == ByteOrder.BIG_ENDIAN ? (short) 19789 : (short) 18761);
                joVar.c = byteOrder2;
                joVar.j((short) 42);
                joVar.e(8);
                int i16 = 0;
                while (true) {
                    lk0[] lk0VarArr5 = ck0.c;
                    if (i16 >= 4) {
                        break;
                    }
                    if (!ck0Var.a(i16).isEmpty()) {
                        joVar.j((short) ck0Var.a(i16).size());
                        int size2 = (ck0Var.a(i16).size() * 12) + iArr[i16] + 2 + 4;
                        for (Map.Entry entry : ck0Var.a(i16).entrySet()) {
                            lk0 lk0Var2 = (lk0) ((HashMap) bk0.f.get(i16)).get(entry.getKey());
                            hh1.d(lk0Var2, "Tag not supported: " + ((String) entry.getKey()) + ". Tag needs to be ported from ExifInterface to ExifData.");
                            int i17 = lk0Var2.a;
                            yj0 yj0Var2 = (yj0) entry.getValue();
                            int[] iArr3 = yj0.f;
                            int i18 = yj0Var2.a;
                            int i19 = yj0Var2.b;
                            int i20 = iArr3[i18] * i19;
                            joVar.j((short) i17);
                            joVar.j((short) yj0Var2.a);
                            joVar.e(i19);
                            if (i20 > 4) {
                                joVar.e(size2);
                                size2 += i20;
                            } else {
                                joVar.write(yj0Var2.c);
                                if (i20 < 4) {
                                    for (int i21 = 4; i20 < i21; i21 = 4) {
                                        joVar.b.write(0);
                                        i20++;
                                    }
                                }
                            }
                        }
                        joVar.e(0);
                        Iterator it2 = ck0Var.a(i16).entrySet().iterator();
                        while (it2.hasNext()) {
                            byte[] bArr2 = ((yj0) ((Map.Entry) it2.next()).getValue()).c;
                            if (bArr2.length > 4) {
                                joVar.write(bArr2, 0, bArr2.length);
                            }
                        }
                    }
                    i16++;
                }
                joVar.c = ByteOrder.BIG_ENDIAN;
            } else if (i7 != 1) {
                continue;
            } else {
                int iMin4 = Math.min(i4, 4 - byteBuffer.position());
                byteBuffer.put(bArr, i3, iMin4);
                i3 += iMin4;
                i4 -= iMin4;
                if (byteBuffer.position() == 2 && byteBuffer.getShort() == -39) {
                    ((FilterOutputStream) this).out.write(byteBuffer.array(), 0, 2);
                    byteBuffer.rewind();
                }
                if (byteBuffer.position() < 4) {
                    return;
                }
                byteBuffer.rewind();
                short s = byteBuffer.getShort();
                if (s == -31) {
                    this.f = (byteBuffer.getShort() & 65535) - 2;
                    this.e = 2;
                } else if (s < -64 || s > -49 || s == -60 || s == -56 || s == -52) {
                    ((FilterOutputStream) this).out.write(byteBuffer.array(), 0, 4);
                    this.i = (byteBuffer.getShort() & 65535) - 2;
                } else {
                    ((FilterOutputStream) this).out.write(byteBuffer.array(), 0, 4);
                    this.e = 2;
                }
                byteBuffer.rewind();
            }
        }
        if (i4 > 0) {
            ((FilterOutputStream) this).out.write(bArr, i3, i4);
        }
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(int i) throws IOException {
        byte[] bArr = this.b;
        bArr[0] = (byte) (i & 255);
        write(bArr);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }
}
