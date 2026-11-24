package com.ibm.icu.impl;

import com.ibm.icu.util.BytesTrie;
import defpackage.dk0;
import defpackage.kf2;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.MissingResourceException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class UPropertyAliases {
    private static final int DATA_FORMAT = 1886282093;
    public static final UPropertyAliases INSTANCE;
    private static final IsAcceptable IS_ACCEPTABLE = new IsAcceptable(0);
    private static final int IX_BYTE_TRIES_OFFSET = 1;
    private static final int IX_NAME_GROUPS_OFFSET = 2;
    private static final int IX_RESERVED3_OFFSET = 3;
    private static final int IX_VALUE_MAPS_OFFSET = 0;
    private byte[] bytesTries;
    private String nameGroups;
    private int[] valueMaps;

    static {
        try {
            INSTANCE = new UPropertyAliases();
        } catch (IOException e) {
            MissingResourceException missingResourceException = new MissingResourceException("Could not construct UPropertyAliases. Missing pnames.icu", "", "");
            missingResourceException.initCause(e);
            throw missingResourceException;
        }
    }

    private UPropertyAliases() throws IOException {
        load(ICUBinary.getRequiredData("pnames.icu"));
    }

    private static int asciiToLowercase(int i) {
        return (65 > i || i > 90) ? i : i + 32;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0040  */
    /* JADX WARN: Code duplicated, block: B:24:0x0042  */
    /* JADX WARN: Code duplicated, block: B:28:0x004a  */
    /* JADX WARN: Code duplicated, block: B:30:0x004d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:32:0x0050  */
    /* JADX WARN: Code duplicated, block: B:33:0x0052 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:34:0x0054  */
    /* JADX WARN: Code duplicated, block: B:38:0x0061  */
    /* JADX WARN: Code duplicated, block: B:45:0x004f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:46:0x0060 A[SYNTHETIC] */
    public static int compare(String str, String str2) {
        boolean z;
        boolean z2;
        int iAsciiToLowercase;
        int i = 0;
        int i2 = 0;
        char cCharAt = 0;
        char cCharAt2 = 0;
        while (true) {
            if (i < str.length()) {
                cCharAt = str.charAt(i);
                if (cCharAt != ' ' && cCharAt != '-' && cCharAt != '_') {
                    switch (cCharAt) {
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                            break;
                    }
                }
                i++;
            }
            while (i2 < str2.length()) {
                cCharAt2 = str2.charAt(i2);
                if (cCharAt2 != ' ' && cCharAt2 != '-' && cCharAt2 != '_') {
                    switch (cCharAt2) {
                        case '\t':
                        case '\n':
                        case 11:
                        case '\f':
                        case '\r':
                            break;
                    }
                    if (i == str.length()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    z2 = i2 == str2.length();
                    if (z) {
                        if (z2) {
                            return 0;
                        }
                        cCharAt = 0;
                    } else if (z2) {
                        cCharAt2 = 0;
                    }
                    iAsciiToLowercase = asciiToLowercase(cCharAt) - asciiToLowercase(cCharAt2);
                    if (iAsciiToLowercase != 0) {
                        return iAsciiToLowercase;
                    }
                    i++;
                    i2++;
                }
                i2++;
            }
            if (i == str.length()) {
                z = true;
            } else {
                z = false;
            }
            if (i2 == str2.length()) {
            }
            if (z) {
                if (z2) {
                    return 0;
                }
                cCharAt = 0;
            } else if (z2) {
                cCharAt2 = 0;
            }
            iAsciiToLowercase = asciiToLowercase(cCharAt) - asciiToLowercase(cCharAt2);
            if (iAsciiToLowercase != 0) {
                return iAsciiToLowercase;
            }
            i++;
            i2++;
        }
    }

    private boolean containsName(BytesTrie bytesTrie, CharSequence charSequence) {
        BytesTrie.Result next = BytesTrie.Result.NO_VALUE;
        for (int i = 0; i < charSequence.length(); i++) {
            char cCharAt = charSequence.charAt(i);
            if (cCharAt != '-' && cCharAt != '_' && cCharAt != ' ' && ('\t' > cCharAt || cCharAt > '\r')) {
                if (!next.hasNext()) {
                    return false;
                }
                next = bytesTrie.next(asciiToLowercase(cCharAt));
            }
        }
        return next.hasValue();
    }

    private int findProperty(int i) {
        int i2 = 1;
        for (int i3 = this.valueMaps[0]; i3 > 0; i3--) {
            int[] iArr = this.valueMaps;
            int i4 = iArr[i2];
            int i5 = iArr[i2 + 1];
            int i6 = i2 + 2;
            if (i < i4) {
                break;
            }
            if (i < i5) {
                return ((i - i4) * 2) + i6;
            }
            i2 = i6 + ((i5 - i4) * 2);
        }
        return 0;
    }

    private int findPropertyValueNameGroup(int i, int i2) {
        if (i == 0) {
            return 0;
        }
        int i3 = i + 1;
        int i4 = i + 2;
        int i5 = this.valueMaps[i3];
        if (i5 >= 16) {
            int i6 = (i5 + i4) - 16;
            int i7 = i4;
            do {
                int[] iArr = this.valueMaps;
                int i8 = iArr[i7];
                if (i2 < i8) {
                    break;
                }
                if (i2 == i8) {
                    return iArr[(i6 + i7) - i4];
                }
                i7++;
            } while (i7 < i6);
        } else {
            while (i5 > 0) {
                int[] iArr2 = this.valueMaps;
                int i9 = iArr2[i4];
                int i10 = iArr2[i4 + 1];
                int i11 = i4 + 2;
                if (i2 < i9) {
                    break;
                }
                if (i2 < i10) {
                    return iArr2[(i11 + i2) - i9];
                }
                i4 = i11 + (i10 - i9);
                i5--;
            }
        }
        return 0;
    }

    private String getName(int i, int i2) {
        int i3;
        int i4 = i + 1;
        char cCharAt = this.nameGroups.charAt(i);
        if (i2 < 0 || cCharAt <= i2) {
            throw new IllegalIcuArgumentException("Invalid property (value) name choice");
        }
        while (i2 > 0) {
            while (true) {
                i3 = i4 + 1;
                if (this.nameGroups.charAt(i4) != 0) {
                    i4 = i3;
                }
            }
            i2--;
            i4 = i3;
        }
        int i5 = i4;
        while (this.nameGroups.charAt(i5) != 0) {
            i5++;
        }
        if (i4 == i5) {
            return null;
        }
        return this.nameGroups.substring(i4, i5);
    }

    private int getPropertyOrValueEnum(int i, CharSequence charSequence) {
        BytesTrie bytesTrie = new BytesTrie(this.bytesTries, i);
        if (containsName(bytesTrie, charSequence)) {
            return bytesTrie.getValue();
        }
        return -1;
    }

    private void load(ByteBuffer byteBuffer) throws IOException {
        ICUBinary.readHeader(byteBuffer, DATA_FORMAT, IS_ACCEPTABLE);
        int i = byteBuffer.getInt() / 4;
        if (i < 8) {
            dk0.h("pnames.icu: not enough indexes");
            return;
        }
        int[] iArr = new int[i];
        iArr[0] = i * 4;
        for (int i2 = 1; i2 < i; i2++) {
            iArr[i2] = byteBuffer.getInt();
        }
        int i3 = iArr[0];
        int i4 = iArr[1];
        this.valueMaps = ICUBinary.getInts(byteBuffer, (i4 - i3) / 4, 0);
        int i5 = iArr[2];
        byte[] bArr = new byte[i5 - i4];
        this.bytesTries = bArr;
        byteBuffer.get(bArr);
        int i6 = iArr[3] - i5;
        StringBuilder sb = new StringBuilder(i6);
        for (int i7 = 0; i7 < i6; i7++) {
            sb.append((char) byteBuffer.get());
        }
        this.nameGroups = sb.toString();
    }

    public int getPropertyEnum(CharSequence charSequence) {
        return getPropertyOrValueEnum(0, charSequence);
    }

    public String getPropertyName(int i, int i2) {
        int iFindProperty = findProperty(i);
        if (iFindProperty != 0) {
            return getName(this.valueMaps[iFindProperty], i2);
        }
        kf2.d(i, "Invalid property enum ", Integer.toHexString(i), ")");
        return null;
    }

    public int getPropertyValueEnum(int i, CharSequence charSequence) {
        int iFindProperty = findProperty(i);
        if (iFindProperty == 0) {
            kf2.d(i, "Invalid property enum ", Integer.toHexString(i), ")");
            return 0;
        }
        int[] iArr = this.valueMaps;
        int i2 = iArr[iFindProperty + 1];
        if (i2 != 0) {
            return getPropertyOrValueEnum(iArr[i2], charSequence);
        }
        kf2.d(i, "Property ", Integer.toHexString(i), ") does not have named values");
        return 0;
    }

    public int getPropertyValueEnumNoThrow(int i, CharSequence charSequence) {
        int[] iArr;
        int i2;
        int iFindProperty = findProperty(i);
        if (iFindProperty == 0 || (i2 = (iArr = this.valueMaps)[iFindProperty + 1]) == 0) {
            return -1;
        }
        return getPropertyOrValueEnum(iArr[i2], charSequence);
    }

    public String getPropertyValueName(int i, int i2, int i3) {
        int iFindProperty = findProperty(i);
        if (iFindProperty == 0) {
            kf2.d(i, "Invalid property enum ", Integer.toHexString(i), ")");
            return null;
        }
        int iFindPropertyValueNameGroup = findPropertyValueNameGroup(this.valueMaps[iFindProperty + 1], i2);
        if (iFindPropertyValueNameGroup != 0) {
            return getName(iFindPropertyValueNameGroup, i3);
        }
        kf2.d(i, "Property ", Integer.toHexString(i), ") does not have named values");
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class IsAcceptable implements ICUBinary.Authenticate {
        public /* synthetic */ IsAcceptable(int i) {
            this();
        }

        @Override // com.ibm.icu.impl.ICUBinary.Authenticate
        public boolean isDataVersionAcceptable(byte[] bArr) {
            return bArr[0] == 2;
        }

        private IsAcceptable() {
        }
    }
}
