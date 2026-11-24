package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sm1 {
    public static final sm1 a;
    public static final /* synthetic */ sm1[] b;

    static {
        sm1 sm1Var = new sm1("Default", 0);
        a = sm1Var;
        b = new sm1[]{sm1Var, new sm1("UserInput", 1), new sm1("PreventUserInput", 2)};
    }

    public static sm1 valueOf(String str) {
        return (sm1) Enum.valueOf(sm1.class, str);
    }

    public static sm1[] values() {
        return (sm1[]) b.clone();
    }
}
