package defpackage;

import com.project.sonic.MainActivity;
import com.project.sonic.ui.camera.CaptureActivity;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class kw0 implements dq1 {
    public final /* synthetic */ int a;
    public final /* synthetic */ n10 b;

    public /* synthetic */ kw0(n10 n10Var, int i) {
        this.a = i;
        this.b = n10Var;
    }

    @Override // defpackage.dq1
    public final void a(n10 n10Var) {
        int i = this.a;
        n10 n10Var2 = this.b;
        switch (i) {
            case 0:
                CaptureActivity captureActivity = (CaptureActivity) n10Var2;
                if (!captureActivity.e0) {
                    captureActivity.e0 = true;
                    iw iwVar = (iw) captureActivity.generatedComponent();
                    CaptureActivity captureActivity2 = (CaptureActivity) UnsafeCasts.unsafeCast(captureActivity);
                    v80 v80Var = ((q80) iwVar).a;
                    captureActivity2.f0 = (tt) v80Var.d.get();
                }
                break;
            default:
                MainActivity mainActivity = (MainActivity) n10Var2;
                if (!mainActivity.e0) {
                    mainActivity.e0 = true;
                    hg1 hg1Var = (hg1) mainActivity.generatedComponent();
                    ((MainActivity) UnsafeCasts.unsafeCast(mainActivity)).f0 = (zv1) ((q80) hg1Var).a.c.get();
                }
                break;
        }
    }
}
