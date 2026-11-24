package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hy1 {
    public static final hy1 a;
    public static final hy1 b;
    public static final hy1 c;
    public static final /* synthetic */ hy1[] e;

    static {
        hy1 hy1Var = new hy1("Initial", 0);
        a = hy1Var;
        hy1 hy1Var2 = new hy1("Main", 1);
        b = hy1Var2;
        hy1 hy1Var3 = new hy1("Final", 2);
        c = hy1Var3;
        e = new hy1[]{hy1Var, hy1Var2, hy1Var3};
    }

    public static hy1 valueOf(String str) {
        return (hy1) Enum.valueOf(hy1.class, str);
    }

    public static hy1[] values() {
        return (hy1[]) e.clone();
    }
}
