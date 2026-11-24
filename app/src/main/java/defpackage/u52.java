package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class u52 {
    public static final u52 a;
    public static final /* synthetic */ u52[] b;

    static {
        u52 u52Var = new u52("Restart", 0);
        a = u52Var;
        b = new u52[]{u52Var, new u52("Reverse", 1)};
    }

    public static u52 valueOf(String str) {
        return (u52) Enum.valueOf(u52.class, str);
    }

    public static u52[] values() {
        return (u52[]) b.clone();
    }
}
