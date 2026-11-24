package defpackage;

import android.os.Trace;
import java.io.Serializable;
import java.util.Iterator;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class i52 {
    public Object a;
    public Object b;
    public Object c;
    public Object d;
    public RandomAccess e;
    public Object f;
    public Object g;
    public Object h;
    public Object i;
    public Object j;
    public Serializable k;

    public i52() {
        pm1 pm1Var = new pm1(new k52[16]);
        this.c = pm1Var;
        hm1 hm1Var = za2.a;
        this.g = new hm1();
        this.d = pm1Var;
        this.e = new pm1(new Object[16]);
        this.f = new pm1(new fq0[16]);
    }

    public static final boolean f(k52 k52Var, pm1 pm1Var) {
        Object[] objArr = pm1Var.a;
        int i = pm1Var.c;
        for (int i2 = 0; i2 < i; i2++) {
            j52 j52Var = ((k52) objArr[i2]).a;
            if (j52Var instanceof lv1) {
                pm1 pm1Var2 = ((lv1) j52Var).b;
                if (pm1Var2.k(k52Var) || f(k52Var, pm1Var2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void a() {
        this.a = null;
        this.b = null;
        pm1 pm1Var = (pm1) this.c;
        pm1Var.h();
        ((hm1) this.g).b();
        this.d = pm1Var;
        ((pm1) this.e).h();
        ((pm1) this.f).h();
        this.h = null;
        this.j = null;
        this.k = null;
    }

    public void b() {
        Set set = (Set) this.a;
        if (set == null || set.isEmpty()) {
            return;
        }
        Trace.beginSection("Compose:abandons");
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                j52 j52Var = (j52) it.next();
                it.remove();
                j52Var.b();
            }
            Trace.endSection();
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    /* JADX WARN: Bottom block not found for handler: all -> 0x006d */
    /* JADX WARN: Bottom block not found for handler: all -> 0x00a8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c() {
        /*
            r8 = this;
            java.lang.Object r0 = r8.c
            pm1 r0 = (defpackage.pm1) r0
            java.util.RandomAccess r1 = r8.e
            pm1 r1 = (defpackage.pm1) r1
            java.lang.Object r2 = r8.a
            java.util.Set r2 = (java.util.Set) r2
            if (r2 != 0) goto L10
            goto Lb3
        L10:
            r3 = 0
            r8.i = r3
            int r3 = r1.c
            r4 = 4
            if (r3 == 0) goto L72
            java.lang.String r3 = "Compose:onForgotten"
            android.os.Trace.beginSection(r3)
            java.lang.Object r3 = r8.h     // Catch: java.lang.Throwable -> L6d
            hm1 r3 = (defpackage.hm1) r3     // Catch: java.lang.Throwable -> L6d
            int r5 = r1.c     // Catch: java.lang.Throwable -> L6d
            int r5 = r5 + (-1)
        L25:
            r6 = -1
            if (r6 >= r5) goto L69
            java.lang.Object[] r6 = r1.a     // Catch: java.lang.Throwable -> L6d
            r6 = r6[r5]     // Catch: java.lang.Throwable -> L6d
            boolean r7 = r6 instanceof defpackage.k52     // Catch: java.lang.Throwable -> L3c
            if (r7 == 0) goto L3e
            r7 = r6
            k52 r7 = (defpackage.k52) r7     // Catch: java.lang.Throwable -> L3c
            j52 r7 = r7.a     // Catch: java.lang.Throwable -> L3c
            r2.remove(r7)     // Catch: java.lang.Throwable -> L3c
            r7.d()     // Catch: java.lang.Throwable -> L3c
            goto L3e
        L3c:
            r0 = move-exception
            goto L5a
        L3e:
            boolean r7 = r6 instanceof defpackage.d20     // Catch: java.lang.Throwable -> L3c
            if (r7 == 0) goto L57
            if (r3 == 0) goto L51
            boolean r7 = r3.c(r6)     // Catch: java.lang.Throwable -> L3c
            if (r7 == 0) goto L51
            r7 = r6
            d20 r7 = (defpackage.d20) r7     // Catch: java.lang.Throwable -> L3c
            r7.a()     // Catch: java.lang.Throwable -> L3c
            goto L57
        L51:
            r7 = r6
            d20 r7 = (defpackage.d20) r7     // Catch: java.lang.Throwable -> L3c
            r7.b()     // Catch: java.lang.Throwable -> L3c
        L57:
            int r5 = r5 + (-1)
            goto L25
        L5a:
            java.lang.Object r8 = r8.b     // Catch: java.lang.Throwable -> L6d
            e30 r8 = (defpackage.e30) r8     // Catch: java.lang.Throwable -> L6d
            if (r8 == 0) goto L68
            zb r1 = new zb     // Catch: java.lang.Throwable -> L6d
            r1.<init>(r4, r8, r6)     // Catch: java.lang.Throwable -> L6d
            defpackage.ej4.b(r0, r1)     // Catch: java.lang.Throwable -> L6d
        L68:
            throw r0     // Catch: java.lang.Throwable -> L6d
        L69:
            android.os.Trace.endSection()
            goto L72
        L6d:
            r8 = move-exception
            android.os.Trace.endSection()
            throw r8
        L72:
            int r1 = r0.c
            if (r1 == 0) goto Lb3
            java.lang.String r1 = "Compose:onRemembered"
            android.os.Trace.beginSection(r1)
            java.lang.Object r1 = r8.a     // Catch: java.lang.Throwable -> La8
            java.util.Set r1 = (java.util.Set) r1     // Catch: java.lang.Throwable -> La8
            if (r1 != 0) goto L82
            goto Lab
        L82:
            java.lang.Object[] r2 = r0.a     // Catch: java.lang.Throwable -> La8
            int r0 = r0.c     // Catch: java.lang.Throwable -> La8
            r3 = 0
        L87:
            if (r3 >= r0) goto Lab
            r5 = r2[r3]     // Catch: java.lang.Throwable -> La8
            k52 r5 = (defpackage.k52) r5     // Catch: java.lang.Throwable -> La8
            j52 r6 = r5.a     // Catch: java.lang.Throwable -> La8
            r1.remove(r6)     // Catch: java.lang.Throwable -> La8
            r6.a()     // Catch: java.lang.Throwable -> L98
            int r3 = r3 + 1
            goto L87
        L98:
            r0 = move-exception
            java.lang.Object r8 = r8.b     // Catch: java.lang.Throwable -> La8
            e30 r8 = (defpackage.e30) r8     // Catch: java.lang.Throwable -> La8
            if (r8 == 0) goto Laa
            zb r1 = new zb     // Catch: java.lang.Throwable -> La8
            r1.<init>(r4, r8, r5)     // Catch: java.lang.Throwable -> La8
            defpackage.ej4.b(r0, r1)     // Catch: java.lang.Throwable -> La8
            goto Laa
        La8:
            r8 = move-exception
            goto Laf
        Laa:
            throw r0     // Catch: java.lang.Throwable -> La8
        Lab:
            android.os.Trace.endSection()
            return
        Laf:
            android.os.Trace.endSection()
            throw r8
        Lb3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i52.c():void");
    }

    public void d() {
        pm1 pm1Var = (pm1) this.f;
        if (pm1Var.c != 0) {
            Trace.beginSection("Compose:sideeffects");
            try {
                Object[] objArr = pm1Var.a;
                int i = pm1Var.c;
                for (int i2 = 0; i2 < i; i2++) {
                    ((fq0) objArr[i2]).a();
                }
                pm1Var.h();
            } finally {
                Trace.endSection();
            }
        }
    }

    public void e(k52 k52Var) {
        pm1 pm1Var = (pm1) this.c;
        if (!((hm1) this.g).c(k52Var)) {
            hm1 hm1Var = (hm1) this.i;
            if (hm1Var == null || !hm1Var.c(k52Var)) {
                ((pm1) this.e).b(k52Var);
                return;
            }
            return;
        }
        ((hm1) this.g).l(k52Var);
        if (!((pm1) this.d).k(k52Var) && !pm1Var.k(k52Var)) {
            f(k52Var, pm1Var);
        }
        Set set = (Set) this.a;
        if (set == null) {
            return;
        }
        set.add(k52Var.a);
    }

    public void g(Set set, e30 e30Var) {
        a();
        this.a = set;
        this.b = e30Var;
    }
}
