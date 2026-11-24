package defpackage;

import java.io.EOFException;
import java.io.IOException;
import java.net.Proxy;
import java.net.Socket;
import java.nio.channels.Channel;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hx0 implements rj0 {
    public int a;
    public final Object b;
    public Object c;
    public Object d;
    public Channel e;
    public Object f;
    public Object g;

    public hx0(rp1 rp1Var, q32 q32Var, i32 i32Var, h32 h32Var) {
        i32Var.getClass();
        h32Var.getClass();
        this.b = rp1Var;
        this.c = q32Var;
        this.d = i32Var;
        this.e = h32Var;
        i32Var.getClass();
        fw0 fw0Var = new fw0();
        fw0Var.b = i32Var;
        fw0Var.a = 262144L;
        this.f = fw0Var;
    }

    @Override // defpackage.rj0
    public wk2 a(lj1 lj1Var, long j) {
        if ("chunked".equalsIgnoreCase(((ew0) lj1Var.d).a("Transfer-Encoding"))) {
            if (this.a == 1) {
                this.a = 2;
                return new dx0(this);
            }
            dk0.e(this.a, "state: ");
            return null;
        }
        if (j == -1) {
            og.n("Cannot stream a request body without chunked encoding or a known content length!");
            return null;
        }
        if (this.a == 1) {
            this.a = 2;
            return new ub0(this);
        }
        dk0.e(this.a, "state: ");
        return null;
    }

    @Override // defpackage.rj0
    public void b(lj1 lj1Var) {
        Proxy.Type type = ((q32) this.c).b.b.type();
        type.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append((String) lj1Var.c);
        sb.append(' ');
        ey0 ey0Var = (ey0) lj1Var.b;
        if (ey0Var.i || type != Proxy.Type.HTTP) {
            String strB = ey0Var.b();
            String strD = ey0Var.d();
            if (strD != null) {
                strB = strB + '?' + strD;
            }
            sb.append(strB);
        } else {
            sb.append(ey0Var);
        }
        sb.append(" HTTP/1.1");
        j((ew0) lj1Var.d, sb.toString());
    }

    @Override // defpackage.rj0
    public fp2 c(z62 z62Var) {
        if (!cy0.a(z62Var)) {
            return i(0L);
        }
        if ("chunked".equalsIgnoreCase(z62.c(z62Var, "Transfer-Encoding"))) {
            ey0 ey0Var = (ey0) z62Var.a.b;
            if (this.a == 4) {
                this.a = 5;
                return new ex0(this, ey0Var);
            }
            dk0.e(this.a, "state: ");
            return null;
        }
        long jK = z53.k(z62Var);
        if (jK != -1) {
            return i(jK);
        }
        if (this.a != 4) {
            dk0.e(this.a, "state: ");
            return null;
        }
        this.a = 5;
        ((q32) this.c).k();
        return new gx0(this);
    }

    @Override // defpackage.rj0
    public void cancel() {
        Socket socket = ((q32) this.c).c;
        if (socket != null) {
            z53.e(socket);
        }
    }

    @Override // defpackage.rj0
    public void d() {
        ((xn) this.e).flush();
    }

    @Override // defpackage.rj0
    public void e() {
        ((xn) this.e).flush();
    }

    @Override // defpackage.rj0
    public long f(z62 z62Var) {
        if (!cy0.a(z62Var)) {
            return 0L;
        }
        if ("chunked".equalsIgnoreCase(z62.c(z62Var, "Transfer-Encoding"))) {
            return -1L;
        }
        return z53.k(z62Var);
    }

    @Override // defpackage.rj0
    public y62 g(boolean z) {
        fw0 fw0Var = (fw0) this.f;
        int i = this.a;
        if (i != 1 && i != 2 && i != 3) {
            dk0.e(this.a, "state: ");
            return null;
        }
        try {
            String strZ = ((yn) fw0Var.b).z(fw0Var.a);
            fw0Var.a -= (long) strZ.length();
            t9 t9VarC = na4.c(strZ);
            int i2 = t9VarC.b;
            y62 y62Var = new y62();
            y62Var.b = (y12) t9VarC.c;
            y62Var.c = i2;
            y62Var.d = (String) t9VarC.e;
            y62Var.f = fw0Var.d().d();
            if (z && i2 == 100) {
                return null;
            }
            if (i2 == 100) {
                this.a = 3;
                return y62Var;
            }
            if (102 > i2 || i2 >= 200) {
                this.a = 4;
                return y62Var;
            }
            this.a = 3;
            return y62Var;
        } catch (EOFException e) {
            throw new IOException("unexpected end of stream on ".concat(((q32) this.c).b.a.h.g()), e);
        }
    }

    @Override // defpackage.rj0
    public q32 h() {
        return (q32) this.c;
    }

    public fx0 i(long j) {
        if (this.a == 4) {
            this.a = 5;
            return new fx0(this, j);
        }
        dk0.e(this.a, "state: ");
        return null;
    }

    public void j(ew0 ew0Var, String str) {
        xn xnVar = (xn) this.e;
        if (this.a != 0) {
            dk0.e(this.a, "state: ");
            return;
        }
        xnVar.G(str).G("\r\n");
        int size = ew0Var.size();
        for (int i = 0; i < size; i++) {
            xnVar.G(ew0Var.b(i)).G(": ").G(ew0Var.f(i)).G("\r\n");
        }
        xnVar.G("\r\n");
        this.a = 1;
    }

    public hx0(mw2 mw2Var) {
        mw2Var.getClass();
        this.b = mw2Var;
        this.g = kx0.a;
    }
}
