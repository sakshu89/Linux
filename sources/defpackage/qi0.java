package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qi0 {
    public final String a;

    public qi0(String str) {
        if (str != null) {
            this.a = str;
        } else {
            dk0.n("name is null");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qi0)) {
            return false;
        }
        return this.a.equals(((qi0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public final String toString() {
        return cq.n(new StringBuilder("Encoding{name=\""), this.a, "\"}");
    }
}
