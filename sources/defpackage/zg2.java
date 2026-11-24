package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class zg2 extends ah2 {
    public static Object b(xg2 xg2Var) {
        Iterator it = xg2Var.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static xg2 c(Object obj, hq0 hq0Var) {
        return obj == null ? li0.a : new au0(0, new kb(19, obj), hq0Var);
    }

    public static String d(xg2 xg2Var, String str, va1 va1Var, int i) {
        if ((i & 32) != 0) {
            va1Var = null;
        }
        xg2Var.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append((CharSequence) "");
        int i2 = 0;
        for (Object obj : xg2Var) {
            i2++;
            if (i2 > 1) {
                sb.append((CharSequence) str);
            }
            ds2.a(sb, obj, va1Var);
        }
        sb.append((CharSequence) "");
        return sb.toString();
    }

    public static Object e(au0 au0Var) {
        zt0 zt0Var = new zt0(au0Var);
        if (!zt0Var.hasNext()) {
            return null;
        }
        Object next = zt0Var.next();
        while (zt0Var.hasNext()) {
            next = zt0Var.next();
        }
        return next;
    }

    public static vl0 f(xg2 xg2Var, hq0 hq0Var) {
        return new vl0(new au0(3, xg2Var, hq0Var), false, new sa2(26));
    }

    public static xg2 g(Object... objArr) {
        return objArr.length == 0 ? li0.a : new rg(0, objArr);
    }

    public static List h(xg2 xg2Var) {
        Iterator it = xg2Var.iterator();
        if (!it.hasNext()) {
            return ii0.a;
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return nz.h(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
