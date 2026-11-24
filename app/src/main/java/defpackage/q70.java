package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q70 {
    public static final q70 a;
    public static final q70 b;
    public static final q70 c;
    public static final q70 e;
    public static final q70 f;
    public static final /* synthetic */ q70[] i;

    static {
        q70 q70Var = new q70("CPU_ACQUIRED", 0);
        a = q70Var;
        q70 q70Var2 = new q70("BLOCKING", 1);
        b = q70Var2;
        q70 q70Var3 = new q70("PARKING", 2);
        c = q70Var3;
        q70 q70Var4 = new q70("DORMANT", 3);
        e = q70Var4;
        q70 q70Var5 = new q70("TERMINATED", 4);
        f = q70Var5;
        i = new q70[]{q70Var, q70Var2, q70Var3, q70Var4, q70Var5};
    }

    public static q70 valueOf(String str) {
        return (q70) Enum.valueOf(q70.class, str);
    }

    public static q70[] values() {
        return (q70[]) i.clone();
    }
}
