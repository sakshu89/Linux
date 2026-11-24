package com.ibm.icu.text;

import com.ibm.icu.impl.Norm2AllModes;
import com.ibm.icu.impl.Normalizer2Impl;
import com.ibm.icu.impl.Utility;
import com.ibm.icu.lang.UCharacter;
import defpackage.dk0;
import defpackage.ky0;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CanonicalIterator {
    private static final int PERMUTE_DEPTH_LIMIT = 8;
    private static boolean PROGRESS = false;
    private static final int RESULT_LIMIT = 4096;
    private static final Set<String> SET_WITH_NULL_STRING;
    private static boolean SKIP_ZEROS = true;
    private transient StringBuilder buffer = new StringBuilder();
    private int[] current;
    private boolean done;
    private final Normalizer2Impl nfcImpl;
    private final Normalizer2 nfd;
    private String[][] pieces;
    private String source;

    static {
        HashSet hashSet = new HashSet();
        SET_WITH_NULL_STRING = hashSet;
        hashSet.add("");
    }

    public CanonicalIterator(String str) {
        Norm2AllModes nFCInstance = Norm2AllModes.getNFCInstance();
        this.nfd = nFCInstance.decomp;
        this.nfcImpl = nFCInstance.impl.ensureCanonIterData();
        setSource(str);
    }

    private Set<String> extract(int i, String str, int i2, StringBuffer stringBuffer) {
        if (PROGRESS) {
            System.out.println(" extract: " + Utility.hex(UTF16.valueOf(i)) + ", " + Utility.hex(str.substring(i2)));
        }
        String decomposition = this.nfcImpl.getDecomposition(i);
        if (decomposition == null) {
            decomposition = UTF16.valueOf(i);
        }
        int iCharAt = UTF16.charAt(decomposition, 0);
        int charCount = UTF16.getCharCount(iCharAt);
        stringBuffer.setLength(0);
        int charCount2 = i2;
        while (charCount2 < str.length()) {
            int iCharAt2 = UTF16.charAt(str, charCount2);
            if (iCharAt2 == iCharAt) {
                if (PROGRESS) {
                    ky0.y("  matches: ", Utility.hex(UTF16.valueOf(iCharAt2)), System.out);
                }
                if (charCount == decomposition.length()) {
                    stringBuffer.append(str.substring(UTF16.getCharCount(iCharAt2) + charCount2));
                    if (PROGRESS) {
                        System.out.println("Matches");
                    }
                    if (stringBuffer.length() == 0) {
                        return SET_WITH_NULL_STRING;
                    }
                    String string = stringBuffer.toString();
                    if (Normalizer.compare(ky0.j(UTF16.valueOf(i), string), str.substring(i2), 0) != 0) {
                        return null;
                    }
                    return getEquivalents2(string);
                }
                iCharAt = UTF16.charAt(decomposition, charCount);
                charCount = UTF16.getCharCount(iCharAt) + charCount;
            } else {
                if (PROGRESS) {
                    ky0.y("  buffer: ", Utility.hex(UTF16.valueOf(iCharAt2)), System.out);
                }
                UTF16.append(stringBuffer, iCharAt2);
            }
            charCount2 += UTF16.getCharCount(iCharAt2);
        }
        return null;
    }

    private String[] getEquivalents(String str) {
        HashSet hashSet = new HashSet();
        Set<String> equivalents2 = getEquivalents2(str);
        HashSet<String> hashSet2 = new HashSet();
        for (String str2 : equivalents2) {
            hashSet2.clear();
            permute(str2, SKIP_ZEROS, hashSet2);
            for (String str3 : hashSet2) {
                if (Normalizer.compare(str3, str, 0) == 0) {
                    if (PROGRESS) {
                        ky0.y("Adding Permutation: ", Utility.hex(str3), System.out);
                    }
                    hashSet.add(str3);
                } else if (PROGRESS) {
                    ky0.y("-Skipping Permutation: ", Utility.hex(str3), System.out);
                }
            }
        }
        String[] strArr = new String[hashSet.size()];
        hashSet.toArray(strArr);
        return strArr;
    }

    private Set<String> getEquivalents2(String str) {
        HashSet hashSet = new HashSet();
        if (PROGRESS) {
            ky0.y("Adding: ", Utility.hex(str), System.out);
        }
        hashSet.add(str);
        StringBuffer stringBuffer = new StringBuffer();
        UnicodeSet unicodeSet = new UnicodeSet();
        int iCharCount = 0;
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (this.nfcImpl.getCanonStartSet(iCodePointAt, unicodeSet)) {
                UnicodeSetIterator unicodeSetIterator = new UnicodeSetIterator(unicodeSet);
                while (unicodeSetIterator.next()) {
                    int i = unicodeSetIterator.codepoint;
                    Set<String> setExtract = extract(i, str, iCharCount, stringBuffer);
                    if (setExtract != null) {
                        String strJ = ky0.j(str.substring(0, iCharCount), UTF16.valueOf(i));
                        Iterator<String> it = setExtract.iterator();
                        while (it.hasNext()) {
                            hashSet.add(strJ + it.next());
                        }
                    }
                }
                if (hashSet.size() > 4096) {
                    dk0.r("Too many permutations");
                    return null;
                }
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
        return hashSet;
    }

    @Deprecated
    private static void permute(String str, boolean z, Set<String> set, int i) {
        if (i > 8) {
            dk0.r(ky0.h(i, "Stack too deep:"));
            return;
        }
        if (str.length() <= 2 && UTF16.countCodePoint(str) <= 1) {
            set.add(str);
            return;
        }
        HashSet hashSet = new HashSet();
        int charCount = 0;
        while (charCount < str.length()) {
            int iCharAt = UTF16.charAt(str, charCount);
            if (!z || charCount == 0 || UCharacter.getCombiningClass(iCharAt) != 0) {
                hashSet.clear();
                permute(str.substring(0, charCount).concat(str.substring(UTF16.getCharCount(iCharAt) + charCount)), z, hashSet, i + 1);
                String strValueOf = UTF16.valueOf(str, charCount);
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    set.add(strValueOf + ((String) it.next()));
                }
            }
            charCount += UTF16.getCharCount(iCharAt);
        }
    }

    public String getSource() {
        return this.source;
    }

    public String next() {
        StringBuilder sb;
        if (this.done) {
            return null;
        }
        this.buffer.setLength(0);
        int i = 0;
        while (true) {
            String[][] strArr = this.pieces;
            int length = strArr.length;
            sb = this.buffer;
            if (i >= length) {
                break;
            }
            sb.append(strArr[i][this.current[i]]);
            i++;
        }
        String string = sb.toString();
        for (int length2 = this.current.length - 1; length2 >= 0; length2--) {
            int[] iArr = this.current;
            int i2 = iArr[length2] + 1;
            iArr[length2] = i2;
            if (i2 < this.pieces[length2].length) {
                return string;
            }
            iArr[length2] = 0;
        }
        this.done = true;
        return string;
    }

    public void reset() {
        this.done = false;
        int i = 0;
        while (true) {
            int[] iArr = this.current;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = 0;
            i++;
        }
    }

    public void setSource(String str) {
        String str2;
        this.source = this.nfd.normalize(str);
        this.done = false;
        if (str.length() == 0) {
            this.pieces = new String[][]{new String[]{""}};
            this.current = new int[1];
            return;
        }
        ArrayList arrayList = new ArrayList();
        int iFindOffsetFromCodePoint = UTF16.findOffsetFromCodePoint(this.source, 1);
        int i = 0;
        while (true) {
            int length = this.source.length();
            str2 = this.source;
            if (iFindOffsetFromCodePoint >= length) {
                break;
            }
            int iCodePointAt = str2.codePointAt(iFindOffsetFromCodePoint);
            if (this.nfcImpl.isCanonSegmentStarter(iCodePointAt)) {
                arrayList.add(this.source.substring(i, iFindOffsetFromCodePoint));
                i = iFindOffsetFromCodePoint;
            }
            iFindOffsetFromCodePoint += Character.charCount(iCodePointAt);
        }
        arrayList.add(str2.substring(i, iFindOffsetFromCodePoint));
        this.pieces = new String[arrayList.size()][];
        this.current = new int[arrayList.size()];
        for (int i2 = 0; i2 < this.pieces.length; i2++) {
            if (PROGRESS) {
                System.out.println("SEGMENT");
            }
            this.pieces[i2] = getEquivalents((String) arrayList.get(i2));
        }
    }

    @Deprecated
    public static void permute(String str, boolean z, Set<String> set) {
        permute(str, z, set, 0);
    }
}
