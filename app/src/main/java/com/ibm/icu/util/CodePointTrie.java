package com.ibm.icu.util;

import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.lang.UCharacterEnums;
import defpackage.kf2;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class CodePointTrie extends CodePointMap {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int ASCII_LIMIT = 128;
    private static final int BMP_INDEX_LENGTH = 1024;
    static final int CP_PER_INDEX_2_ENTRY = 512;
    private static final int ERROR_VALUE_NEG_DATA_OFFSET = 1;
    static final int FAST_DATA_BLOCK_LENGTH = 64;
    private static final int FAST_DATA_MASK = 63;
    static final int FAST_SHIFT = 6;
    private static final int HIGH_VALUE_NEG_DATA_OFFSET = 2;
    static final int INDEX_2_BLOCK_LENGTH = 32;
    static final int INDEX_2_MASK = 31;
    static final int INDEX_3_BLOCK_LENGTH = 32;
    private static final int INDEX_3_MASK = 31;
    private static final int MAX_UNICODE = 1114111;
    static final int NO_DATA_NULL_OFFSET = 1048575;
    static final int NO_INDEX3_NULL_OFFSET = 32767;
    private static final int OMITTED_BMP_INDEX_1_LENGTH = 4;
    private static final int OPTIONS_DATA_LENGTH_MASK = 61440;
    private static final int OPTIONS_DATA_NULL_OFFSET_MASK = 3840;
    private static final int OPTIONS_RESERVED_MASK = 56;
    private static final int OPTIONS_VALUE_BITS_MASK = 7;
    private static final int SHIFT_1 = 14;
    static final int SHIFT_1_2 = 5;
    private static final int SHIFT_2 = 9;
    static final int SHIFT_2_3 = 5;
    static final int SHIFT_3 = 4;
    static final int SMALL_DATA_BLOCK_LENGTH = 16;
    static final int SMALL_DATA_MASK = 15;
    private static final int SMALL_INDEX_LENGTH = 64;
    static final int SMALL_LIMIT = 4096;
    private static final int SMALL_MAX = 4095;
    private final int[] ascii;

    @Deprecated
    protected final Data data;

    @Deprecated
    protected final int dataLength;
    private final int dataNullOffset;

    @Deprecated
    protected final int highStart;
    private final char[] index;
    private final int index3NullOffset;
    private final int nullValue;

    /* JADX INFO: renamed from: com.ibm.icu.util.CodePointTrie$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$util$CodePointTrie$ValueWidth;

        static {
            int[] iArr = new int[ValueWidth.values().length];
            $SwitchMap$com$ibm$icu$util$CodePointTrie$ValueWidth = iArr;
            try {
                iArr[ValueWidth.BITS_16.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$CodePointTrie$ValueWidth[ValueWidth.BITS_32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$CodePointTrie$ValueWidth[ValueWidth.BITS_8.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Data16 extends Data {
        char[] array;

        public Data16(char[] cArr) {
            super(0);
            this.array = cArr;
        }

        @Override // com.ibm.icu.util.CodePointTrie.Data
        public int getDataLength() {
            return this.array.length;
        }

        @Override // com.ibm.icu.util.CodePointTrie.Data
        public int getFromIndex(int i) {
            return this.array[i];
        }

        @Override // com.ibm.icu.util.CodePointTrie.Data
        public ValueWidth getValueWidth() {
            return ValueWidth.BITS_16;
        }

        @Override // com.ibm.icu.util.CodePointTrie.Data
        public int write(DataOutputStream dataOutputStream) throws IOException {
            for (char c : this.array) {
                dataOutputStream.writeChar(c);
            }
            return this.array.length * 2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Data32 extends Data {
        int[] array;

        public Data32(int[] iArr) {
            super(0);
            this.array = iArr;
        }

        @Override // com.ibm.icu.util.CodePointTrie.Data
        public int getDataLength() {
            return this.array.length;
        }

        @Override // com.ibm.icu.util.CodePointTrie.Data
        public int getFromIndex(int i) {
            return this.array[i];
        }

        @Override // com.ibm.icu.util.CodePointTrie.Data
        public ValueWidth getValueWidth() {
            return ValueWidth.BITS_32;
        }

        @Override // com.ibm.icu.util.CodePointTrie.Data
        public int write(DataOutputStream dataOutputStream) throws IOException {
            for (int i : this.array) {
                dataOutputStream.writeInt(i);
            }
            return this.array.length * 4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Data8 extends Data {
        byte[] array;

        public Data8(byte[] bArr) {
            super(0);
            this.array = bArr;
        }

        @Override // com.ibm.icu.util.CodePointTrie.Data
        public int getDataLength() {
            return this.array.length;
        }

        @Override // com.ibm.icu.util.CodePointTrie.Data
        public int getFromIndex(int i) {
            return this.array[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
        }

        @Override // com.ibm.icu.util.CodePointTrie.Data
        public ValueWidth getValueWidth() {
            return ValueWidth.BITS_8;
        }

        @Override // com.ibm.icu.util.CodePointTrie.Data
        public int write(DataOutputStream dataOutputStream) throws IOException {
            for (byte b : this.array) {
                dataOutputStream.writeByte(b);
            }
            return this.array.length;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Fast16 extends Fast {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final char[] dataArray;

        public Fast16(char[] cArr, char[] cArr2, int i, int i2, int i3) {
            super(cArr, new Data16(cArr2), i, i2, i3, 0);
            this.dataArray = cArr2;
        }

        public static Fast16 fromBinary(ByteBuffer byteBuffer) {
            return (Fast16) CodePointTrie.fromBinary(Type.FAST, ValueWidth.BITS_16, byteBuffer);
        }

        @Override // com.ibm.icu.util.CodePointTrie.Fast
        public final int bmpGet(int i) {
            return this.dataArray[fastIndex(i)];
        }

        @Override // com.ibm.icu.util.CodePointTrie, com.ibm.icu.util.CodePointMap
        public final int get(int i) {
            return this.dataArray[cpIndex(i)];
        }

        @Override // com.ibm.icu.util.CodePointTrie.Fast
        public final int suppGet(int i) {
            return this.dataArray[smallIndex(Type.FAST, i)];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Fast32 extends Fast {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final int[] dataArray;

        public Fast32(char[] cArr, int[] iArr, int i, int i2, int i3) {
            super(cArr, new Data32(iArr), i, i2, i3, 0);
            this.dataArray = iArr;
        }

        public static Fast32 fromBinary(ByteBuffer byteBuffer) {
            return (Fast32) CodePointTrie.fromBinary(Type.FAST, ValueWidth.BITS_32, byteBuffer);
        }

        @Override // com.ibm.icu.util.CodePointTrie.Fast
        public final int bmpGet(int i) {
            return this.dataArray[fastIndex(i)];
        }

        @Override // com.ibm.icu.util.CodePointTrie, com.ibm.icu.util.CodePointMap
        public final int get(int i) {
            return this.dataArray[cpIndex(i)];
        }

        @Override // com.ibm.icu.util.CodePointTrie.Fast
        public final int suppGet(int i) {
            return this.dataArray[smallIndex(Type.FAST, i)];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Fast8 extends Fast {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final byte[] dataArray;

        public Fast8(char[] cArr, byte[] bArr, int i, int i2, int i3) {
            super(cArr, new Data8(bArr), i, i2, i3, 0);
            this.dataArray = bArr;
        }

        public static Fast8 fromBinary(ByteBuffer byteBuffer) {
            return (Fast8) CodePointTrie.fromBinary(Type.FAST, ValueWidth.BITS_8, byteBuffer);
        }

        @Override // com.ibm.icu.util.CodePointTrie.Fast
        public final int bmpGet(int i) {
            return this.dataArray[fastIndex(i)] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
        }

        @Override // com.ibm.icu.util.CodePointTrie, com.ibm.icu.util.CodePointMap
        public final int get(int i) {
            return this.dataArray[cpIndex(i)] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
        }

        @Override // com.ibm.icu.util.CodePointTrie.Fast
        public final int suppGet(int i) {
            return this.dataArray[smallIndex(Type.FAST, i)] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Small16 extends Small {
        public Small16(char[] cArr, char[] cArr2, int i, int i2, int i3) {
            super(cArr, new Data16(cArr2), i, i2, i3, 0);
        }

        public static Small16 fromBinary(ByteBuffer byteBuffer) {
            return (Small16) CodePointTrie.fromBinary(Type.SMALL, ValueWidth.BITS_16, byteBuffer);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Small32 extends Small {
        public Small32(char[] cArr, int[] iArr, int i, int i2, int i3) {
            super(cArr, new Data32(iArr), i, i2, i3, 0);
        }

        public static Small32 fromBinary(ByteBuffer byteBuffer) {
            return (Small32) CodePointTrie.fromBinary(Type.SMALL, ValueWidth.BITS_32, byteBuffer);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Small8 extends Small {
        public Small8(char[] cArr, byte[] bArr, int i, int i2, int i3) {
            super(cArr, new Data8(bArr), i, i2, i3, 0);
        }

        public static Small8 fromBinary(ByteBuffer byteBuffer) {
            return (Small8) CodePointTrie.fromBinary(Type.SMALL, ValueWidth.BITS_8, byteBuffer);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Type {
        FAST,
        SMALL
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum ValueWidth {
        BITS_16,
        BITS_32,
        BITS_8
    }

    private CodePointTrie(char[] cArr, Data data, int i, int i2, int i3) {
        this.ascii = new int[128];
        this.index = cArr;
        this.data = data;
        this.dataLength = data.getDataLength();
        this.highStart = i;
        this.index3NullOffset = i2;
        this.dataNullOffset = i3;
        for (int i4 = 0; i4 < 128; i4++) {
            this.ascii[i4] = data.getFromIndex(i4);
        }
        int i5 = this.dataLength;
        this.nullValue = data.getFromIndex(i3 >= i5 ? i5 - 2 : i3);
    }

    /* JADX WARN: Code duplicated, block: B:52:0x00ac A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x0004, B:5:0x000c, B:18:0x0030, B:21:0x0051, B:25:0x005e, B:29:0x0067, B:34:0x0077, B:42:0x0085, B:44:0x0099, B:45:0x009b, B:50:0x00a6, B:52:0x00ac, B:56:0x00bf, B:58:0x00c7, B:59:0x00d0, B:62:0x00dc, B:63:0x00e3, B:64:0x00e4, B:66:0x00f0, B:67:0x00f6, B:71:0x0103, B:73:0x010b, B:74:0x0111, B:77:0x011a, B:78:0x0121, B:46:0x009d, B:48:0x00a1, B:49:0x00a4, B:79:0x0122, B:80:0x0129, B:81:0x012a, B:82:0x0131, B:30:0x006a, B:31:0x0071, B:32:0x0072, B:33:0x0075, B:22:0x0054, B:23:0x005b, B:24:0x005c, B:10:0x001b, B:11:0x0022, B:14:0x0027, B:16:0x002b, B:17:0x002d, B:83:0x0132, B:84:0x0139), top: B:87:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:54:0x00bb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:55:0x00bd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:56:0x00bf A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x0004, B:5:0x000c, B:18:0x0030, B:21:0x0051, B:25:0x005e, B:29:0x0067, B:34:0x0077, B:42:0x0085, B:44:0x0099, B:45:0x009b, B:50:0x00a6, B:52:0x00ac, B:56:0x00bf, B:58:0x00c7, B:59:0x00d0, B:62:0x00dc, B:63:0x00e3, B:64:0x00e4, B:66:0x00f0, B:67:0x00f6, B:71:0x0103, B:73:0x010b, B:74:0x0111, B:77:0x011a, B:78:0x0121, B:46:0x009d, B:48:0x00a1, B:49:0x00a4, B:79:0x0122, B:80:0x0129, B:81:0x012a, B:82:0x0131, B:30:0x006a, B:31:0x0071, B:32:0x0072, B:33:0x0075, B:22:0x0054, B:23:0x005b, B:24:0x005c, B:10:0x001b, B:11:0x0022, B:14:0x0027, B:16:0x002b, B:17:0x002d, B:83:0x0132, B:84:0x0139), top: B:87:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:58:0x00c7 A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x0004, B:5:0x000c, B:18:0x0030, B:21:0x0051, B:25:0x005e, B:29:0x0067, B:34:0x0077, B:42:0x0085, B:44:0x0099, B:45:0x009b, B:50:0x00a6, B:52:0x00ac, B:56:0x00bf, B:58:0x00c7, B:59:0x00d0, B:62:0x00dc, B:63:0x00e3, B:64:0x00e4, B:66:0x00f0, B:67:0x00f6, B:71:0x0103, B:73:0x010b, B:74:0x0111, B:77:0x011a, B:78:0x0121, B:46:0x009d, B:48:0x00a1, B:49:0x00a4, B:79:0x0122, B:80:0x0129, B:81:0x012a, B:82:0x0131, B:30:0x006a, B:31:0x0071, B:32:0x0072, B:33:0x0075, B:22:0x0054, B:23:0x005b, B:24:0x005c, B:10:0x001b, B:11:0x0022, B:14:0x0027, B:16:0x002b, B:17:0x002d, B:83:0x0132, B:84:0x0139), top: B:87:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x00d0 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x0004, B:5:0x000c, B:18:0x0030, B:21:0x0051, B:25:0x005e, B:29:0x0067, B:34:0x0077, B:42:0x0085, B:44:0x0099, B:45:0x009b, B:50:0x00a6, B:52:0x00ac, B:56:0x00bf, B:58:0x00c7, B:59:0x00d0, B:62:0x00dc, B:63:0x00e3, B:64:0x00e4, B:66:0x00f0, B:67:0x00f6, B:71:0x0103, B:73:0x010b, B:74:0x0111, B:77:0x011a, B:78:0x0121, B:46:0x009d, B:48:0x00a1, B:49:0x00a4, B:79:0x0122, B:80:0x0129, B:81:0x012a, B:82:0x0131, B:30:0x006a, B:31:0x0071, B:32:0x0072, B:33:0x0075, B:22:0x0054, B:23:0x005b, B:24:0x005c, B:10:0x001b, B:11:0x0022, B:14:0x0027, B:16:0x002b, B:17:0x002d, B:83:0x0132, B:84:0x0139), top: B:87:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x00dc A[Catch: all -> 0x0023, TRY_ENTER, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x0004, B:5:0x000c, B:18:0x0030, B:21:0x0051, B:25:0x005e, B:29:0x0067, B:34:0x0077, B:42:0x0085, B:44:0x0099, B:45:0x009b, B:50:0x00a6, B:52:0x00ac, B:56:0x00bf, B:58:0x00c7, B:59:0x00d0, B:62:0x00dc, B:63:0x00e3, B:64:0x00e4, B:66:0x00f0, B:67:0x00f6, B:71:0x0103, B:73:0x010b, B:74:0x0111, B:77:0x011a, B:78:0x0121, B:46:0x009d, B:48:0x00a1, B:49:0x00a4, B:79:0x0122, B:80:0x0129, B:81:0x012a, B:82:0x0131, B:30:0x006a, B:31:0x0071, B:32:0x0072, B:33:0x0075, B:22:0x0054, B:23:0x005b, B:24:0x005c, B:10:0x001b, B:11:0x0022, B:14:0x0027, B:16:0x002b, B:17:0x002d, B:83:0x0132, B:84:0x0139), top: B:87:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x00e4 A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x0004, B:5:0x000c, B:18:0x0030, B:21:0x0051, B:25:0x005e, B:29:0x0067, B:34:0x0077, B:42:0x0085, B:44:0x0099, B:45:0x009b, B:50:0x00a6, B:52:0x00ac, B:56:0x00bf, B:58:0x00c7, B:59:0x00d0, B:62:0x00dc, B:63:0x00e3, B:64:0x00e4, B:66:0x00f0, B:67:0x00f6, B:71:0x0103, B:73:0x010b, B:74:0x0111, B:77:0x011a, B:78:0x0121, B:46:0x009d, B:48:0x00a1, B:49:0x00a4, B:79:0x0122, B:80:0x0129, B:81:0x012a, B:82:0x0131, B:30:0x006a, B:31:0x0071, B:32:0x0072, B:33:0x0075, B:22:0x0054, B:23:0x005b, B:24:0x005c, B:10:0x001b, B:11:0x0022, B:14:0x0027, B:16:0x002b, B:17:0x002d, B:83:0x0132, B:84:0x0139), top: B:87:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x00f0 A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x0004, B:5:0x000c, B:18:0x0030, B:21:0x0051, B:25:0x005e, B:29:0x0067, B:34:0x0077, B:42:0x0085, B:44:0x0099, B:45:0x009b, B:50:0x00a6, B:52:0x00ac, B:56:0x00bf, B:58:0x00c7, B:59:0x00d0, B:62:0x00dc, B:63:0x00e3, B:64:0x00e4, B:66:0x00f0, B:67:0x00f6, B:71:0x0103, B:73:0x010b, B:74:0x0111, B:77:0x011a, B:78:0x0121, B:46:0x009d, B:48:0x00a1, B:49:0x00a4, B:79:0x0122, B:80:0x0129, B:81:0x012a, B:82:0x0131, B:30:0x006a, B:31:0x0071, B:32:0x0072, B:33:0x0075, B:22:0x0054, B:23:0x005b, B:24:0x005c, B:10:0x001b, B:11:0x0022, B:14:0x0027, B:16:0x002b, B:17:0x002d, B:83:0x0132, B:84:0x0139), top: B:87:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x00f6 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x0004, B:5:0x000c, B:18:0x0030, B:21:0x0051, B:25:0x005e, B:29:0x0067, B:34:0x0077, B:42:0x0085, B:44:0x0099, B:45:0x009b, B:50:0x00a6, B:52:0x00ac, B:56:0x00bf, B:58:0x00c7, B:59:0x00d0, B:62:0x00dc, B:63:0x00e3, B:64:0x00e4, B:66:0x00f0, B:67:0x00f6, B:71:0x0103, B:73:0x010b, B:74:0x0111, B:77:0x011a, B:78:0x0121, B:46:0x009d, B:48:0x00a1, B:49:0x00a4, B:79:0x0122, B:80:0x0129, B:81:0x012a, B:82:0x0131, B:30:0x006a, B:31:0x0071, B:32:0x0072, B:33:0x0075, B:22:0x0054, B:23:0x005b, B:24:0x005c, B:10:0x001b, B:11:0x0022, B:14:0x0027, B:16:0x002b, B:17:0x002d, B:83:0x0132, B:84:0x0139), top: B:87:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:73:0x010b A[Catch: all -> 0x0023, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x0004, B:5:0x000c, B:18:0x0030, B:21:0x0051, B:25:0x005e, B:29:0x0067, B:34:0x0077, B:42:0x0085, B:44:0x0099, B:45:0x009b, B:50:0x00a6, B:52:0x00ac, B:56:0x00bf, B:58:0x00c7, B:59:0x00d0, B:62:0x00dc, B:63:0x00e3, B:64:0x00e4, B:66:0x00f0, B:67:0x00f6, B:71:0x0103, B:73:0x010b, B:74:0x0111, B:77:0x011a, B:78:0x0121, B:46:0x009d, B:48:0x00a1, B:49:0x00a4, B:79:0x0122, B:80:0x0129, B:81:0x012a, B:82:0x0131, B:30:0x006a, B:31:0x0071, B:32:0x0072, B:33:0x0075, B:22:0x0054, B:23:0x005b, B:24:0x005c, B:10:0x001b, B:11:0x0022, B:14:0x0027, B:16:0x002b, B:17:0x002d, B:83:0x0132, B:84:0x0139), top: B:87:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x0111 A[Catch: all -> 0x0023, TRY_LEAVE, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x0004, B:5:0x000c, B:18:0x0030, B:21:0x0051, B:25:0x005e, B:29:0x0067, B:34:0x0077, B:42:0x0085, B:44:0x0099, B:45:0x009b, B:50:0x00a6, B:52:0x00ac, B:56:0x00bf, B:58:0x00c7, B:59:0x00d0, B:62:0x00dc, B:63:0x00e3, B:64:0x00e4, B:66:0x00f0, B:67:0x00f6, B:71:0x0103, B:73:0x010b, B:74:0x0111, B:77:0x011a, B:78:0x0121, B:46:0x009d, B:48:0x00a1, B:49:0x00a4, B:79:0x0122, B:80:0x0129, B:81:0x012a, B:82:0x0131, B:30:0x006a, B:31:0x0071, B:32:0x0072, B:33:0x0075, B:22:0x0054, B:23:0x005b, B:24:0x005c, B:10:0x001b, B:11:0x0022, B:14:0x0027, B:16:0x002b, B:17:0x002d, B:83:0x0132, B:84:0x0139), top: B:87:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x011a A[Catch: all -> 0x0023, TRY_ENTER, TryCatch #0 {all -> 0x0023, blocks: (B:3:0x0004, B:5:0x000c, B:18:0x0030, B:21:0x0051, B:25:0x005e, B:29:0x0067, B:34:0x0077, B:42:0x0085, B:44:0x0099, B:45:0x009b, B:50:0x00a6, B:52:0x00ac, B:56:0x00bf, B:58:0x00c7, B:59:0x00d0, B:62:0x00dc, B:63:0x00e3, B:64:0x00e4, B:66:0x00f0, B:67:0x00f6, B:71:0x0103, B:73:0x010b, B:74:0x0111, B:77:0x011a, B:78:0x0121, B:46:0x009d, B:48:0x00a1, B:49:0x00a4, B:79:0x0122, B:80:0x0129, B:81:0x012a, B:82:0x0131, B:30:0x006a, B:31:0x0071, B:32:0x0072, B:33:0x0075, B:22:0x0054, B:23:0x005b, B:24:0x005c, B:10:0x001b, B:11:0x0022, B:14:0x0027, B:16:0x002b, B:17:0x002d, B:83:0x0132, B:84:0x0139), top: B:87:0x0004 }] */
    public static CodePointTrie fromBinary(Type type, ValueWidth valueWidth, ByteBuffer byteBuffer) {
        Type type2;
        ValueWidth valueWidth2;
        int i;
        int i2;
        char[] chars;
        int i3;
        char[] chars2;
        CodePointTrie small16;
        int[] ints;
        CodePointTrie small32;
        byte[] bytes;
        CodePointTrie small8;
        ByteOrder byteOrderOrder = byteBuffer.order();
        try {
            if (byteBuffer.remaining() < 16) {
                throw new ICUUncheckedIOException("Buffer too short for a CodePointTrie header");
            }
            int i4 = byteBuffer.getInt();
            if (i4 == 862548564) {
                ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
                if (byteOrderOrder == byteOrder) {
                    byteOrder = ByteOrder.LITTLE_ENDIAN;
                }
                byteBuffer.order(byteOrder);
            } else if (i4 != 1416784179) {
                throw new ICUUncheckedIOException("Buffer does not contain a serialized CodePointTrie");
            }
            char c = byteBuffer.getChar();
            char c2 = byteBuffer.getChar();
            char c3 = byteBuffer.getChar();
            char c4 = byteBuffer.getChar();
            char c5 = byteBuffer.getChar();
            char c6 = byteBuffer.getChar();
            int i5 = (c >> 6) & 3;
            if (i5 == 0) {
                type2 = Type.FAST;
            } else {
                if (i5 != 1) {
                    throw new ICUUncheckedIOException("CodePointTrie data header has an unsupported type");
                }
                type2 = Type.SMALL;
            }
            int i6 = c & 7;
            if (i6 == 0) {
                valueWidth2 = ValueWidth.BITS_16;
            } else if (i6 == 1) {
                valueWidth2 = ValueWidth.BITS_32;
            } else {
                if (i6 != 2) {
                    throw new ICUUncheckedIOException("CodePointTrie data header has an unsupported value width");
                }
                valueWidth2 = ValueWidth.BITS_8;
            }
            if ((c & '8') != 0) {
                throw new ICUUncheckedIOException("CodePointTrie data header has unsupported options");
            }
            if (type == null) {
                type = type2;
            }
            if (valueWidth == null) {
                valueWidth = valueWidth2;
            }
            if (type != type2 || valueWidth != valueWidth2) {
                throw new ICUUncheckedIOException("CodePointTrie data header has a different type or value width than required");
            }
            int i7 = c3 | ((OPTIONS_DATA_LENGTH_MASK & c) << 4);
            int i8 = ((c & 3840) << 8) | c5;
            int i9 = c6 << '\t';
            int i10 = c2 * 2;
            if (valueWidth != ValueWidth.BITS_16) {
                if (valueWidth == ValueWidth.BITS_32) {
                    i2 = i7 * 4;
                } else {
                    i = i10 + i7;
                }
                if (byteBuffer.remaining() >= i) {
                    throw new ICUUncheckedIOException("Buffer too short for the CodePointTrie data");
                }
                chars = ICUBinary.getChars(byteBuffer, c2, 0);
                i3 = AnonymousClass1.$SwitchMap$com$ibm$icu$util$CodePointTrie$ValueWidth[valueWidth.ordinal()];
                if (i3 != 1) {
                    chars2 = ICUBinary.getChars(byteBuffer, i7, 0);
                    if (type == Type.FAST) {
                        small16 = new Fast16(chars, chars2, i9, c4, i8);
                    } else {
                        small16 = new Small16(chars, chars2, i9, c4, i8);
                    }
                    byteBuffer.order(byteOrderOrder);
                    return small16;
                }
                if (i3 != 2) {
                    ints = ICUBinary.getInts(byteBuffer, i7, 0);
                    if (type == Type.FAST) {
                        small32 = new Fast32(chars, ints, i9, c4, i8);
                    } else {
                        small32 = new Small32(chars, ints, i9, c4, i8);
                    }
                    byteBuffer.order(byteOrderOrder);
                    return small32;
                }
                if (i3 == 3) {
                    throw new AssertionError("should be unreachable");
                }
                bytes = ICUBinary.getBytes(byteBuffer, i7, 0);
                if (type == Type.FAST) {
                    small8 = new Fast8(chars, bytes, i9, c4, i8);
                } else {
                    small8 = new Small8(chars, bytes, i9, c4, i8);
                }
                byteBuffer.order(byteOrderOrder);
                return small8;
            }
            i2 = i7 * 2;
            i = i2 + i10;
            if (byteBuffer.remaining() >= i) {
                throw new ICUUncheckedIOException("Buffer too short for the CodePointTrie data");
            }
            chars = ICUBinary.getChars(byteBuffer, c2, 0);
            i3 = AnonymousClass1.$SwitchMap$com$ibm$icu$util$CodePointTrie$ValueWidth[valueWidth.ordinal()];
            if (i3 != 1) {
                chars2 = ICUBinary.getChars(byteBuffer, i7, 0);
                if (type == Type.FAST) {
                    small16 = new Fast16(chars, chars2, i9, c4, i8);
                } else {
                    small16 = new Small16(chars, chars2, i9, c4, i8);
                }
                byteBuffer.order(byteOrderOrder);
                return small16;
            }
            if (i3 != 2) {
                ints = ICUBinary.getInts(byteBuffer, i7, 0);
                if (type == Type.FAST) {
                    small32 = new Fast32(chars, ints, i9, c4, i8);
                } else {
                    small32 = new Small32(chars, ints, i9, c4, i8);
                }
                byteBuffer.order(byteOrderOrder);
                return small32;
            }
            if (i3 == 3) {
                throw new AssertionError("should be unreachable");
            }
            bytes = ICUBinary.getBytes(byteBuffer, i7, 0);
            if (type == Type.FAST) {
                small8 = new Fast8(chars, bytes, i9, c4, i8);
            } else {
                small8 = new Small8(chars, bytes, i9, c4, i8);
            }
            byteBuffer.order(byteOrderOrder);
            return small8;
        } catch (Throwable th) {
            byteBuffer.order(byteOrderOrder);
            throw th;
        }
    }

    private final int internalSmallIndex(Type type, int i) {
        int i2;
        int i3 = i >> 14;
        int i4 = type == Type.FAST ? i3 + 1020 : i3 + 64;
        char[] cArr = this.index;
        char c = cArr[cArr[i4] + ((i >> 9) & 31)];
        int i5 = i >> 4;
        int i6 = i5 & 31;
        if ((32768 & c) == 0) {
            i2 = cArr[c + i6];
        } else {
            int i7 = (c & 32767) + (i5 & 24) + (i6 >> 3);
            int i8 = i5 & 7;
            i2 = cArr[i7 + 1 + i8] | ((cArr[i7] << ((i8 * 2) + 2)) & 196608);
        }
        return i2 + (i & 15);
    }

    private static final int maybeFilterValue(int i, int i2, int i3, CodePointMap.ValueFilter valueFilter) {
        if (i == i2) {
            return i3;
        }
        return valueFilter != null ? valueFilter.apply(i) : i;
    }

    public final int asciiGet(int i) {
        return this.ascii[i];
    }

    @Deprecated
    public abstract int cpIndex(int i);

    @Deprecated
    public final int fastIndex(int i) {
        return this.index[i >> 6] + (i & 63);
    }

    @Override // com.ibm.icu.util.CodePointMap
    public int get(int i) {
        return this.data.getFromIndex(cpIndex(i));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0184 A[LOOP:0: B:18:0x0040->B:100:0x0184, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:109:0x0168 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:96:0x017a  */
    /* JADX WARN: Code duplicated, block: B:97:0x017d  */
    @Override // com.ibm.icu.util.CodePointMap
    public final boolean getRange(int i, CodePointMap.ValueFilter valueFilter, CodePointMap.Range range) {
        char c;
        boolean z;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        Type type;
        if (i < 0 || 1114111 < i) {
            return false;
        }
        boolean z2 = true;
        if (i >= this.highStart) {
            int fromIndex = this.data.getFromIndex(this.dataLength - 2);
            if (valueFilter != null) {
                fromIndex = valueFilter.apply(fromIndex);
            }
            range.set(i, 1114111, fromIndex);
            return true;
        }
        int iApply = this.nullValue;
        if (valueFilter != null) {
            iApply = valueFilter.apply(iApply);
        }
        Type type2 = getType();
        int i7 = i;
        char c2 = 65535;
        boolean z3 = false;
        int iMaybeFilterValue = 0;
        int i8 = -1;
        int i9 = 0;
        while (true) {
            if (i7 > 65535 || (type2 != (type = Type.FAST) && i7 > 4095)) {
                int i10 = i7 >> 14;
                int i11 = type2 == Type.FAST ? i10 + 1020 : i10 + 64;
                char[] cArr = this.index;
                c = cArr[cArr[i11] + ((i7 >> 9) & 31)];
                if (c == c2) {
                    z = z2;
                    if (i7 - i >= 512) {
                        i7 += 512;
                        i8 = i8;
                    }
                    if (i7 >= this.highStart) {
                        if (maybeFilterValue(this.data.getFromIndex(this.dataLength - 2), this.nullValue, iApply, valueFilter) != iMaybeFilterValue) {
                            i5 = i7 - 1;
                        } else {
                            i5 = 1114111;
                        }
                        range.set(i, i5, iMaybeFilterValue);
                        return z;
                    }
                    z2 = z;
                    i8 = i8;
                } else {
                    z = z2;
                }
                if (c == this.index3NullOffset) {
                    if (!z3) {
                        i9 = this.nullValue;
                        iMaybeFilterValue = iApply;
                        z3 = z;
                    } else if (iApply != iMaybeFilterValue) {
                        range.set(i, i7 - 1, iMaybeFilterValue);
                        return z;
                    }
                    c2 = c;
                    i7 = (i7 + 512) & (-512);
                    i8 = this.dataNullOffset;
                    if (i7 >= this.highStart) {
                        if (maybeFilterValue(this.data.getFromIndex(this.dataLength - 2), this.nullValue, iApply, valueFilter) != iMaybeFilterValue) {
                            i5 = i7 - 1;
                        } else {
                            i5 = 1114111;
                        }
                        range.set(i, i5, iMaybeFilterValue);
                        return z;
                    }
                    z2 = z;
                    i8 = i8;
                } else {
                    i2 = (i7 >> 4) & 31;
                    i3 = 32;
                    i4 = 16;
                    c2 = c;
                }
            } else {
                i2 = i7 >> 6;
                i4 = 64;
                z = z2;
                i3 = type2 == type ? 1024 : 64;
                c = 0;
            }
            while (true) {
                int i12 = c & 32768;
                int i13 = i2;
                char[] cArr2 = this.index;
                if (i12 == 0) {
                    i6 = cArr2[c + i13];
                } else {
                    int i14 = (c & 32767) + (i13 & (-8)) + (i13 >> 3);
                    int i15 = i13 & 7;
                    i6 = ((cArr2[i14] << ((i15 * 2) + 2)) & 196608) | cArr2[i14 + 1 + i15];
                }
                char c3 = c;
                if (i6 != i8 || i7 - i < i4) {
                    int i16 = i4 - 1;
                    if (i6 != this.dataNullOffset) {
                        int i17 = (i7 & i16) + i6;
                        int fromIndex2 = this.data.getFromIndex(i17);
                        if (!z3) {
                            iMaybeFilterValue = maybeFilterValue(fromIndex2, this.nullValue, iApply, valueFilter);
                            i9 = fromIndex2;
                            z3 = z;
                        } else if (fromIndex2 != i9) {
                            if (valueFilter == null || maybeFilterValue(fromIndex2, this.nullValue, iApply, valueFilter) != iMaybeFilterValue) {
                                range.set(i, i7 - 1, iMaybeFilterValue);
                                return z;
                            }
                            i9 = fromIndex2;
                        }
                        while (true) {
                            int i18 = i7 + 1;
                            if ((i18 & i16) == 0) {
                                i8 = i6;
                                i7 = i18;
                                break;
                            }
                            i17++;
                            int fromIndex3 = this.data.getFromIndex(i17);
                            if (fromIndex3 != i9) {
                                if (valueFilter == null || maybeFilterValue(fromIndex3, this.nullValue, iApply, valueFilter) != iMaybeFilterValue) {
                                    range.set(i, i7, iMaybeFilterValue);
                                    return z;
                                }
                                i9 = fromIndex3;
                            }
                            i7 = i18;
                        }
                    } else {
                        if (!z3) {
                            i9 = this.nullValue;
                            iMaybeFilterValue = iApply;
                            z3 = z;
                        } else if (iApply != iMaybeFilterValue) {
                            range.set(i, i7 - 1, iMaybeFilterValue);
                            return z;
                        }
                        i7 = (~i16) & (i7 + i4);
                        i8 = i6;
                    }
                } else {
                    i7 += i4;
                    i8 = i8;
                }
                i2 = i13 + 1;
                if (i2 >= i3) {
                    break;
                }
                c = c3;
            }
            if (i7 >= this.highStart) {
                if (maybeFilterValue(this.data.getFromIndex(this.dataLength - 2), this.nullValue, iApply, valueFilter) != iMaybeFilterValue) {
                    i5 = i7 - 1;
                } else {
                    i5 = 1114111;
                }
                range.set(i, i5, iMaybeFilterValue);
                return z;
            }
            z2 = z;
            i8 = i8;
        }
    }

    public abstract Type getType();

    public final ValueWidth getValueWidth() {
        return this.data.getValueWidth();
    }

    @Deprecated
    public final int smallIndex(Type type, int i) {
        return i >= this.highStart ? this.dataLength - 2 : internalSmallIndex(type, i);
    }

    public final int toBinary(OutputStream outputStream) {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeInt(1416784179);
            dataOutputStream.writeChar(((this.dataLength & 983040) >> 4) | ((983040 & this.dataNullOffset) >> 8) | (getType().ordinal() << 6) | getValueWidth().ordinal());
            dataOutputStream.writeChar(this.index.length);
            dataOutputStream.writeChar(this.dataLength);
            dataOutputStream.writeChar(this.index3NullOffset);
            dataOutputStream.writeChar(this.dataNullOffset);
            dataOutputStream.writeChar(this.highStart >> 9);
            for (char c : this.index) {
                dataOutputStream.writeChar(c);
            }
            return (this.index.length * 2) + 16 + this.data.write(dataOutputStream);
        } catch (IOException e) {
            kf2.h(e);
            return 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class Data {
        public /* synthetic */ Data(int i) {
            this();
        }

        public abstract int getDataLength();

        public abstract int getFromIndex(int i);

        public abstract ValueWidth getValueWidth();

        public abstract int write(DataOutputStream dataOutputStream);

        private Data() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class Fast extends CodePointTrie {
        private Fast(char[] cArr, Data data, int i, int i2, int i3) {
            super(cArr, data, i, i2, i3, 0);
        }

        public static Fast fromBinary(ValueWidth valueWidth, ByteBuffer byteBuffer) {
            return (Fast) CodePointTrie.fromBinary(Type.FAST, valueWidth, byteBuffer);
        }

        public abstract int bmpGet(int i);

        @Override // com.ibm.icu.util.CodePointTrie
        @Deprecated
        public final int cpIndex(int i) {
            if (i >= 0) {
                if (i <= 65535) {
                    return fastIndex(i);
                }
                if (i <= 1114111) {
                    return smallIndex(Type.FAST, i);
                }
            }
            return this.dataLength - 1;
        }

        @Override // com.ibm.icu.util.CodePointTrie
        public final Type getType() {
            return Type.FAST;
        }

        @Override // com.ibm.icu.util.CodePointMap
        public final CodePointMap.StringIterator stringIterator(CharSequence charSequence, int i) {
            return new FastStringIterator(this, charSequence, i, 0);
        }

        public abstract int suppGet(int i);

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final class FastStringIterator extends CodePointMap.StringIterator {
            private FastStringIterator(CharSequence charSequence, int i) {
                super(charSequence, i);
            }

            /* JADX WARN: Code duplicated, block: B:16:0x005c  */
            @Override // com.ibm.icu.util.CodePointMap.StringIterator
            public boolean next() {
                int iSmallIndex;
                if (this.sIndex >= this.s.length()) {
                    return false;
                }
                CharSequence charSequence = this.s;
                int i = this.sIndex;
                this.sIndex = i + 1;
                char cCharAt = charSequence.charAt(i);
                this.c = cCharAt;
                if (!Character.isSurrogate(cCharAt)) {
                    iSmallIndex = Fast.this.fastIndex(this.c);
                } else if (!Normalizer2Impl.UTF16Plus.isSurrogateLead(cCharAt) || this.sIndex >= this.s.length()) {
                    iSmallIndex = Fast.this.dataLength - 1;
                } else {
                    char cCharAt2 = this.s.charAt(this.sIndex);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        this.sIndex++;
                        int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                        this.c = codePoint;
                        iSmallIndex = Fast.this.smallIndex(Type.FAST, codePoint);
                    } else {
                        iSmallIndex = Fast.this.dataLength - 1;
                    }
                }
                this.value = Fast.this.data.getFromIndex(iSmallIndex);
                return true;
            }

            /* JADX WARN: Code duplicated, block: B:16:0x004c  */
            @Override // com.ibm.icu.util.CodePointMap.StringIterator
            public boolean previous() {
                int iSmallIndex;
                int i;
                int i2 = this.sIndex;
                if (i2 <= 0) {
                    return false;
                }
                CharSequence charSequence = this.s;
                int i3 = i2 - 1;
                this.sIndex = i3;
                char cCharAt = charSequence.charAt(i3);
                this.c = cCharAt;
                if (!Character.isSurrogate(cCharAt)) {
                    iSmallIndex = Fast.this.fastIndex(this.c);
                } else if (Normalizer2Impl.UTF16Plus.isSurrogateLead(cCharAt) || (i = this.sIndex) <= 0) {
                    iSmallIndex = Fast.this.dataLength - 1;
                } else {
                    char cCharAt2 = this.s.charAt(i - 1);
                    if (Character.isHighSurrogate(cCharAt2)) {
                        this.sIndex--;
                        int codePoint = Character.toCodePoint(cCharAt2, cCharAt);
                        this.c = codePoint;
                        iSmallIndex = Fast.this.smallIndex(Type.FAST, codePoint);
                    } else {
                        iSmallIndex = Fast.this.dataLength - 1;
                    }
                }
                this.value = Fast.this.data.getFromIndex(iSmallIndex);
                return true;
            }

            public /* synthetic */ FastStringIterator(Fast fast, CharSequence charSequence, int i, int i2) {
                this(charSequence, i);
            }
        }

        public /* synthetic */ Fast(char[] cArr, Data data, int i, int i2, int i3, int i4) {
            this(cArr, data, i, i2, i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class Small extends CodePointTrie {
        private Small(char[] cArr, Data data, int i, int i2, int i3) {
            super(cArr, data, i, i2, i3, 0);
        }

        public static Small fromBinary(ValueWidth valueWidth, ByteBuffer byteBuffer) {
            return (Small) CodePointTrie.fromBinary(Type.SMALL, valueWidth, byteBuffer);
        }

        @Override // com.ibm.icu.util.CodePointTrie
        @Deprecated
        public final int cpIndex(int i) {
            if (i >= 0) {
                if (i <= 4095) {
                    return fastIndex(i);
                }
                if (i <= 1114111) {
                    return smallIndex(Type.SMALL, i);
                }
            }
            return this.dataLength - 1;
        }

        @Override // com.ibm.icu.util.CodePointTrie
        public final Type getType() {
            return Type.SMALL;
        }

        @Override // com.ibm.icu.util.CodePointMap
        public final CodePointMap.StringIterator stringIterator(CharSequence charSequence, int i) {
            return new SmallStringIterator(this, charSequence, i, 0);
        }

        /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
        public final class SmallStringIterator extends CodePointMap.StringIterator {
            private SmallStringIterator(CharSequence charSequence, int i) {
                super(charSequence, i);
            }

            /* JADX WARN: Code duplicated, block: B:16:0x005c  */
            @Override // com.ibm.icu.util.CodePointMap.StringIterator
            public boolean next() {
                int iSmallIndex;
                if (this.sIndex >= this.s.length()) {
                    return false;
                }
                CharSequence charSequence = this.s;
                int i = this.sIndex;
                this.sIndex = i + 1;
                char cCharAt = charSequence.charAt(i);
                this.c = cCharAt;
                if (!Character.isSurrogate(cCharAt)) {
                    iSmallIndex = Small.this.cpIndex(this.c);
                } else if (!Normalizer2Impl.UTF16Plus.isSurrogateLead(cCharAt) || this.sIndex >= this.s.length()) {
                    iSmallIndex = Small.this.dataLength - 1;
                } else {
                    char cCharAt2 = this.s.charAt(this.sIndex);
                    if (Character.isLowSurrogate(cCharAt2)) {
                        this.sIndex++;
                        int codePoint = Character.toCodePoint(cCharAt, cCharAt2);
                        this.c = codePoint;
                        iSmallIndex = Small.this.smallIndex(Type.SMALL, codePoint);
                    } else {
                        iSmallIndex = Small.this.dataLength - 1;
                    }
                }
                this.value = Small.this.data.getFromIndex(iSmallIndex);
                return true;
            }

            /* JADX WARN: Code duplicated, block: B:16:0x004c  */
            @Override // com.ibm.icu.util.CodePointMap.StringIterator
            public boolean previous() {
                int iSmallIndex;
                int i;
                int i2 = this.sIndex;
                if (i2 <= 0) {
                    return false;
                }
                CharSequence charSequence = this.s;
                int i3 = i2 - 1;
                this.sIndex = i3;
                char cCharAt = charSequence.charAt(i3);
                this.c = cCharAt;
                if (!Character.isSurrogate(cCharAt)) {
                    iSmallIndex = Small.this.cpIndex(this.c);
                } else if (Normalizer2Impl.UTF16Plus.isSurrogateLead(cCharAt) || (i = this.sIndex) <= 0) {
                    iSmallIndex = Small.this.dataLength - 1;
                } else {
                    char cCharAt2 = this.s.charAt(i - 1);
                    if (Character.isHighSurrogate(cCharAt2)) {
                        this.sIndex--;
                        int codePoint = Character.toCodePoint(cCharAt2, cCharAt);
                        this.c = codePoint;
                        iSmallIndex = Small.this.smallIndex(Type.SMALL, codePoint);
                    } else {
                        iSmallIndex = Small.this.dataLength - 1;
                    }
                }
                this.value = Small.this.data.getFromIndex(iSmallIndex);
                return true;
            }

            public /* synthetic */ SmallStringIterator(Small small, CharSequence charSequence, int i, int i2) {
                this(charSequence, i);
            }
        }

        public /* synthetic */ Small(char[] cArr, Data data, int i, int i2, int i3, int i4) {
            this(cArr, data, i, i2, i3);
        }
    }

    public /* synthetic */ CodePointTrie(char[] cArr, Data data, int i, int i2, int i3, int i4) {
        this(cArr, data, i, i2, i3);
    }
}
