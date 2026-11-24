package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q31 {
    public static final q31 a;
    public static final q31 b;
    public static final q31 c;
    public static final q31 e;
    public static final /* synthetic */ q31[] f;

    static {
        q31 q31Var = new q31("LookaheadMeasurement", 0);
        a = q31Var;
        q31 q31Var2 = new q31("LookaheadPlacement", 1);
        b = q31Var2;
        q31 q31Var3 = new q31("Measurement", 2);
        c = q31Var3;
        q31 q31Var4 = new q31("Placement", 3);
        e = q31Var4;
        f = new q31[]{q31Var, q31Var2, q31Var3, q31Var4};
    }

    public static q31 valueOf(String str) {
        return (q31) Enum.valueOf(q31.class, str);
    }

    public static q31[] values() {
        return (q31[]) f.clone();
    }
}
