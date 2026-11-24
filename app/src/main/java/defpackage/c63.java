package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class c63 {
    public static final c63 a;
    public static final c63 b;
    public static final c63 c;
    public static final /* synthetic */ c63[] e;

    static {
        c63 c63Var = new c63("TEXT", 0);
        a = c63Var;
        c63 c63Var2 = new c63("TAP", 1);
        b = c63Var2;
        c63 c63Var3 = new c63("AMBIENT", 2);
        c = c63Var3;
        e = new c63[]{c63Var, c63Var2, c63Var3};
    }

    public static c63 valueOf(String str) {
        return (c63) Enum.valueOf(c63.class, str);
    }

    public static c63[] values() {
        return (c63[]) e.clone();
    }
}
