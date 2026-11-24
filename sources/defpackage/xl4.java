package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class xl4 {
    /* JADX WARN: Code duplicated, block: B:27:0x0069  */
    /* JADX WARN: Code duplicated, block: B:37:0x008f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0092  */
    /* JADX WARN: Code duplicated, block: B:43:0x0091 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:45:? A[LOOP:0: B:25:0x0063->B:45:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0080 -> B:25:0x0063). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0083 -> B:25:0x0063). Please report as a decompilation issue!!! */
    public static final Object a(List list, f90 f90Var, y50 y50Var) throws Throwable {
        z80 z80Var;
        List list2;
        t42 t42Var;
        Iterator it;
        Throwable th;
        hq0 hq0Var;
        if (y50Var instanceof z80) {
            z80Var = (z80) y50Var;
            int i = z80Var.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                z80Var.j = i - Integer.MIN_VALUE;
            } else {
                z80Var = new z80(y50Var);
            }
        } else {
            z80Var = new z80(y50Var);
        }
        Object obj = z80Var.i;
        int i2 = z80Var.j;
        Object obj2 = t70.a;
        if (i2 != 0) {
            if (i2 == 1) {
                list2 = (List) z80Var.e;
                bz3.g(obj);
            } else {
                if (i2 != 2) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                it = z80Var.f;
                t42Var = (t42) z80Var.e;
                try {
                    bz3.g(obj);
                } catch (Throwable th2) {
                    Object obj3 = t42Var.a;
                    if (obj3 == null) {
                        t42Var.a = th2;
                    } else {
                        gn4.a((Throwable) obj3, th2);
                    }
                }
            }
            while (it.hasNext()) {
                hq0Var = (hq0) it.next();
                z80Var.e = t42Var;
                z80Var.f = it;
                z80Var.j = 2;
                if (hq0Var.j(z80Var) == obj2) {
                    return obj2;
                }
            }
            th = (Throwable) t42Var.a;
            if (th == null) {
                return q43.a;
            }
            throw th;
        }
        bz3.g(obj);
        ArrayList arrayList = new ArrayList();
        z9 z9Var = new z9(list, arrayList, null);
        z80Var.e = arrayList;
        z80Var.j = 1;
        if (f90Var.a(z9Var, z80Var) == obj2) {
            return obj2;
        }
        list2 = arrayList;
        t42Var = new t42();
        it = list2.iterator();
        while (it.hasNext()) {
            hq0Var = (hq0) it.next();
            z80Var.e = t42Var;
            z80Var.f = it;
            z80Var.j = 2;
            if (hq0Var.j(z80Var) == obj2) {
                return obj2;
            }
        }
        th = (Throwable) t42Var.a;
        if (th == null) {
            return q43.a;
        }
        throw th;
    }
}
