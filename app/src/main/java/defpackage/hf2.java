package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hf2 {
    public static final hf2 a;
    public static final /* synthetic */ hf2[] b;

    static {
        hf2 hf2Var = new hf2("EditableText", 0);
        a = hf2Var;
        b = new hf2[]{hf2Var, new hf2("StaticText", 1)};
    }

    public static hf2 valueOf(String str) {
        return (hf2) Enum.valueOf(hf2.class, str);
    }

    public static hf2[] values() {
        return (hf2[]) b.clone();
    }
}
