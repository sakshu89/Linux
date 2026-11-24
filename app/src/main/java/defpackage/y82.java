package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class y82 implements a92 {
    public final f5 a;

    public y82(f5 f5Var) {
        f5Var.getClass();
        this.a = f5Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof y82) && g31.a(this.a, ((y82) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Matched(intent=" + this.a + ")";
    }
}
