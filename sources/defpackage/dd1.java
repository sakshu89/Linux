package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dd1 {
    public static final dd1 a;
    public static final dd1 b;
    public static final dd1 c;
    public static final dd1 e;
    public static final /* synthetic */ dd1[] f;

    static {
        dd1 dd1Var = new dd1("TRANSIENT", 0);
        a = dd1Var;
        dd1 dd1Var2 = new dd1("CONFIGURATION", 1);
        b = dd1Var2;
        dd1 dd1Var3 = new dd1("QUOTA", 2);
        c = dd1Var3;
        dd1 dd1Var4 = new dd1("MICROPHONE_PERMISSION", 3);
        e = dd1Var4;
        f = new dd1[]{dd1Var, dd1Var2, dd1Var3, dd1Var4};
    }

    public static dd1 valueOf(String str) {
        return (dd1) Enum.valueOf(dd1.class, str);
    }

    public static dd1[] values() {
        return (dd1[]) f.clone();
    }
}
