package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ov0 implements fp2 {
    public byte a;
    public final i32 b;
    public final Inflater c;
    public final u01 e;
    public final CRC32 f;

    public ov0(fp2 fp2Var) {
        fp2Var.getClass();
        i32 i32Var = new i32(fp2Var);
        this.b = i32Var;
        Inflater inflater = new Inflater(true);
        this.c = inflater;
        this.e = new u01(i32Var, inflater);
        this.f = new CRC32();
    }

    public static void c(int i, int i2, String str) throws IOException {
        if (i2 != i) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i2), Integer.valueOf(i)}, 3)));
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.e.close();
    }

    @Override // defpackage.fp2
    public final u03 d() {
        return this.b.a.d();
    }

    public final void e(ln lnVar, long j, long j2) {
        ze2 ze2Var = lnVar.a;
        ze2Var.getClass();
        while (true) {
            int i = ze2Var.c;
            int i2 = ze2Var.b;
            if (j < i - i2) {
                break;
            }
            j -= (long) (i - i2);
            ze2Var = ze2Var.f;
            ze2Var.getClass();
        }
        while (j2 > 0) {
            int i3 = (int) (((long) ze2Var.b) + j);
            int iMin = (int) Math.min(ze2Var.c - i3, j2);
            this.f.update(ze2Var.a, i3, iMin);
            j2 -= (long) iMin;
            ze2Var = ze2Var.f;
            ze2Var.getClass();
            j = 0;
        }
    }

    @Override // defpackage.fp2
    public final long f(long j, ln lnVar) throws IOException {
        long j2;
        ov0 ov0Var = this;
        byte b = ov0Var.a;
        CRC32 crc32 = ov0Var.f;
        i32 i32Var = ov0Var.b;
        if (b == 0) {
            i32Var.F(10L);
            ln lnVar2 = i32Var.b;
            byte bJ = lnVar2.j(3L);
            boolean z = ((bJ >> 1) & 1) == 1;
            if (z) {
                ov0Var.e(lnVar2, 0L, 10L);
            }
            c(8075, i32Var.readShort(), "ID1ID2");
            i32Var.skip(8L);
            if (((bJ >> 2) & 1) == 1) {
                i32Var.F(2L);
                if (z) {
                    e(lnVar2, 0L, 2L);
                }
                short s = lnVar2.readShort();
                long j3 = ((short) (((s & 255) << 8) | ((s & 65280) >>> 8))) & 65535;
                i32Var.F(j3);
                if (z) {
                    e(lnVar2, 0L, j3);
                }
                i32Var.skip(j3);
            }
            if (((bJ >> 3) & 1) == 1) {
                long jE = i32Var.e((byte) 0, 0L, Long.MAX_VALUE);
                if (jE == -1) {
                    throw new EOFException();
                }
                if (z) {
                    j2 = 2;
                    e(lnVar2, 0L, jE + 1);
                } else {
                    j2 = 2;
                }
                i32Var.skip(jE + 1);
            } else {
                j2 = 2;
            }
            if (((bJ >> 4) & 1) == 1) {
                j2 = j2;
                long jE2 = i32Var.e((byte) 0, 0L, Long.MAX_VALUE);
                if (jE2 == -1) {
                    throw new EOFException();
                }
                if (z) {
                    ov0Var = this;
                    ov0Var.e(lnVar2, 0L, jE2 + 1);
                } else {
                    ov0Var = this;
                }
                i32Var.skip(jE2 + 1);
            } else {
                ov0Var = this;
            }
            if (z) {
                i32Var.F(j2);
                short s2 = lnVar2.readShort();
                c((short) (((s2 & 255) << 8) | ((s2 & 65280) >>> 8)), (short) crc32.getValue(), "FHCRC");
                crc32.reset();
            }
            ov0Var.a = (byte) 1;
        }
        if (ov0Var.a == 1) {
            long j4 = lnVar.b;
            long jF = ov0Var.e.f(8192L, lnVar);
            if (jF != -1) {
                ov0Var.e(lnVar, j4, jF);
                return jF;
            }
            ov0Var.a = (byte) 2;
        }
        if (ov0Var.a == 2) {
            c(i32Var.j(), (int) crc32.getValue(), "CRC");
            c(i32Var.j(), (int) ov0Var.c.getBytesWritten(), "ISIZE");
            ov0Var.a = (byte) 3;
            if (!i32Var.c()) {
                dk0.h("gzip finished without exhausting source");
                return 0L;
            }
        }
        return -1L;
    }
}
