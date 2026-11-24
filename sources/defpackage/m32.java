package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class m32 implements Cloneable {
    public volatile ux H;
    public volatile q32 X;
    public final rp1 a;
    public final lj1 b;
    public final boolean c;
    public final r32 e;
    public final l32 f;
    public final AtomicBoolean i;
    public Object j;
    public sj0 k;
    public q32 n;
    public boolean s;
    public ux t;
    public boolean u;
    public boolean v;
    public boolean w;
    public volatile boolean x;

    public m32(rp1 rp1Var, lj1 lj1Var, boolean z) {
        this.a = rp1Var;
        this.b = lj1Var;
        this.c = z;
        this.e = (r32) rp1Var.b.b;
        rp1Var.f.getClass();
        l32 l32Var = new l32(this);
        l32Var.g(rp1Var.e0, TimeUnit.MILLISECONDS);
        this.f = l32Var;
        this.i = new AtomicBoolean();
        this.w = true;
    }

    public static final String a(m32 m32Var) {
        StringBuilder sb = new StringBuilder();
        sb.append(m32Var.x ? "canceled " : "");
        sb.append(m32Var.c ? "web socket" : "call");
        sb.append(" to ");
        sb.append(((ey0) m32Var.b.b).g());
        return sb.toString();
    }

    public final void b(q32 q32Var) {
        byte[] bArr = z53.a;
        if (this.n != null) {
            og.n("Check failed.");
        } else {
            this.n = q32Var;
            q32Var.p.add(new k32(this, this.j));
        }
    }

    public final IOException c(IOException iOException) {
        IOException interruptedIOException;
        Socket socketJ;
        byte[] bArr = z53.a;
        q32 q32Var = this.n;
        if (q32Var != null) {
            synchronized (q32Var) {
                socketJ = j();
            }
            if (this.n == null) {
                if (socketJ != null) {
                    z53.e(socketJ);
                }
            } else if (socketJ != null) {
                og.n("Check failed.");
                return null;
            }
        }
        if (!this.s && this.f.j()) {
            interruptedIOException = new InterruptedIOException("timeout");
            if (iOException != null) {
                interruptedIOException.initCause(iOException);
            }
        } else {
            interruptedIOException = iOException;
        }
        if (iOException != null) {
            interruptedIOException.getClass();
        }
        return interruptedIOException;
    }

    public final Object clone() {
        return new m32(this.a, this.b, this.c);
    }

    public final void d() {
        Socket socket;
        if (this.x) {
            return;
        }
        this.x = true;
        ux uxVar = this.H;
        if (uxVar != null) {
            ((rj0) uxVar.d).cancel();
        }
        q32 q32Var = this.X;
        if (q32Var == null || (socket = q32Var.c) == null) {
            return;
        }
        z53.e(socket);
    }

    public final void e(qp qpVar) {
        j32 j32Var;
        if (!this.i.compareAndSet(false, true)) {
            og.n("Already Executed");
            return;
        }
        ex1 ex1Var = ex1.a;
        this.j = ex1.a.g();
        p6 p6Var = this.a.a;
        j32 j32Var2 = new j32(this, qpVar);
        p6Var.getClass();
        synchronized (p6Var) {
            ((ArrayDeque) p6Var.b).add(j32Var2);
            if (!this.c) {
                String str = ((ey0) this.b.b).d;
                Iterator it = ((ArrayDeque) p6Var.c).iterator();
                do {
                    if (!it.hasNext()) {
                        Iterator it2 = ((ArrayDeque) p6Var.b).iterator();
                        do {
                            if (!it2.hasNext()) {
                                j32Var = null;
                                break;
                            }
                            j32Var = (j32) it2.next();
                        } while (!g31.a(((ey0) j32Var.c.b.b).d, str));
                    } else {
                        j32Var = (j32) it.next();
                    }
                } while (!g31.a(((ey0) j32Var.c.b.b).d, str));
                if (j32Var != null) {
                    j32Var2.b = j32Var.b;
                }
            }
        }
        p6Var.o();
    }

    public final void f(boolean z) {
        ux uxVar;
        synchronized (this) {
            if (!this.w) {
                throw new IllegalStateException("released");
            }
        }
        if (z && (uxVar = this.H) != null) {
            ((rj0) uxVar.d).cancel();
            ((m32) uxVar.b).h(uxVar, true, true, null);
        }
        this.t = null;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x007d  */
    public final z62 g() {
        ArrayList arrayList = new ArrayList();
        rz.q(this.a.c, arrayList);
        arrayList.add(new mm(this.a));
        arrayList.add(new mm(this.a.s));
        int i = 0;
        arrayList.add(new to(i));
        arrayList.add(to.b);
        if (!this.c) {
            rz.q(this.a.e, arrayList);
        }
        arrayList.add(new kp(this.c));
        lj1 lj1Var = this.b;
        rp1 rp1Var = this.a;
        try {
            try {
                z62 z62VarB = new s32(this, arrayList, 0, null, lj1Var, rp1Var.f0, rp1Var.g0, rp1Var.h0).b(lj1Var);
                if (this.x) {
                    z53.d(z62VarB);
                    throw new IOException("Canceled");
                }
                i(null);
                return z62VarB;
            } catch (IOException e) {
                i = 1;
                IOException iOExceptionI = i(e);
                iOExceptionI.getClass();
                throw iOExceptionI;
            }
        } catch (Throwable th) {
            if (i == 0) {
                i(null);
            }
            throw th;
        }
        if (i == 0) {
            i(null);
        }
        throw th;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x001e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:17:0x0020 A[Catch: all -> 0x0016, TryCatch #1 {all -> 0x0016, blocks: (B:8:0x0011, B:17:0x0020, B:19:0x0024, B:20:0x0026, B:22:0x002a, B:27:0x0033, B:29:0x0037, B:14:0x001a), top: B:53:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:19:0x0024 A[Catch: all -> 0x0016, TryCatch #1 {all -> 0x0016, blocks: (B:8:0x0011, B:17:0x0020, B:19:0x0024, B:20:0x0026, B:22:0x002a, B:27:0x0033, B:29:0x0037, B:14:0x001a), top: B:53:0x0011 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x0030  */
    public final IOException h(ux uxVar, boolean z, boolean z2, IOException iOException) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        uxVar.getClass();
        if (uxVar.equals(this.H)) {
            synchronized (this) {
                z3 = false;
                if (z) {
                    try {
                        if (this.u) {
                            if (z) {
                                this.u = false;
                            }
                            if (z2) {
                                this.v = false;
                            }
                            z5 = this.u;
                            if (z5) {
                                z6 = false;
                            } else {
                                z6 = false;
                            }
                            if (!z5) {
                                z3 = true;
                            }
                            z4 = z3;
                            z3 = z6;
                        } else if (z2 || !this.v) {
                            z4 = false;
                        } else {
                            if (z) {
                                this.u = false;
                            }
                            if (z2) {
                                this.v = false;
                            }
                            z5 = this.u;
                            if (z5 || this.v) {
                                z6 = false;
                            } else {
                                z6 = true;
                            }
                            if (!z5 && !this.v && !this.w) {
                                z3 = true;
                            }
                            z4 = z3;
                            z3 = z6;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                } else {
                    if (z2) {
                    }
                    z4 = false;
                }
            }
            if (z3) {
                this.H = null;
                q32 q32Var = this.n;
                if (q32Var != null) {
                    synchronized (q32Var) {
                        q32Var.m++;
                    }
                }
            }
            if (z4) {
                return c(iOException);
            }
        }
        return iOException;
    }

    public final IOException i(IOException iOException) {
        boolean z;
        synchronized (this) {
            z = false;
            if (this.w) {
                this.w = false;
                if (!this.u && !this.v) {
                    z = true;
                }
            }
        }
        return z ? c(iOException) : iOException;
    }

    public final Socket j() {
        q32 q32Var = this.n;
        q32Var.getClass();
        byte[] bArr = z53.a;
        ArrayList arrayList = q32Var.p;
        int size = arrayList.size();
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i = -1;
                break;
            }
            Object obj = arrayList.get(i2);
            i2++;
            if (g31.a(((Reference) obj).get(), this)) {
                break;
            }
            i++;
        }
        if (i == -1) {
            og.n("Check failed.");
            return null;
        }
        arrayList.remove(i);
        this.n = null;
        if (!arrayList.isEmpty()) {
            return null;
        }
        q32Var.q = System.nanoTime();
        r32 r32Var = this.e;
        ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) r32Var.e;
        lw2 lw2Var = (lw2) r32Var.b;
        byte[] bArr2 = z53.a;
        if (!q32Var.j) {
            lw2Var.c((qx0) r32Var.c, 0L);
            return null;
        }
        q32Var.j = true;
        concurrentLinkedQueue.remove(q32Var);
        if (concurrentLinkedQueue.isEmpty()) {
            lw2Var.a();
        }
        Socket socket = q32Var.d;
        socket.getClass();
        return socket;
    }
}
