package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class yy2 {
    public static final yy2 a;
    public static final yy2 b;
    public static final yy2 c;
    public static final yy2 e;
    public static final /* synthetic */ yy2[] f;

    static {
        yy2 yy2Var = new yy2("StartInput", 0);
        a = yy2Var;
        yy2 yy2Var2 = new yy2("StopInput", 1);
        b = yy2Var2;
        yy2 yy2Var3 = new yy2("ShowKeyboard", 2);
        c = yy2Var3;
        yy2 yy2Var4 = new yy2("HideKeyboard", 3);
        e = yy2Var4;
        f = new yy2[]{yy2Var, yy2Var2, yy2Var3, yy2Var4};
    }

    public static yy2 valueOf(String str) {
        return (yy2) Enum.valueOf(yy2.class, str);
    }

    public static yy2[] values() {
        return (yy2[]) f.clone();
    }
}
