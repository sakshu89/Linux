package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class nt0 {
    public static final x42 a = new x42("model[^\\n]{0,180}(?:not found|not supported|not available|unavailable|does not support|not enabled|retired|deprecated|not permitted|access denied)|(?:not found|not supported|not available|access denied)[^\\n]{0,100}model|(?:blocking|function calling)[^\\n]{0,80}(?:not supported|unsupported)");
    public static final x42 b = new x42("limit\\s*[\"']?\\s*:\\s*0(?:\\D|$)");

    public static boolean a(Integer num, String str) {
        str.getClass();
        Locale locale = Locale.ROOT;
        String strO = cq.o(locale, str, locale);
        List listI = nz.i("api_key_invalid", "api key not valid", "invalid api key", "api_key_expired", "api_key_leaked", "api has not been used", "api is disabled");
        if (!listI.isEmpty()) {
            Iterator it = listI.iterator();
            while (it.hasNext()) {
                if (cs2.n(strO, (String) it.next(), false)) {
                }
            }
            if (!oj4.a(strO)) {
                return num.intValue() == 404 ? true : true;
            }
        } else if (!oj4.a(strO) && num.intValue() != 401) {
            if (num.intValue() == 404 && num.intValue() != 410) {
                if (mz.s(num, wh2.c(429, 1008)) && cs2.n(strO, "quota", false) && b.a(strO)) {
                    return true;
                }
                if (wh2.c(null, 400, 403, 1008).contains(num) && a.a(strO)) {
                    return true;
                }
            }
        }
        return false;
    }
}
