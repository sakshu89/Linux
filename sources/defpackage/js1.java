package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class js1 {
    public static final js1 a;
    public static final js1 b;
    public static final /* synthetic */ js1[] c;

    static {
        js1 js1Var = new js1("Vertical", 0);
        a = js1Var;
        js1 js1Var2 = new js1("Horizontal", 1);
        b = js1Var2;
        c = new js1[]{js1Var, js1Var2};
    }

    public static js1 valueOf(String str) {
        return (js1) Enum.valueOf(js1.class, str);
    }

    public static js1[] values() {
        return (js1[]) c.clone();
    }
}
