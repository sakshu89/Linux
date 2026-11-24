package defpackage;

import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class wm2 {
    public final hq0 a;
    public boolean c;
    public zq h;
    public vm2 i;
    public final AtomicReference b = new AtomicReference(null);
    public final ha d = new ha(13, this);
    public final rm2 e = new rm2(1, this);
    public final pm1 f = new pm1(new vm2[16]);
    public final Object g = new Object();
    public long j = -1;

    public wm2(hq0 hq0Var) {
        this.a = hq0Var;
    }

    public final void a() {
        synchronized (this.g) {
            pm1 pm1Var = this.f;
            Object[] objArr = pm1Var.a;
            int i = pm1Var.c;
            for (int i2 = 0; i2 < i; i2++) {
                vm2 vm2Var = (vm2) objArr[i2];
                vm2Var.e.a();
                vm2Var.f.a();
                vm2Var.l.a();
                vm2Var.m.clear();
            }
        }
    }

    public final boolean b() {
        boolean z;
        Set set;
        Set set2;
        synchronized (this.g) {
            z = this.c;
        }
        if (z) {
            return false;
        }
        boolean z2 = false;
        while (true) {
            AtomicReference atomicReference = this.b;
            while (true) {
                Object obj = atomicReference.get();
                set = null;
                Object obj2 = null;
                Object objSubList = null;
                if (obj == null) {
                    break;
                }
                if (obj instanceof Set) {
                    set2 = (Set) obj;
                } else {
                    if (!(obj instanceof List)) {
                        y20.b("Unexpected notification");
                        og.k();
                        return false;
                    }
                    List list = (List) obj;
                    Set set3 = (Set) list.get(0);
                    if (list.size() == 2) {
                        objSubList = list.get(1);
                    } else if (list.size() > 2) {
                        objSubList = list.subList(1, list.size());
                    }
                    set2 = set3;
                    obj2 = objSubList;
                }
                do {
                    if (atomicReference.compareAndSet(obj, obj2)) {
                        set = set2;
                        break;
                    }
                } while (atomicReference.get() == obj);
            }
            if (set == null) {
                return z2;
            }
            synchronized (this.g) {
                pm1 pm1Var = this.f;
                Object[] objArr = pm1Var.a;
                int i = pm1Var.c;
                for (int i2 = 0; i2 < i; i2++) {
                    z2 = ((vm2) objArr[i2]).a(set) || z2;
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:90:0x01f5  */
    public final void c(Object obj, hq0 hq0Var, fq0 fq0Var) {
        Object obj2;
        vm2 vm2Var;
        boolean z;
        ul1 ul1Var;
        bm2 n23Var;
        Object obj3;
        Object obj4;
        Object obj5;
        long[] jArr;
        Object obj6;
        int i;
        long[] jArr2;
        long j;
        synchronized (this.g) {
            pm1 pm1Var = this.f;
            Object[] objArr = pm1Var.a;
            int i2 = pm1Var.c;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    obj2 = null;
                    break;
                }
                obj2 = objArr[i3];
                if (((vm2) obj2).a == hq0Var) {
                    break;
                } else {
                    i3++;
                }
            }
            vm2Var = (vm2) obj2;
            z = true;
            if (vm2Var == null) {
                hq0Var.getClass();
                h33.c(1, hq0Var);
                vm2Var = new vm2(hq0Var);
                pm1Var.b(vm2Var);
            }
        }
        vm2 vm2Var2 = this.i;
        long j2 = this.j;
        if (j2 != -1 && j2 != tc4.a()) {
            dz1.a("Detected multithreaded access to SnapshotStateObserver: previousThreadId=" + j2 + "), currentThread={id=" + tc4.a() + ", name=" + Thread.currentThread().getName() + "}. Note that observation on multiple threads in layout/draw is not supported. Make sure your measure/layout/draw for each Owner (AndroidComposeView) is executed on the same thread.");
        }
        try {
            this.i = vm2Var;
            this.j = tc4.a();
            rm2 rm2Var = this.e;
            Object obj7 = vm2Var.b;
            ul1 ul1Var2 = vm2Var.c;
            int i4 = vm2Var.d;
            vm2Var.b = obj;
            vm2Var.c = (ul1) vm2Var.f.g(obj);
            if (vm2Var.d == -1) {
                vm2Var.d = Long.hashCode(im2.j().g());
            }
            w20 w20Var = vm2Var.i;
            pm1 pm1VarA = o44.a();
            try {
                pm1VarA.b(w20Var);
                if (rm2Var == null) {
                    fq0Var.a();
                    ul1Var = ul1Var2;
                } else {
                    bm2 bm2Var = (bm2) im2.b.l();
                    if (bm2Var instanceof n23) {
                        ul1Var = ul1Var2;
                        if (((n23) bm2Var).t == tc4.a()) {
                            hq0 hq0Var2 = ((n23) bm2Var).r;
                            hq0 hq0Var3 = ((n23) bm2Var).s;
                            try {
                                ((n23) bm2Var).r = im2.k(rm2Var, hq0Var2, true);
                                ((n23) bm2Var).s = hq0Var3;
                                fq0Var.a();
                                ((n23) bm2Var).r = hq0Var2;
                                ((n23) bm2Var).s = hq0Var3;
                            } catch (Throwable th) {
                                ((n23) bm2Var).r = hq0Var2;
                                ((n23) bm2Var).s = hq0Var3;
                                throw th;
                            }
                        }
                    } else {
                        ul1Var = ul1Var2;
                    }
                    if (bm2Var == null || (bm2Var instanceof lm1)) {
                        n23Var = new n23(bm2Var instanceof lm1 ? (lm1) bm2Var : null, rm2Var, null, true, false);
                    } else {
                        n23Var = bm2Var.u(rm2Var);
                    }
                    try {
                        bm2 bm2VarJ = n23Var.j();
                        try {
                            fq0Var.a();
                            bm2.q(bm2VarJ);
                            n23Var.c();
                        } catch (Throwable th2) {
                            try {
                                bm2.q(bm2VarJ);
                                throw th2;
                            } catch (Throwable th3) {
                                th = th3;
                                try {
                                    n23Var.c();
                                    throw th;
                                } catch (Throwable th4) {
                                    th = th4;
                                    pm1VarA.l(pm1VarA.c - 1);
                                    throw th;
                                }
                            }
                        }
                    } catch (Throwable th5) {
                        th = th5;
                    }
                }
                pm1VarA.l(pm1VarA.c - 1);
                Object obj8 = vm2Var.b;
                obj8.getClass();
                int i5 = vm2Var.d;
                ul1 ul1Var3 = vm2Var.c;
                if (ul1Var3 != null) {
                    long[] jArr3 = ul1Var3.a;
                    int length = jArr3.length - 2;
                    if (length >= 0) {
                        int i6 = 0;
                        while (true) {
                            long j3 = jArr3[i6];
                            boolean z2 = z;
                            obj4 = obj7;
                            if ((((~j3) << 7) & j3 & (-9187201950435737472L)) != -9187201950435737472L) {
                                int i7 = 8 - ((~(i6 - length)) >>> 31);
                                int i8 = 0;
                                while (i8 < i7) {
                                    if ((j3 & 255) < 128) {
                                        i = i8;
                                        int i9 = (i6 << 3) + i;
                                        jArr2 = jArr3;
                                        Object obj9 = ul1Var3.b[i9];
                                        j = j3;
                                        boolean z3 = ul1Var3.c[i9] != i5 ? z2 : false;
                                        if (z3) {
                                            gm1 gm1Var = vm2Var.e;
                                            tz3.c(gm1Var, obj9, obj8);
                                            obj6 = obj8;
                                            if ((obj9 instanceof qc0) && !gm1Var.c(obj9)) {
                                                tz3.d(vm2Var.l, obj9);
                                                vm2Var.m.remove(obj9);
                                            }
                                        } else {
                                            obj6 = obj8;
                                        }
                                        if (z3) {
                                            ul1Var3.f(i9);
                                        }
                                    } else {
                                        obj6 = obj8;
                                        i = i8;
                                        jArr2 = jArr3;
                                        j = j3;
                                    }
                                    j3 = j >> 8;
                                    i8 = i + 1;
                                    jArr3 = jArr2;
                                    obj8 = obj6;
                                }
                                obj5 = obj8;
                                jArr = jArr3;
                                if (i7 != 8) {
                                    break;
                                }
                            } else {
                                obj5 = obj8;
                                jArr = jArr3;
                            }
                            if (i6 == length) {
                                break;
                            }
                            i6++;
                            z = z2;
                            obj7 = obj4;
                            jArr3 = jArr;
                            obj8 = obj5;
                        }
                        obj3 = obj4;
                    } else {
                        obj3 = obj7;
                    }
                } else {
                    obj3 = obj7;
                }
                vm2Var.b = obj3;
                vm2Var.c = ul1Var;
                vm2Var.d = i4;
                this.i = vm2Var2;
                this.j = j2;
            } catch (Throwable th6) {
                th = th6;
                pm1VarA.l(pm1VarA.c - 1);
                throw th;
            }
        } catch (Throwable th7) {
            this.i = vm2Var2;
            this.j = j2;
            throw th7;
        }
    }

    public final void d() {
        ha haVar = this.d;
        im2.e(im2.a);
        synchronized (im2.c) {
            im2.h = mz.F(im2.h, haVar);
        }
        this.h = new zq(8, haVar);
    }
}
