package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class jw1 extends iw1 {
    public final fw1 e;
    public Object f;
    public boolean i;
    public int j;

    public jw1(fw1 fw1Var, y23[] y23VarArr) {
        super(fw1Var.b, y23VarArr);
        this.e = fw1Var;
        this.j = fw1Var.e;
    }

    public final void c(int i, x23 x23Var, Object obj, int i2) {
        int i3 = i2 * 5;
        y23[] y23VarArr = this.a;
        if (i3 <= 30) {
            int iE = 1 << ld4.e(i, i3);
            if (x23Var.h(iE)) {
                y23VarArr[i2].a(x23Var.d, Integer.bitCount(x23Var.a) * 2, x23Var.f(iE));
                this.b = i2;
                return;
            } else {
                int iT = x23Var.t(iE);
                x23 x23VarS = x23Var.s(iT);
                y23VarArr[i2].a(x23Var.d, Integer.bitCount(x23Var.a) * 2, iT);
                c(i, x23VarS, obj, i2 + 1);
                return;
            }
        }
        y23 y23Var = y23VarArr[i2];
        Object[] objArr = x23Var.d;
        y23Var.a(objArr, objArr.length, 0);
        while (true) {
            y23 y23Var2 = y23VarArr[i2];
            if (g31.a(y23Var2.a[y23Var2.c], obj)) {
                this.b = i2;
                return;
            } else {
                y23VarArr[i2].c += 2;
            }
        }
    }

    @Override // defpackage.iw1, java.util.Iterator
    public final Object next() {
        if (this.e.e != this.j) {
            og.d();
            return null;
        }
        if (!this.c) {
            dk0.d();
            return null;
        }
        y23 y23Var = this.a[this.b];
        this.f = y23Var.a[y23Var.c];
        this.i = true;
        return super.next();
    }

    @Override // defpackage.iw1, java.util.Iterator
    public final void remove() {
        if (!this.i) {
            throw new IllegalStateException();
        }
        boolean z = this.c;
        fw1 fw1Var = this.e;
        if (!z) {
            h33.b(fw1Var).remove(this.f);
        } else {
            if (!z) {
                dk0.d();
                return;
            }
            y23 y23Var = this.a[this.b];
            Object obj = y23Var.a[y23Var.c];
            h33.b(fw1Var).remove(this.f);
            c(obj != null ? obj.hashCode() : 0, fw1Var.b, obj, 0);
        }
        this.f = null;
        this.i = false;
        this.j = fw1Var.e;
    }
}
