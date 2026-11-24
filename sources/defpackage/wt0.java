package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class wt0 implements Cloneable {
    public final yt0 a;
    public yt0 b;

    public wt0(yt0 yt0Var) {
        this.a = yt0Var;
        if (yt0Var.g()) {
            og.i("Default instance must be immutable.");
            throw null;
        }
        this.b = yt0Var.i();
    }

    public final yt0 a() {
        yt0 yt0VarB = b();
        yt0VarB.getClass();
        if (yt0.f(yt0VarB, true)) {
            return yt0VarB;
        }
        throw new o43();
    }

    public final yt0 b() {
        boolean zG = this.b.g();
        yt0 yt0Var = this.b;
        if (!zG) {
            return yt0Var;
        }
        yt0Var.getClass();
        w12 w12Var = w12.c;
        w12Var.getClass();
        w12Var.a(yt0Var.getClass()).c(yt0Var);
        yt0Var.h();
        return this.b;
    }

    public final void c() {
        if (this.b.g()) {
            return;
        }
        yt0 yt0VarI = this.a.i();
        yt0 yt0Var = this.b;
        w12 w12Var = w12.c;
        w12Var.getClass();
        w12Var.a(yt0VarI.getClass()).b(yt0VarI, yt0Var);
        this.b = yt0VarI;
    }

    public final Object clone() {
        wt0 wt0Var = (wt0) this.a.c(5);
        wt0Var.b = b();
        return wt0Var;
    }
}
