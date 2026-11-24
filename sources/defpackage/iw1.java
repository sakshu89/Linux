package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class iw1 implements Iterator, x41 {
    public final y23[] a;
    public int b;
    public boolean c = true;

    public iw1(x23 x23Var, y23[] y23VarArr) {
        this.a = y23VarArr;
        y23VarArr[0].a(x23Var.d, Integer.bitCount(x23Var.a) * 2, 0);
        this.b = 0;
        a();
    }

    public final void a() {
        int i = this.b;
        y23[] y23VarArr = this.a;
        y23 y23Var = y23VarArr[i];
        if (y23Var.c < y23Var.b) {
            return;
        }
        while (-1 < i) {
            int iB = b(i);
            if (iB == -1) {
                y23 y23Var2 = y23VarArr[i];
                int i2 = y23Var2.c;
                Object[] objArr = y23Var2.a;
                if (i2 < objArr.length) {
                    int length = objArr.length;
                    y23Var2.c = i2 + 1;
                    iB = b(i);
                }
            }
            if (iB != -1) {
                this.b = iB;
                return;
            }
            if (i > 0) {
                y23 y23Var3 = y23VarArr[i - 1];
                int i3 = y23Var3.c;
                int length2 = y23Var3.a.length;
                y23Var3.c = i3 + 1;
            }
            y23VarArr[i].a(x23.e.d, 0, 0);
            i--;
        }
        this.c = false;
    }

    public final int b(int i) {
        y23[] y23VarArr = this.a;
        y23 y23Var = y23VarArr[i];
        int i2 = y23Var.c;
        if (i2 < y23Var.b) {
            return i;
        }
        Object[] objArr = y23Var.a;
        if (i2 >= objArr.length) {
            return -1;
        }
        int length = objArr.length;
        Object obj = objArr[i2];
        obj.getClass();
        x23 x23Var = (x23) obj;
        if (i == 6) {
            y23 y23Var2 = y23VarArr[i + 1];
            Object[] objArr2 = x23Var.d;
            y23Var2.a(objArr2, objArr2.length, 0);
        } else {
            y23VarArr[i + 1].a(x23Var.d, Integer.bitCount(x23Var.a) * 2, 0);
        }
        return b(i + 1);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.c;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!this.c) {
            dk0.d();
            return null;
        }
        Object next = this.a[this.b].next();
        a();
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
