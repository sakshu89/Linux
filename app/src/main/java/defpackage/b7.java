package defpackage;

import android.os.Trace;
import android.view.MotionEvent;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b7 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ r7 b;

    public /* synthetic */ b7(r7 r7Var, int i) {
        this.a = i;
        this.b = r7Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        r7 r7Var = this.b;
        switch (i) {
            case 0:
                hg hgVar = r7Var.k;
                Trace.beginSection("AndroidOwner:outOfFrameExecutor");
                while (!hgVar.isEmpty()) {
                    try {
                        ((fq0) hgVar.removeLast()).a();
                    } catch (Throwable th) {
                        Trace.endSection();
                        throw th;
                    }
                }
                Trace.endSection();
                return;
            default:
                r7Var.k1 = false;
                MotionEvent motionEvent = r7Var.c1;
                motionEvent.getClass();
                if (motionEvent.getActionMasked() == 10) {
                    r7Var.C(motionEvent);
                    return;
                } else {
                    og.n("The ACTION_HOVER_EXIT event was not cleared.");
                    return;
                }
        }
    }
}
