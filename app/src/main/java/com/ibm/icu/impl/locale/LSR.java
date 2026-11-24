package com.ibm.icu.impl.locale;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UProperty;
import com.ibm.icu.lang.UScript;
import defpackage.cq;
import defpackage.og;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class LSR {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final boolean DEBUG_OUTPUT = false;
    public static final int DONT_CARE_FLAGS = 0;
    public static final int EXPLICIT_LANGUAGE = 4;
    public static final int EXPLICIT_LSR = 7;
    public static final int EXPLICIT_REGION = 1;
    public static final int EXPLICIT_SCRIPT = 2;
    public static final int IMPLICIT_LSR = 0;
    public static final int REGION_INDEX_LIMIT = 1677;
    public final int flags;
    public final String language;
    public final String region;
    final int regionIndex;
    public final String script;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CachedDecoder {
        private final String[] m49;
        private static final String[] DECODED_ZERO = {"", "", ""};
        private static final String[] DECODED_ONE = {"skip", "script", ""};
        private final HashMap<Integer, String> langsCache = new HashMap<>(556);
        private final HashMap<Integer, String> scriptsCache = new HashMap<>(UCharacter.getIntPropertyMaxValue(UProperty.SCRIPT));
        private final HashMap<Integer, String> regionsCache = new HashMap<>(253);

        public CachedDecoder(String[] strArr) {
            this.m49 = strArr;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String toLanguage(int i) {
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) ((i % 27) + 96));
            sb.append((char) (((i / 27) % 27) + 96));
            int i2 = i / 729;
            if (i2 != 0) {
                sb.append((char) (i2 + 96));
            }
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String toRegion(int i) {
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) ((i % 27) + 64));
            sb.append((char) (((i / 27) % 27) + 64));
            return sb.toString();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static String toScript(int i) {
            try {
                return UScript.getShortName(i);
            } catch (IllegalArgumentException unused) {
                return "";
            }
        }

        public String[] decode(int i) {
            String strComputeIfAbsent;
            if (i == 0) {
                return DECODED_ZERO;
            }
            final int i2 = 1;
            if (i == 1) {
                return DECODED_ONE;
            }
            int i3 = 16777215 & i;
            final int i4 = 0;
            String strComputeIfAbsent2 = this.langsCache.computeIfAbsent(Integer.valueOf(i3 % 19683), new Function() { // from class: com.ibm.icu.impl.locale.a
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Integer num = (Integer) obj;
                    switch (i4) {
                        case 0:
                            return LSR.CachedDecoder.toLanguage(num.intValue());
                        case 1:
                            return LSR.CachedDecoder.toScript(num.intValue());
                        default:
                            return LSR.CachedDecoder.toRegion(num.intValue());
                    }
                }
            });
            String strComputeIfAbsent3 = this.scriptsCache.computeIfAbsent(Integer.valueOf((i >> 24) & 255), new Function() { // from class: com.ibm.icu.impl.locale.a
                @Override // java.util.function.Function
                public final Object apply(Object obj) {
                    Integer num = (Integer) obj;
                    switch (i2) {
                        case 0:
                            return LSR.CachedDecoder.toLanguage(num.intValue());
                        case 1:
                            return LSR.CachedDecoder.toScript(num.intValue());
                        default:
                            return LSR.CachedDecoder.toRegion(num.intValue());
                    }
                }
            });
            int i5 = (i3 / 19683) % 729;
            if (i5 < 27) {
                strComputeIfAbsent = this.m49[i5];
            } else {
                final int i6 = 2;
                strComputeIfAbsent = this.regionsCache.computeIfAbsent(Integer.valueOf(i5), new Function() { // from class: com.ibm.icu.impl.locale.a
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        Integer num = (Integer) obj;
                        switch (i6) {
                            case 0:
                                return LSR.CachedDecoder.toLanguage(num.intValue());
                            case 1:
                                return LSR.CachedDecoder.toScript(num.intValue());
                            default:
                                return LSR.CachedDecoder.toRegion(num.intValue());
                        }
                    }
                });
            }
            return new String[]{strComputeIfAbsent2, strComputeIfAbsent3, strComputeIfAbsent};
        }
    }

    public LSR(String str, String str2, String str3, int i) {
        this.language = str;
        this.script = str2;
        this.region = str3;
        this.regionIndex = indexForRegion(str3);
        this.flags = i;
    }

    public static LSR[] decodeInts(int[] iArr, String[] strArr) {
        LSR[] lsrArr = new LSR[iArr.length];
        CachedDecoder cachedDecoder = new CachedDecoder(strArr);
        for (int i = 0; i < iArr.length; i++) {
            String[] strArrDecode = cachedDecoder.decode(iArr[i]);
            lsrArr[i] = new LSR(strArrDecode[0], strArrDecode[1], strArrDecode[2], 0);
        }
        return lsrArr;
    }

    private int encodeLanguageToInt() {
        return ((this.language.charAt(1) - '`') * 27) + (this.language.charAt(0) - '`') + (this.language.length() != 2 ? (this.language.charAt(2) - '`') * 729 : 0);
    }

    private int encodeRegionToInt(List<String> list) {
        int length = this.region.length();
        String str = this.region;
        if (length != 3) {
            return ((this.region.charAt(1) - '@') * 27) + (str.charAt(0) - '@');
        }
        int iIndexOf = list.indexOf(str);
        if (iIndexOf >= 0) {
            return iIndexOf;
        }
        og.n(cq.v("Please add '", this.region, "' to M49 in LocaleDistanceMapper.java"));
        return 0;
    }

    private int encodeScriptToInt() {
        return UScript.getCodeFromName(this.script);
    }

    public static final int indexForRegion(String str) {
        int iCharAt;
        int iCharAt2;
        int iCharAt3;
        int iCharAt4;
        if (str.length() == 2) {
            int iCharAt5 = str.charAt(0) - 'A';
            if (iCharAt5 < 0 || 25 < iCharAt5 || (iCharAt4 = str.charAt(1) - 'A') < 0 || 25 < iCharAt4) {
                return 0;
            }
            return (iCharAt5 * 26) + iCharAt4 + 1001;
        }
        if (str.length() != 3 || (iCharAt = str.charAt(0) - '0') < 0 || 9 < iCharAt || (iCharAt2 = str.charAt(1) - '0') < 0 || 9 < iCharAt2 || (iCharAt3 = str.charAt(2) - '0') < 0 || 9 < iCharAt3) {
            return 0;
        }
        return (((iCharAt * 10) + iCharAt2) * 10) + iCharAt3 + 1;
    }

    public int encodeToIntForResource(List<String> list) {
        return (encodeScriptToInt() << 24) | ((encodeRegionToInt(list) * 19683) + encodeLanguageToInt());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || obj.getClass() != LSR.class) {
            return false;
        }
        LSR lsr = (LSR) obj;
        return this.language.equals(lsr.language) && this.script.equals(lsr.script) && this.region.equals(lsr.region) && this.flags == lsr.flags;
    }

    public int hashCode() {
        return Objects.hash(this.language, this.script, this.region, Integer.valueOf(this.flags));
    }

    public boolean isEquivalentTo(LSR lsr) {
        return this.language.equals(lsr.language) && this.script.equals(lsr.script) && this.region.equals(lsr.region);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(this.language);
        if (!this.script.isEmpty()) {
            sb.append('-');
            sb.append(this.script);
        }
        if (!this.region.isEmpty()) {
            sb.append('-');
            sb.append(this.region);
        }
        return sb.toString();
    }
}
