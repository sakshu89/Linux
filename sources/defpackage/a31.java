package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a31 {
    public static final a31 a;
    public static final a31 b;
    public static final /* synthetic */ a31[] c;

    static {
        a31 a31Var = new a31("Min", 0);
        a = a31Var;
        a31 a31Var2 = new a31("Max", 1);
        b = a31Var2;
        c = new a31[]{a31Var, a31Var2};
    }

    public static a31 valueOf(String str) {
        return (a31) Enum.valueOf(a31.class, str);
    }

    public static a31[] values() {
        return (a31[]) c.clone();
    }
}
