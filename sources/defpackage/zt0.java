package defpackage;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class zt0 implements Iterator, x41 {
    public final /* synthetic */ int a;
    public int b;
    public Object c;
    public final Object e;

    public zt0(jm1 jm1Var) {
        this.a = 2;
        this.e = jm1Var;
        this.b = -1;
        this.c = ah2.a(new im1(jm1Var, this, null));
    }

    public void a() {
        Object objJ;
        int i = this.b;
        au0 au0Var = (au0) this.e;
        if (i == -2) {
            objJ = ((fq0) au0Var.b).a();
        } else {
            hq0 hq0Var = (hq0) au0Var.c;
            Object obj = this.c;
            obj.getClass();
            objJ = hq0Var.j(obj);
        }
        this.c = objJ;
        this.b = objJ == null ? 0 : 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.a;
        Object obj = this.e;
        switch (i) {
            case 0:
                if (this.b < 0) {
                    a();
                }
                return this.b == 1;
            case 1:
                return ((yg2) this.c).hasNext();
            case 2:
                return ((yg2) this.c).hasNext();
            case 3:
                return this.b < ((Map) obj).size();
            default:
                rs2 rs2Var = (rs2) obj;
                Iterator it = (Iterator) this.c;
                while (this.b < rs2Var.b && it.hasNext()) {
                    it.next();
                    this.b++;
                }
                return this.b < rs2Var.c && it.hasNext();
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.a;
        Object obj = this.e;
        Object obj2 = null;
        switch (i) {
            case 0:
                if (this.b < 0) {
                    a();
                }
                if (this.b == 0) {
                    dk0.d();
                    return null;
                }
                Object obj3 = this.c;
                obj3.getClass();
                this.b = -1;
                return obj3;
            case 1:
                return ((yg2) this.c).next();
            case 2:
                return ((yg2) this.c).next();
            case 3:
                if (hasNext()) {
                    obj2 = this.c;
                    this.b++;
                    Object obj4 = ((Map) obj).get(obj2);
                    if (obj4 == null) {
                        throw new ConcurrentModificationException("Hash code of an element (" + obj2 + ") has changed after it was added to the persistent set.");
                    }
                    this.c = ((oc1) obj4).b;
                } else {
                    dk0.d();
                }
                return obj2;
            default:
                rs2 rs2Var = (rs2) obj;
                Iterator it = (Iterator) this.c;
                while (this.b < rs2Var.b && it.hasNext()) {
                    it.next();
                    this.b++;
                }
                int i2 = this.b;
                if (i2 < rs2Var.c) {
                    this.b = i2 + 1;
                    return it.next();
                }
                dk0.d();
                return null;
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        int i = this.a;
        Object obj = this.e;
        switch (i) {
            case 0:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            case 1:
                int i2 = this.b;
                if (i2 != -1) {
                    ((cm1) obj).b.h(i2);
                    this.b = -1;
                    return;
                }
                return;
            case 2:
                int i3 = this.b;
                if (i3 != -1) {
                    ((jm1) obj).b.m(i3);
                    this.b = -1;
                    return;
                }
                return;
            case 3:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            default:
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public zt0(rs2 rs2Var) {
        this.a = 4;
        this.e = rs2Var;
        this.c = rs2Var.a.iterator();
    }

    public zt0(au0 au0Var) {
        this.a = 0;
        this.e = au0Var;
        this.b = -2;
    }

    public zt0(Object obj, Map map) {
        this.a = 3;
        this.c = obj;
        this.e = map;
    }

    public zt0(cm1 cm1Var) {
        this.a = 1;
        this.e = cm1Var;
        this.b = -1;
        this.c = ah2.a(new bm1(cm1Var, this, null));
    }
}
