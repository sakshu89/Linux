package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ri1 {
    public final String a;
    public final String b;
    public final int c;
    public final String d;

    public ri1(String str, int i, String str2, String str3) {
        str2.getClass();
        this.a = str;
        this.b = str2;
        this.c = i;
        this.d = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ri1)) {
            return false;
        }
        ri1 ri1Var = (ri1) obj;
        return g31.a(this.a, ri1Var.a) && g31.a(this.b, ri1Var.b) && this.c == ri1Var.c && g31.a(this.d, ri1Var.d);
    }

    public final int hashCode() {
        String str = this.a;
        int iA = ky0.a(this.c, ky0.d((str == null ? 0 : str.hashCode()) * 31, 31, this.b), 31);
        String str2 = this.d;
        return iA + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbQ = cq.q("Composed(handlerLabel=", this.a, ", recipientDescription=", this.b, ", bodyCharacters=");
        sbQ.append(this.c);
        sbQ.append(", handlerPackage=");
        sbQ.append(this.d);
        sbQ.append(")");
        return sbQ.toString();
    }
}
