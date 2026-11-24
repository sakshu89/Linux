package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e33 {
    public static final e33 a;
    public static final e33 b;
    public static final e33 c;
    public static final e33 e;
    public static final e33 f;
    public static final e33 i;
    public static final e33 j;
    public static final e33 k;
    public static final e33 n;
    public static final e33 s;
    public static final /* synthetic */ e33[] t;

    static {
        e33 e33Var = new e33("SUCCESS", 0);
        a = e33Var;
        e33 e33Var2 = new e33("PARTIAL", 1);
        b = e33Var2;
        e33 e33Var3 = new e33("FAILED", 2);
        c = e33Var3;
        e33 e33Var4 = new e33("BLOCKED", 3);
        e = e33Var4;
        e33 e33Var5 = new e33("ASKED", 4);
        f = e33Var5;
        e33 e33Var6 = new e33("NEEDS_CONFIRMATION", 5);
        i = e33Var6;
        e33 e33Var7 = new e33("NEEDS_PERMISSION", 6);
        j = e33Var7;
        e33 e33Var8 = new e33("CANCELLED", 7);
        k = e33Var8;
        e33 e33Var9 = new e33("UNSUPPORTED", 8);
        n = e33Var9;
        e33 e33Var10 = new e33("CHATTED", 9);
        s = e33Var10;
        t = new e33[]{e33Var, e33Var2, e33Var3, e33Var4, e33Var5, e33Var6, e33Var7, e33Var8, e33Var9, e33Var10, new e33("NOT_UNDERSTOOD", 10)};
    }

    public static e33 valueOf(String str) {
        return (e33) Enum.valueOf(e33.class, str);
    }

    public static e33[] values() {
        return (e33[]) t.clone();
    }
}
