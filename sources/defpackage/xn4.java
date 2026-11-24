package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class xn4 {
    public static final ko0 a(ko0 ko0Var) {
        ko0 ko0VarF = ((do0) ((r7) cm4.h(ko0Var)).getFocusOwner()).f();
        if (ko0VarF == null || !ko0VarF.w) {
            return null;
        }
        return ko0VarF;
    }

    public static final l42 b(ko0 ko0Var) {
        co1 co1Var;
        if (ko0Var.w && (co1Var = ko0Var.k) != null) {
            y61 y61VarC = pp4.c(co1Var);
            if (!y61VarC.B()) {
                y61VarC = null;
            }
            if (y61VarC != null) {
                return ko0Var.L0(y61VarC);
            }
        }
        return l42.e;
    }

    public static final ko0 c(ko0 ko0Var) {
        boolean z = ko0Var.a.w;
        if (z) {
            if (!z) {
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
            while (true) {
                int i = pm1Var.c;
                if (i == 0) {
                    break;
                }
                dk1 dk1VarB = (dk1) pm1Var.l(i - 1);
                if ((dk1VarB.e & 1024) == 0) {
                    cm4.a(pm1Var, dk1VarB);
                } else {
                    while (dk1VarB != null) {
                        if ((dk1VarB.c & 1024) != 0) {
                            pm1 pm1Var2 = null;
                            while (dk1VarB != null) {
                                if (dk1VarB instanceof ko0) {
                                    ko0 ko0Var2 = (ko0) dk1VarB;
                                    if (ko0Var2.a.w) {
                                        int iOrdinal = ko0Var2.N0().ordinal();
                                        if (iOrdinal == 0 || iOrdinal == 1 || iOrdinal == 2) {
                                            return ko0Var2;
                                        }
                                        if (iOrdinal != 3) {
                                            dk0.l();
                                            return null;
                                        }
                                    }
                                } else if ((dk1VarB.c & 1024) != 0 && (dk1VarB instanceof zb0)) {
                                    int i2 = 0;
                                    for (dk1 dk1Var3 = ((zb0) dk1VarB).H; dk1Var3 != null; dk1Var3 = dk1Var3.i) {
                                        if ((dk1Var3.c & 1024) != 0) {
                                            i2++;
                                            if (i2 == 1) {
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
                                    if (i2 == 1) {
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
        }
        return null;
    }

    public static final boolean d(ko0 ko0Var) {
        n71 n71Var;
        co1 co1Var;
        n71 n71Var2;
        co1 co1Var2 = ko0Var.k;
        return (co1Var2 == null || (n71Var = co1Var2.x) == null || !n71Var.I() || (co1Var = ko0Var.k) == null || (n71Var2 = co1Var.x) == null || !n71Var2.H()) ? false : true;
    }
}
