package defpackage;

import android.hardware.camera2.TotalCaptureResult;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class or implements jq {
    public final tp a;
    public final wp b;
    public final og c;

    public or(og ogVar) {
        tp tpVar = new tp();
        tpVar.c = new o62();
        wp wpVar = new wp(tpVar);
        tpVar.b = wpVar;
        try {
            this.a = tpVar;
            tpVar.a = "waitFor3AResult";
        } catch (Exception e) {
            wpVar.b(e);
        }
        this.b = wpVar;
        this.c = ogVar;
    }

    @Override // defpackage.jq
    public final boolean a(TotalCaptureResult totalCaptureResult) {
        boolean zF;
        og ogVar = this.c;
        if (ogVar != null) {
            switch (ogVar.a) {
                case 11:
                    zF = ur.f(totalCaptureResult, false);
                    break;
                case 14:
                    zF = ur.f(totalCaptureResult, false);
                    break;
                default:
                    zF = ur.f(totalCaptureResult, true);
                    break;
            }
            if (!zF) {
                return false;
            }
        }
        this.a.a(totalCaptureResult);
        return true;
    }
}
