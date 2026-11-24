package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vi2 implements fj2 {
    public final String a;
    public final boolean b;
    public final q22 c;

    public vi2(String str, boolean z, q22 q22Var) {
        str.getClass();
        q22Var.getClass();
        this.a = str;
        this.b = z;
        this.c = q22Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof vi2)) {
            return false;
        }
        vi2 vi2Var = (vi2) obj;
        return g31.a(this.a, vi2Var.a) && this.b == vi2Var.b && this.c == vi2Var.c;
    }

    public final int hashCode() {
        return this.c.hashCode() + ky0.e(this.a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        return "AlreadyInState(setting=" + this.a + ", isOn=" + this.b + ", evidence=" + this.c + ")";
    }
}
