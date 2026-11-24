package defpackage;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'EF2' uses external variables
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
public class jc3 {
    public static final fc3 c;
    public static final gc3 e;
    public static final hc3 f;
    public static final /* synthetic */ jc3[] i;
    public final kc3 a;
    public final int b;

    /* JADX INFO: Fake field, exist only in values array */
    jc3 EF0;

    /* JADX INFO: Fake field, exist only in values array */
    jc3 EF1;

    /* JADX INFO: Fake field, exist only in values array */
    jc3 EF2;

    static {
        jc3 jc3Var = new jc3("DOUBLE", 0, kc3.DOUBLE, 1);
        jc3 jc3Var2 = new jc3("FLOAT", 1, kc3.FLOAT, 5);
        kc3 kc3Var = kc3.LONG;
        jc3 jc3Var3 = new jc3("INT64", 2, kc3Var, 0);
        jc3 jc3Var4 = new jc3("UINT64", 3, kc3Var, 0);
        kc3 kc3Var2 = kc3.INT;
        jc3 jc3Var5 = new jc3("INT32", 4, kc3Var2, 0);
        jc3 jc3Var6 = new jc3("FIXED64", 5, kc3Var, 1);
        jc3 jc3Var7 = new jc3("FIXED32", 6, kc3Var2, 5);
        jc3 jc3Var8 = new jc3("BOOL", 7, kc3.BOOLEAN, 0);
        fc3 fc3Var = new fc3("STRING", 8, kc3.STRING, 2);
        c = fc3Var;
        kc3 kc3Var3 = kc3.MESSAGE;
        gc3 gc3Var = new gc3("GROUP", 9, kc3Var3, 3);
        e = gc3Var;
        hc3 hc3Var = new hc3("MESSAGE", 10, kc3Var3, 2);
        f = hc3Var;
        i = new jc3[]{jc3Var, jc3Var2, jc3Var3, jc3Var4, jc3Var5, jc3Var6, jc3Var7, jc3Var8, fc3Var, gc3Var, hc3Var, new ic3("BYTES", 11, kc3.BYTE_STRING, 2), new jc3("UINT32", 12, kc3Var2, 0), new jc3("ENUM", 13, kc3.ENUM, 0), new jc3("SFIXED32", 14, kc3Var2, 5), new jc3("SFIXED64", 15, kc3Var, 1), new jc3("SINT32", 16, kc3Var2, 0), new jc3("SINT64", 17, kc3Var, 0)};
    }

    public jc3(String str, int i2, kc3 kc3Var, int i3) {
        super(str, i2);
        this.a = kc3Var;
        this.b = i3;
    }

    public static jc3 valueOf(String str) {
        return (jc3) Enum.valueOf(jc3.class, str);
    }

    public static jc3[] values() {
        return (jc3[]) i.clone();
    }
}
