package defpackage;

import java.io.IOException;
import java.net.Socket;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ux {
    public boolean a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;

    public IOException a(boolean z, boolean z2, IOException iOException) {
        m32 m32Var = (m32) this.b;
        if (iOException != null) {
            e(iOException);
        }
        return m32Var.h(this, z2, z, iOException);
    }

    public p32 b() {
        m32 m32Var = (m32) this.b;
        if (m32Var.s) {
            og.n("Check failed.");
            return null;
        }
        m32Var.s = true;
        m32Var.f.j();
        q32 q32VarH = ((rj0) this.d).h();
        q32VarH.getClass();
        Socket socket = q32VarH.d;
        socket.getClass();
        i32 i32Var = q32VarH.h;
        i32Var.getClass();
        h32 h32Var = q32VarH.i;
        h32Var.getClass();
        socket.setSoTimeout(0);
        q32VarH.k();
        return new p32(i32Var, h32Var, this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int c(q91 q91Var, r7 r7Var, boolean z) {
        int i;
        Object[] objArr;
        int i2;
        int i3;
        mw0 mw0Var = (mw0) this.c;
        pw0 pw0Var = (pw0) this.e;
        if (this.a) {
            return 0;
        }
        try {
            this.a = true;
            l11 l11VarP = ((wj1) this.d).p(q91Var, r7Var);
            if1 if1Var = (if1) l11VarP.b;
            int iF = if1Var.f();
            while (true) {
                if (i >= iF) {
                    objArr = true;
                    break;
                }
                ny1 ny1Var = (ny1) if1Var.g(i);
                i = (ny1Var.d || ny1Var.h) ? 0 : i + 1;
                objArr = false;
                break;
            }
            int iF2 = if1Var.f();
            for (int i4 = 0; i4 < iF2; i4++) {
                ny1 ny1Var2 = (ny1) if1Var.g(i4);
                if (objArr != false || y11.b(ny1Var2)) {
                    ((n71) this.b).A(ny1Var2.c, (pw0) this.e, ny1Var2.i, true);
                    if (!pw0Var.a.h()) {
                        mw0Var.a(ny1Var2.a, pw0Var, y11.b(ny1Var2));
                        pw0Var.clear();
                    }
                }
            }
            boolean zB = mw0Var.b(l11VarP, z);
            int iF3 = if1Var.f();
            int i5 = 0;
            while (true) {
                if (i5 >= iF3) {
                    i2 = 0;
                    break;
                }
                ny1 ny1Var3 = (ny1) if1Var.g(i5);
                if (!jp1.b(y11.f(ny1Var3, true), 0L) && ny1Var3.b()) {
                    i2 = 1;
                    break;
                }
                i5++;
            }
            int iF4 = if1Var.f();
            for (int i6 = 0; i6 < iF4; i6++) {
                if (((ny1) if1Var.g(i6)).b()) {
                    i3 = 1;
                    return (zB ? 1 : 0) | (i2 << 1) | (i3 << 2);
                }
            }
            i3 = 0;
            return (zB ? 1 : 0) | (i2 << 1) | (i3 << 2);
        } finally {
            this.a = false;
        }
    }

    public y62 d(boolean z) throws IOException {
        try {
            y62 y62VarG = ((rj0) this.d).g(z);
            if (y62VarG == null) {
                return y62VarG;
            }
            y62VarG.m = this;
            return y62VarG;
        } catch (IOException e) {
            e(e);
            throw e;
        }
    }

    public void e(IOException iOException) {
        this.a = true;
        ((sj0) this.c).b(iOException);
        q32 q32VarH = ((rj0) this.d).h();
        m32 m32Var = (m32) this.b;
        synchronized (q32VarH) {
            try {
                if (!(iOException instanceof wr2)) {
                    if (!(q32VarH.g != null) || (iOException instanceof y30)) {
                        q32VarH.j = true;
                        if (q32VarH.m == 0) {
                            q32.d(m32Var.a, q32VarH.b, iOException);
                            q32VarH.l++;
                        }
                    }
                } else if (((wr2) iOException).a == 8) {
                    int i = q32VarH.n + 1;
                    q32VarH.n = i;
                    if (i > 1) {
                        q32VarH.j = true;
                        q32VarH.l++;
                    }
                } else if (((wr2) iOException).a != 9 || !m32Var.x) {
                    q32VarH.j = true;
                    q32VarH.l++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(int i, int i2) {
        if (i < 0.0f) {
            c11.a("Index should be non-negative (" + i + ')');
        }
        ((hu1) this.b).h(i);
        z81 z81Var = (z81) this.e;
        if (i != z81Var.b) {
            z81Var.b = i;
            int i3 = (i / 30) * 30;
            z81Var.a.setValue(ky3.f(Math.max(i3 - 100, 0), i3 + 130));
        }
        ((hu1) this.c).h(i2);
    }
}
