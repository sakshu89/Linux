package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nd {
    public static final nd a;
    public static final nd b;
    public static final /* synthetic */ nd[] c;

    static {
        nd ndVar = new nd("BoundReached", 0);
        a = ndVar;
        nd ndVar2 = new nd("Finished", 1);
        b = ndVar2;
        c = new nd[]{ndVar, ndVar2};
    }

    public static nd valueOf(String str) {
        return (nd) Enum.valueOf(nd.class, str);
    }

    public static nd[] values() {
        return (nd[]) c.clone();
    }
}
