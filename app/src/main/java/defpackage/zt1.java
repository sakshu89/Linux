package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zt1 {
    public static final zt1 a;
    public static final zt1 b;
    public static final zt1 c;
    public static final /* synthetic */ zt1[] e;

    static {
        zt1 zt1Var = new zt1("CORE", 0);
        a = zt1Var;
        zt1 zt1Var2 = new zt1("HISTORY", 1);
        b = zt1Var2;
        zt1 zt1Var3 = new zt1("SETTINGS", 2);
        c = zt1Var3;
        e = new zt1[]{zt1Var, zt1Var2, zt1Var3};
    }

    public static zt1 valueOf(String str) {
        return (zt1) Enum.valueOf(zt1.class, str);
    }

    public static zt1[] values() {
        return (zt1[]) e.clone();
    }
}
