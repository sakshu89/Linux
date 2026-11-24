package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s33 {
    public final ev2 a;
    public final np0 b;
    public final int c;
    public final int d;
    public final Object e;

    public s33(ev2 ev2Var, np0 np0Var, int i, int i2, Object obj) {
        this.a = ev2Var;
        this.b = np0Var;
        this.c = i;
        this.d = i2;
        this.e = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s33)) {
            return false;
        }
        s33 s33Var = (s33) obj;
        return g31.a(this.a, s33Var.a) && g31.a(this.b, s33Var.b) && this.c == s33Var.c && this.d == s33Var.d && g31.a(this.e, s33Var.e);
    }

    public final int hashCode() {
        ev2 ev2Var = this.a;
        int iA = ky0.a(this.d, ky0.a(this.c, (((ev2Var == null ? 0 : ev2Var.hashCode()) * 31) + this.b.a) * 31, 31), 31);
        Object obj = this.e;
        return iA + (obj != null ? obj.hashCode() : 0);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder("TypefaceRequest(fontFamily=");
        sb.append(this.a);
        sb.append(", fontWeight=");
        sb.append(this.b);
        sb.append(", fontStyle=");
        String str2 = "Invalid";
        int i = this.c;
        if (i == 0) {
            str = "Normal";
        } else {
            str = i == 1 ? "Italic" : "Invalid";
        }
        sb.append((Object) str);
        sb.append(", fontSynthesis=");
        int i2 = this.d;
        if (i2 == 0) {
            str2 = "None";
        } else if (i2 == 1) {
            str2 = "Weight";
        } else if (i2 == 2) {
            str2 = "Style";
        } else if (i2 == 65535) {
            str2 = "All";
        }
        sb.append((Object) str2);
        sb.append(", resourceLoaderCacheKey=");
        sb.append(this.e);
        sb.append(')');
        return sb.toString();
    }
}
