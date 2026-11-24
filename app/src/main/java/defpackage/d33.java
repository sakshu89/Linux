package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class d33 {
    public static final d33 a;
    public static final d33 b;
    public static final d33 c;
    public static final d33 e;
    public static final /* synthetic */ d33[] f;

    static {
        d33 d33Var = new d33("SUCCESSFUL", 0);
        a = d33Var;
        d33 d33Var2 = new d33("REREGISTER", 1);
        b = d33Var2;
        d33 d33Var3 = new d33("CANCELLED", 2);
        c = d33Var3;
        d33 d33Var4 = new d33("ALREADY_SELECTED", 3);
        e = d33Var4;
        f = new d33[]{d33Var, d33Var2, d33Var3, d33Var4};
    }

    public static d33 valueOf(String str) {
        return (d33) Enum.valueOf(d33.class, str);
    }

    public static d33[] values() {
        return (d33[]) f.clone();
    }
}
