package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class me0 {
    public static final me0 a;
    public static final me0 b;
    public static final me0 c;
    public static final /* synthetic */ me0[] e;

    static {
        me0 me0Var = new me0("Yes", 0);
        a = me0Var;
        me0 me0Var2 = new me0("No", 1);
        b = me0Var2;
        me0 me0Var3 = new me0("NotInitialized", 2);
        c = me0Var3;
        e = new me0[]{me0Var, me0Var2, me0Var3};
    }

    public static me0 valueOf(String str) {
        return (me0) Enum.valueOf(me0.class, str);
    }

    public static me0[] values() {
        return (me0[]) e.clone();
    }
}
