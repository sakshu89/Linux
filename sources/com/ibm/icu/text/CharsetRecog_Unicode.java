package com.ibm.icu.text;

import com.ibm.icu.lang.UCharacterEnums;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
abstract class CharsetRecog_Unicode extends CharsetRecognizer {

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CharsetRecog_UTF_16_BE extends CharsetRecog_Unicode {
        @Override // com.ibm.icu.text.CharsetRecog_Unicode, com.ibm.icu.text.CharsetRecognizer
        public String getName() {
            return "UTF-16BE";
        }

        @Override // com.ibm.icu.text.CharsetRecog_Unicode, com.ibm.icu.text.CharsetRecognizer
        public CharsetMatch match(CharsetDetector charsetDetector) {
            byte[] bArr = charsetDetector.fRawInput;
            int iMin = Math.min(bArr.length, 30);
            int iAdjustConfidence = 10;
            for (int i = 0; i < iMin - 1; i += 2) {
                int iCodeUnit16FromBytes = CharsetRecog_Unicode.codeUnit16FromBytes(bArr[i], bArr[i + 1]);
                if (i == 0 && iCodeUnit16FromBytes == 65279) {
                    iAdjustConfidence = 100;
                    break;
                }
                iAdjustConfidence = CharsetRecog_Unicode.adjustConfidence(iCodeUnit16FromBytes, iAdjustConfidence);
                if (iAdjustConfidence == 0 || iAdjustConfidence == 100) {
                    break;
                }
            }
            int i2 = (iMin >= 4 || iAdjustConfidence >= 100) ? iAdjustConfidence : 0;
            if (i2 > 0) {
                return new CharsetMatch(charsetDetector, this, i2);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CharsetRecog_UTF_16_LE extends CharsetRecog_Unicode {
        @Override // com.ibm.icu.text.CharsetRecog_Unicode, com.ibm.icu.text.CharsetRecognizer
        public String getName() {
            return "UTF-16LE";
        }

        @Override // com.ibm.icu.text.CharsetRecog_Unicode, com.ibm.icu.text.CharsetRecognizer
        public CharsetMatch match(CharsetDetector charsetDetector) {
            byte[] bArr = charsetDetector.fRawInput;
            int iMin = Math.min(bArr.length, 30);
            int iAdjustConfidence = 10;
            for (int i = 0; i < iMin - 1; i += 2) {
                int iCodeUnit16FromBytes = CharsetRecog_Unicode.codeUnit16FromBytes(bArr[i + 1], bArr[i]);
                if (i == 0 && iCodeUnit16FromBytes == 65279) {
                    iAdjustConfidence = 100;
                    break;
                }
                iAdjustConfidence = CharsetRecog_Unicode.adjustConfidence(iCodeUnit16FromBytes, iAdjustConfidence);
                if (iAdjustConfidence == 0 || iAdjustConfidence == 100) {
                    break;
                }
            }
            int i2 = (iMin >= 4 || iAdjustConfidence >= 100) ? iAdjustConfidence : 0;
            if (i2 > 0) {
                return new CharsetMatch(charsetDetector, this, i2);
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class CharsetRecog_UTF_32 extends CharsetRecog_Unicode {
        public abstract int getChar(byte[] bArr, int i);

        @Override // com.ibm.icu.text.CharsetRecog_Unicode, com.ibm.icu.text.CharsetRecognizer
        public abstract String getName();

        /* JADX WARN: Code duplicated, block: B:26:0x0042  */
        /* JADX WARN: Code duplicated, block: B:31:0x004c  */
        @Override // com.ibm.icu.text.CharsetRecog_Unicode, com.ibm.icu.text.CharsetRecognizer
        public CharsetMatch match(CharsetDetector charsetDetector) {
            byte[] bArr = charsetDetector.fRawInput;
            int i = (charsetDetector.fRawLength / 4) * 4;
            if (i == 0) {
                return null;
            }
            int i2 = 0;
            boolean z = getChar(bArr, 0) == 65279;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5 += 4) {
                int i6 = getChar(bArr, i5);
                if (i6 < 0 || i6 >= 1114111 || (i6 >= 55296 && i6 <= 57343)) {
                    i3++;
                } else {
                    i4++;
                }
            }
            if (z && i3 == 0) {
                i2 = 100;
            } else if (z && i4 > i3 * 10) {
                i2 = 80;
            } else if (i4 > 3 && i3 == 0) {
                i2 = 100;
            } else if (i4 > 0 && i3 == 0) {
                i2 = 80;
            } else if (i4 > i3 * 10) {
                i2 = 25;
            }
            if (i2 == 0) {
                return null;
            }
            return new CharsetMatch(charsetDetector, this, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CharsetRecog_UTF_32_BE extends CharsetRecog_UTF_32 {
        @Override // com.ibm.icu.text.CharsetRecog_Unicode.CharsetRecog_UTF_32
        public int getChar(byte[] bArr, int i) {
            return ((bArr[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 24) | ((bArr[i + 1] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 16) | ((bArr[i + 2] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 8) | (bArr[i + 3] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED);
        }

        @Override // com.ibm.icu.text.CharsetRecog_Unicode.CharsetRecog_UTF_32, com.ibm.icu.text.CharsetRecog_Unicode, com.ibm.icu.text.CharsetRecognizer
        public String getName() {
            return "UTF-32BE";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CharsetRecog_UTF_32_LE extends CharsetRecog_UTF_32 {
        @Override // com.ibm.icu.text.CharsetRecog_Unicode.CharsetRecog_UTF_32
        public int getChar(byte[] bArr, int i) {
            return ((bArr[i + 3] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 24) | ((bArr[i + 2] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 16) | ((bArr[i + 1] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 8) | (bArr[i] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED);
        }

        @Override // com.ibm.icu.text.CharsetRecog_Unicode.CharsetRecog_UTF_32, com.ibm.icu.text.CharsetRecog_Unicode, com.ibm.icu.text.CharsetRecognizer
        public String getName() {
            return "UTF-32LE";
        }
    }

    public static int adjustConfidence(int i, int i2) {
        if (i == 0) {
            i2 -= 10;
        } else if ((i >= 32 && i <= 255) || i == 10) {
            i2 += 10;
        }
        if (i2 < 0) {
            return 0;
        }
        if (i2 > 100) {
            return 100;
        }
        return i2;
    }

    public static int codeUnit16FromBytes(byte b, byte b2) {
        return ((b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 8) | (b2 & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED);
    }

    @Override // com.ibm.icu.text.CharsetRecognizer
    public abstract String getName();

    @Override // com.ibm.icu.text.CharsetRecognizer
    public abstract CharsetMatch match(CharsetDetector charsetDetector);
}
