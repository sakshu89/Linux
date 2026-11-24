package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class px3 {
    public static final px3 a;
    public static final /* synthetic */ px3[] b;

    static {
        px3 px3Var = new px3("DEFAULT", 0);
        a = px3Var;
        b = new px3[]{px3Var, new px3("SIGNED", 1), new px3("FIXED", 2)};
    }

    public static px3[] values() {
        return (px3[]) b.clone();
    }
}
