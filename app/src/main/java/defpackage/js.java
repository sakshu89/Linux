package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class js {
    public static final js a;
    public static final js b;
    public static final js c;
    public static final js e;
    public static final js f;
    public static final /* synthetic */ js[] i;

    static {
        js jsVar = new js("UNKNOWN", 0);
        a = jsVar;
        js jsVar2 = new js("INACTIVE", 1);
        b = jsVar2;
        js jsVar3 = new js("METERING", 2);
        c = jsVar3;
        js jsVar4 = new js("CONVERGED", 3);
        e = jsVar4;
        js jsVar5 = new js("LOCKED", 4);
        f = jsVar5;
        i = new js[]{jsVar, jsVar2, jsVar3, jsVar4, jsVar5};
    }

    public static js valueOf(String str) {
        return (js) Enum.valueOf(js.class, str);
    }

    public static js[] values() {
        return (js[]) i.clone();
    }
}
