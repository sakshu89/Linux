package defpackage;

import java.io.IOException;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ay0 {
    public final int a;
    public final tx0 b;
    public long c;
    public long d;
    public long e;
    public long f;
    public final ArrayDeque g;
    public boolean h;
    public final yx0 i;
    public final xx0 j;
    public final zx0 k;
    public final zx0 l;
    public int m;
    public IOException n;

    public ay0(int i, tx0 tx0Var, boolean z, boolean z2, ew0 ew0Var) {
        tx0Var.getClass();
        this.a = i;
        this.b = tx0Var;
        this.f = tx0Var.Y.a();
        ArrayDeque arrayDeque = new ArrayDeque();
        this.g = arrayDeque;
        this.i = new yx0(this, tx0Var.X.a(), z2);
        this.j = new xx0(this, z);
        this.k = new zx0(this);
        this.l = new zx0(this);
        if (ew0Var == null) {
            if (g()) {
                return;
            }
            og.n("remotely-initiated streams should have headers");
            throw null;
        }
        if (g()) {
            og.n("locally-initiated streams shouldn't have headers yet");
            throw null;
        }
        arrayDeque.add(ew0Var);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001c  */
    public final void a() {
        boolean z;
        boolean zH;
        byte[] bArr = z53.a;
        synchronized (this) {
            try {
                yx0 yx0Var = this.i;
                if (yx0Var.b || !yx0Var.f) {
                    z = false;
                } else {
                    xx0 xx0Var = this.j;
                    if (xx0Var.a || xx0Var.c) {
                        z = true;
                    } else {
                        z = false;
                    }
                }
                zH = h();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (z) {
            c(9, null);
        } else {
            if (zH) {
                return;
            }
            this.b.j(this.a);
        }
    }

    public final void b() throws IOException {
        xx0 xx0Var = this.j;
        if (xx0Var.c) {
            dk0.h("stream closed");
            return;
        }
        if (xx0Var.a) {
            dk0.h("stream finished");
            return;
        }
        int i = this.m;
        if (i != 0) {
            IOException iOException = this.n;
            if (iOException != null) {
                throw iOException;
            }
            if (i == 0) {
                throw null;
            }
            throw new wr2(i);
        }
    }

    public final void c(int i, IOException iOException) {
        if (i == 0) {
            throw null;
        }
        if (d(i, iOException)) {
            tx0 tx0Var = this.b;
            tx0Var.getClass();
            tx0Var.g0.v(this.a, i);
        }
    }

    public final boolean d(int i, IOException iOException) {
        byte[] bArr = z53.a;
        synchronized (this) {
            if (this.m != 0) {
                return false;
            }
            this.m = i;
            this.n = iOException;
            notifyAll();
            if (this.i.b && this.j.a) {
                return false;
            }
            this.b.j(this.a);
            return true;
        }
    }

    public final void e(int i) {
        if (i == 0) {
            throw null;
        }
        if (d(i, null)) {
            this.b.v(this.a, i);
        }
    }

    public final xx0 f() {
        synchronized (this) {
            if (!this.h && !g()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.j;
    }

    public final boolean g() {
        boolean z = (this.a & 1) == 1;
        this.b.getClass();
        return true == z;
    }

    public final synchronized boolean h() {
        try {
            if (this.m != 0) {
                return false;
            }
            yx0 yx0Var = this.i;
            if (yx0Var.b || yx0Var.f) {
                xx0 xx0Var = this.j;
                if ((xx0Var.a || xx0Var.c) && this.h) {
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void i(ew0 ew0Var, boolean z) {
        boolean zH;
        ew0Var.getClass();
        byte[] bArr = z53.a;
        synchronized (this) {
            try {
                if (this.h && z) {
                    this.i.getClass();
                } else {
                    this.h = true;
                    this.g.add(ew0Var);
                }
                if (z) {
                    this.i.b = true;
                }
                zH = h();
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zH) {
            return;
        }
        this.b.j(this.a);
    }
}
