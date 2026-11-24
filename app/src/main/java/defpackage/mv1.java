package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class mv1 {
    public static final mv1 a;
    public static final mv1 b;
    public static final mv1 c;
    public static final mv1 e;
    public static final mv1 f;
    public static final mv1 i;
    public static final mv1 j;
    public static final /* synthetic */ mv1[] k;

    static {
        mv1 mv1Var = new mv1("Invalid", 0);
        a = mv1Var;
        mv1 mv1Var2 = new mv1("Cancelled", 1);
        b = mv1Var2;
        mv1 mv1Var3 = new mv1("InitialPending", 2);
        c = mv1Var3;
        mv1 mv1Var4 = new mv1("RecomposePending", 3);
        e = mv1Var4;
        mv1 mv1Var5 = new mv1("Recomposing", 4);
        f = mv1Var5;
        mv1 mv1Var6 = new mv1("ApplyPending", 5);
        i = mv1Var6;
        mv1 mv1Var7 = new mv1("Applied", 6);
        j = mv1Var7;
        k = new mv1[]{mv1Var, mv1Var2, mv1Var3, mv1Var4, mv1Var5, mv1Var6, mv1Var7};
    }

    public static mv1 valueOf(String str) {
        return (mv1) Enum.valueOf(mv1.class, str);
    }

    public static mv1[] values() {
        return (mv1[]) k.clone();
    }
}
