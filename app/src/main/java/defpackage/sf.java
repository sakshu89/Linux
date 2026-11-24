package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sf {
    public final x42 a;
    public final float b;
    public final boolean c;

    public sf(x42 x42Var, float f, boolean z) {
        this.a = x42Var;
        this.b = f;
        this.c = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof sf)) {
            return false;
        }
        sf sfVar = (sf) obj;
        return g31.a(this.a, sfVar.a) && Float.compare(this.b, sfVar.b) == 0 && this.c == sfVar.c;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.c) + cq.b(this.a.hashCode() * 31, this.b, 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("OpeningPattern(pattern=");
        sb.append(this.a);
        sb.append(", confidence=");
        sb.append(this.b);
        sb.append(", targetBeforeVerb=");
        return ky0.o(sb, this.c, ")");
    }
}
