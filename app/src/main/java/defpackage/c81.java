package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class c81 {
    public static final c81 a;
    public static final /* synthetic */ c81[] b;

    static {
        c81 c81Var = new c81("Horizontal", 0);
        a = c81Var;
        b = new c81[]{c81Var, new c81("Vertical", 1)};
    }

    public static c81 valueOf(String str) {
        return (c81) Enum.valueOf(c81.class, str);
    }

    public static c81[] values() {
        return (c81[]) b.clone();
    }
}
