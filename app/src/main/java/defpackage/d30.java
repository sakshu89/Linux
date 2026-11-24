package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d30 implements c30 {
    public final z20 a;

    public d30(z20 z20Var) {
        this.a = z20Var;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof d30) {
            return this.a.equals(((d30) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode() * 31;
    }
}
