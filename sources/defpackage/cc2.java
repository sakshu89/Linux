package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cc2 {
    public static final cc2 a;
    public static final cc2 b;
    public static final cc2 c;
    public static final cc2 e;
    public static final /* synthetic */ cc2[] f;

    static {
        cc2 cc2Var = new cc2("CHAT", 0);
        a = cc2Var;
        cc2 cc2Var2 = new cc2("VIDEO", 1);
        b = cc2Var2;
        cc2 cc2Var3 = new cc2("SHORT", 2);
        c = cc2Var3;
        cc2 cc2Var4 = new cc2("RESULT", 3);
        e = cc2Var4;
        f = new cc2[]{cc2Var, cc2Var2, cc2Var3, cc2Var4};
    }

    public static cc2 valueOf(String str) {
        return (cc2) Enum.valueOf(cc2.class, str);
    }

    public static cc2[] values() {
        return (cc2[]) f.clone();
    }
}
