package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ad1 {
    public static final ad1 a;
    public static final ad1 b;
    public static final /* synthetic */ ad1[] c;

    static {
        ad1 ad1Var = new ad1("PHONE_CALL", 0);
        a = ad1Var;
        ad1 ad1Var2 = new ad1("EXTERNAL_AUDIO", 1);
        b = ad1Var2;
        c = new ad1[]{ad1Var, ad1Var2};
    }

    public static ad1 valueOf(String str) {
        return (ad1) Enum.valueOf(ad1.class, str);
    }

    public static ad1[] values() {
        return (ad1[]) c.clone();
    }
}
