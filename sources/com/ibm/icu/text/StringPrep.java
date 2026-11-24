package com.ibm.icu.text;

import com.ibm.icu.impl.CharTrie;
import com.ibm.icu.impl.ICUBinary;
import com.ibm.icu.impl.StringPrepDataReader;
import com.ibm.icu.impl.UBiDiProps;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.util.ICUUncheckedIOException;
import com.ibm.icu.util.VersionInfo;
import defpackage.dk0;
import defpackage.og;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class StringPrep {
    public static final int ALLOW_UNASSIGNED = 1;
    private static final int CHECK_BIDI_ON = 2;
    public static final int DEFAULT = 0;
    private static final int DELETE = 3;
    private static final int FOUR_UCHARS_MAPPING_INDEX_START = 6;
    private static final int INDEX_MAPPING_DATA_SIZE = 1;
    private static final int INDEX_TOP = 16;
    private static final int MAP = 1;
    private static final int MAX_INDEX_VALUE = 16319;
    private static final int MAX_PROFILE = 13;
    private static final int NORMALIZATION_ON = 1;
    private static final int NORM_CORRECTNS_LAST_UNI_VERSION = 2;
    private static final int ONE_UCHAR_MAPPING_INDEX_START = 3;
    private static final int OPTIONS = 7;
    private static final int PROHIBITED = 2;
    public static final int RFC3491_NAMEPREP = 0;
    public static final int RFC3530_NFS4_CIS_PREP = 3;
    public static final int RFC3530_NFS4_CS_PREP = 1;
    public static final int RFC3530_NFS4_CS_PREP_CI = 2;
    public static final int RFC3530_NFS4_MIXED_PREP_PREFIX = 4;
    public static final int RFC3530_NFS4_MIXED_PREP_SUFFIX = 5;
    public static final int RFC3722_ISCSI = 6;
    public static final int RFC3920_NODEPREP = 7;
    public static final int RFC3920_RESOURCEPREP = 8;
    public static final int RFC4011_MIB = 9;
    public static final int RFC4013_SASLPREP = 10;
    public static final int RFC4505_TRACE = 11;
    public static final int RFC4518_LDAP = 12;
    public static final int RFC4518_LDAP_CI = 13;
    private static final int THREE_UCHARS_MAPPING_INDEX_START = 5;
    private static final int TWO_UCHARS_MAPPING_INDEX_START = 4;
    private static final int TYPE_LIMIT = 4;
    private static final int TYPE_THRESHOLD = 65520;
    private static final int UNASSIGNED = 0;
    private UBiDiProps bdp;
    private boolean checkBiDi;
    private boolean doNFKC;
    private int[] indexes;
    private char[] mappingData;
    private VersionInfo normCorrVer;
    private CharTrie sprepTrie;
    private VersionInfo sprepUniVer;
    private static final String[] PROFILE_NAMES = {"rfc3491", "rfc3530cs", "rfc3530csci", "rfc3491", "rfc3530mixp", "rfc3491", "rfc3722", "rfc3920node", "rfc3920res", "rfc4011", "rfc4013", "rfc4505", "rfc4518", "rfc4518ci"};
    private static final AtomicReferenceArray<WeakReference<StringPrep>> CACHE = new AtomicReferenceArray<>(14);

    private StringPrep(ByteBuffer byteBuffer) throws IOException {
        StringPrepDataReader stringPrepDataReader = new StringPrepDataReader(byteBuffer);
        this.indexes = stringPrepDataReader.readIndexes(16);
        this.sprepTrie = new CharTrie(byteBuffer, null);
        this.mappingData = stringPrepDataReader.read(this.indexes[1] / 2);
        int i = this.indexes[7];
        this.doNFKC = (i & 1) > 0;
        this.checkBiDi = (i & 2) > 0;
        this.sprepUniVer = getVersionInfo(stringPrepDataReader.getUnicodeVersion());
        this.normCorrVer = getVersionInfo(this.indexes[2]);
        VersionInfo unicodeVersion = UCharacter.getUnicodeVersion();
        if (unicodeVersion.compareTo(this.sprepUniVer) < 0 && unicodeVersion.compareTo(this.normCorrVer) < 0 && (this.indexes[7] & 1) > 0) {
            dk0.h("Normalization Correction version not supported");
            throw null;
        }
        if (this.checkBiDi) {
            this.bdp = UBiDiProps.INSTANCE;
        }
    }

    private char getCodePointValue(int i) {
        return this.sprepTrie.getCodePointValue(i);
    }

    public static StringPrep getInstance(int i) {
        StringPrep stringPrep;
        if (i < 0 || i > 13) {
            og.i("Bad profile type");
            return null;
        }
        AtomicReferenceArray<WeakReference<StringPrep>> atomicReferenceArray = CACHE;
        WeakReference<StringPrep> weakReference = atomicReferenceArray.get(i);
        StringPrep stringPrep2 = weakReference != null ? weakReference.get() : null;
        if (stringPrep2 != null) {
            return stringPrep2;
        }
        synchronized (atomicReferenceArray) {
            try {
                WeakReference<StringPrep> weakReference2 = atomicReferenceArray.get(i);
                stringPrep = weakReference2 != null ? weakReference2.get() : null;
                if (stringPrep == null) {
                    ByteBuffer requiredData = ICUBinary.getRequiredData(PROFILE_NAMES[i] + ".spp");
                    if (requiredData != null) {
                        try {
                            stringPrep = new StringPrep(requiredData);
                        } catch (IOException e) {
                            throw new ICUUncheckedIOException(e);
                        }
                    }
                    if (stringPrep != null) {
                        atomicReferenceArray.set(i, new WeakReference<>(stringPrep));
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return stringPrep;
    }

    private static final void getValues(char c, Values values) {
        values.reset();
        if (c == 0) {
            values.type = 4;
            return;
        }
        if (c >= TYPE_THRESHOLD) {
            values.type = c - TYPE_THRESHOLD;
            return;
        }
        values.type = 1;
        if ((c & 2) > 0) {
            values.isIndex = true;
            values.value = c >> 2;
        } else {
            values.isIndex = false;
            values.value = (c << 16) >> 18;
        }
        if ((c >> 2) == MAX_INDEX_VALUE) {
            values.type = 3;
            values.isIndex = false;
            values.value = 0;
        }
    }

    private static VersionInfo getVersionInfo(byte[] bArr) {
        if (bArr.length != 4) {
            return null;
        }
        return VersionInfo.getInstance(bArr[0], bArr[1], bArr[2], bArr[3]);
    }

    private StringBuffer map(UCharacterIterator uCharacterIterator, int i) throws StringPrepParseException {
        Values values = new Values(0);
        StringBuffer stringBuffer = new StringBuffer();
        int i2 = (i & 1) > 0 ? 1 : 0;
        while (true) {
            int iNextCodePoint = uCharacterIterator.nextCodePoint();
            if (iNextCodePoint == -1) {
                return stringBuffer;
            }
            getValues(getCodePointValue(iNextCodePoint), values);
            int i3 = values.type;
            char c = 3;
            if (i3 == 0 && i2 == 0) {
                throw new StringPrepParseException("An unassigned code point was found in the input", 3, uCharacterIterator.getText(), uCharacterIterator.getIndex());
            }
            if (i3 == 1) {
                boolean z = values.isIndex;
                int i4 = values.value;
                if (z) {
                    int[] iArr = this.indexes;
                    if (i4 >= iArr[3] && i4 < iArr[4]) {
                        c = 1;
                    } else if (i4 >= iArr[4] && i4 < iArr[5]) {
                        c = 2;
                    } else if (i4 < iArr[5] || i4 >= iArr[6]) {
                        c = this.mappingData[i4];
                        i4++;
                    }
                    stringBuffer.append(this.mappingData, i4, c);
                } else {
                    iNextCodePoint -= i4;
                    UTF16.append(stringBuffer, iNextCodePoint);
                }
            } else if (i3 != 3) {
                UTF16.append(stringBuffer, iNextCodePoint);
            }
        }
    }

    private StringBuffer normalize(StringBuffer stringBuffer) {
        return new StringBuffer(Normalizer.normalize(stringBuffer.toString(), Normalizer.NFKC, 32));
    }

    public StringBuffer prepare(UCharacterIterator uCharacterIterator, int i) throws StringPrepParseException {
        StringBuffer map = map(uCharacterIterator, i);
        if (this.doNFKC) {
            map = normalize(map);
        }
        UCharacterIterator uCharacterIterator2 = UCharacterIterator.getInstance(map);
        int i2 = 0;
        Values values = new Values(i2);
        int i3 = -1;
        boolean z = false;
        int index = -1;
        int index2 = -1;
        int i4 = 23;
        int i5 = 23;
        while (true) {
            int iNextCodePoint = uCharacterIterator2.nextCodePoint();
            if (iNextCodePoint == i3) {
                if (this.checkBiDi) {
                    if (i2 == 1 && z) {
                        String text = uCharacterIterator2.getText();
                        if (index <= index2) {
                            index = index2;
                        }
                        throw new StringPrepParseException("The input does not conform to the rules for BiDi code points.", 4, text, index);
                    }
                    if (z && ((i4 != 1 && i4 != 13) || (i5 != 1 && i5 != 13))) {
                        String text2 = uCharacterIterator2.getText();
                        if (index <= index2) {
                            index = index2;
                        }
                        throw new StringPrepParseException("The input does not conform to the rules for BiDi code points.", 4, text2, index);
                    }
                }
                return map;
            }
            getValues(getCodePointValue(iNextCodePoint), values);
            if (values.type == 2) {
                throw new StringPrepParseException("A prohibited code point was found in the input", 2, uCharacterIterator2.getText(), values.value);
            }
            if (this.checkBiDi) {
                i5 = this.bdp.getClass(iNextCodePoint);
                if (i4 == 23) {
                    i4 = i5;
                }
                if (i5 == 0) {
                    index2 = uCharacterIterator2.getIndex() - 1;
                    i2 = 1;
                }
                if (i5 == 1 || i5 == 13) {
                    index = uCharacterIterator2.getIndex() - 1;
                    z = true;
                }
            }
            i3 = -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class Values {
        boolean isIndex;
        int type;
        int value;

        public /* synthetic */ Values(int i) {
            this();
        }

        public void reset() {
            this.isIndex = false;
            this.value = 0;
            this.type = -1;
        }

        private Values() {
        }
    }

    private static VersionInfo getVersionInfo(int i) {
        return VersionInfo.getInstance((i >> 24) & 255, (i >> 16) & 255, (i >> 8) & 255, i & 255);
    }

    public StringPrep(InputStream inputStream) {
        this(ICUBinary.getByteBufferFromInputStreamAndCloseStream(inputStream));
    }

    public String prepare(String str, int i) {
        return prepare(UCharacterIterator.getInstance(str), i).toString();
    }
}
