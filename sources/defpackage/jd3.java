package defpackage;

import com.ibm.icu.impl.number.Padder;
import java.text.Normalizer;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class jd3 {
    public static final x42 a = new x42("&(#x[0-9a-f]+|#[0-9]+|amp|quot|apos|lt|gt|nbsp);", y42.IGNORE_CASE);

    public static boolean a(ro1 ro1Var, String str) {
        if (!g31.a(ro1Var.a, "com.google.android.youtube")) {
            return false;
        }
        boolean z = ro1Var.f;
        String str2 = ro1Var.c;
        return (!z || str == null || cs2.A(str) || str2 == null || cs2.A(str2) || !g31.a(b(str2), b(str)) || cs2.A(b(str))) ? false : true;
    }

    public static String b(String str) {
        String strNormalize = Normalizer.normalize(a.g(str, new l63(12)), Normalizer.Form.NFKC);
        strNormalize.getClass();
        Locale locale = Locale.ROOT;
        String strO = cq.o(locale, strNormalize, locale);
        Pattern patternCompile = Pattern.compile("[^\\p{L}\\p{M}\\p{N}]+");
        patternCompile.getClass();
        String strReplaceAll = patternCompile.matcher(strO).replaceAll(Padder.FALLBACK_PADDING_STRING);
        strReplaceAll.getClass();
        return cs2.V(strReplaceAll).toString();
    }
}
