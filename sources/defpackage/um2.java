package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class um2 implements Parcelable, nr2, List, RandomAccess, y41 {
    public static final Parcelable.Creator<um2> CREATOR = new tm2(0);
    public mr2 a;

    public um2(n1 n1Var) {
        bm2 bm2VarJ = im2.j();
        mr2 mr2Var = new mr2(bm2VarJ.g(), n1Var);
        if (!(bm2VarJ instanceof hu0)) {
            mr2Var.b = new mr2(1L, n1Var);
        }
        this.a = mr2Var;
    }

    @Override // defpackage.nr2
    public final qr2 a() {
        return this.a;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean add(Object obj) {
        int i;
        n1 n1Var;
        bm2 bm2VarJ;
        boolean zB;
        do {
            synchronized (y44.a) {
                mr2 mr2Var = this.a;
                mr2Var.getClass();
                mr2 mr2Var2 = (mr2) im2.h(mr2Var);
                i = mr2Var2.d;
                n1Var = mr2Var2.c;
            }
            n1Var.getClass();
            n1 n1VarD = n1Var.d(obj);
            if (n1VarD.equals(n1Var)) {
                return false;
            }
            mr2 mr2Var3 = this.a;
            mr2Var3.getClass();
            synchronized (im2.c) {
                bm2VarJ = im2.j();
                zB = y44.b((mr2) im2.w(mr2Var3, this, bm2VarJ), i, n1VarD, true);
            }
            im2.n(bm2VarJ, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean addAll(Collection collection) {
        int i;
        n1 n1Var;
        bm2 bm2VarJ;
        boolean zB;
        do {
            synchronized (y44.a) {
                mr2 mr2Var = this.a;
                mr2Var.getClass();
                mr2 mr2Var2 = (mr2) im2.h(mr2Var);
                i = mr2Var2.d;
                n1Var = mr2Var2.c;
            }
            n1Var.getClass();
            n1 n1VarF = n1Var.f(collection);
            if (g31.a(n1VarF, n1Var)) {
                return false;
            }
            mr2 mr2Var3 = this.a;
            mr2Var3.getClass();
            synchronized (im2.c) {
                bm2VarJ = im2.j();
                zB = y44.b((mr2) im2.w(mr2Var3, this, bm2VarJ), i, n1VarF, true);
            }
            im2.n(bm2VarJ, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        bm2 bm2VarJ;
        mr2 mr2Var = this.a;
        mr2Var.getClass();
        synchronized (im2.c) {
            bm2VarJ = im2.j();
            mr2 mr2Var2 = (mr2) im2.w(mr2Var, this, bm2VarJ);
            synchronized (y44.a) {
                mr2Var2.c = sl2.b;
                mr2Var2.d++;
                mr2Var2.e++;
            }
        }
        im2.n(bm2VarJ, this);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean contains(Object obj) {
        return y44.c(this).c.contains(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean containsAll(Collection collection) {
        return y44.c(this).c.containsAll(collection);
    }

    @Override // defpackage.nr2
    public final void d(qr2 qr2Var) {
        qr2Var.b = this.a;
        this.a = (mr2) qr2Var;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final void f(int i, int i2) {
        int i3;
        n1 n1Var;
        bm2 bm2VarJ;
        boolean zB;
        do {
            synchronized (y44.a) {
                mr2 mr2Var = this.a;
                mr2Var.getClass();
                mr2 mr2Var2 = (mr2) im2.h(mr2Var);
                i3 = mr2Var2.d;
                n1Var = mr2Var2.c;
            }
            n1Var.getClass();
            rw1 rw1VarG = n1Var.g();
            rw1VarG.subList(i, i2).clear();
            n1 n1VarD = rw1VarG.d();
            if (g31.a(n1VarD, n1Var)) {
                return;
            }
            mr2 mr2Var3 = this.a;
            mr2Var3.getClass();
            synchronized (im2.c) {
                bm2VarJ = im2.j();
                zB = y44.b((mr2) im2.w(mr2Var3, this, bm2VarJ), i3, n1VarD, true);
            }
            im2.n(bm2VarJ, this);
        } while (!zB);
    }

    @Override // java.util.List
    public final Object get(int i) {
        return y44.c(this).c.get(i);
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return y44.c(this).c.indexOf(obj);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean isEmpty() {
        return y44.c(this).c.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return y44.c(this).c.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new nw0(this, 0);
    }

    @Override // java.util.List, java.util.Collection
    public final boolean remove(Object obj) {
        int i;
        n1 n1Var;
        bm2 bm2VarJ;
        boolean zB;
        do {
            synchronized (y44.a) {
                mr2 mr2Var = this.a;
                mr2Var.getClass();
                mr2 mr2Var2 = (mr2) im2.h(mr2Var);
                i = mr2Var2.d;
                n1Var = mr2Var2.c;
            }
            n1Var.getClass();
            int iIndexOf = n1Var.indexOf(obj);
            n1 n1VarI = iIndexOf != -1 ? n1Var.i(iIndexOf) : n1Var;
            if (n1VarI.equals(n1Var)) {
                return false;
            }
            mr2 mr2Var3 = this.a;
            mr2Var3.getClass();
            synchronized (im2.c) {
                bm2VarJ = im2.j();
                zB = y44.b((mr2) im2.w(mr2Var3, this, bm2VarJ), i, n1VarI, true);
            }
            im2.n(bm2VarJ, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean removeAll(Collection collection) {
        int i;
        n1 n1Var;
        bm2 bm2VarJ;
        boolean zB;
        do {
            synchronized (y44.a) {
                mr2 mr2Var = this.a;
                mr2Var.getClass();
                mr2 mr2Var2 = (mr2) im2.h(mr2Var);
                i = mr2Var2.d;
                n1Var = mr2Var2.c;
            }
            n1Var.getClass();
            n1 n1VarH = n1Var.h(new m1(0, collection));
            if (g31.a(n1VarH, n1Var)) {
                return false;
            }
            mr2 mr2Var3 = this.a;
            mr2Var3.getClass();
            synchronized (im2.c) {
                bm2VarJ = im2.j();
                zB = y44.b((mr2) im2.w(mr2Var3, this, bm2VarJ), i, n1VarH, true);
            }
            im2.n(bm2VarJ, this);
        } while (!zB);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public final boolean retainAll(Collection collection) {
        return y44.e(this, new m1(2, collection));
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        int i2;
        n1 n1Var;
        bm2 bm2VarJ;
        boolean zB;
        Object obj2 = get(i);
        do {
            synchronized (y44.a) {
                mr2 mr2Var = this.a;
                mr2Var.getClass();
                mr2 mr2Var2 = (mr2) im2.h(mr2Var);
                i2 = mr2Var2.d;
                n1Var = mr2Var2.c;
            }
            n1Var.getClass();
            n1 n1VarJ = n1Var.j(i, obj);
            if (n1VarJ.equals(n1Var)) {
                break;
            }
            mr2 mr2Var3 = this.a;
            mr2Var3.getClass();
            synchronized (im2.c) {
                bm2VarJ = im2.j();
                zB = y44.b((mr2) im2.w(mr2Var3, this, bm2VarJ), i2, n1VarJ, false);
            }
            im2.n(bm2VarJ, this);
        } while (!zB);
        return obj2;
    }

    @Override // java.util.List, java.util.Collection
    public final int size() {
        return y44.c(this).c.a();
    }

    @Override // java.util.List
    public final List subList(int i, int i2) {
        if (!(i >= 0 && i <= i2 && i2 <= size())) {
            dz1.a("fromIndex or toIndex are out of bounds");
        }
        return new qs2(this, i, i2);
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray() {
        return zt3.b(this);
    }

    public final String toString() {
        mr2 mr2Var = this.a;
        mr2Var.getClass();
        return "SnapshotStateList(value=" + ((mr2) im2.h(mr2Var)).c + ")@" + hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        n1 n1Var = y44.c(this).c;
        int iA = n1Var.a();
        parcel.writeInt(iA);
        for (int i2 = 0; i2 < iA; i2++) {
            parcel.writeValue(n1Var.get(i2));
        }
    }

    @Override // java.util.List, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        return zt3.c(this, objArr);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return new nw0(this, i);
    }

    public um2() {
        this(sl2.b);
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        int i2;
        n1 n1Var;
        bm2 bm2VarJ;
        boolean zB;
        do {
            synchronized (y44.a) {
                mr2 mr2Var = this.a;
                mr2Var.getClass();
                mr2 mr2Var2 = (mr2) im2.h(mr2Var);
                i2 = mr2Var2.d;
                n1Var = mr2Var2.c;
            }
            n1Var.getClass();
            n1 n1VarB = n1Var.b(i, obj);
            if (n1VarB.equals(n1Var)) {
                return;
            }
            mr2 mr2Var3 = this.a;
            mr2Var3.getClass();
            synchronized (im2.c) {
                bm2VarJ = im2.j();
                zB = y44.b((mr2) im2.w(mr2Var3, this, bm2VarJ), i2, n1VarB, true);
            }
            im2.n(bm2VarJ, this);
        } while (!zB);
    }

    @Override // java.util.List
    public final boolean addAll(final int i, final Collection collection) {
        return y44.e(this, new hq0() { // from class: sm2
            @Override // defpackage.hq0
            public final Object j(Object obj) {
                return Boolean.valueOf(((List) obj).addAll(i, collection));
            }
        });
    }

    @Override // java.util.List
    public final Object remove(int i) {
        int i2;
        n1 n1Var;
        bm2 bm2VarJ;
        boolean zB;
        Object obj = get(i);
        do {
            synchronized (y44.a) {
                mr2 mr2Var = this.a;
                mr2Var.getClass();
                mr2 mr2Var2 = (mr2) im2.h(mr2Var);
                i2 = mr2Var2.d;
                n1Var = mr2Var2.c;
            }
            n1Var.getClass();
            n1 n1VarI = n1Var.i(i);
            if (n1VarI.equals(n1Var)) {
                break;
            }
            mr2 mr2Var3 = this.a;
            mr2Var3.getClass();
            synchronized (im2.c) {
                bm2VarJ = im2.j();
                zB = y44.b((mr2) im2.w(mr2Var3, this, bm2VarJ), i2, n1VarI, true);
            }
            im2.n(bm2VarJ, this);
        } while (!zB);
        return obj;
    }
}
