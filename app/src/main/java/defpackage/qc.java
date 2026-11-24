package defpackage;

import android.os.Handler;
import android.view.Choreographer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class qc extends l70 {
    public static final cv2 v = new cv2(f8.t);
    public static final oc w = new oc(0);
    public final Choreographer c;
    public final Handler e;
    public boolean n;
    public boolean s;
    public final sc u;
    public final Object f = new Object();
    public final hg i = new hg();
    public ArrayList j = new ArrayList();
    public ArrayList k = new ArrayList();
    public final pc t = new pc(this);

    public qc(Choreographer choreographer, Handler handler) {
        this.c = choreographer;
        this.e = handler;
        this.u = new sc(choreographer, this);
    }

    public static final void P(qc qcVar) {
        Runnable runnable;
        boolean z;
        do {
            synchronized (qcVar.f) {
                hg hgVar = qcVar.i;
                runnable = (Runnable) (hgVar.isEmpty() ? null : hgVar.removeFirst());
            }
            while (runnable != null) {
                runnable.run();
                synchronized (qcVar.f) {
                    hg hgVar2 = qcVar.i;
                    runnable = (Runnable) (hgVar2.isEmpty() ? null : hgVar2.removeFirst());
                }
            }
            synchronized (qcVar.f) {
                if (qcVar.i.isEmpty()) {
                    z = false;
                    qcVar.n = false;
                } else {
                    z = true;
                }
            }
        } while (z);
    }

    @Override // defpackage.l70
    public final void L(j70 j70Var, Runnable runnable) {
        synchronized (this.f) {
            this.i.addLast(runnable);
            if (!this.n) {
                this.n = true;
                this.e.post(this.t);
                if (!this.s) {
                    this.s = true;
                    this.c.postFrameCallback(this.t);
                }
            }
        }
    }
}
