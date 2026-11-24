package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class in0 {
    public static final in0 a;
    public static final /* synthetic */ in0[] b;

    /* JADX INFO: Fake field, exist only in values array */
    in0 EF0;

    static {
        in0 in0Var = new in0("Visible", 0);
        in0 in0Var2 = new in0("Clip", 1);
        a = in0Var2;
        b = new in0[]{in0Var, in0Var2, new in0("ExpandIndicator", 2), new in0("ExpandOrCollapseIndicator", 3)};
    }

    public static in0 valueOf(String str) {
        return (in0) Enum.valueOf(in0.class, str);
    }

    public static in0[] values() {
        return (in0[]) b.clone();
    }
}
