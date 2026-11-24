package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public enum vt {
    RELEASED(false),
    RELEASING(true),
    CLOSED(false),
    PENDING_OPEN(false),
    CLOSING(true),
    OPENING(true),
    OPEN(true),
    CONFIGURED(true);

    public final boolean a;

    vt(boolean z) {
        this.a = z;
    }
}
