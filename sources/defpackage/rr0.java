package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class rr0 {
    public static final rr0 a;
    public static final rr0 b;
    public static final rr0 c;
    public static final /* synthetic */ rr0[] e;

    static {
        rr0 rr0Var = new rr0("UNKNOWN", 0);
        a = rr0Var;
        rr0 rr0Var2 = new rr0("DEFAULT", 1);
        b = rr0Var2;
        rr0 rr0Var3 = new rr0("YUV", 2);
        c = rr0Var3;
        e = new rr0[]{rr0Var, rr0Var2, rr0Var3};
    }

    public static rr0 valueOf(String str) {
        return (rr0) Enum.valueOf(rr0.class, str);
    }

    public static rr0[] values() {
        return (rr0[]) e.clone();
    }
}
