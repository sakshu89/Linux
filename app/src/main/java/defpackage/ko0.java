package defpackage;

import android.os.Trace;
import com.ibm.icu.impl.UCharacterProperty;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ko0 extends dk1 implements h30, w61, ep1, gk1, xb0 {
    public boolean H;
    public boolean X;
    public final int Y;
    public final vq0 x;

    public ko0(int i, vq0 vq0Var, int i2) {
        this.x = (i2 & 4) != 0 ? null : vq0Var;
        this.Y = i;
    }

    @Override // defpackage.dk1
    public final void B0() {
        int iOrdinal = N0().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                ((r7) cm4.h(this)).getFocusOwner();
                xn4.a(this);
                return;
            } else if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return;
                }
                dk0.l();
                return;
            }
        }
        do0 do0Var = (do0) ((r7) cm4.h(this)).getFocusOwner();
        do0Var.b(true, false, 8);
        do0Var.d.a();
    }

    @Override // defpackage.dk1
    public final void C0() {
        if (N0().a()) {
            ((do0) ((r7) cm4.h(this)).getFocusOwner()).b(true, true, 8);
        }
    }

    /* JADX WARN: Code duplicated, block: B:155:0x0225  */
    /* JADX WARN: Code duplicated, block: B:157:0x022c A[ADDED_TO_REGION, LOOP:9: B:157:0x022c->B:164:0x023e, LOOP_START, PHI: r12
      0x022c: PHI (r12v3 int) = (r12v2 int), (r12v4 int) binds: [B:156:0x022a, B:164:0x023e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:158:0x022e  */
    /* JADX WARN: Code duplicated, block: B:161:0x0239 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:162:0x023b  */
    /* JADX WARN: Code duplicated, block: B:163:0x023d  */
    /* JADX WARN: Code duplicated, block: B:165:0x0244  */
    /* JADX WARN: Code duplicated, block: B:168:0x024c  */
    /* JADX WARN: Code duplicated, block: B:172:0x0257 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:206:0x01c2 A[SYNTHETIC] */
    public final boolean I0() {
        pm1 pm1Var;
        int i;
        ko0 ko0Var;
        jo0 jo0Var;
        zn1 zn1Var;
        char c;
        zn1 zn1Var2;
        int iOrdinal = wn4.d(this).ordinal();
        int i2 = 0;
        if (iOrdinal == 0) {
            do0 do0Var = (do0) ((r7) cm4.h(this)).getFocusOwner();
            ko0 ko0VarF = do0Var.f();
            jo0 jo0VarN0 = N0();
            if (ko0VarF == this) {
                J0(jo0VarN0, jo0VarN0);
                return true;
            }
            if (ko0VarF != null || ((do0) ((r7) cm4.h(this)).getFocusOwner()).a.z()) {
                char c2 = 16;
                if (ko0VarF != null) {
                    pm1Var = new pm1(new ko0[16]);
                    if (!ko0VarF.a.w) {
                        z01.b("visitAncestors called on an unattached node");
                    }
                    dk1 dk1Var = ko0VarF.a.f;
                    n71 n71VarG = cm4.g(ko0VarF);
                    while (n71VarG != null) {
                        if ((n71VarG.o0.f.e & 1024) != 0) {
                            while (dk1Var != null) {
                                if ((dk1Var.c & 1024) != 0) {
                                    dk1 dk1VarB = dk1Var;
                                    pm1 pm1Var2 = null;
                                    while (dk1VarB != null) {
                                        if (dk1VarB instanceof ko0) {
                                            pm1Var.b((ko0) dk1VarB);
                                        } else if ((dk1VarB.c & 1024) != 0 && (dk1VarB instanceof zb0)) {
                                            int i3 = 0;
                                            for (dk1 dk1Var2 = ((zb0) dk1VarB).H; dk1Var2 != null; dk1Var2 = dk1Var2.i) {
                                                if ((dk1Var2.c & 1024) != 0) {
                                                    i3++;
                                                    if (i3 == 1) {
                                                        dk1VarB = dk1Var2;
                                                    } else {
                                                        if (pm1Var2 == null) {
                                                            pm1Var2 = new pm1(new dk1[16]);
                                                        }
                                                        if (dk1VarB != null) {
                                                            pm1Var2.b(dk1VarB);
                                                            dk1VarB = null;
                                                        }
                                                        pm1Var2.b(dk1Var2);
                                                    }
                                                }
                                            }
                                            if (i3 == 1) {
                                            }
                                        }
                                        dk1VarB = cm4.b(pm1Var2);
                                    }
                                }
                                dk1Var = dk1Var.f;
                            }
                        }
                        n71VarG = n71VarG.u();
                        dk1Var = (n71VarG == null || (zn1Var2 = n71VarG.o0) == null) ? null : zn1Var2.e;
                    }
                } else {
                    pm1Var = null;
                }
                Object[] objArr = new ko0[16];
                if (!this.a.w) {
                    z01.b("visitAncestors called on an unattached node");
                }
                dk1 dk1Var3 = this.a.f;
                n71 n71VarG2 = cm4.g(this);
                int i4 = 0;
                int i5 = 1;
                while (n71VarG2 != null) {
                    if ((n71VarG2.o0.f.e & 1024) != 0) {
                        while (dk1Var3 != null) {
                            if ((dk1Var3.c & 1024) != 0) {
                                dk1 dk1VarB2 = dk1Var3;
                                pm1 pm1Var3 = null;
                                while (dk1VarB2 != null) {
                                    if (dk1VarB2 instanceof ko0) {
                                        ko0 ko0Var2 = (ko0) dk1VarB2;
                                        Boolean boolValueOf = pm1Var != null ? Boolean.valueOf(pm1Var.k(ko0Var2)) : null;
                                        if (boolValueOf == null || !boolValueOf.booleanValue()) {
                                            int i6 = i4 + 1;
                                            if (objArr.length < i6) {
                                                int length = objArr.length;
                                                Object[] objArr2 = new Object[Math.max(i6, length * 2)];
                                                System.arraycopy(objArr, i2, objArr2, i2, length);
                                                objArr = objArr2;
                                            }
                                            objArr[i4] = ko0Var2;
                                            i4 = i6;
                                        }
                                        if (ko0Var2 == ko0VarF) {
                                            i5 = i2;
                                        }
                                    } else if ((dk1VarB2.c & 1024) != 0 && (dk1VarB2 instanceof zb0)) {
                                        int i7 = i2;
                                        for (dk1 dk1Var4 = ((zb0) dk1VarB2).H; dk1Var4 != null; dk1Var4 = dk1Var4.i) {
                                            if ((dk1Var4.c & 1024) != 0) {
                                                i7++;
                                                if (i7 == 1) {
                                                    dk1VarB2 = dk1Var4;
                                                } else {
                                                    if (pm1Var3 == null) {
                                                        pm1Var3 = new pm1(new dk1[16]);
                                                    }
                                                    if (dk1VarB2 != null) {
                                                        pm1Var3.b(dk1VarB2);
                                                        dk1VarB2 = null;
                                                    }
                                                    pm1Var3.b(dk1Var4);
                                                }
                                            }
                                        }
                                        c = 16;
                                        if (i7 == 1) {
                                            c2 = 16;
                                            i2 = 0;
                                        } else {
                                            dk1VarB2 = cm4.b(pm1Var3);
                                            c2 = c;
                                            i2 = 0;
                                        }
                                    }
                                    c = 16;
                                    dk1VarB2 = cm4.b(pm1Var3);
                                    c2 = c;
                                    i2 = 0;
                                }
                            }
                            dk1Var3 = dk1Var3.f;
                            c2 = c2;
                            i2 = 0;
                        }
                    }
                    char c3 = c2;
                    n71VarG2 = n71VarG2.u();
                    dk1Var3 = (n71VarG2 == null || (zn1Var = n71VarG2.o0) == null) ? null : zn1Var.e;
                    c2 = c3;
                    i2 = 0;
                }
                if (i5 == 0 || ko0VarF == null || wn4.a(ko0VarF, false)) {
                    tr4.a(this, new ta(4, this));
                    int iOrdinal2 = N0().ordinal();
                    if (iOrdinal2 != 0) {
                        if (iOrdinal2 == 1) {
                            ((do0) ((r7) cm4.h(this)).getFocusOwner()).i(this);
                        } else if (iOrdinal2 != 2) {
                            if (iOrdinal2 != 3) {
                                dk0.l();
                                return false;
                            }
                            ((do0) ((r7) cm4.h(this)).getFocusOwner()).i(this);
                        }
                    }
                    jo0 jo0Var2 = jo0.c;
                    jo0 jo0Var3 = jo0.a;
                    if (i5 != 0 && ko0VarF != null) {
                        ko0VarF.J0(jo0Var3, jo0Var2);
                    }
                    jo0 jo0Var4 = jo0.b;
                    if (pm1Var != null) {
                        int i8 = pm1Var.c - 1;
                        Object[] objArr3 = pm1Var.a;
                        if (i8 < objArr3.length) {
                            while (i8 >= 0) {
                                ko0 ko0Var3 = (ko0) objArr3[i8];
                                if (do0Var.f() == this) {
                                    ko0Var3.J0(jo0Var4, jo0Var2);
                                    i8--;
                                }
                            }
                            i = i4 - 1;
                            if (i < objArr.length) {
                                while (i >= 0) {
                                    ko0Var = (ko0) objArr[i];
                                    if (do0Var.f() == this) {
                                        if (ko0Var == ko0VarF) {
                                            jo0Var = jo0Var3;
                                        } else {
                                            jo0Var = jo0Var2;
                                        }
                                        ko0Var.J0(jo0Var, jo0Var4);
                                        i--;
                                    }
                                }
                                if (do0Var.f() == this) {
                                    J0(jo0VarN0, jo0Var3);
                                    if (do0Var.f() != this) {
                                        return true;
                                    }
                                }
                            } else if (do0Var.f() == this) {
                                J0(jo0VarN0, jo0Var3);
                                if (do0Var.f() != this) {
                                    return true;
                                }
                            }
                        } else {
                            i = i4 - 1;
                            if (i < objArr.length) {
                                while (i >= 0) {
                                    ko0Var = (ko0) objArr[i];
                                    if (do0Var.f() == this) {
                                        if (ko0Var == ko0VarF) {
                                            jo0Var = jo0Var3;
                                        } else {
                                            jo0Var = jo0Var2;
                                        }
                                        ko0Var.J0(jo0Var, jo0Var4);
                                        i--;
                                    }
                                }
                                if (do0Var.f() == this) {
                                    J0(jo0VarN0, jo0Var3);
                                    if (do0Var.f() != this) {
                                        return true;
                                    }
                                }
                            } else if (do0Var.f() == this) {
                                J0(jo0VarN0, jo0Var3);
                                if (do0Var.f() != this) {
                                    return true;
                                }
                            }
                        }
                    } else {
                        i = i4 - 1;
                        if (i < objArr.length) {
                            while (i >= 0) {
                                ko0Var = (ko0) objArr[i];
                                if (do0Var.f() == this) {
                                    if (ko0Var == ko0VarF) {
                                        jo0Var = jo0Var3;
                                    } else {
                                        jo0Var = jo0Var2;
                                    }
                                    ko0Var.J0(jo0Var, jo0Var4);
                                    i--;
                                }
                            }
                            if (do0Var.f() == this) {
                                J0(jo0VarN0, jo0Var3);
                                if (do0Var.f() != this) {
                                    return true;
                                }
                            }
                        } else if (do0Var.f() == this) {
                            J0(jo0VarN0, jo0Var3);
                            if (do0Var.f() != this) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }
        } else if (iOrdinal != 1) {
            if (iOrdinal == 2) {
                return true;
            }
            if (iOrdinal != 3) {
                dk0.l();
                return false;
            }
        }
        return false;
    }

    @Override // defpackage.ep1
    public final void J() {
        O0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10, types: [dk1] */
    /* JADX WARN: Type inference failed for: r3v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v13 */
    /* JADX WARN: Type inference failed for: r3v14 */
    /* JADX WARN: Type inference failed for: r3v15 */
    /* JADX WARN: Type inference failed for: r3v16 */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v6 */
    /* JADX WARN: Type inference failed for: r3v7, types: [dk1] */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v10 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3 */
    /* JADX WARN: Type inference failed for: r5v4, types: [pm1] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6 */
    /* JADX WARN: Type inference failed for: r5v7, types: [pm1] */
    /* JADX WARN: Type inference failed for: r6v5 */
    public final void J0(jo0 jo0Var, jo0 jo0Var2) {
        zn1 zn1Var;
        vq0 vq0Var;
        do0 do0Var = (do0) ((r7) cm4.h(this)).getFocusOwner();
        ko0 ko0VarF = do0Var.f();
        if (!jo0Var.equals(jo0Var2) && (vq0Var = this.x) != null) {
            vq0Var.e(jo0Var, jo0Var2);
        }
        dk1 dk1Var = this.a;
        if (!dk1Var.w) {
            z01.b("visitAncestors called on an unattached node");
        }
        dk1 dk1Var2 = this.a;
        n71 n71VarG = cm4.g(this);
        while (n71VarG != null) {
            if ((n71VarG.o0.f.e & 5120) != 0) {
                while (dk1Var2 != null) {
                    int i = dk1Var2.c;
                    if ((i & 5120) != 0) {
                        if (dk1Var2 != dk1Var && (i & 1024) != 0) {
                            return;
                        }
                        if ((i & 4096) != 0) {
                            ?? B = dk1Var2;
                            ?? pm1Var = 0;
                            while (B != 0) {
                                if (B instanceof rn0) {
                                    rn0 rn0Var = (rn0) B;
                                    if (ko0VarF == do0Var.f()) {
                                        rn0Var.V(jo0Var2);
                                    }
                                } else if ((B.c & 4096) != 0 && (B instanceof zb0)) {
                                    dk1 dk1Var3 = ((zb0) B).H;
                                    int i2 = 0;
                                    B = B;
                                    pm1Var = pm1Var;
                                    while (dk1Var3 != null) {
                                        if ((dk1Var3.c & 4096) != 0) {
                                            i2++;
                                            pm1Var = pm1Var;
                                            if (i2 == 1) {
                                                B = dk1Var3;
                                            } else {
                                                if (pm1Var == 0) {
                                                    pm1Var = new pm1(new dk1[16]);
                                                }
                                                if (B != 0) {
                                                    pm1Var.b(B);
                                                    B = 0;
                                                }
                                                pm1Var.b(dk1Var3);
                                            }
                                        }
                                        dk1Var3 = dk1Var3.i;
                                        B = B;
                                        pm1Var = pm1Var;
                                    }
                                    if (i2 == 1) {
                                    }
                                }
                                B = cm4.b(pm1Var);
                            }
                        }
                    }
                    dk1Var2 = dk1Var2.f;
                }
            }
            n71VarG = n71VarG.u();
            dk1Var2 = (n71VarG == null || (zn1Var = n71VarG.o0) == null) ? null : zn1Var.e;
        }
    }

    public final eo0 K0() {
        boolean z;
        zn1 zn1Var;
        eo0 eo0Var = new eo0();
        eo0Var.a = true;
        fo0 fo0Var = fo0.b;
        eo0Var.b = fo0Var;
        eo0Var.c = fo0Var;
        eo0Var.d = fo0Var;
        eo0Var.e = fo0Var;
        eo0Var.f = fo0Var;
        eo0Var.g = fo0Var;
        eo0Var.h = fo0Var;
        eo0Var.i = fo0Var;
        eo0Var.j = j7.f0;
        eo0Var.k = j7.g0;
        eo0Var.l = ak1.e;
        int i = this.Y;
        if (i == 1) {
            z = true;
        } else if (i == 0) {
            z = !(((n11) ((p11) ((o11) ij4.a(this, l30.m))).a.getValue()).a == 1);
        } else {
            if (i != 2) {
                og.n("Unknown Focusability");
                return null;
            }
            z = false;
        }
        eo0Var.a = z;
        dk1 dk1Var = this.a;
        if (!dk1Var.w) {
            z01.b("visitAncestors called on an unattached node");
        }
        dk1 dk1Var2 = this.a;
        n71 n71VarG = cm4.g(this);
        loop0: while (n71VarG != null) {
            if ((n71VarG.o0.f.e & UCharacterProperty.SCRIPT_X_WITH_OTHER) != 0) {
                while (dk1Var2 != null) {
                    int i2 = dk1Var2.c;
                    if ((i2 & UCharacterProperty.SCRIPT_X_WITH_OTHER) != 0) {
                        if (dk1Var2 != dk1Var && (i2 & 1024) != 0) {
                            break loop0;
                        }
                        if ((i2 & 2048) != 0) {
                            pm1 pm1Var = null;
                            dk1 dk1VarB = dk1Var2;
                            while (dk1VarB != null) {
                                if (dk1VarB instanceof ok) {
                                    ck1 ck1Var = ((ok) dk1VarB).x;
                                    z01.b("applyFocusProperties called on wrong node");
                                    ck1Var.getClass();
                                    dk0.t();
                                    return null;
                                }
                                if ((dk1VarB.c & 2048) != 0 && (dk1VarB instanceof zb0)) {
                                    int i3 = 0;
                                    for (dk1 dk1Var3 = ((zb0) dk1VarB).H; dk1Var3 != null; dk1Var3 = dk1Var3.i) {
                                        if ((dk1Var3.c & 2048) != 0) {
                                            i3++;
                                            if (i3 == 1) {
                                                dk1VarB = dk1Var3;
                                            } else {
                                                if (pm1Var == null) {
                                                    pm1Var = new pm1(new dk1[16]);
                                                }
                                                if (dk1VarB != null) {
                                                    pm1Var.b(dk1VarB);
                                                    dk1VarB = null;
                                                }
                                                pm1Var.b(dk1Var3);
                                            }
                                        }
                                    }
                                    if (i3 == 1) {
                                    }
                                }
                                dk1VarB = cm4.b(pm1Var);
                            }
                        } else {
                            continue;
                        }
                    }
                    dk1Var2 = dk1Var2.f;
                }
            }
            n71VarG = n71VarG.u();
            dk1Var2 = (n71VarG == null || (zn1Var = n71VarG.o0) == null) ? null : zn1Var.e;
        }
        return eo0Var;
    }

    public final l42 L0(y61 y61Var) {
        l42 l42Var = K0().l;
        if (l42Var != ak1.e) {
            return y61Var == null ? l42Var : l42Var.i(y61Var.H(cm4.f(this), 0L));
        }
        return y61Var != null ? y61Var.N(cm4.f(this), false) : ry3.a(0L, cp4.a(cm4.f(this).c));
    }

    public final p81 M0() {
        zn1 zn1Var;
        Object obj;
        if (!this.a.w) {
            z01.b("visitAncestors called on an unattached node");
        }
        dk1 dk1Var = this.a.f;
        n71 n71VarG = cm4.g(this);
        loop0: while (n71VarG != null) {
            if ((n71VarG.o0.f.e & 8388640) != 0) {
                while (dk1Var != null) {
                    int i = dk1Var.c;
                    if ((i & 8388640) != 0) {
                        if ((8388608 & i) != 0) {
                            if (!(dk1Var instanceof p81)) {
                                if (dk1Var instanceof zb0) {
                                    dk1Var = null;
                                    for (dk1 dk1Var2 = ((zb0) dk1Var).H; dk1Var2 != null; dk1Var2 = dk1Var2.i) {
                                        if (dk1Var2 instanceof p81) {
                                            dk1Var = dk1Var2;
                                        }
                                    }
                                } else {
                                    dk1Var = null;
                                }
                            }
                            p81 p81Var = (p81) dk1Var;
                            if (p81Var != null) {
                                return p81Var;
                            }
                        } else if ((i & 32) != 0) {
                            if (dk1Var instanceof gk1) {
                                obj = dk1Var;
                            } else if (dk1Var instanceof zb0) {
                                obj = null;
                                for (dk1 dk1Var3 = ((zb0) dk1Var).H; dk1Var3 != null; dk1Var3 = dk1Var3.i) {
                                    if (dk1Var3 instanceof gk1) {
                                        obj = dk1Var3;
                                    }
                                }
                            } else {
                                obj = null;
                            }
                            gk1 gk1Var = (gk1) obj;
                            if (gk1Var != null) {
                                gk1Var.i();
                            }
                        }
                    }
                    dk1Var = dk1Var.f;
                }
            }
            n71VarG = n71VarG.u();
            dk1Var = (n71VarG == null || (zn1Var = n71VarG.o0) == null) ? null : zn1Var.e;
        }
        return null;
    }

    public final jo0 N0() {
        ko0 ko0VarF;
        zn1 zn1Var;
        boolean z = this.w;
        jo0 jo0Var = jo0.c;
        if (!z || (ko0VarF = ((do0) ((r7) cm4.h(this)).getFocusOwner()).f()) == null) {
            return jo0Var;
        }
        if (this == ko0VarF) {
            return jo0.a;
        }
        if (ko0VarF.w) {
            if (!ko0VarF.a.w) {
                z01.b("visitAncestors called on an unattached node");
            }
            dk1 dk1Var = ko0VarF.a.f;
            n71 n71VarG = cm4.g(ko0VarF);
            while (n71VarG != null) {
                if ((n71VarG.o0.f.e & 1024) != 0) {
                    while (dk1Var != null) {
                        if ((dk1Var.c & 1024) != 0) {
                            dk1 dk1VarB = dk1Var;
                            pm1 pm1Var = null;
                            while (dk1VarB != null) {
                                if (dk1VarB instanceof ko0) {
                                    if (this == ((ko0) dk1VarB)) {
                                        return jo0.b;
                                    }
                                } else if ((dk1VarB.c & 1024) != 0 && (dk1VarB instanceof zb0)) {
                                    int i = 0;
                                    for (dk1 dk1Var2 = ((zb0) dk1VarB).H; dk1Var2 != null; dk1Var2 = dk1Var2.i) {
                                        if ((dk1Var2.c & 1024) != 0) {
                                            i++;
                                            if (i == 1) {
                                                dk1VarB = dk1Var2;
                                            } else {
                                                if (pm1Var == null) {
                                                    pm1Var = new pm1(new dk1[16]);
                                                }
                                                if (dk1VarB != null) {
                                                    pm1Var.b(dk1VarB);
                                                    dk1VarB = null;
                                                }
                                                pm1Var.b(dk1Var2);
                                            }
                                        }
                                    }
                                    if (i == 1) {
                                    }
                                }
                                dk1VarB = cm4.b(pm1Var);
                            }
                        }
                        dk1Var = dk1Var.f;
                    }
                }
                n71VarG = n71VarG.u();
                dk1Var = (n71VarG == null || (zn1Var = n71VarG.o0) == null) ? null : zn1Var.e;
            }
        }
        return jo0Var;
    }

    public final void O0() {
        int iOrdinal = N0().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return;
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return;
                }
                dk0.l();
                return;
            }
        }
        t42 t42Var = new t42();
        tr4.a(this, new h7(4, t42Var, this));
        Object obj = t42Var.a;
        if (obj == null) {
            g31.f("focusProperties");
            throw null;
        }
        if (((eo0) obj).a) {
            return;
        }
        ((do0) ((r7) cm4.h(this)).getFocusOwner()).b(true, true, 8);
    }

    public final boolean P0(int i) {
        Trace.beginSection("FocusTransactions:requestFocus");
        try {
            return K0().a ? I0() : nd4.f(this, i, new kt1(i));
        } finally {
            Trace.endSection();
        }
    }

    @Override // defpackage.dk1
    public final boolean x0() {
        return false;
    }

    @Override // defpackage.w61
    public final void o(y61 y61Var) {
    }
}
