package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sh1 {
    public static final sh1 a;
    public static final sh1 b;
    public static final /* synthetic */ sh1[] c;

    static {
        sh1 sh1Var = new sh1("Width", 0);
        a = sh1Var;
        sh1 sh1Var2 = new sh1("Height", 1);
        b = sh1Var2;
        c = new sh1[]{sh1Var, sh1Var2};
    }

    public static sh1 valueOf(String str) {
        return (sh1) Enum.valueOf(sh1.class, str);
    }

    public static sh1[] values() {
        return (sh1[]) c.clone();
    }
}
