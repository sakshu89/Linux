package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qf1 {
    public static final qf1 a;
    public static final qf1 b;
    public static final qf1 c;
    public static final /* synthetic */ qf1[] e;

    static {
        qf1 qf1Var = new qf1("IsPlacedInLookahead", 0);
        a = qf1Var;
        qf1 qf1Var2 = new qf1("IsPlacedInApproach", 1);
        b = qf1Var2;
        qf1 qf1Var3 = new qf1("IsNotPlaced", 2);
        c = qf1Var3;
        e = new qf1[]{qf1Var, qf1Var2, qf1Var3};
    }

    public static qf1 valueOf(String str) {
        return (qf1) Enum.valueOf(qf1.class, str);
    }

    public static qf1[] values() {
        return (qf1[]) e.clone();
    }
}
