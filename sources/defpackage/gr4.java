package defpackage;

import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class gr4 {
    public static ji1 a(String str) {
        str.getClass();
        Matcher matcher = ji1.c.matcher(str);
        if (!matcher.lookingAt()) {
            dk0.m(str, "No subtype found for: \"");
            return null;
        }
        String strGroup = matcher.group(1);
        strGroup.getClass();
        Locale locale = Locale.US;
        locale.getClass();
        strGroup.toLowerCase(locale).getClass();
        String strGroup2 = matcher.group(2);
        strGroup2.getClass();
        strGroup2.toLowerCase(locale).getClass();
        ArrayList arrayList = new ArrayList();
        Matcher matcher2 = ji1.d.matcher(str);
        int iEnd = matcher.end();
        while (iEnd < str.length()) {
            matcher2.region(iEnd, str.length());
            if (!matcher2.lookingAt()) {
                throw new IllegalArgumentException(("Parameter is not formatted correctly: \"" + str.substring(iEnd) + "\" for: \"" + str + '\"').toString());
            }
            String strGroup3 = matcher2.group(1);
            if (strGroup3 == null) {
                iEnd = matcher2.end();
            } else {
                String strGroup4 = matcher2.group(2);
                if (strGroup4 == null) {
                    strGroup4 = matcher2.group(3);
                } else if (js2.k(strGroup4, "'", false) && js2.e(strGroup4, "'", false) && strGroup4.length() > 2) {
                    strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                }
                arrayList.add(strGroup3);
                arrayList.add(strGroup4);
                iEnd = matcher2.end();
            }
        }
        return new ji1(str, (String[]) arrayList.toArray(new String[0]));
    }
}
