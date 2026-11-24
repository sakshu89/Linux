package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ok3 {
    public final int a;
    public final pp3 b;

    public ok3(int i, pp3 pp3Var) {
        this.a = i;
        this.b = pp3Var;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ok3)) {
            return false;
        }
        ok3 ok3Var = (ok3) obj;
        return this.a == ok3Var.a && this.b.equals(ok3Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() ^ ((this.a ^ 1000003) * 1000003);
    }

    public final String toString() {
        return "VkpStatus{exceptionType=" + this.a + ", remoteException=" + this.b.toString() + "}";
    }
}
