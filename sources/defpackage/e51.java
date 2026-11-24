package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e51 {
    public static final e51 a;
    public static final e51 b;
    public static final e51 c;
    public static final e51 e;
    public static final /* synthetic */ e51[] f;

    static {
        e51 e51Var = new e51("STRONGBOX", 0);
        a = e51Var;
        e51 e51Var2 = new e51("TRUSTED_ENVIRONMENT", 1);
        b = e51Var2;
        e51 e51Var3 = new e51("SOFTWARE", 2);
        c = e51Var3;
        e51 e51Var4 = new e51("UNKNOWN", 3);
        e = e51Var4;
        f = new e51[]{e51Var, e51Var2, e51Var3, e51Var4};
    }

    public static e51 valueOf(String str) {
        return (e51) Enum.valueOf(e51.class, str);
    }

    public static e51[] values() {
        return (e51[]) f.clone();
    }
}
