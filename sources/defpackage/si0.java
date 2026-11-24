package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class si0 {
    public static final si0 a;
    public static final si0 b;
    public static final si0 c;
    public static final /* synthetic */ si0[] e;

    static {
        si0 si0Var = new si0("PreEnter", 0);
        a = si0Var;
        si0 si0Var2 = new si0("Visible", 1);
        b = si0Var2;
        si0 si0Var3 = new si0("PostExit", 2);
        c = si0Var3;
        e = new si0[]{si0Var, si0Var2, si0Var3};
    }

    public static si0 valueOf(String str) {
        return (si0) Enum.valueOf(si0.class, str);
    }

    public static si0[] values() {
        return (si0[]) e.clone();
    }
}
