package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uw1 {
    public final long a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;
    public final String f;

    public uw1(long j, String str, String str2, String str3, boolean z, String str4) {
        str3.getClass();
        this.a = j;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = z;
        this.f = str4;
    }

    public final String a() {
        String str = this.d;
        boolean zA = cs2.A(str);
        String str2 = this.b;
        return zA ? str2 : cq.k(str2, " — ", str);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof uw1)) {
            return false;
        }
        uw1 uw1Var = (uw1) obj;
        return this.a == uw1Var.a && this.b.equals(uw1Var.b) && this.c.equals(uw1Var.c) && g31.a(this.d, uw1Var.d) && this.e == uw1Var.e && g31.a(this.f, uw1Var.f);
    }

    public final int hashCode() {
        int iE = ky0.e(ky0.d(ky0.d(ky0.d(Long.hashCode(this.a) * 31, 31, this.b), 31, this.c), 31, this.d), 31, this.e);
        String str = this.f;
        return iE + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return "PhoneCandidate(contactId=" + this.a + ", displayName=" + this.b + ", number=" + this.c + ", typeLabel=" + this.d + ", isStarred=" + this.e + ", photoUri=" + this.f + ")";
    }
}
