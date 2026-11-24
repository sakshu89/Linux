package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rv0 {
    public static final rv0 a;
    public static final rv0 b;
    public static final rv0 c;
    public static final /* synthetic */ rv0[] e;

    static {
        rv0 rv0Var = new rv0("None", 0);
        a = rv0Var;
        rv0 rv0Var2 = new rv0("Selection", 1);
        b = rv0Var2;
        rv0 rv0Var3 = new rv0("Cursor", 2);
        c = rv0Var3;
        e = new rv0[]{rv0Var, rv0Var2, rv0Var3};
    }

    public static rv0 valueOf(String str) {
        return (rv0) Enum.valueOf(rv0.class, str);
    }

    public static rv0[] values() {
        return (rv0[]) e.clone();
    }
}
