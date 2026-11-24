package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l43 extends hb2 {
    public final ThreadLocal j;
    private volatile boolean threadLocalIsSet;

    /* JADX WARN: Illegal instructions before constructor call */
    public l43(x50 x50Var, j70 j70Var) {
        bw bwVar = bw.c;
        super(x50Var, j70Var.v(bwVar) == null ? j70Var.r(bwVar) : j70Var);
        this.j = new ThreadLocal();
        if (x50Var.f().v(qs4.c) instanceof l70) {
            return;
        }
        Object objE = ab4.e(j70Var, null);
        ab4.a(j70Var, objE);
        y0(j70Var, objE);
    }

    @Override // defpackage.hb2
    public final void v0() {
        x0();
    }

    public final boolean w0() {
        boolean z = this.threadLocalIsSet && this.j.get() == null;
        this.j.remove();
        return !z;
    }

    public final void x0() {
        if (this.threadLocalIsSet) {
            wt1 wt1Var = (wt1) this.j.get();
            if (wt1Var != null) {
                ab4.a((j70) wt1Var.a, wt1Var.b);
            }
            this.j.remove();
        }
    }

    public final void y0(j70 j70Var, Object obj) {
        this.threadLocalIsSet = true;
        this.j.set(new wt1(j70Var, obj));
    }

    @Override // defpackage.hb2, defpackage.p41
    public final void z(Object obj) {
        x0();
        Object objA = wi4.a(obj);
        x50 x50Var = this.i;
        j70 j70VarF = x50Var.f();
        Object objE = ab4.e(j70VarF, null);
        l43 l43VarC = objE != ab4.a ? ql4.c(x50Var, j70VarF, objE) : null;
        try {
            x50Var.h(objA);
        } finally {
            if (l43VarC == null || l43VarC.w0()) {
                ab4.a(j70VarF, objE);
            }
        }
    }
}
