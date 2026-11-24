package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qd implements gr2 {
    public final g33 a;
    public final ku1 b;
    public vd c;
    public long e;
    public long f;
    public boolean i;

    public qd(g33 g33Var, Object obj, vd vdVar, long j, long j2, boolean z) {
        vd vdVarA;
        this.a = g33Var;
        this.b = o44.g(obj);
        if (vdVar != null) {
            vdVarA = v53.a(vdVar);
        } else {
            vdVarA = (vd) g33Var.a.j(obj);
            vdVarA.d();
        }
        this.c = vdVarA;
        this.e = j;
        this.f = j2;
        this.i = z;
    }

    @Override // defpackage.gr2
    public final Object getValue() {
        return this.b.getValue();
    }

    public final String toString() {
        return "AnimationState(value=" + this.b.getValue() + ", velocity=" + this.a.b.j(this.c) + ", isRunning=" + this.i + ", lastFrameTimeNanos=" + this.e + ", finishedTimeNanos=" + this.f + ')';
    }

    public /* synthetic */ qd(g33 g33Var, Object obj, vd vdVar, int i) {
        this(g33Var, obj, (i & 4) != 0 ? null : vdVar, Long.MIN_VALUE, Long.MIN_VALUE, false);
    }
}
