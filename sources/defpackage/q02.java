package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q02 {
    public static final q02 a;
    public static final q02 b;
    public static final /* synthetic */ q02[] c;

    static {
        q02 q02Var = new q02("IDLE", 0);
        a = q02Var;
        q02 q02Var2 = new q02("STREAMING", 1);
        b = q02Var2;
        c = new q02[]{q02Var, q02Var2};
    }

    public static q02 valueOf(String str) {
        return (q02) Enum.valueOf(q02.class, str);
    }

    public static q02[] values() {
        return (q02[]) c.clone();
    }
}
