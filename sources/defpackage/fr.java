package defpackage;

import android.hardware.camera2.TotalCaptureResult;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class fr implements nr {
    public final kq a;
    public final ph b;
    public final int c;
    public boolean d = false;

    public fr(kq kqVar, int i, ph phVar) {
        this.a = kqVar;
        this.c = i;
        this.b = phVar;
    }

    @Override // defpackage.nr
    public final boolean a() {
        return this.c == 0;
    }

    @Override // defpackage.nr
    public final wc1 b(TotalCaptureResult totalCaptureResult) {
        if (!ur.g(this.c, totalCaptureResult)) {
            return oz3.d(Boolean.FALSE);
        }
        xq4.c(3, "Camera2CapturePipeline");
        this.d = true;
        tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        tpVar.a = cq.class;
        try {
            this.a.h.d(tpVar);
            this.b.b = true;
            tpVar.a = "AePreCapture";
        } catch (Exception e) {
            wpVar.b(e);
        }
        jr0 jr0VarB = jr0.b(wpVar);
        og ogVar = new og(9);
        return oz3.g(jr0VarB, new q82(ogVar), xg4.a());
    }

    @Override // defpackage.nr
    public final void c() {
        if (this.d) {
            xq4.c(3, "Camera2CapturePipeline");
            this.a.h.a(false, true);
            this.b.b = false;
        }
    }
}
