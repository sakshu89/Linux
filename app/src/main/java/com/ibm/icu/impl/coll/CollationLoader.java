package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CollationLoader {
    private static volatile String rootRules;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ASCII {
        private ASCII() {
        }

        public static String toLowerCase(String str) {
            int i = 0;
            while (i < str.length()) {
                char cCharAt = str.charAt(i);
                if ('A' > cCharAt || cCharAt > 'Z') {
                    i++;
                } else {
                    StringBuilder sb = new StringBuilder(str.length());
                    sb.append((CharSequence) str, 0, i);
                    sb.append((char) (cCharAt + ' '));
                    while (true) {
                        i++;
                        if (i >= str.length()) {
                            return sb.toString();
                        }
                        char cCharAt2 = str.charAt(i);
                        if ('A' <= cCharAt2 && cCharAt2 <= 'Z') {
                            cCharAt2 = (char) (cCharAt2 + ' ');
                        }
                        sb.append(cCharAt2);
                    }
                }
            }
            return str;
        }
    }

    private CollationLoader() {
    }

    private static final UResourceBundle findWithFallback(UResourceBundle uResourceBundle, String str) {
        return ((ICUResourceBundle) uResourceBundle).findWithFallback(str);
    }

    public static String getRootRules() {
        loadRootRules();
        return rootRules;
    }

    private static void loadRootRules() {
        if (rootRules != null) {
            return;
        }
        synchronized (CollationLoader.class) {
            try {
                if (rootRules == null) {
                    rootRules = UResourceBundle.getBundleInstance(ICUData.ICU_COLLATION_BASE_NAME, ULocale.ROOT).getString("UCARules");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String loadRules(ULocale uLocale, String str) {
        return ((ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_COLLATION_BASE_NAME, uLocale)).getWithFallback("collations/" + ASCII.toLowerCase(str)).getString("Sequence");
    }

    /* JADX WARN: Code duplicated, block: B:12:0x0034  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b2  */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00b8, code lost:
    
        if (r11.equals("standard") != false) goto L69;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [T, com.ibm.icu.util.ULocale] */
    /* JADX WARN: Type inference failed for: r11v2, types: [T, com.ibm.icu.util.ULocale] */
    /* JADX WARN: Type inference failed for: r1v3, types: [T, com.ibm.icu.util.ULocale] */
    /* JADX WARN: Type inference failed for: r4v2, types: [T, com.ibm.icu.util.ULocale, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static com.ibm.icu.impl.coll.CollationTailoring loadTailoring(com.ibm.icu.util.ULocale r11, com.ibm.icu.util.Output<com.ibm.icu.util.ULocale> r12) {
        /*
            Method dump skipped, instruction units count: 296
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.impl.coll.CollationLoader.loadTailoring(com.ibm.icu.util.ULocale, com.ibm.icu.util.Output):com.ibm.icu.impl.coll.CollationTailoring");
    }
}
