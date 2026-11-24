package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class er4 {
    public static final ArrayList a(z21 z21Var) {
        z21Var.getClass();
        n71 n71VarC0 = ((mf1) z21Var).C0();
        boolean zB = b(n71VarC0);
        wl1 wl1Var = (wl1) n71VarC0.o();
        pm1 pm1Var = (pm1) wl1Var.b;
        ArrayList arrayList = new ArrayList(pm1Var.c);
        int i = pm1Var.c;
        for (int i2 = 0; i2 < i; i2++) {
            n71 n71Var = (n71) wl1Var.get(i2);
            arrayList.add(zB ? n71Var.l() : n71Var.m());
        }
        return arrayList;
    }

    public static final boolean b(n71 n71Var) {
        int iOrdinal = n71Var.p0.d.ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                if (iOrdinal != 2) {
                    if (iOrdinal != 3) {
                        if (iOrdinal != 4) {
                            dk0.l();
                            return false;
                        }
                        n71 n71VarU = n71Var.u();
                        if (n71VarU != null) {
                            return b(n71VarU);
                        }
                        og.i("no parent for idle node");
                        return false;
                    }
                }
            }
            return true;
        }
        return false;
    }
}
