package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class r14 {
    public static final r14 a;
    public static final /* synthetic */ r14[] b;

    static {
        r14 r14Var = new r14("DEFAULT", 0);
        a = r14Var;
        b = new r14[]{r14Var, new r14("SIGNED", 1), new r14("FIXED", 2)};
    }

    public static r14[] values() {
        return (r14[]) b.clone();
    }
}
