package defpackage;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class s44 {
    public static final py0 a = new py0(16, "NO_VALUE");

    public static hk2 a(int i, int i2, nn nnVar) {
        int i3 = (i2 & 1) != 0 ? 0 : 1;
        if ((i2 & 2) != 0) {
            i = 0;
        }
        int i4 = i2 & 4;
        nn nnVar2 = nn.a;
        if (i4 != 0) {
            nnVar = nnVar2;
        }
        if (i < 0) {
            og.g(ky0.h(i, "extraBufferCapacity cannot be negative, but was "));
            return null;
        }
        if (i3 <= 0 && i <= 0 && nnVar != nnVar2) {
            dk0.w(nnVar, "replay or extraBufferCapacity must be positive with non-default onBufferOverflow strategy ");
            return null;
        }
        int i5 = i + i3;
        if (i5 < 0) {
            i5 = Integer.MAX_VALUE;
        }
        return new hk2(i3, i5, nnVar);
    }

    public static final void b(final rn2 rn2Var, float f, boolean z, ek1 ek1Var, x20 x20Var, int i) {
        int i2;
        l60 l60Var;
        ek1 ek1Var2 = ek1Var;
        rn2Var.getClass();
        x20Var.X(344169953);
        if ((i & 6) == 0) {
            i2 = (x20Var.d(rn2Var.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.c(f) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var.g(z) ? 256 : 128;
        }
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i2 |= x20Var.f(ek1Var2) ? 2048 : 1024;
        }
        if (x20Var.O(i2 & 1, (i2 & 1171) != 1170)) {
            Object objL = x20Var.L();
            Object obj = r20.a;
            if (objL == obj) {
                objL = new fy1();
                x20Var.g0(objL);
            }
            final fy1 fy1Var = (fy1) objL;
            Object objL2 = x20Var.L();
            if (objL2 == obj) {
                objL2 = new xz();
                x20Var.g0(objL2);
            }
            final xz xzVar = (xz) objL2;
            final gu1 gu1VarA = sz3.a(x20Var);
            qn2 qn2Var = z ? new qn2(ki4.c(4280468830L), ki4.c(4287033260L), ki4.c(4280468830L)) : uz.a(rn2Var);
            Object objL3 = x20Var.L();
            if (objL3 == obj) {
                objL3 = new fy0();
                x20Var.g0(objL3);
            }
            final fy0 fy0Var = (fy0) objL3;
            int i3 = i2;
            final gr2 gr2VarA = vk2.a(qn2Var.a, ie4.e(520, null, 6), "core", x20Var);
            final gr2 gr2VarA2 = vk2.a(qn2Var.b, ie4.e(520, null, 6), "halo", x20Var);
            final gr2 gr2VarA3 = dd.a(ky3.b(f, 0.0f, 1.0f), ie4.e(90, null, 6), "voice", x20Var);
            switch (rn2Var.ordinal()) {
                case 0:
                    l60Var = new l60(0.0f, 0.014f, 0.0f, 0.72f);
                    break;
                case 1:
                    l60Var = new l60(0.1f, 0.02f, 0.08f, 1.0f);
                    break;
                case 2:
                    l60Var = new l60(0.04f, 0.045f, 0.55f, 0.92f);
                    break;
                case 3:
                    l60Var = new l60(0.06f, 0.085f, 0.4f, 0.95f);
                    break;
                case 4:
                    l60Var = new l60(-0.04f, 0.03f, 1.15f, 1.0f);
                    break;
                case 5:
                    l60Var = new l60(0.02f, 0.018f, 0.3f, 0.88f);
                    break;
                case 6:
                    l60Var = new l60(0.14f, 0.01f, 0.05f, 1.0f);
                    break;
                case 7:
                    l60Var = new l60(0.06f, 0.05f, 0.18f, 0.9f);
                    break;
                case 8:
                    l60Var = new l60(-0.02f, 0.03f, 0.1f, 0.62f);
                    break;
                case 9:
                    l60Var = new l60(0.0f, 0.024f, 0.08f, 0.8f);
                    break;
                case 10:
                    l60Var = new l60(-0.06f, 0.038f, 0.06f, 0.85f);
                    break;
                case 11:
                    l60Var = new l60(0.08f, 0.016f, 0.12f, 0.95f);
                    break;
                case 12:
                    l60Var = new l60(0.08f, 0.016f, 0.12f, 0.95f);
                    break;
                case 13:
                    l60Var = new l60(0.04f, 0.014f, 0.1f, 0.88f);
                    break;
                case 14:
                    l60Var = new l60(-0.05f, 0.012f, 0.0f, 0.45f);
                    break;
                default:
                    dk0.l();
                    return;
            }
            final gr2 gr2VarA4 = dd.a(l60Var.a, ie4.e(520, null, 6), "swell", x20Var);
            final gr2 gr2VarA5 = dd.a(l60Var.b, ie4.e(520, null, 6), "churn", x20Var);
            final gr2 gr2VarA6 = dd.a(l60Var.c, ie4.e(520, null, 6), "spin", x20Var);
            final gr2 gr2VarA7 = dd.a(l60Var.d, ie4.e(520, null, 6), "glow", x20Var);
            final gr2 gr2VarA8 = dd.a(z ? 1.0f : 0.0f, ie4.e(200, null, 6), "voicing", x20Var);
            boolean zF = x20Var.f(gu1VarA) | x20Var.f(gr2VarA3) | x20Var.f(gr2VarA8) | x20Var.h(fy0Var) | x20Var.f(gr2VarA) | ((i3 & 14) == 4) | x20Var.f(gr2VarA2) | x20Var.f(gr2VarA6) | x20Var.f(gr2VarA7) | x20Var.h(xzVar) | x20Var.h(fy1Var) | x20Var.f(gr2VarA4) | x20Var.f(gr2VarA5);
            Object objL4 = x20Var.L();
            if (zF || objL4 == obj) {
                Object obj2 = new hq0() { // from class: kn2
                    /* JADX WARN: Code duplicated, block: B:14:0x0195  */
                    /* JADX WARN: Code duplicated, block: B:17:0x01a8 A[LOOP:3: B:15:0x01a4->B:17:0x01a8, LOOP_END] */
                    @Override // defpackage.hq0
                    public final Object j(Object obj3) {
                        int i4;
                        int i5;
                        rf0 rf0Var;
                        rf0 rf0Var2 = (rf0) obj3;
                        rf0Var2.getClass();
                        float fFloatValue = ((Number) gu1VarA.getValue()).floatValue();
                        float fFloatValue2 = ((Number) gr2VarA3.getValue()).floatValue();
                        float fFloatValue3 = ((Number) gr2VarA8.getValue()).floatValue();
                        float f2 = (1.2f * fFloatValue3) + fFloatValue2;
                        float fSin = ((((float) Math.sin(14.2f * fFloatValue)) * 0.06f) + (((float) Math.sin(28.4f * fFloatValue)) * 0.09f)) * f2;
                        long j = ((sz) gr2VarA.getValue()).a;
                        fy0 fy0Var2 = fy0Var;
                        rn2 rn2Var2 = rn2Var;
                        long jA = fy0Var2.a(j, fFloatValue, rn2Var2, fFloatValue2);
                        long jA2 = fy0Var2.a(((sz) gr2VarA2.getValue()).a, fFloatValue, rn2Var2, fFloatValue2);
                        float fMin = Math.min(Float.intBitsToFloat((int) (rf0Var2.c() >> 32)), Float.intBitsToFloat((int) (rf0Var2.c() & 4294967295L))) * 0.4f;
                        float fIntBitsToFloat = Float.intBitsToFloat((int) (rf0Var2.c() >> 32)) / 2.0f;
                        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (rf0Var2.c() & 4294967295L)) / 2.0f;
                        float fFloatValue4 = ((0.48f * fFloatValue3) + ((Number) gr2VarA6.getValue()).floatValue() + 0.16f) * fFloatValue;
                        float fSin2 = (((float) Math.sin(fFloatValue * 0.21f)) * 0.3f) + 0.38f;
                        gr2 gr2Var = gr2VarA7;
                        float fFloatValue5 = ((Number) gr2Var.getValue()).floatValue();
                        float f3 = ((f2 * 0.35f) + 2.1f) * fMin;
                        rf0 rf0Var3 = rf0Var2;
                        rf0.Z(rf0Var3, new o22(nz.i(new sz(sz.b(fFloatValue5 * 0.22f, jA2)), new sz(sz.b(fFloatValue5 * 0.06f, jA2)), new sz(sz.f)), null, (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L), f3), f3, (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L), 0.0f, 120);
                        xz xzVar2 = xzVar;
                        xzVar2.getClass();
                        int[] iArr = xzVar2.a;
                        sz szVar = xzVar2.b;
                        if (szVar == null ? false : sz.c(szVar.a, jA)) {
                            sz szVar2 = xzVar2.c;
                            if (!(szVar2 == null ? false : sz.c(szVar2.a, jA2))) {
                                xzVar2.b = new sz(jA);
                                xzVar2.c = new sz(jA2);
                                for (i4 = 0; i4 < 10; i4++) {
                                    iArr[i4] = ki4.g(ki4.f(jA, jA2, i4 / 9.0f));
                                }
                            }
                        } else {
                            xzVar2.b = new sz(jA);
                            xzVar2.c = new sz(jA2);
                            while (i4 < 10) {
                                iArr[i4] = ki4.g(ki4.f(jA, jA2, i4 / 9.0f));
                            }
                        }
                        float fFloatValue6 = (0.12f * fFloatValue3) + ((Number) gr2VarA4.getValue()).floatValue();
                        float fFloatValue7 = (fFloatValue2 * 0.35f) + ((Number) gr2VarA5.getValue()).floatValue() + fSin;
                        fy1 fy1Var2 = fy1Var;
                        fy1Var2.getClass();
                        float[] fArr = fy1Var2.h;
                        float[] fArr2 = fy1Var2.f;
                        float[] fArr3 = fy1Var2.g;
                        float[] fArr4 = fy1Var2.e;
                        float[] fArr5 = fy1Var2.d;
                        double d = fFloatValue4;
                        float fCos = (float) Math.cos(d);
                        float fSin3 = (float) Math.sin(d);
                        double d2 = fSin2;
                        float fCos2 = (float) Math.cos(d2);
                        float fSin4 = (float) Math.sin(d2);
                        int i6 = 0;
                        while (true) {
                            i5 = 380;
                            if (i6 >= 380) {
                                break;
                            }
                            float f4 = fy1Var2.a[i6];
                            float f5 = fy1Var2.b[i6];
                            rf0 rf0Var4 = rf0Var3;
                            float f6 = fy1Var2.c[i6];
                            fy1 fy1Var3 = fy1Var2;
                            float fSin5 = (((float) Math.sin((0.9f * fFloatValue) + (3.4f * f6))) * ((float) Math.cos((f5 * 2.7f) - (1.3f * fFloatValue))) * ((float) Math.sin((1.7f * fFloatValue) + (3.1f * f4))) * fFloatValue7) + fFloatValue6 + 1.0f;
                            float f7 = f4 * fSin5;
                            float f8 = f5 * fSin5;
                            float f9 = f6 * fSin5;
                            float f10 = (f9 * fSin3) + (f7 * fCos);
                            float f11 = (f9 * fCos) - (f7 * fSin3);
                            float f12 = (f8 * fCos2) - (f11 * fSin4);
                            float f13 = (f11 * fCos2) + (f8 * fSin4);
                            float f14 = 2.2f / (3.0f - f13);
                            fArr5[i6] = (f10 * f14 * fMin) + fIntBitsToFloat;
                            fArr4[i6] = (f12 * f14 * fMin) + fIntBitsToFloat2;
                            fArr3[i6] = f14;
                            float f15 = 0.0f;
                            fArr2[i6] = ky3.b((1.35f + f13) / 2.7f, 0.0f, 1.0f);
                            float f16 = fSin5 > 0.0f ? 1.0f / fSin5 : 0.0f;
                            float f17 = (f13 * f16 * 0.66f) + (f12 * f16 * 0.6f) + (f10 * f16 * (-0.45f));
                            if (f17 >= 0.0f) {
                                f15 = f17;
                            }
                            fArr[i6] = f15 * f15 * f15;
                            i6++;
                            fy1Var2 = fy1Var3;
                            rf0Var3 = rf0Var4;
                        }
                        rf0 rf0Var5 = rf0Var3;
                        float fFloatValue8 = ((Number) gr2Var.getValue()).floatValue();
                        float fMax = Math.max(0.026f * fMin, 1.4f);
                        int i7 = 0;
                        while (i7 < 8) {
                            float f18 = i7 / 8.0f;
                            i7++;
                            float f19 = i7 / 8.0f;
                            int i8 = 0;
                            while (i8 < i5) {
                                float f20 = fArr2[i8];
                                if (f20 < f18 || f20 >= f19 || f20 < 0.06f) {
                                    rf0Var = rf0Var5;
                                } else {
                                    long jB = ki4.b(iArr[ky3.c((int) (fArr[i8] * 9.0f), 0, 9)]);
                                    float f21 = fArr3[i8] * fMax;
                                    long jFloatToRawIntBits = (((long) Float.floatToRawIntBits(fArr4[i8])) & 4294967295L) | (((long) Float.floatToRawIntBits(fArr5[i8])) << 32);
                                    float f22 = (((f20 - 0.06f) / 0.94f) * 0.84f) + 0.16f;
                                    if (f22 > 1.0f) {
                                        f22 = 1.0f;
                                    }
                                    rf0Var = rf0Var5;
                                    rf0.P(rf0Var, jB, f21, jFloatToRawIntBits, f22 * fFloatValue8, 112);
                                }
                                i8++;
                                rf0Var5 = rf0Var;
                                iArr = iArr;
                                fArr5 = fArr5;
                                fArr = fArr;
                                i7 = i7;
                                i5 = 380;
                            }
                        }
                        float fFloatValue9 = ((Number) gr2Var.getValue()).floatValue();
                        float f23 = ((f2 * 0.14f) + 0.34f) * fMin;
                        rf0.Z(rf0Var5, new o22(nz.i(new sz(sz.b(fFloatValue9 * 0.4f, sz.c)), new sz(sz.b(fFloatValue9 * 0.16f, jA2)), new sz(sz.f)), null, (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L), f23), f23, (((long) Float.floatToRawIntBits(fIntBitsToFloat)) << 32) | (((long) Float.floatToRawIntBits(fIntBitsToFloat2)) & 4294967295L), 0.0f, 120);
                        return q43.a;
                    }
                };
                x20Var.g0(obj2);
                objL4 = obj2;
            }
            ek1Var2 = ek1Var;
            dh4.a(ek1Var2, (hq0) objL4, x20Var, (i3 >> 9) & 14);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new hs1(rn2Var, f, z, ek1Var2, i, 1);
        }
    }

    public static final void c(Object[] objArr, long j, Object obj) {
        objArr[((int) j) & (objArr.length - 1)] = obj;
    }

    public static final mm0 d(ek2 ek2Var, j70 j70Var, int i, nn nnVar) {
        return ((i == 0 || i == -3) && nnVar == nn.a) ? ek2Var : new fx(ek2Var, j70Var, i, nnVar);
    }
}
