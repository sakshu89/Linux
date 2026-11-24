package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kk2 {
    public static final kk2 a;
    public static final kk2 b;
    public static final kk2 c;
    public static final /* synthetic */ kk2[] e;

    static {
        kk2 kk2Var = new kk2("START", 0);
        a = kk2Var;
        kk2 kk2Var2 = new kk2("STOP", 1);
        b = kk2Var2;
        kk2 kk2Var3 = new kk2("STOP_AND_RESET_REPLAY_CACHE", 2);
        c = kk2Var3;
        e = new kk2[]{kk2Var, kk2Var2, kk2Var3};
    }

    public static kk2 valueOf(String str) {
        return (kk2) Enum.valueOf(kk2.class, str);
    }

    public static kk2[] values() {
        return (kk2[]) e.clone();
    }
}
