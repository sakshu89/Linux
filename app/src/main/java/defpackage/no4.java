package defpackage;

import com.ibm.icu.impl.PatternTokenizer;
import com.ibm.icu.lang.UCharacterEnums;
import java.net.IDN;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class no4 {
    /* JADX WARN: Code duplicated, block: B:55:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ac A[LOOP:1: B:54:0x00a0->B:57:0x00ac, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:79:0x00b2 A[EDGE_INSN: B:79:0x00b2->B:58:0x00b2 BREAK  A[LOOP:1: B:54:0x00a0->B:57:0x00ac], SYNTHETIC] */
    public static final InetAddress a(int i, int i2, String str) {
        int i3;
        int i4;
        int iR;
        byte[] bArr = new byte[16];
        int i5 = i;
        int i6 = 0;
        int i7 = -1;
        int i8 = -1;
        while (i5 < i2) {
            if (i6 == 16) {
                return null;
            }
            int i9 = i5 + 2;
            if (i9 <= i2 && js2.j(str, "::", i5, false)) {
                if (i7 != -1) {
                    return null;
                }
                i6 += 2;
                i7 = i6;
                if (i9 == i2) {
                    break;
                }
                i8 = i9;
                i3 = 0;
                i5 = i8;
                while (i5 < i2) {
                    iR = z53.r(str.charAt(i5));
                    if (iR != -1) {
                        break;
                        break;
                    }
                    i3 = (i3 << 4) + iR;
                    i5++;
                }
                i4 = i5 - i8;
                return i4 == 0 ? null : null;
            }
            if (i6 != 0) {
                if (!js2.j(str, ":", i5, false)) {
                    if (!js2.j(str, ".", i5, false)) {
                        return null;
                    }
                    int i10 = i6 - 2;
                    int i11 = i10;
                    while (i8 < i2) {
                        if (i11 == 16) {
                            return null;
                        }
                        if (i11 != i10) {
                            if (str.charAt(i8) != '.') {
                                return null;
                            }
                            i8++;
                        }
                        int i12 = 0;
                        int i13 = i8;
                        while (i13 < i2) {
                            char cCharAt = str.charAt(i13);
                            if (g31.b(cCharAt, 48) < 0 || g31.b(cCharAt, 57) > 0) {
                                break;
                            }
                            if ((i12 == 0 && i8 != i13) || (i12 = ((i12 * 10) + cCharAt) - 48) > 255) {
                                return null;
                            }
                            i13++;
                        }
                        if (i13 - i8 == 0) {
                            return null;
                        }
                        bArr[i11] = (byte) i12;
                        i11++;
                        i8 = i13;
                    }
                    if (i11 != i6 + 2) {
                        return null;
                    }
                    i6 += 2;
                    break;
                }
                i5++;
            }
            i8 = i5;
            i3 = 0;
            i5 = i8;
            while (i5 < i2) {
                iR = z53.r(str.charAt(i5));
                if (iR != -1) {
                    break;
                }
                i3 = (i3 << 4) + iR;
                i5++;
            }
            i4 = i5 - i8;
            if (i4 == 0 && i4 <= 4) {
                int i14 = i6 + 1;
                bArr[i6] = (byte) (255 & (i3 >>> 8));
                i6 += 2;
                bArr[i14] = (byte) (i3 & 255);
            }
        }
        if (i6 != 16) {
            if (i7 == -1) {
                return null;
            }
            int i15 = i6 - i7;
            System.arraycopy(bArr, i7, bArr, 16 - i15, i15);
            Arrays.fill(bArr, i7, (16 - i6) + i7, (byte) 0);
        }
        return InetAddress.getByAddress(bArr);
    }

    public static final String b(String str) {
        str.getClass();
        int i = 0;
        int i2 = -1;
        if (!cs2.n(str, ":", false)) {
            try {
                String ascii = IDN.toASCII(str);
                ascii.getClass();
                Locale locale = Locale.US;
                locale.getClass();
                String lowerCase = ascii.toLowerCase(locale);
                lowerCase.getClass();
                if (lowerCase.length() == 0) {
                    return null;
                }
                int length = lowerCase.length();
                for (int i3 = 0; i3 < length; i3++) {
                    char cCharAt = lowerCase.charAt(i3);
                    if (g31.b(cCharAt, 31) <= 0 || g31.b(cCharAt, 127) >= 0 || cs2.x(" #%/:?@[\\]", cCharAt, 0, 6) != -1) {
                        return null;
                    }
                }
                return lowerCase;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        InetAddress inetAddressA = (js2.k(str, "[", false) && js2.e(str, "]", false)) ? a(1, str.length() - 1, str) : a(0, str.length(), str);
        if (inetAddressA == null) {
            return null;
        }
        byte[] address = inetAddressA.getAddress();
        if (address.length != 16) {
            if (address.length == 4) {
                return inetAddressA.getHostAddress();
            }
            throw new AssertionError("Invalid IPv6 address: '" + str + PatternTokenizer.SINGLE_QUOTE);
        }
        int i4 = 0;
        int i5 = 0;
        while (i4 < address.length) {
            int i6 = i4;
            while (i6 < 16 && address[i6] == 0 && address[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i2 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        ln lnVar = new ln();
        while (i < address.length) {
            if (i == i2) {
                lnVar.E(58);
                i += i5;
                if (i == 16) {
                    lnVar.E(58);
                }
            } else {
                if (i > 0) {
                    lnVar.E(58);
                }
                byte b = address[i];
                byte[] bArr = z53.a;
                lnVar.H(((b & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) << 8) | (address[i + 1] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED));
                i += 2;
            }
        }
        return lnVar.w();
    }
}
