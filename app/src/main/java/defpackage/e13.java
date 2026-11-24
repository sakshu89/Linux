package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e13 {
    public static final e13 a;
    public static final e13 b;
    public static final e13 c;
    public static final /* synthetic */ e13[] e;

    static {
        e13 e13Var = new e13("Uninitialized", 0);
        a = e13Var;
        e13 e13Var2 = new e13("Detached", 1);
        b = e13Var2;
        e13 e13Var3 = new e13("Attached", 2);
        c = e13Var3;
        e = new e13[]{e13Var, e13Var2, e13Var3};
    }

    public static e13 valueOf(String str) {
        return (e13) Enum.valueOf(e13.class, str);
    }

    public static e13[] values() {
        return (e13[]) e.clone();
    }
}
