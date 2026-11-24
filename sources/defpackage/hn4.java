package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public enum hn4 implements p14 {
    /* JADX INFO: Fake field, exist only in values array */
    TYPE_UNKNOWN(0),
    TYPE_THIN(1),
    TYPE_THICK(2),
    /* JADX INFO: Fake field, exist only in values array */
    TYPE_GMV(3);

    public final int a;

    hn4(int i) {
        this.a = i;
    }

    @Override // defpackage.p14
    public final int zza() {
        return this.a;
    }
}
