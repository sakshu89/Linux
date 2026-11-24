package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p61 implements t61 {
    public final String a;
    public final String b;

    public p61(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p61)) {
            return false;
        }
        p61 p61Var = (p61) obj;
        return this.a.equals(p61Var.a) && g31.a(this.b, p61Var.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return ky0.l("Launched(handlerPackage=", this.a, ", handlerLabel=", this.b, ")");
    }
}
