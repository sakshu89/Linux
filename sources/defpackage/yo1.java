package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class yo1 {
    public static final Object[] a = new Object[0];
    public static final yl1 b = new yl1(0);

    public static final void a(int i, List list) {
        int size = list.size();
        if (i < 0 || i >= size) {
            og.o(cq.i("Index ", i, " is out of bounds. The list has ", size, " elements."));
        }
    }

    public static final void b(List list, int i, int i2) {
        int size = list.size();
        if (i > i2) {
            og.i(cq.i("Indices are out of order. fromIndex (", i, ") is greater than toIndex (", i2, ")."));
            return;
        }
        if (i < 0) {
            og.o(cq.h("fromIndex (", i, ") is less than 0."));
            return;
        }
        if (i2 <= size) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i2 + ") is more than than the list size (" + size + ')');
    }
}
