package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class cf2 {
    public static final ze2 a = new ze2(new byte[0], 0, 0, false, false);
    public static final int b;
    public static final AtomicReference[] c;

    static {
        int iHighestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        b = iHighestOneBit;
        AtomicReference[] atomicReferenceArr = new AtomicReference[iHighestOneBit];
        for (int i = 0; i < iHighestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference();
        }
        c = atomicReferenceArr;
    }

    public static final void a(ze2 ze2Var) {
        ze2Var.getClass();
        if (ze2Var.f != null || ze2Var.g != null) {
            og.i("Failed requirement.");
            return;
        }
        if (ze2Var.d) {
            return;
        }
        AtomicReference atomicReference = c[(int) (Thread.currentThread().getId() & (((long) b) - 1))];
        ze2 ze2Var2 = a;
        ze2 ze2Var3 = (ze2) atomicReference.getAndSet(ze2Var2);
        if (ze2Var3 == ze2Var2) {
            return;
        }
        int i = ze2Var3 != null ? ze2Var3.c : 0;
        if (i >= 65536) {
            atomicReference.set(ze2Var3);
            return;
        }
        ze2Var.f = ze2Var3;
        ze2Var.b = 0;
        ze2Var.c = i + 8192;
        atomicReference.set(ze2Var);
    }

    public static final ze2 b() {
        AtomicReference atomicReference = c[(int) (Thread.currentThread().getId() & (((long) b) - 1))];
        ze2 ze2Var = a;
        ze2 ze2Var2 = (ze2) atomicReference.getAndSet(ze2Var);
        if (ze2Var2 == ze2Var) {
            return new ze2();
        }
        if (ze2Var2 == null) {
            atomicReference.set(null);
            return new ze2();
        }
        atomicReference.set(ze2Var2.f);
        ze2Var2.f = null;
        ze2Var2.c = 0;
        return ze2Var2;
    }
}
