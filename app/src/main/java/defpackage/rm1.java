package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rm1 {
    public static final rm1 a;
    public static final rm1 b;
    public static final /* synthetic */ rm1[] c;

    static {
        rm1 rm1Var = new rm1("Default", 0);
        a = rm1Var;
        rm1 rm1Var2 = new rm1("UserInput", 1);
        b = rm1Var2;
        c = new rm1[]{rm1Var, rm1Var2, new rm1("PreventUserInput", 2)};
    }

    public static rm1 valueOf(String str) {
        return (rm1) Enum.valueOf(rm1.class, str);
    }

    public static rm1[] values() {
        return (rm1[]) c.clone();
    }
}
