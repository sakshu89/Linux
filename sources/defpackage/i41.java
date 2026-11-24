package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class i41 extends re1 implements rd0, rz0 {
    public p41 j;

    @Override // defpackage.rd0
    public final void a() {
        p().k0(this);
    }

    @Override // defpackage.rz0
    public final boolean c() {
        return true;
    }

    @Override // defpackage.rz0
    public final eo1 getList() {
        return null;
    }

    public f41 getParent() {
        return p();
    }

    public final p41 p() {
        p41 p41Var = this.j;
        if (p41Var != null) {
            return p41Var;
        }
        g31.f("job");
        throw null;
    }

    public abstract boolean q();

    public abstract void r(Throwable th);

    @Override // defpackage.re1
    public final String toString() {
        return getClass().getSimpleName() + '@' + ba0.c(this) + "[job@" + ba0.c(p()) + ']';
    }
}
