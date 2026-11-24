package defpackage;

import com.ibm.icu.impl.locale.LanguageTag;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class g24 {
    public static final gb a = new gb(5);

    public static boolean a(String str) {
        str.getClass();
        Set setC = wh2.c(LanguageTag.PRIVATEUSE, "×", "✕", "cross", "close", "close button", "close icon", "x button", "cross button", "dismiss button");
        String string = cs2.V(str).toString();
        Locale locale = Locale.ROOT;
        locale.getClass();
        String lowerCase = string.toLowerCase(locale);
        lowerCase.getClass();
        return setC.contains(lowerCase);
    }
}
