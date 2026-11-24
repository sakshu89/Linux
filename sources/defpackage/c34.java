package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class c34 {
    public static qt1 a(int i) {
        float f = (i & 2) != 0 ? 0.0f : 6.0f;
        return new qt1(0.0f, f, 0.0f, f);
    }

    /* JADX WARN: Code duplicated, block: B:35:0x0061 A[LOOP:0: B:4:0x000b->B:35:0x0061, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:43:0x0064 A[EDGE_INSN: B:43:0x0064->B:36:0x0064 BREAK  A[LOOP:0: B:4:0x000b->B:35:0x0061], SYNTHETIC] */
    public static final gg2 b(n71 n71Var, boolean z) {
        dk1 dk1Var = n71Var.o0.f;
        xb0 xb0Var = null;
        if ((dk1Var.e & 8) != 0) {
            loop0: while (dk1Var != null) {
                if ((dk1Var.c & 8) == 0) {
                    if ((dk1Var.e & 8) != 0) {
                        break;
                        break;
                    }
                    dk1Var = dk1Var.i;
                } else {
                    dk1 dk1VarB = dk1Var;
                    pm1 pm1Var = null;
                    while (dk1VarB != null) {
                        if (dk1VarB instanceof eg2) {
                            xb0Var = dk1VarB;
                            break loop0;
                        }
                        if ((dk1VarB.c & 8) != 0 && (dk1VarB instanceof zb0)) {
                            int i = 0;
                            for (dk1 dk1Var2 = ((zb0) dk1VarB).H; dk1Var2 != null; dk1Var2 = dk1Var2.i) {
                                if ((dk1Var2.c & 8) != 0) {
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
                    if ((dk1Var.e & 8) != 0) {
                        break;
                    }
                    dk1Var = dk1Var.i;
                }
            }
        }
        xb0Var.getClass();
        dk1 dk1Var3 = ((dk1) ((eg2) xb0Var)).a;
        cg2 cg2VarW = n71Var.w();
        if (cg2VarW == null) {
            cg2VarW = new cg2();
        }
        return new gg2(dk1Var3, z, n71Var, cg2VarW);
    }

    public static final ek1 c(ek1 ek1Var, float f) {
        return ek1Var.c(new nt1(f, f, f, f));
    }

    public static final ek1 d(ek1 ek1Var, float f, float f2) {
        return ek1Var.c(new nt1(f, f2, f, f2));
    }

    public static ek1 e(ek1 ek1Var, float f, float f2, int i) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        return d(ek1Var, f, f2);
    }

    public static ek1 f(ek1 ek1Var, float f, float f2, float f3, int i) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        if ((i & 8) != 0) {
            f3 = 0.0f;
        }
        return ek1Var.c(new nt1(0.0f, f, f2, f3));
    }
}
