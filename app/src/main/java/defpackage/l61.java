package defpackage;

import java.util.Locale;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'e' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:160)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class l61 {
    public static final xy c;
    public static final l61 e;
    public static final l61 f;
    public static final l61 i;
    public static final /* synthetic */ l61[] j;
    public static final /* synthetic */ gj0 k;
    public final String a;
    public final Locale b;

    static {
        Locale locale = Locale.ENGLISH;
        locale.getClass();
        l61 l61Var = new l61("ENGLISH", 0, "English", locale);
        e = l61Var;
        Locale localeForLanguageTag = Locale.forLanguageTag("hi-IN");
        localeForLanguageTag.getClass();
        l61 l61Var2 = new l61("HINDI", 1, "हिन्दी", localeForLanguageTag);
        f = l61Var2;
        Locale localeForLanguageTag2 = Locale.forLanguageTag("mr-IN");
        localeForLanguageTag2.getClass();
        l61 l61Var3 = new l61("MARATHI", 2, "मराठी", localeForLanguageTag2);
        Locale localeForLanguageTag3 = Locale.forLanguageTag("ur-IN");
        localeForLanguageTag3.getClass();
        l61 l61Var4 = new l61("URDU", 3, "اردو", localeForLanguageTag3);
        Locale localeForLanguageTag4 = Locale.forLanguageTag("gu-IN");
        localeForLanguageTag4.getClass();
        l61 l61Var5 = new l61("GUJARATI", 4, "ગુજરાતી", localeForLanguageTag4);
        Locale localeForLanguageTag5 = Locale.forLanguageTag("bn-IN");
        localeForLanguageTag5.getClass();
        l61 l61Var6 = new l61("BENGALI", 5, "বাংলা", localeForLanguageTag5);
        Locale localeForLanguageTag6 = Locale.forLanguageTag("ta-IN");
        localeForLanguageTag6.getClass();
        l61 l61Var7 = new l61("TAMIL", 6, "தமிழ்", localeForLanguageTag6);
        Locale localeForLanguageTag7 = Locale.forLanguageTag("te-IN");
        localeForLanguageTag7.getClass();
        l61 l61Var8 = new l61("TELUGU", 7, "తెలుగు", localeForLanguageTag7);
        Locale localeForLanguageTag8 = Locale.forLanguageTag("pa-IN");
        localeForLanguageTag8.getClass();
        l61 l61Var9 = new l61("PUNJABI", 8, "ਪੰਜਾਬੀ", localeForLanguageTag8);
        Locale localeForLanguageTag9 = Locale.forLanguageTag("mwr-IN");
        localeForLanguageTag9.getClass();
        l61 l61Var10 = new l61("MARWARI", 9, "मारवाड़ी", localeForLanguageTag9);
        Locale localeForLanguageTag10 = Locale.forLanguageTag("kn-IN");
        localeForLanguageTag10.getClass();
        l61 l61Var11 = new l61("KANNADA", 10, "ಕನ್ನಡ", localeForLanguageTag10);
        Locale localeForLanguageTag11 = Locale.forLanguageTag("ml-IN");
        localeForLanguageTag11.getClass();
        l61 l61Var12 = new l61("MALAYALAM", 11, "മലയാളം", localeForLanguageTag11);
        Locale localeForLanguageTag12 = Locale.forLanguageTag("ks-IN");
        localeForLanguageTag12.getClass();
        l61 l61Var13 = new l61("KASHMIRI", 12, "کٲشُر", localeForLanguageTag12);
        Locale localeForLanguageTag13 = Locale.forLanguageTag("as-IN");
        localeForLanguageTag13.getClass();
        l61 l61Var14 = new l61("ASSAMESE", 13, "অসমীয়া", localeForLanguageTag13);
        Locale localeForLanguageTag14 = Locale.forLanguageTag("or-IN");
        localeForLanguageTag14.getClass();
        l61 l61Var15 = new l61("ODIA", 14, "ଓଡ଼ିଆ", localeForLanguageTag14);
        i = l61Var15;
        Locale localeForLanguageTag15 = Locale.forLanguageTag("ne-IN");
        localeForLanguageTag15.getClass();
        l61 l61Var16 = new l61("NEPALI", 15, "नेपाली", localeForLanguageTag15);
        Locale localeForLanguageTag16 = Locale.forLanguageTag("kok-IN");
        localeForLanguageTag16.getClass();
        l61 l61Var17 = new l61("KONKANI", 16, "कोंकणी", localeForLanguageTag16);
        Locale localeForLanguageTag17 = Locale.forLanguageTag("sd-IN");
        localeForLanguageTag17.getClass();
        l61 l61Var18 = new l61("SINDHI", 17, "سنڌي", localeForLanguageTag17);
        Locale localeForLanguageTag18 = Locale.forLanguageTag("mai-IN");
        localeForLanguageTag18.getClass();
        l61 l61Var19 = new l61("MAITHILI", 18, "मैथिली", localeForLanguageTag18);
        Locale localeForLanguageTag19 = Locale.forLanguageTag("doi-IN");
        localeForLanguageTag19.getClass();
        l61 l61Var20 = new l61("DOGRI", 19, "डोगरी", localeForLanguageTag19);
        Locale localeForLanguageTag20 = Locale.forLanguageTag("sa-IN");
        localeForLanguageTag20.getClass();
        l61 l61Var21 = new l61("SANSKRIT", 20, "संस्कृतम्", localeForLanguageTag20);
        Locale localeForLanguageTag21 = Locale.forLanguageTag("mni-IN");
        localeForLanguageTag21.getClass();
        l61 l61Var22 = new l61("MANIPURI", 21, "মৈতৈলোন্", localeForLanguageTag21);
        Locale localeForLanguageTag22 = Locale.forLanguageTag("brx-IN");
        localeForLanguageTag22.getClass();
        l61 l61Var23 = new l61("BODO", 22, "बड़ो", localeForLanguageTag22);
        Locale localeForLanguageTag23 = Locale.forLanguageTag("sat-IN");
        localeForLanguageTag23.getClass();
        l61[] l61VarArr = {l61Var, l61Var2, l61Var3, l61Var4, l61Var5, l61Var6, l61Var7, l61Var8, l61Var9, l61Var10, l61Var11, l61Var12, l61Var13, l61Var14, l61Var15, l61Var16, l61Var17, l61Var18, l61Var19, l61Var20, l61Var21, l61Var22, l61Var23, new l61("SANTALI", 23, "ᱥᱟᱱᱛᱟᱲᱤ", localeForLanguageTag23)};
        j = l61VarArr;
        k = new gj0(l61VarArr);
        c = new xy(15);
    }

    public l61(String str, int i2, String str2, Locale locale) {
        super(str, i2);
        this.a = str2;
        this.b = locale;
    }

    public static l61 valueOf(String str) {
        return (l61) Enum.valueOf(l61.class, str);
    }

    public static l61[] values() {
        return (l61[]) j.clone();
    }
}
