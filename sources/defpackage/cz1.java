package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cz1 {
    public static final cz1 a;
    public static final cz1 b;
    public static final cz1 c;
    public static final cz1 e;
    public static final cz1 f;
    public static final cz1 i;
    public static final /* synthetic */ cz1[] j;

    static {
        cz1 cz1Var = new cz1("NONE", 0);
        a = cz1Var;
        cz1 cz1Var2 = new cz1("AC", 1);
        b = cz1Var2;
        cz1 cz1Var3 = new cz1("USB", 2);
        c = cz1Var3;
        cz1 cz1Var4 = new cz1("WIRELESS", 3);
        e = cz1Var4;
        cz1 cz1Var5 = new cz1("DOCK", 4);
        f = cz1Var5;
        cz1 cz1Var6 = new cz1("UNKNOWN", 5);
        i = cz1Var6;
        j = new cz1[]{cz1Var, cz1Var2, cz1Var3, cz1Var4, cz1Var5, cz1Var6};
    }

    public static cz1 valueOf(String str) {
        return (cz1) Enum.valueOf(cz1.class, str);
    }

    public static cz1[] values() {
        return (cz1[]) j.clone();
    }

    public final String a() {
        int iOrdinal = ordinal();
        if (iOrdinal == 0) {
            return "not charging";
        }
        if (iOrdinal == 1) {
            return "on the charger";
        }
        if (iOrdinal == 2) {
            return "charging over USB";
        }
        if (iOrdinal == 3) {
            return "charging wirelessly";
        }
        if (iOrdinal == 4) {
            return "charging on a dock";
        }
        if (iOrdinal == 5) {
            return "charging";
        }
        dk0.l();
        return null;
    }
}
