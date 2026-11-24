package com.ibm.icu.impl;

import com.ibm.icu.text.UTF16;
import defpackage.dk0;
import defpackage.og;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class Trie2 implements Iterable<Range> {
    static final int UNEWTRIE2_INDEX_1_LENGTH = 544;
    static final int UNEWTRIE2_INDEX_GAP_LENGTH = 576;
    static final int UNEWTRIE2_INDEX_GAP_OFFSET = 2080;
    static final int UNEWTRIE2_MAX_DATA_LENGTH = 1115264;
    static final int UNEWTRIE2_MAX_INDEX_2_LENGTH = 35488;
    static final int UTRIE2_BAD_UTF8_DATA_OFFSET = 128;
    static final int UTRIE2_CP_PER_INDEX_1_ENTRY = 2048;
    static final int UTRIE2_DATA_BLOCK_LENGTH = 32;
    static final int UTRIE2_DATA_GRANULARITY = 4;
    static final int UTRIE2_DATA_MASK = 31;
    static final int UTRIE2_DATA_START_OFFSET = 192;
    static final int UTRIE2_INDEX_1_OFFSET = 2112;
    static final int UTRIE2_INDEX_2_BLOCK_LENGTH = 64;
    static final int UTRIE2_INDEX_2_BMP_LENGTH = 2080;
    static final int UTRIE2_INDEX_2_MASK = 63;
    static final int UTRIE2_INDEX_2_OFFSET = 0;
    static final int UTRIE2_INDEX_SHIFT = 2;
    static final int UTRIE2_LSCP_INDEX_2_LENGTH = 32;
    static final int UTRIE2_LSCP_INDEX_2_OFFSET = 2048;
    static final int UTRIE2_MAX_INDEX_1_LENGTH = 512;
    static final int UTRIE2_OMITTED_BMP_INDEX_1_LENGTH = 32;
    static final int UTRIE2_OPTIONS_VALUE_BITS_MASK = 15;
    static final int UTRIE2_SHIFT_1 = 11;
    static final int UTRIE2_SHIFT_1_2 = 6;
    static final int UTRIE2_SHIFT_2 = 5;
    static final int UTRIE2_UTF8_2B_INDEX_2_LENGTH = 32;
    static final int UTRIE2_UTF8_2B_INDEX_2_OFFSET = 2080;
    private static ValueMapper defaultValueMapper = new ValueMapper() { // from class: com.ibm.icu.impl.Trie2.1
        @Override // com.ibm.icu.impl.Trie2.ValueMapper
        public int map(int i) {
            return i;
        }
    };
    int data16;
    int[] data32;
    int dataLength;
    int dataNullOffset;
    int errorValue;
    int fHash;
    UTrie2Header header;
    int highStart;
    int highValueIndex;
    char[] index;
    int index2NullOffset;
    int indexLength;
    int initialValue;

    /* JADX INFO: renamed from: com.ibm.icu.impl.Trie2$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$Trie2$ValueWidth;

        static {
            int[] iArr = new int[ValueWidth.values().length];
            $SwitchMap$com$ibm$icu$impl$Trie2$ValueWidth = iArr;
            try {
                iArr[ValueWidth.BITS_16.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$Trie2$ValueWidth[ValueWidth.BITS_32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class CharSequenceIterator implements Iterator<CharSequenceValues> {
        private CharSequenceValues fResults = new CharSequenceValues();
        private int index;
        private CharSequence text;
        private int textLength;

        public CharSequenceIterator(CharSequence charSequence, int i) {
            this.text = charSequence;
            this.textLength = charSequence.length();
            set(i);
        }

        @Override // java.util.Iterator
        public final boolean hasNext() {
            return this.index < this.textLength;
        }

        public final boolean hasPrevious() {
            return this.index > 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public CharSequenceValues next() {
            int iCodePointAt = Character.codePointAt(this.text, this.index);
            int i = Trie2.this.get(iCodePointAt);
            CharSequenceValues charSequenceValues = this.fResults;
            int i2 = this.index;
            charSequenceValues.index = i2;
            charSequenceValues.codePoint = iCodePointAt;
            charSequenceValues.value = i;
            this.index = i2 + 1;
            if (iCodePointAt >= 65536) {
                this.index = i2 + 2;
            }
            return charSequenceValues;
        }

        public CharSequenceValues previous() {
            int iCodePointBefore = Character.codePointBefore(this.text, this.index);
            int i = Trie2.this.get(iCodePointBefore);
            int i2 = this.index;
            this.index = i2 - 1;
            if (iCodePointBefore >= 65536) {
                this.index = i2 - 2;
            }
            CharSequenceValues charSequenceValues = this.fResults;
            charSequenceValues.index = this.index;
            charSequenceValues.codePoint = iCodePointBefore;
            charSequenceValues.value = i;
            return charSequenceValues;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Trie2.CharSequenceIterator does not support remove().");
        }

        public void set(int i) {
            if (i < 0 || i > this.textLength) {
                throw new IndexOutOfBoundsException();
            }
            this.index = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CharSequenceValues {
        public int codePoint;
        public int index;
        public int value;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Range {
        public int endCodePoint;
        public boolean leadSurrogate;
        public int startCodePoint;
        public int value;

        public boolean equals(Object obj) {
            if (obj != null && obj.getClass().equals(getClass())) {
                Range range = (Range) obj;
                if (this.startCodePoint == range.startCodePoint && this.endCodePoint == range.endCodePoint && this.value == range.value && this.leadSurrogate == range.leadSurrogate) {
                    return true;
                }
            }
            return false;
        }

        public int hashCode() {
            return Trie2.hashByte(Trie2.hashInt(Trie2.hashUChar32(Trie2.hashUChar32(Trie2.initHash(), this.startCodePoint), this.endCodePoint), this.value), this.leadSurrogate ? 1 : 0);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class UTrie2Header {
        int dataNullOffset;
        int index2NullOffset;
        int indexLength;
        int options;
        int shiftedDataLength;
        int shiftedHighStart;
        int signature;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public interface ValueMapper {
        int map(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum ValueWidth {
        BITS_16,
        BITS_32
    }

    public static Trie2 createFromSerialized(ByteBuffer byteBuffer) {
        ValueWidth valueWidth;
        Trie2 trie2_32;
        ByteOrder byteOrderOrder = byteBuffer.order();
        try {
            UTrie2Header uTrie2Header = new UTrie2Header();
            int i = byteBuffer.getInt();
            uTrie2Header.signature = i;
            if (i == 845771348) {
                ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                if (byteOrderOrder == byteOrder) {
                    byteOrder = ByteOrder.LITTLE_ENDIAN;
                }
                byteBuffer.order(byteOrder);
                uTrie2Header.signature = 1416784178;
            } else if (i != 1416784178) {
                throw new IllegalArgumentException("Buffer does not contain a serialized UTrie2");
            }
            uTrie2Header.options = byteBuffer.getChar();
            uTrie2Header.indexLength = byteBuffer.getChar();
            uTrie2Header.shiftedDataLength = byteBuffer.getChar();
            uTrie2Header.index2NullOffset = byteBuffer.getChar();
            uTrie2Header.dataNullOffset = byteBuffer.getChar();
            uTrie2Header.shiftedHighStart = byteBuffer.getChar();
            int i2 = uTrie2Header.options;
            if ((i2 & 15) > 1) {
                throw new IllegalArgumentException("UTrie2 serialized format error.");
            }
            if ((i2 & 15) == 0) {
                valueWidth = ValueWidth.BITS_16;
                trie2_32 = new Trie2_16();
            } else {
                valueWidth = ValueWidth.BITS_32;
                trie2_32 = new Trie2_32();
            }
            trie2_32.header = uTrie2Header;
            int i3 = uTrie2Header.indexLength;
            trie2_32.indexLength = i3;
            int i4 = uTrie2Header.shiftedDataLength << 2;
            trie2_32.dataLength = i4;
            trie2_32.index2NullOffset = uTrie2Header.index2NullOffset;
            trie2_32.dataNullOffset = uTrie2Header.dataNullOffset;
            trie2_32.highStart = uTrie2Header.shiftedHighStart << 11;
            int i5 = i4 - 4;
            trie2_32.highValueIndex = i5;
            ValueWidth valueWidth2 = ValueWidth.BITS_16;
            if (valueWidth == valueWidth2) {
                trie2_32.highValueIndex = i5 + i3;
            }
            if (valueWidth == valueWidth2) {
                i3 += i4;
            }
            trie2_32.index = ICUBinary.getChars(byteBuffer, i3, 0);
            if (valueWidth == valueWidth2) {
                trie2_32.data16 = trie2_32.indexLength;
            } else {
                trie2_32.data32 = ICUBinary.getInts(byteBuffer, trie2_32.dataLength, 0);
            }
            int i6 = AnonymousClass2.$SwitchMap$com$ibm$icu$impl$Trie2$ValueWidth[valueWidth.ordinal()];
            if (i6 == 1) {
                trie2_32.data32 = null;
                char[] cArr = trie2_32.index;
                trie2_32.initialValue = cArr[trie2_32.dataNullOffset];
                trie2_32.errorValue = cArr[trie2_32.data16 + 128];
            } else {
                if (i6 != 2) {
                    throw new IllegalArgumentException("UTrie2 serialized format error.");
                }
                trie2_32.data16 = 0;
                int[] iArr = trie2_32.data32;
                trie2_32.initialValue = iArr[trie2_32.dataNullOffset];
                trie2_32.errorValue = iArr[128];
            }
            byteBuffer.order(byteOrderOrder);
            return trie2_32;
        } catch (Throwable th) {
            byteBuffer.order(byteOrderOrder);
            throw th;
        }
    }

    public static int getVersion(InputStream inputStream, boolean z) throws IOException {
        if (!inputStream.markSupported()) {
            og.i("Input stream must support mark().");
            return 0;
        }
        inputStream.mark(4);
        byte[] bArr = new byte[4];
        int i = inputStream.read(bArr);
        inputStream.reset();
        if (i != 4) {
            return 0;
        }
        byte b = bArr[0];
        if (b == 84 && bArr[1] == 114 && bArr[2] == 105 && bArr[3] == 101) {
            return 1;
        }
        if (b == 84 && bArr[1] == 114 && bArr[2] == 105 && bArr[3] == 50) {
            return 2;
        }
        if (z) {
            if (b == 101 && bArr[1] == 105 && bArr[2] == 114 && bArr[3] == 84) {
                return 1;
            }
            if (b == 50 && bArr[1] == 105 && bArr[2] == 114 && bArr[3] == 84) {
                return 2;
            }
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hashByte(int i, int i2) {
        return (i * 16777619) ^ i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hashInt(int i, int i2) {
        return hashByte(hashByte(hashByte(hashByte(i, i2 & 255), (i2 >> 8) & 255), (i2 >> 16) & 255), (i2 >> 24) & 255);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hashUChar32(int i, int i2) {
        return hashByte(hashByte(hashByte(i, i2 & 255), (i2 >> 8) & 255), i2 >> 16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int initHash() {
        return -2128831035;
    }

    public CharSequenceIterator charSequenceIterator(CharSequence charSequence, int i) {
        return new CharSequenceIterator(charSequence, i);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Trie2)) {
            return false;
        }
        Trie2 trie2 = (Trie2) obj;
        Iterator<Range> it = trie2.iterator();
        for (Range range : this) {
            if (!it.hasNext() || !range.equals(it.next())) {
                return false;
            }
        }
        return !it.hasNext() && this.errorValue == trie2.errorValue && this.initialValue == trie2.initialValue;
    }

    public abstract int get(int i);

    public abstract int getFromU16SingleLead(char c);

    public int hashCode() {
        if (this.fHash == 0) {
            int iInitHash = initHash();
            Iterator<Range> it = iterator();
            while (it.hasNext()) {
                iInitHash = hashInt(iInitHash, it.next().hashCode());
            }
            if (iInitHash == 0) {
                iInitHash = 1;
            }
            this.fHash = iInitHash;
        }
        return this.fHash;
    }

    @Override // java.lang.Iterable
    public Iterator<Range> iterator() {
        return iterator(defaultValueMapper);
    }

    public Iterator<Range> iteratorForLeadSurrogate(char c) {
        return new Trie2Iterator(c, defaultValueMapper);
    }

    public int rangeEnd(int i, int i2, int i3) {
        int iMin = Math.min(this.highStart, i2);
        do {
            i++;
            if (i >= iMin) {
                break;
            }
        } while (get(i) == i3);
        if (i < this.highStart) {
            i2 = i;
        }
        return i2 - 1;
    }

    public int serializeHeader(DataOutputStream dataOutputStream) {
        dataOutputStream.writeInt(this.header.signature);
        dataOutputStream.writeShort(this.header.options);
        dataOutputStream.writeShort(this.header.indexLength);
        dataOutputStream.writeShort(this.header.shiftedDataLength);
        dataOutputStream.writeShort(this.header.index2NullOffset);
        dataOutputStream.writeShort(this.header.dataNullOffset);
        dataOutputStream.writeShort(this.header.shiftedHighStart);
        int i = 0;
        while (true) {
            int i2 = this.header.indexLength;
            if (i >= i2) {
                return 16 + i2;
            }
            dataOutputStream.writeChar(this.index[i]);
            i++;
        }
    }

    public Iterator<Range> iterator(ValueMapper valueMapper) {
        return new Trie2Iterator(valueMapper);
    }

    public Iterator<Range> iteratorForLeadSurrogate(char c, ValueMapper valueMapper) {
        return new Trie2Iterator(c, valueMapper);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public class Trie2Iterator implements Iterator<Range> {
        private boolean doLeadSurrogates;
        private boolean doingCodePoints;
        private int limitCP;
        private ValueMapper mapper;
        private int nextStart;
        private Range returnValue;

        public Trie2Iterator(char c, ValueMapper valueMapper) {
            this.returnValue = new Range();
            this.doingCodePoints = true;
            this.doLeadSurrogates = true;
            if (c < 55296 || c > 56319) {
                og.i("Bad lead surrogate value.");
                throw null;
            }
            this.mapper = valueMapper;
            int i = (c - 55232) << 10;
            this.nextStart = i;
            this.limitCP = i + 1024;
            this.doLeadSurrogates = false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v2, types: [int] */
        private int rangeEndLS(char c) {
            if (c >= 56319) {
                return UTF16.LEAD_SURROGATE_MAX_VALUE;
            }
            int fromU16SingleLead = Trie2.this.getFromU16SingleLead(c);
            do {
                c++;
                if (c > 56319) {
                    break;
                }
            } while (Trie2.this.getFromU16SingleLead((char) c) == fromU16SingleLead);
            return c - 1;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return (this.doingCodePoints && (this.doLeadSurrogates || this.nextStart < this.limitCP)) || this.nextStart < 56320;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Range next() {
            int map;
            int iRangeEndLS;
            if (!hasNext()) {
                dk0.d();
                return null;
            }
            if (this.nextStart >= this.limitCP) {
                this.doingCodePoints = false;
                this.nextStart = 55296;
            }
            boolean z = this.doingCodePoints;
            Trie2 trie2 = Trie2.this;
            if (z) {
                int i = trie2.get(this.nextStart);
                map = this.mapper.map(i);
                iRangeEndLS = Trie2.this.rangeEnd(this.nextStart, this.limitCP, i);
                while (iRangeEndLS < this.limitCP - 1) {
                    int i2 = iRangeEndLS + 1;
                    int i3 = Trie2.this.get(i2);
                    if (this.mapper.map(i3) != map) {
                        break;
                    }
                    iRangeEndLS = Trie2.this.rangeEnd(i2, this.limitCP, i3);
                }
            } else {
                map = this.mapper.map(trie2.getFromU16SingleLead((char) this.nextStart));
                iRangeEndLS = rangeEndLS((char) this.nextStart);
                while (iRangeEndLS < 56319) {
                    char c = (char) (iRangeEndLS + 1);
                    if (this.mapper.map(Trie2.this.getFromU16SingleLead(c)) != map) {
                        break;
                    }
                    iRangeEndLS = rangeEndLS(c);
                }
            }
            Range range = this.returnValue;
            range.startCodePoint = this.nextStart;
            range.endCodePoint = iRangeEndLS;
            range.value = map;
            range.leadSurrogate = !this.doingCodePoints;
            this.nextStart = iRangeEndLS + 1;
            return range;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Trie2Iterator(ValueMapper valueMapper) {
            this.returnValue = new Range();
            this.doingCodePoints = true;
            this.mapper = valueMapper;
            this.nextStart = 0;
            this.limitCP = 1114112;
            this.doLeadSurrogates = true;
        }
    }
}
