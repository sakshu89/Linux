package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class g52 implements h52 {
    public final String a;
    public final String b;

    public g52(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    @Override // defpackage.h52
    public final String a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g52)) {
            return false;
        }
        g52 g52Var = (g52) obj;
        return this.a.equals(g52Var.a) && this.b.equals(g52Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return ky0.l("TryAlternative(label=", this.a, ", describe=", this.b, ")");
    }
}
