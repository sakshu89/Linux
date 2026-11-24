package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wv2 implements md {
    public final s63 a;
    public final g33 b;
    public final Object c;
    public final Object d;
    public final vd e;
    public final vd f;
    public final vd g;
    public long h;
    public vd i;

    public wv2(pd pdVar, g33 g33Var, Object obj, Object obj2, vd vdVar) {
        this.a = pdVar.a(g33Var);
        this.b = g33Var;
        this.c = obj2;
        this.d = obj;
        this.e = (vd) g33Var.a.j(obj);
        hq0 hq0Var = g33Var.a;
        this.f = (vd) hq0Var.j(obj2);
        this.g = vdVar != null ? v53.a(vdVar) : ((vd) hq0Var.j(obj)).c();
        this.h = -1L;
    }

    @Override // defpackage.md
    public final Object a(long j) {
        if (f(j)) {
            return this.c;
        }
        vd vdVarH = this.a.h(j, this.e, this.f, this.g);
        int iB = vdVarH.b();
        for (int i = 0; i < iB; i++) {
            if (Float.isNaN(vdVarH.a(i))) {
                fz1.b("AnimationVector cannot contain a NaN. " + vdVarH + ". Animation: " + this + ", playTimeNanos: " + j);
            }
        }
        return this.b.b.j(vdVarH);
    }

    @Override // defpackage.md
    public final long b() {
        if (this.h < 0) {
            this.h = this.a.a(this.e, this.f, this.g);
        }
        return this.h;
    }

    @Override // defpackage.md
    public final g33 c() {
        return this.b;
    }

    @Override // defpackage.md
    public final Object d() {
        return this.c;
    }

    @Override // defpackage.md
    public final vd e(long j) {
        if (!f(j)) {
            return this.a.f(j, this.e, this.f, this.g);
        }
        vd vdVar = this.i;
        if (vdVar != null) {
            return vdVar;
        }
        vd vdVarK = this.a.k(this.e, this.f, this.g);
        this.i = vdVarK;
        return vdVarK;
    }

    @Override // defpackage.md
    public final boolean isInfinite() {
        return this.a.isInfinite();
    }

    public final String toString() {
        return "TargetBasedAnimation: " + this.d + " -> " + this.c + ",initial velocity: " + this.g + ", duration: " + (b() / 1000000) + " ms,animationSpec: " + this.a;
    }
}
