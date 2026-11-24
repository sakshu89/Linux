package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l82 {
    public static final l82 a;
    public static final l82 b;
    public static final l82 c;
    public static final l82 e;
    public static final /* synthetic */ l82[] f;
    public static final /* synthetic */ gj0 i;

    static {
        l82 l82Var = new l82("LOW", 0);
        a = l82Var;
        l82 l82Var2 = new l82("MEDIUM", 1);
        b = l82Var2;
        l82 l82Var3 = new l82("HIGH", 2);
        c = l82Var3;
        l82 l82Var4 = new l82("CRITICAL", 3);
        e = l82Var4;
        l82[] l82VarArr = {l82Var, l82Var2, l82Var3, l82Var4};
        f = l82VarArr;
        i = new gj0(l82VarArr);
    }

    public static l82 valueOf(String str) {
        return (l82) Enum.valueOf(l82.class, str);
    }

    public static l82[] values() {
        return (l82[]) f.clone();
    }
}
