package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public enum sm4 implements p14 {
    UNKNOWN_FORMAT(0),
    NV16(1),
    NV21(2),
    YV12(3),
    YUV_420_888(7),
    /* JADX INFO: Fake field, exist only in values array */
    JPEG(8),
    BITMAP(4),
    /* JADX INFO: Fake field, exist only in values array */
    CM_SAMPLE_BUFFER_REF(5),
    /* JADX INFO: Fake field, exist only in values array */
    UI_IMAGE(6),
    /* JADX INFO: Fake field, exist only in values array */
    CV_PIXEL_BUFFER_REF(9);

    public final int a;

    sm4(int i) {
        this.a = i;
    }

    @Override // defpackage.p14
    public final int zza() {
        return this.a;
    }
}
