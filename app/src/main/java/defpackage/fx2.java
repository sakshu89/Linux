package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class fx2 extends ik1 {
    public final gy2 a;

    public fx2(gy2 gy2Var) {
        this.a = gy2Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        return new hx2(this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof fx2) {
            return this.a == ((fx2) obj).a;
        }
        return false;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        ((hx2) dk1Var).X = this.a;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
