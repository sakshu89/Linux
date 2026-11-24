package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q03 {
    public static final q03 a;
    public static final /* synthetic */ q03[] b;
    public static final /* synthetic */ gj0 c;

    static {
        q03 q03Var = new q03("FREE", 0);
        a = q03Var;
        q03[] q03VarArr = {q03Var, new q03("PRO", 1), new q03("PREMIUM", 2)};
        b = q03VarArr;
        c = new gj0(q03VarArr);
    }

    public static q03 valueOf(String str) {
        return (q03) Enum.valueOf(q03.class, str);
    }

    public static q03[] values() {
        return (q03[]) b.clone();
    }
}
