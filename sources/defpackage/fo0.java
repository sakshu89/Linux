package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fo0 {
    public static final fo0 b = new fo0();
    public static final fo0 c = new fo0();
    public static final fo0 d = new fo0();
    public final pm1 a = new pm1(new ho0[16]);

    public static void a(fo0 fo0Var) {
        fo0Var.getClass();
        if (fo0Var == b) {
            og.n("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n");
            return;
        }
        if (fo0Var == c) {
            og.n("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n");
            return;
        }
        pm1 pm1Var = fo0Var.a;
        int i = pm1Var.c;
        if (i == 0) {
            System.out.println((Object) "FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
            return;
        }
        Object[] objArr = pm1Var.a;
        for (int i2 = 0; i2 < i; i2++) {
            xb0 xb0Var = (ho0) objArr[i2];
            if (!((dk1) xb0Var).a.w) {
                z01.b("visitChildren called on an unattached node");
            }
            pm1 pm1Var2 = new pm1(new dk1[16]);
            dk1 dk1Var = ((dk1) xb0Var).a;
            dk1 dk1Var2 = dk1Var.i;
            if (dk1Var2 == null) {
                cm4.a(pm1Var2, dk1Var);
            } else {
                pm1Var2.b(dk1Var2);
            }
            while (true) {
                int i3 = pm1Var2.c;
                if (i3 == 0) {
                    break;
                }
                dk1 dk1VarB = (dk1) pm1Var2.l(i3 - 1);
                if ((dk1VarB.e & 1024) == 0) {
                    cm4.a(pm1Var2, dk1VarB);
                } else {
                    while (dk1VarB != null) {
                        if ((dk1VarB.c & 1024) != 0) {
                            pm1 pm1Var3 = null;
                            while (dk1VarB != null) {
                                if (dk1VarB instanceof ko0) {
                                    if (((ko0) dk1VarB).P0(7)) {
                                        break;
                                    }
                                } else if ((dk1VarB.c & 1024) != 0 && (dk1VarB instanceof zb0)) {
                                    int i4 = 0;
                                    for (dk1 dk1Var3 = ((zb0) dk1VarB).H; dk1Var3 != null; dk1Var3 = dk1Var3.i) {
                                        if ((dk1Var3.c & 1024) != 0) {
                                            i4++;
                                            if (i4 == 1) {
                                                dk1VarB = dk1Var3;
                                            } else {
                                                if (pm1Var3 == null) {
                                                    pm1Var3 = new pm1(new dk1[16]);
                                                }
                                                if (dk1VarB != null) {
                                                    pm1Var3.b(dk1VarB);
                                                    dk1VarB = null;
                                                }
                                                pm1Var3.b(dk1Var3);
                                            }
                                        }
                                    }
                                    if (i4 == 1) {
                                    }
                                }
                                dk1VarB = cm4.b(pm1Var3);
                            }
                            break;
                        }
                        dk1VarB = dk1VarB.i;
                    }
                }
            }
        }
    }
}
