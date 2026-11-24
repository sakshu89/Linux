package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s01 {
    public final pm1 a = new pm1(new q01[16]);
    public final ku1 b = o44.g(Boolean.FALSE);
    public long c = Long.MIN_VALUE;
    public final ku1 d = o44.g(Boolean.TRUE);

    public final void a(x20 x20Var, int i) {
        x20Var.X(-318043801);
        int i2 = 4;
        int i3 = (x20Var.h(this) ? 4 : 2) | i;
        if (x20Var.O(i3 & 1, (i3 & 3) != 2)) {
            Object objL = x20Var.L();
            x50 x50Var = null;
            xy xyVar = r20.a;
            if (objL == xyVar) {
                objL = o44.g(null);
                x20Var.g0(objL);
            }
            mm1 mm1Var = (mm1) objL;
            if (((Boolean) this.d.getValue()).booleanValue() || ((Boolean) this.b.getValue()).booleanValue()) {
                x20Var.W(-144841960);
                boolean zH = x20Var.h(this);
                Object objL2 = x20Var.L();
                if (zH || objL2 == xyVar) {
                    objL2 = new aa(mm1Var, this, x50Var, 6);
                    x20Var.g0(objL2);
                }
                bz3.c(x20Var, (vq0) objL2, this);
            } else {
                x20Var.W(-151918981);
            }
            x20Var.p(false);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new ha(this, i, i2);
        }
    }
}
