package defpackage;

import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class gr implements nr {
    public final kq a;
    public boolean b = false;

    public gr(kq kqVar) {
        this.a = kqVar;
    }

    @Override // defpackage.nr
    public final boolean a() {
        return true;
    }

    @Override // defpackage.nr
    public final wc1 b(TotalCaptureResult totalCaptureResult) {
        Integer num;
        int iIntValue;
        mz0 mz0VarD = oz3.d(Boolean.TRUE);
        if (totalCaptureResult != null && (num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE)) != null && ((iIntValue = num.intValue()) == 1 || iIntValue == 2)) {
            xq4.c(3, "Camera2CapturePipeline");
            Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
            if (num2 != null && num2.intValue() == 0) {
                xq4.c(3, "Camera2CapturePipeline");
                this.b = true;
                zn0 zn0Var = this.a.h;
                if (zn0Var.c) {
                    ur urVar = new ur();
                    urVar.a = zn0Var.d;
                    urVar.c = true;
                    zl1 zl1VarM = zl1.m();
                    zl1VarM.v(zr.M(CaptureRequest.CONTROL_AF_TRIGGER), 1);
                    urVar.c(new zr(gs1.l(zl1VarM)));
                    urVar.b(new pw(1));
                    zn0Var.a.s(Collections.singletonList(urVar.d()));
                }
            }
        }
        return mz0VarD;
    }

    @Override // defpackage.nr
    public final void c() {
        if (this.b) {
            xq4.c(3, "Camera2CapturePipeline");
            this.a.h.a(true, false);
        }
    }
}
