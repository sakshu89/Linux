package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class xe2 {
    public static final xe2 a;
    public static final xe2 b;
    public static final /* synthetic */ xe2[] c;

    static {
        xe2 xe2Var = new xe2("Inherit", 0);
        a = xe2Var;
        xe2 xe2Var2 = new xe2("SecureOn", 1);
        b = xe2Var2;
        c = new xe2[]{xe2Var, xe2Var2, new xe2("SecureOff", 2)};
    }

    public static xe2 valueOf(String str) {
        return (xe2) Enum.valueOf(xe2.class, str);
    }

    public static xe2[] values() {
        return (xe2[]) c.clone();
    }
}
