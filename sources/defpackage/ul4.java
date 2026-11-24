package defpackage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.ibm.icu.impl.UCharacterProperty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ul4 {
    /* JADX WARN: Code duplicated, block: B:73:0x0180  */
    /* JADX WARN: Code duplicated, block: B:75:0x0185  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r20v10 */
    /* JADX WARN: Type inference failed for: r20v12 */
    /* JADX WARN: Type inference failed for: r20v13 */
    /* JADX WARN: Type inference failed for: r20v4 */
    /* JADX WARN: Type inference failed for: r20v8 */
    /* JADX WARN: Type inference failed for: r20v9 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v42 */
    /* JADX WARN: Type inference failed for: r2v48 */
    /* JADX WARN: Type inference failed for: r2v49 */
    /* JADX WARN: Type inference failed for: r2v50 */
    /* JADX WARN: Type inference failed for: r34v6 */
    /* JADX WARN: Type inference failed for: r34v7 */
    /* JADX WARN: Type inference failed for: r34v8 */
    /* JADX WARN: Type inference failed for: r36v0 */
    /* JADX WARN: Type inference failed for: r38v4 */
    /* JADX WARN: Type inference failed for: r38v5 */
    /* JADX WARN: Type inference failed for: r38v6 */
    /* JADX WARN: Type inference failed for: r5v25, types: [int] */
    /* JADX WARN: Type inference failed for: r5v27 */
    /* JADX WARN: Type inference failed for: r5v45 */
    public static List a(int i, int i2, Rect rect, d80 d80Var) {
        boolean[] zArr;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr;
        int[] iArr2;
        int i7;
        int[] iArr3;
        int i8;
        ?? r20;
        int i9;
        ?? r2;
        int i10;
        int i11;
        int i12;
        rect.getClass();
        int i13 = rect.right;
        int i14 = rect.left;
        int i15 = i13 - i14;
        int i16 = rect.bottom;
        int i17 = rect.top;
        int i18 = i16 - i17;
        if (i14 >= 0 && i17 >= 0 && i13 <= i && i16 <= i2 && i15 >= 8 && i18 >= 8 && i18 <= 512) {
            boolean z = true;
            int iMax = Math.max(1, (i15 + UCharacterProperty.MAX_SCRIPT) / 1024);
            int i19 = i15 / iMax;
            int i20 = i18 / iMax;
            if (i19 >= 8 && i20 >= 8) {
                int i21 = i19 * i20;
                int[] iArr4 = new int[i21];
                int iMin = 255;
                int i22 = 0;
                int iMax2 = 0;
                while (i22 < i20) {
                    int i23 = 0;
                    while (i23 < i19) {
                        boolean z2 = z;
                        int iIntValue = ((Number) d80Var.e(Integer.valueOf((i23 * iMax) + rect.left), Integer.valueOf((i22 * iMax) + rect.top))).intValue();
                        if ((iIntValue >>> 24) >= 128) {
                            int i24 = (((iIntValue & 255) * 19) + ((((iIntValue >>> 8) & 255) * 183) + (((iIntValue >>> 16) & 255) * 54))) / 256;
                            iArr4[(i22 * i19) + i23] = i24;
                            iMin = Math.min(iMin, i24);
                            iMax2 = Math.max(iMax2, i24);
                            i23++;
                            z = z2;
                        }
                    }
                    i22++;
                    z = z;
                }
                boolean z3 = z;
                int i25 = 0;
                int i26 = iMax2 - iMin;
                if (i26 >= 48) {
                    ArrayList arrayList = new ArrayList();
                    int[] iArr5 = {35, 50, 65};
                    int i27 = 0;
                    while (i27 < 3) {
                        int i28 = iArr5[i27];
                        Iterator it = nz.i(Boolean.TRUE, Boolean.FALSE).iterator();
                        while (it.hasNext()) {
                            boolean zBooleanValue = ((Boolean) it.next()).booleanValue();
                            int i29 = ((i26 * i28) / 100) + iMin;
                            boolean[] zArr2 = new boolean[i21];
                            int i30 = i25;
                            while (i30 < i21) {
                                int i31 = i30;
                                zArr2[i31] = (!zBooleanValue ? iArr4[i31] > i29 : iArr4[i31] < i29) ? i25 : z3;
                                i30 = i31 + 1;
                            }
                            boolean[] zArr3 = new boolean[i21];
                            int[] iArr6 = new int[i21];
                            int i32 = i25;
                            while (i32 < i21) {
                                if (!zArr2[i32] || zArr3[i32]) {
                                    zArr = zArr3;
                                    i3 = iMax;
                                    i4 = i19;
                                    i5 = i21;
                                    i6 = i20;
                                    iArr = iArr4;
                                    iArr2 = iArr5;
                                    i7 = i27;
                                    iArr3 = iArr6;
                                } else {
                                    iArr6[i25] = i32;
                                    zArr3[i32] = z3;
                                    int i33 = i25;
                                    zArr = zArr3;
                                    i3 = iMax;
                                    i5 = i21;
                                    iArr = iArr4;
                                    iArr2 = iArr5;
                                    i7 = i27;
                                    iArr3 = iArr6;
                                    ?? r3 = z3;
                                    int i34 = i33 == true ? 1 : 0;
                                    int iMax3 = i34 == true ? 1 : 0;
                                    int iMax4 = iMax3;
                                    int i35 = i19;
                                    int iMin2 = i20;
                                    ?? r21 = i33;
                                    while (i34 < r3) {
                                        int i36 = i34 + 1;
                                        int i37 = iArr3[i34];
                                        int i38 = i37 % i19;
                                        int i39 = i37 / i19;
                                        int iMin3 = Math.min(i35, i38);
                                        iMax3 = Math.max(iMax3, i38);
                                        iMin2 = Math.min(iMin2, i39);
                                        iMax4 = Math.max(iMax4, i39);
                                        if (r21 != 0 || i38 == 0 || i39 == 0) {
                                            i8 = iMin3;
                                        } else {
                                            i8 = iMin3;
                                            if (i38 != i19 - 1 && i39 != i20 - 1) {
                                                r20 = i25;
                                            }
                                            i9 = -1;
                                            r2 = r3;
                                            while (true) {
                                                if (i9 < 2) {
                                                    int i40 = r2 == true ? 1 : 0;
                                                    i11 = -1;
                                                    for (i10 = 2; i11 < i10; i10 = 2) {
                                                        i12 = i38 + i11;
                                                        int i41 = i11;
                                                        int i42 = i39 + i9;
                                                        if (i12 < 0 && i12 < i19 && i42 >= 0 && i42 < i20) {
                                                            int i43 = (i42 * i19) + i12;
                                                            if (zArr2[i43] && !zArr[i43]) {
                                                                zArr[i43] = z3;
                                                                int i44 = (i40 == true ? 1 : 0) + 1;
                                                                iArr3[i40 == true ? 1 : 0] = i43;
                                                                i40 = i44;
                                                            }
                                                        }
                                                        i11 = i41 + 1;
                                                    }
                                                    i9++;
                                                    r2 = i40 == true ? 1 : 0;
                                                }
                                            }
                                            i34 = i36;
                                            i35 = i8;
                                            r3 = r2;
                                            r21 = r20;
                                        }
                                        r20 = z3;
                                        i9 = -1;
                                        r2 = r3;
                                        while (true) {
                                            if (i9 < 2) {
                                                int i45 = r2 == true ? 1 : 0;
                                                i11 = -1;
                                                while (i11 < i10) {
                                                    i12 = i38 + i11;
                                                    int i46 = i11;
                                                    int i47 = i39 + i9;
                                                    if (i12 < 0) {
                                                    }
                                                    i11 = i46 + 1;
                                                }
                                                i9++;
                                                r2 = i45 == true ? 1 : 0;
                                            }
                                        }
                                        i34 = i36;
                                        i35 = i8;
                                        r3 = r2;
                                        r21 = r20;
                                    }
                                    if (r21 != 0 || r3 < 8) {
                                        i4 = i19;
                                    } else {
                                        int i48 = iMax3 - i35;
                                        int i49 = iMax4 - iMin2;
                                        i4 = i19;
                                        if (i48 >= 5 && i49 >= 5) {
                                            float f = i48;
                                            float f2 = i49;
                                            if (f <= f2 * 1.46f && f2 <= 1.46f * f) {
                                                float f3 = r3 == true ? 1.0f : 0.0f;
                                                float f4 = f3 / ((i49 + 1) * (i48 + 1));
                                                if (0.08f <= f4 && f4 <= 0.68f) {
                                                    int i50 = i35;
                                                    boolean[] zArr4 = new boolean[9];
                                                    boolean[] zArr5 = new boolean[9];
                                                    int i51 = i25;
                                                    int i52 = i51;
                                                    ?? r4 = r3;
                                                    while (i51 < r4) {
                                                        int i53 = iArr3[i51];
                                                        ?? r36 = r4;
                                                        int i54 = (i53 % i4) - i50;
                                                        int i55 = i51;
                                                        float f5 = ((i54 * 2.0f) / f) - 1.0f;
                                                        float f6 = ((((i53 / i4) - iMin2) * 2.0f) / f2) - 1.0f;
                                                        int i56 = i20;
                                                        int i57 = i25;
                                                        int iC = ky3.c((i54 * 8) / i48, i57, 8);
                                                        ?? r38 = Math.abs(f5 - f6) <= 0.3f ? z3 : i57;
                                                        ?? r34 = Math.abs(f5 + f6) <= 0.3f ? z3 : i57;
                                                        if (r38 != 0) {
                                                            zArr4[iC] = z3;
                                                        }
                                                        if (r34 != 0) {
                                                            zArr5[iC] = z3;
                                                        }
                                                        if (r38 != 0 || r34 != 0) {
                                                            i52++;
                                                        }
                                                        i51 = i55 + 1;
                                                        i25 = i57;
                                                        i20 = i56;
                                                        r4 = r36 == true ? 1 : 0;
                                                    }
                                                    i6 = i20;
                                                    int i58 = i25;
                                                    if (i52 >= 0.84f * f3) {
                                                        int i59 = i58;
                                                        int i60 = i59;
                                                        while (i59 < 9) {
                                                            if (zArr4[i59]) {
                                                                i60++;
                                                            }
                                                            i59++;
                                                        }
                                                        if (i60 >= 7) {
                                                            int i61 = i58;
                                                            int i62 = i61;
                                                            while (i61 < 9) {
                                                                if (zArr5[i61]) {
                                                                    i62++;
                                                                }
                                                                i61++;
                                                            }
                                                            if (i62 >= 7) {
                                                                int iMax5 = Math.max(3, Math.max(i48, i49) / 2);
                                                                boolean z4 = z3;
                                                                int iMax6 = Math.max(z4 ? 1 : 0, iMin2 - iMax5);
                                                                int iMin4 = Math.min(i6 - 2, iMax4 + iMax5);
                                                                int i63 = 0;
                                                                ?? r5 = z4;
                                                                if (iMax6 <= iMin4) {
                                                                    while (true) {
                                                                        int iMax7 = Math.max((int) r5, i50 - iMax5);
                                                                        int i64 = iMax5;
                                                                        int iMin5 = Math.min(i4 - 2, iMax3 + i64);
                                                                        if (iMax7 <= iMin5) {
                                                                            while (true) {
                                                                                if (zArr2[(iMax6 * i4) + iMax7]) {
                                                                                    i63++;
                                                                                }
                                                                                if (iMax7 == iMin5) {
                                                                                    break;
                                                                                }
                                                                                iMax7++;
                                                                            }
                                                                        }
                                                                        if (iMax6 == iMin4) {
                                                                            break;
                                                                        }
                                                                        iMax6++;
                                                                        iMax5 = i64;
                                                                        r5 = 1;
                                                                    }
                                                                }
                                                                if (f3 >= i63 * 0.8f) {
                                                                    Rect rect2 = new Rect();
                                                                    rect2.left = (i50 * i3) + rect.left;
                                                                    rect2.top = (iMin2 * i3) + rect.top;
                                                                    rect2.right = Math.min(rect.right, ((iMax3 + 1) * i3) + rect.left);
                                                                    rect2.bottom = Math.min(rect.bottom, ((iMax4 + 1) * i3) + rect.top);
                                                                    if (arrayList.isEmpty()) {
                                                                        arrayList.add(rect2);
                                                                        break;
                                                                    }
                                                                    int size = arrayList.size();
                                                                    int i65 = 0;
                                                                    while (true) {
                                                                        if (i65 >= size) {
                                                                            arrayList.add(rect2);
                                                                            break;
                                                                            break;
                                                                        }
                                                                        Object obj = arrayList.get(i65);
                                                                        i65++;
                                                                        Rect rect3 = (Rect) obj;
                                                                        if (Math.min(rect3.right, rect2.right) > Math.max(rect3.left, rect2.left) && Math.min(rect3.bottom, rect2.bottom) > Math.max(rect3.top, rect2.top)) {
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i6 = i20;
                                }
                                i32++;
                                i20 = i6;
                                zArr3 = zArr;
                                iMax = i3;
                                i19 = i4;
                                i21 = i5;
                                iArr4 = iArr;
                                iArr5 = iArr2;
                                i27 = i7;
                                iArr6 = iArr3;
                                z3 = true;
                                i25 = 0;
                            }
                            z3 = true;
                            i25 = 0;
                        }
                        i27++;
                        z3 = true;
                        i25 = 0;
                    }
                    return arrayList;
                }
            }
        }
        return ii0.a;
    }

    public static List b(Bitmap bitmap, Rect rect) {
        bitmap.getClass();
        rect.getClass();
        if (!bitmap.isRecycled()) {
            try {
                return a(bitmap.getWidth(), bitmap.getHeight(), rect, new d80(2, bitmap, Bitmap.class, "getPixel", "getPixel(II)I", 0, 0, 0));
            } catch (IllegalArgumentException | IllegalStateException unused) {
            }
        }
        return ii0.a;
    }
}
