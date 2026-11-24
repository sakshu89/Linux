package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ua1 {
    public final ku1 A;
    public final ku1 B;
    public ux2 a;
    public final a42 b;
    public final zm2 c;
    public final l11 d;
    public bz2 e;
    public final ku1 f;
    public final ku1 g;
    public y61 h;
    public final ku1 i;
    public be j;
    public final ku1 k;
    public final ku1 l;
    public final ku1 m;
    public final ku1 n;
    public final ku1 o;
    public boolean p;
    public final ku1 q;
    public final kf r;
    public final ku1 s;
    public final ku1 t;
    public hq0 u;
    public final q60 v;
    public final q60 w;
    public final q60 x;
    public final fa y;
    public long z;

    public ua1(ux2 ux2Var, a42 a42Var, zm2 zm2Var) {
        this.a = ux2Var;
        this.b = a42Var;
        this.c = zm2Var;
        l11 l11Var = new l11(20, false);
        be beVar = ce.a;
        long j = oz2.b;
        ty2 ty2Var = new ty2(beVar, j, (oz2) null);
        l11Var.b = ty2Var;
        l11Var.c = new gh0(beVar, ty2Var.b);
        this.d = l11Var;
        Boolean bool = Boolean.FALSE;
        this.f = o44.g(bool);
        this.g = o44.g(new de0(0.0f));
        this.i = o44.g(null);
        this.k = o44.g(rv0.a);
        this.l = o44.g(bool);
        this.m = o44.g(bool);
        this.n = o44.g(bool);
        this.o = o44.g(bool);
        this.p = true;
        this.q = o44.g(Boolean.TRUE);
        this.r = new kf(zm2Var);
        this.s = o44.g(bool);
        this.t = o44.g(bool);
        this.u = new j(29);
        this.v = new q60(this, 2);
        this.w = new q60(this, 3);
        this.x = new q60(this, 4);
        this.y = ld4.a();
        this.z = sz.g;
        this.A = o44.g(new oz2(j));
        this.B = o44.g(new oz2(j));
    }

    public final rv0 a() {
        return (rv0) this.k.getValue();
    }

    public final boolean b() {
        return ((Boolean) this.f.getValue()).booleanValue();
    }

    public final y61 c() {
        y61 y61Var = this.h;
        if (y61Var == null || !y61Var.B()) {
            return null;
        }
        return y61Var;
    }

    public final hz2 d() {
        return (hz2) this.i.getValue();
    }

    public final void e(long j) {
        this.B.setValue(new oz2(j));
    }

    public final void f(long j) {
        this.A.setValue(new oz2(j));
    }
}
