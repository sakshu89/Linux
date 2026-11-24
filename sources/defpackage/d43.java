package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d43 implements h43 {
    public final String a;
    public final String b;

    public d43(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d43)) {
            return false;
        }
        d43 d43Var = (d43) obj;
        return this.a.equals(d43Var.a) && this.b.equals(d43Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return ky0.l("OpenSettings(action=", this.a, ", label=", this.b, ")");
    }
}
