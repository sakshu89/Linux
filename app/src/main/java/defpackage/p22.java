package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p22 {
    public static final p22 a;
    public static final p22 b;
    public static final p22 c;
    public static final p22 e;
    public static final p22 f;
    public static final p22 i;
    public static final p22 j;
    public static final /* synthetic */ p22[] k;

    static {
        p22 p22Var = new p22("ON", 0);
        a = p22Var;
        p22 p22Var2 = new p22("OFF", 1);
        b = p22Var2;
        p22 p22Var3 = new p22("TURNING_ON", 2);
        c = p22Var3;
        p22 p22Var4 = new p22("TURNING_OFF", 3);
        e = p22Var4;
        p22 p22Var5 = new p22("UNKNOWN", 4);
        f = p22Var5;
        p22 p22Var6 = new p22("PERMISSION_DENIED", 5);
        i = p22Var6;
        p22 p22Var7 = new p22("UNAVAILABLE", 6);
        j = p22Var7;
        k = new p22[]{p22Var, p22Var2, p22Var3, p22Var4, p22Var5, p22Var6, p22Var7};
    }

    public static p22 valueOf(String str) {
        return (p22) Enum.valueOf(p22.class, str);
    }

    public static p22[] values() {
        return (p22[]) k.clone();
    }
}
