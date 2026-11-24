package com.ibm.icu.impl.locale;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.text.Bidi;
import com.ibm.icu.util.BytesTrie;
import com.ibm.icu.util.Region;
import com.ibm.icu.util.ULocale;
import defpackage.cq;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class LikelySubtags {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final boolean DEBUG_OUTPUT = false;
    public static final LikelySubtags INSTANCE = new LikelySubtags(Data.load());
    private static final String PSEUDO_ACCENTS_PREFIX = "'";
    private static final String PSEUDO_BIDI_PREFIX = "+";
    private static final String PSEUDO_CRACKED_PREFIX = ",";
    public static final int SKIP_SCRIPT = 1;
    private final int defaultLsrIndex;
    private final Map<String, String> languageAliases;
    private final LSR[] lsrs;
    private final Map<String, String> regionAliases;
    private final BytesTrie trie;
    private final long[] trieFirstLetterStates = new long[26];
    private final long trieUndState;
    private final long trieUndZzzzState;

    /* JADX INFO: renamed from: com.ibm.icu.impl.locale.LikelySubtags$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$util$BytesTrie$Result;

        static {
            int[] iArr = new int[BytesTrie.Result.values().length];
            $SwitchMap$com$ibm$icu$util$BytesTrie$Result = iArr;
            try {
                iArr[BytesTrie.Result.NO_MATCH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$BytesTrie$Result[BytesTrie.Result.NO_VALUE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$BytesTrie$Result[BytesTrie.Result.INTERMEDIATE_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$BytesTrie$Result[BytesTrie.Result.FINAL_VALUE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Data {
        public final Map<String, String> languageAliases;
        public final LSR[] lsrs;
        public final Map<String, String> regionAliases;
        public final byte[] trie;

        public Data(Map<String, String> map, Map<String, String> map2, byte[] bArr, LSR[] lsrArr) {
            this.languageAliases = map;
            this.regionAliases = map2;
            this.trie = bArr;
            this.lsrs = lsrArr;
        }

        private static UResource.Value getValue(UResource.Table table, String str, UResource.Value value) {
            if (table.findValue(str, value)) {
                return value;
            }
            throw new MissingResourceException("langInfo.res missing data", "", cq.j("likely/", str));
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r4v1, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r4v2, types: [java.util.HashMap] */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.Map] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.util.HashMap] */
        public static Data load() {
            Object map;
            Object map2;
            UResource.Value valueWithFallback = ICUResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "langInfo", ICUResourceBundle.ICU_DATA_CLASS_LOADER, ICUResourceBundle.OpenType.DIRECT).getValueWithFallback("likely");
            UResource.Table table = valueWithFallback.getTable();
            if (table.findValue("languageAliases", valueWithFallback)) {
                String[] stringArray = valueWithFallback.getStringArray();
                map = new HashMap(stringArray.length / 2);
                for (int i = 0; i < stringArray.length; i += 2) {
                    map.put(stringArray[i], stringArray[i + 1]);
                }
            } else {
                map = Collections.EMPTY_MAP;
            }
            if (table.findValue("regionAliases", valueWithFallback)) {
                String[] stringArray2 = valueWithFallback.getStringArray();
                map2 = new HashMap(stringArray2.length / 2);
                for (int i2 = 0; i2 < stringArray2.length; i2 += 2) {
                    map2.put(stringArray2[i2], stringArray2[i2 + 1]);
                }
            } else {
                map2 = Collections.EMPTY_MAP;
            }
            ByteBuffer binary = getValue(table, "trie", valueWithFallback).getBinary();
            byte[] bArr = new byte[binary.remaining()];
            binary.get(bArr);
            return new Data(map, map2, bArr, LSR.decodeInts(getValue(table, "lsrnum", valueWithFallback).getIntVector(), getValue(table, "m49", valueWithFallback).getStringArray()));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Data.class.equals(obj.getClass())) {
                Data data = (Data) obj;
                if (this.languageAliases.equals(data.languageAliases) && this.regionAliases.equals(data.regionAliases) && Arrays.equals(this.trie, data.trie) && Arrays.equals(this.lsrs, data.lsrs)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return 1;
        }
    }

    private LikelySubtags(Data data) {
        this.languageAliases = data.languageAliases;
        this.regionAliases = data.regionAliases;
        BytesTrie bytesTrie = new BytesTrie(data.trie, 0);
        this.trie = bytesTrie;
        this.lsrs = data.lsrs;
        bytesTrie.next(42);
        this.trieUndState = bytesTrie.getState64();
        bytesTrie.next(42);
        this.trieUndZzzzState = bytesTrie.getState64();
        bytesTrie.next(42);
        this.defaultLsrIndex = bytesTrie.getValue();
        bytesTrie.reset();
        for (char c = 'a'; c <= 'z'; c = (char) (c + 1)) {
            if (this.trie.next(c) == BytesTrie.Result.NO_VALUE) {
                this.trieFirstLetterStates[c - 'a'] = this.trie.getState64();
            }
            this.trie.reset();
        }
    }

    private static String getCanonical(Map<String, String> map, String str) {
        String str2 = map.get(str);
        return str2 == null ? str : str2;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0043  */
    private int getLikelyIndex(String str, String str2) {
        int iTrieNext;
        long state64;
        int iCharAt;
        if (str.equals("und")) {
            str = "";
        }
        if (str2.equals("Zzzz")) {
            str2 = "";
        }
        BytesTrie bytesTrie = new BytesTrie(this.trie);
        if (str.length() < 2 || (iCharAt = str.charAt(0) - 'a') < 0 || iCharAt > 25) {
            iTrieNext = trieNext(bytesTrie, str, 0);
        } else {
            long j = this.trieFirstLetterStates[iCharAt];
            if (j != 0) {
                iTrieNext = trieNext(bytesTrie.resetToState64(j), str, 1);
            } else {
                iTrieNext = trieNext(bytesTrie, str, 0);
            }
        }
        if (iTrieNext >= 0) {
            state64 = bytesTrie.getState64();
        } else {
            bytesTrie.resetToState64(this.trieUndState);
            state64 = 0;
        }
        if (iTrieNext <= 0) {
            iTrieNext = trieNext(bytesTrie, str2, 0);
            if (iTrieNext >= 0) {
                bytesTrie.getState64();
            } else if (state64 == 0) {
                bytesTrie.resetToState64(this.trieUndZzzzState);
            } else {
                bytesTrie.resetToState64(state64);
                iTrieNext = trieNext(bytesTrie, "", 0);
                bytesTrie.getState64();
            }
        } else if (iTrieNext == 1) {
            iTrieNext = 0;
        }
        return iTrieNext > 0 ? iTrieNext : trieNext(bytesTrie, "", 0);
    }

    private Map<String, LSR> getTable() {
        TreeMap treeMap = new TreeMap();
        StringBuilder sb = new StringBuilder();
        Iterator<BytesTrie.Entry> itIterator2 = this.trie.iterator2();
        while (itIterator2.hasNext()) {
            BytesTrie.Entry next = itIterator2.next();
            int i = 0;
            sb.setLength(0);
            int iBytesLength = next.bytesLength();
            while (i < iBytesLength) {
                int i2 = i + 1;
                byte bByteAt = next.byteAt(i);
                if (bByteAt == 42) {
                    sb.append("*-");
                } else if (bByteAt >= 0) {
                    sb.append((char) bByteAt);
                } else {
                    sb.append((char) (bByteAt & Bidi.LEVEL_DEFAULT_RTL));
                    sb.append('-');
                }
                i = i2;
            }
            sb.setLength(sb.length() - 1);
            treeMap.put(sb.toString(), this.lsrs[next.value]);
        }
        return treeMap;
    }

    private boolean isMacroregion(String str) {
        Region.RegionType type = Region.getInstance(str).getType();
        return type == Region.RegionType.WORLD || type == Region.RegionType.CONTINENT || type == Region.RegionType.SUBCONTINENT;
    }

    private LSR makeMaximizedLsr(String str, String str2, String str3, String str4, boolean z) {
        if (!z) {
            if (str3.length() == 2 && str3.charAt(0) == 'X') {
                switch (str3.charAt(1)) {
                    case 'A':
                        return new LSR(cq.j(PSEUDO_ACCENTS_PREFIX, str), cq.j(PSEUDO_ACCENTS_PREFIX, str2), str3, 7);
                    case 'B':
                        return new LSR(cq.j(PSEUDO_BIDI_PREFIX, str), cq.j(PSEUDO_BIDI_PREFIX, str2), str3, 7);
                    case 'C':
                        return new LSR(cq.j(PSEUDO_CRACKED_PREFIX, str), cq.j(PSEUDO_CRACKED_PREFIX, str2), str3, 7);
                }
            }
            if (str4.startsWith("PS")) {
                int i = str3.isEmpty() ? 6 : 7;
                switch (str4) {
                    case "PSBIDI":
                        String strJ = cq.j(PSEUDO_BIDI_PREFIX, str);
                        String strJ2 = cq.j(PSEUDO_BIDI_PREFIX, str2);
                        if (str3.isEmpty()) {
                            str3 = "XB";
                        }
                        return new LSR(strJ, strJ2, str3, i);
                    case "PSACCENT":
                        String strJ3 = cq.j(PSEUDO_ACCENTS_PREFIX, str);
                        String strJ4 = cq.j(PSEUDO_ACCENTS_PREFIX, str2);
                        if (str3.isEmpty()) {
                            str3 = "XA";
                        }
                        return new LSR(strJ3, strJ4, str3, i);
                    case "PSCRACK":
                        String strJ5 = cq.j(PSEUDO_CRACKED_PREFIX, str);
                        String strJ6 = cq.j(PSEUDO_CRACKED_PREFIX, str2);
                        if (str3.isEmpty()) {
                            str3 = "XC";
                        }
                        return new LSR(strJ5, strJ6, str3, i);
                }
            }
        }
        return maximize(getCanonical(this.languageAliases, str), str2, getCanonical(this.regionAliases, str3), z);
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0175  */
    /* JADX WARN: Code duplicated, block: B:31:0x0075  */
    /* JADX WARN: Code duplicated, block: B:32:0x0077  */
    /* JADX WARN: Code duplicated, block: B:34:0x007a  */
    /* JADX WARN: Code duplicated, block: B:35:0x0084  */
    /* JADX WARN: Code duplicated, block: B:40:0x0096  */
    /* JADX WARN: Code duplicated, block: B:42:0x0099 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x009b  */
    /* JADX WARN: Code duplicated, block: B:46:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:48:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:49:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:56:0x00db  */
    /* JADX WARN: Code duplicated, block: B:58:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:64:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:66:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:69:0x0102  */
    /* JADX WARN: Code duplicated, block: B:71:0x0124  */
    /* JADX WARN: Code duplicated, block: B:73:0x012e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:83:0x0148  */
    /* JADX WARN: Code duplicated, block: B:85:0x014b A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:90:0x0156  */
    /* JADX WARN: Code duplicated, block: B:92:0x015e  */
    /* JADX WARN: Code duplicated, block: B:94:0x0166  */
    /* JADX WARN: Code duplicated, block: B:96:0x016e  */
    /* JADX WARN: Code duplicated, block: B:97:0x0170  */
    /* JADX WARN: Code duplicated, block: B:99:0x0173  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v11, types: [int] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v8 */
    private LSR maximize(String str, String str2, String str3, boolean z) {
        long j;
        int iTrieNext;
        boolean z2;
        long state64;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        long state65;
        Object r3;
        String str4;
        int i;
        int i2;
        int iCharAt;
        String str5 = str;
        if (str5.equals("und")) {
            str5 = "";
        }
        String str6 = str2;
        if (str6.equals("Zzzz")) {
            str6 = "";
        }
        String str7 = str3;
        if (str7.equals("ZZ")) {
            str7 = "";
        }
        if (!str6.isEmpty() && !str7.isEmpty() && !str5.isEmpty()) {
            return new LSR(str5, str6, str7, 7);
        }
        BytesTrie bytesTrie = new BytesTrie(this.trie);
        boolean zIsEmpty = true;
        if (str5.length() >= 2 && (iCharAt = str5.charAt(0) - 'a') >= 0 && iCharAt <= 25) {
            j = 0;
            long j2 = this.trieFirstLetterStates[iCharAt];
            if (j2 != 0) {
                iTrieNext = trieNext(bytesTrie.resetToState64(j2), str5, 1);
            }
            if (iTrieNext >= 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (iTrieNext >= 0) {
                z3 = !str5.isEmpty();
                state64 = bytesTrie.getState64();
            } else {
                bytesTrie.resetToState64(this.trieUndState);
                state64 = j;
                z3 = true;
            }
            if (iTrieNext >= 0 || str6.isEmpty()) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (iTrieNext > 0) {
                iTrieNext = trieNext(bytesTrie, str6, 0);
                if (iTrieNext >= 0) {
                    z6 = !str6.isEmpty();
                    state64 = bytesTrie.getState64();
                } else if (state64 == j) {
                    bytesTrie.resetToState64(this.trieUndZzzzState);
                    z5 = true;
                    iTrieNext = iTrieNext;
                } else {
                    bytesTrie.resetToState64(state64);
                    iTrieNext = trieNext(bytesTrie, "", 0);
                    state64 = bytesTrie.getState64();
                    z5 = true;
                }
                if (iTrieNext > 0) {
                    iTrieNext = trieNext(bytesTrie, str7, 0);
                    if (iTrieNext >= 0) {
                        if (!str7.isEmpty() || isMacroregion(str7)) {
                            r3 = 0;
                            zIsEmpty = false;
                        } else {
                            r3 = 1;
                        }
                    } else if (state64 == j) {
                        iTrieNext = this.defaultLsrIndex;
                    } else {
                        bytesTrie.resetToState64(state64);
                        iTrieNext = trieNext(bytesTrie, "", 0);
                        if (iTrieNext < 0) {
                            z3 = !str5.isEmpty();
                            z5 = !str6.isEmpty();
                            zIsEmpty = true ^ str7.isEmpty();
                            bytesTrie.resetToState64(this.trieUndState);
                            trieNext(bytesTrie, "", 0);
                            state65 = bytesTrie.getState64();
                            iTrieNext = trieNext(bytesTrie, str7, 0);
                            if (iTrieNext < 0) {
                                bytesTrie.resetToState64(state65);
                                iTrieNext = trieNext(bytesTrie, "", 0);
                            }
                        }
                    }
                    if (!z && !z2 && !z4 && (!zIsEmpty || !str5.isEmpty())) {
                        return new LSR("", "", "", 7);
                    }
                    str4 = str5.isEmpty() ? "und" : str5;
                    if (z3 && !z5 && r3 == 0) {
                        return this.lsrs[iTrieNext];
                    }
                    if (!z3) {
                        str4 = this.lsrs[iTrieNext].language;
                    }
                    if (!z5) {
                        str6 = this.lsrs[iTrieNext].script;
                    }
                    if (r3 == 0) {
                        str7 = this.lsrs[iTrieNext].region;
                    }
                    if (z3) {
                        i = 4;
                    } else {
                        i = 0;
                    }
                    if (z5) {
                        i2 = 2;
                    } else {
                        i2 = 0;
                    }
                    return new LSR(str4, str6, str7, i + i2 + r3);
                }
                zIsEmpty = true ^ str7.isEmpty();
                r3 = zIsEmpty;
                zIsEmpty = false;
                if (!z) {
                }
                if (str5.isEmpty()) {
                }
                if (z3) {
                }
                if (!z3) {
                    str4 = this.lsrs[iTrieNext].language;
                }
                if (!z5) {
                    str6 = this.lsrs[iTrieNext].script;
                }
                if (r3 == 0) {
                    str7 = this.lsrs[iTrieNext].region;
                }
                if (z3) {
                    i = 4;
                } else {
                    i = 0;
                }
                if (z5) {
                    i2 = 2;
                } else {
                    i2 = 0;
                }
                return new LSR(str4, str6, str7, i + i2 + r3);
            }
            if (iTrieNext == 1) {
                iTrieNext = 0;
            }
            z6 = !str6.isEmpty();
            z5 = z6;
            if (iTrieNext > 0) {
                iTrieNext = trieNext(bytesTrie, str7, 0);
                if (iTrieNext >= 0) {
                    if (str7.isEmpty()) {
                        r3 = 0;
                        zIsEmpty = false;
                    } else {
                        r3 = 0;
                        zIsEmpty = false;
                    }
                } else if (state64 == j) {
                    iTrieNext = this.defaultLsrIndex;
                } else {
                    bytesTrie.resetToState64(state64);
                    iTrieNext = trieNext(bytesTrie, "", 0);
                    if (iTrieNext < 0) {
                        z3 = !str5.isEmpty();
                        z5 = !str6.isEmpty();
                        zIsEmpty = true ^ str7.isEmpty();
                        bytesTrie.resetToState64(this.trieUndState);
                        trieNext(bytesTrie, "", 0);
                        state65 = bytesTrie.getState64();
                        iTrieNext = trieNext(bytesTrie, str7, 0);
                        if (iTrieNext < 0) {
                            bytesTrie.resetToState64(state65);
                            iTrieNext = trieNext(bytesTrie, "", 0);
                        }
                    }
                }
                if (!z) {
                }
                if (str5.isEmpty()) {
                }
                if (z3) {
                }
                if (!z3) {
                    str4 = this.lsrs[iTrieNext].language;
                }
                if (!z5) {
                    str6 = this.lsrs[iTrieNext].script;
                }
                if (r3 == 0) {
                    str7 = this.lsrs[iTrieNext].region;
                }
                if (z3) {
                    i = 4;
                } else {
                    i = 0;
                }
                if (z5) {
                    i2 = 2;
                } else {
                    i2 = 0;
                }
                return new LSR(str4, str6, str7, i + i2 + r3);
            }
            zIsEmpty = true ^ str7.isEmpty();
            r3 = zIsEmpty;
            zIsEmpty = false;
            if (!z) {
            }
            if (str5.isEmpty()) {
            }
            if (z3) {
            }
            if (!z3) {
                str4 = this.lsrs[iTrieNext].language;
            }
            if (!z5) {
                str6 = this.lsrs[iTrieNext].script;
            }
            if (r3 == 0) {
                str7 = this.lsrs[iTrieNext].region;
            }
            if (z3) {
                i = 4;
            } else {
                i = 0;
            }
            if (z5) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            return new LSR(str4, str6, str7, i + i2 + r3);
        }
        j = 0;
        iTrieNext = trieNext(bytesTrie, str5, 0);
        if (iTrieNext >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (iTrieNext >= 0) {
            z3 = !str5.isEmpty();
            state64 = bytesTrie.getState64();
        } else {
            bytesTrie.resetToState64(this.trieUndState);
            state64 = j;
            z3 = true;
        }
        if (iTrieNext >= 0) {
            z4 = false;
        } else {
            z4 = false;
        }
        if (iTrieNext > 0) {
            iTrieNext = trieNext(bytesTrie, str6, 0);
            if (iTrieNext >= 0) {
                z6 = !str6.isEmpty();
                state64 = bytesTrie.getState64();
            } else if (state64 == j) {
                bytesTrie.resetToState64(this.trieUndZzzzState);
                z5 = true;
                iTrieNext = iTrieNext;
            } else {
                bytesTrie.resetToState64(state64);
                iTrieNext = trieNext(bytesTrie, "", 0);
                state64 = bytesTrie.getState64();
                z5 = true;
            }
            if (iTrieNext > 0) {
                iTrieNext = trieNext(bytesTrie, str7, 0);
                if (iTrieNext >= 0) {
                    if (str7.isEmpty()) {
                        r3 = 0;
                        zIsEmpty = false;
                    } else {
                        r3 = 0;
                        zIsEmpty = false;
                    }
                } else if (state64 == j) {
                    iTrieNext = this.defaultLsrIndex;
                } else {
                    bytesTrie.resetToState64(state64);
                    iTrieNext = trieNext(bytesTrie, "", 0);
                    if (iTrieNext < 0) {
                        z3 = !str5.isEmpty();
                        z5 = !str6.isEmpty();
                        zIsEmpty = true ^ str7.isEmpty();
                        bytesTrie.resetToState64(this.trieUndState);
                        trieNext(bytesTrie, "", 0);
                        state65 = bytesTrie.getState64();
                        iTrieNext = trieNext(bytesTrie, str7, 0);
                        if (iTrieNext < 0) {
                            bytesTrie.resetToState64(state65);
                            iTrieNext = trieNext(bytesTrie, "", 0);
                        }
                    }
                }
                if (!z) {
                }
                if (str5.isEmpty()) {
                }
                if (z3) {
                }
                if (!z3) {
                    str4 = this.lsrs[iTrieNext].language;
                }
                if (!z5) {
                    str6 = this.lsrs[iTrieNext].script;
                }
                if (r3 == 0) {
                    str7 = this.lsrs[iTrieNext].region;
                }
                if (z3) {
                    i = 4;
                } else {
                    i = 0;
                }
                if (z5) {
                    i2 = 2;
                } else {
                    i2 = 0;
                }
                return new LSR(str4, str6, str7, i + i2 + r3);
            }
            zIsEmpty = true ^ str7.isEmpty();
            r3 = zIsEmpty;
            zIsEmpty = false;
            if (!z) {
            }
            if (str5.isEmpty()) {
            }
            if (z3) {
            }
            if (!z3) {
                str4 = this.lsrs[iTrieNext].language;
            }
            if (!z5) {
                str6 = this.lsrs[iTrieNext].script;
            }
            if (r3 == 0) {
                str7 = this.lsrs[iTrieNext].region;
            }
            if (z3) {
                i = 4;
            } else {
                i = 0;
            }
            if (z5) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            return new LSR(str4, str6, str7, i + i2 + r3);
        }
        if (iTrieNext == 1) {
            iTrieNext = 0;
        }
        z6 = !str6.isEmpty();
        z5 = z6;
        if (iTrieNext > 0) {
            iTrieNext = trieNext(bytesTrie, str7, 0);
            if (iTrieNext >= 0) {
                if (str7.isEmpty()) {
                    r3 = 0;
                    zIsEmpty = false;
                } else {
                    r3 = 0;
                    zIsEmpty = false;
                }
            } else if (state64 == j) {
                iTrieNext = this.defaultLsrIndex;
            } else {
                bytesTrie.resetToState64(state64);
                iTrieNext = trieNext(bytesTrie, "", 0);
                if (iTrieNext < 0) {
                    z3 = !str5.isEmpty();
                    z5 = !str6.isEmpty();
                    zIsEmpty = true ^ str7.isEmpty();
                    bytesTrie.resetToState64(this.trieUndState);
                    trieNext(bytesTrie, "", 0);
                    state65 = bytesTrie.getState64();
                    iTrieNext = trieNext(bytesTrie, str7, 0);
                    if (iTrieNext < 0) {
                        bytesTrie.resetToState64(state65);
                        iTrieNext = trieNext(bytesTrie, "", 0);
                    }
                }
            }
            if (!z) {
            }
            if (str5.isEmpty()) {
            }
            if (z3) {
            }
            if (!z3) {
                str4 = this.lsrs[iTrieNext].language;
            }
            if (!z5) {
                str6 = this.lsrs[iTrieNext].script;
            }
            if (r3 == 0) {
                str7 = this.lsrs[iTrieNext].region;
            }
            if (z3) {
                i = 4;
            } else {
                i = 0;
            }
            if (z5) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            return new LSR(str4, str6, str7, i + i2 + r3);
        }
        zIsEmpty = true ^ str7.isEmpty();
        r3 = zIsEmpty;
        zIsEmpty = false;
        if (!z) {
        }
        if (str5.isEmpty()) {
        }
        if (z3) {
        }
        if (!z3) {
            str4 = this.lsrs[iTrieNext].language;
        }
        if (!z5) {
            str6 = this.lsrs[iTrieNext].script;
        }
        if (r3 == 0) {
            str7 = this.lsrs[iTrieNext].region;
        }
        if (z3) {
            i = 4;
        } else {
            i = 0;
        }
        if (z5) {
            i2 = 2;
        } else {
            i2 = 0;
        }
        return new LSR(str4, str6, str7, i + i2 + r3);
    }

    private static final int trieNext(BytesTrie bytesTrie, String str, int i) {
        BytesTrie.Result next;
        if (!str.isEmpty()) {
            int length = str.length() - 1;
            while (true) {
                char cCharAt = str.charAt(i);
                if (i >= length) {
                    next = bytesTrie.next(cCharAt | 128);
                    break;
                }
                if (!bytesTrie.next(cCharAt).hasNext()) {
                    return -1;
                }
                i++;
            }
        } else {
            next = bytesTrie.next(42);
        }
        int i2 = AnonymousClass1.$SwitchMap$com$ibm$icu$util$BytesTrie$Result[next.ordinal()];
        if (i2 == 2) {
            return 0;
        }
        if (i2 == 3) {
            return 1;
        }
        if (i2 != 4) {
            return -1;
        }
        return bytesTrie.getValue();
    }

    public ULocale canonicalize(ULocale uLocale) {
        String language = uLocale.getLanguage();
        String str = this.languageAliases.get(language);
        String country = uLocale.getCountry();
        String str2 = this.regionAliases.get(country);
        if (str == null && str2 == null) {
            return uLocale;
        }
        if (str != null) {
            language = str;
        }
        String script = uLocale.getScript();
        if (str2 != null) {
            country = str2;
        }
        return new ULocale(language, script, country);
    }

    public int compareLikely(LSR lsr, LSR lsr2, int i) {
        int likelyIndex;
        int likelyIndex2;
        if (!lsr.language.equals(lsr2.language)) {
            return -4;
        }
        if (!lsr.script.equals(lsr2.script)) {
            if (i < 0 || (i & 2) != 0) {
                likelyIndex2 = getLikelyIndex(lsr.language, "");
                i = likelyIndex2 << 2;
            } else {
                likelyIndex2 = i >> 2;
            }
            return lsr.script.equals(this.lsrs[likelyIndex2].script) ? i | 1 : i & (-2);
        }
        if (lsr.region.equals(lsr2.region)) {
            return i & (-2);
        }
        if (i < 0 || (i & 2) == 0) {
            likelyIndex = getLikelyIndex(lsr.language, lsr.region);
            i = (likelyIndex << 2) | 2;
        } else {
            likelyIndex = i >> 2;
        }
        return lsr.region.equals(this.lsrs[likelyIndex].region) ? i | 1 : i & (-2);
    }

    public LSR makeMaximizedLsrFrom(ULocale uLocale, boolean z) {
        if (uLocale.getName().startsWith("@x=")) {
            return new LSR(uLocale.toLanguageTag(), "", "", 7);
        }
        LSR lsrMakeMaximizedLsr = makeMaximizedLsr(uLocale.getLanguage(), uLocale.getScript(), uLocale.getCountry(), uLocale.getVariant(), z);
        return (lsrMakeMaximizedLsr.language.isEmpty() && lsrMakeMaximizedLsr.script.isEmpty() && lsrMakeMaximizedLsr.region.isEmpty()) ? new LSR(uLocale.getLanguage(), uLocale.getScript(), uLocale.getCountry(), 7) : lsrMakeMaximizedLsr;
    }

    public LSR minimizeSubtags(String str, String str2, String str3, ULocale.Minimize minimize) {
        LSR lsrMaximize = maximize(str, str2, str3, true);
        if (lsrMaximize.language.isEmpty() && lsrMaximize.region.isEmpty() && lsrMaximize.script.isEmpty()) {
            return new LSR(str, str2, str3, 7);
        }
        if (maximize(lsrMaximize.language, "", "", true).isEquivalentTo(lsrMaximize)) {
            return new LSR(lsrMaximize.language, "", "", 0);
        }
        ULocale.Minimize minimize2 = ULocale.Minimize.FAVOR_REGION;
        String str4 = lsrMaximize.language;
        if (minimize2 == minimize) {
            boolean zIsEquivalentTo = maximize(str4, "", lsrMaximize.region, true).isEquivalentTo(lsrMaximize);
            String str5 = lsrMaximize.language;
            if (zIsEquivalentTo) {
                return new LSR(str5, "", lsrMaximize.region, 0);
            }
            if (maximize(str5, lsrMaximize.script, "", true).isEquivalentTo(lsrMaximize)) {
                return new LSR(lsrMaximize.language, lsrMaximize.script, "", 0);
            }
        } else {
            boolean zIsEquivalentTo2 = maximize(str4, lsrMaximize.script, "", true).isEquivalentTo(lsrMaximize);
            String str6 = lsrMaximize.language;
            if (zIsEquivalentTo2) {
                return new LSR(str6, lsrMaximize.script, "", 0);
            }
            if (maximize(str6, "", lsrMaximize.region, true).isEquivalentTo(lsrMaximize)) {
                return new LSR(lsrMaximize.language, "", lsrMaximize.region, 0);
            }
        }
        return new LSR(lsrMaximize.language, lsrMaximize.script, lsrMaximize.region, 0);
    }

    public String toString() {
        return getTable().toString();
    }

    public LSR makeMaximizedLsrFrom(Locale locale) {
        String languageTag = locale.toLanguageTag();
        if (!languageTag.startsWith("x-") && !languageTag.startsWith("und-x-")) {
            return makeMaximizedLsr(locale.getLanguage(), locale.getScript(), locale.getCountry(), locale.getVariant(), false);
        }
        return new LSR(languageTag, "", "", 7);
    }
}
