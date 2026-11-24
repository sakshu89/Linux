package defpackage;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class db1 {
    private static final /* synthetic */ fj0 $ENTRIES;
    private static final /* synthetic */ db1[] $VALUES;
    public static final bb1 Companion;
    public static final db1 ON_ANY;
    public static final db1 ON_CREATE;
    public static final db1 ON_DESTROY;
    public static final db1 ON_PAUSE;
    public static final db1 ON_RESUME;
    public static final db1 ON_START;
    public static final db1 ON_STOP;

    static {
        db1 db1Var = new db1("ON_CREATE", 0);
        ON_CREATE = db1Var;
        db1 db1Var2 = new db1("ON_START", 1);
        ON_START = db1Var2;
        db1 db1Var3 = new db1("ON_RESUME", 2);
        ON_RESUME = db1Var3;
        db1 db1Var4 = new db1("ON_PAUSE", 3);
        ON_PAUSE = db1Var4;
        db1 db1Var5 = new db1("ON_STOP", 4);
        ON_STOP = db1Var5;
        db1 db1Var6 = new db1("ON_DESTROY", 5);
        ON_DESTROY = db1Var6;
        db1 db1Var7 = new db1("ON_ANY", 6);
        ON_ANY = db1Var7;
        db1[] db1VarArr = {db1Var, db1Var2, db1Var3, db1Var4, db1Var5, db1Var6, db1Var7};
        $VALUES = db1VarArr;
        $ENTRIES = new gj0(db1VarArr);
        Companion = new bb1();
    }

    public static db1 valueOf(String str) {
        return (db1) Enum.valueOf(db1.class, str);
    }

    public static db1[] values() {
        return (db1[]) $VALUES.clone();
    }

    public final eb1 a() {
        switch (cb1.a[ordinal()]) {
            case 1:
            case 2:
                return eb1.c;
            case 3:
            case 4:
                return eb1.e;
            case 5:
                return eb1.f;
            case 6:
                return eb1.a;
            case 7:
                throw new IllegalArgumentException(this + " has no target state");
            default:
                dk0.l();
                return null;
        }
    }
}
