package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class z61 {
    public static final z61 a;
    public static final z61 b;
    public static final /* synthetic */ z61[] c;

    static {
        z61 z61Var = new z61("Ltr", 0);
        a = z61Var;
        z61 z61Var2 = new z61("Rtl", 1);
        b = z61Var2;
        c = new z61[]{z61Var, z61Var2};
    }

    public static z61 valueOf(String str) {
        return (z61) Enum.valueOf(z61.class, str);
    }

    public static z61[] values() {
        return (z61[]) c.clone();
    }
}
