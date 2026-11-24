package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class mj0 implements Runnable, Comparable, rd0 {
    private volatile Object _heap;
    public long a;
    public int b = -1;

    public mj0(long j) {
        this.a = j;
    }

    @Override // defpackage.rd0
    public final void a() {
        synchronized (this) {
            try {
                Object obj = this._heap;
                py0 py0Var = dz3.a;
                if (obj == py0Var) {
                    return;
                }
                nj0 nj0Var = obj instanceof nj0 ? (nj0) obj : null;
                if (nj0Var != null) {
                    synchronized (nj0Var) {
                        Object obj2 = this._heap;
                        if ((obj2 instanceof k03 ? (k03) obj2 : null) != null) {
                            nj0Var.b(this.b);
                        }
                    }
                }
                this._heap = py0Var;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int c(long j, nj0 nj0Var, oj0 oj0Var) {
        synchronized (this) {
            if (this._heap == dz3.a) {
                return 2;
            }
            synchronized (nj0Var) {
                try {
                    mj0[] mj0VarArr = nj0Var.a;
                    mj0 mj0Var = mj0VarArr != null ? mj0VarArr[0] : null;
                    if (oj0.n.get(oj0Var) == 1) {
                        return 1;
                    }
                    if (mj0Var == null) {
                        nj0Var.c = j;
                    } else {
                        long j2 = mj0Var.a;
                        if (j2 - j < 0) {
                            j = j2;
                        }
                        if (j - nj0Var.c > 0) {
                            nj0Var.c = j;
                        }
                    }
                    long j3 = this.a;
                    long j4 = nj0Var.c;
                    if (j3 - j4 < 0) {
                        this.a = j4;
                    }
                    nj0Var.a(this);
                    return 0;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        long j = this.a - ((mj0) obj).a;
        if (j > 0) {
            return 1;
        }
        return j < 0 ? -1 : 0;
    }

    public final void d(nj0 nj0Var) {
        if (this._heap != dz3.a) {
            this._heap = nj0Var;
        } else {
            og.i("Failed requirement.");
        }
    }

    public String toString() {
        return "Delayed[nanos=" + this.a + ']';
    }
}
