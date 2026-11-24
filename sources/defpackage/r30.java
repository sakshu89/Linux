package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r30 {
    public static final r30 a;
    public static final r30 b;
    public static final r30 c;
    public static final /* synthetic */ r30[] e;

    static {
        r30 r30Var = new r30("ALWAYS_OVERRIDE", 0);
        a = r30Var;
        r30 r30Var2 = new r30("HIGH_PRIORITY_REQUIRED", 1);
        r30 r30Var3 = new r30("REQUIRED", 2);
        b = r30Var3;
        r30 r30Var4 = new r30("OPTIONAL", 3);
        c = r30Var4;
        e = new r30[]{r30Var, r30Var2, r30Var3, r30Var4};
    }

    public static r30 valueOf(String str) {
        return (r30) Enum.valueOf(r30.class, str);
    }

    public static r30[] values() {
        return (r30[]) e.clone();
    }
}
