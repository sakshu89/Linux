package com.ibm.icu.impl;

import com.ibm.icu.impl.locale.BaseLocale;
import com.ibm.icu.impl.number.range.StandardPluralRanges;
import com.ibm.icu.text.PluralRules;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import java.text.ParseException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class PluralRulesLoader extends PluralRules.Factory {
    private static final PluralRules NULL_RULES = PluralRules.createRules("other: ");
    public static final PluralRulesLoader loader = new PluralRulesLoader();
    private volatile Map<String, String> localeIdToCardinalRulesId;
    private volatile Map<String, String> localeIdToOrdinalRulesId;
    private final ConcurrentHashMap<String, PluralRules> pluralRulesCache = new ConcurrentHashMap<>();
    private volatile Map<String, ULocale> rulesIdToEquivalentULocale;

    private PluralRulesLoader() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Map<java.lang.String, java.lang.String>] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.TreeMap] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Map<java.lang.String, com.ibm.icu.util.ULocale>] */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.HashMap] */
    private void checkBuildRulesIdMaps() {
        Object treeMap;
        Object treeMap2;
        Object map;
        if (this.localeIdToCardinalRulesId != null) {
            return;
        }
        synchronized (this) {
            if (this.localeIdToCardinalRulesId != null) {
                return;
            }
            try {
                UResourceBundle pluralBundle = getPluralBundle();
                UResourceBundle uResourceBundle = pluralBundle.get("locales");
                treeMap = new TreeMap();
                map = new HashMap();
                for (int i = 0; i < uResourceBundle.getSize(); i++) {
                    UResourceBundle uResourceBundle2 = uResourceBundle.get(i);
                    String key = uResourceBundle2.getKey();
                    String strIntern = uResourceBundle2.getString().intern();
                    treeMap.put(key, strIntern);
                    if (!map.containsKey(strIntern)) {
                        map.put(strIntern, new ULocale(key));
                    }
                }
                UResourceBundle uResourceBundle3 = pluralBundle.get("locales_ordinals");
                treeMap2 = new TreeMap();
                for (int i2 = 0; i2 < uResourceBundle3.getSize(); i2++) {
                    UResourceBundle uResourceBundle4 = uResourceBundle3.get(i2);
                    treeMap2.put(uResourceBundle4.getKey(), uResourceBundle4.getString().intern());
                }
            } catch (MissingResourceException unused) {
                treeMap = Collections.EMPTY_MAP;
                treeMap2 = treeMap;
                map = treeMap2;
            }
            this.rulesIdToEquivalentULocale = map;
            this.localeIdToOrdinalRulesId = treeMap2;
            this.localeIdToCardinalRulesId = treeMap;
        }
    }

    private Map<String, String> getLocaleIdToRulesIdMap(PluralRules.PluralType pluralType) {
        checkBuildRulesIdMaps();
        return pluralType == PluralRules.PluralType.CARDINAL ? this.localeIdToCardinalRulesId : this.localeIdToOrdinalRulesId;
    }

    private Map<String, ULocale> getRulesIdToEquivalentULocaleMap() {
        checkBuildRulesIdMaps();
        return this.rulesIdToEquivalentULocale;
    }

    @Override // com.ibm.icu.text.PluralRules.Factory
    public PluralRules forLocale(ULocale uLocale, PluralRules.PluralType pluralType) {
        PluralRules orCreateRulesForLocale = getOrCreateRulesForLocale(uLocale, pluralType);
        return orCreateRulesForLocale == null ? PluralRules.DEFAULT : orCreateRulesForLocale;
    }

    @Override // com.ibm.icu.text.PluralRules.Factory
    public ULocale[] getAvailableULocales() {
        Set<String> setKeySet = getLocaleIdToRulesIdMap(PluralRules.PluralType.CARDINAL).keySet();
        LinkedHashSet linkedHashSet = new LinkedHashSet(setKeySet.size());
        Iterator<String> it = setKeySet.iterator();
        while (it.hasNext()) {
            linkedHashSet.add(ULocale.createCanonical(it.next()));
        }
        return (ULocale[]) linkedHashSet.toArray(new ULocale[0]);
    }

    @Override // com.ibm.icu.text.PluralRules.Factory
    public ULocale getFunctionalEquivalent(ULocale uLocale, boolean[] zArr) {
        if (zArr != null && zArr.length > 0) {
            zArr[0] = getLocaleIdToRulesIdMap(PluralRules.PluralType.CARDINAL).containsKey(ULocale.canonicalize(uLocale.getBaseName()));
        }
        String rulesIdForLocale = getRulesIdForLocale(uLocale, PluralRules.PluralType.CARDINAL);
        if (rulesIdForLocale == null || rulesIdForLocale.trim().length() == 0) {
            return ULocale.ROOT;
        }
        ULocale uLocale2 = getRulesIdToEquivalentULocaleMap().get(rulesIdForLocale);
        return uLocale2 == null ? ULocale.ROOT : uLocale2;
    }

    public PluralRules getOrCreateRulesForLocale(ULocale uLocale, PluralRules.PluralType pluralType) {
        PluralRules pluralRulesNewInternal;
        String rulesIdForLocale = getRulesIdForLocale(uLocale, pluralType);
        if (rulesIdForLocale == null || rulesIdForLocale.trim().length() == 0) {
            return null;
        }
        String setForLocale = StandardPluralRanges.getSetForLocale(uLocale);
        String strK = cq.k(rulesIdForLocale, "/", setForLocale);
        PluralRules pluralRules = this.pluralRulesCache.get(strK);
        if (pluralRules != null) {
            if (pluralRules == NULL_RULES) {
                return null;
            }
            return pluralRules;
        }
        try {
            UResourceBundle uResourceBundle = getPluralBundle().get("rules").get(rulesIdForLocale);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < uResourceBundle.getSize(); i++) {
                UResourceBundle uResourceBundle2 = uResourceBundle.get(i);
                if (i > 0) {
                    sb.append("; ");
                }
                sb.append(uResourceBundle2.getKey());
                sb.append(": ");
                sb.append(uResourceBundle2.getString());
            }
            pluralRulesNewInternal = PluralRules.newInternal(sb.toString(), StandardPluralRanges.forSet(setForLocale));
        } catch (ParseException | MissingResourceException unused) {
            pluralRulesNewInternal = null;
        }
        PluralRules pluralRulesPutIfAbsent = this.pluralRulesCache.putIfAbsent(strK, pluralRulesNewInternal != null ? pluralRulesNewInternal : NULL_RULES);
        if (pluralRulesPutIfAbsent == null) {
            return pluralRulesNewInternal;
        }
        if (pluralRulesPutIfAbsent == NULL_RULES) {
            return null;
        }
        return pluralRulesPutIfAbsent;
    }

    public UResourceBundle getPluralBundle() {
        return ICUResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "plurals", ICUResourceBundle.ICU_DATA_CLASS_LOADER, true);
    }

    public String getRulesIdForLocale(ULocale uLocale, PluralRules.PluralType pluralType) {
        String str;
        int iLastIndexOf;
        Map<String, String> localeIdToRulesIdMap = getLocaleIdToRulesIdMap(pluralType);
        String strCanonicalize = ULocale.canonicalize(uLocale.getBaseName());
        while (true) {
            str = localeIdToRulesIdMap.get(strCanonicalize);
            if (str != null || (iLastIndexOf = strCanonicalize.lastIndexOf(BaseLocale.SEP)) == -1) {
                break;
            }
            strCanonicalize = strCanonicalize.substring(0, iLastIndexOf);
        }
        return str;
    }

    @Override // com.ibm.icu.text.PluralRules.Factory
    public boolean hasOverride(ULocale uLocale) {
        return false;
    }
}
