package defpackage;

import android.hardware.camera2.CameraCaptureSession;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class zu2 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ bv2 b;

    public /* synthetic */ zu2(bv2 bv2Var, int i) {
        this.a = i;
        this.b = bv2Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i = this.a;
        bv2 bv2Var = this.b;
        switch (i) {
            case 0:
                bv2Var.g(bv2Var);
                return;
            default:
                bv2.l();
                hh1.d(bv2Var.g, "Need to call openCaptureSession before using this API.");
                lj1 lj1Var = bv2Var.b;
                synchronized (lj1Var.c) {
                    ((LinkedHashSet) lj1Var.e).add(bv2Var);
                    break;
                }
                ((CameraCaptureSession) ((l11) bv2Var.g.a).b).close();
                bv2Var.d.execute(new zu2(bv2Var, 0));
                return;
        }
    }
}
