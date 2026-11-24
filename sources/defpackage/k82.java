package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class k82 implements c01 {
    public final boolean a;
    public final long b;

    public k82(long j, boolean z) {
        this.a = z;
        this.b = j;
    }

    @Override // defpackage.c01
    public final xb0 a(ol1 ol1Var) {
        return new cc0(ol1Var, this.a, new wj1(6, this));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k82)) {
            return false;
        }
        k82 k82Var = (k82) obj;
        if (this.a == k82Var.a && de0.b(Float.NaN, Float.NaN)) {
            return sz.c(this.b, k82Var.b);
        }
        return false;
    }

    @Override // defpackage.c01
    public final int hashCode() {
        int iB = cq.b(Boolean.hashCode(this.a) * 31, Float.NaN, 961);
        int i = sz.h;
        return Long.hashCode(this.b) + iB;
    }
}
