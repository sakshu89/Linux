package com.ibm.icu.impl;

import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.text.StringTransform;
import com.ibm.icu.text.UTF16;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.text.UnicodeSetIterator;
import com.ibm.icu.util.Freezable;
import defpackage.cq;
import defpackage.dk0;
import defpackage.ky0;
import defpackage.og;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class UnicodeMap<T> implements Cloneable, Freezable<UnicodeMap<T>>, StringTransform, Iterable<String> {
    static final boolean ASSERTIONS = false;
    static final boolean DEBUG_WRITE = false;
    static final long GROWTH_GAP = 10;
    static final long GROWTH_PERCENT = 200;
    private LinkedHashSet<T> availableValues = new LinkedHashSet<>();
    private transient boolean errorOnReset;
    private int lastIndex;
    private int length;
    private volatile transient boolean locked;
    private transient boolean staleAvailableValues;
    private TreeMap<String, T> stringMap;
    private int[] transitions;
    T[] values;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class Composer<T> {
        public abstract T compose(int i, String str, T t, T t2);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class EntryRange<T> {
        public int codepoint;
        public int codepointEnd;
        public String string;
        public T value;

        public String toString() {
            String strJ;
            String str = this.string;
            if (str != null) {
                strJ = Utility.hex(str);
            } else {
                String strHex = Utility.hex(this.codepoint);
                int i = this.codepoint;
                int i2 = this.codepointEnd;
                strJ = ky0.j(strHex, i == i2 ? "" : cq.j("..", Utility.hex(i2)));
            }
            return cq.k(strJ, "=", String.valueOf(this.value));
        }
    }

    public UnicodeMap(UnicodeMap<T> unicodeMap) {
        clear();
        putAll(unicodeMap);
    }

    private int __findIndex(int i) {
        for (int i2 = this.length - 1; i2 > 0; i2--) {
            if (this.transitions[i2] <= i) {
                return i2;
            }
        }
        return 0;
    }

    private void _checkFind(int i, int i2) {
        int i__findIndex = __findIndex(i);
        if (i__findIndex == i2) {
            return;
        }
        throw new IllegalArgumentException("Invariant failed: binary search\t" + Utility.hex(i) + ": " + i2 + "\tshould be: " + i__findIndex);
    }

    private int _findIndex(int i) {
        int i2 = this.length - 1;
        int i3 = 0;
        for (int i4 = i2 >>> 1; i4 != i3; i4 = (i3 + i2) >>> 1) {
            if (i < this.transitions[i4]) {
                i2 = i4;
            } else {
                i3 = i4;
            }
        }
        return i3;
    }

    private void _insertGapAt(int i, int i2) {
        int i3 = this.length + i2;
        int[] iArr = this.transitions;
        T[] tArr = this.values;
        if (i3 > iArr.length) {
            int i4 = (int) (((((long) i3) * GROWTH_PERCENT) / 100) + GROWTH_GAP);
            this.transitions = new int[i4];
            this.values = (T[]) new Object[i4];
            for (int i5 = 0; i5 < i; i5++) {
                this.transitions[i5] = iArr[i5];
                this.values[i5] = tArr[i5];
            }
        }
        for (int i6 = this.length - 1; i6 >= i; i6--) {
            int i7 = i6 + i2;
            this.transitions[i7] = iArr[i6];
            this.values[i7] = tArr[i6];
        }
        this.length = i3;
    }

    private UnicodeMap<T> _put(int i, T t) {
        int[] iArr = this.transitions;
        int i_findIndex = this.lastIndex;
        if (iArr[i_findIndex] > i || i >= iArr[i_findIndex + 1]) {
            i_findIndex = _findIndex(i);
        }
        int i2 = i_findIndex + 1;
        if (areEqual(this.values[i_findIndex], t)) {
            return this;
        }
        if (this.locked) {
            dk0.r("Attempt to modify locked object");
            return null;
        }
        if (this.errorOnReset && this.values[i_findIndex] != null) {
            String strHex = Utility.hex(i);
            String strValueOf = String.valueOf(this.values[i_findIndex]);
            String strValueOf2 = String.valueOf(t);
            StringBuilder sbQ = cq.q("Attempt to reset value for ", strHex, " when that is disallowed. Old: ", strValueOf, "; New: ");
            sbQ.append(strValueOf2);
            throw new UnsupportedOperationException(sbQ.toString());
        }
        this.staleAvailableValues = true;
        this.availableValues.add(t);
        int[] iArr2 = this.transitions;
        int i3 = iArr2[i_findIndex];
        int i4 = iArr2[i2];
        if (i3 == i) {
            boolean z = false;
            boolean z2 = i_findIndex != 0 && areEqual(t, this.values[i_findIndex + (-1)]);
            int i5 = i + 1;
            if (i4 == i5) {
                if (i_findIndex < this.length - 2 && areEqual(t, this.values[i2])) {
                    z = true;
                }
                if (z2) {
                    if (z) {
                        _removeAt(i_findIndex, 2);
                    } else {
                        _removeAt(i_findIndex, 1);
                    }
                    i_findIndex--;
                } else if (z) {
                    _removeAt(i_findIndex, 1);
                    this.transitions[i_findIndex] = i;
                } else {
                    this.values[i_findIndex] = t;
                }
            } else {
                int[] iArr3 = this.transitions;
                if (z2) {
                    iArr3[i_findIndex] = iArr3[i_findIndex] + 1;
                } else {
                    iArr3[i_findIndex] = i5;
                    _insertGapAt(i_findIndex, 1);
                    this.values[i_findIndex] = t;
                    this.transitions[i_findIndex] = i;
                }
            }
        } else {
            int i6 = i + 1;
            if (i4 != i6) {
                _insertGapAt(i2, 2);
                int[] iArr4 = this.transitions;
                iArr4[i2] = i;
                T[] tArr = this.values;
                tArr[i2] = t;
                int i7 = i_findIndex + 2;
                iArr4[i7] = i6;
                tArr[i7] = tArr[i_findIndex];
                i_findIndex = i2;
            } else {
                if (i_findIndex < this.length - 2 && areEqual(t, this.values[i2])) {
                    int[] iArr5 = this.transitions;
                    iArr5[i2] = iArr5[i2] - 1;
                    return this;
                }
                _insertGapAt(i2, 1);
                this.transitions[i2] = i;
                this.values[i2] = t;
            }
        }
        this.lastIndex = i_findIndex;
        return this;
    }

    private UnicodeMap<T> _putAll(int i, int i2, T t) {
        while (i <= i2) {
            _put(i, t);
            i++;
        }
        return this;
    }

    private void _removeAt(int i, int i2) {
        int i3 = i + i2;
        while (true) {
            int i4 = this.length;
            if (i3 >= i4) {
                this.length = i4 - i2;
                return;
            }
            int[] iArr = this.transitions;
            int i5 = i3 - i2;
            iArr[i5] = iArr[i3];
            T[] tArr = this.values;
            tArr[i5] = tArr[i3];
            i3++;
        }
    }

    public static boolean areEqual(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static int findCommonPrefix(String str, String str2) {
        int iMin = Math.min(str.length(), str2.length());
        for (int i = 0; i < iMin; i++) {
            if (str.charAt(i) != str2.charAt(i)) {
                return i;
            }
        }
        return iMin;
    }

    public static <T> Map<T, UnicodeSet> freeze(Map<T, UnicodeSet> map) {
        Iterator<UnicodeSet> it = map.values().iterator();
        while (it.hasNext()) {
            it.next().freeze();
        }
        return Collections.unmodifiableMap(map);
    }

    private final UnicodeMap<T> removeRetainAll(UnicodeMap<T> unicodeMap, boolean z) {
        UnicodeSet unicodeSet = new UnicodeSet();
        for (EntryRange<T> entryRange : entryRanges()) {
            String str = entryRange.string;
            if (str == null) {
                for (int i = entryRange.codepoint; i <= entryRange.codepointEnd; i++) {
                    if (entryRange.value.equals(unicodeMap.get(i)) == z) {
                        unicodeSet.add(i);
                    }
                }
            } else if (entryRange.value.equals(unicodeMap.get(str)) == z) {
                unicodeSet.add(entryRange.string);
            }
        }
        return putAll(unicodeSet, null);
    }

    public void _checkInvariants() {
        int i = this.length;
        if (i >= 2) {
            int[] iArr = this.transitions;
            if (i <= iArr.length && iArr.length == this.values.length) {
                int i2 = 1;
                while (true) {
                    int i3 = this.length;
                    if (i2 >= i3 - 1) {
                        int[] iArr2 = this.transitions;
                        if (iArr2[0] != 0 || iArr2[i3 - 1] != 1114112) {
                            og.i("Invariant failed: bounds set wrong");
                            return;
                        }
                        for (int i4 = 1; i4 < this.length - 1; i4++) {
                            int[] iArr3 = this.transitions;
                            int i5 = i4 - 1;
                            if (iArr3[i5] >= iArr3[i4]) {
                                throw new IllegalArgumentException("Invariant failed: not monotonic\t" + Utility.hex(i5) + ": " + this.transitions[i5] + "\t" + Utility.hex(i4) + ": " + this.transitions[i4]);
                            }
                        }
                        return;
                    }
                    T[] tArr = this.values;
                    int i6 = i2 - 1;
                    if (areEqual(tArr[i6], tArr[i2])) {
                        String strHex = Utility.hex(i6);
                        String strValueOf = String.valueOf(this.values[i6]);
                        String strHex2 = Utility.hex(i2);
                        String strValueOf2 = String.valueOf(this.values[i2]);
                        StringBuilder sbQ = cq.q("Invariant failed: values shared at \t", strHex, ": <", strValueOf, ">\t");
                        sbQ.append(strHex2);
                        sbQ.append(": <");
                        sbQ.append(strValueOf2);
                        sbQ.append(">");
                        throw new IllegalArgumentException(sbQ.toString());
                    }
                    i2++;
                }
            }
        }
        og.i("Invariant failed: Lengths bad");
    }

    public <U extends Map<T, UnicodeSet>> U addInverseTo(U u) {
        for (T t : values()) {
            u.put(t, getSet(t));
        }
        return u;
    }

    public UnicodeMap<T> clear() {
        if (this.locked) {
            dk0.r("Attempt to modify locked object");
            return null;
        }
        this.length = 2;
        this.transitions = new int[]{0, 1114112, 0, 0, 0, 0, 0, 0, 0, 0};
        this.values = (T[]) new Object[10];
        this.availableValues.clear();
        this.staleAvailableValues = false;
        this.errorOnReset = false;
        this.lastIndex = 0;
        this.stringMap = null;
        return this;
    }

    @Override // com.ibm.icu.util.Freezable
    public UnicodeMap<T> cloneAsThawed() {
        UnicodeMap<T> unicodeMap = new UnicodeMap<>();
        unicodeMap.length = this.length;
        unicodeMap.transitions = (int[]) this.transitions.clone();
        unicodeMap.values = (T[]) ((Object[]) this.values.clone());
        unicodeMap.availableValues = new LinkedHashSet<>(this.availableValues);
        unicodeMap.locked = false;
        unicodeMap.stringMap = this.stringMap == null ? null : new TreeMap<>((SortedMap) this.stringMap);
        return unicodeMap;
    }

    public UnicodeMap<T> composeWith(UnicodeSet unicodeSet, T t, Composer<T> composer) {
        UnicodeSetIterator unicodeSetIterator = new UnicodeSetIterator(unicodeSet);
        while (unicodeSetIterator.next()) {
            int i = unicodeSetIterator.codepoint;
            if (i == -1) {
                String str = unicodeSetIterator.string;
                T value = getValue(str);
                T tCompose = composer.compose(-1, str, value, t);
                if (value != tCompose && (value == null || !value.equals(tCompose))) {
                    put(str, tCompose);
                }
            } else {
                T value2 = getValue(i);
                T tCompose2 = composer.compose(i, null, value2, t);
                if (value2 != tCompose2 && (value2 == null || !value2.equals(tCompose2))) {
                    put(i, tCompose2);
                }
            }
        }
        return this;
    }

    public boolean containsKey(String str) {
        return getValue(str) != null;
    }

    public boolean containsValue(T t) {
        return getAvailableValues().contains(t);
    }

    public Iterable<EntryRange<T>> entryRanges() {
        return new EntryRanges(this, 0);
    }

    public Iterable<Map.Entry<String, T>> entrySet() {
        return new EntrySetX(this, 0);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            UnicodeMap unicodeMap = (UnicodeMap) obj;
            if (this.length != unicodeMap.length) {
                return false;
            }
            for (int i = 0; i < this.length - 1; i++) {
                if (this.transitions[i] != unicodeMap.transitions[i] || !areEqual(this.values[i], unicodeMap.values[i])) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public T get(String str) {
        if (!UTF16.hasMoreCodePointsThan(str, 1)) {
            return getValue(UTF16.charAt(str, 0));
        }
        TreeMap<String, T> treeMap = this.stringMap;
        if (treeMap == null) {
            return null;
        }
        return treeMap.get(str);
    }

    public Collection<T> getAvailableValues() {
        return values();
    }

    public boolean getErrorOnReset() {
        return this.errorOnReset;
    }

    public Set<String> getNonRangeStrings() {
        TreeMap<String, T> treeMap = this.stringMap;
        if (treeMap == null || treeMap.isEmpty()) {
            return null;
        }
        return Collections.unmodifiableSet(this.stringMap.keySet());
    }

    public int getRangeCount() {
        return this.length - 1;
    }

    public int getRangeEnd(int i) {
        return this.transitions[i + 1] - 1;
    }

    public int getRangeStart(int i) {
        return this.transitions[i];
    }

    public T getRangeValue(int i) {
        return this.values[i];
    }

    public UnicodeSet getSet(T t) {
        return keySet(t);
    }

    public T getValue(String str) {
        return get(str);
    }

    public int hashCode() {
        int iHashCode = this.length;
        for (int i = 0; i < this.length - 1; i++) {
            iHashCode = ((iHashCode * 37) + this.transitions[i]) * 37;
            T t = this.values[i];
            if (t != null) {
                iHashCode = t.hashCode() + iHashCode;
            }
        }
        TreeMap<String, T> treeMap = this.stringMap;
        if (treeMap == null) {
            return iHashCode;
        }
        return treeMap.hashCode() + (iHashCode * 37);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // com.ibm.icu.util.Freezable
    public boolean isFrozen() {
        return this.locked;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return keySet().iterator();
    }

    public UnicodeSet keySet(T t, UnicodeSet unicodeSet) {
        TreeMap<String, T> treeMap;
        if (unicodeSet == null) {
            unicodeSet = new UnicodeSet();
        }
        for (int i = 0; i < this.length - 1; i++) {
            if (areEqual(t, this.values[i])) {
                int[] iArr = this.transitions;
                unicodeSet.add(iArr[i], iArr[i + 1] - 1);
            }
        }
        if (t != null && (treeMap = this.stringMap) != null) {
            for (String str : treeMap.keySet()) {
                if (t.equals(this.stringMap.get(str))) {
                    unicodeSet.add(str);
                }
            }
        }
        return unicodeSet;
    }

    public UnicodeMap<T> put(String str, T t) {
        int singleCodePoint = UnicodeSet.getSingleCodePoint(str);
        if (singleCodePoint != Integer.MAX_VALUE) {
            return put(singleCodePoint, t);
        }
        if (this.locked) {
            dk0.r("Attempt to modify locked object");
            return null;
        }
        TreeMap<String, T> treeMap = this.stringMap;
        if (t == null) {
            if (treeMap != null && treeMap.remove(str) != null) {
                this.staleAvailableValues = true;
            }
            return this;
        }
        if (treeMap == null) {
            this.stringMap = new TreeMap<>();
        }
        this.stringMap.put(str, t);
        this.staleAvailableValues = true;
        return this;
    }

    public UnicodeMap<T> putAll(UnicodeMap<T> unicodeMap) {
        for (int i = 0; i < unicodeMap.length; i++) {
            T t = unicodeMap.values[i];
            if (t != null) {
                int[] iArr = unicodeMap.transitions;
                _putAll(iArr[i], iArr[i + 1] - 1, t);
            }
        }
        TreeMap<String, T> treeMap = unicodeMap.stringMap;
        if (treeMap != null && !treeMap.isEmpty()) {
            if (this.stringMap == null) {
                this.stringMap = new TreeMap<>();
            }
            this.stringMap.putAll(unicodeMap.stringMap);
        }
        return this;
    }

    public <U extends Map<Integer, T>> U putAllCodepointsInto(U u) {
        for (EntryRange<T> entryRange : entryRanges()) {
            if (entryRange.string != null) {
                break;
            }
            for (int i = entryRange.codepoint; i <= entryRange.codepointEnd; i++) {
                u.put(Integer.valueOf(i), entryRange.value);
            }
        }
        return u;
    }

    public UnicodeMap<T> putAllFiltered(UnicodeMap<T> unicodeMap, UnicodeSet unicodeSet) {
        T value;
        UnicodeSetIterator unicodeSetIterator = new UnicodeSetIterator(unicodeSet);
        while (unicodeSetIterator.next()) {
            int i = unicodeSetIterator.codepoint;
            if (i != -1 && (value = unicodeMap.getValue(i)) != null) {
                _put(unicodeSetIterator.codepoint, value);
            }
        }
        for (String str : unicodeSet.strings()) {
            T t = unicodeMap.get(str);
            if (t != null) {
                put(str, t);
            }
        }
        return this;
    }

    @Deprecated
    public UnicodeMap<T> putAllIn(Map<? super String, ? super T> map) {
        for (String str : keySet()) {
            map.put(str, get(str));
        }
        return this;
    }

    public <U extends Map<String, T>> U putAllInto(U u) {
        for (EntryRange<T> entryRange : entryRanges()) {
            if (entryRange.string != null) {
                break;
            }
            for (int i = entryRange.codepoint; i <= entryRange.codepointEnd; i++) {
                u.put(UTF16.valueOf(i), entryRange.value);
            }
        }
        u.putAll(this.stringMap);
        return u;
    }

    public UnicodeMap<T> putAllInverse(Map<T, UnicodeSet> map) {
        for (Map.Entry<T, UnicodeSet> entry : map.entrySet()) {
            putAll(entry.getValue(), entry.getKey());
        }
        return this;
    }

    public UnicodeMap<T> remove(String str) {
        return put(str, (Object) null);
    }

    public final UnicodeMap<T> removeAll(UnicodeSet unicodeSet) {
        return putAll(unicodeSet, null);
    }

    public final UnicodeMap<T> retainAll(UnicodeSet unicodeSet) {
        UnicodeSet unicodeSet2 = new UnicodeSet();
        for (EntryRange<T> entryRange : entryRanges()) {
            String str = entryRange.string;
            if (str == null) {
                for (int i = entryRange.codepoint; i <= entryRange.codepointEnd; i++) {
                    if (!unicodeSet.contains(i)) {
                        unicodeSet2.add(i);
                    }
                }
            } else if (!unicodeSet.contains(str)) {
                unicodeSet2.add(entryRange.string);
            }
        }
        return putAll(unicodeSet2, null);
    }

    public UnicodeMap<T> setErrorOnReset(boolean z) {
        this.errorOnReset = z;
        return this;
    }

    public UnicodeMap<T> setMissing(T t) {
        if (getAvailableValues().contains(t)) {
            return putAll(keySet(null), t);
        }
        this.staleAvailableValues = true;
        this.availableValues.add(t);
        for (int i = 0; i < this.length; i++) {
            T[] tArr = this.values;
            if (tArr[i] == null) {
                tArr[i] = t;
            }
        }
        return this;
    }

    public int size() {
        TreeMap<String, T> treeMap = this.stringMap;
        int size = treeMap == null ? 0 : treeMap.size();
        for (int i = 0; i < this.length - 1; i++) {
            if (this.values[i] != null) {
                int[] iArr = this.transitions;
                size = (iArr[i + 1] - iArr[i]) + size;
            }
        }
        return size;
    }

    public final Set<String> stringKeys() {
        return getNonRangeStrings();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String toString(Comparator<T> comparator) {
        StringBuffer stringBuffer = new StringBuffer();
        if (comparator == null) {
            for (int i = 0; i < this.length - 1; i++) {
                T t = this.values[i];
                if (t != null) {
                    int[] iArr = this.transitions;
                    int i2 = iArr[i];
                    int i3 = iArr[i + 1] - 1;
                    stringBuffer.append(Utility.hex(i2));
                    if (i2 != i3) {
                        stringBuffer.append(LanguageTag.SEP);
                        stringBuffer.append(Utility.hex(i3));
                    }
                    stringBuffer.append("=");
                    stringBuffer.append(t.toString());
                    stringBuffer.append("\n");
                }
            }
            TreeMap<String, T> treeMap = this.stringMap;
            if (treeMap != null) {
                for (String str : treeMap.keySet()) {
                    stringBuffer.append(Utility.hex(str));
                    stringBuffer.append("=");
                    stringBuffer.append(this.stringMap.get(str).toString());
                    stringBuffer.append("\n");
                }
            }
        } else {
            for (Object obj : (Set) values(new TreeSet(comparator))) {
                UnicodeSet unicodeSetKeySet = keySet(obj);
                stringBuffer.append(obj);
                stringBuffer.append("=");
                stringBuffer.append(unicodeSetKeySet.toString());
                stringBuffer.append("\n");
            }
        }
        return stringBuffer.toString();
    }

    @Override // com.ibm.icu.text.StringTransform, com.ibm.icu.text.Transform
    public String transform(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int charCount = 0;
        while (charCount < str.length()) {
            int iCharAt = UTF16.charAt(str, charCount);
            T value = getValue(iCharAt);
            if (value != null) {
                stringBuffer.append(value);
            } else {
                UTF16.append(stringBuffer, iCharAt);
            }
            charCount += UTF16.getCharCount(iCharAt);
        }
        return stringBuffer.toString();
    }

    public <U extends Collection<T>> U values(U u) {
        if (this.staleAvailableValues) {
            HashSet hashSet = new HashSet();
            for (int i = 0; i < this.length - 1; i++) {
                T t = this.values[i];
                if (t != null) {
                    hashSet.add(t);
                }
            }
            this.availableValues.retainAll(hashSet);
            TreeMap<String, T> treeMap = this.stringMap;
            if (treeMap != null) {
                this.availableValues.addAll(treeMap.values());
            }
            this.staleAvailableValues = false;
        }
        if (u == null) {
            u = new LinkedHashSet(this.availableValues.size());
        }
        u.addAll(this.availableValues);
        return u;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class EntrySetX implements Iterable<Map.Entry<String, T>> {
        private EntrySetX() {
        }

        @Override // java.lang.Iterable
        public Iterator<Map.Entry<String, T>> iterator() {
            return new IteratorX(UnicodeMap.this, 0);
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            Iterator<Map.Entry<String, T>> it = iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().toString());
                stringBuffer.append(' ');
            }
            return stringBuffer.toString();
        }

        public /* synthetic */ EntrySetX(UnicodeMap unicodeMap, int i) {
            this();
        }
    }

    public <U extends Collection<T>> U getAvailableValues(U u) {
        return (U) values(u);
    }

    public UnicodeSet getSet(T t, UnicodeSet unicodeSet) {
        return keySet(t, unicodeSet);
    }

    public T getValue(int i) {
        return get(i);
    }

    public UnicodeMap<T> remove(int i) {
        return put(i, (Object) null);
    }

    public final UnicodeMap<T> removeAll(UnicodeMap<T> unicodeMap) {
        return removeRetainAll(unicodeMap, true);
    }

    public boolean containsKey(int i) {
        return getValue(i) != null;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class IteratorX implements Iterator<Map.Entry<String, T>> {
        Iterator<String> iterator;

        private IteratorX() {
            this.iterator = UnicodeMap.this.keySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.iterator.hasNext();
        }

        @Override // java.util.Iterator
        public Map.Entry<String, T> next() {
            String next = this.iterator.next();
            return new ImmutableEntry(next, UnicodeMap.this.get(next));
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ IteratorX(UnicodeMap unicodeMap, int i) {
            this();
        }
    }

    public UnicodeMap() {
        clear();
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class EntryRanges implements Iterable<EntryRange<T>>, Iterator<EntryRange<T>> {
        private int lastRealRange;
        private int pos;
        private EntryRange<T> result;
        private Iterator<Map.Entry<String, T>> stringIterator;

        private EntryRanges() {
            this.result = new EntryRange<>();
            this.lastRealRange = UnicodeMap.this.values[UnicodeMap.this.length + (-2)] == null ? UnicodeMap.this.length - 2 : UnicodeMap.this.length - 1;
            this.stringIterator = UnicodeMap.this.stringMap == null ? null : UnicodeMap.this.stringMap.entrySet().iterator();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.pos < this.lastRealRange) {
                return true;
            }
            Iterator<Map.Entry<String, T>> it = this.stringIterator;
            return it != null && it.hasNext();
        }

        @Override // java.util.Iterator
        public EntryRange<T> next() {
            int i = this.pos;
            if (i < this.lastRealRange) {
                UnicodeMap unicodeMap = UnicodeMap.this;
                T[] tArr = unicodeMap.values;
                T t = tArr[i];
                if (t == null) {
                    int i2 = i + 1;
                    this.pos = i2;
                    t = tArr[i2];
                }
                this.result.codepoint = unicodeMap.transitions[this.pos];
                EntryRange<T> entryRange = this.result;
                int[] iArr = UnicodeMap.this.transitions;
                int i3 = this.pos;
                entryRange.codepointEnd = iArr[i3 + 1] - 1;
                EntryRange<T> entryRange2 = this.result;
                entryRange2.string = null;
                entryRange2.value = t;
                this.pos = i3 + 1;
            } else {
                Map.Entry<String, T> next = this.stringIterator.next();
                EntryRange<T> entryRange3 = this.result;
                entryRange3.codepointEnd = -1;
                entryRange3.codepoint = -1;
                entryRange3.string = next.getKey();
                this.result.value = next.getValue();
            }
            return this.result;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override // java.lang.Iterable
        public Iterator<EntryRange<T>> iterator() {
            return this;
        }

        public /* synthetic */ EntryRanges(UnicodeMap unicodeMap, int i) {
            this();
        }
    }

    public T get(int i) {
        if (i >= 0 && i <= 1114111) {
            return this.values[_findIndex(i)];
        }
        og.i(ky0.h(i, "Codepoint out of range: "));
        return null;
    }

    @Override // com.ibm.icu.util.Freezable
    public UnicodeMap<T> freeze() {
        this.locked = true;
        return this;
    }

    public UnicodeMap<T> putAll(int i, int i2, T t) {
        if (this.locked) {
            dk0.r("Attempt to modify locked object");
            return null;
        }
        if (i >= 0 && i2 <= 1114111) {
            return _putAll(i, i2, t);
        }
        og.i(cq.l("Codepoint out of range: ", Utility.hex(i), "..", Utility.hex(i2)));
        return null;
    }

    public UnicodeMap<T> put(int i, T t) {
        if (i >= 0 && i <= 1114111) {
            _put(i, t);
            return this;
        }
        og.i(ky0.h(i, "Codepoint out of range: "));
        return null;
    }

    public UnicodeMap<T> putAll(UnicodeSet unicodeSet, T t) {
        UnicodeSetIterator unicodeSetIterator = new UnicodeSetIterator(unicodeSet);
        while (unicodeSetIterator.nextRange()) {
            String str = unicodeSetIterator.string;
            if (str == null) {
                _putAll(unicodeSetIterator.codepoint, unicodeSetIterator.codepointEnd, t);
            } else {
                put(str, t);
            }
        }
        return this;
    }

    public UnicodeMap<T> composeWith(UnicodeMap<T> unicodeMap, Composer<T> composer) {
        for (T t : unicodeMap.getAvailableValues()) {
            composeWith(unicodeMap.keySet(t), t, composer);
        }
        return this;
    }

    public final UnicodeMap<T> retainAll(UnicodeMap<T> unicodeMap) {
        return removeRetainAll(unicodeMap, false);
    }

    public UnicodeMap<T> putAll(Map<? extends String, ? extends T> map) {
        for (String str : map.keySet()) {
            put(str, map.get(str));
        }
        return this;
    }

    public Set<T> values() {
        return (Set) getAvailableValues(null);
    }

    public UnicodeSet keySet(T t) {
        return keySet(t, null);
    }

    public UnicodeSet keySet() {
        UnicodeSet unicodeSet = new UnicodeSet();
        for (int i = 0; i < this.length - 1; i++) {
            if (this.values[i] != null) {
                int[] iArr = this.transitions;
                unicodeSet.add(iArr[i], iArr[i + 1] - 1);
            }
        }
        TreeMap<String, T> treeMap = this.stringMap;
        if (treeMap != null) {
            unicodeSet.addAll(treeMap.keySet());
        }
        return unicodeSet;
    }

    public String toString() {
        return toString(null);
    }
}
