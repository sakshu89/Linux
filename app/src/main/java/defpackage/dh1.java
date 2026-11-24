package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class dh1 extends h1 {
    public final /* synthetic */ int a = 0;
    public final Object b;

    public dh1(List list) {
        list.getClass();
        this.b = list;
    }

    @Override // defpackage.y0
    public final int a() {
        int i = this.a;
        Object obj = this.b;
        switch (i) {
            case 0:
                return ((fh1) obj).a.groupCount() + 1;
            default:
                return ((List) obj).size();
        }
    }

    @Override // defpackage.y0, java.util.Collection, java.util.List
    public /* bridge */ boolean contains(Object obj) {
        switch (this.a) {
            case 0:
                if (obj instanceof String) {
                    return super.contains((String) obj);
                }
                return false;
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.List
    public final Object get(int i) {
        int i2 = this.a;
        Object obj = this.b;
        switch (i2) {
            case 0:
                String strGroup = ((fh1) obj).a.group(i);
                return strGroup == null ? "" : strGroup;
            default:
                List list = (List) obj;
                if (i >= 0 && i <= nz.g(this)) {
                    return list.get(nz.g(this) - i);
                }
                StringBuilder sbP = ky0.p("Element index ", i, " must be in range [");
                sbP.append(new h21(0, nz.g(this), 1));
                sbP.append("].");
                throw new IndexOutOfBoundsException(sbP.toString());
        }
    }

    @Override // defpackage.h1, java.util.List
    public /* bridge */ int indexOf(Object obj) {
        switch (this.a) {
            case 0:
                if (obj instanceof String) {
                    return super.indexOf((String) obj);
                }
                return -1;
            default:
                return super.indexOf(obj);
        }
    }

    @Override // defpackage.h1, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        switch (this.a) {
            case 1:
                return new t72(this, 0);
            default:
                return super.iterator();
        }
    }

    @Override // defpackage.h1, java.util.List
    public /* bridge */ int lastIndexOf(Object obj) {
        switch (this.a) {
            case 0:
                if (obj instanceof String) {
                    return super.lastIndexOf((String) obj);
                }
                return -1;
            default:
                return super.lastIndexOf(obj);
        }
    }

    @Override // defpackage.h1, java.util.List
    public ListIterator listIterator() {
        switch (this.a) {
            case 1:
                return new t72(this, 0);
            default:
                return super.listIterator();
        }
    }

    public dh1(fh1 fh1Var) {
        this.b = fh1Var;
    }

    @Override // defpackage.h1, java.util.List
    public ListIterator listIterator(int i) {
        switch (this.a) {
            case 1:
                return new t72(this, i);
            default:
                return super.listIterator(i);
        }
    }
}
