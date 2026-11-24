package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class q22 {
    public static final q22 a;
    public static final q22 b;
    public static final /* synthetic */ q22[] c;

    static {
        q22 q22Var = new q22("ADAPTER", 0);
        a = q22Var;
        q22 q22Var2 = new q22("SETTINGS_SWITCH", 1);
        b = q22Var2;
        c = new q22[]{q22Var, q22Var2};
    }

    public static q22 valueOf(String str) {
        return (q22) Enum.valueOf(q22.class, str);
    }

    public static q22[] values() {
        return (q22[]) c.clone();
    }
}
