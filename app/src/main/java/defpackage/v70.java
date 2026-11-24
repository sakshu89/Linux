package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class v70 {
    public static final v70 a;
    public static final v70 b;
    public static final v70 c;
    public static final v70 e;
    public static final /* synthetic */ v70[] f;

    static {
        v70 v70Var = new v70("DEFAULT", 0);
        a = v70Var;
        v70 v70Var2 = new v70("LAZY", 1);
        b = v70Var2;
        v70 v70Var3 = new v70("ATOMIC", 2);
        c = v70Var3;
        v70 v70Var4 = new v70("UNDISPATCHED", 3);
        e = v70Var4;
        f = new v70[]{v70Var, v70Var2, v70Var3, v70Var4};
    }

    public static v70 valueOf(String str) {
        return (v70) Enum.valueOf(v70.class, str);
    }

    public static v70[] values() {
        return (v70[]) f.clone();
    }
}
