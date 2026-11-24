package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hd3 implements id3 {
    public final String a;
    public final String b;

    public hd3(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof hd3)) {
            return false;
        }
        hd3 hd3Var = (hd3) obj;
        return this.a.equals(hd3Var.a) && g31.a(this.b, hd3Var.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return ky0.l("Video(id=", this.a, ", title=", this.b, ")");
    }
}
