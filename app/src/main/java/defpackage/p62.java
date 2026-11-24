package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class p62 {
    public static final p62 a;
    public static final p62 b;
    public static final /* synthetic */ p62[] c;

    static {
        p62 p62Var = new p62("Ltr", 0);
        a = p62Var;
        p62 p62Var2 = new p62("Rtl", 1);
        b = p62Var2;
        c = new p62[]{p62Var, p62Var2};
    }

    public static p62 valueOf(String str) {
        return (p62) Enum.valueOf(p62.class, str);
    }

    public static p62[] values() {
        return (p62[]) c.clone();
    }
}
