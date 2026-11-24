package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class m80 {
    public static final m80 a;
    public static final m80 b;
    public static final m80 c;
    public static final /* synthetic */ m80[] e;

    static {
        m80 m80Var = new m80("None", 0);
        a = m80Var;
        m80 m80Var2 = new m80("Cancelled", 1);
        b = m80Var2;
        m80 m80Var3 = new m80("Redirected", 2);
        c = m80Var3;
        e = new m80[]{m80Var, m80Var2, m80Var3, new m80("RedirectCancelled", 3)};
    }

    public static m80 valueOf(String str) {
        return (m80) Enum.valueOf(m80.class, str);
    }

    public static m80[] values() {
        return (m80[]) e.clone();
    }
}
