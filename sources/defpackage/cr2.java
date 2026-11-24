package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cr2 implements s63 {
    public final s63 a;
    public final long b;

    public cr2(s63 s63Var, long j) {
        this.a = s63Var;
        this.b = j;
    }

    @Override // defpackage.s63
    public final long a(vd vdVar, vd vdVar2, vd vdVar3) {
        return this.a.a(vdVar, vdVar2, vdVar3) + this.b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof cr2)) {
            return false;
        }
        cr2 cr2Var = (cr2) obj;
        return cr2Var.b == this.b && g31.a(cr2Var.a, this.a);
    }

    @Override // defpackage.s63
    public final vd f(long j, vd vdVar, vd vdVar2, vd vdVar3) {
        long j2 = this.b;
        return j < j2 ? vdVar3 : this.a.f(j - j2, vdVar, vdVar2, vdVar3);
    }

    @Override // defpackage.s63
    public final vd h(long j, vd vdVar, vd vdVar2, vd vdVar3) {
        long j2 = this.b;
        return j < j2 ? vdVar : this.a.h(j - j2, vdVar, vdVar2, vdVar3);
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    @Override // defpackage.s63
    public final boolean isInfinite() {
        return this.a.isInfinite();
    }
}
