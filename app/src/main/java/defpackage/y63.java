package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class y63 {
    public static final y63 a;
    public static final y63 b;
    public static final /* synthetic */ y63[] c;

    static {
        y63 y63Var = new y63("Lsq2", 0);
        a = y63Var;
        y63 y63Var2 = new y63("Impulse", 1);
        b = y63Var2;
        c = new y63[]{y63Var, y63Var2};
    }

    public static y63 valueOf(String str) {
        return (y63) Enum.valueOf(y63.class, str);
    }

    public static y63[] values() {
        return (y63[]) c.clone();
    }
}
