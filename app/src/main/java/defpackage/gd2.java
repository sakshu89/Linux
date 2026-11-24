package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gd2 {
    public static final gd2 a;
    public static final gd2 b;
    public static final /* synthetic */ gd2[] c;

    static {
        gd2 gd2Var = new gd2("UP", 0);
        a = gd2Var;
        gd2 gd2Var2 = new gd2("DOWN", 1);
        b = gd2Var2;
        c = new gd2[]{gd2Var, gd2Var2};
    }

    public static gd2 valueOf(String str) {
        return (gd2) Enum.valueOf(gd2.class, str);
    }

    public static gd2[] values() {
        return (gd2[]) c.clone();
    }
}
