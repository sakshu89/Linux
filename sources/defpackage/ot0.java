package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ot0 {
    public final long a;
    public final List b;

    public ot0(long j, List list) {
        this.a = j;
        this.b = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ot0)) {
            return false;
        }
        ot0 ot0Var = (ot0) obj;
        return this.a == ot0Var.a && this.b.equals(ot0Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (Long.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "Catalogue(revision=" + this.a + ", models=" + this.b + ")";
    }
}
