package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class j71 {
    public static final j71 a;
    public static final j71 b;
    public static final j71 c;
    public static final j71 e;
    public static final j71 f;
    public static final /* synthetic */ j71[] i;

    static {
        j71 j71Var = new j71("Measuring", 0);
        a = j71Var;
        j71 j71Var2 = new j71("LookaheadMeasuring", 1);
        b = j71Var2;
        j71 j71Var3 = new j71("LayingOut", 2);
        c = j71Var3;
        j71 j71Var4 = new j71("LookaheadLayingOut", 3);
        e = j71Var4;
        j71 j71Var5 = new j71("Idle", 4);
        f = j71Var5;
        i = new j71[]{j71Var, j71Var2, j71Var3, j71Var4, j71Var5};
    }

    public static j71 valueOf(String str) {
        return (j71) Enum.valueOf(j71.class, str);
    }

    public static j71[] values() {
        return (j71[]) i.clone();
    }
}
