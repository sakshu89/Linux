package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ce2 extends ik1 {
    public final md2 a;

    public ce2(md2 md2Var) {
        this.a = md2Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        id2 id2Var = new id2();
        id2Var.x = this.a;
        id2Var.H = true;
        return id2Var;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof ce2) {
            return g31.a(this.a, ((ce2) obj).a);
        }
        return false;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        id2 id2Var = (id2) dk1Var;
        id2Var.x = this.a;
        id2Var.H = true;
    }

    public final int hashCode() {
        return Boolean.hashCode(true) + ky0.e(this.a.hashCode() * 31, 31, false);
    }
}
