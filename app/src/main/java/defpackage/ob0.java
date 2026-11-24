package defpackage;

import android.util.Log;
import android.util.Size;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class ob0 {
    public static final Size k = new Size(0, 0);
    public static final boolean l = xq4.c(3, "DeferrableSurface");
    public static final AtomicInteger m = new AtomicInteger(0);
    public static final AtomicInteger n = new AtomicInteger(0);
    public final Object a = new Object();
    public int b = 0;
    public boolean c = false;
    public tp d;
    public final wp e;
    public tp f;
    public final wp g;
    public final Size h;
    public final int i;
    public Class j;

    public ob0(Size size, int i) {
        final int i2 = 0;
        this.h = size;
        this.i = i;
        wp wpVarA = hg4.a(new up(this) { // from class: mb0
            public final /* synthetic */ ob0 b;

            {
                this.b = this;
            }

            @Override // defpackage.up
            public final Object d(tp tpVar) {
                int i3 = i2;
                ob0 ob0Var = this.b;
                switch (i3) {
                    case 0:
                        synchronized (ob0Var.a) {
                            ob0Var.d = tpVar;
                            break;
                        }
                        return "DeferrableSurface-termination(" + ob0Var + ")";
                    default:
                        synchronized (ob0Var.a) {
                            ob0Var.f = tpVar;
                            break;
                        }
                        return "DeferrableSurface-close(" + ob0Var + ")";
                }
            }
        });
        this.e = wpVarA;
        final int i3 = 1;
        this.g = hg4.a(new up(this) { // from class: mb0
            public final /* synthetic */ ob0 b;

            {
                this.b = this;
            }

            @Override // defpackage.up
            public final Object d(tp tpVar) {
                int i4 = i3;
                ob0 ob0Var = this.b;
                switch (i4) {
                    case 0:
                        synchronized (ob0Var.a) {
                            ob0Var.d = tpVar;
                            break;
                        }
                        return "DeferrableSurface-termination(" + ob0Var + ")";
                    default:
                        synchronized (ob0Var.a) {
                            ob0Var.f = tpVar;
                            break;
                        }
                        return "DeferrableSurface-close(" + ob0Var + ")";
                }
            }
        });
        if (xq4.c(3, "DeferrableSurface")) {
            n.incrementAndGet();
            m.get();
            e();
            wpVarA.b.a(new o8(14, this, Log.getStackTraceString(new Exception())), xg4.a());
        }
    }

    public void a() {
        tp tpVar;
        synchronized (this.a) {
            try {
                if (this.c) {
                    tpVar = null;
                } else {
                    this.c = true;
                    this.f.a(null);
                    if (this.b == 0) {
                        tpVar = this.d;
                        this.d = null;
                    } else {
                        tpVar = null;
                    }
                    if (xq4.c(3, "DeferrableSurface")) {
                        toString();
                        xq4.c(3, "DeferrableSurface");
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (tpVar != null) {
            tpVar.a(null);
        }
    }

    public final void b() {
        tp tpVar;
        synchronized (this.a) {
            try {
                int i = this.b;
                if (i == 0) {
                    throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
                }
                int i2 = i - 1;
                this.b = i2;
                if (i2 == 0 && this.c) {
                    tpVar = this.d;
                    this.d = null;
                } else {
                    tpVar = null;
                }
                if (xq4.c(3, "DeferrableSurface")) {
                    toString();
                    xq4.c(3, "DeferrableSurface");
                    if (this.b == 0) {
                        n.get();
                        m.decrementAndGet();
                        e();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (tpVar != null) {
            tpVar.a(null);
        }
    }

    public final wc1 c() {
        synchronized (this.a) {
            try {
                if (this.c) {
                    return new mz0(1, new nb0("DeferrableSurface already closed.", this));
                }
                return f();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d() {
        synchronized (this.a) {
            try {
                int i = this.b;
                if (i == 0 && this.c) {
                    throw new nb0("Cannot begin use on a closed surface.", this);
                }
                this.b = i + 1;
                if (xq4.c(3, "DeferrableSurface")) {
                    if (this.b == 1) {
                        n.get();
                        m.incrementAndGet();
                        e();
                    }
                    toString();
                    xq4.c(3, "DeferrableSurface");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e() {
        if (!l && xq4.c(3, "DeferrableSurface")) {
            xq4.c(3, "DeferrableSurface");
        }
        toString();
        xq4.c(3, "DeferrableSurface");
    }

    public abstract wc1 f();
}
