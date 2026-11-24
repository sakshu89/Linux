package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class ls2 extends ik1 {
    public final fq0 a;

    public ls2(fq0 fq0Var) {
        this.a = fq0Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        return new ms2(this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ls2) {
            return this.a == ((ls2) obj).a;
        }
        return false;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        ((ms2) dk1Var).X = this.a;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
