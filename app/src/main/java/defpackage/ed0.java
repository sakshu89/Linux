package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ed0 {
    public static final ed0 a;
    public static final ed0 b;
    public static final ed0 c;
    public static final /* synthetic */ ed0[] e;

    static {
        ed0 ed0Var = new ed0("Vertical", 0);
        a = ed0Var;
        ed0 ed0Var2 = new ed0("Horizontal", 1);
        b = ed0Var2;
        ed0 ed0Var3 = new ed0("Both", 2);
        c = ed0Var3;
        e = new ed0[]{ed0Var, ed0Var2, ed0Var3};
    }

    public static ed0 valueOf(String str) {
        return (ed0) Enum.valueOf(ed0.class, str);
    }

    public static ed0[] values() {
        return (ed0[]) e.clone();
    }
}
