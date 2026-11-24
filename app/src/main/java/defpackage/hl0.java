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
public final class hl0 {
    public static final hl0 b;
    public static final hl0 c;
    public static final hl0[] e;
    public static final /* synthetic */ hl0[] f;
    public final int a;

    /* JADX INFO: Fake field, exist only in values array */
    hl0 EF0;

    static {
        b41 b41Var = b41.DOUBLE;
        hl0 hl0Var = new hl0("DOUBLE", 0, 0, 1, b41Var);
        b41 b41Var2 = b41.FLOAT;
        hl0 hl0Var2 = new hl0("FLOAT", 1, 1, 1, b41Var2);
        b41 b41Var3 = b41.LONG;
        hl0 hl0Var3 = new hl0("INT64", 2, 2, 1, b41Var3);
        hl0 hl0Var4 = new hl0("UINT64", 3, 3, 1, b41Var3);
        b41 b41Var4 = b41.INT;
        hl0 hl0Var5 = new hl0("INT32", 4, 4, 1, b41Var4);
        hl0 hl0Var6 = new hl0("FIXED64", 5, 5, 1, b41Var3);
        hl0 hl0Var7 = new hl0("FIXED32", 6, 6, 1, b41Var4);
        b41 b41Var5 = b41.BOOLEAN;
        hl0 hl0Var8 = new hl0("BOOL", 7, 7, 1, b41Var5);
        b41 b41Var6 = b41.STRING;
        hl0 hl0Var9 = new hl0("STRING", 8, 8, 1, b41Var6);
        b41 b41Var7 = b41.MESSAGE;
        hl0 hl0Var10 = new hl0("MESSAGE", 9, 9, 1, b41Var7);
        b41 b41Var8 = b41.BYTE_STRING;
        hl0 hl0Var11 = new hl0("BYTES", 10, 10, 1, b41Var8);
        hl0 hl0Var12 = new hl0("UINT32", 11, 11, 1, b41Var4);
        b41 b41Var9 = b41.ENUM;
        hl0 hl0Var13 = new hl0("ENUM", 12, 12, 1, b41Var9);
        hl0 hl0Var14 = new hl0("SFIXED32", 13, 13, 1, b41Var4);
        hl0 hl0Var15 = new hl0("SFIXED64", 14, 14, 1, b41Var3);
        hl0 hl0Var16 = new hl0("SINT32", 15, 15, 1, b41Var4);
        hl0 hl0Var17 = new hl0("SINT64", 16, 16, 1, b41Var3);
        hl0 hl0Var18 = new hl0("GROUP", 17, 17, 1, b41Var7);
        hl0 hl0Var19 = new hl0("DOUBLE_LIST", 18, 18, 2, b41Var);
        hl0 hl0Var20 = new hl0("FLOAT_LIST", 19, 19, 2, b41Var2);
        hl0 hl0Var21 = new hl0("INT64_LIST", 20, 20, 2, b41Var3);
        hl0 hl0Var22 = new hl0("UINT64_LIST", 21, 21, 2, b41Var3);
        hl0 hl0Var23 = new hl0("INT32_LIST", 22, 22, 2, b41Var4);
        hl0 hl0Var24 = new hl0("FIXED64_LIST", 23, 23, 2, b41Var3);
        hl0 hl0Var25 = new hl0("FIXED32_LIST", 24, 24, 2, b41Var4);
        hl0 hl0Var26 = new hl0("BOOL_LIST", 25, 25, 2, b41Var5);
        hl0 hl0Var27 = new hl0("STRING_LIST", 26, 26, 2, b41Var6);
        hl0 hl0Var28 = new hl0("MESSAGE_LIST", 27, 27, 2, b41Var7);
        hl0 hl0Var29 = new hl0("BYTES_LIST", 28, 28, 2, b41Var8);
        hl0 hl0Var30 = new hl0("UINT32_LIST", 29, 29, 2, b41Var4);
        hl0 hl0Var31 = new hl0("ENUM_LIST", 30, 30, 2, b41Var9);
        hl0 hl0Var32 = new hl0("SFIXED32_LIST", 31, 31, 2, b41Var4);
        hl0 hl0Var33 = new hl0("SFIXED64_LIST", 32, 32, 2, b41Var3);
        hl0 hl0Var34 = new hl0("SINT32_LIST", 33, 33, 2, b41Var4);
        hl0 hl0Var35 = new hl0("SINT64_LIST", 34, 34, 2, b41Var3);
        hl0 hl0Var36 = new hl0("DOUBLE_LIST_PACKED", 35, 35, 3, b41Var);
        b = hl0Var36;
        hl0 hl0Var37 = new hl0("FLOAT_LIST_PACKED", 36, 36, 3, b41Var2);
        hl0 hl0Var38 = new hl0("INT64_LIST_PACKED", 37, 37, 3, b41Var3);
        hl0 hl0Var39 = new hl0("UINT64_LIST_PACKED", 38, 38, 3, b41Var3);
        hl0 hl0Var40 = new hl0("INT32_LIST_PACKED", 39, 39, 3, b41Var4);
        hl0 hl0Var41 = new hl0("FIXED64_LIST_PACKED", 40, 40, 3, b41Var3);
        hl0 hl0Var42 = new hl0("FIXED32_LIST_PACKED", 41, 41, 3, b41Var4);
        hl0 hl0Var43 = new hl0("BOOL_LIST_PACKED", 42, 42, 3, b41Var5);
        hl0 hl0Var44 = new hl0("UINT32_LIST_PACKED", 43, 43, 3, b41Var4);
        hl0 hl0Var45 = new hl0("ENUM_LIST_PACKED", 44, 44, 3, b41Var9);
        hl0 hl0Var46 = new hl0("SFIXED32_LIST_PACKED", 45, 45, 3, b41Var4);
        hl0 hl0Var47 = new hl0("SFIXED64_LIST_PACKED", 46, 46, 3, b41Var3);
        hl0 hl0Var48 = new hl0("SINT32_LIST_PACKED", 47, 47, 3, b41Var4);
        hl0 hl0Var49 = new hl0("SINT64_LIST_PACKED", 48, 48, 3, b41Var3);
        c = hl0Var49;
        f = new hl0[]{hl0Var, hl0Var2, hl0Var3, hl0Var4, hl0Var5, hl0Var6, hl0Var7, hl0Var8, hl0Var9, hl0Var10, hl0Var11, hl0Var12, hl0Var13, hl0Var14, hl0Var15, hl0Var16, hl0Var17, hl0Var18, hl0Var19, hl0Var20, hl0Var21, hl0Var22, hl0Var23, hl0Var24, hl0Var25, hl0Var26, hl0Var27, hl0Var28, hl0Var29, hl0Var30, hl0Var31, hl0Var32, hl0Var33, hl0Var34, hl0Var35, hl0Var36, hl0Var37, hl0Var38, hl0Var39, hl0Var40, hl0Var41, hl0Var42, hl0Var43, hl0Var44, hl0Var45, hl0Var46, hl0Var47, hl0Var48, hl0Var49, new hl0("GROUP_LIST", 49, 49, 2, b41Var7), new hl0("MAP", 50, 50, 4, b41.VOID)};
        hl0[] hl0VarArrValues = values();
        e = new hl0[hl0VarArrValues.length];
        for (hl0 hl0Var50 : hl0VarArrValues) {
            e[hl0Var50.a] = hl0Var50;
        }
    }

    public hl0(String str, int i, int i2, int i3, b41 b41Var) {
        super(str, i);
        this.a = i2;
        int iX = cq.x(i3);
        if (iX == 1 || iX == 3) {
            b41Var.getClass();
        }
        if (i3 == 1) {
            b41Var.ordinal();
        }
    }

    public static hl0 valueOf(String str) {
        return (hl0) Enum.valueOf(hl0.class, str);
    }

    public static hl0[] values() {
        return (hl0[]) f.clone();
    }
}
