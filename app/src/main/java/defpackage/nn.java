package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class nn {
    public static final nn a;
    public static final nn b;
    public static final nn c;
    public static final /* synthetic */ nn[] e;

    static {
        nn nnVar = new nn("SUSPEND", 0);
        a = nnVar;
        nn nnVar2 = new nn("DROP_OLDEST", 1);
        b = nnVar2;
        nn nnVar3 = new nn("DROP_LATEST", 2);
        c = nnVar3;
        e = new nn[]{nnVar, nnVar2, nnVar3};
    }

    public static nn valueOf(String str) {
        return (nn) Enum.valueOf(nn.class, str);
    }

    public static nn[] values() {
        return (nn[]) e.clone();
    }
}
