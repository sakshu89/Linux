package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fw2 {
    public static final fw2 a;
    public static final fw2 b;
    public static final fw2 c;
    public static final fw2 e;
    public static final fw2 f;
    public static final fw2 i;
    public static final fw2 j;
    public static final /* synthetic */ fw2[] k;

    static {
        fw2 fw2Var = new fw2("SEARCH_BAR", 0);
        a = fw2Var;
        fw2 fw2Var2 = new fw2("COMMUNITIES_TAB", 1);
        b = fw2Var2;
        fw2 fw2Var3 = new fw2("SPONSOR_CLOSE", 2);
        c = fw2Var3;
        fw2 fw2Var4 = new fw2("MINI_PLAYER_CLOSE", 3);
        e = fw2Var4;
        fw2 fw2Var5 = new fw2("CHAT_ROW", 4);
        fw2 fw2Var6 = new fw2("CANCEL_BUTTON", 5);
        f = fw2Var6;
        fw2 fw2Var7 = new fw2("CLOSE_CONTROL", 6);
        i = fw2Var7;
        fw2 fw2Var8 = new fw2("GENERIC", 7);
        j = fw2Var8;
        k = new fw2[]{fw2Var, fw2Var2, fw2Var3, fw2Var4, fw2Var5, fw2Var6, fw2Var7, fw2Var8};
    }

    public static fw2 valueOf(String str) {
        return (fw2) Enum.valueOf(fw2.class, str);
    }

    public static fw2[] values() {
        return (fw2[]) k.clone();
    }
}
