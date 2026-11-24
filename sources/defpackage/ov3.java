package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ov3 {
    public final Object a;

    public ov3(int i) {
        switch (i) {
            case 2:
                this.a = new HashMap();
                break;
            default:
                this.a = new ArrayList();
                break;
        }
    }

    public boolean a(int i, nv0 nv0Var, Object obj) {
        ArrayList arrayList = nv0Var.a;
        if (arrayList == null) {
            b(i, nv0Var, null);
            return true;
        }
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            Object obj2 = arrayList.get(i2);
            if (!(obj2 instanceof j6)) {
                if (!(obj2 instanceof nv0)) {
                    og.h(obj2, "Unexpected child source info ");
                    break;
                }
                if (a(i, (nv0) obj2, obj)) {
                    b(0, nv0Var, obj2);
                    return true;
                }
            } else if (obj2 == obj) {
                b(0, nv0Var, obj2);
                return true;
            }
        }
        return false;
    }

    public void b(int i, nv0 nv0Var, Object obj) {
        ((ArrayList) this.a).add(new m20(i, null, null));
    }

    public abstract Object c(Object obj);

    public Object d(Object obj) {
        synchronized (((HashMap) this.a)) {
            try {
                if (((HashMap) this.a).containsKey(obj)) {
                    return ((HashMap) this.a).get(obj);
                }
                Object objC = c(obj);
                ((HashMap) this.a).put(obj, objC);
                return objC;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void e(int i, Object obj, nv0 nv0Var, Object obj2) {
        if (g31.a(obj, r20.a)) {
            b(i, nv0Var, null);
        }
    }

    public abstract double f(long j, Object obj);

    public abstract float g(long j, Object obj);

    public abstract void h(Object obj, long j, boolean z);

    public abstract void i(Object obj, long j, byte b);

    public abstract void j(Object obj, long j, double d);

    public abstract void k(Object obj, long j, float f);

    public abstract boolean l(long j, Object obj);

    public ov3(Unsafe unsafe) {
        this.a = unsafe;
    }
}
