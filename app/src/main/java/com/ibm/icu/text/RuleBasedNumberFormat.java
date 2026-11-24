package com.ibm.icu.text;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUDebug;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.text.RbnfScannerProviderImpl;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.math.BigDecimal;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import defpackage.ky0;
import defpackage.og;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class RuleBasedNumberFormat extends NumberFormat implements Cloneable {

    @Deprecated
    public static final int DURATION = 3;
    public static final int NUMBERING_SYSTEM = 4;
    public static final int ORDINAL = 2;
    public static final int SPELLOUT = 1;
    private static final long serialVersionUID = -7664252765575395068L;
    private transient BreakIterator capitalizationBrkIter;
    private boolean capitalizationForListOrMenu;
    private boolean capitalizationForStandAlone;
    private boolean capitalizationInfoIsSet;
    transient byte caseFoldOption;
    private transient DecimalFormat decimalFormat;
    private transient DecimalFormatSymbols decimalFormatSymbols;
    private transient NFRule defaultInfinityRule;
    private transient NFRule defaultNaNRule;
    private transient NFRuleSet defaultRuleSet;
    private boolean lenientParse;
    private transient String lenientParseRules;
    private ULocale locale;
    private transient boolean lookedForScanner;
    private transient String postProcessRules;
    private transient RBNFPostProcessor postProcessor;
    private String[] publicRuleSetNames;
    private int roundingMode;
    private Map<String, String[]> ruleSetDisplayNames;
    private transient NFRuleSet[] ruleSets;
    private transient Map<String, NFRuleSet> ruleSetsMap;
    private transient RbnfLenientScannerProvider scannerProvider;
    transient boolean unparseable;
    private static final boolean DEBUG = ICUDebug.enabled("rbnf");
    private static final String[] rulenames = {"SpelloutRules", "OrdinalRules", "DurationRules", "NumberingSystemRules"};
    private static final String[] locnames = {"SpelloutLocalizations", "OrdinalLocalizations", "DurationLocalizations", "NumberingSystemLocalizations"};
    private static final BigDecimal MAX_VALUE = BigDecimal.valueOf(Long.MAX_VALUE);
    private static final BigDecimal MIN_VALUE = BigDecimal.valueOf(Long.MIN_VALUE);

    public RuleBasedNumberFormat(ULocale uLocale, int i) {
        String stringWithFallback;
        String[][] strArr = null;
        this.ruleSets = null;
        this.ruleSetsMap = null;
        this.defaultRuleSet = null;
        this.roundingMode = 7;
        this.scannerProvider = null;
        this.decimalFormatSymbols = null;
        this.decimalFormat = null;
        this.defaultInfinityRule = null;
        this.defaultNaNRule = null;
        this.lenientParse = false;
        this.caseFoldOption = (byte) 0;
        this.unparseable = false;
        this.capitalizationInfoIsSet = false;
        this.capitalizationForListOrMenu = false;
        this.capitalizationForStandAlone = false;
        this.capitalizationBrkIter = null;
        this.locale = uLocale;
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_RBNF_BASE_NAME, uLocale);
        ULocale uLocale2 = iCUResourceBundle.getULocale();
        setLocale(uLocale2, uLocale2);
        try {
            stringWithFallback = iCUResourceBundle.getStringWithFallback("RBNFRules/" + rulenames[i - 1]);
        } catch (MissingResourceException unused) {
            stringWithFallback = "";
        }
        ICUResourceBundle iCUResourceBundleFindTopLevel = iCUResourceBundle.findTopLevel(locnames[i - 1]);
        if (iCUResourceBundleFindTopLevel != null) {
            int size = iCUResourceBundleFindTopLevel.getSize();
            strArr = new String[size][];
            for (int i2 = 0; i2 < size; i2++) {
                strArr[i2] = iCUResourceBundleFindTopLevel.get(i2).getStringArray();
            }
        }
        init(stringWithFallback, strArr);
    }

    private String adjustForContext(String str) {
        DisplayContext context = getContext(DisplayContext.Type.CAPITALIZATION);
        if (context == DisplayContext.CAPITALIZATION_NONE || str == null || str.length() <= 0 || !UCharacter.isLowerCase(str.codePointAt(0)) || !(context == DisplayContext.CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE || ((context == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU && this.capitalizationForListOrMenu) || (context == DisplayContext.CAPITALIZATION_FOR_STANDALONE && this.capitalizationForStandAlone)))) {
            return str;
        }
        if (this.capitalizationBrkIter == null) {
            this.capitalizationBrkIter = BreakIterator.getSentenceInstance(this.locale);
        }
        return UCharacter.toTitleCase(this.locale, str, this.capitalizationBrkIter.mo5clone(), 768);
    }

    private static String extractSpecial(StringBuilder sb, String str) {
        int iIndexOf = sb.indexOf(str);
        if (iIndexOf == -1) {
            return null;
        }
        if (iIndexOf != 0 && sb.charAt(iIndexOf - 1) != ';') {
            return null;
        }
        int iIndexOf2 = sb.indexOf(";%", iIndexOf);
        if (iIndexOf2 == -1) {
            iIndexOf2 = sb.length() - 1;
        }
        int length = str.length() + iIndexOf;
        while (length < iIndexOf2 && PatternProps.isWhiteSpace(sb.charAt(length))) {
            length++;
        }
        String strSubstring = sb.substring(length, iIndexOf2);
        sb.delete(iIndexOf, iIndexOf2 + 1);
        return strSubstring;
    }

    private String format(double d, NFRuleSet nFRuleSet) {
        StringBuilder sb = new StringBuilder();
        if (getRoundingMode() != 7 && !Double.isNaN(d) && !Double.isInfinite(d)) {
            d = new BigDecimal(Double.toString(d)).setScale(getMaximumFractionDigits(), this.roundingMode).doubleValue();
        }
        nFRuleSet.format(d, sb, 0, 0);
        postProcess(sb, nFRuleSet);
        return sb.toString();
    }

    private String[] getNameListForLocale(ULocale uLocale) {
        if (uLocale == null || this.ruleSetDisplayNames == null) {
            return null;
        }
        String[] strArr = {uLocale.getBaseName(), ULocale.getDefault(ULocale.Category.DISPLAY).getBaseName()};
        for (int i = 0; i < 2; i++) {
            for (String fallback = strArr[i]; fallback.length() > 0; fallback = ULocale.getFallback(fallback)) {
                String[] strArr2 = this.ruleSetDisplayNames.get(fallback);
                if (strArr2 != null) {
                    return strArr2;
                }
            }
        }
        return null;
    }

    private void init(String str, String[][] strArr) {
        NFRuleSet[] nFRuleSetArr;
        NFRuleSet[] nFRuleSetArr2;
        initLocalizations(strArr);
        String language = this.locale.getLanguage();
        this.caseFoldOption = (byte) (("tr".equals(language) || "az".equals(language)) ? 1 : 0);
        StringBuilder sbStripWhitespace = stripWhitespace(str);
        this.lenientParseRules = extractSpecial(sbStripWhitespace, "%%lenient-parse:");
        this.postProcessRules = extractSpecial(sbStripWhitespace, "%%post-process:");
        int i = 0;
        int i2 = 1;
        while (true) {
            int iIndexOf = sbStripWhitespace.indexOf(";%", i);
            if (iIndexOf == -1) {
                break;
            }
            i2++;
            i = iIndexOf + 2;
        }
        this.ruleSets = new NFRuleSet[i2];
        this.ruleSetsMap = new HashMap((i2 * 2) + 1);
        this.defaultRuleSet = null;
        String[] strArr2 = new String[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            nFRuleSetArr = this.ruleSets;
            if (i3 >= nFRuleSetArr.length) {
                break;
            }
            int iIndexOf2 = sbStripWhitespace.indexOf(";%", i4);
            if (iIndexOf2 < 0) {
                iIndexOf2 = sbStripWhitespace.length() - 1;
            }
            int i6 = iIndexOf2 + 1;
            strArr2[i3] = sbStripWhitespace.substring(i4, i6);
            NFRuleSet nFRuleSet = new NFRuleSet(this, strArr2, i3);
            this.ruleSets[i3] = nFRuleSet;
            String name = nFRuleSet.getName();
            this.ruleSetsMap.put(name, nFRuleSet);
            if (!name.startsWith("%%")) {
                i5++;
                if ((this.defaultRuleSet == null && name.equals("%spellout-numbering")) || name.equals("%digits-ordinal") || name.equals("%duration")) {
                    this.defaultRuleSet = nFRuleSet;
                }
            }
            i3++;
            i4 = i6;
        }
        if (this.defaultRuleSet == null) {
            for (int length = nFRuleSetArr.length - 1; length >= 0; length--) {
                if (!this.ruleSets[length].getName().startsWith("%%")) {
                    this.defaultRuleSet = this.ruleSets[length];
                    break;
                }
            }
        }
        if (this.defaultRuleSet == null) {
            NFRuleSet[] nFRuleSetArr3 = this.ruleSets;
            this.defaultRuleSet = nFRuleSetArr3[nFRuleSetArr3.length - 1];
        }
        int i7 = 0;
        while (true) {
            nFRuleSetArr2 = this.ruleSets;
            if (i7 >= nFRuleSetArr2.length) {
                break;
            }
            nFRuleSetArr2[i7].parseRules(strArr2[i7]);
            i7++;
        }
        String[] strArr3 = new String[i5];
        int i8 = 0;
        for (int length2 = nFRuleSetArr2.length - 1; length2 >= 0; length2--) {
            if (!this.ruleSets[length2].getName().startsWith("%%")) {
                strArr3[i8] = this.ruleSets[length2].getName();
                i8++;
            }
        }
        if (this.publicRuleSetNames == null) {
            this.publicRuleSetNames = strArr3;
            return;
        }
        int i9 = 0;
        while (true) {
            String[] strArr4 = this.publicRuleSetNames;
            if (i9 >= strArr4.length) {
                this.defaultRuleSet = findRuleSet(strArr4[0]);
                return;
            }
            String str2 = strArr4[i9];
            int i10 = 0;
            while (true) {
                if (i10 >= i5) {
                    og.i(cq.j("did not find public rule set: ", str2));
                    return;
                } else if (str2.equals(strArr3[i10])) {
                    break;
                } else {
                    i10++;
                }
            }
            i9++;
        }
    }

    private void initCapitalizationContextInfo(ULocale uLocale) {
        try {
            int[] intVector = ((ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, uLocale)).getWithFallback("contextTransforms/number-spellout").getIntVector();
            if (intVector.length >= 2) {
                this.capitalizationForListOrMenu = intVector[0] != 0;
                this.capitalizationForStandAlone = intVector[1] != 0;
            }
        } catch (MissingResourceException unused) {
        }
    }

    private void initLocalizations(String[][] strArr) {
        if (strArr != null) {
            this.publicRuleSetNames = (String[]) strArr[0].clone();
            HashMap map = new HashMap();
            for (int i = 1; i < strArr.length; i++) {
                String[] strArr2 = strArr[i];
                String str = strArr2[0];
                int length = strArr2.length - 1;
                String[] strArr3 = new String[length];
                String[] strArr4 = this.publicRuleSetNames;
                if (length != strArr4.length) {
                    og.e(length, cq.p("public name length: ", strArr4.length, " != localized names[", i, "] length: "));
                    return;
                } else {
                    System.arraycopy(strArr2, 1, strArr3, 0, length);
                    map.put(str, strArr3);
                }
            }
            if (map.isEmpty()) {
                return;
            }
            this.ruleSetDisplayNames = map;
        }
    }

    private void initializeLenientScannerProvider() {
        if (this.scannerProvider != null || this.lookedForScanner) {
            return;
        }
        try {
            this.lookedForScanner = true;
            int i = RbnfScannerProviderImpl.a;
            setLenientScannerProvider((RbnfLenientScannerProvider) RbnfScannerProviderImpl.class.newInstance());
        } catch (Exception unused) {
        }
    }

    private void postProcess(StringBuilder sb, NFRuleSet nFRuleSet) {
        String str = this.postProcessRules;
        if (str != null) {
            if (this.postProcessor == null) {
                int iIndexOf = str.indexOf(";");
                if (iIndexOf == -1) {
                    iIndexOf = this.postProcessRules.length();
                }
                String strTrim = this.postProcessRules.substring(0, iIndexOf).trim();
                try {
                    RBNFPostProcessor rBNFPostProcessor = (RBNFPostProcessor) Class.forName(strTrim).newInstance();
                    this.postProcessor = rBNFPostProcessor;
                    rBNFPostProcessor.init(this, this.postProcessRules);
                } catch (Exception e) {
                    if (DEBUG) {
                        PrintStream printStream = System.out;
                        String name = e.getClass().getName();
                        String message = e.getMessage();
                        StringBuilder sbQ = cq.q("could not locate ", strTrim, ", error ", name, ", ");
                        sbQ.append(message);
                        printStream.println(sbQ.toString());
                    }
                    this.postProcessor = null;
                    this.postProcessRules = null;
                    return;
                }
            }
            this.postProcessor.process(sb, nFRuleSet);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException {
        ULocale uLocale;
        String utf = objectInputStream.readUTF();
        try {
            uLocale = (ULocale) objectInputStream.readObject();
        } catch (Exception unused) {
            uLocale = ULocale.getDefault(ULocale.Category.FORMAT);
        }
        try {
            this.roundingMode = objectInputStream.readInt();
        } catch (Exception unused2) {
        }
        RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(utf, uLocale);
        this.ruleSets = ruleBasedNumberFormat.ruleSets;
        this.ruleSetsMap = ruleBasedNumberFormat.ruleSetsMap;
        this.defaultRuleSet = ruleBasedNumberFormat.defaultRuleSet;
        this.publicRuleSetNames = ruleBasedNumberFormat.publicRuleSetNames;
        this.decimalFormatSymbols = ruleBasedNumberFormat.decimalFormatSymbols;
        this.decimalFormat = ruleBasedNumberFormat.decimalFormat;
        this.locale = ruleBasedNumberFormat.locale;
        this.defaultInfinityRule = ruleBasedNumberFormat.defaultInfinityRule;
        this.defaultNaNRule = ruleBasedNumberFormat.defaultNaNRule;
    }

    /* JADX WARN: Code duplicated, block: B:21:0x003b  */
    private StringBuilder stripWhitespace(String str) {
        int i;
        int length = str.length();
        if (length > 0) {
            char cCharAt = str.charAt(0);
            if (PatternProps.isWhiteSpace(cCharAt) || cCharAt == ';') {
                i = 0;
            } else {
                int i2 = 0;
                while (true) {
                    if (i2 >= length - 1) {
                        i = 0;
                        break;
                    }
                    if (str.charAt(i2) == ';') {
                        i = i2 + 1;
                        char cCharAt2 = str.charAt(i);
                        if (PatternProps.isWhiteSpace(cCharAt2) || cCharAt2 == ';') {
                            break;
                        }
                    }
                    i2++;
                }
                if (i == 0) {
                    return new StringBuilder(str);
                }
            }
        } else {
            i = 0;
        }
        StringBuilder sb = new StringBuilder(str.substring(0, i));
        while (i < length) {
            while (i < length) {
                char cCharAt3 = str.charAt(i);
                if (!PatternProps.isWhiteSpace(cCharAt3) && cCharAt3 != ';') {
                    break;
                }
                i++;
            }
            int iIndexOf = str.indexOf(59, i);
            if (iIndexOf == -1) {
                sb.append((CharSequence) str, i, length);
                return sb;
            }
            if (iIndexOf < length) {
                int i3 = iIndexOf + 1;
                sb.append((CharSequence) str, i, i3);
                i = i3;
            }
        }
        return sb;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeUTF(toString());
        objectOutputStream.writeObject(this.locale);
        objectOutputStream.writeInt(this.roundingMode);
    }

    @Override // com.ibm.icu.text.NumberFormat, java.text.Format
    public RuleBasedNumberFormat clone() {
        return (RuleBasedNumberFormat) super.clone();
    }

    public PluralFormat createPluralFormat(PluralRules.PluralType pluralType, String str) {
        return new PluralFormat(this.locale, pluralType, str, getDecimalFormat());
    }

    @Override // com.ibm.icu.text.NumberFormat
    public boolean equals(Object obj) {
        if (!(obj instanceof RuleBasedNumberFormat)) {
            return false;
        }
        RuleBasedNumberFormat ruleBasedNumberFormat = (RuleBasedNumberFormat) obj;
        if (!this.locale.equals(ruleBasedNumberFormat.locale) || this.lenientParse != ruleBasedNumberFormat.lenientParse || this.ruleSets.length != ruleBasedNumberFormat.ruleSets.length) {
            return false;
        }
        int i = 0;
        while (true) {
            NFRuleSet[] nFRuleSetArr = this.ruleSets;
            if (i >= nFRuleSetArr.length) {
                return true;
            }
            if (!nFRuleSetArr[i].equals(ruleBasedNumberFormat.ruleSets[i])) {
                return false;
            }
            i++;
        }
    }

    public NFRuleSet findRuleSet(String str) {
        NFRuleSet nFRuleSet = this.ruleSetsMap.get(str);
        if (nFRuleSet != null) {
            return nFRuleSet;
        }
        og.i(cq.j("No rule set named ", str));
        return null;
    }

    public DecimalFormat getDecimalFormat() {
        if (this.decimalFormat == null) {
            this.decimalFormat = new DecimalFormat(NumberFormat.getPattern(this.locale, 0), getDecimalFormatSymbols());
        }
        return this.decimalFormat;
    }

    public DecimalFormatSymbols getDecimalFormatSymbols() {
        if (this.decimalFormatSymbols == null) {
            this.decimalFormatSymbols = new DecimalFormatSymbols(this.locale);
        }
        return this.decimalFormatSymbols;
    }

    public NFRule getDefaultInfinityRule() {
        if (this.defaultInfinityRule == null) {
            this.defaultInfinityRule = new NFRule(this, cq.j("Inf: ", getDecimalFormatSymbols().getInfinity()));
        }
        return this.defaultInfinityRule;
    }

    public NFRule getDefaultNaNRule() {
        if (this.defaultNaNRule == null) {
            this.defaultNaNRule = new NFRule(this, cq.j("NaN: ", getDecimalFormatSymbols().getNaN()));
        }
        return this.defaultNaNRule;
    }

    public NFRuleSet getDefaultRuleSet() {
        return this.defaultRuleSet;
    }

    public String getDefaultRuleSetName() {
        NFRuleSet nFRuleSet = this.defaultRuleSet;
        return (nFRuleSet == null || !nFRuleSet.isPublic()) ? "" : this.defaultRuleSet.getName();
    }

    public RbnfLenientScanner getLenientScanner() {
        String str;
        RbnfLenientScannerProvider lenientScannerProvider;
        if (!this.lenientParse || (str = this.lenientParseRules) == null || str.isEmpty() || (lenientScannerProvider = getLenientScannerProvider()) == null) {
            return null;
        }
        return lenientScannerProvider.get(this.locale, this.lenientParseRules);
    }

    public RbnfLenientScannerProvider getLenientScannerProvider() {
        if (this.scannerProvider == null && this.lenientParse && !this.lookedForScanner) {
            initializeLenientScannerProvider();
        }
        return this.scannerProvider;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public int getRoundingMode() {
        return this.roundingMode;
    }

    public String getRuleSetDisplayName(String str, ULocale uLocale) {
        String[] strArr = this.publicRuleSetNames;
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                String[] nameListForLocale = getNameListForLocale(uLocale);
                return nameListForLocale != null ? nameListForLocale[i] : strArr[i].substring(1);
            }
        }
        og.i(cq.j("unrecognized rule set name: ", str));
        return null;
    }

    public ULocale[] getRuleSetDisplayNameLocales() {
        Map<String, String[]> map = this.ruleSetDisplayNames;
        if (map == null) {
            return null;
        }
        Set<String> setKeySet = map.keySet();
        String[] strArr = (String[]) setKeySet.toArray(new String[setKeySet.size()]);
        Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER);
        ULocale[] uLocaleArr = new ULocale[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            uLocaleArr[i] = new ULocale(strArr[i]);
        }
        return uLocaleArr;
    }

    public String[] getRuleSetDisplayNames(ULocale uLocale) {
        String[] nameListForLocale = getNameListForLocale(uLocale);
        if (nameListForLocale != null) {
            return (String[]) nameListForLocale.clone();
        }
        String[] ruleSetNames = getRuleSetNames();
        for (int i = 0; i < ruleSetNames.length; i++) {
            ruleSetNames[i] = ruleSetNames[i].substring(1);
        }
        return ruleSetNames;
    }

    public String[] getRuleSetNames() {
        return (String[]) this.publicRuleSetNames.clone();
    }

    @Override // com.ibm.icu.text.NumberFormat
    public int hashCode() {
        return super.hashCode();
    }

    public boolean lenientParseEnabled() {
        return this.lenientParse;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public Number parse(String str, ParsePosition parsePosition) {
        if (this.unparseable) {
            og.i("Rules do not allow parsing");
            return null;
        }
        String strSubstring = str.substring(parsePosition.getIndex());
        ParsePosition parsePosition2 = new ParsePosition(0);
        Number number = NFRule.ZERO;
        ParsePosition parsePosition3 = new ParsePosition(parsePosition2.getIndex());
        for (int length = this.ruleSets.length - 1; length >= 0; length--) {
            if (this.ruleSets[length].isPublic() && this.ruleSets[length].isParseable()) {
                Number number2 = this.ruleSets[length].parse(strSubstring, parsePosition2, Double.MAX_VALUE, 0, 0);
                if (parsePosition2.getIndex() > parsePosition3.getIndex()) {
                    parsePosition3.setIndex(parsePosition2.getIndex());
                    number = number2;
                }
                if (parsePosition2.getErrorIndex() > parsePosition3.getErrorIndex()) {
                    parsePosition3.setErrorIndex(parsePosition2.getErrorIndex());
                }
                if (parsePosition3.getIndex() == strSubstring.length()) {
                    break;
                }
                parsePosition2.setIndex(0);
            }
        }
        parsePosition.setIndex(parsePosition3.getIndex() + parsePosition.getIndex());
        if (parsePosition3.getIndex() == 0) {
            parsePosition.setErrorIndex(parsePosition3.getErrorIndex() + parsePosition.getIndex());
        }
        return number;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public void setContext(DisplayContext displayContext) {
        super.setContext(displayContext);
        if (!this.capitalizationInfoIsSet && (displayContext == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU || displayContext == DisplayContext.CAPITALIZATION_FOR_STANDALONE)) {
            initCapitalizationContextInfo(this.locale);
            this.capitalizationInfoIsSet = true;
        }
        if (this.capitalizationBrkIter == null) {
            if (displayContext == DisplayContext.CAPITALIZATION_FOR_BEGINNING_OF_SENTENCE || ((displayContext == DisplayContext.CAPITALIZATION_FOR_UI_LIST_OR_MENU && this.capitalizationForListOrMenu) || (displayContext == DisplayContext.CAPITALIZATION_FOR_STANDALONE && this.capitalizationForStandAlone))) {
                this.capitalizationBrkIter = BreakIterator.getSentenceInstance(this.locale);
            }
        }
    }

    public void setDecimalFormatSymbols(DecimalFormatSymbols decimalFormatSymbols) {
        if (decimalFormatSymbols != null) {
            DecimalFormatSymbols decimalFormatSymbolsM17clone = decimalFormatSymbols.m17clone();
            this.decimalFormatSymbols = decimalFormatSymbolsM17clone;
            DecimalFormat decimalFormat = this.decimalFormat;
            if (decimalFormat != null) {
                decimalFormat.setDecimalFormatSymbols(decimalFormatSymbolsM17clone);
            }
            if (this.defaultInfinityRule != null) {
                this.defaultInfinityRule = null;
                getDefaultInfinityRule();
            }
            if (this.defaultNaNRule != null) {
                this.defaultNaNRule = null;
                getDefaultNaNRule();
            }
            for (NFRuleSet nFRuleSet : this.ruleSets) {
                nFRuleSet.setDecimalFormatSymbols(this.decimalFormatSymbols);
            }
        }
    }

    public void setDefaultRuleSet(String str) {
        String name;
        if (str != null) {
            if (str.startsWith("%%")) {
                og.i("cannot use private rule set: ".concat(str));
                return;
            } else {
                this.defaultRuleSet = findRuleSet(str);
                return;
            }
        }
        String[] strArr = this.publicRuleSetNames;
        if (strArr.length > 0) {
            this.defaultRuleSet = findRuleSet(strArr[0]);
            return;
        }
        this.defaultRuleSet = null;
        int length = this.ruleSets.length;
        do {
            length--;
            NFRuleSet[] nFRuleSetArr = this.ruleSets;
            if (length < 0) {
                int length2 = nFRuleSetArr.length;
                do {
                    length2--;
                    if (length2 < 0) {
                        return;
                    }
                } while (!this.ruleSets[length2].isPublic());
                this.defaultRuleSet = this.ruleSets[length2];
                return;
            }
            name = nFRuleSetArr[length].getName();
            if (name.equals("%spellout-numbering") || name.equals("%digits-ordinal")) {
                break;
            }
        } while (!name.equals("%duration"));
        this.defaultRuleSet = this.ruleSets[length];
    }

    public void setLenientParseMode(boolean z) {
        this.lenientParse = z;
        if (z) {
            initializeLenientScannerProvider();
        }
    }

    public void setLenientScannerProvider(RbnfLenientScannerProvider rbnfLenientScannerProvider) {
        this.scannerProvider = rbnfLenientScannerProvider;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public void setRoundingMode(int i) {
        if (i < 0 || i > 7) {
            og.i(ky0.h(i, "Invalid rounding mode: "));
        } else {
            this.roundingMode = i;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (NFRuleSet nFRuleSet : this.ruleSets) {
            sb.append(nFRuleSet.toString());
        }
        return sb.toString();
    }

    public String[] getRuleSetDisplayNames() {
        return getRuleSetDisplayNames(ULocale.getDefault(ULocale.Category.DISPLAY));
    }

    public String getRuleSetDisplayName(String str) {
        return getRuleSetDisplayName(str, ULocale.getDefault(ULocale.Category.DISPLAY));
    }

    public String format(long j, String str) {
        if (!str.startsWith("%%")) {
            return adjustForContext(format(j, findRuleSet(str)));
        }
        og.i("Can't use internal rule set");
        return null;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(double d, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        int length = stringBuffer.length();
        NFRuleSet nFRuleSet = this.defaultRuleSet;
        if (length == 0) {
            stringBuffer.append(adjustForContext(format(d, nFRuleSet)));
            return stringBuffer;
        }
        stringBuffer.append(format(d, nFRuleSet));
        return stringBuffer;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(long j, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        int length = stringBuffer.length();
        NFRuleSet nFRuleSet = this.defaultRuleSet;
        if (length == 0) {
            stringBuffer.append(adjustForContext(format(j, nFRuleSet)));
            return stringBuffer;
        }
        stringBuffer.append(format(j, nFRuleSet));
        return stringBuffer;
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(BigInteger bigInteger, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return format(new BigDecimal(bigInteger), stringBuffer, fieldPosition);
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(java.math.BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        return format(new BigDecimal(bigDecimal), stringBuffer, fieldPosition);
    }

    @Override // com.ibm.icu.text.NumberFormat
    public StringBuffer format(BigDecimal bigDecimal, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        if (MIN_VALUE.compareTo(bigDecimal) <= 0 && MAX_VALUE.compareTo(bigDecimal) >= 0) {
            if (bigDecimal.scale() == 0) {
                return format(bigDecimal.longValue(), stringBuffer, fieldPosition);
            }
            return format(bigDecimal.doubleValue(), stringBuffer, fieldPosition);
        }
        return getDecimalFormat().format(bigDecimal, stringBuffer, fieldPosition);
    }

    public String format(double d, String str) {
        if (!str.startsWith("%%")) {
            return adjustForContext(format(d, findRuleSet(str)));
        }
        og.i("Can't use internal rule set");
        return null;
    }

    private String format(long j, NFRuleSet nFRuleSet) {
        NFRuleSet nFRuleSet2;
        StringBuilder sb = new StringBuilder();
        if (j == Long.MIN_VALUE) {
            sb.append(getDecimalFormat().format(Long.MIN_VALUE));
            nFRuleSet2 = nFRuleSet;
        } else {
            nFRuleSet2 = nFRuleSet;
            nFRuleSet2.format(j, sb, 0, 0);
        }
        postProcess(sb, nFRuleSet2);
        return sb.toString();
    }

    public RuleBasedNumberFormat(String str, String[][] strArr) {
        this.ruleSets = null;
        this.ruleSetsMap = null;
        this.defaultRuleSet = null;
        this.locale = null;
        this.roundingMode = 7;
        this.scannerProvider = null;
        this.decimalFormatSymbols = null;
        this.decimalFormat = null;
        this.defaultInfinityRule = null;
        this.defaultNaNRule = null;
        this.lenientParse = false;
        this.caseFoldOption = (byte) 0;
        this.unparseable = false;
        this.capitalizationInfoIsSet = false;
        this.capitalizationForListOrMenu = false;
        this.capitalizationForStandAlone = false;
        this.capitalizationBrkIter = null;
        this.locale = ULocale.getDefault(ULocale.Category.FORMAT);
        init(str, strArr);
    }

    public RuleBasedNumberFormat(String str, Locale locale) {
        this(str, ULocale.forLocale(locale));
    }

    public RuleBasedNumberFormat(String str, ULocale uLocale) {
        this.ruleSets = null;
        this.ruleSetsMap = null;
        this.defaultRuleSet = null;
        this.roundingMode = 7;
        this.scannerProvider = null;
        this.decimalFormatSymbols = null;
        this.decimalFormat = null;
        this.defaultInfinityRule = null;
        this.defaultNaNRule = null;
        this.lenientParse = false;
        this.caseFoldOption = (byte) 0;
        this.unparseable = false;
        this.capitalizationInfoIsSet = false;
        this.capitalizationForListOrMenu = false;
        this.capitalizationForStandAlone = false;
        this.capitalizationBrkIter = null;
        this.locale = uLocale;
        init(str, null);
    }

    public RuleBasedNumberFormat(String str, String[][] strArr, ULocale uLocale) {
        this.ruleSets = null;
        this.ruleSetsMap = null;
        this.defaultRuleSet = null;
        this.roundingMode = 7;
        this.scannerProvider = null;
        this.decimalFormatSymbols = null;
        this.decimalFormat = null;
        this.defaultInfinityRule = null;
        this.defaultNaNRule = null;
        this.lenientParse = false;
        this.caseFoldOption = (byte) 0;
        this.unparseable = false;
        this.capitalizationInfoIsSet = false;
        this.capitalizationForListOrMenu = false;
        this.capitalizationForStandAlone = false;
        this.capitalizationBrkIter = null;
        this.locale = uLocale;
        init(str, strArr);
    }

    public RuleBasedNumberFormat(Locale locale, int i) {
        this(ULocale.forLocale(locale), i);
    }

    public RuleBasedNumberFormat(String str) {
        this.ruleSets = null;
        this.ruleSetsMap = null;
        this.defaultRuleSet = null;
        this.locale = null;
        this.roundingMode = 7;
        this.scannerProvider = null;
        this.decimalFormatSymbols = null;
        this.decimalFormat = null;
        this.defaultInfinityRule = null;
        this.defaultNaNRule = null;
        this.lenientParse = false;
        this.caseFoldOption = (byte) 0;
        this.unparseable = false;
        this.capitalizationInfoIsSet = false;
        this.capitalizationForListOrMenu = false;
        this.capitalizationForStandAlone = false;
        this.capitalizationBrkIter = null;
        this.locale = ULocale.getDefault(ULocale.Category.FORMAT);
        init(str, null);
    }

    public RuleBasedNumberFormat(int i) {
        this(ULocale.getDefault(ULocale.Category.FORMAT), i);
    }
}
