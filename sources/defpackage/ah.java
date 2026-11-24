package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ah {
    public static final ah a;
    public static final /* synthetic */ ah[] b;

    static {
        ah ahVar = new ah("ACTIVE", 0);
        a = ahVar;
        b = new ah[]{ahVar, new ah("STOPPED", 1)};
    }

    public static ah valueOf(String str) {
        return (ah) Enum.valueOf(ah.class, str);
    }

    public static ah[] values() {
        return (ah[]) b.clone();
    }
}
