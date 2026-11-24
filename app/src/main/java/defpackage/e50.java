package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e50 {
    public static final e50 a;
    public static final e50 b;
    public static final /* synthetic */ e50[] c;

    static {
        e50 e50Var = new e50("VIEW_APPEAR", 0);
        a = e50Var;
        e50 e50Var2 = new e50("VIEW_DISAPPEAR", 1);
        b = e50Var2;
        c = new e50[]{e50Var, e50Var2};
    }

    public static e50 valueOf(String str) {
        return (e50) Enum.valueOf(e50.class, str);
    }

    public static e50[] values() {
        return (e50[]) c.clone();
    }
}
