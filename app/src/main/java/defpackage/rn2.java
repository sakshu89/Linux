package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rn2 {
    public static final rn2 H;
    public static final /* synthetic */ rn2[] X;
    public static final el1 a;
    public static final rn2 b;
    public static final rn2 c;
    public static final rn2 e;
    public static final rn2 f;
    public static final rn2 i;
    public static final rn2 j;
    public static final rn2 k;
    public static final rn2 n;
    public static final rn2 s;
    public static final rn2 t;
    public static final rn2 u;
    public static final rn2 v;
    public static final rn2 w;
    public static final rn2 x;

    static {
        rn2 rn2Var = new rn2("IDLE", 0);
        b = rn2Var;
        rn2 rn2Var2 = new rn2("LISTENING", 1);
        c = rn2Var2;
        rn2 rn2Var3 = new rn2("PROCESSING", 2);
        e = rn2Var3;
        rn2 rn2Var4 = new rn2("THINKING", 3);
        f = rn2Var4;
        rn2 rn2Var5 = new rn2("EXECUTING", 4);
        i = rn2Var5;
        rn2 rn2Var6 = new rn2("VERIFYING", 5);
        j = rn2Var6;
        rn2 rn2Var7 = new rn2("SUCCESS", 6);
        k = rn2Var7;
        rn2 rn2Var8 = new rn2("PARTIAL", 7);
        n = rn2Var8;
        rn2 rn2Var9 = new rn2("UNCLEAR", 8);
        s = rn2Var9;
        rn2 rn2Var10 = new rn2("BLOCKED", 9);
        t = rn2Var10;
        rn2 rn2Var11 = new rn2("ERROR", 10);
        u = rn2Var11;
        rn2 rn2Var12 = new rn2("CONFIRMATION", 11);
        v = rn2Var12;
        rn2 rn2Var13 = new rn2("ASKING", 12);
        w = rn2Var13;
        rn2 rn2Var14 = new rn2("PERMISSION_REQUIRED", 13);
        x = rn2Var14;
        rn2 rn2Var15 = new rn2("OFFLINE", 14);
        H = rn2Var15;
        X = new rn2[]{rn2Var, rn2Var2, rn2Var3, rn2Var4, rn2Var5, rn2Var6, rn2Var7, rn2Var8, rn2Var9, rn2Var10, rn2Var11, rn2Var12, rn2Var13, rn2Var14, rn2Var15};
        a = new el1(18);
    }

    public static rn2 valueOf(String str) {
        return (rn2) Enum.valueOf(rn2.class, str);
    }

    public static rn2[] values() {
        return (rn2[]) X.clone();
    }

    public final boolean a() {
        return this == e || this == f || this == i || this == j;
    }

    public final boolean b() {
        return this == v || this == w || this == x;
    }
}
