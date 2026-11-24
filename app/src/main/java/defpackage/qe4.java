package defpackage;

import android.graphics.Path;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class qe4 {
    public static final void a(kv0 kv0Var, n63 n63Var) {
        List list = n63Var.s;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            p63 p63Var = (p63) list.get(i);
            if (p63Var instanceof r63) {
                ou1 ou1Var = new ou1();
                r63 r63Var = (r63) p63Var;
                ou1Var.d = r63Var.b;
                ou1Var.n = true;
                ou1Var.c();
                ou1Var.s.a.setFillType(r63Var.c == 1 ? Path.FillType.EVEN_ODD : Path.FillType.WINDING);
                ou1Var.c();
                ou1Var.c();
                ou1Var.b = r63Var.e;
                ou1Var.c();
                ou1Var.c = r63Var.f;
                ou1Var.c();
                ou1Var.g = r63Var.i;
                ou1Var.c();
                ou1Var.e = r63Var.j;
                ou1Var.c();
                ou1Var.f = r63Var.k;
                ou1Var.o = true;
                ou1Var.c();
                ou1Var.h = r63Var.n;
                ou1Var.o = true;
                ou1Var.c();
                ou1Var.i = r63Var.s;
                ou1Var.o = true;
                ou1Var.c();
                ou1Var.j = r63Var.t;
                ou1Var.o = true;
                ou1Var.c();
                ou1Var.k = r63Var.u;
                ou1Var.p = true;
                ou1Var.c();
                ou1Var.l = r63Var.v;
                ou1Var.p = true;
                ou1Var.c();
                ou1Var.m = r63Var.w;
                ou1Var.p = true;
                ou1Var.c();
                kv0Var.e(i, ou1Var);
            } else if (p63Var instanceof n63) {
                kv0 kv0Var2 = new kv0();
                n63 n63Var2 = (n63) p63Var;
                kv0Var2.k = n63Var2.a;
                kv0Var2.c();
                kv0Var2.l = n63Var2.b;
                kv0Var2.s = true;
                kv0Var2.c();
                kv0Var2.o = n63Var2.f;
                kv0Var2.s = true;
                kv0Var2.c();
                kv0Var2.p = n63Var2.i;
                kv0Var2.s = true;
                kv0Var2.c();
                kv0Var2.q = n63Var2.j;
                kv0Var2.s = true;
                kv0Var2.c();
                kv0Var2.r = n63Var2.k;
                kv0Var2.s = true;
                kv0Var2.c();
                kv0Var2.m = n63Var2.c;
                kv0Var2.s = true;
                kv0Var2.c();
                kv0Var2.n = n63Var2.e;
                kv0Var2.s = true;
                kv0Var2.c();
                kv0Var2.f = n63Var2.n;
                kv0Var2.g = true;
                kv0Var2.c();
                a(kv0Var2, n63Var2);
                kv0Var.e(i, kv0Var2);
            }
        }
    }

    public static final int b(pg pgVar, Object obj, int i) {
        int i2 = pgVar.c;
        if (i2 == 0) {
            return -1;
        }
        try {
            int iA = ny3.a(pgVar.a, i2, i);
            if (iA < 0 || g31.a(obj, pgVar.b[iA])) {
                return iA;
            }
            int i3 = iA + 1;
            while (i3 < i2 && pgVar.a[i3] == i) {
                if (g31.a(obj, pgVar.b[i3])) {
                    return i3;
                }
                i3++;
            }
            for (int i4 = iA - 1; i4 >= 0 && pgVar.a[i4] == i; i4--) {
                if (g31.a(obj, pgVar.b[i4])) {
                    return i4;
                }
            }
            return ~i3;
        } catch (IndexOutOfBoundsException unused) {
            og.d();
            return 0;
        }
    }
}
