package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zg {
    public static final zg a;
    public static final zg b;
    public static final zg c;
    public static final /* synthetic */ zg[] e;

    static {
        zg zgVar = new zg("DIRECT", 0);
        a = zgVar;
        zg zgVar2 = new zg("SETTINGS_FALLBACK", 1);
        b = zgVar2;
        zg zgVar3 = new zg("UNAVAILABLE", 2);
        c = zgVar3;
        e = new zg[]{zgVar, zgVar2, zgVar3};
    }

    public static zg valueOf(String str) {
        return (zg) Enum.valueOf(zg.class, str);
    }

    public static zg[] values() {
        return (zg[]) e.clone();
    }
}
