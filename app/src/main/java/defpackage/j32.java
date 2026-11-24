package defpackage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j32 implements Runnable {
    public final qp a;
    public volatile AtomicInteger b = new AtomicInteger(0);
    public final /* synthetic */ m32 c;

    public j32(m32 m32Var, qp qpVar) {
        this.c = m32Var;
        this.a = qpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        rp1 rp1Var;
        String strConcat = "OkHttp ".concat(((ey0) this.c.b.b).g());
        m32 m32Var = this.c;
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(strConcat);
        try {
            m32Var.f.i();
            boolean z = false;
            try {
                try {
                    try {
                        this.a.d(m32Var, m32Var.g());
                        rp1Var = m32Var.a;
                    } catch (IOException e) {
                        e = e;
                        z = true;
                        if (z) {
                            ex1 ex1Var = ex1.a;
                            ex1 ex1Var2 = ex1.a;
                            String strConcat2 = "Callback failure for ".concat(m32.a(m32Var));
                            ex1Var2.getClass();
                            ex1.i(strConcat2, 4, e);
                        } else {
                            this.a.m(m32Var, e);
                        }
                        rp1Var = m32Var.a;
                    } catch (Throwable th) {
                        th = th;
                        z = true;
                        m32Var.d();
                        if (!z) {
                            IOException iOException = new IOException("canceled due to " + th);
                            gn4.a(iOException, th);
                            this.a.m(m32Var, iOException);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    m32Var.a.a.j(this);
                    throw th2;
                }
            } catch (IOException e2) {
                e = e2;
            } catch (Throwable th3) {
                th = th3;
            }
            rp1Var.a.j(this);
            threadCurrentThread.setName(name);
        } catch (Throwable th4) {
            threadCurrentThread.setName(name);
            throw th4;
        }
    }
}
