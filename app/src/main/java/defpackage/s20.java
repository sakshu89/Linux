package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class s20 {
    public final x20 a;
    public yw b;
    public boolean c;
    public int f;
    public int g;
    public int l;
    public final m21 d = new m21();
    public boolean e = true;
    public final ArrayList h = new ArrayList();
    public int i = -1;
    public int j = -1;
    public int k = -1;

    public s20(x20 x20Var, yw ywVar) {
        this.a = x20Var;
        this.b = ywVar;
    }

    public final void a() {
        c();
        ArrayList arrayList = this.h;
        if (arrayList.isEmpty()) {
            this.g++;
        } else {
            arrayList.remove(arrayList.size() - 1);
        }
    }

    public final void b() {
        int i = this.g;
        if (i > 0) {
            bs1 bs1Var = this.b.a;
            bs1Var.e(xr1.c);
            bs1Var.c[bs1Var.d - bs1Var.a[bs1Var.b - 1].a] = i;
            this.g = 0;
        }
        ArrayList arrayList = this.h;
        if (arrayList.isEmpty()) {
            return;
        }
        yw ywVar = this.b;
        int size = arrayList.size();
        Object[] objArr = new Object[size];
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = arrayList.get(i2);
        }
        ywVar.getClass();
        if (size != 0) {
            bs1 bs1Var2 = ywVar.a;
            bs1Var2.e(ar1.c);
            yr4.a(bs1Var2, 0, objArr);
        }
        arrayList.clear();
    }

    public final void c() {
        int i = this.l;
        if (i > 0) {
            int i2 = this.i;
            if (i2 >= 0) {
                b();
                bs1 bs1Var = this.b.a;
                bs1Var.e(pr1.c);
                int i3 = bs1Var.d - bs1Var.a[bs1Var.b - 1].a;
                int[] iArr = bs1Var.c;
                iArr[i3] = i2;
                iArr[i3 + 1] = i;
                this.i = -1;
            } else {
                int i4 = this.k;
                int i5 = this.j;
                b();
                bs1 bs1Var2 = this.b.a;
                bs1Var2.e(lr1.c);
                int i6 = bs1Var2.d - bs1Var2.a[bs1Var2.b - 1].a;
                int[] iArr2 = bs1Var2.c;
                iArr2[i6 + 1] = i4;
                iArr2[i6] = i5;
                iArr2[i6 + 2] = i;
                this.j = -1;
                this.k = -1;
            }
            this.l = 0;
        }
    }

    public final void d(boolean z) {
        nl2 nl2Var = this.a.G;
        int i = z ? nl2Var.i : nl2Var.g;
        int i2 = i - this.f;
        if (i2 < 0) {
            y20.a("Tried to seek backward");
        }
        if (i2 > 0) {
            bs1 bs1Var = this.b.a;
            bs1Var.e(tq1.c);
            bs1Var.c[bs1Var.d - bs1Var.a[bs1Var.b - 1].a] = i2;
            this.f = i;
        }
    }

    public final void e(int i, int i2) {
        if (i2 > 0) {
            if (!(i >= 0)) {
                y20.a("Invalid remove index " + i);
            }
            if (this.i == i) {
                this.l += i2;
                return;
            }
            c();
            this.i = i;
            this.l = i2;
        }
    }
}
