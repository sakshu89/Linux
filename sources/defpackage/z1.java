package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class z1 {
    public a2[] a;
    public int b;
    public int c;
    public bt2 e;

    public final a2 c() {
        a2 a2VarD;
        bt2 bt2Var;
        synchronized (this) {
            try {
                a2[] a2VarArrE = this.a;
                if (a2VarArrE == null) {
                    a2VarArrE = e();
                    this.a = a2VarArrE;
                } else if (this.b >= a2VarArrE.length) {
                    Object[] objArrCopyOf = Arrays.copyOf(a2VarArrE, a2VarArrE.length * 2);
                    this.a = (a2[]) objArrCopyOf;
                    a2VarArrE = (a2[]) objArrCopyOf;
                }
                int i = this.c;
                do {
                    a2VarD = a2VarArrE[i];
                    if (a2VarD == null) {
                        a2VarD = d();
                        a2VarArrE[i] = a2VarD;
                    }
                    i++;
                    if (i >= a2VarArrE.length) {
                        i = 0;
                    }
                } while (!a2VarD.a(this));
                this.c = i;
                this.b++;
                bt2Var = this.e;
            } catch (Throwable th) {
                throw th;
            }
        }
        if (bt2Var != null) {
            bt2Var.w(1);
        }
        return a2VarD;
    }

    public abstract a2 d();

    public abstract a2[] e();

    public final void f(a2 a2Var) {
        bt2 bt2Var;
        int i;
        x50[] x50VarArrB;
        synchronized (this) {
            try {
                int i2 = this.b - 1;
                this.b = i2;
                bt2Var = this.e;
                if (i2 == 0) {
                    this.c = 0;
                }
                a2Var.getClass();
                x50VarArrB = a2Var.b(this);
            } catch (Throwable th) {
                throw th;
            }
        }
        for (x50 x50Var : x50VarArrB) {
            if (x50Var != null) {
                x50Var.h(q43.a);
            }
        }
        if (bt2Var != null) {
            bt2Var.w(-1);
        }
    }

    public final bt2 g() {
        bt2 bt2Var;
        synchronized (this) {
            bt2Var = this.e;
            if (bt2Var == null) {
                int i = this.b;
                bt2Var = new bt2(1, Integer.MAX_VALUE, nn.b);
                bt2Var.q(Integer.valueOf(i));
                this.e = bt2Var;
            }
        }
        return bt2Var;
    }
}
