package com.ibm.icu.impl.personname;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.lang.UScript;
import com.ibm.icu.text.PersonName;
import com.ibm.icu.text.PersonNameFormatter;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import defpackage.ky0;
import defpackage.og;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class PersonNameFormatterImpl {
    static final Set<String> NON_DEFAULT_SCRIPTS = new HashSet(Arrays.asList("Hani", "Hira", "Kana"));
    private final boolean capitalizeSurname;
    private final PersonNameFormatter.DisplayOrder displayOrder;
    private final String foreignSpaceReplacement;
    private final PersonNameFormatter.Formality formality;
    private final Set<String> gnFirstLocales;
    private final PersonNamePattern[] gnFirstPatterns;
    private final String initialPattern;
    private final String initialSequencePattern;
    private final PersonNameFormatter.Length length;
    private final Locale locale;
    private final String nativeSpaceReplacement;
    private final Set<String> snFirstLocales;
    private final PersonNamePattern[] snFirstPatterns;
    private final PersonNameFormatter.Usage usage;

    public PersonNameFormatterImpl(Locale locale, PersonNameFormatter.Length length, PersonNameFormatter.Usage usage, PersonNameFormatter.Formality formality, PersonNameFormatter.DisplayOrder displayOrder, boolean z) {
        this.length = length;
        this.usage = usage;
        this.formality = formality;
        this.displayOrder = displayOrder;
        this.capitalizeSurname = z;
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, locale);
        this.locale = locale;
        this.initialPattern = iCUResourceBundle.getStringWithFallback("personNames/initialPattern/initial");
        this.initialSequencePattern = iCUResourceBundle.getStringWithFallback("personNames/initialPattern/initialSequence");
        this.foreignSpaceReplacement = iCUResourceBundle.getStringWithFallback("personNames/foreignSpaceReplacement");
        this.nativeSpaceReplacement = iCUResourceBundle.getStringWithFallback("personNames/nativeSpaceReplacement");
        if (usage == PersonNameFormatter.Usage.MONOGRAM) {
            displayOrder = PersonNameFormatter.DisplayOrder.DEFAULT;
        } else if (displayOrder == PersonNameFormatter.DisplayOrder.SORTING) {
            usage = PersonNameFormatter.Usage.REFERRING;
        }
        String lowerCase = length != PersonNameFormatter.Length.DEFAULT ? length.toString().toLowerCase() : iCUResourceBundle.getStringWithFallback("personNames/parameterDefault/length");
        String lowerCase2 = formality != PersonNameFormatter.Formality.DEFAULT ? formality.toString().toLowerCase() : iCUResourceBundle.getStringWithFallback("personNames/parameterDefault/formality");
        String str = lowerCase + LanguageTag.SEP + usage.toString().toLowerCase() + LanguageTag.SEP + lowerCase2;
        if (displayOrder == PersonNameFormatter.DisplayOrder.SORTING) {
            this.gnFirstPatterns = PersonNamePattern.makePatterns(asStringArray(iCUResourceBundle.getWithFallback("personNames/namePattern/sorting-".concat(str))), this);
            this.snFirstPatterns = null;
            this.gnFirstLocales = null;
            this.snFirstLocales = null;
            return;
        }
        ICUResourceBundle withFallback = iCUResourceBundle.getWithFallback("personNames/namePattern/givenFirst-".concat(str));
        ICUResourceBundle withFallback2 = iCUResourceBundle.getWithFallback("personNames/namePattern/surnameFirst-".concat(str));
        this.gnFirstPatterns = PersonNamePattern.makePatterns(asStringArray(withFallback), this);
        this.snFirstPatterns = PersonNamePattern.makePatterns(asStringArray(withFallback2), this);
        HashSet hashSet = new HashSet();
        this.gnFirstLocales = hashSet;
        Collections.addAll(hashSet, asStringArray(iCUResourceBundle.getWithFallback("personNames/nameOrderLocales/givenFirst")));
        HashSet hashSet2 = new HashSet();
        this.snFirstLocales = hashSet2;
        Collections.addAll(hashSet2, asStringArray(iCUResourceBundle.getWithFallback("personNames/nameOrderLocales/surnameFirst")));
    }

    private String[] asStringArray(ICUResourceBundle iCUResourceBundle) {
        if (iCUResourceBundle.getType() == 0) {
            return new String[]{iCUResourceBundle.getString()};
        }
        if (iCUResourceBundle.getType() == 8) {
            return iCUResourceBundle.getStringArray();
        }
        og.n(ky0.h(iCUResourceBundle.getType(), "Unsupported resource type "));
        return null;
    }

    private boolean formattingLocaleExists(Locale locale) {
        String language = locale.getLanguage();
        ICUResourceBundle bundleInstance = ICUResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, ULocale.forLocale(locale), ICUResourceBundle.OpenType.LOCALE_DEFAULT_ROOT);
        if (bundleInstance.getULocale().getLanguage().equals(language)) {
            return bundleInstance.getWithFallback("personNames/nameOrderLocales/givenFirst").getULocale().getLanguage().equals(language) || bundleInstance.getWithFallback("personNames/nameOrderLocales/surnameFirst").getULocale().getLanguage().equals(language);
        }
        return false;
    }

    private PersonNamePattern getBestPattern(PersonNamePattern[] personNamePatternArr, PersonName personName) {
        if (personNamePatternArr.length == 1) {
            return personNamePatternArr[0];
        }
        int i = Integer.MAX_VALUE;
        personNamePattern = null;
        int i2 = 0;
        for (PersonNamePattern personNamePattern : personNamePatternArr) {
            int iNumPopulatedFields = personNamePattern.numPopulatedFields(personName);
            int iNumEmptyFields = personNamePattern.numEmptyFields(personName);
            if (iNumPopulatedFields > i2) {
                i2 = iNumPopulatedFields;
            } else {
                if (iNumPopulatedFields != i2 || iNumEmptyFields >= i) {
                }
            }
            i = iNumEmptyFields;
        }
        return personNamePattern;
    }

    private Locale getNameLocale(PersonName personName) {
        return newLocaleWithScript(personName.getNameLocale(), getNameScript(personName), null);
    }

    private String getNameScript(PersonName personName) {
        PersonName.NameField nameField = PersonName.NameField.SURNAME;
        Set<PersonName.FieldModifier> set = Collections.EMPTY_SET;
        String fieldValue = personName.getFieldValue(nameField, set);
        String fieldValue2 = personName.getFieldValue(PersonName.NameField.GIVEN, set);
        if (fieldValue2 == null) {
            fieldValue2 = "";
        }
        if (fieldValue == null) {
            fieldValue = "";
        }
        String strConcat = fieldValue2.concat(fieldValue);
        int i = 103;
        for (int i2 = 0; i == 103 && i2 < strConcat.length(); i2++) {
            int script = UScript.getScript(strConcat.codePointAt(i2));
            if (script != 0 && script != 1 && script != 103) {
                i = script;
            }
        }
        return UScript.getShortName(i);
    }

    private boolean localesMatch(Locale locale, Locale locale2) {
        String language = locale.getLanguage();
        String language2 = locale2.getLanguage();
        if (language.equals(language2)) {
            return true;
        }
        if (language.equals("ja") || language.equals("zh")) {
            return language2.equals("ja") || language2.equals("zh");
        }
        return false;
    }

    private boolean nameIsGnFirst(PersonName personName) {
        PersonNameFormatter.DisplayOrder displayOrder = this.displayOrder;
        if (displayOrder == PersonNameFormatter.DisplayOrder.FORCE_GIVEN_FIRST) {
            return true;
        }
        if (displayOrder == PersonNameFormatter.DisplayOrder.FORCE_SURNAME_FIRST) {
            return false;
        }
        if (personName.getPreferredOrder() == PersonName.PreferredOrder.GIVEN_FIRST) {
            return true;
        }
        if (personName.getPreferredOrder() == PersonName.PreferredOrder.SURNAME_FIRST) {
            return false;
        }
        Locale nameLocale = personName.getNameLocale();
        if (nameLocale == null) {
            nameLocale = getNameLocale(personName);
        }
        ULocale uLocaleForLocale = ULocale.forLocale(nameLocale);
        if (NON_DEFAULT_SCRIPTS.contains(uLocaleForLocale.getScript())) {
            ULocale.Builder builder = new ULocale.Builder();
            builder.setLocale(uLocaleForLocale);
            builder.setScript(null);
            uLocaleForLocale = ULocale.addLikelySubtags(builder.build());
        }
        String name = uLocaleForLocale.getName();
        String language = uLocaleForLocale.getLanguage();
        String parentLocaleID = name;
        while (!this.gnFirstLocales.contains(parentLocaleID)) {
            if (this.snFirstLocales.contains(parentLocaleID)) {
                return false;
            }
            String strReplaceAll = parentLocaleID.replaceAll("^" + language, "und");
            if (this.gnFirstLocales.contains(strReplaceAll)) {
                return true;
            }
            if (this.snFirstLocales.contains(strReplaceAll)) {
                return false;
            }
            parentLocaleID = ICUResourceBundle.getParentLocaleID(parentLocaleID, name, ICUResourceBundle.OpenType.LOCALE_DEFAULT_ROOT);
            if (parentLocaleID == null) {
                parentLocaleID = language;
            }
            if (parentLocaleID == null) {
                return true;
            }
        }
        return true;
    }

    private boolean nameScriptMatchesLocale(String str, Locale locale) {
        if (str.equals("Zzzz")) {
            return true;
        }
        int[] code = UScript.getCode(locale);
        int codeFromName = UScript.getCodeFromName(str);
        for (int i : code) {
            if (i == codeFromName || ((i == 73 && codeFromName == 17) || (i == 74 && codeFromName == 17))) {
                return true;
            }
        }
        return false;
    }

    private Locale newLocaleWithScript(Locale locale, String str, String str2) {
        String script;
        if (str.equals("Zzzz")) {
            return locale != null ? locale : Locale.ROOT;
        }
        Locale.Builder builder = new Locale.Builder();
        if (locale != null) {
            builder.setLocale(locale);
            script = ULocale.addLikelySubtags(ULocale.forLocale(locale)).getScript();
        } else {
            ULocale uLocaleAddLikelySubtags = ULocale.addLikelySubtags(new ULocale("und_".concat(str)));
            builder.setLanguage(uLocaleAddLikelySubtags.getLanguage());
            locale = ULocale.addLikelySubtags(new ULocale(uLocaleAddLikelySubtags.getLanguage())).toLocale();
            String script2 = locale.getScript();
            if (str2 != null) {
                builder.setRegion(str2);
            }
            script = script2;
        }
        if (!str.equals(script) && nameScriptMatchesLocale(str, locale)) {
            str = script;
        }
        builder.setScript(str);
        return builder.build();
    }

    public String formatToString(PersonName personName) {
        Locale nameLocale = getNameLocale(personName);
        String nameScript = getNameScript(personName);
        if (!nameScriptMatchesLocale(nameScript, this.locale)) {
            if (!formattingLocaleExists(nameLocale)) {
                nameLocale = newLocaleWithScript(null, nameScript, nameLocale.getCountry());
            }
            return new PersonNameFormatterImpl(nameLocale, this.length, this.usage, this.formality, this.displayOrder, this.capitalizeSurname).formatToString(personName);
        }
        String str = (this.snFirstPatterns == null || nameIsGnFirst(personName)) ? getBestPattern(this.gnFirstPatterns, personName).format(personName) : getBestPattern(this.snFirstPatterns, personName).format(personName);
        if (this.nativeSpaceReplacement.equals(Padder.FALLBACK_PADDING_STRING) && this.foreignSpaceReplacement.equals(Padder.FALLBACK_PADDING_STRING)) {
            return str;
        }
        return localesMatch(nameLocale, this.locale) ? str.replace(Padder.FALLBACK_PADDING_STRING, this.nativeSpaceReplacement) : str.replace(Padder.FALLBACK_PADDING_STRING, this.foreignSpaceReplacement);
    }

    public PersonNameFormatter.DisplayOrder getDisplayOrder() {
        return this.displayOrder;
    }

    public PersonNameFormatter.Formality getFormality() {
        return this.formality;
    }

    public String getInitialPattern() {
        return this.initialPattern;
    }

    public String getInitialSequencePattern() {
        return this.initialSequencePattern;
    }

    public PersonNameFormatter.Length getLength() {
        return this.length;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public boolean getSurnameAllCaps() {
        return this.capitalizeSurname;
    }

    public PersonNameFormatter.Usage getUsage() {
        return this.usage;
    }

    public boolean shouldCapitalizeSurname() {
        return this.capitalizeSurname;
    }

    public String toString() {
        String strValueOf = String.valueOf(this.displayOrder);
        String strValueOf2 = String.valueOf(this.length);
        String strValueOf3 = String.valueOf(this.usage);
        String strValueOf4 = String.valueOf(this.formality);
        String strValueOf5 = String.valueOf(this.locale);
        StringBuilder sbQ = cq.q("PersonNameFormatter: ", strValueOf, LanguageTag.SEP, strValueOf2, LanguageTag.SEP);
        sbQ.append(strValueOf3);
        sbQ.append(LanguageTag.SEP);
        sbQ.append(strValueOf4);
        sbQ.append(", ");
        sbQ.append(strValueOf5);
        return sbQ.toString();
    }

    public PersonNameFormatterImpl(Locale locale, String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        this.length = PersonNameFormatter.Length.MEDIUM;
        this.usage = PersonNameFormatter.Usage.REFERRING;
        this.formality = PersonNameFormatter.Formality.FORMAL;
        this.displayOrder = PersonNameFormatter.DisplayOrder.DEFAULT;
        this.initialPattern = "{0}.";
        this.initialSequencePattern = "{0} {1}";
        this.capitalizeSurname = false;
        this.foreignSpaceReplacement = Padder.FALLBACK_PADDING_STRING;
        this.nativeSpaceReplacement = Padder.FALLBACK_PADDING_STRING;
        this.locale = locale;
        this.gnFirstPatterns = PersonNamePattern.makePatterns(strArr, this);
        this.snFirstPatterns = strArr2 != null ? PersonNamePattern.makePatterns(strArr2, this) : null;
        if (strArr3 != null) {
            HashSet hashSet = new HashSet();
            this.gnFirstLocales = hashSet;
            Collections.addAll(hashSet, strArr3);
        } else {
            this.gnFirstLocales = null;
        }
        if (strArr4 != null) {
            HashSet hashSet2 = new HashSet();
            this.snFirstLocales = hashSet2;
            Collections.addAll(hashSet2, strArr4);
            return;
        }
        this.snFirstLocales = null;
    }
}
