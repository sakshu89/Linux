package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class t70 {
    public static final t70 a;
    public static final t70 b;
    public static final t70 c;
    public static final /* synthetic */ t70[] e;

    static {
        t70 t70Var = new t70("COROUTINE_SUSPENDED", 0);
        a = t70Var;
        t70 t70Var2 = new t70("UNDECIDED", 1);
        b = t70Var2;
        t70 t70Var3 = new t70("RESUMED", 2);
        c = t70Var3;
        e = new t70[]{t70Var, t70Var2, t70Var3};
    }

    public static t70 valueOf(String str) {
        return (t70) Enum.valueOf(t70.class, str);
    }

    public static t70[] values() {
        return (t70[]) e.clone();
    }
}
