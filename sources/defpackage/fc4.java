package defpackage;

import android.graphics.RectF;
import android.text.Layout;
import java.text.Bidi;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class fc4 {
    public static final float a(float[] fArr, int i, int i2) {
        return fArr[((i - i2) * 2) + 1];
    }

    /* JADX WARN: Code duplicated, block: B:144:0x025e A[EDGE_INSN: B:144:0x025e->B:171:0x02ba BREAK  A[LOOP:5: B:154:0x027a->B:206:0x027a]] */
    /* JADX WARN: Code duplicated, block: B:86:0x01a6  */
    public static final int b(ez2 ez2Var, Layout layout, cj cjVar, int i, RectF rectF, bf2 bf2Var, ha haVar, boolean z) {
        b71[] b71VarArr;
        b71[] b71VarArr2;
        int i2;
        int iD;
        int i3;
        int i4;
        int iA;
        Bidi bidiCreateLineBidi;
        float fA;
        float fA2;
        float fA3;
        int lineTop = layout.getLineTop(i);
        int lineBottom = layout.getLineBottom(i);
        int lineStart = layout.getLineStart(i);
        int lineEnd = layout.getLineEnd(i);
        if (lineStart == lineEnd) {
            return -1;
        }
        int i5 = (lineEnd - lineStart) * 2;
        float[] fArr = new float[i5];
        Layout layout2 = ez2Var.f;
        int lineStart2 = layout2.getLineStart(i);
        int iF = ez2Var.f(i);
        if (i5 < (iF - lineStart2) * 2) {
            a11.a("array.size - arrayStart must be greater or equal than (endOffset - startOffset) * 2");
        }
        rw0 rw0Var = new rw0(ez2Var);
        boolean z2 = false;
        boolean z3 = layout2.getParagraphDirection(i) == 1;
        int i6 = 0;
        while (lineStart2 < iF) {
            boolean zIsRtlCharAt = layout2.isRtlCharAt(lineStart2);
            if (z3 && !zIsRtlCharAt) {
                fA = rw0Var.a(lineStart2, z2, z2, true);
                fA3 = rw0Var.a(lineStart2 + 1, true, true, true);
            } else if (z3 && zIsRtlCharAt) {
                fA3 = rw0Var.a(lineStart2, false, false, false);
                fA = rw0Var.a(lineStart2 + 1, true, true, false);
            } else {
                if (zIsRtlCharAt) {
                    fA2 = rw0Var.a(lineStart2, false, false, true);
                    fA = rw0Var.a(lineStart2 + 1, true, true, true);
                } else {
                    fA = rw0Var.a(lineStart2, false, false, false);
                    fA2 = rw0Var.a(lineStart2 + 1, true, true, false);
                }
                fA3 = fA2;
            }
            fArr[i6] = fA;
            fArr[i6 + 1] = fA3;
            i6 += 2;
            lineStart2++;
            z3 = z3;
            z2 = false;
        }
        Layout layout3 = (Layout) cjVar.b;
        int lineStart3 = layout3.getLineStart(i);
        int lineEnd2 = layout3.getLineEnd(i);
        int iS = cjVar.s(lineStart3, false);
        int iT = cjVar.t(iS);
        int i7 = lineStart3 - iT;
        int i8 = lineEnd2 - iT;
        Bidi bidiF = cjVar.f(iS);
        if (bidiF == null || (bidiCreateLineBidi = bidiF.createLineBidi(i7, i8)) == null) {
            b71VarArr = new b71[]{new b71(lineStart3, lineEnd2, layout3.isRtlCharAt(lineStart3))};
        } else {
            int runCount = bidiCreateLineBidi.getRunCount();
            b71VarArr = new b71[runCount];
            int i9 = 0;
            while (i9 < runCount) {
                int i10 = runCount;
                b71VarArr[i9] = new b71(bidiCreateLineBidi.getRunStart(i9) + lineStart3, bidiCreateLineBidi.getRunLimit(i9) + lineStart3, bidiCreateLineBidi.getRunLevel(i9) % 2 == 1);
                i9++;
                runCount = i10;
            }
        }
        f21 h21Var = z ? new h21(0, b71VarArr.length - 1, 1) : new f21(b71VarArr.length - 1, 0, -1);
        int i11 = h21Var.a;
        int i12 = h21Var.b;
        int i13 = h21Var.c;
        if ((i13 <= 0 || i11 > i12) && (i13 >= 0 || i12 > i11)) {
            return -1;
        }
        while (true) {
            b71 b71Var = b71VarArr[i11];
            boolean z4 = b71Var.c;
            int iE = b71Var.a;
            int iF2 = b71Var.b;
            float f = z4 ? fArr[((iF2 - 1) - lineStart) * 2] : fArr[(iE - lineStart) * 2];
            float fA4 = z4 ? a(fArr, iE, lineStart) : a(fArr, iF2 - 1, lineStart);
            float f2 = rectF.left;
            int i14 = i13;
            if (!z) {
                b71VarArr2 = b71VarArr;
                if (fA4 < f2) {
                    iF2 = -1;
                    break;
                }
                float f3 = rectF.right;
                if (f <= f3) {
                    if ((z4 || f3 < fA4) && (!z4 || f2 > f)) {
                        int i15 = iF2;
                        int i16 = iE;
                        while (i15 - i16 > 1) {
                            int i17 = (i15 + i16) / 2;
                            float f4 = fArr[(i17 - lineStart) * 2];
                            int i18 = i15;
                            if ((z4 || f4 <= rectF.right) && (!z4 || f4 >= rectF.left)) {
                                i15 = i18;
                                i16 = i17;
                            } else {
                                i15 = i17;
                            }
                        }
                        i2 = z4 ? i15 : i16;
                    } else {
                        i2 = iF2 - 1;
                    }
                    int iA2 = bf2Var.a(i2 + 1);
                    if (iA2 == -1 || (iD = bf2Var.d(iA2)) <= iE) {
                        iF2 = -1;
                        break;
                    }
                    if (iA2 < iE) {
                        iA2 = iE;
                    }
                    if (iD <= iF2) {
                        iF2 = iD;
                    }
                    RectF rectF2 = new RectF(0.0f, lineTop, 0.0f, lineBottom);
                    int iA3 = iA2;
                    while (true) {
                        rectF2.left = z4 ? fArr[((iF2 - 1) - lineStart) * 2] : fArr[(iA3 - lineStart) * 2];
                        rectF2.right = z4 ? a(fArr, iA3, lineStart) : a(fArr, iF2 - 1, lineStart);
                        if (((Boolean) haVar.e(rectF2, rectF)).booleanValue()) {
                            break;
                        }
                        iF2 = bf2Var.f(iF2);
                        if (iF2 == -1 || iF2 <= iE) {
                            iF2 = -1;
                            break;
                        }
                        iA3 = bf2Var.a(iF2);
                        if (iA3 < iE) {
                            iA3 = iE;
                        }
                    }
                } else {
                    iF2 = -1;
                    break;
                }
                iE = iF2;
            } else {
                if (fA4 < f2) {
                    b71VarArr2 = b71VarArr;
                    iE = -1;
                    break;
                }
                float f5 = rectF.right;
                if (f <= f5) {
                    if ((z4 || f2 > f) && (!z4 || f5 < fA4)) {
                        int i19 = iF2;
                        int i20 = iE;
                        while (true) {
                            i3 = i19;
                            if (i19 - i20 <= 1) {
                                break;
                            }
                            int i21 = (i3 + i20) / 2;
                            float f6 = fArr[(i21 - lineStart) * 2];
                            if ((z4 || f6 <= rectF.left) && (!z4 || f6 >= rectF.right)) {
                                i19 = i3;
                                i20 = i21;
                            } else {
                                i19 = i21;
                            }
                        }
                        i4 = z4 ? i3 : i20;
                    } else {
                        i4 = iE;
                    }
                    int iD2 = bf2Var.d(i4);
                    if (iD2 != -1 && (iA = bf2Var.a(iD2)) < iF2) {
                        if (iA >= iE) {
                            iE = iA;
                        }
                        if (iD2 > iF2) {
                            iD2 = iF2;
                        }
                        b71VarArr2 = b71VarArr;
                        RectF rectF3 = new RectF(0.0f, lineTop, 0.0f, lineBottom);
                        int iD3 = iD2;
                        while (true) {
                            rectF3.left = z4 ? fArr[((iD3 - 1) - lineStart) * 2] : fArr[(iE - lineStart) * 2];
                            rectF3.right = z4 ? a(fArr, iE, lineStart) : a(fArr, iD3 - 1, lineStart);
                            if (((Boolean) haVar.e(rectF3, rectF)).booleanValue()) {
                                break;
                            }
                            iE = bf2Var.e(iE);
                            if (iE != -1 && iE < iF2) {
                                iD3 = bf2Var.d(iE);
                                if (iD3 > iF2) {
                                    iD3 = iF2;
                                }
                            }
                        }
                    } else {
                        b71VarArr2 = b71VarArr;
                    }
                    iE = -1;
                    break;
                } else {
                    b71VarArr2 = b71VarArr;
                    iE = -1;
                    break;
                }
            }
            if (iE >= 0) {
                return iE;
            }
            if (i11 == i12) {
                return -1;
            }
            i11 += i14;
            i13 = i14;
            b71VarArr = b71VarArr2;
        }
    }
}
