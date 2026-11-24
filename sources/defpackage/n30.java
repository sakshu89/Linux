package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n30 implements h63 {
    public final hq0 a;

    public n30(hq0 hq0Var) {
        this.a = hq0Var;
    }

    @Override // defpackage.h63
    public final Object a(gw1 gw1Var) {
        return this.a.j(gw1Var);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof n30) && this.a.equals(((n30) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "ComputedValueHolder(compute=" + this.a + ')';
    }
}
