package com.ibm.icu.impl;

import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import defpackage.og;
import java.util.EnumMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class StaticUnicodeSets {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Map<Key, UnicodeSet> unicodeSets;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Key {
        EMPTY,
        DEFAULT_IGNORABLES,
        STRICT_IGNORABLES,
        COMMA,
        PERIOD,
        STRICT_COMMA,
        STRICT_PERIOD,
        APOSTROPHE_SIGN,
        OTHER_GROUPING_SEPARATORS,
        ALL_SEPARATORS,
        STRICT_ALL_SEPARATORS,
        MINUS_SIGN,
        PLUS_SIGN,
        PERCENT_SIGN,
        PERMILLE_SIGN,
        INFINITY_SIGN,
        APPROXIMATELY_SIGN,
        DOLLAR_SIGN,
        POUND_SIGN,
        RUPEE_SIGN,
        YEN_SIGN,
        WON_SIGN,
        DIGITS,
        DIGITS_OR_ALL_SEPARATORS,
        DIGITS_OR_STRICT_ALL_SEPARATORS
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ParseDataSink extends UResource.Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        @Override // com.ibm.icu.impl.UResource.Sink
        public void put(UResource.Key key, UResource.Value value, boolean z) {
            UResource.Table table = value.getTable();
            for (int i = 0; table.getKeyAndValue(i, key, value); i++) {
                if (!key.contentEquals("date")) {
                    UResource.Table table2 = value.getTable();
                    for (int i2 = 0; table2.getKeyAndValue(i2, key, value); i2++) {
                        boolean zContentEquals = key.contentEquals("lenient");
                        UResource.Array array = value.getArray();
                        for (int i3 = 0; i3 < array.getSize(); i3++) {
                            array.getValue(i3, value);
                            String string = value.toString();
                            if (string.indexOf(46) != -1) {
                                StaticUnicodeSets.saveSet(zContentEquals ? Key.PERIOD : Key.STRICT_PERIOD, string);
                            } else if (string.indexOf(44) != -1) {
                                StaticUnicodeSets.saveSet(zContentEquals ? Key.COMMA : Key.STRICT_COMMA, string);
                            } else if (string.indexOf(43) != -1) {
                                StaticUnicodeSets.saveSet(Key.PLUS_SIGN, string);
                            } else if (string.indexOf(45) != -1) {
                                StaticUnicodeSets.saveSet(Key.MINUS_SIGN, string);
                            } else if (string.indexOf(36) != -1) {
                                StaticUnicodeSets.saveSet(Key.DOLLAR_SIGN, string);
                            } else if (string.indexOf(163) != -1) {
                                StaticUnicodeSets.saveSet(Key.POUND_SIGN, string);
                            } else if (string.indexOf(8377) != -1) {
                                StaticUnicodeSets.saveSet(Key.RUPEE_SIGN, string);
                            } else if (string.indexOf(165) != -1) {
                                StaticUnicodeSets.saveSet(Key.YEN_SIGN, string);
                            } else if (string.indexOf(8361) != -1) {
                                StaticUnicodeSets.saveSet(Key.WON_SIGN, string);
                            } else if (string.indexOf(37) != -1) {
                                StaticUnicodeSets.saveSet(Key.PERCENT_SIGN, string);
                            } else if (string.indexOf(8240) != -1) {
                                StaticUnicodeSets.saveSet(Key.PERMILLE_SIGN, string);
                            } else {
                                if (string.indexOf(8217) == -1) {
                                    og.m("Unknown class of parse lenients: ".concat(string));
                                    return;
                                }
                                StaticUnicodeSets.saveSet(Key.APOSTROPHE_SIGN, string);
                            }
                        }
                    }
                }
            }
        }
    }

    static {
        EnumMap enumMap = new EnumMap(Key.class);
        unicodeSets = enumMap;
        enumMap.put(Key.EMPTY, new UnicodeSet("[]").freeze());
        enumMap.put(Key.DEFAULT_IGNORABLES, new UnicodeSet("[[:Zs:][\\u0009][:Bidi_Control:][:Variation_Selector:]]").freeze());
        enumMap.put(Key.STRICT_IGNORABLES, new UnicodeSet("[[:Bidi_Control:]]").freeze());
        ((ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, ULocale.ROOT)).getAllItemsWithFallback("parse", new ParseDataSink());
        UnicodeSet unicodeSet = new UnicodeSet("[٬‘\\u0020\\u00A0\\u2000-\\u200A\\u202F\\u205F\\u3000]");
        unicodeSet.addAll((UnicodeSet) enumMap.get(Key.APOSTROPHE_SIGN));
        Key key = Key.OTHER_GROUPING_SEPARATORS;
        enumMap.put(key, unicodeSet.freeze());
        Key key2 = Key.ALL_SEPARATORS;
        enumMap.put(key2, computeUnion(Key.COMMA, Key.PERIOD, key));
        Key key3 = Key.STRICT_ALL_SEPARATORS;
        enumMap.put(key3, computeUnion(Key.STRICT_COMMA, Key.STRICT_PERIOD, key));
        enumMap.put(Key.INFINITY_SIGN, new UnicodeSet("[∞]").freeze());
        enumMap.put(Key.APPROXIMATELY_SIGN, new UnicodeSet("[∼~≈≃約]").freeze());
        Key key4 = Key.DIGITS;
        enumMap.put(key4, new UnicodeSet("[:digit:]").freeze());
        enumMap.put(Key.DIGITS_OR_ALL_SEPARATORS, computeUnion(key4, key2));
        enumMap.put(Key.DIGITS_OR_STRICT_ALL_SEPARATORS, computeUnion(key4, key3));
    }

    public static Key chooseCurrency(String str) {
        Key key = Key.DOLLAR_SIGN;
        if (get(key).contains(str)) {
            return key;
        }
        Key key2 = Key.POUND_SIGN;
        if (get(key2).contains(str)) {
            return key2;
        }
        Key key3 = Key.RUPEE_SIGN;
        if (get(key3).contains(str)) {
            return key3;
        }
        Key key4 = Key.YEN_SIGN;
        if (get(key4).contains(str)) {
            return key4;
        }
        Key key5 = Key.WON_SIGN;
        if (get(key5).contains(str)) {
            return key5;
        }
        return null;
    }

    public static Key chooseFrom(String str, Key key, Key key2) {
        return get(key).contains(str) ? key : chooseFrom(str, key2);
    }

    private static UnicodeSet computeUnion(Key key, Key key2, Key key3) {
        return new UnicodeSet().addAll(get(key)).addAll(get(key2)).addAll(get(key3)).freeze();
    }

    public static UnicodeSet get(Key key) {
        UnicodeSet unicodeSet = unicodeSets.get(key);
        return unicodeSet == null ? UnicodeSet.EMPTY : unicodeSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void saveSet(Key key, String str) {
        unicodeSets.put(key, new UnicodeSet(str).freeze());
    }

    public static Key chooseFrom(String str, Key key) {
        if (get(key).contains(str)) {
            return key;
        }
        return null;
    }

    private static UnicodeSet computeUnion(Key key, Key key2) {
        return new UnicodeSet().addAll(get(key)).addAll(get(key2)).freeze();
    }
}
