package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s3 implements v3 {
    public final String a;
    public final String b;
    public final String c;

    public s3(String str, String str2, String str3) {
        str.getClass();
        this.a = str;
        this.b = str2;
        this.c = str3;
    }

    public final String a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s3)) {
            return false;
        }
        s3 s3Var = (s3) obj;
        return g31.a(this.a, s3Var.a) && g31.a(this.b, s3Var.b) && g31.a(this.c, s3Var.c);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return cq.n(cq.q("Done(matchedLabel=", this.a, ", matchedTitle=", this.b, ", matchedArtist="), this.c, ")");
    }

    public /* synthetic */ s3(String str) {
        this(str, null, null);
    }
}
