package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public enum tq4 implements p14 {
    /* JADX INFO: Fake field, exist only in values array */
    TYPE_UNKNOWN(0),
    LATIN(1),
    /* JADX INFO: Fake field, exist only in values array */
    LATIN_AND_CHINESE(2),
    /* JADX INFO: Fake field, exist only in values array */
    LATIN_AND_DEVANAGARI(3),
    /* JADX INFO: Fake field, exist only in values array */
    LATIN_AND_JAPANESE(4),
    /* JADX INFO: Fake field, exist only in values array */
    LATIN_AND_KOREAN(5),
    /* JADX INFO: Fake field, exist only in values array */
    CREDIT_CARD(6),
    /* JADX INFO: Fake field, exist only in values array */
    DOCUMENT(7),
    /* JADX INFO: Fake field, exist only in values array */
    PIXEL_AI(8);

    public final int a;

    tq4(int i) {
        this.a = i;
    }

    @Override // defpackage.p14
    public final int zza() {
        return this.a;
    }
}
