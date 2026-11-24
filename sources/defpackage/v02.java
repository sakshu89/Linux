package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class v02 {
    public static final v02 a;
    public static final v02 b;
    public static final v02 c;
    public static final /* synthetic */ v02[] e;

    static {
        v02 v02Var = new v02("DEFAULT", 0);
        a = v02Var;
        v02 v02Var2 = new v02("VERY_LOW", 1);
        b = v02Var2;
        v02 v02Var3 = new v02("HIGHEST", 2);
        c = v02Var3;
        e = new v02[]{v02Var, v02Var2, v02Var3};
    }

    public static v02 valueOf(String str) {
        return (v02) Enum.valueOf(v02.class, str);
    }

    public static v02[] values() {
        return (v02[]) e.clone();
    }
}
