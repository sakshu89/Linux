package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s23 {
    public static final s23 a;
    public static final s23 b;
    public static final s23 c;
    public static final /* synthetic */ s23[] e;

    static {
        s23 s23Var = new s23("ContinueTraversal", 0);
        a = s23Var;
        s23 s23Var2 = new s23("SkipSubtreeAndContinueTraversal", 1);
        b = s23Var2;
        s23 s23Var3 = new s23("CancelTraversal", 2);
        c = s23Var3;
        e = new s23[]{s23Var, s23Var2, s23Var3};
    }

    public static s23 valueOf(String str) {
        return (s23) Enum.valueOf(s23.class, str);
    }

    public static s23[] values() {
        return (s23[]) e.clone();
    }
}
