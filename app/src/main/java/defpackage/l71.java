package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l71 {
    public static final l71 a;
    public static final l71 b;
    public static final l71 c;
    public static final /* synthetic */ l71[] e;

    static {
        l71 l71Var = new l71("InMeasureBlock", 0);
        a = l71Var;
        l71 l71Var2 = new l71("InLayoutBlock", 1);
        b = l71Var2;
        l71 l71Var3 = new l71("NotUsed", 2);
        c = l71Var3;
        e = new l71[]{l71Var, l71Var2, l71Var3};
    }

    public static l71 valueOf(String str) {
        return (l71) Enum.valueOf(l71.class, str);
    }

    public static l71[] values() {
        return (l71[]) e.clone();
    }
}
