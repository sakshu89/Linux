package com.ibm.icu.impl;

import com.ibm.icu.lang.CharSequences;
import defpackage.cq;
import defpackage.og;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class StringRange {
    public static final Comparator<int[]> COMPARE_INT_ARRAYS = new Comparator<int[]>() { // from class: com.ibm.icu.impl.StringRange.1
        @Override // java.util.Comparator
        public int compare(int[] iArr, int[] iArr2) {
            int iMin = Math.min(iArr.length, iArr2.length);
            for (int i = 0; i < iMin; i++) {
                int i2 = iArr[i] - iArr2[i];
                if (i2 != 0) {
                    return i2;
                }
            }
            return iArr.length - iArr2.length;
        }
    };
    private static final boolean DEBUG = false;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface Adder {
        void add(String str, String str2);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Range implements Comparable<Range> {
        int max;
        int min;

        public Range(int i, int i2) {
            this.min = i;
            this.max = i2;
        }

        @Override // java.lang.Comparable
        public int compareTo(Range range) {
            int i = this.min - range.min;
            return i != 0 ? i : this.max - range.max;
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return obj != null && (obj instanceof Range) && compareTo((Range) obj) == 0;
            }
            return true;
        }

        public int hashCode() {
            return (this.min * 37) + this.max;
        }

        public String toString() {
            StringBuilder sbAppendCodePoint = new StringBuilder().appendCodePoint(this.min);
            if (this.min == this.max) {
                return sbAppendCodePoint.toString();
            }
            sbAppendCodePoint.append('~');
            return sbAppendCodePoint.appendCodePoint(this.max).toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Ranges implements Comparable<Ranges> {
        private final Range[] ranges;

        public Ranges(String str) {
            int[] iArrCodePoints = CharSequences.codePoints(str);
            this.ranges = new Range[iArrCodePoints.length];
            for (int i = 0; i < iArrCodePoints.length; i++) {
                Range[] rangeArr = this.ranges;
                int i2 = iArrCodePoints[i];
                rangeArr[i] = new Range(i2, i2);
            }
        }

        @Override // java.lang.Comparable
        public int compareTo(Ranges ranges) {
            int length = this.ranges.length - ranges.ranges.length;
            if (length != 0) {
                return length;
            }
            int i = 0;
            while (true) {
                Range[] rangeArr = this.ranges;
                if (i >= rangeArr.length) {
                    return 0;
                }
                int iCompareTo = rangeArr[i].compareTo(ranges.ranges[i]);
                if (iCompareTo != 0) {
                    return iCompareTo;
                }
                i++;
            }
        }

        public String end(boolean z) {
            int iFirstDifference = firstDifference();
            if (iFirstDifference == this.ranges.length) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            if (!z) {
                iFirstDifference = 0;
            }
            while (true) {
                Range[] rangeArr = this.ranges;
                if (iFirstDifference >= rangeArr.length) {
                    return sb.toString();
                }
                sb.appendCodePoint(rangeArr[iFirstDifference].max);
                iFirstDifference++;
            }
        }

        public int firstDifference() {
            int i = 0;
            while (true) {
                Range[] rangeArr = this.ranges;
                if (i >= rangeArr.length) {
                    return rangeArr.length;
                }
                Range range = rangeArr[i];
                if (range.min != range.max) {
                    return i;
                }
                i++;
            }
        }

        public boolean merge(int i, Ranges ranges) {
            for (int length = this.ranges.length - 1; length >= 0; length--) {
                Range[] rangeArr = this.ranges;
                if (length == i) {
                    if (rangeArr[length].max != ranges.ranges[length].min - 1) {
                        return false;
                    }
                } else if (!rangeArr[length].equals(ranges.ranges[length])) {
                    return false;
                }
            }
            this.ranges[i].max = ranges.ranges[i].max;
            return true;
        }

        public Integer size() {
            return Integer.valueOf(this.ranges.length);
        }

        public String start() {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                Range[] rangeArr = this.ranges;
                if (i >= rangeArr.length) {
                    return sb.toString();
                }
                sb.appendCodePoint(rangeArr[i].min);
                i++;
            }
        }

        public String toString() {
            String strStart = start();
            String strEnd = end(false);
            return strEnd == null ? strStart : cq.k(strStart, "~", strEnd);
        }
    }

    private static void add(int i, int i2, int[] iArr, int[] iArr2, StringBuilder sb, Collection<String> collection) {
        int i3 = iArr[i + i2];
        int i4 = iArr2[i];
        if (i3 > i4) {
            og.q("Range must have xᵢ ≤ yᵢ for each index i");
            return;
        }
        boolean z = i == iArr2.length - 1;
        int length = sb.length();
        for (int i5 = i3; i5 <= i4; i5++) {
            sb.appendCodePoint(i5);
            if (z) {
                collection.add(sb.toString());
            } else {
                add(i + 1, i2, iArr, iArr2, sb, collection);
            }
            sb.setLength(length);
        }
    }

    public static void compact(Set<String> set, Adder adder, boolean z, boolean z2) {
        int iCodePointAt;
        if (z2) {
            Relation relationOf = Relation.of(new TreeMap(), TreeSet.class);
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                Ranges ranges = new Ranges(it.next());
                relationOf.put(ranges.size(), ranges);
            }
            for (Map.Entry entry : relationOf.keyValuesSet()) {
                for (Ranges ranges2 : compact(((Integer) entry.getKey()).intValue(), (Set) entry.getValue())) {
                    adder.add(ranges2.start(), ranges2.end(z));
                }
            }
            return;
        }
        int length = 0;
        int iCodePointBefore = 0;
        String str = null;
        String strSubstring = null;
        for (String str2 : set) {
            if (str != null) {
                if (str2.regionMatches(0, str, 0, length) && (iCodePointAt = str2.codePointAt(length)) == iCodePointBefore + 1 && str2.length() == Character.charCount(iCodePointAt) + length) {
                    strSubstring = str2;
                    iCodePointBefore = iCodePointAt;
                } else {
                    if (strSubstring == null) {
                        strSubstring = null;
                    } else if (z) {
                        strSubstring = strSubstring.substring(length, strSubstring.length());
                    }
                    adder.add(str, strSubstring);
                }
            }
            iCodePointBefore = str2.codePointBefore(str2.length());
            length = str2.length() - Character.charCount(iCodePointBefore);
            strSubstring = null;
            str = str2;
        }
        adder.add(str, strSubstring != null ? !z ? strSubstring : strSubstring.substring(length, strSubstring.length()) : null);
    }

    public static Collection<String> expand(String str, String str2, boolean z, Collection<String> collection) {
        if (str == null || str2 == null) {
            og.q("Range must have 2 valid strings");
            return null;
        }
        int[] iArrCodePoints = CharSequences.codePoints(str);
        int[] iArrCodePoints2 = CharSequences.codePoints(str2);
        int length = iArrCodePoints.length - iArrCodePoints2.length;
        if (z && length != 0) {
            og.q("Range must have equal-length strings");
            return null;
        }
        if (length < 0) {
            og.q("Range must have start-length ≥ end-length");
            return null;
        }
        if (iArrCodePoints2.length == 0) {
            og.q("Range must have end-length > 0");
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.appendCodePoint(iArrCodePoints[i]);
        }
        add(0, length, iArrCodePoints, iArrCodePoints2, sb, collection);
        return collection;
    }

    public static void compact(Set<String> set, Adder adder, boolean z) {
        compact(set, adder, z, false);
    }

    private static LinkedList<Ranges> compact(int i, Set<Ranges> set) {
        LinkedList<Ranges> linkedList = new LinkedList<>(set);
        for (int i2 = i - 1; i2 >= 0; i2--) {
            Iterator<Ranges> it = linkedList.iterator();
            Ranges ranges = null;
            while (it.hasNext()) {
                Ranges next = it.next();
                if (ranges != null && ranges.merge(i2, next)) {
                    it.remove();
                } else {
                    ranges = next;
                }
            }
        }
        return linkedList;
    }
}
