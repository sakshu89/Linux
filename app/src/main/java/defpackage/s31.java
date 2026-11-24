package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s31 {
    public static final s31 a;
    public static final s31 b;
    public static final s31 c;
    public static final s31 e;
    public static final /* synthetic */ s31[] f;

    static {
        s31 s31Var = new s31("IGNORED", 0);
        a = s31Var;
        s31 s31Var2 = new s31("SCHEDULED", 1);
        b = s31Var2;
        s31 s31Var3 = new s31("DEFERRED", 2);
        c = s31Var3;
        s31 s31Var4 = new s31("IMMINENT", 3);
        e = s31Var4;
        f = new s31[]{s31Var, s31Var2, s31Var3, s31Var4};
    }

    public static s31 valueOf(String str) {
        return (s31) Enum.valueOf(s31.class, str);
    }

    public static s31[] values() {
        return (s31[]) f.clone();
    }
}
