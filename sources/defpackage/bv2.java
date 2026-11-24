package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import android.os.Handler;
import android.view.Surface;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionOnClosedNotCalledQuirk;
import androidx.camera.camera2.internal.compat.quirk.CaptureSessionStuckQuirk;
import androidx.camera.camera2.internal.compat.quirk.IncorrectCaptureStateQuirk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bv2 extends xu2 {
    public final lj1 b;
    public final Handler c;
    public final ch2 d;
    public final xv0 e;
    public sw f;
    public q82 g;
    public wp h;
    public tp i;
    public jr0 j;
    public final xv0 o;
    public ArrayList q;
    public uc1 r;
    public final sp0 s;
    public final q82 t;
    public final jb u;
    public final rh2 v;
    public final Object a = new Object();
    public List k = null;
    public boolean l = false;
    public boolean m = false;
    public boolean n = false;
    public final Object p = new Object();
    public final AtomicBoolean w = new AtomicBoolean(false);

    public bv2(cq0 cq0Var, cq0 cq0Var2, xv0 xv0Var, lj1 lj1Var, ch2 ch2Var, Handler handler) {
        this.b = lj1Var;
        this.c = handler;
        this.d = ch2Var;
        this.e = xv0Var;
        this.s = new sp0(cq0Var, cq0Var2);
        this.u = new jb(cq0Var.c(CaptureSessionStuckQuirk.class) || cq0Var.c(IncorrectCaptureStateQuirk.class));
        q82 q82Var = new q82();
        q82Var.a = (CaptureSessionOnClosedNotCalledQuirk) cq0Var2.d(CaptureSessionOnClosedNotCalledQuirk.class);
        this.t = q82Var;
        this.v = new rh2(cq0Var2, 0);
        this.o = xv0Var;
    }

    public static void l() {
        xq4.c(3, "SyncCaptureSessionImpl");
    }

    @Override // defpackage.xu2
    public final void a(bv2 bv2Var) {
        Objects.requireNonNull(this.f);
        this.f.a(bv2Var);
    }

    @Override // defpackage.xu2
    public final void b(bv2 bv2Var) {
        Objects.requireNonNull(this.f);
        this.f.b(bv2Var);
    }

    @Override // defpackage.xu2
    public final void c(bv2 bv2Var) {
        int i;
        wp wpVar;
        synchronized (this.p) {
            this.s.a(this.q);
        }
        l();
        synchronized (this.a) {
            try {
                i = 1;
                if (this.l) {
                    wpVar = null;
                } else {
                    this.l = true;
                    hh1.d(this.h, "Need to call openCaptureSession before using this API.");
                    wpVar = this.h;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.a) {
            try {
                List list = this.k;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((ob0) it.next()).b();
                    }
                    this.k = null;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.u.i();
        if (wpVar != null) {
            wpVar.b.a(new yu2(this, bv2Var, i), xg4.a());
        }
    }

    @Override // defpackage.xu2
    public final void d(bv2 bv2Var) {
        Objects.requireNonNull(this.f);
        synchronized (this.a) {
            try {
                List list = this.k;
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        ((ob0) it.next()).b();
                    }
                    this.k = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.u.i();
        lj1 lj1Var = this.b;
        lj1Var.f(this);
        synchronized (lj1Var.c) {
            ((LinkedHashSet) lj1Var.f).remove(this);
        }
        this.f.d(bv2Var);
    }

    @Override // defpackage.xu2
    public final void e(bv2 bv2Var) {
        ArrayList arrayList;
        l();
        q82 q82Var = this.t;
        lj1 lj1Var = this.b;
        synchronized (lj1Var.c) {
            arrayList = new ArrayList((LinkedHashSet) lj1Var.f);
        }
        ArrayList arrayListG = this.b.g();
        int i = 0;
        if (((CaptureSessionOnClosedNotCalledQuirk) q82Var.a) != null) {
            LinkedHashSet<bv2> linkedHashSet = new LinkedHashSet();
            int size = arrayList.size();
            int i2 = 0;
            while (i2 < size) {
                Object obj = arrayList.get(i2);
                i2++;
                bv2 bv2Var2 = (bv2) obj;
                if (bv2Var2 == bv2Var) {
                    break;
                } else {
                    linkedHashSet.add(bv2Var2);
                }
            }
            for (bv2 bv2Var3 : linkedHashSet) {
                bv2Var3.getClass();
                bv2Var3.d(bv2Var3);
            }
        }
        Objects.requireNonNull(this.f);
        lj1 lj1Var2 = this.b;
        synchronized (lj1Var2.c) {
            ((LinkedHashSet) lj1Var2.d).add(this);
            ((LinkedHashSet) lj1Var2.f).remove(this);
        }
        lj1Var2.f(this);
        this.f.e(bv2Var);
        if (((CaptureSessionOnClosedNotCalledQuirk) q82Var.a) != null) {
            LinkedHashSet<bv2> linkedHashSet2 = new LinkedHashSet();
            int size2 = arrayListG.size();
            while (i < size2) {
                Object obj2 = arrayListG.get(i);
                i++;
                bv2 bv2Var4 = (bv2) obj2;
                if (bv2Var4 == bv2Var) {
                    break;
                } else {
                    linkedHashSet2.add(bv2Var4);
                }
            }
            for (bv2 bv2Var5 : linkedHashSet2) {
                bv2Var5.getClass();
                bv2Var5.c(bv2Var5);
            }
        }
    }

    @Override // defpackage.xu2
    public final void f(bv2 bv2Var) {
        Objects.requireNonNull(this.f);
        this.f.f(bv2Var);
    }

    @Override // defpackage.xu2
    public final void g(bv2 bv2Var) {
        wp wpVar;
        synchronized (this.a) {
            try {
                if (this.n) {
                    wpVar = null;
                } else {
                    this.n = true;
                    hh1.d(this.h, "Need to call openCaptureSession before using this API.");
                    wpVar = this.h;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (wpVar != null) {
            wpVar.b.a(new yu2(this, bv2Var, 0), xg4.a());
        }
    }

    @Override // defpackage.xu2
    public final void h(bv2 bv2Var, Surface surface) {
        Objects.requireNonNull(this.f);
        this.f.h(bv2Var, surface);
    }

    public final int i(ArrayList arrayList, iq iqVar) {
        CameraCaptureSession.CaptureCallback captureCallbackC = this.u.c(iqVar);
        hh1.d(this.g, "Need to call openCaptureSession before using this API.");
        return ((l11) this.g.a).r(arrayList, this.d, captureCallbackC);
    }

    public final void j() {
        int i = 1;
        if (!this.w.compareAndSet(false, true)) {
            l();
            return;
        }
        if (this.v.a) {
            try {
                l();
                hh1.d(this.g, "Need to call openCaptureSession before using this API.");
                ((CameraCaptureSession) ((l11) this.g.a).b).abortCaptures();
            } catch (Exception e) {
                e.toString();
                l();
            }
        }
        l();
        this.u.d().a(new zu2(this, i), this.d);
    }

    public final void k(CameraCaptureSession cameraCaptureSession) {
        if (this.g == null) {
            q82 q82Var = new q82();
            if (Build.VERSION.SDK_INT >= 28) {
                q82Var.a = new ts(cameraCaptureSession, null);
            } else {
                q82Var.a = new l11(cameraCaptureSession, new us(this.c));
            }
            this.g = q82Var;
        }
    }

    public final boolean m() {
        boolean z;
        synchronized (this.a) {
            z = this.h != null;
        }
        return z;
    }

    public final wc1 n(CameraDevice cameraDevice, oh2 oh2Var, List list) {
        wc1 wc1VarE;
        synchronized (this.p) {
            try {
                ArrayList arrayListG = this.b.g();
                ArrayList arrayList = new ArrayList();
                int size = arrayListG.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayListG.get(i);
                    i++;
                    bv2 bv2Var = (bv2) obj;
                    arrayList.add(hg4.a(new kr0(bv2Var.u.d(), bv2Var.o, 1500L, 0)));
                }
                uc1 uc1Var = new uc1(new ArrayList(arrayList), false, xg4.a());
                this.r = uc1Var;
                wc1VarE = oz3.e(oz3.g(jr0.b(uc1Var), new av2(this, cameraDevice, oh2Var, list), this.d));
            } catch (Throwable th) {
                throw th;
            }
        }
        return wc1VarE;
    }

    public final int o(CaptureRequest captureRequest, CameraCaptureSession.CaptureCallback captureCallback) {
        CameraCaptureSession.CaptureCallback captureCallbackC = this.u.c(captureCallback);
        hh1.d(this.g, "Need to call openCaptureSession before using this API.");
        return ((l11) this.g.a).G(captureRequest, this.d, captureCallbackC);
    }

    public final wc1 p(ArrayList arrayList) {
        synchronized (this.a) {
            try {
                if (this.m) {
                    return new mz0(1, new CancellationException("Opener is disabled"));
                }
                xw xwVarG = oz3.g(jr0.b(am4.a(arrayList, this.d, this.e)), new zq(this, arrayList), this.d);
                this.j = xwVarG;
                return oz3.e(xwVarG);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean q() {
        boolean z;
        synchronized (this.p) {
            try {
                if (m()) {
                    this.s.a(this.q);
                } else {
                    uc1 uc1Var = this.r;
                    if (uc1Var != null) {
                        uc1Var.cancel(true);
                    }
                }
                jr0 jr0Var = null;
                try {
                    synchronized (this.a) {
                        try {
                            if (!this.m) {
                                jr0 jr0Var2 = this.j;
                                jr0Var = jr0Var2 != null ? jr0Var2 : null;
                                this.m = true;
                            }
                            z = !m();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    if (jr0Var != null) {
                        jr0Var.cancel(true);
                    }
                } catch (Throwable th2) {
                    if (jr0Var != null) {
                        jr0Var.cancel(true);
                    }
                    throw th2;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
        return z;
    }

    public final q82 r() {
        this.g.getClass();
        return this.g;
    }
}
