package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pa0 implements jh1 {
    public final /* synthetic */ int a;
    public final jh1 b;
    public final Enum c;
    public final Enum e;

    public /* synthetic */ pa0(jh1 jh1Var, Enum r2, Enum r3, int i) {
        this.a = i;
        this.b = jh1Var;
        this.c = r2;
        this.e = r3;
    }

    @Override // defpackage.jh1
    public final int V(int i) {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.b.V(i);
    }

    @Override // defpackage.jh1
    public final int c0(int i) {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.b.c0(i);
    }

    @Override // defpackage.jh1
    public final zw1 e(long j) {
        int i = this.a;
        Enum r1 = this.c;
        Enum r2 = this.e;
        jh1 jh1Var = this.b;
        switch (i) {
            case 0:
                d31 d31Var = (d31) r2;
                a31 a31Var = (a31) r1;
                a31 a31Var2 = a31.b;
                if (d31Var == d31.a) {
                    return new am0(a31Var == a31Var2 ? jh1Var.c0(q40.g(j)) : jh1Var.V(q40.g(j)), q40.c(j) ? q40.g(j) : 32767, 0);
                }
                return new am0(q40.d(j) ? q40.h(j) : 32767, a31Var == a31Var2 ? jh1Var.f(q40.h(j)) : jh1Var.e0(q40.h(j)), 0);
            case 1:
                sh1 sh1Var = (sh1) r2;
                rh1 rh1Var = (rh1) r1;
                rh1 rh1Var2 = rh1.b;
                if (sh1Var == sh1.a) {
                    return new am0(rh1Var == rh1Var2 ? jh1Var.c0(q40.g(j)) : jh1Var.V(q40.g(j)), q40.c(j) ? q40.g(j) : 32767, 1);
                }
                return new am0(q40.d(j) ? q40.h(j) : 32767, rh1Var == rh1Var2 ? jh1Var.f(q40.h(j)) : jh1Var.e0(q40.h(j)), 1);
            default:
                go1 go1Var = (go1) r2;
                fo1 fo1Var = (fo1) r1;
                fo1 fo1Var2 = fo1.b;
                if (go1Var == go1.a) {
                    return new am0(fo1Var == fo1Var2 ? jh1Var.c0(q40.g(j)) : jh1Var.V(q40.g(j)), q40.c(j) ? q40.g(j) : 32767, 2);
                }
                return new am0(q40.d(j) ? q40.h(j) : 32767, fo1Var == fo1Var2 ? jh1Var.f(q40.h(j)) : jh1Var.e0(q40.h(j)), 2);
        }
    }

    @Override // defpackage.jh1
    public final int e0(int i) {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.b.e0(i);
    }

    @Override // defpackage.jh1
    public final int f(int i) {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.b.f(i);
    }

    @Override // defpackage.jh1
    public final Object k() {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
        }
        return this.b.k();
    }
}
