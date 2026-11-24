package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uf extends ik1 {
    public final boolean a;
    public final hq0 b;

    public uf(hq0 hq0Var, boolean z) {
        this.a = z;
        this.b = hq0Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        m60 m60Var = new m60();
        m60Var.x = this.a;
        m60Var.H = this.b;
        return m60Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uf)) {
            return false;
        }
        uf ufVar = (uf) obj;
        return this.a == ufVar.a && this.b == ufVar.b;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        m60 m60Var = (m60) dk1Var;
        m60Var.x = this.a;
        m60Var.H = this.b;
    }

    public final int hashCode() {
        return this.b.hashCode() + (Boolean.hashCode(this.a) * 31);
    }
}
