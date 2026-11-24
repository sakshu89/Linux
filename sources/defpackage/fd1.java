package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fd1 {
    public static final fd1 a;
    public static final fd1 b;
    public static final fd1 c;
    public static final /* synthetic */ fd1[] e;

    static {
        fd1 fd1Var = new fd1("NONE", 0);
        a = fd1Var;
        fd1 fd1Var2 = new fd1("STOP_OUTPUT", 1);
        b = fd1Var2;
        fd1 fd1Var3 = new fd1("SHUT_DOWN", 2);
        c = fd1Var3;
        e = new fd1[]{fd1Var, fd1Var2, fd1Var3};
    }

    public static fd1 valueOf(String str) {
        return (fd1) Enum.valueOf(fd1.class, str);
    }

    public static fd1[] values() {
        return (fd1[]) e.clone();
    }
}
