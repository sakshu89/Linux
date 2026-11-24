package com.ibm.icu.impl.locale;

import com.ibm.icu.impl.ValidIdentifiers;
import com.ibm.icu.text.DateFormat;
import com.ibm.icu.util.IllformedLocaleException;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.ULocale;
import defpackage.ky0;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class LocaleValidityChecker {
    private final boolean allowsDeprecated;
    private final Set<ValidIdentifiers.Datasubtype> datasubtypes;
    static Pattern SEPARATOR = Pattern.compile("[-_]");
    private static final Pattern VALID_X = Pattern.compile("[a-zA-Z0-9]{2,8}(-[a-zA-Z0-9]{2,8})*");
    static final Set<String> REORDERING_INCLUDE = new HashSet(Arrays.asList("space", "punct", "symbol", "currency", "digit", "others", DateFormat.SPECIFIC_TZ));
    static final Set<String> REORDERING_EXCLUDE = new HashSet(Arrays.asList("zinh", "zyyy"));
    static final Set<ValidIdentifiers.Datasubtype> REGULAR_ONLY = EnumSet.of(ValidIdentifiers.Datasubtype.regular);

    /* JADX INFO: renamed from: com.ibm.icu.impl.locale.LocaleValidityChecker$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$ValidIdentifiers$Datatype;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$locale$KeyTypeData$ValueType;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$locale$LocaleValidityChecker$SpecialCase;

        static {
            int[] iArr = new int[SpecialCase.values().length];
            $SwitchMap$com$ibm$icu$impl$locale$LocaleValidityChecker$SpecialCase = iArr;
            try {
                iArr[SpecialCase.anything.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$locale$LocaleValidityChecker$SpecialCase[SpecialCase.codepoints.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$locale$LocaleValidityChecker$SpecialCase[SpecialCase.reorder.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$locale$LocaleValidityChecker$SpecialCase[SpecialCase.subdivision.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$locale$LocaleValidityChecker$SpecialCase[SpecialCase.rgKey.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            int[] iArr2 = new int[KeyTypeData.ValueType.values().length];
            $SwitchMap$com$ibm$icu$impl$locale$KeyTypeData$ValueType = iArr2;
            try {
                iArr2[KeyTypeData.ValueType.single.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$locale$KeyTypeData$ValueType[KeyTypeData.ValueType.incremental.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$locale$KeyTypeData$ValueType[KeyTypeData.ValueType.multiple.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr3 = new int[ValidIdentifiers.Datatype.values().length];
            $SwitchMap$com$ibm$icu$impl$ValidIdentifiers$Datatype = iArr3;
            try {
                iArr3[ValidIdentifiers.Datatype.x.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$ValidIdentifiers$Datatype[ValidIdentifiers.Datatype.t.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$ValidIdentifiers$Datatype[ValidIdentifiers.Datatype.u.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum SpecialCase {
        normal,
        anything,
        reorder,
        codepoints,
        subdivision,
        rgKey;

        public static SpecialCase get(String str) {
            if (str.equals("kr")) {
                return reorder;
            }
            if (str.equals("vt")) {
                return codepoints;
            }
            if (str.equals("sd")) {
                return subdivision;
            }
            if (str.equals("rg")) {
                return rgKey;
            }
            return str.equals("x0") ? anything : normal;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Where {
        public String codeFailure;
        public ValidIdentifiers.Datatype fieldFailure;

        public boolean set(ValidIdentifiers.Datatype datatype, String str) {
            this.fieldFailure = datatype;
            this.codeFailure = str;
            return false;
        }

        public String toString() {
            ValidIdentifiers.Datatype datatype = this.fieldFailure;
            return datatype == null ? "OK" : ky0.l("{", String.valueOf(datatype), ", ", this.codeFailure, "}");
        }
    }

    public LocaleValidityChecker(ValidIdentifiers.Datasubtype... datasubtypeArr) {
        EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) Arrays.asList(datasubtypeArr));
        this.datasubtypes = enumSetCopyOf;
        this.allowsDeprecated = enumSetCopyOf.contains(ValidIdentifiers.Datasubtype.deprecated);
    }

    private boolean isScriptReorder(String str) {
        String lowerString = AsciiUtil.toLowerString(str);
        if (REORDERING_INCLUDE.contains(lowerString)) {
            return true;
        }
        return (REORDERING_EXCLUDE.contains(lowerString) || ValidIdentifiers.isValid(ValidIdentifiers.Datatype.script, REGULAR_ONLY, lowerString) == null) ? false : true;
    }

    private boolean isSubdivision(ULocale uLocale, String str) {
        if (str.length() < 3) {
            return false;
        }
        String strSubstring = str.substring(0, str.charAt(0) > '9' ? 2 : 3);
        if (ValidIdentifiers.isValid(ValidIdentifiers.Datatype.subdivision, this.datasubtypes, strSubstring, str.substring(strSubstring.length())) == null) {
            return false;
        }
        String country = uLocale.getCountry();
        if (country.isEmpty()) {
            country = ULocale.addLikelySubtags(uLocale).getCountry();
        }
        return strSubstring.equalsIgnoreCase(country);
    }

    private boolean isValidLocale(String str, Where where) {
        try {
            return isValid(new ULocale.Builder().setLanguageTag(str).build(), where);
        } catch (IllformedLocaleException e) {
            return where.set(ValidIdentifiers.Datatype.t, SEPARATOR.split(str.substring(e.getErrorIndex()))[0]);
        } catch (Exception e2) {
            return where.set(ValidIdentifiers.Datatype.t, e2.getMessage());
        }
    }

    private boolean isValidU(ULocale uLocale, ValidIdentifiers.Datatype datatype, String str, Where where) {
        StringBuilder sb;
        StringBuilder sb2 = new StringBuilder();
        HashSet hashSet = new HashSet();
        StringBuilder sb3 = datatype == ValidIdentifiers.Datatype.t ? new StringBuilder() : null;
        String[] strArrSplit = SEPARATOR.split(str);
        int length = strArrSplit.length;
        String bcpKey = "";
        int i = 0;
        int i2 = 0;
        KeyTypeData.ValueType valueType = null;
        SpecialCase specialCase = null;
        while (i < length) {
            String string = strArrSplit[i];
            if (string.length() != 2 || (sb3 != null && string.charAt(1) > '9')) {
                if (sb3 != null) {
                    if (sb3.length() != 0) {
                        sb3.append('-');
                    }
                    sb3.append(string);
                } else {
                    i2++;
                    int i3 = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$locale$KeyTypeData$ValueType[valueType.ordinal()];
                    StringBuilder sb4 = sb3;
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3 && i2 == 1) {
                                hashSet.clear();
                            }
                        } else if (i2 == 1) {
                            sb2.setLength(0);
                            sb2.append(string);
                        } else {
                            sb2.append('-');
                            sb2.append(string);
                            string = sb2.toString();
                        }
                    } else if (i2 > 1) {
                        return where.set(datatype, bcpKey + LanguageTag.SEP + string);
                    }
                    int i4 = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$locale$LocaleValidityChecker$SpecialCase[specialCase.ordinal()];
                    if (i4 != 1) {
                        if (i4 != 2) {
                            sb = sb2;
                            if (i4 == 3) {
                                if (!hashSet.add(string.equals(DateFormat.SPECIFIC_TZ) ? "others" : string) || !isScriptReorder(string)) {
                                    return where.set(datatype, bcpKey + LanguageTag.SEP + string);
                                }
                            } else if (i4 != 4) {
                                if (i4 != 5) {
                                    if (KeyTypeData.toBcpType(bcpKey, string, new Output(), new Output()) == null) {
                                        return where.set(datatype, bcpKey + LanguageTag.SEP + string);
                                    }
                                    if (!this.allowsDeprecated && KeyTypeData.isDeprecated(bcpKey, string)) {
                                        return where.set(datatype, bcpKey + LanguageTag.SEP + string);
                                    }
                                } else {
                                    if (string.length() < 6 || !string.endsWith(DateFormat.SPECIFIC_TZ)) {
                                        return where.set(datatype, string);
                                    }
                                    if (!isValid(ValidIdentifiers.Datatype.region, string.substring(0, string.length() - 4), where)) {
                                        return false;
                                    }
                                }
                            } else if (!isSubdivision(uLocale, string)) {
                                return where.set(datatype, bcpKey + LanguageTag.SEP + string);
                            }
                        } else {
                            sb = sb2;
                            try {
                                if (Integer.parseInt(string, 16) > 1114111) {
                                    return where.set(datatype, bcpKey + LanguageTag.SEP + string);
                                }
                            } catch (NumberFormatException unused) {
                                return where.set(datatype, bcpKey + LanguageTag.SEP + string);
                            }
                        }
                        sb3 = sb4;
                    } else {
                        sb = sb2;
                    }
                    sb3 = sb4;
                }
                i++;
                sb2 = sb;
            } else {
                if (sb3 != null) {
                    if (sb3.length() != 0 && !isValidLocale(sb3.toString(), where)) {
                        return false;
                    }
                    sb3 = null;
                }
                bcpKey = KeyTypeData.toBcpKey(string);
                if (bcpKey == null) {
                    return where.set(datatype, string);
                }
                if (!this.allowsDeprecated && KeyTypeData.isDeprecated(bcpKey)) {
                    return where.set(datatype, bcpKey);
                }
                valueType = KeyTypeData.getValueType(bcpKey);
                specialCase = SpecialCase.get(bcpKey);
                i2 = 0;
            }
            sb = sb2;
            i++;
            sb2 = sb;
        }
        StringBuilder sb5 = sb3;
        return sb5 == null || sb5.length() == 0 || isValidLocale(sb5.toString(), where);
    }

    public Set<ValidIdentifiers.Datasubtype> getDatasubtypes() {
        return EnumSet.copyOf((Collection) this.datasubtypes);
    }

    public boolean isValid(ULocale uLocale, Where where) {
        where.set(null, null);
        String language = uLocale.getLanguage();
        String script = uLocale.getScript();
        String country = uLocale.getCountry();
        String variant = uLocale.getVariant();
        Set<Character> extensionKeys = uLocale.getExtensionKeys();
        if (!isValid(ValidIdentifiers.Datatype.language, language, where)) {
            if (!language.equals(LanguageTag.PRIVATEUSE)) {
                return false;
            }
            where.set(null, null);
            return true;
        }
        if (!isValid(ValidIdentifiers.Datatype.script, script, where) || !isValid(ValidIdentifiers.Datatype.region, country, where)) {
            return false;
        }
        if (!variant.isEmpty()) {
            for (String str : SEPARATOR.split(variant)) {
                if (!isValid(ValidIdentifiers.Datatype.variant, str, where)) {
                    return false;
                }
            }
        }
        for (Character ch : extensionKeys) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(ch);
                ValidIdentifiers.Datatype datatypeValueOf = ValidIdentifiers.Datatype.valueOf(sb.toString());
                int i = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$ValidIdentifiers$Datatype[datatypeValueOf.ordinal()];
                if (i == 1) {
                    return true;
                }
                if (i == 2 || i == 3) {
                    if (!isValidU(uLocale, datatypeValueOf, uLocale.getExtension(ch.charValue()), where)) {
                        return false;
                    }
                }
            } catch (Exception unused) {
                ValidIdentifiers.Datatype datatype = ValidIdentifiers.Datatype.illegal;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(ch);
                return where.set(datatype, sb2.toString());
            }
        }
        return true;
    }

    public LocaleValidityChecker(Set<ValidIdentifiers.Datasubtype> set) {
        this.datasubtypes = EnumSet.copyOf((Collection) set);
        this.allowsDeprecated = set.contains(ValidIdentifiers.Datasubtype.deprecated);
    }

    private boolean isValid(ValidIdentifiers.Datatype datatype, String str, Where where) {
        if (str.isEmpty()) {
            return true;
        }
        if ((datatype == ValidIdentifiers.Datatype.variant && "posix".equalsIgnoreCase(str)) || ValidIdentifiers.isValid(datatype, this.datasubtypes, str) != null) {
            return true;
        }
        if (where == null) {
            return false;
        }
        return where.set(datatype, str);
    }
}
