package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class n8 {
    public static final n8 a;
    public static final n8 b;
    public static final /* synthetic */ n8[] c;

    static {
        n8 n8Var = new n8("SHOW_ORIGINAL", 0);
        a = n8Var;
        n8 n8Var2 = new n8("SHOW_TRANSLATED", 1);
        b = n8Var2;
        c = new n8[]{n8Var, n8Var2};
    }

    public static n8 valueOf(String str) {
        return (n8) Enum.valueOf(n8.class, str);
    }

    public static n8[] values() {
        return (n8[]) c.clone();
    }
}
