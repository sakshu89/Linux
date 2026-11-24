package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ej4 {
    public static final ArrayList a(l20 l20Var) {
        int[] iArr = {201, 202, 204, 206, 207, 125, -127, 126665345, 200};
        List list = l20Var.a;
        int size = list.size();
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i < size) {
            int i2 = i + 1;
            m20 m20Var = (m20) list.get(i);
            int i3 = m20Var.a;
            int i4 = 0;
            while (true) {
                if (i4 >= 9) {
                    i4 = -1;
                    break;
                }
                if (i3 == iArr[i4]) {
                    break;
                }
                i4++;
            }
            if (i4 < 0) {
                if (m20Var.a == 100) {
                    int i5 = i + 2;
                    if (i5 < size && ((m20) list.get(i5)).a == 1000) {
                        break;
                    }
                    if (!arrayList.isEmpty()) {
                        arrayList.remove(arrayList.size() - 1);
                    }
                } else {
                    arrayList.add(m20Var);
                }
            }
            i = i2;
        }
        return arrayList;
    }

    public static final boolean b(Throwable th, fq0 fq0Var) throws IllegalAccessException, InvocationTargetException {
        List listAsList;
        Object objInvoke;
        th.getClass();
        Integer num = z31.a;
        yc0 yc0Var = null;
        if (num == null || num.intValue() >= 19) {
            Throwable[] suppressed = th.getSuppressed();
            suppressed.getClass();
            listAsList = Arrays.asList(suppressed);
            listAsList.getClass();
        } else {
            Method method = fx1.b;
            if (method == null || (objInvoke = method.invoke(th, null)) == null) {
                listAsList = ii0.a;
            } else {
                listAsList = Arrays.asList((Throwable[]) objInvoke);
                listAsList.getClass();
            }
        }
        int size = listAsList.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            if (((Throwable) listAsList.get(i)) instanceof yc0) {
                return false;
            }
        }
        try {
            l20 l20Var = (l20) fq0Var.a();
            if (l20Var != null && !l20Var.a.isEmpty()) {
                z = true;
            }
            if (z) {
                l20Var.getClass();
                yc0Var = new yc0(l20Var);
            }
        } catch (Throwable th2) {
            yc0Var = th2;
        }
        if (yc0Var != null) {
            gn4.a(th, yc0Var);
        }
        return z;
    }
}
