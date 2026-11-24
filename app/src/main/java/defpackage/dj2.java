package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dj2 implements fj2 {
    public final String a;
    public final boolean b;
    public final q22 c;

    public dj2(String str, boolean z, q22 q22Var) {
        this.a = str;
        this.b = z;
        this.c = q22Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof dj2)) {
            return false;
        }
        dj2 dj2Var = (dj2) obj;
        return g31.a(this.a, dj2Var.a) && this.b == dj2Var.b && this.c == dj2Var.c;
    }

    public final int hashCode() {
        return this.c.hashCode() + ky0.e(this.a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        return "Verified(setting=" + this.a + ", isOn=" + this.b + ", evidence=" + this.c + ")";
    }

    public /* synthetic */ dj2(String str, boolean z) {
        this(str, z, q22.a);
    }
}
