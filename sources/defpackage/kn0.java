package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kn0 {
    public final void a(jh1 jh1Var, jh1 jh1Var2, long j) {
        long jA = cs4.a(j, c81.a);
        if (jh1Var != null) {
            int iV = jh1Var.V(q40.g(jA));
            new a21(a21.a(iV, jh1Var.e0(iV)));
        }
        if (jh1Var2 != null) {
            int iV2 = jh1Var2.V(q40.g(jA));
            new a21(a21.a(iV2, jh1Var2.e0(iV2)));
        }
    }

    public final boolean equals(Object obj) {
        return this == obj || (obj instanceof kn0);
    }

    public final int hashCode() {
        return Integer.hashCode(0) + ky0.a(0, in0.a.hashCode() * 31, 31);
    }

    public final String toString() {
        return "FlowLayoutOverflowState(type=" + in0.a + ", minLinesToShowCollapse=0, minCrossAxisSizeToShowCollapse=0)";
    }
}
