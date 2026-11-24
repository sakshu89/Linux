package com.ibm.icu.impl;

import com.ibm.icu.impl.locale.BaseLocale;
import com.ibm.icu.lang.UCharacterEnums;
import com.ibm.icu.util.ICUUncheckedIOException;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceTypeMismatchException;
import com.ibm.icu.util.VersionInfo;
import defpackage.cq;
import defpackage.ky0;
import defpackage.og;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.IntBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BiFunction;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ICUResourceBundleReader {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final ReaderCache CACHE;
    private static final int DATA_FORMAT = 1382380354;
    private static final boolean DEBUG = false;
    private static final String ICU_RESOURCE_SUFFIX = ".res";
    private static final IsAcceptable IS_ACCEPTABLE;
    static final int LARGE_SIZE = 24;
    private static final int URES_ATT_IS_POOL_BUNDLE = 2;
    private static final int URES_ATT_NO_FALLBACK = 1;
    private static final int URES_ATT_USES_POOL_BUNDLE = 4;
    private static final int URES_INDEX_16BIT_TOP = 6;
    private static final int URES_INDEX_ATTRIBUTES = 5;
    private static final int URES_INDEX_BUNDLE_TOP = 3;
    private static final int URES_INDEX_KEYS_TOP = 1;
    private static final int URES_INDEX_LENGTH = 0;
    private static final int URES_INDEX_MAX_TABLE_LENGTH = 4;
    private static final int URES_INDEX_POOL_CHECKSUM = 7;
    private static final String emptyString = "";
    private CharBuffer b16BitUnits;
    private ByteBuffer bytes;
    private int dataVersion;
    private boolean isPoolBundle;
    private byte[] keyBytes;
    private int localKeyLimit;
    private boolean noFallback;
    private ICUResourceBundleReader poolBundleReader;
    private int poolCheckSum;
    private int poolStringIndex16Limit;
    private int poolStringIndexLimit;
    private ResourceCache resourceCache;
    private int rootRes;
    private boolean usesPoolBundle;
    private static final CharBuffer EMPTY_16_BIT_UNITS = CharBuffer.wrap("\u0000");
    private static final ICUResourceBundleReader NULL_READER = new ICUResourceBundleReader();
    private static final byte[] emptyBytes = new byte[0];
    private static final ByteBuffer emptyByteBuffer = ByteBuffer.allocate(0).asReadOnlyBuffer();
    private static final char[] emptyChars = new char[0];
    private static final int[] emptyInts = new int[0];
    private static final Array EMPTY_ARRAY = new Array();
    private static final Table EMPTY_TABLE = new Table();
    private static int[] PUBLIC_TYPES = {0, 1, 2, 3, 2, 2, 0, 7, 8, 8, -1, -1, -1, -1, 14, -1};

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Array extends Container implements UResource.Array {
        @Override // com.ibm.icu.impl.UResource.Array
        public boolean getValue(int i, UResource.Value value) {
            if (i < 0 || i >= this.size) {
                return false;
            }
            ReaderValue readerValue = (ReaderValue) value;
            readerValue.res = getContainerResource(readerValue.reader, i);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Array16 extends Array {
        public Array16(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            this.size = iCUResourceBundleReader.b16BitUnits.charAt(i);
            this.itemsOffset = i + 1;
        }

        @Override // com.ibm.icu.impl.ICUResourceBundleReader.Container
        public int getContainerResource(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            return getContainer16Resource(iCUResourceBundleReader, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Array32 extends Array {
        public Array32(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            int resourceByteOffset = iCUResourceBundleReader.getResourceByteOffset(i);
            this.size = iCUResourceBundleReader.getInt(resourceByteOffset);
            this.itemsOffset = resourceByteOffset + 4;
        }

        @Override // com.ibm.icu.impl.ICUResourceBundleReader.Container
        public int getContainerResource(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            return getContainer32Resource(iCUResourceBundleReader, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Container {
        protected int itemsOffset;
        protected int size;

        public int getContainer16Resource(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            if (i < 0 || this.size <= i) {
                return -1;
            }
            int iCharAt = iCUResourceBundleReader.b16BitUnits.charAt(this.itemsOffset + i);
            if (iCharAt >= iCUResourceBundleReader.poolStringIndex16Limit) {
                iCharAt = (iCharAt - iCUResourceBundleReader.poolStringIndex16Limit) + iCUResourceBundleReader.poolStringIndexLimit;
            }
            return iCharAt | 1610612736;
        }

        public int getContainer32Resource(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            if (i < 0 || this.size <= i) {
                return -1;
            }
            return iCUResourceBundleReader.getInt((i * 4) + this.itemsOffset);
        }

        public int getContainerResource(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            return -1;
        }

        public int getResource(ICUResourceBundleReader iCUResourceBundleReader, String str) {
            return getContainerResource(iCUResourceBundleReader, Integer.parseInt(str));
        }

        public final int getSize() {
            return this.size;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ReaderCacheKey {
        final String baseName;
        final String localeID;

        public ReaderCacheKey(String str, String str2) {
            this.baseName = str == null ? ICUResourceBundleReader.emptyString : str;
            this.localeID = str2 == null ? ICUResourceBundleReader.emptyString : str2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ReaderCacheKey)) {
                return false;
            }
            ReaderCacheKey readerCacheKey = (ReaderCacheKey) obj;
            return this.baseName.equals(readerCacheKey.baseName) && this.localeID.equals(readerCacheKey.localeID);
        }

        public int hashCode() {
            return this.localeID.hashCode() ^ this.baseName.hashCode();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ResourceCache {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final ConcurrentHashMap<Integer, Object> map = new ConcurrentHashMap<>();

        private static Object deduplicateItem(Object obj, Map<CharBuffer, char[]> map, Map<IntBuffer, int[]> map2, Map<String, String> map3) {
            int[] iArrPutIfAbsent;
            char[] cArrPutIfAbsent;
            boolean z = obj instanceof SoftReference;
            Object obj2 = z ? ((SoftReference) obj).get() : obj;
            if (obj2 instanceof Table) {
                Table table = (Table) obj2;
                char[] cArr = table.keyOffsets;
                if (cArr != null && (cArrPutIfAbsent = map.putIfAbsent(CharBuffer.wrap(cArr), table.keyOffsets)) != null) {
                    table.keyOffsets = cArrPutIfAbsent;
                }
                int[] iArr = table.key32Offsets;
                if (iArr != null && (iArrPutIfAbsent = map2.putIfAbsent(IntBuffer.wrap(iArr), table.key32Offsets)) != null) {
                    table.key32Offsets = iArrPutIfAbsent;
                    return obj;
                }
            } else if (obj2 instanceof String) {
                String str = (String) obj2;
                String strPutIfAbsent = map3.putIfAbsent(str, str);
                if (strPutIfAbsent != null) {
                    obj2 = strPutIfAbsent;
                }
                return z ? new SoftReference(obj2) : obj2;
            }
            return obj;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Object lambda$putIfAbsent$0(Object[] objArr, Object obj, int i, Integer num, Object obj2) {
            if (obj2 != null) {
                Object obj3 = obj2 instanceof SoftReference ? ((SoftReference) obj2).get() : obj2;
                if (obj3 != null) {
                    objArr[0] = obj3;
                    return obj2;
                }
            }
            objArr[0] = obj;
            return storeDirectly(i) ? obj : new SoftReference(obj);
        }

        private static boolean storeDirectly(int i) {
            return i < 24 || CacheValue.futureInstancesWillBeStrong();
        }

        public synchronized void deduplicateTableArrays() {
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            for (Map.Entry<Integer, Object> entry : this.map.entrySet()) {
                entry.setValue(deduplicateItem(entry.getValue(), map, map2, map3));
            }
        }

        public Object get(int i) {
            Integer numValueOf = Integer.valueOf(i);
            Object obj = this.map.get(numValueOf);
            if (obj == null) {
                return null;
            }
            if (!(obj instanceof SoftReference)) {
                return obj;
            }
            Object obj2 = ((SoftReference) obj).get();
            if (obj2 == null) {
                this.map.remove(numValueOf, obj);
            }
            return obj2;
        }

        public Object putIfAbsent(int i, final Object obj, final int i2) {
            final Object[] objArr = {obj};
            this.map.compute(Integer.valueOf(i), new BiFunction() { // from class: com.ibm.icu.impl.a
                @Override // java.util.function.BiFunction
                public final Object apply(Object obj2, Object obj3) {
                    return ICUResourceBundleReader.ResourceCache.lambda$putIfAbsent$0(objArr, obj, i2, (Integer) obj2, obj3);
                }
            });
            return objArr[0];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class Table extends Container implements UResource.Table {
        private static final int URESDATA_ITEM_NOT_FOUND = -1;
        protected int[] key32Offsets;
        protected char[] keyOffsets;

        public int findTableItem(ICUResourceBundleReader iCUResourceBundleReader, CharSequence charSequence) {
            int i = this.size;
            int i2 = 0;
            while (i2 < i) {
                int i3 = (i2 + i) >>> 1;
                char[] cArr = this.keyOffsets;
                int iCompareKeys = cArr != null ? iCUResourceBundleReader.compareKeys(charSequence, cArr[i3]) : iCUResourceBundleReader.compareKeys32(charSequence, this.key32Offsets[i3]);
                if (iCompareKeys < 0) {
                    i = i3;
                } else {
                    if (iCompareKeys <= 0) {
                        return i3;
                    }
                    i2 = i3 + 1;
                }
            }
            return -1;
        }

        @Override // com.ibm.icu.impl.UResource.Table
        public boolean findValue(CharSequence charSequence, UResource.Value value) {
            ReaderValue readerValue = (ReaderValue) value;
            int iFindTableItem = findTableItem(readerValue.reader, charSequence);
            if (iFindTableItem < 0) {
                return false;
            }
            readerValue.res = getContainerResource(readerValue.reader, iFindTableItem);
            return true;
        }

        public String getKey(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            if (i < 0 || this.size <= i) {
                return null;
            }
            char[] cArr = this.keyOffsets;
            return cArr != null ? iCUResourceBundleReader.getKey16String(cArr[i]) : iCUResourceBundleReader.getKey32String(this.key32Offsets[i]);
        }

        @Override // com.ibm.icu.impl.UResource.Table
        public boolean getKeyAndValue(int i, UResource.Key key, UResource.Value value) {
            if (i < 0 || i >= this.size) {
                return false;
            }
            ReaderValue readerValue = (ReaderValue) value;
            char[] cArr = this.keyOffsets;
            if (cArr != null) {
                readerValue.reader.setKeyFromKey16(cArr[i], key);
            } else {
                readerValue.reader.setKeyFromKey32(this.key32Offsets[i], key);
            }
            readerValue.res = getContainerResource(readerValue.reader, i);
            return true;
        }

        @Override // com.ibm.icu.impl.ICUResourceBundleReader.Container
        public int getResource(ICUResourceBundleReader iCUResourceBundleReader, String str) {
            return getContainerResource(iCUResourceBundleReader, findTableItem(iCUResourceBundleReader, str));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Table16 extends Table {
        public Table16(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            char[] table16KeyOffsets = iCUResourceBundleReader.getTable16KeyOffsets(i);
            this.keyOffsets = table16KeyOffsets;
            int length = table16KeyOffsets.length;
            this.size = length;
            this.itemsOffset = i + 1 + length;
        }

        @Override // com.ibm.icu.impl.ICUResourceBundleReader.Container
        public int getContainerResource(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            return getContainer16Resource(iCUResourceBundleReader, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Table1632 extends Table {
        public Table1632(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            int resourceByteOffset = iCUResourceBundleReader.getResourceByteOffset(i);
            char[] tableKeyOffsets = iCUResourceBundleReader.getTableKeyOffsets(resourceByteOffset);
            this.keyOffsets = tableKeyOffsets;
            int length = tableKeyOffsets.length;
            this.size = length;
            this.itemsOffset = (((length + 2) & (-2)) * 2) + resourceByteOffset;
        }

        @Override // com.ibm.icu.impl.ICUResourceBundleReader.Container
        public int getContainerResource(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            return getContainer32Resource(iCUResourceBundleReader, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Table32 extends Table {
        public Table32(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            int resourceByteOffset = iCUResourceBundleReader.getResourceByteOffset(i);
            int[] table32KeyOffsets = iCUResourceBundleReader.getTable32KeyOffsets(resourceByteOffset);
            this.key32Offsets = table32KeyOffsets;
            int length = table32KeyOffsets.length;
            this.size = length;
            this.itemsOffset = ((length + 1) * 4) + resourceByteOffset;
        }

        @Override // com.ibm.icu.impl.ICUResourceBundleReader.Container
        public int getContainerResource(ICUResourceBundleReader iCUResourceBundleReader, int i) {
            return getContainer32Resource(iCUResourceBundleReader, i);
        }
    }

    static {
        int i = 0;
        IS_ACCEPTABLE = new IsAcceptable(i);
        CACHE = new ReaderCache(i);
    }

    private ICUResourceBundleReader(ByteBuffer byteBuffer, String str, String str2, ClassLoader classLoader) {
        init(byteBuffer);
        if (this.usesPoolBundle) {
            ICUResourceBundleReader reader = getReader(str, "pool", classLoader);
            this.poolBundleReader = reader;
            if (reader == null || !reader.isPoolBundle) {
                og.n("pool.res is not a pool bundle");
                throw null;
            }
            if (reader.poolCheckSum == this.poolCheckSum) {
                return;
            }
            og.n("pool.res has a different checksum than this bundle");
            throw null;
        }
    }

    public static int RES_GET_INT(int i) {
        return (i << 4) >> 4;
    }

    private static int RES_GET_OFFSET(int i) {
        return i & 268435455;
    }

    public static int RES_GET_TYPE(int i) {
        return i >>> 28;
    }

    public static int RES_GET_UINT(int i) {
        return i & 268435455;
    }

    public static boolean URES_IS_ARRAY(int i) {
        return i == 8 || i == 9;
    }

    public static boolean URES_IS_TABLE(int i) {
        return i == 2 || i == 5 || i == 4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int compareKeys(CharSequence charSequence, char c) {
        int i = this.localKeyLimit;
        return c < i ? ICUBinary.compareKeys(charSequence, this.keyBytes, c) : ICUBinary.compareKeys(charSequence, this.poolBundleReader.keyBytes, c - i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int compareKeys32(CharSequence charSequence, int i) {
        return i >= 0 ? ICUBinary.compareKeys(charSequence, this.keyBytes, i) : ICUBinary.compareKeys(charSequence, this.poolBundleReader.keyBytes, i & Integer.MAX_VALUE);
    }

    public static void deduplicateTableArrays() {
        ResourceCache resourceCache;
        for (Object obj : CACHE.getMap().values()) {
            ICUResourceBundleReader iCUResourceBundleReader = null;
            if (obj instanceof CacheValue) {
                CacheValue cacheValue = (CacheValue) obj;
                if (!cacheValue.isNull()) {
                    iCUResourceBundleReader = (ICUResourceBundleReader) cacheValue.get();
                }
            } else if (obj instanceof ICUResourceBundleReader) {
                iCUResourceBundleReader = (ICUResourceBundleReader) obj;
            }
            if (iCUResourceBundleReader != null && (resourceCache = iCUResourceBundleReader.resourceCache) != null) {
                resourceCache.deduplicateTableArrays();
            }
        }
    }

    private char[] getChars(int i, int i2) {
        char[] cArr = new char[i2];
        if (i2 > 16) {
            CharBuffer charBufferAsCharBuffer = this.bytes.asCharBuffer();
            charBufferAsCharBuffer.get(cArr);
            return cArr;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            cArr[i3] = this.bytes.getChar(i);
            i += 2;
        }
        return cArr;
    }

    public static String getFullName(String str, String str2) {
        if (str == null || str.length() == 0) {
            return str2.length() == 0 ? ULocale.getDefault().toString() : str2.concat(ICU_RESOURCE_SUFFIX);
        }
        if (str.indexOf(46) == -1) {
            return str.charAt(str.length() + (-1)) != '/' ? ky0.k(str, "/", str2, ICU_RESOURCE_SUFFIX) : cq.k(str, str2, ICU_RESOURCE_SUFFIX);
        }
        String strReplace = str.replace('.', '/');
        return str2.length() == 0 ? ky0.j(strReplace, ICU_RESOURCE_SUFFIX) : ky0.k(strReplace, BaseLocale.SEP, str2, ICU_RESOURCE_SUFFIX);
    }

    private int getIndexesInt(int i) {
        return this.bytes.getInt((i + 1) << 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getInt(int i) {
        return this.bytes.getInt(i);
    }

    private int[] getInts(int i, int i2) {
        int[] iArr = new int[i2];
        if (i2 > 16) {
            IntBuffer intBufferAsIntBuffer = this.bytes.asIntBuffer();
            intBufferAsIntBuffer.get(iArr);
            return iArr;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            iArr[i3] = this.bytes.getInt(i);
            i += 4;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getKey16String(int i) {
        int i2 = this.localKeyLimit;
        return i < i2 ? makeKeyStringFromBytes(this.keyBytes, i) : makeKeyStringFromBytes(this.poolBundleReader.keyBytes, i - i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getKey32String(int i) {
        return i >= 0 ? makeKeyStringFromBytes(this.keyBytes, i) : makeKeyStringFromBytes(this.poolBundleReader.keyBytes, i & Integer.MAX_VALUE);
    }

    public static ICUResourceBundleReader getReader(String str, String str2, ClassLoader classLoader) {
        ICUResourceBundleReader softCache = CACHE.getInstance(new ReaderCacheKey(str, str2), classLoader);
        if (softCache == NULL_READER) {
            return null;
        }
        return softCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getResourceByteOffset(int i) {
        return i << 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public char[] getTable16KeyOffsets(int i) {
        int i2 = i + 1;
        int iCharAt = this.b16BitUnits.charAt(i);
        if (iCharAt <= 0) {
            return emptyChars;
        }
        char[] cArr = new char[iCharAt];
        if (iCharAt > 16) {
            CharBuffer charBufferDuplicate = this.b16BitUnits.duplicate();
            charBufferDuplicate.get(cArr);
            return cArr;
        }
        int i3 = 0;
        while (i3 < iCharAt) {
            cArr[i3] = this.b16BitUnits.charAt(i2);
            i3++;
            i2++;
        }
        return cArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int[] getTable32KeyOffsets(int i) {
        int i2 = getInt(i);
        return i2 > 0 ? getInts(i + 4, i2) : emptyInts;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public char[] getTableKeyOffsets(int i) {
        char c = this.bytes.getChar(i);
        return c > 0 ? getChars(i + 2, c) : emptyChars;
    }

    private void init(ByteBuffer byteBuffer) {
        int indexesInt;
        this.dataVersion = ICUBinary.readHeader(byteBuffer, DATA_FORMAT, IS_ACCEPTABLE);
        byte b = byteBuffer.get(16);
        ByteBuffer byteBufferSliceWithOrder = ICUBinary.sliceWithOrder(byteBuffer);
        this.bytes = byteBufferSliceWithOrder;
        int iRemaining = byteBufferSliceWithOrder.remaining();
        this.rootRes = this.bytes.getInt(0);
        int indexesInt2 = getIndexesInt(0);
        int i = indexesInt2 & 255;
        if (i <= 4) {
            og.q("not enough indexes");
            return;
        }
        int i2 = i + 1;
        int i3 = i2 << 2;
        if (iRemaining < i3 || iRemaining < (getIndexesInt(3) << 2)) {
            og.q("not enough bytes");
            return;
        }
        if (b >= 3) {
            this.poolStringIndexLimit = indexesInt2 >>> 8;
        }
        if (i > 5) {
            int indexesInt3 = getIndexesInt(5);
            this.noFallback = (indexesInt3 & 1) != 0;
            this.isPoolBundle = (indexesInt3 & 2) != 0;
            this.usesPoolBundle = (indexesInt3 & 4) != 0;
            this.poolStringIndexLimit |= (61440 & indexesInt3) << 12;
            this.poolStringIndex16Limit = indexesInt3 >>> 16;
        }
        int indexesInt4 = getIndexesInt(1);
        if (indexesInt4 > i2) {
            if (this.isPoolBundle) {
                this.keyBytes = new byte[(indexesInt4 - i2) << 2];
            } else {
                int i4 = indexesInt4 << 2;
                this.localKeyLimit = i4;
                this.keyBytes = new byte[i4];
            }
            this.bytes.get(this.keyBytes);
        }
        if (i <= 6 || (indexesInt = getIndexesInt(6)) <= indexesInt4) {
            this.b16BitUnits = EMPTY_16_BIT_UNITS;
        } else {
            int i5 = (indexesInt - indexesInt4) * 2;
            CharBuffer charBufferAsCharBuffer = this.bytes.asCharBuffer();
            this.b16BitUnits = charBufferAsCharBuffer;
        }
        if (i > 7) {
            this.poolCheckSum = getIndexesInt(7);
        }
        if (!this.isPoolBundle || this.b16BitUnits.length() > 1) {
            this.resourceCache = new ResourceCache();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isNoInheritanceMarker(int i) {
        int iRES_GET_OFFSET = RES_GET_OFFSET(i);
        if (iRES_GET_OFFSET != 0) {
            if (i == iRES_GET_OFFSET) {
                int resourceByteOffset = getResourceByteOffset(iRES_GET_OFFSET);
                return getInt(resourceByteOffset) == 3 && this.bytes.getChar(resourceByteOffset + 4) == 8709 && this.bytes.getChar(resourceByteOffset + 6) == 8709 && this.bytes.getChar(resourceByteOffset + 8) == 8709;
            }
            if (RES_GET_TYPE(i) == 6) {
                int i2 = this.poolStringIndexLimit;
                return iRES_GET_OFFSET < i2 ? this.poolBundleReader.isStringV2NoInheritanceMarker(iRES_GET_OFFSET) : isStringV2NoInheritanceMarker(iRES_GET_OFFSET - i2);
            }
        }
        return false;
    }

    private boolean isStringV2NoInheritanceMarker(int i) {
        char cCharAt = this.b16BitUnits.charAt(i);
        if (cCharAt == 8709) {
            return this.b16BitUnits.charAt(i + 1) == 8709 && this.b16BitUnits.charAt(i + 2) == 8709 && this.b16BitUnits.charAt(i + 3) == 0;
        }
        return cCharAt == 56323 && this.b16BitUnits.charAt(i + 1) == 8709 && this.b16BitUnits.charAt(i + 2) == 8709 && this.b16BitUnits.charAt(i + 3) == 8709;
    }

    private static String makeKeyStringFromBytes(byte[] bArr, int i) {
        int i2 = i;
        while (bArr[i2] != 0) {
            i2++;
        }
        return new String(bArr, i, i2 - i, StandardCharsets.ISO_8859_1);
    }

    private String makeStringFromBytes(int i, int i2) {
        if (i2 > 16) {
            int i3 = i / 2;
            return this.bytes.asCharBuffer().subSequence(i3, i2 + i3).toString();
        }
        StringBuilder sb = new StringBuilder(i2);
        for (int i4 = 0; i4 < i2; i4++) {
            sb.append(this.bytes.getChar(i));
            i += 2;
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyFromKey16(int i, UResource.Key key) {
        int i2 = this.localKeyLimit;
        if (i < i2) {
            key.setBytes(this.keyBytes, i);
        } else {
            key.setBytes(this.poolBundleReader.keyBytes, i - i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setKeyFromKey32(int i, UResource.Key key) {
        if (i >= 0) {
            key.setBytes(this.keyBytes, i);
        } else {
            key.setBytes(this.poolBundleReader.keyBytes, i & Integer.MAX_VALUE);
        }
    }

    public String getAlias(int i) {
        int iRES_GET_OFFSET = RES_GET_OFFSET(i);
        if (RES_GET_TYPE(i) != 3) {
            return null;
        }
        if (iRES_GET_OFFSET == 0) {
            return emptyString;
        }
        Object obj = this.resourceCache.get(i);
        if (obj != null) {
            return (String) obj;
        }
        int resourceByteOffset = getResourceByteOffset(iRES_GET_OFFSET);
        int i2 = getInt(resourceByteOffset);
        return (String) this.resourceCache.putIfAbsent(i, makeStringFromBytes(resourceByteOffset + 4, i2), i2 * 2);
    }

    public Array getArray(int i) {
        int iRES_GET_TYPE = RES_GET_TYPE(i);
        if (!URES_IS_ARRAY(iRES_GET_TYPE)) {
            return null;
        }
        int iRES_GET_OFFSET = RES_GET_OFFSET(i);
        if (iRES_GET_OFFSET == 0) {
            return EMPTY_ARRAY;
        }
        Object obj = this.resourceCache.get(i);
        if (obj != null) {
            return (Array) obj;
        }
        return (Array) this.resourceCache.putIfAbsent(i, iRES_GET_TYPE == 8 ? new Array32(this, iRES_GET_OFFSET) : new Array16(this, iRES_GET_OFFSET), 0);
    }

    public byte[] getBinary(int i, byte[] bArr) {
        int iRES_GET_OFFSET = RES_GET_OFFSET(i);
        if (RES_GET_TYPE(i) != 1) {
            return null;
        }
        if (iRES_GET_OFFSET == 0) {
            return emptyBytes;
        }
        int resourceByteOffset = getResourceByteOffset(iRES_GET_OFFSET);
        int i2 = getInt(resourceByteOffset);
        if (i2 == 0) {
            return emptyBytes;
        }
        if (bArr == null || bArr.length != i2) {
            bArr = new byte[i2];
        }
        int i3 = resourceByteOffset + 4;
        if (i2 > 16) {
            ByteBuffer byteBufferDuplicate = this.bytes.duplicate();
            byteBufferDuplicate.get(bArr);
            return bArr;
        }
        int i4 = 0;
        while (i4 < i2) {
            bArr[i4] = this.bytes.get(i3);
            i4++;
            i3++;
        }
        return bArr;
    }

    public int[] getIntVector(int i) {
        int iRES_GET_OFFSET = RES_GET_OFFSET(i);
        if (RES_GET_TYPE(i) != 14) {
            return null;
        }
        if (iRES_GET_OFFSET == 0) {
            return emptyInts;
        }
        int resourceByteOffset = getResourceByteOffset(iRES_GET_OFFSET);
        return getInts(resourceByteOffset + 4, getInt(resourceByteOffset));
    }

    public boolean getNoFallback() {
        return this.noFallback;
    }

    public int getRootResource() {
        return this.rootRes;
    }

    public String getString(int i) {
        int iRES_GET_OFFSET = RES_GET_OFFSET(i);
        if (i != iRES_GET_OFFSET && RES_GET_TYPE(i) != 6) {
            return null;
        }
        if (iRES_GET_OFFSET == 0) {
            return emptyString;
        }
        if (i != iRES_GET_OFFSET) {
            int i2 = this.poolStringIndexLimit;
            return iRES_GET_OFFSET < i2 ? this.poolBundleReader.getStringV2(i) : getStringV2(i - i2);
        }
        Object obj = this.resourceCache.get(i);
        if (obj != null) {
            return (String) obj;
        }
        int resourceByteOffset = getResourceByteOffset(iRES_GET_OFFSET);
        String strMakeStringFromBytes = makeStringFromBytes(resourceByteOffset + 4, getInt(resourceByteOffset));
        return (String) this.resourceCache.putIfAbsent(i, strMakeStringFromBytes, strMakeStringFromBytes.length() * 2);
    }

    public String getStringV2(int i) {
        int iCharAt;
        int i2;
        String string;
        int iRES_GET_OFFSET = RES_GET_OFFSET(i);
        Object obj = this.resourceCache.get(i);
        if (obj != null) {
            return (String) obj;
        }
        char cCharAt = this.b16BitUnits.charAt(iRES_GET_OFFSET);
        if ((cCharAt & 64512) == 56320) {
            if (cCharAt < 57327) {
                iCharAt = cCharAt & 1023;
                i2 = iRES_GET_OFFSET + 1;
            } else {
                CharBuffer charBuffer = this.b16BitUnits;
                if (cCharAt < 57343) {
                    iCharAt = ((cCharAt - 57327) << 16) | charBuffer.charAt(iRES_GET_OFFSET + 1);
                    i2 = iRES_GET_OFFSET + 2;
                } else {
                    iCharAt = (charBuffer.charAt(iRES_GET_OFFSET + 1) << 16) | this.b16BitUnits.charAt(iRES_GET_OFFSET + 2);
                    i2 = iRES_GET_OFFSET + 3;
                }
            }
            string = this.b16BitUnits.subSequence(i2, iCharAt + i2).toString();
        } else {
            if (cCharAt == 0) {
                return emptyString;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(cCharAt);
            while (true) {
                iRES_GET_OFFSET++;
                char cCharAt2 = this.b16BitUnits.charAt(iRES_GET_OFFSET);
                if (cCharAt2 == 0) {
                    break;
                }
                sb.append(cCharAt2);
            }
            string = sb.toString();
        }
        return (String) this.resourceCache.putIfAbsent(i, string, string.length() * 2);
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
    public Table getTable(int i) {
        Container table32;
        int size;
        int size2;
        int iRES_GET_TYPE = RES_GET_TYPE(i);
        if (!URES_IS_TABLE(iRES_GET_TYPE)) {
            return null;
        }
        int iRES_GET_OFFSET = RES_GET_OFFSET(i);
        if (iRES_GET_OFFSET == 0) {
            return EMPTY_TABLE;
        }
        Object obj = this.resourceCache.get(i);
        if (obj != null) {
            return (Table) obj;
        }
        if (iRES_GET_TYPE != 2) {
            if (iRES_GET_TYPE == 5) {
                table32 = new Table16(this, iRES_GET_OFFSET);
                size2 = table32.getSize();
            } else {
                table32 = new Table32(this, iRES_GET_OFFSET);
                size = table32.getSize() * 4;
            }
            return (Table) this.resourceCache.putIfAbsent(i, table32, size);
        }
        table32 = new Table1632(this, iRES_GET_OFFSET);
        size2 = table32.getSize();
        size = size2 * 2;
        return (Table) this.resourceCache.putIfAbsent(i, table32, size);
    }

    public boolean getUsesPoolBundle() {
        return this.usesPoolBundle;
    }

    public VersionInfo getVersion() {
        return ICUBinary.getVersionInfoFromCompactInt(this.dataVersion);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class IsAcceptable implements ICUBinary.Authenticate {
        public /* synthetic */ IsAcceptable(int i) {
            this();
        }

        @Override // com.ibm.icu.impl.ICUBinary.Authenticate
        public boolean isDataVersionAcceptable(byte[] bArr) {
            byte b = bArr[0];
            return (b == 1 && (bArr[1] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) >= 1) || (2 <= b && b <= 3);
        }

        private IsAcceptable() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ReaderCache extends SoftCache<ReaderCacheKey, ICUResourceBundleReader, ClassLoader> {
        public /* synthetic */ ReaderCache(int i) {
            this();
        }

        @Override // com.ibm.icu.impl.CacheBase
        public ICUResourceBundleReader createInstance(ReaderCacheKey readerCacheKey, ClassLoader classLoader) {
            ByteBuffer byteBufferFromInputStreamAndCloseStream;
            String fullName = ICUResourceBundleReader.getFullName(readerCacheKey.baseName, readerCacheKey.localeID);
            try {
                String str = readerCacheKey.baseName;
                if (str == null || !str.startsWith(ICUData.ICU_BASE_NAME)) {
                    InputStream stream = ICUData.getStream(classLoader, fullName);
                    if (stream == null) {
                        return ICUResourceBundleReader.NULL_READER;
                    }
                    byteBufferFromInputStreamAndCloseStream = ICUBinary.getByteBufferFromInputStreamAndCloseStream(stream);
                } else {
                    byteBufferFromInputStreamAndCloseStream = ICUBinary.getData(classLoader, fullName, fullName.substring(30));
                    if (byteBufferFromInputStreamAndCloseStream == null) {
                        return ICUResourceBundleReader.NULL_READER;
                    }
                }
                return new ICUResourceBundleReader(byteBufferFromInputStreamAndCloseStream, readerCacheKey.baseName, readerCacheKey.localeID, classLoader, 0);
            } catch (IOException e) {
                throw new ICUUncheckedIOException(cq.l("Data file ", fullName, " is corrupt - ", e.getMessage()), e);
            }
        }

        private ReaderCache() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ReaderValue extends UResource.Value {
        ICUResourceBundleReader reader;
        int res;

        private String[] getStringArray(Array array) {
            String[] strArr = new String[array.size];
            for (int i = 0; i < array.size; i++) {
                String string = this.reader.getString(array.getContainerResource(this.reader, i));
                if (string == null) {
                    throw new UResourceTypeMismatchException(ICUResourceBundleReader.emptyString);
                }
                strArr[i] = string;
            }
            return strArr;
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public String getAliasString() {
            String alias = this.reader.getAlias(this.res);
            if (alias != null) {
                return alias;
            }
            throw new UResourceTypeMismatchException(ICUResourceBundleReader.emptyString);
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public UResource.Array getArray() {
            Array array = this.reader.getArray(this.res);
            if (array != null) {
                return array;
            }
            throw new UResourceTypeMismatchException(ICUResourceBundleReader.emptyString);
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public ByteBuffer getBinary() {
            ByteBuffer binary = this.reader.getBinary(this.res);
            if (binary != null) {
                return binary;
            }
            throw new UResourceTypeMismatchException(ICUResourceBundleReader.emptyString);
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public int getInt() {
            if (ICUResourceBundleReader.RES_GET_TYPE(this.res) == 7) {
                return ICUResourceBundleReader.RES_GET_INT(this.res);
            }
            throw new UResourceTypeMismatchException(ICUResourceBundleReader.emptyString);
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public int[] getIntVector() {
            int[] intVector = this.reader.getIntVector(this.res);
            if (intVector != null) {
                return intVector;
            }
            throw new UResourceTypeMismatchException(ICUResourceBundleReader.emptyString);
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public String getString() {
            String string = this.reader.getString(this.res);
            if (string != null) {
                return string;
            }
            throw new UResourceTypeMismatchException(ICUResourceBundleReader.emptyString);
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public String[] getStringArrayOrStringAsArray() {
            Array array = this.reader.getArray(this.res);
            if (array != null) {
                return getStringArray(array);
            }
            String string = this.reader.getString(this.res);
            if (string != null) {
                return new String[]{string};
            }
            throw new UResourceTypeMismatchException(ICUResourceBundleReader.emptyString);
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public String getStringOrFirstOfArray() {
            String string = this.reader.getString(this.res);
            if (string != null) {
                return string;
            }
            Array array = this.reader.getArray(this.res);
            if (array != null && array.size > 0) {
                String string2 = this.reader.getString(array.getContainerResource(this.reader, 0));
                if (string2 != null) {
                    return string2;
                }
            }
            throw new UResourceTypeMismatchException(ICUResourceBundleReader.emptyString);
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public UResource.Table getTable() {
            Table table = this.reader.getTable(this.res);
            if (table != null) {
                return table;
            }
            throw new UResourceTypeMismatchException(ICUResourceBundleReader.emptyString);
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public int getType() {
            return ICUResourceBundleReader.PUBLIC_TYPES[ICUResourceBundleReader.RES_GET_TYPE(this.res)];
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public int getUInt() {
            if (ICUResourceBundleReader.RES_GET_TYPE(this.res) == 7) {
                return ICUResourceBundleReader.RES_GET_UINT(this.res);
            }
            throw new UResourceTypeMismatchException(ICUResourceBundleReader.emptyString);
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public boolean isNoInheritanceMarker() {
            return this.reader.isNoInheritanceMarker(this.res);
        }

        @Override // com.ibm.icu.impl.UResource.Value
        public String[] getStringArray() {
            Array array = this.reader.getArray(this.res);
            if (array != null) {
                return getStringArray(array);
            }
            throw new UResourceTypeMismatchException(ICUResourceBundleReader.emptyString);
        }
    }

    private ICUResourceBundleReader() {
    }

    public /* synthetic */ ICUResourceBundleReader(ByteBuffer byteBuffer, String str, String str2, ClassLoader classLoader, int i) {
        this(byteBuffer, str, str2, classLoader);
    }

    public ByteBuffer getBinary(int i) {
        int iRES_GET_OFFSET = RES_GET_OFFSET(i);
        if (RES_GET_TYPE(i) != 1) {
            return null;
        }
        if (iRES_GET_OFFSET == 0) {
            return emptyByteBuffer.duplicate();
        }
        int resourceByteOffset = getResourceByteOffset(iRES_GET_OFFSET);
        int i2 = getInt(resourceByteOffset);
        if (i2 == 0) {
            return emptyByteBuffer.duplicate();
        }
        int i3 = resourceByteOffset + 4;
        ByteBuffer byteBufferDuplicate = this.bytes.duplicate();
        ByteBuffer byteBufferSliceWithOrder = ICUBinary.sliceWithOrder(byteBufferDuplicate);
        return !byteBufferSliceWithOrder.isReadOnly() ? byteBufferSliceWithOrder.asReadOnlyBuffer() : byteBufferSliceWithOrder;
    }
}
