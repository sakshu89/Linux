package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i63 implements na3 {
    public final String a;
    public final ku1 b;

    public i63(v11 v11Var, String str) {
        this.a = str;
        this.b = o44.g(v11Var);
    }

    @Override // defpackage.na3
    public final int a(qh1 qh1Var, z61 z61Var) {
        return e().a;
    }

    @Override // defpackage.na3
    public final int b(qh1 qh1Var) {
        return e().b;
    }

    @Override // defpackage.na3
    public final int c(qh1 qh1Var, z61 z61Var) {
        return e().c;
    }

    @Override // defpackage.na3
    public final int d(qh1 qh1Var) {
        return e().d;
    }

    public final v11 e() {
        return (v11) this.b.getValue();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof i63) {
            return g31.a(e(), ((i63) obj).e());
        }
        return false;
    }

    public final void f(v11 v11Var) {
        this.b.setValue(v11Var);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append("(left=");
        sb.append(e().a);
        sb.append(", top=");
        sb.append(e().b);
        sb.append(", right=");
        sb.append(e().c);
        sb.append(", bottom=");
        return ky0.m(sb, e().d, ')');
    }
}
