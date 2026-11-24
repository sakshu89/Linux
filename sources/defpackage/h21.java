package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class h21 extends f21 {
    public static final h21 e = new h21(1, 0, 1);

    @Override // defpackage.f21
    public final boolean equals(Object obj) {
        if (!(obj instanceof h21)) {
            return false;
        }
        if (isEmpty() && ((h21) obj).isEmpty()) {
            return true;
        }
        h21 h21Var = (h21) obj;
        return this.a == h21Var.a && this.b == h21Var.b;
    }

    @Override // defpackage.f21
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.a * 31) + this.b;
    }

    @Override // defpackage.f21
    public final boolean isEmpty() {
        return this.a > this.b;
    }

    @Override // defpackage.f21
    public final String toString() {
        return this.a + ".." + this.b;
    }
}
