package defpackage;

import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pr2 implements Runnable {
    public static final Object k = new Object();
    public final Executor a;
    public final bp1 b;
    public final AtomicReference e;
    public final AtomicBoolean c = new AtomicBoolean(true);
    public Object f = k;
    public int i = -1;
    public boolean j = false;

    public pr2(AtomicReference atomicReference, Executor executor, bp1 bp1Var) {
        this.e = atomicReference;
        this.a = executor;
        this.b = bp1Var;
    }

    public final void a(int i) {
        synchronized (this) {
            try {
                if (this.c.get()) {
                    if (i <= this.i) {
                        return;
                    }
                    this.i = i;
                    if (this.j) {
                        return;
                    }
                    this.j = true;
                    try {
                        this.a.execute(this);
                    } catch (Throwable unused) {
                        synchronized (this) {
                            this.j = false;
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this) {
            try {
                if (!this.c.get()) {
                    this.j = false;
                    return;
                }
                Object obj = this.e.get();
                int i = this.i;
                while (true) {
                    if (!Objects.equals(this.f, obj)) {
                        this.f = obj;
                        boolean z = obj instanceof ej;
                        bp1 bp1Var = this.b;
                        if (z) {
                            bp1Var.onError(null);
                        } else {
                            bp1Var.m(obj);
                        }
                    }
                    synchronized (this) {
                        try {
                            if (i == this.i || !this.c.get()) {
                                break;
                                break;
                            } else {
                                obj = this.e.get();
                                i = this.i;
                            }
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                }
                this.j = false;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
