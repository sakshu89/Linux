package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class au3 implements Cloneable {
    public final gu3 a;
    public gu3 b;

    public au3(gu3 gu3Var) {
        this.a = gu3Var;
        if (gu3Var.g()) {
            og.i("Default instance must be immutable.");
            throw null;
        }
        this.b = (gu3) gu3Var.i(4, null);
    }

    public final gu3 a() {
        gu3 gu3VarB = b();
        if (gu3.f(gu3VarB, true)) {
            return gu3VarB;
        }
        throw new jv3();
    }

    public gu3 b() {
        boolean zG = this.b.g();
        gu3 gu3Var = this.b;
        if (!zG) {
            return gu3Var;
        }
        gu3Var.getClass();
        bv3.c.a(gu3Var.getClass()).g(gu3Var);
        gu3Var.c();
        return this.b;
    }

    public /* bridge */ jt3 c() {
        return b();
    }

    public final Object clone() {
        au3 au3Var = (au3) this.a.i(5, null);
        au3Var.b = b();
        return au3Var;
    }

    public final void d() {
        if (this.b.g()) {
            return;
        }
        e();
    }

    public void e() {
        gu3 gu3Var = (gu3) this.a.i(4, null);
        bv3.c.a(gu3Var.getClass()).e(gu3Var, this.b);
        this.b = gu3Var;
    }
}
