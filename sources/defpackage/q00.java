package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q00 implements ek1 {
    public final ek1 a;
    public final ek1 b;

    public q00(ek1 ek1Var, ek1 ek1Var2) {
        this.a = ek1Var;
        this.b = ek1Var2;
    }

    @Override // defpackage.ek1
    public final Object a(vq0 vq0Var, Object obj) {
        return this.b.a(vq0Var, this.a.a(vq0Var, obj));
    }

    @Override // defpackage.ek1
    public final boolean b(hq0 hq0Var) {
        return this.a.b(hq0Var) && this.b.b(hq0Var);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof q00)) {
            return false;
        }
        q00 q00Var = (q00) obj;
        return this.a.equals(q00Var.a) && g31.a(this.b, q00Var.b);
    }

    public final int hashCode() {
        return (this.b.hashCode() * 31) + this.a.hashCode();
    }

    public final String toString() {
        return ky0.n(new StringBuilder("["), (String) a(jd.e, ""), ']');
    }
}
