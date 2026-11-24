package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l14 implements t14 {
    public final int a;

    public l14(int i) {
        this.a = i;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return t14.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t14)) {
            return false;
        }
        t14 t14Var = (t14) obj;
        return this.a == t14Var.zza() && r14.a.equals(t14Var.zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.a ^ 14552422) + (r14.a.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.a + "intEncoding=" + r14.a + ')';
    }

    @Override // defpackage.t14
    public final int zza() {
        return this.a;
    }

    @Override // defpackage.t14
    public final r14 zzb() {
        return r14.a;
    }
}
