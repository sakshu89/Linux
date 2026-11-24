package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class b31 {
    public static final b31 a;
    public static final b31 b;
    public static final /* synthetic */ b31[] c;

    static {
        b31 b31Var = new b31("Min", 0);
        a = b31Var;
        b31 b31Var2 = new b31("Max", 1);
        b = b31Var2;
        c = new b31[]{b31Var, b31Var2};
    }

    public static b31 valueOf(String str) {
        return (b31) Enum.valueOf(b31.class, str);
    }

    public static b31[] values() {
        return (b31[]) c.clone();
    }
}
