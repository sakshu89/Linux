package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e23 implements gr2 {
    public final h23 a;
    public hq0 b;
    public hq0 c;
    public final /* synthetic */ f23 e;

    public e23(f23 f23Var, h23 h23Var, hq0 hq0Var, hq0 hq0Var2) {
        this.e = f23Var;
        this.a = h23Var;
        this.b = hq0Var;
        this.c = hq0Var2;
    }

    public final void a(g23 g23Var) {
        h23 h23Var = this.a;
        ku1 ku1Var = h23Var.f;
        ku1 ku1Var2 = h23Var.b;
        gu1 gu1Var = h23Var.i;
        ku1 ku1Var3 = h23Var.k;
        Object objJ = this.c.j(g23Var.b);
        if (this.e.c.g()) {
            h23Var.f(this.c.j(g23Var.a), objJ, (yl0) this.b.j(g23Var));
            return;
        }
        yl0 yl0Var = (yl0) this.b.j(g23Var);
        if (h23Var.j && g31.a(objJ, null)) {
            return;
        }
        if (g31.a(ku1Var2.getValue(), objJ) && gu1Var.g() == -1.0f) {
            return;
        }
        ku1Var2.setValue(objJ);
        h23Var.c.setValue(yl0Var);
        h23Var.e(gu1Var.g() == -3.0f ? objJ : ku1Var3.getValue(), !((Boolean) ku1Var.getValue()).booleanValue());
        ku1Var.setValue(Boolean.valueOf(gu1Var.g() == -3.0f));
        if (gu1Var.g() >= 0.0f) {
            ku1Var3.setValue(h23Var.a().a((long) (gu1Var.g() * h23Var.a().b())));
        } else if (gu1Var.g() == -3.0f) {
            ku1Var3.setValue(objJ);
        }
        h23Var.j = false;
        gu1Var.h(-1.0f);
    }

    @Override // defpackage.gr2
    public final Object getValue() {
        a(this.e.c.f());
        return this.a.k.getValue();
    }
}
