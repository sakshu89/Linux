package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class be0 {
    public static final be0 a;
    public static final be0 b;
    public static final be0 c;
    public static final be0 e;
    public static final /* synthetic */ be0[] f;

    static {
        be0 be0Var = new be0("Up", 0);
        a = be0Var;
        be0 be0Var2 = new be0("Drag", 1);
        b = be0Var2;
        be0 be0Var3 = new be0("Timeout", 2);
        c = be0Var3;
        be0 be0Var4 = new be0("Cancel", 3);
        e = be0Var4;
        f = new be0[]{be0Var, be0Var2, be0Var3, be0Var4};
    }

    public static be0 valueOf(String str) {
        return (be0) Enum.valueOf(be0.class, str);
    }

    public static be0[] values() {
        return (be0[]) f.clone();
    }
}
