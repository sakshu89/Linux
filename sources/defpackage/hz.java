package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class hz {
    public int a;
    public Object b;

    public hz(int i) {
        this.a = i;
    }

    public abstract int A();

    public abstract long B();

    public abstract boolean C(int i);

    public void D() throws o31 {
        boolean zC;
        do {
            int iZ = z();
            if (iZ == 0) {
                return;
            }
            int i = this.a;
            if (i >= 100) {
                throw new o31("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
            }
            this.a = i + 1;
            zC = C(iZ);
            this.a--;
        } while (zC);
    }

    public abstract void b(int i);

    public abstract int c();

    public abstract boolean d();

    public abstract void e(xa3 xa3Var);

    public abstract void f();

    public abstract pb3 g(pb3 pb3Var, List list);

    public abstract cu2 h(xa3 xa3Var, cu2 cu2Var);

    public abstract void i(int i);

    public abstract int j(int i);

    public abstract boolean k();

    public abstract no l();

    public abstract double m();

    public abstract int n();

    public abstract int o();

    public abstract long p();

    public abstract float q();

    public abstract int r();

    public abstract long s();

    public abstract int t();

    public abstract long u();

    public abstract int v();

    public abstract long w();

    public abstract String x();

    public abstract String y();

    public abstract int z();
}
