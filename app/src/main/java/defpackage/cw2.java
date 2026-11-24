package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cw2 implements ew2 {
    public final String a;
    public final String b;

    public cw2(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof cw2)) {
            return false;
        }
        cw2 cw2Var = (cw2) obj;
        return this.a.equals(cw2Var.a) && g31.a(this.b, cw2Var.b);
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    public final String toString() {
        return ky0.l("LowConfidence(target=", this.a, ", bestCandidateLabel=", this.b, ")");
    }
}
