package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ak2 {
    public static final ak2 a;
    public static final /* synthetic */ ak2[] b;

    /* JADX INFO: Fake field, exist only in values array */
    ak2 EF0;

    static {
        ak2 ak2Var = new ak2("CornerExtraExtraLarge", 0);
        ak2 ak2Var2 = new ak2("CornerExtraLarge", 1);
        ak2 ak2Var3 = new ak2("CornerExtraLargeIncreased", 2);
        ak2 ak2Var4 = new ak2("CornerExtraLargeTop", 3);
        ak2 ak2Var5 = new ak2("CornerExtraSmall", 4);
        ak2 ak2Var6 = new ak2("CornerExtraSmallTop", 5);
        ak2 ak2Var7 = new ak2("CornerFull", 6);
        a = ak2Var7;
        b = new ak2[]{ak2Var, ak2Var2, ak2Var3, ak2Var4, ak2Var5, ak2Var6, ak2Var7, new ak2("CornerLarge", 7), new ak2("CornerLargeEnd", 8), new ak2("CornerLargeIncreased", 9), new ak2("CornerLargeStart", 10), new ak2("CornerLargeTop", 11), new ak2("CornerMedium", 12), new ak2("CornerNone", 13), new ak2("CornerSmall", 14)};
    }

    public static ak2 valueOf(String str) {
        return (ak2) Enum.valueOf(ak2.class, str);
    }

    public static ak2[] values() {
        return (ak2[]) b.clone();
    }
}
