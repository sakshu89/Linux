package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class la1 {
    public static final /* synthetic */ la1[] a = {new la1("SYNCHRONIZED", 0), new la1("PUBLICATION", 1), new la1("NONE", 2)};

    /* JADX INFO: Fake field, exist only in values array */
    la1 EF5;

    public static la1 valueOf(String str) {
        return (la1) Enum.valueOf(la1.class, str);
    }

    public static la1[] values() {
        return (la1[]) a.clone();
    }
}
