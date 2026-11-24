package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rh1 {
    public static final rh1 a;
    public static final rh1 b;
    public static final /* synthetic */ rh1[] c;

    static {
        rh1 rh1Var = new rh1("Min", 0);
        a = rh1Var;
        rh1 rh1Var2 = new rh1("Max", 1);
        b = rh1Var2;
        c = new rh1[]{rh1Var, rh1Var2};
    }

    public static rh1 valueOf(String str) {
        return (rh1) Enum.valueOf(rh1.class, str);
    }

    public static rh1[] values() {
        return (rh1[]) c.clone();
    }
}
