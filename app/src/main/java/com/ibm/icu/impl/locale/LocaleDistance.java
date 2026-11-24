package com.ibm.icu.impl.locale;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.impl.UResource;
import com.ibm.icu.text.Bidi;
import com.ibm.icu.util.BytesTrie;
import com.ibm.icu.util.LocaleMatcher;
import com.ibm.icu.util.ULocale;
import defpackage.cq;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class LocaleDistance {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ABOVE_THRESHOLD = 100;
    private static final boolean DEBUG_OUTPUT = false;
    private static final int DISTANCE_FRACTION_MASK = 7;
    private static final int DISTANCE_INT_SHIFT = 7;
    private static final int DISTANCE_IS_FINAL = 256;
    private static final int DISTANCE_IS_FINAL_OR_SKIP_SCRIPT = 384;
    private static final int DISTANCE_MASK = 1023;
    private static final int DISTANCE_SHIFT = 3;
    public static final int DISTANCE_SKIP_SCRIPT = 128;
    public static final int END_OF_SUBTAG = 128;
    private static final int INDEX_NEG_1 = -1024;
    private static final int INDEX_SHIFT = 10;
    public static final LocaleDistance INSTANCE = new LocaleDistance(Data.load());
    public static final int IX_DEF_LANG_DISTANCE = 0;
    public static final int IX_DEF_REGION_DISTANCE = 2;
    public static final int IX_DEF_SCRIPT_DISTANCE = 1;
    public static final int IX_LIMIT = 4;
    public static final int IX_MIN_REGION_DISTANCE = 3;
    private final int defaultDemotionPerDesiredLocale;
    private final int defaultLanguageDistance;
    private final int defaultRegionDistance;
    private final int defaultScriptDistance;
    private final int minRegionDistance;
    private final Set<LSR> paradigmLSRs;
    private final String[] partitionArrays;
    private final byte[] regionToPartitionsIndex;
    private final BytesTrie trie;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Data {
        public int[] distances;
        public Set<LSR> paradigmLSRs;
        public String[] partitionArrays;
        public byte[] regionToPartitionsIndex;
        public byte[] trie;

        public Data(byte[] bArr, byte[] bArr2, String[] strArr, Set<LSR> set, int[] iArr) {
            this.trie = bArr;
            this.regionToPartitionsIndex = bArr2;
            this.partitionArrays = strArr;
            this.paradigmLSRs = set;
            this.distances = iArr;
        }

        private static UResource.Value getValue(UResource.Table table, String str, UResource.Value value) {
            if (table.findValue(str, value)) {
                return value;
            }
            throw new MissingResourceException("langInfo.res missing data", "", cq.j("match/", str));
        }

        public static Data load() {
            Set linkedHashSet;
            ICUResourceBundle bundleInstance = ICUResourceBundle.getBundleInstance(ICUData.ICU_BASE_NAME, "langInfo", ICUResourceBundle.ICU_DATA_CLASS_LOADER, ICUResourceBundle.OpenType.DIRECT);
            UResource.Value valueWithFallback = bundleInstance.getValueWithFallback("match");
            UResource.Table table = valueWithFallback.getTable();
            ByteBuffer binary = getValue(table, "trie", valueWithFallback).getBinary();
            byte[] bArr = new byte[binary.remaining()];
            binary.get(bArr);
            ByteBuffer binary2 = getValue(table, "regionToPartitions", valueWithFallback).getBinary();
            int iRemaining = binary2.remaining();
            byte[] bArr2 = new byte[iRemaining];
            binary2.get(bArr2);
            if (iRemaining < 1677) {
                throw new MissingResourceException("langInfo.res binary data too short", "", "match/regionToPartitions");
            }
            String[] stringArray = getValue(table, "partitions", valueWithFallback).getStringArray();
            if (table.findValue("paradigmnum", valueWithFallback)) {
                linkedHashSet = new LinkedHashSet(Arrays.asList(LSR.decodeInts(getValue(table, "paradigmnum", valueWithFallback).getIntVector(), getValue(bundleInstance.getValueWithFallback("likely").getTable(), "m49", valueWithFallback).getStringArray())));
            } else {
                linkedHashSet = Collections.EMPTY_SET;
            }
            Set set = linkedHashSet;
            int[] intVector = getValue(table, "distances", valueWithFallback).getIntVector();
            if (intVector.length >= 4) {
                return new Data(bArr, bArr2, stringArray, set, intVector);
            }
            throw new MissingResourceException("langInfo.res intvector too short", "", "match/distances");
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && Data.class.equals(obj.getClass())) {
                Data data = (Data) obj;
                if (Arrays.equals(this.trie, data.trie) && Arrays.equals(this.regionToPartitionsIndex, data.regionToPartitionsIndex) && Arrays.equals(this.partitionArrays, data.partitionArrays) && this.paradigmLSRs.equals(data.paradigmLSRs) && Arrays.equals(this.distances, data.distances)) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return 1;
        }
    }

    private LocaleDistance(Data data) {
        this.trie = new BytesTrie(data.trie, 0);
        this.regionToPartitionsIndex = data.regionToPartitionsIndex;
        this.partitionArrays = data.partitionArrays;
        this.paradigmLSRs = data.paradigmLSRs;
        int[] iArr = data.distances;
        this.defaultLanguageDistance = iArr[0];
        this.defaultScriptDistance = iArr[1];
        this.defaultRegionDistance = iArr[2];
        this.minRegionDistance = iArr[3];
        this.defaultDemotionPerDesiredLocale = getDistanceFloor(getBestIndexAndDistance(new LSR("en", "Latn", "US", 7), new LSR[]{new LSR("en", "Latn", "GB", 7)}, 1, shiftDistance(50), LocaleMatcher.FavorSubtag.LANGUAGE, LocaleMatcher.Direction.WITH_ONE_WAY));
    }

    private static final int getDesSuppScriptDistance(BytesTrie bytesTrie, long j, String str, String str2) {
        int iTrieNext = trieNext(bytesTrie, str, false);
        if (iTrieNext >= 0) {
            iTrieNext = trieNext(bytesTrie, str2, true);
        }
        if (iTrieNext >= 0) {
            return iTrieNext;
        }
        BytesTrie.Result next = bytesTrie.resetToState64(j).next(42);
        int value = str.equals(str2) ? 0 : bytesTrie.getValue();
        return next == BytesTrie.Result.FINAL_VALUE ? value | 256 : value;
    }

    public static final double getDistanceDouble(int i) {
        return ((double) getShiftedDistance(i)) / 8.0d;
    }

    public static final int getDistanceFloor(int i) {
        return (i & 1023) >> 3;
    }

    private static final int getFallbackRegionDistance(BytesTrie bytesTrie, long j) {
        bytesTrie.resetToState64(j).next(42);
        return bytesTrie.getValue();
    }

    public static final int getIndex(int i) {
        return i >> 10;
    }

    private static final int getRegionPartitionsDistance(BytesTrie bytesTrie, long j, String str, String str2, int i) {
        int fallbackRegionDistance;
        int length = str.length();
        int length2 = str2.length();
        if (length == 1 && length2 == 1) {
            return (bytesTrie.next(str.charAt(0) | 128).hasNext() && bytesTrie.next(str2.charAt(0) | 128).hasValue()) ? bytesTrie.getValue() : getFallbackRegionDistance(bytesTrie, j);
        }
        int i2 = 0;
        boolean z = false;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (bytesTrie.next(str.charAt(i2) | 128).hasNext()) {
                long state64 = length2 > 1 ? bytesTrie.getState64() : 0L;
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    if (bytesTrie.next(str2.charAt(i5) | 128).hasValue()) {
                        fallbackRegionDistance = bytesTrie.getValue();
                    } else if (z) {
                        fallbackRegionDistance = 0;
                    } else {
                        fallbackRegionDistance = getFallbackRegionDistance(bytesTrie, j);
                        z = true;
                    }
                    if (fallbackRegionDistance <= i) {
                        if (i3 < fallbackRegionDistance) {
                            i3 = fallbackRegionDistance;
                        }
                        if (i6 >= length2) {
                            break;
                        }
                        bytesTrie.resetToState64(state64);
                        i5 = i6;
                    } else {
                        return fallbackRegionDistance;
                    }
                }
            } else if (!z) {
                int fallbackRegionDistance2 = getFallbackRegionDistance(bytesTrie, j);
                if (fallbackRegionDistance2 > i) {
                    return fallbackRegionDistance2;
                }
                if (i3 < fallbackRegionDistance2) {
                    i3 = fallbackRegionDistance2;
                }
                z = true;
            }
            if (i4 >= length) {
                return i3;
            }
            bytesTrie.resetToState64(j);
            i2 = i4;
        }
    }

    public static final int getShiftedDistance(int i) {
        return i & 1023;
    }

    private boolean isMatch(LSR lsr, LSR lsr2, int i, LocaleMatcher.FavorSubtag favorSubtag) {
        return getBestIndexAndDistance(lsr, new LSR[]{lsr2}, 1, i, favorSubtag, null) >= 0;
    }

    private String partitionsForRegion(LSR lsr) {
        return this.partitionArrays[this.regionToPartitionsIndex[lsr.regionIndex]];
    }

    public static final int shiftDistance(int i) {
        return i << 3;
    }

    private static final int trieNext(BytesTrie bytesTrie, String str, boolean z) {
        if (str.isEmpty()) {
            return -1;
        }
        int length = str.length() - 1;
        int i = 0;
        while (true) {
            char cCharAt = str.charAt(i);
            if (i >= length) {
                BytesTrie.Result next = bytesTrie.next(cCharAt | 128);
                if (z) {
                    if (next.hasValue()) {
                        int value = bytesTrie.getValue();
                        return next == BytesTrie.Result.FINAL_VALUE ? value | 256 : value;
                    }
                } else if (next.hasNext()) {
                    return 0;
                }
                return -1;
            }
            if (!bytesTrie.next(cCharAt).hasNext()) {
                return -1;
            }
            i++;
        }
    }

    public int getBestIndexAndDistance(LSR lsr, LSR[] lsrArr, int i, int i2, LocaleMatcher.FavorSubtag favorSubtag, LocaleMatcher.Direction direction) {
        int iTrieNext;
        int i3;
        boolean z;
        int i4;
        int i5;
        int i6;
        int i7;
        LSR lsr2;
        int regionPartitionsDistance;
        int i8;
        int i9 = i;
        BytesTrie bytesTrie = new BytesTrie(this.trie);
        int iTrieNext2 = trieNext(bytesTrie, lsr.language, false);
        boolean z2 = true;
        long state64 = (iTrieNext2 < 0 || i9 <= 1) ? 0L : bytesTrie.getState64();
        int iShiftDistance = i2;
        int i10 = 0;
        int iCompareLikely = -1;
        int i11 = -1;
        while (i10 < i9) {
            LSR lsr3 = lsrArr[i10];
            if (iTrieNext2 >= 0) {
                if (i10 != 0) {
                    bytesTrie.resetToState64(state64);
                }
                iTrieNext = trieNext(bytesTrie, lsr3.language, z2);
            } else {
                iTrieNext = iTrieNext2;
            }
            if (iTrieNext >= 0) {
                i4 = iTrieNext & 384;
                i3 = iTrieNext & (-385);
                z = false;
            } else {
                i3 = lsr.language.equals(lsr3.language) ? 0 : this.defaultLanguageDistance;
                z = z2;
                i4 = 0;
            }
            int i12 = (iShiftDistance + 7) >> 3;
            if (favorSubtag == LocaleMatcher.FavorSubtag.SCRIPT) {
                i3 >>= 2;
            }
            if (i3 > i12) {
                i5 = iShiftDistance;
                i6 = i10;
            } else {
                if (z || i4 != 0) {
                    i5 = iShiftDistance;
                    i6 = i10;
                    i7 = lsr.script.equals(lsr3.script) ? 0 : this.defaultScriptDistance;
                } else {
                    i5 = iShiftDistance;
                    i6 = i10;
                    int desSuppScriptDistance = getDesSuppScriptDistance(bytesTrie, bytesTrie.getState64(), lsr.script, lsr3.script);
                    i4 = desSuppScriptDistance & 256;
                    i7 = desSuppScriptDistance & (-257);
                }
                int i13 = i7 + i3;
                if (i13 <= i12) {
                    if (lsr.region.equals(lsr3.region)) {
                        i5 = i5;
                        i8 = i13;
                        iCompareLikely = iCompareLikely;
                        lsr2 = lsr3;
                    } else {
                        if (z || (i4 & 256) != 0) {
                            lsr2 = lsr3;
                            regionPartitionsDistance = this.defaultRegionDistance;
                        } else {
                            int i14 = i12 - i13;
                            if (this.minRegionDistance <= i14) {
                                lsr2 = lsr3;
                                regionPartitionsDistance = getRegionPartitionsDistance(bytesTrie, bytesTrie.getState64(), partitionsForRegion(lsr), partitionsForRegion(lsr3), i14);
                            }
                        }
                        i8 = i13 + regionPartitionsDistance;
                    }
                    iShiftDistance = shiftDistance(i8);
                    if (iShiftDistance == 0) {
                        iShiftDistance |= lsr.flags ^ lsr2.flags;
                        if (iShiftDistance >= i5 || (direction == LocaleMatcher.Direction.ONLY_TWO_WAY && !isMatch(lsr2, lsr, i5, favorSubtag))) {
                            iCompareLikely = iCompareLikely;
                            iShiftDistance = i5;
                        } else {
                            if (iShiftDistance == 0) {
                                return i6 << 10;
                            }
                            iCompareLikely = -1;
                            i11 = i6;
                        }
                    } else {
                        if (iShiftDistance < i5) {
                            if (direction != LocaleMatcher.Direction.ONLY_TWO_WAY || isMatch(lsr2, lsr, i5, favorSubtag)) {
                                iCompareLikely = -1;
                                i11 = i6;
                            }
                        } else if (iShiftDistance == i5 && i11 >= 0 && (direction != LocaleMatcher.Direction.ONLY_TWO_WAY || isMatch(lsr2, lsr, i5, favorSubtag))) {
                            iCompareLikely = LikelySubtags.INSTANCE.compareLikely(lsr2, lsrArr[i11], iCompareLikely);
                            iShiftDistance = i5;
                            if ((iCompareLikely & 1) != 0) {
                                i11 = i6;
                            }
                        }
                        iCompareLikely = iCompareLikely;
                        iShiftDistance = i5;
                    }
                    i10 = i6 + 1;
                    i9 = i;
                    z2 = true;
                }
                i5 = i5;
            }
            iCompareLikely = iCompareLikely;
            iCompareLikely = iCompareLikely;
            iShiftDistance = i5;
            i10 = i6 + 1;
            i9 = i;
            z2 = true;
        }
        return i11 >= 0 ? (i11 << 10) | iShiftDistance : shiftDistance(100) | INDEX_NEG_1;
    }

    public int getDefaultDemotionPerDesiredLocale() {
        return this.defaultDemotionPerDesiredLocale;
    }

    public int getDefaultRegionDistance() {
        return this.defaultRegionDistance;
    }

    public int getDefaultScriptDistance() {
        return this.defaultScriptDistance;
    }

    public boolean isParadigmLSR(LSR lsr) {
        Iterator<LSR> it = this.paradigmLSRs.iterator();
        while (it.hasNext()) {
            if (lsr.isEquivalentTo(it.next())) {
                return true;
            }
        }
        return false;
    }

    public int testOnlyDistance(ULocale uLocale, ULocale uLocale2, int i, LocaleMatcher.FavorSubtag favorSubtag) {
        LikelySubtags likelySubtags = LikelySubtags.INSTANCE;
        return getDistanceFloor(getBestIndexAndDistance(likelySubtags.makeMaximizedLsrFrom(uLocale, false), new LSR[]{likelySubtags.makeMaximizedLsrFrom(uLocale2, false)}, 1, shiftDistance(i), favorSubtag, LocaleMatcher.Direction.WITH_ONE_WAY));
    }

    public Map<String, Integer> testOnlyGetDistanceTable() {
        TreeMap treeMap = new TreeMap();
        StringBuilder sb = new StringBuilder();
        Iterator<BytesTrie.Entry> itIterator2 = this.trie.iterator2();
        while (itIterator2.hasNext()) {
            BytesTrie.Entry next = itIterator2.next();
            sb.setLength(0);
            int iBytesLength = next.bytesLength();
            for (int i = 0; i < iBytesLength; i++) {
                byte bByteAt = next.byteAt(i);
                if (bByteAt == 42) {
                    sb.append("*-*-");
                } else if (bByteAt >= 0) {
                    sb.append((char) bByteAt);
                } else {
                    sb.append((char) (bByteAt & Bidi.LEVEL_DEFAULT_RTL));
                    sb.append('-');
                }
            }
            sb.setLength(sb.length() - 1);
            treeMap.put(sb.toString(), Integer.valueOf(next.value));
        }
        return treeMap;
    }

    public void testOnlyPrintDistanceTable() {
        String str;
        for (Map.Entry<String, Integer> entry : testOnlyGetDistanceTable().entrySet()) {
            int iIntValue = entry.getValue().intValue();
            if ((iIntValue & 128) != 0) {
                iIntValue &= -129;
                str = " skip script";
            } else {
                str = "";
            }
            System.out.println(entry.getKey() + "=" + iIntValue + str);
        }
    }

    public String toString() {
        return testOnlyGetDistanceTable().toString();
    }
}
