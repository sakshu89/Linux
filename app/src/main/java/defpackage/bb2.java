package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bb2 {
    public static final bb2 a;
    public static final bb2 b;
    public static final bb2 c;
    public static final /* synthetic */ bb2[] e;

    static {
        bb2 bb2Var = new bb2("NETWORK_UNMETERED", 0);
        a = bb2Var;
        bb2 bb2Var2 = new bb2("DEVICE_IDLE", 1);
        b = bb2Var2;
        bb2 bb2Var3 = new bb2("DEVICE_CHARGING", 2);
        c = bb2Var3;
        e = new bb2[]{bb2Var, bb2Var2, bb2Var3};
    }

    public static bb2 valueOf(String str) {
        return (bb2) Enum.valueOf(bb2.class, str);
    }

    public static bb2[] values() {
        return (bb2[]) e.clone();
    }
}
