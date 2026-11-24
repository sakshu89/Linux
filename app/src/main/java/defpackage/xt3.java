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
public final class xt3 {
    public static final xt3 b;
    public static final xt3 c;
    public static final xt3[] e;
    public static final /* synthetic */ xt3[] f;
    public final int a;

    /* JADX INFO: Fake field, exist only in values array */
    xt3 EF0;

    static {
        qu3 qu3Var = qu3.f;
        xt3 xt3Var = new xt3("DOUBLE", 0, 0, 1, qu3Var);
        qu3 qu3Var2 = qu3.e;
        xt3 xt3Var2 = new xt3("FLOAT", 1, 1, 1, qu3Var2);
        qu3 qu3Var3 = qu3.c;
        xt3 xt3Var3 = new xt3("INT64", 2, 2, 1, qu3Var3);
        xt3 xt3Var4 = new xt3("UINT64", 3, 3, 1, qu3Var3);
        qu3 qu3Var4 = qu3.b;
        xt3 xt3Var5 = new xt3("INT32", 4, 4, 1, qu3Var4);
        xt3 xt3Var6 = new xt3("FIXED64", 5, 5, 1, qu3Var3);
        xt3 xt3Var7 = new xt3("FIXED32", 6, 6, 1, qu3Var4);
        qu3 qu3Var5 = qu3.i;
        xt3 xt3Var8 = new xt3("BOOL", 7, 7, 1, qu3Var5);
        qu3 qu3Var6 = qu3.j;
        xt3 xt3Var9 = new xt3("STRING", 8, 8, 1, qu3Var6);
        qu3 qu3Var7 = qu3.s;
        xt3 xt3Var10 = new xt3("MESSAGE", 9, 9, 1, qu3Var7);
        qu3 qu3Var8 = qu3.k;
        xt3 xt3Var11 = new xt3("BYTES", 10, 10, 1, qu3Var8);
        xt3 xt3Var12 = new xt3("UINT32", 11, 11, 1, qu3Var4);
        qu3 qu3Var9 = qu3.n;
        xt3 xt3Var13 = new xt3("ENUM", 12, 12, 1, qu3Var9);
        xt3 xt3Var14 = new xt3("SFIXED32", 13, 13, 1, qu3Var4);
        xt3 xt3Var15 = new xt3("SFIXED64", 14, 14, 1, qu3Var3);
        xt3 xt3Var16 = new xt3("SINT32", 15, 15, 1, qu3Var4);
        xt3 xt3Var17 = new xt3("SINT64", 16, 16, 1, qu3Var3);
        xt3 xt3Var18 = new xt3("GROUP", 17, 17, 1, qu3Var7);
        xt3 xt3Var19 = new xt3("DOUBLE_LIST", 18, 18, 2, qu3Var);
        xt3 xt3Var20 = new xt3("FLOAT_LIST", 19, 19, 2, qu3Var2);
        xt3 xt3Var21 = new xt3("INT64_LIST", 20, 20, 2, qu3Var3);
        xt3 xt3Var22 = new xt3("UINT64_LIST", 21, 21, 2, qu3Var3);
        xt3 xt3Var23 = new xt3("INT32_LIST", 22, 22, 2, qu3Var4);
        xt3 xt3Var24 = new xt3("FIXED64_LIST", 23, 23, 2, qu3Var3);
        xt3 xt3Var25 = new xt3("FIXED32_LIST", 24, 24, 2, qu3Var4);
        xt3 xt3Var26 = new xt3("BOOL_LIST", 25, 25, 2, qu3Var5);
        xt3 xt3Var27 = new xt3("STRING_LIST", 26, 26, 2, qu3Var6);
        xt3 xt3Var28 = new xt3("MESSAGE_LIST", 27, 27, 2, qu3Var7);
        xt3 xt3Var29 = new xt3("BYTES_LIST", 28, 28, 2, qu3Var8);
        xt3 xt3Var30 = new xt3("UINT32_LIST", 29, 29, 2, qu3Var4);
        xt3 xt3Var31 = new xt3("ENUM_LIST", 30, 30, 2, qu3Var9);
        xt3 xt3Var32 = new xt3("SFIXED32_LIST", 31, 31, 2, qu3Var4);
        xt3 xt3Var33 = new xt3("SFIXED64_LIST", 32, 32, 2, qu3Var3);
        xt3 xt3Var34 = new xt3("SINT32_LIST", 33, 33, 2, qu3Var4);
        xt3 xt3Var35 = new xt3("SINT64_LIST", 34, 34, 2, qu3Var3);
        xt3 xt3Var36 = new xt3("DOUBLE_LIST_PACKED", 35, 35, 3, qu3Var);
        b = xt3Var36;
        xt3 xt3Var37 = new xt3("FLOAT_LIST_PACKED", 36, 36, 3, qu3Var2);
        xt3 xt3Var38 = new xt3("INT64_LIST_PACKED", 37, 37, 3, qu3Var3);
        xt3 xt3Var39 = new xt3("UINT64_LIST_PACKED", 38, 38, 3, qu3Var3);
        xt3 xt3Var40 = new xt3("INT32_LIST_PACKED", 39, 39, 3, qu3Var4);
        xt3 xt3Var41 = new xt3("FIXED64_LIST_PACKED", 40, 40, 3, qu3Var3);
        xt3 xt3Var42 = new xt3("FIXED32_LIST_PACKED", 41, 41, 3, qu3Var4);
        xt3 xt3Var43 = new xt3("BOOL_LIST_PACKED", 42, 42, 3, qu3Var5);
        xt3 xt3Var44 = new xt3("UINT32_LIST_PACKED", 43, 43, 3, qu3Var4);
        xt3 xt3Var45 = new xt3("ENUM_LIST_PACKED", 44, 44, 3, qu3Var9);
        xt3 xt3Var46 = new xt3("SFIXED32_LIST_PACKED", 45, 45, 3, qu3Var4);
        xt3 xt3Var47 = new xt3("SFIXED64_LIST_PACKED", 46, 46, 3, qu3Var3);
        xt3 xt3Var48 = new xt3("SINT32_LIST_PACKED", 47, 47, 3, qu3Var4);
        xt3 xt3Var49 = new xt3("SINT64_LIST_PACKED", 48, 48, 3, qu3Var3);
        c = xt3Var49;
        f = new xt3[]{xt3Var, xt3Var2, xt3Var3, xt3Var4, xt3Var5, xt3Var6, xt3Var7, xt3Var8, xt3Var9, xt3Var10, xt3Var11, xt3Var12, xt3Var13, xt3Var14, xt3Var15, xt3Var16, xt3Var17, xt3Var18, xt3Var19, xt3Var20, xt3Var21, xt3Var22, xt3Var23, xt3Var24, xt3Var25, xt3Var26, xt3Var27, xt3Var28, xt3Var29, xt3Var30, xt3Var31, xt3Var32, xt3Var33, xt3Var34, xt3Var35, xt3Var36, xt3Var37, xt3Var38, xt3Var39, xt3Var40, xt3Var41, xt3Var42, xt3Var43, xt3Var44, xt3Var45, xt3Var46, xt3Var47, xt3Var48, xt3Var49, new xt3("GROUP_LIST", 49, 49, 2, qu3Var7), new xt3("MAP", 50, 50, 4, qu3.a)};
        xt3[] xt3VarArrValues = values();
        e = new xt3[xt3VarArrValues.length];
        for (xt3 xt3Var50 : xt3VarArrValues) {
            e[xt3Var50.a] = xt3Var50;
        }
    }

    public xt3(String str, int i, int i2, int i3, qu3 qu3Var) {
        super(str, i);
        this.a = i2;
        int i4 = i3 - 1;
        if (i4 == 1 || i4 == 3) {
            qu3Var.getClass();
        }
        if (i3 == 1) {
            qu3 qu3Var2 = qu3.a;
            qu3Var.ordinal();
        }
    }

    public static xt3[] values() {
        return (xt3[]) f.clone();
    }
}
