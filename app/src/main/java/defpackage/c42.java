package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class c42 {
    public static final c42 a;
    public static final c42 b;
    public static final c42 c;
    public static final c42 e;
    public static final c42 f;
    public static final c42 i;
    public static final /* synthetic */ c42[] j;

    static {
        c42 c42Var = new c42("ShutDown", 0);
        a = c42Var;
        c42 c42Var2 = new c42("ShuttingDown", 1);
        b = c42Var2;
        c42 c42Var3 = new c42("Inactive", 2);
        c = c42Var3;
        c42 c42Var4 = new c42("InactivePendingWork", 3);
        e = c42Var4;
        c42 c42Var5 = new c42("Idle", 4);
        f = c42Var5;
        c42 c42Var6 = new c42("PendingWork", 5);
        i = c42Var6;
        j = new c42[]{c42Var, c42Var2, c42Var3, c42Var4, c42Var5, c42Var6};
    }

    public static c42 valueOf(String str) {
        return (c42) Enum.valueOf(c42.class, str);
    }

    public static c42[] values() {
        return (c42[]) j.clone();
    }
}
