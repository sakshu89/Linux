package defpackage;

import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class cx0 implements fp2 {
    public final xp0 a;
    public boolean b;
    public final /* synthetic */ hx0 c;

    public cx0(hx0 hx0Var) {
        this.c = hx0Var;
        this.a = new xp0(((yn) hx0Var.d).d());
    }

    public final void c() {
        hx0 hx0Var = this.c;
        int i = hx0Var.a;
        if (i == 6) {
            return;
        }
        if (i != 5) {
            throw new IllegalStateException("state: " + hx0Var.a);
        }
        xp0 xp0Var = this.a;
        u03 u03Var = xp0Var.e;
        xp0Var.e = u03.d;
        u03Var.a();
        u03Var.b();
        hx0Var.a = 6;
    }

    @Override // defpackage.fp2
    public final u03 d() {
        return this.a;
    }

    @Override // defpackage.fp2
    public long f(long j, ln lnVar) throws IOException {
        hx0 hx0Var = this.c;
        lnVar.getClass();
        try {
            return ((yn) hx0Var.d).f(j, lnVar);
        } catch (IOException e) {
            ((q32) hx0Var.c).k();
            c();
            throw e;
        }
    }
}
