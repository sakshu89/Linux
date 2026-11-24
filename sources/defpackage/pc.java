package defpackage;

import android.view.Choreographer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class pc implements Choreographer.FrameCallback, Runnable {
    public final /* synthetic */ qc a;

    public pc(qc qcVar) {
        this.a = qcVar;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.a.e.removeCallbacks(this);
        qc.P(this.a);
        qc qcVar = this.a;
        synchronized (qcVar.f) {
            if (qcVar.s) {
                qcVar.s = false;
                ArrayList arrayList = qcVar.j;
                qcVar.j = qcVar.k;
                qcVar.k = arrayList;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((Choreographer.FrameCallback) arrayList.get(i)).doFrame(j);
                }
                arrayList.clear();
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        qc.P(this.a);
        qc qcVar = this.a;
        synchronized (qcVar.f) {
            if (qcVar.j.isEmpty()) {
                qcVar.c.removeFrameCallback(this);
                qcVar.s = false;
            }
        }
    }
}
