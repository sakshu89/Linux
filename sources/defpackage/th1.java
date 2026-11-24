package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class th1 {
    public static final th1 a;
    public static final th1 b;
    public static final th1 c;
    public static final th1 e;
    public static final th1 f;
    public static final /* synthetic */ th1[] i;

    static {
        th1 th1Var = new th1("PLAY", 0);
        a = th1Var;
        th1 th1Var2 = new th1("PAUSE", 1);
        b = th1Var2;
        th1 th1Var3 = new th1("STOP", 2);
        c = th1Var3;
        th1 th1Var4 = new th1("NEXT", 3);
        e = th1Var4;
        th1 th1Var5 = new th1("PREVIOUS", 4);
        f = th1Var5;
        i = new th1[]{th1Var, th1Var2, th1Var3, th1Var4, th1Var5};
    }

    public static th1 valueOf(String str) {
        return (th1) Enum.valueOf(th1.class, str);
    }

    public static th1[] values() {
        return (th1[]) i.clone();
    }
}
