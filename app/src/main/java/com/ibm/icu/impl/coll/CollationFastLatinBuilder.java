package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.util.CharsTrie;
import defpackage.og;
import java.lang.reflect.Array;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
final class CollationFastLatinBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final long CONTRACTION_FLAG = 2147483648L;
    private static final int NUM_SPECIAL_GROUPS = 4;
    private long[][] charCEs = (long[][]) Array.newInstance((Class<?>) Long.TYPE, 448, 2);
    long[] lastSpecialPrimaries = new long[4];
    private StringBuilder result = new StringBuilder();
    private long ce0 = 0;
    private long ce1 = 0;
    private UVector64 contractionCEs = new UVector64();
    private UVector64 uniqueCEs = new UVector64();
    private char[] miniCEs = null;
    private long firstDigitPrimary = 0;
    private long firstLatinPrimary = 0;
    private long lastLatinPrimary = 0;
    private long firstShortPrimary = 0;
    private boolean shortPrimaryOverflow = false;
    private int headerLength = 0;

    private void addContractionEntry(int i, long j, long j2) {
        this.contractionCEs.addElement(i);
        this.contractionCEs.addElement(j);
        this.contractionCEs.addElement(j2);
        addUniqueCE(j);
        addUniqueCE(j2);
    }

    private void addUniqueCE(long j) {
        long j2;
        int iBinarySearch;
        if (j == 0 || (j >>> 32) == 1 || (iBinarySearch = binarySearch(this.uniqueCEs.getBuffer(), this.uniqueCEs.size(), (j2 = j & (-49153)))) >= 0) {
            return;
        }
        this.uniqueCEs.insertElementAt(j2, ~iBinarySearch);
    }

    private static final int binarySearch(long[] jArr, int i, long j) {
        if (i == 0) {
            return -1;
        }
        int i2 = 0;
        while (true) {
            int i3 = (int) ((((long) i2) + ((long) i)) / 2);
            int iCompareInt64AsUnsigned = compareInt64AsUnsigned(j, jArr[i3]);
            if (iCompareInt64AsUnsigned == 0) {
                return i3;
            }
            if (iCompareInt64AsUnsigned < 0) {
                if (i3 == i2) {
                    return ~i2;
                }
                i = i3;
            } else {
                if (i3 == i2) {
                    return ~(i2 + 1);
                }
                i2 = i3;
            }
        }
    }

    private static final int compareInt64AsUnsigned(long j, long j2) {
        long j3 = j - Long.MIN_VALUE;
        long j4 = j2 - Long.MIN_VALUE;
        if (j3 < j4) {
            return -1;
        }
        return j3 > j4 ? 1 : 0;
    }

    private void encodeCharCEs() {
        StringBuilder sb;
        int length = this.result.length();
        int i = 0;
        while (true) {
            sb = this.result;
            if (i >= 448) {
                break;
            }
            sb.append(0);
            i++;
        }
        int length2 = sb.length();
        for (int i2 = 0; i2 < 448; i2++) {
            long j = this.charCEs[i2][0];
            if (!isContractionCharCE(j)) {
                int i3 = 1;
                int iEncodeTwoCEs = encodeTwoCEs(j, this.charCEs[i2][1]);
                if ((iEncodeTwoCEs >>> 16) > 0) {
                    int length3 = this.result.length() - length2;
                    if (length3 <= 1023) {
                        StringBuilder sb2 = this.result;
                        sb2.append((char) (iEncodeTwoCEs >> 16));
                        sb2.append((char) iEncodeTwoCEs);
                        i3 = length3 | 2048;
                    }
                } else {
                    i3 = iEncodeTwoCEs;
                }
                this.result.setCharAt(length + i2, (char) i3);
            }
        }
    }

    private void encodeContractions() {
        int i = this.headerLength + 448;
        int length = this.result.length();
        for (int i2 = 0; i2 < 448; i2++) {
            long j = this.charCEs[i2][0];
            if (isContractionCharCE(j)) {
                int length2 = this.result.length() - i;
                if (length2 > 1023) {
                    this.result.setCharAt(this.headerLength + i2, (char) 1);
                } else {
                    int i3 = ((int) j) & Integer.MAX_VALUE;
                    boolean z = true;
                    while (true) {
                        long jElementAti = this.contractionCEs.elementAti(i3);
                        if (jElementAti == 511 && !z) {
                            break;
                        }
                        int iEncodeTwoCEs = encodeTwoCEs(this.contractionCEs.elementAti(i3 + 1), this.contractionCEs.elementAti(i3 + 2));
                        if (iEncodeTwoCEs == 1) {
                            this.result.append((char) (jElementAti | 512));
                        } else {
                            int i4 = iEncodeTwoCEs >>> 16;
                            StringBuilder sb = this.result;
                            if (i4 == 0) {
                                sb.append((char) (jElementAti | 1024));
                                this.result.append((char) iEncodeTwoCEs);
                            } else {
                                sb.append((char) (jElementAti | 1536));
                                StringBuilder sb2 = this.result;
                                sb2.append((char) (iEncodeTwoCEs >> 16));
                                sb2.append((char) iEncodeTwoCEs);
                            }
                        }
                        i3 += 3;
                        z = false;
                    }
                    this.result.setCharAt(this.headerLength + i2, (char) (length2 | 1024));
                }
            }
        }
        if (this.result.length() > length) {
            this.result.append((char) 511);
        }
    }

    private int encodeTwoCEs(long j, long j2) {
        if (j == 0) {
            return 0;
        }
        if (j == Collation.NO_CE) {
            return 1;
        }
        int miniCE = getMiniCE(j);
        if (miniCE == 1) {
            return miniCE;
        }
        if (miniCE >= 4096) {
            miniCE |= ((((int) j) & Collation.CASE_MASK) >> 11) + 8;
        }
        if (j2 == 0) {
            return miniCE;
        }
        int miniCE2 = getMiniCE(j2);
        if (miniCE2 == 1) {
            return miniCE2;
        }
        int i = ((int) j2) & Collation.CASE_MASK;
        if (miniCE >= 4096 && (miniCE & 992) == 160) {
            int i2 = miniCE2 & 992;
            int i3 = miniCE2 & 7;
            if (i2 >= 384 && i == 0 && i3 == 0) {
                return (miniCE & (-993)) | i2;
            }
        }
        if (miniCE2 <= 992 || 4096 <= miniCE2) {
            miniCE2 |= (i >> 11) + 8;
        }
        return miniCE2 | (miniCE << 16);
    }

    /* JADX WARN: Code duplicated, block: B:32:0x008c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:33:0x008e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x0090  */
    /* JADX WARN: Code duplicated, block: B:35:0x0093  */
    /* JADX WARN: Code duplicated, block: B:37:0x0097  */
    /* JADX WARN: Code duplicated, block: B:38:0x009b  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:41:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:43:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:44:0x00af  */
    /* JADX WARN: Code duplicated, block: B:46:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:47:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:48:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:50:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:53:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:54:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:59:0x00d7 A[PHI: r9 r10 r11
      0x00d7: PHI (r9v3 int) = (r9v2 int), (r9v9 int) binds: [B:31:0x008a, B:57:0x00cc] A[DONT_GENERATE, DONT_INLINE]
      0x00d7: PHI (r10v3 int) = (r10v2 int), (r10v4 int) binds: [B:31:0x008a, B:57:0x00cc] A[DONT_GENERATE, DONT_INLINE]
      0x00d7: PHI (r11v3 int) = (r11v2 int), (r11v6 int) binds: [B:31:0x008a, B:57:0x00cc] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:61:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:63:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:64:0x00e2 A[PHI: r11
      0x00e2: PHI (r11v4 int) = (r11v3 int), (r11v5 int) binds: [B:60:0x00db, B:63:0x00e0] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:65:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:70:0x00fa  */
    private void encodeUniqueCEs() {
        int i;
        int i2;
        int i3;
        this.miniCEs = new char[this.uniqueCEs.size()];
        long j = this.lastSpecialPrimaries[0];
        long j2 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = 0; i9 < this.uniqueCEs.size(); i9++) {
            long jElementAti = this.uniqueCEs.elementAti(i9);
            long j3 = jElementAti >>> 32;
            if (j3 != j2) {
                while (j3 > j) {
                    i5++;
                    this.result.setCharAt(i5, (char) i4);
                    if (i5 >= 4) {
                        j = 4294967295L;
                        break;
                    }
                    j = this.lastSpecialPrimaries[i5];
                }
                long j4 = j;
                if (j3 < this.firstShortPrimary) {
                    if (i4 == 0) {
                        i4 = UCharacterProperty.SCRIPT_X_WITH_OTHER;
                    } else if (i4 < 4088) {
                        i4 += 8;
                    } else {
                        this.miniCEs[i9] = 1;
                        j = j4;
                    }
                    j2 = j3;
                    j = j4;
                    i6 = Collation.COMMON_WEIGHT16;
                    i7 = 160;
                    i8 = 0;
                    i = (int) jElementAti;
                    i2 = i >>> 16;
                    if (i2 == i6) {
                        if ((i & Collation.ONLY_TERTIARY_MASK) <= 1280) {
                            if (3072 <= i4 || i4 > 4088) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i8);
                            }
                        } else if (i8 < 7) {
                            i8++;
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else {
                            this.miniCEs[i9] = 1;
                        }
                    } else if (i4 == 0) {
                        if (i7 == 0) {
                            i3 = CollationFastLatin.LATIN_LIMIT;
                        } else if (i7 < 992) {
                            i3 = i7 + 32;
                        } else {
                            this.miniCEs[i9] = 1;
                        }
                        i7 = i3;
                        i6 = i2;
                        i8 = 0;
                        if ((i & Collation.ONLY_TERTIARY_MASK) <= 1280) {
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else if (i8 < 7) {
                            i8++;
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else {
                            this.miniCEs[i9] = 1;
                        }
                    } else if (i2 >= 1280) {
                        if (i2 == 1280) {
                            i3 = 160;
                        } else if (i7 < 192) {
                            i3 = 192;
                        } else if (i7 < 352) {
                            i3 = i7 + 32;
                        } else {
                            this.miniCEs[i9] = 1;
                        }
                        i7 = i3;
                        i6 = i2;
                        i8 = 0;
                        if ((i & Collation.ONLY_TERTIARY_MASK) <= 1280) {
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else if (i8 < 7) {
                            i8++;
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else {
                            this.miniCEs[i9] = 1;
                        }
                    } else if (i7 == 160) {
                        i3 = 0;
                        i7 = i3;
                        i6 = i2;
                        i8 = 0;
                        if ((i & Collation.ONLY_TERTIARY_MASK) <= 1280) {
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else if (i8 < 7) {
                            i8++;
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else {
                            this.miniCEs[i9] = 1;
                        }
                    } else if (i7 < 128) {
                        i3 = i7 + 32;
                        i7 = i3;
                        i6 = i2;
                        i8 = 0;
                        if ((i & Collation.ONLY_TERTIARY_MASK) <= 1280) {
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else if (i8 < 7) {
                            i8++;
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else {
                            this.miniCEs[i9] = 1;
                        }
                    } else {
                        this.miniCEs[i9] = 1;
                    }
                } else {
                    if (i4 < 4096) {
                        i4 = 4096;
                    } else if (i4 < 63488) {
                        i4 += 1024;
                    } else {
                        this.shortPrimaryOverflow = true;
                        this.miniCEs[i9] = 1;
                        j = j4;
                    }
                    j2 = j3;
                    j = j4;
                    i6 = Collation.COMMON_WEIGHT16;
                    i7 = 160;
                    i8 = 0;
                    i = (int) jElementAti;
                    i2 = i >>> 16;
                    if (i2 == i6) {
                        if ((i & Collation.ONLY_TERTIARY_MASK) <= 1280) {
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else if (i8 < 7) {
                            i8++;
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else {
                            this.miniCEs[i9] = 1;
                        }
                    } else if (i4 == 0) {
                        if (i7 == 0) {
                            i3 = CollationFastLatin.LATIN_LIMIT;
                        } else if (i7 < 992) {
                            i3 = i7 + 32;
                        } else {
                            this.miniCEs[i9] = 1;
                        }
                        i7 = i3;
                        i6 = i2;
                        i8 = 0;
                        if ((i & Collation.ONLY_TERTIARY_MASK) <= 1280) {
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else if (i8 < 7) {
                            i8++;
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else {
                            this.miniCEs[i9] = 1;
                        }
                    } else if (i2 >= 1280) {
                        if (i2 == 1280) {
                            i3 = 160;
                        } else if (i7 < 192) {
                            i3 = 192;
                        } else if (i7 < 352) {
                            i3 = i7 + 32;
                        } else {
                            this.miniCEs[i9] = 1;
                        }
                        i7 = i3;
                        i6 = i2;
                        i8 = 0;
                        if ((i & Collation.ONLY_TERTIARY_MASK) <= 1280) {
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else if (i8 < 7) {
                            i8++;
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else {
                            this.miniCEs[i9] = 1;
                        }
                    } else if (i7 == 160) {
                        i3 = 0;
                        i7 = i3;
                        i6 = i2;
                        i8 = 0;
                        if ((i & Collation.ONLY_TERTIARY_MASK) <= 1280) {
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else if (i8 < 7) {
                            i8++;
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else {
                            this.miniCEs[i9] = 1;
                        }
                    } else if (i7 < 128) {
                        i3 = i7 + 32;
                        i7 = i3;
                        i6 = i2;
                        i8 = 0;
                        if ((i & Collation.ONLY_TERTIARY_MASK) <= 1280) {
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else if (i8 < 7) {
                            i8++;
                            if (3072 <= i4) {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            } else {
                                this.miniCEs[i9] = (char) (i4 | i7 | i8);
                            }
                        } else {
                            this.miniCEs[i9] = 1;
                        }
                    } else {
                        this.miniCEs[i9] = 1;
                    }
                }
            } else {
                i = (int) jElementAti;
                i2 = i >>> 16;
                if (i2 == i6) {
                    if ((i & Collation.ONLY_TERTIARY_MASK) <= 1280) {
                        if (3072 <= i4) {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        } else {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        }
                    } else if (i8 < 7) {
                        i8++;
                        if (3072 <= i4) {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        } else {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        }
                    } else {
                        this.miniCEs[i9] = 1;
                    }
                } else if (i4 == 0) {
                    if (i7 == 0) {
                        i3 = CollationFastLatin.LATIN_LIMIT;
                    } else if (i7 < 992) {
                        i3 = i7 + 32;
                    } else {
                        this.miniCEs[i9] = 1;
                    }
                    i7 = i3;
                    i6 = i2;
                    i8 = 0;
                    if ((i & Collation.ONLY_TERTIARY_MASK) <= 1280) {
                        if (3072 <= i4) {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        } else {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        }
                    } else if (i8 < 7) {
                        i8++;
                        if (3072 <= i4) {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        } else {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        }
                    } else {
                        this.miniCEs[i9] = 1;
                    }
                } else if (i2 >= 1280) {
                    if (i2 == 1280) {
                        i3 = 160;
                    } else if (i7 < 192) {
                        i3 = 192;
                    } else if (i7 < 352) {
                        i3 = i7 + 32;
                    } else {
                        this.miniCEs[i9] = 1;
                    }
                    i7 = i3;
                    i6 = i2;
                    i8 = 0;
                    if ((i & Collation.ONLY_TERTIARY_MASK) <= 1280) {
                        if (3072 <= i4) {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        } else {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        }
                    } else if (i8 < 7) {
                        i8++;
                        if (3072 <= i4) {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        } else {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        }
                    } else {
                        this.miniCEs[i9] = 1;
                    }
                } else if (i7 == 160) {
                    i3 = 0;
                    i7 = i3;
                    i6 = i2;
                    i8 = 0;
                    if ((i & Collation.ONLY_TERTIARY_MASK) <= 1280) {
                        if (3072 <= i4) {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        } else {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        }
                    } else if (i8 < 7) {
                        i8++;
                        if (3072 <= i4) {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        } else {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        }
                    } else {
                        this.miniCEs[i9] = 1;
                    }
                } else if (i7 < 128) {
                    i3 = i7 + 32;
                    i7 = i3;
                    i6 = i2;
                    i8 = 0;
                    if ((i & Collation.ONLY_TERTIARY_MASK) <= 1280) {
                        if (3072 <= i4) {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        } else {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        }
                    } else if (i8 < 7) {
                        i8++;
                        if (3072 <= i4) {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        } else {
                            this.miniCEs[i9] = (char) (i4 | i7 | i8);
                        }
                    } else {
                        this.miniCEs[i9] = 1;
                    }
                } else {
                    this.miniCEs[i9] = 1;
                }
            }
        }
    }

    private void getCEs(CollationData collationData) {
        int ce32;
        CollationData collationData2;
        CollationFastLatinBuilder collationFastLatinBuilder;
        char c = 0;
        int i = 0;
        while (true) {
            if (c == 384) {
                c = 8192;
            } else if (c == 8256) {
                this.contractionCEs.addElement(511L);
                return;
            }
            int ce33 = collationData.getCE32(c);
            if (ce33 == 192) {
                collationData2 = collationData.base;
                ce32 = collationData2.getCE32(c);
            } else {
                ce32 = ce33;
                collationData2 = collationData;
            }
            boolean cEsFromCE32 = this.getCEsFromCE32(collationData2, c, ce32);
            long[][] jArr = this.charCEs;
            if (cEsFromCE32) {
                long[] jArr2 = jArr[i];
                long j = this.ce0;
                jArr2[0] = j;
                jArr2[1] = this.ce1;
                this.addUniqueCE(j);
                this.addUniqueCE(this.ce1);
            } else {
                long[] jArr3 = jArr[i];
                this.ce0 = Collation.NO_CE;
                jArr3[0] = 4311744768L;
                this.ce1 = 0L;
                jArr3[1] = 0;
            }
            if (c != 0 || isContractionCharCE(this.ce0)) {
                collationFastLatinBuilder = this;
            } else {
                collationFastLatinBuilder = this;
                collationFastLatinBuilder.addContractionEntry(511, this.ce0, this.ce1);
                long[] jArr4 = collationFastLatinBuilder.charCEs[0];
                jArr4[0] = 6442450944L;
                jArr4[1] = 0;
            }
            i++;
            c = (char) (c + 1);
            this = collationFastLatinBuilder;
        }
    }

    private boolean getCEsFromCE32(CollationData collationData, int i, int i2) {
        int i3;
        int finalCE32 = collationData.getFinalCE32(i2);
        this.ce1 = 0L;
        if (Collation.isSimpleOrLongCE32(finalCE32)) {
            this.ce0 = Collation.ceFromCE32(finalCE32);
        } else {
            int iTagFromCE32 = Collation.tagFromCE32(finalCE32);
            if (iTagFromCE32 == 4) {
                this.ce0 = Collation.latinCE0FromCE32(finalCE32);
                this.ce1 = Collation.latinCE1FromCE32(finalCE32);
            } else if (iTagFromCE32 == 5) {
                int iIndexFromCE32 = Collation.indexFromCE32(finalCE32);
                int iLengthFromCE32 = Collation.lengthFromCE32(finalCE32);
                if (iLengthFromCE32 > 2) {
                    return false;
                }
                this.ce0 = Collation.ceFromCE32(collationData.ce32s[iIndexFromCE32]);
                if (iLengthFromCE32 == 2) {
                    this.ce1 = Collation.ceFromCE32(collationData.ce32s[iIndexFromCE32 + 1]);
                }
            } else if (iTagFromCE32 == 6) {
                int iIndexFromCE33 = Collation.indexFromCE32(finalCE32);
                int iLengthFromCE33 = Collation.lengthFromCE32(finalCE32);
                if (iLengthFromCE33 > 2) {
                    return false;
                }
                long[] jArr = collationData.ces;
                this.ce0 = jArr[iIndexFromCE33];
                if (iLengthFromCE33 == 2) {
                    this.ce1 = jArr[iIndexFromCE33 + 1];
                }
            } else {
                if (iTagFromCE32 == 9) {
                    return getCEsFromContractionCE32(collationData, finalCE32);
                }
                if (iTagFromCE32 != 14) {
                    return false;
                }
                this.ce0 = collationData.getCEFromOffsetCE32(i, finalCE32);
            }
        }
        long j = this.ce0;
        if (j == 0) {
            return this.ce1 == 0;
        }
        long j2 = j >>> 32;
        if (j2 == 0 || j2 > this.lastLatinPrimary) {
            return false;
        }
        int i4 = (int) j;
        long j3 = this.firstShortPrimary;
        if ((j2 < j3 && (i4 & (-16384)) != 83886080) || (i3 = i4 & Collation.ONLY_TERTIARY_MASK) < 1280) {
            return false;
        }
        long j4 = this.ce1;
        if (j4 != 0) {
            long j5 = j4 >>> 32;
            if (j5 != 0 ? !inSameGroup(j2, j5) : j2 < j3) {
                return false;
            }
            int i5 = (int) this.ce1;
            if ((i5 >>> 16) == 0) {
                return false;
            }
            if ((j5 != 0 && j5 < this.firstShortPrimary && (i5 & (-16384)) != 83886080) || i3 < 1280) {
                return false;
            }
        }
        return ((this.ce0 | this.ce1) & 192) == 0;
    }

    private boolean getCEsFromContractionCE32(CollationData collationData, int i) {
        boolean z;
        CollationFastLatinBuilder collationFastLatinBuilder;
        int charIndex;
        CollationFastLatinBuilder collationFastLatinBuilder2;
        int i2;
        int iIndexFromCE32 = Collation.indexFromCE32(i);
        int cE32FromContexts = collationData.getCE32FromContexts(iIndexFromCE32);
        int size = this.contractionCEs.size();
        if (getCEsFromCE32(collationData, -1, cE32FromContexts)) {
            addContractionEntry(511, this.ce0, this.ce1);
        } else {
            addContractionEntry(511, Collation.NO_CE, 0L);
        }
        CharsTrie.Iterator it = CharsTrie.iterator(collationData.contexts, iIndexFromCE32 + 2, 0);
        int i3 = -1;
        loop0: while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                CharsTrie.Entry next = it.next();
                CharSequence charSequence = next.chars;
                charIndex = CollationFastLatin.getCharIndex(charSequence.charAt(0));
                if (charIndex >= 0) {
                    if (charIndex != i3) {
                        if (z) {
                            collationFastLatinBuilder2 = this;
                            collationFastLatinBuilder2.addContractionEntry(i3, this.ce0, this.ce1);
                        } else {
                            collationFastLatinBuilder2 = this;
                        }
                        int i4 = next.value;
                        if (charSequence.length() == 1 && collationFastLatinBuilder2.getCEsFromCE32(collationData, -1, i4)) {
                            z = true;
                            i2 = charIndex;
                        } else {
                            i2 = charIndex;
                            collationFastLatinBuilder2.addContractionEntry(i2, Collation.NO_CE, 0L);
                            z = false;
                        }
                        i3 = i2;
                    } else if (z) {
                        break;
                    }
                }
            }
            addContractionEntry(charIndex, Collation.NO_CE, 0L);
        }
        int i5 = i3;
        if (z) {
            collationFastLatinBuilder = this;
            collationFastLatinBuilder.addContractionEntry(i5, this.ce0, this.ce1);
        } else {
            collationFastLatinBuilder = this;
        }
        collationFastLatinBuilder.ce0 = 6442450944L | ((long) size);
        collationFastLatinBuilder.ce1 = 0L;
        return true;
    }

    private int getMiniCE(long j) {
        return this.miniCEs[binarySearch(this.uniqueCEs.getBuffer(), this.uniqueCEs.size(), j & (-49153))];
    }

    private boolean inSameGroup(long j, long j2) {
        long j3 = this.firstShortPrimary;
        if (j >= j3) {
            return j2 >= j3;
        }
        if (j2 >= j3) {
            return false;
        }
        long j4 = this.lastSpecialPrimaries[3];
        if (j > j4) {
            return j2 > j4;
        }
        if (j2 > j4) {
            return false;
        }
        int i = 0;
        while (true) {
            long j5 = this.lastSpecialPrimaries[i];
            if (j <= j5) {
                return j2 <= j5;
            }
            if (j2 <= j5) {
                return false;
            }
            i++;
        }
    }

    private static boolean isContractionCharCE(long j) {
        return (j >>> 32) == 1 && j != Collation.NO_CE;
    }

    private boolean loadGroups(CollationData collationData) {
        this.headerLength = 5;
        this.result.append((char) (5 | 512));
        for (int i = 0; i < 4; i++) {
            this.lastSpecialPrimaries[i] = collationData.getLastPrimaryForGroup(i + 4096);
            if (this.lastSpecialPrimaries[i] == 0) {
                return false;
            }
            this.result.append(0);
        }
        this.firstDigitPrimary = collationData.getFirstPrimaryForGroup(4100);
        this.firstLatinPrimary = collationData.getFirstPrimaryForGroup(25);
        this.lastLatinPrimary = collationData.getLastPrimaryForGroup(25);
        return (this.firstDigitPrimary == 0 || this.firstLatinPrimary == 0) ? false : true;
    }

    private void resetCEs() {
        this.contractionCEs.removeAllElements();
        this.uniqueCEs.removeAllElements();
        this.shortPrimaryOverflow = false;
        this.result.setLength(this.headerLength);
    }

    public boolean forData(CollationData collationData) {
        if (this.result.length() != 0) {
            og.n("attempt to reuse a CollationFastLatinBuilder");
            return false;
        }
        if (!loadGroups(collationData)) {
            return false;
        }
        this.firstShortPrimary = this.firstDigitPrimary;
        getCEs(collationData);
        encodeUniqueCEs();
        if (this.shortPrimaryOverflow) {
            this.firstShortPrimary = this.firstLatinPrimary;
            resetCEs();
            getCEs(collationData);
            encodeUniqueCEs();
        }
        boolean z = this.shortPrimaryOverflow;
        boolean z2 = !z;
        if (!z) {
            encodeCharCEs();
            encodeContractions();
        }
        this.contractionCEs.removeAllElements();
        this.uniqueCEs.removeAllElements();
        return z2;
    }

    public char[] getHeader() {
        int i = this.headerLength;
        char[] cArr = new char[i];
        this.result.getChars(0, i, cArr, 0);
        return cArr;
    }

    public char[] getTable() {
        int length = this.result.length();
        int i = this.headerLength;
        char[] cArr = new char[length - i];
        StringBuilder sb = this.result;
        sb.getChars(i, sb.length(), cArr, 0);
        return cArr;
    }
}
