package defpackage;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.Normalizer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class dg4 {
    /* JADX WARN: Code duplicated, block: B:105:0x0134 A[PHI: r8 r12 r15 r18
      0x0134: PHI (r8v8 boolean) = (r8v5 boolean), (r8v2 boolean) binds: [B:114:0x0154, B:103:0x012a] A[DONT_GENERATE, DONT_INLINE]
      0x0134: PHI (r12v14 eo) = (r12v11 eo), (r12v9 eo) binds: [B:114:0x0154, B:103:0x012a] A[DONT_GENERATE, DONT_INLINE]
      0x0134: PHI (r15v7 yl) = (r15v4 yl), (r15v3 yl) binds: [B:114:0x0154, B:103:0x012a] A[DONT_GENERATE, DONT_INLINE]
      0x0134: PHI (r18v18 int) = (r18v14 int), (r18v13 int) binds: [B:114:0x0154, B:103:0x012a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:107:0x013b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:108:0x013d  */
    /* JADX WARN: Code duplicated, block: B:111:0x0143  */
    /* JADX WARN: Code duplicated, block: B:113:0x0153  */
    /* JADX WARN: Code duplicated, block: B:115:0x0156  */
    /* JADX WARN: Code duplicated, block: B:118:0x016a  */
    /* JADX WARN: Code duplicated, block: B:121:0x0179  */
    /* JADX WARN: Code duplicated, block: B:122:0x017c  */
    /* JADX WARN: Code duplicated, block: B:125:0x0182  */
    /* JADX WARN: Code duplicated, block: B:126:0x0185  */
    /* JADX WARN: Code duplicated, block: B:128:0x0189  */
    /* JADX WARN: Code duplicated, block: B:129:0x019f  */
    /* JADX WARN: Code duplicated, block: B:131:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:134:0x01cb A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:135:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:138:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:139:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:147:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:148:0x0210  */
    /* JADX WARN: Code duplicated, block: B:151:0x022d  */
    /* JADX WARN: Code duplicated, block: B:153:0x0233  */
    /* JADX WARN: Code duplicated, block: B:159:0x0244  */
    /* JADX WARN: Code duplicated, block: B:161:0x024a  */
    /* JADX WARN: Code duplicated, block: B:167:0x025e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:170:0x0266  */
    /* JADX WARN: Code duplicated, block: B:173:0x028b  */
    /* JADX WARN: Code duplicated, block: B:174:0x0298  */
    /* JADX WARN: Code duplicated, block: B:177:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:180:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:182:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:184:0x02e0  */
    /* JADX WARN: Code duplicated, block: B:186:0x0331  */
    /* JADX WARN: Code duplicated, block: B:189:0x033f  */
    /* JADX WARN: Code duplicated, block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0057  */
    /* JADX WARN: Code duplicated, block: B:32:0x005d  */
    /* JADX WARN: Code duplicated, block: B:33:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:40:0x0070  */
    /* JADX WARN: Code duplicated, block: B:44:0x0078  */
    /* JADX WARN: Code duplicated, block: B:46:0x007c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0084  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:52:0x008d  */
    /* JADX WARN: Code duplicated, block: B:55:0x0095  */
    /* JADX WARN: Code duplicated, block: B:57:0x0099  */
    /* JADX WARN: Code duplicated, block: B:59:0x009c  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:81:0x00df  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:93:0x0108  */
    /* JADX WARN: Code duplicated, block: B:94:0x010b  */
    /* JADX WARN: Code duplicated, block: B:97:0x0114  */
    /* JADX WARN: Code duplicated, block: B:99:0x011e  */
    public static final void a(fq0 fq0Var, ek1 ek1Var, boolean z, yj2 yj2Var, ao aoVar, eo eoVar, yl ylVar, qt1 qt1Var, w10 w10Var, x20 x20Var, int i, int i2) {
        int i3;
        boolean z2;
        eo eoVar2;
        int i4;
        yl ylVar2;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z3;
        boolean z4;
        boolean z5;
        eo eoVar3;
        yl ylVar3;
        qt1 qt1Var2;
        a42 a42VarR;
        qt1 qt1Var3;
        int i10;
        yl ylVar4;
        Object objL;
        Object obj;
        ol1 ol1Var;
        long j;
        long j2;
        int i11;
        Object objL2;
        um2 um2Var;
        boolean zF;
        float f;
        Object objL3;
        int i12;
        r21 r21Var;
        float f2;
        Object objL4;
        bd bdVar;
        boolean zH;
        Object objL5;
        eo eoVar4;
        boolean z6;
        qd qdVar;
        float f3;
        Object objL6;
        ol1 ol1Var2;
        Object objL7;
        int i13;
        int i14;
        int i15;
        x20Var.X(-1310015664);
        if ((i & 6) == 0) {
            i3 = (x20Var.h(fq0Var) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= x20Var.f(ek1Var) ? 32 : 16;
        }
        int i16 = i2 & 4;
        if (i16 == 0) {
            if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
                z2 = z;
                i3 |= x20Var.g(z2) ? 256 : 128;
            }
            if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
                if (x20Var.f(yj2Var)) {
                    i15 = 2048;
                } else {
                    i15 = 1024;
                }
                i3 |= i15;
            }
            if ((i & 24576) == 0) {
                if (x20Var.f(aoVar)) {
                    i14 = 16384;
                } else {
                    i14 = 8192;
                }
                i3 |= i14;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    eoVar2 = eoVar;
                    int i17 = x20Var.f(eoVar2) ? Normalizer.INPUT_IS_FCD : 65536;
                    i3 |= i17;
                } else {
                    eoVar2 = eoVar;
                }
                i3 |= i17;
            } else {
                eoVar2 = eoVar;
            }
            i4 = i2 & 64;
            if (i4 != 0) {
                if ((1572864 & i) == 0) {
                    ylVar2 = ylVar;
                    if (x20Var.f(ylVar2)) {
                        i5 = 1048576;
                    } else {
                        i5 = ArabicShaping.TASHKEEL_RESIZE;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 128;
                if (i6 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (x20Var.f(qt1Var)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                }
                if ((i2 & 256) != 0) {
                    i3 |= 100663296;
                } else if ((i & 100663296) == 0) {
                    if (x20Var.f(null)) {
                        i8 = 67108864;
                    } else {
                        i8 = 33554432;
                    }
                    i3 |= i8;
                }
                if ((i & 805306368) == 0) {
                    if (x20Var.h(w10Var)) {
                        i13 = 536870912;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                i9 = i3;
                z3 = true;
                if ((i3 & 306783379) != 306783378) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (x20Var.O(i9 & 1, z4)) {
                    x20Var.T();
                    if ((i & 1) != 0 || x20Var.y()) {
                        if (i16 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 32) != 0) {
                            qt1 qt1Var4 = bo.a;
                            eoVar2 = new eo(hz3.f);
                            i9 &= -458753;
                        }
                        if (i4 != 0) {
                            ylVar2 = null;
                        }
                        if (i6 != 0) {
                            qt1Var3 = bo.a;
                        }
                        i10 = i9;
                        ylVar4 = ylVar2;
                        x20Var.q();
                        x20Var.W(1691738187);
                        objL = x20Var.L();
                        obj = r20.a;
                        if (objL == obj) {
                            objL = new ol1();
                            x20Var.g0(objL);
                        }
                        ol1Var = (ol1) objL;
                        x20Var.p(false);
                        if (z2) {
                            j = aoVar.a;
                        } else {
                            j = aoVar.c;
                        }
                        long j3 = j;
                        if (z2) {
                            j2 = aoVar.b;
                        } else {
                            j2 = aoVar.d;
                        }
                        if (eoVar2 == null) {
                            x20Var.W(1691921830);
                            x20Var.p(false);
                            qt1Var3 = qt1Var3;
                            ol1Var = ol1Var;
                            z6 = z2;
                            eoVar4 = eoVar2;
                            f = 0.0f;
                            qdVar = null;
                        } else {
                            x20Var.W(-499611205);
                            i11 = ((i10 >> 9) & 896) | ((i10 >> 6) & 14);
                            objL2 = x20Var.L();
                            if (objL2 == obj) {
                                objL2 = new um2();
                                x20Var.g0(objL2);
                            }
                            um2Var = (um2) objL2;
                            zF = x20Var.f(ol1Var);
                            f = 0.0f;
                            objL3 = x20Var.L();
                            i12 = 6;
                            if (zF || objL3 == obj) {
                                objL3 = new p0(ol1Var, um2Var, null, i12);
                                x20Var.g0(objL3);
                            }
                            bz3.c(x20Var, (vq0) objL3, ol1Var);
                            r21Var = (r21) mz.E(um2Var);
                            if (z2 || (r21Var instanceof b02) || !(r21Var instanceof xw0)) {
                                f2 = 0.0f;
                            } else {
                                f2 = eoVar2.a;
                            }
                            objL4 = x20Var.L();
                            if (objL4 == obj) {
                                objL4 = new bd(new de0(f2), eb4.c, null, 12);
                                x20Var.g0(objL4);
                            }
                            bdVar = (bd) objL4;
                            de0 de0Var = new de0(f2);
                            boolean zH2 = x20Var.h(bdVar) | x20Var.c(f2) | ((((i11 & 14) ^ 6) <= 4 && x20Var.g(z2)) || (i11 & 6) == 4);
                            if ((((i11 & 896) ^ CollationFastLatin.LATIN_LIMIT) > 256 || !x20Var.f(eoVar2)) && (i11 & CollationFastLatin.LATIN_LIMIT) != 256) {
                            }
                            zH = zH2 | z3 | x20Var.h(r21Var);
                            objL5 = x20Var.L();
                            if (!zH || objL5 == obj) {
                                boolean z7 = z2;
                                eoVar4 = eoVar2;
                                objL5 = new co(bdVar, f2, z7, eoVar4, r21Var, null);
                                z6 = z7;
                                x20Var.g0(objL5);
                            } else {
                                z6 = z2;
                                eoVar4 = eoVar2;
                            }
                            bz3.c(x20Var, (vq0) objL5, de0Var);
                            qdVar = bdVar.c;
                            x20Var.p(false);
                        }
                        if (qdVar != null) {
                            f3 = ((de0) qdVar.b.getValue()).a;
                        } else {
                            f3 = f;
                        }
                        objL6 = x20Var.L();
                        if (objL6 == obj) {
                            objL6 = new j(10);
                            x20Var.g0(objL6);
                        }
                        ek1 ek1VarA = dg2.a(ek1Var, (hq0) objL6);
                        qt1 qt1Var5 = qt1Var3;
                        w10 w10VarB = yi4.b(-535639973, new io(j2, qt1Var5, w10Var), x20Var);
                        m30 m30Var = wt2.a;
                        if (ol1Var == null) {
                            x20Var.W(-1701037204);
                            objL7 = x20Var.L();
                            if (objL7 == obj) {
                                objL7 = new ol1();
                                x20Var.g0(objL7);
                            }
                            x20Var.p(false);
                            ol1Var2 = (ol1) objL7;
                        } else {
                            x20Var.W(2023337163);
                            x20Var.p(false);
                            ol1Var2 = ol1Var;
                        }
                        z12 z12Var = wt2.a;
                        float f4 = ((de0) x20Var.j(z12Var)).a + f;
                        kj4.b(new a22[]{g50.a.a(new sz(j2)), z12Var.a(new de0(f4))}, yi4.b(849208527, new vt2(ek1VarA, yj2Var, j3, f4, ylVar4, ol1Var2, z6, fq0Var, f3, w10VarB), x20Var), x20Var, 56);
                        qt1Var2 = qt1Var5;
                        ylVar3 = ylVar4;
                        z5 = z6;
                        eoVar3 = eoVar4;
                    } else {
                        x20Var.R();
                        if ((i2 & 32) != 0) {
                            i10 = i9 & (-458753);
                            ylVar4 = ylVar2;
                            qt1Var3 = qt1Var;
                        }
                        x20Var.q();
                        x20Var.W(1691738187);
                        objL = x20Var.L();
                        obj = r20.a;
                        if (objL == obj) {
                            objL = new ol1();
                            x20Var.g0(objL);
                        }
                        ol1Var = (ol1) objL;
                        x20Var.p(false);
                        if (z2) {
                            j = aoVar.a;
                        } else {
                            j = aoVar.c;
                        }
                        long j4 = j;
                        if (z2) {
                            j2 = aoVar.b;
                        } else {
                            j2 = aoVar.d;
                        }
                        if (eoVar2 == null) {
                            x20Var.W(1691921830);
                            x20Var.p(false);
                            qt1Var3 = qt1Var3;
                            ol1Var = ol1Var;
                            z6 = z2;
                            eoVar4 = eoVar2;
                            f = 0.0f;
                            qdVar = null;
                        } else {
                            x20Var.W(-499611205);
                            i11 = ((i10 >> 9) & 896) | ((i10 >> 6) & 14);
                            objL2 = x20Var.L();
                            if (objL2 == obj) {
                                objL2 = new um2();
                                x20Var.g0(objL2);
                            }
                            um2Var = (um2) objL2;
                            zF = x20Var.f(ol1Var);
                            f = 0.0f;
                            objL3 = x20Var.L();
                            i12 = 6;
                            if (zF) {
                                objL3 = new p0(ol1Var, um2Var, null, i12);
                                x20Var.g0(objL3);
                            } else {
                                objL3 = new p0(ol1Var, um2Var, null, i12);
                                x20Var.g0(objL3);
                            }
                            bz3.c(x20Var, (vq0) objL3, ol1Var);
                            r21Var = (r21) mz.E(um2Var);
                            if (z2) {
                                f2 = 0.0f;
                            } else {
                                f2 = eoVar2.a;
                            }
                            objL4 = x20Var.L();
                            if (objL4 == obj) {
                                objL4 = new bd(new de0(f2), eb4.c, null, 12);
                                x20Var.g0(objL4);
                            }
                            bdVar = (bd) objL4;
                            de0 de0Var2 = new de0(f2);
                            boolean zH3 = x20Var.h(bdVar) | x20Var.c(f2) | ((((i11 & 14) ^ 6) <= 4 && x20Var.g(z2)) || (i11 & 6) == 4);
                            z3 = ((i11 & 896) ^ CollationFastLatin.LATIN_LIMIT) > 256 ? false : false;
                            zH = zH3 | z3 | x20Var.h(r21Var);
                            objL5 = x20Var.L();
                            if (zH) {
                                boolean z8 = z2;
                                eoVar4 = eoVar2;
                                objL5 = new co(bdVar, f2, z8, eoVar4, r21Var, null);
                                z6 = z8;
                                x20Var.g0(objL5);
                            } else {
                                boolean z9 = z2;
                                eoVar4 = eoVar2;
                                objL5 = new co(bdVar, f2, z9, eoVar4, r21Var, null);
                                z6 = z9;
                                x20Var.g0(objL5);
                            }
                            bz3.c(x20Var, (vq0) objL5, de0Var2);
                            qdVar = bdVar.c;
                            x20Var.p(false);
                        }
                        if (qdVar != null) {
                            f3 = ((de0) qdVar.b.getValue()).a;
                        } else {
                            f3 = f;
                        }
                        objL6 = x20Var.L();
                        if (objL6 == obj) {
                            objL6 = new j(10);
                            x20Var.g0(objL6);
                        }
                        ek1 ek1VarA2 = dg2.a(ek1Var, (hq0) objL6);
                        qt1 qt1Var6 = qt1Var3;
                        w10 w10VarB2 = yi4.b(-535639973, new io(j2, qt1Var6, w10Var), x20Var);
                        m30 m30Var2 = wt2.a;
                        if (ol1Var == null) {
                            x20Var.W(-1701037204);
                            objL7 = x20Var.L();
                            if (objL7 == obj) {
                                objL7 = new ol1();
                                x20Var.g0(objL7);
                            }
                            x20Var.p(false);
                            ol1Var2 = (ol1) objL7;
                        } else {
                            x20Var.W(2023337163);
                            x20Var.p(false);
                            ol1Var2 = ol1Var;
                        }
                        z12 z12Var2 = wt2.a;
                        float f5 = ((de0) x20Var.j(z12Var2)).a + f;
                        kj4.b(new a22[]{g50.a.a(new sz(j2)), z12Var2.a(new de0(f5))}, yi4.b(849208527, new vt2(ek1VarA2, yj2Var, j4, f5, ylVar4, ol1Var2, z6, fq0Var, f3, w10VarB2), x20Var), x20Var, 56);
                        qt1Var2 = qt1Var6;
                        ylVar3 = ylVar4;
                        z5 = z6;
                        eoVar3 = eoVar4;
                    }
                    qt1Var3 = qt1Var;
                    i10 = i9;
                    ylVar4 = ylVar2;
                    x20Var.q();
                    x20Var.W(1691738187);
                    objL = x20Var.L();
                    obj = r20.a;
                    if (objL == obj) {
                        objL = new ol1();
                        x20Var.g0(objL);
                    }
                    ol1Var = (ol1) objL;
                    x20Var.p(false);
                    if (z2) {
                        j = aoVar.a;
                    } else {
                        j = aoVar.c;
                    }
                    long j5 = j;
                    if (z2) {
                        j2 = aoVar.b;
                    } else {
                        j2 = aoVar.d;
                    }
                    if (eoVar2 == null) {
                        x20Var.W(1691921830);
                        x20Var.p(false);
                        qt1Var3 = qt1Var3;
                        ol1Var = ol1Var;
                        z6 = z2;
                        eoVar4 = eoVar2;
                        f = 0.0f;
                        qdVar = null;
                    } else {
                        x20Var.W(-499611205);
                        i11 = ((i10 >> 9) & 896) | ((i10 >> 6) & 14);
                        objL2 = x20Var.L();
                        if (objL2 == obj) {
                            objL2 = new um2();
                            x20Var.g0(objL2);
                        }
                        um2Var = (um2) objL2;
                        zF = x20Var.f(ol1Var);
                        f = 0.0f;
                        objL3 = x20Var.L();
                        i12 = 6;
                        if (zF) {
                            objL3 = new p0(ol1Var, um2Var, null, i12);
                            x20Var.g0(objL3);
                        } else {
                            objL3 = new p0(ol1Var, um2Var, null, i12);
                            x20Var.g0(objL3);
                        }
                        bz3.c(x20Var, (vq0) objL3, ol1Var);
                        r21Var = (r21) mz.E(um2Var);
                        if (z2) {
                            f2 = 0.0f;
                        } else {
                            f2 = eoVar2.a;
                        }
                        objL4 = x20Var.L();
                        if (objL4 == obj) {
                            objL4 = new bd(new de0(f2), eb4.c, null, 12);
                            x20Var.g0(objL4);
                        }
                        bdVar = (bd) objL4;
                        de0 de0Var3 = new de0(f2);
                        boolean zH4 = x20Var.h(bdVar) | x20Var.c(f2) | ((((i11 & 14) ^ 6) <= 4 && x20Var.g(z2)) || (i11 & 6) == 4);
                        if (((i11 & 896) ^ CollationFastLatin.LATIN_LIMIT) > 256) {
                        }
                        zH = zH4 | z3 | x20Var.h(r21Var);
                        objL5 = x20Var.L();
                        if (zH) {
                            boolean z10 = z2;
                            eoVar4 = eoVar2;
                            objL5 = new co(bdVar, f2, z10, eoVar4, r21Var, null);
                            z6 = z10;
                            x20Var.g0(objL5);
                        } else {
                            boolean z11 = z2;
                            eoVar4 = eoVar2;
                            objL5 = new co(bdVar, f2, z11, eoVar4, r21Var, null);
                            z6 = z11;
                            x20Var.g0(objL5);
                        }
                        bz3.c(x20Var, (vq0) objL5, de0Var3);
                        qdVar = bdVar.c;
                        x20Var.p(false);
                    }
                    if (qdVar != null) {
                        f3 = ((de0) qdVar.b.getValue()).a;
                    } else {
                        f3 = f;
                    }
                    objL6 = x20Var.L();
                    if (objL6 == obj) {
                        objL6 = new j(10);
                        x20Var.g0(objL6);
                    }
                    ek1 ek1VarA3 = dg2.a(ek1Var, (hq0) objL6);
                    qt1 qt1Var7 = qt1Var3;
                    w10 w10VarB3 = yi4.b(-535639973, new io(j2, qt1Var7, w10Var), x20Var);
                    m30 m30Var3 = wt2.a;
                    if (ol1Var == null) {
                        x20Var.W(-1701037204);
                        objL7 = x20Var.L();
                        if (objL7 == obj) {
                            objL7 = new ol1();
                            x20Var.g0(objL7);
                        }
                        x20Var.p(false);
                        ol1Var2 = (ol1) objL7;
                    } else {
                        x20Var.W(2023337163);
                        x20Var.p(false);
                        ol1Var2 = ol1Var;
                    }
                    z12 z12Var3 = wt2.a;
                    float f6 = ((de0) x20Var.j(z12Var3)).a + f;
                    kj4.b(new a22[]{g50.a.a(new sz(j2)), z12Var3.a(new de0(f6))}, yi4.b(849208527, new vt2(ek1VarA3, yj2Var, j5, f6, ylVar4, ol1Var2, z6, fq0Var, f3, w10VarB3), x20Var), x20Var, 56);
                    qt1Var2 = qt1Var7;
                    ylVar3 = ylVar4;
                    z5 = z6;
                    eoVar3 = eoVar4;
                } else {
                    x20Var.R();
                    z5 = z2;
                    eoVar3 = eoVar2;
                    ylVar3 = ylVar2;
                    qt1Var2 = qt1Var;
                }
                a42VarR = x20Var.r();
                if (a42VarR != null) {
                    a42VarR.d = new go(fq0Var, ek1Var, z5, yj2Var, aoVar, eoVar3, ylVar3, qt1Var2, w10Var, i, i2);
                }
            }
            i3 |= 1572864;
            ylVar2 = ylVar;
            i6 = i2 & 128;
            if (i6 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (x20Var.f(qt1Var)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            if ((i2 & 256) != 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (x20Var.f(null)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i3 |= i8;
            }
            if ((i & 805306368) == 0) {
                if (x20Var.h(w10Var)) {
                    i13 = 536870912;
                } else {
                    i13 = 268435456;
                }
                i3 |= i13;
            }
            i9 = i3;
            z3 = true;
            if ((i3 & 306783379) != 306783378) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (x20Var.O(i9 & 1, z4)) {
                x20Var.T();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 32) != 0) {
                        qt1 qt1Var8 = bo.a;
                        eoVar2 = new eo(hz3.f);
                        i9 &= -458753;
                    }
                    if (i4 != 0) {
                        ylVar2 = null;
                    }
                    if (i6 != 0) {
                        qt1Var3 = bo.a;
                    } else {
                        qt1Var3 = qt1Var;
                    }
                    i10 = i9;
                    ylVar4 = ylVar2;
                } else {
                    if (i16 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 32) != 0) {
                        qt1 qt1Var9 = bo.a;
                        eoVar2 = new eo(hz3.f);
                        i9 &= -458753;
                    }
                    if (i4 != 0) {
                        ylVar2 = null;
                    }
                    if (i6 != 0) {
                        qt1Var3 = bo.a;
                    } else {
                        qt1Var3 = qt1Var;
                    }
                    i10 = i9;
                    ylVar4 = ylVar2;
                }
                x20Var.q();
                x20Var.W(1691738187);
                objL = x20Var.L();
                obj = r20.a;
                if (objL == obj) {
                    objL = new ol1();
                    x20Var.g0(objL);
                }
                ol1Var = (ol1) objL;
                x20Var.p(false);
                if (z2) {
                    j = aoVar.a;
                } else {
                    j = aoVar.c;
                }
                long j6 = j;
                if (z2) {
                    j2 = aoVar.b;
                } else {
                    j2 = aoVar.d;
                }
                if (eoVar2 == null) {
                    x20Var.W(1691921830);
                    x20Var.p(false);
                    qt1Var3 = qt1Var3;
                    ol1Var = ol1Var;
                    z6 = z2;
                    eoVar4 = eoVar2;
                    f = 0.0f;
                    qdVar = null;
                } else {
                    x20Var.W(-499611205);
                    i11 = ((i10 >> 9) & 896) | ((i10 >> 6) & 14);
                    objL2 = x20Var.L();
                    if (objL2 == obj) {
                        objL2 = new um2();
                        x20Var.g0(objL2);
                    }
                    um2Var = (um2) objL2;
                    zF = x20Var.f(ol1Var);
                    f = 0.0f;
                    objL3 = x20Var.L();
                    i12 = 6;
                    if (zF) {
                        objL3 = new p0(ol1Var, um2Var, null, i12);
                        x20Var.g0(objL3);
                    } else {
                        objL3 = new p0(ol1Var, um2Var, null, i12);
                        x20Var.g0(objL3);
                    }
                    bz3.c(x20Var, (vq0) objL3, ol1Var);
                    r21Var = (r21) mz.E(um2Var);
                    if (z2) {
                        f2 = 0.0f;
                    } else {
                        f2 = eoVar2.a;
                    }
                    objL4 = x20Var.L();
                    if (objL4 == obj) {
                        objL4 = new bd(new de0(f2), eb4.c, null, 12);
                        x20Var.g0(objL4);
                    }
                    bdVar = (bd) objL4;
                    de0 de0Var4 = new de0(f2);
                    boolean zH5 = x20Var.h(bdVar) | x20Var.c(f2) | ((((i11 & 14) ^ 6) <= 4 && x20Var.g(z2)) || (i11 & 6) == 4);
                    if (((i11 & 896) ^ CollationFastLatin.LATIN_LIMIT) > 256) {
                    }
                    zH = zH5 | z3 | x20Var.h(r21Var);
                    objL5 = x20Var.L();
                    if (zH) {
                        boolean z12 = z2;
                        eoVar4 = eoVar2;
                        objL5 = new co(bdVar, f2, z12, eoVar4, r21Var, null);
                        z6 = z12;
                        x20Var.g0(objL5);
                    } else {
                        boolean z13 = z2;
                        eoVar4 = eoVar2;
                        objL5 = new co(bdVar, f2, z13, eoVar4, r21Var, null);
                        z6 = z13;
                        x20Var.g0(objL5);
                    }
                    bz3.c(x20Var, (vq0) objL5, de0Var4);
                    qdVar = bdVar.c;
                    x20Var.p(false);
                }
                if (qdVar != null) {
                    f3 = ((de0) qdVar.b.getValue()).a;
                } else {
                    f3 = f;
                }
                objL6 = x20Var.L();
                if (objL6 == obj) {
                    objL6 = new j(10);
                    x20Var.g0(objL6);
                }
                ek1 ek1VarA4 = dg2.a(ek1Var, (hq0) objL6);
                qt1 qt1Var10 = qt1Var3;
                w10 w10VarB4 = yi4.b(-535639973, new io(j2, qt1Var10, w10Var), x20Var);
                m30 m30Var4 = wt2.a;
                if (ol1Var == null) {
                    x20Var.W(-1701037204);
                    objL7 = x20Var.L();
                    if (objL7 == obj) {
                        objL7 = new ol1();
                        x20Var.g0(objL7);
                    }
                    x20Var.p(false);
                    ol1Var2 = (ol1) objL7;
                } else {
                    x20Var.W(2023337163);
                    x20Var.p(false);
                    ol1Var2 = ol1Var;
                }
                z12 z12Var4 = wt2.a;
                float f7 = ((de0) x20Var.j(z12Var4)).a + f;
                kj4.b(new a22[]{g50.a.a(new sz(j2)), z12Var4.a(new de0(f7))}, yi4.b(849208527, new vt2(ek1VarA4, yj2Var, j6, f7, ylVar4, ol1Var2, z6, fq0Var, f3, w10VarB4), x20Var), x20Var, 56);
                qt1Var2 = qt1Var10;
                ylVar3 = ylVar4;
                z5 = z6;
                eoVar3 = eoVar4;
            } else {
                x20Var.R();
                z5 = z2;
                eoVar3 = eoVar2;
                ylVar3 = ylVar2;
                qt1Var2 = qt1Var;
            }
            a42VarR = x20Var.r();
            if (a42VarR != null) {
                a42VarR.d = new go(fq0Var, ek1Var, z5, yj2Var, aoVar, eoVar3, ylVar3, qt1Var2, w10Var, i, i2);
            }
        }
        i3 |= CollationFastLatin.LATIN_LIMIT;
        z2 = z;
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            if (x20Var.f(yj2Var)) {
                i15 = 2048;
            } else {
                i15 = 1024;
            }
            i3 |= i15;
        }
        if ((i & 24576) == 0) {
            if (x20Var.f(aoVar)) {
                i14 = 16384;
            } else {
                i14 = 8192;
            }
            i3 |= i14;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                eoVar2 = eoVar;
                if (x20Var.f(eoVar2)) {
                }
                i3 |= i17;
            } else {
                eoVar2 = eoVar;
            }
            i3 |= i17;
        } else {
            eoVar2 = eoVar;
        }
        i4 = i2 & 64;
        if (i4 != 0) {
            if ((1572864 & i) == 0) {
                ylVar2 = ylVar;
                if (x20Var.f(ylVar2)) {
                    i5 = 1048576;
                } else {
                    i5 = ArabicShaping.TASHKEEL_RESIZE;
                }
                i3 |= i5;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (x20Var.f(qt1Var)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            if ((i2 & 256) != 0) {
                i3 |= 100663296;
            } else if ((i & 100663296) == 0) {
                if (x20Var.f(null)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i3 |= i8;
            }
            if ((i & 805306368) == 0) {
                if (x20Var.h(w10Var)) {
                    i13 = 536870912;
                } else {
                    i13 = 268435456;
                }
                i3 |= i13;
            }
            i9 = i3;
            z3 = true;
            if ((i3 & 306783379) != 306783378) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (x20Var.O(i9 & 1, z4)) {
                x20Var.T();
                if ((i & 1) != 0) {
                    if (i16 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 32) != 0) {
                        qt1 qt1Var11 = bo.a;
                        eoVar2 = new eo(hz3.f);
                        i9 &= -458753;
                    }
                    if (i4 != 0) {
                        ylVar2 = null;
                    }
                    if (i6 != 0) {
                        qt1Var3 = bo.a;
                    } else {
                        qt1Var3 = qt1Var;
                    }
                    i10 = i9;
                    ylVar4 = ylVar2;
                } else {
                    if (i16 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 32) != 0) {
                        qt1 qt1Var12 = bo.a;
                        eoVar2 = new eo(hz3.f);
                        i9 &= -458753;
                    }
                    if (i4 != 0) {
                        ylVar2 = null;
                    }
                    if (i6 != 0) {
                        qt1Var3 = bo.a;
                    } else {
                        qt1Var3 = qt1Var;
                    }
                    i10 = i9;
                    ylVar4 = ylVar2;
                }
                x20Var.q();
                x20Var.W(1691738187);
                objL = x20Var.L();
                obj = r20.a;
                if (objL == obj) {
                    objL = new ol1();
                    x20Var.g0(objL);
                }
                ol1Var = (ol1) objL;
                x20Var.p(false);
                if (z2) {
                    j = aoVar.a;
                } else {
                    j = aoVar.c;
                }
                long j7 = j;
                if (z2) {
                    j2 = aoVar.b;
                } else {
                    j2 = aoVar.d;
                }
                if (eoVar2 == null) {
                    x20Var.W(1691921830);
                    x20Var.p(false);
                    qt1Var3 = qt1Var3;
                    ol1Var = ol1Var;
                    z6 = z2;
                    eoVar4 = eoVar2;
                    f = 0.0f;
                    qdVar = null;
                } else {
                    x20Var.W(-499611205);
                    i11 = ((i10 >> 9) & 896) | ((i10 >> 6) & 14);
                    objL2 = x20Var.L();
                    if (objL2 == obj) {
                        objL2 = new um2();
                        x20Var.g0(objL2);
                    }
                    um2Var = (um2) objL2;
                    zF = x20Var.f(ol1Var);
                    f = 0.0f;
                    objL3 = x20Var.L();
                    i12 = 6;
                    if (zF) {
                        objL3 = new p0(ol1Var, um2Var, null, i12);
                        x20Var.g0(objL3);
                    } else {
                        objL3 = new p0(ol1Var, um2Var, null, i12);
                        x20Var.g0(objL3);
                    }
                    bz3.c(x20Var, (vq0) objL3, ol1Var);
                    r21Var = (r21) mz.E(um2Var);
                    if (z2) {
                        f2 = 0.0f;
                    } else {
                        f2 = eoVar2.a;
                    }
                    objL4 = x20Var.L();
                    if (objL4 == obj) {
                        objL4 = new bd(new de0(f2), eb4.c, null, 12);
                        x20Var.g0(objL4);
                    }
                    bdVar = (bd) objL4;
                    de0 de0Var5 = new de0(f2);
                    boolean zH6 = x20Var.h(bdVar) | x20Var.c(f2) | ((((i11 & 14) ^ 6) <= 4 && x20Var.g(z2)) || (i11 & 6) == 4);
                    if (((i11 & 896) ^ CollationFastLatin.LATIN_LIMIT) > 256) {
                    }
                    zH = zH6 | z3 | x20Var.h(r21Var);
                    objL5 = x20Var.L();
                    if (zH) {
                        boolean z14 = z2;
                        eoVar4 = eoVar2;
                        objL5 = new co(bdVar, f2, z14, eoVar4, r21Var, null);
                        z6 = z14;
                        x20Var.g0(objL5);
                    } else {
                        boolean z15 = z2;
                        eoVar4 = eoVar2;
                        objL5 = new co(bdVar, f2, z15, eoVar4, r21Var, null);
                        z6 = z15;
                        x20Var.g0(objL5);
                    }
                    bz3.c(x20Var, (vq0) objL5, de0Var5);
                    qdVar = bdVar.c;
                    x20Var.p(false);
                }
                if (qdVar != null) {
                    f3 = ((de0) qdVar.b.getValue()).a;
                } else {
                    f3 = f;
                }
                objL6 = x20Var.L();
                if (objL6 == obj) {
                    objL6 = new j(10);
                    x20Var.g0(objL6);
                }
                ek1 ek1VarA5 = dg2.a(ek1Var, (hq0) objL6);
                qt1 qt1Var13 = qt1Var3;
                w10 w10VarB5 = yi4.b(-535639973, new io(j2, qt1Var13, w10Var), x20Var);
                m30 m30Var5 = wt2.a;
                if (ol1Var == null) {
                    x20Var.W(-1701037204);
                    objL7 = x20Var.L();
                    if (objL7 == obj) {
                        objL7 = new ol1();
                        x20Var.g0(objL7);
                    }
                    x20Var.p(false);
                    ol1Var2 = (ol1) objL7;
                } else {
                    x20Var.W(2023337163);
                    x20Var.p(false);
                    ol1Var2 = ol1Var;
                }
                z12 z12Var5 = wt2.a;
                float f8 = ((de0) x20Var.j(z12Var5)).a + f;
                kj4.b(new a22[]{g50.a.a(new sz(j2)), z12Var5.a(new de0(f8))}, yi4.b(849208527, new vt2(ek1VarA5, yj2Var, j7, f8, ylVar4, ol1Var2, z6, fq0Var, f3, w10VarB5), x20Var), x20Var, 56);
                qt1Var2 = qt1Var13;
                ylVar3 = ylVar4;
                z5 = z6;
                eoVar3 = eoVar4;
            } else {
                x20Var.R();
                z5 = z2;
                eoVar3 = eoVar2;
                ylVar3 = ylVar2;
                qt1Var2 = qt1Var;
            }
            a42VarR = x20Var.r();
            if (a42VarR != null) {
                a42VarR.d = new go(fq0Var, ek1Var, z5, yj2Var, aoVar, eoVar3, ylVar3, qt1Var2, w10Var, i, i2);
            }
        }
        i3 |= 1572864;
        ylVar2 = ylVar;
        i6 = i2 & 128;
        if (i6 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (x20Var.f(qt1Var)) {
                i7 = 8388608;
            } else {
                i7 = 4194304;
            }
            i3 |= i7;
        }
        if ((i2 & 256) != 0) {
            i3 |= 100663296;
        } else if ((i & 100663296) == 0) {
            if (x20Var.f(null)) {
                i8 = 67108864;
            } else {
                i8 = 33554432;
            }
            i3 |= i8;
        }
        if ((i & 805306368) == 0) {
            if (x20Var.h(w10Var)) {
                i13 = 536870912;
            } else {
                i13 = 268435456;
            }
            i3 |= i13;
        }
        i9 = i3;
        z3 = true;
        if ((i3 & 306783379) != 306783378) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (x20Var.O(i9 & 1, z4)) {
            x20Var.T();
            if ((i & 1) != 0) {
                if (i16 != 0) {
                    z2 = true;
                }
                if ((i2 & 32) != 0) {
                    qt1 qt1Var14 = bo.a;
                    eoVar2 = new eo(hz3.f);
                    i9 &= -458753;
                }
                if (i4 != 0) {
                    ylVar2 = null;
                }
                if (i6 != 0) {
                    qt1Var3 = bo.a;
                } else {
                    qt1Var3 = qt1Var;
                }
                i10 = i9;
                ylVar4 = ylVar2;
            } else {
                if (i16 != 0) {
                    z2 = true;
                }
                if ((i2 & 32) != 0) {
                    qt1 qt1Var15 = bo.a;
                    eoVar2 = new eo(hz3.f);
                    i9 &= -458753;
                }
                if (i4 != 0) {
                    ylVar2 = null;
                }
                if (i6 != 0) {
                    qt1Var3 = bo.a;
                } else {
                    qt1Var3 = qt1Var;
                }
                i10 = i9;
                ylVar4 = ylVar2;
            }
            x20Var.q();
            x20Var.W(1691738187);
            objL = x20Var.L();
            obj = r20.a;
            if (objL == obj) {
                objL = new ol1();
                x20Var.g0(objL);
            }
            ol1Var = (ol1) objL;
            x20Var.p(false);
            if (z2) {
                j = aoVar.a;
            } else {
                j = aoVar.c;
            }
            long j8 = j;
            if (z2) {
                j2 = aoVar.b;
            } else {
                j2 = aoVar.d;
            }
            if (eoVar2 == null) {
                x20Var.W(1691921830);
                x20Var.p(false);
                qt1Var3 = qt1Var3;
                ol1Var = ol1Var;
                z6 = z2;
                eoVar4 = eoVar2;
                f = 0.0f;
                qdVar = null;
            } else {
                x20Var.W(-499611205);
                i11 = ((i10 >> 9) & 896) | ((i10 >> 6) & 14);
                objL2 = x20Var.L();
                if (objL2 == obj) {
                    objL2 = new um2();
                    x20Var.g0(objL2);
                }
                um2Var = (um2) objL2;
                zF = x20Var.f(ol1Var);
                f = 0.0f;
                objL3 = x20Var.L();
                i12 = 6;
                if (zF) {
                    objL3 = new p0(ol1Var, um2Var, null, i12);
                    x20Var.g0(objL3);
                } else {
                    objL3 = new p0(ol1Var, um2Var, null, i12);
                    x20Var.g0(objL3);
                }
                bz3.c(x20Var, (vq0) objL3, ol1Var);
                r21Var = (r21) mz.E(um2Var);
                if (z2) {
                    f2 = 0.0f;
                } else {
                    f2 = eoVar2.a;
                }
                objL4 = x20Var.L();
                if (objL4 == obj) {
                    objL4 = new bd(new de0(f2), eb4.c, null, 12);
                    x20Var.g0(objL4);
                }
                bdVar = (bd) objL4;
                de0 de0Var6 = new de0(f2);
                boolean zH7 = x20Var.h(bdVar) | x20Var.c(f2) | ((((i11 & 14) ^ 6) <= 4 && x20Var.g(z2)) || (i11 & 6) == 4);
                if (((i11 & 896) ^ CollationFastLatin.LATIN_LIMIT) > 256) {
                }
                zH = zH7 | z3 | x20Var.h(r21Var);
                objL5 = x20Var.L();
                if (zH) {
                    boolean z16 = z2;
                    eoVar4 = eoVar2;
                    objL5 = new co(bdVar, f2, z16, eoVar4, r21Var, null);
                    z6 = z16;
                    x20Var.g0(objL5);
                } else {
                    boolean z17 = z2;
                    eoVar4 = eoVar2;
                    objL5 = new co(bdVar, f2, z17, eoVar4, r21Var, null);
                    z6 = z17;
                    x20Var.g0(objL5);
                }
                bz3.c(x20Var, (vq0) objL5, de0Var6);
                qdVar = bdVar.c;
                x20Var.p(false);
            }
            if (qdVar != null) {
                f3 = ((de0) qdVar.b.getValue()).a;
            } else {
                f3 = f;
            }
            objL6 = x20Var.L();
            if (objL6 == obj) {
                objL6 = new j(10);
                x20Var.g0(objL6);
            }
            ek1 ek1VarA6 = dg2.a(ek1Var, (hq0) objL6);
            qt1 qt1Var16 = qt1Var3;
            w10 w10VarB6 = yi4.b(-535639973, new io(j2, qt1Var16, w10Var), x20Var);
            m30 m30Var6 = wt2.a;
            if (ol1Var == null) {
                x20Var.W(-1701037204);
                objL7 = x20Var.L();
                if (objL7 == obj) {
                    objL7 = new ol1();
                    x20Var.g0(objL7);
                }
                x20Var.p(false);
                ol1Var2 = (ol1) objL7;
            } else {
                x20Var.W(2023337163);
                x20Var.p(false);
                ol1Var2 = ol1Var;
            }
            z12 z12Var6 = wt2.a;
            float f9 = ((de0) x20Var.j(z12Var6)).a + f;
            kj4.b(new a22[]{g50.a.a(new sz(j2)), z12Var6.a(new de0(f9))}, yi4.b(849208527, new vt2(ek1VarA6, yj2Var, j8, f9, ylVar4, ol1Var2, z6, fq0Var, f3, w10VarB6), x20Var), x20Var, 56);
            qt1Var2 = qt1Var16;
            ylVar3 = ylVar4;
            z5 = z6;
            eoVar3 = eoVar4;
        } else {
            x20Var.R();
            z5 = z2;
            eoVar3 = eoVar2;
            ylVar3 = ylVar2;
            qt1Var2 = qt1Var;
        }
        a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new go(fq0Var, ek1Var, z5, yj2Var, aoVar, eoVar3, ylVar3, qt1Var2, w10Var, i, i2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0124  */
    /* JADX WARN: Code duplicated, block: B:103:0x0129  */
    /* JADX WARN: Code duplicated, block: B:106:0x013e  */
    /* JADX WARN: Code duplicated, block: B:107:0x016a  */
    /* JADX WARN: Code duplicated, block: B:109:0x016e  */
    /* JADX WARN: Code duplicated, block: B:112:0x018c  */
    /* JADX WARN: Code duplicated, block: B:115:0x0199  */
    /* JADX WARN: Code duplicated, block: B:117:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    /* JADX WARN: Code duplicated, block: B:25:0x0045  */
    /* JADX WARN: Code duplicated, block: B:27:0x004d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0050  */
    /* JADX WARN: Code duplicated, block: B:31:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x005c  */
    /* JADX WARN: Code duplicated, block: B:36:0x0060  */
    /* JADX WARN: Code duplicated, block: B:38:0x0068  */
    /* JADX WARN: Code duplicated, block: B:39:0x006b  */
    /* JADX WARN: Code duplicated, block: B:42:0x0071  */
    /* JADX WARN: Code duplicated, block: B:45:0x007b  */
    /* JADX WARN: Code duplicated, block: B:47:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x0098  */
    /* JADX WARN: Code duplicated, block: B:58:0x009c  */
    /* JADX WARN: Code duplicated, block: B:60:0x009f  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:63:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00de  */
    /* JADX WARN: Code duplicated, block: B:81:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:94:0x010f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:95:0x0111  */
    /* JADX WARN: Code duplicated, block: B:96:0x0114  */
    /* JADX WARN: Code duplicated, block: B:99:0x0119  */
    public static final void b(final fq0 fq0Var, ek1 ek1Var, boolean z, yj2 yj2Var, ao aoVar, yl ylVar, qt1 qt1Var, final w10 w10Var, x20 x20Var, final int i, final int i2) {
        int i3;
        ek1 ek1Var2;
        int i4;
        final yj2 yj2Var2;
        final ao aoVarB;
        int i5;
        final yl ylVar2;
        int i6;
        qt1 qt1Var2;
        int i7;
        int i8;
        w10 w10Var2;
        boolean z2;
        final ek1 ek1Var3;
        final qt1 qt1Var3;
        final boolean z3;
        a42 a42VarR;
        ek1 ek1Var4;
        yj2 yj2VarA;
        int i9;
        ek1 ek1Var5;
        ao aoVar2;
        boolean z4;
        int i10;
        int i11;
        x20Var.X(399974542);
        if ((i & 6) == 0) {
            i3 = (x20Var.h(fq0Var) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                ek1Var2 = ek1Var;
                i3 |= x20Var.f(ek1Var2) ? 32 : 16;
            }
            i4 = i3 | CollationFastLatin.LATIN_LIMIT;
            if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
                if ((i2 & 8) == 0) {
                    yj2Var2 = yj2Var;
                    int i13 = x20Var.f(yj2Var2) ? 2048 : 1024;
                    i4 |= i13;
                } else {
                    yj2Var2 = yj2Var;
                }
                i4 |= i13;
            } else {
                yj2Var2 = yj2Var;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    aoVarB = aoVar;
                    int i14 = x20Var.f(aoVarB) ? 16384 : 8192;
                    i4 |= i14;
                } else {
                    aoVarB = aoVar;
                }
                i4 |= i14;
            } else {
                aoVarB = aoVar;
            }
            i5 = i4 | 196608;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    ylVar2 = ylVar;
                    if (x20Var.f(ylVar2)) {
                        i11 = 1048576;
                    }
                    i5 |= i11;
                } else {
                    ylVar2 = ylVar;
                }
                i11 = ArabicShaping.TASHKEEL_RESIZE;
                i5 |= i11;
            } else {
                ylVar2 = ylVar;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                if ((12582912 & i) == 0) {
                    qt1Var2 = qt1Var;
                    if (x20Var.f(qt1Var2)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i5 |= i7;
                }
                i8 = i5 | 100663296;
                if ((805306368 & i) == 0) {
                    w10Var2 = w10Var;
                    if (x20Var.h(w10Var2)) {
                        i10 = 536870912;
                    } else {
                        i10 = 268435456;
                    }
                    i8 |= i10;
                } else {
                    w10Var2 = w10Var;
                }
                if ((306783379 & i8) != 306783378) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (x20Var.O(i8 & 1, z2)) {
                    x20Var.T();
                    if ((i & 1) != 0 || x20Var.y()) {
                        if (i12 != 0) {
                            ek1Var4 = bk1.a;
                        } else {
                            ek1Var4 = ek1Var2;
                        }
                        if ((i2 & 8) != 0) {
                            qt1 qt1Var4 = bo.a;
                            yj2VarA = dk2.a(dl1.a, x20Var);
                            i8 &= -7169;
                        } else {
                            yj2VarA = yj2Var2;
                        }
                        if ((i2 & 16) != 0) {
                            qt1 qt1Var5 = bo.a;
                            i8 &= -57345;
                            aoVarB = bo.b((yz) x20Var.j(a00.a));
                        }
                        if ((i2 & 64) != 0) {
                            qt1 qt1Var6 = bo.a;
                            x20Var.W(-112346942);
                            long jA = a00.a((yz) x20Var.j(a00.a), a34.d);
                            x20Var.p(false);
                            i8 &= -3670017;
                            ylVar2 = new yl(dl1.b, new cn2(jA));
                        }
                        if (i6 != 0) {
                            qt1Var2 = bo.a;
                        }
                        i9 = i8;
                        ek1Var5 = ek1Var4;
                        aoVar2 = aoVarB;
                        qt1Var3 = qt1Var2;
                        z4 = true;
                    } else {
                        x20Var.R();
                        if ((i2 & 8) != 0) {
                            i8 &= -7169;
                        }
                        if ((i2 & 16) != 0) {
                            i8 &= -57345;
                        }
                        if ((i2 & 64) != 0) {
                            i8 &= -3670017;
                        }
                        z4 = z;
                        i9 = i8;
                        ek1Var5 = ek1Var2;
                        yj2VarA = yj2Var2;
                        aoVar2 = aoVarB;
                        qt1Var3 = qt1Var2;
                    }
                    x20Var.q();
                    a(fq0Var, ek1Var5, z4, yj2VarA, aoVar2, null, ylVar2, qt1Var3, w10Var2, x20Var, i9 & 2147483646, 0);
                    aoVarB = aoVar2;
                    yj2Var2 = yj2VarA;
                    z3 = z4;
                    ek1Var3 = ek1Var5;
                } else {
                    x20Var.R();
                    ek1Var3 = ek1Var2;
                    qt1Var3 = qt1Var2;
                    z3 = z;
                }
                a42VarR = x20Var.r();
                if (a42VarR != null) {
                    a42VarR.d = new vq0() { // from class: fo
                        @Override // defpackage.vq0
                        public final Object e(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            dg4.b(fq0Var, ek1Var3, z3, yj2Var2, aoVarB, ylVar2, qt1Var3, w10Var, (x20) obj, ny3.c(i | 1), i2);
                            return q43.a;
                        }
                    };
                }
            }
            i5 |= 12582912;
            qt1Var2 = qt1Var;
            i8 = i5 | 100663296;
            if ((805306368 & i) == 0) {
                w10Var2 = w10Var;
                if (x20Var.h(w10Var2)) {
                    i10 = 536870912;
                } else {
                    i10 = 268435456;
                }
                i8 |= i10;
            } else {
                w10Var2 = w10Var;
            }
            if ((306783379 & i8) != 306783378) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (x20Var.O(i8 & 1, z2)) {
                x20Var.T();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        ek1Var4 = bk1.a;
                    } else {
                        ek1Var4 = ek1Var2;
                    }
                    if ((i2 & 8) != 0) {
                        qt1 qt1Var7 = bo.a;
                        yj2VarA = dk2.a(dl1.a, x20Var);
                        i8 &= -7169;
                    } else {
                        yj2VarA = yj2Var2;
                    }
                    if ((i2 & 16) != 0) {
                        qt1 qt1Var8 = bo.a;
                        i8 &= -57345;
                        aoVarB = bo.b((yz) x20Var.j(a00.a));
                    }
                    if ((i2 & 64) != 0) {
                        qt1 qt1Var9 = bo.a;
                        x20Var.W(-112346942);
                        long jA2 = a00.a((yz) x20Var.j(a00.a), a34.d);
                        x20Var.p(false);
                        i8 &= -3670017;
                        ylVar2 = new yl(dl1.b, new cn2(jA2));
                    }
                    if (i6 != 0) {
                        qt1Var2 = bo.a;
                    }
                    i9 = i8;
                    ek1Var5 = ek1Var4;
                    aoVar2 = aoVarB;
                    qt1Var3 = qt1Var2;
                    z4 = true;
                } else {
                    if (i12 != 0) {
                        ek1Var4 = bk1.a;
                    } else {
                        ek1Var4 = ek1Var2;
                    }
                    if ((i2 & 8) != 0) {
                        qt1 qt1Var10 = bo.a;
                        yj2VarA = dk2.a(dl1.a, x20Var);
                        i8 &= -7169;
                    } else {
                        yj2VarA = yj2Var2;
                    }
                    if ((i2 & 16) != 0) {
                        qt1 qt1Var11 = bo.a;
                        i8 &= -57345;
                        aoVarB = bo.b((yz) x20Var.j(a00.a));
                    }
                    if ((i2 & 64) != 0) {
                        qt1 qt1Var12 = bo.a;
                        x20Var.W(-112346942);
                        long jA3 = a00.a((yz) x20Var.j(a00.a), a34.d);
                        x20Var.p(false);
                        i8 &= -3670017;
                        ylVar2 = new yl(dl1.b, new cn2(jA3));
                    }
                    if (i6 != 0) {
                        qt1Var2 = bo.a;
                    }
                    i9 = i8;
                    ek1Var5 = ek1Var4;
                    aoVar2 = aoVarB;
                    qt1Var3 = qt1Var2;
                    z4 = true;
                }
                x20Var.q();
                a(fq0Var, ek1Var5, z4, yj2VarA, aoVar2, null, ylVar2, qt1Var3, w10Var2, x20Var, i9 & 2147483646, 0);
                aoVarB = aoVar2;
                yj2Var2 = yj2VarA;
                z3 = z4;
                ek1Var3 = ek1Var5;
            } else {
                x20Var.R();
                ek1Var3 = ek1Var2;
                qt1Var3 = qt1Var2;
                z3 = z;
            }
            a42VarR = x20Var.r();
            if (a42VarR != null) {
                a42VarR.d = new vq0() { // from class: fo
                    @Override // defpackage.vq0
                    public final Object e(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        dg4.b(fq0Var, ek1Var3, z3, yj2Var2, aoVarB, ylVar2, qt1Var3, w10Var, (x20) obj, ny3.c(i | 1), i2);
                        return q43.a;
                    }
                };
            }
        }
        i3 |= 48;
        ek1Var2 = ek1Var;
        i4 = i3 | CollationFastLatin.LATIN_LIMIT;
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            if ((i2 & 8) == 0) {
                yj2Var2 = yj2Var;
                if (x20Var.f(yj2Var2)) {
                }
                i4 |= i13;
            } else {
                yj2Var2 = yj2Var;
            }
            i4 |= i13;
        } else {
            yj2Var2 = yj2Var;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                aoVarB = aoVar;
                if (x20Var.f(aoVarB)) {
                }
                i4 |= i14;
            } else {
                aoVarB = aoVar;
            }
            i4 |= i14;
        } else {
            aoVarB = aoVar;
        }
        i5 = i4 | 196608;
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                ylVar2 = ylVar;
                if (x20Var.f(ylVar2)) {
                    i11 = 1048576;
                }
                i5 |= i11;
            } else {
                ylVar2 = ylVar;
            }
            i11 = ArabicShaping.TASHKEEL_RESIZE;
            i5 |= i11;
        } else {
            ylVar2 = ylVar;
        }
        i6 = i2 & 128;
        if (i6 != 0) {
            if ((12582912 & i) == 0) {
                qt1Var2 = qt1Var;
                if (x20Var.f(qt1Var2)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i5 |= i7;
            }
            i8 = i5 | 100663296;
            if ((805306368 & i) == 0) {
                w10Var2 = w10Var;
                if (x20Var.h(w10Var2)) {
                    i10 = 536870912;
                } else {
                    i10 = 268435456;
                }
                i8 |= i10;
            } else {
                w10Var2 = w10Var;
            }
            if ((306783379 & i8) != 306783378) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (x20Var.O(i8 & 1, z2)) {
                x20Var.T();
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        ek1Var4 = bk1.a;
                    } else {
                        ek1Var4 = ek1Var2;
                    }
                    if ((i2 & 8) != 0) {
                        qt1 qt1Var13 = bo.a;
                        yj2VarA = dk2.a(dl1.a, x20Var);
                        i8 &= -7169;
                    } else {
                        yj2VarA = yj2Var2;
                    }
                    if ((i2 & 16) != 0) {
                        qt1 qt1Var14 = bo.a;
                        i8 &= -57345;
                        aoVarB = bo.b((yz) x20Var.j(a00.a));
                    }
                    if ((i2 & 64) != 0) {
                        qt1 qt1Var15 = bo.a;
                        x20Var.W(-112346942);
                        long jA4 = a00.a((yz) x20Var.j(a00.a), a34.d);
                        x20Var.p(false);
                        i8 &= -3670017;
                        ylVar2 = new yl(dl1.b, new cn2(jA4));
                    }
                    if (i6 != 0) {
                        qt1Var2 = bo.a;
                    }
                    i9 = i8;
                    ek1Var5 = ek1Var4;
                    aoVar2 = aoVarB;
                    qt1Var3 = qt1Var2;
                    z4 = true;
                } else {
                    if (i12 != 0) {
                        ek1Var4 = bk1.a;
                    } else {
                        ek1Var4 = ek1Var2;
                    }
                    if ((i2 & 8) != 0) {
                        qt1 qt1Var16 = bo.a;
                        yj2VarA = dk2.a(dl1.a, x20Var);
                        i8 &= -7169;
                    } else {
                        yj2VarA = yj2Var2;
                    }
                    if ((i2 & 16) != 0) {
                        qt1 qt1Var17 = bo.a;
                        i8 &= -57345;
                        aoVarB = bo.b((yz) x20Var.j(a00.a));
                    }
                    if ((i2 & 64) != 0) {
                        qt1 qt1Var18 = bo.a;
                        x20Var.W(-112346942);
                        long jA5 = a00.a((yz) x20Var.j(a00.a), a34.d);
                        x20Var.p(false);
                        i8 &= -3670017;
                        ylVar2 = new yl(dl1.b, new cn2(jA5));
                    }
                    if (i6 != 0) {
                        qt1Var2 = bo.a;
                    }
                    i9 = i8;
                    ek1Var5 = ek1Var4;
                    aoVar2 = aoVarB;
                    qt1Var3 = qt1Var2;
                    z4 = true;
                }
                x20Var.q();
                a(fq0Var, ek1Var5, z4, yj2VarA, aoVar2, null, ylVar2, qt1Var3, w10Var2, x20Var, i9 & 2147483646, 0);
                aoVarB = aoVar2;
                yj2Var2 = yj2VarA;
                z3 = z4;
                ek1Var3 = ek1Var5;
            } else {
                x20Var.R();
                ek1Var3 = ek1Var2;
                qt1Var3 = qt1Var2;
                z3 = z;
            }
            a42VarR = x20Var.r();
            if (a42VarR != null) {
                a42VarR.d = new vq0() { // from class: fo
                    @Override // defpackage.vq0
                    public final Object e(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        dg4.b(fq0Var, ek1Var3, z3, yj2Var2, aoVarB, ylVar2, qt1Var3, w10Var, (x20) obj, ny3.c(i | 1), i2);
                        return q43.a;
                    }
                };
            }
        }
        i5 |= 12582912;
        qt1Var2 = qt1Var;
        i8 = i5 | 100663296;
        if ((805306368 & i) == 0) {
            w10Var2 = w10Var;
            if (x20Var.h(w10Var2)) {
                i10 = 536870912;
            } else {
                i10 = 268435456;
            }
            i8 |= i10;
        } else {
            w10Var2 = w10Var;
        }
        if ((306783379 & i8) != 306783378) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (x20Var.O(i8 & 1, z2)) {
            x20Var.T();
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    ek1Var4 = bk1.a;
                } else {
                    ek1Var4 = ek1Var2;
                }
                if ((i2 & 8) != 0) {
                    qt1 qt1Var19 = bo.a;
                    yj2VarA = dk2.a(dl1.a, x20Var);
                    i8 &= -7169;
                } else {
                    yj2VarA = yj2Var2;
                }
                if ((i2 & 16) != 0) {
                    qt1 qt1Var110 = bo.a;
                    i8 &= -57345;
                    aoVarB = bo.b((yz) x20Var.j(a00.a));
                }
                if ((i2 & 64) != 0) {
                    qt1 qt1Var111 = bo.a;
                    x20Var.W(-112346942);
                    long jA6 = a00.a((yz) x20Var.j(a00.a), a34.d);
                    x20Var.p(false);
                    i8 &= -3670017;
                    ylVar2 = new yl(dl1.b, new cn2(jA6));
                }
                if (i6 != 0) {
                    qt1Var2 = bo.a;
                }
                i9 = i8;
                ek1Var5 = ek1Var4;
                aoVar2 = aoVarB;
                qt1Var3 = qt1Var2;
                z4 = true;
            } else {
                if (i12 != 0) {
                    ek1Var4 = bk1.a;
                } else {
                    ek1Var4 = ek1Var2;
                }
                if ((i2 & 8) != 0) {
                    qt1 qt1Var112 = bo.a;
                    yj2VarA = dk2.a(dl1.a, x20Var);
                    i8 &= -7169;
                } else {
                    yj2VarA = yj2Var2;
                }
                if ((i2 & 16) != 0) {
                    qt1 qt1Var113 = bo.a;
                    i8 &= -57345;
                    aoVarB = bo.b((yz) x20Var.j(a00.a));
                }
                if ((i2 & 64) != 0) {
                    qt1 qt1Var114 = bo.a;
                    x20Var.W(-112346942);
                    long jA7 = a00.a((yz) x20Var.j(a00.a), a34.d);
                    x20Var.p(false);
                    i8 &= -3670017;
                    ylVar2 = new yl(dl1.b, new cn2(jA7));
                }
                if (i6 != 0) {
                    qt1Var2 = bo.a;
                }
                i9 = i8;
                ek1Var5 = ek1Var4;
                aoVar2 = aoVarB;
                qt1Var3 = qt1Var2;
                z4 = true;
            }
            x20Var.q();
            a(fq0Var, ek1Var5, z4, yj2VarA, aoVar2, null, ylVar2, qt1Var3, w10Var2, x20Var, i9 & 2147483646, 0);
            aoVarB = aoVar2;
            yj2Var2 = yj2VarA;
            z3 = z4;
            ek1Var3 = ek1Var5;
        } else {
            x20Var.R();
            ek1Var3 = ek1Var2;
            qt1Var3 = qt1Var2;
            z3 = z;
        }
        a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new vq0() { // from class: fo
                @Override // defpackage.vq0
                public final Object e(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    dg4.b(fq0Var, ek1Var3, z3, yj2Var2, aoVarB, ylVar2, qt1Var3, w10Var, (x20) obj, ny3.c(i | 1), i2);
                    return q43.a;
                }
            };
        }
    }

    public static int c(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 9;
            case 9:
                return 10;
            case 10:
                return 11;
            case 11:
                return 12;
            case 12:
                return 13;
            case 13:
                return 14;
            case 14:
                return 15;
            default:
                return 0;
        }
    }
}
