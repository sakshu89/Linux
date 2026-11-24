package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lv implements mv {
    public final boolean a;
    public final boolean b;
    public final String c;

    public lv(String str, boolean z, boolean z2) {
        str.getClass();
        this.a = z;
        this.b = z2;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lv)) {
            return false;
        }
        lv lvVar = (lv) obj;
        return this.a == lvVar.a && this.b == lvVar.b && g31.a(this.c, lvVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ky0.e(Boolean.hashCode(this.a) * 31, 31, this.b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Verified(recording=");
        sb.append(this.a);
        sb.append(", alreadyInState=");
        sb.append(this.b);
        sb.append(", packageName=");
        return cq.n(sb, this.c, ")");
    }
}
