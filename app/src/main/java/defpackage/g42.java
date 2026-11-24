package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g42 implements xf {
    public final ll1 a = new ll1();
    public final yl1 b = new yl1();
    public final Object c;

    public g42(Object obj) {
        this.c = obj;
    }

    @Override // defpackage.xf
    public final void a(int i, Object obj) {
        ll1 ll1Var = this.a;
        ll1Var.a(5);
        ll1Var.a(i);
        this.b.a(obj);
    }

    @Override // defpackage.xf
    public final void b(Object obj) {
        this.a.a(1);
        this.b.a(obj);
    }

    @Override // defpackage.xf
    public final void c() {
        this.a.a(8);
    }

    @Override // defpackage.xf
    public final void d(int i, Object obj) {
        ll1 ll1Var = this.a;
        ll1Var.a(6);
        ll1Var.a(i);
        this.b.a(obj);
    }

    @Override // defpackage.xf
    public final void f(int i, int i2, int i3) {
        ll1 ll1Var = this.a;
        ll1Var.a(3);
        ll1Var.a(i);
        ll1Var.a(i2);
        ll1Var.a(i3);
    }

    @Override // defpackage.xf
    public final Object g() {
        return this.c;
    }

    @Override // defpackage.xf
    public final void h(int i, int i2) {
        ll1 ll1Var = this.a;
        ll1Var.a(2);
        ll1Var.a(i);
        ll1Var.a(i2);
    }

    @Override // defpackage.xf
    public final void i(vq0 vq0Var, Object obj) {
        this.a.a(7);
        yl1 yl1Var = this.b;
        yl1Var.a(vq0Var);
        yl1Var.a(obj);
    }

    @Override // defpackage.xf
    public final void j() {
        this.a.a(0);
    }

    public final void k(b43 b43Var, i52 i52Var) {
        Exception exc;
        ll1 ll1Var = this.a;
        int i = ll1Var.b;
        yl1 yl1Var = new yl1();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            yl1 yl1Var2 = this.b;
            if (i2 >= i) {
                if (i3 != yl1Var2.b) {
                    y20.a("Applier operation size mismatch");
                }
                yl1Var2.d();
                ll1Var.b = 0;
                b43Var.e();
                return;
            }
            int i4 = i2 + 1;
            try {
                try {
                    switch (ll1Var.c(i2)) {
                        case 0:
                            b43Var.j();
                            i2 = i4;
                            break;
                        case 1:
                            int i5 = i3 + 1;
                            b43Var.b(yl1Var2.f(i3));
                            i3 = i5;
                            i2 = i4;
                            break;
                        case 2:
                            int i6 = i2 + 2;
                            i2 += 3;
                            b43Var.h(ll1Var.c(i4), ll1Var.c(i6));
                            break;
                        case 3:
                            int i7 = i2 + 2;
                            try {
                                int i8 = i2 + 3;
                                try {
                                    i2 += 4;
                                    b43Var.f(ll1Var.c(i4), ll1Var.c(i7), ll1Var.c(i8));
                                } catch (Exception e) {
                                    exc = e;
                                    i2 = i8;
                                }
                            } catch (Exception e2) {
                                exc = e2;
                                i2 = i7;
                            }
                            break;
                        case 4:
                            b43Var.k();
                            i2 = i4;
                            break;
                        case 5:
                            i2 += 2;
                            int i9 = i3 + 1;
                            b43Var.a(ll1Var.c(i4), yl1Var2.f(i3));
                            i3 = i9;
                            break;
                        case 6:
                            i2 += 2;
                            try {
                                ll1Var.c(i4);
                                int i10 = i3 + 1;
                                i3 = i10;
                            } catch (Exception e3) {
                                exc = e3;
                            }
                            break;
                        case 7:
                            int i11 = i3 + 1;
                            Object objF = yl1Var2.f(i3);
                            objF.getClass();
                            h33.c(2, objF);
                            i3 += 2;
                            b43Var.i((vq0) objF, yl1Var2.f(i11));
                            i2 = i4;
                            break;
                        case 8:
                            Object obj = b43Var.c;
                            if (obj instanceof d20) {
                                d20 d20Var = (d20) obj;
                                if (((pm1) i52Var.e).k(d20Var)) {
                                    d20Var.b();
                                }
                            }
                            yl1Var.a(obj);
                            b43Var.c();
                            i2 = i4;
                            break;
                        default:
                            i2 = i4;
                            break;
                    }
                } catch (Exception e4) {
                    exc = e4;
                    i2 = i4;
                }
            } catch (Throwable th) {
                b43Var.e();
                throw th;
            }
            exc = e3;
            throw new f20(yl1Var2, yl1Var, ll1Var, i2 - 1, exc);
        }
    }
}
