package com.ibm.icu.impl.locale;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.util.Output;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceBundleIterator;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class KeyTypeData {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static Map<String, Set<String>> BCP47_KEYS;
    static Set<String> DEPRECATED_KEYS = Collections.EMPTY_SET;
    static Map<String, Set<String>> DEPRECATED_KEY_TYPES;
    private static final Map<String, KeyData> KEYMAP;
    private static final Object[][] KEY_DATA;
    static Map<String, ValueType> VALUE_TYPES;

    /* JADX INFO: renamed from: com.ibm.icu.impl.locale.KeyTypeData$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$locale$KeyTypeData$KeyInfoType;
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$locale$KeyTypeData$TypeInfoType;

        static {
            int[] iArr = new int[TypeInfoType.values().length];
            $SwitchMap$com$ibm$icu$impl$locale$KeyTypeData$TypeInfoType = iArr;
            try {
                iArr[TypeInfoType.deprecated.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            int[] iArr2 = new int[KeyInfoType.values().length];
            $SwitchMap$com$ibm$icu$impl$locale$KeyTypeData$KeyInfoType = iArr2;
            try {
                iArr2[KeyInfoType.deprecated.ordinal()] = 1;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$locale$KeyTypeData$KeyInfoType[KeyInfoType.valueType.ordinal()] = 2;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class KeyData {
        String bcpId;
        String legacyId;
        EnumSet<SpecialType> specialTypes;
        Map<String, Type> typeMap;

        public KeyData(String str, String str2, Map<String, Type> map, EnumSet<SpecialType> enumSet) {
            this.legacyId = str;
            this.bcpId = str2;
            this.typeMap = map;
            this.specialTypes = enumSet;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum KeyInfoType {
        deprecated,
        valueType
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'CODEPOINTS' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:485)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:422)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:351)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:284)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:153)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:102)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class SpecialType {
        private static final /* synthetic */ SpecialType[] $VALUES;
        public static final SpecialType CODEPOINTS;
        public static final SpecialType PRIVATE_USE;
        public static final SpecialType REORDER_CODE;
        public static final SpecialType RG_KEY_VALUE;
        public static final SpecialType SCRIPT_CODE;
        public static final SpecialType SUBDIVISION_CODE;
        SpecialTypeHandler handler;

        static {
            int i = 0;
            SpecialType specialType = new SpecialType("CODEPOINTS", 0, new CodepointsTypeHandler(i));
            CODEPOINTS = specialType;
            SpecialType specialType2 = new SpecialType("REORDER_CODE", 1, new ReorderCodeTypeHandler(i));
            REORDER_CODE = specialType2;
            SpecialType specialType3 = new SpecialType("RG_KEY_VALUE", 2, new RgKeyValueTypeHandler(i));
            RG_KEY_VALUE = specialType3;
            SpecialType specialType4 = new SpecialType("SCRIPT_CODE", 3, new ScriptCodeTypeHandler(i));
            SCRIPT_CODE = specialType4;
            SpecialType specialType5 = new SpecialType("SUBDIVISION_CODE", 4, new SubdivisionKeyValueTypeHandler(i));
            SUBDIVISION_CODE = specialType5;
            SpecialType specialType6 = new SpecialType("PRIVATE_USE", 5, new PrivateUseKeyValueTypeHandler(i));
            PRIVATE_USE = specialType6;
            $VALUES = new SpecialType[]{specialType, specialType2, specialType3, specialType4, specialType5, specialType6};
        }

        private SpecialType(String str, int i, SpecialTypeHandler specialTypeHandler) {
            super(str, i);
            this.handler = specialTypeHandler;
        }

        public static SpecialType valueOf(String str) {
            return (SpecialType) Enum.valueOf(SpecialType.class, str);
        }

        public static SpecialType[] values() {
            return (SpecialType[]) $VALUES.clone();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Type {
        String bcpId;
        String legacyId;

        public Type(String str, String str2) {
            this.legacyId = str;
            this.bcpId = str2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum TypeInfoType {
        deprecated
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum ValueType {
        single,
        multiple,
        incremental,
        any
    }

    static {
        Map map = Collections.EMPTY_MAP;
        VALUE_TYPES = map;
        DEPRECATED_KEY_TYPES = map;
        KEY_DATA = new Object[0][];
        KEYMAP = new HashMap();
        initFromResourceBundle();
    }

    public static Set<String> getBcp47KeyTypes(String str) {
        return BCP47_KEYS.get(str);
    }

    public static Set<String> getBcp47Keys() {
        return BCP47_KEYS.keySet();
    }

    private static void getKeyInfo(UResourceBundle uResourceBundle) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        UResourceBundleIterator iterator = uResourceBundle.getIterator();
        while (iterator.hasNext()) {
            UResourceBundle next = iterator.next();
            KeyInfoType keyInfoTypeValueOf = KeyInfoType.valueOf(next.getKey());
            UResourceBundleIterator iterator2 = next.getIterator();
            while (iterator2.hasNext()) {
                UResourceBundle next2 = iterator2.next();
                String key = next2.getKey();
                String string = next2.getString();
                int i = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$locale$KeyTypeData$KeyInfoType[keyInfoTypeValueOf.ordinal()];
                if (i == 1) {
                    linkedHashSet.add(key);
                } else if (i == 2) {
                    linkedHashMap.put(key, ValueType.valueOf(string));
                }
            }
        }
        DEPRECATED_KEYS = Collections.unmodifiableSet(linkedHashSet);
        VALUE_TYPES = Collections.unmodifiableMap(linkedHashMap);
    }

    private static void getTypeInfo(UResourceBundle uResourceBundle) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        UResourceBundleIterator iterator = uResourceBundle.getIterator();
        while (iterator.hasNext()) {
            UResourceBundle next = iterator.next();
            TypeInfoType typeInfoTypeValueOf = TypeInfoType.valueOf(next.getKey());
            UResourceBundleIterator iterator2 = next.getIterator();
            while (iterator2.hasNext()) {
                UResourceBundle next2 = iterator2.next();
                String key = next2.getKey();
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                UResourceBundleIterator iterator3 = next2.getIterator();
                while (iterator3.hasNext()) {
                    String key2 = iterator3.next().getKey();
                    if (AnonymousClass1.$SwitchMap$com$ibm$icu$impl$locale$KeyTypeData$TypeInfoType[typeInfoTypeValueOf.ordinal()] == 1) {
                        linkedHashSet.add(key2);
                    }
                }
                linkedHashMap.put(key, Collections.unmodifiableSet(linkedHashSet));
            }
        }
        DEPRECATED_KEY_TYPES = Collections.unmodifiableMap(linkedHashMap);
    }

    public static ValueType getValueType(String str) {
        ValueType valueType = VALUE_TYPES.get(str);
        return valueType == null ? ValueType.single : valueType;
    }

    /* JADX WARN: Code duplicated, block: B:33:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:47:0x00f8  */
    private static void initFromResourceBundle() {
        UResourceBundle uResourceBundle;
        UResourceBundle uResourceBundle2;
        boolean z;
        UResourceBundle uResourceBundle3;
        HashMap map;
        Set hashSet;
        UResourceBundle uResourceBundle4;
        HashMap map2;
        Set hashSet2;
        UResourceBundle uResourceBundle5;
        EnumSet enumSetNoneOf;
        boolean z2;
        Set set;
        Set set2;
        ICUResourceBundle bundleInstance = ICUResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "keyTypeData", ICUResourceBundle.ICU_DATA_CLASS_LOADER, ICUResourceBundle.OpenType.DIRECT);
        getKeyInfo(bundleInstance.get("keyInfo"));
        getTypeInfo(bundleInstance.get("typeInfo"));
        UResourceBundle uResourceBundle6 = bundleInstance.get("keyMap");
        UResourceBundle uResourceBundle7 = bundleInstance.get("typeMap");
        try {
            uResourceBundle = bundleInstance.get("typeAlias");
        } catch (MissingResourceException unused) {
            uResourceBundle = null;
        }
        try {
            uResourceBundle2 = bundleInstance.get("bcpTypeAlias");
        } catch (MissingResourceException unused2) {
            uResourceBundle2 = null;
        }
        UResourceBundleIterator iterator = uResourceBundle6.getIterator();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        while (iterator.hasNext()) {
            UResourceBundle next = iterator.next();
            String key = next.getKey();
            String string = next.getString();
            if (string.length() == 0) {
                string = key;
                z = true;
            } else {
                z = false;
            }
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            linkedHashMap.put(string, Collections.unmodifiableSet(linkedHashSet));
            boolean zEquals = key.equals("timezone");
            char c = '/';
            if (uResourceBundle != null) {
                try {
                    uResourceBundle3 = uResourceBundle.get(key);
                } catch (MissingResourceException unused3) {
                    uResourceBundle3 = null;
                }
                if (uResourceBundle3 != null) {
                    map = new HashMap();
                    UResourceBundleIterator iterator2 = uResourceBundle3.getIterator();
                    while (iterator2.hasNext()) {
                        UResourceBundle next2 = iterator2.next();
                        String key2 = next2.getKey();
                        String string2 = next2.getString();
                        if (zEquals) {
                            key2 = key2.replace(':', c);
                        }
                        Set set3 = (Set) map.get(string2);
                        if (set3 == null) {
                            hashSet = new HashSet();
                            map.put(string2, hashSet);
                        } else {
                            hashSet = set3;
                        }
                        hashSet.add(key2);
                        c = '/';
                    }
                } else {
                    map = null;
                }
            } else {
                map = null;
            }
            if (uResourceBundle2 != null) {
                try {
                    uResourceBundle4 = uResourceBundle2.get(string);
                } catch (MissingResourceException unused4) {
                    uResourceBundle4 = null;
                }
                if (uResourceBundle4 != null) {
                    map2 = new HashMap();
                    UResourceBundleIterator iterator3 = uResourceBundle4.getIterator();
                    while (iterator3.hasNext()) {
                        UResourceBundle next3 = iterator3.next();
                        String key3 = next3.getKey();
                        String string3 = next3.getString();
                        Set set4 = (Set) map2.get(string3);
                        if (set4 == null) {
                            hashSet2 = new HashSet();
                            map2.put(string3, hashSet2);
                        } else {
                            hashSet2 = set4;
                        }
                        hashSet2.add(key3);
                    }
                } else {
                    map2 = null;
                }
            } else {
                map2 = null;
            }
            HashMap map3 = new HashMap();
            try {
                uResourceBundle5 = uResourceBundle7.get(key);
            } catch (MissingResourceException unused5) {
                uResourceBundle5 = null;
            }
            if (uResourceBundle5 != null) {
                UResourceBundleIterator iterator4 = uResourceBundle5.getIterator();
                enumSetNoneOf = null;
                while (iterator4.hasNext()) {
                    UResourceBundle next4 = iterator4.next();
                    UResourceBundle uResourceBundle8 = uResourceBundle2;
                    String key4 = next4.getKey();
                    String string4 = next4.getString();
                    UResourceBundleIterator uResourceBundleIterator = iterator;
                    UResourceBundle uResourceBundle9 = uResourceBundle7;
                    char cCharAt = key4.charAt(0);
                    if ('9' >= cCharAt || cCharAt >= 'a' || string4.length() != 0) {
                        if (zEquals) {
                            key4 = key4.replace(':', '/');
                        }
                        if (string4.length() == 0) {
                            z2 = true;
                            string4 = key4;
                        } else {
                            z2 = false;
                        }
                        linkedHashSet.add(string4);
                        Type type = new Type(key4, string4);
                        map3.put(AsciiUtil.toLowerString(key4), type);
                        if (!z2) {
                            map3.put(AsciiUtil.toLowerString(string4), type);
                        }
                        if (map != null && (set2 = (Set) map.get(key4)) != null) {
                            Iterator it = set2.iterator();
                            while (it.hasNext()) {
                                map3.put(AsciiUtil.toLowerString((String) it.next()), type);
                            }
                        }
                        if (map2 != null && (set = (Set) map2.get(string4)) != null) {
                            Iterator it2 = set.iterator();
                            while (it2.hasNext()) {
                                map3.put(AsciiUtil.toLowerString((String) it2.next()), type);
                            }
                        }
                    } else {
                        if (enumSetNoneOf == null) {
                            enumSetNoneOf = EnumSet.noneOf(SpecialType.class);
                        }
                        enumSetNoneOf.add(SpecialType.valueOf(key4));
                        linkedHashSet.add(key4);
                    }
                    uResourceBundle2 = uResourceBundle8;
                    uResourceBundle7 = uResourceBundle9;
                    iterator = uResourceBundleIterator;
                }
            } else {
                enumSetNoneOf = null;
            }
            UResourceBundle uResourceBundle10 = uResourceBundle2;
            UResourceBundleIterator uResourceBundleIterator2 = iterator;
            UResourceBundle uResourceBundle11 = uResourceBundle7;
            KeyData keyData = new KeyData(key, string, map3, enumSetNoneOf);
            Map<String, KeyData> map4 = KEYMAP;
            map4.put(AsciiUtil.toLowerString(key), keyData);
            if (!z) {
                map4.put(AsciiUtil.toLowerString(string), keyData);
            }
            uResourceBundle2 = uResourceBundle10;
            uResourceBundle7 = uResourceBundle11;
            iterator = uResourceBundleIterator2;
        }
        BCP47_KEYS = Collections.unmodifiableMap(linkedHashMap);
    }

    private static void initFromTables() {
        int i;
        HashMap map;
        HashMap map2;
        int i2;
        int i3;
        Set hashSet;
        Object[][] objArr = KEY_DATA;
        int length = objArr.length;
        int i4 = 0;
        int i5 = 0;
        while (i5 < length) {
            Object[] objArr2 = objArr[i5];
            String str = (String) objArr2[i4];
            int i6 = 1;
            String str2 = (String) objArr2[1];
            String[][] strArr = (String[][]) objArr2[2];
            String[][] strArr2 = (String[][]) objArr2[3];
            String[][] strArr3 = (String[][]) objArr2[4];
            if (str2 == null) {
                str2 = str;
                i = 1;
            } else {
                i = i4;
            }
            if (strArr2 != null) {
                map = new HashMap();
                int length2 = strArr2.length;
                int i7 = i4;
                while (i7 < length2) {
                    String[] strArr4 = strArr2[i7];
                    int i8 = i4;
                    String str3 = strArr4[i8];
                    String str4 = strArr4[i6];
                    Set set = (Set) map.get(str4);
                    int i9 = i6;
                    if (set == null) {
                        hashSet = new HashSet();
                        map.put(str4, hashSet);
                    } else {
                        hashSet = set;
                    }
                    hashSet.add(str3);
                    i7++;
                    i4 = i8;
                    i6 = i9;
                }
            } else {
                map = null;
            }
            int i10 = i4;
            int i11 = i6;
            if (strArr3 != null) {
                map2 = new HashMap();
                int length3 = strArr3.length;
                for (int i12 = i10; i12 < length3; i12++) {
                    String[] strArr5 = strArr3[i12];
                    String str5 = strArr5[i10];
                    String str6 = strArr5[i11];
                    Set hashSet2 = (Set) map2.get(str6);
                    if (hashSet2 == null) {
                        hashSet2 = new HashSet();
                        map2.put(str6, hashSet2);
                    }
                    hashSet2.add(str5);
                }
            } else {
                map2 = null;
            }
            HashMap map3 = new HashMap();
            int length4 = strArr.length;
            int i13 = i10;
            HashSet hashSet3 = null;
            while (i13 < length4) {
                String[] strArr6 = strArr[i13];
                String str7 = strArr6[i10];
                String str8 = strArr6[i11];
                SpecialType[] specialTypeArrValues = SpecialType.values();
                Object[][] objArr3 = objArr;
                int length5 = specialTypeArrValues.length;
                int i14 = length;
                int i15 = i10;
                while (true) {
                    if (i15 >= length5) {
                        i2 = i10;
                        break;
                    }
                    int i16 = length5;
                    SpecialType specialType = specialTypeArrValues[i15];
                    int i17 = i15;
                    if (str7.equals(specialType.toString())) {
                        if (hashSet3 == null) {
                            hashSet3 = new HashSet();
                        }
                        hashSet3.add(specialType);
                        i2 = i11;
                        break;
                    }
                    i15 = i17 + 1;
                    length5 = i16;
                }
                if (i2 == 0) {
                    if (str8 == null) {
                        str8 = str7;
                        i3 = i11;
                    } else {
                        i3 = i10;
                    }
                    Type type = new Type(str7, str8);
                    map3.put(AsciiUtil.toLowerString(str7), type);
                    if (i3 == 0) {
                        map3.put(AsciiUtil.toLowerString(str8), type);
                    }
                    Set set2 = (Set) map.get(str7);
                    if (set2 != null) {
                        Iterator it = set2.iterator();
                        while (it.hasNext()) {
                            map3.put(AsciiUtil.toLowerString((String) it.next()), type);
                        }
                    }
                    Set set3 = (Set) map2.get(str8);
                    if (set3 != null) {
                        Iterator it2 = set3.iterator();
                        while (it2.hasNext()) {
                            map3.put(AsciiUtil.toLowerString((String) it2.next()), type);
                        }
                    }
                }
                i13++;
                objArr = objArr3;
                length = i14;
            }
            Object[][] objArr4 = objArr;
            int i18 = length;
            KeyData keyData = new KeyData(str, str2, map3, hashSet3 != null ? EnumSet.copyOf((Collection) hashSet3) : null);
            Map<String, KeyData> map4 = KEYMAP;
            map4.put(AsciiUtil.toLowerString(str), keyData);
            if (i == 0) {
                map4.put(AsciiUtil.toLowerString(str2), keyData);
            }
            i5++;
            i4 = i10;
            objArr = objArr4;
            length = i18;
        }
    }

    public static boolean isDeprecated(String str, String str2) {
        Set<String> set = DEPRECATED_KEY_TYPES.get(str);
        if (set == null) {
            return false;
        }
        return set.contains(str2);
    }

    public static String toBcpKey(String str) {
        KeyData keyData = KEYMAP.get(AsciiUtil.toLowerString(str));
        if (keyData != null) {
            return keyData.bcpId;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r1v11, types: [T, java.lang.Boolean] */
    public static String toBcpType(String str, String str2, Output<Boolean> output, Output<Boolean> output2) {
        if (output != null) {
            output.value = Boolean.FALSE;
        }
        if (output2 != null) {
            output2.value = Boolean.FALSE;
        }
        String lowerString = AsciiUtil.toLowerString(str);
        String lowerString2 = AsciiUtil.toLowerString(str2);
        KeyData keyData = KEYMAP.get(lowerString);
        if (keyData == null) {
            return null;
        }
        if (output != null) {
            output.value = Boolean.TRUE;
        }
        Type type = keyData.typeMap.get(lowerString2);
        if (type != null) {
            return type.bcpId;
        }
        EnumSet<SpecialType> enumSet = keyData.specialTypes;
        if (enumSet == null) {
            return null;
        }
        for (SpecialType specialType : enumSet) {
            if (specialType.handler.isWellFormed(lowerString2)) {
                if (output2 != null) {
                    output2.value = Boolean.TRUE;
                }
                return specialType.handler.canonicalize(lowerString2);
            }
        }
        return null;
    }

    public static String toLegacyKey(String str) {
        KeyData keyData = KEYMAP.get(AsciiUtil.toLowerString(str));
        if (keyData != null) {
            return keyData.legacyId;
        }
        return null;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v4, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.Boolean] */
    /* JADX WARN: Type inference failed for: r1v11, types: [T, java.lang.Boolean] */
    public static String toLegacyType(String str, String str2, Output<Boolean> output, Output<Boolean> output2) {
        if (output != null) {
            output.value = Boolean.FALSE;
        }
        if (output2 != null) {
            output2.value = Boolean.FALSE;
        }
        String lowerString = AsciiUtil.toLowerString(str);
        String lowerString2 = AsciiUtil.toLowerString(str2);
        KeyData keyData = KEYMAP.get(lowerString);
        if (keyData == null) {
            return null;
        }
        if (output != null) {
            output.value = Boolean.TRUE;
        }
        Type type = keyData.typeMap.get(lowerString2);
        if (type != null) {
            return type.legacyId;
        }
        EnumSet<SpecialType> enumSet = keyData.specialTypes;
        if (enumSet == null) {
            return null;
        }
        for (SpecialType specialType : enumSet) {
            if (specialType.handler.isWellFormed(lowerString2)) {
                if (output2 != null) {
                    output2.value = Boolean.TRUE;
                }
                return specialType.handler.canonicalize(lowerString2);
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class SpecialTypeHandler {
        public /* synthetic */ SpecialTypeHandler(int i) {
            this();
        }

        public String canonicalize(String str) {
            return AsciiUtil.toLowerString(str);
        }

        public abstract boolean isWellFormed(String str);

        private SpecialTypeHandler() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CodepointsTypeHandler extends SpecialTypeHandler {
        private static final Pattern pat = Pattern.compile("[0-9a-fA-F]{4,6}(-[0-9a-fA-F]{4,6})*");

        private CodepointsTypeHandler() {
            super(0);
        }

        @Override // com.ibm.icu.impl.locale.KeyTypeData.SpecialTypeHandler
        public boolean isWellFormed(String str) {
            return pat.matcher(str).matches();
        }

        public /* synthetic */ CodepointsTypeHandler(int i) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class PrivateUseKeyValueTypeHandler extends SpecialTypeHandler {
        private static final Pattern pat = Pattern.compile("[a-zA-Z0-9]{3,8}(-[a-zA-Z0-9]{3,8})*");

        private PrivateUseKeyValueTypeHandler() {
            super(0);
        }

        @Override // com.ibm.icu.impl.locale.KeyTypeData.SpecialTypeHandler
        public boolean isWellFormed(String str) {
            return pat.matcher(str).matches();
        }

        public /* synthetic */ PrivateUseKeyValueTypeHandler(int i) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ReorderCodeTypeHandler extends SpecialTypeHandler {
        private static final Pattern pat = Pattern.compile("[a-zA-Z]{3,8}(-[a-zA-Z]{3,8})*");

        private ReorderCodeTypeHandler() {
            super(0);
        }

        @Override // com.ibm.icu.impl.locale.KeyTypeData.SpecialTypeHandler
        public boolean isWellFormed(String str) {
            return pat.matcher(str).matches();
        }

        public /* synthetic */ ReorderCodeTypeHandler(int i) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RgKeyValueTypeHandler extends SpecialTypeHandler {
        private static final Pattern pat = Pattern.compile("([a-zA-Z]{2}|[0-9]{3})[zZ]{4}");

        private RgKeyValueTypeHandler() {
            super(0);
        }

        @Override // com.ibm.icu.impl.locale.KeyTypeData.SpecialTypeHandler
        public boolean isWellFormed(String str) {
            return pat.matcher(str).matches();
        }

        public /* synthetic */ RgKeyValueTypeHandler(int i) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ScriptCodeTypeHandler extends SpecialTypeHandler {
        private static final Pattern pat = Pattern.compile("[a-zA-Z]{4}(-[a-zA-Z]{4})*");

        private ScriptCodeTypeHandler() {
            super(0);
        }

        @Override // com.ibm.icu.impl.locale.KeyTypeData.SpecialTypeHandler
        public boolean isWellFormed(String str) {
            return pat.matcher(str).matches();
        }

        public /* synthetic */ ScriptCodeTypeHandler(int i) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class SubdivisionKeyValueTypeHandler extends SpecialTypeHandler {
        private static final Pattern pat = Pattern.compile("([a-zA-Z]{2}|[0-9]{3})");

        private SubdivisionKeyValueTypeHandler() {
            super(0);
        }

        @Override // com.ibm.icu.impl.locale.KeyTypeData.SpecialTypeHandler
        public boolean isWellFormed(String str) {
            return pat.matcher(str).matches();
        }

        public /* synthetic */ SubdivisionKeyValueTypeHandler(int i) {
            this();
        }
    }

    public static boolean isDeprecated(String str) {
        return DEPRECATED_KEYS.contains(str);
    }
}
