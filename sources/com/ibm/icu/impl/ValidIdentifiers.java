package com.ibm.icu.impl;

import com.ibm.icu.impl.locale.AsciiUtil;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import defpackage.mc1;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ValidIdentifiers {

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Datasubtype {
        deprecated,
        private_use,
        regular,
        special,
        unknown,
        macroregion,
        reserved
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Datatype {
        currency,
        language,
        region,
        script,
        subdivision,
        unit,
        variant,
        u,
        t,
        x,
        illegal
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ValidityData {
        static final Map<Datatype, Map<Datasubtype, ValiditySet>> data;

        static {
            EnumMap enumMap = new EnumMap(Datatype.class);
            UResourceBundleIterator iterator = UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "supplementalData", ICUResourceBundle.ICU_DATA_CLASS_LOADER).get("idValidity").getIterator();
            while (iterator.hasNext()) {
                UResourceBundle next = iterator.next();
                Datatype datatypeValueOf = Datatype.valueOf(next.getKey());
                EnumMap enumMap2 = new EnumMap(Datasubtype.class);
                UResourceBundleIterator iterator2 = next.getIterator();
                while (iterator2.hasNext()) {
                    UResourceBundle next2 = iterator2.next();
                    Datasubtype datasubtypeValueOf = Datasubtype.valueOf(next2.getKey());
                    HashSet hashSet = new HashSet();
                    boolean z = false;
                    if (next2.getType() == 0) {
                        addRange(next2.getString(), hashSet);
                    } else {
                        for (String str : next2.getStringArray()) {
                            addRange(str, hashSet);
                        }
                    }
                    if (datatypeValueOf == Datatype.subdivision) {
                        z = true;
                    }
                    enumMap2.put(datasubtypeValueOf, new ValiditySet(hashSet, z));
                }
                enumMap.put(datatypeValueOf, ValidIdentifiers.toImmutableMap(enumMap2));
            }
            data = ValidIdentifiers.toImmutableMap(enumMap);
        }

        private ValidityData() {
        }

        private static void addRange(String str, Set<String> set) {
            String lowerString = AsciiUtil.toLowerString(str);
            int iIndexOf = lowerString.indexOf(126);
            if (iIndexOf < 0) {
                set.add(lowerString);
            } else {
                StringRange.expand(lowerString.substring(0, iIndexOf), lowerString.substring(iIndexOf + 1), false, set);
            }
        }
    }

    public static Map<Datatype, Map<Datasubtype, ValiditySet>> getData() {
        return ValidityData.data;
    }

    public static Datasubtype isValid(Datatype datatype, Set<Datasubtype> set, String str, String str2) {
        Map<Datasubtype, ValiditySet> map = ValidityData.data.get(datatype);
        if (map == null) {
            return null;
        }
        String lowerString = AsciiUtil.toLowerString(str);
        String lowerString2 = AsciiUtil.toLowerString(str2);
        for (Datasubtype datasubtype : set) {
            ValiditySet validitySet = map.get(datasubtype);
            if (validitySet != null && validitySet.contains(lowerString, lowerString2)) {
                return datasubtype;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <K, V> Map<K, V> toImmutableMap(Map<K, V> map) {
        HashMap map2 = new HashMap(map.size());
        for (Map.Entry<K, V> entry : map.entrySet()) {
            K key = entry.getKey();
            Objects.requireNonNull(key);
            V value = entry.getValue();
            Objects.requireNonNull(value);
            map2.put(key, value);
        }
        return Collections.unmodifiableMap(map2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <E> Set<E> toImmutableSet(Set<E> set) {
        HashSet hashSet = new HashSet(set.size());
        for (E e : set) {
            Objects.requireNonNull(e);
            hashSet.add(e);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ValiditySet {
        public final Set<String> regularData;
        public final Map<String, Set<String>> subdivisionData;

        public ValiditySet(Set<String> set, boolean z) {
            if (!z) {
                this.regularData = ValidIdentifiers.toImmutableSet(set);
                this.subdivisionData = null;
                return;
            }
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            for (String str : set) {
                int iIndexOf = str.indexOf(45);
                int i = iIndexOf + 1;
                if (iIndexOf < 0) {
                    iIndexOf = str.charAt(0) < 'A' ? 3 : 2;
                    i = iIndexOf;
                }
                String strSubstring = str.substring(0, iIndexOf);
                String str2 = (String) map.computeIfAbsent(str.substring(i), new mc1(6));
                Set hashSet = (Set) map2.get(strSubstring);
                if (hashSet == null) {
                    hashSet = new HashSet();
                    map2.put(strSubstring, hashSet);
                }
                hashSet.add(str2);
            }
            this.regularData = null;
            HashMap map3 = new HashMap();
            for (Map.Entry entry : map2.entrySet()) {
                map3.put((String) entry.getKey(), ValidIdentifiers.toImmutableSet((Set) entry.getValue()));
            }
            this.subdivisionData = ValidIdentifiers.toImmutableMap(map3);
        }

        public boolean contains(String str) {
            Set<String> set = this.regularData;
            if (set != null) {
                return set.contains(str);
            }
            int iIndexOf = str.indexOf(45);
            return contains(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
        }

        public String toString() {
            Set<String> set = this.regularData;
            return set != null ? set.toString() : this.subdivisionData.toString();
        }

        public boolean contains(String str, String str2) {
            Set<String> set = this.subdivisionData.get(str);
            return set != null && set.contains(str2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ String lambda$new$0(String str) {
            return str;
        }
    }

    public static Datasubtype isValid(Datatype datatype, Set<Datasubtype> set, String str) {
        Map<Datasubtype, ValiditySet> map = ValidityData.data.get(datatype);
        if (map == null) {
            return null;
        }
        for (Datasubtype datasubtype : set) {
            ValiditySet validitySet = map.get(datasubtype);
            if (validitySet != null && validitySet.contains(AsciiUtil.toLowerString(str))) {
                return datasubtype;
            }
        }
        return null;
    }
}
