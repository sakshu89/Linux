package com.ibm.icu.impl.locale;

import defpackage.cq;
import defpackage.ky0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class LanguageTag {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean JDKIMPL = false;
    private static final Map<AsciiUtil.CaseInsensitiveKey, String[]> LEGACY = new HashMap();
    public static final String PRIVATEUSE = "x";
    public static final String PRIVUSE_VARIANT_PREFIX = "lvariant";
    public static final String SEP = "-";
    public static String UNDETERMINED = "und";
    private List<String> _extensions;
    private List<String> _extlangs;
    private List<String> _variants;
    private String _language = "";
    private String _script = "";
    private String _region = "";
    private String _privateuse = "";

    static {
        String[][] strArr = {new String[]{"art-lojban", "jbo"}, new String[]{"cel-gaulish", "xtg"}, new String[]{"en-GB-oed", "en-GB-x-oed"}, new String[]{"i-ami", "ami"}, new String[]{"i-bnn", "bnn"}, new String[]{"i-default", "en-x-i-default"}, new String[]{"i-enochian", "und-x-i-enochian"}, new String[]{"i-hak", "hak"}, new String[]{"i-klingon", "tlh"}, new String[]{"i-lux", "lb"}, new String[]{"i-mingo", "see-x-i-mingo"}, new String[]{"i-navajo", "nv"}, new String[]{"i-pwn", "pwn"}, new String[]{"i-tao", "tao"}, new String[]{"i-tay", "tay"}, new String[]{"i-tsu", "tsu"}, new String[]{"no-bok", "nb"}, new String[]{"no-nyn", "nn"}, new String[]{"sgn-BE-FR", "sfb"}, new String[]{"sgn-BE-NL", "vgt"}, new String[]{"sgn-CH-DE", "sgg"}, new String[]{"zh-guoyu", "cmn"}, new String[]{"zh-hakka", "hak"}, new String[]{"zh-min", "nan-x-zh-min"}, new String[]{"zh-min-nan", "nan"}, new String[]{"zh-xiang", "hsn"}};
        for (int i = 0; i < 26; i++) {
            String[] strArr2 = strArr[i];
            LEGACY.put(new AsciiUtil.CaseInsensitiveKey(strArr2[0]), strArr2);
        }
    }

    private LanguageTag() {
        List<String> list = Collections.EMPTY_LIST;
        this._extlangs = list;
        this._variants = list;
        this._extensions = list;
    }

    public static String canonicalizeExtension(String str) {
        String lowerString = AsciiUtil.toLowerString(str);
        if (lowerString.startsWith("u-")) {
            while (lowerString.endsWith("-true")) {
                lowerString = lowerString.substring(0, lowerString.length() - 5);
            }
            while (true) {
                int iIndexOf = lowerString.indexOf("-true-");
                if (iIndexOf <= 0) {
                    break;
                }
                lowerString = lowerString.substring(0, iIndexOf).concat(lowerString.substring(iIndexOf + 5));
            }
            while (lowerString.endsWith("-yes")) {
                lowerString = lowerString.substring(0, lowerString.length() - 4);
            }
            while (true) {
                int iIndexOf2 = lowerString.indexOf("-yes-");
                if (iIndexOf2 <= 0) {
                    break;
                }
                lowerString = lowerString.substring(0, iIndexOf2).concat(lowerString.substring(iIndexOf2 + 4));
            }
        }
        return lowerString;
    }

    public static String canonicalizeExtensionSingleton(String str) {
        return AsciiUtil.toLowerString(str);
    }

    public static String canonicalizeExtensionSubtag(String str) {
        return AsciiUtil.toLowerString(str);
    }

    public static String canonicalizeExtlang(String str) {
        return AsciiUtil.toLowerString(str);
    }

    public static String canonicalizeLanguage(String str) {
        return AsciiUtil.toLowerString(str);
    }

    public static String canonicalizePrivateuse(String str) {
        return AsciiUtil.toLowerString(str);
    }

    public static String canonicalizePrivateuseSubtag(String str) {
        return AsciiUtil.toLowerString(str);
    }

    public static String canonicalizeRegion(String str) {
        return AsciiUtil.toUpperString(str);
    }

    public static String canonicalizeScript(String str) {
        return AsciiUtil.toTitleString(str);
    }

    public static String canonicalizeVariant(String str) {
        return AsciiUtil.toLowerString(str);
    }

    public static boolean isExtensionSingleton(String str) {
        return str.length() == 1 && AsciiUtil.isAlphaNumericString(str) && !AsciiUtil.caseIgnoreMatch(PRIVATEUSE, str);
    }

    public static boolean isExtensionSingletonChar(char c) {
        return isExtensionSingleton(String.valueOf(c));
    }

    public static boolean isExtensionSubtag(String str) {
        return str.length() >= 2 && str.length() <= 8 && AsciiUtil.isAlphaNumericString(str);
    }

    public static boolean isExtlang(String str) {
        return str.length() == 3 && AsciiUtil.isAlphaString(str);
    }

    public static boolean isLanguage(String str) {
        return str.length() >= 2 && str.length() <= 8 && AsciiUtil.isAlphaString(str);
    }

    public static boolean isPrivateusePrefix(String str) {
        return str.length() == 1 && AsciiUtil.caseIgnoreMatch(PRIVATEUSE, str);
    }

    public static boolean isPrivateusePrefixChar(char c) {
        return AsciiUtil.caseIgnoreMatch(PRIVATEUSE, String.valueOf(c));
    }

    public static boolean isPrivateuseSubtag(String str) {
        return str.length() >= 1 && str.length() <= 8 && AsciiUtil.isAlphaNumericString(str);
    }

    public static boolean isRegion(String str) {
        if (str.length() == 2 && AsciiUtil.isAlphaString(str)) {
            return true;
        }
        return str.length() == 3 && AsciiUtil.isNumericString(str);
    }

    public static boolean isScript(String str) {
        return str.length() == 4 && AsciiUtil.isAlphaString(str);
    }

    public static boolean isTKey(String str) {
        return str.length() == 2 && AsciiUtil.isAlpha(str.charAt(0)) && AsciiUtil.isNumeric(str.charAt(1));
    }

    public static boolean isVariant(String str) {
        int length = str.length();
        if (length < 5 || length > 8) {
            return length == 4 && AsciiUtil.isNumeric(str.charAt(0)) && AsciiUtil.isAlphaNumeric(str.charAt(1)) && AsciiUtil.isAlphaNumeric(str.charAt(2)) && AsciiUtil.isAlphaNumeric(str.charAt(3));
        }
        return AsciiUtil.isAlphaNumericString(str);
    }

    public static LanguageTag parse(String str, ParseStatus parseStatus) {
        boolean z;
        StringTokenIterator stringTokenIterator;
        if (parseStatus == null) {
            parseStatus = new ParseStatus();
        } else {
            parseStatus.reset();
        }
        String[] strArr = LEGACY.get(new AsciiUtil.CaseInsensitiveKey(str));
        int iIndexOf = 2;
        while (true) {
            z = false;
            if (strArr != null || (iIndexOf = str.indexOf(45, iIndexOf + 1)) == -1) {
                break;
            }
            strArr = LEGACY.get(new AsciiUtil.CaseInsensitiveKey(str.substring(0, iIndexOf)));
        }
        if (strArr != null) {
            stringTokenIterator = strArr[0].length() == str.length() ? new StringTokenIterator(strArr[1], SEP) : new StringTokenIterator(ky0.j(strArr[1], str.substring(iIndexOf)), SEP);
            z = true;
        } else {
            stringTokenIterator = new StringTokenIterator(str, SEP);
        }
        LanguageTag languageTag = new LanguageTag();
        if (languageTag.parseLanguage(stringTokenIterator, parseStatus)) {
            if (languageTag._language.length() <= 3) {
                languageTag.parseExtlangs(stringTokenIterator, parseStatus);
            }
            languageTag.parseScript(stringTokenIterator, parseStatus);
            languageTag.parseRegion(stringTokenIterator, parseStatus);
            languageTag.parseVariants(stringTokenIterator, parseStatus);
            languageTag.parseExtensions(stringTokenIterator, parseStatus);
        }
        languageTag.parsePrivateuse(stringTokenIterator, parseStatus);
        if (z) {
            parseStatus._parseLength = str.length();
            return languageTag;
        }
        if (!stringTokenIterator.isDone() && !parseStatus.isError()) {
            String strCurrent = stringTokenIterator.current();
            parseStatus._errorIndex = stringTokenIterator.currentStart();
            if (strCurrent.length() == 0) {
                parseStatus._errorMsg = "Empty subtag";
                return languageTag;
            }
            parseStatus._errorMsg = "Invalid subtag: ".concat(strCurrent);
        }
        return languageTag;
    }

    private boolean parseExtensions(StringTokenIterator stringTokenIterator, ParseStatus parseStatus) {
        if (stringTokenIterator.isDone() || parseStatus.isError()) {
            return false;
        }
        boolean z = false;
        while (!stringTokenIterator.isDone()) {
            String strCurrent = stringTokenIterator.current();
            if (!isExtensionSingleton(strCurrent)) {
                break;
            }
            int iCurrentStart = stringTokenIterator.currentStart();
            String lowerCase = strCurrent.toLowerCase();
            StringBuilder sb = new StringBuilder(lowerCase);
            stringTokenIterator.next();
            while (!stringTokenIterator.isDone()) {
                String strCurrent2 = stringTokenIterator.current();
                if (!isExtensionSubtag(strCurrent2)) {
                    break;
                }
                sb.append(SEP);
                sb.append(strCurrent2);
                parseStatus._parseLength = stringTokenIterator.currentEnd();
                stringTokenIterator.next();
            }
            if (parseStatus._parseLength <= iCurrentStart) {
                parseStatus._errorIndex = iCurrentStart;
                parseStatus._errorMsg = cq.v("Incomplete extension '", lowerCase, "'");
                return z;
            }
            if (this._extensions.size() == 0) {
                this._extensions = new ArrayList(4);
            }
            Iterator<String> it = this._extensions.iterator();
            boolean z2 = false;
            while (true) {
                boolean z3 = true;
                if (!it.hasNext()) {
                    break;
                }
                if (it.next().charAt(0) != sb.charAt(0)) {
                    z3 = false;
                }
                z2 |= z3;
            }
            if (!z2) {
                this._extensions.add(sb.toString());
            }
            z = true;
        }
        return z;
    }

    private boolean parseExtlangs(StringTokenIterator stringTokenIterator, ParseStatus parseStatus) {
        boolean z = false;
        if (!stringTokenIterator.isDone() && !parseStatus.isError()) {
            while (!stringTokenIterator.isDone()) {
                String strCurrent = stringTokenIterator.current();
                if (!isExtlang(strCurrent)) {
                    break;
                }
                if (this._extlangs.isEmpty()) {
                    this._extlangs = new ArrayList(3);
                }
                this._extlangs.add(strCurrent);
                parseStatus._parseLength = stringTokenIterator.currentEnd();
                stringTokenIterator.next();
                z = true;
                if (this._extlangs.size() == 3) {
                    break;
                }
            }
        }
        return z;
    }

    private boolean parseLanguage(StringTokenIterator stringTokenIterator, ParseStatus parseStatus) {
        if (!stringTokenIterator.isDone() && !parseStatus.isError()) {
            String strCurrent = stringTokenIterator.current();
            if (isLanguage(strCurrent)) {
                this._language = strCurrent;
                parseStatus._parseLength = stringTokenIterator.currentEnd();
                stringTokenIterator.next();
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:55:0x00e0 A[PHI: r1
      0x00e0: PHI (r1v5 boolean) = (r1v4 boolean), (r1v7 boolean), (r1v7 boolean) binds: [B:28:0x0075, B:41:0x00a9, B:53:0x00d9] A[DONT_GENERATE, DONT_INLINE]] */
    public static LanguageTag parseLocale(BaseLocale baseLocale, LocaleExtensions localeExtensions) {
        boolean z;
        String string;
        LanguageTag languageTag = new LanguageTag();
        String language = baseLocale.getLanguage();
        String script = baseLocale.getScript();
        String region = baseLocale.getRegion();
        String variant = baseLocale.getVariant();
        if (language.length() > 0 && isLanguage(language)) {
            if (language.equals("iw")) {
                language = "he";
            } else if (language.equals("ji")) {
                language = "yi";
            } else if (language.equals("in")) {
                language = "id";
            }
            languageTag._language = language;
        }
        boolean z2 = true;
        if (script.length() <= 0 || !isScript(script)) {
            z = false;
        } else {
            languageTag._script = canonicalizeScript(script);
            z = true;
        }
        if (region.length() > 0 && isRegion(region)) {
            languageTag._region = canonicalizeRegion(region);
            z = true;
        }
        ArrayList arrayList = null;
        if (variant.length() > 0) {
            StringTokenIterator stringTokenIterator = new StringTokenIterator(variant, BaseLocale.SEP);
            ArrayList arrayList2 = null;
            while (!stringTokenIterator.isDone()) {
                String strCurrent = stringTokenIterator.current();
                if (!isVariant(strCurrent)) {
                    break;
                }
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList();
                }
                arrayList2.add(canonicalizeVariant(strCurrent));
                stringTokenIterator.next();
            }
            if (arrayList2 != null) {
                languageTag._variants = arrayList2;
                z = true;
            }
            if (stringTokenIterator.isDone()) {
                string = null;
            } else {
                StringBuilder sb = new StringBuilder();
                while (!stringTokenIterator.isDone()) {
                    String strCurrent2 = stringTokenIterator.current();
                    if (!isPrivateuseSubtag(strCurrent2)) {
                        break;
                    }
                    if (sb.length() > 0) {
                        sb.append(SEP);
                    }
                    sb.append(AsciiUtil.toLowerString(strCurrent2));
                    stringTokenIterator.next();
                }
                if (sb.length() > 0) {
                    string = sb.toString();
                } else {
                    string = null;
                }
            }
        } else {
            string = null;
        }
        String strConcat = null;
        for (Character ch : localeExtensions.getKeys()) {
            Extension extension = localeExtensions.getExtension(ch);
            if (isPrivateusePrefixChar(ch.charValue())) {
                strConcat = extension.getValue();
            } else {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(ch.toString() + SEP + extension.getValue());
            }
        }
        if (arrayList != null) {
            languageTag._extensions = arrayList;
        } else {
            z2 = z;
        }
        if (string != null) {
            strConcat = strConcat == null ? "lvariant-".concat(string) : cq.k(strConcat, "-lvariant-", string.replace(BaseLocale.SEP, SEP));
        }
        if (strConcat != null) {
            languageTag._privateuse = strConcat;
        }
        if (languageTag._language.length() == 0 && (z2 || strConcat == null)) {
            languageTag._language = UNDETERMINED;
        }
        return languageTag;
    }

    private boolean parsePrivateuse(StringTokenIterator stringTokenIterator, ParseStatus parseStatus) {
        if (!stringTokenIterator.isDone() && !parseStatus.isError()) {
            String strCurrent = stringTokenIterator.current();
            if (isPrivateusePrefix(strCurrent)) {
                int iCurrentStart = stringTokenIterator.currentStart();
                StringBuilder sb = new StringBuilder(strCurrent);
                stringTokenIterator.next();
                while (!stringTokenIterator.isDone()) {
                    String strCurrent2 = stringTokenIterator.current();
                    if (!isPrivateuseSubtag(strCurrent2)) {
                        break;
                    }
                    sb.append(SEP);
                    sb.append(strCurrent2);
                    parseStatus._parseLength = stringTokenIterator.currentEnd();
                    stringTokenIterator.next();
                }
                if (parseStatus._parseLength > iCurrentStart) {
                    this._privateuse = sb.toString();
                    return true;
                }
                parseStatus._errorIndex = iCurrentStart;
                parseStatus._errorMsg = "Incomplete privateuse";
                return false;
            }
        }
        return false;
    }

    private boolean parseRegion(StringTokenIterator stringTokenIterator, ParseStatus parseStatus) {
        if (!stringTokenIterator.isDone() && !parseStatus.isError()) {
            String strCurrent = stringTokenIterator.current();
            if (isRegion(strCurrent)) {
                this._region = strCurrent;
                parseStatus._parseLength = stringTokenIterator.currentEnd();
                stringTokenIterator.next();
                return true;
            }
        }
        return false;
    }

    private boolean parseScript(StringTokenIterator stringTokenIterator, ParseStatus parseStatus) {
        if (!stringTokenIterator.isDone() && !parseStatus.isError()) {
            String strCurrent = stringTokenIterator.current();
            if (isScript(strCurrent)) {
                this._script = strCurrent;
                parseStatus._parseLength = stringTokenIterator.currentEnd();
                stringTokenIterator.next();
                return true;
            }
        }
        return false;
    }

    private boolean parseVariants(StringTokenIterator stringTokenIterator, ParseStatus parseStatus) {
        boolean z = false;
        if (!stringTokenIterator.isDone() && !parseStatus.isError()) {
            while (!stringTokenIterator.isDone()) {
                String strCurrent = stringTokenIterator.current();
                if (!isVariant(strCurrent)) {
                    break;
                }
                if (this._variants.isEmpty()) {
                    this._variants = new ArrayList(3);
                }
                String upperCase = strCurrent.toUpperCase();
                if (!this._variants.contains(upperCase)) {
                    this._variants.add(upperCase);
                }
                parseStatus._parseLength = stringTokenIterator.currentEnd();
                stringTokenIterator.next();
                z = true;
            }
        }
        return z;
    }

    public List<String> getExtensions() {
        return Collections.unmodifiableList(this._extensions);
    }

    public List<String> getExtlangs() {
        return Collections.unmodifiableList(this._extlangs);
    }

    public String getLanguage() {
        return this._language;
    }

    public String getPrivateuse() {
        return this._privateuse;
    }

    public String getRegion() {
        return this._region;
    }

    public String getScript() {
        return this._script;
    }

    public List<String> getVariants() {
        return Collections.unmodifiableList(this._variants);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this._language.length() > 0) {
            sb.append(this._language);
            for (String str : this._extlangs) {
                sb.append(SEP);
                sb.append(str);
            }
            if (this._script.length() > 0) {
                sb.append(SEP);
                sb.append(this._script);
            }
            if (this._region.length() > 0) {
                sb.append(SEP);
                sb.append(this._region);
            }
            for (String str2 : this._variants) {
                sb.append(SEP);
                sb.append(str2);
            }
            for (String str3 : this._extensions) {
                sb.append(SEP);
                sb.append(str3);
            }
        }
        if (this._privateuse.length() > 0) {
            if (sb.length() > 0) {
                sb.append(SEP);
            }
            sb.append(this._privateuse);
        }
        return sb.toString();
    }
}
