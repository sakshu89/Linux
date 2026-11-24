package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class se1 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(se1.class, Object.class, "_cur$volatile");
    public static final /* synthetic */ long b = zj.a.objectFieldOffset(se1.class.getDeclaredField("_cur$volatile"));
    private volatile /* synthetic */ Object _cur$volatile = new ue1(8, false);

    public final boolean a(Runnable runnable) {
        se1 se1Var;
        while (true) {
            a.getClass();
            Unsafe unsafe = zj.a;
            long j = b;
            ue1 ue1Var = (ue1) unsafe.getObjectVolatile(this, j);
            int iA = ue1Var.a(runnable);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                ue1 ue1VarD = ue1Var.d();
                while (true) {
                    Unsafe unsafe2 = zj.a;
                    se1Var = this;
                    if (unsafe2.compareAndSwapObject(se1Var, b, ue1Var, ue1VarD) || unsafe2.getObjectVolatile(se1Var, j) != ue1Var) {
                        break;
                    }
                    this = se1Var;
                }
            } else {
                if (iA == 2) {
                    return false;
                }
                se1Var = this;
            }
            this = se1Var;
        }
    }

    public final void b() {
        se1 se1Var;
        while (true) {
            a.getClass();
            Unsafe unsafe = zj.a;
            long j = b;
            ue1 ue1Var = (ue1) unsafe.getObjectVolatile(this, j);
            if (ue1Var.c()) {
                return;
            }
            ue1 ue1VarD = ue1Var.d();
            while (true) {
                Unsafe unsafe2 = zj.a;
                se1Var = this;
                if (unsafe2.compareAndSwapObject(se1Var, b, ue1Var, ue1VarD) || unsafe2.getObjectVolatile(se1Var, j) != ue1Var) {
                    break;
                } else {
                    this = se1Var;
                }
            }
            this = se1Var;
        }
    }

    public final int c() {
        a.getClass();
        ue1 ue1Var = (ue1) zj.a.getObjectVolatile(this, b);
        ue1Var.getClass();
        long j = ue1.f.get(ue1Var);
        return 1073741823 & (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j)));
    }

    public final Object d() {
        se1 se1Var;
        while (true) {
            a.getClass();
            Unsafe unsafe = zj.a;
            long j = b;
            ue1 ue1Var = (ue1) unsafe.getObjectVolatile(this, j);
            Object objE = ue1Var.e();
            if (objE != ue1.g) {
                return objE;
            }
            ue1 ue1VarD = ue1Var.d();
            while (true) {
                Unsafe unsafe2 = zj.a;
                se1Var = this;
                if (unsafe2.compareAndSwapObject(se1Var, b, ue1Var, ue1VarD) || unsafe2.getObjectVolatile(se1Var, j) != ue1Var) {
                    break;
                }
                this = se1Var;
            }
            this = se1Var;
        }
    }
}
