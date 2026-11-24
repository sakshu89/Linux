package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class ol extends ik1 {
    public final hq0 a;

    public ol(hq0 hq0Var) {
        this.a = hq0Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        return new pl(this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ol) {
            return this.a == ((ol) obj).a;
        }
        return false;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        co1 co1Var;
        pl plVar = (pl) dk1Var;
        hq0 hq0Var = this.a;
        plVar.x = hq0Var;
        if (plVar.a.w && (co1Var = cm4.e(plVar, 2).H) != null) {
            co1Var.t1(hq0Var, true);
        }
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
