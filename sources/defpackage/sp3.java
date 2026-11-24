package defpackage;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Spliterator;
import java.util.Spliterators;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class sp3 extends AbstractCollection implements Serializable {
    public static final Object[] b = new Object[0];
    public static final Object[] c = new Object[0];
    public static final Object[] e = new Object[0];
    public final /* synthetic */ int a;

    public abstract int a(Object[] objArr);

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public abstract int b();

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public abstract int d();

    public abstract Object[] f();

    public abstract int g(Object[] objArr);

    public int h() {
        switch (this.a) {
            case 1:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public int i() {
        switch (this.a) {
            case 1:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    public Object[] j() {
        switch (this.a) {
        }
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        switch (this.a) {
            case 0:
                throw new UnsupportedOperationException();
            case 1:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Spliterator spliterator() {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
        }
        return Spliterators.spliterator(this, 1296);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        switch (this.a) {
            case 0:
                objArr.getClass();
                int size = size();
                int length = objArr.length;
                if (length < size) {
                    Object[] objArrF = f();
                    if (objArrF != null) {
                        return Arrays.copyOfRange(objArrF, d(), b(), objArr.getClass());
                    }
                    if (length != 0) {
                        objArr = Arrays.copyOf(objArr, 0);
                    }
                    objArr = Arrays.copyOf(objArr, size);
                } else if (length > size) {
                    objArr[size] = null;
                }
                a(objArr);
                return objArr;
            case 1:
                objArr.getClass();
                int size2 = size();
                int length2 = objArr.length;
                if (length2 < size2) {
                    Object[] objArrJ = j();
                    if (objArrJ != null) {
                        return Arrays.copyOfRange(objArrJ, i(), h(), objArr.getClass());
                    }
                    if (length2 != 0) {
                        objArr = Arrays.copyOf(objArr, 0);
                    }
                    objArr = Arrays.copyOf(objArr, size2);
                } else if (length2 > size2) {
                    objArr[size2] = null;
                }
                g(objArr);
                return objArr;
            default:
                objArr.getClass();
                int size3 = size();
                int length3 = objArr.length;
                if (length3 < size3) {
                    Object[] objArrJ2 = j();
                    if (objArrJ2 != null) {
                        return Arrays.copyOfRange(objArrJ2, i(), h(), objArr.getClass());
                    }
                    if (length3 != 0) {
                        objArr = Arrays.copyOf(objArr, 0);
                    }
                    objArr = Arrays.copyOf(objArr, size3);
                } else if (length3 > size3) {
                    objArr[size3] = null;
                }
                g(objArr);
                return objArr;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final Object[] toArray() {
        switch (this.a) {
            case 0:
                return toArray(b);
            case 1:
                return toArray(c);
            default:
                return toArray(e);
        }
    }
}
