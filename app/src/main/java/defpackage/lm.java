package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lm {
    public final jc0 a;
    public final long b;

    public lm(xs2 xs2Var, long j) {
        this.a = xs2Var;
        this.b = j;
    }

    public final float a() {
        long j = this.b;
        if (!q40.c(j)) {
            return Float.POSITIVE_INFINITY;
        }
        return this.a.r0(q40.g(j));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof lm)) {
            return false;
        }
        lm lmVar = (lm) obj;
        return g31.a(this.a, lmVar.a) && q40.b(this.b, lmVar.b);
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "BoxWithConstraintsScopeImpl(density=" + this.a + ", constraints=" + ((Object) q40.k(this.b)) + ')';
    }
}
