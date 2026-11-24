package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class is {
    public static final is a;
    public static final is b;
    public static final is c;
    public static final is e;
    public static final is f;
    public static final is i;
    public static final is j;
    public static final /* synthetic */ is[] k;

    static {
        is isVar = new is("UNKNOWN", 0);
        a = isVar;
        is isVar2 = new is("INACTIVE", 1);
        b = isVar2;
        is isVar3 = new is("SCANNING", 2);
        c = isVar3;
        is isVar4 = new is("PASSIVE_FOCUSED", 3);
        e = isVar4;
        is isVar5 = new is("PASSIVE_NOT_FOCUSED", 4);
        f = isVar5;
        is isVar6 = new is("LOCKED_FOCUSED", 5);
        i = isVar6;
        is isVar7 = new is("LOCKED_NOT_FOCUSED", 6);
        j = isVar7;
        k = new is[]{isVar, isVar2, isVar3, isVar4, isVar5, isVar6, isVar7};
    }

    public static is valueOf(String str) {
        return (is) Enum.valueOf(is.class, str);
    }

    public static is[] values() {
        return (is[]) k.clone();
    }
}
