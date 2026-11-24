package defpackage;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class by0 implements Closeable {
    public static final Logger i = Logger.getLogger(ix0.class.getName());
    public final xn a;
    public final ln b;
    public int c;
    public boolean e;
    public final ax0 f;

    public by0(h32 h32Var) {
        h32Var.getClass();
        this.a = h32Var;
        ln lnVar = new ln();
        this.b = lnVar;
        this.c = 16384;
        this.f = new ax0(lnVar);
    }

    public final synchronized void c(yh2 yh2Var) {
        try {
            yh2Var.getClass();
            if (this.e) {
                throw new IOException("closed");
            }
            int i2 = this.c;
            int i3 = yh2Var.a;
            if ((i3 & 32) != 0) {
                i2 = yh2Var.b[5];
            }
            this.c = i2;
            if (((i3 & 2) != 0 ? yh2Var.b[1] : -1) != -1) {
                ax0 ax0Var = this.f;
                int i4 = (i3 & 2) != 0 ? yh2Var.b[1] : -1;
                ax0Var.getClass();
                int iMin = Math.min(i4, 16384);
                int i5 = ax0Var.d;
                if (i5 != iMin) {
                    if (iMin < i5) {
                        ax0Var.b = Math.min(ax0Var.b, iMin);
                    }
                    ax0Var.c = true;
                    ax0Var.d = iMin;
                    int i6 = ax0Var.h;
                    if (iMin < i6) {
                        if (iMin == 0) {
                            dw0[] dw0VarArr = ax0Var.e;
                            qg.l(0, dw0VarArr.length, null, dw0VarArr);
                            ax0Var.f = ax0Var.e.length - 1;
                            ax0Var.g = 0;
                            ax0Var.h = 0;
                        } else {
                            ax0Var.a(i6 - iMin);
                        }
                    }
                }
            }
            j(0, 0, 4, 1);
            this.a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        this.e = true;
        this.a.close();
    }

    public final synchronized void e(boolean z, int i2, ln lnVar, int i3) {
        if (this.e) {
            throw new IOException("closed");
        }
        j(i2, i3, 0, z ? 1 : 0);
        if (i3 > 0) {
            xn xnVar = this.a;
            lnVar.getClass();
            xnVar.u(i3, lnVar);
        }
    }

    public final synchronized void flush() {
        if (this.e) {
            throw new IOException("closed");
        }
        this.a.flush();
    }

    public final void j(int i2, int i3, int i4, int i5) {
        Level level = Level.FINE;
        Logger logger = i;
        if (logger.isLoggable(level)) {
            logger.fine(ix0.a(false, i2, i3, i4, i5));
        }
        if (i3 > this.c) {
            throw new IllegalArgumentException(("FRAME_SIZE_ERROR length > " + this.c + ": " + i3).toString());
        }
        if ((Integer.MIN_VALUE & i2) != 0) {
            og.g(ky0.h(i2, "reserved bit set: "));
            return;
        }
        byte[] bArr = z53.a;
        xn xnVar = this.a;
        xnVar.getClass();
        xnVar.writeByte((i3 >>> 16) & 255);
        xnVar.writeByte((i3 >>> 8) & 255);
        xnVar.writeByte(i3 & 255);
        xnVar.writeByte(i4 & 255);
        xnVar.writeByte(i5 & 255);
        xnVar.writeInt(i2 & Integer.MAX_VALUE);
    }

    public final synchronized void o(int i2, byte[] bArr, int i3) {
        try {
            if (i3 == 0) {
                throw null;
            }
            if (this.e) {
                throw new IOException("closed");
            }
            if (cq.x(i3) == -1) {
                throw new IllegalArgumentException("errorCode.httpCode == -1");
            }
            j(0, bArr.length + 8, 7, 0);
            this.a.writeInt(i2);
            this.a.writeInt(cq.x(i3));
            if (bArr.length != 0) {
                this.a.write(bArr);
            }
            this.a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void q(boolean z, int i2, ArrayList arrayList) {
        if (this.e) {
            throw new IOException("closed");
        }
        this.f.d(arrayList);
        long j = this.b.b;
        long jMin = Math.min(this.c, j);
        int i3 = j == jMin ? 4 : 0;
        if (z) {
            i3 |= 1;
        }
        j(i2, (int) jMin, 1, i3);
        this.a.u(jMin, this.b);
        if (j > jMin) {
            long j2 = j - jMin;
            while (j2 > 0) {
                long jMin2 = Math.min(this.c, j2);
                j2 -= jMin2;
                j(i2, (int) jMin2, 9, j2 == 0 ? 4 : 0);
                this.a.u(jMin2, this.b);
            }
        }
    }

    public final synchronized void r(int i2, int i3, boolean z) {
        if (this.e) {
            throw new IOException("closed");
        }
        j(0, 8, 6, z ? 1 : 0);
        this.a.writeInt(i2);
        this.a.writeInt(i3);
        this.a.flush();
    }

    public final synchronized void v(int i2, int i3) {
        try {
            if (i3 == 0) {
                throw null;
            }
            if (this.e) {
                throw new IOException("closed");
            }
            if (cq.x(i3) == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            j(i2, 4, 3, 0);
            this.a.writeInt(cq.x(i3));
            this.a.flush();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void w(int i2, long j) {
        if (this.e) {
            throw new IOException("closed");
        }
        if (j == 0 || j > 2147483647L) {
            throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
        }
        j(i2, 4, 8, 0);
        this.a.writeInt((int) j);
        this.a.flush();
    }
}
