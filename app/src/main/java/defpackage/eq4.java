package defpackage;

import com.ibm.icu.impl.UCharacterProperty;
import com.ibm.icu.impl.coll.CollationFastLatin;
import com.ibm.icu.text.ArabicShaping;
import com.ibm.icu.text.Normalizer;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class eq4 {
    /* JADX WARN: Code duplicated, block: B:173:0x029b  */
    /* JADX WARN: Code duplicated, block: B:197:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:211:0x031a  */
    /* JADX WARN: Code duplicated, block: B:214:0x0338  */
    /* JADX WARN: Code duplicated, block: B:225:0x0362  */
    /* JADX WARN: Code duplicated, block: B:227:0x0378  */
    /* JADX WARN: Code duplicated, block: B:230:0x03aa  */
    /* JADX WARN: Code duplicated, block: B:231:0x03b1  */
    public static final void a(ek1 ek1Var, ea1 ea1Var, qt1 qt1Var, ka0 ka0Var, boolean z, f9 f9Var, jl jlVar, fg fgVar, hq0 hq0Var, x20 x20Var, int i, int i2) {
        int i3;
        int i4;
        hq0 hq0Var2;
        boolean z2;
        Object obj;
        boolean z3;
        boolean z4;
        boolean zF;
        Object objL;
        boolean z5;
        u91 u91Var;
        bk1 bk1Var;
        js1 js1Var;
        ek1 m81Var;
        ek1 ek1VarA;
        boolean zD;
        Object objL2;
        ea1 ea1Var2 = ea1Var;
        x20Var.X(924924659);
        if ((i & 6) == 0) {
            i3 = (x20Var.f(ek1Var) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= x20Var.f(ea1Var2) ? 32 : 16;
        }
        if ((i & CollationFastLatin.LATIN_LIMIT) == 0) {
            i3 |= x20Var.f(qt1Var) ? 256 : 128;
        }
        if ((i & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            i3 |= x20Var.g(false) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= x20Var.g(true) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= x20Var.f(ka0Var) ? Normalizer.INPUT_IS_FCD : 65536;
        }
        if ((i & 1572864) == 0) {
            i3 |= x20Var.g(z) ? 1048576 : ArabicShaping.TASHKEEL_RESIZE;
        }
        if ((i & 12582912) == 0) {
            i3 |= x20Var.f(f9Var) ? 8388608 : 4194304;
        }
        if ((i & 100663296) == 0) {
            i3 |= 33554432;
        }
        if ((i & 805306368) == 0) {
            i3 |= x20Var.f(jlVar) ? 536870912 : 268435456;
        }
        if ((i2 & 6) == 0) {
            i4 = i2 | (x20Var.f(fgVar) ? 4 : 2);
        } else {
            i4 = i2;
        }
        int i5 = i4 | 432;
        if ((i2 & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 0) {
            hq0Var2 = hq0Var;
            i5 |= x20Var.h(hq0Var2) ? 2048 : 1024;
        } else {
            hq0Var2 = hq0Var;
        }
        if (x20Var.O(i3 & 1, ((i3 & 306783379) == 306783378 && (i5 & 1171) == 1170) ? false : true)) {
            x20Var.T();
            if ((i & 1) != 0 && !x20Var.y()) {
                x20Var.R();
            }
            int i6 = i3 & (-234881025);
            x20Var.q();
            int i7 = i6 >> 3;
            int i8 = i7 & 14;
            int i9 = i8 | ((i5 >> 6) & 112);
            mm1 mm1VarH = o44.h(hq0Var, x20Var);
            boolean z6 = (((i9 & 14) ^ 6) > 4 && x20Var.f(ea1Var2)) || (i9 & 6) == 4;
            Object objL3 = x20Var.L();
            Object obj2 = r20.a;
            if (z6 || objL3 == obj2) {
                k81 k81Var = new k81();
                k81Var.a = new hu1(Integer.MAX_VALUE);
                k81Var.b = new hu1(Integer.MAX_VALUE);
                ak1 ak1Var = ak1.i;
                hc hcVar = new hc(mm1VarH, 4);
                kf kfVar = pm2.a;
                objL3 = new u91(0, 0, gr2.class, new qc0(new ek(new qc0(hcVar, ak1Var), ea1Var2, k81Var, 4), ak1Var), "value", "getValue()Ljava/lang/Object;");
                x20Var.g0(objL3);
            }
            u91 u91Var2 = (u91) objL3;
            int i10 = i6 >> 9;
            int i11 = i8 | (i10 & 112);
            boolean z7 = ((((i11 & 112) ^ 48) > 32 && x20Var.g(true)) || (i11 & 48) == 32) | ((((i11 & 14) ^ 6) > 4 && x20Var.f(ea1Var2)) || (i11 & 6) == 4);
            Object objL4 = x20Var.L();
            if (z7 || objL4 == obj2) {
                objL4 = new j91(ea1Var2);
                x20Var.g0(objL4);
            }
            j91 j91Var = (j91) objL4;
            Object objL5 = x20Var.L();
            if (objL5 == obj2) {
                objL5 = bz3.e(x20Var);
                x20Var.g0(objL5);
            }
            s70 s70Var = (s70) objL5;
            uu0 uu0Var = (uu0) x20Var.j(l30.g);
            nr4 nr4Var = !((Boolean) x20Var.j(l30.v)).booleanValue() ? ur2.a : null;
            int i12 = i5 << 18;
            int i13 = (i6 & 65520) | (i10 & 3670016) | (i12 & 29360128) | (i12 & 234881024) | ((i5 << 27) & 1879048192);
            boolean z8 = ((((i13 & 112) ^ 48) > 32 && x20Var.f(ea1Var2)) || (i13 & 48) == 32) | ((((i13 & 896) ^ CollationFastLatin.LATIN_LIMIT) > 256 && x20Var.f(qt1Var)) || (i13 & CollationFastLatin.LATIN_LIMIT) == 256) | ((((i13 & 7168) ^ UCharacterProperty.SCRIPT_X_WITH_OTHER) > 2048 && x20Var.g(false)) || (i13 & UCharacterProperty.SCRIPT_X_WITH_OTHER) == 2048);
            if (((57344 & i13) ^ 24576) > 16384 && x20Var.g(true)) {
                z2 = true;
            } else if ((i13 & 24576) == 16384) {
                z2 = true;
            } else {
                z2 = false;
            }
            boolean zD2 = ((((i13 & 3670016) ^ 1572864) > 1048576 && x20Var.f(jlVar)) || (i13 & 1572864) == 1048576) | z8 | z2 | x20Var.d(0);
            if (((i13 & 29360128) ^ 12582912) > 8388608) {
                obj = null;
                if (x20Var.f(null)) {
                    z3 = true;
                }
                boolean z9 = zD2 | z3;
                if (((i13 & 234881024) ^ 100663296) > 67108864 || !x20Var.f(obj)) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                zF = z9 | z4 | ((((i13 & 1879048192) ^ 805306368) <= 536870912 && x20Var.f(fgVar)) || (i13 & 805306368) == 536870912) | x20Var.f(uu0Var) | x20Var.f(nr4Var);
                objL = x20Var.L();
                if (!zF || objL == obj2) {
                    z5 = true;
                    Object w91Var = new w91(ea1Var2, qt1Var, u91Var2, fgVar, s70Var, uu0Var, nr4Var, jlVar);
                    ea1Var2 = ea1Var2;
                    u91Var = u91Var2;
                    x20Var.g0(w91Var);
                    objL = w91Var;
                } else {
                    u91Var = u91Var2;
                    z5 = true;
                }
                w91 w91Var2 = (w91) objL;
                bk1Var = bk1.a;
                js1Var = js1.a;
                if (z) {
                    x20Var.W(-2077147368);
                    if ((((i7 & 14) ^ 6) > 4 || !x20Var.f(ea1Var2)) && (i7 & 6) != 4) {
                    }
                    zD = z5 | x20Var.d(0);
                    objL2 = x20Var.L();
                    if (zD || objL2 == obj2) {
                        objL2 = new p91(ea1Var2);
                        x20Var.g0(objL2);
                    }
                    m81Var = new m81((p91) objL2, ea1Var2.o, js1Var);
                    x20Var.p(false);
                } else {
                    x20Var.W(-2076718545);
                    x20Var.p(false);
                    m81Var = bk1Var;
                }
                ek1 ek1VarC = ek1Var.c(ea1Var2.l).c(ea1Var2.m).c(new k91(u91Var, j91Var, js1Var, z)).c(m81Var).c(ea1Var2.n.i);
                ol1 ol1Var = ea1Var2.g;
                if (js1Var == js1.a) {
                    ek1VarA = vh4.a(bk1Var, vw0.c);
                } else {
                    ek1VarA = vh4.a(bk1Var, vw0.b);
                }
                bq4.a(u91Var, ek1VarC.c(ek1VarA).c(new nd2(f9Var, ka0Var, ol1Var, js1Var, ea1Var2, z, false)), ea1Var2.p, w91Var2, x20Var, 0);
            } else {
                obj = null;
            }
            z3 = false;
            boolean z10 = zD2 | z3;
            if (((i13 & 234881024) ^ 100663296) > 67108864) {
                z4 = false;
            } else {
                z4 = false;
            }
            zF = z10 | z4 | ((((i13 & 1879048192) ^ 805306368) <= 536870912 && x20Var.f(fgVar)) || (i13 & 805306368) == 536870912) | x20Var.f(uu0Var) | x20Var.f(nr4Var);
            objL = x20Var.L();
            if (zF) {
                z5 = true;
                Object w91Var3 = new w91(ea1Var2, qt1Var, u91Var2, fgVar, s70Var, uu0Var, nr4Var, jlVar);
                ea1Var2 = ea1Var2;
                u91Var = u91Var2;
                x20Var.g0(w91Var3);
                objL = w91Var3;
            } else {
                z5 = true;
                Object w91Var4 = new w91(ea1Var2, qt1Var, u91Var2, fgVar, s70Var, uu0Var, nr4Var, jlVar);
                ea1Var2 = ea1Var2;
                u91Var = u91Var2;
                x20Var.g0(w91Var4);
                objL = w91Var4;
            }
            w91 w91Var5 = (w91) objL;
            bk1Var = bk1.a;
            js1Var = js1.a;
            if (z) {
                x20Var.W(-2077147368);
                z5 = ((i7 & 14) ^ 6) > 4 ? false : false;
                zD = z5 | x20Var.d(0);
                objL2 = x20Var.L();
                if (zD) {
                    objL2 = new p91(ea1Var2);
                    x20Var.g0(objL2);
                } else {
                    objL2 = new p91(ea1Var2);
                    x20Var.g0(objL2);
                }
                m81Var = new m81((p91) objL2, ea1Var2.o, js1Var);
                x20Var.p(false);
            } else {
                x20Var.W(-2076718545);
                x20Var.p(false);
                m81Var = bk1Var;
            }
            ek1 ek1VarC2 = ek1Var.c(ea1Var2.l).c(ea1Var2.m).c(new k91(u91Var, j91Var, js1Var, z)).c(m81Var).c(ea1Var2.n.i);
            ol1 ol1Var2 = ea1Var2.g;
            if (js1Var == js1.a) {
                ek1VarA = vh4.a(bk1Var, vw0.c);
            } else {
                ek1VarA = vh4.a(bk1Var, vw0.b);
            }
            bq4.a(u91Var, ek1VarC2.c(ek1VarA).c(new nd2(f9Var, ka0Var, ol1Var2, js1Var, ea1Var2, z, false)), ea1Var2.p, w91Var5, x20Var, 0);
        } else {
            x20Var.R();
        }
        a42 a42VarR = x20Var.r();
        if (a42VarR != null) {
            a42VarR.d = new go(ek1Var, ea1Var, qt1Var, ka0Var, z, f9Var, jlVar, fgVar, hq0Var2, i, i2);
        }
    }
}
