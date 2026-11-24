package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.speech.SpeechRecognizer;
import android.util.ArrayMap;
import android.util.Size;
import android.view.ActionMode;
import android.view.Surface;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class dc implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;
    public final /* synthetic */ Object e;

    public /* synthetic */ dc(fb0 fb0Var, ig0 ig0Var, tp tpVar) {
        this.a = 4;
        Map map = Collections.EMPTY_MAP;
        this.b = fb0Var;
        this.c = ig0Var;
        this.e = tpVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                fc fcVar = (fc) this.b;
                bc bcVar = (bc) this.c;
                cc ccVar = (cc) this.e;
                ActionMode actionModeStartActionMode = fcVar.a.startActionMode(new lm0(bcVar), 1);
                g31.a(fcVar.h, actionModeStartActionMode);
                if (actionModeStartActionMode == null) {
                    ccVar.close();
                    return;
                }
                return;
            case 1:
                kq kqVar = (kq) this.b;
                Executor executor = (Executor) this.c;
                es esVar = (es) this.e;
                hq hqVar = kqVar.z;
                ((HashSet) hqVar.b).add(esVar);
                ((ArrayMap) hqVar.c).put(esVar, executor);
                return;
            case 2:
                rr rrVar = (rr) this.b;
                AtomicReference atomicReference = (AtomicReference) this.c;
                tp tpVar = (tp) this.e;
                xq4.c(3, "Camera2CapturePipeline");
                rrVar.d.a(System.currentTimeMillis() + 3000, (pr) atomicReference.get());
                tpVar.a(null);
                return;
            case 3:
                ss ssVar = (ss) this.b;
                ssVar.a.onSurfacePrepared((CameraCaptureSession) this.c, (Surface) this.e);
                return;
            case 4:
                fb0 fb0Var = (fb0) this.b;
                ig0 ig0Var = (ig0) this.c;
                Map map = Collections.EMPTY_MAP;
                tp tpVar2 = (tp) this.e;
                try {
                    fb0Var.a.m(ig0Var);
                    tpVar2.a(null);
                    return;
                } catch (RuntimeException e) {
                    tpVar2.b(e);
                    return;
                }
            case 5:
                fb0 fb0Var2 = (fb0) this.b;
                Runnable runnable = (Runnable) this.c;
                Runnable runnable2 = (Runnable) this.e;
                if (fb0Var2.j) {
                    runnable.run();
                    return;
                } else {
                    runnable2.run();
                    return;
                }
            case 6:
                cg0 cg0Var = (cg0) this.b;
                ig0 ig0Var2 = (ig0) this.c;
                Map map2 = Collections.EMPTY_MAP;
                tp tpVar3 = (tp) this.e;
                try {
                    cg0Var.a.m(ig0Var2);
                    tpVar3.a(null);
                    return;
                } catch (RuntimeException e2) {
                    tpVar3.b(e2);
                    return;
                }
            case 7:
                cg0 cg0Var2 = (cg0) this.b;
                Runnable runnable3 = (Runnable) this.c;
                Runnable runnable4 = (Runnable) this.e;
                if (cg0Var2.f) {
                    runnable3.run();
                    return;
                } else {
                    runnable4.run();
                    return;
                }
            case 8:
                wf wfVar = (wf) this.b;
                cn4 cn4Var = (cn4) this.c;
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) this.e;
                try {
                    ap0 ap0VarA = yl4.a(wfVar.a);
                    if (ap0VarA == null) {
                        throw new RuntimeException("EmojiCompat font provider not available on this device.");
                    }
                    zo0 zo0Var = (zo0) ap0VarA.a;
                    synchronized (zo0Var.d) {
                        zo0Var.f = threadPoolExecutor;
                        break;
                    }
                    ap0VarA.a.a(new qh0(cn4Var, threadPoolExecutor));
                    return;
                } catch (Throwable th) {
                    cn4Var.a(th);
                    threadPoolExecutor.shutdown();
                    return;
                }
            case 9:
                q91 q91Var = (q91) this.b;
                kd1 kd1Var = (kd1) this.c;
                kd1 kd1Var2 = (kd1) this.e;
                pl1 pl1Var = (pl1) q91Var.b;
                if (kd1Var != null) {
                    pl1Var.g(kd1Var);
                }
                pl1Var.d(kd1Var2);
                return;
            case 10:
                jb jbVar = (jb) this.b;
                iq iqVar = (iq) this.c;
                wc1 wc1Var = (wc1) this.e;
                Objects.toString(iqVar);
                ((List) jbVar.b).remove(wc1Var);
                return;
            case 11:
                t42 t42Var = (t42) this.b;
                AtomicBoolean atomicBoolean = (AtomicBoolean) this.c;
                pn2 pn2Var = (pn2) this.e;
                SpeechRecognizer speechRecognizer = (SpeechRecognizer) t42Var.a;
                if (speechRecognizer == null) {
                    return;
                }
                if (atomicBoolean.compareAndSet(false, true)) {
                    try {
                        speechRecognizer.setRecognitionListener(null);
                        speechRecognizer.cancel();
                        speechRecognizer.destroy();
                        break;
                    } catch (Throwable unused) {
                    }
                }
                if (pn2Var.c == speechRecognizer) {
                    pn2Var.c = null;
                    pn2Var.d = null;
                    return;
                }
                return;
            case 12:
                ((kf) this.b).g((st2) this.c, (Map.Entry) this.e);
                return;
            default:
                iu2 iu2Var = (iu2) this.b;
                fu2 fu2Var = (fu2) this.c;
                rw rwVar = (rw) this.e;
                hu2 hu2Var = iu2Var.f;
                fu2 fu2Var2 = hu2Var.b;
                if (fu2Var2 != null) {
                    Objects.toString(fu2Var2);
                    xq4.c(3, "SurfaceViewImpl");
                    hu2Var.b.c();
                }
                if (hu2Var.g) {
                    hu2Var.g = false;
                    fu2Var.c();
                    fu2Var.i.a(null);
                    return;
                }
                hu2Var.b = fu2Var;
                hu2Var.d = rwVar;
                Size size = fu2Var.b;
                hu2Var.a = size;
                hu2Var.f = false;
                if (hu2Var.a()) {
                    return;
                }
                xq4.c(3, "SurfaceViewImpl");
                hu2Var.h.e.getHolder().setFixedSize(size.getWidth(), size.getHeight());
                return;
        }
    }

    public /* synthetic */ dc(cg0 cg0Var, ig0 ig0Var, tp tpVar) {
        this.a = 6;
        Map map = Collections.EMPTY_MAP;
        this.b = cg0Var;
        this.c = ig0Var;
        this.e = tpVar;
    }

    public /* synthetic */ dc(t42 t42Var, AtomicBoolean atomicBoolean, j12 j12Var, pn2 pn2Var) {
        this.a = 11;
        this.b = t42Var;
        this.c = atomicBoolean;
        this.e = pn2Var;
    }

    public /* synthetic */ dc(Object obj, Object obj2, Object obj3, int i) {
        this.a = i;
        this.b = obj;
        this.c = obj2;
        this.e = obj3;
    }
}
