package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class w30 {
    public static final w30 a;
    public static final w30 b;
    public static final w30 c;
    public static final w30 e;
    public static final w30 f;
    public static final w30 i;
    public static final w30 j;
    public static final w30 k;
    public static final w30 n;
    public static final w30 s;
    public static final w30 t;
    public static final /* synthetic */ w30[] u;

    static {
        w30 w30Var = new w30("TLS_TRUST", 0);
        a = w30Var;
        w30 w30Var2 = new w30("NO_INTERNET", 1);
        b = w30Var2;
        w30 w30Var3 = new w30("TIMEOUT", 2);
        c = w30Var3;
        w30 w30Var4 = new w30("KEY_REJECTED", 3);
        e = w30Var4;
        w30 w30Var5 = new w30("ACCESS_DENIED", 4);
        f = w30Var5;
        w30 w30Var6 = new w30("NO_CREDIT", 5);
        i = w30Var6;
        w30 w30Var7 = new w30("QUOTA_EXHAUSTED", 6);
        j = w30Var7;
        w30 w30Var8 = new w30("RATE_LIMITED", 7);
        k = w30Var8;
        w30 w30Var9 = new w30("NO_MODELS", 8);
        n = w30Var9;
        w30 w30Var10 = new w30("SERVER", 9);
        s = w30Var10;
        w30 w30Var11 = new w30("OTHER", 10);
        t = w30Var11;
        u = new w30[]{w30Var, w30Var2, w30Var3, w30Var4, w30Var5, w30Var6, w30Var7, w30Var8, w30Var9, w30Var10, w30Var11};
    }

    public static w30 valueOf(String str) {
        return (w30) Enum.valueOf(w30.class, str);
    }

    public static w30[] values() {
        return (w30[]) u.clone();
    }
}
