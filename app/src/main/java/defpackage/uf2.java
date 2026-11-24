package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uf2 {
    public static final uf2 a;
    public static final uf2 b;
    public static final uf2 c;
    public static final /* synthetic */ uf2[] e;

    static {
        uf2 uf2Var = new uf2("Left", 0);
        a = uf2Var;
        uf2 uf2Var2 = new uf2("Middle", 1);
        b = uf2Var2;
        uf2 uf2Var3 = new uf2("Right", 2);
        c = uf2Var3;
        e = new uf2[]{uf2Var, uf2Var2, uf2Var3};
    }

    public static uf2 valueOf(String str) {
        return (uf2) Enum.valueOf(uf2.class, str);
    }

    public static uf2[] values() {
        return (uf2[]) e.clone();
    }
}
