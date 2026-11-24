package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yc implements na3 {
    public final int a;
    public final String b;
    public final ku1 c = o44.g(q11.e);
    public final ku1 d = o44.g(Boolean.TRUE);

    public yc(int i, String str) {
        this.a = i;
        this.b = str;
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

    public final q11 e() {
        return (q11) this.c.getValue();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof yc) {
            return this.a == ((yc) obj).a;
        }
        return false;
    }

    public final void f(boolean z) {
        this.d.setValue(Boolean.valueOf(z));
    }

    public final void g(pb3 pb3Var, int i) {
        int i2 = this.a;
        if (i == 0 || (i & i2) != 0) {
            this.c.setValue(pb3Var.a.f(i2));
            f(pb3Var.a.o(i2));
        }
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.b);
        sb.append('(');
        sb.append(e().a);
        sb.append(", ");
        sb.append(e().b);
        sb.append(", ");
        sb.append(e().c);
        sb.append(", ");
        return ky0.m(sb, e().d, ')');
    }
}
