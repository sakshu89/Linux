package defpackage;

import com.ibm.icu.text.DateTimePatternGenerator;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class tx0 implements Closeable {
    public static final yh2 j0;
    public long H;
    public final yh2 X;
    public yh2 Y;
    public long Z;
    public final kx0 a;
    public final LinkedHashMap b = new LinkedHashMap();
    public final String c;
    public long c0;
    public long d0;
    public int e;
    public long e0;
    public int f;
    public final Socket f0;
    public final by0 g0;
    public final nx0 h0;
    public boolean i;
    public final LinkedHashSet i0;
    public final mw2 j;
    public final lw2 k;
    public final lw2 n;
    public final lw2 s;
    public final su0 t;
    public long u;
    public long v;
    public long w;
    public long x;

    static {
        yh2 yh2Var = new yh2();
        yh2Var.b(7, DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH);
        yh2Var.b(5, 16384);
        j0 = yh2Var;
    }

    public tx0(hx0 hx0Var) {
        this.a = (kx0) hx0Var.g;
        String str = (String) hx0Var.d;
        if (str == null) {
            g31.f("connectionName");
            throw null;
        }
        this.c = str;
        this.f = 3;
        mw2 mw2Var = (mw2) hx0Var.b;
        this.j = mw2Var;
        lw2 lw2VarE = mw2Var.e();
        this.k = lw2VarE;
        this.n = mw2Var.e();
        this.s = mw2Var.e();
        this.t = su0.j;
        yh2 yh2Var = new yh2();
        yh2Var.b(7, 16777216);
        this.X = yh2Var;
        yh2 yh2Var2 = j0;
        this.Y = yh2Var2;
        this.e0 = yh2Var2.a();
        Socket socket = (Socket) hx0Var.c;
        if (socket == null) {
            g31.f("socket");
            throw null;
        }
        this.f0 = socket;
        h32 h32Var = (h32) hx0Var.f;
        if (h32Var == null) {
            g31.f("sink");
            throw null;
        }
        this.g0 = new by0(h32Var);
        i32 i32Var = (i32) hx0Var.e;
        if (i32Var == null) {
            g31.f("source");
            throw null;
        }
        this.h0 = new nx0(this, new wx0(i32Var));
        this.i0 = new LinkedHashSet();
        int i = hx0Var.a;
        if (i != 0) {
            long nanos = TimeUnit.MILLISECONDS.toNanos(i);
            lw2VarE.c(new rx0(str.concat(" ping"), this, nanos, 0), nanos);
        }
    }

    public final void c(int i, int i2, IOException iOException) {
        int i3;
        Object[] array = null;
        if (i == 0 || i2 == 0) {
            throw null;
        }
        byte[] bArr = z53.a;
        try {
            o(i);
        } catch (IOException unused) {
        }
        synchronized (this) {
            if (!this.b.isEmpty()) {
                array = this.b.values().toArray(new ay0[0]);
                this.b.clear();
            }
        }
        ay0[] ay0VarArr = (ay0[]) array;
        if (ay0VarArr != null) {
            for (ay0 ay0Var : ay0VarArr) {
                try {
                    ay0Var.c(i2, iOException);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.g0.close();
        } catch (IOException unused3) {
        }
        try {
            this.f0.close();
        } catch (IOException unused4) {
        }
        this.k.e();
        this.n.e();
        this.s.e();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        c(1, 9, null);
    }

    public final synchronized ay0 e(int i) {
        return (ay0) this.b.get(Integer.valueOf(i));
    }

    public final void flush() {
        this.g0.flush();
    }

    public final synchronized ay0 j(int i) {
        ay0 ay0Var;
        ay0Var = (ay0) this.b.remove(Integer.valueOf(i));
        notifyAll();
        return ay0Var;
    }

    public final void o(int i) {
        if (i == 0) {
            throw null;
        }
        synchronized (this.g0) {
            synchronized (this) {
                if (this.i) {
                    return;
                }
                this.i = true;
                this.g0.o(this.e, z53.a, i);
            }
        }
    }

    public final synchronized void q(long j) {
        long j2 = this.Z + j;
        this.Z = j2;
        long j3 = j2 - this.c0;
        if (j3 >= this.X.a() / 2) {
            w(0, j3);
            this.c0 += j3;
        }
    }

    public final void r(int i, boolean z, ln lnVar, long j) {
        long j2;
        long j3;
        int iMin;
        long j4;
        if (j == 0) {
            this.g0.e(z, i, lnVar, 0);
            return;
        }
        while (j > 0) {
            synchronized (this) {
                while (true) {
                    try {
                        try {
                            j2 = this.d0;
                            j3 = this.e0;
                            if (j2 >= j3) {
                                if (!this.b.containsKey(Integer.valueOf(i))) {
                                    throw new IOException("stream closed");
                                }
                                wait();
                            }
                        } catch (InterruptedException unused) {
                            Thread.currentThread().interrupt();
                            throw new InterruptedIOException();
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                iMin = Math.min((int) Math.min(j, j3 - j2), this.g0.c);
                j4 = iMin;
                this.d0 += j4;
            }
            j -= j4;
            this.g0.e(z && j == 0, i, lnVar, iMin);
        }
    }

    public final void v(int i, int i2) {
        if (i2 == 0) {
            throw null;
        }
        this.k.c(new mx0(this.c + '[' + i + "] writeSynReset", this, i, i2, 2), 0L);
    }

    public final void w(int i, long j) {
        this.k.c(new sx0(this.c + '[' + i + "] windowUpdate", this, i, j), 0L);
    }
}
