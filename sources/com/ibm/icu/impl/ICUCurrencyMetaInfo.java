package com.ibm.icu.impl;

import com.ibm.icu.text.CurrencyMetaInfo;
import com.ibm.icu.util.Currency;
import com.ibm.icu.util.UResourceBundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class ICUCurrencyMetaInfo extends CurrencyMetaInfo {
    private static final int Currency = 2;
    private static final int Date = 4;
    private static final int Everything = Integer.MAX_VALUE;
    private static final long MASK = 4294967295L;
    private static final int Region = 1;
    private static final int Tender = 8;
    private ICUResourceBundle digitInfo;
    private ICUResourceBundle regionInfo;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface Collector<T> {
        void collect(String str, String str2, long j, long j2, int i, boolean z);

        int collects();

        List<T> getList();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class UniqueList<T> {
        private Set<T> seen = new HashSet();
        private List<T> list = new ArrayList();

        private UniqueList() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T> UniqueList<T> create() {
            return new UniqueList<>();
        }

        public void add(T t) {
            if (this.seen.contains(t)) {
                return;
            }
            this.list.add(t);
            this.seen.add(t);
        }

        public List<T> list() {
            return Collections.unmodifiableList(this.list);
        }
    }

    public ICUCurrencyMetaInfo() {
        ICUResourceBundle iCUResourceBundle = (ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_CURR_BASE_NAME, "supplementalData", ICUResourceBundle.ICU_DATA_CLASS_LOADER);
        this.regionInfo = iCUResourceBundle.findTopLevel("CurrencyMap");
        this.digitInfo = iCUResourceBundle.findTopLevel("CurrencyMeta");
    }

    private <T> List<T> collect(Collector<T> collector, CurrencyMetaInfo.CurrencyFilter currencyFilter) {
        if (currencyFilter == null) {
            currencyFilter = CurrencyMetaInfo.CurrencyFilter.all();
        }
        int iCollects = collector.collects();
        String str = currencyFilter.region;
        if (str != null) {
            iCollects |= 1;
        }
        if (currencyFilter.currency != null) {
            iCollects |= 2;
        }
        if (currencyFilter.from != Long.MIN_VALUE || currencyFilter.to != Long.MAX_VALUE) {
            iCollects |= 4;
        }
        if (currencyFilter.tenderOnly) {
            iCollects |= 8;
        }
        if (iCollects != 0) {
            if (str != null) {
                ICUResourceBundle iCUResourceBundleFindWithFallback = this.regionInfo.findWithFallback(str);
                if (iCUResourceBundleFindWithFallback != null) {
                    collectRegion(collector, currencyFilter, iCollects, iCUResourceBundleFindWithFallback);
                }
            } else {
                for (int i = 0; i < this.regionInfo.getSize(); i++) {
                    collectRegion(collector, currencyFilter, iCollects, this.regionInfo.at(i));
                }
            }
        }
        return collector.getList();
    }

    private <T> void collectRegion(Collector<T> collector, CurrencyMetaInfo.CurrencyFilter currencyFilter, int i, ICUResourceBundle iCUResourceBundle) {
        String string;
        long j;
        long j2;
        boolean z;
        String key = iCUResourceBundle.getKey();
        boolean z2 = true;
        if (i == 1) {
            collector.collect(iCUResourceBundle.getKey(), null, 0L, 0L, -1, false);
            return;
        }
        boolean z3 = false;
        int i2 = 0;
        while (i2 < iCUResourceBundle.getSize()) {
            ICUResourceBundle iCUResourceBundleAt = iCUResourceBundle.at(i2);
            if (iCUResourceBundleAt.getSize() != 0) {
                if ((i & 2) != 0) {
                    string = iCUResourceBundleAt.at("id").getString();
                    String str = currencyFilter.currency;
                    if (str == null || str.equals(string)) {
                    }
                } else {
                    string = null;
                }
                if ((i & 4) != 0) {
                    long date = getDate(iCUResourceBundleAt.at("from"), Long.MIN_VALUE, z3);
                    long date2 = getDate(iCUResourceBundleAt.at("to"), Long.MAX_VALUE, z2);
                    if (currencyFilter.from <= date2 && currencyFilter.to >= date) {
                        j = date;
                        j2 = date2;
                    }
                } else {
                    j = Long.MIN_VALUE;
                    j2 = Long.MAX_VALUE;
                }
                if ((i & 8) != 0) {
                    ICUResourceBundle iCUResourceBundleAt2 = iCUResourceBundleAt.at("tender");
                    boolean z4 = iCUResourceBundleAt2 == null || "true".equals(iCUResourceBundleAt2.getString());
                    if (!currencyFilter.tenderOnly || z4) {
                        z = z4;
                    }
                } else {
                    z = true;
                }
                collector.collect(key, string, j, j2, i2, z);
            }
            i2++;
            z2 = true;
            z3 = false;
        }
    }

    private long getDate(ICUResourceBundle iCUResourceBundle, long j, boolean z) {
        if (iCUResourceBundle == null) {
            return j;
        }
        int[] intVector = iCUResourceBundle.getIntVector();
        return (((long) intVector[0]) << 32) | (((long) intVector[1]) & MASK);
    }

    @Override // com.ibm.icu.text.CurrencyMetaInfo
    public List<String> currencies(CurrencyMetaInfo.CurrencyFilter currencyFilter) {
        return collect(new CurrencyCollector(0), currencyFilter);
    }

    @Override // com.ibm.icu.text.CurrencyMetaInfo
    public CurrencyMetaInfo.CurrencyDigits currencyDigits(String str, Currency.CurrencyUsage currencyUsage) {
        ICUResourceBundle iCUResourceBundleFindWithFallback = this.digitInfo.findWithFallback(str);
        if (iCUResourceBundleFindWithFallback == null) {
            iCUResourceBundleFindWithFallback = this.digitInfo.findWithFallback("DEFAULT");
        }
        int[] intVector = iCUResourceBundleFindWithFallback.getIntVector();
        if (currencyUsage == Currency.CurrencyUsage.CASH) {
            return new CurrencyMetaInfo.CurrencyDigits(intVector[2], intVector[3]);
        }
        return currencyUsage == Currency.CurrencyUsage.STANDARD ? new CurrencyMetaInfo.CurrencyDigits(intVector[0], intVector[1]) : new CurrencyMetaInfo.CurrencyDigits(intVector[0], intVector[1]);
    }

    @Override // com.ibm.icu.text.CurrencyMetaInfo
    public List<CurrencyMetaInfo.CurrencyInfo> currencyInfo(CurrencyMetaInfo.CurrencyFilter currencyFilter) {
        return collect(new InfoCollector(0), currencyFilter);
    }

    @Override // com.ibm.icu.text.CurrencyMetaInfo
    public List<String> regions(CurrencyMetaInfo.CurrencyFilter currencyFilter) {
        return collect(new RegionCollector(0), currencyFilter);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CurrencyCollector implements Collector<String> {
        private final UniqueList<String> result;

        private CurrencyCollector() {
            this.result = UniqueList.create();
        }

        @Override // com.ibm.icu.impl.ICUCurrencyMetaInfo.Collector
        public void collect(String str, String str2, long j, long j2, int i, boolean z) {
            this.result.add(str2);
        }

        @Override // com.ibm.icu.impl.ICUCurrencyMetaInfo.Collector
        public int collects() {
            return 2;
        }

        @Override // com.ibm.icu.impl.ICUCurrencyMetaInfo.Collector
        public List<String> getList() {
            return this.result.list();
        }

        public /* synthetic */ CurrencyCollector(int i) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RegionCollector implements Collector<String> {
        private final UniqueList<String> result;

        private RegionCollector() {
            this.result = UniqueList.create();
        }

        @Override // com.ibm.icu.impl.ICUCurrencyMetaInfo.Collector
        public void collect(String str, String str2, long j, long j2, int i, boolean z) {
            this.result.add(str);
        }

        @Override // com.ibm.icu.impl.ICUCurrencyMetaInfo.Collector
        public int collects() {
            return 1;
        }

        @Override // com.ibm.icu.impl.ICUCurrencyMetaInfo.Collector
        public List<String> getList() {
            return this.result.list();
        }

        public /* synthetic */ RegionCollector(int i) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class InfoCollector implements Collector<CurrencyMetaInfo.CurrencyInfo> {
        private List<CurrencyMetaInfo.CurrencyInfo> result;

        private InfoCollector() {
            this.result = new ArrayList();
        }

        @Override // com.ibm.icu.impl.ICUCurrencyMetaInfo.Collector
        public void collect(String str, String str2, long j, long j2, int i, boolean z) {
            this.result.add(new CurrencyMetaInfo.CurrencyInfo(str, str2, j, j2, i, z));
        }

        @Override // com.ibm.icu.impl.ICUCurrencyMetaInfo.Collector
        public int collects() {
            return Integer.MAX_VALUE;
        }

        @Override // com.ibm.icu.impl.ICUCurrencyMetaInfo.Collector
        public List<CurrencyMetaInfo.CurrencyInfo> getList() {
            return Collections.unmodifiableList(this.result);
        }

        public /* synthetic */ InfoCollector(int i) {
            this();
        }
    }

    @Override // com.ibm.icu.text.CurrencyMetaInfo
    public CurrencyMetaInfo.CurrencyDigits currencyDigits(String str) {
        return currencyDigits(str, Currency.CurrencyUsage.STANDARD);
    }
}
