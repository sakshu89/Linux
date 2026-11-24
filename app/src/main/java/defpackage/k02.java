package defpackage;

import android.hardware.camera2.CameraCharacteristics;
import android.os.Build;
import android.util.Range;
import java.util.ArrayList;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class k02 implements bp1, qk {
    public final Object a;
    public boolean b;
    public final Object c;
    public Object e;
    public Object f;
    public Object i;

    /* JADX WARN: Code duplicated, block: B:20:0x0067  */
    public k02(kq kqVar, ys ysVar) {
        Range range;
        md3 uf1Var;
        boolean z = false;
        this.b = false;
        this.i = new ld3(this);
        this.c = kqVar;
        if (Build.VERSION.SDK_INT >= 30) {
            try {
                range = (Range) ysVar.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
            } catch (AssertionError e) {
                xq4.e("ZoomControl", "AssertionError, fail to get camera characteristic.", e);
                range = null;
            }
            if (range != null) {
                jb jbVar = new jb();
                jbVar.a = false;
                jbVar.b = (Range) ysVar.a(CameraCharacteristics.CONTROL_ZOOM_RATIO_RANGE);
                if (Build.VERSION.SDK_INT >= 34) {
                    int[] iArr = (int[]) ((CameraCharacteristics) ysVar.b.b).get(CameraCharacteristics.CONTROL_AVAILABLE_SETTINGS_OVERRIDES);
                    if (iArr != null) {
                        for (int i : iArr) {
                            if (i == 1) {
                                z = true;
                                break;
                            }
                        }
                    }
                }
                jbVar.a = z;
                uf1Var = jbVar;
            } else {
                uf1Var = new uf1(14, ysVar);
            }
        } else {
            uf1Var = new uf1(14, ysVar);
        }
        this.f = uf1Var;
        fm1 fm1Var = new fm1(uf1Var.b(), uf1Var.f());
        this.e = fm1Var;
        fm1Var.g();
        this.a = new pl1(new ni(fm1Var.d(), fm1Var.b(), fm1Var.c(), fm1Var.a()));
        kqVar.j((ld3) this.i);
    }

    public void a(q02 q02Var) {
        synchronized (this) {
            try {
                if (((q02) this.e).equals(q02Var)) {
                    return;
                }
                this.e = q02Var;
                Objects.toString(q02Var);
                xq4.c(3, "StreamStateObserver");
                ((pl1) this.a).i(q02Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void b(x30 x30Var) {
        wd3 wd3Var = (wd3) ((qu0) this.i).j.get((se) this.a);
        if (wd3Var != null) {
            wd3Var.p(x30Var);
        }
    }

    @Override // defpackage.bp1
    public void m(Object obj) {
        vt vtVar = (vt) obj;
        vt vtVar2 = vt.CLOSING;
        int i = 0;
        q02 q02Var = q02.a;
        if (vtVar == vtVar2 || vtVar == vt.CLOSED || vtVar == vt.RELEASING || vtVar == vt.RELEASED) {
            a(q02Var);
            if (this.b) {
                this.b = false;
                jr0 jr0Var = (jr0) this.i;
                if (jr0Var != null) {
                    jr0Var.cancel(false);
                    this.i = null;
                    return;
                }
                return;
            }
            return;
        }
        if ((vtVar == vt.OPENING || vtVar == vt.OPEN || vtVar == vt.PENDING_OPEN) && !this.b) {
            ut utVar = (ut) this.c;
            a(q02Var);
            ArrayList arrayList = new ArrayList();
            tp tpVar = new tp();
            tpVar.c = new o62();
            wp wpVar = new wp(tpVar);
            tpVar.b = wpVar;
            tpVar.a = cq.class;
            try {
                hq hqVar = new hq(tpVar, utVar);
                arrayList.add(hqVar);
                utVar.g(xg4.a(), hqVar);
                tpVar.a = "waitForCaptureResult";
            } catch (Exception e) {
                wpVar.b(e);
            }
            xw xwVarG = oz3.g(jr0.b(wpVar), new j02(this), xg4.a());
            j02 j02Var = new j02(this);
            xw xwVarG2 = oz3.g(xwVarG, new q82(j02Var), xg4.a());
            this.i = xwVarG2;
            kf kfVar = new kf(this, arrayList, utVar, 22, false);
            xwVarG2.a(new or0(i, xwVarG2, kfVar), xg4.a());
            this.b = true;
        }
    }

    @Override // defpackage.qk
    public void o(x30 x30Var) {
        ((qu0) this.i).m.post(new or0(9, this, x30Var, false));
    }

    @Override // defpackage.bp1
    public void onError(Throwable th) {
        jr0 jr0Var = (jr0) this.i;
        if (jr0Var != null) {
            jr0Var.cancel(false);
            this.i = null;
        }
        a(q02.a);
    }

    public k02(ut utVar, pl1 pl1Var, s02 s02Var) {
        this.b = false;
        this.c = utVar;
        this.a = pl1Var;
        this.f = s02Var;
        synchronized (this) {
            this.e = (q02) pl1Var.c();
        }
    }

    public k02(qu0 qu0Var, je jeVar, se seVar) {
        this.i = qu0Var;
        this.e = null;
        this.f = null;
        this.b = false;
        this.c = jeVar;
        this.a = seVar;
    }
}
