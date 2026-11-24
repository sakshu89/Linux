package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f93 implements h93 {
    public final int a;
    public final i93 b;

    public f93(int i, i93 i93Var) {
        this.a = i;
        this.b = i93Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f93)) {
            return false;
        }
        f93 f93Var = (f93) obj;
        return this.a == f93Var.a && this.b.equals(f93Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Integer.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "Contradicted(requested=" + this.a + ", actual=" + this.b + ")";
    }
}
