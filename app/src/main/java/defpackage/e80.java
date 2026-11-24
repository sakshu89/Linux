package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e80 {
    public static final e80 a;
    public static final e80 b;
    public static final e80 c;
    public static final /* synthetic */ e80[] e;

    static {
        e80 e80Var = new e80("CROSSED", 0);
        a = e80Var;
        e80 e80Var2 = new e80("NOT_CROSSED", 1);
        b = e80Var2;
        e80 e80Var3 = new e80("COLLAPSED", 2);
        c = e80Var3;
        e = new e80[]{e80Var, e80Var2, e80Var3};
    }

    public static e80 valueOf(String str) {
        return (e80) Enum.valueOf(e80.class, str);
    }

    public static e80[] values() {
        return (e80[]) e.clone();
    }
}
