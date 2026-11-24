package defpackage;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF0' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class sv3 {
    public static final sv3 c;
    public static final sv3 e;
    public static final sv3 f;
    public static final sv3 i;
    public static final /* synthetic */ sv3[] j;
    public final tv3 a;
    public final int b;

    /* JADX INFO: Fake field, exist only in values array */
    sv3 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    sv3 EF2;

    /* JADX INFO: Fake field, exist only in values array */
    sv3 EF0;

    static {
        sv3 sv3Var = new sv3("DOUBLE", 0, tv3.e, 1);
        sv3 sv3Var2 = new sv3("FLOAT", 1, tv3.c, 5);
        tv3 tv3Var = tv3.b;
        sv3 sv3Var3 = new sv3("INT64", 2, tv3Var, 0);
        sv3 sv3Var4 = new sv3("UINT64", 3, tv3Var, 0);
        tv3 tv3Var2 = tv3.a;
        sv3 sv3Var5 = new sv3("INT32", 4, tv3Var2, 0);
        c = sv3Var5;
        sv3 sv3Var6 = new sv3("FIXED64", 5, tv3Var, 1);
        sv3 sv3Var7 = new sv3("FIXED32", 6, tv3Var2, 5);
        sv3 sv3Var8 = new sv3("BOOL", 7, tv3.f, 0);
        sv3 sv3Var9 = new sv3("STRING", 8, tv3.i, 2);
        e = sv3Var9;
        tv3 tv3Var3 = tv3.n;
        sv3 sv3Var10 = new sv3("GROUP", 9, tv3Var3, 3);
        f = sv3Var10;
        sv3 sv3Var11 = new sv3("MESSAGE", 10, tv3Var3, 2);
        i = sv3Var11;
        j = new sv3[]{sv3Var, sv3Var2, sv3Var3, sv3Var4, sv3Var5, sv3Var6, sv3Var7, sv3Var8, sv3Var9, sv3Var10, sv3Var11, new sv3("BYTES", 11, tv3.j, 2), new sv3("UINT32", 12, tv3Var2, 0), new sv3("ENUM", 13, tv3.k, 0), new sv3("SFIXED32", 14, tv3Var2, 5), new sv3("SFIXED64", 15, tv3Var, 1), new sv3("SINT32", 16, tv3Var2, 0), new sv3("SINT64", 17, tv3Var, 0)};
    }

    public sv3(String str, int i2, tv3 tv3Var, int i3) {
        super(str, i2);
        this.a = tv3Var;
        this.b = i3;
    }

    public static sv3[] values() {
        return (sv3[]) j.clone();
    }
}
