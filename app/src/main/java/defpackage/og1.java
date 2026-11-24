package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class og1 extends qg1 implements Iterator, x41 {
    public final /* synthetic */ int f;

    public og1(rg1 rg1Var, int i) {
        this.f = i;
        rg1Var.getClass();
        this.e = rg1Var;
        this.b = -1;
        this.c = rg1Var.k;
        c();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f) {
            case 0:
                b();
                int i = this.a;
                rg1 rg1Var = (rg1) this.e;
                if (i >= rg1Var.i) {
                    dk0.d();
                    return null;
                }
                this.a = i + 1;
                this.b = i;
                pg1 pg1Var = new pg1(rg1Var, i);
                c();
                return pg1Var;
            case 1:
                b();
                int i2 = this.a;
                rg1 rg1Var2 = (rg1) this.e;
                if (i2 >= rg1Var2.i) {
                    dk0.d();
                    return null;
                }
                this.a = i2 + 1;
                this.b = i2;
                Object obj = rg1Var2.a[i2];
                c();
                return obj;
            default:
                b();
                int i3 = this.a;
                rg1 rg1Var3 = (rg1) this.e;
                if (i3 >= rg1Var3.i) {
                    dk0.d();
                    return null;
                }
                this.a = i3 + 1;
                this.b = i3;
                Object[] objArr = rg1Var3.b;
                objArr.getClass();
                Object obj2 = objArr[this.b];
                c();
                return obj2;
        }
    }
}
