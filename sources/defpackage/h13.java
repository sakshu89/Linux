package defpackage;

import android.hardware.camera2.CameraManager;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class h13 extends CameraManager.TorchCallback {
    public final /* synthetic */ j13 a;

    public h13(j13 j13Var) {
        this.a = j13Var;
    }

    @Override // android.hardware.camera2.CameraManager.TorchCallback
    public final void onTorchModeChanged(String str, boolean z) {
        str.getClass();
        if (str.equals((String) this.a.g.getValue())) {
            this.a.f = true;
            jr2 jr2Var = this.a.c;
            Boolean boolValueOf = Boolean.valueOf(z);
            jr2Var.getClass();
            jr2Var.j(null, boolValueOf);
            jr2 jr2Var2 = this.a.d;
            Boolean boolValueOf2 = Boolean.valueOf(z);
            jr2Var2.getClass();
            jr2Var2.j(null, boolValueOf2);
        }
    }

    @Override // android.hardware.camera2.CameraManager.TorchCallback
    public final void onTorchModeUnavailable(String str) {
        str.getClass();
        if (str.equals((String) this.a.g.getValue())) {
            this.a.f = false;
            this.a.d.i(null);
        }
    }
}
