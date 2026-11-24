package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a23 {
    public final be a;
    public final mp1 b;

    public a23(be beVar, mp1 mp1Var) {
        this.a = beVar;
        this.b = mp1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a23)) {
            return false;
        }
        a23 a23Var = (a23) obj;
        return g31.a(this.a, a23Var.a) && this.b.equals(a23Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "TransformedText(text=" + ((Object) this.a) + ", offsetMapping=" + this.b + ')';
    }
}
