package com.ibm.icu.text;

import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.util.CaseInsensitiveString;
import defpackage.cq;
import defpackage.ky0;
import defpackage.og;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class TransliteratorIDParser {
    private static final String ANY = "Any";
    private static final char CLOSE_REV = ')';
    private static final int FORWARD = 0;
    private static final char ID_DELIM = ';';
    private static final char OPEN_REV = '(';
    private static final int REVERSE = 1;
    private static final Map<CaseInsensitiveString, String> SPECIAL_INVERSES = new ConcurrentHashMap();
    private static final char TARGET_SEP = '-';
    private static final char VARIANT_SEP = '/';

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Specs {
        public String filter;
        public boolean sawSource;
        public String source;
        public String target;
        public String variant;

        public Specs(String str, String str2, String str3, boolean z, String str4) {
            this.source = str;
            this.target = str2;
            this.variant = str3;
            this.sawSource = z;
            this.filter = str4;
        }
    }

    public static String[] IDtoSTV(String str) {
        String strSubstring;
        String strSubstring2;
        int iIndexOf = str.indexOf(45);
        int iIndexOf2 = str.indexOf(47);
        if (iIndexOf2 < 0) {
            iIndexOf2 = str.length();
        }
        boolean z = false;
        String strSubstring3 = ANY;
        if (iIndexOf < 0) {
            strSubstring = str.substring(0, iIndexOf2);
            strSubstring2 = str.substring(iIndexOf2);
        } else if (iIndexOf < iIndexOf2) {
            if (iIndexOf > 0) {
                strSubstring3 = str.substring(0, iIndexOf);
                z = true;
            }
            strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
            strSubstring2 = str.substring(iIndexOf2);
        } else {
            if (iIndexOf2 > 0) {
                strSubstring3 = str.substring(0, iIndexOf2);
                z = true;
            }
            int i = iIndexOf + 1;
            String strSubstring4 = str.substring(iIndexOf2, iIndexOf);
            strSubstring = str.substring(i);
            strSubstring2 = strSubstring4;
        }
        if (strSubstring2.length() > 0) {
            strSubstring2 = strSubstring2.substring(1);
        }
        return new String[]{strSubstring3, strSubstring, strSubstring2, z ? "" : null};
    }

    public static String STVtoID(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        if (sb.length() == 0) {
            sb.append(ANY);
        }
        sb.append(TARGET_SEP);
        sb.append(str2);
        if (str3 != null && str3.length() != 0) {
            sb.append(VARIANT_SEP);
            sb.append(str3);
        }
        return sb.toString();
    }

    public static List<Transliterator> instantiateList(List<SingleID> list) {
        ArrayList arrayList = new ArrayList();
        for (SingleID singleID : list) {
            if (singleID.basicID.length() != 0) {
                Transliterator singleID2 = singleID.getInstance();
                if (singleID2 == null) {
                    og.i(cq.j("Illegal ID ", singleID.canonID));
                    return null;
                }
                arrayList.add(singleID2);
            }
        }
        if (arrayList.size() != 0) {
            return arrayList;
        }
        Transliterator basicInstance = Transliterator.getBasicInstance("Any-Null", null);
        if (basicInstance != null) {
            arrayList.add(basicInstance);
            return arrayList;
        }
        og.i("Internal error; cannot instantiate Any-Null");
        return null;
    }

    public static boolean parseCompoundID(String str, int i, StringBuilder sb, List<SingleID> list, UnicodeSet[] unicodeSetArr) {
        boolean z;
        int[] iArr = {0};
        list.clear();
        unicodeSetArr[0] = null;
        sb.setLength(0);
        int[] iArr2 = {0};
        UnicodeSet globalFilter = parseGlobalFilter(str, iArr, i, iArr2, sb);
        if (globalFilter != null) {
            if (!Utility.parseChar(str, iArr, ID_DELIM)) {
                sb.setLength(0);
                iArr[0] = 0;
            }
            if (i == 0) {
                unicodeSetArr[0] = globalFilter;
            }
        }
        while (true) {
            SingleID singleID = parseSingleID(str, iArr, i);
            if (singleID == null) {
                z = true;
                break;
            }
            if (i == 0) {
                list.add(singleID);
            } else {
                list.add(0, singleID);
            }
            if (!Utility.parseChar(str, iArr, ID_DELIM)) {
                z = false;
                break;
            }
        }
        if (list.size() == 0) {
            return false;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(list.get(i2).canonID);
            if (i2 != list.size() - 1) {
                sb.append(ID_DELIM);
            }
        }
        if (z) {
            iArr2[0] = 1;
            UnicodeSet globalFilter2 = parseGlobalFilter(str, iArr, i, iArr2, sb);
            if (globalFilter2 != null) {
                Utility.parseChar(str, iArr, ID_DELIM);
                if (i == 1) {
                    unicodeSetArr[0] = globalFilter2;
                }
            }
        }
        int iSkipWhiteSpace = PatternProps.skipWhiteSpace(str, iArr[0]);
        iArr[0] = iSkipWhiteSpace;
        return iSkipWhiteSpace == str.length();
    }

    private static Specs parseFilterID(String str, int[] iArr, boolean z) {
        String str2;
        boolean z2;
        String unicodeIdentifier;
        char cCharAt;
        int i = iArr[0];
        char c = 0;
        int i2 = 0;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        String str6 = null;
        while (true) {
            int iSkipWhiteSpace = PatternProps.skipWhiteSpace(str, iArr[0]);
            iArr[0] = iSkipWhiteSpace;
            if (iSkipWhiteSpace == str.length()) {
                break;
            }
            if (z && str6 == null && UnicodeSet.resemblesPattern(str, iArr[0])) {
                ParsePosition parsePosition = new ParsePosition(iArr[0]);
                new UnicodeSet(str, parsePosition, null);
                String strSubstring = str.substring(iArr[0], parsePosition.getIndex());
                iArr[0] = parsePosition.getIndex();
                str6 = strSubstring;
            } else if (c != 0 || (((cCharAt = str.charAt(iArr[0])) != '-' || str3 != null) && (cCharAt != '/' || str5 != null))) {
                if ((c == 0 && i2 > 0) || (unicodeIdentifier = Utility.parseUnicodeIdentifier(str, iArr)) == null) {
                    break;
                }
                if (c == 0) {
                    str4 = unicodeIdentifier;
                } else if (c == '-') {
                    str3 = unicodeIdentifier;
                } else if (c == '/') {
                    str5 = unicodeIdentifier;
                }
                i2++;
                c = 0;
            } else {
                iArr[0] = iArr[0] + 1;
                c = cCharAt;
            }
        }
        if (str4 == null) {
            str4 = null;
        } else if (str3 == null) {
            str3 = str4;
            str4 = null;
        }
        if (str4 == null && str3 == null) {
            iArr[0] = i;
            return null;
        }
        if (str4 == null) {
            str2 = ANY;
            z2 = false;
        } else {
            str2 = str4;
            z2 = true;
        }
        return new Specs(str2, str3 == null ? ANY : str3, str5, z2, str6);
    }

    public static UnicodeSet parseGlobalFilter(String str, int[] iArr, int i, int[] iArr2, StringBuilder sb) {
        int i2 = iArr[0];
        int i3 = iArr2[0];
        if (i3 == -1) {
            iArr2[0] = Utility.parseChar(str, iArr, OPEN_REV) ? 1 : 0;
        } else if (i3 == 1 && !Utility.parseChar(str, iArr, OPEN_REV)) {
            iArr[0] = i2;
            return null;
        }
        int iSkipWhiteSpace = PatternProps.skipWhiteSpace(str, iArr[0]);
        iArr[0] = iSkipWhiteSpace;
        if (UnicodeSet.resemblesPattern(str, iSkipWhiteSpace)) {
            ParsePosition parsePosition = new ParsePosition(iArr[0]);
            try {
                UnicodeSet unicodeSet = new UnicodeSet(str, parsePosition, null);
                String strSubstring = str.substring(iArr[0], parsePosition.getIndex());
                iArr[0] = parsePosition.getIndex();
                if (iArr2[0] == 1 && !Utility.parseChar(str, iArr, CLOSE_REV)) {
                    iArr[0] = i2;
                    return null;
                }
                if (sb != null) {
                    if (i == 0) {
                        if (iArr2[0] == 1) {
                            strSubstring = cq.k(String.valueOf(OPEN_REV), strSubstring, ")");
                        }
                        sb.append(strSubstring.concat(";"));
                        return unicodeSet;
                    }
                    if (iArr2[0] == 0) {
                        strSubstring = cq.k(String.valueOf(OPEN_REV), strSubstring, ")");
                    }
                    sb.insert(0, strSubstring.concat(";"));
                }
                return unicodeSet;
            } catch (IllegalArgumentException unused) {
                iArr[0] = i2;
            }
        }
        return null;
    }

    public static SingleID parseSingleID(String str, int[] iArr, int i) {
        boolean z;
        SingleID singleIDSpecsToSpecialInverse;
        int i2 = iArr[0];
        Specs specs = null;
        Specs filterID = null;
        int i3 = 1;
        while (true) {
            if (i3 > 2) {
                z = false;
                break;
            }
            if (i3 == 2 && (filterID = parseFilterID(str, iArr, true)) == null) {
                iArr[0] = i2;
                return null;
            }
            if (Utility.parseChar(str, iArr, OPEN_REV)) {
                if (!Utility.parseChar(str, iArr, CLOSE_REV)) {
                    Specs filterID2 = parseFilterID(str, iArr, true);
                    if (filterID2 != null && Utility.parseChar(str, iArr, CLOSE_REV)) {
                        z = true;
                        specs = filterID2;
                        break;
                    }
                    iArr[0] = i2;
                    return null;
                }
                z = true;
                break;
            }
            i3++;
        }
        if (!z) {
            if (i == 0) {
                singleIDSpecsToSpecialInverse = specsToID(filterID, 0);
            } else {
                singleIDSpecsToSpecialInverse = specsToSpecialInverse(filterID);
                if (singleIDSpecsToSpecialInverse == null) {
                    singleIDSpecsToSpecialInverse = specsToID(filterID, 1);
                }
            }
            singleIDSpecsToSpecialInverse.filter = filterID.filter;
            return singleIDSpecsToSpecialInverse;
        }
        if (i == 0) {
            SingleID singleIDSpecsToID = specsToID(filterID, 0);
            singleIDSpecsToID.canonID = ky0.k(singleIDSpecsToID.canonID, "(", specsToID(specs, 0).canonID, ")");
            if (filterID != null) {
                singleIDSpecsToID.filter = filterID.filter;
            }
            return singleIDSpecsToID;
        }
        SingleID singleIDSpecsToID2 = specsToID(specs, 0);
        singleIDSpecsToID2.canonID = ky0.k(singleIDSpecsToID2.canonID, "(", specsToID(filterID, 0).canonID, ")");
        if (specs != null) {
            singleIDSpecsToID2.filter = specs.filter;
        }
        return singleIDSpecsToID2;
    }

    public static void registerSpecialInverse(String str, String str2, boolean z) {
        Map<CaseInsensitiveString, String> map = SPECIAL_INVERSES;
        map.put(new CaseInsensitiveString(str), str2);
        if (!z || str.equalsIgnoreCase(str2)) {
            return;
        }
        map.put(new CaseInsensitiveString(str2), str);
    }

    private static SingleID specsToID(Specs specs, int i) {
        String str;
        String string = "";
        if (specs != null) {
            StringBuilder sb = new StringBuilder();
            if (i == 0) {
                boolean z = specs.sawSource;
                String str2 = specs.source;
                if (z) {
                    sb.append(str2);
                    sb.append(TARGET_SEP);
                } else {
                    string = ky0.j(str2, LanguageTag.SEP);
                }
                sb.append(specs.target);
            } else {
                sb.append(specs.target);
                sb.append(TARGET_SEP);
                sb.append(specs.source);
            }
            if (specs.variant != null) {
                sb.append(VARIANT_SEP);
                sb.append(specs.variant);
            }
            String strConcat = string.concat(sb.toString());
            String str3 = specs.filter;
            if (str3 != null) {
                sb.insert(0, str3);
            }
            string = sb.toString();
            str = strConcat;
        } else {
            str = "";
        }
        return new SingleID(string, str);
    }

    private static SingleID specsToSpecialInverse(Specs specs) {
        String str;
        if (!specs.source.equalsIgnoreCase(ANY) || (str = SPECIAL_INVERSES.get(new CaseInsensitiveString(specs.target))) == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        String str2 = specs.filter;
        if (str2 != null) {
            sb.append(str2);
        }
        if (specs.sawSource) {
            sb.append("Any-");
        }
        sb.append(str);
        String strConcat = "Any-".concat(str);
        if (specs.variant != null) {
            sb.append(VARIANT_SEP);
            sb.append(specs.variant);
            strConcat = cq.k(strConcat, "/", specs.variant);
        }
        return new SingleID(sb.toString(), strConcat);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class SingleID {
        public String basicID;
        public String canonID;
        public String filter;

        public SingleID(String str, String str2, String str3) {
            this.canonID = str;
            this.basicID = str2;
            this.filter = str3;
        }

        public Transliterator getInstance() {
            String str = this.basicID;
            Transliterator basicInstance = (str == null || str.length() == 0) ? Transliterator.getBasicInstance("Any-Null", this.canonID) : Transliterator.getBasicInstance(this.basicID, this.canonID);
            if (basicInstance != null && this.filter != null) {
                basicInstance.setFilter(new UnicodeSet(this.filter));
            }
            return basicInstance;
        }

        public SingleID(String str, String str2) {
            this(str, str2, null);
        }
    }

    public static SingleID parseFilterID(String str, int[] iArr) {
        int i = iArr[0];
        Specs filterID = parseFilterID(str, iArr, true);
        if (filterID == null) {
            iArr[0] = i;
            return null;
        }
        SingleID singleIDSpecsToID = specsToID(filterID, 0);
        singleIDSpecsToID.filter = filterID.filter;
        return singleIDSpecsToID;
    }
}
