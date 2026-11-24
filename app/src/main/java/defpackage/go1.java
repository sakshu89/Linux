package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class go1 {
    public static final go1 a;
    public static final go1 b;
    public static final /* synthetic */ go1[] c;

    static {
        go1 go1Var = new go1("Width", 0);
        a = go1Var;
        go1 go1Var2 = new go1("Height", 1);
        b = go1Var2;
        c = new go1[]{go1Var, go1Var2};
    }

    public static go1 valueOf(String str) {
        return (go1) Enum.valueOf(go1.class, str);
    }

    public static go1[] values() {
        return (go1[]) c.clone();
    }
}
