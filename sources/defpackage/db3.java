package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class db3 {
    public final pb3 a;
    public q11[] b;

    public db3() {
        this(new pb3());
    }

    public final void a() {
        q11[] q11VarArr = this.b;
        if (q11VarArr != null) {
            q11 q11VarF = q11VarArr[0];
            q11 q11VarF2 = q11VarArr[1];
            pb3 pb3Var = this.a;
            if (q11VarF2 == null) {
                q11VarF2 = pb3Var.a.f(2);
            }
            if (q11VarF == null) {
                q11VarF = pb3Var.a.f(1);
            }
            f(q11.a(q11VarF, q11VarF2));
            q11 q11Var = this.b[qf4.b(16)];
            if (q11Var != null) {
                e(q11Var);
            }
            q11 q11Var2 = this.b[qf4.b(32)];
            if (q11Var2 != null) {
                d(q11Var2);
            }
            q11 q11Var3 = this.b[qf4.b(64)];
            if (q11Var3 != null) {
                g(q11Var3);
            }
        }
    }

    public abstract pb3 b();

    public void c(int i, q11 q11Var) {
        if (this.b == null) {
            this.b = new q11[10];
        }
        for (int i2 = 1; i2 <= 512; i2 <<= 1) {
            if ((i & i2) != 0) {
                this.b[qf4.b(i2)] = q11Var;
            }
        }
    }

    public abstract void f(q11 q11Var);

    public db3(pb3 pb3Var) {
        this.a = pb3Var;
    }

    public void d(q11 q11Var) {
    }

    public void e(q11 q11Var) {
    }

    public void g(q11 q11Var) {
    }
}
