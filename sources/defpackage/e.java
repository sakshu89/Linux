package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e implements h {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;

    public e(String str, String str2, boolean z, boolean z2) {
        this.a = str;
        this.b = str2;
        this.c = z;
        this.d = z2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return g31.a(this.a, eVar.a) && g31.a(this.b, eVar.b) && this.c == eVar.c && this.d == eVar.d;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.d) + ky0.e(ky0.d(this.a.hashCode() * 31, 31, this.b), 31, this.c);
    }

    public final String toString() {
        StringBuilder sbQ = cq.q("Failed(spoken=", this.a, ", technical=", this.b, ", retryable=");
        sbQ.append(this.c);
        sbQ.append(", reachedProvider=");
        sbQ.append(this.d);
        sbQ.append(")");
        return sbQ.toString();
    }
}
