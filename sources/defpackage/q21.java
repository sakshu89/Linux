package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q21 {
    public static final q21 a;
    public static final q21 b;
    public static final q21 c;
    public static final q21 e;
    public static final /* synthetic */ q21[] f;

    static {
        q21 q21Var = new q21("LOCAL_RULES", 0);
        a = q21Var;
        q21 q21Var2 = new q21("LOCAL_MEMORY", 1);
        q21 q21Var3 = new q21("CONVERSATION_CONTEXT", 2);
        b = q21Var3;
        q21 q21Var4 = new q21("REMOTE_MODEL", 3);
        c = q21Var4;
        q21 q21Var5 = new q21("USER_CHOICE", 4);
        e = q21Var5;
        f = new q21[]{q21Var, q21Var2, q21Var3, q21Var4, q21Var5};
    }

    public static q21 valueOf(String str) {
        return (q21) Enum.valueOf(q21.class, str);
    }

    public static q21[] values() {
        return (q21[]) f.clone();
    }
}
