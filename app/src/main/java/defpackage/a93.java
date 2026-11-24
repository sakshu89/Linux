package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a93 {
    public static final a93 a;
    public static final a93 b;
    public static final a93 c;
    public static final /* synthetic */ a93[] e;

    static {
        a93 a93Var = new a93("CONNECT_LIVE", 0);
        a = a93Var;
        a93 a93Var2 = new a93("WAIT_FOR_LIVE", 1);
        b = a93Var2;
        a93 a93Var3 = new a93("LISTEN_LOCAL", 2);
        c = a93Var3;
        e = new a93[]{a93Var, a93Var2, a93Var3};
    }

    public static a93 valueOf(String str) {
        return (a93) Enum.valueOf(a93.class, str);
    }

    public static a93[] values() {
        return (a93[]) e.clone();
    }
}
