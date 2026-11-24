package com.ibm.icu.util;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class LocalePriorityList implements Iterable<ULocale> {
    private final Map<ULocale, Double> languagesAndWeights;
    private static final Double D1 = Double.valueOf(1.0d);
    private static final Pattern languageSplitter = Pattern.compile("\\s*,\\s*");
    private static final Pattern weightSplitter = Pattern.compile("\\s*(\\S*)\\s*;\\s*q\\s*=\\s*(\\S*)");
    private static Comparator<Double> myDescendingDouble = new Comparator<Double>() { // from class: com.ibm.icu.util.LocalePriorityList.1
        @Override // java.util.Comparator
        public int compare(Double d, Double d2) {
            int iCompareTo = d.compareTo(d2);
            if (iCompareTo > 0) {
                return -1;
            }
            return iCompareTo < 0 ? 1 : 0;
        }
    };

    private LocalePriorityList(Map<ULocale, Double> map) {
        this.languagesAndWeights = map;
    }

    public static Builder add(ULocale... uLocaleArr) {
        return new Builder(0).add(uLocaleArr);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        try {
            return this.languagesAndWeights.equals(((LocalePriorityList) obj).languagesAndWeights);
        } catch (RuntimeException unused) {
            return false;
        }
    }

    public Set<ULocale> getULocales() {
        return this.languagesAndWeights.keySet();
    }

    public Double getWeight(ULocale uLocale) {
        return this.languagesAndWeights.get(uLocale);
    }

    public int hashCode() {
        return this.languagesAndWeights.hashCode();
    }

    @Override // java.lang.Iterable
    public Iterator<ULocale> iterator() {
        return this.languagesAndWeights.keySet().iterator();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<ULocale, Double> entry : this.languagesAndWeights.entrySet()) {
            ULocale key = entry.getKey();
            double dDoubleValue = entry.getValue().doubleValue();
            if (sb.length() != 0) {
                sb.append(", ");
            }
            sb.append(key);
            if (dDoubleValue != 1.0d) {
                sb.append(";q=");
                sb.append(dDoubleValue);
            }
        }
        return sb.toString();
    }

    public /* synthetic */ LocalePriorityList(Map map, int i) {
        this(map);
    }

    public static Builder add(ULocale uLocale, double d) {
        return new Builder(0).add(uLocale, d);
    }

    public static Builder add(LocalePriorityList localePriorityList) {
        return new Builder(localePriorityList, 0);
    }

    public static Builder add(String str) {
        return new Builder(0).add(str);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Builder {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private LocalePriorityList built;
        private boolean hasWeights;
        private Map<ULocale, Double> languageToWeight;

        private Builder(LocalePriorityList localePriorityList) {
            this.hasWeights = false;
            this.built = localePriorityList;
            Iterator it = localePriorityList.languagesAndWeights.values().iterator();
            while (it.hasNext()) {
                if (((Double) it.next()).doubleValue() != 1.0d) {
                    this.hasWeights = true;
                    return;
                }
            }
        }

        public Builder add(String str) {
            String[] strArrSplit = LocalePriorityList.languageSplitter.split(str.trim());
            Matcher matcher = LocalePriorityList.weightSplitter.matcher("");
            for (String str2 : strArrSplit) {
                if (matcher.reset(str2).matches()) {
                    ULocale uLocale = new ULocale(matcher.group(1));
                    double d = Double.parseDouble(matcher.group(2));
                    if (0.0d > d || d > 1.0d) {
                        throw new IllegalArgumentException("Illegal weight, must be 0..1: " + d);
                    }
                    add(uLocale, d);
                } else if (str2.length() != 0) {
                    add(new ULocale(str2));
                }
            }
            return this;
        }

        public LocalePriorityList build(boolean z) {
            Map<ULocale, Double> map;
            LocalePriorityList localePriorityList = this.built;
            if (localePriorityList != null) {
                return localePriorityList;
            }
            int i = 0;
            if (this.hasWeights) {
                TreeMap treeMap = new TreeMap(LocalePriorityList.myDescendingDouble);
                for (Map.Entry<ULocale, Double> entry : this.languageToWeight.entrySet()) {
                    ULocale key = entry.getKey();
                    Double value = entry.getValue();
                    List linkedList = (List) treeMap.get(value);
                    if (linkedList == null) {
                        linkedList = new LinkedList();
                        treeMap.put(value, linkedList);
                    }
                    linkedList.add(key);
                }
                if (treeMap.size() <= 1) {
                    map = this.languageToWeight;
                    if (treeMap.isEmpty() || ((Double) treeMap.firstKey()).doubleValue() == 1.0d) {
                        this.hasWeights = false;
                    }
                } else {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    for (Map.Entry entry2 : treeMap.entrySet()) {
                        Double d = z ? (Double) entry2.getKey() : LocalePriorityList.D1;
                        Iterator it = ((List) entry2.getValue()).iterator();
                        while (it.hasNext()) {
                            linkedHashMap.put((ULocale) it.next(), d);
                        }
                    }
                    map = linkedHashMap;
                }
            } else {
                map = this.languageToWeight;
            }
            this.languageToWeight = null;
            LocalePriorityList localePriorityList2 = new LocalePriorityList(Collections.unmodifiableMap(map), i);
            this.built = localePriorityList2;
            return localePriorityList2;
        }

        public /* synthetic */ Builder(LocalePriorityList localePriorityList, int i) {
            this(localePriorityList);
        }

        private Builder() {
            this.hasWeights = false;
            this.languageToWeight = new LinkedHashMap();
        }

        public /* synthetic */ Builder(int i) {
            this();
        }

        public Builder add(ULocale uLocale) {
            return add(uLocale, 1.0d);
        }

        public Builder add(ULocale... uLocaleArr) {
            for (ULocale uLocale : uLocaleArr) {
                add(uLocale, 1.0d);
            }
            return this;
        }

        public Builder add(ULocale uLocale, double d) {
            Double dValueOf;
            if (this.languageToWeight == null) {
                this.languageToWeight = new LinkedHashMap(this.built.languagesAndWeights);
                this.built = null;
            }
            if (this.languageToWeight.containsKey(uLocale)) {
                this.languageToWeight.remove(uLocale);
            }
            if (d <= 0.0d) {
                return this;
            }
            if (d >= 1.0d) {
                dValueOf = LocalePriorityList.D1;
            } else {
                dValueOf = Double.valueOf(d);
                this.hasWeights = true;
            }
            this.languageToWeight.put(uLocale, dValueOf);
            return this;
        }

        public Builder add(LocalePriorityList localePriorityList) {
            for (Map.Entry entry : localePriorityList.languagesAndWeights.entrySet()) {
                add((ULocale) entry.getKey(), ((Double) entry.getValue()).doubleValue());
            }
            return this;
        }

        public LocalePriorityList build() {
            return build(false);
        }
    }
}
