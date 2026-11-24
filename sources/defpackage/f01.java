package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f01 {
    public static final f01 a;
    public static final f01 b;
    public static final f01 c;
    public static final /* synthetic */ f01[] e;

    static {
        f01 f01Var = new f01("Yes", 0);
        a = f01Var;
        f01 f01Var2 = new f01("No", 1);
        b = f01Var2;
        f01 f01Var3 = new f01("NotInitialized", 2);
        c = f01Var3;
        e = new f01[]{f01Var, f01Var2, f01Var3};
    }

    public static f01 valueOf(String str) {
        return (f01) Enum.valueOf(f01.class, str);
    }

    public static f01[] values() {
        return (f01[]) e.clone();
    }
}
