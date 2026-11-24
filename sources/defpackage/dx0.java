package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dx0 implements wk2 {
    public final xp0 a;
    public boolean b;
    public final /* synthetic */ hx0 c;

    public dx0(hx0 hx0Var) {
        this.c = hx0Var;
        this.a = new xp0(((xn) hx0Var.e).d());
    }

    @Override // defpackage.wk2, java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() {
        if (this.b) {
            return;
        }
        this.b = true;
        ((xn) this.c.e).G("0\r\n\r\n");
        xp0 xp0Var = this.a;
        u03 u03Var = xp0Var.e;
        xp0Var.e = u03.d;
        u03Var.a();
        u03Var.b();
        this.c.a = 3;
    }

    @Override // defpackage.wk2
    public final u03 d() {
        return this.a;
    }

    @Override // defpackage.wk2, java.io.Flushable
    public final synchronized void flush() {
        if (this.b) {
            return;
        }
        ((xn) this.c.e).flush();
    }

    @Override // defpackage.wk2
    public final void u(long j, ln lnVar) {
        xn xnVar = (xn) this.c.e;
        if (this.b) {
            og.n("closed");
        } else {
            if (j == 0) {
                return;
            }
            xnVar.k(j);
            xnVar.G("\r\n");
            xnVar.u(j, lnVar);
            xnVar.G("\r\n");
        }
    }
}
