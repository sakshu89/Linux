package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class vs1 extends es4 {
    public final s82 a;
    public final na b;

    public vs1(s82 s82Var) {
        na naVarA;
        this.a = s82Var;
        if (ez3.b(s82Var)) {
            naVarA = null;
        } else {
            naVarA = pa.a();
            na.b(naVarA, s82Var);
        }
        this.b = naVarA;
    }

    @Override // defpackage.es4
    public final l42 a() {
        s82 s82Var = this.a;
        return new l42(s82Var.a, s82Var.b, s82Var.c, s82Var.d);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof vs1) {
            return this.a.equals(((vs1) obj).a);
        }
        return false;
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
