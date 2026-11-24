package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ed3 {
    public static final ed3 a;
    public static final ed3 b;
    public static final ed3 c;
    public static final ed3 e;
    public static final ed3 f;
    public static final ed3 i;
    public static final /* synthetic */ ed3[] j;

    static {
        ed3 ed3Var = new ed3("LIKE", 0);
        a = ed3Var;
        ed3 ed3Var2 = new ed3("DISLIKE", 1);
        b = ed3Var2;
        ed3 ed3Var3 = new ed3("SUBSCRIBE", 2);
        c = ed3Var3;
        ed3 ed3Var4 = new ed3("PAUSE", 3);
        e = ed3Var4;
        ed3 ed3Var5 = new ed3("PLAY", 4);
        f = ed3Var5;
        ed3 ed3Var6 = new ed3("CLOSE", 5);
        i = ed3Var6;
        j = new ed3[]{ed3Var, ed3Var2, ed3Var3, ed3Var4, ed3Var5, ed3Var6};
    }

    public static ed3 valueOf(String str) {
        return (ed3) Enum.valueOf(ed3.class, str);
    }

    public static ed3[] values() {
        return (ed3[]) j.clone();
    }
}
