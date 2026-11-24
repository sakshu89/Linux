package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class jo0 {
    public static final jo0 a;
    public static final jo0 b;
    public static final jo0 c;
    public static final /* synthetic */ jo0[] e;

    static {
        jo0 jo0Var = new jo0("Active", 0);
        a = jo0Var;
        jo0 jo0Var2 = new jo0("ActiveParent", 1);
        b = jo0Var2;
        jo0 jo0Var3 = new jo0("Captured", 2);
        jo0 jo0Var4 = new jo0("Inactive", 3);
        c = jo0Var4;
        e = new jo0[]{jo0Var, jo0Var2, jo0Var3, jo0Var4};
    }

    public static jo0 valueOf(String str) {
        return (jo0) Enum.valueOf(jo0.class, str);
    }

    public static jo0[] values() {
        return (jo0[]) e.clone();
    }

    public final boolean a() {
        int iOrdinal = ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return false;
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return false;
                }
                dk0.l();
                return false;
            }
        }
        return true;
    }
}
