package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class tf0 extends ik1 {
    public final hq0 a;

    public tf0(hq0 hq0Var) {
        this.a = hq0Var;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        return new ro(new so(), this.a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof tf0) {
            return this.a == ((tf0) obj).a;
        }
        return false;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        ro roVar = (ro) dk1Var;
        roVar.X = this.a;
        roVar.I0();
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
