package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qp3 extends pp3 {
    public final Object a;

    public qp3(Object obj) {
        this.a = obj;
    }

    @Override // defpackage.pp3
    public final Object a() {
        return this.a;
    }

    @Override // defpackage.pp3
    public final Object b() {
        return this.a;
    }

    @Override // defpackage.pp3
    public final boolean c() {
        return true;
    }

    @Override // defpackage.pp3
    public final boolean equals(Object obj) {
        if (obj instanceof qp3) {
            return this.a.equals(((qp3) obj).a);
        }
        return false;
    }

    @Override // defpackage.pp3
    public final int hashCode() {
        return this.a.hashCode() + 1502476572;
    }

    public final String toString() {
        return cq.v("Optional.of(", this.a.toString(), ")");
    }
}
