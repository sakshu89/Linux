package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class t53 {
    public static final t53 a;
    public static final t53 b;
    public static final t53 c;
    public static final t53 e;
    public static final t53 f;
    public static final t53 i;
    public static final /* synthetic */ t53[] j;

    static {
        t53 t53Var = new t53("IMAGE_CAPTURE", 0);
        a = t53Var;
        t53 t53Var2 = new t53("PREVIEW", 1);
        b = t53Var2;
        t53 t53Var3 = new t53("IMAGE_ANALYSIS", 2);
        c = t53Var3;
        t53 t53Var4 = new t53("VIDEO_CAPTURE", 3);
        e = t53Var4;
        t53 t53Var5 = new t53("STREAM_SHARING", 4);
        f = t53Var5;
        t53 t53Var6 = new t53("METERING_REPEATING", 5);
        i = t53Var6;
        j = new t53[]{t53Var, t53Var2, t53Var3, t53Var4, t53Var5, t53Var6};
    }

    public static t53 valueOf(String str) {
        return (t53) Enum.valueOf(t53.class, str);
    }

    public static t53[] values() {
        return (t53[]) j.clone();
    }
}
