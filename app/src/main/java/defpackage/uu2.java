package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uu2 {
    public static final uu2 a;
    public static final uu2 b;
    public static final uu2 c;
    public static final uu2 e;
    public static final /* synthetic */ uu2[] f;

    static {
        uu2 uu2Var = new uu2("UP", 0);
        a = uu2Var;
        uu2 uu2Var2 = new uu2("DOWN", 1);
        b = uu2Var2;
        uu2 uu2Var3 = new uu2("LEFT", 2);
        c = uu2Var3;
        uu2 uu2Var4 = new uu2("RIGHT", 3);
        e = uu2Var4;
        f = new uu2[]{uu2Var, uu2Var2, uu2Var3, uu2Var4};
    }

    public static uu2 valueOf(String str) {
        return (uu2) Enum.valueOf(uu2.class, str);
    }

    public static uu2[] values() {
        return (uu2[]) f.clone();
    }
}
