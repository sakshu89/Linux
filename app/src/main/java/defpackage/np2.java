package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class np2 {
    public static final np2 a;
    public static final np2 b;
    public static final np2 c;
    public static final np2 e;
    public static final np2 f;
    public static final /* synthetic */ np2[] i;

    static {
        np2 np2Var = new np2("WRITE_SETTINGS", 0);
        a = np2Var;
        np2 np2Var2 = new np2("NOTIFICATION_ACCESS", 1);
        b = np2Var2;
        np2 np2Var3 = new np2("ACCESSIBILITY", 2);
        c = np2Var3;
        np2 np2Var4 = new np2("DND_POLICY", 3);
        e = np2Var4;
        np2 np2Var5 = new np2("EXACT_ALARMS", 4);
        np2 np2Var6 = new np2("OVERLAY", 5);
        f = np2Var6;
        i = new np2[]{np2Var, np2Var2, np2Var3, np2Var4, np2Var5, np2Var6};
    }

    public static np2 valueOf(String str) {
        return (np2) Enum.valueOf(np2.class, str);
    }

    public static np2[] values() {
        return (np2[]) i.clone();
    }
}
