package defpackage;

import android.os.Trace;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kv1 {
    public final g30 a;
    public final a30 b;
    public final x20 c;
    public final vq0 d;
    public final boolean e;
    public final b43 f;
    public final Object g;
    public final AtomicReference h = new AtomicReference(mv1.c);
    public long i = tc4.a();
    public hm1 j;
    public final i52 k;
    public final g42 l;

    public kv1(g30 g30Var, a30 a30Var, x20 x20Var, jm1 jm1Var, vq0 vq0Var, boolean z, b43 b43Var, Object obj) {
        this.a = g30Var;
        this.b = a30Var;
        this.c = x20Var;
        this.d = vq0Var;
        this.e = z;
        this.f = b43Var;
        this.g = obj;
        hm1 hm1Var = za2.a;
        hm1Var.getClass();
        this.j = hm1Var;
        i52 i52Var = new i52();
        i52Var.g(jm1Var, x20Var.z());
        this.k = i52Var;
        this.l = new g42(b43Var.c);
    }

    public final void a() throws Exception {
        AtomicReference atomicReference = this.h;
        try {
            switch (((mv1) atomicReference.get()).ordinal()) {
                case 0:
                    throw new IllegalStateException("The paused composition is invalid because of a previous exception");
                case 1:
                    throw new IllegalStateException("The paused composition has been cancelled");
                case 2:
                case 3:
                case 4:
                    throw new IllegalStateException("The paused composition has not completed yet");
                case 5:
                    b();
                    mv1 mv1Var = mv1.i;
                    mv1 mv1Var2 = mv1.j;
                    while (!atomicReference.compareAndSet(mv1Var, mv1Var2)) {
                        if (atomicReference.get() != mv1Var) {
                            dz1.b("Unexpected state change from: " + mv1Var + " to: " + mv1Var2 + '.');
                            return;
                        }
                    }
                    return;
                case 6:
                    throw new IllegalStateException("The paused composition has already been applied");
                default:
                    throw new b10();
            }
        } catch (Exception e) {
            atomicReference.set(mv1.a);
            throw e;
        }
    }

    public final void b() {
        Trace.beginSection("PausedComposition:applyChanges");
        try {
            synchronized (this.g) {
                try {
                    this.l.k(this.f, this.k);
                    this.k.c();
                    this.k.d();
                    this.k.b();
                    this.a.X = null;
                } catch (Throwable th) {
                    this.k.b();
                    this.a.X = null;
                    throw th;
                }
            }
            Trace.endSection();
        } catch (Throwable th2) {
            Trace.endSection();
            throw th2;
        }
    }

    public final boolean c() {
        return ((mv1) this.h.get()).compareTo(mv1.i) >= 0;
    }

    public final void d() {
        mv1 mv1Var;
        mv1 mv1Var2;
        boolean z;
        while (true) {
            AtomicReference atomicReference = this.h;
            mv1Var = mv1.e;
            mv1Var2 = mv1.i;
            if (atomicReference.compareAndSet(mv1Var, mv1Var2)) {
                z = true;
                break;
            } else if (atomicReference.get() != mv1Var) {
                z = false;
                break;
            }
        }
        if (z) {
            return;
        }
        dz1.b("Unexpected state change from: " + mv1Var + " to: " + mv1Var2 + '.');
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:28:0x0082 A[Catch: Exception -> 0x0023, TryCatch #2 {Exception -> 0x0023, blocks: (B:3:0x0004, B:6:0x001d, B:7:0x0022, B:10:0x0026, B:11:0x002d, B:12:0x002e, B:13:0x0035, B:14:0x0036, B:15:0x0040, B:16:0x0041, B:22:0x0069, B:24:0x0079, B:25:0x007b, B:31:0x00a3, B:33:0x00ab, B:28:0x0082, B:30:0x0088, B:35:0x00b1, B:36:0x00b3, B:38:0x00b9, B:41:0x00c0, B:42:0x00db, B:19:0x0048, B:21:0x004e, B:46:0x00e4, B:49:0x00f3, B:50:0x00f6, B:51:0x00f8, B:57:0x0120, B:59:0x0128, B:54:0x00ff, B:56:0x0105, B:64:0x0133, B:65:0x0136, B:66:0x0137, B:67:0x013e, B:68:0x013f, B:69:0x0146, B:47:0x00e9, B:23:0x006b), top: B:76:0x0004, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:33:0x00ab A[Catch: Exception -> 0x0023, TryCatch #2 {Exception -> 0x0023, blocks: (B:3:0x0004, B:6:0x001d, B:7:0x0022, B:10:0x0026, B:11:0x002d, B:12:0x002e, B:13:0x0035, B:14:0x0036, B:15:0x0040, B:16:0x0041, B:22:0x0069, B:24:0x0079, B:25:0x007b, B:31:0x00a3, B:33:0x00ab, B:28:0x0082, B:30:0x0088, B:35:0x00b1, B:36:0x00b3, B:38:0x00b9, B:41:0x00c0, B:42:0x00db, B:19:0x0048, B:21:0x004e, B:46:0x00e4, B:49:0x00f3, B:50:0x00f6, B:51:0x00f8, B:57:0x0120, B:59:0x0128, B:54:0x00ff, B:56:0x0105, B:64:0x0133, B:65:0x0136, B:66:0x0137, B:67:0x013e, B:68:0x013f, B:69:0x0146, B:47:0x00e9, B:23:0x006b), top: B:76:0x0004, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:59:0x0128 A[Catch: Exception -> 0x0023, TRY_LEAVE, TryCatch #2 {Exception -> 0x0023, blocks: (B:3:0x0004, B:6:0x001d, B:7:0x0022, B:10:0x0026, B:11:0x002d, B:12:0x002e, B:13:0x0035, B:14:0x0036, B:15:0x0040, B:16:0x0041, B:22:0x0069, B:24:0x0079, B:25:0x007b, B:31:0x00a3, B:33:0x00ab, B:28:0x0082, B:30:0x0088, B:35:0x00b1, B:36:0x00b3, B:38:0x00b9, B:41:0x00c0, B:42:0x00db, B:19:0x0048, B:21:0x004e, B:46:0x00e4, B:49:0x00f3, B:50:0x00f6, B:51:0x00f8, B:57:0x0120, B:59:0x0128, B:54:0x00ff, B:56:0x0105, B:64:0x0133, B:65:0x0136, B:66:0x0137, B:67:0x013e, B:68:0x013f, B:69:0x0146, B:47:0x00e9, B:23:0x006b), top: B:76:0x0004, inners: #0, #1 }] */
    /* JADX WARN: Code duplicated, block: B:81:0x0088 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:82:? A[LOOP:1: B:25:0x007b->B:82:?, LOOP_END, SYNTHETIC] */
    public final boolean e(mk2 mk2Var) throws Exception {
        long j;
        mv1 mv1Var = mv1.f;
        AtomicReference atomicReference = this.h;
        try {
            int iOrdinal = ((mv1) atomicReference.get()).ordinal();
            mv1 mv1Var2 = mv1.e;
            g30 g30Var = this.a;
            a30 a30Var = this.b;
            switch (iOrdinal) {
                case 0:
                    throw new IllegalStateException("The paused composition is invalid because of a previous exception");
                case 1:
                    throw new IllegalStateException("The paused composition has been cancelled");
                case 2:
                    x20 x20Var = this.c;
                    boolean z = this.e;
                    if (z) {
                        x20Var.z = 100;
                        x20Var.y = true;
                    }
                    try {
                        this.j = a30Var.b(g30Var, mk2Var, this.d);
                        if (z) {
                            x20Var.s();
                        }
                        mv1 mv1Var3 = mv1.c;
                        while (!atomicReference.compareAndSet(mv1Var3, mv1Var2)) {
                            if (atomicReference.get() != mv1Var3) {
                                dz1.b("Unexpected state change from: " + mv1Var3 + " to: " + mv1Var2 + '.');
                                if (this.j.g()) {
                                    d();
                                }
                                return c();
                            }
                        }
                        if (this.j.g()) {
                            d();
                        }
                        return c();
                    } catch (Throwable th) {
                        if (z) {
                            x20Var.s();
                        }
                        throw th;
                    }
                case 3:
                    try {
                        while (!atomicReference.compareAndSet(mv1Var2, mv1Var)) {
                            if (atomicReference.get() != mv1Var2) {
                                dz1.b("Unexpected state change from: " + mv1Var2 + " to: " + mv1Var + '.');
                                j = this.i;
                                this.i = tc4.a();
                                this.j = a30Var.n(g30Var, mk2Var, this.j);
                                this.i = j;
                                while (!atomicReference.compareAndSet(mv1Var, mv1Var2)) {
                                    if (atomicReference.get() != mv1Var) {
                                        dz1.b("Unexpected state change from: " + mv1Var + " to: " + mv1Var2 + '.');
                                        if (this.j.g()) {
                                            d();
                                        }
                                        return c();
                                    }
                                }
                                if (this.j.g()) {
                                    d();
                                }
                                return c();
                            }
                        }
                        this.i = tc4.a();
                        this.j = a30Var.n(g30Var, mk2Var, this.j);
                        this.i = j;
                        while (!atomicReference.compareAndSet(mv1Var, mv1Var2)) {
                            if (atomicReference.get() != mv1Var) {
                                dz1.b("Unexpected state change from: " + mv1Var + " to: " + mv1Var2 + '.');
                                if (this.j.g()) {
                                    d();
                                }
                                return c();
                            }
                        }
                        if (this.j.g()) {
                            d();
                        }
                        return c();
                    } catch (Throwable th2) {
                        this.i = j;
                        while (!atomicReference.compareAndSet(mv1Var, mv1Var2)) {
                            if (atomicReference.get() != mv1Var) {
                                dz1.b("Unexpected state change from: " + mv1Var + " to: " + mv1Var2 + '.');
                                throw th2;
                            }
                        }
                        throw th2;
                    }
                    j = this.i;
                case 4:
                    y20.b("Recursive call to resume()");
                    throw new b10();
                case 5:
                    throw new IllegalStateException("Pausable composition is complete and apply() should be applied");
                case 6:
                    throw new IllegalStateException("The paused composition has been applied");
                default:
                    throw new b10();
            }
        } catch (Exception e) {
            atomicReference.set(mv1.a);
            throw e;
        }
    }
}
