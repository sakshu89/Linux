package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class o51 implements s51 {
    public final String a;
    public final String b;

    public o51(String str, String str2) {
        str.getClass();
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o51)) {
            return false;
        }
        o51 o51Var = (o51) obj;
        return g31.a(this.a, o51Var.a) && g31.a(this.b, o51Var.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return ky0.l("Failed(summary=", this.a, ", technical=", this.b, ")");
    }
}
