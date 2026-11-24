package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class my {
    public static final my a;
    public static final /* synthetic */ my[] b;

    /* JADX INFO: Fake field, exist only in values array */
    my EF0;

    static {
        my myVar = new my("UNKNOWN", 0);
        my myVar2 = new my("ANDROID_FIREBASE", 1);
        a = myVar2;
        b = new my[]{myVar, myVar2};
    }

    public static my valueOf(String str) {
        return (my) Enum.valueOf(my.class, str);
    }

    public static my[] values() {
        return (my[]) b.clone();
    }
}
