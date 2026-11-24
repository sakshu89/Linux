package defpackage;

import android.os.Trace;
import android.view.Choreographer;
import android.view.Display;
import android.view.View;
import java.util.PriorityQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ib implements uz1, View.OnAttachStateChangeListener, Runnable, Choreographer.FrameCallback {
    public static long k;
    public final View a;
    public boolean c;
    public boolean i;
    public long j;
    public final PriorityQueue b = new PriorityQueue(11, new gb(0));
    public final Choreographer e = Choreographer.getInstance();
    public final hb f = new hb();

    /* JADX WARN: Code duplicated, block: B:10:0x0040  */
    public ib(View view) {
        float refreshRate;
        this.a = view;
        if (k == 0) {
            Display display = view.getDisplay();
            if (!view.isInEditMode() && display != null) {
                refreshRate = display.getRefreshRate();
                refreshRate = refreshRate < 30.0f ? 60.0f : refreshRate;
            }
            k = (long) (1.0E9f / refreshRate);
        }
        view.addOnAttachStateChangeListener(this);
        if (view.isAttachedToWindow()) {
            this.i = true;
        }
    }

    @Override // defpackage.uz1
    public final void a(tz1 tz1Var) {
        this.b.add(new x02(1, tz1Var));
        if (this.c) {
            return;
        }
        this.c = true;
        this.a.post(this);
    }

    public final boolean b() {
        hb hbVar = this.f;
        long jA = hbVar.a();
        ge4.a(jA, "compose:lazy:prefetch:available_time_nanos");
        boolean z = true;
        if (jA > 0) {
            PriorityQueue priorityQueue = this.b;
            Object objPeek = priorityQueue.peek();
            objPeek.getClass();
            if (!((x02) objPeek).b.c(hbVar)) {
                priorityQueue.poll();
                z = false;
            }
            hbVar.a = false;
        }
        return z;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        if (this.i) {
            this.j = j;
            this.a.post(this);
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.i = true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.i = false;
        this.a.removeCallbacks(this);
        this.e.removeFrameCallback(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        PriorityQueue priorityQueue = this.b;
        if (!priorityQueue.isEmpty() && this.c && this.i) {
            View view = this.a;
            if (view.getWindowVisibility() == 0) {
                long nanos = TimeUnit.MILLISECONDS.toNanos(view.getDrawingTime());
                boolean z = System.nanoTime() > (2 * k) + nanos;
                hb hbVar = this.f;
                hbVar.a = z;
                hbVar.b = Math.max(this.j, nanos) + k;
                boolean zB = false;
                while (!priorityQueue.isEmpty() && !zB) {
                    if (hbVar.a) {
                        Trace.beginSection("compose:lazy:prefetch:idle_frame");
                        try {
                            zB = b();
                            Trace.endSection();
                        } catch (Throwable th) {
                            Trace.endSection();
                            throw th;
                        }
                    } else {
                        zB = b();
                    }
                }
                if (zB) {
                    this.e.postFrameCallback(this);
                } else {
                    this.c = false;
                }
                ge4.a(0L, "compose:lazy:prefetch:available_time_nanos");
                return;
            }
        }
        this.c = false;
    }
}
