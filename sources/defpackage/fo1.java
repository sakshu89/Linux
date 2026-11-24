package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fo1 {
    public static final fo1 a;
    public static final fo1 b;
    public static final /* synthetic */ fo1[] c;

    static {
        fo1 fo1Var = new fo1("Min", 0);
        a = fo1Var;
        fo1 fo1Var2 = new fo1("Max", 1);
        b = fo1Var2;
        c = new fo1[]{fo1Var, fo1Var2};
    }

    public static fo1 valueOf(String str) {
        return (fo1) Enum.valueOf(fo1.class, str);
    }

    public static fo1[] values() {
        return (fo1[]) c.clone();
    }
}
