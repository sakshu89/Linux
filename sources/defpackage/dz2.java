package defpackage;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.Normalizer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class dz2 {
    public static final m30 a = new m30(new tv1(15));

    public static final void a(yz2 yz2Var, w10 w10Var, x20 x20Var, int i) {
        x20Var.X(15327438);
        int i2 = 16;
        int i3 = (x20Var.f(yz2Var) ? 4 : 2) | i | (x20Var.h(w10Var) ? 32 : 16);
        if (x20Var.O(i3 & 1, (i3 & 19) != 18)) {
            m30 m30Var = a;
            kj4.a(m30Var.a(((yz2) x20Var.j(m30Var)).d(yz2Var)), w10Var, x20Var, (i3 & 112) | 8);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new km(i, i2, yz2Var, w10Var);
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x013e  */
    /* JADX WARN: Code duplicated, block: B:103:0x0143  */
    /* JADX WARN: Code duplicated, block: B:106:0x014f  */
    /* JADX WARN: Code duplicated, block: B:108:0x0159  */
    /* JADX WARN: Code duplicated, block: B:109:0x015c  */
    /* JADX WARN: Code duplicated, block: B:112:0x016f  */
    /* JADX WARN: Code duplicated, block: B:116:0x017c  */
    /* JADX WARN: Code duplicated, block: B:119:0x0186  */
    /* JADX WARN: Code duplicated, block: B:121:0x0190  */
    /* JADX WARN: Code duplicated, block: B:128:0x01b2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:129:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:130:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:132:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:134:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:135:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:138:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:140:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:142:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:143:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:146:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:149:0x01db  */
    /* JADX WARN: Code duplicated, block: B:150:0x01de  */
    /* JADX WARN: Code duplicated, block: B:152:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:155:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:157:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:160:0x0208  */
    /* JADX WARN: Code duplicated, block: B:161:0x020f  */
    /* JADX WARN: Code duplicated, block: B:163:0x021d  */
    /* JADX WARN: Code duplicated, block: B:164:0x0222  */
    /* JADX WARN: Code duplicated, block: B:168:0x023a  */
    /* JADX WARN: Code duplicated, block: B:170:0x02a2  */
    /* JADX WARN: Code duplicated, block: B:173:0x02c1  */
    /* JADX WARN: Code duplicated, block: B:175:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0041  */
    /* JADX WARN: Code duplicated, block: B:25:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004a  */
    /* JADX WARN: Code duplicated, block: B:29:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x0055  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:39:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x0076  */
    /* JADX WARN: Code duplicated, block: B:44:0x0084  */
    /* JADX WARN: Code duplicated, block: B:46:0x0089  */
    /* JADX WARN: Code duplicated, block: B:48:0x008e  */
    /* JADX WARN: Code duplicated, block: B:50:0x0096  */
    /* JADX WARN: Code duplicated, block: B:51:0x0099  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:58:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:61:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:68:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:77:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:80:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:84:0x0104  */
    /* JADX WARN: Code duplicated, block: B:85:0x010a  */
    /* JADX WARN: Code duplicated, block: B:87:0x010e  */
    /* JADX WARN: Code duplicated, block: B:89:0x0116  */
    /* JADX WARN: Code duplicated, block: B:90:0x0119  */
    /* JADX WARN: Code duplicated, block: B:93:0x0120  */
    /* JADX WARN: Code duplicated, block: B:96:0x012b  */
    /* JADX WARN: Code duplicated, block: B:97:0x0132  */
    /* JADX WARN: Code duplicated, block: B:99:0x0136  */
    public static final void b(final String str, ek1 ek1Var, long j, long j2, np0 np0Var, ev2 ev2Var, long j3, vw2 vw2Var, long j4, int i, boolean z, int i2, int i3, yz2 yz2Var, x20 x20Var, final int i4, final int i5, final int i6) {
        int i7;
        ek1 ek1Var2;
        int i8;
        long j5;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        np0 np0Var2;
        int i15;
        int i16;
        int i17;
        ev2 ev2Var2;
        int i18;
        int i19;
        int i20;
        int i21;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        int i30;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        boolean z2;
        boolean z3;
        final int i36;
        final yz2 yz2Var2;
        final int i37;
        final ek1 ek1Var3;
        final ev2 ev2Var3;
        final long j6;
        final np0 np0Var3;
        final long j7;
        final long j8;
        final vw2 vw2Var2;
        final long j9;
        final int i38;
        final boolean z4;
        a42 a42VarR;
        ek1 ek1Var4;
        long j10;
        long j11;
        vw2 vw2Var3;
        long j12;
        int i39;
        yz2 yz2Var3;
        int i40;
        long jB;
        x20Var.X(1809465675);
        if ((i4 & 6) == 0) {
            i7 = (x20Var.f(str) ? 4 : 2) | i4;
        } else {
            i7 = i4;
        }
        int i41 = i6 & 2;
        if (i41 == 0) {
            if ((i4 & 48) == 0) {
                ek1Var2 = ek1Var;
                i7 |= x20Var.f(ek1Var2) ? 32 : 16;
            }
            i8 = i6 & 4;
            if (i8 != 0) {
                if ((i4 & CollationFastLatin.LATIN_LIMIT) == 0) {
                    j5 = j;
                    if (x20Var.e(j5)) {
                        i9 = 256;
                    } else {
                        i9 = 128;
                    }
                    i7 |= i9;
                }
                i10 = i7 | UCharacterProperty.SCRIPT_X_WITH_OTHER;
                i11 = i6 & 16;
                if (i11 != 0) {
                    i10 = i7 | 27648;
                } else if ((i4 & 24576) == 0) {
                    if (x20Var.e(j2)) {
                        i12 = 16384;
                    } else {
                        i12 = 8192;
                    }
                    i10 |= i12;
                }
                i13 = i10 | 196608;
                i14 = i6 & 64;
                if (i14 != 0) {
                    if ((1572864 & i4) == 0) {
                        np0Var2 = np0Var;
                        if (x20Var.f(np0Var2)) {
                            i15 = 1048576;
                        } else {
                            i15 = ArabicShaping.TASHKEEL_RESIZE;
                        }
                        i13 |= i15;
                    }
                    i16 = i6 & 128;
                    i17 = 4194304;
                    if (i16 != 0) {
                        i13 |= 12582912;
                        ev2Var2 = ev2Var;
                    } else {
                        ev2Var2 = ev2Var;
                        if ((i4 & 12582912) == 0) {
                            if (x20Var.f(ev2Var2)) {
                                i18 = 8388608;
                            } else {
                                i18 = 4194304;
                            }
                            i13 |= i18;
                        }
                    }
                    i19 = i6 & 256;
                    if (i19 != 0) {
                        i13 |= 100663296;
                    } else if ((i4 & 100663296) == 0) {
                        if (x20Var.e(j3)) {
                            i20 = 67108864;
                        } else {
                            i20 = 33554432;
                        }
                        i13 |= i20;
                    }
                    i21 = i13 | 805306368;
                    i22 = i6 & 1024;
                    if (i22 != 0) {
                        i24 = i5 | 6;
                    } else {
                        if (x20Var.f(vw2Var)) {
                            i23 = 4;
                        } else {
                            i23 = 2;
                        }
                        i24 = i5 | i23;
                    }
                    i25 = i24;
                    i26 = i25 | 48;
                    i27 = i6 & 4096;
                    if (i27 != 0) {
                        i28 = i25 | 432;
                    } else {
                        if ((i5 & CollationFastLatin.LATIN_LIMIT) != 0) {
                            if (x20Var.d(i)) {
                                i29 = 256;
                            } else {
                                i29 = 128;
                            }
                            i26 |= i29;
                        }
                        i28 = i26;
                    }
                    i30 = i28 | UCharacterProperty.SCRIPT_X_WITH_OTHER;
                    i31 = i6 & 16384;
                    if (i31 != 0) {
                        i33 = i28 | 27648;
                        i32 = i2;
                    } else if ((i5 & 24576) == 0) {
                        i32 = i2;
                        i33 = i30 | (x20Var.d(i32) ? 16384 : 8192);
                    } else {
                        i32 = i2;
                        i33 = i30;
                    }
                    int i42 = i33 | 1769472;
                    if ((i6 & Normalizer.INPUT_IS_FCD) == 0) {
                        i34 = i31;
                        if (x20Var.f(yz2Var)) {
                            i17 = 8388608;
                        }
                    } else {
                        i34 = i31;
                    }
                    i35 = i42 | i17;
                    z2 = true;
                    if ((i21 & 306783379) == 306783378 || (i35 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (x20Var.O(i21 & 1, z3)) {
                        x20Var.T();
                        if ((i4 & 1) != 0 || x20Var.y()) {
                            if (i41 != 0) {
                                ek1Var4 = bk1.a;
                            } else {
                                ek1Var4 = ek1Var2;
                            }
                            if (i8 != 0) {
                                j5 = sz.g;
                            }
                            if (i11 != 0) {
                                j10 = b03.c;
                            } else {
                                j10 = j2;
                            }
                            if (i14 != 0) {
                                np0Var2 = null;
                            }
                            if (i16 != 0) {
                                ev2Var2 = null;
                            }
                            if (i19 != 0) {
                                j11 = b03.c;
                            } else {
                                j11 = j3;
                            }
                            vw2Var3 = i22 == 0 ? vw2Var : null;
                            j12 = b03.c;
                            if (i27 != 0) {
                                i39 = 1;
                            } else {
                                i39 = i;
                            }
                            if (i34 != 0) {
                                i32 = Integer.MAX_VALUE;
                            }
                            if ((i6 & Normalizer.INPUT_IS_FCD) != 0) {
                                yz2Var3 = (yz2) x20Var.j(a);
                                i35 &= -29360129;
                            } else {
                                yz2Var3 = yz2Var;
                            }
                            i40 = 1;
                        } else {
                            x20Var.R();
                            if ((i6 & Normalizer.INPUT_IS_FCD) != 0) {
                                i35 &= -29360129;
                            }
                            j11 = j3;
                            vw2Var3 = vw2Var;
                            j12 = j4;
                            i39 = i;
                            z2 = z;
                            i40 = i3;
                            yz2Var3 = yz2Var;
                            ek1Var4 = ek1Var2;
                            j10 = j2;
                        }
                        x20Var.q();
                        x20Var.W(-565217106);
                        if (j5 != 16) {
                            ek1Var4 = ek1Var4;
                            i40 = i40;
                            jB = j5;
                        } else {
                            x20Var.W(-565216333);
                            jB = yz2Var3.b();
                            if (jB != 16) {
                                jB = ((sz) x20Var.j(g50.a)).a;
                            }
                            x20Var.p(false);
                        }
                        x20Var.p(false);
                        int i43 = i35 << 6;
                        ek1 ek1Var5 = ek1Var4;
                        int i44 = i40;
                        ef4.a(str, ek1Var5, yz2.e(yz2Var3, jB, j10, np0Var2, ev2Var2, j11, vw2Var3 != null ? vw2Var3.a : 0, j12, 16609104), i39, z2, i32, i44, x20Var, (i21 & 126) | UCharacterProperty.SCRIPT_X_WITH_OTHER | (57344 & i43) | 196608 | (i43 & 3670016) | 12582912 | ((i21 << 18) & 1879048192), 256);
                        i38 = i39;
                        j6 = j5;
                        i36 = i44;
                        ek1Var3 = ek1Var5;
                        i37 = i32;
                        yz2Var2 = yz2Var3;
                        j7 = j10;
                        ev2Var3 = ev2Var2;
                        np0Var3 = np0Var2;
                        j9 = j12;
                        z4 = z2;
                        vw2Var2 = vw2Var3;
                        j8 = j11;
                    } else {
                        x20Var.R();
                        i36 = i3;
                        yz2Var2 = yz2Var;
                        i37 = i32;
                        ek1Var3 = ek1Var2;
                        ev2Var3 = ev2Var2;
                        j6 = j5;
                        np0Var3 = np0Var2;
                        j7 = j2;
                        j8 = j3;
                        vw2Var2 = vw2Var;
                        j9 = j4;
                        i38 = i;
                        z4 = z;
                    }
                    a42VarR = x20Var.r();
                    if (a42VarR != null) {
                        a42VarR.d = new vq0() { // from class: cz2
                            @Override // defpackage.vq0
                            public final Object e(Object obj, Object obj2) {
                                ((Integer) obj2).getClass();
                                int iC = ny3.c(i4 | 1);
                                int iC2 = ny3.c(i5);
                                dz2.b(str, ek1Var3, j6, j7, np0Var3, ev2Var3, j8, vw2Var2, j9, i38, z4, i37, i36, yz2Var2, (x20) obj, iC, iC2, i6);
                                return q43.a;
                            }
                        };
                    }
                }
                i13 = i10 | 1769472;
                np0Var2 = np0Var;
                i16 = i6 & 128;
                i17 = 4194304;
                if (i16 != 0) {
                    i13 |= 12582912;
                    ev2Var2 = ev2Var;
                } else {
                    ev2Var2 = ev2Var;
                    if ((i4 & 12582912) == 0) {
                        if (x20Var.f(ev2Var2)) {
                            i18 = 8388608;
                        } else {
                            i18 = 4194304;
                        }
                        i13 |= i18;
                    }
                }
                i19 = i6 & 256;
                if (i19 != 0) {
                    i13 |= 100663296;
                } else if ((i4 & 100663296) == 0) {
                    if (x20Var.e(j3)) {
                        i20 = 67108864;
                    } else {
                        i20 = 33554432;
                    }
                    i13 |= i20;
                }
                i21 = i13 | 805306368;
                i22 = i6 & 1024;
                if (i22 != 0) {
                    i24 = i5 | 6;
                } else {
                    if (x20Var.f(vw2Var)) {
                        i23 = 4;
                    } else {
                        i23 = 2;
                    }
                    i24 = i5 | i23;
                }
                i25 = i24;
                i26 = i25 | 48;
                i27 = i6 & 4096;
                if (i27 != 0) {
                    i28 = i25 | 432;
                } else {
                    if ((i5 & CollationFastLatin.LATIN_LIMIT) != 0) {
                        if (x20Var.d(i)) {
                            i29 = 256;
                        } else {
                            i29 = 128;
                        }
                        i26 |= i29;
                    }
                    i28 = i26;
                }
                i30 = i28 | UCharacterProperty.SCRIPT_X_WITH_OTHER;
                i31 = i6 & 16384;
                if (i31 != 0) {
                    i33 = i28 | 27648;
                    i32 = i2;
                } else if ((i5 & 24576) == 0) {
                    i32 = i2;
                    i33 = i30 | (x20Var.d(i32) ? 16384 : 8192);
                } else {
                    i32 = i2;
                    i33 = i30;
                }
                int i45 = i33 | 1769472;
                if ((i6 & Normalizer.INPUT_IS_FCD) == 0) {
                    i34 = i31;
                    if (x20Var.f(yz2Var)) {
                        i17 = 8388608;
                    }
                } else {
                    i34 = i31;
                }
                i35 = i45 | i17;
                z2 = true;
                if ((i21 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (x20Var.O(i21 & 1, z3)) {
                    x20Var.T();
                    if ((i4 & 1) != 0) {
                        if (i41 != 0) {
                            ek1Var4 = bk1.a;
                        } else {
                            ek1Var4 = ek1Var2;
                        }
                        if (i8 != 0) {
                            j5 = sz.g;
                        }
                        if (i11 != 0) {
                            j10 = b03.c;
                        } else {
                            j10 = j2;
                        }
                        if (i14 != 0) {
                            np0Var2 = null;
                        }
                        if (i16 != 0) {
                            ev2Var2 = null;
                        }
                        if (i19 != 0) {
                            j11 = b03.c;
                        } else {
                            j11 = j3;
                        }
                        if (i22 == 0) {
                        }
                        j12 = b03.c;
                        if (i27 != 0) {
                            i39 = 1;
                        } else {
                            i39 = i;
                        }
                        if (i34 != 0) {
                            i32 = Integer.MAX_VALUE;
                        }
                        if ((i6 & Normalizer.INPUT_IS_FCD) != 0) {
                            yz2Var3 = (yz2) x20Var.j(a);
                            i35 &= -29360129;
                        } else {
                            yz2Var3 = yz2Var;
                        }
                        i40 = 1;
                    } else {
                        if (i41 != 0) {
                            ek1Var4 = bk1.a;
                        } else {
                            ek1Var4 = ek1Var2;
                        }
                        if (i8 != 0) {
                            j5 = sz.g;
                        }
                        if (i11 != 0) {
                            j10 = b03.c;
                        } else {
                            j10 = j2;
                        }
                        if (i14 != 0) {
                            np0Var2 = null;
                        }
                        if (i16 != 0) {
                            ev2Var2 = null;
                        }
                        if (i19 != 0) {
                            j11 = b03.c;
                        } else {
                            j11 = j3;
                        }
                        if (i22 == 0) {
                        }
                        j12 = b03.c;
                        if (i27 != 0) {
                            i39 = 1;
                        } else {
                            i39 = i;
                        }
                        if (i34 != 0) {
                            i32 = Integer.MAX_VALUE;
                        }
                        if ((i6 & Normalizer.INPUT_IS_FCD) != 0) {
                            yz2Var3 = (yz2) x20Var.j(a);
                            i35 &= -29360129;
                        } else {
                            yz2Var3 = yz2Var;
                        }
                        i40 = 1;
                    }
                    x20Var.q();
                    x20Var.W(-565217106);
                    if (j5 != 16) {
                        ek1Var4 = ek1Var4;
                        i40 = i40;
                        jB = j5;
                    } else {
                        x20Var.W(-565216333);
                        jB = yz2Var3.b();
                        if (jB != 16) {
                            jB = ((sz) x20Var.j(g50.a)).a;
                        }
                        x20Var.p(false);
                    }
                    x20Var.p(false);
                    int i46 = i35 << 6;
                    ek1 ek1Var6 = ek1Var4;
                    int i47 = i40;
                    ef4.a(str, ek1Var6, yz2.e(yz2Var3, jB, j10, np0Var2, ev2Var2, j11, vw2Var3 != null ? vw2Var3.a : 0, j12, 16609104), i39, z2, i32, i47, x20Var, (i21 & 126) | UCharacterProperty.SCRIPT_X_WITH_OTHER | (57344 & i46) | 196608 | (i46 & 3670016) | 12582912 | ((i21 << 18) & 1879048192), 256);
                    i38 = i39;
                    j6 = j5;
                    i36 = i47;
                    ek1Var3 = ek1Var6;
                    i37 = i32;
                    yz2Var2 = yz2Var3;
                    j7 = j10;
                    ev2Var3 = ev2Var2;
                    np0Var3 = np0Var2;
                    j9 = j12;
                    z4 = z2;
                    vw2Var2 = vw2Var3;
                    j8 = j11;
                } else {
                    x20Var.R();
                    i36 = i3;
                    yz2Var2 = yz2Var;
                    i37 = i32;
                    ek1Var3 = ek1Var2;
                    ev2Var3 = ev2Var2;
                    j6 = j5;
                    np0Var3 = np0Var2;
                    j7 = j2;
                    j8 = j3;
                    vw2Var2 = vw2Var;
                    j9 = j4;
                    i38 = i;
                    z4 = z;
                }
                a42VarR = x20Var.r();
                if (a42VarR != null) {
                    a42VarR.d = new vq0() { // from class: cz2
                        @Override // defpackage.vq0
                        public final Object e(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iC = ny3.c(i4 | 1);
                            int iC2 = ny3.c(i5);
                            dz2.b(str, ek1Var3, j6, j7, np0Var3, ev2Var3, j8, vw2Var2, j9, i38, z4, i37, i36, yz2Var2, (x20) obj, iC, iC2, i6);
                            return q43.a;
                        }
                    };
                }
            }
            i7 |= CollationFastLatin.LATIN_LIMIT;
            j5 = j;
            i10 = i7 | UCharacterProperty.SCRIPT_X_WITH_OTHER;
            i11 = i6 & 16;
            if (i11 != 0) {
                i10 = i7 | 27648;
            } else if ((i4 & 24576) == 0) {
                if (x20Var.e(j2)) {
                    i12 = 16384;
                } else {
                    i12 = 8192;
                }
                i10 |= i12;
            }
            i13 = i10 | 196608;
            i14 = i6 & 64;
            if (i14 != 0) {
                if ((1572864 & i4) == 0) {
                    np0Var2 = np0Var;
                    if (x20Var.f(np0Var2)) {
                        i15 = 1048576;
                    } else {
                        i15 = ArabicShaping.TASHKEEL_RESIZE;
                    }
                    i13 |= i15;
                }
                i16 = i6 & 128;
                i17 = 4194304;
                if (i16 != 0) {
                    i13 |= 12582912;
                    ev2Var2 = ev2Var;
                } else {
                    ev2Var2 = ev2Var;
                    if ((i4 & 12582912) == 0) {
                        if (x20Var.f(ev2Var2)) {
                            i18 = 8388608;
                        } else {
                            i18 = 4194304;
                        }
                        i13 |= i18;
                    }
                }
                i19 = i6 & 256;
                if (i19 != 0) {
                    i13 |= 100663296;
                } else if ((i4 & 100663296) == 0) {
                    if (x20Var.e(j3)) {
                        i20 = 67108864;
                    } else {
                        i20 = 33554432;
                    }
                    i13 |= i20;
                }
                i21 = i13 | 805306368;
                i22 = i6 & 1024;
                if (i22 != 0) {
                    i24 = i5 | 6;
                } else {
                    if (x20Var.f(vw2Var)) {
                        i23 = 4;
                    } else {
                        i23 = 2;
                    }
                    i24 = i5 | i23;
                }
                i25 = i24;
                i26 = i25 | 48;
                i27 = i6 & 4096;
                if (i27 != 0) {
                    i28 = i25 | 432;
                } else {
                    if ((i5 & CollationFastLatin.LATIN_LIMIT) != 0) {
                        if (x20Var.d(i)) {
                            i29 = 256;
                        } else {
                            i29 = 128;
                        }
                        i26 |= i29;
                    }
                    i28 = i26;
                }
                i30 = i28 | UCharacterProperty.SCRIPT_X_WITH_OTHER;
                i31 = i6 & 16384;
                if (i31 != 0) {
                    i33 = i28 | 27648;
                    i32 = i2;
                } else if ((i5 & 24576) == 0) {
                    i32 = i2;
                    i33 = i30 | (x20Var.d(i32) ? 16384 : 8192);
                } else {
                    i32 = i2;
                    i33 = i30;
                }
                int i48 = i33 | 1769472;
                if ((i6 & Normalizer.INPUT_IS_FCD) == 0) {
                    i34 = i31;
                    if (x20Var.f(yz2Var)) {
                        i17 = 8388608;
                    }
                } else {
                    i34 = i31;
                }
                i35 = i48 | i17;
                z2 = true;
                if ((i21 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (x20Var.O(i21 & 1, z3)) {
                    x20Var.T();
                    if ((i4 & 1) != 0) {
                        if (i41 != 0) {
                            ek1Var4 = bk1.a;
                        } else {
                            ek1Var4 = ek1Var2;
                        }
                        if (i8 != 0) {
                            j5 = sz.g;
                        }
                        if (i11 != 0) {
                            j10 = b03.c;
                        } else {
                            j10 = j2;
                        }
                        if (i14 != 0) {
                            np0Var2 = null;
                        }
                        if (i16 != 0) {
                            ev2Var2 = null;
                        }
                        if (i19 != 0) {
                            j11 = b03.c;
                        } else {
                            j11 = j3;
                        }
                        if (i22 == 0) {
                        }
                        j12 = b03.c;
                        if (i27 != 0) {
                            i39 = 1;
                        } else {
                            i39 = i;
                        }
                        if (i34 != 0) {
                            i32 = Integer.MAX_VALUE;
                        }
                        if ((i6 & Normalizer.INPUT_IS_FCD) != 0) {
                            yz2Var3 = (yz2) x20Var.j(a);
                            i35 &= -29360129;
                        } else {
                            yz2Var3 = yz2Var;
                        }
                        i40 = 1;
                    } else {
                        if (i41 != 0) {
                            ek1Var4 = bk1.a;
                        } else {
                            ek1Var4 = ek1Var2;
                        }
                        if (i8 != 0) {
                            j5 = sz.g;
                        }
                        if (i11 != 0) {
                            j10 = b03.c;
                        } else {
                            j10 = j2;
                        }
                        if (i14 != 0) {
                            np0Var2 = null;
                        }
                        if (i16 != 0) {
                            ev2Var2 = null;
                        }
                        if (i19 != 0) {
                            j11 = b03.c;
                        } else {
                            j11 = j3;
                        }
                        if (i22 == 0) {
                        }
                        j12 = b03.c;
                        if (i27 != 0) {
                            i39 = 1;
                        } else {
                            i39 = i;
                        }
                        if (i34 != 0) {
                            i32 = Integer.MAX_VALUE;
                        }
                        if ((i6 & Normalizer.INPUT_IS_FCD) != 0) {
                            yz2Var3 = (yz2) x20Var.j(a);
                            i35 &= -29360129;
                        } else {
                            yz2Var3 = yz2Var;
                        }
                        i40 = 1;
                    }
                    x20Var.q();
                    x20Var.W(-565217106);
                    if (j5 != 16) {
                        ek1Var4 = ek1Var4;
                        i40 = i40;
                        jB = j5;
                    } else {
                        x20Var.W(-565216333);
                        jB = yz2Var3.b();
                        if (jB != 16) {
                            jB = ((sz) x20Var.j(g50.a)).a;
                        }
                        x20Var.p(false);
                    }
                    x20Var.p(false);
                    int i49 = i35 << 6;
                    ek1 ek1Var7 = ek1Var4;
                    int i410 = i40;
                    ef4.a(str, ek1Var7, yz2.e(yz2Var3, jB, j10, np0Var2, ev2Var2, j11, vw2Var3 != null ? vw2Var3.a : 0, j12, 16609104), i39, z2, i32, i410, x20Var, (i21 & 126) | UCharacterProperty.SCRIPT_X_WITH_OTHER | (57344 & i49) | 196608 | (i49 & 3670016) | 12582912 | ((i21 << 18) & 1879048192), 256);
                    i38 = i39;
                    j6 = j5;
                    i36 = i410;
                    ek1Var3 = ek1Var7;
                    i37 = i32;
                    yz2Var2 = yz2Var3;
                    j7 = j10;
                    ev2Var3 = ev2Var2;
                    np0Var3 = np0Var2;
                    j9 = j12;
                    z4 = z2;
                    vw2Var2 = vw2Var3;
                    j8 = j11;
                } else {
                    x20Var.R();
                    i36 = i3;
                    yz2Var2 = yz2Var;
                    i37 = i32;
                    ek1Var3 = ek1Var2;
                    ev2Var3 = ev2Var2;
                    j6 = j5;
                    np0Var3 = np0Var2;
                    j7 = j2;
                    j8 = j3;
                    vw2Var2 = vw2Var;
                    j9 = j4;
                    i38 = i;
                    z4 = z;
                }
                a42VarR = x20Var.r();
                if (a42VarR != null) {
                    a42VarR.d = new vq0() { // from class: cz2
                        @Override // defpackage.vq0
                        public final Object e(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iC = ny3.c(i4 | 1);
                            int iC2 = ny3.c(i5);
                            dz2.b(str, ek1Var3, j6, j7, np0Var3, ev2Var3, j8, vw2Var2, j9, i38, z4, i37, i36, yz2Var2, (x20) obj, iC, iC2, i6);
                            return q43.a;
                        }
                    };
                }
            }
            i13 = i10 | 1769472;
            np0Var2 = np0Var;
            i16 = i6 & 128;
            i17 = 4194304;
            if (i16 != 0) {
                i13 |= 12582912;
                ev2Var2 = ev2Var;
            } else {
                ev2Var2 = ev2Var;
                if ((i4 & 12582912) == 0) {
                    if (x20Var.f(ev2Var2)) {
                        i18 = 8388608;
                    } else {
                        i18 = 4194304;
                    }
                    i13 |= i18;
                }
            }
            i19 = i6 & 256;
            if (i19 != 0) {
                i13 |= 100663296;
            } else if ((i4 & 100663296) == 0) {
                if (x20Var.e(j3)) {
                    i20 = 67108864;
                } else {
                    i20 = 33554432;
                }
                i13 |= i20;
            }
            i21 = i13 | 805306368;
            i22 = i6 & 1024;
            if (i22 != 0) {
                i24 = i5 | 6;
            } else {
                if (x20Var.f(vw2Var)) {
                    i23 = 4;
                } else {
                    i23 = 2;
                }
                i24 = i5 | i23;
            }
            i25 = i24;
            i26 = i25 | 48;
            i27 = i6 & 4096;
            if (i27 != 0) {
                i28 = i25 | 432;
            } else {
                if ((i5 & CollationFastLatin.LATIN_LIMIT) != 0) {
                    if (x20Var.d(i)) {
                        i29 = 256;
                    } else {
                        i29 = 128;
                    }
                    i26 |= i29;
                }
                i28 = i26;
            }
            i30 = i28 | UCharacterProperty.SCRIPT_X_WITH_OTHER;
            i31 = i6 & 16384;
            if (i31 != 0) {
                i33 = i28 | 27648;
                i32 = i2;
            } else if ((i5 & 24576) == 0) {
                i32 = i2;
                i33 = i30 | (x20Var.d(i32) ? 16384 : 8192);
            } else {
                i32 = i2;
                i33 = i30;
            }
            int i411 = i33 | 1769472;
            if ((i6 & Normalizer.INPUT_IS_FCD) == 0) {
                i34 = i31;
                if (x20Var.f(yz2Var)) {
                    i17 = 8388608;
                }
            } else {
                i34 = i31;
            }
            i35 = i411 | i17;
            z2 = true;
            if ((i21 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (x20Var.O(i21 & 1, z3)) {
                x20Var.T();
                if ((i4 & 1) != 0) {
                    if (i41 != 0) {
                        ek1Var4 = bk1.a;
                    } else {
                        ek1Var4 = ek1Var2;
                    }
                    if (i8 != 0) {
                        j5 = sz.g;
                    }
                    if (i11 != 0) {
                        j10 = b03.c;
                    } else {
                        j10 = j2;
                    }
                    if (i14 != 0) {
                        np0Var2 = null;
                    }
                    if (i16 != 0) {
                        ev2Var2 = null;
                    }
                    if (i19 != 0) {
                        j11 = b03.c;
                    } else {
                        j11 = j3;
                    }
                    if (i22 == 0) {
                    }
                    j12 = b03.c;
                    if (i27 != 0) {
                        i39 = 1;
                    } else {
                        i39 = i;
                    }
                    if (i34 != 0) {
                        i32 = Integer.MAX_VALUE;
                    }
                    if ((i6 & Normalizer.INPUT_IS_FCD) != 0) {
                        yz2Var3 = (yz2) x20Var.j(a);
                        i35 &= -29360129;
                    } else {
                        yz2Var3 = yz2Var;
                    }
                    i40 = 1;
                } else {
                    if (i41 != 0) {
                        ek1Var4 = bk1.a;
                    } else {
                        ek1Var4 = ek1Var2;
                    }
                    if (i8 != 0) {
                        j5 = sz.g;
                    }
                    if (i11 != 0) {
                        j10 = b03.c;
                    } else {
                        j10 = j2;
                    }
                    if (i14 != 0) {
                        np0Var2 = null;
                    }
                    if (i16 != 0) {
                        ev2Var2 = null;
                    }
                    if (i19 != 0) {
                        j11 = b03.c;
                    } else {
                        j11 = j3;
                    }
                    if (i22 == 0) {
                    }
                    j12 = b03.c;
                    if (i27 != 0) {
                        i39 = 1;
                    } else {
                        i39 = i;
                    }
                    if (i34 != 0) {
                        i32 = Integer.MAX_VALUE;
                    }
                    if ((i6 & Normalizer.INPUT_IS_FCD) != 0) {
                        yz2Var3 = (yz2) x20Var.j(a);
                        i35 &= -29360129;
                    } else {
                        yz2Var3 = yz2Var;
                    }
                    i40 = 1;
                }
                x20Var.q();
                x20Var.W(-565217106);
                if (j5 != 16) {
                    ek1Var4 = ek1Var4;
                    i40 = i40;
                    jB = j5;
                } else {
                    x20Var.W(-565216333);
                    jB = yz2Var3.b();
                    if (jB != 16) {
                        jB = ((sz) x20Var.j(g50.a)).a;
                    }
                    x20Var.p(false);
                }
                x20Var.p(false);
                int i412 = i35 << 6;
                ek1 ek1Var8 = ek1Var4;
                int i413 = i40;
                ef4.a(str, ek1Var8, yz2.e(yz2Var3, jB, j10, np0Var2, ev2Var2, j11, vw2Var3 != null ? vw2Var3.a : 0, j12, 16609104), i39, z2, i32, i413, x20Var, (i21 & 126) | UCharacterProperty.SCRIPT_X_WITH_OTHER | (57344 & i412) | 196608 | (i412 & 3670016) | 12582912 | ((i21 << 18) & 1879048192), 256);
                i38 = i39;
                j6 = j5;
                i36 = i413;
                ek1Var3 = ek1Var8;
                i37 = i32;
                yz2Var2 = yz2Var3;
                j7 = j10;
                ev2Var3 = ev2Var2;
                np0Var3 = np0Var2;
                j9 = j12;
                z4 = z2;
                vw2Var2 = vw2Var3;
                j8 = j11;
            } else {
                x20Var.R();
                i36 = i3;
                yz2Var2 = yz2Var;
                i37 = i32;
                ek1Var3 = ek1Var2;
                ev2Var3 = ev2Var2;
                j6 = j5;
                np0Var3 = np0Var2;
                j7 = j2;
                j8 = j3;
                vw2Var2 = vw2Var;
                j9 = j4;
                i38 = i;
                z4 = z;
            }
            a42VarR = x20Var.r();
            if (a42VarR != null) {
                a42VarR.d = new vq0() { // from class: cz2
                    @Override // defpackage.vq0
                    public final Object e(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iC = ny3.c(i4 | 1);
                        int iC2 = ny3.c(i5);
                        dz2.b(str, ek1Var3, j6, j7, np0Var3, ev2Var3, j8, vw2Var2, j9, i38, z4, i37, i36, yz2Var2, (x20) obj, iC, iC2, i6);
                        return q43.a;
                    }
                };
            }
        }
        i7 |= 48;
        ek1Var2 = ek1Var;
        i8 = i6 & 4;
        if (i8 != 0) {
            if ((i4 & CollationFastLatin.LATIN_LIMIT) == 0) {
                j5 = j;
                if (x20Var.e(j5)) {
                    i9 = 256;
                } else {
                    i9 = 128;
                }
                i7 |= i9;
            }
            i10 = i7 | UCharacterProperty.SCRIPT_X_WITH_OTHER;
            i11 = i6 & 16;
            if (i11 != 0) {
                i10 = i7 | 27648;
            } else if ((i4 & 24576) == 0) {
                if (x20Var.e(j2)) {
                    i12 = 16384;
                } else {
                    i12 = 8192;
                }
                i10 |= i12;
            }
            i13 = i10 | 196608;
            i14 = i6 & 64;
            if (i14 != 0) {
                if ((1572864 & i4) == 0) {
                    np0Var2 = np0Var;
                    if (x20Var.f(np0Var2)) {
                        i15 = 1048576;
                    } else {
                        i15 = ArabicShaping.TASHKEEL_RESIZE;
                    }
                    i13 |= i15;
                }
                i16 = i6 & 128;
                i17 = 4194304;
                if (i16 != 0) {
                    i13 |= 12582912;
                    ev2Var2 = ev2Var;
                } else {
                    ev2Var2 = ev2Var;
                    if ((i4 & 12582912) == 0) {
                        if (x20Var.f(ev2Var2)) {
                            i18 = 8388608;
                        } else {
                            i18 = 4194304;
                        }
                        i13 |= i18;
                    }
                }
                i19 = i6 & 256;
                if (i19 != 0) {
                    i13 |= 100663296;
                } else if ((i4 & 100663296) == 0) {
                    if (x20Var.e(j3)) {
                        i20 = 67108864;
                    } else {
                        i20 = 33554432;
                    }
                    i13 |= i20;
                }
                i21 = i13 | 805306368;
                i22 = i6 & 1024;
                if (i22 != 0) {
                    i24 = i5 | 6;
                } else {
                    if (x20Var.f(vw2Var)) {
                        i23 = 4;
                    } else {
                        i23 = 2;
                    }
                    i24 = i5 | i23;
                }
                i25 = i24;
                i26 = i25 | 48;
                i27 = i6 & 4096;
                if (i27 != 0) {
                    i28 = i25 | 432;
                } else {
                    if ((i5 & CollationFastLatin.LATIN_LIMIT) != 0) {
                        if (x20Var.d(i)) {
                            i29 = 256;
                        } else {
                            i29 = 128;
                        }
                        i26 |= i29;
                    }
                    i28 = i26;
                }
                i30 = i28 | UCharacterProperty.SCRIPT_X_WITH_OTHER;
                i31 = i6 & 16384;
                if (i31 != 0) {
                    i33 = i28 | 27648;
                    i32 = i2;
                } else if ((i5 & 24576) == 0) {
                    i32 = i2;
                    i33 = i30 | (x20Var.d(i32) ? 16384 : 8192);
                } else {
                    i32 = i2;
                    i33 = i30;
                }
                int i414 = i33 | 1769472;
                if ((i6 & Normalizer.INPUT_IS_FCD) == 0) {
                    i34 = i31;
                    if (x20Var.f(yz2Var)) {
                        i17 = 8388608;
                    }
                } else {
                    i34 = i31;
                }
                i35 = i414 | i17;
                z2 = true;
                if ((i21 & 306783379) == 306783378) {
                    z3 = true;
                } else {
                    z3 = true;
                }
                if (x20Var.O(i21 & 1, z3)) {
                    x20Var.T();
                    if ((i4 & 1) != 0) {
                        if (i41 != 0) {
                            ek1Var4 = bk1.a;
                        } else {
                            ek1Var4 = ek1Var2;
                        }
                        if (i8 != 0) {
                            j5 = sz.g;
                        }
                        if (i11 != 0) {
                            j10 = b03.c;
                        } else {
                            j10 = j2;
                        }
                        if (i14 != 0) {
                            np0Var2 = null;
                        }
                        if (i16 != 0) {
                            ev2Var2 = null;
                        }
                        if (i19 != 0) {
                            j11 = b03.c;
                        } else {
                            j11 = j3;
                        }
                        if (i22 == 0) {
                        }
                        j12 = b03.c;
                        if (i27 != 0) {
                            i39 = 1;
                        } else {
                            i39 = i;
                        }
                        if (i34 != 0) {
                            i32 = Integer.MAX_VALUE;
                        }
                        if ((i6 & Normalizer.INPUT_IS_FCD) != 0) {
                            yz2Var3 = (yz2) x20Var.j(a);
                            i35 &= -29360129;
                        } else {
                            yz2Var3 = yz2Var;
                        }
                        i40 = 1;
                    } else {
                        if (i41 != 0) {
                            ek1Var4 = bk1.a;
                        } else {
                            ek1Var4 = ek1Var2;
                        }
                        if (i8 != 0) {
                            j5 = sz.g;
                        }
                        if (i11 != 0) {
                            j10 = b03.c;
                        } else {
                            j10 = j2;
                        }
                        if (i14 != 0) {
                            np0Var2 = null;
                        }
                        if (i16 != 0) {
                            ev2Var2 = null;
                        }
                        if (i19 != 0) {
                            j11 = b03.c;
                        } else {
                            j11 = j3;
                        }
                        if (i22 == 0) {
                        }
                        j12 = b03.c;
                        if (i27 != 0) {
                            i39 = 1;
                        } else {
                            i39 = i;
                        }
                        if (i34 != 0) {
                            i32 = Integer.MAX_VALUE;
                        }
                        if ((i6 & Normalizer.INPUT_IS_FCD) != 0) {
                            yz2Var3 = (yz2) x20Var.j(a);
                            i35 &= -29360129;
                        } else {
                            yz2Var3 = yz2Var;
                        }
                        i40 = 1;
                    }
                    x20Var.q();
                    x20Var.W(-565217106);
                    if (j5 != 16) {
                        ek1Var4 = ek1Var4;
                        i40 = i40;
                        jB = j5;
                    } else {
                        x20Var.W(-565216333);
                        jB = yz2Var3.b();
                        if (jB != 16) {
                            jB = ((sz) x20Var.j(g50.a)).a;
                        }
                        x20Var.p(false);
                    }
                    x20Var.p(false);
                    int i415 = i35 << 6;
                    ek1 ek1Var9 = ek1Var4;
                    int i416 = i40;
                    ef4.a(str, ek1Var9, yz2.e(yz2Var3, jB, j10, np0Var2, ev2Var2, j11, vw2Var3 != null ? vw2Var3.a : 0, j12, 16609104), i39, z2, i32, i416, x20Var, (i21 & 126) | UCharacterProperty.SCRIPT_X_WITH_OTHER | (57344 & i415) | 196608 | (i415 & 3670016) | 12582912 | ((i21 << 18) & 1879048192), 256);
                    i38 = i39;
                    j6 = j5;
                    i36 = i416;
                    ek1Var3 = ek1Var9;
                    i37 = i32;
                    yz2Var2 = yz2Var3;
                    j7 = j10;
                    ev2Var3 = ev2Var2;
                    np0Var3 = np0Var2;
                    j9 = j12;
                    z4 = z2;
                    vw2Var2 = vw2Var3;
                    j8 = j11;
                } else {
                    x20Var.R();
                    i36 = i3;
                    yz2Var2 = yz2Var;
                    i37 = i32;
                    ek1Var3 = ek1Var2;
                    ev2Var3 = ev2Var2;
                    j6 = j5;
                    np0Var3 = np0Var2;
                    j7 = j2;
                    j8 = j3;
                    vw2Var2 = vw2Var;
                    j9 = j4;
                    i38 = i;
                    z4 = z;
                }
                a42VarR = x20Var.r();
                if (a42VarR != null) {
                    a42VarR.d = new vq0() { // from class: cz2
                        @Override // defpackage.vq0
                        public final Object e(Object obj, Object obj2) {
                            ((Integer) obj2).getClass();
                            int iC = ny3.c(i4 | 1);
                            int iC2 = ny3.c(i5);
                            dz2.b(str, ek1Var3, j6, j7, np0Var3, ev2Var3, j8, vw2Var2, j9, i38, z4, i37, i36, yz2Var2, (x20) obj, iC, iC2, i6);
                            return q43.a;
                        }
                    };
                }
            }
            i13 = i10 | 1769472;
            np0Var2 = np0Var;
            i16 = i6 & 128;
            i17 = 4194304;
            if (i16 != 0) {
                i13 |= 12582912;
                ev2Var2 = ev2Var;
            } else {
                ev2Var2 = ev2Var;
                if ((i4 & 12582912) == 0) {
                    if (x20Var.f(ev2Var2)) {
                        i18 = 8388608;
                    } else {
                        i18 = 4194304;
                    }
                    i13 |= i18;
                }
            }
            i19 = i6 & 256;
            if (i19 != 0) {
                i13 |= 100663296;
            } else if ((i4 & 100663296) == 0) {
                if (x20Var.e(j3)) {
                    i20 = 67108864;
                } else {
                    i20 = 33554432;
                }
                i13 |= i20;
            }
            i21 = i13 | 805306368;
            i22 = i6 & 1024;
            if (i22 != 0) {
                i24 = i5 | 6;
            } else {
                if (x20Var.f(vw2Var)) {
                    i23 = 4;
                } else {
                    i23 = 2;
                }
                i24 = i5 | i23;
            }
            i25 = i24;
            i26 = i25 | 48;
            i27 = i6 & 4096;
            if (i27 != 0) {
                i28 = i25 | 432;
            } else {
                if ((i5 & CollationFastLatin.LATIN_LIMIT) != 0) {
                    if (x20Var.d(i)) {
                        i29 = 256;
                    } else {
                        i29 = 128;
                    }
                    i26 |= i29;
                }
                i28 = i26;
            }
            i30 = i28 | UCharacterProperty.SCRIPT_X_WITH_OTHER;
            i31 = i6 & 16384;
            if (i31 != 0) {
                i33 = i28 | 27648;
                i32 = i2;
            } else if ((i5 & 24576) == 0) {
                i32 = i2;
                i33 = i30 | (x20Var.d(i32) ? 16384 : 8192);
            } else {
                i32 = i2;
                i33 = i30;
            }
            int i417 = i33 | 1769472;
            if ((i6 & Normalizer.INPUT_IS_FCD) == 0) {
                i34 = i31;
                if (x20Var.f(yz2Var)) {
                    i17 = 8388608;
                }
            } else {
                i34 = i31;
            }
            i35 = i417 | i17;
            z2 = true;
            if ((i21 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (x20Var.O(i21 & 1, z3)) {
                x20Var.T();
                if ((i4 & 1) != 0) {
                    if (i41 != 0) {
                        ek1Var4 = bk1.a;
                    } else {
                        ek1Var4 = ek1Var2;
                    }
                    if (i8 != 0) {
                        j5 = sz.g;
                    }
                    if (i11 != 0) {
                        j10 = b03.c;
                    } else {
                        j10 = j2;
                    }
                    if (i14 != 0) {
                        np0Var2 = null;
                    }
                    if (i16 != 0) {
                        ev2Var2 = null;
                    }
                    if (i19 != 0) {
                        j11 = b03.c;
                    } else {
                        j11 = j3;
                    }
                    if (i22 == 0) {
                    }
                    j12 = b03.c;
                    if (i27 != 0) {
                        i39 = 1;
                    } else {
                        i39 = i;
                    }
                    if (i34 != 0) {
                        i32 = Integer.MAX_VALUE;
                    }
                    if ((i6 & Normalizer.INPUT_IS_FCD) != 0) {
                        yz2Var3 = (yz2) x20Var.j(a);
                        i35 &= -29360129;
                    } else {
                        yz2Var3 = yz2Var;
                    }
                    i40 = 1;
                } else {
                    if (i41 != 0) {
                        ek1Var4 = bk1.a;
                    } else {
                        ek1Var4 = ek1Var2;
                    }
                    if (i8 != 0) {
                        j5 = sz.g;
                    }
                    if (i11 != 0) {
                        j10 = b03.c;
                    } else {
                        j10 = j2;
                    }
                    if (i14 != 0) {
                        np0Var2 = null;
                    }
                    if (i16 != 0) {
                        ev2Var2 = null;
                    }
                    if (i19 != 0) {
                        j11 = b03.c;
                    } else {
                        j11 = j3;
                    }
                    if (i22 == 0) {
                    }
                    j12 = b03.c;
                    if (i27 != 0) {
                        i39 = 1;
                    } else {
                        i39 = i;
                    }
                    if (i34 != 0) {
                        i32 = Integer.MAX_VALUE;
                    }
                    if ((i6 & Normalizer.INPUT_IS_FCD) != 0) {
                        yz2Var3 = (yz2) x20Var.j(a);
                        i35 &= -29360129;
                    } else {
                        yz2Var3 = yz2Var;
                    }
                    i40 = 1;
                }
                x20Var.q();
                x20Var.W(-565217106);
                if (j5 != 16) {
                    ek1Var4 = ek1Var4;
                    i40 = i40;
                    jB = j5;
                } else {
                    x20Var.W(-565216333);
                    jB = yz2Var3.b();
                    if (jB != 16) {
                        jB = ((sz) x20Var.j(g50.a)).a;
                    }
                    x20Var.p(false);
                }
                x20Var.p(false);
                int i418 = i35 << 6;
                ek1 ek1Var10 = ek1Var4;
                int i419 = i40;
                ef4.a(str, ek1Var10, yz2.e(yz2Var3, jB, j10, np0Var2, ev2Var2, j11, vw2Var3 != null ? vw2Var3.a : 0, j12, 16609104), i39, z2, i32, i419, x20Var, (i21 & 126) | UCharacterProperty.SCRIPT_X_WITH_OTHER | (57344 & i418) | 196608 | (i418 & 3670016) | 12582912 | ((i21 << 18) & 1879048192), 256);
                i38 = i39;
                j6 = j5;
                i36 = i419;
                ek1Var3 = ek1Var10;
                i37 = i32;
                yz2Var2 = yz2Var3;
                j7 = j10;
                ev2Var3 = ev2Var2;
                np0Var3 = np0Var2;
                j9 = j12;
                z4 = z2;
                vw2Var2 = vw2Var3;
                j8 = j11;
            } else {
                x20Var.R();
                i36 = i3;
                yz2Var2 = yz2Var;
                i37 = i32;
                ek1Var3 = ek1Var2;
                ev2Var3 = ev2Var2;
                j6 = j5;
                np0Var3 = np0Var2;
                j7 = j2;
                j8 = j3;
                vw2Var2 = vw2Var;
                j9 = j4;
                i38 = i;
                z4 = z;
            }
            a42VarR = x20Var.r();
            if (a42VarR != null) {
                a42VarR.d = new vq0() { // from class: cz2
                    @Override // defpackage.vq0
                    public final Object e(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iC = ny3.c(i4 | 1);
                        int iC2 = ny3.c(i5);
                        dz2.b(str, ek1Var3, j6, j7, np0Var3, ev2Var3, j8, vw2Var2, j9, i38, z4, i37, i36, yz2Var2, (x20) obj, iC, iC2, i6);
                        return q43.a;
                    }
                };
            }
        }
        i7 |= CollationFastLatin.LATIN_LIMIT;
        j5 = j;
        i10 = i7 | UCharacterProperty.SCRIPT_X_WITH_OTHER;
        i11 = i6 & 16;
        if (i11 != 0) {
            i10 = i7 | 27648;
        } else if ((i4 & 24576) == 0) {
            if (x20Var.e(j2)) {
                i12 = 16384;
            } else {
                i12 = 8192;
            }
            i10 |= i12;
        }
        i13 = i10 | 196608;
        i14 = i6 & 64;
        if (i14 != 0) {
            if ((1572864 & i4) == 0) {
                np0Var2 = np0Var;
                if (x20Var.f(np0Var2)) {
                    i15 = 1048576;
                } else {
                    i15 = ArabicShaping.TASHKEEL_RESIZE;
                }
                i13 |= i15;
            }
            i16 = i6 & 128;
            i17 = 4194304;
            if (i16 != 0) {
                i13 |= 12582912;
                ev2Var2 = ev2Var;
            } else {
                ev2Var2 = ev2Var;
                if ((i4 & 12582912) == 0) {
                    if (x20Var.f(ev2Var2)) {
                        i18 = 8388608;
                    } else {
                        i18 = 4194304;
                    }
                    i13 |= i18;
                }
            }
            i19 = i6 & 256;
            if (i19 != 0) {
                i13 |= 100663296;
            } else if ((i4 & 100663296) == 0) {
                if (x20Var.e(j3)) {
                    i20 = 67108864;
                } else {
                    i20 = 33554432;
                }
                i13 |= i20;
            }
            i21 = i13 | 805306368;
            i22 = i6 & 1024;
            if (i22 != 0) {
                i24 = i5 | 6;
            } else {
                if (x20Var.f(vw2Var)) {
                    i23 = 4;
                } else {
                    i23 = 2;
                }
                i24 = i5 | i23;
            }
            i25 = i24;
            i26 = i25 | 48;
            i27 = i6 & 4096;
            if (i27 != 0) {
                i28 = i25 | 432;
            } else {
                if ((i5 & CollationFastLatin.LATIN_LIMIT) != 0) {
                    if (x20Var.d(i)) {
                        i29 = 256;
                    } else {
                        i29 = 128;
                    }
                    i26 |= i29;
                }
                i28 = i26;
            }
            i30 = i28 | UCharacterProperty.SCRIPT_X_WITH_OTHER;
            i31 = i6 & 16384;
            if (i31 != 0) {
                i33 = i28 | 27648;
                i32 = i2;
            } else if ((i5 & 24576) == 0) {
                i32 = i2;
                i33 = i30 | (x20Var.d(i32) ? 16384 : 8192);
            } else {
                i32 = i2;
                i33 = i30;
            }
            int i4110 = i33 | 1769472;
            if ((i6 & Normalizer.INPUT_IS_FCD) == 0) {
                i34 = i31;
                if (x20Var.f(yz2Var)) {
                    i17 = 8388608;
                }
            } else {
                i34 = i31;
            }
            i35 = i4110 | i17;
            z2 = true;
            if ((i21 & 306783379) == 306783378) {
                z3 = true;
            } else {
                z3 = true;
            }
            if (x20Var.O(i21 & 1, z3)) {
                x20Var.T();
                if ((i4 & 1) != 0) {
                    if (i41 != 0) {
                        ek1Var4 = bk1.a;
                    } else {
                        ek1Var4 = ek1Var2;
                    }
                    if (i8 != 0) {
                        j5 = sz.g;
                    }
                    if (i11 != 0) {
                        j10 = b03.c;
                    } else {
                        j10 = j2;
                    }
                    if (i14 != 0) {
                        np0Var2 = null;
                    }
                    if (i16 != 0) {
                        ev2Var2 = null;
                    }
                    if (i19 != 0) {
                        j11 = b03.c;
                    } else {
                        j11 = j3;
                    }
                    if (i22 == 0) {
                    }
                    j12 = b03.c;
                    if (i27 != 0) {
                        i39 = 1;
                    } else {
                        i39 = i;
                    }
                    if (i34 != 0) {
                        i32 = Integer.MAX_VALUE;
                    }
                    if ((i6 & Normalizer.INPUT_IS_FCD) != 0) {
                        yz2Var3 = (yz2) x20Var.j(a);
                        i35 &= -29360129;
                    } else {
                        yz2Var3 = yz2Var;
                    }
                    i40 = 1;
                } else {
                    if (i41 != 0) {
                        ek1Var4 = bk1.a;
                    } else {
                        ek1Var4 = ek1Var2;
                    }
                    if (i8 != 0) {
                        j5 = sz.g;
                    }
                    if (i11 != 0) {
                        j10 = b03.c;
                    } else {
                        j10 = j2;
                    }
                    if (i14 != 0) {
                        np0Var2 = null;
                    }
                    if (i16 != 0) {
                        ev2Var2 = null;
                    }
                    if (i19 != 0) {
                        j11 = b03.c;
                    } else {
                        j11 = j3;
                    }
                    if (i22 == 0) {
                    }
                    j12 = b03.c;
                    if (i27 != 0) {
                        i39 = 1;
                    } else {
                        i39 = i;
                    }
                    if (i34 != 0) {
                        i32 = Integer.MAX_VALUE;
                    }
                    if ((i6 & Normalizer.INPUT_IS_FCD) != 0) {
                        yz2Var3 = (yz2) x20Var.j(a);
                        i35 &= -29360129;
                    } else {
                        yz2Var3 = yz2Var;
                    }
                    i40 = 1;
                }
                x20Var.q();
                x20Var.W(-565217106);
                if (j5 != 16) {
                    ek1Var4 = ek1Var4;
                    i40 = i40;
                    jB = j5;
                } else {
                    x20Var.W(-565216333);
                    jB = yz2Var3.b();
                    if (jB != 16) {
                        jB = ((sz) x20Var.j(g50.a)).a;
                    }
                    x20Var.p(false);
                }
                x20Var.p(false);
                int i4111 = i35 << 6;
                ek1 ek1Var11 = ek1Var4;
                int i4112 = i40;
                ef4.a(str, ek1Var11, yz2.e(yz2Var3, jB, j10, np0Var2, ev2Var2, j11, vw2Var3 != null ? vw2Var3.a : 0, j12, 16609104), i39, z2, i32, i4112, x20Var, (i21 & 126) | UCharacterProperty.SCRIPT_X_WITH_OTHER | (57344 & i4111) | 196608 | (i4111 & 3670016) | 12582912 | ((i21 << 18) & 1879048192), 256);
                i38 = i39;
                j6 = j5;
                i36 = i4112;
                ek1Var3 = ek1Var11;
                i37 = i32;
                yz2Var2 = yz2Var3;
                j7 = j10;
                ev2Var3 = ev2Var2;
                np0Var3 = np0Var2;
                j9 = j12;
                z4 = z2;
                vw2Var2 = vw2Var3;
                j8 = j11;
            } else {
                x20Var.R();
                i36 = i3;
                yz2Var2 = yz2Var;
                i37 = i32;
                ek1Var3 = ek1Var2;
                ev2Var3 = ev2Var2;
                j6 = j5;
                np0Var3 = np0Var2;
                j7 = j2;
                j8 = j3;
                vw2Var2 = vw2Var;
                j9 = j4;
                i38 = i;
                z4 = z;
            }
            a42VarR = x20Var.r();
            if (a42VarR != null) {
                a42VarR.d = new vq0() { // from class: cz2
                    @Override // defpackage.vq0
                    public final Object e(Object obj, Object obj2) {
                        ((Integer) obj2).getClass();
                        int iC = ny3.c(i4 | 1);
                        int iC2 = ny3.c(i5);
                        dz2.b(str, ek1Var3, j6, j7, np0Var3, ev2Var3, j8, vw2Var2, j9, i38, z4, i37, i36, yz2Var2, (x20) obj, iC, iC2, i6);
                        return q43.a;
                    }
                };
            }
        }
        i13 = i10 | 1769472;
        np0Var2 = np0Var;
        i16 = i6 & 128;
        i17 = 4194304;
        if (i16 != 0) {
            i13 |= 12582912;
            ev2Var2 = ev2Var;
        } else {
            ev2Var2 = ev2Var;
            if ((i4 & 12582912) == 0) {
                if (x20Var.f(ev2Var2)) {
                    i18 = 8388608;
                } else {
                    i18 = 4194304;
                }
                i13 |= i18;
            }
        }
        i19 = i6 & 256;
        if (i19 != 0) {
            i13 |= 100663296;
        } else if ((i4 & 100663296) == 0) {
            if (x20Var.e(j3)) {
                i20 = 67108864;
            } else {
                i20 = 33554432;
            }
            i13 |= i20;
        }
        i21 = i13 | 805306368;
        i22 = i6 & 1024;
        if (i22 != 0) {
            i24 = i5 | 6;
        } else {
            if (x20Var.f(vw2Var)) {
                i23 = 4;
            } else {
                i23 = 2;
            }
            i24 = i5 | i23;
        }
        i25 = i24;
        i26 = i25 | 48;
        i27 = i6 & 4096;
        if (i27 != 0) {
            i28 = i25 | 432;
        } else {
            if ((i5 & CollationFastLatin.LATIN_LIMIT) != 0) {
                if (x20Var.d(i)) {
                    i29 = 256;
                } else {
                    i29 = 128;
                }
                i26 |= i29;
            }
            i28 = i26;
        }
        i30 = i28 | UCharacterProperty.SCRIPT_X_WITH_OTHER;
        i31 = i6 & 16384;
        if (i31 != 0) {
            i33 = i28 | 27648;
            i32 = i2;
        } else if ((i5 & 24576) == 0) {
            i32 = i2;
            i33 = i30 | (x20Var.d(i32) ? 16384 : 8192);
        } else {
            i32 = i2;
            i33 = i30;
        }
        int i4113 = i33 | 1769472;
        if ((i6 & Normalizer.INPUT_IS_FCD) == 0) {
            i34 = i31;
            if (x20Var.f(yz2Var)) {
                i17 = 8388608;
            }
        } else {
            i34 = i31;
        }
        i35 = i4113 | i17;
        z2 = true;
        if ((i21 & 306783379) == 306783378) {
            z3 = true;
        } else {
            z3 = true;
        }
        if (x20Var.O(i21 & 1, z3)) {
            x20Var.T();
            if ((i4 & 1) != 0) {
                if (i41 != 0) {
                    ek1Var4 = bk1.a;
                } else {
                    ek1Var4 = ek1Var2;
                }
                if (i8 != 0) {
                    j5 = sz.g;
                }
                if (i11 != 0) {
                    j10 = b03.c;
                } else {
                    j10 = j2;
                }
                if (i14 != 0) {
                    np0Var2 = null;
                }
                if (i16 != 0) {
                    ev2Var2 = null;
                }
                if (i19 != 0) {
                    j11 = b03.c;
                } else {
                    j11 = j3;
                }
                if (i22 == 0) {
                }
                j12 = b03.c;
                if (i27 != 0) {
                    i39 = 1;
                } else {
                    i39 = i;
                }
                if (i34 != 0) {
                    i32 = Integer.MAX_VALUE;
                }
                if ((i6 & Normalizer.INPUT_IS_FCD) != 0) {
                    yz2Var3 = (yz2) x20Var.j(a);
                    i35 &= -29360129;
                } else {
                    yz2Var3 = yz2Var;
                }
                i40 = 1;
            } else {
                if (i41 != 0) {
                    ek1Var4 = bk1.a;
                } else {
                    ek1Var4 = ek1Var2;
                }
                if (i8 != 0) {
                    j5 = sz.g;
                }
                if (i11 != 0) {
                    j10 = b03.c;
                } else {
                    j10 = j2;
                }
                if (i14 != 0) {
                    np0Var2 = null;
                }
                if (i16 != 0) {
                    ev2Var2 = null;
                }
                if (i19 != 0) {
                    j11 = b03.c;
                } else {
                    j11 = j3;
                }
                if (i22 == 0) {
                }
                j12 = b03.c;
                if (i27 != 0) {
                    i39 = 1;
                } else {
                    i39 = i;
                }
                if (i34 != 0) {
                    i32 = Integer.MAX_VALUE;
                }
                if ((i6 & Normalizer.INPUT_IS_FCD) != 0) {
                    yz2Var3 = (yz2) x20Var.j(a);
                    i35 &= -29360129;
                } else {
                    yz2Var3 = yz2Var;
                }
                i40 = 1;
            }
            x20Var.q();
            x20Var.W(-565217106);
            if (j5 != 16) {
                ek1Var4 = ek1Var4;
                i40 = i40;
                jB = j5;
            } else {
                x20Var.W(-565216333);
                jB = yz2Var3.b();
                if (jB != 16) {
                    jB = ((sz) x20Var.j(g50.a)).a;
                }
                x20Var.p(false);
            }
            x20Var.p(false);
            int i4114 = i35 << 6;
            ek1 ek1Var12 = ek1Var4;
            int i4115 = i40;
            ef4.a(str, ek1Var12, yz2.e(yz2Var3, jB, j10, np0Var2, ev2Var2, j11, vw2Var3 != null ? vw2Var3.a : 0, j12, 16609104), i39, z2, i32, i4115, x20Var, (i21 & 126) | UCharacterProperty.SCRIPT_X_WITH_OTHER | (57344 & i4114) | 196608 | (i4114 & 3670016) | 12582912 | ((i21 << 18) & 1879048192), 256);
            i38 = i39;
            j6 = j5;
            i36 = i4115;
            ek1Var3 = ek1Var12;
            i37 = i32;
            yz2Var2 = yz2Var3;
            j7 = j10;
            ev2Var3 = ev2Var2;
            np0Var3 = np0Var2;
            j9 = j12;
            z4 = z2;
            vw2Var2 = vw2Var3;
            j8 = j11;
        } else {
            x20Var.R();
            i36 = i3;
            yz2Var2 = yz2Var;
            i37 = i32;
            ek1Var3 = ek1Var2;
            ev2Var3 = ev2Var2;
            j6 = j5;
            np0Var3 = np0Var2;
            j7 = j2;
            j8 = j3;
            vw2Var2 = vw2Var;
            j9 = j4;
            i38 = i;
            z4 = z;
        }
        a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new vq0() { // from class: cz2
                @Override // defpackage.vq0
                public final Object e(Object obj, Object obj2) {
                    ((Integer) obj2).getClass();
                    int iC = ny3.c(i4 | 1);
                    int iC2 = ny3.c(i5);
                    dz2.b(str, ek1Var3, j6, j7, np0Var3, ev2Var3, j8, vw2Var2, j9, i38, z4, i37, i36, yz2Var2, (x20) obj, iC, iC2, i6);
                    return q43.a;
                }
            };
        }
    }
}
