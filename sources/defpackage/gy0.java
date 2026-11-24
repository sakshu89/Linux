package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gy0 implements xf, mp1 {
    public final int a;
    public int b;
    public final Object c;

    public gy0(int i, int i2) {
        this.c = null;
        this.a = i;
        int i3 = i2 & 7;
        this.b = i3 == 0 ? 8 : i3;
    }

    @Override // defpackage.xf
    public void a(int i, Object obj) {
        ((xf) this.c).a(i + (this.b == 0 ? this.a : 0), obj);
    }

    @Override // defpackage.xf
    public void b(Object obj) {
        this.b++;
        ((xf) this.c).b(obj);
    }

    @Override // defpackage.xf
    public void c() {
        ((xf) this.c).c();
    }

    @Override // defpackage.xf
    public void d(int i, Object obj) {
        ((xf) this.c).d(i + (this.b == 0 ? this.a : 0), obj);
    }

    @Override // defpackage.xf
    public void f(int i, int i2, int i3) {
        int i4 = this.b == 0 ? this.a : 0;
        ((xf) this.c).f(i + i4, i2 + i4, i3);
    }

    @Override // defpackage.xf
    public Object g() {
        return ((xf) this.c).g();
    }

    @Override // defpackage.xf
    public void h(int i, int i2) {
        ((xf) this.c).h(i + (this.b == 0 ? this.a : 0), i2);
    }

    @Override // defpackage.xf
    public void i(vq0 vq0Var, Object obj) {
        ((xf) this.c).i(vq0Var, obj);
    }

    @Override // defpackage.xf
    public void j() {
        if (this.b <= 0) {
            y20.a("OffsetApplier up called with no corresponding down");
        }
        this.b--;
        ((xf) this.c).j();
    }

    @Override // defpackage.mp1
    public int k(int i) {
        int iK = ((mp1) this.c).k(i);
        if (i >= 0 && i <= this.b) {
            e63.c(iK, this.a, i);
        }
        return iK;
    }

    @Override // defpackage.mp1
    public int l(int i) {
        int iL = ((mp1) this.c).l(i);
        if (i >= 0 && i <= this.a) {
            e63.b(iL, this.b, i);
        }
        return iL;
    }

    public gy0() {
        this.c = new gy0[256];
        this.a = 0;
        this.b = 0;
    }

    public gy0(mp1 mp1Var, int i, int i2) {
        this.c = mp1Var;
        this.a = i;
        this.b = i2;
    }

    public gy0(xf xfVar, int i) {
        this.c = xfVar;
        this.a = i;
    }
}
