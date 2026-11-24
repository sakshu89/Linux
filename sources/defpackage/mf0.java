package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class mf0 extends ik1 {
    public final hq0 a;

    public mf0(hq0 hq0Var) {
        this.a = hq0Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        lf0 lf0Var = new lf0();
        lf0Var.x = this.a;
        return lf0Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof mf0) {
            return this.a == ((mf0) obj).a;
        }
        return false;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        ((lf0) dk1Var).x = this.a;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
