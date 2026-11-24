package defpackage;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ue1 {
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ long _state$volatile;
    public final int a;
    public final boolean b;
    public final int c;
    public final /* synthetic */ AtomicReferenceArray d;
    public static final /* synthetic */ AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(ue1.class, Object.class, "_next$volatile");
    public static final /* synthetic */ long h = zj.a.objectFieldOffset(ue1.class.getDeclaredField("_next$volatile"));
    public static final /* synthetic */ AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(ue1.class, "_state$volatile");
    public static final py0 g = new py0(16, "REMOVE_FROZEN");

    public ue1(int i, boolean z) {
        this.a = i;
        this.b = z;
        int i2 = i - 1;
        this.c = i2;
        this.d = new AtomicReferenceArray(i);
        if (i2 > 1073741823) {
            og.n("Check failed.");
            throw null;
        }
        if ((i & i2) == 0) {
            return;
        }
        og.n("Check failed.");
        throw null;
    }

    public final int a(Object obj) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            long j = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j) != 0) {
                return (2305843009213693952L & j) != 0 ? 2 : 1;
            }
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.c;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            boolean z = this.b;
            AtomicReferenceArray atomicReferenceArray = this.d;
            if (z || atomicReferenceArray.get(i2 & i3) == null) {
                ue1 ue1Var = this;
                if (f.compareAndSet(ue1Var, j, ((-1152921503533105153L) & j) | (((long) ((i2 + 1) & 1073741823)) << 30))) {
                    atomicReferenceArray.set(i2 & i3, obj);
                    ue1 ue1VarD = ue1Var;
                    while ((atomicLongFieldUpdater.get(ue1VarD) & 1152921504606846976L) != 0) {
                        ue1VarD = ue1VarD.d();
                        AtomicReferenceArray atomicReferenceArray2 = ue1VarD.d;
                        int i4 = ue1VarD.c & i2;
                        Object obj2 = atomicReferenceArray2.get(i4);
                        if ((obj2 instanceof te1) && ((te1) obj2).a == i2) {
                            atomicReferenceArray2.set(i4, obj);
                        } else {
                            ue1VarD = null;
                        }
                        if (ue1VarD == null) {
                            return 0;
                        }
                    }
                    return 0;
                }
                this = ue1Var;
            } else {
                int i5 = this.a;
                if (i5 < 1024 || ((i2 - i) & 1073741823) > (i5 >> 1)) {
                    return 1;
                }
            }
        }
    }

    public final ue1 b(long j) {
        ue1 ue1Var;
        while (true) {
            e.getClass();
            Unsafe unsafe = zj.a;
            long j2 = h;
            ue1 ue1Var2 = (ue1) unsafe.getObjectVolatile(this, j2);
            if (ue1Var2 != null) {
                return ue1Var2;
            }
            ue1 ue1Var3 = new ue1(this.a * 2, this.b);
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i3 = this.c;
                int i4 = i & i3;
                if (i4 == (i3 & i2)) {
                    break;
                }
                Object te1Var = this.d.get(i4);
                if (te1Var == null) {
                    te1Var = new te1(i);
                }
                ue1Var3.d.set(ue1Var3.c & i, te1Var);
                i++;
            }
            f.set(ue1Var3, (-1152921504606846977L) & j);
            while (true) {
                Unsafe unsafe2 = zj.a;
                ue1Var = this;
                if (unsafe2.compareAndSwapObject(ue1Var, h, (Object) null, ue1Var3) || unsafe2.getObjectVolatile(ue1Var, j2) != null) {
                    break;
                }
                this = ue1Var;
            }
            this = ue1Var;
        }
    }

    public final boolean c() {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            long j = atomicLongFieldUpdater.get(this);
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
            ue1 ue1Var = this;
            if (atomicLongFieldUpdater.compareAndSet(ue1Var, j, 2305843009213693952L | j)) {
                return true;
            }
            this = ue1Var;
        }
    }

    public final ue1 d() {
        long j;
        ue1 ue1Var;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                ue1Var = this;
                break;
            }
            long j2 = 1152921504606846976L | j;
            ue1Var = this;
            if (atomicLongFieldUpdater.compareAndSet(ue1Var, j, j2)) {
                j = j2;
                break;
            }
            this = ue1Var;
        }
        return ue1Var.b(j);
    }

    public final Object e() {
        ue1 ue1VarD = this;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            long j = atomicLongFieldUpdater.get(ue1VarD);
            if ((j & 1152921504606846976L) != 0) {
                return g;
            }
            int i = (int) (j & 1073741823);
            int i2 = ue1VarD.c;
            int i3 = i & i2;
            if ((((int) ((1152921503533105152L & j) >> 30)) & i2) != i3) {
                AtomicReferenceArray atomicReferenceArray = ue1VarD.d;
                Object obj = atomicReferenceArray.get(i3);
                boolean z = ue1VarD.b;
                if (obj == null) {
                    if (z) {
                    }
                } else if (!(obj instanceof te1)) {
                    long j2 = (i + 1) & 1073741823;
                    if (f.compareAndSet(ue1VarD, j, (j & (-1073741824)) | j2)) {
                        atomicReferenceArray.set(i3, null);
                        return obj;
                    }
                    ue1VarD = this;
                    if (z) {
                        while (true) {
                            long j3 = atomicLongFieldUpdater.get(ue1VarD);
                            int i4 = (int) (j3 & 1073741823);
                            if ((j3 & 1152921504606846976L) != 0) {
                                ue1VarD = ue1VarD.d();
                            } else {
                                ue1 ue1Var = ue1VarD;
                                if (f.compareAndSet(ue1Var, j3, (j3 & (-1073741824)) | j2)) {
                                    ue1Var.d.set(i4 & ue1Var.c, null);
                                    ue1VarD = null;
                                } else {
                                    ue1VarD = ue1Var;
                                }
                            }
                            if (ue1VarD == null) {
                                return obj;
                            }
                        }
                    }
                }
            }
            return null;
        }
    }
}
