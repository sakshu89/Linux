package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nj {
    public final int a;
    public final ty0 b;

    public nj(int i, ty0 ty0Var) {
        this.a = i;
        this.b = ty0Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof nj) {
            nj njVar = (nj) obj;
            return this.a == njVar.a && this.b == njVar.b;
        }
        return false;
    }

    public final int hashCode() {
        return this.b.hashCode() ^ ((this.a ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "CaptureError{requestId=" + this.a + ", imageCaptureException=" + this.b + "}";
    }
}
