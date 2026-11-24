package com.ibm.icu.text;

import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.util.LocaleData;
import com.ibm.icu.util.ULocale;
import defpackage.cq;
import defpackage.dk0;
import defpackage.og;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class AlphabeticIndex<V> implements Iterable<Bucket<V>> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String BASE = "\ufdd0";
    private static final char CGJ = 847;
    private static final int GC_CN_MASK = 1;
    private static final int GC_LL_MASK = 4;
    private static final int GC_LM_MASK = 16;
    private static final int GC_LO_MASK = 32;
    private static final int GC_LT_MASK = 8;
    private static final int GC_LU_MASK = 2;
    private static final int GC_L_MASK = 62;
    private static final Comparator<String> binaryCmp = new UTF16.StringComparator(true, false, 0);
    private BucketList<V> buckets;
    private RuleBasedCollator collatorExternal;
    private final RuleBasedCollator collatorOriginal;
    private final RuleBasedCollator collatorPrimaryOnly;
    private final List<String> firstCharsInScripts;
    private String inflowLabel;
    private final UnicodeSet initialLabels;
    private List<Record<V>> inputList;
    private int maxLabelCount;
    private String overflowLabel;
    private final Comparator<Record<V>> recordComparator;
    private String underflowLabel;

    private AlphabeticIndex(ULocale uLocale, RuleBasedCollator ruleBasedCollator) {
        this.recordComparator = new Comparator<Record<V>>() { // from class: com.ibm.icu.text.AlphabeticIndex.1
            @Override // java.util.Comparator
            public int compare(Record<V> record, Record<V> record2) {
                return AlphabeticIndex.this.collatorOriginal.compare(((Record) record).name, ((Record) record2).name);
            }
        };
        this.initialLabels = new UnicodeSet();
        this.overflowLabel = "…";
        this.underflowLabel = "…";
        this.inflowLabel = "…";
        this.maxLabelCount = 99;
        ruleBasedCollator = ruleBasedCollator == null ? (RuleBasedCollator) Collator.getInstance(uLocale) : ruleBasedCollator;
        this.collatorOriginal = ruleBasedCollator;
        try {
            RuleBasedCollator ruleBasedCollatorCloneAsThawed = ruleBasedCollator.cloneAsThawed();
            this.collatorPrimaryOnly = ruleBasedCollatorCloneAsThawed;
            ruleBasedCollatorCloneAsThawed.setStrength(0);
            ruleBasedCollatorCloneAsThawed.freeze();
            List<String> firstCharactersInScripts = getFirstCharactersInScripts();
            this.firstCharsInScripts = firstCharactersInScripts;
            Collections.sort(firstCharactersInScripts, ruleBasedCollatorCloneAsThawed);
            while (!this.firstCharsInScripts.isEmpty()) {
                if (this.collatorPrimaryOnly.compare(this.firstCharsInScripts.get(0), "") != 0) {
                    if (addChineseIndexCharacters() || uLocale == null) {
                        return;
                    }
                    addIndexExemplars(uLocale);
                    return;
                }
                this.firstCharsInScripts.remove(0);
            }
            og.i("AlphabeticIndex requires some non-ignorable script boundary strings");
            throw null;
        } catch (Exception e) {
            throw new IllegalStateException("Collator cannot be cloned", e);
        }
    }

    private boolean addChineseIndexCharacters() {
        UnicodeSet unicodeSet = new UnicodeSet();
        try {
            this.collatorPrimaryOnly.internalAddContractions(BASE.charAt(0), unicodeSet);
            if (unicodeSet.isEmpty()) {
                return false;
            }
            this.initialLabels.addAll(unicodeSet);
            for (String str : unicodeSet) {
                char cCharAt = str.charAt(str.length() - 1);
                if ('A' <= cCharAt && cCharAt <= 'Z') {
                    this.initialLabels.add(65, 90);
                    break;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private void addIndexExemplars(ULocale uLocale) {
        UnicodeSet exemplarSet = LocaleData.getExemplarSet(uLocale, 0, 2);
        if (exemplarSet != null && !exemplarSet.isEmpty()) {
            this.initialLabels.addAll(exemplarSet);
            return;
        }
        UnicodeSet unicodeSetCloneAsThawed = LocaleData.getExemplarSet(uLocale, 0, 0).cloneAsThawed();
        if (unicodeSetCloneAsThawed.containsSome(97, 122) || unicodeSetCloneAsThawed.isEmpty()) {
            unicodeSetCloneAsThawed.addAll(97, 122);
        }
        if (unicodeSetCloneAsThawed.containsSome(Normalizer2Impl.Hangul.HANGUL_BASE, Normalizer2Impl.Hangul.HANGUL_END)) {
            unicodeSetCloneAsThawed.remove(Normalizer2Impl.Hangul.HANGUL_BASE, Normalizer2Impl.Hangul.HANGUL_END).add(Normalizer2Impl.Hangul.HANGUL_BASE).add(45208).add(45796).add(46972).add(47560).add(48148).add(49324).add(50500).add(51088).add(52264).add(52852).add(53440).add(54028).add(54616);
        }
        if (unicodeSetCloneAsThawed.containsSome(4608, 4991)) {
            UnicodeSet unicodeSet = new UnicodeSet("[ሀለሐመሠረሰሸቀቈቐቘበቨተቸኀኈነኘአከኰኸዀወዐዘዠየደዸጀገጐጘጠጨጰጸፀፈፐፘ]");
            unicodeSet.retainAll(unicodeSetCloneAsThawed);
            unicodeSetCloneAsThawed.remove(4608, 4991).addAll(unicodeSet);
        }
        Iterator<String> it = unicodeSetCloneAsThawed.iterator();
        while (it.hasNext()) {
            this.initialLabels.add(UCharacter.toUpperCase(uLocale, it.next()));
        }
    }

    private BucketList<V> createBucketList() {
        int i;
        char cCharAt;
        char cCharAt2;
        String str;
        AlphabeticIndex<V> alphabeticIndex = this;
        List<String> listInitLabels = alphabeticIndex.initLabels();
        long variableTop = alphabeticIndex.collatorPrimaryOnly.isAlternateHandlingShifted() ? ((long) alphabeticIndex.collatorPrimaryOnly.getVariableTop()) & 4294967295L : 0L;
        Bucket[] bucketArr = new Bucket[26];
        Bucket[] bucketArr2 = new Bucket[26];
        ArrayList arrayList = new ArrayList();
        String str2 = "";
        int i2 = 0;
        arrayList.add(new Bucket(alphabeticIndex.getUnderflowLabel(), str2, Bucket.LabelType.UNDERFLOW, i2));
        Iterator<String> it = listInitLabels.iterator();
        String str3 = "";
        boolean z = false;
        boolean z2 = false;
        int i3 = -1;
        while (true) {
            int i4 = 1;
            if (!it.hasNext()) {
                break;
            }
            String next = it.next();
            if (alphabeticIndex.collatorPrimaryOnly.compare(next, str3) >= 0) {
                int i5 = i2;
                while (true) {
                    i3 += i4;
                    str = alphabeticIndex.firstCharsInScripts.get(i3);
                    if (alphabeticIndex.collatorPrimaryOnly.compare(next, str) < 0) {
                        break;
                    }
                    i5 = 1;
                    i4 = 1;
                }
                if (i5 == 0 || arrayList.size() <= 1) {
                    i = 0;
                } else {
                    i = 0;
                    arrayList.add(new Bucket(alphabeticIndex.getInflowLabel(), str3, Bucket.LabelType.INFLOW, i));
                }
                str3 = str;
            } else {
                it = it;
                bucketArr = bucketArr;
                i = i2;
            }
            Bucket bucket = new Bucket(fixLabel(next), next, Bucket.LabelType.NORMAL, i);
            arrayList.add(bucket);
            if (next.length() == 1 && 'A' <= (cCharAt2 = next.charAt(i)) && cCharAt2 <= 'Z') {
                bucketArr[cCharAt2 - 'A'] = bucket;
            } else if (next.length() == 2 && next.startsWith(BASE) && 'A' <= (cCharAt = next.charAt(1)) && cCharAt <= 'Z') {
                bucketArr2[cCharAt - 'A'] = bucket;
                z = true;
            }
            if (!next.startsWith(BASE) && hasMultiplePrimaryWeights(alphabeticIndex.collatorPrimaryOnly, variableTop, next) && !next.endsWith("\uffff")) {
                int size = arrayList.size() - 2;
                while (true) {
                    Bucket bucket2 = (Bucket) arrayList.get(size);
                    Bucket.LabelType labelType = bucket2.labelType;
                    Bucket.LabelType labelType2 = Bucket.LabelType.NORMAL;
                    if (labelType != labelType2) {
                        break;
                    }
                    if (bucket2.displayBucket == null && !hasMultiplePrimaryWeights(alphabeticIndex.collatorPrimaryOnly, variableTop, bucket2.lowerBoundary)) {
                        Bucket bucket3 = new Bucket(str2, next.concat("\uffff"), labelType2, 0);
                        bucket3.displayBucket = bucket2;
                        arrayList.add(bucket3);
                        z2 = true;
                        break;
                    }
                    size--;
                    alphabeticIndex = this;
                }
            }
            alphabeticIndex = this;
            it = it;
            bucketArr = bucketArr;
            i2 = 0;
        }
        Bucket[] bucketArr3 = bucketArr;
        if (arrayList.size() == 1) {
            return new BucketList<>(arrayList, arrayList, 0);
        }
        arrayList.add(new Bucket(getOverflowLabel(), str3, Bucket.LabelType.OVERFLOW, 0));
        if (z) {
            Bucket bucket4 = null;
            for (int i6 = 0; i6 < 26; i6++) {
                Bucket bucket5 = bucketArr3[i6];
                if (bucket5 != null) {
                    bucket4 = bucket5;
                }
                Bucket bucket6 = bucketArr2[i6];
                if (bucket6 != null && bucket4 != null) {
                    bucket6.displayBucket = bucket4;
                    z2 = true;
                }
            }
        }
        if (!z2) {
            return new BucketList<>(arrayList, arrayList, 0);
        }
        int size2 = arrayList.size() - 1;
        Bucket bucket7 = (Bucket) arrayList.get(size2);
        while (true) {
            size2--;
            if (size2 <= 0) {
                break;
            }
            Bucket bucket8 = (Bucket) arrayList.get(size2);
            if (bucket8.displayBucket == null) {
                if (bucket8.labelType != Bucket.LabelType.INFLOW || bucket7.labelType == Bucket.LabelType.NORMAL) {
                    bucket7 = bucket8;
                } else {
                    bucket8.displayBucket = bucket7;
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        int size3 = arrayList.size();
        int i7 = 0;
        while (i7 < size3) {
            Object obj = arrayList.get(i7);
            i7++;
            Bucket bucket9 = (Bucket) obj;
            if (bucket9.displayBucket == null) {
                arrayList2.add(bucket9);
            }
        }
        return new BucketList<>(arrayList, arrayList2, 0);
    }

    private static String fixLabel(String str) {
        if (!str.startsWith(BASE)) {
            return str;
        }
        char cCharAt = str.charAt(1);
        if (10240 >= cCharAt || cCharAt > 10495) {
            return str.substring(1);
        }
        return (cCharAt - 10240) + "劃";
    }

    private static boolean hasMultiplePrimaryWeights(RuleBasedCollator ruleBasedCollator, long j, String str) throws Throwable {
        boolean z = false;
        for (long j2 : ruleBasedCollator.internalGetCEs(str)) {
            if ((j2 >>> 32) > j) {
                if (z) {
                    return true;
                }
                z = true;
            }
        }
        return false;
    }

    private void initBuckets() {
        Bucket bucket;
        String str;
        if (this.buckets != null) {
            return;
        }
        this.buckets = createBucketList();
        List<Record<V>> list = this.inputList;
        if (list == null || list.isEmpty()) {
            return;
        }
        Collections.sort(this.inputList, this.recordComparator);
        Iterator itFullIterator = this.buckets.fullIterator();
        Bucket bucket2 = (Bucket) itFullIterator.next();
        if (itFullIterator.hasNext()) {
            bucket = (Bucket) itFullIterator.next();
            str = bucket.lowerBoundary;
        } else {
            bucket = null;
            str = null;
        }
        for (Record<V> record : this.inputList) {
            while (str != null && this.collatorPrimaryOnly.compare(((Record) record).name, str) >= 0) {
                if (itFullIterator.hasNext()) {
                    Bucket bucket3 = (Bucket) itFullIterator.next();
                    str = bucket3.lowerBoundary;
                    Bucket bucket4 = bucket;
                    bucket = bucket3;
                    bucket2 = bucket4;
                } else {
                    bucket2 = bucket;
                    str = null;
                }
            }
            Bucket bucket5 = bucket2.displayBucket != null ? bucket2.displayBucket : bucket2;
            if (bucket5.records == null) {
                bucket5.records = new ArrayList();
            }
            bucket5.records.add(record);
        }
    }

    private List<String> initLabels() {
        boolean z;
        Normalizer2 nFKDInstance = Normalizer2.getNFKDInstance();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        String str = this.firstCharsInScripts.get(0);
        List<String> list = this.firstCharsInScripts;
        String str2 = list.get(list.size() - 1);
        Iterator<String> it = this.initialLabels.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (!UTF16.hasMoreCodePointsThan(next, 1)) {
                z = false;
            } else if (next.charAt(next.length() - 1) != '*' || next.charAt(next.length() - 2) == '*') {
                z = true;
            } else {
                next = next.substring(0, next.length() - 1);
                z = false;
            }
            if (this.collatorPrimaryOnly.compare(next, str) >= 0 && this.collatorPrimaryOnly.compare(next, str2) < 0 && (!z || this.collatorPrimaryOnly.compare(next, separated(next)) != 0)) {
                int iBinarySearch = Collections.binarySearch(arrayList, next, this.collatorPrimaryOnly);
                if (iBinarySearch < 0) {
                    arrayList.add(~iBinarySearch, next);
                } else if (isOneLabelBetterThanOther(nFKDInstance, next, (String) arrayList.get(iBinarySearch))) {
                    arrayList.set(iBinarySearch, next);
                }
            }
        }
        int size = arrayList.size() - 1;
        if (size > this.maxLabelCount) {
            Iterator it2 = arrayList.iterator();
            int i2 = -1;
            while (it2.hasNext()) {
                i++;
                it2.next();
                int i3 = (this.maxLabelCount * i) / size;
                if (i3 == i2) {
                    it2.remove();
                } else {
                    i2 = i3;
                }
            }
        }
        return arrayList;
    }

    private static boolean isOneLabelBetterThanOther(Normalizer2 normalizer2, String str, String str2) {
        String strNormalize = normalizer2.normalize(str);
        String strNormalize2 = normalizer2.normalize(str2);
        int iCodePointCount = strNormalize.codePointCount(0, strNormalize.length()) - strNormalize2.codePointCount(0, strNormalize2.length());
        if (iCodePointCount != 0) {
            return iCodePointCount < 0;
        }
        Comparator<String> comparator = binaryCmp;
        int iCompare = comparator.compare(strNormalize, strNormalize2);
        if (iCompare != 0) {
            return iCompare < 0;
        }
        return comparator.compare(str, str2) < 0;
    }

    private String separated(String str) {
        StringBuilder sb = new StringBuilder();
        char cCharAt = str.charAt(0);
        sb.append(cCharAt);
        int i = 1;
        while (i < str.length()) {
            char cCharAt2 = str.charAt(i);
            if (!UCharacter.isHighSurrogate(cCharAt) || !UCharacter.isLowSurrogate(cCharAt2)) {
                sb.append(CGJ);
            }
            sb.append(cCharAt2);
            i++;
            cCharAt = cCharAt2;
        }
        return sb.toString();
    }

    public AlphabeticIndex<V> addLabels(Locale... localeArr) {
        for (Locale locale : localeArr) {
            addIndexExemplars(ULocale.forLocale(locale));
        }
        this.buckets = null;
        return this;
    }

    public AlphabeticIndex<V> addRecord(CharSequence charSequence, V v) {
        this.buckets = null;
        if (this.inputList == null) {
            this.inputList = new ArrayList();
        }
        this.inputList.add(new Record<>(charSequence, v, 0));
        return this;
    }

    public ImmutableIndex<V> buildImmutableIndex() {
        BucketList<V> bucketListCreateBucketList;
        List<Record<V>> list = this.inputList;
        if (list == null || list.isEmpty()) {
            if (this.buckets == null) {
                this.buckets = createBucketList();
            }
            bucketListCreateBucketList = this.buckets;
        } else {
            bucketListCreateBucketList = createBucketList();
        }
        return new ImmutableIndex<>(bucketListCreateBucketList, this.collatorPrimaryOnly, 0);
    }

    public AlphabeticIndex<V> clearRecords() {
        List<Record<V>> list = this.inputList;
        if (list != null && !list.isEmpty()) {
            this.inputList.clear();
            this.buckets = null;
        }
        return this;
    }

    public int getBucketCount() {
        initBuckets();
        return this.buckets.getBucketCount();
    }

    public int getBucketIndex(CharSequence charSequence) {
        initBuckets();
        return this.buckets.getBucketIndex(charSequence, this.collatorPrimaryOnly);
    }

    public List<String> getBucketLabels() {
        initBuckets();
        ArrayList arrayList = new ArrayList();
        Iterator<Bucket<V>> it = this.buckets.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getLabel());
        }
        return arrayList;
    }

    public RuleBasedCollator getCollator() {
        if (this.collatorExternal == null) {
            try {
                this.collatorExternal = this.collatorOriginal.mo12clone();
            } catch (Exception e) {
                throw new IllegalStateException("Collator cannot be cloned", e);
            }
        }
        return this.collatorExternal;
    }

    @Deprecated
    public List<String> getFirstCharactersInScripts() {
        ArrayList arrayList = new ArrayList(200);
        UnicodeSet unicodeSet = new UnicodeSet();
        this.collatorPrimaryOnly.internalAddContractions(64977, unicodeSet);
        if (unicodeSet.isEmpty()) {
            dk0.r("AlphabeticIndex requires script-first-primary contractions");
            return null;
        }
        for (String str : unicodeSet) {
            if (((1 << UCharacter.getType(str.codePointAt(1))) & 63) != 0) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public String getInflowLabel() {
        return this.inflowLabel;
    }

    public int getMaxLabelCount() {
        return this.maxLabelCount;
    }

    public String getOverflowLabel() {
        return this.overflowLabel;
    }

    public int getRecordCount() {
        List<Record<V>> list = this.inputList;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public String getUnderflowLabel() {
        return this.underflowLabel;
    }

    @Override // java.lang.Iterable
    public Iterator<Bucket<V>> iterator() {
        initBuckets();
        return this.buckets.iterator();
    }

    public AlphabeticIndex<V> setInflowLabel(String str) {
        this.inflowLabel = str;
        this.buckets = null;
        return this;
    }

    public AlphabeticIndex<V> setMaxLabelCount(int i) {
        if (i <= 0) {
            og.i("Maximum number of labels must be greater than 0");
            return null;
        }
        this.maxLabelCount = i;
        this.buckets = null;
        return this;
    }

    public AlphabeticIndex<V> setOverflowLabel(String str) {
        this.overflowLabel = str;
        this.buckets = null;
        return this;
    }

    public AlphabeticIndex<V> setUnderflowLabel(String str) {
        this.underflowLabel = str;
        this.buckets = null;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ImmutableIndex<V> implements Iterable<Bucket<V>> {
        private final BucketList<V> buckets;
        private final Collator collatorPrimaryOnly;

        private ImmutableIndex(BucketList<V> bucketList, Collator collator) {
            this.buckets = bucketList;
            this.collatorPrimaryOnly = collator;
        }

        public Bucket<V> getBucket(int i) {
            if (i < 0 || i >= this.buckets.getBucketCount()) {
                return null;
            }
            return (Bucket) ((BucketList) this.buckets).immutableVisibleList.get(i);
        }

        public int getBucketCount() {
            return this.buckets.getBucketCount();
        }

        public int getBucketIndex(CharSequence charSequence) {
            return this.buckets.getBucketIndex(charSequence, this.collatorPrimaryOnly);
        }

        @Override // java.lang.Iterable
        public Iterator<Bucket<V>> iterator() {
            return this.buckets.iterator();
        }

        public /* synthetic */ ImmutableIndex(BucketList bucketList, Collator collator, int i) {
            this(bucketList, collator);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Record<V> {
        private final V data;
        private final CharSequence name;

        private Record(CharSequence charSequence, V v) {
            this.name = charSequence;
            this.data = v;
        }

        public V getData() {
            return this.data;
        }

        public CharSequence getName() {
            return this.name;
        }

        public String toString() {
            return cq.k(String.valueOf(this.name), "=", String.valueOf(this.data));
        }

        public /* synthetic */ Record(CharSequence charSequence, Object obj, int i) {
            this(charSequence, obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Bucket<V> implements Iterable<Record<V>> {
        private Bucket<V> displayBucket;
        private int displayIndex;
        private final String label;
        private final LabelType labelType;
        private final String lowerBoundary;
        private List<Record<V>> records;

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public enum LabelType {
            NORMAL,
            UNDERFLOW,
            INFLOW,
            OVERFLOW
        }

        private Bucket(String str, String str2, LabelType labelType) {
            this.label = str;
            this.lowerBoundary = str2;
            this.labelType = labelType;
        }

        public String getLabel() {
            return this.label;
        }

        public LabelType getLabelType() {
            return this.labelType;
        }

        @Override // java.lang.Iterable
        public Iterator<Record<V>> iterator() {
            List<Record<V>> list = this.records;
            return list == null ? Collections.EMPTY_LIST.iterator() : list.iterator();
        }

        public int size() {
            List<Record<V>> list = this.records;
            if (list == null) {
                return 0;
            }
            return list.size();
        }

        public String toString() {
            String strValueOf = String.valueOf(this.labelType);
            String str = this.lowerBoundary;
            return cq.n(cq.q("{labelType=", strValueOf, ", lowerBoundary=", str, ", label="), this.label, "}");
        }

        public /* synthetic */ Bucket(String str, String str2, LabelType labelType, int i) {
            this(str, str2, labelType);
        }
    }

    public AlphabeticIndex<V> addLabels(ULocale... uLocaleArr) {
        for (ULocale uLocale : uLocaleArr) {
            addIndexExemplars(uLocale);
        }
        this.buckets = null;
        return this;
    }

    public AlphabeticIndex<V> addLabels(UnicodeSet unicodeSet) {
        this.initialLabels.addAll(unicodeSet);
        this.buckets = null;
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class BucketList<V> implements Iterable<Bucket<V>> {
        private final ArrayList<Bucket<V>> bucketList;
        private final List<Bucket<V>> immutableVisibleList;

        private BucketList(ArrayList<Bucket<V>> arrayList, ArrayList<Bucket<V>> arrayList2) {
            this.bucketList = arrayList;
            int size = arrayList2.size();
            int i = 0;
            int i2 = 0;
            while (i2 < size) {
                Bucket<V> bucket = arrayList2.get(i2);
                i2++;
                ((Bucket) bucket).displayIndex = i;
                i++;
            }
            this.immutableVisibleList = Collections.unmodifiableList(arrayList2);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Iterator<Bucket<V>> fullIterator() {
            return this.bucketList.iterator();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getBucketCount() {
            return this.immutableVisibleList.size();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int getBucketIndex(CharSequence charSequence, Collator collator) {
            ArrayList<Bucket<V>> arrayList;
            int size = this.bucketList.size();
            int i = 0;
            while (true) {
                int i2 = i + 1;
                arrayList = this.bucketList;
                if (i2 >= size) {
                    break;
                }
                int i3 = (i + size) / 2;
                if (collator.compare(charSequence, ((Bucket) arrayList.get(i3)).lowerBoundary) < 0) {
                    size = i3;
                } else {
                    i = i3;
                }
            }
            Bucket<V> bucket = arrayList.get(i);
            if (((Bucket) bucket).displayBucket != null) {
                bucket = ((Bucket) bucket).displayBucket;
            }
            return ((Bucket) bucket).displayIndex;
        }

        @Override // java.lang.Iterable
        public Iterator<Bucket<V>> iterator() {
            return this.immutableVisibleList.iterator();
        }

        public /* synthetic */ BucketList(ArrayList arrayList, ArrayList arrayList2, int i) {
            this(arrayList, arrayList2);
        }
    }

    public AlphabeticIndex(Locale locale) {
        this(ULocale.forLocale(locale), null);
    }

    public AlphabeticIndex(RuleBasedCollator ruleBasedCollator) {
        this(null, ruleBasedCollator);
    }

    public AlphabeticIndex(ULocale uLocale) {
        this(uLocale, null);
    }
}
