package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s83 implements z83 {
    public final String a;
    public final boolean b;
    public final boolean c;

    public s83(String str, boolean z, boolean z2) {
        this.a = str;
        this.b = z;
        this.c = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s83)) {
            return false;
        }
        s83 s83Var = (s83) obj;
        return g31.a(this.a, s83Var.a) && this.b == s83Var.b && this.c == s83Var.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + ky0.e(this.a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Failed(detail=");
        sb.append(this.a);
        sb.append(", fatal=");
        sb.append(this.b);
        sb.append(", isError11=");
        return ky0.o(sb, this.c, ")");
    }
}
