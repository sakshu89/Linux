package defpackage;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class a22 {
    public final boolean a;
    public boolean b;
    public boolean c;
    public final Object d;
    public final Object e;
    public Object f;

    public a22(kq kqVar, ys ysVar) {
        this.d = kqVar;
        this.a = ln4.a(new zq(1, ysVar));
        this.e = new pl1(0);
        kqVar.j(new jq() { // from class: g13
            @Override // defpackage.jq
            public final boolean a(TotalCaptureResult totalCaptureResult) {
                a22 a22Var = this.a;
                if (((tp) a22Var.f) != null) {
                    Integer num = (Integer) totalCaptureResult.getRequest().get(CaptureRequest.FLASH_MODE);
                    if ((num != null && num.intValue() == 2) == a22Var.c) {
                        ((tp) a22Var.f).a(null);
                        a22Var.f = null;
                    }
                }
                return false;
            }
        });
    }

    public void a(tp tpVar, boolean z) {
        pl1 pl1Var = (pl1) this.e;
        if (!this.a) {
            if (tpVar != null) {
                tpVar.b(new IllegalStateException("No flash unit"));
                return;
            }
            return;
        }
        if (!this.b) {
            if (vc4.c()) {
                pl1Var.h(0);
            } else {
                pl1Var.i(0);
            }
            if (tpVar != null) {
                tpVar.b(new dt("Camera is not active."));
                return;
            }
            return;
        }
        this.c = z;
        ((kq) this.d).l(z);
        Integer numValueOf = Integer.valueOf(z ? 1 : 0);
        if (vc4.c()) {
            pl1Var.h(numValueOf);
        } else {
            pl1Var.i(numValueOf);
        }
        tp tpVar2 = (tp) this.f;
        if (tpVar2 != null) {
            tpVar2.b(new dt("There is a new enableTorch being set"));
        }
        this.f = tpVar;
    }

    public Object b() {
        if (this.a) {
            return null;
        }
        Object obj = this.f;
        if (obj != null) {
            return obj;
        }
        y20.b("Unexpected form of a provided value");
        og.k();
        return null;
    }

    public a22(z12 z12Var, Object obj, boolean z, om2 om2Var, boolean z2) {
        this.d = z12Var;
        this.a = z;
        this.e = om2Var;
        this.b = z2;
        this.f = obj;
        this.c = true;
    }
}
