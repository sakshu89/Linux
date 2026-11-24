package com.ibm.icu.text;

import com.ibm.icu.lang.UCharacterEnums;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
abstract class CharsetRecog_2022 extends CharsetRecognizer {

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CharsetRecog_2022CN extends CharsetRecog_2022 {
        private byte[][] escapeSequences = {new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 36, 41, 65}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 36, 41, 71}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 36, 42, 72}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 36, 41, 69}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 36, 43, 73}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 36, 43, 74}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 36, 43, 75}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 36, 43, 76}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 36, 43, 77}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 78}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 79}};

        @Override // com.ibm.icu.text.CharsetRecognizer
        public String getName() {
            return "ISO-2022-CN";
        }

        @Override // com.ibm.icu.text.CharsetRecognizer
        public CharsetMatch match(CharsetDetector charsetDetector) {
            int iMatch = match(charsetDetector.fInputBytes, charsetDetector.fInputLen, this.escapeSequences);
            if (iMatch == 0) {
                return null;
            }
            return new CharsetMatch(charsetDetector, this, iMatch);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CharsetRecog_2022JP extends CharsetRecog_2022 {
        private byte[][] escapeSequences = {new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 36, 40, 67}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 36, 40, 68}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 36, 64}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 36, 65}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 36, 66}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 38, 64}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 40, 66}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 40, 72}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 40, 73}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 40, 74}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 46, 65}, new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 46, 70}};

        @Override // com.ibm.icu.text.CharsetRecognizer
        public String getName() {
            return "ISO-2022-JP";
        }

        @Override // com.ibm.icu.text.CharsetRecognizer
        public CharsetMatch match(CharsetDetector charsetDetector) {
            int iMatch = match(charsetDetector.fInputBytes, charsetDetector.fInputLen, this.escapeSequences);
            if (iMatch == 0) {
                return null;
            }
            return new CharsetMatch(charsetDetector, this, iMatch);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CharsetRecog_2022KR extends CharsetRecog_2022 {
        private byte[][] escapeSequences = {new byte[]{UCharacterEnums.ECharacterCategory.OTHER_SYMBOL, 36, 41, 67}};

        @Override // com.ibm.icu.text.CharsetRecognizer
        public String getName() {
            return "ISO-2022-KR";
        }

        @Override // com.ibm.icu.text.CharsetRecognizer
        public CharsetMatch match(CharsetDetector charsetDetector) {
            int iMatch = match(charsetDetector.fInputBytes, charsetDetector.fInputLen, this.escapeSequences);
            if (iMatch == 0) {
                return null;
            }
            return new CharsetMatch(charsetDetector, this, iMatch);
        }
    }

    /* JADX WARN: Code duplicated, block: B:25:0x003e  */
    public int match(byte[] bArr, int i, byte[][] bArr2) {
        byte b;
        int length = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (length < i) {
            if (bArr[length] == 27) {
                int i5 = 0;
                while (true) {
                    if (i5 < bArr2.length) {
                        byte[] bArr3 = bArr2[i5];
                        if (i - length >= bArr3.length) {
                            int i6 = 1;
                            while (true) {
                                if (i6 >= bArr3.length) {
                                    i2++;
                                    length += bArr3.length - 1;
                                } else if (bArr3[i6] == bArr[length + i6]) {
                                    i6++;
                                }
                            }
                        }
                        i5++;
                    } else {
                        i3++;
                        b = bArr[length];
                        if (b != 14 || b == 15) {
                            i4++;
                        }
                    }
                }
            } else {
                b = bArr[length];
                if (b != 14) {
                    i4++;
                } else {
                    i4++;
                }
            }
            length++;
        }
        if (i2 == 0) {
            return 0;
        }
        int i7 = ((i2 * 100) - (i3 * 100)) / (i3 + i2);
        int i8 = i2 + i4;
        if (i8 < 5) {
            i7 -= (5 - i8) * 10;
        }
        if (i7 < 0) {
            return 0;
        }
        return i7;
    }
}
