package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class yi4 {
    public static final int a(int i, int i2) {
        return i << (((i2 % 10) * 3) + 1);
    }

    public static final w10 b(int i, rq0 rq0Var, x20 x20Var) {
        Object objL = x20Var.L();
        if (objL == r20.a) {
            objL = new w10(i, true, rq0Var);
            x20Var.g0(objL);
        }
        w10 w10Var = (w10) objL;
        if (!w10Var.c.equals(rq0Var)) {
            w10Var.c = rq0Var;
            if (w10Var.b) {
                a42 a42Var = w10Var.e;
                if (a42Var != null) {
                    g30 g30Var = a42Var.a;
                    if (g30Var != null) {
                        g30Var.s(a42Var, null);
                    }
                    w10Var.e = null;
                }
                ArrayList arrayList = w10Var.f;
                if (arrayList != null) {
                    int size = arrayList.size();
                    for (int i2 = 0; i2 < size; i2++) {
                        a42 a42Var2 = (a42) arrayList.get(i2);
                        g30 g30Var2 = a42Var2.a;
                        if (g30Var2 != null) {
                            g30Var2.s(a42Var2, null);
                        }
                    }
                    arrayList.clear();
                }
            }
        }
        return w10Var;
    }
}
