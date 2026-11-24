package defpackage;

import java.util.ArrayList;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lw2 {
    public final mw2 a;
    public final String b;
    public boolean c;
    public gw2 d;
    public final ArrayList e = new ArrayList();
    public boolean f;

    public lw2(mw2 mw2Var, String str) {
        this.a = mw2Var;
        this.b = str;
    }

    public final void a() {
        byte[] bArr = z53.a;
        synchronized (this.a) {
            if (b()) {
                this.a.d(this);
            }
        }
    }

    public final boolean b() {
        gw2 gw2Var = this.d;
        if (gw2Var != null && gw2Var.b) {
            this.f = true;
        }
        ArrayList arrayList = this.e;
        boolean z = false;
        for (int size = arrayList.size() - 1; -1 < size; size--) {
            if (((gw2) arrayList.get(size)).b) {
                gw2 gw2Var2 = (gw2) arrayList.get(size);
                mw2 mw2Var = mw2.h;
                if (mw2.i.isLoggable(Level.FINE)) {
                    gb4.a(gw2Var2, this, "canceled");
                }
                arrayList.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final void c(gw2 gw2Var, long j) {
        gw2Var.getClass();
        synchronized (this.a) {
            if (!this.c) {
                if (d(gw2Var, j, false)) {
                    this.a.d(this);
                }
            } else if (gw2Var.b) {
                mw2 mw2Var = mw2.h;
                if (mw2.i.isLoggable(Level.FINE)) {
                    gb4.a(gw2Var, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                mw2 mw2Var2 = mw2.h;
                if (mw2.i.isLoggable(Level.FINE)) {
                    gb4.a(gw2Var, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0045 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x0047  */
    /* JADX WARN: Code duplicated, block: B:20:0x0053  */
    /* JADX WARN: Code duplicated, block: B:24:0x0069  */
    /* JADX WARN: Code duplicated, block: B:27:0x0079 A[LOOP:0: B:23:0x0067->B:27:0x0079, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:30:0x007f  */
    /* JADX WARN: Code duplicated, block: B:33:0x0088 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:38:0x007c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x007d A[EDGE_INSN: B:39:0x007d->B:29:0x007d BREAK  A[LOOP:0: B:23:0x0067->B:27:0x0079], SYNTHETIC] */
    public final boolean d(gw2 gw2Var, long j, boolean z) {
        int size;
        int size2;
        int i;
        Object obj;
        String strConcat;
        gw2Var.getClass();
        lw2 lw2Var = gw2Var.c;
        if (lw2Var != this) {
            if (lw2Var != null) {
                og.n("task is in multiple queues");
                return false;
            }
            gw2Var.c = this;
        }
        long jNanoTime = System.nanoTime();
        long j2 = jNanoTime + j;
        ArrayList arrayList = this.e;
        int iIndexOf = arrayList.indexOf(gw2Var);
        if (iIndexOf == -1) {
            gw2Var.d = j2;
            mw2 mw2Var = mw2.h;
            if (mw2.i.isLoggable(Level.FINE)) {
                if (z) {
                    strConcat = "run again after ".concat(gb4.b(j2 - jNanoTime));
                } else {
                    strConcat = "scheduled after ".concat(gb4.b(j2 - jNanoTime));
                }
                gb4.a(gw2Var, this, strConcat);
            }
            size = arrayList.size();
            size2 = 0;
            i = 0;
            while (true) {
                if (i < size) {
                    size2 = -1;
                    break;
                }
                obj = arrayList.get(i);
                i++;
                if (((gw2) obj).d - jNanoTime > j) {
                    break;
                }
                size2++;
            }
            if (size2 == -1) {
                size2 = arrayList.size();
            }
            arrayList.add(size2, gw2Var);
            if (size2 == 0) {
                return true;
            }
        } else if (gw2Var.d <= j2) {
            mw2 mw2Var2 = mw2.h;
            if (mw2.i.isLoggable(Level.FINE)) {
                gb4.a(gw2Var, this, "already scheduled");
                return false;
            }
        } else {
            arrayList.remove(iIndexOf);
            gw2Var.d = j2;
            mw2 mw2Var3 = mw2.h;
            if (mw2.i.isLoggable(Level.FINE)) {
                if (z) {
                    strConcat = "run again after ".concat(gb4.b(j2 - jNanoTime));
                } else {
                    strConcat = "scheduled after ".concat(gb4.b(j2 - jNanoTime));
                }
                gb4.a(gw2Var, this, strConcat);
            }
            size = arrayList.size();
            size2 = 0;
            i = 0;
            while (true) {
                if (i < size) {
                    size2 = -1;
                    break;
                }
                obj = arrayList.get(i);
                i++;
                if (((gw2) obj).d - jNanoTime > j) {
                    break;
                    break;
                }
                size2++;
            }
            if (size2 == -1) {
                size2 = arrayList.size();
            }
            arrayList.add(size2, gw2Var);
            if (size2 == 0) {
                return true;
            }
        }
        return false;
    }

    public final void e() {
        byte[] bArr = z53.a;
        synchronized (this.a) {
            this.c = true;
            if (b()) {
                this.a.d(this);
            }
        }
    }

    public final String toString() {
        return this.b;
    }
}
