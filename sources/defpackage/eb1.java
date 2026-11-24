package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class eb1 {
    public static final eb1 a;
    public static final eb1 b;
    public static final eb1 c;
    public static final eb1 e;
    public static final eb1 f;
    public static final /* synthetic */ eb1[] i;

    static {
        eb1 eb1Var = new eb1("DESTROYED", 0);
        a = eb1Var;
        eb1 eb1Var2 = new eb1("INITIALIZED", 1);
        b = eb1Var2;
        eb1 eb1Var3 = new eb1("CREATED", 2);
        c = eb1Var3;
        eb1 eb1Var4 = new eb1("STARTED", 3);
        e = eb1Var4;
        eb1 eb1Var5 = new eb1("RESUMED", 4);
        f = eb1Var5;
        i = new eb1[]{eb1Var, eb1Var2, eb1Var3, eb1Var4, eb1Var5};
    }

    public static eb1 valueOf(String str) {
        return (eb1) Enum.valueOf(eb1.class, str);
    }

    public static eb1[] values() {
        return (eb1[]) i.clone();
    }
}
