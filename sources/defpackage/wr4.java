package defpackage;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class wr4 {
    /* JADX WARN: Code duplicated, block: B:38:0x0076 A[RETURN] */
    public static final boolean a(ko0 ko0Var, ke0 ke0Var) {
        int iOrdinal = ko0Var.N0().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                ko0 ko0VarC = xn4.c(ko0Var);
                if (ko0VarC == null) {
                    og.n("ActiveParent must have a focusedChild");
                    return false;
                }
                int iOrdinal2 = ko0VarC.N0().ordinal();
                if (iOrdinal2 != 0) {
                    if (iOrdinal2 == 1) {
                        if (a(ko0VarC, ke0Var) || c(ko0Var, ko0VarC, 2, ke0Var) || (ko0VarC.K0().a && ((Boolean) ke0Var.j(ko0VarC)).booleanValue())) {
                            return true;
                        }
                        return false;
                    }
                    if (iOrdinal2 != 2) {
                        if (iOrdinal2 != 3) {
                            dk0.l();
                            return false;
                        }
                        og.n("ActiveParent must have a focusedChild");
                        return false;
                    }
                }
                return c(ko0Var, ko0VarC, 2, ke0Var);
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    dk0.l();
                    return false;
                }
                if (!d(ko0Var, ke0Var)) {
                    if (!(ko0Var.K0().a ? ((Boolean) ke0Var.j(ko0Var)).booleanValue() : false)) {
                        return false;
                    }
                }
                return true;
            }
        }
        return d(ko0Var, ke0Var);
    }

    public static final boolean b(ko0 ko0Var, ke0 ke0Var) {
        int iOrdinal = ko0Var.N0().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                ko0 ko0VarC = xn4.c(ko0Var);
                if (ko0VarC != null) {
                    return b(ko0VarC, ke0Var) || c(ko0Var, ko0VarC, 1, ke0Var);
                }
                og.n("ActiveParent must have a focusedChild");
                return false;
            }
            if (iOrdinal != 2) {
                if (iOrdinal == 3) {
                    return ko0Var.K0().a ? ((Boolean) ke0Var.j(ko0Var)).booleanValue() : e(ko0Var, ke0Var);
                }
                dk0.l();
                return false;
            }
        }
        return e(ko0Var, ke0Var);
    }

    public static final boolean c(ko0 ko0Var, ko0 ko0Var2, int i, ke0 ke0Var) {
        if (f(ko0Var, ko0Var2, i, ke0Var)) {
            return true;
        }
        Boolean bool = (Boolean) if4.c(ko0Var, i, new nq1(((do0) ((r7) cm4.h(ko0Var)).getFocusOwner()).f(), ko0Var, ko0Var2, i, ke0Var, 0));
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public static final boolean d(ko0 ko0Var, ke0 ke0Var) {
        Object[] objArr = new ko0[16];
        if (!ko0Var.a.w) {
            z01.b("visitChildren called on an unattached node");
        }
        pm1 pm1Var = new pm1(new dk1[16]);
        dk1 dk1Var = ko0Var.a;
        dk1 dk1Var2 = dk1Var.i;
        if (dk1Var2 == null) {
            cm4.a(pm1Var, dk1Var);
        } else {
            pm1Var.b(dk1Var2);
        }
        int i = 0;
        while (true) {
            int i2 = pm1Var.c;
            if (i2 == 0) {
                break;
            }
            dk1 dk1VarB = (dk1) pm1Var.l(i2 - 1);
            if ((dk1VarB.e & 1024) == 0) {
                cm4.a(pm1Var, dk1VarB);
            } else {
                while (dk1VarB != null) {
                    if ((dk1VarB.c & 1024) != 0) {
                        pm1 pm1Var2 = null;
                        while (dk1VarB != null) {
                            if (dk1VarB instanceof ko0) {
                                ko0 ko0Var2 = (ko0) dk1VarB;
                                int i3 = i + 1;
                                if (objArr.length < i3) {
                                    int length = objArr.length;
                                    Object[] objArr2 = new Object[Math.max(i3, length * 2)];
                                    System.arraycopy(objArr, 0, objArr2, 0, length);
                                    objArr = objArr2;
                                }
                                objArr[i] = ko0Var2;
                                i = i3;
                            } else if ((dk1VarB.c & 1024) != 0 && (dk1VarB instanceof zb0)) {
                                int i4 = 0;
                                for (dk1 dk1Var3 = ((zb0) dk1VarB).H; dk1Var3 != null; dk1Var3 = dk1Var3.i) {
                                    if ((dk1Var3.c & 1024) != 0) {
                                        i4++;
                                        if (i4 == 1) {
                                            dk1VarB = dk1Var3;
                                        } else {
                                            if (pm1Var2 == null) {
                                                pm1Var2 = new pm1(new dk1[16]);
                                            }
                                            if (dk1VarB != null) {
                                                pm1Var2.b(dk1VarB);
                                                dk1VarB = null;
                                            }
                                            pm1Var2.b(dk1Var3);
                                        }
                                    }
                                }
                                if (i4 == 1) {
                                }
                            }
                            dk1VarB = cm4.b(pm1Var2);
                        }
                        break;
                    }
                    dk1VarB = dk1VarB.i;
                }
            }
        }
        Arrays.sort(objArr, 0, i, lo0.b);
        int i5 = i - 1;
        if (i5 < objArr.length) {
            while (i5 >= 0) {
                ko0 ko0Var3 = (ko0) objArr[i5];
                if (xn4.d(ko0Var3) && a(ko0Var3, ke0Var)) {
                    return true;
                }
                i5--;
            }
        }
        return false;
    }

    public static final boolean e(ko0 ko0Var, ke0 ke0Var) {
        Object[] objArr = new ko0[16];
        if (!ko0Var.a.w) {
            z01.b("visitChildren called on an unattached node");
        }
        pm1 pm1Var = new pm1(new dk1[16]);
        dk1 dk1Var = ko0Var.a;
        dk1 dk1Var2 = dk1Var.i;
        if (dk1Var2 == null) {
            cm4.a(pm1Var, dk1Var);
        } else {
            pm1Var.b(dk1Var2);
        }
        int i = 0;
        while (true) {
            int i2 = pm1Var.c;
            if (i2 == 0) {
                break;
            }
            dk1 dk1VarB = (dk1) pm1Var.l(i2 - 1);
            if ((dk1VarB.e & 1024) == 0) {
                cm4.a(pm1Var, dk1VarB);
            } else {
                while (dk1VarB != null) {
                    if ((dk1VarB.c & 1024) != 0) {
                        pm1 pm1Var2 = null;
                        while (dk1VarB != null) {
                            if (dk1VarB instanceof ko0) {
                                ko0 ko0Var2 = (ko0) dk1VarB;
                                int i3 = i + 1;
                                if (objArr.length < i3) {
                                    int length = objArr.length;
                                    Object[] objArr2 = new Object[Math.max(i3, length * 2)];
                                    System.arraycopy(objArr, 0, objArr2, 0, length);
                                    objArr = objArr2;
                                }
                                objArr[i] = ko0Var2;
                                i = i3;
                            } else if ((dk1VarB.c & 1024) != 0 && (dk1VarB instanceof zb0)) {
                                int i4 = 0;
                                for (dk1 dk1Var3 = ((zb0) dk1VarB).H; dk1Var3 != null; dk1Var3 = dk1Var3.i) {
                                    if ((dk1Var3.c & 1024) != 0) {
                                        i4++;
                                        if (i4 == 1) {
                                            dk1VarB = dk1Var3;
                                        } else {
                                            if (pm1Var2 == null) {
                                                pm1Var2 = new pm1(new dk1[16]);
                                            }
                                            if (dk1VarB != null) {
                                                pm1Var2.b(dk1VarB);
                                                dk1VarB = null;
                                            }
                                            pm1Var2.b(dk1Var3);
                                        }
                                    }
                                }
                                if (i4 == 1) {
                                }
                            }
                            dk1VarB = cm4.b(pm1Var2);
                        }
                        break;
                    }
                    dk1VarB = dk1VarB.i;
                }
            }
        }
        Arrays.sort(objArr, 0, i, lo0.b);
        for (int i5 = 0; i5 < i; i5++) {
            ko0 ko0Var3 = (ko0) objArr[i5];
            if (xn4.d(ko0Var3) && b(ko0Var3, ke0Var)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x014a  */
    /* JADX WARN: Code duplicated, block: B:129:0x019a  */
    /* JADX WARN: Code duplicated, block: B:158:0x0148 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:166:0x0185 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:87:0x011f  */
    /* JADX WARN: Code duplicated, block: B:90:0x012e  */
    /* JADX WARN: Code duplicated, block: B:92:0x0138 A[ADDED_TO_REGION, LOOP:6: B:92:0x0138->B:120:0x0185, LOOP_START, PHI: r13
      0x0138: PHI (r13v12 dk1) = (r13v7 dk1), (r13v13 dk1) binds: [B:91:0x0136, B:120:0x0185] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:93:0x013a  */
    /* JADX WARN: Code duplicated, block: B:95:0x0140  */
    /* JADX WARN: Code duplicated, block: B:97:0x0144  */
    public static final boolean f(ko0 ko0Var, ko0 ko0Var2, int i, ke0 ke0Var) {
        dk1 dk1Var;
        dk1 dk1Var2;
        n71 n71VarG;
        zn1 zn1Var;
        dk1 dk1VarB;
        pm1 pm1Var;
        if (ko0Var.N0() != jo0.b) {
            og.n("This function should only be used within a parent that has focus.");
            return false;
        }
        Object[] objArr = new ko0[16];
        if (!ko0Var.a.w) {
            z01.b("visitChildren called on an unattached node");
        }
        pm1 pm1Var2 = new pm1(new dk1[16]);
        dk1 dk1Var3 = ko0Var.a;
        dk1 dk1Var4 = dk1Var3.i;
        if (dk1Var4 == null) {
            cm4.a(pm1Var2, dk1Var3);
        } else {
            pm1Var2.b(dk1Var4);
        }
        int i2 = 0;
        while (true) {
            int i3 = pm1Var2.c;
            dk1Var = null;
            if (i3 == 0) {
                break;
            }
            dk1 dk1VarB2 = (dk1) pm1Var2.l(i3 - 1);
            if ((dk1VarB2.e & 1024) == 0) {
                cm4.a(pm1Var2, dk1VarB2);
            } else {
                while (dk1VarB2 != null) {
                    if ((dk1VarB2.c & 1024) != 0) {
                        pm1 pm1Var3 = null;
                        while (dk1VarB2 != null) {
                            if (dk1VarB2 instanceof ko0) {
                                ko0 ko0Var3 = (ko0) dk1VarB2;
                                int i4 = i2 + 1;
                                if (objArr.length < i4) {
                                    int length = objArr.length;
                                    Object[] objArr2 = new Object[Math.max(i4, length * 2)];
                                    System.arraycopy(objArr, 0, objArr2, 0, length);
                                    objArr = objArr2;
                                }
                                objArr[i2] = ko0Var3;
                                i2 = i4;
                            } else if ((dk1VarB2.c & 1024) != 0 && (dk1VarB2 instanceof zb0)) {
                                int i5 = 0;
                                for (dk1 dk1Var5 = ((zb0) dk1VarB2).H; dk1Var5 != null; dk1Var5 = dk1Var5.i) {
                                    if ((dk1Var5.c & 1024) != 0) {
                                        i5++;
                                        if (i5 == 1) {
                                            dk1VarB2 = dk1Var5;
                                        } else {
                                            if (pm1Var3 == null) {
                                                pm1Var3 = new pm1(new dk1[16]);
                                            }
                                            if (dk1VarB2 != null) {
                                                pm1Var3.b(dk1VarB2);
                                                dk1VarB2 = null;
                                            }
                                            pm1Var3.b(dk1Var5);
                                        }
                                    }
                                }
                                if (i5 == 1) {
                                }
                            }
                            dk1VarB2 = cm4.b(pm1Var3);
                        }
                        break;
                    }
                    dk1VarB2 = dk1VarB2.i;
                }
            }
        }
        Arrays.sort(objArr, 0, i2, lo0.b);
        if (i != 1) {
            if (i != 2) {
                og.n("This function should only be used for 1-D focus search");
                return false;
            }
            h21 h21VarF = ky3.f(0, i2);
            int i6 = h21VarF.a;
            int i7 = h21VarF.b;
            if (i6 <= i7) {
                boolean z = false;
                while (true) {
                    if (z) {
                        ko0 ko0Var4 = (ko0) objArr[i7];
                        if (xn4.d(ko0Var4) && a(ko0Var4, ke0Var)) {
                            return true;
                        }
                    }
                    if (g31.a(objArr[i7], ko0Var2)) {
                        z = true;
                    }
                    if (i7 == i6) {
                        break;
                    }
                    i7--;
                }
            }
            if (i != 1) {
                if (!ko0Var.a.w) {
                    z01.b("visitAncestors called on an unattached node");
                }
                dk1Var2 = ko0Var.a.f;
                n71VarG = cm4.g(ko0Var);
                loop5: while (n71VarG != null) {
                    if ((n71VarG.o0.f.e & 1024) != 0) {
                        while (dk1Var2 != null) {
                            if ((dk1Var2.c & 1024) != 0) {
                                dk1VarB = dk1Var2;
                                pm1Var = null;
                                while (dk1VarB != null) {
                                    if (dk1VarB instanceof ko0) {
                                        dk1Var = dk1VarB;
                                        break loop5;
                                    }
                                    if ((dk1VarB.c & 1024) == 0) {
                                    }
                                    dk1VarB = cm4.b(pm1Var);
                                }
                            }
                            dk1Var2 = dk1Var2.f;
                        }
                    }
                    n71VarG = n71VarG.u();
                    if (n71VarG != null) {
                    }
                }
                if (dk1Var != null) {
                    return ((Boolean) ke0Var.j(ko0Var)).booleanValue();
                }
            }
            return false;
        }
        h21 h21VarF2 = ky3.f(0, i2);
        int i8 = h21VarF2.a;
        int i9 = h21VarF2.b;
        if (i8 <= i9) {
            boolean z2 = false;
            while (true) {
                if (z2) {
                    ko0 ko0Var5 = (ko0) objArr[i8];
                    if (xn4.d(ko0Var5) && b(ko0Var5, ke0Var)) {
                        return true;
                    }
                }
                if (g31.a(objArr[i8], ko0Var2)) {
                    z2 = true;
                }
                if (i8 == i9) {
                    break;
                }
                i8++;
            }
        }
        if (i != 1 && ko0Var.K0().a) {
            if (!ko0Var.a.w) {
                z01.b("visitAncestors called on an unattached node");
            }
            dk1Var2 = ko0Var.a.f;
            n71VarG = cm4.g(ko0Var);
            loop5: while (n71VarG != null) {
                if ((n71VarG.o0.f.e & 1024) != 0) {
                    while (dk1Var2 != null) {
                        if ((dk1Var2.c & 1024) != 0) {
                            dk1VarB = dk1Var2;
                            pm1Var = null;
                            while (dk1VarB != null) {
                                if (dk1VarB instanceof ko0) {
                                    dk1Var = dk1VarB;
                                    break loop5;
                                }
                                if ((dk1VarB.c & 1024) == 0 && (dk1VarB instanceof zb0)) {
                                    int i10 = 0;
                                    for (dk1 dk1Var6 = ((zb0) dk1VarB).H; dk1Var6 != null; dk1Var6 = dk1Var6.i) {
                                        if ((dk1Var6.c & 1024) != 0) {
                                            i10++;
                                            if (i10 == 1) {
                                                dk1VarB = dk1Var6;
                                            } else {
                                                if (pm1Var == null) {
                                                    pm1Var = new pm1(new dk1[16]);
                                                }
                                                if (dk1VarB != null) {
                                                    pm1Var.b(dk1VarB);
                                                    dk1VarB = null;
                                                }
                                                pm1Var.b(dk1Var6);
                                            }
                                        }
                                    }
                                    if (i10 == 1) {
                                    }
                                }
                                dk1VarB = cm4.b(pm1Var);
                            }
                        }
                        dk1Var2 = dk1Var2.f;
                    }
                }
                n71VarG = n71VarG.u();
                dk1Var2 = (n71VarG != null || (zn1Var = n71VarG.o0) == null) ? null : zn1Var.e;
            }
            if (dk1Var != null) {
                return ((Boolean) ke0Var.j(ko0Var)).booleanValue();
            }
        }
        return false;
    }
}
