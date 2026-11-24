package defpackage;

import java.util.LinkedHashSet;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class yu2 implements Runnable {
    public final /* synthetic */ int a;
    public final /* synthetic */ bv2 b;
    public final /* synthetic */ bv2 c;

    public /* synthetic */ yu2(bv2 bv2Var, bv2 bv2Var2, int i) {
        this.a = i;
        this.b = bv2Var;
        this.c = bv2Var2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.a) {
            case 0:
                bv2 bv2Var = this.b;
                bv2 bv2Var2 = this.c;
                Objects.requireNonNull(bv2Var.f);
                bv2Var.f.g(bv2Var2);
                return;
            default:
                bv2 bv2Var3 = this.b;
                bv2 bv2Var4 = this.c;
                lj1 lj1Var = bv2Var3.b;
                synchronized (lj1Var.c) {
                    ((LinkedHashSet) lj1Var.d).remove(bv2Var3);
                    ((LinkedHashSet) lj1Var.e).remove(bv2Var3);
                    break;
                }
                bv2Var3.g(bv2Var4);
                if (bv2Var3.g != null) {
                    Objects.requireNonNull(bv2Var3.f);
                    bv2Var3.f.c(bv2Var4);
                    return;
                } else {
                    xq4.d("SyncCaptureSessionBase", "[" + bv2Var3 + "] Cannot call onClosed() when the CameraCaptureSession is not correctly configured.");
                    return;
                }
        }
    }
}
