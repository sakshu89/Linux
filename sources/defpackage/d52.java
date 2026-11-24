package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d52 implements h52 {
    public final String a;
    public final String b;
    public final String c;

    public d52(String str, String str2, String str3) {
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    @Override // defpackage.h52
    public final String a() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d52)) {
            return false;
        }
        d52 d52Var = (d52) obj;
        return this.a.equals(d52Var.a) && this.b.equals(d52Var.b) && this.c.equals(d52Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ky0.d(this.a.hashCode() * 31, 31, this.b);
    }

    public final String toString() {
        return cq.n(cq.q("EnableSonicFeature(featureKey=", this.a, ", label=", this.b, ", explanation="), this.c, ")");
    }
}
