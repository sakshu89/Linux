package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class hs {
    public static final hs a;
    public static final hs b;
    public static final hs c;
    public static final hs e;
    public static final hs f;
    public static final hs i;
    public static final /* synthetic */ hs[] j;

    static {
        hs hsVar = new hs("UNKNOWN", 0);
        a = hsVar;
        hs hsVar2 = new hs("INACTIVE", 1);
        b = hsVar2;
        hs hsVar3 = new hs("SEARCHING", 2);
        c = hsVar3;
        hs hsVar4 = new hs("FLASH_REQUIRED", 3);
        e = hsVar4;
        hs hsVar5 = new hs("CONVERGED", 4);
        f = hsVar5;
        hs hsVar6 = new hs("LOCKED", 5);
        i = hsVar6;
        j = new hs[]{hsVar, hsVar2, hsVar3, hsVar4, hsVar5, hsVar6};
    }

    public static hs valueOf(String str) {
        return (hs) Enum.valueOf(hs.class, str);
    }

    public static hs[] values() {
        return (hs[]) j.clone();
    }
}
