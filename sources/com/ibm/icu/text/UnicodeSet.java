package com.ibm.icu.text;

import com.ibm.icu.impl.BMPSet;
import com.ibm.icu.impl.CharacterPropertiesImpl;
import com.ibm.icu.impl.PatternProps;
import com.ibm.icu.impl.PatternTokenizer;
import com.ibm.icu.impl.RuleCharacterIterator;
import com.ibm.icu.impl.SortedSetRelation;
import com.ibm.icu.impl.UCaseProps;
import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.UPropertyAliases;
import com.ibm.icu.impl.UnicodeSetStringSpan;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.impl.locale.LanguageTag;
import com.ibm.icu.lang.CharSequences;
import com.ibm.icu.lang.CharacterProperties;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UProperty;
import com.ibm.icu.lang.UScript;
import com.ibm.icu.util.Freezable;
import com.ibm.icu.util.OutputInt;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.VersionInfo;
import defpackage.cq;
import defpackage.dk0;
import defpackage.kf2;
import defpackage.ky0;
import defpackage.og;
import java.io.IOException;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class UnicodeSet extends UnicodeFilter implements Iterable<String>, Comparable<UnicodeSet>, Freezable<UnicodeSet>, Cloneable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int ADD_CASE_MAPPINGS = 4;
    private static final String ANY_ID = "ANY";
    private static final String ASCII_ID = "ASCII";
    private static final String ASSIGNED = "Assigned";

    @Deprecated
    public static final int CASE = 2;
    public static final int CASE_INSENSITIVE = 2;
    private static final int CASE_MASK = 6;
    private static final int HIGH = 1114112;
    public static final int IGNORE_SPACE = 1;
    private static final int INITIAL_CAPACITY = 25;
    private static final int LOW = 0;
    private static final int MAX_DEPTH = 100;
    private static final int MAX_LENGTH = 1114113;
    public static final int MAX_VALUE = 1114111;
    public static final int MIN_VALUE = 0;
    public static final int SIMPLE_CASE_INSENSITIVE = 6;
    private volatile BMPSet bmpSet;
    private int[] buffer;
    private int len;
    private int[] list;
    private String pat;
    private int[] rangeList;
    private volatile UnicodeSetStringSpan stringSpan;
    SortedSet<String> strings;
    private static final SortedSet<String> EMPTY_STRINGS = Collections.unmodifiableSortedSet(new TreeSet());
    public static final UnicodeSet EMPTY = new UnicodeSet().freeze();
    public static final UnicodeSet ALL_CODE_POINTS = new UnicodeSet(0, 1114111).freeze();
    private static volatile XSymbolTable XSYMBOL_TABLE = null;
    private static final VersionInfo NO_VERSION = VersionInfo.getInstance(0, 0, 0, 0);

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CodePointIterable implements Iterable<Integer> {
        private final UnicodeSet unicodeSet;

        public CodePointIterable(UnicodeSet unicodeSet) {
            this.unicodeSet = unicodeSet;
        }

        @Override // java.lang.Iterable
        public Iterator<Integer> iterator() {
            return new CodePointIterator(this.unicodeSet);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CodePointIterator implements Iterator<Integer> {
        private final CodePointIteratorInt cpi;

        public CodePointIterator(UnicodeSet unicodeSet) {
            this.cpi = new CodePointIteratorInt(unicodeSet);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.cpi.hasNext();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Integer next() {
            return Integer.valueOf(this.cpi.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CodePointIteratorInt {
        private int currentRange;
        private final int lastRange;
        private final int[] list;
        private int rangeLimit;
        private int rangeStart;

        public CodePointIteratorInt(UnicodeSet unicodeSet) {
            this.currentRange = 0;
            int[] iArr = unicodeSet.list;
            this.list = iArr;
            int i = unicodeSet.len - 1;
            this.lastRange = i;
            this.currentRange = 1;
            int i2 = iArr[0];
            this.rangeStart = i2;
            if (i <= 0) {
                this.rangeLimit = i2;
            } else {
                this.currentRange = 1 + 1;
                this.rangeLimit = iArr[1];
            }
        }

        public boolean hasNext() {
            return this.rangeStart < this.rangeLimit || this.currentRange < this.lastRange;
        }

        public int next() {
            if (this.rangeStart >= this.rangeLimit) {
                int i = this.currentRange;
                if (i >= this.lastRange) {
                    dk0.d();
                    return 0;
                }
                int[] iArr = this.list;
                int i2 = i + 1;
                this.currentRange = i2;
                this.rangeStart = iArr[i];
                this.currentRange = i + 2;
                this.rangeLimit = iArr[i2];
            }
            int i3 = this.rangeStart;
            this.rangeStart = i3 + 1;
            return i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum ComparisonStyle {
        SHORTER_FIRST,
        LEXICOGRAPHIC,
        LONGER_FIRST
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class EntryRange {
        public int codepoint;
        public int codepointEnd;

        public String toString() {
            StringBuilder sb;
            StringBuilder sb2 = new StringBuilder();
            int i = this.codepoint;
            if (i == this.codepointEnd) {
                sb = (StringBuilder) UnicodeSet.f(i, sb2);
            } else {
                StringBuilder sb3 = (StringBuilder) UnicodeSet.f(i, sb2);
                sb3.append('-');
                sb = (StringBuilder) UnicodeSet.f(this.codepointEnd, sb3);
            }
            return sb.toString();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface Filter {
        boolean contains(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class GeneralCategoryMaskFilter implements Filter {
        int mask;

        public GeneralCategoryMaskFilter(int i) {
            this.mask = i;
        }

        @Override // com.ibm.icu.text.UnicodeSet.Filter
        public boolean contains(int i) {
            return (this.mask & (1 << UCharacter.getType(i))) != 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class IdentifierTypeFilter implements Filter {
        int idType;

        public IdentifierTypeFilter(int i) {
            this.idType = i;
        }

        @Override // com.ibm.icu.text.UnicodeSet.Filter
        public boolean contains(int i) {
            return UCharacterProperty.INSTANCE.hasIDType(i, this.idType);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class IntPropertyFilter implements Filter {
        int prop;
        int value;

        public IntPropertyFilter(int i, int i2) {
            this.prop = i;
            this.value = i2;
        }

        @Override // com.ibm.icu.text.UnicodeSet.Filter
        public boolean contains(int i) {
            return UCharacter.getIntPropertyValue(i, this.prop) == this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class NumericValueFilter implements Filter {
        double value;

        public NumericValueFilter(double d) {
            this.value = d;
        }

        @Override // com.ibm.icu.text.UnicodeSet.Filter
        public boolean contains(int i) {
            return UCharacter.getUnicodeNumericValue(i) == this.value;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ScriptExtensionsFilter implements Filter {
        int script;

        public ScriptExtensionsFilter(int i) {
            this.script = i;
        }

        @Override // com.ibm.icu.text.UnicodeSet.Filter
        public boolean contains(int i) {
            return UScript.hasScript(i, this.script);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum SpanCondition {
        NOT_CONTAINED,
        CONTAINED,
        SIMPLE,
        CONDITION_COUNT
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class UnicodeSetIterator2 implements Iterator<String> {
        private char[] buffer;
        private int current;
        private int item;
        private int len;
        private int limit;
        private int[] sourceList;
        private SortedSet<String> sourceStrings;
        private Iterator<String> stringIterator;

        public UnicodeSetIterator2(UnicodeSet unicodeSet) {
            int i = unicodeSet.len - 1;
            this.len = i;
            SortedSet<String> sortedSet = unicodeSet.strings;
            if (i <= 0) {
                this.stringIterator = sortedSet.iterator();
                this.sourceList = null;
                return;
            }
            this.sourceStrings = sortedSet;
            int[] iArr = unicodeSet.list;
            this.sourceList = iArr;
            int i2 = this.item;
            int i3 = i2 + 1;
            this.item = i3;
            this.current = iArr[i2];
            this.item = i2 + 2;
            this.limit = iArr[i3];
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.sourceList != null || this.stringIterator.hasNext();
        }

        @Override // java.util.Iterator
        public String next() {
            int[] iArr = this.sourceList;
            if (iArr == null) {
                return this.stringIterator.next();
            }
            int i = this.current;
            int i2 = i + 1;
            this.current = i2;
            if (i2 >= this.limit) {
                int i3 = this.item;
                if (i3 >= this.len) {
                    this.stringIterator = this.sourceStrings.iterator();
                    this.sourceList = null;
                } else {
                    int i4 = i3 + 1;
                    this.item = i4;
                    this.current = iArr[i3];
                    this.item = i3 + 2;
                    this.limit = iArr[i4];
                }
            }
            if (i <= 65535) {
                return String.valueOf((char) i);
            }
            if (this.buffer == null) {
                this.buffer = new char[2];
            }
            int i5 = i - 65536;
            char[] cArr = this.buffer;
            cArr[0] = (char) ((i5 >>> 10) + 55296);
            cArr[1] = (char) ((i5 & UCharacterProperty.MAX_SCRIPT) + UTF16.TRAIL_SURROGATE_MIN_VALUE);
            return String.valueOf(cArr);
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class VersionFilter implements Filter {
        VersionInfo version;

        public VersionFilter(VersionInfo versionInfo) {
            this.version = versionInfo;
        }

        @Override // com.ibm.icu.text.UnicodeSet.Filter
        public boolean contains(int i) {
            VersionInfo age = UCharacter.getAge(i);
            return !Utility.sameObjects(age, UnicodeSet.NO_VERSION) && age.compareTo(this.version) <= 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class XSymbolTable implements SymbolTable {
        public boolean applyPropertyAlias(String str, String str2, UnicodeSet unicodeSet) {
            return false;
        }

        @Override // com.ibm.icu.text.SymbolTable
        public char[] lookup(String str) {
            return null;
        }

        @Override // com.ibm.icu.text.SymbolTable
        public UnicodeMatcher lookupMatcher(int i) {
            return null;
        }

        @Override // com.ibm.icu.text.SymbolTable
        public String parseReference(String str, ParsePosition parsePosition, int i) {
            return null;
        }

        @Deprecated
        public String scanVariable(String str, ParsePosition parsePosition, int i) {
            ParsePosition parsePosition2;
            String reference;
            if (parsePosition.getIndex() >= i || str.charAt(parsePosition.getIndex()) != '$' || (reference = parseReference(str, (parsePosition2 = new ParsePosition(parsePosition.getIndex() + 1)), i)) == null) {
                return null;
            }
            parsePosition.setIndex(parsePosition2.getIndex());
            return reference;
        }
    }

    public UnicodeSet(int... iArr) {
        this.strings = EMPTY_STRINGS;
        this.pat = null;
        if ((iArr.length & 1) != 0) {
            og.i("Must have even number of integers");
            throw null;
        }
        int[] iArr2 = new int[iArr.length + 1];
        this.list = iArr2;
        this.len = iArr2.length;
        int i = -1;
        int i2 = 0;
        while (i2 < iArr.length) {
            int i3 = iArr[i2];
            if (i >= i3) {
                og.i("Must be monotonically increasing.");
                throw null;
            }
            int[] iArr3 = this.list;
            int i4 = i2 + 1;
            iArr3[i2] = i3;
            int i5 = iArr[i4] + 1;
            if (i3 >= i5) {
                og.i("Must be monotonically increasing.");
                throw null;
            }
            i2 += 2;
            iArr3[i4] = i5;
            i = i5;
        }
        this.list[i2] = 1114112;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x003b A[Catch: IOException -> 0x0042, TryCatch #0 {IOException -> 0x0042, blocks: (B:3:0x0002, B:8:0x000f, B:22:0x002e, B:23:0x0031, B:25:0x0037, B:27:0x003e, B:26:0x003b, B:6:0x0009), top: B:32:0x0000 }] */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000d, code lost:
    
        if (com.ibm.icu.impl.Utility.shouldAlwaysBeEscaped(r2) != false) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static <T extends java.lang.Appendable> T _appendToPat(T r1, int r2, boolean r3) {
        /*
            if (r3 == 0) goto L9
            boolean r3 = com.ibm.icu.impl.Utility.isUnprintable(r2)     // Catch: java.io.IOException -> L42
            if (r3 == 0) goto L14
            goto Lf
        L9:
            boolean r3 = com.ibm.icu.impl.Utility.shouldAlwaysBeEscaped(r2)     // Catch: java.io.IOException -> L42
            if (r3 == 0) goto L14
        Lf:
            java.lang.Appendable r1 = com.ibm.icu.impl.Utility.escape(r1, r2)     // Catch: java.io.IOException -> L42
            return r1
        L14:
            r3 = 36
            r0 = 92
            if (r2 == r3) goto L3b
            r3 = 38
            if (r2 == r3) goto L3b
            r3 = 45
            if (r2 == r3) goto L3b
            r3 = 58
            if (r2 == r3) goto L3b
            r3 = 123(0x7b, float:1.72E-43)
            if (r2 == r3) goto L3b
            r3 = 125(0x7d, float:1.75E-43)
            if (r2 == r3) goto L3b
            switch(r2) {
                case 91: goto L3b;
                case 92: goto L3b;
                case 93: goto L3b;
                case 94: goto L3b;
                default: goto L31;
            }     // Catch: java.io.IOException -> L42
        L31:
            boolean r3 = com.ibm.icu.impl.PatternProps.isWhiteSpace(r2)     // Catch: java.io.IOException -> L42
            if (r3 == 0) goto L3e
            r1.append(r0)     // Catch: java.io.IOException -> L42
            goto L3e
        L3b:
            r1.append(r0)     // Catch: java.io.IOException -> L42
        L3e:
            appendCodePoint(r1, r2)     // Catch: java.io.IOException -> L42
            return r1
        L42:
            r1 = move-exception
            defpackage.kf2.h(r1)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.UnicodeSet._appendToPat(java.lang.Appendable, int, boolean):java.lang.Appendable");
    }

    private <T extends Appendable> T _toPattern(T t, boolean z) {
        String str = this.pat;
        if (str == null) {
            return (T) appendNewPattern(t, z, true);
        }
        try {
            if (!z) {
                t.append(str);
                return t;
            }
            int iCharCount = 0;
            boolean z2 = false;
            while (iCharCount < this.pat.length()) {
                int iCodePointAt = this.pat.codePointAt(iCharCount);
                iCharCount += Character.charCount(iCodePointAt);
                if (Utility.isUnprintable(iCodePointAt)) {
                    Utility.escape(t, iCodePointAt);
                } else if (z2 || iCodePointAt != 92) {
                    if (z2) {
                        t.append(PatternTokenizer.BACK_SLASH);
                    }
                    appendCodePoint(t, iCodePointAt);
                } else {
                    z2 = true;
                }
                z2 = false;
            }
            if (z2) {
                t.append(PatternTokenizer.BACK_SLASH);
            }
            return t;
        } catch (IOException e) {
            kf2.h(e);
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:41:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:48:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:57:0x011f  */
    private UnicodeSet add(int[] iArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        ensureBufferCapacity(this.len + i);
        int i10 = 0;
        int iMax = this.list[0];
        int iMax2 = iArr[0];
        int i11 = 1;
        int i12 = 1;
        while (true) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            continue;
                        } else if (iMax2 <= iMax) {
                            if (iMax == 1114112) {
                                break;
                            }
                            i3 = i10 + 1;
                            this.buffer[i10] = iMax;
                            int i13 = i11 + 1;
                            iMax = this.list[i11];
                            int i14 = iArr[i12];
                            i2 ^= 3;
                            i12++;
                            iMax2 = i14;
                            i11 = i13;
                            i10 = i3;
                        } else {
                            if (iMax2 == 1114112) {
                                break;
                            }
                            i3 = i10 + 1;
                            this.buffer[i10] = iMax2;
                            int i15 = i11 + 1;
                            iMax = this.list[i11];
                            int i16 = iArr[i12];
                            i2 ^= 3;
                            i12++;
                            iMax2 = i16;
                            i11 = i15;
                            i10 = i3;
                        }
                    } else if (iMax2 < iMax) {
                        i4 = i10 + 1;
                        this.buffer[i10] = iMax2;
                        iMax2 = iArr[i12];
                        i2 ^= 2;
                        i12++;
                        i10 = i4;
                    } else if (iMax < iMax2) {
                        iMax = this.list[i11];
                        i2 ^= 1;
                        i11++;
                    } else {
                        if (iMax == 1114112) {
                            break;
                        }
                        i5 = i11 + 1;
                        iMax = this.list[i11];
                        i6 = i12 + 1;
                        i7 = iArr[i12];
                        i2 ^= 3;
                        int i17 = i6;
                        i11 = i5;
                        iMax2 = i7;
                        i12 = i17;
                    }
                } else if (iMax < iMax2) {
                    i4 = i10 + 1;
                    this.buffer[i10] = iMax;
                    iMax = this.list[i11];
                    i2 ^= 1;
                    i11++;
                    i10 = i4;
                } else if (iMax2 < iMax) {
                    i8 = i12 + 1;
                    i9 = iArr[i12];
                    i2 ^= 2;
                    int i18 = i9;
                    i12 = i8;
                    iMax2 = i18;
                } else {
                    if (iMax == 1114112) {
                        break;
                    }
                    i5 = i11 + 1;
                    iMax = this.list[i11];
                    i6 = i12 + 1;
                    i7 = iArr[i12];
                    i2 ^= 3;
                    int i19 = i6;
                    i11 = i5;
                    iMax2 = i7;
                    i12 = i19;
                }
            } else if (iMax < iMax2) {
                if (i10 > 0) {
                    int[] iArr2 = this.buffer;
                    if (iMax <= iArr2[i10 - 1]) {
                        i10--;
                        iMax = max(this.list[i11], iArr2[i10]);
                    } else {
                        this.buffer[i10] = iMax;
                        iMax = this.list[i11];
                        i10++;
                    }
                } else {
                    this.buffer[i10] = iMax;
                    iMax = this.list[i11];
                    i10++;
                }
                i11++;
                i2 ^= 1;
            } else if (iMax2 < iMax) {
                if (i10 > 0) {
                    int[] iArr3 = this.buffer;
                    if (iMax2 <= iArr3[i10 - 1]) {
                        i10--;
                        iMax2 = max(iArr[i12], iArr3[i10]);
                    } else {
                        this.buffer[i10] = iMax2;
                        iMax2 = iArr[i12];
                        i10++;
                    }
                } else {
                    this.buffer[i10] = iMax2;
                    iMax2 = iArr[i12];
                    i10++;
                }
                i12++;
                i2 ^= 2;
            } else {
                if (iMax == 1114112) {
                    break;
                }
                if (i10 > 0) {
                    int[] iArr4 = this.buffer;
                    if (iMax <= iArr4[i10 - 1]) {
                        i10--;
                        iMax = max(this.list[i11], iArr4[i10]);
                    } else {
                        this.buffer[i10] = iMax;
                        iMax = this.list[i11];
                        i10++;
                    }
                } else {
                    this.buffer[i10] = iMax;
                    iMax = this.list[i11];
                    i10++;
                }
                i11++;
                i8 = i12 + 1;
                i9 = iArr[i12];
                i2 ^= 3;
                int i110 = i9;
                i12 = i8;
                iMax2 = i110;
            }
        }
        int[] iArr5 = this.buffer;
        iArr5[i10] = 1114112;
        this.len = i10 + 1;
        int[] iArr6 = this.list;
        this.list = iArr5;
        this.buffer = iArr6;
        this.pat = null;
        return this;
    }

    public static <T> T[] addAllTo(Iterable<T> iterable, T[] tArr) {
        Iterator<T> it = iterable.iterator();
        int i = 0;
        while (it.hasNext()) {
            tArr[i] = it.next();
            i++;
        }
        return tArr;
    }

    private static final void addCaseMapping(UnicodeSet unicodeSet, int i, StringBuilder sb) {
        if (i >= 0) {
            if (i > 31) {
                unicodeSet.add(i);
            } else {
                unicodeSet.add(sb.toString());
                sb.setLength(0);
            }
        }
    }

    private void addString(CharSequence charSequence) {
        if (this.strings == EMPTY_STRINGS) {
            this.strings = new TreeSet();
        }
        this.strings.add(charSequence.toString());
    }

    private final UnicodeSet add_unchecked(int i) {
        int i2;
        int i3;
        if (i < 0 || i > 1114111) {
            og.i(cq.j("Invalid code point U+", Utility.hex(i, 6)));
            return null;
        }
        int iFindCodePoint = findCodePoint(i);
        if ((iFindCodePoint & 1) != 0) {
            return this;
        }
        int[] iArr = this.list;
        if (i == iArr[iFindCodePoint] - 1) {
            iArr[iFindCodePoint] = i;
            if (i == 1114111) {
                ensureCapacity(this.len + 1);
                int[] iArr2 = this.list;
                int i4 = this.len;
                this.len = i4 + 1;
                iArr2[i4] = 1114112;
            }
            if (iFindCodePoint > 0) {
                int[] iArr3 = this.list;
                int i5 = iFindCodePoint - 1;
                if (i == iArr3[i5]) {
                    System.arraycopy(iArr3, iFindCodePoint + 1, iArr3, i5, (this.len - iFindCodePoint) - 1);
                    this.len -= 2;
                }
            }
        } else if (iFindCodePoint <= 0 || i != (i3 = iArr[(i2 = iFindCodePoint - 1)])) {
            int i6 = this.len;
            if (i6 + 2 > iArr.length) {
                int[] iArr4 = new int[nextCapacity(i6 + 2)];
                if (iFindCodePoint != 0) {
                    System.arraycopy(this.list, 0, iArr4, 0, iFindCodePoint);
                }
                System.arraycopy(this.list, iFindCodePoint, iArr4, iFindCodePoint + 2, this.len - iFindCodePoint);
                this.list = iArr4;
            } else {
                System.arraycopy(iArr, iFindCodePoint, iArr, iFindCodePoint + 2, i6 - iFindCodePoint);
            }
            int[] iArr5 = this.list;
            iArr5[iFindCodePoint] = i;
            iArr5[iFindCodePoint + 1] = i + 1;
            this.len += 2;
        } else {
            iArr[i2] = i3 + 1;
        }
        this.pat = null;
        return this;
    }

    private static void appendCodePoint(Appendable appendable, int i) {
        try {
            if (i <= 65535) {
                appendable.append((char) i);
            } else {
                appendable.append(UTF16.getLeadSurrogate(i)).append(UTF16.getTrailSurrogate(i));
            }
        } catch (IOException e) {
            kf2.h(e);
        }
    }

    private <T extends Appendable> T appendNewPattern(T t, boolean z, boolean z2) {
        try {
            t.append('[');
            int i = this.len;
            int i2 = i & (-2);
            int i3 = 0;
            if (i >= 4 && this.list[0] == 0 && i2 == i && !hasStrings()) {
                t.append('^');
                i2--;
                i3 = 1;
            }
            while (i3 < i2) {
                int[] iArr = this.list;
                int i4 = iArr[i3];
                int i5 = iArr[i3 + 1] - 1;
                if (55296 > i5 || i5 > 56319) {
                    _appendToPat(t, i4, i5, z);
                    i3 += 2;
                } else {
                    int i6 = i3;
                    do {
                        i6 += 2;
                        if (i6 >= i2) {
                            break;
                        }
                    } while (this.list[i6] <= 56319);
                    int i7 = i6;
                    while (i7 < i2) {
                        int[] iArr2 = this.list;
                        int i8 = iArr2[i7];
                        if (i8 > 57343) {
                            break;
                        }
                        _appendToPat(t, i8, iArr2[i7 + 1] - 1, z);
                        i7 += 2;
                    }
                    while (i3 < i6) {
                        int[] iArr3 = this.list;
                        _appendToPat(t, iArr3[i3], iArr3[i3 + 1] - 1, z);
                        i3 += 2;
                    }
                    i3 = i7;
                }
            }
            if (z2 && hasStrings()) {
                for (String str : this.strings) {
                    t.append('{');
                    _appendToPat(t, str, z);
                    t.append('}');
                }
            }
            t.append(']');
            return t;
        } catch (IOException e) {
            kf2.h(e);
            return null;
        }
    }

    private void applyFilter(Filter filter, UnicodeSet unicodeSet) {
        clear();
        int rangeCount = unicodeSet.getRangeCount();
        int i = -1;
        for (int i2 = 0; i2 < rangeCount; i2++) {
            int rangeEnd = unicodeSet.getRangeEnd(i2);
            for (int rangeStart = unicodeSet.getRangeStart(i2); rangeStart <= rangeEnd; rangeStart++) {
                if (filter.contains(rangeStart)) {
                    if (i < 0) {
                        i = rangeStart;
                    }
                } else if (i >= 0) {
                    add_unchecked(i, rangeStart - 1);
                    i = -1;
                }
            }
        }
        if (i >= 0) {
            add_unchecked(i, 1114111);
        }
    }

    private void checkFrozen() {
        if (isFrozen()) {
            dk0.r("Attempt to modify frozen object");
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void closeOverAddCaseMappings() {
        UCaseProps uCaseProps = UCaseProps.INSTANCE;
        UnicodeSet unicodeSet = new UnicodeSet(this);
        UnicodeSet unicodeSetMaybeOnlyCaseSensitive = maybeOnlyCaseSensitive(this);
        int rangeCount = unicodeSetMaybeOnlyCaseSensitive.getRangeCount();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rangeCount; i++) {
            int rangeEnd = unicodeSetMaybeOnlyCaseSensitive.getRangeEnd(i);
            for (int rangeStart = unicodeSetMaybeOnlyCaseSensitive.getRangeStart(i); rangeStart <= rangeEnd; rangeStart++) {
                addCaseMapping(unicodeSet, uCaseProps.toFullLower(rangeStart, null, sb, 1), sb);
                addCaseMapping(unicodeSet, uCaseProps.toFullTitle(rangeStart, null, sb, 1), sb);
                addCaseMapping(unicodeSet, uCaseProps.toFullUpper(rangeStart, null, sb, 1), sb);
                addCaseMapping(unicodeSet, uCaseProps.toFullFolding(rangeStart, sb, 0), sb);
            }
        }
        if (hasStrings()) {
            ULocale uLocale = ULocale.ROOT;
            BreakIterator wordInstance = BreakIterator.getWordInstance(uLocale);
            for (String str : this.strings) {
                unicodeSet.add(UCharacter.toLowerCase(uLocale, str));
                unicodeSet.add(UCharacter.toTitleCase(uLocale, str, wordInstance));
                unicodeSet.add(UCharacter.toUpperCase(uLocale, str));
                unicodeSet.add(UCharacter.foldCase(str, 0));
            }
        }
        set(unicodeSet);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private void closeOverCaseInsensitive(boolean z) {
        UCaseProps uCaseProps = UCaseProps.INSTANCE;
        UnicodeSet unicodeSet = new UnicodeSet(this);
        if (!z && unicodeSet.hasStrings()) {
            unicodeSet.strings.clear();
        }
        UnicodeSet unicodeSetMaybeOnlyCaseSensitive = maybeOnlyCaseSensitive(this);
        int rangeCount = unicodeSetMaybeOnlyCaseSensitive.getRangeCount();
        for (int i = 0; i < rangeCount; i++) {
            int rangeStart = unicodeSetMaybeOnlyCaseSensitive.getRangeStart(i);
            int rangeEnd = unicodeSetMaybeOnlyCaseSensitive.getRangeEnd(i);
            if (z) {
                while (rangeStart <= rangeEnd) {
                    uCaseProps.addSimpleCaseClosure(rangeStart, unicodeSet);
                    rangeStart++;
                }
            } else {
                while (rangeStart <= rangeEnd) {
                    uCaseProps.addCaseClosure(rangeStart, unicodeSet);
                    rangeStart++;
                }
            }
        }
        if (hasStrings()) {
            StringBuilder sb = z ? new StringBuilder() : null;
            for (String str : this.strings) {
                if (!z) {
                    String strFoldCase = UCharacter.foldCase(str, 0);
                    if (!uCaseProps.addStringCaseClosure(strFoldCase, unicodeSet)) {
                        unicodeSet.add(strFoldCase);
                    }
                } else if (scfString(str, sb)) {
                    unicodeSet.remove(str).add(sb);
                }
            }
        }
        set(unicodeSet);
    }

    @Deprecated
    public static <T extends Comparable<T>> int compare(Iterator<T> it, Iterator<T> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext()) {
                return 1;
            }
            int iCompareTo = it.next().compareTo(it2.next());
            if (iCompareTo != 0) {
                return iCompareTo;
            }
        }
        return it2.hasNext() ? -1 : 0;
    }

    private void ensureBufferCapacity(int i) {
        if (i > 1114113) {
            i = 1114113;
        }
        int[] iArr = this.buffer;
        if (iArr == null || i > iArr.length) {
            this.buffer = new int[nextCapacity(i)];
        }
    }

    private void ensureCapacity(int i) {
        if (i > 1114113) {
            i = 1114113;
        }
        if (i <= this.list.length) {
            return;
        }
        int[] iArr = new int[nextCapacity(i)];
        System.arraycopy(this.list, 0, iArr, 0, this.len);
        this.list = iArr;
    }

    public static /* bridge */ /* synthetic */ Appendable f(int i, StringBuilder sb) {
        return _appendToPat(sb, i, false);
    }

    private final int findCodePoint(int i) {
        int[] iArr = this.list;
        int i2 = 0;
        if (i < iArr[0]) {
            return 0;
        }
        int i3 = this.len;
        if (i3 >= 2 && i >= iArr[i3 - 2]) {
            return i3 - 1;
        }
        int i4 = i3 - 1;
        while (true) {
            int i5 = (i2 + i4) >>> 1;
            if (i5 == i2) {
                return i4;
            }
            if (i < this.list[i5]) {
                i4 = i5;
            } else {
                i2 = i5;
            }
        }
    }

    public static UnicodeSet from(CharSequence charSequence) {
        return new UnicodeSet().add(charSequence);
    }

    public static UnicodeSet fromAll(CharSequence charSequence) {
        return new UnicodeSet().addAll(charSequence);
    }

    @Deprecated
    public static XSymbolTable getDefaultXSymbolTable() {
        return XSYMBOL_TABLE;
    }

    private static int getSingleCP(CharSequence charSequence) {
        int iCodePointAt;
        if (charSequence.length() == 1) {
            return charSequence.charAt(0);
        }
        if (charSequence.length() != 2 || (iCodePointAt = Character.codePointAt(charSequence, 0)) <= 65535) {
            return -1;
        }
        return iCodePointAt;
    }

    @Deprecated
    public static int getSingleCodePoint(CharSequence charSequence) {
        return CharSequences.getSingleCodePoint(charSequence);
    }

    private static int matchRest(Replaceable replaceable, int i, int i2, String str) {
        int length = str.length();
        int i3 = 1;
        if (i < i2) {
            int i4 = i2 - i;
            if (i4 <= length) {
                length = i4;
            }
            while (i3 < length) {
                if (replaceable.charAt(i + i3) != str.charAt(i3)) {
                    return 0;
                }
                i3++;
            }
            return length;
        }
        int i5 = i - i2;
        if (i5 > length) {
            i5 = length;
        }
        int i6 = length - 1;
        while (i3 < i5) {
            if (replaceable.charAt(i - i3) != str.charAt(i6 - i3)) {
                return 0;
            }
            i3++;
        }
        return i5;
    }

    private static final int max(int i, int i2) {
        return i > i2 ? i : i2;
    }

    private int nextCapacity(int i) {
        if (i < 25) {
            return i + 25;
        }
        if (i <= 2500) {
            return i * 5;
        }
        int i2 = i * 2;
        if (i2 > 1114113) {
            return 1114113;
        }
        return i2;
    }

    public static UnicodeSet parseContent(UnicodeSetLexer unicodeSetLexer, StringBuilder sb, int i, int i2, GrammaticalConstructProperties grammaticalConstructProperties) {
        UnicodeSet unicodeSet = new UnicodeSet();
        if (unicodeSetLexer.acceptSetOperator('-')) {
            unicodeSet.add(45);
            sb.append("\\-");
        }
        while (!unicodeSetLexer.atEnd()) {
            if (unicodeSetLexer.acceptSetOperator('-')) {
                sb.append('-');
                unicodeSet.add(45);
                return unicodeSet;
            }
            if (unicodeSetLexer.lookahead().isSetOperator(SymbolTable.SYMBOL_REF) && unicodeSetLexer.lookahead2().isSetOperator(']')) {
                sb.append(SymbolTable.SYMBOL_REF);
                unicodeSetLexer.advance();
                unicodeSet.add(DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH);
                grammaticalConstructProperties.containsSetOperation = true;
                return unicodeSet;
            }
            if (unicodeSetLexer.lookahead().isSetOperator(']')) {
                break;
            }
            unicodeSet.parseMutation(unicodeSetLexer, sb, i, i2, grammaticalConstructProperties);
        }
        return unicodeSet;
    }

    public static UnicodeSet parseElements(UnicodeSetLexer unicodeSetLexer, StringBuilder sb) {
        int iIntValue;
        if (unicodeSetLexer.lookahead().isStringLiteral()) {
            String strElement = unicodeSetLexer.lookahead().element();
            sb.append('{');
            _appendToPat(sb, strElement, false);
            sb.append('}');
            unicodeSetLexer.advance();
            return from(strElement);
        }
        int iIntValue2 = 36;
        if (unicodeSetLexer.lookahead().isSetOperator(SymbolTable.SYMBOL_REF)) {
            iIntValue = 36;
        } else {
            if (unicodeSetLexer.lookahead().codePoint() == null) {
                throw unicodeSetLexer.syntaxError("RangeElement | string-literal", unicodeSetLexer.lookahead().debugString());
            }
            iIntValue = unicodeSetLexer.lookahead().codePoint().intValue();
        }
        unicodeSetLexer.advance();
        _appendToPat(sb, iIntValue, false);
        if (!unicodeSetLexer.lookahead().isSetOperator('-')) {
            return new UnicodeSet(iIntValue, iIntValue);
        }
        if (unicodeSetLexer.lookahead2().isSetOperator(']')) {
            return new UnicodeSet(iIntValue, iIntValue);
        }
        unicodeSetLexer.advance();
        sb.append('-');
        if (unicodeSetLexer.lookahead().isSetOperator(SymbolTable.SYMBOL_REF)) {
            if (unicodeSetLexer.lookahead2().isSetOperator(']')) {
                throw unicodeSetLexer.syntaxError("Elements or UnicodeSet after Range ending in unescaped $", cq.k(unicodeSetLexer.lookahead().debugString(), " followed by ", unicodeSetLexer.lookahead2().debugString()));
            }
        } else {
            if (unicodeSetLexer.lookahead().codePoint() == null) {
                throw unicodeSetLexer.syntaxError("RangeElement", unicodeSetLexer.lookahead().debugString());
            }
            iIntValue2 = unicodeSetLexer.lookahead().codePoint().intValue();
        }
        if (iIntValue2 <= iIntValue) {
            throw unicodeSetLexer.syntaxError("first < last in Range", cq.k(new String(Character.toChars(iIntValue2)), LanguageTag.SEP, new String(Character.toChars(iIntValue))));
        }
        unicodeSetLexer.advance();
        _appendToPat(sb, iIntValue2, false);
        return new UnicodeSet(iIntValue, iIntValue2);
    }

    public static UnicodeSet parseUnicodeSet(UnicodeSetLexer unicodeSetLexer, StringBuilder sb, int i, int i2) {
        UnicodeSet content;
        boolean z;
        if (i2 > 100) {
            throw unicodeSetLexer.syntaxError("depth <= 100", ky0.h(i2, "depth = "));
        }
        StringBuilder sb2 = new StringBuilder();
        boolean z2 = true;
        int i3 = 0;
        if (unicodeSetLexer.lookahead().set() != null) {
            content = unicodeSetLexer.lookahead().set();
            content._toPattern(sb2, false);
            unicodeSetLexer.advance();
            z = true;
            z2 = false;
        } else {
            if (!unicodeSetLexer.acceptSetOperator('[')) {
                throw unicodeSetLexer.syntaxError("property-query | [", unicodeSetLexer.lookahead().debugString());
            }
            sb2.append('[');
            if (unicodeSetLexer.acceptSetOperator('^')) {
                sb2.append('^');
            } else {
                z2 = false;
            }
            GrammaticalConstructProperties grammaticalConstructProperties = new GrammaticalConstructProperties(i3);
            content = parseContent(unicodeSetLexer, sb2, i, i2, grammaticalConstructProperties);
            z = grammaticalConstructProperties.containsSetOperation;
            if (!unicodeSetLexer.acceptSetOperator(']')) {
                throw unicodeSetLexer.syntaxError("]", unicodeSetLexer.lookahead().debugString());
            }
            sb2.append(']');
        }
        if ((i & 6) != 0) {
            content.closeOver(i);
        }
        if (z2) {
            content.complement().removeAllStrings();
        }
        if (z) {
            sb.append((CharSequence) sb2);
            return content;
        }
        StringBuffer stringBuffer = new StringBuffer();
        content._generatePattern(stringBuffer, false);
        sb.append(stringBuffer);
        return content;
    }

    private int[] range(int i, int i2) {
        int[] iArr = this.rangeList;
        if (iArr == null) {
            this.rangeList = new int[]{i, i2 + 1, 1114112};
        } else {
            iArr[0] = i;
            iArr[1] = i2 + 1;
        }
        return this.rangeList;
    }

    public static boolean resemblesPattern(String str, int i) {
        return (i + 1 < str.length() && str.charAt(i) == '[') || resemblesPropertyPattern(str, i);
    }

    private static boolean resemblesPropertyPattern(String str, int i) {
        if (i + 5 > str.length()) {
            return false;
        }
        return str.regionMatches(i, "[:", 0, 2) || str.regionMatches(true, i, "\\p", 0, 2) || str.regionMatches(i, "\\N", 0, 2);
    }

    private UnicodeSet retain(int[] iArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        ensureBufferCapacity(this.len + i);
        int i16 = 0;
        int i17 = this.list[0];
        int i18 = iArr[0];
        int i19 = 1;
        int i20 = 1;
        while (true) {
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 != 2) {
                        if (i2 != 3) {
                            continue;
                        } else if (i17 < i18) {
                            i10 = i16 + 1;
                            this.buffer[i16] = i17;
                            i11 = i19 + 1;
                            i17 = this.list[i19];
                            i2 ^= 1;
                            i19 = i11;
                        } else if (i18 < i17) {
                            i10 = i16 + 1;
                            this.buffer[i16] = i18;
                            i12 = i20 + 1;
                            i18 = iArr[i20];
                            i2 ^= 2;
                            i20 = i12;
                        } else {
                            if (i17 == 1114112) {
                                break;
                            }
                            i3 = i16 + 1;
                            this.buffer[i16] = i17;
                            i4 = i19 + 1;
                            i17 = this.list[i19];
                            i5 = i20 + 1;
                            i6 = iArr[i20];
                            i2 ^= 3;
                            i20 = i5;
                            i18 = i6;
                            i19 = i4;
                            i16 = i3;
                        }
                    } else if (i18 < i17) {
                        i7 = i20 + 1;
                        i8 = iArr[i20];
                        i2 ^= 2;
                        int i21 = i8;
                        i20 = i7;
                        i18 = i21;
                    } else if (i17 < i18) {
                        i10 = i16 + 1;
                        this.buffer[i16] = i17;
                        i11 = i19 + 1;
                        i17 = this.list[i19];
                        i2 ^= 1;
                        i19 = i11;
                    } else {
                        if (i17 == 1114112) {
                            break;
                        }
                        i13 = i19 + 1;
                        i17 = this.list[i19];
                        i14 = i20 + 1;
                        i15 = iArr[i20];
                        i2 ^= 3;
                        int i22 = i14;
                        i19 = i13;
                        i18 = i15;
                        i20 = i22;
                    }
                    i16 = i10;
                } else if (i17 < i18) {
                    i9 = i19 + 1;
                    i17 = this.list[i19];
                    i2 ^= 1;
                    i19 = i9;
                } else if (i18 < i17) {
                    i10 = i16 + 1;
                    this.buffer[i16] = i18;
                    i12 = i20 + 1;
                    i18 = iArr[i20];
                    i2 ^= 2;
                    i20 = i12;
                    i16 = i10;
                } else {
                    if (i17 == 1114112) {
                        break;
                    }
                    i13 = i19 + 1;
                    i17 = this.list[i19];
                    i14 = i20 + 1;
                    i15 = iArr[i20];
                    i2 ^= 3;
                    int i23 = i14;
                    i19 = i13;
                    i18 = i15;
                    i20 = i23;
                }
            } else if (i17 < i18) {
                i9 = i19 + 1;
                i17 = this.list[i19];
                i2 ^= 1;
                i19 = i9;
            } else if (i18 < i17) {
                i7 = i20 + 1;
                i8 = iArr[i20];
                i2 ^= 2;
                int i24 = i8;
                i20 = i7;
                i18 = i24;
            } else {
                if (i17 == 1114112) {
                    break;
                }
                i3 = i16 + 1;
                this.buffer[i16] = i17;
                i4 = i19 + 1;
                i17 = this.list[i19];
                i5 = i20 + 1;
                i6 = iArr[i20];
                i2 ^= 3;
                i20 = i5;
                i18 = i6;
                i19 = i4;
                i16 = i3;
            }
        }
        int[] iArr2 = this.buffer;
        iArr2[i16] = 1114112;
        this.len = i16 + 1;
        int[] iArr3 = this.list;
        this.list = iArr2;
        this.buffer = iArr3;
        this.pat = null;
        return this;
    }

    private static final boolean scfString(CharSequence charSequence, StringBuilder sb) {
        int length = charSequence.length();
        int iCharCount = 0;
        while (iCharCount < length) {
            int iCodePointAt = Character.codePointAt(charSequence, iCharCount);
            int iFoldCase = UCharacter.foldCase(iCodePointAt, 0);
            if (iFoldCase != iCodePointAt) {
                sb.setLength(0);
                sb.append(charSequence, 0, iCharCount);
                while (true) {
                    sb.appendCodePoint(iFoldCase);
                    iCharCount += Character.charCount(iCodePointAt);
                    if (iCharCount == length) {
                        return true;
                    }
                    iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                    iFoldCase = UCharacter.foldCase(iCodePointAt, 0);
                }
            } else {
                iCharCount += Character.charCount(iCodePointAt);
            }
        }
        return false;
    }

    @Deprecated
    public static void setDefaultXSymbolTable(XSymbolTable xSymbolTable) {
        CharacterPropertiesImpl.clear();
        XSYMBOL_TABLE = xSymbolTable;
    }

    private int spanCodePointsAndCount(CharSequence charSequence, int i, SpanCondition spanCondition, OutputInt outputInt) {
        int i2 = 0;
        boolean z = spanCondition != SpanCondition.NOT_CONTAINED;
        int length = charSequence.length();
        do {
            int iCodePointAt = Character.codePointAt(charSequence, i);
            if (z != contains(iCodePointAt)) {
                break;
            }
            i2++;
            i += Character.charCount(iCodePointAt);
        } while (i < length);
        if (outputInt != null) {
            outputInt.value = i2;
        }
        return i;
    }

    private static void syntaxError(RuleCharacterIterator ruleCharacterIterator, String str) {
        throw new IllegalArgumentException(ky0.l("Error: ", str, " at \"", Utility.escape(ruleCharacterIterator.toString()), "\""));
    }

    public static String[] toArray(UnicodeSet unicodeSet) {
        return (String[]) addAllTo(unicodeSet, new String[unicodeSet.size()]);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0034 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:20:0x0047  */
    /* JADX WARN: Code duplicated, block: B:23:0x0043 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:24:0x0036 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x0056 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0025 A[SYNTHETIC] */
    private UnicodeSet xor(int[] iArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        ensureBufferCapacity(this.len + i);
        int i6 = 0;
        int i7 = this.list[0];
        int i8 = 1;
        if (i2 == 1 || i2 == 2) {
            if (iArr[0] == 0) {
                i4 = iArr[1];
            } else {
                i3 = 0;
                i8 = 0;
            }
            while (true) {
                if (i7 < i6) {
                    i5 = i3 + 1;
                    this.buffer[i3] = i7;
                    i7 = this.list[i8];
                    i8++;
                } else if (i6 < i7) {
                    i5 = i3 + 1;
                    this.buffer[i3] = i6;
                    int i9 = iArr[i8];
                    i8++;
                    i6 = i9;
                } else {
                    if (i7 != 1114112) {
                        int[] iArr2 = this.buffer;
                        iArr2[i3] = 1114112;
                        this.len = i3 + 1;
                        int[] iArr3 = this.list;
                        this.list = iArr2;
                        this.buffer = iArr3;
                        this.pat = null;
                        return this;
                    }
                    i7 = this.list[i8];
                    i8++;
                    i6 = iArr[i8];
                    i8++;
                }
                i3 = i5;
            }
        } else {
            i4 = iArr[0];
        }
        i6 = i4;
        i3 = 0;
        while (true) {
            if (i7 < i6) {
                i5 = i3 + 1;
                this.buffer[i3] = i7;
                i7 = this.list[i8];
                i8++;
            } else if (i6 < i7) {
                i5 = i3 + 1;
                this.buffer[i3] = i6;
                int i10 = iArr[i8];
                i8++;
                i6 = i10;
            } else {
                if (i7 != 1114112) {
                    int[] iArr4 = this.buffer;
                    iArr4[i3] = 1114112;
                    this.len = i3 + 1;
                    int[] iArr5 = this.list;
                    this.list = iArr4;
                    this.buffer = iArr5;
                    this.pat = null;
                    return this;
                }
                i7 = this.list[i8];
                i8++;
                i6 = iArr[i8];
                i8++;
            }
            i3 = i5;
        }
    }

    public StringBuffer _generatePattern(StringBuffer stringBuffer, boolean z, boolean z2) {
        return (StringBuffer) appendNewPattern(stringBuffer, z, z2);
    }

    public UnicodeSet addAll(UnicodeSet unicodeSet) {
        checkFrozen();
        add(unicodeSet.list, unicodeSet.len, 0);
        if (unicodeSet.hasStrings()) {
            SortedSet<String> sortedSet = this.strings;
            if (sortedSet == EMPTY_STRINGS) {
                this.strings = new TreeSet((SortedSet) unicodeSet.strings);
                return this;
            }
            sortedSet.addAll(unicodeSet.strings);
        }
        return this;
    }

    @Deprecated
    public UnicodeSet addBridges(UnicodeSet unicodeSet) {
        int i;
        UnicodeSetIterator unicodeSetIterator = new UnicodeSetIterator(new UnicodeSet(this).complement().removeAllStrings());
        while (unicodeSetIterator.nextRange()) {
            int i2 = unicodeSetIterator.codepoint;
            if (i2 != 0 && (i = unicodeSetIterator.codepointEnd) != 1114111 && unicodeSet.contains(i2, i)) {
                add(unicodeSetIterator.codepoint, unicodeSetIterator.codepointEnd);
            }
        }
        return this;
    }

    @Override // com.ibm.icu.text.UnicodeMatcher
    public void addMatchSetTo(UnicodeSet unicodeSet) {
        unicodeSet.addAll(this);
    }

    public UnicodeSet applyIntPropertyValue(int i, int i2) {
        if (i == 8192) {
            applyFilter(new GeneralCategoryMaskFilter(i2), CharacterPropertiesImpl.getInclusionsForProperty(i));
            return this;
        }
        if (i == 28672) {
            applyFilter(new ScriptExtensionsFilter(i2), CharacterPropertiesImpl.getInclusionsForProperty(i));
            return this;
        }
        if (i == 28673) {
            applyFilter(new IdentifierTypeFilter(i2), CharacterPropertiesImpl.getInclusionsForProperty(i));
            return this;
        }
        if (i < 0 || i >= 76) {
            if (4096 > i || i >= 4123) {
                og.i(ky0.h(i, "unsupported property "));
                return null;
            }
            applyFilter(new IntPropertyFilter(i, i2), CharacterPropertiesImpl.getInclusionsForProperty(i));
            return this;
        }
        if (i2 != 0 && i2 != 1) {
            clear();
            return this;
        }
        set(CharacterProperties.getBinaryPropertySet(i));
        if (i2 == 0) {
            complement().removeAllStrings();
        }
        return this;
    }

    @Deprecated
    public UnicodeSet applyPattern(String str, ParsePosition parsePosition, SymbolTable symbolTable, int i) {
        boolean z = parsePosition == null;
        if (z) {
            parsePosition = new ParsePosition(0);
        }
        ParsePosition parsePosition2 = parsePosition;
        StringBuilder sb = new StringBuilder();
        RuleCharacterIterator ruleCharacterIterator = new RuleCharacterIterator(str, symbolTable, parsePosition2);
        applyPattern(str, parsePosition2, ruleCharacterIterator, symbolTable, sb, i, 0);
        if (ruleCharacterIterator.inVariable()) {
            syntaxError(ruleCharacterIterator, "Extra chars in variable value");
        }
        this.pat = sb.toString();
        if (z) {
            int index = parsePosition2.getIndex();
            if ((i & 1) != 0) {
                index = PatternProps.skipWhiteSpace(str, index);
            }
            if (index != str.length()) {
                throw new IllegalArgumentException("Parse of \"" + str + "\" failed at " + index);
            }
        }
        return this;
    }

    public UnicodeSet applyPropertyAlias(String str, String str2, SymbolTable symbolTable) {
        int propertyValueEnum;
        checkFrozen();
        if ((symbolTable == null || !(symbolTable instanceof XSymbolTable) || !((XSymbolTable) symbolTable).applyPropertyAlias(str, str2, this)) && (XSYMBOL_TABLE == null || !XSYMBOL_TABLE.applyPropertyAlias(str, str2, this))) {
            int propertyEnum = UProperty.SCRIPT;
            boolean z = false;
            if (str2 != null) {
                int propertyEnum2 = UCharacter.getPropertyEnum(str);
                if (propertyEnum2 == 4101) {
                    propertyEnum2 = 8192;
                }
                if ((propertyEnum2 >= 0 && propertyEnum2 < 76) || ((propertyEnum2 >= 4096 && propertyEnum2 < 4123) || (propertyEnum2 >= 8192 && propertyEnum2 < 8193))) {
                    try {
                        propertyValueEnum = UCharacter.getPropertyValueEnum(propertyEnum2, str2);
                    } catch (IllegalArgumentException e) {
                        if ((propertyEnum2 != 4098 && propertyEnum2 != 4112 && propertyEnum2 != 4113) || (propertyValueEnum = Integer.parseInt(PatternProps.trimWhiteSpace(str2))) < 0 || propertyValueEnum > 255) {
                            throw e;
                        }
                    }
                } else {
                    if (propertyEnum2 == 12288) {
                        applyFilter(new NumericValueFilter(Double.parseDouble(PatternProps.trimWhiteSpace(str2))), CharacterPropertiesImpl.getInclusionsForProperty(propertyEnum2));
                        return this;
                    }
                    if (propertyEnum2 == 16384) {
                        applyFilter(new VersionFilter(VersionInfo.getInstance(str2)), CharacterPropertiesImpl.getInclusionsForProperty(propertyEnum2));
                        return this;
                    }
                    if (propertyEnum2 == 16389) {
                        int charFromExtendedName = UCharacter.getCharFromExtendedName(str2);
                        if (charFromExtendedName == -1) {
                            og.i("Invalid character name");
                            return null;
                        }
                        clear();
                        add_unchecked(charFromExtendedName);
                        return this;
                    }
                    if (propertyEnum2 == 16395) {
                        og.i("Unicode_1_Name (na1) not supported");
                        return null;
                    }
                    if (propertyEnum2 == 28672) {
                        propertyValueEnum = UCharacter.getPropertyValueEnum(UProperty.SCRIPT, str2);
                    } else {
                        if (propertyEnum2 != 28673) {
                            og.i("Unsupported property");
                            return null;
                        }
                        propertyValueEnum = UCharacter.getPropertyValueEnum(propertyEnum2, str2);
                    }
                }
                propertyEnum = propertyEnum2;
            } else {
                UPropertyAliases uPropertyAliases = UPropertyAliases.INSTANCE;
                int propertyValueEnum2 = uPropertyAliases.getPropertyValueEnum(8192, str);
                if (propertyValueEnum2 == -1) {
                    propertyValueEnum2 = uPropertyAliases.getPropertyValueEnum(UProperty.SCRIPT, str);
                    if (propertyValueEnum2 == -1) {
                        propertyEnum = uPropertyAliases.getPropertyEnum(str);
                        if (propertyEnum == -1) {
                            propertyEnum = -1;
                        }
                        if (propertyEnum >= 0 && propertyEnum < 76) {
                            propertyValueEnum = 1;
                        } else {
                            if (propertyEnum != -1) {
                                og.i("Missing property value");
                                return null;
                            }
                            if (UPropertyAliases.compare(ANY_ID, str) == 0) {
                                set(0, 1114111);
                                return this;
                            }
                            if (UPropertyAliases.compare(ASCII_ID, str) == 0) {
                                set(0, 127);
                                return this;
                            }
                            if (UPropertyAliases.compare(ASSIGNED, str) != 0) {
                                og.i(cq.l("Invalid property alias: ", str, "=", str2));
                                return null;
                            }
                            propertyEnum = 8192;
                            propertyValueEnum = 1;
                            z = true;
                        }
                    }
                } else {
                    propertyEnum = 8192;
                }
                propertyValueEnum = propertyValueEnum2;
            }
            applyIntPropertyValue(propertyEnum, propertyValueEnum);
            if (z) {
                complement().removeAllStrings();
            }
        }
        return this;
    }

    public int charAt(int i) {
        if (i < 0) {
            return -1;
        }
        int i2 = this.len & (-2);
        int i3 = 0;
        while (i3 < i2) {
            int[] iArr = this.list;
            int i4 = i3 + 1;
            int i5 = iArr[i3];
            i3 += 2;
            int i6 = iArr[i4] - i5;
            if (i < i6) {
                return i5 + i;
            }
            i -= i6;
        }
        return -1;
    }

    public UnicodeSet clear() {
        checkFrozen();
        this.list[0] = 1114112;
        this.len = 1;
        this.pat = null;
        if (hasStrings()) {
            this.strings.clear();
        }
        return this;
    }

    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public UnicodeSet m20clone() {
        return isFrozen() ? this : new UnicodeSet(this);
    }

    @Override // com.ibm.icu.util.Freezable
    public UnicodeSet cloneAsThawed() {
        return new UnicodeSet(this);
    }

    public UnicodeSet closeOver(int i) {
        checkFrozen();
        int i2 = i & 6;
        if (i2 == 2) {
            closeOverCaseInsensitive(false);
            return this;
        }
        if (i2 == 4) {
            closeOverAddCaseMappings();
            return this;
        }
        if (i2 != 6) {
            return this;
        }
        closeOverCaseInsensitive(true);
        return this;
    }

    public IntStream codePointStream() {
        return StreamSupport.intStream(new CodePointSpliterator(this), false);
    }

    public Iterable<Integer> codePoints() {
        return new CodePointIterable(this);
    }

    public UnicodeSet compact() {
        checkFrozen();
        int i = this.len;
        int i2 = i + 7;
        int[] iArr = this.list;
        if (i2 < iArr.length) {
            this.list = Arrays.copyOf(iArr, i);
        }
        this.rangeList = null;
        this.buffer = null;
        SortedSet<String> sortedSet = this.strings;
        SortedSet<String> sortedSet2 = EMPTY_STRINGS;
        if (sortedSet != sortedSet2 && sortedSet.isEmpty()) {
            this.strings = sortedSet2;
        }
        return this;
    }

    public int compareTo(UnicodeSet unicodeSet, ComparisonStyle comparisonStyle) {
        int iCompare;
        int size;
        if (comparisonStyle != ComparisonStyle.LEXICOGRAPHIC && (size = size() - unicodeSet.size()) != 0) {
            return (size < 0) == (comparisonStyle == ComparisonStyle.SHORTER_FIRST) ? -1 : 1;
        }
        int i = 0;
        while (true) {
            int i2 = this.list[i];
            int i3 = unicodeSet.list[i];
            int i4 = i2 - i3;
            if (i4 != 0) {
                if (i2 == 1114112) {
                    if (hasStrings()) {
                        return compare(this.strings.first(), unicodeSet.list[i]);
                    }
                    return 1;
                }
                if (i3 != 1114112) {
                    return (i & 1) == 0 ? i4 : -i4;
                }
                if (unicodeSet.hasStrings() && (iCompare = compare(unicodeSet.strings.first(), this.list[i])) <= 0) {
                    return iCompare < 0 ? 1 : 0;
                }
                return -1;
            }
            if (i2 == 1114112) {
                return compare(this.strings, unicodeSet.strings);
            }
            i++;
        }
    }

    public UnicodeSet complement(int i, int i2) {
        checkFrozen();
        if (i < 0 || i > 1114111) {
            og.i(cq.j("Invalid code point U+", Utility.hex(i, 6)));
            return null;
        }
        if (i2 < 0 || i2 > 1114111) {
            og.i(cq.j("Invalid code point U+", Utility.hex(i2, 6)));
            return null;
        }
        if (i <= i2) {
            xor(range(i, i2), 2, 0);
        }
        this.pat = null;
        return this;
    }

    public UnicodeSet complementAll(UnicodeSet unicodeSet) {
        checkFrozen();
        xor(unicodeSet.list, unicodeSet.len, 0);
        if (unicodeSet.hasStrings()) {
            SortedSet<String> sortedSet = this.strings;
            if (sortedSet == EMPTY_STRINGS) {
                this.strings = new TreeSet((SortedSet) unicodeSet.strings);
                return this;
            }
            SortedSetRelation.doOperation(sortedSet, 5, unicodeSet.strings);
        }
        return this;
    }

    public boolean contains(int i, int i2) {
        if (i < 0 || i > 1114111) {
            og.i(cq.j("Invalid code point U+", Utility.hex(i, 6)));
            return false;
        }
        if (i2 < 0 || i2 > 1114111) {
            og.i(cq.j("Invalid code point U+", Utility.hex(i2, 6)));
            return false;
        }
        int iFindCodePoint = findCodePoint(i);
        return (iFindCodePoint & 1) != 0 && i2 < this.list[iFindCodePoint];
    }

    /* JADX WARN: Code duplicated, block: B:11:0x002a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:16:0x0038  */
    /* JADX WARN: Code duplicated, block: B:23:0x0045 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x002c A[EDGE_INSN: B:25:0x002c->B:12:0x002c BREAK  A[LOOP:0: B:3:0x0012->B:29:0x0012], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0042 A[SYNTHETIC] */
    public boolean containsAll(UnicodeSet unicodeSet) {
        int[] iArr = unicodeSet.list;
        int i = this.len - 1;
        int i2 = unicodeSet.len - 1;
        boolean z = true;
        boolean z2 = true;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (!z) {
                if (z2) {
                    if (i4 >= i2) {
                        break;
                    }
                    int i9 = i4 + 1;
                    i6 = iArr[i4];
                    i4 += 2;
                    i8 = iArr[i9];
                }
                if (i6 < i7) {
                    z = true;
                    z2 = false;
                } else {
                    if (i6 >= i5 || i8 > i7) {
                        return false;
                    }
                    z2 = true;
                    z = false;
                }
            } else {
                if (i3 >= i) {
                    if (z2 && i4 >= i2) {
                        break;
                    }
                    return false;
                }
                int[] iArr2 = this.list;
                int i10 = i3 + 1;
                int i11 = iArr2[i3];
                i3 += 2;
                int i12 = iArr2[i10];
                i5 = i11;
                i7 = i12;
                if (z2) {
                    if (i4 >= i2) {
                        break;
                        break;
                    }
                    int i13 = i4 + 1;
                    i6 = iArr[i4];
                    i4 += 2;
                    i8 = iArr[i13];
                }
                if (i6 < i7) {
                    if (i6 >= i5) {
                    }
                    return false;
                }
                z = true;
                z2 = false;
            }
        }
        return this.strings.containsAll(unicodeSet.strings);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0034  */
    /* JADX WARN: Code duplicated, block: B:17:0x0043  */
    /* JADX WARN: Code duplicated, block: B:20:0x0027 A[EDGE_INSN: B:20:0x0027->B:9:0x0027 BREAK  A[LOOP:0: B:3:0x0012->B:24:0x0012], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:21:0x0041 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:22:0x0046 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x003e A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:8:0x0025 A[DONT_INVERT] */
    public boolean containsNone(UnicodeSet unicodeSet) {
        int[] iArr = unicodeSet.list;
        int i = this.len - 1;
        int i2 = unicodeSet.len - 1;
        boolean z = true;
        boolean z2 = true;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (!z) {
                if (z2) {
                    if (i4 >= i2) {
                        break;
                    }
                    int i9 = i4 + 1;
                    i6 = iArr[i4];
                    i4 += 2;
                    i8 = iArr[i9];
                }
                if (i6 >= i7) {
                    z = true;
                    z2 = false;
                } else {
                    if (i5 >= i8) {
                        return false;
                    }
                    z2 = true;
                    z = false;
                }
            } else {
                if (i3 >= i) {
                    break;
                }
                int[] iArr2 = this.list;
                int i10 = i3 + 1;
                int i11 = iArr2[i3];
                i3 += 2;
                int i12 = iArr2[i10];
                i5 = i11;
                i7 = i12;
                if (z2) {
                    if (i4 >= i2) {
                        break;
                        break;
                    }
                    int i13 = i4 + 1;
                    i6 = iArr[i4];
                    i4 += 2;
                    i8 = iArr[i13];
                }
                if (i6 >= i7) {
                    z = true;
                    z2 = false;
                } else {
                    if (i5 >= i8) {
                        return false;
                    }
                    z2 = true;
                    z = false;
                }
            }
        }
        return SortedSetRelation.hasRelation(this.strings, 5, unicodeSet.strings);
    }

    public final boolean containsSome(int i, int i2) {
        return !containsNone(i, i2);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        try {
            UnicodeSet unicodeSet = (UnicodeSet) obj;
            if (this.len != unicodeSet.len) {
                return false;
            }
            for (int i = 0; i < this.len; i++) {
                if (this.list[i] != unicodeSet.list[i]) {
                    return false;
                }
            }
            return this.strings.equals(unicodeSet.strings);
        } catch (Exception unused) {
            return false;
        }
    }

    @Deprecated
    public int findIn(CharSequence charSequence, int i, boolean z) {
        while (i < charSequence.length()) {
            int iCharAt = UTF16.charAt(charSequence, i);
            if (contains(iCharAt) != z) {
                break;
            }
            i += UTF16.getCharCount(iCharAt);
        }
        return i;
    }

    @Deprecated
    public int findLastIn(CharSequence charSequence, int i, boolean z) {
        int charCount = i - 1;
        while (charCount >= 0) {
            int iCharAt = UTF16.charAt(charSequence, charCount);
            if (contains(iCharAt) != z) {
                break;
            }
            charCount -= UTF16.getCharCount(iCharAt);
        }
        if (charCount < 0) {
            return -1;
        }
        return charCount;
    }

    @Override // com.ibm.icu.util.Freezable
    public UnicodeSet freeze() {
        if (!isFrozen()) {
            compact();
            if (hasStrings()) {
                this.stringSpan = new UnicodeSetStringSpan(this, new ArrayList(this.strings), 127);
            }
            if (this.stringSpan == null || !this.stringSpan.needsStringSpanUTF16()) {
                this.bmpSet = new BMPSet(this.list, this.len);
            }
        }
        return this;
    }

    public int getRangeCount() {
        return this.len / 2;
    }

    public int getRangeEnd(int i) {
        return this.list[(i * 2) + 1] - 1;
    }

    public int getRangeStart(int i) {
        return this.list[i * 2];
    }

    @Deprecated
    public String getRegexEquivalent() {
        if (!hasStrings()) {
            return toString();
        }
        StringBuilder sb = new StringBuilder("(?:");
        appendNewPattern(sb, true, false);
        for (String str : this.strings) {
            sb.append('|');
            _appendToPat(sb, str, true);
        }
        sb.append(")");
        return sb.toString();
    }

    public boolean hasStrings() {
        return !this.strings.isEmpty();
    }

    public int hashCode() {
        int i = this.len;
        for (int i2 = 0; i2 < this.len; i2++) {
            i = (i * 1000003) + this.list[i2];
        }
        return i;
    }

    public int indexOf(int i) {
        if (i < 0 || i > 1114111) {
            og.i(cq.j("Invalid code point U+", Utility.hex(i, 6)));
            return 0;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = this.list;
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i < i5) {
                return -1;
            }
            i2 += 2;
            int i6 = iArr[i4];
            if (i < i6) {
                return (i3 + i) - i5;
            }
            i3 += i6 - i5;
        }
    }

    public boolean isEmpty() {
        return this.len == 1 && !hasStrings();
    }

    @Override // com.ibm.icu.util.Freezable
    public boolean isFrozen() {
        return (this.bmpSet == null && this.stringSpan == null) ? false : true;
    }

    @Override // java.lang.Iterable
    public Iterator<String> iterator() {
        return new UnicodeSetIterator2(this);
    }

    @Override // com.ibm.icu.text.UnicodeFilter, com.ibm.icu.text.UnicodeMatcher
    public int matches(Replaceable replaceable, int[] iArr, int i, boolean z) {
        if (iArr[0] == i) {
            if (contains(DateTimePatternGenerator.MATCH_ALL_FIELDS_LENGTH)) {
                return z ? 1 : 2;
            }
            return 0;
        }
        if (hasStrings()) {
            int i2 = iArr[0];
            boolean z2 = i2 < i;
            char cCharAt = replaceable.charAt(i2);
            int i3 = 0;
            for (String str : this.strings) {
                if (!str.isEmpty()) {
                    char cCharAt2 = str.charAt(z2 ? 0 : str.length() - 1);
                    if (z2 && cCharAt2 > cCharAt) {
                        break;
                    }
                    if (cCharAt2 == cCharAt) {
                        int iMatchRest = matchRest(replaceable, iArr[0], i, str);
                        if (z) {
                            if (iMatchRest == (z2 ? i - iArr[0] : iArr[0] - i)) {
                                return 1;
                            }
                        }
                        if (iMatchRest == str.length()) {
                            if (iMatchRest > i3) {
                                i3 = iMatchRest;
                            }
                            if (z2 && iMatchRest < i3) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        continue;
                    }
                }
            }
            if (i3 != 0) {
                int i4 = iArr[0];
                if (!z2) {
                    i3 = -i3;
                }
                iArr[0] = i4 + i3;
                return 2;
            }
        }
        return super.matches(replaceable, iArr, i, z);
    }

    @Deprecated
    public int matchesAt(CharSequence charSequence, int i) {
        int charCount = -1;
        if (hasStrings()) {
            char cCharAt = charSequence.charAt(i);
            Iterator<String> it = this.strings.iterator();
            String next = null;
            while (true) {
                if (!it.hasNext()) {
                    while (true) {
                        int iMatchesAt = matchesAt(charSequence, i, next);
                        if (charCount > iMatchesAt) {
                            break;
                        }
                        if (!it.hasNext()) {
                            charCount = iMatchesAt;
                            break;
                        }
                        next = it.next();
                        charCount = iMatchesAt;
                    }
                } else {
                    next = it.next();
                    char cCharAt2 = next.charAt(0);
                    if (cCharAt2 >= cCharAt && cCharAt2 > cCharAt) {
                        break;
                    }
                }
            }
        }
        if (charCount < 2) {
            int iCharAt = UTF16.charAt(charSequence, i);
            if (contains(iCharAt)) {
                charCount = UTF16.getCharCount(iCharAt);
            }
        }
        return i + charCount;
    }

    @Override // com.ibm.icu.text.UnicodeMatcher
    public boolean matchesIndexValue(int i) {
        for (int i2 = 0; i2 < getRangeCount(); i2++) {
            int rangeStart = getRangeStart(i2);
            int rangeEnd = getRangeEnd(i2);
            if ((rangeStart & (-256)) == (rangeEnd & (-256))) {
                if ((rangeStart & 255) <= i && i <= (rangeEnd & 255)) {
                    return true;
                }
            } else if ((rangeStart & 255) <= i || i <= (rangeEnd & 255)) {
                return true;
            }
        }
        if (hasStrings()) {
            for (String str : this.strings) {
                if (!str.isEmpty() && (UTF16.charAt(str, 0) & 255) == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public UnicodeSet maybeOnlyCaseSensitive(UnicodeSet unicodeSet) {
        if (unicodeSet.size() < 30) {
            return unicodeSet;
        }
        UnicodeSet binaryPropertySet = CharacterProperties.getBinaryPropertySet(34);
        return (unicodeSet.hasStrings() || unicodeSet.getRangeCount() > binaryPropertySet.getRangeCount()) ? binaryPropertySet.cloneAsThawed().retainAll(unicodeSet) : unicodeSet.m20clone().retainAll(binaryPropertySet);
    }

    public void parseMutation(UnicodeSetLexer unicodeSetLexer, StringBuilder sb, int i, int i2, GrammaticalConstructProperties grammaticalConstructProperties) {
        if (!unicodeSetLexer.lookahead().isSetOperator('[') && unicodeSetLexer.lookahead().set() == null) {
            addAll(parseElements(unicodeSetLexer, sb));
        } else {
            grammaticalConstructProperties.containsSetOperation = true;
            parseSetOperations(unicodeSetLexer, sb, i, i2);
        }
    }

    public void parseSetOperations(UnicodeSetLexer unicodeSetLexer, StringBuilder sb, int i, int i2) {
        int i3 = i2 + 1;
        addAll(parseUnicodeSet(unicodeSetLexer, sb, i, i3));
        while (true) {
            if (unicodeSetLexer.acceptSetOperator('&')) {
                sb.append('&');
                retainAll(parseUnicodeSet(unicodeSetLexer, sb, i, i3));
            } else {
                if (!unicodeSetLexer.lookahead().isSetOperator('-') || unicodeSetLexer.lookahead2().isSetOperator(']')) {
                    return;
                }
                unicodeSetLexer.advance();
                sb.append('-');
                removeAll(parseUnicodeSet(unicodeSetLexer, sb, i, i3));
            }
        }
    }

    public Stream<EntryRange> rangeStream() {
        return StreamSupport.stream(ranges().spliterator(), false);
    }

    public Iterable<EntryRange> ranges() {
        return new EntryRangeIterable(0, this);
    }

    public UnicodeSet remove(int i, int i2) {
        checkFrozen();
        if (i < 0 || i > 1114111) {
            og.i(cq.j("Invalid code point U+", Utility.hex(i, 6)));
            return null;
        }
        if (i2 < 0 || i2 > 1114111) {
            og.i(cq.j("Invalid code point U+", Utility.hex(i2, 6)));
            return null;
        }
        if (i <= i2) {
            retain(range(i, i2), 2, 2);
        }
        return this;
    }

    public UnicodeSet removeAll(UnicodeSet unicodeSet) {
        checkFrozen();
        retain(unicodeSet.list, unicodeSet.len, 2);
        if (hasStrings() && unicodeSet.hasStrings()) {
            this.strings.removeAll(unicodeSet.strings);
        }
        return this;
    }

    public final UnicodeSet removeAllStrings() {
        checkFrozen();
        if (hasStrings()) {
            this.strings.clear();
            this.pat = null;
        }
        return this;
    }

    public UnicodeSet retainAll(UnicodeSet unicodeSet) {
        checkFrozen();
        retain(unicodeSet.list, unicodeSet.len, 0);
        if (hasStrings()) {
            boolean zHasStrings = unicodeSet.hasStrings();
            SortedSet<String> sortedSet = this.strings;
            if (!zHasStrings) {
                sortedSet.clear();
                return this;
            }
            sortedSet.retainAll(unicodeSet.strings);
        }
        return this;
    }

    public UnicodeSet set(UnicodeSet unicodeSet) {
        checkFrozen();
        this.list = Arrays.copyOf(unicodeSet.list, unicodeSet.len);
        this.len = unicodeSet.len;
        this.pat = unicodeSet.pat;
        if (unicodeSet.hasStrings()) {
            this.strings = new TreeSet((SortedSet) unicodeSet.strings);
            return this;
        }
        this.strings = EMPTY_STRINGS;
        return this;
    }

    public void setPattern(String str) {
        this.pat = str;
    }

    public int size() {
        int rangeCount = getRangeCount();
        int rangeEnd = 0;
        for (int i = 0; i < rangeCount; i++) {
            rangeEnd += (getRangeEnd(i) - getRangeStart(i)) + 1;
        }
        return this.strings.size() + rangeEnd;
    }

    public int span(CharSequence charSequence, int i, SpanCondition spanCondition) {
        int length = charSequence.length();
        if (i < 0) {
            i = 0;
        } else if (i >= length) {
            return length;
        }
        if (this.bmpSet != null) {
            return this.bmpSet.span(charSequence, i, spanCondition, null);
        }
        if (this.stringSpan != null) {
            return this.stringSpan.span(charSequence, i, spanCondition);
        }
        if (hasStrings()) {
            UnicodeSetStringSpan unicodeSetStringSpan = new UnicodeSetStringSpan(this, new ArrayList(this.strings), spanCondition == SpanCondition.NOT_CONTAINED ? 33 : 34);
            if (unicodeSetStringSpan.needsStringSpanUTF16()) {
                return unicodeSetStringSpan.span(charSequence, i, spanCondition);
            }
        }
        return spanCodePointsAndCount(charSequence, i, spanCondition, null);
    }

    @Deprecated
    public int spanAndCount(CharSequence charSequence, int i, SpanCondition spanCondition, OutputInt outputInt) {
        if (outputInt == null) {
            og.i("outCount must not be null");
            return 0;
        }
        int length = charSequence.length();
        if (i < 0) {
            i = 0;
        } else if (i >= length) {
            return length;
        }
        if (this.stringSpan != null) {
            return this.stringSpan.spanAndCount(charSequence, i, spanCondition, outputInt);
        }
        if (this.bmpSet != null) {
            return this.bmpSet.span(charSequence, i, spanCondition, outputInt);
        }
        if (!hasStrings()) {
            return spanCodePointsAndCount(charSequence, i, spanCondition, outputInt);
        }
        return new UnicodeSetStringSpan(this, new ArrayList(this.strings), (spanCondition == SpanCondition.NOT_CONTAINED ? 33 : 34) | 64).spanAndCount(charSequence, i, spanCondition, outputInt);
    }

    public int spanBack(CharSequence charSequence, int i, SpanCondition spanCondition) {
        if (i <= 0) {
            return 0;
        }
        if (i > charSequence.length()) {
            i = charSequence.length();
        }
        if (this.bmpSet != null) {
            return this.bmpSet.spanBack(charSequence, i, spanCondition);
        }
        if (this.stringSpan != null) {
            return this.stringSpan.spanBack(charSequence, i, spanCondition);
        }
        if (hasStrings()) {
            UnicodeSetStringSpan unicodeSetStringSpan = new UnicodeSetStringSpan(this, new ArrayList(this.strings), spanCondition == SpanCondition.NOT_CONTAINED ? 17 : 18);
            if (unicodeSetStringSpan.needsStringSpanUTF16()) {
                return unicodeSetStringSpan.spanBack(charSequence, i, spanCondition);
            }
        }
        boolean z = spanCondition != SpanCondition.NOT_CONTAINED;
        do {
            int iCodePointBefore = Character.codePointBefore(charSequence, i);
            if (z != contains(iCodePointBefore)) {
                return i;
            }
            i -= Character.charCount(iCodePointBefore);
        } while (i > 0);
        return i;
    }

    public Stream<String> stream() {
        return StreamSupport.stream(spliterator(), false);
    }

    public Stream<String> stringStream() {
        return strings().stream();
    }

    public Collection<String> strings() {
        return hasStrings() ? Collections.unmodifiableSortedSet(this.strings) : EMPTY_STRINGS;
    }

    @Deprecated
    public String stripFrom(CharSequence charSequence, boolean z) {
        StringBuilder sb = new StringBuilder();
        int iFindIn = 0;
        while (iFindIn < charSequence.length()) {
            int iFindIn2 = findIn(charSequence, iFindIn, !z);
            sb.append(charSequence.subSequence(iFindIn, iFindIn2));
            iFindIn = findIn(charSequence, iFindIn2, z);
        }
        return sb.toString();
    }

    @Override // com.ibm.icu.text.UnicodeMatcher
    public String toPattern(boolean z) {
        String str = this.pat;
        return (str == null || z) ? ((StringBuilder) _toPattern(new StringBuilder(), z)).toString() : str;
    }

    public String toString() {
        return toPattern(true);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CodePointSpliterator implements Spliterator.OfInt {
        private static final int CHARACTERISTICS = 337;
        private final CodePointIteratorInt cpi;
        private final UnicodeSet unicodeSet;

        public CodePointSpliterator(UnicodeSet unicodeSet) {
            this.unicodeSet = unicodeSet;
            this.cpi = new CodePointIteratorInt(unicodeSet);
        }

        @Override // java.util.Spliterator
        public int characteristics() {
            return this.unicodeSet.isFrozen() ? 1361 : 337;
        }

        @Override // java.util.Spliterator
        public long estimateSize() {
            return this.unicodeSet.size() - this.unicodeSet.strings.size();
        }

        @Override // java.util.Spliterator.OfPrimitive
        public boolean tryAdvance(IntConsumer intConsumer) {
            intConsumer.getClass();
            if (!this.cpi.hasNext()) {
                return false;
            }
            intConsumer.accept(this.cpi.next());
            return true;
        }

        @Override // java.util.Spliterator.OfInt, java.util.Spliterator.OfPrimitive, java.util.Spliterator
        public Spliterator.OfInt trySplit() {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class EntryRangeIterable implements Iterable<EntryRange> {
        private EntryRangeIterable() {
        }

        @Override // java.lang.Iterable
        public Iterator<EntryRange> iterator() {
            return new EntryRangeIterator(0, UnicodeSet.this);
        }

        public /* synthetic */ EntryRangeIterable(int i, UnicodeSet unicodeSet) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class GrammaticalConstructProperties {
        boolean containsSetOperation;

        private GrammaticalConstructProperties() {
            this.containsSetOperation = false;
        }

        public /* synthetic */ GrammaticalConstructProperties(int i) {
            this();
        }
    }

    public StringBuffer _generatePattern(StringBuffer stringBuffer, boolean z) {
        return _generatePattern(stringBuffer, z, true);
    }

    public final boolean containsSome(UnicodeSet unicodeSet) {
        return !containsNone(unicodeSet);
    }

    public final boolean containsSome(CharSequence charSequence) {
        return !containsNone(charSequence);
    }

    public final <T extends CharSequence> boolean containsSome(Iterable<T> iterable) {
        return !containsNone(iterable);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class EntryRangeIterator implements Iterator<EntryRange> {
        int pos;
        EntryRange result;

        private EntryRangeIterator() {
            this.result = new EntryRange();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.pos < UnicodeSet.this.len - 1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public EntryRange next() {
            if (this.pos >= UnicodeSet.this.len - 1) {
                dk0.d();
                return null;
            }
            EntryRange entryRange = this.result;
            int[] iArr = UnicodeSet.this.list;
            int i = this.pos;
            this.pos = i + 1;
            entryRange.codepoint = iArr[i];
            EntryRange entryRange2 = this.result;
            int[] iArr2 = UnicodeSet.this.list;
            int i2 = this.pos;
            this.pos = i2 + 1;
            entryRange2.codepointEnd = iArr2[i2] - 1;
            return this.result;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public /* synthetic */ EntryRangeIterator(int i, UnicodeSet unicodeSet) {
            this();
        }
    }

    public String[] addAllTo(String[] strArr) {
        return (String[]) addAllTo(this, strArr);
    }

    public static <T, U extends Collection<T>> U addAllTo(Iterable<T> iterable, U u) {
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            u.add(it.next());
        }
        return u;
    }

    public <T extends Collection<String>> T addAllTo(T t) {
        return (T) addAllTo(this, t);
    }

    public final UnicodeSet removeAll(CharSequence charSequence) {
        return removeAll(fromAll(charSequence));
    }

    public <T extends CharSequence> UnicodeSet removeAll(Iterable<T> iterable) {
        checkFrozen();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
        return this;
    }

    public final UnicodeSet retainAll(CharSequence charSequence) {
        return retainAll(fromAll(charSequence));
    }

    public <T extends CharSequence> UnicodeSet retainAll(Iterable<T> iterable) {
        checkFrozen();
        UnicodeSet unicodeSet = new UnicodeSet();
        unicodeSet.addAll((Iterable<?>) iterable);
        retainAll(unicodeSet);
        return this;
    }

    public final UnicodeSet addAll(CharSequence charSequence) {
        checkFrozen();
        int charCount = 0;
        while (charCount < charSequence.length()) {
            int iCharAt = UTF16.charAt(charSequence, charCount);
            add_unchecked(iCharAt, iCharAt);
            charCount += UTF16.getCharCount(iCharAt);
        }
        return this;
    }

    public final UnicodeSet complementAll(CharSequence charSequence) {
        return complementAll(fromAll(charSequence));
    }

    public UnicodeSet set(int i, int i2) {
        checkFrozen();
        clear();
        complement(i, i2);
        return this;
    }

    public static int compare(int i, CharSequence charSequence) {
        return -CharSequences.compare(charSequence, i);
    }

    public static <T extends Comparable<T>> int compare(Iterable<T> iterable, Iterable<T> iterable2) {
        return compare(iterable.iterator(), iterable2.iterator());
    }

    public UnicodeSet addAll(int i, int i2) {
        checkFrozen();
        return add_unchecked(i, i2);
    }

    public static int compare(CharSequence charSequence, int i) {
        return CharSequences.compare(charSequence, i);
    }

    public static <T extends Comparable<T>> int compare(Collection<T> collection, Collection<T> collection2, ComparisonStyle comparisonStyle) {
        int size;
        if (comparisonStyle == ComparisonStyle.LEXICOGRAPHIC || (size = collection.size() - collection2.size()) == 0) {
            return compare(collection, collection2);
        }
        return (size < 0) == (comparisonStyle == ComparisonStyle.SHORTER_FIRST) ? -1 : 1;
    }

    public UnicodeSet addAll(Iterable<?> iterable) {
        checkFrozen();
        Iterator<?> it = iterable.iterator();
        while (it.hasNext()) {
            add(it.next().toString());
        }
        return this;
    }

    public <T extends CharSequence> UnicodeSet addAll(T... tArr) {
        checkFrozen();
        for (T t : tArr) {
            add(t);
        }
        return this;
    }

    public final UnicodeSet remove(int i) {
        return remove(i, i);
    }

    public final UnicodeSet remove(CharSequence charSequence) {
        int singleCP = getSingleCP(charSequence);
        if (singleCP < 0) {
            checkFrozen();
            String string = charSequence.toString();
            if (this.strings.contains(string)) {
                this.strings.remove(string);
                this.pat = null;
            }
            return this;
        }
        remove(singleCP, singleCP);
        return this;
    }

    @Override // com.ibm.icu.text.UnicodeFilter
    public boolean contains(int i) {
        if (i >= 0 && i <= 1114111) {
            if (this.bmpSet != null) {
                return this.bmpSet.contains(i);
            }
            if (this.stringSpan != null) {
                return this.stringSpan.contains(i);
            }
            return (findCodePoint(i) & 1) != 0;
        }
        og.i(cq.j("Invalid code point U+", Utility.hex(i, 6)));
        return false;
    }

    public final UnicodeSet complement(int i) {
        return complement(i, i);
    }

    public UnicodeSet complement() {
        checkFrozen();
        int[] iArr = this.list;
        int i = iArr[0];
        int i2 = this.len;
        if (i == 0) {
            System.arraycopy(iArr, 1, iArr, 0, i2 - 1);
            this.len--;
        } else {
            ensureCapacity(i2 + 1);
            int[] iArr2 = this.list;
            System.arraycopy(iArr2, 0, iArr2, 1, this.len);
            this.list[0] = 0;
            this.len++;
        }
        this.pat = null;
        return this;
    }

    public final boolean contains(CharSequence charSequence) {
        int singleCP = getSingleCP(charSequence);
        if (singleCP < 0) {
            return this.strings.contains(charSequence.toString());
        }
        return contains(singleCP);
    }

    public final UnicodeSet complement(CharSequence charSequence) {
        checkFrozen();
        int singleCP = getSingleCP(charSequence);
        if (singleCP < 0) {
            String string = charSequence.toString();
            if (this.strings.contains(string)) {
                this.strings.remove(string);
            } else {
                addString(string);
            }
            this.pat = null;
            return this;
        }
        complement(singleCP, singleCP);
        return this;
    }

    public boolean containsNone(int i, int i2) {
        int i3;
        if (i < 0 || i > 1114111) {
            og.i(cq.j("Invalid code point U+", Utility.hex(i, 6)));
            return false;
        }
        if (i2 < 0 || i2 > 1114111) {
            og.i(cq.j("Invalid code point U+", Utility.hex(i2, 6)));
            return false;
        }
        int i4 = -1;
        do {
            i4++;
            i3 = this.list[i4];
        } while (i >= i3);
        return (i4 & 1) == 0 && i2 < i3;
    }

    private static <T extends Appendable> T _appendToPat(T t, String str, boolean z) {
        int iCharCount = 0;
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            _appendToPat(t, iCodePointAt, z);
            iCharCount += Character.charCount(iCodePointAt);
        }
        return t;
    }

    public UnicodeSet(UnicodeSet unicodeSet) {
        this.strings = EMPTY_STRINGS;
        this.pat = null;
        set(unicodeSet);
    }

    private static <T extends Appendable> T _appendToPat(T t, int i, int i2, boolean z) {
        _appendToPat(t, i, z);
        if (i == i2) {
            return t;
        }
        if (i + 1 != i2 || i == 56319) {
            try {
                t.append('-');
            } catch (IOException e) {
                kf2.h(e);
                return null;
            }
        }
        _appendToPat(t, i2, z);
        return t;
    }

    public boolean containsAll(String str) {
        int charCount = 0;
        while (charCount < str.length()) {
            int iCharAt = UTF16.charAt(str, charCount);
            if (!contains(iCharAt)) {
                if (hasStrings()) {
                    return containsAll(str, 0);
                }
                return false;
            }
            charCount += UTF16.getCharCount(iCharAt);
        }
        return true;
    }

    public int span(CharSequence charSequence, SpanCondition spanCondition) {
        return span(charSequence, 0, spanCondition);
    }

    public UnicodeSet(int i, int i2) {
        this();
        add(i, i2);
    }

    public boolean containsNone(CharSequence charSequence) {
        return span(charSequence, SpanCondition.NOT_CONTAINED) == charSequence.length();
    }

    public <T extends CharSequence> boolean containsNone(Iterable<T> iterable) {
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            if (contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public UnicodeSet() {
        this.strings = EMPTY_STRINGS;
        this.pat = null;
        int[] iArr = new int[25];
        this.list = iArr;
        iArr[0] = 1114112;
        this.len = 1;
    }

    private boolean containsAll(String str, int i) {
        if (i >= str.length()) {
            return true;
        }
        int iCharAt = UTF16.charAt(str, i);
        if (contains(iCharAt) && containsAll(str, UTF16.getCharCount(iCharAt) + i)) {
            return true;
        }
        for (String str2 : this.strings) {
            if (!str2.isEmpty() && str.startsWith(str2, i) && containsAll(str, str2.length() + i)) {
                return true;
            }
        }
        return false;
    }

    private static int matchesAt(CharSequence charSequence, int i, CharSequence charSequence2) {
        int length = charSequence2.length();
        if (charSequence.length() + i > length) {
            return -1;
        }
        int i2 = 0;
        while (i2 < length) {
            if (charSequence2.charAt(i2) != charSequence.charAt(i)) {
                return -1;
            }
            i2++;
            i++;
        }
        return i2;
    }

    public UnicodeSet(String str) {
        this();
        applyPattern(str, null, null, 1);
    }

    public UnicodeSet(String str, boolean z) {
        this();
        applyPattern(str, null, null, z ? 1 : 0);
    }

    public <T extends CharSequence> boolean containsAll(Iterable<T> iterable) {
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public UnicodeSet(String str, int i) {
        this();
        applyPattern(str, null, null, i);
    }

    public UnicodeSet(String str, ParsePosition parsePosition, SymbolTable symbolTable) {
        this();
        applyPattern(str, parsePosition, symbolTable, 1);
    }

    public UnicodeSet(String str, ParsePosition parsePosition, SymbolTable symbolTable, int i) {
        this();
        applyPattern(str, parsePosition, symbolTable, i);
    }

    public int spanBack(CharSequence charSequence, SpanCondition spanCondition) {
        return spanBack(charSequence, charSequence.length(), spanCondition);
    }

    public UnicodeSet applyPattern(String str, boolean z) {
        checkFrozen();
        return applyPattern(str, null, null, z ? 1 : 0);
    }

    public UnicodeSet applyPattern(String str, int i) {
        checkFrozen();
        return applyPattern(str, null, null, i);
    }

    public final UnicodeSet applyPattern(String str) {
        checkFrozen();
        return applyPattern(str, null, null, 1);
    }

    private void applyPattern(String str, ParsePosition parsePosition, RuleCharacterIterator ruleCharacterIterator, SymbolTable symbolTable, StringBuilder sb, int i, int i2) {
        set(parseUnicodeSet(new UnicodeSetLexer(str, parsePosition, ruleCharacterIterator, i, symbolTable), sb, i, i2));
    }

    @Override // java.lang.Comparable
    public int compareTo(UnicodeSet unicodeSet) {
        return compareTo(unicodeSet, ComparisonStyle.SHORTER_FIRST);
    }

    public int compareTo(Iterable<String> iterable) {
        return compare(this, iterable);
    }

    private UnicodeSet add_unchecked(int i, int i2) {
        if (i < 0 || i > 1114111) {
            og.i(cq.j("Invalid code point U+", Utility.hex(i, 6)));
            return null;
        }
        if (i2 < 0 || i2 > 1114111) {
            og.i(cq.j("Invalid code point U+", Utility.hex(i2, 6)));
            return null;
        }
        if (i >= i2) {
            if (i == i2) {
                add(i);
            }
            return this;
        }
        int i3 = i2 + 1;
        int i4 = this.len;
        if ((i4 & 1) != 0) {
            int i5 = i4 == 1 ? -2 : this.list[i4 - 2];
            if (i5 <= i) {
                checkFrozen();
                int[] iArr = this.list;
                if (i5 == i) {
                    int i6 = this.len;
                    iArr[i6 - 2] = i3;
                    if (i3 == 1114112) {
                        this.len = i6 - 1;
                    }
                } else {
                    int i7 = this.len;
                    iArr[i7 - 1] = i;
                    if (i3 < 1114112) {
                        ensureCapacity(i7 + 2);
                        int[] iArr2 = this.list;
                        int i8 = this.len;
                        int i9 = i8 + 1;
                        this.len = i9;
                        iArr2[i8] = i3;
                        this.len = i8 + 2;
                        iArr2[i9] = 1114112;
                    } else {
                        ensureCapacity(i7 + 1);
                        int[] iArr3 = this.list;
                        int i10 = this.len;
                        this.len = i10 + 1;
                        iArr3[i10] = 1114112;
                    }
                }
                this.pat = null;
                return this;
            }
        }
        add(range(i, i2), 2, 0);
        return this;
    }

    public final UnicodeSet retain(int i) {
        return retain(i, i);
    }

    public final UnicodeSet retain(CharSequence charSequence) {
        int singleCP = getSingleCP(charSequence);
        if (singleCP < 0) {
            checkFrozen();
            String string = charSequence.toString();
            boolean zContains = this.strings.contains(string);
            if (zContains && getRangeCount() == 0 && size() == 1) {
                return this;
            }
            clear();
            if (zContains) {
                addString(string);
            }
            this.pat = null;
            return this;
        }
        retain(singleCP, singleCP);
        return this;
    }

    public UnicodeSet retain(int i, int i2) {
        checkFrozen();
        if (i < 0 || i > 1114111) {
            og.i(cq.j("Invalid code point U+", Utility.hex(i, 6)));
            return null;
        }
        if (i2 < 0 || i2 > 1114111) {
            og.i(cq.j("Invalid code point U+", Utility.hex(i2, 6)));
            return null;
        }
        if (i <= i2) {
            retain(range(i, i2), 2, 0);
            return this;
        }
        clear();
        return this;
    }

    public final UnicodeSet add(int i) {
        checkFrozen();
        return add_unchecked(i);
    }

    public final UnicodeSet add(CharSequence charSequence) {
        checkFrozen();
        int singleCP = getSingleCP(charSequence);
        if (singleCP < 0) {
            String string = charSequence.toString();
            if (!this.strings.contains(string)) {
                addString(string);
                this.pat = null;
            }
            return this;
        }
        add_unchecked(singleCP, singleCP);
        return this;
    }

    public UnicodeSet add(Iterable<?> iterable) {
        return addAll(iterable);
    }

    public UnicodeSet add(int i, int i2) {
        checkFrozen();
        return add_unchecked(i, i2);
    }

    public UnicodeSet applyPropertyAlias(String str, String str2) {
        return applyPropertyAlias(str, str2, null);
    }
}
