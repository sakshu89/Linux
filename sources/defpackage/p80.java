package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p80 {
    public final Class a;
    public final boolean b;

    public p80(Class cls, boolean z) {
        this.a = cls;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof p80) {
            p80 p80Var = (p80) obj;
            if (p80Var.a.equals(this.a) && p80Var.b == this.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Boolean.valueOf(this.b).hashCode() ^ ((this.a.hashCode() ^ 1000003) * 1000003);
    }
}
