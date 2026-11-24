package defpackage;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.text.Normalizer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class f31 {
    public static final void a(j23 j23Var, hq0 hq0Var, ek1 ek1Var, cj0 cj0Var, mk0 mk0Var, vq0 vq0Var, w10 w10Var, x20 x20Var, int i) {
        int i2;
        f23 f23Var;
        boolean z;
        f23 f23Var2;
        f23 f23VarA;
        ku1 ku1Var = j23Var.d;
        x20Var.X(1912839215);
        if ((i & 6) == 0) {
            i2 = (x20Var.f(j23Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.h(hq0Var) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var.f(ek1Var) ? 256 : 128;
        }
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i2 |= x20Var.f(cj0Var) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= x20Var.f(mk0Var) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= x20Var.h(vq0Var) ? Normalizer.INPUT_IS_FCD : 65536;
        }
        int i3 = i2 | 1572864;
        if ((12582912 & i) == 0) {
            i3 |= x20Var.h(w10Var) ? 8388608 : 4194304;
        }
        if (!x20Var.O(i3 & 1, (4793491 & i3) != 4793490)) {
            x20Var.R();
        } else if (((Boolean) hq0Var.j(ku1Var.getValue())).booleanValue() || ((Boolean) hq0Var.j(j23Var.c())).booleanValue() || j23Var.g() || j23Var.d()) {
            x20Var.W(-232413539);
            int i4 = i3 & 14;
            int i5 = i4 | 48;
            int i6 = i5 & 14;
            boolean z2 = ((i6 ^ 6) > 4 && x20Var.f(j23Var)) || (i5 & 6) == 4;
            Object objL = x20Var.L();
            Object obj = r20.a;
            if (z2 || objL == obj) {
                objL = j23Var.c();
                x20Var.g0(objL);
            }
            if (j23Var.g()) {
                objL = j23Var.c();
            }
            x20Var.W(1844425648);
            si0 si0VarE = e(j23Var, hq0Var, objL, x20Var);
            x20Var.p(false);
            Object value = ku1Var.getValue();
            x20Var.W(1844425648);
            si0 si0VarE2 = e(j23Var, hq0Var, value, x20Var);
            x20Var.p(false);
            int i7 = i6 | UCharacterProperty.SCRIPT_X_WITH_OTHER;
            int i8 = l23.a;
            int i9 = (i7 & 14) ^ 6;
            boolean z3 = (i9 > 4 && x20Var.f(j23Var)) || (i7 & 6) == 4;
            Object objL2 = x20Var.L();
            if (z3 || objL2 == obj) {
                objL2 = new j23(new q91(9, si0VarE), j23Var, j23Var.c.concat(" > EnterExitTransition"));
                x20Var.g0(objL2);
            }
            j23 j23Var2 = (j23) objL2;
            boolean zF = ((i9 > 4 && x20Var.f(j23Var)) || (i7 & 6) == 4) | x20Var.f(j23Var2);
            Object objL3 = x20Var.L();
            if (zF || objL3 == obj) {
                objL3 = new o0(21, j23Var, j23Var2);
                x20Var.g0(objL3);
            }
            bz3.a(j23Var2, (hq0) objL3, x20Var);
            if (j23Var.g()) {
                j23Var2.j(si0VarE, si0VarE2);
            } else {
                j23Var2.k(si0VarE2);
                j23Var2.k.setValue(Boolean.FALSE);
            }
            Object objH = o44.h(vq0Var, x20Var);
            Object objC = j23Var2.c();
            ku1 ku1Var2 = j23Var2.d;
            Object objE = vq0Var.e(objC, ku1Var2.getValue());
            boolean zF2 = x20Var.f(j23Var2) | x20Var.f(objH);
            Object objL4 = x20Var.L();
            x50 x50Var = null;
            if (zF2 || objL4 == obj) {
                objL4 = new r0(j23Var2, objH, x50Var, 1);
                x20Var.g0(objL4);
            }
            vq0 vq0Var2 = (vq0) objL4;
            Object objL5 = x20Var.L();
            if (objL5 == obj) {
                objL5 = o44.g(objE);
                x20Var.g0(objL5);
            }
            mm1 mm1Var = (mm1) objL5;
            boolean zH = x20Var.h(vq0Var2);
            Object objL6 = x20Var.L();
            if (zH || objL6 == obj) {
                objL6 = new qm2(vq0Var2, mm1Var, x50Var, 0);
                x20Var.g0(objL6);
            }
            bz3.c(x20Var, (vq0) objL6, q43.a);
            Object objC2 = j23Var2.c();
            si0 si0Var = si0.c;
            if (objC2 == si0Var && ku1Var2.getValue() == si0Var && ((Boolean) mm1Var.getValue()).booleanValue()) {
                x20Var.W(-272333293);
            } else {
                x20Var.W(-231383533);
                boolean z4 = i4 == 4;
                Object objL7 = x20Var.L();
                if (z4 || objL7 == obj) {
                    objL7 = new ld();
                    x20Var.g0(objL7);
                }
                ld ldVar = (ld) objL7;
                vq2 vq2Var = yi0.a;
                Object objL8 = x20Var.L();
                if (objL8 == obj) {
                    objL8 = k30.i;
                    x20Var.g0(objL8);
                }
                fq0 fq0Var = (fq0) objL8;
                boolean zF3 = x20Var.f(j23Var2);
                Object objL9 = x20Var.L();
                if (zF3 || objL9 == obj) {
                    objL9 = o44.g(cj0Var);
                    x20Var.g0(objL9);
                }
                mm1 mm1Var2 = (mm1) objL9;
                Object objC3 = j23Var2.c();
                Object value2 = ku1Var2.getValue();
                si0 si0Var2 = si0.b;
                if (objC3 == value2 && j23Var2.c() == si0Var2) {
                    if (j23Var2.g()) {
                        mm1Var2.setValue(cj0Var);
                    } else {
                        mm1Var2.setValue(cj0.b);
                    }
                } else if (ku1Var2.getValue() == si0Var2) {
                    mm1Var2.setValue(((cj0) mm1Var2.getValue()).a(cj0Var));
                }
                cj0 cj0Var2 = (cj0) mm1Var2.getValue();
                boolean zF4 = x20Var.f(j23Var2);
                Object objL10 = x20Var.L();
                if (zF4 || objL10 == obj) {
                    objL10 = o44.g(mk0Var);
                    x20Var.g0(objL10);
                }
                mm1 mm1Var3 = (mm1) objL10;
                if (j23Var2.c() == ku1Var2.getValue() && j23Var2.c() == si0Var2) {
                    if (j23Var2.g()) {
                        mm1Var3.setValue(mk0Var);
                    } else {
                        mm1Var3.setValue(mk0.b);
                    }
                } else if (ku1Var2.getValue() != si0Var2) {
                    mm1Var3.setValue(((mk0) mm1Var3.getValue()).a(mk0Var));
                }
                mk0 mk0Var2 = (mk0) mm1Var3.getValue();
                k23 k23Var = cj0Var2.a;
                k23 k23Var2 = mk0Var2.a;
                boolean z5 = (k23Var.b == null && k23Var2.b == null) ? false : true;
                x20Var.W(133898448);
                x20Var.p(false);
                if (z5) {
                    x20Var.W(133990239);
                    Object objL11 = x20Var.L();
                    if (objL11 == obj) {
                        objL11 = "Built-in shrink/expand";
                        x20Var.g0("Built-in shrink/expand");
                    }
                    f23 f23VarA2 = l23.a(j23Var2, eb4.h, (String) objL11, x20Var);
                    x20Var.p(false);
                    f23Var = f23VarA2;
                } else {
                    x20Var.W(134101063);
                    x20Var.p(false);
                    f23Var = null;
                }
                if (z5) {
                    x20Var.W(134174689);
                    Object objL12 = x20Var.L();
                    if (objL12 == obj) {
                        objL12 = "Built-in InterruptionHandlingOffset";
                        x20Var.g0("Built-in InterruptionHandlingOffset");
                    }
                    f23 f23VarA3 = l23.a(j23Var2, eb4.g, (String) objL12, x20Var);
                    z = false;
                    x20Var.p(false);
                    f23Var2 = f23VarA3;
                } else {
                    z = false;
                    x20Var.W(134345095);
                    x20Var.p(false);
                    f23Var2 = null;
                }
                boolean z6 = !z5;
                float[] fArr = d00.a;
                x20Var.W(135150476);
                x20Var.p(z);
                if (k23Var.a == null && k23Var2.a == null) {
                    x20Var.W(-703709976);
                    x20Var.p(z);
                    f23VarA = null;
                } else {
                    x20Var.W(-703879421);
                    Object objL13 = x20Var.L();
                    if (objL13 == obj) {
                        objL13 = "Built-in alpha";
                        x20Var.g0("Built-in alpha");
                    }
                    f23VarA = l23.a(j23Var2, eb4.a, (String) objL13, x20Var);
                    z = false;
                    x20Var.p(false);
                }
                x20Var.W(-703472888);
                x20Var.p(z);
                x20Var.W(-703222904);
                x20Var.p(z);
                boolean zH2 = x20Var.h(f23VarA) | x20Var.f(cj0Var2) | x20Var.f(mk0Var2) | x20Var.h(null) | x20Var.f(j23Var2) | x20Var.h(null);
                Object objL14 = x20Var.L();
                if (zH2 || objL14 == obj) {
                    objL14 = new ui0(f23VarA, j23Var2, cj0Var2, mk0Var2);
                    x20Var.g0(objL14);
                }
                ui0 ui0Var = (ui0) objL14;
                boolean zG = x20Var.g(z6) | x20Var.f(fq0Var);
                Object objL15 = x20Var.L();
                if (zG || objL15 == obj) {
                    objL15 = new wi0(z6, fq0Var);
                    x20Var.g0(objL15);
                }
                ek1 ek1VarC = new ol((hq0) objL15).c(new ti0(j23Var2, f23Var, f23Var2, cj0Var2, mk0Var2, fq0Var, ui0Var));
                bk1 bk1Var = bk1.a;
                ek1 ek1VarC2 = ek1VarC.c(bk1Var);
                x20Var.W(-7432681);
                x20Var.p(false);
                ek1 ek1VarC3 = ek1Var.c(ek1VarC2.c(bk1Var));
                Object objL16 = x20Var.L();
                if (objL16 == obj) {
                    objL16 = new ed(ldVar);
                    x20Var.g0(objL16);
                }
                ed edVar = (ed) objL16;
                int iHashCode = Long.hashCode(x20Var.T);
                gw1 gw1VarL = x20Var.l();
                ek1 ek1VarC4 = gj4.c(x20Var, ek1VarC3);
                o20.p.getClass();
                fq0 fq0Var2 = n20.b;
                x20Var.Z();
                if (x20Var.S) {
                    x20Var.k(fq0Var2);
                } else {
                    x20Var.j0();
                }
                ie4.c(x20Var, n20.f, edVar);
                ie4.c(x20Var, n20.e, gw1VarL);
                ie4.a(x20Var, Integer.valueOf(iHashCode), n20.g);
                ie4.b(x20Var, n20.h);
                ie4.c(x20Var, n20.d, ek1VarC4);
                w10Var.c(ldVar, x20Var, Integer.valueOf((i3 >> 18) & 112));
                x20Var.p(true);
            }
            x20Var.p(false);
            x20Var.p(false);
        } else {
            x20Var.W(-272333293);
            x20Var.p(false);
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new fd(j23Var, hq0Var, ek1Var, cj0Var, mk0Var, vq0Var, w10Var, i);
        }
    }

    public static final void b(boolean z, ek1 ek1Var, cj0 cj0Var, mk0 mk0Var, String str, w10 w10Var, x20 x20Var, int i) {
        int i2;
        String str2;
        x20Var.X(-1448730565);
        if ((i & 6) == 0) {
            i2 = (x20Var.g(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.f(ek1Var) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var.f(cj0Var) ? 256 : 128;
        }
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i2 |= x20Var.f(mk0Var) ? 2048 : 1024;
        }
        int i3 = i2 | 24576;
        if ((196608 & i) == 0) {
            i3 |= x20Var.h(w10Var) ? Normalizer.INPUT_IS_FCD : 65536;
        }
        if (x20Var.O(i3 & 1, (74899 & i3) != 74898)) {
            Boolean boolValueOf = Boolean.valueOf(z);
            int i4 = (i3 & 14) | ((i3 >> 9) & 112);
            int i5 = l23.a;
            Object objL = x20Var.L();
            int i6 = 9;
            xy xyVar = r20.a;
            if (objL == xyVar) {
                objL = new j23(new q91(9, boolValueOf), null, "AnimatedVisibility");
                x20Var.g0(objL);
            }
            j23 j23Var = (j23) objL;
            j23Var.a(boolValueOf, x20Var, (i4 & 14) | (i4 & 8) | 48);
            Object objL2 = x20Var.L();
            if (objL2 == xyVar) {
                objL2 = new rm2(i6, j23Var);
                x20Var.g0(objL2);
            }
            bz3.a(j23Var, (hq0) objL2, x20Var);
            Object objL3 = x20Var.L();
            if (objL3 == xyVar) {
                objL3 = j7.t;
                x20Var.g0(objL3);
            }
            int i7 = i3 << 3;
            c(j23Var, (hq0) objL3, ek1Var, cj0Var, mk0Var, w10Var, x20Var, (i7 & 57344) | (i7 & 896) | 48 | (i7 & 7168) | (i3 & 458752));
            str2 = "AnimatedVisibility";
        } else {
            x20Var.R();
            str2 = str;
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new hd(z, ek1Var, cj0Var, mk0Var, str2, w10Var, i);
        }
    }

    public static final void c(j23 j23Var, hq0 hq0Var, ek1 ek1Var, cj0 cj0Var, mk0 mk0Var, w10 w10Var, x20 x20Var, int i) {
        int i2;
        cj0 cj0Var2;
        mk0 mk0Var2;
        w10 w10Var2;
        x20Var.X(1706321816);
        if ((i & 6) == 0) {
            i2 = (x20Var.f(j23Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= x20Var.h(hq0Var) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i2 |= x20Var.f(ek1Var) ? 256 : 128;
        }
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            cj0Var2 = cj0Var;
            i2 |= x20Var.f(cj0Var2) ? 2048 : 1024;
        } else {
            cj0Var2 = cj0Var;
        }
        if ((i & 24576) == 0) {
            mk0Var2 = mk0Var;
            i2 |= x20Var.f(mk0Var2) ? 16384 : 8192;
        } else {
            mk0Var2 = mk0Var;
        }
        if ((i & 196608) == 0) {
            w10Var2 = w10Var;
            i2 |= x20Var.h(w10Var2) ? Normalizer.INPUT_IS_FCD : 65536;
        } else {
            w10Var2 = w10Var;
        }
        if (x20Var.O(i2 & 1, (74899 & i2) != 74898)) {
            int i3 = i2 & 112;
            int i4 = i2 & 14;
            boolean z = (i3 == 32) | (i4 == 4);
            Object objL = x20Var.L();
            xy xyVar = r20.a;
            if (z || objL == xyVar) {
                objL = new id(hq0Var, j23Var);
                x20Var.g0(objL);
            }
            ek1 ek1VarA = xz3.a(ek1Var, (wq0) objL);
            Object objL2 = x20Var.L();
            if (objL2 == xyVar) {
                objL2 = jd.c;
                x20Var.g0(objL2);
            }
            a(j23Var, hq0Var, ek1VarA, cj0Var2, mk0Var2, (vq0) objL2, w10Var2, x20Var, 196608 | i4 | i3 | (i2 & 7168) | (57344 & i2) | ((i2 << 6) & 29360128));
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new kd(j23Var, hq0Var, ek1Var, cj0Var, mk0Var, w10Var, i);
        }
    }

    public static final boolean d(long j, long j2) {
        return j == j2;
    }

    public static final si0 e(j23 j23Var, hq0 hq0Var, Object obj, x20 x20Var) {
        x20Var.S(-422486745, 0, j23Var, null);
        boolean zG = j23Var.g();
        si0 si0Var = si0.a;
        si0 si0Var2 = si0.c;
        si0 si0Var3 = si0.b;
        if (zG) {
            x20Var.W(-212166497);
            x20Var.p(false);
            if (((Boolean) hq0Var.j(obj)).booleanValue()) {
                si0Var = si0Var3;
            } else if (((Boolean) hq0Var.j(j23Var.c())).booleanValue()) {
                si0Var = si0Var2;
            }
        } else {
            x20Var.W(-211892364);
            Object objL = x20Var.L();
            if (objL == r20.a) {
                objL = o44.g(Boolean.FALSE);
                x20Var.g0(objL);
            }
            mm1 mm1Var = (mm1) objL;
            if (((Boolean) hq0Var.j(j23Var.c())).booleanValue()) {
                mm1Var.setValue(Boolean.TRUE);
            }
            if (((Boolean) hq0Var.j(obj)).booleanValue()) {
                si0Var = si0Var3;
            } else if (((Boolean) mm1Var.getValue()).booleanValue()) {
                si0Var = si0Var2;
            }
            x20Var.p(false);
        }
        x20Var.p(false);
        return si0Var;
    }

    public static String f(long j) {
        return "PointerId(value=" + j + ')';
    }
}
