package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d31 {
    public static final d31 a;
    public static final d31 b;
    public static final /* synthetic */ d31[] c;

    static {
        d31 d31Var = new d31("Width", 0);
        a = d31Var;
        d31 d31Var2 = new d31("Height", 1);
        b = d31Var2;
        c = new d31[]{d31Var, d31Var2};
    }

    public static d31 valueOf(String str) {
        return (d31) Enum.valueOf(d31.class, str);
    }

    public static d31[] values() {
        return (d31[]) c.clone();
    }
}
