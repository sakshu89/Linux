package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pv0 {
    public static final pv0 a;
    public static final pv0 b;
    public static final pv0 c;
    public static final /* synthetic */ pv0[] e;

    static {
        pv0 pv0Var = new pv0("Cursor", 0);
        a = pv0Var;
        pv0 pv0Var2 = new pv0("SelectionStart", 1);
        b = pv0Var2;
        pv0 pv0Var3 = new pv0("SelectionEnd", 2);
        c = pv0Var3;
        e = new pv0[]{pv0Var, pv0Var2, pv0Var3};
    }

    public static pv0 valueOf(String str) {
        return (pv0) Enum.valueOf(pv0.class, str);
    }

    public static pv0[] values() {
        return (pv0[]) e.clone();
    }
}
