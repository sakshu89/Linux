package defpackage;

import com.ibm.icu.impl.PatternTokenizer;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class vi1 {
    public static final mz2 a = new mz2();
    public static final Set b = wh2.c(Character.valueOf(PatternTokenizer.SINGLE_QUOTE), '\"', 8216, 8217, 8220, 8221, '`');
    public static final x42 c = new x42("\\blet['’]s\\b", y42.IGNORE_CASE);
    public static final x42 d = new x42("(?:(?:(?:yes|yeah|yep|yup|sure|ok|okay|haan|han|ji|bilkul|go\\s+ahead)(?:\\s+and)?|(?:send(?:\\s+(?:it|that|this|(?:the|this|that)\\s+message))?|bhej\\s+do|bhejo)|sonic|sonik|please)\\s+){0,4}(?:send(?:\\s+(?:it|that|this|(?:the|this|that)\\s+message))?|bhej\\s+do|bhejo)(?:\\s+(?:please|now))?");
    public static final x42 e = new x42("(?:yes|yeah|yep|yup|sure|ok|okay|haan|han|ji|bilkul|go\\s+ahead)(?:\\s+please)?");

    public static String a(String str) {
        String strF = c.f(str, "lets");
        for (int i = 0; i < strF.length(); i++) {
            if (b.contains(Character.valueOf(strF.charAt(i)))) {
                return null;
            }
        }
        return cs2.V(cs2.I(a.a(strF).b, " please")).toString();
    }

    public static boolean b(String str) {
        str.getClass();
        String strA = a(str);
        if (strA != null) {
            return d.e(strA) || e.e(strA) || wh2.c("confirm", "confirmed").contains(strA);
        }
        return false;
    }
}
