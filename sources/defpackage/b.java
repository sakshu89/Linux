package defpackage;

import com.ibm.icu.lang.UCharacterEnums;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static final byte[] a;

    static {
        byte[] bytes = "0123456789abcdef".getBytes(px.a);
        bytes.getClass();
        a = bytes;
    }

    public static final String a(long j, ln lnVar) throws EOFException {
        if (j > 0) {
            long j2 = j - 1;
            if (lnVar.j(j2) == 13) {
                String strV = lnVar.v(j2, px.a);
                lnVar.skip(2L);
                return strV;
            }
        }
        String strV2 = lnVar.v(j, px.a);
        lnVar.skip(1L);
        return strV2;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x00a1 A[LOOP:0: B:8:0x001c->B:49:0x00a1, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:55:0x00a0 A[SYNTHETIC] */
    public static final int b(ln lnVar, fs1 fs1Var, boolean z) {
        int i;
        int i2;
        int i3;
        ze2 ze2Var;
        int i4;
        fs1Var.getClass();
        ze2 ze2Var2 = lnVar.a;
        if (ze2Var2 == null) {
            return z ? -2 : -1;
        }
        byte[] bArr = ze2Var2.a;
        int i5 = ze2Var2.b;
        int i6 = ze2Var2.c;
        int[] iArr = fs1Var.b;
        ze2 ze2Var3 = ze2Var2;
        int i7 = -1;
        int i8 = 0;
        loop0: while (true) {
            int i9 = i8 + 1;
            int i10 = iArr[i8];
            int i11 = i8 + 2;
            int i12 = iArr[i9];
            if (i12 != -1) {
                i7 = i12;
            }
            if (ze2Var3 == null) {
                break;
            }
            if (i10 >= 0) {
                int i13 = i5 + 1;
                int i14 = bArr[i5] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED;
                int i15 = i11 + i10;
                while (i11 != i15) {
                    if (i14 == iArr[i11]) {
                        i = iArr[i11 + i10];
                        if (i13 == i6) {
                            ze2Var3 = ze2Var3.f;
                            ze2Var3.getClass();
                            int i16 = ze2Var3.b;
                            byte[] bArr2 = ze2Var3.a;
                            i2 = ze2Var3.c;
                            if (ze2Var3 == ze2Var2) {
                                i3 = i16;
                                bArr = bArr2;
                                ze2Var3 = null;
                            } else {
                                i3 = i16;
                                bArr = bArr2;
                            }
                        } else {
                            i2 = i6;
                            i3 = i13;
                        }
                        if (i >= 0) {
                            return i;
                        }
                        int i17 = i2;
                        i8 = -i;
                        i5 = i3;
                        i6 = i17;
                    } else {
                        i11++;
                    }
                }
                return i7;
            }
            int i18 = (i10 * (-1)) + i11;
            while (true) {
                int i19 = i5 + 1;
                int i20 = i11 + 1;
                if ((bArr[i5] & UCharacterEnums.ECharacterDirection.DIRECTIONALITY_UNDEFINED) == iArr[i11]) {
                    boolean z2 = i20 == i18;
                    if (i19 == i6) {
                        ze2Var3.getClass();
                        ze2 ze2Var4 = ze2Var3.f;
                        ze2Var4.getClass();
                        i3 = ze2Var4.b;
                        byte[] bArr3 = ze2Var4.a;
                        i4 = ze2Var4.c;
                        if (ze2Var4 != ze2Var2) {
                            ze2Var = ze2Var4;
                            bArr = bArr3;
                        } else {
                            if (!z2) {
                                break loop0;
                            }
                            bArr = bArr3;
                            ze2Var = null;
                        }
                    } else {
                        ze2Var = ze2Var3;
                        i4 = i6;
                        i3 = i19;
                    }
                    if (z2) {
                        i = iArr[i20];
                        int i21 = i4;
                        ze2Var3 = ze2Var;
                        i2 = i21;
                        break;
                    }
                    i5 = i3;
                    i6 = i4;
                    ze2Var3 = ze2Var;
                    i11 = i20;
                }
                return i7;
            }
            if (i >= 0) {
                return i;
            }
            int i110 = i2;
            i8 = -i;
            i5 = i3;
            i6 = i110;
        }
        if (z) {
            return -2;
        }
        return i7;
    }
}
