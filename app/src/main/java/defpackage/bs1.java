package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bs1 extends zr4 {
    public int b;
    public int d;
    public int f;
    public zr1[] a = new zr1[16];
    public int[] c = new int[16];
    public Object[] e = new Object[16];

    public final void a() {
        this.b = 0;
        this.d = 0;
        Arrays.fill(this.e, 0, this.f, (Object) null);
        this.f = 0;
    }

    public final void b(xf xfVar, rl2 rl2Var, i52 i52Var, as1 as1Var) throws IllegalAccessException, InvocationTargetException {
        if (d()) {
            iz izVar = new iz(this);
            bs1 bs1Var = (bs1) izVar.e;
            while (true) {
                zr1 zr1Var = bs1Var.a[izVar.b];
                j6 j6VarB = zr1Var.b(izVar);
                xf xfVar2 = xfVar;
                rl2 rl2Var2 = rl2Var;
                i52 i52Var2 = i52Var;
                as1 as1Var2 = as1Var;
                try {
                    zr1Var.a(izVar, xfVar2, rl2Var2, i52Var2, as1Var2);
                    int i = izVar.b;
                    int i2 = bs1Var.b;
                    if (i < i2) {
                        zr1 zr1Var2 = bs1Var.a[i];
                        izVar.c += zr1Var2.a;
                        izVar.d += zr1Var2.b;
                        int i3 = i + 1;
                        izVar.b = i3;
                        if (i3 >= i2) {
                            break;
                        }
                        xfVar = xfVar2;
                        rl2Var = rl2Var2;
                        i52Var = i52Var2;
                        as1Var = as1Var2;
                    } else {
                        break;
                    }
                } catch (Throwable th) {
                    if (as1Var2 == null) {
                        throw th;
                    }
                    ej4.b(th, new ek(j6VarB, rl2Var2, as1Var2, 5));
                    throw th;
                }
            }
        }
        a();
    }

    public final boolean c() {
        return this.b == 0;
    }

    public final boolean d() {
        return this.b != 0;
    }

    public final void e(zr1 zr1Var) {
        int i = this.b;
        zr1[] zr1VarArr = this.a;
        if (i == zr1VarArr.length) {
            zr1[] zr1VarArr2 = new zr1[(i > 1024 ? 1024 : i) + i];
            System.arraycopy(zr1VarArr, 0, zr1VarArr2, 0, i);
            this.a = zr1VarArr2;
        }
        int i2 = this.d;
        int i3 = zr1Var.a;
        int i4 = zr1Var.b;
        int i5 = i2 + i3;
        int[] iArr = this.c;
        int length = iArr.length;
        if (i5 > length) {
            int i6 = (length > 1024 ? 1024 : length) + length;
            if (i6 >= i5) {
                i5 = i6;
            }
            int[] iArr2 = new int[i5];
            qg.e(iArr, 0, iArr2, 0, length);
            this.c = iArr2;
        }
        int i7 = this.f + i4;
        Object[] objArr = this.e;
        int length2 = objArr.length;
        if (i7 > length2) {
            int i8 = (length2 <= 1024 ? length2 : 1024) + length2;
            if (i8 >= i7) {
                i7 = i8;
            }
            Object[] objArr2 = new Object[i7];
            System.arraycopy(objArr, 0, objArr2, 0, length2);
            this.e = objArr2;
        }
        zr1[] zr1VarArr3 = this.a;
        int i9 = this.b;
        this.b = i9 + 1;
        zr1VarArr3[i9] = zr1Var;
        this.d += zr1Var.a;
        this.f += i4;
    }
}
