package defpackage;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class lh4 {
    public static final Object a(j70 j70Var, Object obj, Object obj2, vq0 vq0Var, x50 x50Var) {
        Object objE;
        Object objE2 = ab4.e(j70Var, obj2);
        try {
            wq2 wq2Var = new wq2(x50Var, j70Var);
            if (vq0Var == null) {
                objE = fp4.c(vq0Var, obj, wq2Var);
            } else {
                h33.c(2, vq0Var);
                objE = vq0Var.e(obj, wq2Var);
            }
            ab4.a(j70Var, objE2);
            if (objE == t70.a) {
                x50Var.getClass();
            }
            return objE;
        } catch (Throwable th) {
            ab4.a(j70Var, objE2);
            throw th;
        }
    }

    public static boolean b(cx3 cx3Var, Collection collection) {
        collection.getClass();
        if (collection instanceof o04) {
            collection = ((o04) collection).zza();
        }
        boolean zRemove = false;
        if (!(collection instanceof Set) || collection.size() <= cx3Var.size()) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                zRemove |= cx3Var.remove(it.next());
            }
            return zRemove;
        }
        Iterator<E> it2 = cx3Var.iterator();
        while (it2.hasNext()) {
            if (collection.contains(it2.next())) {
                it2.remove();
                zRemove = true;
            }
        }
        return zRemove;
    }
}
