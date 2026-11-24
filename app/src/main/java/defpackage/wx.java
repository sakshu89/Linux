package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wx extends ik1 {
    public final j a;

    public wx(j jVar) {
        this.a = jVar;
    }

    @Override // defpackage.ik1
    public final dk1 e() {
        vx vxVar = new vx();
        vxVar.x = this.a;
        return vxVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof wx) {
            return this.a == ((wx) obj).a;
        }
        return false;
    }

    @Override // defpackage.ik1
    public final void f(dk1 dk1Var) {
        vx vxVar = (vx) dk1Var;
        vxVar.x = this.a;
        a34.a(vxVar);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }
}
