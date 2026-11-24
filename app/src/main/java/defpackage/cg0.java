package defpackage;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class cg0 implements yt2, SurfaceTexture.OnFrameAvailableListener {
    public final ag0 a;
    public final HandlerThread b;
    public final xv0 c;
    public final Handler d;
    public int e;
    public boolean f;
    public final AtomicBoolean g;
    public final LinkedHashMap h;
    public SurfaceTexture i;
    public SurfaceTexture j;

    public cg0(ig0 ig0Var, qs4 qs4Var, qs4 qs4Var2) {
        Map map = Collections.EMPTY_MAP;
        this.e = 0;
        this.f = false;
        this.g = new AtomicBoolean(false);
        this.h = new LinkedHashMap();
        HandlerThread handlerThread = new HandlerThread("GL Thread");
        this.b = handlerThread;
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.d = handler;
        this.c = new xv0(handler);
        this.a = new ag0(qs4Var, qs4Var2);
        try {
            f(ig0Var);
        } catch (RuntimeException e) {
            a();
            throw e;
        }
    }

    @Override // defpackage.yt2
    public final void a() {
        if (this.g.getAndSet(true)) {
            return;
        }
        e(new s7(19, this), new c7(1));
    }

    @Override // defpackage.yt2
    public final void b(xt2 xt2Var) {
        if (this.g.get()) {
            xt2Var.close();
            return;
        }
        o8 o8Var = new o8(16, this, xt2Var);
        Objects.requireNonNull(xt2Var);
        e(o8Var, new s7(16, xt2Var));
    }

    @Override // defpackage.yt2
    public final void c(fu2 fu2Var) {
        if (this.g.get()) {
            fu2Var.c();
        } else {
            e(new o8(15, this, fu2Var), new db0(fu2Var, 0));
        }
    }

    public final void d() {
        if (this.f && this.e == 0) {
            LinkedHashMap linkedHashMap = this.h;
            Iterator it = linkedHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((xt2) it.next()).close();
            }
            linkedHashMap.clear();
            ag0 ag0Var = this.a;
            if (((AtomicBoolean) ag0Var.c).getAndSet(false)) {
                ur0.c((Thread) ag0Var.f);
                ag0Var.q();
            }
            ag0Var.w = -1;
            ag0Var.x = -1;
            this.b.quit();
        }
    }

    public final void e(Runnable runnable, Runnable runnable2) {
        try {
            this.c.execute(new dc(this, runnable2, runnable, 7));
        } catch (RejectedExecutionException e) {
            xq4.e("DualSurfaceProcessor", "Unable to executor runnable", e);
            runnable2.run();
        }
    }

    public final void f(ig0 ig0Var) {
        Map map = Collections.EMPTY_MAP;
        tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        tpVar.a = cq.class;
        try {
            e(new dc(this, ig0Var, tpVar), new c7(1));
            tpVar.a = "Init GlRenderer";
        } catch (Exception e) {
            wpVar.b(e);
        }
        try {
            wpVar.get();
        } catch (InterruptedException | ExecutionException e2) {
            e = e2;
            if (e instanceof ExecutionException) {
                e = e.getCause();
            }
            if (!(e instanceof RuntimeException)) {
                throw new IllegalStateException("Failed to create DefaultSurfaceProcessor", e);
            }
            throw ((RuntimeException) e);
        }
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public final void onFrameAvailable(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2;
        if (this.g.get() || (surfaceTexture2 = this.i) == null || this.j == null) {
            return;
        }
        surfaceTexture2.updateTexImage();
        this.j.updateTexImage();
        for (Map.Entry entry : this.h.entrySet()) {
            Surface surface = (Surface) entry.getValue();
            xt2 xt2Var = (xt2) entry.getKey();
            if (xt2Var.c == 34) {
                try {
                    this.a.u(surfaceTexture.getTimestamp(), surface, xt2Var, this.i, this.j);
                } catch (RuntimeException e) {
                    xq4.b("DualSurfaceProcessor", "Failed to render with OpenGL.", e);
                }
            }
        }
    }
}
