package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class wn4 {
    public static final boolean a(ko0 ko0Var, boolean z) {
        int iOrdinal = ko0Var.N0().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                ko0 ko0VarC = xn4.c(ko0Var);
                if (!(ko0VarC != null ? a(ko0VarC, z) : true)) {
                    return false;
                }
                ko0Var.J0(jo0.b, jo0.c);
                return true;
            }
            if (iOrdinal == 2) {
                return z;
            }
            if (iOrdinal != 3) {
                dk0.l();
                return false;
            }
        }
        return true;
    }

    public static final m80 b(ko0 ko0Var) {
        int iOrdinal = ko0Var.N0().ordinal();
        m80 m80Var = m80.a;
        if (iOrdinal != 0) {
            m80 m80Var2 = m80.b;
            if (iOrdinal == 1) {
                ko0 ko0VarC = xn4.c(ko0Var);
                if (ko0VarC == null) {
                    og.i("ActiveParent with no focused child");
                    return null;
                }
                m80 m80VarB = b(ko0VarC);
                m80 m80Var3 = m80VarB != m80Var ? m80VarB : null;
                if (m80Var3 != null) {
                    return m80Var3;
                }
                if (ko0Var.H) {
                    return m80Var;
                }
                ko0Var.H = true;
                try {
                    eo0 eo0VarK0 = ko0Var.K0();
                    do0 do0Var = (do0) ((r7) cm4.h(ko0Var)).getFocusOwner();
                    ko0 ko0VarF = do0Var.f();
                    eo0VarK0.k.getClass();
                    ko0 ko0VarF2 = do0Var.f();
                    if (ko0VarF == ko0VarF2 || ko0VarF2 == null) {
                        return m80Var;
                    }
                    return fo0.d == fo0.c ? m80Var2 : m80.c;
                } finally {
                    ko0Var.H = false;
                }
            }
            if (iOrdinal == 2) {
                return m80Var2;
            }
            if (iOrdinal != 3) {
                dk0.l();
                return null;
            }
        }
        return m80Var;
    }

    public static final m80 c(ko0 ko0Var) {
        if (!ko0Var.X) {
            ko0Var.X = true;
            try {
                eo0 eo0VarK0 = ko0Var.K0();
                do0 do0Var = (do0) ((r7) cm4.h(ko0Var)).getFocusOwner();
                ko0 ko0VarF = do0Var.f();
                eo0VarK0.j.getClass();
                ko0 ko0VarF2 = do0Var.f();
                if (ko0VarF != ko0VarF2 && ko0VarF2 != null) {
                    return fo0.d == fo0.c ? m80.b : m80.c;
                }
            } finally {
                ko0Var.X = false;
            }
        }
        return m80.a;
    }

    public static final m80 d(ko0 ko0Var) {
        dk1 dk1VarB;
        zn1 zn1Var;
        int iOrdinal = ko0Var.N0().ordinal();
        m80 m80Var = m80.a;
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                ko0 ko0VarC = xn4.c(ko0Var);
                if (ko0VarC != null) {
                    return b(ko0VarC);
                }
                og.i("ActiveParent with no focused child");
                return null;
            }
            if (iOrdinal != 2) {
                if (iOrdinal != 3) {
                    dk0.l();
                    return null;
                }
                if (!ko0Var.a.w) {
                    z01.b("visitAncestors called on an unattached node");
                }
                dk1 dk1Var = ko0Var.a.f;
                n71 n71VarG = cm4.g(ko0Var);
                loop0: while (true) {
                    if (n71VarG == null) {
                        dk1VarB = null;
                        break;
                    }
                    if ((n71VarG.o0.f.e & 1024) != 0) {
                        while (dk1Var != null) {
                            if ((dk1Var.c & 1024) != 0) {
                                dk1VarB = dk1Var;
                                pm1 pm1Var = null;
                                while (dk1VarB != null) {
                                    if (dk1VarB instanceof ko0) {
                                        break loop0;
                                    }
                                    if ((dk1VarB.c & 1024) != 0 && (dk1VarB instanceof zb0)) {
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
                ko0 ko0Var2 = (ko0) dk1VarB;
                if (ko0Var2 == null) {
                    return m80Var;
                }
                int iOrdinal2 = ko0Var2.N0().ordinal();
                if (iOrdinal2 == 0) {
                    return c(ko0Var2);
                }
                if (iOrdinal2 == 1) {
                    return d(ko0Var2);
                }
                if (iOrdinal2 == 2) {
                    return m80.b;
                }
                if (iOrdinal2 != 3) {
                    dk0.l();
                    return null;
                }
                m80 m80VarD = d(ko0Var2);
                m80 m80Var2 = m80VarD != m80Var ? m80VarD : null;
                return m80Var2 == null ? c(ko0Var2) : m80Var2;
            }
        }
        return m80Var;
    }
}
