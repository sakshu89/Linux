package defpackage;

import android.media.ImageReader;
import android.util.LongSparseArray;
import android.view.Surface;
import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fj1 implements bz0, vp0 {
    public final Object a;
    public final ow b;
    public int c;
    public final zq e;
    public boolean f;
    public final s9 i;
    public az0 j;
    public Executor k;
    public final LongSparseArray n;
    public final LongSparseArray s;
    public int t;
    public final ArrayList u;
    public final ArrayList v;

    public fj1(int i, int i2, int i3, int i4) {
        s9 s9Var = new s9(ImageReader.newInstance(i, i2, i3, i4));
        this.a = new Object();
        this.b = new ow(1, this);
        this.c = 0;
        this.e = new zq(4, this);
        this.f = false;
        this.n = new LongSparseArray();
        this.s = new LongSparseArray();
        this.v = new ArrayList();
        this.i = s9Var;
        this.t = 0;
        this.u = new ArrayList(n());
    }

    @Override // defpackage.bz0
    public final int a() {
        int iA;
        synchronized (this.a) {
            iA = this.i.a();
        }
        return iA;
    }

    @Override // defpackage.bz0
    public final int b() {
        int iB;
        synchronized (this.a) {
            iB = this.i.b();
        }
        return iB;
    }

    @Override // defpackage.vp0
    public final void c(wp0 wp0Var) {
        synchronized (this.a) {
            d(wp0Var);
        }
    }

    @Override // defpackage.bz0
    public final void close() {
        synchronized (this.a) {
            try {
                if (this.f) {
                    return;
                }
                ArrayList arrayList = new ArrayList(this.u);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((zy0) obj).close();
                }
                this.u.clear();
                this.i.close();
                this.f = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(wp0 wp0Var) {
        synchronized (this.a) {
            try {
                int iIndexOf = this.u.indexOf(wp0Var);
                if (iIndexOf >= 0) {
                    this.u.remove(iIndexOf);
                    int i = this.t;
                    if (iIndexOf <= i) {
                        this.t = i - 1;
                    }
                }
                this.v.remove(wp0Var);
                if (this.c > 0) {
                    g(this.i);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.bz0
    public final zy0 e() {
        synchronized (this.a) {
            try {
                if (this.u.isEmpty()) {
                    return null;
                }
                if (this.t >= this.u.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                ArrayList arrayList = new ArrayList();
                int i = 0;
                for (int i2 = 0; i2 < this.u.size() - 1; i2++) {
                    if (!this.v.contains(this.u.get(i2))) {
                        arrayList.add((zy0) this.u.get(i2));
                    }
                }
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((zy0) obj).close();
                }
                int size2 = this.u.size();
                ArrayList arrayList2 = this.u;
                this.t = size2;
                zy0 zy0Var = (zy0) arrayList2.get(size2 - 1);
                this.v.add(zy0Var);
                return zy0Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void f(xh2 xh2Var) {
        az0 az0Var;
        Executor executor;
        synchronized (this.a) {
            try {
                if (this.u.size() < n()) {
                    xh2Var.c(this);
                    this.u.add(xh2Var);
                    az0Var = this.j;
                    executor = this.k;
                } else {
                    xq4.c(3, "TAG");
                    xh2Var.close();
                    az0Var = null;
                    executor = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (az0Var != null) {
            if (executor != null) {
                executor.execute(new o8(22, this, az0Var));
            } else {
                az0Var.c(this);
            }
        }
    }

    public final void g(bz0 bz0Var) {
        zy0 zy0VarP;
        synchronized (this.a) {
            try {
                if (this.f) {
                    return;
                }
                int size = this.s.size() + this.u.size();
                if (size >= bz0Var.n()) {
                    xq4.c(3, "MetadataImageReader");
                    return;
                }
                do {
                    try {
                        zy0VarP = bz0Var.p();
                        if (zy0VarP != null) {
                            this.c--;
                            size++;
                            this.s.put(zy0VarP.m().d(), zy0VarP);
                            i();
                        }
                    } catch (IllegalStateException unused) {
                        xq4.c(3, "MetadataImageReader");
                        zy0VarP = null;
                    }
                    if (zy0VarP == null || this.c <= 0) {
                        break;
                    }
                } while (size < bz0Var.n());
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.bz0
    public final Surface getSurface() {
        Surface surface;
        synchronized (this.a) {
            surface = this.i.getSurface();
        }
        return surface;
    }

    @Override // defpackage.bz0
    public final int h() {
        int iH;
        synchronized (this.a) {
            iH = this.i.h();
        }
        return iH;
    }

    public final void i() {
        synchronized (this.a) {
            try {
                for (int size = this.n.size() - 1; size >= 0; size--) {
                    vy0 vy0Var = (vy0) this.n.valueAt(size);
                    long jD = vy0Var.d();
                    zy0 zy0Var = (zy0) this.s.get(jD);
                    if (zy0Var != null) {
                        this.s.remove(jD);
                        this.n.removeAt(size);
                        f(new xh2(zy0Var, null, vy0Var));
                    }
                }
                k();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.bz0
    public final void j() {
        synchronized (this.a) {
            this.i.j();
            this.j = null;
            this.k = null;
            this.c = 0;
        }
    }

    public final void k() {
        synchronized (this.a) {
            try {
                if (this.s.size() != 0 && this.n.size() != 0) {
                    long jKeyAt = this.s.keyAt(0);
                    Long lValueOf = Long.valueOf(jKeyAt);
                    long jKeyAt2 = this.n.keyAt(0);
                    hh1.b(!Long.valueOf(jKeyAt2).equals(lValueOf));
                    if (jKeyAt2 > jKeyAt) {
                        for (int size = this.s.size() - 1; size >= 0; size--) {
                            if (this.s.keyAt(size) < jKeyAt2) {
                                ((zy0) this.s.valueAt(size)).close();
                                this.s.removeAt(size);
                            }
                        }
                    } else {
                        for (int size2 = this.n.size() - 1; size2 >= 0; size2--) {
                            if (this.n.keyAt(size2) < jKeyAt) {
                                this.n.removeAt(size2);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.bz0
    public final void l(az0 az0Var, Executor executor) {
        synchronized (this.a) {
            az0Var.getClass();
            this.j = az0Var;
            executor.getClass();
            this.k = executor;
            this.i.l(this.e, executor);
        }
    }

    @Override // defpackage.bz0
    public final int n() {
        int iN;
        synchronized (this.a) {
            iN = this.i.n();
        }
        return iN;
    }

    @Override // defpackage.bz0
    public final zy0 p() {
        synchronized (this.a) {
            try {
                if (this.u.isEmpty()) {
                    return null;
                }
                if (this.t >= this.u.size()) {
                    throw new IllegalStateException("Maximum image number reached.");
                }
                ArrayList arrayList = this.u;
                int i = this.t;
                this.t = i + 1;
                zy0 zy0Var = (zy0) arrayList.get(i);
                this.v.add(zy0Var);
                return zy0Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
