package defpackage;

import android.hardware.camera2.CaptureRequest;
import androidx.camera.camera2.internal.compat.quirk.ImageCapturePixelHDRPlusQuirk;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uy0 extends er {
    public static final uy0 b;

    static {
        new xy(14);
        b = new uy0();
    }

    @Override // defpackage.er
    public final void a(r53 r53Var, ur urVar) {
        super.a(r53Var, urVar);
        if (!(r53Var instanceof sy0)) {
            og.i("config is not ImageCaptureConfig");
            return;
        }
        sy0 sy0Var = (sy0) r53Var;
        zl1 zl1VarM = zl1.m();
        bi biVar = sy0.b;
        if (sy0Var.a(biVar)) {
            int iIntValue = ((Integer) sy0Var.f(biVar)).intValue();
            if (((ImageCapturePixelHDRPlusQuirk) wc0.a.d(ImageCapturePixelHDRPlusQuirk.class)) != null) {
                if (iIntValue == 0) {
                    CaptureRequest.Key key = CaptureRequest.CONTROL_ENABLE_ZSL;
                    zl1VarM.v(zr.M(key), Boolean.TRUE);
                } else if (iIntValue == 1) {
                    CaptureRequest.Key key2 = CaptureRequest.CONTROL_ENABLE_ZSL;
                    zl1VarM.v(zr.M(key2), Boolean.FALSE);
                }
            }
        }
        urVar.c(new zr(gs1.l(zl1VarM)));
    }
}
