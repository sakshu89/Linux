package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class h23 implements gr2 {
    public final g33 a;
    public final ku1 b;
    public final ku1 c;
    public final ku1 e;
    public final ku1 f;
    public final gu1 i;
    public boolean j;
    public final ku1 k;
    public vd n;
    public final iu1 s;
    public boolean t;
    public final vq2 u;
    public final /* synthetic */ j23 v;

    public h23(j23 j23Var, Object obj, vd vdVar, g33 g33Var) {
        this.v = j23Var;
        this.a = g33Var;
        ku1 ku1VarG = o44.g(obj);
        this.b = ku1VarG;
        Object objJ = null;
        this.c = o44.g(ie4.d(7, null));
        this.e = o44.g(new wv2(b(), g33Var, obj, ku1VarG.getValue(), vdVar));
        this.f = o44.g(Boolean.TRUE);
        this.i = new gu1(-1.0f);
        this.k = o44.g(obj);
        this.n = vdVar;
        this.s = new iu1(a().b());
        Float f = (Float) p83.a.get(g33Var);
        if (f != null) {
            float fFloatValue = f.floatValue();
            vd vdVar2 = (vd) g33Var.a.j(obj);
            int iB = vdVar2.b();
            for (int i = 0; i < iB; i++) {
                vdVar2.e(fFloatValue, i);
            }
            objJ = this.a.b.j(vdVar2);
        }
        this.u = ie4.d(3, objJ);
    }

    public final wv2 a() {
        return (wv2) this.e.getValue();
    }

    public final yl0 b() {
        return (yl0) this.c.getValue();
    }

    public final void d() {
        if (this.i.g() == -1.0f) {
            this.t = true;
            boolean zA = g31.a(a().c, a().d);
            ku1 ku1Var = this.k;
            if (zA) {
                ku1Var.setValue(a().c);
            } else {
                ku1Var.setValue(a().a(0L));
                this.n = a().e(0L);
            }
        }
    }

    public final void e(Object obj, boolean z) {
        j23 j23Var = this.v;
        ku1 ku1Var = j23Var.h;
        ku1 ku1Var2 = this.b;
        boolean zA = g31.a(null, ku1Var2.getValue());
        iu1 iu1Var = this.s;
        ku1 ku1Var3 = this.e;
        g33 g33Var = this.a;
        if (zA) {
            ku1Var3.setValue(new wv2(this.u, g33Var, obj, obj, this.n.c()));
            this.j = true;
            iu1Var.h(a().b());
            return;
        }
        yl0 yl0VarB = (!z || this.t || (b() instanceof vq2)) ? b() : this.u;
        long jMax = 0;
        ku1Var3.setValue(new wv2(j23Var.e() <= 0 ? yl0VarB : new br2(yl0VarB, j23Var.e()), g33Var, obj, ku1Var2.getValue(), this.n));
        iu1Var.h(a().b());
        this.j = false;
        ku1Var.setValue(Boolean.TRUE);
        if (j23Var.g()) {
            um2 um2Var = j23Var.i;
            int size = um2Var.size();
            for (int i = 0; i < size; i++) {
                h23 h23Var = (h23) um2Var.get(i);
                jMax = Math.max(jMax, h23Var.s.g());
                h23Var.d();
            }
            ku1Var.setValue(Boolean.FALSE);
        }
    }

    public final void f(Object obj, Object obj2, yl0 yl0Var) {
        this.b.setValue(obj2);
        this.c.setValue(yl0Var);
        if (g31.a(a().d, obj) && g31.a(a().c, obj2)) {
            return;
        }
        e(obj, false);
    }

    @Override // defpackage.gr2
    public final Object getValue() {
        return this.k.getValue();
    }

    public final String toString() {
        return "current value: " + this.k.getValue() + ", target: " + this.b.getValue() + ", spec: " + b();
    }
}
