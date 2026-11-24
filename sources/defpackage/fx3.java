package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fx3 implements qx3 {
    public final int a;

    public fx3(int i) {
        this.a = i;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return qx3.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qx3)) {
            return false;
        }
        qx3 qx3Var = (qx3) obj;
        return this.a == qx3Var.zza() && px3.a.equals(qx3Var.zzb());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (this.a ^ 14552422) + (px3.a.hashCode() ^ 2041407134);
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.a + "intEncoding=" + px3.a + ')';
    }

    @Override // defpackage.qx3
    public final int zza() {
        return this.a;
    }

    @Override // defpackage.qx3
    public final px3 zzb() {
        return px3.a;
    }
}
